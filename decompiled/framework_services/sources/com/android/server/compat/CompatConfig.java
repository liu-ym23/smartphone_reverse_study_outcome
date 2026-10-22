package com.android.server.compat;

import android.app.compat.ChangeIdStateCache;
import android.app.compat.PackageOverride;
import android.compat.Compatibility;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.LongArray;
import android.util.Slog;
import com.android.internal.compat.AndroidBuildClassifier;
import com.android.internal.compat.CompatibilityChangeConfig;
import com.android.internal.compat.CompatibilityChangeInfo;
import com.android.internal.compat.CompatibilityOverrideConfig;
import com.android.internal.compat.CompatibilityOverridesByPackageConfig;
import com.android.internal.compat.CompatibilityOverridesToRemoveByPackageConfig;
import com.android.internal.compat.CompatibilityOverridesToRemoveConfig;
import com.android.internal.compat.IOverrideValidator;
import com.android.internal.compat.OverrideAllowedState;
import com.android.internal.ravenwood.RavenwoodEnvironment;
import com.android.server.compat.config.Change;
import com.android.server.compat.config.Config;
import com.android.server.compat.config.XmlParser;
import com.android.server.compat.overrides.ChangeOverrides;
import com.android.server.compat.overrides.Overrides;
import com.android.server.compat.overrides.XmlWriter;
import com.android.server.pm.ApexManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
final class CompatConfig {
    private static final String APP_COMPAT_DATA_DIR = "/data/misc/appcompat";
    private static final String APP_COMPAT_DATA_DIR_RAVENWOOD = "/ravenwood-data/";
    private static final String OVERRIDES_FILE = "compat_framework_overrides.xml";
    private static final String OVERRIDES_FILE_RAVENWOOD = "compat-config.xml";
    private static final String STATIC_OVERRIDES_PRODUCT_DIR = "/product/etc/appcompat";
    private static final String TAG = "CompatConfig";
    private final AndroidBuildClassifier mAndroidBuildClassifier;
    private File mBackupOverridesFile;
    private final ConcurrentHashMap<Long, CompatChange> mChanges;
    private Context mContext;
    private final OverrideValidatorImpl mOverrideValidator;
    private File mOverridesFile;
    private final Object mOverridesFileLock;

