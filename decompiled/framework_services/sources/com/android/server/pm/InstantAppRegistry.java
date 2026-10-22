package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstantAppInfo;
import android.content.pm.PermissionInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.permission.PermissionManager;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.PackageUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.SomeArgs;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUtils;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.Watched;
import com.android.server.utils.WatchedSparseArray;
import com.android.server.utils.WatchedSparseBooleanArray;
import com.android.server.utils.Watcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import libcore.io.IoUtils;
import libcore.util.HexEncoding;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class InstantAppRegistry implements Watchable, Snappable {
    private static final String ATTR_GRANTED = "granted";
    private static final String ATTR_LABEL = "label";
    private static final String ATTR_NAME = "name";
    private static final boolean DEBUG = false;
    private static final long DEFAULT_INSTALLED_INSTANT_APP_MAX_CACHE_PERIOD = 15552000000L;
    static final long DEFAULT_INSTALLED_INSTANT_APP_MIN_CACHE_PERIOD = 604800000;
    private static final long DEFAULT_UNINSTALLED_INSTANT_APP_MAX_CACHE_PERIOD = 15552000000L;
    static final long DEFAULT_UNINSTALLED_INSTANT_APP_MIN_CACHE_PERIOD = 604800000;
    private static final String INSTANT_APPS_FOLDER = "instant";
    private static final String INSTANT_APP_ANDROID_ID_FILE = "android_id";
    private static final String INSTANT_APP_COOKIE_FILE_PREFIX = "cookie_";
    private static final String INSTANT_APP_COOKIE_FILE_SIFFIX = ".dat";
    private static final String INSTANT_APP_ICON_FILE = "icon.png";
    private static final String INSTANT_APP_METADATA_FILE = "metadata.xml";
    private static final String LOG_TAG = "InstantAppRegistry";
    private static final String TAG_PACKAGE = "package";
    private static final String TAG_PERMISSION = "permission";
    private static final String TAG_PERMISSIONS = "permissions";
    private final Context mContext;
    private final CookiePersistence mCookiePersistence;
    private final DeletePackageHelper mDeletePackageHelper;

    @Watched
    private final WatchedSparseArray<WatchedSparseBooleanArray> mInstalledInstantAppUids;

    @Watched
    private final WatchedSparseArray<WatchedSparseArray<WatchedSparseBooleanArray>> mInstantGrants;
    private final Object mLock;
    private final Watcher mObserver;
    private final PermissionManagerServiceInternal mPermissionManager;
    private final SnapshotCache<InstantAppRegistry> mSnapshot;

    @Watched
    private final WatchedSparseArray<List<UninstalledInstantAppState>> mUninstalledInstantApps;
    private final UserManagerInternal mUserManager;
    private final WatchableImpl mWatchable;

    private final class CookiePersistence extends Handler {
        private static final long PERSIST_COOKIE_DELAY_MILLIS = 1000;
        private final SparseArray<ArrayMap<String, SomeArgs>> mPendingPersistCookies;
        final /* synthetic */ InstantAppRegistry this$0;

        public CookiePersistence(InstantAppRegistry r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
            this.mPendingPersistCookies = new SparseArray();
        }

        public void schedulePersistLPw(int userId, AndroidPackage pkg, byte[] cookie) {
            File newCookieFile = InstantAppRegistry.m6681$$Nest$smcomputeInstantCookieFile(pkg.getPackageName(), PackageUtils.computeSignaturesSha256Digest(pkg.getSigningDetails().getSignatures()), userId);
            if (pkg.getSigningDetails().hasSignatures() == true) goto L5;
            Slog.wtf(InstantAppRegistry.LOG_TAG, "Parsed Instant App contains no valid signatures!");
        L5:
            File oldCookieFile = InstantAppRegistry.m6682$$Nest$smpeekInstantCookieFile(pkg.getPackageName(), userId);
            if (oldCookieFile != null) goto L8;
        L10:
            cancelPendingPersistLPw(pkg, userId);
            addPendingPersistCookieLPw(userId, pkg, cookie, newCookieFile);
            sendMessageDelayed(obtainMessage(userId, pkg), 1000);
            return;
        L8:
            if (newCookieFile.equals(oldCookieFile) == true) goto L10;
            oldCookieFile.delete();
            goto L10
        }

        public byte[] getPendingPersistCookieLPr(AndroidPackage pkg, int userId) {
            ArrayMap<String, SomeArgs> pendingWorkForUser = this.mPendingPersistCookies.get(userId);
            if (pendingWorkForUser == null) goto L8;
            SomeArgs state = pendingWorkForUser.get(pkg.getPackageName());
            if (state != null) goto L7;
            return null;
        L7:
            return (byte[]) state.arg1;
        L8:
            return null;
        }

        public void cancelPendingPersistLPw(AndroidPackage pkg, int userId) {
            removeMessages(userId, pkg);
            SomeArgs state = removePendingPersistCookieLPr(pkg, userId);
            if (state == null) goto L6;
            state.recycle();
            return;
        }

        private void addPendingPersistCookieLPw(int userId, AndroidPackage pkg, byte[] cookie, File cookieFile) {
            ArrayMap<String, SomeArgs> pendingWorkForUser = this.mPendingPersistCookies.get(userId);
            if (pendingWorkForUser != null) goto L5;
            pendingWorkForUser = new ArrayMap();
            this.mPendingPersistCookies.put(userId, pendingWorkForUser);
        L5:
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = cookie;
            args.arg2 = cookieFile;
            pendingWorkForUser.put(pkg.getPackageName(), args);
        }

        private SomeArgs removePendingPersistCookieLPr(AndroidPackage pkg, int userId) {
            ArrayMap<String, SomeArgs> pendingWorkForUser = this.mPendingPersistCookies.get(userId);
            SomeArgs state = null;
            if (pendingWorkForUser == null) goto L7;
            SomeArgs state2 = pendingWorkForUser.remove(pkg.getPackageName());
            state = state2;
            if (pendingWorkForUser.isEmpty() == false) goto L7;
            this.mPendingPersistCookies.remove(userId);
        L7:
            return state;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int userId = message.what;
            AndroidPackage pkg = (AndroidPackage) message.obj;
            SomeArgs state = removePendingPersistCookieLPr(pkg, userId);
            if (state != null) goto L5;
            return;
        L5:
            byte[] cookie = (byte[]) state.arg1;
            File cookieFile = (File) state.arg2;
            state.recycle();
            InstantAppRegistry.m6680$$Nest$mpersistInstantApplicationCookie(this.this$0, cookie, pkg.getPackageName(), cookieFile, userId);
        }
    }

    private static final class UninstalledInstantAppState {
        final InstantAppInfo mInstantAppInfo;
        final long mTimestamp;

        public UninstalledInstantAppState(InstantAppInfo instantApp, long timestamp) {
            this.mInstantAppInfo = instantApp;
            this.mTimestamp = timestamp;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$4nF9pSnc0Uypodr6i7PK2TAqKk4(AndroidPackage r0, UninstalledInstantAppState r1) {
        return lambda$onPackageInstalled$0(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$5QiwaX1dRSyXlX1j4q1hixt_x5I(ArrayMap r0, String r1, String r2) {
        return lambda$pruneInstantApps$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Nn-QdoyMsBX-t84LOJc2ceUB4zE, reason: not valid java name */
    public static /* synthetic */ boolean m6677$r8$lambda$NnQdoyMsBXt84LOJc2ceUB4zE(long r0, UninstalledInstantAppState r2) {
        return lambda$pruneInstantApps$3(r0, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$yPlgZBhW7tOn4Xi2FvzE7v0VKz0(String r0, UninstalledInstantAppState r1) {
        return lambda$deleteInstantApplicationMetadata$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWatchable, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchableImpl m6678$$Nest$fgetmWatchable(InstantAppRegistry r0) {
        return r0.mWatchable;
    }

    /* JADX INFO: renamed from: -$$Nest$monChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6679$$Nest$monChanged(InstantAppRegistry r0) {
        r0.onChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mpersistInstantApplicationCookie, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6680$$Nest$mpersistInstantApplicationCookie(InstantAppRegistry r0, byte[] r1, String r2, File r3, int r4) {
        r0.persistInstantApplicationCookie(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smcomputeInstantCookieFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m6681$$Nest$smcomputeInstantCookieFile(String r0, String r1, int r2) {
        return computeInstantCookieFile(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smpeekInstantCookieFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m6682$$Nest$smpeekInstantCookieFile(String r0, int r1) {
        return peekInstantCookieFile(r0, r1);
    }

    /* synthetic */ InstantAppRegistry(InstantAppRegistry r1, InstantAppRegistryIA r2) {
        this(r1);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    @Override // com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        this.mWatchable.registerObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        this.mWatchable.unregisterObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public boolean isRegisteredObserver(Watcher observer) {
        return this.mWatchable.isRegisteredObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void dispatchChange(Watchable what) {
        this.mWatchable.dispatchChange(what);
    }

    private void onChanged() {
        dispatchChange(this);
    }

    private SnapshotCache<InstantAppRegistry> makeCache() {
        return new AnonymousClass2(this, this, this);
    }

    public InstantAppRegistry(Context context, PermissionManagerServiceInternal permissionManager, UserManagerInternal userManager, DeletePackageHelper deletePackageHelper) {
        this.mLock = new Object();
        this.mWatchable = new WatchableImpl();
        this.mObserver = new AnonymousClass1(this);
        this.mContext = context;
        this.mPermissionManager = permissionManager;
        this.mUserManager = userManager;
        this.mDeletePackageHelper = deletePackageHelper;
        this.mCookiePersistence = new CookiePersistence(this, BackgroundThread.getHandler().getLooper());
        this.mUninstalledInstantApps = new WatchedSparseArray();
        this.mInstantGrants = new WatchedSparseArray();
        this.mInstalledInstantAppUids = new WatchedSparseArray();
        this.mUninstalledInstantApps.registerObserver(this.mObserver);
        this.mInstantGrants.registerObserver(this.mObserver);
        this.mInstalledInstantAppUids.registerObserver(this.mObserver);
        Watchable.verifyWatchedAttributes(this, this.mObserver);
        this.mSnapshot = makeCache();
    }

    private InstantAppRegistry(InstantAppRegistry r) {
        this.mLock = new Object();
        this.mWatchable = new WatchableImpl();
        this.mObserver = new AnonymousClass1(this);
        this.mContext = r.mContext;
        this.mPermissionManager = r.mPermissionManager;
        this.mUserManager = r.mUserManager;
        this.mDeletePackageHelper = r.mDeletePackageHelper;
        this.mCookiePersistence = null;
        this.mUninstalledInstantApps = new WatchedSparseArray(r.mUninstalledInstantApps);
        this.mInstantGrants = new WatchedSparseArray(r.mInstantGrants);
        this.mInstalledInstantAppUids = new WatchedSparseArray(r.mInstalledInstantAppUids);
        this.mSnapshot = null;
    }

    @Override // com.android.server.utils.Snappable
    public InstantAppRegistry snapshot() {
        return this.mSnapshot.snapshot();
    }

    public byte[] getInstantAppCookie(AndroidPackage pkg, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        byte[] pendingCookie = this.mCookiePersistence.getPendingPersistCookieLPr(pkg, userId);     // Catch: Throwable -> L8
        if (pendingCookie == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return pendingCookie;
    L10:
        File cookieFile = peekInstantCookieFile(pkg.getPackageName(), userId);     // Catch: Throwable -> L8
        if (cookieFile != null) goto L13;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L13:
        if (cookieFile.exists() == false) goto L19;
        byte[] r3 = IoUtils.readFileAsByteArray(cookieFile.toString());     // Catch: Throwable -> L8 IOException -> L17
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r3;
    L18:
        Slog.w(LOG_TAG, "Error reading cookie file: " + cookieFile);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public boolean setInstantAppCookie(AndroidPackage pkg, byte[] cookie, int instantAppCookieMaxBytes, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (cookie != null) goto L21;
    L15:
        this.mCookiePersistence.schedulePersistLPw(userId, pkg, cookie);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L21:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (cookie.length <= 0) goto L15;
        if (cookie.length <= instantAppCookieMaxBytes) goto L15;
        Slog.e(LOG_TAG, "Instant app cookie for package " + pkg.getPackageName() + " size " + cookie.length + " bytes while max size is " + instantAppCookieMaxBytes);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    }

    private void persistInstantApplicationCookie(byte[] cookie, String packageName, File cookieFile, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        File appDir = getInstantApplicationDir(packageName, userId);     // Catch: Throwable -> L11
        if (appDir.exists() == true) goto L14;
        if (appDir.mkdirs() == true) goto L14;
        Slog.e(LOG_TAG, "Cannot create instant app cookie directory");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (cookieFile.exists() == true) goto L16;
    L18:
        if (cookie == null) goto L37;
        if (cookie.length <= 0) goto L37;
        monitor-exit(r0);     // Catch: Throwable -> L11
        FileOutputStream fos = new FileOutputStream(cookieFile);     // Catch: IOException -> L27
        fos.write(cookie, 0, cookie.length);     // Catch: Throwable -> L29
        fos.close();     // Catch: IOException -> L27
        return;
    L29:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: IOException -> L27
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L27
    L27:
        e = move-exception;
        Slog.e(LOG_TAG, "Error writing instant app cookie file: " + cookieFile, e);
        return;
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        if (cookieFile.delete() == true) goto L18;
        Slog.e(LOG_TAG, "Cannot delete instant app cookie file");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public Bitmap getInstantAppIcon(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        File iconFile = new File(getInstantApplicationDir(packageName, userId), INSTANT_APP_ICON_FILE);     // Catch: Throwable -> L9
        if (iconFile.exists() == false) goto L11;
        Bitmap r2 = BitmapFactory.decodeFile(iconFile.toString());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public String getInstantAppAndroidId(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        File idFile = new File(getInstantApplicationDir(packageName, userId), INSTANT_APP_ANDROID_ID_FILE);     // Catch: Throwable -> L9
        if (idFile.exists() == true) goto L43;
    L13:
        byte[] randomBytes = new byte[8];     // Catch: Throwable -> L9
        new SecureRandom().nextBytes(randomBytes);     // Catch: Throwable -> L9
        String id = HexEncoding.encodeToString(randomBytes, false);     // Catch: Throwable -> L9
        File appDir = getInstantApplicationDir(packageName, userId);     // Catch: Throwable -> L9
        if (appDir.exists() == false) goto L16;
    L20:
        File idFile2 = new File(getInstantApplicationDir(packageName, userId), INSTANT_APP_ANDROID_ID_FILE);     // Catch: Throwable -> L9
        FileOutputStream fos = new FileOutputStream(idFile2);     // Catch: Throwable -> L9 IOException -> L25
        fos.write(id.getBytes());     // Catch: Throwable -> L27
        fos.close();     // Catch: Throwable -> L9 IOException -> L25
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return id;
    L27:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Throwable -> L9 IOException -> L25
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 IOException -> L25
    L25:
        e = move-exception;
        Slog.e(LOG_TAG, "Error writing instant app android id file: " + idFile2, e);     // Catch: Throwable -> L9
        goto L35
    L16:
        if (appDir.mkdirs() == true) goto L20;
        Slog.e(LOG_TAG, "Cannot create instant app cookie directory");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return id;
    L43:
        String r2 = IoUtils.readFileAsString(idFile.getAbsolutePath());     // Catch: Throwable -> L9 IOException -> L11
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        e = move-exception;
        Slog.e(LOG_TAG, "Failed to read instant app android id file: " + idFile, e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public List<InstantAppInfo> getInstantApps(Computer computer, int userId) {
        List<InstantAppInfo> installedApps = getInstalledInstantApplications(computer, userId);
        List<InstantAppInfo> uninstalledApps = getUninstalledInstantApplications(computer, userId);
        if (installedApps == null) goto L7;
        if (uninstalledApps == null) goto L6;
        installedApps.addAll(uninstalledApps);
    L6:
        return installedApps;
    L7:
        return uninstalledApps;
    }

    public void onPackageInstalled(Computer computer, String packageName, int[] userIds) {
        PackageStateInternal ps = computer.getPackageStateInternal(packageName);
        if (ps != null) goto L5;
        AndroidPackageInternal r0 = null;
    L6:
        final AndroidPackageInternal r4 = r0;
        if (r4 != null) goto L9;
        return;
    L9:
        Object r5 = this.mLock;
        monitor-enter(r5);
        int r1 = userIds.length;     // Catch: Throwable -> L19
        int r7 = 0;
    L12:
        if (r7 >= r1) goto L37;
        int userId = userIds[r7];     // Catch: Throwable -> L19
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L36;
        propagateInstantAppPermissionsIfNeeded(r4, userId);     // Catch: Throwable -> L19
        if (ps.getUserStateOrDefault(userId).isInstantApp() == false) goto L21;
        addInstantApp(userId, ps.getAppId());     // Catch: Throwable -> L19
    L21:
        removeUninstalledInstantAppStateLPw(new InstantAppRegistry$$ExternalSyntheticLambda0(r4), userId);     // Catch: Throwable -> L19
        File instantAppDir = getInstantApplicationDir(r4.getPackageName(), userId);     // Catch: Throwable -> L19
        new File(instantAppDir, INSTANT_APP_METADATA_FILE).delete();     // Catch: Throwable -> L19
        new File(instantAppDir, INSTANT_APP_ICON_FILE).delete();     // Catch: Throwable -> L19
        File currentCookieFile = peekInstantCookieFile(r4.getPackageName(), userId);     // Catch: Throwable -> L19
        if (currentCookieFile == null) goto L36;
        String cookieName = currentCookieFile.getName();     // Catch: Throwable -> L19
        String currentCookieSha256 = cookieName.substring(INSTANT_APP_COOKIE_FILE_PREFIX.length(), cookieName.length() - INSTANT_APP_COOKIE_FILE_SIFFIX.length());     // Catch: Throwable -> L19
        if (r4.getSigningDetails().checkCapability(currentCookieSha256, 1) == true) goto L26;
        String[] signaturesSha256Digests = PackageUtils.computeSignaturesSha256Digests(r4.getSigningDetails().getSignatures());     // Catch: Throwable -> L19
        int r14 = signaturesSha256Digests.length;     // Catch: Throwable -> L19
        int r15 = 0;
    L29:
        if (r15 >= r14) goto L35;
        String s = signaturesSha256Digests[r15];     // Catch: Throwable -> L19
        if (s.equals(currentCookieSha256) == true) goto L32;
        r15 = r15 + 1;     // Catch: Throwable -> L19
        goto L29
    L32:
        monitor-exit(r5);     // Catch: Throwable -> L19
        return;
    L35:
        Slog.i(LOG_TAG, "Signature for package " + r4.getPackageName() + " changed - dropping cookie");     // Catch: Throwable -> L19
        this.mCookiePersistence.cancelPendingPersistLPw(r4, userId);     // Catch: Throwable -> L19
        currentCookieFile.delete();     // Catch: Throwable -> L19
        goto L36
    L26:
        monitor-exit(r5);     // Catch: Throwable -> L19
        return;
    L36:
        r7 = r7 + 1;     // Catch: Throwable -> L19
        goto L12
    L37:
        monitor-exit(r5);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L5:
        r0 = ps.getPkg();
        goto L6
    }

    private static /* synthetic */ boolean lambda$onPackageInstalled$0(AndroidPackage pkg, UninstalledInstantAppState state) {
        return state.mInstantAppInfo.getPackageName().equals(pkg.getPackageName());
    }

    public void onPackageUninstalled(AndroidPackage pkg, PackageSetting ps, int[] userIds, boolean packageInstalledForSomeUsers) {
        if (ps != null) goto L4;
        return;
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = userIds.length;     // Catch: Throwable -> L13
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L20;
        int userId = userIds[r2];     // Catch: Throwable -> L13
        if (packageInstalledForSomeUsers == false) goto L16;
        if (ps.getInstalled(userId) == false) goto L16;
    L19:
        r2 = r2 + 1;     // Catch: Throwable -> L13
    L16:
        if (ps.getInstantApp(userId) == false) goto L18;
        addUninstalledInstantAppLPw(ps, userId);     // Catch: Throwable -> L13
        removeInstantAppLPw(userId, ps.getAppId());     // Catch: Throwable -> L13
        goto L19
    L18:
        deleteDir(getInstantApplicationDir(pkg.getPackageName(), userId));     // Catch: Throwable -> L13
        this.mCookiePersistence.cancelPendingPersistLPw(pkg, userId);     // Catch: Throwable -> L13
        removeAppLPw(userId, ps.getAppId());     // Catch: Throwable -> L13
        goto L19
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUninstalledInstantApps.remove(userId);     // Catch: Throwable -> L7
        this.mInstalledInstantAppUids.remove(userId);     // Catch: Throwable -> L7
        this.mInstantGrants.remove(userId);     // Catch: Throwable -> L7
        deleteDir(getInstantApplicationsDir(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isInstantAccessGranted(int userId, int targetAppId, int instantAppId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WatchedSparseArray<WatchedSparseBooleanArray> targetAppList = this.mInstantGrants.get(userId);     // Catch: Throwable -> L8
        if (targetAppList != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        WatchedSparseBooleanArray instantGrantList = targetAppList.get(targetAppId);     // Catch: Throwable -> L8
        if (instantGrantList != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L14:
        boolean r2 = instantGrantList.get(instantAppId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean grantInstantAccess(int userId, Intent intent, int recipientUid, int instantAppId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInstalledInstantAppUids != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        WatchedSparseBooleanArray instantAppList = this.mInstalledInstantAppUids.get(userId);     // Catch: Throwable -> L8
        if (instantAppList == null) goto L37;
        if (instantAppList.get(instantAppId) == false) goto L37;
        if (instantAppList.get(recipientUid) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L19:
        if (intent != null) goto L21;
    L28:
        WatchedSparseArray<WatchedSparseBooleanArray> targetAppList = this.mInstantGrants.get(userId);     // Catch: Throwable -> L8
        if (targetAppList != null) goto L31;
        targetAppList = new WatchedSparseArray();     // Catch: Throwable -> L8
        this.mInstantGrants.put(userId, targetAppList);     // Catch: Throwable -> L8
    L31:
        WatchedSparseBooleanArray instantGrantList = targetAppList.get(recipientUid);     // Catch: Throwable -> L8
        if (instantGrantList != null) goto L34;
        instantGrantList = new WatchedSparseBooleanArray();     // Catch: Throwable -> L8
        targetAppList.put(recipientUid, instantGrantList);     // Catch: Throwable -> L8
    L34:
        instantGrantList.put(instantAppId, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L21:
        if ("android.intent.action.VIEW".equals(intent.getAction()) == false) goto L28;
        Set<String> categories = intent.getCategories();     // Catch: Throwable -> L8
        if (categories == null) goto L28;
        if (categories.contains("android.intent.category.BROWSABLE") == false) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    public void addInstantApp(int userId, int instantAppId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WatchedSparseBooleanArray instantAppList = this.mInstalledInstantAppUids.get(userId);     // Catch: Throwable -> L7
        if (instantAppList != null) goto L9;
        instantAppList = new WatchedSparseBooleanArray();     // Catch: Throwable -> L7
        this.mInstalledInstantAppUids.put(userId, instantAppList);     // Catch: Throwable -> L7
    L9:
        instantAppList.put(instantAppId, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        onChanged();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeInstantAppLPw(int userId, int instantAppId) {
        if (this.mInstalledInstantAppUids != null) goto L5;
        return;
    L5:
        WatchedSparseBooleanArray instantAppList = this.mInstalledInstantAppUids.get(userId);
        if (instantAppList != null) goto L26;
        return;
    L26:
        instantAppList.delete(instantAppId);     // Catch: Throwable -> L20
        if (this.mInstantGrants != null) goto L12;
        onChanged();
        return;
    L12:
        WatchedSparseArray<WatchedSparseBooleanArray> targetAppList = this.mInstantGrants.get(userId);     // Catch: Throwable -> L20
        if (targetAppList != null) goto L16;
        onChanged();
        return;
    L16:
        int i = targetAppList.size() - 1;     // Catch: Throwable -> L20
    L17:
        if (i < 0) goto L22;
        targetAppList.valueAt(i).delete(instantAppId);     // Catch: Throwable -> L20
        i = i - 1;
        goto L17
    L22:
        onChanged();
        return;
    L20:
        th = move-exception;
        onChanged();
        throw th;
    }

    private void removeAppLPw(int userId, int targetAppId) {
        if (this.mInstantGrants != null) goto L5;
        return;
    L5:
        WatchedSparseArray<WatchedSparseBooleanArray> targetAppList = this.mInstantGrants.get(userId);
        if (targetAppList != null) goto L8;
        return;
    L8:
        targetAppList.delete(targetAppId);
        onChanged();
    }

    private void addUninstalledInstantAppLPw(PackageStateInternal packageState, int userId) {
        InstantAppInfo uninstalledApp = createInstantAppInfoForPackage(packageState, userId, false);
        if (uninstalledApp != null) goto L5;
        return;
    L5:
        List<UninstalledInstantAppState> uninstalledAppStates = this.mUninstalledInstantApps.get(userId);
        if (uninstalledAppStates != null) goto L8;
        uninstalledAppStates = new ArrayList();
        this.mUninstalledInstantApps.put(userId, uninstalledAppStates);
    L8:
        UninstalledInstantAppState uninstalledAppState = new UninstalledInstantAppState(uninstalledApp, System.currentTimeMillis());
        uninstalledAppStates.add(uninstalledAppState);
        writeUninstalledInstantAppMetadata(uninstalledApp, userId);
        writeInstantApplicationIconLPw(packageState.getPkg(), userId);
    }

    private void writeInstantApplicationIconLPw(AndroidPackage pkg, int userId) {
        File appDir = getInstantApplicationDir(pkg.getPackageName(), userId);
        if (appDir.exists() == true) goto L5;
        return;
    L5:
        Drawable icon = AndroidPackageUtils.generateAppInfoWithoutState(pkg).loadIcon(this.mContext.getPackageManager());
        if ((icon instanceof BitmapDrawable) == false) goto L8;
        Bitmap bitmap = ((BitmapDrawable) icon).getBitmap();
    L9:
        File iconFile = new File(getInstantApplicationDir(pkg.getPackageName(), userId), INSTANT_APP_ICON_FILE);
        FileOutputStream out = new FileOutputStream(iconFile);     // Catch: Exception -> L14
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);     // Catch: Throwable -> L16
        out.close();     // Catch: Exception -> L14
        return;
    L16:
        th = move-exception;
        out.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L14
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Slog.e(LOG_TAG, "Error writing instant app icon", e);
        return;
    L8:
        bitmap = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
        icon.draw(canvas);
        goto L9
    }

    boolean hasInstantApplicationMetadata(String packageName, int userId) {
        if (hasUninstalledInstantAppState(packageName, userId) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasInstantAppMetadata(packageName, userId) == true) goto L8;
        return false;
    }

    public void deleteInstantApplicationMetadata(final String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeUninstalledInstantAppStateLPw(new InstantAppRegistry$$ExternalSyntheticLambda1(packageName), userId);     // Catch: Throwable -> L7
        File instantAppDir = getInstantApplicationDir(packageName, userId);     // Catch: Throwable -> L7
        new File(instantAppDir, INSTANT_APP_METADATA_FILE).delete();     // Catch: Throwable -> L7
        new File(instantAppDir, INSTANT_APP_ICON_FILE).delete();     // Catch: Throwable -> L7
        new File(instantAppDir, INSTANT_APP_ANDROID_ID_FILE).delete();     // Catch: Throwable -> L7
        File cookie = peekInstantCookieFile(packageName, userId);     // Catch: Throwable -> L7
        if (cookie == null) goto L9;
        cookie.delete();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$deleteInstantApplicationMetadata$1(String packageName, UninstalledInstantAppState state) {
        return state.mInstantAppInfo.getPackageName().equals(packageName);
    }

    private void removeUninstalledInstantAppStateLPw(Predicate<UninstalledInstantAppState> criteria, int userId) {
        if (this.mUninstalledInstantApps != null) goto L5;
        return;
    L5:
        List<UninstalledInstantAppState> uninstalledAppStates = this.mUninstalledInstantApps.get(userId);
        if (uninstalledAppStates != null) goto L8;
        return;
    L8:
        int appCount = uninstalledAppStates.size();
        int i = appCount - 1;
    L9:
        if (i < 0) goto L19;
        UninstalledInstantAppState uninstalledAppState = uninstalledAppStates.get(i);
        if (criteria.test(uninstalledAppState) == false) goto L17;
        uninstalledAppStates.remove(i);
        if (uninstalledAppStates.isEmpty() == false) goto L17;
        this.mUninstalledInstantApps.remove(userId);
        onChanged();
        return;
    L17:
        i = i - 1;
        goto L9
    }

    private boolean hasUninstalledInstantAppState(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mUninstalledInstantApps != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        List<UninstalledInstantAppState> uninstalledAppStates = this.mUninstalledInstantApps.get(userId);     // Catch: Throwable -> L8
        if (uninstalledAppStates != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L14:
        int appCount = uninstalledAppStates.size();     // Catch: Throwable -> L8
        int i = 0;
    L15:
        if (i >= appCount) goto L23;
        UninstalledInstantAppState uninstalledAppState = uninstalledAppStates.get(i);     // Catch: Throwable -> L8
        if (packageName.equals(uninstalledAppState.mInstantAppInfo.getPackageName()) == true) goto L18;
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    private boolean hasInstantAppMetadata(String packageName, int userId) {
        File instantAppDir = getInstantApplicationDir(packageName, userId);
        if (new File(instantAppDir, INSTANT_APP_METADATA_FILE).exists() == false) goto L5;
    L12:
        return true;
    L5:
        if (new File(instantAppDir, INSTANT_APP_ICON_FILE).exists() == true) goto L12;
        if (new File(instantAppDir, INSTANT_APP_ANDROID_ID_FILE).exists() == true) goto L12;
        if (peekInstantCookieFile(packageName, userId) != null) goto L12;
        return false;
    }

    void pruneInstantApps(Computer computer) {
        long maxInstalledCacheDuration = android.provider.Settings.Global.getLong(this.mContext.getContentResolver(), "installed_instant_app_max_cache_period", 15552000000L);
        long maxUninstalledCacheDuration = android.provider.Settings.Global.getLong(this.mContext.getContentResolver(), "uninstalled_instant_app_max_cache_period", 15552000000L);
        pruneInstantApps(computer, Long.MAX_VALUE, maxInstalledCacheDuration, maxUninstalledCacheDuration);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, "Error pruning installed and uninstalled instant apps", e);
    }

    boolean pruneInstalledInstantApps(Computer computer, long neededSpace, long maxInstalledCacheDuration) {
        return pruneInstantApps(computer, neededSpace, maxInstalledCacheDuration, Long.MAX_VALUE);
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, "Error pruning installed instant apps", e);
        return false;
    }

    boolean pruneUninstalledInstantApps(Computer computer, long neededSpace, long maxUninstalledCacheDuration) {
        return pruneInstantApps(computer, neededSpace, Long.MAX_VALUE, maxUninstalledCacheDuration);
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, "Error pruning uninstalled instant apps", e);
        return false;
    }

    private boolean pruneInstantApps(Computer computer, long neededSpace, long maxInstalledCacheDuration, final long maxUninstalledCacheDuration) throws IOException {
        InstantAppRegistry r1 = this;
        StorageManager storage = (StorageManager) r1.mContext.getSystemService(StorageManager.class);
        File file = storage.findPathForUuid(StorageManager.UUID_PRIVATE_INTERNAL);
        if (file.getUsableSpace() < neededSpace) goto L5;
        return true;
    L5:
        long now = System.currentTimeMillis();
        int[] allUsers = r1.mUserManager.getUserIds();
        final ArrayMap<String, ? extends PackageStateInternal> packageStates = computer.getPackageStates();
        int packageStateCount = packageStates.size();
        List<String> packagesToDelete = null;
        int i = 0;
    L6:
        if (i >= packageStateCount) goto L32;
        PackageStateInternal ps = packageStates.valueAt(i);
        if (ps != null) goto L10;
        AndroidPackage pkg = null;
    L11:
        if (pkg != null) goto L14;
        int i2 = i;
    L30:
        i = i2 + 1;
        goto L6
    L14:
        if ((now - ps.getTransientState().getLatestPackageUseTimeInMills()) >= maxInstalledCacheDuration) goto L16;
        i2 = i;
        goto L30
    L16:
        boolean installedOnlyAsInstantApp = false;
        int r13 = allUsers.length;
        int r6 = 0;
    L17:
        if (r6 >= r13) goto L25;
        i2 = i;
        int i3 = allUsers[r6];
        PackageUserStateInternal userState = ps.getUserStateOrDefault(i3);
        if (userState.isInstalled() == false) goto L24;
        if (userState.isInstantApp() == false) goto L23;
        installedOnlyAsInstantApp = true;
        goto L24
    L23:
        installedOnlyAsInstantApp = false;
    L26:
        if (installedOnlyAsInstantApp == false) goto L30;
        if (packagesToDelete != null) goto L29;
        packagesToDelete = new ArrayList();
    L29:
        packagesToDelete.add(pkg.getPackageName());
    L24:
        r6 = r6 + 1;
        i = i2;
        goto L17
    L25:
        i2 = i;
        goto L26
    L10:
        pkg = ps.getPkg();
        goto L11
    L32:
        if (packagesToDelete == null) goto L34;
        packagesToDelete.sort(new InstantAppRegistry$$ExternalSyntheticLambda2(packageStates));
    L34:
        if (packagesToDelete == null) goto L43;
        int packageCount = packagesToDelete.size();
        int i4 = 0;
    L36:
        if (i4 >= packageCount) goto L43;
        String packageToDelete = packagesToDelete.get(i4);
        if (r1.mDeletePackageHelper.deletePackageX(packageToDelete, -1, 0, 2, true) != 1) goto L42;
        if (file.getUsableSpace() < neededSpace) goto L42;
        return true;
    L42:
        i4 = i4 + 1;
    L43:
        Object r7 = r1.mLock;
        monitor-enter(r7);
        int[] r0 = r1.mUserManager.getUserIds();     // Catch: Throwable -> L68
        int r14 = r0.length;     // Catch: Throwable -> L68
        int r15 = 0;
    L46:
        if (r15 >= r14) goto L75;
        int userId = r0[r15];     // Catch: Throwable -> L68
        int[] r16 = r0;
        r1.removeUninstalledInstantAppStateLPw(new InstantAppRegistry$$ExternalSyntheticLambda3(maxUninstalledCacheDuration), userId);     // Catch: Throwable -> L68
        File instantAppsDir = getInstantApplicationsDir(userId);     // Catch: Throwable -> L68
        if (instantAppsDir.exists() == false) goto L74;
        File[] files = instantAppsDir.listFiles();     // Catch: Throwable -> L68
        if (files == null) goto L74;
        int r2 = files.length;     // Catch: Throwable -> L68
        int r3 = 0;
    L54:
        if (r3 >= r2) goto L74;
        File instantDir = files[r3];     // Catch: Throwable -> L68
        if (instantDir.isDirectory() == true) goto L58;
        int r21 = r3;
        int r23 = r2;
    L72:
        r3 = r21 + 1;     // Catch: Throwable -> L68
        r2 = r23;
        goto L54
    L58:
        r21 = r3;
        r23 = r2;
        File metadataFile = new File(instantDir, INSTANT_APP_METADATA_FILE);     // Catch: Throwable -> L68
        if (metadataFile.exists() == false) goto L72;
        long elapsedCachingMillis = System.currentTimeMillis() - metadataFile.lastModified();     // Catch: Throwable -> L68
        if (elapsedCachingMillis <= maxUninstalledCacheDuration) goto L72;
        deleteDir(instantDir);     // Catch: Throwable -> L68
        if (file.getUsableSpace() < neededSpace) goto L72;
        monitor-exit(r7);     // Catch: Throwable -> L68
        return true;
    L74:
        r15 = r15 + 1;     // Catch: Throwable -> L68
        r1 = this;
        r0 = r16;
        goto L46
    L75:
        monitor-exit(r7);     // Catch: Throwable -> L68
        return false;
    L68:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ int lambda$pruneInstantApps$2(ArrayMap packageStates, String lhs, String rhs) {
        PackageStateInternal lhsPkgState = (PackageStateInternal) packageStates.get(lhs);
        PackageStateInternal rhsPkgState = (PackageStateInternal) packageStates.get(rhs);
        AndroidPackageInternal r2 = null;
        if (lhsPkgState != null) goto L5;
        AndroidPackage lhsPkg = null;
    L6:
        if (rhsPkgState == null) goto L10;
        r2 = rhsPkgState.getPkg();
    L10:
        if (lhsPkg != null) goto L14;
        if (r2 != null) goto L14;
        return 0;
    L14:
        if (lhsPkg != null) goto L17;
        return -1;
    L17:
        if (r2 != null) goto L19;
        return 1;
    L19:
        PackageStateInternal lhsPs = (PackageStateInternal) packageStates.get(lhsPkg.getPackageName());
        if (lhsPs != null) goto L22;
        return 0;
    L22:
        PackageStateInternal rhsPs = (PackageStateInternal) packageStates.get(r2.getPackageName());
        if (rhsPs != null) goto L26;
        return 0;
    L26:
        if (lhsPs.getTransientState().getLatestPackageUseTimeInMills() <= rhsPs.getTransientState().getLatestPackageUseTimeInMills()) goto L29;
        return 1;
    L29:
        if (lhsPs.getTransientState().getLatestPackageUseTimeInMills() >= rhsPs.getTransientState().getLatestPackageUseTimeInMills()) goto L32;
        return -1;
    L32:
        if (PackageStateUtils.getEarliestFirstInstallTime(lhsPs.getUserStates()) <= PackageStateUtils.getEarliestFirstInstallTime(rhsPs.getUserStates())) goto L34;
        return 1;
    L34:
        return -1;
    L5:
        lhsPkg = lhsPkgState.getPkg();
        goto L6
    }

    private static /* synthetic */ boolean lambda$pruneInstantApps$3(long maxUninstalledCacheDuration, UninstalledInstantAppState state) {
        long elapsedCachingMillis = System.currentTimeMillis() - state.mTimestamp;
        if (elapsedCachingMillis <= maxUninstalledCacheDuration) goto L5;
        return true;
    L5:
        return false;
    }

    private List<InstantAppInfo> getInstalledInstantApplications(Computer computer, int userId) {
        List<InstantAppInfo> result = null;
        ArrayMap<String, ? extends PackageStateInternal> packageStates = computer.getPackageStates();
        int packageCount = packageStates.size();
        int i = 0;
    L3:
        if (i >= packageCount) goto L17;
        PackageStateInternal ps = packageStates.valueAt(i);
        if (ps == null) goto L15;
        if (ps.getUserStateOrDefault(userId).isInstantApp() == false) goto L15;
        InstantAppInfo info = createInstantAppInfoForPackage(ps, userId, true);
        if (info == null) goto L15;
        if (result != null) goto L14;
        result = new ArrayList();
    L14:
        result.add(info);
    L15:
        i = i + 1;
        goto L3
    L17:
        return result;
    }

    private InstantAppInfo createInstantAppInfoForPackage(PackageStateInternal ps, int userId, boolean addApplicationInfo) {
        AndroidPackageInternal r0 = ps.getPkg();
        if (r0 == null) goto L14;
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L16;
        String[] requestedPermissions = new String[r0.getRequestedPermissions().size()];
        r0.getRequestedPermissions().toArray(requestedPermissions);
        Set<String> permissions = this.mPermissionManager.getGrantedPermissions(r0.getPackageName(), userId);
        String[] grantedPermissions = new String[permissions.size()];
        permissions.toArray(grantedPermissions);
        ApplicationInfo appInfo = PackageInfoUtils.generateApplicationInfo(ps.getPkg(), 0, ps.getUserStateOrDefault(userId), userId, ps);
        if (addApplicationInfo == false) goto L12;
        return new InstantAppInfo(appInfo, requestedPermissions, grantedPermissions);
    L12:
        return new InstantAppInfo(appInfo.packageName, appInfo.loadLabel(this.mContext.getPackageManager()), requestedPermissions, grantedPermissions);
    L16:
        return null;
    L14:
        return null;
    }

    private List<InstantAppInfo> getUninstalledInstantApplications(Computer computer, int userId) {
        List<UninstalledInstantAppState> uninstalledAppStates = getUninstalledInstantAppStates(userId);
        if (uninstalledAppStates != null) goto L5;
        return null;
    L5:
        if (uninstalledAppStates.isEmpty() == true) goto L20;
        List<InstantAppInfo> uninstalledApps = null;
        int stateCount = uninstalledAppStates.size();
        int i = 0;
    L8:
        if (i >= stateCount) goto L14;
        UninstalledInstantAppState uninstalledAppState = uninstalledAppStates.get(i);
        if (uninstalledApps != null) goto L12;
        uninstalledApps = new ArrayList();
    L12:
        uninstalledApps.add(uninstalledAppState.mInstantAppInfo);
        i = i + 1;
        goto L8
    L14:
        return uninstalledApps;
    L20:
        return null;
    }

    private void propagateInstantAppPermissionsIfNeeded(AndroidPackage pkg, int userId) {
        InstantAppInfo appInfo = peekOrParseUninstalledInstantAppInfo(pkg.getPackageName(), userId);
        if (appInfo != null) goto L6;
        return;
    L6:
        if (ArrayUtils.isEmpty(appInfo.getGrantedPermissions()) == false) goto L8;
        return;
    L8:
        long identity = Binder.clearCallingIdentity();
        String[] r3 = appInfo.getGrantedPermissions();     // Catch: Throwable -> L17
        int r4 = r3.length;     // Catch: Throwable -> L17
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L20;
        String grantedPermission = r3[r5];     // Catch: Throwable -> L17
        boolean propagatePermission = canPropagatePermission(grantedPermission);     // Catch: Throwable -> L17
        if (propagatePermission == false) goto L19;
        if (pkg.getRequestedPermissions().contains(grantedPermission) == false) goto L19;
        ((PermissionManager) this.mContext.getSystemService(PermissionManager.class)).grantRuntimePermission(pkg.getPackageName(), grantedPermission, UserHandle.of(userId));     // Catch: Throwable -> L17
    L19:
        r5 = r5 + 1;
        goto L10
    L20:
        Binder.restoreCallingIdentity(identity);
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean canPropagatePermission(String permissionName) {
        PermissionManager permissionManager = (PermissionManager) this.mContext.getSystemService(PermissionManager.class);
        PermissionInfo permissionInfo = permissionManager.getPermissionInfo(permissionName, 0);
        if (permissionInfo != null) goto L5;
        return false;
    L5:
        if (permissionInfo.getProtection() == 1) goto L9;
        if ((permissionInfo.getProtectionFlags() & 32) != 0) goto L9;
        return false;
    L9:
        if ((permissionInfo.getProtectionFlags() & 4096) != 0) goto L12;
        return false;
    L12:
        return true;
    }

    private InstantAppInfo peekOrParseUninstalledInstantAppInfo(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mUninstalledInstantApps == null) goto L18;
        List<UninstalledInstantAppState> uninstalledAppStates = this.mUninstalledInstantApps.get(userId);     // Catch: Throwable -> L15
        if (uninstalledAppStates == null) goto L18;
        int appCount = uninstalledAppStates.size();     // Catch: Throwable -> L15
        int i = 0;
    L9:
        if (i >= appCount) goto L18;
        UninstalledInstantAppState uninstalledAppState = uninstalledAppStates.get(i);     // Catch: Throwable -> L15
        if (uninstalledAppState.mInstantAppInfo.getPackageName().equals(packageName) == true) goto L12;
        i = i + 1;     // Catch: Throwable -> L15
        goto L9
    L12:
        InstantAppInfo r5 = uninstalledAppState.mInstantAppInfo;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r5;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        File metadataFile = new File(getInstantApplicationDir(packageName, userId), INSTANT_APP_METADATA_FILE);
        UninstalledInstantAppState uninstalledAppState2 = parseMetadataFile(metadataFile);
        if (uninstalledAppState2 != null) goto L24;
        return null;
    L24:
        return uninstalledAppState2.mInstantAppInfo;
    }

    private List<UninstalledInstantAppState> getUninstalledInstantAppStates(int userId) {
        List<UninstalledInstantAppState> uninstalledAppStates = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mUninstalledInstantApps == null) goto L12;
        uninstalledAppStates = this.mUninstalledInstantApps.get(userId);     // Catch: Throwable -> L10
        if (uninstalledAppStates == null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return uninstalledAppStates;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        File instantAppsDir = getInstantApplicationsDir(userId);
        if (instantAppsDir.exists() == false) goto L31;
        File[] files = instantAppsDir.listFiles();
        if (files == null) goto L31;
        int r3 = files.length;
        int r4 = 0;
    L19:
        if (r4 >= r3) goto L30;
        File instantDir = files[r4];
        if (instantDir.isDirectory() == false) goto L29;
        File metadataFile = new File(instantDir, INSTANT_APP_METADATA_FILE);
        UninstalledInstantAppState uninstalledAppState = parseMetadataFile(metadataFile);
        if (uninstalledAppState == null) goto L29;
        if (uninstalledAppStates != null) goto L28;
        uninstalledAppStates = new ArrayList();
    L28:
        uninstalledAppStates.add(uninstalledAppState);
    L29:
        r4 = r4 + 1;
        goto L19
    L30:
        List<UninstalledInstantAppState> uninstalledAppStates2 = uninstalledAppStates;
    L32:
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mUninstalledInstantApps.put(userId, uninstalledAppStates2);     // Catch: Throwable -> L37
        monitor-exit(r5);     // Catch: Throwable -> L37
        return uninstalledAppStates2;
    L37:
        th = move-exception;
        throw th;
    L31:
        uninstalledAppStates2 = uninstalledAppStates;
        goto L32
    }

    private static UninstalledInstantAppState parseMetadataFile(File metadataFile) {
        if (metadataFile.exists() == true) goto L20;
        return null;
    L20:
        FileInputStream in = new AtomicFile(metadataFile).openRead();     // Catch: FileNotFoundException -> L17
        File instantDir = metadataFile.getParentFile();
        long timestamp = metadataFile.lastModified();
        String packageName = instantDir.getName();
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L10 Throwable -> L12
        UninstalledInstantAppState r6 = new UninstalledInstantAppState(parseMetadata(parser, packageName), timestamp);     // Catch: Throwable -> L10 Throwable -> L12
        IoUtils.closeQuietly(in);
        return r6;
    L12:
        e = move-exception;
        throw new IllegalStateException("Failed parsing instant metadata file: " + metadataFile, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        IoUtils.closeQuietly(in);
        throw th;
    L18:
        Slog.i(LOG_TAG, "No instant metadata file");
        return null;
    }

    private static File computeInstantCookieFile(String packageName, String sha256Digest, int userId) {
        File appDir = getInstantApplicationDir(packageName, userId);
        String cookieFile = INSTANT_APP_COOKIE_FILE_PREFIX + sha256Digest + INSTANT_APP_COOKIE_FILE_SIFFIX;
        return new File(appDir, cookieFile);
    }

    private static File peekInstantCookieFile(String packageName, int userId) {
        File appDir = getInstantApplicationDir(packageName, userId);
        if (appDir.exists() == true) goto L5;
        return null;
    L5:
        File[] files = appDir.listFiles();
        if (files != null) goto L8;
        return null;
    L8:
        int r3 = files.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L18;
        File file = files[r4];
        if (file.isDirectory() == true) goto L17;
        if (file.getName().startsWith(INSTANT_APP_COOKIE_FILE_PREFIX) == false) goto L17;
        if (file.getName().endsWith(INSTANT_APP_COOKIE_FILE_SIFFIX) == false) goto L17;
        return file;
    L17:
        r4 = r4 + 1;
        goto L9
    L18:
        return null;
    }

    private static InstantAppInfo parseMetadata(TypedXmlPullParser parser, String packageName) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L9;
        if ("package".equals(parser.getName()) == false) goto L4;
        return parsePackage(parser, packageName);
    L9:
        return null;
    }

    private static InstantAppInfo parsePackage(TypedXmlPullParser parser, String packageName) throws IOException, XmlPullParserException {
        String label = parser.getAttributeValue(null, ATTR_LABEL);
        List<String> outRequestedPermissions = new ArrayList();
        List<String> outGrantedPermissions = new ArrayList();
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L8;
        if (TAG_PERMISSIONS.equals(parser.getName()) == false) goto L4;
        parsePermissions(parser, outRequestedPermissions, outGrantedPermissions);
        goto L4
    L8:
        String[] requestedPermissions = new String[outRequestedPermissions.size()];
        outRequestedPermissions.toArray(requestedPermissions);
        String[] grantedPermissions = new String[outGrantedPermissions.size()];
        outGrantedPermissions.toArray(grantedPermissions);
        return new InstantAppInfo(packageName, label, requestedPermissions, grantedPermissions);
    }

    private static void parsePermissions(TypedXmlPullParser parser, List<String> outRequestedPermissions, List<String> outGrantedPermissions) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L11;
        if (TAG_PERMISSION.equals(parser.getName()) == false) goto L4;
        String permission = XmlUtils.readStringAttribute(parser, "name");
        outRequestedPermissions.add(permission);
        if (parser.getAttributeBoolean(null, ATTR_GRANTED, false) == false) goto L4;
        outGrantedPermissions.add(permission);
        goto L4
    }

    private void writeUninstalledInstantAppMetadata(InstantAppInfo instantApp, int userId) {
        File appDir = getInstantApplicationDir(instantApp.getPackageName(), userId);
        if (appDir.exists() == false) goto L5;
    L7:
        File metadataFile = new File(appDir, INSTANT_APP_METADATA_FILE);
        AtomicFile destination = new AtomicFile(metadataFile);
        FileOutputStream out = null;
        out = destination.startWrite();     // Catch: Throwable -> L29
        TypedXmlSerializer serializer = Xml.resolveSerializer(out);     // Catch: Throwable -> L29
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L29
        serializer.startDocument(null, true);     // Catch: Throwable -> L29
        serializer.startTag(null, "package");     // Catch: Throwable -> L29
        serializer.attribute(null, ATTR_LABEL, instantApp.loadLabel(this.mContext.getPackageManager()).toString());     // Catch: Throwable -> L23
        serializer.startTag(null, TAG_PERMISSIONS);     // Catch: Throwable -> L23
        String[] r9 = instantApp.getRequestedPermissions();     // Catch: Throwable -> L23
        int r13 = r9.length;     // Catch: Throwable -> L23
        int r15 = 0;
    L13:
        if (r15 >= r13) goto L25;
        String permission = r9[r15];     // Catch: Throwable -> L23
        serializer.startTag(null, TAG_PERMISSION);     // Catch: Throwable -> L23
        File appDir2 = appDir;
        serializer.attribute(null, "name", permission);     // Catch: Throwable -> L19
        if (ArrayUtils.contains(instantApp.getGrantedPermissions(), permission) == false) goto L21;
        boolean r3 = true;
        serializer.attributeBoolean(null, ATTR_GRANTED, true);     // Catch: Throwable -> L19
    L22:
        serializer.endTag(null, TAG_PERMISSION);     // Catch: Throwable -> L19
        r15 = r15 + 1;     // Catch: Throwable -> L19
        appDir = appDir2;
        goto L13
    L21:
        r3 = true;
    L19:
        t = th;
    L42:
        Slog.wtf(LOG_TAG, "Failed to write instant state, restoring backup", t);     // Catch: Throwable -> L35
        destination.failWrite(out);     // Catch: Throwable -> L35
    L26:
        IoUtils.closeQuietly(out);
        return;
    L35:
        th = move-exception;
        IoUtils.closeQuietly(out);
        throw th;
    L25:
        serializer.endTag(null, TAG_PERMISSIONS);     // Catch: Throwable -> L19
        serializer.endTag(null, "package");     // Catch: Throwable -> L19
        serializer.endDocument();     // Catch: Throwable -> L19
        destination.finishWrite(out);     // Catch: Throwable -> L19
    L23:
        t = th;
    L27:
        t = th;
    L29:
        t = th;
        goto L42
    L5:
        if (appDir.mkdirs() == true) goto L7;
    }

    private static File getInstantApplicationsDir(int userId) {
        return new File(Environment.getUserSystemDirectory(userId), INSTANT_APPS_FOLDER);
    }

    private static File getInstantApplicationDir(String packageName, int userId) {
        return new File(getInstantApplicationsDir(userId), packageName);
    }

    private static void deleteDir(File dir) {
        File[] files = dir.listFiles();
        if (files == null) goto L8;
        int r1 = files.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        File file = files[r2];
        deleteDir(file);
        r2 = r2 + 1;
    L8:
        dir.delete();
    }
}
