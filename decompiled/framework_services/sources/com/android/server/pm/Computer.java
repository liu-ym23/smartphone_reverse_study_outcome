package com.android.server.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.KeySet;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ProcessInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.content.pm.UserInfo;
import android.content.pm.VersionedPackage;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedLongSparseArray;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface Computer extends PackageDataSnapshot {
    boolean activitySupportsIntentAsUser(ComponentName r1, ComponentName r2, Intent r3, String r4, int r5);

    List<ResolveInfo> applyPostResolutionFilter(List<ResolveInfo> r1, String r2, boolean r3, int r4, boolean r5, int r6, Intent r7);

    boolean canAccessComponent(int r1, ComponentName r2, int r3);

    boolean canForwardTo(Intent r1, String r2, int r3, int r4);

    boolean[] canPackageQuery(String r1, String[] r2, int r3);

    boolean canQueryPackage(int r1, String r2);

    boolean canRequestPackageInstalls(String r1, int r2, int r3, boolean r4);

    boolean canViewInstantApps(int r1, int r2);

    String[] canonicalToCurrentPackageNames(String[] r1);

    void checkPackageFrozen(String r1);

    int checkSignatures(String r1, String r2, int r3);

    int checkUidPermission(String r1, int r2);

    int checkUidSignatures(int r1, int r2);

    int checkUidSignaturesForAllUsers(int r1, int r2);

    ResolveInfo createForwardingResolveInfoUnchecked(WatchedIntentFilter r1, int r2, int r3);

    String[] currentToCanonicalPackageNames(String[] r1);

    void dump(int r1, FileDescriptor r2, PrintWriter r3, DumpState r4);

    void dumpKeySet(PrintWriter r1, String r2, DumpState r3);

    void dumpPackages(PrintWriter r1, String r2, ArraySet<String> r3, DumpState r4, boolean r5);

    void dumpPackagesProto(ProtoOutputStream r1);

    void dumpPermissions(PrintWriter r1, String r2, ArraySet<String> r3, DumpState r4);

    void dumpSharedLibrariesProto(ProtoOutputStream r1);

    void dumpSharedUsers(PrintWriter r1, String r2, ArraySet<String> r3, DumpState r4, boolean r5);

    void dumpSharedUsersProto(ProtoOutputStream r1);

    void enforceCrossUserOrProfilePermission(int r1, int r2, boolean r3, boolean r4, String r5);

    void enforceCrossUserPermission(int r1, int r2, boolean r3, boolean r4, String r5);

    void enforceCrossUserPermission(int r1, int r2, boolean r3, boolean r4, boolean r5, String r6);

    boolean filterAppAccess(int r1, int r2);

    boolean filterAppAccess(AndroidPackage r1, int r2, int r3);

    boolean filterAppAccess(String r1, int r2, int r3, boolean r4);

    String[] filterOnlySystemPackages(String... r1);

    boolean filterSharedLibPackage(PackageStateInternal r1, int r2, int r3, long r4);

    ResolveInfo findPersistentPreferredActivity(Intent r1, String r2, long r3, List<ResolveInfo> r5, boolean r6, int r7);

    PackageManagerService.FindPreferredActivityBodyResult findPreferredActivityInternal(Intent r1, String r2, long r3, List<ResolveInfo> r5, boolean r6, boolean r7, boolean r8, int r9, boolean r10);

    List<PackageStateInternal> findSharedNonSystemLibraries(PackageStateInternal r1);

    ApplicationInfo generateApplicationInfoFromSettings(String r1, long r2, int r4, int r5);

    PackageInfo generatePackageInfo(PackageStateInternal r1, long r2, int r4);

    ActivityInfo getActivityInfo(ComponentName r1, long r2, int r4);

    ActivityInfo getActivityInfoCrossProfile(ComponentName r1, long r2, int r4);

    ActivityInfo getActivityInfoInternal(ComponentName r1, long r2, int r4, int r5);

    String[] getAllAvailablePackageNames();

    ParceledListSlice<IntentFilter> getAllIntentFilters(String r1);

    List<String> getAllPackages();

    String[] getAppOpPermissionPackages(String r1, int r2);

    int getApplicationEnabledSetting(String r1, int r2);

    boolean getApplicationHiddenSettingAsUser(String r1, int r2);

    ApplicationInfo getApplicationInfo(String r1, long r2, int r4);

    ApplicationInfo getApplicationInfoInternal(String r1, long r2, int r4, int r5);

    SparseArray<String> getAppsWithSharedUserIds();

    boolean getBlockUninstall(int r1, String r2);

    boolean getBlockUninstallForUser(String r1, int r2);

    int getComponentEnabledSetting(ComponentName r1, int r2, int r3);

    int getComponentEnabledSettingInternal(ComponentName r1, int r2, int r3);

    ComponentResolverApi getComponentResolver();

    CrossProfileDomainInfo getCrossProfileDomainPreferredLpr(Intent r1, String r2, long r3, int r5, int r6);

    ParceledListSlice<SharedLibraryInfo> getDeclaredSharedLibraries(String r1, long r2, int r4);

    ComponentName getDefaultHomeActivity(int r1);

    PackageStateInternal getDisabledSystemPackage(String r1);

    ArrayMap<String, ? extends PackageStateInternal> getDisabledSystemPackageStates();

    IExtComputerEngine getExt();

    int getFlagsForUid(int r1);

    WatchedArrayMap<String, Integer> getFrozenPackages();

    ProviderInfo getGrantImplicitAccessProviderInfo(int r1, String r2);

    CharSequence getHarmfulAppWarning(String r1, int r2);

    ComponentName getHomeActivitiesAsUser(List<ResolveInfo> r1, int r2);

    Intent getHomeIntent();

    int getInstallReason(String r1, int r2);

    InstallSourceInfo getInstallSourceInfo(String r1, int r2);

    List<ApplicationInfo> getInstalledApplications(long r1, int r3, int r4, boolean r5);

    ParceledListSlice<PackageInfo> getInstalledPackages(long r1, int r3);

    String getInstallerPackageName(String r1, int r2);

    ComponentName getInstantAppInstallerComponent();

    ResolveInfo getInstantAppInstallerInfo();

    String getInstantAppPackageName(int r1);

    InstrumentationInfo getInstrumentationInfoAsUser(ComponentName r1, int r2, int r3);

    KeySet getKeySetByAlias(String r1, String r2);

    List<CrossProfileIntentFilter> getMatchingCrossProfileIntentFilters(Intent r1, String r2, int r3);

    String getNameForUid(int r1);

    String[] getNamesForUids(int[] r1);

    ArraySet<String> getNotifyPackagesForReplacedReceived(String[] r1);

    AndroidPackage getPackage(int r1);

    AndroidPackage getPackage(String r1);

    int[] getPackageGids(String r1, long r2, int r4);

    PackageInfo getPackageInfo(String r1, long r2, int r4);

    PackageInfo getPackageInfoInternal(String r1, long r2, long r4, int r6, int r7);

    Pair<PackageStateInternal, SharedUserApi> getPackageOrSharedUser(int r1);

    int getPackageStartability(boolean r1, String r2, int r3, int r4);

    PackageStateInternal getPackageStateFiltered(String r1, int r2, int r3);

    PackageStateInternal getPackageStateForInstalledAndFiltered(String r1, int r2, int r3);

    PackageStateInternal getPackageStateInternal(String r1);

    PackageStateInternal getPackageStateInternal(String r1, int r2);

    ArrayMap<String, ? extends PackageStateInternal> getPackageStates();

    int getPackageUid(String r1, long r2, int r4);

    int getPackageUidInternal(String r1, long r2, int r4, int r5);

    List<AndroidPackage> getPackagesForAppId(int r1);

    String[] getPackagesForUid(int r1);

    ParceledListSlice<PackageInfo> getPackagesHoldingPermissions(String[] r1, long r2, int r4);

    Pair<List<VersionedPackage>, List<Boolean>> getPackagesUsingSharedLibrary(SharedLibraryInfo r1, long r2, int r4, int r5);

    List<ApplicationInfo> getPersistentApplications(boolean r1, int r2);

    PreferredIntentResolver getPreferredActivities(int r1);

    int getPrivateFlagsForUid(int r1);

    ArrayMap<String, ProcessInfo> getProcessesForUid(int r1);

    UserInfo getProfileParent(int r1);

    ProviderInfo getProviderInfo(ComponentName r1, long r2, int r4);

    ActivityInfo getReceiverInfo(ComponentName r1, long r2, int r4);

    String getRenamedPackage(String r1);

    ServiceInfo getServiceInfo(ComponentName r1, long r2, int r4);

    ParceledListSlice<SharedLibraryInfo> getSharedLibraries(String r1, long r2, int r4);

    WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> getSharedLibraries();

    SharedLibraryInfo getSharedLibraryInfo(String r1, long r2);

    SharedUserApi getSharedUser(int r1);

    ArraySet<PackageStateInternal> getSharedUserPackages(int r1);

    String[] getSharedUserPackagesForPackage(String r1, int r2);

    ArrayMap<String, ? extends SharedUserApi> getSharedUsers();

    SigningDetails getSigningDetails(int r1);

    SigningDetails getSigningDetails(String r1);

    KeySet getSigningKeySet(String r1);

    ArrayMap<String, String> getSystemSharedLibraryNamesAndPaths();

    int getTargetSdkVersion(String r1);

    int getUidForSharedUser(String r1);

    int getUidTargetSdkVersion(int r1);

    Set<String> getUnusedPackages(long r1);

    UserInfo[] getUserInfos();

    int getVersion();

    int[] getVisibilityAllowList(String r1, int r2);

    SparseArray<int[]> getVisibilityAllowLists(String r1, int[] r2);

    List<? extends PackageStateInternal> getVolumePackages(String r1);

    boolean hasSigningCertificate(String r1, byte[] r2, int r3);

    boolean hasUidSigningCertificate(int r1, byte[] r2, int r3);

    boolean isApexPackage(String r1);

    boolean isApplicationEffectivelyEnabled(String r1, UserHandle r2);

    boolean isCallerInstallerOfRecord(AndroidPackage r1, int r2);

    boolean isCallerSameApp(String r1, int r2);

    boolean isCallerSameApp(String r1, int r2, boolean r3);

    boolean isComponentEffectivelyEnabled(ComponentInfo r1, UserHandle r2);

    boolean isComponentVisibleToInstantApp(ComponentName r1);

    boolean isComponentVisibleToInstantApp(ComponentName r1, int r2);

    boolean isImplicitImageCaptureIntentAndNotSetByDpc(Intent r1, int r2, String r3, long r4);

    boolean isInstallDisabledForPackage(String r1, int r2, int r3);

    boolean isInstantApp(String r1, int r2);

    boolean isInstantAppInternal(String r1, int r2, int r3);

    boolean isPackageAvailable(String r1, int r2);

    boolean isPackageQuarantinedForUser(String r1, int r2) throws PackageManager.NameNotFoundException;

    boolean isPackageSignedByKeySet(String r1, KeySet r2);

    boolean isPackageSignedByKeySetExactly(String r1, KeySet r2);

    boolean isPackageStoppedForUser(String r1, int r2) throws PackageManager.NameNotFoundException;

    boolean isPackageSuspendedForUser(String r1, int r2) throws PackageManager.NameNotFoundException;

    boolean isSameProfileGroup(int r1, int r2);

    boolean isSuspendingAnyPackages(String r1, int r2, int r3);

    boolean isUidPrivileged(int r1);

    ParceledListSlice<ProviderInfo> queryContentProviders(String r1, int r2, long r3, String r5);

    ParceledListSlice<InstrumentationInfo> queryInstrumentationAsUser(String r1, int r2, int r3);

    List<ResolveInfo> queryIntentActivitiesInternal(Intent r1, String r2, long r3, int r5);

    List<ResolveInfo> queryIntentActivitiesInternal(Intent r1, String r2, long r3, int r5, int r6);

    List<ResolveInfo> queryIntentActivitiesInternal(Intent r1, String r2, long r3, long r5, int r7, int r8, int r9, boolean r10, boolean r11);

    QueryIntentActivitiesResult queryIntentActivitiesInternalBody(Intent r1, String r2, long r3, int r5, int r6, boolean r7, boolean r8, String r9, String r10);

    List<ResolveInfo> queryIntentServicesInternal(Intent r1, String r2, long r3, int r5, int r6, int r7, boolean r8, boolean r9);

    void querySyncProviders(boolean r1, List<String> r2, List<ProviderInfo> r3);

    ProviderInfo resolveContentProvider(String r1, long r2, int r4, int r5);

    ProviderInfo resolveContentProviderForUid(String r1, long r2, int r4, int r5);

    String resolveExternalPackageName(AndroidPackage r1);

    String resolveInternalPackageName(String r1, long r2);

    boolean shouldFilterApplication(SharedUserSetting r1, int r2, int r3);

    boolean shouldFilterApplication(PackageStateInternal r1, int r2, int r3);

    boolean shouldFilterApplication(PackageStateInternal r1, int r2, ComponentName r3, int r4, int r5);

    boolean shouldFilterApplication(PackageStateInternal r1, int r2, ComponentName r3, int r4, int r5, boolean r6);

    boolean shouldFilterApplicationIncludingUninstalled(SharedUserSetting r1, int r2, int r3);

    boolean shouldFilterApplicationIncludingUninstalled(PackageStateInternal r1, int r2, int r3);

    boolean shouldFilterApplicationIncludingUninstalledNotArchived(PackageStateInternal r1, int r2, int r3);

    long updateFlagsForApplication(long r1, int r3);

    long updateFlagsForComponent(long r1, int r3);

    long updateFlagsForPackage(long r1, int r3);

    long updateFlagsForResolve(long r1, int r3, int r4, boolean r5, boolean r6);

    long updateFlagsForResolve(long r1, int r3, int r4, boolean r5, boolean r6, boolean r7);

    Computer use();

    default int getUsed() {
        return 0;
    }
}