    /* JADX INFO: renamed from: $r8$lambda$C1SLw-dqL7ekU-66P5SJ6ti6DZY, reason: not valid java name */
    public static /* synthetic */ CompatChange m3037$r8$lambda$C1SLwdqL7ekU66P5SJ6ti6DZY(CompatConfig r0, AtomicBoolean r1, long r2, Long r4) {
        return r0.lambda$registerListener$2(r1, r2, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$L7PqG_mk54F9sDPy8oXSEGha7NM(File r0) {
        return lambda$loadConfigFiles$ravenwood$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$RmVydZyosIBjprfsjXCOUcqARPw(File r0) {
        return lambda$initConfigFromLib$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$UU-PU-AnQuTIJeABebic5M59hFg, reason: not valid java name */
    public static /* synthetic */ CompatChange m3038$r8$lambda$UUPUAnQuTIJeABebic5M59hFg(AtomicBoolean r0, long r1, Long r3) {
        return lambda$addOverrideUnsafe$1(r0, r1, r3);
    }

    CompatConfig(AndroidBuildClassifier androidBuildClassifier, Context context) {
        this.mChanges = new ConcurrentHashMap();
        this.mOverridesFileLock = new Object();
        this.mOverrideValidator = new OverrideValidatorImpl(androidBuildClassifier, context, this);
        this.mAndroidBuildClassifier = androidBuildClassifier;
        this.mContext = context;
    }

    static CompatConfig create(AndroidBuildClassifier androidBuildClassifier, Context context) {
        CompatConfig config = new CompatConfig(androidBuildClassifier, context);
        config.loadConfigFiles();
        config.initOverrides();
        config.invalidateCache();
        return config;
    }

    private void loadConfigFiles() {
        initConfigFromLib(Environment.buildPath(Environment.getRootDirectory(), new String[]{"etc", "compatconfig"}));
        initConfigFromLib(Environment.buildPath(Environment.getRootDirectory(), new String[]{"system_ext", "etc", "compatconfig"}));
        List<ApexManager.ActiveApexInfo> apexes = ApexManager.getInstance().getActiveApexInfos();
        Iterator<ApexManager.ActiveApexInfo> r3 = apexes.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ApexManager.ActiveApexInfo apex = r3.next();
        initConfigFromLib(Environment.buildPath(apex.apexDirectory, new String[]{"etc", "compatconfig"}));
        goto L4
    }

    private void loadConfigFiles$ravenwood() {
        File configDir = new File(RavenwoodEnvironment.getInstance().getRavenwoodRuntimePath() + APP_COMPAT_DATA_DIR_RAVENWOOD);
        initConfigFromLib(configDir, new CompatConfig$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ boolean lambda$loadConfigFiles$ravenwood$0(File file) {
        return file.getName().endsWith(OVERRIDES_FILE_RAVENWOOD);
    }

    void addChange(CompatChange change) {
        this.mChanges.put(Long.valueOf(change.getId()), change);
    }

    long[] getDisabledChanges(ApplicationInfo app) {
        LongArray disabled = new LongArray();
        Iterator<CompatChange> r1 = this.mChanges.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        CompatChange c = r1.next();
        if (c.isEnabled(app, this.mAndroidBuildClassifier) == true) goto L4;
        disabled.add(c.getId());
        goto L4
    L9:
        long[] sortedChanges = disabled.toArray();
        Arrays.sort(sortedChanges);
        return sortedChanges;
    }

    long[] getLoggableChanges(ApplicationInfo app) {
        LongArray loggable = new LongArray(this.mChanges.size());
        Iterator<CompatChange> r1 = this.mChanges.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        CompatChange c = r1.next();
        long changeId = c.getId();
        boolean isLatestSdk = isChangeTargetingLatestSdk(c, app.targetSdkVersion);
        if (c.isEnabled(app, this.mAndroidBuildClassifier) == false) goto L4;
        if (isLatestSdk == false) goto L4;
        loggable.add(changeId);
        goto L4
    L10:
        long[] sortedChanges = loggable.toArray();
        Arrays.sort(sortedChanges);
        return sortedChanges;
    }

    boolean isChangeTargetingLatestSdk(CompatChange c, int appSdkVersion) {
        int maxTargetSdk = maxTargetSdkForCompatChange(c) + 1;
        if (maxTargetSdk > 0) goto L6;
        return false;
    L6:
        if (maxTargetSdk == 10000) goto L11;
        if (maxTargetSdk != appSdkVersion) goto L10;
        return true;
    L10:
        return false;
    L11:
        return true;
    }

    CompatChange getCompatChange(long changeId) {
        return this.mChanges.get(Long.valueOf(changeId));
    }

    long lookupChangeId(String name) {
        Iterator<CompatChange> r0 = this.mChanges.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CompatChange c = r0.next();
        if (TextUtils.equals(c.getName(), name) == false) goto L4;
        return c.getId();
    L10:
        return -1;
    }

    boolean isChangeEnabled(long changeId, ApplicationInfo app) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        return isChangeEnabled(c, app);
    }

    boolean isChangeEnabled(CompatChange c, ApplicationInfo app) {
        if (c != null) goto L6;
        return true;
    L6:
        return c.isEnabled(app, this.mAndroidBuildClassifier);
    }

    boolean willChangeBeEnabled(long changeId, String packageName) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        if (c != null) goto L7;
        return true;
    L7:
        return c.willBeEnabled(packageName);
    }

    synchronized boolean addOverride(long changeId, String packageName, boolean enabled) {
        monitor-enter(this);
        boolean alreadyKnown = addOverrideUnsafe(changeId, packageName, new PackageOverride.Builder().setEnabled(enabled).build());     // Catch: Throwable -> L6
        saveOverrides();     // Catch: Throwable -> L6
        invalidateCache();     // Catch: Throwable -> L6
        monitor-exit(this);
        return alreadyKnown;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void addAllPackageOverrides(CompatibilityOverridesByPackageConfig overridesByPackage, boolean skipUnknownChangeIds) {
        monitor-enter(this);
        Iterator r0 = overridesByPackage.packageNameToOverrides.keySet().iterator();     // Catch: Throwable -> L7
    L5:
        if (r0.hasNext() == false) goto L9;
        String packageName = (String) r0.next();     // Catch: Throwable -> L7
        addPackageOverridesWithoutSaving((CompatibilityOverrideConfig) overridesByPackage.packageNameToOverrides.get(packageName), packageName, skipUnknownChangeIds);     // Catch: Throwable -> L7
        goto L5
    L9:
        saveOverrides();     // Catch: Throwable -> L7
        invalidateCache();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void addPackageOverrides(CompatibilityOverrideConfig overrides, String packageName, boolean skipUnknownChangeIds) {
        monitor-enter(this);
        addPackageOverridesWithoutSaving(overrides, packageName, skipUnknownChangeIds);     // Catch: Throwable -> L6
        saveOverrides();     // Catch: Throwable -> L6
        invalidateCache();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void addPackageOverridesWithoutSaving(CompatibilityOverrideConfig overrides, String packageName, boolean skipUnknownChangeIds) {
        Iterator r0 = overrides.overrides.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Long changeId = (Long) r0.next();
        if (skipUnknownChangeIds == false) goto L10;
        if (isKnownChangeId(changeId.longValue()) == true) goto L10;
        Slog.w(TAG, "Trying to add overrides for unknown Change ID " + changeId + ". Skipping Change ID.");
    L10:
        addOverrideUnsafe(changeId.longValue(), packageName, (PackageOverride) overrides.overrides.get(changeId));
        goto L4
    }

    private boolean addOverrideUnsafe(final long changeId, String packageName, PackageOverride overrides) {
        final AtomicBoolean alreadyKnown = new AtomicBoolean(true);
        OverrideAllowedState allowedState = this.mOverrideValidator.getOverrideAllowedState(changeId, packageName);
        allowedState.enforce(changeId, packageName);
        Long versionCode = getVersionCodeOrNull(packageName);
        CompatChange c = this.mChanges.computeIfAbsent(Long.valueOf(changeId), new CompatConfig$$ExternalSyntheticLambda0(alreadyKnown, changeId));
        c.addPackageOverride(packageName, overrides, allowedState, versionCode);
        StringBuilder r4 = new StringBuilder();
        if (overrides.isEnabled() == false) goto L5;
        String r5 = "Enabled";
    L6:
        r4.append(r5);
        r4.append(" change ");
        r4.append(changeId);
        if (c.getName() == null) goto L9;
        String r6 = " [" + c.getName() + "]";
    L10:
        r4.append(r6);
        r4.append(" for ");
        r4.append(packageName);
        Slog.d(TAG, r4.toString());
        invalidateCache();
        return alreadyKnown.get();
    L9:
        r6 = "";
        goto L10
    L5:
        r5 = "Disabled";
        goto L6
    }

    private static /* synthetic */ CompatChange lambda$addOverrideUnsafe$1(AtomicBoolean alreadyKnown, long changeId, Long key) {
        alreadyKnown.set(false);
        return new CompatChange(changeId);
    }

    boolean isKnownChangeId(long changeId) {
        return this.mChanges.containsKey(Long.valueOf(changeId));
    }

    int maxTargetSdkForChangeIdOptIn(long changeId) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        return maxTargetSdkForCompatChange(c);
    }

    int maxTargetSdkForCompatChange(CompatChange c) {
        if (c != null) goto L5;
    L8:
        return -1;
    L5:
        if (c.getEnableSinceTargetSdk() == (-1)) goto L8;
        return c.getEnableSinceTargetSdk() - 1;
    }

    boolean isLoggingOnly(long changeId) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        if (c != null) goto L5;
    L7:
        return false;
    L5:
        if (c.getLoggingOnly() == false) goto L7;
        return true;
    }

    boolean isDisabled(long changeId) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        if (c != null) goto L5;
    L7:
        return false;
    L5:
        if (c.getDisabled() == false) goto L7;
        return true;
    }

    boolean isOverridable(long changeId) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        if (c != null) goto L5;
    L7:
        return false;
    L5:
        if (c.getOverridable() == false) goto L7;
        return true;
    }

    synchronized boolean removeOverride(long changeId, String packageName) {
        monitor-enter(this);
        boolean overrideExists = removeOverrideUnsafe(changeId, packageName);     // Catch: Throwable -> L7
        if (overrideExists == false) goto L9;
        saveOverrides();     // Catch: Throwable -> L7
        invalidateCache();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return overrideExists;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean removeOverrideUnsafe(long changeId, String packageName) {
        Long versionCode = getVersionCodeOrNull(packageName);
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        if (c != null) goto L5;
        return false;
    L5:
        return removeOverrideUnsafe(c, packageName, versionCode);
    }

    private boolean removeOverrideUnsafe(CompatChange change, String packageName, Long versionCode) {
        long changeId = change.getId();
        OverrideAllowedState allowedState = this.mOverrideValidator.getOverrideAllowedState(changeId, packageName);
        boolean overrideExists = change.removePackageOverride(packageName, allowedState, versionCode);
        if (overrideExists == false) goto L9;
        StringBuilder r4 = new StringBuilder();
        r4.append("Reset change ");
        r4.append(changeId);
        if (change.getName() == null) goto L7;
        String r5 = " [" + change.getName() + "]";
    L8:
        r4.append(r5);
        r4.append(" for ");
        r4.append(packageName);
        r4.append(" to default value.");
        Slog.d(TAG, r4.toString());
        goto L9
    L7:
        r5 = "";
    L9:
        return overrideExists;
    }

    synchronized void removeAllPackageOverrides(CompatibilityOverridesToRemoveByPackageConfig overridesToRemoveByPackage) {
        monitor-enter(this);
        boolean shouldInvalidateCache = false;
        Iterator r1 = overridesToRemoveByPackage.packageNameToOverridesToRemove.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        String packageName = (String) r1.next();     // Catch: Throwable -> L8
        shouldInvalidateCache = shouldInvalidateCache | removePackageOverridesWithoutSaving((CompatibilityOverridesToRemoveConfig) overridesToRemoveByPackage.packageNameToOverridesToRemove.get(packageName), packageName);     // Catch: Throwable -> L8
        goto L6
    L10:
        if (shouldInvalidateCache == false) goto L12;
        saveOverrides();     // Catch: Throwable -> L8
        invalidateCache();     // Catch: Throwable -> L8
    L12:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void removePackageOverrides(String packageName) {
        monitor-enter(this);
        Long versionCode = getVersionCodeOrNull(packageName);     // Catch: Throwable -> L7
        boolean shouldInvalidateCache = false;
        Iterator<CompatChange> r2 = this.mChanges.values().iterator();     // Catch: Throwable -> L7
    L5:
        if (r2.hasNext() == false) goto L9;
        CompatChange change = r2.next();     // Catch: Throwable -> L7
        shouldInvalidateCache = shouldInvalidateCache | removeOverrideUnsafe(change, packageName, versionCode);     // Catch: Throwable -> L7
        goto L5
    L9:
        if (shouldInvalidateCache == false) goto L11;
        saveOverrides();     // Catch: Throwable -> L7
        invalidateCache();     // Catch: Throwable -> L7
    L11:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void removePackageOverrides(CompatibilityOverridesToRemoveConfig overridesToRemove, String packageName) {
        monitor-enter(this);
        boolean shouldInvalidateCache = removePackageOverridesWithoutSaving(overridesToRemove, packageName);     // Catch: Throwable -> L7
        if (shouldInvalidateCache == false) goto L9;
        saveOverrides();     // Catch: Throwable -> L7
        invalidateCache();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean removePackageOverridesWithoutSaving(CompatibilityOverridesToRemoveConfig overridesToRemove, String packageName) {
        boolean shouldInvalidateCache = false;
        Iterator r1 = overridesToRemove.changeIds.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Long changeId = (Long) r1.next();
        if (isKnownChangeId(changeId.longValue()) == false) goto L7;
        shouldInvalidateCache = shouldInvalidateCache | removeOverrideUnsafe(changeId.longValue(), packageName);
        goto L4
    L7:
        Slog.w(TAG, "Trying to remove overrides for unknown Change ID " + changeId + ". Skipping Change ID.");
        goto L4
    L9:
        return shouldInvalidateCache;
    }

    private long[] getAllowedChangesSinceTargetSdkForPackage(String packageName, int targetSdkVersion) {
        LongArray allowed = new LongArray();
        Iterator<CompatChange> r1 = this.mChanges.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        CompatChange change = r1.next();
        if (change.getEnableSinceTargetSdk() != targetSdkVersion) goto L4;
        OverrideAllowedState allowedState = this.mOverrideValidator.getOverrideAllowedState(change.getId(), packageName);
        if (allowedState.state != 0) goto L4;
        allowed.add(change.getId());
        goto L4
    L13:
        return allowed.toArray();
    }

    int enableTargetSdkChangesForPackage(String packageName, int targetSdkVersion) {
        long[] changes = getAllowedChangesSinceTargetSdkForPackage(packageName, targetSdkVersion);
        boolean shouldInvalidateCache = false;
        int r2 = changes.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        long changeId = changes[r3];
        shouldInvalidateCache = shouldInvalidateCache | addOverrideUnsafe(changeId, packageName, new PackageOverride.Builder().setEnabled(true).build());
        r3 = r3 + 1;
        goto L3
    L5:
        if (shouldInvalidateCache == false) goto L8;
        saveOverrides();
        invalidateCache();
    L8:
        return changes.length;
    }

    int disableTargetSdkChangesForPackage(String packageName, int targetSdkVersion) {
        long[] changes = getAllowedChangesSinceTargetSdkForPackage(packageName, targetSdkVersion);
        boolean shouldInvalidateCache = false;
        int r2 = changes.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        long changeId = changes[r4];
        shouldInvalidateCache = shouldInvalidateCache | addOverrideUnsafe(changeId, packageName, new PackageOverride.Builder().setEnabled(false).build());
        r4 = r4 + 1;
        goto L3
    L5:
        if (shouldInvalidateCache == false) goto L8;
        saveOverrides();
        invalidateCache();
    L8:
        return changes.length;
    }

    boolean registerListener(final long changeId, CompatChange.ChangeListener listener) {
        final AtomicBoolean alreadyKnown = new AtomicBoolean(true);
        CompatChange c = this.mChanges.computeIfAbsent(Long.valueOf(changeId), new CompatConfig$$ExternalSyntheticLambda3(this, alreadyKnown, changeId));
        c.registerListener(listener);
        return alreadyKnown.get();
    }

    private /* synthetic */ CompatChange lambda$registerListener$2(AtomicBoolean alreadyKnown, long changeId, Long key) {
        alreadyKnown.set(false);
        invalidateCache();
        return new CompatChange(changeId);
    }

    boolean defaultChangeIdValue(long changeId) {
        CompatChange c = this.mChanges.get(Long.valueOf(changeId));
        if (c != null) goto L7;
        return true;
    L7:
        return c.defaultValue();
    }

    void forceNonDebuggableFinalForTest(boolean value) {
        this.mOverrideValidator.forceNonDebuggableFinalForTest(value);
    }

    void clearChanges() {
        this.mChanges.clear();
    }

    void dumpConfig(PrintWriter pw) {
        if (this.mChanges.size() != 0) goto L6;
        pw.println("No compat overrides.");
        return;
    L6:
        Iterator<CompatChange> r0 = this.mChanges.values().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        CompatChange c = r0.next();
        pw.println(c.toString());
        goto L8
    }

    CompatibilityChangeConfig getAppConfig(ApplicationInfo applicationInfo) {
        Set<Long> enabled = new HashSet();
        Set<Long> disabled = new HashSet();
        Iterator<CompatChange> r2 = this.mChanges.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        CompatChange c = r2.next();
        if (c.isEnabled(applicationInfo, this.mAndroidBuildClassifier) == true) goto L7;
        disabled.add(Long.valueOf(c.getId()));
        goto L4
    L7:
        enabled.add(Long.valueOf(c.getId()));
        goto L4
    L11:
        return new CompatibilityChangeConfig(new Compatibility.ChangeConfig(enabled, disabled));
    }

    CompatibilityChangeInfo[] dumpChanges() {
        CompatibilityChangeInfo[] changeInfos = new CompatibilityChangeInfo[this.mChanges.size()];
        int i = 0;
        Iterator<CompatChange> r2 = this.mChanges.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CompatChange change = r2.next();
        changeInfos[i] = new CompatibilityChangeInfo(change);
        i = i + 1;
        goto L4
    L6:
        return changeInfos;
    }

    private static /* synthetic */ boolean lambda$initConfigFromLib$3(File file) {
        return true;
    }

    void initConfigFromLib(File libraryDir) {
        initConfigFromLib(libraryDir, new CompatConfig$$ExternalSyntheticLambda1());
    }

    void initConfigFromLib(File libraryDir, Predicate<File> includingFilter) {
        if (libraryDir.exists() == true) goto L5;
    L15:
        Slog.d(TAG, "No directory " + libraryDir + ", skipping");
        return;
    L5:
        if (libraryDir.isDirectory() == false) goto L15;
        File[] r0 = libraryDir.listFiles();
        int r2 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L14;
        File f = r0[r3];
        if (includingFilter.test(f) == false) goto L13;
        Slog.d(TAG, "Found a config file: " + f.getPath());
        readConfig(f);
    L13:
        r3 = r3 + 1;
        goto L8
    }

    private void readConfig(File configFile) {
        InputStream in = new BufferedInputStream(new FileInputStream(configFile));     // Catch: Throwable -> L14 Throwable -> L16
        Config config = XmlParser.read(in);     // Catch: Throwable -> L9
        Iterator<Change> r3 = config.getCompatChange().iterator();     // Catch: Throwable -> L9
    L6:
        if (r3.hasNext() == false) goto L12;
        Change change = r3.next();     // Catch: Throwable -> L9
        Slog.d(TAG, "Adding: " + change.toString());     // Catch: Throwable -> L9
        this.mChanges.put(Long.valueOf(change.getId()), new CompatChange(change));     // Catch: Throwable -> L9
        goto L6
    L12:
        in.close();     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16 Throwable -> L16
    L13:
        invalidateCache();
        return;
    L9:
        th = move-exception;
        in.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16 Throwable -> L16
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16 Throwable -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "Encountered an error while reading/parsing compat config file", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        invalidateCache();
        throw th;
    }

    private void initOverrides() {
        initOverrides(new File(APP_COMPAT_DATA_DIR, OVERRIDES_FILE), new File(STATIC_OVERRIDES_PRODUCT_DIR, OVERRIDES_FILE));
    }

    void initOverrides(File dynamicOverridesFile, File staticOverridesFile) {
        Iterator<CompatChange> r0 = this.mChanges.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CompatChange c = r0.next();
        c.clearOverrides();
        goto L4
    L6:
        loadOverrides(staticOverridesFile);
        Object r1 = this.mOverridesFileLock;
        monitor-enter(r1);
        this.mOverridesFile = dynamicOverridesFile;     // Catch: Throwable -> L11
        this.mBackupOverridesFile = makeBackupFile(dynamicOverridesFile);     // Catch: Throwable -> L11
        if (this.mBackupOverridesFile.exists() == false) goto L13;
        this.mOverridesFile.delete();     // Catch: Throwable -> L11
        this.mBackupOverridesFile.renameTo(this.mOverridesFile);     // Catch: Throwable -> L11
    L13:
        loadOverrides(this.mOverridesFile);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (staticOverridesFile.exists() == false) goto L24;
        saveOverrides();
        return;
    L24:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private File makeBackupFile(File overridesFile) {
        return new File(overridesFile.getPath() + ".bak");
    }

    private void loadOverrides(File overridesFile) {
        if (overridesFile.exists() == true) goto L33;
        return;
    L33:
        InputStream in = new BufferedInputStream(new FileInputStream(overridesFile));     // Catch: Throwable -> L11
        Overrides overrides = com.android.server.compat.overrides.XmlParser.read(in);     // Catch: Throwable -> L13
        if (overrides != null) goto L15;
        Slog.w(TAG, "Parsing " + overridesFile.getPath() + " failed");     // Catch: Throwable -> L13
        in.close();     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
        return;
    L15:
        Iterator<ChangeOverrides> r3 = overrides.getChangeOverrides().iterator();     // Catch: Throwable -> L13
    L17:
        if (r3.hasNext() == false) goto L24;
        ChangeOverrides changeOverrides = r3.next();     // Catch: Throwable -> L13
        long changeId = changeOverrides.getChangeId();     // Catch: Throwable -> L13
        CompatChange compatChange = this.mChanges.get(Long.valueOf(changeId));     // Catch: Throwable -> L13
        if (compatChange == null) goto L20;
        compatChange.loadOverrides(changeOverrides);     // Catch: Throwable -> L13
        goto L17
    L20:
        Slog.w(TAG, "Change ID " + changeId + " not found. Skipping overrides for it.");     // Catch: Throwable -> L13
        goto L17
    L24:
        in.close();     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
        return;
    L13:
        th = move-exception;
        in.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
    L11:
        e = move-exception;
        Slog.w(TAG, "Error processing " + overridesFile + " " + e.toString());
    }

    void saveOverrides() {
        Object r0 = this.mOverridesFileLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mOverridesFile == null) goto L50;
        if (this.mBackupOverridesFile == null) goto L50;
        Overrides overrides = new Overrides();     // Catch: Throwable -> L15
        List<ChangeOverrides> changeOverridesList = overrides.getChangeOverrides();     // Catch: Throwable -> L15
        Iterator<CompatChange> r3 = this.mChanges.values().iterator();     // Catch: Throwable -> L15
    L11:
        if (r3.hasNext() == false) goto L19;
        CompatChange c = r3.next();     // Catch: Throwable -> L15
        ChangeOverrides changeOverrides = c.saveOverrides();     // Catch: Throwable -> L15
        if (changeOverrides == null) goto L11;
        changeOverridesList.add(changeOverrides);     // Catch: Throwable -> L15
        goto L11
    L19:
        if (this.mOverridesFile.exists() == true) goto L21;
    L55:
        this.mOverridesFile.createNewFile();     // Catch: Throwable -> L15 IOException -> L46
        PrintWriter out = new PrintWriter(this.mOverridesFile);     // Catch: Throwable -> L15 IOException -> L33
        XmlWriter writer = new XmlWriter(out);     // Catch: Throwable -> L35
        XmlWriter.write(writer, overrides);     // Catch: Throwable -> L35
        out.close();     // Catch: Throwable -> L15 IOException -> L33
    L43:
        this.mBackupOverridesFile.delete();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L35:
        th = move-exception;
        out.close();     // Catch: Throwable -> L38
    L40:
        throw th;     // Catch: Throwable -> L15 IOException -> L33
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15 IOException -> L33
    L33:
        e = move-exception;
        Slog.e(TAG, e.toString());     // Catch: Throwable -> L15
        goto L43
    L46:
        e = move-exception;
        Slog.e(TAG, "Could not create override config file: " + e.toString());     // Catch: Throwable -> L15
        return;
    L21:
        if (this.mBackupOverridesFile.exists() == false) goto L24;
        this.mOverridesFile.delete();     // Catch: Throwable -> L15
        goto L55
    L24:
        if (this.mOverridesFile.renameTo(this.mBackupOverridesFile) == true) goto L55;
        Slog.e(TAG, "Couldn't rename file " + this.mOverridesFile + " to " + this.mBackupOverridesFile);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L50:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    IOverrideValidator getOverrideValidator() {
        return this.mOverrideValidator;
    }

    private void invalidateCache() {
        ChangeIdStateCache.invalidate();
    }

    void recheckOverrides(String packageName) {
        Long versionCode = getVersionCodeOrNull(packageName);
        boolean shouldInvalidateCache = false;
        Iterator<CompatChange> r2 = this.mChanges.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CompatChange c = r2.next();
        OverrideAllowedState allowedState = this.mOverrideValidator.getOverrideAllowedStateForRecheck(c.getId(), packageName);
        shouldInvalidateCache = shouldInvalidateCache | c.recheckOverride(packageName, allowedState, versionCode);
        goto L4
    L6:
        if (shouldInvalidateCache == false) goto L10;
        invalidateCache();
        return;
    }

    private Long getVersionCodeOrNull(String packageName) {
        return getVersionCodeOrNullImpl(packageName);
    }

    private Long getVersionCodeOrNull$ravenwood(String packageName) {
        return getVersionCodeOrNullImpl(packageName);
    L6:
        return 1L;
    }

    private Long getVersionCodeOrNullImpl(String packageName) {
        ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(packageName, 4194304);     // Catch: PackageManager.NameNotFoundException -> L4
        return Long.valueOf(applicationInfo.longVersionCode);
    L5:
        return null;
    }

    void registerContentObserver() {
        this.mOverrideValidator.registerContentObserver();
    }
}
