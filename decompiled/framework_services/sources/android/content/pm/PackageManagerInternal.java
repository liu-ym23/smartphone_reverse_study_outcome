package android.content.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.overlay.OverlayPaths;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.pm.PackageArchiver;
import com.android.server.pm.PackageList;
import com.android.server.pm.PackageSetting;
import com.android.server.pm.dex.DynamicCodeLogger;
import com.android.server.pm.permission.LegacyPermissionSettings;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class PackageManagerInternal {
    public static final int ENABLE_ROLLBACK_FAILED = -1;
    public static final int ENABLE_ROLLBACK_SUCCEEDED = 1;
    public static final String EXTRA_ENABLE_ROLLBACK_SESSION_ID = "android.content.pm.extra.ENABLE_ROLLBACK_SESSION_ID";
    public static final String EXTRA_ENABLE_ROLLBACK_TOKEN = "android.content.pm.extra.ENABLE_ROLLBACK_TOKEN";

    @Deprecated
    public static final int INTEGRITY_VERIFICATION_ALLOW = 1;

    @Deprecated
    public static final int INTEGRITY_VERIFICATION_REJECT = 0;
    public static final int RESOLVE_NON_BROWSER_ONLY = 1;
    public static final int RESOLVE_NON_RESOLVER_ONLY = 2;

    public interface ExternalSourcesPolicy {
        public static final int USER_BLOCKED = 1;
        public static final int USER_DEFAULT = 2;
        public static final int USER_TRUSTED = 0;

        int getPackageTrustedToInstallApps(String r1, int r2);
    }

    public static abstract class InstalledLoadingProgressCallback {
        final LoadingProgressCallbackBinder mBinder;
        final Executor mExecutor;

        private class LoadingProgressCallbackBinder extends IPackageLoadingProgressCallback.Stub {
            final /* synthetic */ InstalledLoadingProgressCallback this$0;

            /* synthetic */ LoadingProgressCallbackBinder(InstalledLoadingProgressCallback r1, PackageManagerInternalIA r2) {
                this(r1);
            }

            private LoadingProgressCallbackBinder(InstalledLoadingProgressCallback r1) {
                this.this$0 = r1;
            }

            public void onPackageLoadingProgressChanged(float progress) {
                this.this$0.mExecutor.execute(PooledLambda.obtainRunnable(new PackageManagerInternal$InstalledLoadingProgressCallback$LoadingProgressCallbackBinder$$ExternalSyntheticLambda0(), this.this$0, Float.valueOf(progress)).recycleOnUse());
            }
        }

        public abstract void onLoadingProgressChanged(float r1);

        public InstalledLoadingProgressCallback(Handler handler) {
            this.mBinder = new LoadingProgressCallbackBinder(this, null);
            if (handler != null) goto L5;
            handler = new Handler(Looper.getMainLooper());
        L5:
            this.mExecutor = new HandlerExecutor(handler);
        }

        public final IBinder getBinder() {
            return this.mBinder;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    public @interface IntegrityVerificationResult {
    }

    @Deprecated
    public interface PackageListObserver {
        default void onPackageAdded(String packageName, int uid) {
        }

        default void onPackageChanged(String packageName, int uid) {
        }

        default void onPackageRemoved(String packageName, int uid) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PrivateResolveFlags {
    }

    public abstract void addIsolatedUid(int r1, int r2);

    public abstract boolean canAccessComponent(int r1, ComponentName r2, int r3);

    public abstract boolean canAccessInstantApps(int r1, int r2);

    public abstract boolean canQueryPackage(int r1, String r2);

    public abstract int checkUidSignaturesForAllUsers(int r1, int r2);

    public abstract void clearBlockUninstallForUser(int r1);

    public abstract PackageStateMutator.Result commitPackageStateMutation(PackageStateMutator.InitialState r1, Consumer<PackageStateMutator> r2);

    public abstract long deleteOatArtifactsOfPackage(String r1);

    public abstract boolean filterAppAccess(int r1, int r2);

    public abstract boolean filterAppAccess(AndroidPackage r1, int r2, int r3);

    public abstract boolean filterAppAccess(String r1, int r2, int r3, boolean r4);

    public abstract void finishPackageInstall(int r1, boolean r2);

    public abstract void flushPackageRestrictions(int r1);

    public abstract void forEachInstalledPackage(Consumer<AndroidPackage> r1, int r2);

    public abstract void forEachPackage(Consumer<AndroidPackage> r1);

    public abstract void forEachPackageSetting(Consumer<PackageSetting> r1);

    public abstract void forEachPackageState(Consumer<PackageStateInternal> r1);

    public abstract void freeAllAppCacheAboveQuota(String r1) throws IOException;

    public abstract void freeStorage(String r1, long r2, int r4) throws IOException;

    public abstract ActivityInfo getActivityInfo(ComponentName r1, long r2, int r4, int r5);

    public abstract AndroidPackage getAndroidPackage(String r1);

    public abstract List<String> getApksInApex(String r1);

    public abstract int getApplicationEnabledState(String r1, int r2);

    public abstract ApplicationInfo getApplicationInfo(String r1, long r2, int r4, int r5);

    public abstract SparseArray<String> getAppsWithSharedUserIds();

    public abstract long getCeDataInode(String r1, int r2);

    public abstract int getComponentEnabledSetting(ComponentName r1, int r2, int r3);

    public abstract ComponentName getDefaultHomeActivity(int r1);

    public abstract ArraySet<String> getDisabledComponents(String r1, int r2);

    public abstract PackageStateInternal getDisabledSystemPackage(String r1);

    public abstract String getDisabledSystemPackageName(String r1);

    public abstract int getDistractingPackageRestrictions(String r1, int r2);

    public abstract int[] getDistractingPackageRestrictionsAsUser(String[] r1, int r2);

    public abstract DynamicCodeLogger getDynamicCodeLogger();

    public abstract ArraySet<String> getEnabledComponents(String r1, int r2);

    public abstract ParceledListSlice<PackageInstaller.SessionInfo> getHistoricalSessions(int r1);

    public abstract ComponentName getHomeActivitiesAsUser(List<ResolveInfo> r1, int r2);

    public abstract IncrementalStatesInfo getIncrementalStatesInfo(String r1, int r2, int r3);

    public abstract List<ApplicationInfo> getInstalledApplications(long r1, int r3, int r4);

    public abstract List<ApplicationInfo> getInstalledApplicationsCrossUser(long r1, int r3, int r4);

    public abstract ParceledListSlice getInstalledPackagesUncheck(long r1, int r3);

    public abstract String getInstantAppPackageName(int r1);

    public abstract String[] getKnownPackageNames(int r1, int r2);

    public abstract LegacyPermissionSettings getLegacyPermissions();

    public abstract Object getLegacyPermissionsState(int r1);

    public abstract int getLegacyPermissionsVersion(int r1);

    public abstract List<String> getMimeGroup(String r1, String r2);

    public abstract String getNameForUid(int r1);

    public abstract List<PackageInfo> getOverlayPackages(int r1);

    public abstract AndroidPackage getPackage(int r1);

    public abstract AndroidPackage getPackage(String r1);

    public abstract PackageArchiver getPackageArchiver();

    public abstract PackageInfo getPackageInfo(String r1, long r2, int r4, int r5);

    @Deprecated
    public abstract PackageList getPackageList(PackageListObserver r1);

    public abstract PackageStateInternal getPackageStateInternal(String r1);

    public abstract ArrayMap<String, ? extends PackageStateInternal> getPackageStates();

    public abstract int getPackageTargetSdkVersion(String r1);

    public abstract int getPackageUid(String r1, long r2, int r4);

    public abstract List<AndroidPackage> getPackagesForAppId(int r1);

    public abstract int[] getPermissionGids(String r1, int r2);

    public abstract ArrayMap<String, ProcessInfo> getProcessesForUid(int r1);

    public abstract String getSetupWizardPackageName();

    public abstract SharedUserApi getSharedUserApi(int r1);

    public abstract ArraySet<PackageStateInternal> getSharedUserPackages(int r1);

    public abstract String[] getSharedUserPackagesForPackage(String r1, int r2);

    public abstract SuspendDialogInfo getSuspendedDialogInfo(String r1, UserPackage r2, int r3);

    public abstract Bundle getSuspendedPackageLauncherExtras(String r1, int r2);

    public abstract UserPackage getSuspendingPackage(String r1, int r2);

    public abstract ComponentName getSystemUiServiceComponent();

    public abstract List<String> getTargetPackageNames(int r1);

    public abstract int getUidTargetSdkVersion(int r1);

    public abstract int[] getVisibilityAllowList(String r1, int r2);

    public abstract void grantImplicitAccess(int r1, Intent r2, int r3, int r4, boolean r5);

    public abstract void grantImplicitAccess(int r1, Intent r2, int r3, int r4, boolean r5, boolean r6);

    public abstract boolean hasInstantApplicationMetadata(String r1, int r2);

    public abstract boolean hasSignatureCapability(int r1, int r2, int r3);

    public abstract boolean isAdminSuspendingAnyPackages(int r1);

    public abstract boolean isApexPackage(String r1);

    public abstract boolean isCallerInstallerOfRecord(AndroidPackage r1, int r2);

    public abstract boolean isDataRestoreSafe(Signature r1, String r2);

    public abstract boolean isDataRestoreSafe(byte[] r1, String r2);

    public abstract boolean isEnabledAndMatches(ParsedMainComponent r1, long r2, int r4);

    public abstract boolean isInstantApp(String r1, int r2);

    public abstract boolean isInstantAppInstallerComponent(ComponentName r1);

    public abstract boolean isPackageDataProtected(int r1, String r2);

    public abstract boolean isPackageEphemeral(int r1, String r2);

    public abstract boolean isPackageFrozen(String r1, int r2, int r3);

    public abstract boolean isPackagePersistent(String r1);

    public abstract boolean isPackageQuarantined(String r1, int r2) throws PackageManager.NameNotFoundException;

    public abstract boolean isPackageStateProtected(String r1, int r2);

    public abstract boolean isPackageStopped(String r1, int r2) throws PackageManager.NameNotFoundException;

    public abstract boolean isPackageSuspended(String r1, int r2);

    public abstract boolean isPermissionUpgradeNeeded(int r1);

    public abstract boolean isPermissionsReviewRequired(String r1, int r2);

    public abstract boolean isPlatformSigned(String r1);

    public abstract boolean isResolveActivityComponent(ComponentInfo r1);

    public abstract boolean isSameApp(String r1, int r2, int r3);

    public abstract boolean isSameApp(String r1, long r2, int r4, int r5);

    public abstract boolean isSystemPackage(String r1);

    public abstract boolean isUidPrivileged(int r1);

    public abstract boolean isUpgradingFromLowerThan(int r1);

    public abstract void migrateLegacyObbData();

    public abstract void notifyComponentUsed(String r1, int r2, String r3, String r4);

    public abstract void notifyPackageUse(String r1, int r2);

    public abstract void onPackageProcessKilledForUninstall(String r1);

    public abstract void pruneInstantApps();

    public abstract List<ResolveInfo> queryIntentActivities(Intent r1, String r2, long r3, int r5, int r6);

    public abstract List<ResolveInfo> queryIntentReceivers(Intent r1, String r2, long r3, int r5, int r6, int r7, boolean r8);

    public abstract List<ResolveInfo> queryIntentServices(Intent r1, long r2, int r4, int r5);

    public abstract void reconcileAppsData(int r1, int r2, boolean r3);

    public abstract PackageStateMutator.InitialState recordInitialState();

    public abstract boolean registerInstalledLoadingProgressCallback(String r1, InstalledLoadingProgressCallback r2, int r3);

    public abstract void removeAllDistractingPackageRestrictions(int r1);

    public abstract void removeAllNonSystemPackageSuspensions(int r1);

    public abstract void removeDistractingPackageRestrictions(String r1, int r2);

    public abstract void removeIsolatedUid(int r1);

    public abstract String removeLegacyDefaultBrowserPackageName(int r1);

    public abstract void removeNonSystemPackageSuspensions(String r1, int r2);

    @Deprecated
    public abstract void removePackageListObserver(PackageListObserver r1);

    public abstract void requestChecksums(String r1, boolean r2, int r3, int r4, List r5, IOnChecksumsReadyListener r6, int r7, Executor r8, Handler r9);

    public abstract void requestInstantAppResolutionPhaseTwo(AuxiliaryResolveInfo r1, Intent r2, String r3, String r4, String r5, boolean r6, Bundle r7, int r8);

    public abstract ProviderInfo resolveContentProvider(String r1, long r2, int r4, int r5);

    public abstract ResolveInfo resolveIntent(Intent r1, String r2, long r3, long r5, int r7, boolean r8, int r9, int r10);

    public abstract ResolveInfo resolveService(Intent r1, String r2, long r3, int r5, int r6);

    public abstract ResolveInfo resolveService(Intent r1, String r2, long r3, int r5, int r6, int r7);

    public abstract void sendPackageDataClearedBroadcast(String r1, int r2, int r3, boolean r4, boolean r5);

    public abstract void sendPackageRestartedBroadcast(String r1, int r2, int r3);

    public abstract void setDeviceAndProfileOwnerPackages(int r1, String r2, SparseArray<String> r3);

    public abstract void setEnableRollbackCode(int r1, int r2);

    public abstract void setEnabledOverlayPackages(int r1, ArrayMap<String, OverlayPaths> r2, Set<String> r3, Set<String> r4);

    public abstract void setExternalSourcesPolicy(ExternalSourcesPolicy r1);

    @Deprecated
    public abstract void setIntegrityVerificationResult(int r1, int r2);

    public abstract void setKeepUninstalledPackages(List<String> r1);

    public abstract void setOwnerProtectedPackages(int r1, List<String> r2);

    public abstract void setPackageStoppedState(String r1, boolean r2, int r3);

    public abstract String[] setPackagesSuspendedByAdmin(int r1, String[] r2, boolean r3);

    public abstract void setVisibilityLogging(String r1, boolean r2);

    public abstract void shutdown();

    public abstract PackageDataSnapshot snapshot();

    public abstract void uninstallApex(String r1, long r2, int r4, IntentSender r5, int r6);

    public abstract void unsuspendAdminSuspendedPackages(int r1);

    public abstract void updateRuntimePermissionsFingerprint(int r1);

    public abstract boolean userNeedsBadging(int r1);

    public abstract boolean wasPackageEverLaunched(String r1, int r2);

    public abstract void writePermissionSettings(int[] r1, boolean r2);

    public abstract void writeSettings(boolean r1);

    public PackageManagerInternal() {
    }

    public void onDefaultSmsAppChanged(String packageName, int userId) {
    }

    public void onDefaultSimCallManagerAppChanged(String packageName, int userId) {
    }

    public PackageList getPackageList() {
        return getPackageList(null);
    }

    public boolean filterAppAccess(String packageName, int callingUid, int userId) {
        return filterAppAccess(packageName, callingUid, userId, true);
    }
}
