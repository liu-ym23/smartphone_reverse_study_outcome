package com.android.server.pm;

import android.content.pm.UserPackage;
import android.metrics.LogMaker;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.FgThread;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ShortcutUser {
    private static final String ATTR_KNOWN_LOCALES = "locales";
    private static final String ATTR_LAST_APP_SCAN_OS_FINGERPRINT = "last-app-scan-fp";
    private static final String ATTR_LAST_APP_SCAN_TIME = "last-app-scan-time2";
    private static final String ATTR_RESTORE_SOURCE_FINGERPRINT = "restore-from-fp";
    private static final String ATTR_VALUE = "value";
    static final String DIRECTORY_LAUNCHERS = "launchers";
    static final String DIRECTORY_PACKAGES = "packages";
    private static final String KEY_LAUNCHERS = "launchers";
    private static final String KEY_PACKAGES = "packages";
    private static final String KEY_USER_ID = "userId";
    private static final String TAG = "ShortcutService";
    private static final String TAG_LAUNCHER = "launcher";
    static final String TAG_ROOT = "user";
    private String mCachedLauncher;
    final Executor mExecutor;
    private String mKnownLocales;
    private String mLastAppScanOsFingerprint;
    private long mLastAppScanTime;
    private final ArrayMap<UserPackage, ShortcutLauncher> mLaunchers;
    private final Object mLock;
    private final ArrayMap<String, ShortcutPackage> mPackages;
    private String mRestoreFromOsFingerprint;
    final ShortcutService mService;
    private final int mUserId;

    /* JADX INFO: renamed from: $r8$lambda$BeZCg8-9BP9faEuabdbH0SUoZS0, reason: not valid java name */
    public static /* synthetic */ void m6952$r8$lambda$BeZCg89BP9faEuabdbH0SUoZS0(ShortcutService r0, ShortcutUser r1, boolean r2, File r3) {
        lambda$loadFromXml$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$CaE5-WgWd3bzZNCC7o4uRMfowXc, reason: not valid java name */
    public static /* synthetic */ void m6953$r8$lambda$CaE5WgWd3bzZNCC7o4uRMfowXc(ShortcutUser r0, int r1, boolean r2, File r3) {
        lambda$loadFromXml$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$In82QhJ-Sku78LsVH3sI9Fds4BA, reason: not valid java name */
    public static /* synthetic */ void m6954$r8$lambda$In82QhJSku78LsVH3sI9Fds4BA(ShortcutPackage r0) {
        lambda$detectLocaleChange$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$QKKXDMz85BlzW8iTAFI9amZMsII(ShortcutUser r0, ShortcutService r1, int[] r2, ShortcutLauncher r3) {
        r0.lambda$mergeRestoredFile$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qr5HXjYL-1-vCbYqw4iRvkQ2IS0, reason: not valid java name */
    public static /* synthetic */ void m6955$r8$lambda$Qr5HXjYL1vCbYqw4iRvkQ2IS0(ShortcutPackageItem r0) {
        lambda$attemptToRestoreIfNeededAndSave$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$gV8N2KBvwqRgSMKulu2hQRJz6gE(int r0, String r1, Consumer r2, ShortcutPackageItem r3) {
        lambda$forPackageItem$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$t-JJrfUbh2aFSA6DQfImfJD2u9s, reason: not valid java name */
    public static /* synthetic */ void m6956$r8$lambda$tJJrfUbh2aFSA6DQfImfJD2u9s(ShortcutUser r0, ShortcutService r1, int[] r2, int[] r3, ShortcutPackage r4) {
        r0.lambda$mergeRestoredFile$6(r1, r2, r3, r4);
    }

    public ShortcutUser(ShortcutService service, int userId) {
        this.mPackages = new ArrayMap();
        this.mLaunchers = new ArrayMap();
        this.mLock = new Object();
        this.mService = service;
        this.mUserId = userId;
        this.mExecutor = FgThread.getExecutor();
    }

    public int getUserId() {
        return this.mUserId;
    }

    public long getLastAppScanTime() {
        return this.mLastAppScanTime;
    }

    public void setLastAppScanTime(long lastAppScanTime) {
        this.mLastAppScanTime = lastAppScanTime;
    }

    public String getLastAppScanOsFingerprint() {
        return this.mLastAppScanOsFingerprint;
    }

    public void setLastAppScanOsFingerprint(String lastAppScanOsFingerprint) {
        this.mLastAppScanOsFingerprint = lastAppScanOsFingerprint;
    }

    ArrayMap<String, ShortcutPackage> getAllPackagesForTest() {
        return this.mPackages;
    }

    public boolean hasPackage(String packageName) {
        return this.mPackages.containsKey(packageName);
    }

    private void addPackage(ShortcutPackage p) {
        p.replaceUser(this);
        this.mPackages.put(p.getPackageName(), p);
    }

    public ShortcutPackage removePackage(String packageName) {
        ShortcutPackage removed = this.mPackages.remove(packageName);
        this.mService.cleanupBitmapsForPackage(this.mUserId, packageName);
        return removed;
    }

    ArrayMap<UserPackage, ShortcutLauncher> getAllLaunchersForTest() {
        return this.mLaunchers;
    }

    private void addLauncher(ShortcutLauncher launcher) {
        launcher.replaceUser(this);
        this.mLaunchers.put(UserPackage.of(launcher.getPackageUserId(), launcher.getPackageName()), launcher);
    }

    public ShortcutLauncher removeLauncher(int packageUserId, String packageName) {
        return this.mLaunchers.remove(UserPackage.of(packageUserId, packageName));
    }

    public ShortcutPackage getPackageShortcutsIfExists(String packageName) {
        ShortcutPackage ret = this.mPackages.get(packageName);
        if (ret == null) goto L5;
        ret.attemptToRestoreIfNeededAndSave();
    L5:
        return ret;
    }

    public ShortcutPackage getPackageShortcuts(String packageName) {
        ShortcutPackage ret = getPackageShortcutsIfExists(packageName);
        if (ret != null) goto L6;
        ShortcutPackage ret2 = new ShortcutPackage(this, this.mUserId, packageName);
        this.mPackages.put(packageName, ret2);
        return ret2;
    L6:
        return ret;
    }

    public ShortcutLauncher getLauncherShortcuts(String packageName, int launcherUserId) {
        UserPackage key = UserPackage.of(launcherUserId, packageName);
        ShortcutLauncher ret = this.mLaunchers.get(key);
        if (ret != null) goto L5;
        ret = new ShortcutLauncher(this, this.mUserId, packageName, launcherUserId);
        this.mLaunchers.put(key, ret);
    L5:
        ret.attemptToRestoreIfNeededAndSave();
        return ret;
    }

    public void forAllPackages(Consumer<? super ShortcutPackage> callback) {
        int size = this.mPackages.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        callback.accept(this.mPackages.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void forAllLaunchers(Consumer<? super ShortcutLauncher> callback) {
        int size = this.mLaunchers.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        callback.accept(this.mLaunchers.valueAt(i));
        i = i + 1;
        goto L3
    }

    public void forAllPackageItems(Consumer<? super ShortcutPackageItem> callback) {
        forAllLaunchers(callback);
        forAllPackages(callback);
    }

    public void forPackageItem(final String packageName, final int packageUserId, final Consumer<ShortcutPackageItem> callback) {
        forAllPackageItems(new ShortcutUser$$ExternalSyntheticLambda2(packageUserId, packageName, callback));
    }

    private static /* synthetic */ void lambda$forPackageItem$0(int packageUserId, String packageName, Consumer callback, ShortcutPackageItem spi) {
        if (spi.getPackageUserId() == packageUserId) goto L5;
        return;
    L5:
        if (spi.getPackageName().equals(packageName) == false) goto L9;
        callback.accept(spi);
        return;
    }

    public void onCalledByPublisher(String packageName) {
        detectLocaleChange();
        rescanPackageIfNeeded(packageName, false);
    }

    private String getKnownLocales() {
        if (TextUtils.isEmpty(this.mKnownLocales) == false) goto L6;
        this.mKnownLocales = this.mService.injectGetLocaleTagsForUser(this.mUserId);
        this.mService.scheduleSaveUser(this.mUserId);
    L6:
        return this.mKnownLocales;
    }

    public void detectLocaleChange() {
        String currentLocales = this.mService.injectGetLocaleTagsForUser(this.mUserId);
        if (TextUtils.isEmpty(this.mKnownLocales) == false) goto L5;
    L7:
        this.mKnownLocales = currentLocales;
        forAllPackages(new ShortcutUser$$ExternalSyntheticLambda0());
        this.mService.scheduleSaveUser(this.mUserId);
        return;
    L5:
        if (this.mKnownLocales.equals(currentLocales) == false) goto L7;
    }

    private static /* synthetic */ void lambda$detectLocaleChange$1(ShortcutPackage pkg) {
        pkg.resetRateLimiting();
        pkg.resolveResourceStrings();
    }

    public void rescanPackageIfNeeded(String packageName, boolean forceRescan) {
        boolean isNewApp = !this.mPackages.containsKey(packageName);
        ShortcutPackage shortcutPackage = getPackageShortcuts(packageName);
        if (shortcutPackage.rescanPackageIfNeeded(isNewApp, forceRescan) == true) goto L7;
        if (isNewApp == false) goto L8;
        this.mPackages.remove(packageName);
        return;
    L8:
        return;
    }

    public void attemptToRestoreIfNeededAndSave(ShortcutService s, String packageName, int packageUserId) {
        forPackageItem(packageName, packageUserId, new ShortcutUser$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ void lambda$attemptToRestoreIfNeededAndSave$2(ShortcutPackageItem spi) {
        spi.attemptToRestoreIfNeededAndSave();
    }

    public void saveToXml(TypedXmlSerializer out, boolean forBackup) throws IOException, XmlPullParserException {
        out.startTag(null, TAG_ROOT);
        if (forBackup == true) goto L5;
        ShortcutService.writeAttr(out, ATTR_KNOWN_LOCALES, this.mKnownLocales);
        ShortcutService.writeAttr(out, ATTR_LAST_APP_SCAN_TIME, this.mLastAppScanTime);
        ShortcutService.writeAttr(out, ATTR_LAST_APP_SCAN_OS_FINGERPRINT, this.mLastAppScanOsFingerprint);
        ShortcutService.writeAttr(out, ATTR_RESTORE_SOURCE_FINGERPRINT, this.mRestoreFromOsFingerprint);
    L6:
        if (forBackup == false) goto L13;
        int size = this.mLaunchers.size();
        int i = 0;
    L8:
        if (i >= size) goto L10;
        saveShortcutPackageItem(out, this.mLaunchers.valueAt(i));
        i = i + 1;
        goto L8
    L10:
        int size2 = this.mPackages.size();
        int i2 = 0;
    L11:
        if (i2 >= size2) goto L13;
        saveShortcutPackageItem(out, this.mPackages.valueAt(i2));
        i2 = i2 + 1;
    L13:
        out.endTag(null, TAG_ROOT);
        return;
    L5:
        ShortcutService.writeAttr(out, ATTR_RESTORE_SOURCE_FINGERPRINT, this.mService.injectBuildFingerprint());
        goto L6
    }

    void scheduleSaveAllLaunchersAndPackages() {
        int size = this.mLaunchers.size();
        int i = 0;
    L3:
        if (i >= size) goto L5;
        this.mLaunchers.valueAt(i).scheduleSave();
        i = i + 1;
        goto L3
    L5:
        int size2 = this.mPackages.size();
        int i2 = 0;
    L6:
        if (i2 >= size2) goto L9;
        this.mPackages.valueAt(i2).scheduleSave();
        i2 = i2 + 1;
        goto L6
    }

    private void saveShortcutPackageItem(TypedXmlSerializer out, ShortcutPackageItem spi) throws IOException, XmlPullParserException {
        if (spi.getPackageUserId() == spi.getOwnerUserId()) goto L5;
        return;
    L5:
        spi.waitForBitmapSaves();
        spi.saveToXml(out, true);
    }

    public static ShortcutUser loadFromXml(final ShortcutService s, TypedXmlPullParser parser, final int userId, final boolean fromBackup) throws IOException, XmlPullParserException, ShortcutService.InvalidFileFormatException {
        final ShortcutUser ret = new ShortcutUser(s, userId);
        boolean readShortcutItems = false;
        ret.mKnownLocales = ShortcutService.parseStringAttribute(parser, ATTR_KNOWN_LOCALES);     // Catch: RuntimeException -> L15
        long lastAppScanTime = ShortcutService.parseLongAttribute(parser, ATTR_LAST_APP_SCAN_TIME);     // Catch: RuntimeException -> L15
        long currentTime = s.injectCurrentTimeMillis();     // Catch: RuntimeException -> L15
        if (lastAppScanTime >= currentTime) goto L6;
        long r11 = lastAppScanTime;
    L7:
        ret.mLastAppScanTime = r11;     // Catch: RuntimeException -> L15
        ret.mLastAppScanOsFingerprint = ShortcutService.parseStringAttribute(parser, ATTR_LAST_APP_SCAN_OS_FINGERPRINT);     // Catch: RuntimeException -> L15
        ret.mRestoreFromOsFingerprint = ShortcutService.parseStringAttribute(parser, ATTR_RESTORE_SOURCE_FINGERPRINT);     // Catch: RuntimeException -> L15
        int outerDepth = parser.getDepth();     // Catch: RuntimeException -> L15
    L8:
        int type = parser.next();     // Catch: RuntimeException -> L15
        byte r13 = 1;
        if (type == 1) goto L41;
        if (type != 3) goto L18;
        if (parser.getDepth() <= outerDepth) goto L41;
    L18:
        if (type != 2) goto L19;
        int depth = parser.getDepth();     // Catch: RuntimeException -> L15
        String tag = parser.getName();     // Catch: RuntimeException -> L15
        if (depth != (outerDepth + 1)) goto L37;
        switch(tag.hashCode()) {
            case -1146595445: goto L29;
            case -807062458: goto L26;
            default: goto L31;
        };     // Catch: RuntimeException -> L15
    L31:
        r13 = -1;
    L32:
        switch(r13) {
            case 0: goto L35;
            case 1: goto L34;
            default: goto L37;
        };     // Catch: RuntimeException -> L15
    L34:
        ret.addLauncher(ShortcutLauncher.loadFromXml(parser, ret, userId, fromBackup));     // Catch: RuntimeException -> L15
        readShortcutItems = true;
        goto L8
    L35:
        ShortcutPackage shortcuts = ShortcutPackage.loadFromXml(s, ret, parser, fromBackup);     // Catch: RuntimeException -> L15
        int outerDepth2 = outerDepth;
        ret.mPackages.put(shortcuts.getPackageName(), shortcuts);     // Catch: RuntimeException -> L15
        readShortcutItems = true;
        outerDepth = outerDepth2;
        goto L8
    L26:
        if (tag.equals(Settings.ATTR_PACKAGE) == false) goto L31;
        r13 = 0;
        goto L32
    L29:
        if (tag.equals("launcher-pins") == false) goto L31;
    L37:
        ShortcutService.warnForInvalidTag(depth, tag);     // Catch: RuntimeException -> L15
    L38:
        outerDepth = outerDepth;
        goto L8
    L19:
        outerDepth = outerDepth;
    L41:
        if (readShortcutItems == false) goto L43;
        s.scheduleSaveUser(userId);
    L44:
        return ret;
    L43:
        File root = s.injectUserDataPath(userId);
        forMainFilesIn(new File(root, "packages"), new ShortcutUser$$ExternalSyntheticLambda3(s, ret, fromBackup));
        forMainFilesIn(new File(root, "launchers"), new ShortcutUser$$ExternalSyntheticLambda4(ret, userId, fromBackup));
        goto L44
    L6:
        r11 = 0;
    L15:
        e = move-exception;
        throw new ShortcutService.InvalidFileFormatException("Unable to parse file", e);
    }

    private static /* synthetic */ void lambda$loadFromXml$3(ShortcutService s, ShortcutUser ret, boolean fromBackup, File f) {
        ShortcutPackage sp = ShortcutPackage.loadFromFile(s, ret, f, fromBackup);
        if (sp == null) goto L6;
        ret.mPackages.put(sp.getPackageName(), sp);
        return;
    }

    private static /* synthetic */ void lambda$loadFromXml$4(ShortcutUser ret, int userId, boolean fromBackup, File f) {
        ShortcutLauncher sl = ShortcutLauncher.loadFromFile(f, ret, userId, fromBackup);
        if (sl == null) goto L6;
        ret.addLauncher(sl);
        return;
    }

    private static void forMainFilesIn(File path, Consumer<File> callback) {
        if (path.exists() == true) goto L5;
        return;
    L5:
        File[] list = path.listFiles();
        int r1 = list.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        File f = list[r2];
        if (f.getName().endsWith(".reservecopy") == true) goto L12;
        if (f.getName().endsWith(".backup") == true) goto L12;
        callback.accept(f);
    L12:
        r2 = r2 + 1;
        goto L6
    }

    public void setCachedLauncher(String launcher) {
        this.mCachedLauncher = launcher;
    }

    public String getCachedLauncher() {
        return this.mCachedLauncher;
    }

    public void resetThrottling() {
        int i = this.mPackages.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mPackages.valueAt(i).resetThrottling();
        i = i - 1;
        goto L3
    }

    public void mergeRestoredFile(ShortcutUser restored) {
        final ShortcutService s = this.mService;
        final int[] restoredLaunchers = new int[1];
        final int[] restoredPackages = new int[1];
        final int[] restoredShortcuts = new int[1];
        this.mLaunchers.clear();
        restored.forAllLaunchers(new ShortcutUser$$ExternalSyntheticLambda5(this, s, restoredLaunchers));
        restored.forAllPackages(new ShortcutUser$$ExternalSyntheticLambda6(this, s, restoredPackages, restoredShortcuts));
        restored.mLaunchers.clear();
        restored.mPackages.clear();
        this.mRestoreFromOsFingerprint = restored.mRestoreFromOsFingerprint;
        Slog.i(TAG, "Restored: L=" + restoredLaunchers[0] + " P=" + restoredPackages[0] + " S=" + restoredShortcuts[0]);
    }

    private /* synthetic */ void lambda$mergeRestoredFile$5(ShortcutService s, int[] restoredLaunchers, ShortcutLauncher sl) {
        if (s.isPackageInstalled(sl.getPackageName(), getUserId()) == true) goto L5;
    L7:
        addLauncher(sl);
        restoredLaunchers[0] = restoredLaunchers[0] + 1;
        return;
    L5:
        if (s.shouldBackupApp(sl.getPackageName(), getUserId()) == true) goto L7;
    }

    private /* synthetic */ void lambda$mergeRestoredFile$6(ShortcutService s, int[] restoredPackages, int[] restoredShortcuts, ShortcutPackage sp) {
        if (s.isPackageInstalled(sp.getPackageName(), getUserId()) == true) goto L5;
    L7:
        ShortcutPackage previous = getPackageShortcutsIfExists(sp.getPackageName());
        if (previous != null) goto L10;
    L12:
        addPackage(sp);
        restoredPackages[0] = restoredPackages[0] + 1;
        restoredShortcuts[0] = restoredShortcuts[0] + sp.getShortcutCount();
        return;
    L10:
        if (previous.hasNonManifestShortcuts() == false) goto L12;
        Log.w(TAG, "Shortcuts for package " + sp.getPackageName() + " are being restored. Existing non-manifeset shortcuts will be overwritten.");
        goto L12
    L5:
        if (s.shouldBackupApp(sp.getPackageName(), getUserId()) == true) goto L7;
    }

    public void dump(PrintWriter pw, String prefix, ShortcutService.DumpFilter filter) {
        if (filter.shouldDumpDetails() == false) goto L5;
        pw.print(prefix);
        pw.print("User: ");
        pw.print(this.mUserId);
        pw.print("  Known locales: ");
        pw.print(this.mKnownLocales);
        pw.print("  Last app scan: [");
        pw.print(this.mLastAppScanTime);
        pw.print("] ");
        pw.println(ShortcutService.formatTime(this.mLastAppScanTime));
        prefix = prefix + prefix + "  ";
        pw.print(prefix);
        pw.print("Last app scan FP: ");
        pw.println(this.mLastAppScanOsFingerprint);
        pw.print(prefix);
        pw.print("Restore from FP: ");
        pw.print(this.mRestoreFromOsFingerprint);
        pw.println();
        pw.print(prefix);
        pw.print("Cached launcher: ");
        pw.print(this.mCachedLauncher);
        pw.println();
    L5:
        int i = 0;
    L7:
        if (i >= this.mLaunchers.size()) goto L12;
        ShortcutLauncher launcher = this.mLaunchers.valueAt(i);
        if (filter.isPackageMatch(launcher.getPackageName()) == false) goto L11;
        launcher.dump(pw, prefix, filter);
    L11:
        i = i + 1;
        goto L7
    L12:
        int i2 = 0;
    L14:
        if (i2 >= this.mPackages.size()) goto L20;
        ShortcutPackage pkg = this.mPackages.valueAt(i2);
        if (filter.isPackageMatch(pkg.getPackageName()) == false) goto L18;
        pkg.dump(pw, prefix, filter);
    L18:
        i2 = i2 + 1;
        goto L14
    L20:
        if (filter.shouldDumpDetails() == false) goto L29;
        pw.println();
        pw.print(prefix);
        pw.println("Bitmap directories: ");
        dumpDirectorySize(pw, prefix + "  ", this.mService.getUserBitmapFilePath(this.mUserId));
        return;
    }

    private void dumpDirectorySize(PrintWriter pw, String prefix, File path) {
        int numFiles = 0;
        long size = 0;
        File[] children = path.listFiles();
        if (children == null) goto L14;
        File[] r4 = path.listFiles();
        int r5 = r4.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L14;
        File child = r4[r6];
        if (child.isFile() == false) goto L11;
        numFiles = numFiles + 1;
        size = size + child.length();
    L13:
        r6 = r6 + 1;
        goto L6
    L11:
        if (child.isDirectory() == false) goto L13;
        dumpDirectorySize(pw, prefix + "  ", child);
    L14:
        pw.print(prefix);
        pw.print("Path: ");
        pw.print(path.getName());
        pw.print("/ has ");
        pw.print(numFiles);
        pw.print(" files, size=");
        pw.print(size);
        pw.print(" (");
        pw.print(Formatter.formatFileSize(this.mService.mContext, size));
        pw.println(")");
    }

    public JSONObject dumpCheckin(boolean clear) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("userId", this.mUserId);
        JSONArray launchers = new JSONArray();
        int i = 0;
    L4:
        if (i >= this.mLaunchers.size()) goto L6;
        launchers.put(this.mLaunchers.valueAt(i).dumpCheckin(clear));
        i = i + 1;
        goto L4
    L6:
        result.put("launchers", launchers);
        JSONArray packages = new JSONArray();
        int i2 = 0;
    L8:
        if (i2 >= this.mPackages.size()) goto L10;
        packages.put(this.mPackages.valueAt(i2).dumpCheckin(clear));
        i2 = i2 + 1;
        goto L8
    L10:
        result.put("packages", packages);
        return result;
    }

    void logSharingShortcutStats(MetricsLogger logger) {
        int packageWithShareTargetsCount = 0;
        int totalSharingShortcutCount = 0;
        int i = 0;
    L4:
        if (i >= this.mPackages.size()) goto L9;
        if (this.mPackages.valueAt(i).hasShareTargets() == false) goto L8;
        packageWithShareTargetsCount = packageWithShareTargetsCount + 1;
        totalSharingShortcutCount = totalSharingShortcutCount + this.mPackages.valueAt(i).getSharingShortcutCount();
    L8:
        i = i + 1;
        goto L4
    L9:
        LogMaker logMaker = new LogMaker(1717);
        logger.write(logMaker.setType(1).setSubtype(this.mUserId));
        logger.write(logMaker.setType(2).setSubtype(packageWithShareTargetsCount));
        logger.write(logMaker.setType(3).setSubtype(totalSharingShortcutCount));
    }
}
