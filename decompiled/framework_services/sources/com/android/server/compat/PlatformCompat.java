package com.android.server.compat;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.compat.PackageOverride;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.PermissionEnforcer;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.compat.AndroidBuildClassifier;
import com.android.internal.compat.ChangeReporter;
import com.android.internal.compat.CompatibilityChangeConfig;
import com.android.internal.compat.CompatibilityChangeInfo;
import com.android.internal.compat.CompatibilityOverrideConfig;
import com.android.internal.compat.CompatibilityOverridesByPackageConfig;
import com.android.internal.compat.CompatibilityOverridesToRemoveByPackageConfig;
import com.android.internal.compat.CompatibilityOverridesToRemoveConfig;
import com.android.internal.compat.IOverrideValidator;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import com.android.server.pm.Settings;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PlatformCompat extends IPlatformCompat.Stub {
    private static final String TAG = "Compatibility";
    private final AndroidBuildClassifier mBuildClassifier;
    private final ChangeReporter mChangeReporter;
    private final CompatConfig mCompatConfig;
    private final Context mContext;
    private Boolean mIsWear;

    /* JADX INFO: renamed from: $r8$lambda$-zCtnrhX3uL10YRKH31OPs5_I_s, reason: not valid java name */
    public static /* synthetic */ boolean m3041$r8$lambda$zCtnrhX3uL10YRKH31OPs5_I_s(PlatformCompat r0, CompatibilityChangeInfo r1) {
        return r0.isShownInUI(r1);
    }

    public static /* synthetic */ CompatibilityChangeInfo[] $r8$lambda$Scg1oad3I4U5dU8481owPl2CreI(int r0) {
        return lambda$listUIChanges$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCompatConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompatConfig m3042$$Nest$fgetmCompatConfig(PlatformCompat r0) {
        return r0.mCompatConfig;
    }

    public PlatformCompat(Context context) {
        super(PermissionEnforcer.fromContext(context));
        this.mContext = context;
        this.mChangeReporter = new ChangeReporter(2);
        this.mBuildClassifier = new AndroidBuildClassifier();
        this.mCompatConfig = CompatConfig.create(this.mBuildClassifier, this.mContext);
    }

    PlatformCompat(Context context, CompatConfig compatConfig, AndroidBuildClassifier buildClassifier, ChangeReporter changeReporter) {
        super(PermissionEnforcer.fromContext(context));
        this.mContext = context;
        this.mChangeReporter = changeReporter;
        this.mCompatConfig = compatConfig;
        this.mBuildClassifier = buildClassifier;
        registerPackageReceiver(context);
    }

    public void reportChange(long changeId, ApplicationInfo appInfo) {
        super.reportChange_enforcePermission();
        reportChangeInternal(changeId, appInfo.uid, appInfo.isSystemApp(), 3);
    }

    public void reportChangeByPackageName(long changeId, String packageName, int userId) {
        super.reportChangeByPackageName_enforcePermission();
        ApplicationInfo appInfo = getApplicationInfo(packageName, userId);
        if (appInfo == null) goto L6;
        reportChangeInternal(changeId, appInfo.uid, appInfo.isSystemApp(), 3);
        return;
    }

    public void reportChangeByUid(long changeId, int uid) {
        super.reportChangeByUid_enforcePermission();
        reportChangeInternal(changeId, uid, false, 3);
    }

    private void reportChangeInternal(long changeId, int uid, boolean isKnownSystemApp, int state) {
        this.mChangeReporter.reportChange(uid, changeId, state, isKnownSystemApp, true);
    }

    public boolean isChangeEnabled(long changeId, ApplicationInfo appInfo) {
        super.isChangeEnabled_enforcePermission();
        return isChangeEnabledInternal(changeId, appInfo);
    }

    public boolean isChangeEnabledByPackageName(long changeId, String packageName, int userId) {
        super.isChangeEnabledByPackageName_enforcePermission();
        ApplicationInfo appInfo = getApplicationInfo(packageName, userId);
        if (appInfo != null) goto L7;
        return this.mCompatConfig.willChangeBeEnabled(changeId, packageName);
    L7:
        return isChangeEnabledInternal(changeId, appInfo);
    }

    public boolean isChangeEnabledByUid(long changeId, int uid) {
        super.isChangeEnabledByUid_enforcePermission();
        return isChangeEnabledByUidInternal(changeId, uid);
    }

    public boolean isChangeEnabledInternalNoLogging(long changeId, ApplicationInfo appInfo) {
        return this.mCompatConfig.isChangeEnabled(changeId, appInfo);
    }

    public boolean isChangeEnabledInternal(long changeId, ApplicationInfo appInfo) {
        CompatChange c = this.mCompatConfig.getCompatChange(changeId);
        boolean enabled = this.mCompatConfig.isChangeEnabled(c, appInfo);
        if (enabled == false) goto L5;
        int r2 = 1;
    L6:
        int state = r2;
        if (appInfo == null) goto L10;
        boolean isTargetingLatestSdk = this.mCompatConfig.isChangeTargetingLatestSdk(c, appInfo.targetSdkVersion);
        this.mChangeReporter.reportChange(appInfo.uid, changeId, state, appInfo.isSystemApp(), isTargetingLatestSdk);
    L10:
        return enabled;
    L5:
        r2 = 2;
        goto L6
    }

    public boolean isChangeEnabledInternal(long changeId, String packageName, int targetSdkVersion) {
        if (this.mCompatConfig.willChangeBeEnabled(changeId, packageName) == false) goto L6;
        ApplicationInfo appInfo = new ApplicationInfo();
        appInfo.packageName = packageName;
        appInfo.targetSdkVersion = targetSdkVersion;
        return isChangeEnabledInternalNoLogging(changeId, appInfo);
    L6:
        return false;
    }

    public boolean isChangeEnabledByUidInternal(long changeId, int uid) {
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packages == null) goto L12;
        if (packages.length == 0) goto L12;
        boolean enabled = true;
        int userId = UserHandle.getUserId(uid);
        int r3 = packages.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        String packageName = packages[r4];
        ApplicationInfo appInfo = fixTargetSdk(getApplicationInfo(packageName, userId), uid);
        enabled = enabled & isChangeEnabledInternal(changeId, appInfo);
        r4 = r4 + 1;
        goto L8
    L10:
        return enabled;
    L12:
        return this.mCompatConfig.defaultChangeIdValue(changeId);
    }

    public boolean isChangeEnabledByUidInternalNoLogging(long changeId, int uid) {
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packages == null) goto L12;
        if (packages.length == 0) goto L12;
        boolean enabled = true;
        int userId = UserHandle.getUserId(uid);
        int r3 = packages.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        String packageName = packages[r4];
        ApplicationInfo appInfo = fixTargetSdk(getApplicationInfo(packageName, userId), uid);
        enabled = enabled & isChangeEnabledInternalNoLogging(changeId, appInfo);
        r4 = r4 + 1;
        goto L8
    L10:
        return enabled;
    L12:
        return this.mCompatConfig.defaultChangeIdValue(changeId);
    }

    public void setOverrides(CompatibilityChangeConfig overrides, String packageName) {
        super.setOverrides_enforcePermission();
        Map<Long, PackageOverride> overridesMap = new HashMap();
        Iterator r1 = overrides.enabledChanges().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        long change = ((Long) r1.next()).longValue();
        overridesMap.put(Long.valueOf(change), new PackageOverride.Builder().setEnabled(true).build());
        goto L4
    L6:
        Iterator r2 = overrides.disabledChanges().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        long change2 = ((Long) r2.next()).longValue();
        overridesMap.put(Long.valueOf(change2), new PackageOverride.Builder().setEnabled(false).build());
        goto L8
    L10:
        this.mCompatConfig.addPackageOverrides(new CompatibilityOverrideConfig(overridesMap), packageName, false);
        killPackage(packageName);
    }

    public void setOverridesForTest(CompatibilityChangeConfig overrides, String packageName) {
        super.setOverridesForTest_enforcePermission();
        Map<Long, PackageOverride> overridesMap = new HashMap();
        Iterator r1 = overrides.enabledChanges().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        long change = ((Long) r1.next()).longValue();
        overridesMap.put(Long.valueOf(change), new PackageOverride.Builder().setEnabled(true).build());
        goto L4
    L6:
        Iterator r2 = overrides.disabledChanges().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        long change2 = ((Long) r2.next()).longValue();
        overridesMap.put(Long.valueOf(change2), new PackageOverride.Builder().setEnabled(false).build());
        goto L8
    L10:
        this.mCompatConfig.addPackageOverrides(new CompatibilityOverrideConfig(overridesMap), packageName, false);
    }

    public void putAllOverridesOnReleaseBuilds(CompatibilityOverridesByPackageConfig overridesByPackage) {
        super.putAllOverridesOnReleaseBuilds_enforcePermission();
        Iterator r0 = overridesByPackage.packageNameToOverrides.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CompatibilityOverrideConfig overrides = (CompatibilityOverrideConfig) r0.next();
        checkAllCompatOverridesAreOverridable(overrides.overrides.keySet());
        goto L4
    L6:
        this.mCompatConfig.addAllPackageOverrides(overridesByPackage, true);
    }

    public void putOverridesOnReleaseBuilds(CompatibilityOverrideConfig overrides, String packageName) {
        super.putOverridesOnReleaseBuilds_enforcePermission();
        checkAllCompatOverridesAreOverridable(overrides.overrides.keySet());
        this.mCompatConfig.addPackageOverrides(overrides, packageName, true);
    }

    public int enableTargetSdkChanges(String packageName, int targetSdkVersion) {
        super.enableTargetSdkChanges_enforcePermission();
        int numChanges = this.mCompatConfig.enableTargetSdkChangesForPackage(packageName, targetSdkVersion);
        killPackage(packageName);
        return numChanges;
    }

    public int disableTargetSdkChanges(String packageName, int targetSdkVersion) {
        super.disableTargetSdkChanges_enforcePermission();
        int numChanges = this.mCompatConfig.disableTargetSdkChangesForPackage(packageName, targetSdkVersion);
        killPackage(packageName);
        return numChanges;
    }

    public void clearOverrides(String packageName) {
        super.clearOverrides_enforcePermission();
        this.mCompatConfig.removePackageOverrides(packageName);
        killPackage(packageName);
    }

    public void clearOverridesForTest(String packageName) {
        super.clearOverridesForTest_enforcePermission();
        this.mCompatConfig.removePackageOverrides(packageName);
    }

    public boolean clearOverride(long changeId, String packageName) {
        super.clearOverride_enforcePermission();
        boolean existed = this.mCompatConfig.removeOverride(changeId, packageName);
        killPackage(packageName);
        return existed;
    }

    public boolean clearOverrideForTest(long changeId, String packageName) {
        super.clearOverrideForTest_enforcePermission();
        return this.mCompatConfig.removeOverride(changeId, packageName);
    }

    public void removeAllOverridesOnReleaseBuilds(CompatibilityOverridesToRemoveByPackageConfig overridesToRemoveByPackage) {
        super.removeAllOverridesOnReleaseBuilds_enforcePermission();
        Iterator r0 = overridesToRemoveByPackage.packageNameToOverridesToRemove.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CompatibilityOverridesToRemoveConfig overridesToRemove = (CompatibilityOverridesToRemoveConfig) r0.next();
        checkAllCompatOverridesAreOverridable(overridesToRemove.changeIds);
        goto L4
    L6:
        this.mCompatConfig.removeAllPackageOverrides(overridesToRemoveByPackage);
    }

    public void removeOverridesOnReleaseBuilds(CompatibilityOverridesToRemoveConfig overridesToRemove, String packageName) {
        super.removeOverridesOnReleaseBuilds_enforcePermission();
        checkAllCompatOverridesAreOverridable(overridesToRemove.changeIds);
        this.mCompatConfig.removePackageOverrides(overridesToRemove, packageName);
    }

    public CompatibilityChangeConfig getAppConfig(ApplicationInfo appInfo) {
        super.getAppConfig_enforcePermission();
        return this.mCompatConfig.getAppConfig(appInfo);
    }

    public CompatibilityChangeInfo[] listAllChanges() {
        super.listAllChanges_enforcePermission();
        return this.mCompatConfig.dumpChanges();
    }

    public CompatibilityChangeInfo[] listUIChanges() {
        return (CompatibilityChangeInfo[]) Arrays.stream(listAllChanges()).filter(new PlatformCompat$$ExternalSyntheticLambda0(this)).toArray(new PlatformCompat$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ CompatibilityChangeInfo[] lambda$listUIChanges$0(int x$0) {
        return new CompatibilityChangeInfo[x$0];
    }

    public boolean isKnownChangeId(long changeId) {
        return this.mCompatConfig.isKnownChangeId(changeId);
    }

    public long[] getDisabledChanges(ApplicationInfo appInfo) {
        return this.mCompatConfig.getDisabledChanges(appInfo);
    }

    public long[] getLoggableChanges(ApplicationInfo appInfo) {
        return this.mCompatConfig.getLoggableChanges(appInfo);
    }

    public long lookupChangeId(String name) {
        return this.mCompatConfig.lookupChangeId(name);
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, "platform_compat", pw) == true) goto L5;
        return;
    L5:
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_COMPAT_CHANGE_CONFIG", "Cannot read compat change");
        this.mContext.enforceCallingOrSelfPermission("android.permission.LOG_COMPAT_CHANGE", "Cannot read log compat change usage");
        this.mCompatConfig.dumpConfig(pw);
    }

    public IOverrideValidator getOverrideValidator() {
        return this.mCompatConfig.getOverrideValidator();
    }

    public void resetReporting(ApplicationInfo appInfo) {
        this.mChangeReporter.resetReportedChanges(appInfo.uid);
    }

    private ApplicationInfo getApplicationInfo(String packageName, int userId) {
        return ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getApplicationInfo(packageName, 0, Process.myUid(), userId);
    }

    private ApplicationInfo fixTargetSdk(ApplicationInfo appInfo, int uid) {
        if (this.mIsWear != null) goto L6;
        this.mIsWear = Boolean.valueOf(this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
    L6:
        if (this.mIsWear.booleanValue() == false) goto L8;
    L11:
        return appInfo;
    L8:
        if (uid != 1000) goto L11;
        if (appInfo == null) goto L11;
        appInfo.targetSdkVersion = this.mBuildClassifier.platformTargetSdk();
        goto L11
    }

    private void killPackage(String packageName) {
        int uid = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageUid(packageName, 0, UserHandle.myUserId());
        if (uid >= 0) goto L6;
        Slog.w(TAG, "Didn't find package " + packageName + " on device.");
        return;
    L6:
        Slog.d(TAG, "Killing package " + packageName + " (UID " + uid + ").");
        killUid(UserHandle.getAppId(uid));
    }

    private void killPackage$ravenwood(String packageName) {
        Slog.w(TAG, "killPackage() is ignored on Ravenwood: packageName=" + packageName);
    }

    private void killUid(int appId) {
        long identity = Binder.clearCallingIdentity();
        IActivityManager am = ActivityManager.getService();     // Catch: Throwable -> L7 RemoteException -> L9
        if (am == null) goto L10;
        am.killUid(appId, -1, "PlatformCompat overrides");     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        Binder.restoreCallingIdentity(identity);
    }

    private void killUid$ravenwood(int appId) {
        Slog.w(TAG, "killUid() is ignored on Ravenwood: appId=" + appId);
    }

    private void checkAllCompatOverridesAreOverridable(Collection<Long> changeIds) {
        Iterator<Long> r0 = changeIds.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Long changeId = r0.next();
        if (isKnownChangeId(changeId.longValue()) == false) goto L4;
        if (this.mCompatConfig.isOverridable(changeId.longValue()) == true) goto L4;
        throw new SecurityException("Only change ids marked as Overridable can be overridden.");
    }

    private boolean isShownInUI(CompatibilityChangeInfo change) {
        if (change.getLoggingOnly() == false) goto L6;
        return false;
    L6:
        if (change.getId() != 149391281) goto L9;
        return false;
    L9:
        if (change.getEnableSinceTargetSdk() > 0) goto L11;
        return true;
    L11:
        if (change.getEnableSinceTargetSdk() >= 29) goto L13;
        return false;
    L13:
        if (change.getEnableSinceTargetSdk() <= this.mBuildClassifier.platformTargetSdk()) goto L16;
        return false;
    L16:
        return true;
    }

    public boolean registerListener(long changeId, CompatChange.ChangeListener listener) {
        return this.mCompatConfig.registerListener(changeId, listener);
    }

    public void registerPackageReceiver(Context context) {
        BroadcastReceiver receiver = new AnonymousClass1(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        context.registerReceiverForAllUsers(receiver, filter, null, null);
    }

    public void registerContentObserver() {
        this.mCompatConfig.registerContentObserver();
    }
}
