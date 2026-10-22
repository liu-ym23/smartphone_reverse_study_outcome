package com.android.server.pm;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.doppelganger.DoppelgangerManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.AuxiliaryResolveInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.InstantAppRequest;
import android.content.pm.InstantAppResolveInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.KeySet;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ProcessInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.content.pm.SigningInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.pm.VersionedPackage;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelableException;
import android.os.Process;
import android.os.Trace;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.pico.utils.ExtImplFactory;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.LogPrinter;
import android.util.LongSparseLongArray;
import android.util.MathUtils;
import android.util.Pair;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Utils;
import android.util.Xml;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.IntentForwarderActivity;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalManagerRegistry;
import com.android.server.ondeviceintelligence.OnDeviceIntelligenceManagerLocal;
import com.android.server.pm.dex.DexManager;
import com.android.server.pm.dex.PackageDexUsage;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUtils;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.PackageUserStateUtils;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.resolution.ComponentResolver;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedLongSparseArray;
import com.android.server.utils.WatchedSparseBooleanArray;
import com.android.server.utils.WatchedSparseIntArray;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class ComputerEngine implements Computer {
    private static final Comparator<ProviderInfo> sProviderInitOrderSorter = null;
    private final ApexManager mApexManager;
    private final String mAppPredictionServicePackage;
    private final AppsFilterSnapshot mAppsFilter;
    private final CompilerStats mCompilerStats;
    private final ComponentResolverApi mComponentResolver;
    private final Context mContext;
    private final CrossProfileIntentResolverEngine mCrossProfileIntentResolverEngine;
    private final DefaultAppProvider mDefaultAppProvider;
    private final DexManager mDexManager;
    private final DomainVerificationManagerInternal mDomainVerificationManager;
    private IExtComputerEngine mExt;
    private final PackageManagerInternal.ExternalSourcesPolicy mExternalSourcesPolicy;
    private final WatchedArrayMap<String, Integer> mFrozenPackages;
    private final PackageManagerServiceInjector mInjector;
    private final ResolveInfo mInstantAppInstallerInfo;
    private final InstantAppRegistry mInstantAppRegistry;
    private final InstantAppResolverConnection mInstantAppResolverConnection;
    private final WatchedArrayMap<ComponentName, ParsedInstrumentation> mInstrumentation;
    private final WatchedSparseIntArray mIsolatedOwners;
    private final ApplicationInfo mLocalAndroidApplication;
    private final ActivityInfo mLocalInstantAppInstallerActivity;
    private final ComponentName mLocalResolveComponentName;
    private final PackageDexOptimizer mPackageDexOptimizer;
    private final WatchedArrayMap<String, AndroidPackage> mPackages;
    private final PermissionManagerServiceInternal mPermissionManager;
    private final ActivityInfo mResolveActivity;
    protected final PackageManagerService mService;
    protected final Settings mSettings;
    private final SharedLibrariesRead mSharedLibraries;
    private int mUsed;
    final UserManagerService mUserManager;
    private final int mVersion;
    private final WatchedSparseBooleanArray mWebInstantAppsDisabled;

    protected class Settings {
        private final com.android.server.pm.Settings mSettings;

        public ArrayMap<String, ? extends PackageStateInternal> getPackages() {
            return this.mSettings.getPackagesLocked().untrackedStorage();
        }

        public ArrayMap<String, ? extends PackageStateInternal> getDisabledSystemPackages() {
            return this.mSettings.getDisabledSystemPackagesLocked().untrackedStorage();
        }

        public Settings(ComputerEngine this$0, com.android.server.pm.Settings settings) {
            this.mSettings = settings;
        }

        public PackageStateInternal getPackage(String packageName) {
            return this.mSettings.getPackageLPr(packageName);
        }

        public PackageStateInternal getDisabledSystemPkg(String packageName) {
            return this.mSettings.getDisabledSystemPkgLPr(packageName);
        }

        public boolean isEnabledAndMatch(ComponentInfo componentInfo, int flags, int userId) {
            PackageStateInternal pkgState = getPackage(componentInfo.packageName);
            if (pkgState != null) goto L7;
            return false;
        L7:
            return PackageUserStateUtils.isMatch(pkgState.getUserStateOrDefault(userId), componentInfo, flags);
        }

        public boolean isEnabledAndMatch(AndroidPackage pkg, ParsedMainComponent component, long flags, int userId) {
            PackageStateInternal pkgState = getPackage(component.getPackageName());
            if (pkgState != null) goto L7;
            return false;
        L7:
            return PackageUserStateUtils.isMatch(pkgState.getUserStateOrDefault(userId), pkgState.isSystem(), pkg.isEnabled(), component, flags);
        }

        public CrossProfileIntentResolver getCrossProfileIntentResolver(int userId) {
            return this.mSettings.getCrossProfileIntentResolver(userId);
        }

        public SettingBase getSettingBase(int appId) {
            return this.mSettings.getSettingLPr(appId);
        }

        public String getRenamedPackageLPr(String packageName) {
            return this.mSettings.getRenamedPackageLPr(packageName);
        }

        public PersistentPreferredIntentResolver getPersistentPreferredActivities(int userId) {
            return this.mSettings.getPersistentPreferredActivities(userId);
        }

        public void dumpVersionLPr(IndentingPrintWriter indentingPrintWriter) {
            this.mSettings.dumpVersionLPr(indentingPrintWriter);
        }

        public void dumpPreferred(PrintWriter pw, DumpState dumpState, String packageName) {
            this.mSettings.dumpPreferred(pw, dumpState, packageName);
        }

        public void writePreferredActivitiesLPr(TypedXmlSerializer serializer, int userId, boolean full) throws IllegalArgumentException, IllegalStateException, IOException {
            this.mSettings.writePreferredActivitiesLPr(serializer, userId, full);
        }

        public PreferredIntentResolver getPreferredActivities(int userId) {
            return this.mSettings.getPreferredActivities(userId);
        }

        public SharedUserSetting getSharedUserFromId(String name) {
            return this.mSettings.getSharedUserLPw(name, 0, 0, false);
        L4:
            ignored = move-exception;
            throw new RuntimeException(ignored);
        }

        public boolean getBlockUninstall(int userId, String packageName) {
            return this.mSettings.getBlockUninstallLPr(userId, packageName);
        }

        public int getApplicationEnabledSetting(String packageName, int userId) throws PackageManager.NameNotFoundException {
            return this.mSettings.getApplicationEnabledSettingLPr(packageName, userId);
        }

        public int getComponentEnabledSetting(ComponentName component, int userId) throws PackageManager.NameNotFoundException {
            return this.mSettings.getComponentEnabledSettingLPr(component, userId);
        }

        public KeySetManagerService getKeySetManagerService() {
            return this.mSettings.getKeySetManagerService();
        }

        ArrayMap<String, ? extends SharedUserApi> getSharedUsers() {
            return this.mSettings.getSharedUsersLocked().untrackedStorage();
        }

        public SharedUserApi getSharedUserFromPackageName(String packageName) {
            return this.mSettings.getSharedUserSettingLPr(packageName);
        }

        public SharedUserApi getSharedUserFromAppId(int sharedUserAppId) {
            return (SharedUserSetting) this.mSettings.getSettingLPr(sharedUserAppId);
        }

        public ArraySet<PackageStateInternal> getSharedUserPackages(int sharedUserAppId) {
            ArraySet<PackageStateInternal> res = new ArraySet();
            SharedUserSetting sharedUserSetting = (SharedUserSetting) this.mSettings.getSettingLPr(sharedUserAppId);
            if (sharedUserSetting == null) goto L8;
            ArraySet<? extends PackageStateInternal> sharedUserPackages = sharedUserSetting.getPackageStates();
            Iterator<? extends PackageStateInternal> r3 = sharedUserPackages.iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            PackageStateInternal ps = r3.next();
            res.add(ps);
        L8:
            return res;
        }

        public void dumpPackagesProto(ProtoOutputStream proto) {
            this.mSettings.dumpPackagesProto(proto);
        }

        public void dumpPermissions(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState) {
            this.mSettings.dumpPermissions(pw, packageName, permissionNames, dumpState);
        }

        public void dumpPackages(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState, boolean checkin) {
            this.mSettings.dumpPackagesLPr(pw, packageName, permissionNames, dumpState, checkin);
        }

        public void dumpKeySet(PrintWriter pw, String packageName, DumpState dumpState) {
            this.mSettings.getKeySetManagerService().dumpLPr(pw, packageName, dumpState);
        }

        public void dumpSharedUsers(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState, boolean checkin) {
            this.mSettings.dumpSharedUsersLPr(pw, packageName, permissionNames, dumpState, checkin);
        }

        public void dumpReadMessages(PrintWriter pw, DumpState dumpState) {
            this.mSettings.dumpReadMessages(pw, dumpState);
        }

        public void dumpSharedUsersProto(ProtoOutputStream proto) {
            this.mSettings.dumpSharedUsersProto(proto);
        }

        public List<? extends PackageStateInternal> getVolumePackages(String volumeUuid) {
            return this.mSettings.getVolumePackagesLPr(volumeUuid);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$ZsQO-GMd1VCddKx0WIWHtlgezQI, reason: not valid java name */
    public static /* synthetic */ int m6615$r8$lambda$ZsQOGMd1VCddKx0WIWHtlgezQI(ProviderInfo r0, ProviderInfo r1) {
        return lambda$static$0(r0, r1);
    }

    static {
        sProviderInitOrderSorter = new ComputerEngine$$ExternalSyntheticLambda1();
    }

    private static /* synthetic */ int lambda$static$0(ProviderInfo p1, ProviderInfo p2) {
        int v1 = p1.initOrder;
        int v2 = p2.initOrder;
        if (v1 <= v2) goto L5;
        return -1;
    L5:
        if (v1 >= v2) goto L7;
        return 1;
    L7:
        return 0;
    }

    private boolean safeMode() {
        return this.mService.getSafeMode();
    }

    protected ComponentName resolveComponentName() {
        return this.mLocalResolveComponentName;
    }

    protected ActivityInfo instantAppInstallerActivity() {
        return this.mLocalInstantAppInstallerActivity;
    }

    protected ApplicationInfo androidApplication() {
        return this.mLocalAndroidApplication;
    }

    ComputerEngine(PackageManagerService.Snapshot args, int version) {
        this.mUsed = 0;
        this.mExt = (IExtComputerEngine) ExtImplFactory.getImpl(IExtComputerEngine.class, new Object[]{this});
        this.mVersion = version;
        this.mSettings = new Settings(this, args.settings);
        this.mIsolatedOwners = args.isolatedOwners;
        this.mPackages = args.packages;
        this.mSharedLibraries = args.sharedLibraries;
        this.mInstrumentation = args.instrumentation;
        this.mWebInstantAppsDisabled = args.webInstantAppsDisabled;
        this.mLocalResolveComponentName = args.resolveComponentName;
        this.mResolveActivity = args.resolveActivity;
        this.mLocalInstantAppInstallerActivity = args.instantAppInstallerActivity;
        this.mInstantAppInstallerInfo = args.instantAppInstallerInfo;
        this.mInstantAppRegistry = args.instantAppRegistry;
        this.mLocalAndroidApplication = args.androidApplication;
        this.mAppsFilter = args.appsFilter;
        this.mFrozenPackages = args.frozenPackages;
        this.mComponentResolver = args.componentResolver;
        this.mAppPredictionServicePackage = args.appPredictionServicePackage;
        this.mPermissionManager = args.service.mPermissionManager;
        this.mUserManager = args.service.mUserManager;
        this.mContext = args.service.mContext;
        this.mInjector = args.service.mInjector;
        this.mApexManager = args.service.mApexManager;
        this.mInstantAppResolverConnection = args.service.mInstantAppResolverConnection;
        this.mDefaultAppProvider = args.service.getDefaultAppProvider();
        this.mDomainVerificationManager = args.service.mDomainVerificationManager;
        this.mPackageDexOptimizer = args.service.mPackageDexOptimizer;
        this.mDexManager = args.service.getDexManager();
        this.mCompilerStats = args.service.mCompilerStats;
        this.mExternalSourcesPolicy = args.service.mExternalSourcesPolicy;
        this.mCrossProfileIntentResolverEngine = new CrossProfileIntentResolverEngine(this.mUserManager, this.mDomainVerificationManager, this.mDefaultAppProvider, this.mContext);
        this.mService = args.service;
    }

    @Override // com.android.server.pm.Computer
    public int getVersion() {
        return this.mVersion;
    }

    @Override // com.android.server.pm.Computer
    public final Computer use() {
        this.mUsed++;
        return this;
    }

    @Override // com.android.server.pm.Computer
    public final int getUsed() {
        return this.mUsed;
    }

    @Override // com.android.server.pm.Computer
    public final List<ResolveInfo> queryIntentActivitiesInternal(Intent intent, String resolvedType, long flags, long privateResolveFlags, int filterCallingUid, int callingPid, int userId, boolean resolveForStart, boolean allowDynamicSplits) {
        if (this.mUserManager.exists(userId) == false) goto L5;
        long flags2 = flags | 8589934592L;
        String instantAppPkgName = getInstantAppPackageName(filterCallingUid);
        enforceCrossUserPermission(Binder.getCallingUid(), userId, false, false, "query intent activities");
        String pkgName = intent.getPackage();
        ComponentName comp = intent.getComponent();
        if (comp == null) goto L9;
    L11:
        ComponentName comp2 = comp;
        Intent intent2 = intent;
        Intent originalIntent = null;
    L12:
        if (comp2 != null) goto L16;
        if (pkgName != null) goto L16;
        boolean r6 = false;
    L17:
        Intent intent3 = intent2;
        long flags3 = updateFlagsForResolve(flags2, userId, filterCallingUid, resolveForStart, r6, isImplicitImageCaptureIntentAndNotSetByDpc(intent2, userId, resolvedType, flags2));
        SaferIntentUtils.IntentArgs args = new SaferIntentUtils.IntentArgs(intent3, resolvedType, false, resolveForStart, filterCallingUid, callingPid);
        args.platformCompat = this.mInjector.getCompatibility();
        args.snapshot = this;
        List<ResolveInfo> list = Collections.emptyList();
        boolean skipPostResolution = false;
        if (comp2 == null) goto L92;
        ActivityInfo ai = getActivityInfo(comp2, flags3, userId);
        if (ai != null) goto L22;
        Intent intent4 = intent3;
    L91:
        int r7 = userId;
        List<ResolveInfo> list2 = list;
        SaferIntentUtils.IntentArgs args2 = args;
        ComputerEngine r0 = this;
        Intent intent5 = intent4;
        int r9 = filterCallingUid;
    L104:
        if (originalIntent == null) goto L106;
        args2.intent = originalIntent;
        SaferIntentUtils.enforceIntentFilterMatching(args2, list2);
    L106:
        r0.mService.getSmtEx().queryIntentActivitiesInternalSmtEx(intent5, r7, list2);
        if (skipPostResolution == false) goto L110;
        return list2;
    L110:
        return r0.applyPostResolutionFilter(list2, instantAppPkgName, allowDynamicSplits, r9, resolveForStart, r7, intent5);
    L22:
        if ((8388608 & flags3) == 0) goto L24;
        boolean matchInstantApp = true;
    L26:
        if ((16777216 & flags3) == 0) goto L28;
        boolean matchVisibleToInstantAppOnly = true;
    L30:
        if ((flags3 & 33554432) == 0) goto L32;
        boolean matchExplicitlyVisibleOnly = true;
    L33:
        if (instantAppPkgName == null) goto L35;
        boolean isCallerInstantApp = true;
    L36:
        intent4 = intent3;
        boolean isTargetSameInstantApp = comp2.getPackageName().equals(instantAppPkgName);
        if ((ai.applicationInfo.privateFlags & 128) == 0) goto L39;
        boolean isTargetInstantApp = true;
    L40:
        boolean isTargetInstantApp2 = isTargetInstantApp;
        if ((ai.flags & 1048576) == 0) goto L43;
        boolean isTargetVisibleToInstantApp = true;
    L44:
        if (isTargetVisibleToInstantApp == false) goto L48;
        boolean isTargetVisibleToInstantApp2 = isTargetVisibleToInstantApp;
        if ((ai.flags & 2097152) != 0) goto L49;
        boolean isTargetExplicitlyVisibleToInstantApp = true;
    L50:
        if (isTargetVisibleToInstantApp2 == false) goto L55;
        if (matchExplicitlyVisibleOnly == false) goto L54;
        if (isTargetExplicitlyVisibleToInstantApp == false) goto L55;
    L54:
        boolean isTargetHiddenFromInstantApp = false;
    L56:
        if (isTargetSameInstantApp == true) goto L64;
        if (matchInstantApp == true) goto L60;
        if (isCallerInstantApp == true) goto L60;
        if (isTargetInstantApp2 == false) goto L60;
    L63:
        boolean blockInstantResolution = true;
    L65:
        if (resolveForStart == false) goto L72;
        boolean isTargetExplicitlyVisibleToInstantApp2 = ai.exported;
        if (isTargetExplicitlyVisibleToInstantApp2 == true) goto L72;
        if (isCallerSameApp(pkgName, filterCallingUid) == true) goto L72;
        boolean resolveForStartNonExported = true;
    L74:
        if (resolveForStart == false) goto L78;
        if (resolveForStartNonExported == true) goto L78;
    L84:
        boolean resolveForStartNonExported2 = false;
    L86:
        if (blockInstantResolution == true) goto L91;
        if (resolveForStartNonExported2 == true) goto L91;
        ResolveInfo ri = new ResolveInfo();
        ri.activityInfo = ai;
        ri.userHandle = UserHandle.of(userId);
        List<ResolveInfo> list3 = new ArrayList(1);
        list3.add(ri);
        SaferIntentUtils.enforceIntentFilterMatching(args, list3);
        list = list3;
    L78:
        if (isTargetInstantApp2 == true) goto L84;
        if (isCallerInstantApp == true) goto L84;
        if (shouldFilterApplication(getPackageStateInternal(ai.applicationInfo.packageName, 1000), filterCallingUid, userId) == false) goto L84;
        resolveForStartNonExported2 = true;
    L72:
        resolveForStartNonExported = false;
    L60:
        if (matchVisibleToInstantAppOnly == false) goto L64;
        if (isCallerInstantApp == false) goto L64;
        if (isTargetHiddenFromInstantApp == true) goto L63;
    L64:
        blockInstantResolution = false;
    L55:
        isTargetHiddenFromInstantApp = true;
    L49:
        isTargetExplicitlyVisibleToInstantApp = false;
        goto L50
    L48:
        isTargetVisibleToInstantApp2 = isTargetVisibleToInstantApp;
        goto L49
    L43:
        isTargetVisibleToInstantApp = false;
        goto L44
    L39:
        isTargetInstantApp = false;
        goto L40
    L35:
        isCallerInstantApp = false;
        goto L36
    L32:
        matchExplicitlyVisibleOnly = false;
        goto L33
    L28:
        matchVisibleToInstantAppOnly = false;
        goto L30
    L24:
        matchInstantApp = false;
        goto L26
    L92:
        r7 = userId;
        args2 = args;
        r0 = this;
        QueryIntentActivitiesResult lockedResult = r0.queryIntentActivitiesInternalBody(intent3, resolvedType, flags3, filterCallingUid, r7, resolveForStart, allowDynamicSplits, pkgName, instantAppPkgName);
        r9 = filterCallingUid;
        if (lockedResult.answer == null) goto L96;
        skipPostResolution = true;
        intent5 = intent3;
        list2 = lockedResult.answer;
    L103:
        SaferIntentUtils.blockNullAction(args2, list2);
        goto L104
    L96:
        if (lockedResult.addInstant == false) goto L98;
        String callingPkgName = r0.getInstantAppPackageName(r9);
        boolean isRequesterInstantApp = r0.isInstantApp(callingPkgName, r7);
        intent5 = intent3;
        lockedResult.result = r0.maybeAddInstantAppInstaller(lockedResult.result, intent3, resolvedType, flags3, r7, resolveForStart, isRequesterInstantApp);
    L100:
        if (lockedResult.sortResult == false) goto L102;
        lockedResult.result.sort(ComponentResolver.RESOLVE_PRIORITY_SORTER);
    L102:
        list2 = lockedResult.result;
        goto L103
    L98:
        intent5 = intent3;
    L16:
        r6 = true;
        goto L17
    L9:
        if (intent.getSelector() == null) goto L11;
        Intent intent6 = intent.getSelector();
        comp2 = intent6.getComponent();
        intent2 = intent6;
        originalIntent = intent;
        goto L12
    L5:
        return Collections.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public final List<ResolveInfo> queryIntentActivitiesInternal(Intent intent, String resolvedType, long flags, int filterCallingUid, int userId) {
        return queryIntentActivitiesInternal(intent, resolvedType, flags, 0, filterCallingUid, -1, userId, false, true);
    }

    @Override // com.android.server.pm.Computer
    public final List<ResolveInfo> queryIntentActivitiesInternal(Intent intent, String resolvedType, long flags, int userId) {
        return queryIntentActivitiesInternal(intent, resolvedType, flags, 0, Binder.getCallingUid(), -1, userId, false, true);
    }

    @Override // com.android.server.pm.Computer
    public final List<ResolveInfo> queryIntentServicesInternal(Intent intent, String resolvedType, long flags, int userId, int callingUid, int callingPid, boolean includeInstantApps, boolean resolveForStart) {
        if (this.mUserManager.exists(userId) == false) goto L5;
        enforceCrossUserOrProfilePermission(Binder.getCallingUid(), userId, false, false, "query intent services");
        String instantAppPkgName = getInstantAppPackageName(callingUid);
        long flags2 = updateFlagsForResolve(flags, userId, callingUid, includeInstantApps, false);
        SaferIntentUtils.IntentArgs args = new SaferIntentUtils.IntentArgs(intent, resolvedType, false, resolveForStart, callingUid, callingPid);
        args.platformCompat = this.mInjector.getCompatibility();
        args.snapshot = this;
        ComponentName comp = intent.getComponent();
        if (comp == null) goto L9;
    L11:
        ComponentName comp2 = comp;
        Intent intent2 = intent;
        Intent originalIntent = null;
    L12:
        List<ResolveInfo> list = Collections.emptyList();
        if (comp2 == null) goto L58;
        ServiceInfo si = getServiceInfo(comp2, flags2, userId);
        if (si != null) goto L17;
        Intent intent3 = intent2;
    L59:
        if (originalIntent == null) goto L61;
        args.intent = originalIntent;
        SaferIntentUtils.enforceIntentFilterMatching(args, list);
    L61:
        return list;
    L17:
        if ((8388608 & flags2) == 0) goto L19;
        boolean matchInstantApp = true;
    L21:
        if ((flags2 & 16777216) == 0) goto L23;
        boolean matchVisibleToInstantAppOnly = true;
    L24:
        if (instantAppPkgName == null) goto L26;
        boolean isCallerInstantApp = true;
    L27:
        boolean isTargetSameInstantApp = comp2.getPackageName().equals(instantAppPkgName);
        intent3 = intent2;
        if ((si.applicationInfo.privateFlags & 128) == 0) goto L30;
        boolean isTargetInstantApp = true;
    L31:
        boolean isTargetInstantApp2 = isTargetInstantApp;
        if ((si.flags & 1048576) != 0) goto L34;
        boolean isTargetHiddenFromInstantApp = true;
    L35:
        if (isTargetSameInstantApp == true) goto L43;
        if (matchInstantApp == true) goto L39;
        if (isCallerInstantApp == true) goto L39;
        if (isTargetInstantApp2 == false) goto L39;
    L42:
        boolean blockInstantResolution = true;
    L44:
        if (isTargetInstantApp2 == true) goto L50;
        if (isCallerInstantApp == true) goto L50;
        if (shouldFilterApplication(getPackageStateInternal(si.applicationInfo.packageName, 1000), callingUid, userId) == false) goto L50;
        boolean blockNormalResolution = true;
    L52:
        if (blockInstantResolution == true) goto L59;
        if (blockNormalResolution == true) goto L59;
        ResolveInfo ri = new ResolveInfo();
        ri.serviceInfo = si;
        list = new ArrayList(1);
        list.add(ri);
        SaferIntentUtils.enforceIntentFilterMatching(args, list);
    L50:
        blockNormalResolution = false;
    L39:
        if (matchVisibleToInstantAppOnly == false) goto L43;
        if (isCallerInstantApp == false) goto L43;
        if (isTargetHiddenFromInstantApp == true) goto L42;
    L43:
        blockInstantResolution = false;
        goto L44
    L34:
        isTargetHiddenFromInstantApp = false;
        goto L35
    L30:
        isTargetInstantApp = false;
        goto L31
    L26:
        isCallerInstantApp = false;
        goto L27
    L23:
        matchVisibleToInstantAppOnly = false;
        goto L24
    L19:
        matchInstantApp = false;
        goto L21
    L58:
        list = queryIntentServicesInternalBody(intent2, resolvedType, flags2, userId, callingUid, instantAppPkgName);
        SaferIntentUtils.blockNullAction(args, list);
        goto L59
    L9:
        if (intent.getSelector() == null) goto L11;
        Intent intent4 = intent.getSelector();
        comp2 = intent4.getComponent();
        intent2 = intent4;
        originalIntent = intent;
        goto L12
    L5:
        return Collections.emptyList();
    }

    protected List<ResolveInfo> queryIntentServicesInternalBody(Intent intent, String resolvedType, long flags, int userId, int callingUid, String instantAppPkgName) {
        String pkgName = intent.getPackage();
        if (pkgName != null) goto L10;
        List<ResolveInfo> resolveInfos = this.mComponentResolver.queryServices(this, intent, resolvedType, flags, userId);
        if (resolveInfos != null) goto L9;
        return Collections.emptyList();
    L9:
        return applyPostServiceResolutionFilter(resolveInfos, instantAppPkgName, userId, callingUid);
    L10:
        AndroidPackage pkg = this.mPackages.get(pkgName);
        if (pkg == null) goto L19;
        List<ResolveInfo> resolveInfos2 = this.mComponentResolver.queryServices(this, intent, resolvedType, flags, pkg.getServices(), userId);
        if (resolveInfos2 != null) goto L17;
        return Collections.emptyList();
    L17:
        return applyPostServiceResolutionFilter(resolveInfos2, instantAppPkgName, userId, callingUid);
    L19:
        return Collections.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public QueryIntentActivitiesResult queryIntentActivitiesInternalBody(Intent intent, String resolvedType, long flags, int filterCallingUid, int userId, boolean resolveForStart, boolean allowDynamicSplits, String pkgName, String instantAppPkgName) {
        ComputerEngine r1 = this;
        int r3 = userId;
        boolean sortResult = false;
        List<ResolveInfo> result = new ArrayList();
        new ArrayList();
        if (pkgName == null) goto L5;
        PackageStateInternal setting = r1.getPackageStateInternal(pkgName, 1000);
        if (setting == null) goto L29;
        if (setting.getAndroidPackage() == null) goto L29;
        if (resolveForStart == true) goto L24;
        if (r1.shouldFilterApplication(setting, filterCallingUid, r3) == true) goto L29;
    L24:
        List<ResolveInfo> queryResult = r1.mComponentResolver.queryActivities(r1, intent, resolvedType, flags, setting.getAndroidPackage().getActivities(), r3);
        r3 = r3;
        if (queryResult == null) goto L29;
        result.addAll(r1.filterIfNotSystemUser(queryResult, r3));
    L29:
        if (result.size() != 0) goto L31;
        boolean addInstant = r1.isInstantAppResolutionAllowed(intent, null, r3, true, flags);
        r1 = r1;
        boolean addInstant2 = addInstant;
    L32:
        CrossProfileIntentResolverEngine r0 = r1.mCrossProfileIntentResolverEngine;
        final Settings r2 = r1.mSettings;
        r2.getClass();
        int r4 = userId;
        List<CrossProfileDomainInfo> crossProfileResults = r0.resolveIntent(r1, intent, resolvedType, userId, flags, pkgName, false, resolveForStart, new ComputerEngine$$ExternalSyntheticLambda0(r2));
        boolean sortResult2 = false;
    L33:
        CrossProfileIntentResolverEngine r5 = r1.mCrossProfileIntentResolverEngine;
        boolean r15 = r1.areWebInstantAppsDisabled(r4);
        final Settings r6 = r1.mSettings;
        r6.getClass();
        return r5.combineFilterAndCreateQueryActivitiesResponse(r1, intent, resolvedType, instantAppPkgName, pkgName, allowDynamicSplits, flags, r4, filterCallingUid, resolveForStart, result, crossProfileResults, r15, addInstant2, sortResult2, new ComputerEngine$$ExternalSyntheticLambda0(r6));
    L31:
        addInstant2 = false;
        goto L32
    L5:
        if (r1.mCrossProfileIntentResolverEngine.shouldSkipCurrentProfile(r1, intent, resolvedType, r3) == true) goto L9;
        List<ResolveInfo> queryResult2 = r1.mComponentResolver.queryActivities(r1, intent, resolvedType, flags, r3);
        r3 = r3;
        if (queryResult2 == null) goto L9;
        result.addAll(r1.filterIfNotSystemUser(queryResult2, r3));
    L9:
        boolean addInstant3 = r1.isInstantAppResolutionAllowed(intent, result, r3, false, flags);
        r1 = r1;
        result = result;
        boolean hasNonNegativePriorityResult = r1.hasNonNegativePriority(result);
        CrossProfileIntentResolverEngine r7 = r1.mCrossProfileIntentResolverEngine;
        final Settings r8 = r1.mSettings;
        r8.getClass();
        List<CrossProfileDomainInfo> crossProfileResults2 = r7.resolveIntent(r1, intent, resolvedType, userId, flags, pkgName, hasNonNegativePriorityResult, resolveForStart, new ComputerEngine$$ExternalSyntheticLambda0(r8));
        r4 = userId;
        if (intent.hasWebURI() == false) goto L12;
    L13:
        sortResult = true;
    L14:
        addInstant2 = addInstant3;
        sortResult2 = sortResult;
        crossProfileResults = crossProfileResults2;
        goto L33
    L12:
        if (crossProfileResults2.isEmpty() == true) goto L14;
        goto L13
    }

    private ComponentName findInstallFailureActivity(String packageName, int filterCallingUid, int userId) {
        Intent failureActivityIntent = new Intent("android.intent.action.INSTALL_FAILURE");
        failureActivityIntent.setPackage(packageName);
        List<ResolveInfo> result = queryIntentActivitiesInternal(failureActivityIntent, null, 0, 0, filterCallingUid, -1, userId, false, false);
        int numResults = result.size();
        if (numResults <= 0) goto L11;
        int i = 0;
    L5:
        if (i >= numResults) goto L15;
        ResolveInfo info = result.get(i);
        if (info.activityInfo.splitName == null) goto L10;
        i = i + 1;
        goto L5
    L10:
        return new ComponentName(packageName, info.activityInfo.name);
    L15:
        return null;
    L11:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public final ActivityInfo getActivityInfo(ComponentName component, long flags, int userId) {
        return getActivityInfoInternal(component, flags, Binder.getCallingUid(), userId);
    }

    @Override // com.android.server.pm.Computer
    public final ActivityInfo getActivityInfoCrossProfile(ComponentName component, long flags, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L7;
        return null;
    L7:
        return getActivityInfoInternalBody(component, updateFlagsForComponent(flags, userId), Binder.getCallingUid(), userId);
    }

    @Override // com.android.server.pm.Computer
    public final ActivityInfo getActivityInfoInternal(ComponentName component, long flags, int filterCallingUid, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L6;
        return null;
    L6:
        long flags2 = updateFlagsForComponent(flags, userId);
        if (isRecentsAccessingChildProfiles(Binder.getCallingUid(), userId) == true) goto L10;
        enforceCrossUserPermission(Binder.getCallingUid(), userId, false, false, "get activity info");
    L10:
        return getActivityInfoInternalBody(component, flags2, filterCallingUid, userId);
    }

    protected ActivityInfo getActivityInfoInternalBody(ComponentName component, long flags, int filterCallingUid, int userId) {
        ParsedMainComponent r1 = this.mComponentResolver.getActivity(component);
        long flags2 = 8589934592L | flags;
        if (r1 != null) goto L5;
        AndroidPackage pkg = null;
    L6:
        if (pkg == null) goto L18;
        AndroidPackage pkg2 = pkg;
        if (this.mSettings.isEnabledAndMatch(pkg2, r1, flags2, userId) == false) goto L17;
        PackageStateInternal ps = this.mSettings.getPackage(component.getPackageName());
        if (ps != null) goto L13;
        return null;
    L13:
        if (shouldFilterApplication(ps, filterCallingUid, component, 1, userId) == false) goto L16;
        return null;
    L16:
        return PackageInfoUtils.generateActivityInfo(pkg2, r1, flags2, ps.getUserStateOrDefault(userId), userId, ps);
    L17:
        long flags3 = flags2;
    L20:
        if (resolveComponentName().equals(component) == true) goto L22;
        return null;
    L22:
        return PackageInfoUtils.generateDelegateActivityInfo(this.mResolveActivity, flags3, PackageUserStateInternal.DEFAULT, userId);
    L18:
        flags3 = flags2;
        goto L20
    L5:
        pkg = this.mPackages.get(r1.getPackageName());
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public AndroidPackage getPackage(String packageName) {
        String packageName2 = resolveInternalPackageName(packageName, -1);
        return this.mPackages.get(packageName2);
    }

    @Override // com.android.server.pm.Computer
    public AndroidPackage getPackage(int uid) {
        String[] packageNames = getPackagesForUidInternal(uid, 1000);
        AndroidPackage pkg = null;
        if (packageNames != null) goto L5;
        int numPackages = 0;
    L6:
        int i = 0;
    L7:
        if (pkg != null) goto L10;
        if (i >= numPackages) goto L10;
        AndroidPackage pkg2 = this.mPackages.get(packageNames[i]);
        pkg = pkg2;
        i = i + 1;
    L10:
        return pkg;
    L5:
        numPackages = packageNames.length;
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public final ApplicationInfo generateApplicationInfoFromSettings(String packageName, long flags, int filterCallingUid, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (ps != null) goto L8;
        return null;
    L8:
        if (filterSharedLibPackage(ps, filterCallingUid, userId, flags) == false) goto L11;
        return null;
    L11:
        if (shouldFilterApplication(ps, filterCallingUid, userId) == false) goto L14;
        return null;
    L14:
        if (ps.getAndroidPackage() != null) goto L20;
        PackageInfo pInfo = generatePackageInfo(ps, flags, userId);
        if (pInfo != null) goto L18;
        return null;
    L18:
        return pInfo.applicationInfo;
    L20:
        ApplicationInfo ai = PackageInfoUtils.generateApplicationInfo(ps.getPkg(), flags, ps.getUserStateOrDefault(userId), userId, ps);
        if (ai == null) goto L23;
        ai.packageName = resolveExternalPackageName(ps.getPkg());
    L23:
        return ai;
    }

    @Override // com.android.server.pm.Computer
    public final ApplicationInfo getApplicationInfo(String packageName, long flags, int userId) {
        return getApplicationInfoInternal(packageName, flags, Binder.getCallingUid(), userId);
    }

    @Override // com.android.server.pm.Computer
    public final ApplicationInfo getApplicationInfoInternal(String packageName, long flags, int filterCallingUid, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L6;
        return null;
    L6:
        long flags2 = updateFlagsForApplication(flags, userId);
        if (isRecentsAccessingChildProfiles(Binder.getCallingUid(), userId) == true) goto L10;
        enforceCrossUserPermission(Binder.getCallingUid(), userId, false, false, "get application info");
    L10:
        return getApplicationInfoInternalBody(packageName, flags2, filterCallingUid, userId);
    }

    protected ApplicationInfo getApplicationInfoInternalBody(String packageName, long flags, int filterCallingUid, int userId) {
        String packageName2 = resolveInternalPackageName(packageName, -1);
        AndroidPackage p = this.mPackages.get(packageName2);
        if ((flags & 1073741824) == 0) goto L5;
        boolean r1 = true;
    L6:
        boolean matchApex = r1;
        if (p == null) goto L30;
        PackageStateInternal ps = this.mSettings.getPackage(packageName2);
        if (ps != null) goto L11;
        return null;
    L11:
        if (matchApex == true) goto L16;
        if (p.isApex() == false) goto L16;
        return null;
    L16:
        if (filterSharedLibPackage(ps, filterCallingUid, userId, flags) == false) goto L19;
        return null;
    L19:
        if (shouldFilterApplication(ps, filterCallingUid, userId) == false) goto L21;
        return null;
    L21:
        ApplicationInfo ai = PackageInfoUtils.generateApplicationInfo(p, flags, ps.getUserStateOrDefault(userId), userId, ps);
        if (ai == null) goto L24;
        ai.packageName = resolveExternalPackageName(p);
    L24:
        if (ai != null) goto L28;
        if (userId != 10) goto L28;
        return PackageInfoUtils.generateApplicationInfo(p, flags, ps.getUserStateOrDefault(0), 0, ps);
    L28:
        return ai;
    L30:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName2) == true) goto L44;
        if ("system".equals(packageName2) == true) goto L44;
        if ((flags & 4299169792L) == 0) goto L41;
        ApplicationInfo info = generateApplicationInfoFromSettings(packageName2, flags, filterCallingUid, userId);
        if (info != null) goto L46;
        if (userId == 10) goto L40;
        return info;
    L40:
        return generateApplicationInfoFromSettings(packageName2, flags, filterCallingUid, 0);
    L46:
        return info;
    L41:
        return null;
    L44:
        return androidApplication();
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public final ComponentName getDefaultHomeActivity(int userId) {
        List<ResolveInfo> allHomeCandidates = new ArrayList();
        ComponentName cn = getHomeActivitiesAsUser(allHomeCandidates, userId);
        if (cn == null) goto L5;
        return cn;
    L5:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Default package for ROLE_HOME is not set in RoleManager");
        int lastPriority = Integer.MIN_VALUE;
        ComponentName lastComponent = null;
        int size = allHomeCandidates.size();
        int i = 0;
    L6:
        if (i >= size) goto L15;
        ResolveInfo ri = allHomeCandidates.get(i);
        if (ri.priority <= lastPriority) goto L11;
        lastComponent = ri.activityInfo.getComponentName();
        lastPriority = ri.priority;
    L13:
        i = i + 1;
        goto L6
    L11:
        if (ri.priority != lastPriority) goto L13;
        lastComponent = null;
        goto L13
    L15:
        return lastComponent;
    }

    @Override // com.android.server.pm.Computer
    public final ComponentName getHomeActivitiesAsUser(List<ResolveInfo> allHomeCandidates, int userId) {
        Intent intent = getHomeIntent();
        List<ResolveInfo> resolveInfos = queryIntentActivitiesInternal(intent, null, 128, userId);
        allHomeCandidates.clear();
        if (resolveInfos != null) goto L5;
        return null;
    L5:
        allHomeCandidates.addAll(resolveInfos);
        String packageName = this.mDefaultAppProvider.getDefaultHome(userId);
        if (packageName != null) goto L17;
        int appId = UserHandle.getAppId(Binder.getCallingUid());
        if (appId < 10000) goto L11;
        boolean r3 = true;
    L10:
        boolean filtered = r3;
        List<ResolveInfo> resolveInfos2 = resolveInfos;
        PackageManagerService.FindPreferredActivityBodyResult result = findPreferredActivityInternal(intent, null, 0, resolveInfos2, true, false, false, userId, filtered);
        ResolveInfo preferredResolveInfo = result.mPreferredResolveInfo;
        if (preferredResolveInfo != null) goto L15;
    L18:
        if (packageName != null) goto L20;
        return null;
    L20:
        int resolveInfosSize = resolveInfos2.size();
        int i = 0;
    L21:
        if (i >= resolveInfosSize) goto L30;
        ResolveInfo resolveInfo = resolveInfos2.get(i);
        if (resolveInfo.activityInfo == null) goto L28;
        if (TextUtils.equals(resolveInfo.activityInfo.packageName, packageName) == false) goto L28;
        return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
    L28:
        i = i + 1;
        goto L21
    L30:
        return null;
    L15:
        if (preferredResolveInfo.activityInfo == null) goto L18;
        packageName = preferredResolveInfo.activityInfo.packageName;
        goto L18
    L11:
        r3 = false;
        goto L10
    L17:
        resolveInfos2 = resolveInfos;
        goto L18
    }

    @Override // com.android.server.pm.Computer
    public final CrossProfileDomainInfo getCrossProfileDomainPreferredLpr(Intent intent, String resolvedType, long flags, int sourceUserId, int parentUserId) {
        if (this.mUserManager.hasUserRestriction("allow_parent_profile_app_linking", sourceUserId) == true) goto L5;
        return null;
    L5:
        List<ResolveInfo> resultTargetUser = this.mComponentResolver.queryActivities(this, intent, resolvedType, flags, parentUserId);
        if (resultTargetUser == null) goto L30;
        if (resultTargetUser.isEmpty() == true) goto L30;
        int size = resultTargetUser.size();
        CrossProfileDomainInfo result = null;
        int i = 0;
    L11:
        if (i >= size) goto L24;
        ResolveInfo riTargetUser = resultTargetUser.get(i);
        if (riTargetUser.handleAllWebDataURI == true) goto L22;
        String packageName = riTargetUser.activityInfo.packageName;
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (ps == null) goto L22;
        int approvalLevel = this.mDomainVerificationManager.approvalLevelForDomain(ps, intent, flags, parentUserId);
        if (result != null) goto L21;
        result = new CrossProfileDomainInfo(createForwardingResolveInfoUnchecked(new WatchedIntentFilter(), sourceUserId, parentUserId), approvalLevel, parentUserId);
        goto L22
    L21:
        result.mHighestApprovalLevel = Math.max(approvalLevel, result.mHighestApprovalLevel);
    L22:
        i = i + 1;
        goto L11
    L24:
        if (result != null) goto L26;
    L28:
        return result;
    L26:
        if (result.mHighestApprovalLevel > 0) goto L28;
        return null;
    L30:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public final Intent getHomeIntent() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.addCategory("android.intent.category.DEFAULT");
        return intent;
    }

    @Override // com.android.server.pm.Computer
    public final List<CrossProfileIntentFilter> getMatchingCrossProfileIntentFilters(Intent intent, String resolvedType, int userId) {
        CrossProfileIntentResolver resolver = this.mSettings.getCrossProfileIntentResolver(userId);
        if (resolver == null) goto L7;
        return resolver.queryIntent(this, intent, resolvedType, false, userId);
    L7:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public final List<ResolveInfo> applyPostResolutionFilter(List<ResolveInfo> resolveInfos, String ephemeralPkgName, boolean allowDynamicSplits, int filterCallingUid, boolean resolveForStart, int userId, Intent intent) {
        ComputerEngine r1 = this;
        int r5 = userId;
        boolean r9 = true;
        if (intent.isWebIntent() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean blockInstant = r0;
        int i = resolveInfos.size() - 1;
    L9:
        if (i < 0) goto L60;
        ResolveInfo info = resolveInfos.get(i);
        if (info.isInstantAppAvailable == false) goto L14;
        if (blockInstant == false) goto L14;
        resolveInfos.remove(i);
        r9 = r9;
    L58:
        i = i - 1;
        r1 = this;
        r5 = userId;
        r9 = r9;
    L14:
        if (allowDynamicSplits == false) goto L31;
        if (info.activityInfo == null) goto L31;
        if (info.activityInfo.splitName == null) goto L31;
        if (ArrayUtils.contains(info.activityInfo.applicationInfo.splitNames, info.activityInfo.splitName) == true) goto L31;
        if (r1.instantAppInstallerActivity() != null) goto L24;
        resolveInfos.remove(i);
        r9 = r9;
        goto L58
    L24:
        if (blockInstant == true) goto L26;
    L28:
        ResolveInfo installerInfo = new ResolveInfo(r1.mInstantAppInstallerInfo);
        ComponentName installFailureActivity = r1.findInstallFailureActivity(info.activityInfo.packageName, filterCallingUid, r5);
        installerInfo.auxiliaryInfo = new AuxiliaryResolveInfo(installFailureActivity, info.activityInfo.packageName, info.activityInfo.applicationInfo.longVersionCode, info.activityInfo.splitName);
        installerInfo.filter = new IntentFilter();
        installerInfo.resolvePackageName = info.getComponentInfo().packageName;
        installerInfo.labelRes = info.resolveLabelResId();
        installerInfo.icon = info.resolveIconResId();
        r9 = true;
        installerInfo.isInstantAppAvailable = true;
        resolveInfos.set(i, installerInfo);
        goto L58
    L26:
        if (r1.isInstantAppInternal(info.activityInfo.packageName, r5, 1000) == false) goto L28;
        resolveInfos.remove(i);
        r9 = r9;
    L31:
        if (ephemeralPkgName != null) goto L40;
        SettingBase callingSetting = r1.mSettings.getSettingBase(UserHandle.getAppId(filterCallingUid));
        PackageStateInternal resolvedSetting = r1.getPackageStateInternal(info.activityInfo.packageName, 0);
        if (resolveForStart == true) goto L58;
        if (r1.mAppsFilter.shouldFilterApplication(r1, filterCallingUid, callingSetting, resolvedSetting, r5) == false) goto L58;
    L57:
        resolveInfos.remove(i);
        goto L58
    L40:
        if (ephemeralPkgName.equals(info.activityInfo.packageName) == true) goto L58;
        if (resolveForStart == false) goto L53;
        if (intent.isWebIntent() == true) goto L48;
        if ((intent.getFlags() & 2048) == 0) goto L53;
    L48:
        if (intent.getPackage() != null) goto L53;
        if (intent.getComponent() == null) goto L58;
    L53:
        if ((info.activityInfo.flags & 1048576) == 0) goto L57;
        if (info.activityInfo.applicationInfo.isInstantApp() == true) goto L57;
    L60:
        return resolveInfos;
    L5:
        if (r1.areWebInstantAppsDisabled(r5) == false) goto L7;
        r0 = true;
        goto L8
    }

    private List<ResolveInfo> applyPostServiceResolutionFilter(List<ResolveInfo> resolveInfos, String instantAppPkgName, int userId, int filterCallingUid) {
        int i = resolveInfos.size() - 1;
    L3:
        if (i < 0) goto L34;
        ResolveInfo info = resolveInfos.get(i);
        if (instantAppPkgName != null) goto L9;
        SettingBase callingSetting = this.mSettings.getSettingBase(UserHandle.getAppId(filterCallingUid));
        PackageStateInternal resolvedSetting = getPackageStateInternal(info.serviceInfo.packageName, 0);
        if (this.mAppsFilter.shouldFilterApplication(this, filterCallingUid, callingSetting, resolvedSetting, userId) == true) goto L9;
    L32:
        i = i - 1;
    L9:
        boolean isEphemeralApp = info.serviceInfo.applicationInfo.isInstantApp();
        if (isEphemeralApp == true) goto L12;
    L27:
        if (isEphemeralApp == false) goto L29;
    L31:
        resolveInfos.remove(i);
        goto L32
    L29:
        if ((info.serviceInfo.flags & 1048576) == 0) goto L31;
    L12:
        if (instantAppPkgName.equals(info.serviceInfo.packageName) == false) goto L27;
        if (info.serviceInfo.splitName == null) goto L32;
        if (ArrayUtils.contains(info.serviceInfo.applicationInfo.splitNames, info.serviceInfo.splitName) == true) goto L32;
        if (instantAppInstallerActivity() != null) goto L24;
        if (PackageManagerService.DEBUG_INSTANT == false) goto L22;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "No installer - not adding it to the ResolveInfolist");
    L22:
        resolveInfos.remove(i);
        goto L32
    L24:
        if (PackageManagerService.DEBUG_INSTANT == false) goto L26;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Adding ephemeral installer to the ResolveInfo list");
    L26:
        ResolveInfo installerInfo = new ResolveInfo(this.mInstantAppInstallerInfo);
        installerInfo.auxiliaryInfo = new AuxiliaryResolveInfo(null, info.serviceInfo.packageName, info.serviceInfo.applicationInfo.longVersionCode, info.serviceInfo.splitName);
        installerInfo.filter = new IntentFilter();
        installerInfo.resolvePackageName = info.getComponentInfo().packageName;
        resolveInfos.set(i, installerInfo);
        goto L32
    L34:
        return resolveInfos;
    }

    private List<ResolveInfo> filterIfNotSystemUser(List<ResolveInfo> resolveInfos, int userId) {
        if (userId != 0) goto L4;
        return resolveInfos;
    L4:
        int i = CollectionUtils.size(resolveInfos) - 1;
    L5:
        if (i < 0) goto L11;
        ResolveInfo info = resolveInfos.get(i);
        if ((info.activityInfo.flags & 536870912) == 0) goto L9;
        resolveInfos.remove(i);
    L9:
        i = i - 1;
        goto L5
    L11:
        return resolveInfos;
    }

    private List<ResolveInfo> maybeAddInstantAppInstaller(List<ResolveInfo> result, Intent intent, String resolvedType, long flags, int userId, boolean resolveForStart, boolean isRequesterInstantApp) {
        if ((flags & 8388608) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean alreadyResolvedLocally = r0;
        if (alreadyResolvedLocally == true) goto L24;
        List<ResolveInfo> instantApps = this.mComponentResolver.queryActivities(this, intent, resolvedType, 16777216 | (8388608 | (flags | 64)), userId);
        int r5 = userId;
        ComputerEngine r6 = this;
        int i = instantApps.size() - 1;
    L9:
        if (i < 0) goto L25;
        ResolveInfo info = instantApps.get(i);
        String packageName = info.activityInfo.packageName;
        PackageStateInternal ps = r6.mSettings.getPackage(packageName);
        if (ps.getUserStateOrDefault(r5).isInstantApp() == true) goto L13;
        i = i - 1;
        r5 = userId;
        goto L9
    L13:
        if (PackageManagerServiceUtils.hasAnyDomainApproval(r6.mDomainVerificationManager, ps, intent, flags, r5) == false) goto L19;
        if (PackageManagerService.DEBUG_INSTANT == false) goto L17;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Instant app approved for intent; pkg: " + packageName);
    L17:
        ResolveInfo localInstantApp = info;
        boolean blockResolution = false;
    L26:
        AuxiliaryResolveInfo auxiliaryResponse = null;
        if (blockResolution == true) goto L31;
        if (localInstantApp != null) goto L30;
        Trace.traceBegin(262144, "resolveEphemeral");
        String token = UUID.randomUUID().toString();
        InstantAppResolveInfo.InstantAppDigest digest = InstantAppResolver.parseDigest(intent);
        int r15 = userId;
        long r4 = 0;
        InstantAppRequest requestObject = new InstantAppRequest(null, intent, resolvedType, null, null, isRequesterInstantApp, r15, null, resolveForStart, digest.getDigestPrefixSecure(), token);
        auxiliaryResponse = InstantAppResolver.doInstantAppResolutionPhaseOne(r6, r6.mUserManager, r6.mInstantAppResolverConnection, requestObject);
        Trace.traceEnd(262144);
    L33:
        if (intent.isWebIntent() == false) goto L36;
        if (auxiliaryResponse != null) goto L36;
        return result;
    L36:
        PackageStateInternal ps2 = r6.mSettings.getPackage(r6.instantAppInstallerActivity().packageName);
        if (ps2 != null) goto L39;
    L54:
        return result;
    L39:
        if (PackageUserStateUtils.isEnabled(ps2.getUserStateOrDefault(r15), r6.instantAppInstallerActivity(), r4) == false) goto L54;
        ResolveInfo ephemeralInstaller = new ResolveInfo(r6.mInstantAppInstallerInfo);
        ephemeralInstaller.activityInfo = PackageInfoUtils.generateDelegateActivityInfo(r6.instantAppInstallerActivity(), r4, ps2.getUserStateOrDefault(r15), r15);
        ephemeralInstaller.match = 5799936;
        ephemeralInstaller.filter = new IntentFilter();
        if (intent.getAction() == null) goto L45;
        ephemeralInstaller.filter.addAction(intent.getAction());
    L45:
        if (intent.getData() != null) goto L47;
    L49:
        ephemeralInstaller.isInstantAppAvailable = true;
        ephemeralInstaller.isDefault = true;
        ephemeralInstaller.auxiliaryInfo = auxiliaryResponse;
        if (PackageManagerService.DEBUG_INSTANT == false) goto L52;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Adding ephemeral installer to the ResolveInfo list");
    L52:
        result.add(ephemeralInstaller);
        return result;
    L47:
        if (intent.getData().getPath() == null) goto L49;
        ephemeralInstaller.filter.addDataPath(intent.getData().getPath(), 0);
        goto L49
    L30:
        r15 = userId;
        r4 = 0;
        ApplicationInfo ai = localInstantApp.activityInfo.applicationInfo;
        auxiliaryResponse = new AuxiliaryResolveInfo(null, ai.packageName, ai.longVersionCode, null);
        goto L33
    L31:
        r15 = userId;
        r4 = 0;
        goto L33
    L19:
        if (PackageManagerService.DEBUG_INSTANT == false) goto L21;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Instant app not approved for intent; pkg: " + packageName);
    L21:
        localInstantApp = null;
        blockResolution = true;
    L25:
        localInstantApp = null;
        blockResolution = false;
        goto L26
    L24:
        r6 = this;
        goto L25
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public final PackageInfo generatePackageInfo(PackageStateInternal ps, long flags, int userId) {
        String r14 = null;
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        if (ps != null) goto L7;
        return null;
    L7:
        int callingUid = Binder.getCallingUid();
        if (shouldFilterApplication(ps, callingUid, userId) == false) goto L11;
        return null;
    L11:
        if ((flags & 8192) != 0) goto L13;
    L15:
        long flags2 = flags;
    L16:
        PackageUserStateInternal state = ps.getUserStateOrDefault(userId);
        long flags3 = flags2;
        AndroidPackageInternal r1 = ps.getPkg();
        if (r1 == null) goto L44;
        if ((256 & flags3) != 0) goto L21;
        int[] gids = PackageManagerService.EMPTY_INT_ARRAY;
    L23:
        if ((flags3 & 4096) != 0) goto L25;
    L28:
        Set<String> installedPermissions = Collections.emptySet();
    L30:
        if ((4096 & flags3) != 0) goto L32;
    L35:
        Set<String> grantedPermissions = Collections.emptySet();
    L36:
        PackageInfo packageInfo = PackageInfoUtils.generate(r1, gids, flags3, state.getFirstInstallTimeMillis(), ps.getLastUpdateTime(), installedPermissions, grantedPermissions, state, userId, ps);
        if (packageInfo != null) goto L39;
        return null;
    L39:
        ApplicationInfo r6 = packageInfo.applicationInfo;
        String r7 = resolveExternalPackageName(r1);
        r6.packageName = r7;
        packageInfo.packageName = r7;
        packageInfo.isFrozen = this.mFrozenPackages.containsKey(packageInfo.packageName);
        String apexModuleName = ps.getApexModuleName();
        if (apexModuleName == null) goto L42;
        packageInfo.setApexPackageName(this.mApexManager.getActivePackageNameForApexModuleName(apexModuleName));
    L42:
        return packageInfo;
    L32:
        if (ArrayUtils.isEmpty(r1.getRequestedPermissions()) == true) goto L35;
        grantedPermissions = this.mPermissionManager.getGrantedPermissions(ps.getPackageName(), userId);
        goto L36
    L25:
        if (ArrayUtils.isEmpty(r1.getPermissions()) == true) goto L28;
        installedPermissions = this.mPermissionManager.getInstalledPermissions(ps.getPackageName());
        goto L30
    L21:
        gids = this.mPermissionManager.getGidsForUid(UserHandle.getUid(userId, ps.getAppId()));
        goto L23
    L44:
        if ((4294975488L & flags3) != 0) goto L46;
    L54:
        return null;
    L46:
        if (PackageUserStateUtils.isAvailable(state, flags3) == false) goto L54;
        PackageInfo pi = new PackageInfo();
        pi.packageName = ps.getPackageName();
        pi.setLongVersionCode(ps.getVersionCode());
        SharedUserApi sharedUser = this.mSettings.getSharedUserFromPackageName(pi.packageName);
        if (sharedUser == null) goto L50;
        r14 = sharedUser.getName();
    L50:
        pi.sharedUserId = r14;
        pi.firstInstallTime = state.getFirstInstallTimeMillis();
        pi.lastUpdateTime = ps.getLastUpdateTime();
        ApplicationInfo ai = new ApplicationInfo();
        ai.packageName = ps.getPackageName();
        ai.uid = UserHandle.getUid(userId, ps.getAppId());
        ai.primaryCpuAbi = ps.getPrimaryCpuAbiLegacy();
        ai.secondaryCpuAbi = ps.getSecondaryCpuAbiLegacy();
        ai.volumeUuid = ps.getVolumeUuid();
        ai.storageUuid = StorageManager.convert(ai.volumeUuid);
        ai.setVersionCode(ps.getVersionCode());
        ai.targetSdkVersion = ps.getTargetSdkVersion();
        ai.flags = ps.getFlags();
        ai.privateFlags = ps.getPrivateFlags();
        pi.applicationInfo = PackageInfoUtils.generateDelegateApplicationInfo(ai, flags3, state, userId);
        pi.signingInfo = ps.getSigningInfo();
        pi.signatures = PackageInfoUtils.getDeprecatedSignatures(pi.signingInfo.getSigningDetails(), flags3);
        if (state.getArchiveState() == null) goto L53;
        pi.setArchiveTimeMillis(state.getArchiveState().getArchiveTimeMillis());
    L53:
        return pi;
    L13:
        if (ps.isSystem() == false) goto L15;
        flags2 = flags | 4194304;
        goto L16
    }

    @Override // com.android.server.pm.Computer
    public final PackageInfo getPackageInfo(String packageName, long flags, int userId) {
        return getPackageInfoInternal(packageName, -1, flags, Binder.getCallingUid(), userId);
    }

    @Override // com.android.server.pm.Computer
    public final PackageInfo getPackageInfoInternal(String packageName, long versionCode, long flags, int filterCallingUid, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L6;
        return null;
    L6:
        long flags2 = updateFlagsForPackage(flags, userId);
        enforceCrossUserPermission(Binder.getCallingUid(), userId, false, false, "get package info");
        return getPackageInfoInternalBody(packageName, versionCode, flags2, filterCallingUid, userId);
    }

    protected PackageInfo getPackageInfoInternalBody(String packageName, long versionCode, long flags, int filterCallingUid, int userId) {
        String packageName2 = resolveInternalPackageName(packageName, versionCode);
        String[] callingPkgs = getPackagesForUid(Binder.getCallingUid());
        if (callingPkgs == null) goto L13;
        int r3 = callingPkgs.length;
        long flags2 = flags;
        int r9 = 0;
    L6:
        if (r9 >= r3) goto L14;
        String pkg = callingPkgs[r9];
        if (Utils.isXtsPkg(pkg) == false) goto L12;
        if ((4096 & flags2) == 0) goto L12;
        flags2 = flags2 | PackageInfoUtils.BD_PERMISSION_FILTER_CTS;
    L12:
        r9 = r9 + 1;
    L14:
        boolean matchApex = true;
        if ((2097152 & flags2) == 0) goto L17;
        boolean r4 = true;
    L18:
        boolean matchFactoryOnly = r4;
        if ((1073741824 & flags2) != 0) goto L23;
        matchApex = false;
    L23:
        if (matchFactoryOnly == false) goto L47;
        PackageStateInternal ps = this.mSettings.getDisabledSystemPkg(packageName2);
        if (ps == null) goto L47;
        if (matchApex == false) goto L28;
    L32:
        long flags3 = flags2;
        if (filterSharedLibPackage(ps, filterCallingUid, userId, flags2) == false) goto L36;
        return null;
    L36:
        if (shouldFilterApplication(ps, filterCallingUid, userId) == false) goto L38;
        return null;
    L38:
        PackageInfo packageInfo = generatePackageInfo(ps, flags3, userId);
        if (packageInfo != null) goto L98;
        if (userId == 10) goto L42;
        return packageInfo;
    L42:
        if (UserHandle.getUserId(Binder.getCallingUid()) == 10) goto L44;
        return packageInfo;
    L44:
        return generatePackageInfo(ps, flags3, 0);
    L98:
        return packageInfo;
    L28:
        if (ps.getPkg() == null) goto L32;
        if (ps.getPkg().isApex() == false) goto L32;
        return null;
    L47:
        AndroidPackage p = this.mPackages.get(packageName2);
        PackageStateInternal packageState = this.mSettings.getPackage(packageName2);
        if (matchFactoryOnly == false) goto L53;
        if (p == null) goto L53;
        if (packageState.isSystem() == true) goto L53;
        return null;
    L53:
        if (p == null) goto L73;
        PackageStateInternal ps2 = getPackageStateInternal(p.getPackageName());
        if (matchApex == false) goto L57;
    L59:
        long flags4 = flags2;
        if (filterSharedLibPackage(ps2, filterCallingUid, userId, flags4) == false) goto L62;
        return null;
    L62:
        if (ps2 != null) goto L64;
    L66:
        PackageInfo packageInfo2 = generatePackageInfo(ps2, flags4, userId);
        if (packageInfo2 != null) goto L101;
        if (userId == 10) goto L70;
        return packageInfo2;
    L70:
        if (UserHandle.getUserId(Binder.getCallingUid()) == 10) goto L72;
        return packageInfo2;
    L72:
        return generatePackageInfo(ps2, flags4, 0);
    L101:
        return packageInfo2;
    L64:
        if (shouldFilterApplication(ps2, filterCallingUid, userId) == false) goto L66;
        return null;
    L57:
        if (p.isApex() == false) goto L59;
        return null;
    L73:
        if (matchFactoryOnly == true) goto L93;
        if ((flags2 & 4299169792L) == 0) goto L93;
        PackageStateInternal ps3 = this.mSettings.getPackage(packageName2);
        if (ps3 != null) goto L79;
        return null;
    L79:
        long flags5 = flags2;
        if (filterSharedLibPackage(ps3, filterCallingUid, userId, flags5) == false) goto L83;
        return null;
    L83:
        if (shouldFilterApplication(ps3, filterCallingUid, userId) == false) goto L85;
        return null;
    L85:
        PackageInfo packageInfo3 = generatePackageInfo(ps3, flags5, userId);
        if (packageInfo3 != null) goto L104;
        if (userId == 10) goto L89;
        return packageInfo3;
    L89:
        if (UserHandle.getUserId(Binder.getCallingUid()) == 10) goto L91;
        return packageInfo3;
    L91:
        return generatePackageInfo(ps3, flags5, 0);
    L104:
        return packageInfo3;
    L93:
        return null;
    L17:
        r4 = false;
        goto L18
    L13:
        flags2 = flags;
        goto L14
    }

    @Override // com.android.server.pm.Computer
    public String[] getAllAvailablePackageNames() {
        return (String[]) this.mPackages.keySet().toArray(new String[0]);
    }

    @Override // com.android.server.pm.Computer
    public final PackageStateInternal getPackageStateInternal(String packageName) {
        return getPackageStateInternal(packageName, Binder.getCallingUid());
    }

    @Override // com.android.server.pm.Computer
    public PackageStateInternal getPackageStateInternal(String packageName, int callingUid) {
        String packageName2 = resolveInternalPackageNameInternalLocked(packageName, -1, callingUid);
        return this.mSettings.getPackage(packageName2);
    }

    @Override // com.android.server.pm.Computer
    public PackageStateInternal getPackageStateFiltered(String packageName, int callingUid, int userId) {
        String packageName2 = resolveInternalPackageNameInternalLocked(packageName, -1, callingUid);
        PackageStateInternal packageState = this.mSettings.getPackage(packageName2);
        if (shouldFilterApplication(packageState, callingUid, userId) == false) goto L6;
        return null;
    L6:
        return packageState;
    }

    @Override // com.android.server.pm.Computer
    public final ParceledListSlice<PackageInfo> getInstalledPackages(long flags, int userId) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L7;
        return ParceledListSlice.emptyList();
    L7:
        if (this.mUserManager.exists(userId) == false) goto L9;
        long flags2 = updateFlagsForPackage(flags, userId);
        enforceCrossUserPermission(callingUid, userId, false, false, "get installed packages");
        return getInstalledPackagesBody(flags2, userId, callingUid, this.mExt.checkGetInstallAppsPermission(this.mContext, userId, callingUid, flags2));
    L9:
        return ParceledListSlice.emptyList();
    }

    protected ParceledListSlice<PackageInfo> getInstalledPackagesBody(long flags, int userId, int callingUid) {
        return getInstalledPackagesBody(flags, userId, callingUid, true);
    }

    protected ParceledListSlice<PackageInfo> getInstalledPackagesBody(long flags, int userId, int callingUid, boolean hasPermission) {
        boolean r1 = false;
        if ((4202496 & flags) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean listUninstalled = r0;
        if ((1073741824 & flags) == 0) goto L9;
        boolean r2 = true;
    L10:
        boolean listApex = r2;
        if ((2097152 & flags) == 0) goto L13;
        boolean r3 = true;
    L14:
        boolean listFactory = r3;
        if (listUninstalled == false) goto L17;
    L19:
        boolean listArchivedOnly = r1;
        if (listUninstalled == true) goto L57;
        if (listArchivedOnly == true) goto L57;
        ArrayList<PackageInfo> list = new ArrayList(this.mPackages.size());
        Iterator<AndroidPackage> r11 = this.mPackages.values().iterator();
    L25:
        if (r11.hasNext() == false) goto L97;
        AndroidPackage p = r11.next();
        PackageStateInternal ps = getPackageStateInternal(p.getPackageName());
        if (listFactory == false) goto L34;
        if (ps.isSystem() == false) goto L25;
        PackageStateInternal psDisabled = this.mSettings.getDisabledSystemPkg(ps.getPackageName());
        if (psDisabled == null) goto L34;
    L35:
        if (listApex == true) goto L40;
        if (p.isApex() == true) goto L25;
    L40:
        if (hasPermission == true) goto L46;
        if (psDisabled == null) goto L25;
        if (isCallerSameApp(psDisabled.getPackageName(), callingUid) == false) goto L25;
    L46:
        if (filterSharedLibPackage(psDisabled, callingUid, userId, flags) == true) goto L25;
        if (shouldFilterApplication(psDisabled, callingUid, userId) == true) goto L25;
        PackageInfo pi = generatePackageInfo(psDisabled, flags, userId);
        if (pi == null) goto L25;
        list.add(pi);
    L34:
        psDisabled = ps;
    L97:
        return new ParceledListSlice(list);
    L57:
        list = new ArrayList(this.mSettings.getPackages().size());
        Iterator<? extends PackageStateInternal> r12 = this.mSettings.getPackages().values().iterator();
    L59:
        if (r12.hasNext() == false) goto L97;
        PackageStateInternal ps2 = r12.next();
        if (listFactory == false) goto L68;
        if (ps2.isSystem() == false) goto L59;
        PackageStateInternal psDisabled2 = this.mSettings.getDisabledSystemPkg(ps2.getPackageName());
        if (psDisabled2 == null) goto L68;
        ps2 = psDisabled2;
    L68:
        if (listApex == true) goto L74;
        if (ps2.getPkg() == null) goto L74;
        if (ps2.getPkg().isApex() == true) goto L59;
    L74:
        PackageUserStateInternal userState = ps2.getUserStateOrDefault(userId);
        if (listArchivedOnly == false) goto L81;
        if (userState.isInstalled() == true) goto L81;
        if (userState.getArchiveState() == null) goto L59;
    L81:
        if (hasPermission == true) goto L86;
        if (isCallerSameApp(ps2.getPackageName(), callingUid) == false) goto L59;
    L86:
        if (filterSharedLibPackage(ps2, callingUid, userId, flags) == true) goto L59;
        if (shouldFilterApplication(ps2, callingUid, userId) == true) goto L59;
        PackageInfo pi2 = generatePackageInfo(ps2, flags, userId);
        if (pi2 == null) goto L59;
        list.add(pi2);
        goto L59
    L17:
        if ((4294967296L & flags) == 0) goto L19;
        r1 = true;
        goto L19
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public final ResolveInfo createForwardingResolveInfoUnchecked(WatchedIntentFilter filter, int sourceUserId, int targetUserId) {
        ResolveInfo forwardingResolveInfo = new ResolveInfo();
        long ident = Binder.clearCallingIdentity();
        boolean targetIsProfile = this.mUserManager.getUserInfo(targetUserId).isManagedProfile();     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        if (targetIsProfile == false) goto L7;
        String className = IntentForwarderActivity.FORWARD_INTENT_TO_MANAGED_PROFILE;
    L8:
        ComponentName forwardingActivityComponentName = new ComponentName(androidApplication().packageName, className);
        ActivityInfo forwardingActivityInfo = getActivityInfoCrossProfile(forwardingActivityComponentName, 0, sourceUserId);
        if (targetIsProfile == true) goto L11;
        forwardingActivityInfo.showUserIcon = targetUserId;
        forwardingResolveInfo.noResourceId = true;
    L11:
        forwardingResolveInfo.activityInfo = forwardingActivityInfo;
        forwardingResolveInfo.priority = 0;
        forwardingResolveInfo.preferredOrder = 0;
        forwardingResolveInfo.match = 0;
        forwardingResolveInfo.isDefault = true;
        forwardingResolveInfo.filter = new IntentFilter(filter.getIntentFilter());
        forwardingResolveInfo.targetUserId = targetUserId;
        forwardingResolveInfo.userHandle = UserHandle.of(sourceUserId);
        return forwardingResolveInfo;
    L7:
        className = IntentForwarderActivity.FORWARD_INTENT_TO_PARENT;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    @Override // com.android.server.pm.Computer
    public final ServiceInfo getServiceInfo(ComponentName component, long flags, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L6;
        return null;
    L6:
        int callingUid = Binder.getCallingUid();
        long flags2 = updateFlagsForComponent(flags, userId);
        enforceCrossUserOrProfilePermission(callingUid, userId, false, false, "get service info");
        return getServiceInfoBody(component, flags2, userId, callingUid);
    }

    protected ServiceInfo getServiceInfoBody(ComponentName component, long flags, int userId, int callingUid) {
        ParsedMainComponent r2 = this.mComponentResolver.getService(component);
        if (r2 != null) goto L5;
        return null;
    L5:
        AndroidPackage pkg = this.mPackages.get(r2.getPackageName());
        if (this.mSettings.isEnabledAndMatch(pkg, r2, flags, userId) == false) goto L15;
        PackageStateInternal ps = this.mSettings.getPackage(component.getPackageName());
        if (ps != null) goto L11;
        return null;
    L11:
        if (shouldFilterApplication(ps, callingUid, component, 3, userId) == false) goto L14;
        return null;
    L14:
        return PackageInfoUtils.generateServiceInfo(pkg, r2, flags, ps.getUserStateOrDefault(userId), userId, ps);
    L15:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public final SharedLibraryInfo getSharedLibraryInfo(String name, long version) {
        return this.mSharedLibraries.getSharedLibraryInfo(name, version);
    }

    @Override // com.android.server.pm.Computer
    public String getInstantAppPackageName(int callingUid) {
        if (Process.isIsolated(callingUid) == false) goto L5;
        callingUid = getIsolatedOwner(callingUid);
    L5:
        int appId = UserHandle.getAppId(callingUid);
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof PackageStateInternal) == false) goto L11;
        PackageStateInternal ps = (PackageStateInternal) obj;
        boolean isInstantApp = ps.getUserStateOrDefault(UserHandle.getUserId(callingUid)).isInstantApp();
        if (isInstantApp == true) goto L10;
        return null;
    L10:
        return ps.getPkg().getPackageName();
    L11:
        return null;
    }

    private int getIsolatedOwner(int isolatedUid) {
        int ownerUid = this.mIsolatedOwners.get(isolatedUid, -1);
        if (ownerUid == (-1)) goto L6;
        return ownerUid;
    L6:
        throw new IllegalStateException("No owner UID found for isolated UID " + isolatedUid);
    }

    @Override // com.android.server.pm.Computer
    public final String resolveExternalPackageName(AndroidPackage pkg) {
        if (pkg.getStaticSharedLibraryName() == null) goto L7;
        return pkg.getManifestPackageName();
    L7:
        return pkg.getPackageName();
    }

    private String resolveInternalPackageNameInternalLocked(String packageName, long versionCode, int callingUid) {
        String normalizedPackageName = this.mSettings.getRenamedPackageLPr(packageName);
        if (normalizedPackageName == null) goto L5;
        String packageName2 = normalizedPackageName;
    L6:
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.getStaticLibraryInfos(packageName2);
        if (versionedLib == null) goto L52;
        if (versionedLib.size() <= 0) goto L52;
        LongSparseLongArray versionsCallerCanSee = null;
        int callingAppId = UserHandle.getAppId(callingUid);
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingAppId) == true) goto L23;
        versionsCallerCanSee = new LongSparseLongArray();
        int r6 = 0;
        String libName = versionedLib.valueAt(0).getName();
        String[] uidPackages = getPackagesForUidInternal(callingUid, callingUid);
        if (uidPackages == null) goto L23;
        int r10 = uidPackages.length;
    L17:
        if (r6 >= r10) goto L23;
        String uidPackage = uidPackages[r6];
        PackageStateInternal ps = this.mSettings.getPackage(uidPackage);
        int libIdx = ArrayUtils.indexOf(ps.getUsesStaticLibraries(), libName);
        if (libIdx < 0) goto L21;
        long libVersion = ps.getUsesStaticLibrariesVersions()[libIdx];
        versionsCallerCanSee.append(libVersion, libVersion);
    L21:
        r6 = r6 + 1;
    L23:
        if (versionsCallerCanSee != null) goto L25;
    L27:
        SharedLibraryInfo highestVersion = null;
        int versionCount = versionedLib.size();
        int i = 0;
    L28:
        if (i >= versionCount) goto L47;
        SharedLibraryInfo libraryInfo = versionedLib.valueAt(i);
        if (versionsCallerCanSee != null) goto L32;
    L34:
        long libVersionCode = libraryInfo.getDeclaringPackage().getLongVersionCode();
        if (versionCode != (-1)) goto L37;
        if (highestVersion != null) goto L43;
        highestVersion = libraryInfo;
    L45:
        i = i + 1;
        goto L28
    L43:
        if (libVersionCode <= highestVersion.getDeclaringPackage().getLongVersionCode()) goto L45;
        highestVersion = libraryInfo;
        goto L45
    L37:
        if (libVersionCode != versionCode) goto L45;
        return libraryInfo.getPackageName();
    L32:
        if (versionsCallerCanSee.indexOfKey(libraryInfo.getLongVersion()) >= 0) goto L34;
    L47:
        if (highestVersion != null) goto L49;
        return packageName2;
    L49:
        return highestVersion.getPackageName();
    L25:
        if (versionsCallerCanSee.size() > 0) goto L27;
        return packageName2;
    L52:
        return packageName2;
    L5:
        packageName2 = packageName;
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public final String resolveInternalPackageName(String packageName, long versionCode) {
        int callingUid = Binder.getCallingUid();
        return resolveInternalPackageNameInternalLocked(packageName, versionCode, callingUid);
    }

    @Override // com.android.server.pm.Computer
    public final String[] getPackagesForUid(int uid) {
        return getPackagesForUidInternal(uid, Binder.getCallingUid());
    }

    private String[] getPackagesForUidInternal(int uid, int callingUid) {
        if (getInstantAppPackageName(callingUid) == null) goto L5;
        boolean isCallerInstantApp = true;
    L6:
        int userId = UserHandle.getUserId(uid);
        if (Process.isSdkSandboxUid(uid) == false) goto L10;
        uid = getBaseSdkSandboxUid();
    L10:
        if (isKnownIsolatedComputeApp(uid) == false) goto L12;
        uid = getIsolatedOwner(uid);
    L12:
        int appId = UserHandle.getAppId(uid);
        return getPackagesForUidInternalBody(callingUid, userId, appId, isCallerInstantApp);
    L5:
        isCallerInstantApp = false;
        goto L6
    }

    protected String[] getPackagesForUidInternalBody(int callingUid, int userId, int appId, boolean isCallerInstantApp) {
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof SharedUserSetting) == false) goto L17;
        if (isCallerInstantApp == false) goto L6;
        return null;
    L6:
        SharedUserSetting sus = (SharedUserSetting) obj;
        ArraySet<? extends PackageStateInternal> r2 = sus.getPackageStates();
        int n = r2.size();
        String[] res = new String[n];
        int i = 0;
        int index = 0;
    L7:
        if (index >= n) goto L15;
        PackageStateInternal ps = r2.valueAt(index);
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L13;
        if (shouldFilterApplication(ps, callingUid, userId) == true) goto L13;
        res[i] = ps.getPackageName();
        i = i + 1;
    L13:
        index = index + 1;
        goto L7
    L15:
        return (String[]) ArrayUtils.trimToSize(res, i);
    L17:
        if ((obj instanceof PackageStateInternal) == false) goto L24;
        PackageStateInternal ps2 = (PackageStateInternal) obj;
        if (ps2.getUserStateOrDefault(userId).isInstalled() == false) goto L24;
        if (shouldFilterApplication(ps2, callingUid, userId) == true) goto L24;
        return new String[]{ps2.getPackageName()};
    L24:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public final UserInfo getProfileParent(int userId) {
        long identity = Binder.clearCallingIdentity();
        UserInfo r2 = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean areWebInstantAppsDisabled(int userId) {
        return this.mWebInstantAppsDisabled.get(userId);
    }

    @Override // com.android.server.pm.Computer
    public final boolean canViewInstantApps(int callingUid, int userId) {
        if (callingUid >= 10000) goto L6;
        return true;
    L6:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_INSTANT_APPS") != 0) goto L9;
        return true;
    L9:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.VIEW_INSTANT_APPS") != 0) goto L22;
        ComponentName homeComponent = getDefaultHomeActivity(userId);
        if (homeComponent == null) goto L16;
        if (isCallerSameApp(homeComponent.getPackageName(), callingUid) == false) goto L16;
        return true;
    L16:
        if (this.mAppPredictionServicePackage == null) goto L21;
        if (isCallerSameApp(this.mAppPredictionServicePackage, callingUid) == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    private boolean filterStaticSharedLibPackage(PackageStateInternal ps, int uid, int userId, long flags) {
        if ((flags & 67108864) == 0) goto L10;
        int appId = UserHandle.getAppId(uid);
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(appId) == false) goto L7;
        return false;
    L7:
        int r4 = uid;
        if (checkUidPermission("android.permission.INSTALL_PACKAGES", r4) != 0) goto L11;
        return false;
    L11:
        if (ps == null) goto L39;
        if (ps.getPkg() == null) goto L39;
        if (ps.getPkg().isStaticSharedLibrary() == false) goto L39;
        SharedLibraryInfo libraryInfo = getSharedLibraryInfo(ps.getPkg().getStaticSharedLibraryName(), ps.getPkg().getStaticSharedLibraryVersion());
        if (libraryInfo != null) goto L20;
        return false;
    L20:
        int resolvedUid = UserHandle.getUid(userId, UserHandle.getAppId(r4));
        String[] uidPackageNames = getPackagesForUid(resolvedUid);
        if (uidPackageNames != null) goto L23;
        return true;
    L23:
        int r8 = uidPackageNames.length;
        int r9 = 0;
    L24:
        if (r9 >= r8) goto L37;
        String uidPackageName = uidPackageNames[r9];
        if (ps.getPackageName().equals(uidPackageName) == true) goto L27;
        PackageStateInternal uidPs = this.mSettings.getPackage(uidPackageName);
        if (uidPs == null) goto L36;
        int index = ArrayUtils.indexOf(uidPs.getUsesStaticLibraries(), libraryInfo.getName());
        if (index < 0) goto L36;
        if (uidPs.getPkg().getUsesStaticLibrariesVersions()[index] != libraryInfo.getLongVersion()) goto L36;
        return false;
    L36:
        r9 = r9 + 1;
        goto L24
    L27:
        return false;
    L37:
        return true;
    L39:
        return false;
    L10:
        r4 = uid;
        goto L11
    }

    private boolean filterSdkLibPackage(PackageStateInternal ps, int uid, int userId, long flags) {
        if ((flags & 67108864) == 0) goto L10;
        int appId = UserHandle.getAppId(uid);
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(appId) == false) goto L7;
        return false;
    L7:
        int r4 = uid;
        if (checkUidPermission("android.permission.INSTALL_PACKAGES", r4) != 0) goto L11;
        return false;
    L11:
        if (ps == null) goto L39;
        if (ps.getPkg() == null) goto L39;
        if (ps.getPkg().isSdkLibrary() == false) goto L39;
        SharedLibraryInfo libraryInfo = getSharedLibraryInfo(ps.getPkg().getSdkLibraryName(), ps.getPkg().getSdkLibVersionMajor());
        if (libraryInfo != null) goto L20;
        return false;
    L20:
        int resolvedUid = UserHandle.getUid(userId, UserHandle.getAppId(r4));
        String[] uidPackageNames = getPackagesForUid(resolvedUid);
        if (uidPackageNames != null) goto L23;
        return true;
    L23:
        int r8 = uidPackageNames.length;
        int r9 = 0;
    L24:
        if (r9 >= r8) goto L37;
        String uidPackageName = uidPackageNames[r9];
        if (ps.getPackageName().equals(uidPackageName) == true) goto L27;
        PackageStateInternal uidPs = this.mSettings.getPackage(uidPackageName);
        if (uidPs == null) goto L36;
        int index = ArrayUtils.indexOf(uidPs.getUsesSdkLibraries(), libraryInfo.getName());
        if (index < 0) goto L36;
        if (uidPs.getPkg().getUsesSdkLibrariesVersionsMajor()[index] != libraryInfo.getLongVersion()) goto L36;
        return false;
    L36:
        r9 = r9 + 1;
        goto L24
    L27:
        return false;
    L37:
        return true;
    L39:
        return false;
    L10:
        r4 = uid;
        goto L11
    }

    @Override // com.android.server.pm.Computer
    public final boolean filterSharedLibPackage(PackageStateInternal ps, int uid, int userId, long flags) {
        if (filterStaticSharedLibPackage(ps, uid, userId, flags) == false) goto L5;
    L8:
        return true;
    L5:
        if (filterSdkLibPackage(ps, uid, userId, flags) == true) goto L8;
        return false;
    }

    private boolean hasCrossUserPermission(int callingUid, int callingUserId, int userId, boolean requireFullPermission, boolean requirePermissionWhenSameUser) {
        boolean permissionGranted = true;
        if (requirePermissionWhenSameUser == true) goto L7;
        if (userId != callingUserId) goto L7;
        return true;
    L7:
        if (PackageManagerServiceUtils.isSystemOrRoot(callingUid) == false) goto L10;
        return true;
    L10:
        if (DoppelgangerManager.allowCrossUser(callingUserId, userId) == false) goto L13;
        return true;
    L13:
        if (requireFullPermission == false) goto L16;
        permissionGranted = hasPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingUid);
    L23:
        if (permissionGranted == false) goto L25;
    L30:
        return permissionGranted;
    L25:
        if (Process.isIsolatedUid(callingUid) == false) goto L30;
        if (isKnownIsolatedComputeApp(callingUid) == false) goto L30;
        return checkIsolatedOwnerHasPermission(callingUid, requireFullPermission);
    L16:
        if (hasPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingUid) == true) goto L23;
        if (hasPermission("android.permission.INTERACT_ACROSS_USERS", callingUid) == true) goto L23;
        permissionGranted = false;
        goto L23
    }

    private boolean hasNonNegativePriority(List<ResolveInfo> resolveInfos) {
        if (resolveInfos.size() > 0) goto L5;
        return false;
    L5:
        if (resolveInfos.get(0).priority < 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean hasPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasPermission(String permission, int uid) {
        if (this.mContext.checkPermission(permission, -1, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkIsolatedOwnerHasPermission(int callingUid, boolean requireFullPermission) {
        int ownerUid = getIsolatedOwner(callingUid);
        if (requireFullPermission == false) goto L7;
        return hasPermission("android.permission.INTERACT_ACROSS_USERS_FULL", ownerUid);
    L7:
        if (hasPermission("android.permission.INTERACT_ACROSS_USERS_FULL", ownerUid) == false) goto L9;
    L12:
        return true;
    L9:
        if (hasPermission("android.permission.INTERACT_ACROSS_USERS", ownerUid) == true) goto L12;
        return false;
    }

    @Override // com.android.server.pm.Computer
    public final boolean isCallerSameApp(String packageName, int uid) {
        return isCallerSameApp(packageName, uid, false);
    }

    @Override // com.android.server.pm.Computer
    public final boolean isCallerSameApp(String packageName, int uid, boolean resolveIsolatedUid) {
        if (Process.isSdkSandboxUid(uid) == false) goto L10;
        if (packageName != null) goto L6;
        return false;
    L6:
        if (packageName.equals(this.mService.getSdkSandboxPackageName()) == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        AndroidPackage pkg = this.mPackages.get(packageName);
        if (resolveIsolatedUid == true) goto L13;
    L15:
        if (pkg != null) goto L17;
        return false;
    L17:
        if (UserHandle.getAppId(uid) == pkg.getUid()) goto L20;
        return false;
    L20:
        return true;
    L13:
        if (Process.isIsolated(uid) == false) goto L15;
        uid = getIsolatedOwner(uid);
        goto L15
    }

    private boolean isCallerFromManagedUserOrProfile(int userId) {
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) this.mInjector.getLocalService(DevicePolicyManagerInternal.class);
        if (dpmi != null) goto L5;
    L7:
        return false;
    L5:
        if (dpmi.isUserOrganizationManaged(userId) == false) goto L7;
        return true;
    }

    @Override // com.android.server.pm.Computer
    public final boolean isComponentVisibleToInstantApp(ComponentName component) {
        if (isComponentVisibleToInstantApp(component, 1) == false) goto L6;
        return true;
    L6:
        if (isComponentVisibleToInstantApp(component, 3) == false) goto L9;
        return true;
    L9:
        return isComponentVisibleToInstantApp(component, 4);
    }

    @Override // com.android.server.pm.Computer
    public final boolean isComponentVisibleToInstantApp(ComponentName component, int type) {
        if (type != 1) goto L20;
        ParsedActivity activity = this.mComponentResolver.getActivity(component);
        if (activity != null) goto L8;
        return false;
    L8:
        if ((1048576 & activity.getFlags()) == 0) goto L10;
        boolean visibleToInstantApp = true;
    L12:
        if ((2097152 & activity.getFlags()) != 0) goto L14;
        boolean explicitlyVisibleToInstantApp = true;
    L15:
        if (visibleToInstantApp == false) goto L58;
        if (explicitlyVisibleToInstantApp == true) goto L18;
        return false;
    L18:
        return true;
    L58:
        return false;
    L14:
        explicitlyVisibleToInstantApp = false;
        goto L15
    L10:
        visibleToInstantApp = false;
        goto L12
    L20:
        if (type != 2) goto L37;
        ParsedActivity activity2 = this.mComponentResolver.getReceiver(component);
        if (activity2 != null) goto L25;
        return false;
    L25:
        if ((1048576 & activity2.getFlags()) == 0) goto L27;
        boolean visibleToInstantApp2 = true;
    L29:
        if ((2097152 & activity2.getFlags()) != 0) goto L31;
        boolean explicitlyVisibleToInstantApp2 = true;
    L32:
        if (visibleToInstantApp2 == false) goto L60;
        if (explicitlyVisibleToInstantApp2 == false) goto L35;
        return false;
    L35:
        return true;
    L60:
        return false;
    L31:
        explicitlyVisibleToInstantApp2 = false;
        goto L32
    L27:
        visibleToInstantApp2 = false;
        goto L29
    L37:
        if (type != 3) goto L46;
        ParsedService service = this.mComponentResolver.getService(component);
        if (service != null) goto L41;
        return false;
    L41:
        if ((1048576 & service.getFlags()) != 0) goto L44;
        return false;
    L44:
        return true;
    L46:
        if (type != 4) goto L54;
        ParsedProvider provider = this.mComponentResolver.getProvider(component);
        if (provider != null) goto L50;
        return false;
    L50:
        if ((1048576 & provider.getFlags()) != 0) goto L53;
        return false;
    L53:
        return true;
    L54:
        if (type == 0) goto L56;
        return false;
    L56:
        return isComponentVisibleToInstantApp(component);
    }

    @Override // com.android.server.pm.Computer
    public final boolean isImplicitImageCaptureIntentAndNotSetByDpc(Intent intent, int userId, String resolvedType, long flags) {
        if (intent.isImplicitImageCaptureIntent() == true) goto L5;
    L7:
        return false;
    L5:
        if (isPersistentPreferredActivitySetByDpm(intent, userId, resolvedType, flags) == true) goto L7;
        return true;
    }

    @Override // com.android.server.pm.Computer
    public final boolean isInstantApp(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, true, false, "isInstantApp");
        return isInstantAppInternal(packageName, userId, callingUid);
    }

    @Override // com.android.server.pm.Computer
    public final boolean isInstantAppInternal(String packageName, int userId, int callingUid) {
        return isInstantAppInternalBody(packageName, userId, callingUid);
    }

    protected boolean isInstantAppInternalBody(String packageName, int userId, int callingUid) {
        if (Process.isIsolated(callingUid) == false) goto L5;
        callingUid = getIsolatedOwner(callingUid);
    L5:
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (ps != null) goto L8;
    L14:
        boolean returnAllowed = false;
    L16:
        if (returnAllowed == true) goto L18;
        return false;
    L18:
        return ps.getUserStateOrDefault(userId).isInstantApp();
    L8:
        if (isCallerSameApp(packageName, callingUid) == false) goto L10;
    L13:
        returnAllowed = true;
        goto L16
    L10:
        if (canViewInstantApps(callingUid, userId) == true) goto L13;
        if (this.mInstantAppRegistry.isInstantAccessGranted(userId, UserHandle.getAppId(callingUid), ps.getAppId()) == false) goto L14;
        goto L13
    }

    private boolean isInstantAppResolutionAllowed(Intent intent, List<ResolveInfo> resolvedActivities, int userId, boolean skipPackageCheck, long flags) {
        if (this.mInstantAppResolverConnection != null) goto L6;
        return false;
    L6:
        if (instantAppInstallerActivity() != null) goto L9;
        return false;
    L9:
        if (intent.getComponent() == null) goto L12;
        return false;
    L12:
        if ((intent.getFlags() & Integer.MIN_VALUE) == 0) goto L15;
        return false;
    L15:
        if ((intent.getFlags() & 1024) == 0) goto L17;
        return false;
    L17:
        if (skipPackageCheck == true) goto L22;
        if (intent.getPackage() == null) goto L22;
        return false;
    L22:
        if (intent.isWebIntent() == true) goto L30;
        if (resolvedActivities == null) goto L27;
        if (resolvedActivities.size() == 0) goto L27;
    L28:
        return false;
    L27:
        if ((intent.getFlags() & 2048) == 0) goto L28;
    L38:
        return isInstantAppResolutionAllowedBody(intent, resolvedActivities, userId, skipPackageCheck, flags);
    L30:
        if (intent.getData() != null) goto L32;
    L39:
        return false;
    L32:
        if (TextUtils.isEmpty(intent.getData().getHost()) == true) goto L39;
        if (areWebInstantAppsDisabled(userId) == false) goto L38;
        return false;
    }

    protected boolean isInstantAppResolutionAllowedBody(Intent intent, List<ResolveInfo> resolvedActivities, int userId, boolean skipPackageCheck, long flags) {
        if (resolvedActivities != null) goto L5;
        int count = 0;
    L7:
        if ((intent.getFlags() & 8) == 0) goto L9;
        boolean debug = true;
    L11:
        if (debug == false) goto L13;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Checking if instant app resolution allowed, resolvedActivities = " + resolvedActivities);
    L13:
        int n = 0;
    L14:
        if (n >= count) goto L36;
        ResolveInfo info = resolvedActivities.get(n);
        String packageName = info.activityInfo.packageName;
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (ps == null) goto L32;
        if (info.handleAllWebDataURI == true) goto L26;
        if (PackageManagerServiceUtils.hasAnyDomainApproval(this.mDomainVerificationManager, ps, intent, flags, userId) == false) goto L26;
        if (PackageManagerService.DEBUG_INSTANT == false) goto L24;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "DENY instant app; pkg: " + packageName + ", approved");
    L24:
        return false;
    L26:
        if (ps.getUserStateOrDefault(userId).isInstantApp() == false) goto L34;
        if (PackageManagerService.DEBUG_INSTANT == false) goto L30;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "DENY instant app installed; pkg: " + packageName);
    L30:
        return false;
    L34:
        n = n + 1;
        goto L14
    L32:
        if (debug == false) goto L34;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Could not find package " + packageName);
        goto L34
    L36:
        return true;
    L9:
        debug = false;
        goto L11
    L5:
        count = resolvedActivities.size();
        goto L7
    }

    private boolean isPersistentPreferredActivitySetByDpm(Intent intent, int userId, String resolvedType, long flags) {
        PersistentPreferredIntentResolver ppir = this.mSettings.getPersistentPreferredActivities(userId);
        if (ppir != null) goto L5;
        List r9 = new ArrayList();
    L10:
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        PersistentPreferredActivity ppa = (PersistentPreferredActivity) r10.next();
        if (ppa.mIsSetByDpm == false) goto L12;
        return true;
    L17:
        return false;
    L5:
        if ((65536 & flags) == 0) goto L7;
        boolean r5 = true;
    L8:
        r9 = ppir.queryIntent(this, intent, resolvedType, r5, userId);
        goto L10
    L7:
        r5 = false;
        goto L8
    }

    private boolean isRecentsAccessingChildProfiles(int callingUid, int targetUserId) {
        if (((ActivityTaskManagerInternal) this.mInjector.getLocalService(ActivityTaskManagerInternal.class)).isCallerRecents(callingUid) == true) goto L5;
        return false;
    L5:
        long token = Binder.clearCallingIdentity();
        int callingUserId = UserHandle.getUserId(callingUid);     // Catch: Throwable -> L13
        if (ActivityManager.getCurrentUser() == callingUserId) goto L10;
        Binder.restoreCallingIdentity(token);
        return false;
    L10:
        boolean r1 = this.mUserManager.isSameProfileGroup(callingUserId, targetUserId);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r1;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    @Override // com.android.server.pm.Computer
    public final boolean isSameProfileGroup(int callerUserId, int userId) {
        long identity = Binder.clearCallingIdentity();
        boolean r2 = UserManagerService.getInstance().isSameProfileGroup(callerUserId, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public final boolean shouldFilterApplication(PackageStateInternal ps, int callingUid, ComponentName component, int componentType, int userId, boolean filterUninstall, boolean filterArchived) {
        if (Process.isSdkSandboxUid(callingUid) == false) goto L10;
        int clientAppUid = Process.getAppUidForSdkSandboxUid(callingUid);
        if (ps == null) goto L10;
        if (clientAppUid != UserHandle.getUid(userId, ps.getAppId())) goto L10;
        return false;
    L10:
        if (Process.isIsolated(callingUid) == false) goto L12;
        int callingUid2 = getIsolatedOwner(callingUid);
    L13:
        String instantAppPkgName = getInstantAppPackageName(callingUid2);
        if (instantAppPkgName == null) goto L16;
        boolean r3 = true;
    L17:
        boolean callerIsInstantApp = r3;
        if (ps != null) goto L20;
    L22:
        boolean r4 = false;
    L23:
        boolean packageArchivedForUser = r4;
        if (ps == null) goto L63;
        if (filterUninstall == false) goto L36;
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid2) == true) goto L36;
        if (ps.isHiddenUntilInstalled() == true) goto L36;
        if (ps.getUserStateOrDefault(userId).isInstalled() == true) goto L36;
        if (packageArchivedForUser == false) goto L63;
        if (filterArchived == true) goto L63;
    L36:
        if (isCallerSameApp(ps.getPackageName(), callingUid2) == false) goto L38;
        return false;
    L38:
        if (callerIsInstantApp == false) goto L53;
        if (ps.getUserStateOrDefault(userId).isInstantApp() == false) goto L42;
        return true;
    L42:
        if (component == null) goto L51;
        ParsedInstrumentation instrumentation = this.mInstrumentation.get(component);
        if (instrumentation == null) goto L49;
        if (isCallerSameApp(instrumentation.getTargetPackage(), callingUid2) == false) goto L49;
        return false;
    L49:
        return true ^ isComponentVisibleToInstantApp(component, componentType);
    L51:
        return true ^ ps.getPkg().isVisibleToInstantApps();
    L53:
        if (ps.getUserStateOrDefault(userId).isInstantApp() == true) goto L55;
        int appId = UserHandle.getAppId(callingUid2);
        SettingBase callingPs = this.mSettings.getSettingBase(appId);
        return this.mAppsFilter.shouldFilterApplication(this, callingUid2, callingPs, ps, userId);
    L55:
        if (canViewInstantApps(callingUid2, userId) == false) goto L57;
        return false;
    L57:
        if (component == null) goto L60;
        return true;
    L60:
        return true ^ this.mInstantAppRegistry.isInstantAccessGranted(userId, UserHandle.getAppId(callingUid2), ps.getAppId());
    L63:
        if (callerIsInstantApp == true) goto L68;
        if (filterUninstall == true) goto L68;
        if (Process.isSdkSandboxUid(callingUid2) == true) goto L68;
        return false;
    L68:
        return true;
    L20:
        if (PackageArchiver.isArchived(ps.getUserStateOrDefault(userId)) == false) goto L22;
        r4 = true;
        goto L23
    L16:
        r3 = false;
        goto L17
    L12:
        callingUid2 = callingUid;
        goto L13
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplication(PackageStateInternal ps, int callingUid, ComponentName component, int componentType, int userId, boolean filterUninstall) {
        return shouldFilterApplication(ps, callingUid, component, componentType, userId, filterUninstall, true);
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplication(PackageStateInternal ps, int callingUid, ComponentName component, int componentType, int userId) {
        return shouldFilterApplication(ps, callingUid, component, componentType, userId, false);
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplication(PackageStateInternal ps, int callingUid, int userId) {
        return shouldFilterApplication(ps, callingUid, null, 0, userId, false);
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplication(SharedUserSetting sus, int callingUid, int userId) {
        boolean filterApp = true;
        ArraySet<? extends PackageStateInternal> r1 = sus.getPackageStates();
        int index = r1.size() - 1;
    L3:
        if (index < 0) goto L7;
        if (filterApp == false) goto L7;
        int callingUid2 = callingUid;
        filterApp = filterApp & shouldFilterApplication(r1.valueAt(index), callingUid2, null, 0, userId, false);
        index = index - 1;
        callingUid = callingUid2;
    L7:
        return filterApp;
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplicationIncludingUninstalled(PackageStateInternal ps, int callingUid, int userId) {
        return shouldFilterApplication(ps, callingUid, null, 0, userId, true);
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplicationIncludingUninstalledNotArchived(PackageStateInternal ps, int callingUid, int userId) {
        return shouldFilterApplication(ps, callingUid, null, 0, userId, true, false);
    }

    @Override // com.android.server.pm.Computer
    public final boolean shouldFilterApplicationIncludingUninstalled(SharedUserSetting sus, int callingUid, int userId) {
        if (shouldFilterApplication(sus, callingUid, userId) == false) goto L6;
        return true;
    L6:
        if (PackageManagerServiceUtils.isSystemOrRootOrShell(callingUid) == false) goto L8;
        return false;
    L8:
        ArraySet<? extends PackageStateInternal> r0 = sus.getPackageStates();
        int index = 0;
    L10:
        if (index >= r0.size()) goto L19;
        PackageStateInternal ps = r0.valueAt(index);
        if (ps.getUserStateOrDefault(userId).isInstalled() == true) goto L17;
        if (ps.isHiddenUntilInstalled() == true) goto L17;
        index = index + 1;
    L17:
        return false;
    L19:
        return true;
    }

    private int bestDomainVerificationStatus(int status1, int status2) {
        if (status1 != 3) goto L5;
        return status2;
    L5:
        if (status2 != 3) goto L8;
        return status1;
    L8:
        return (int) MathUtils.max(status1, status2);
    }

    @Override // com.android.server.pm.Computer
    public final int checkUidPermission(String permName, int uid) {
        return this.mPermissionManager.checkUidPermission(uid, permName, 0);
    }

    @Override // com.android.server.pm.Computer
    public int getPackageUidInternal(String packageName, long flags, int userId, int callingUid) {
        PackageStateInternal packageState = this.mSettings.getPackage(packageName);
        AndroidPackage p = this.mPackages.get(packageName);
        if (p == null) goto L15;
        if (AndroidPackageUtils.isMatchForSystemOnly(packageState, flags) == false) goto L15;
        PackageStateInternal ps = getPackageStateInternal(p.getPackageName(), callingUid);
        if (ps == null) goto L15;
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L15;
        if (shouldFilterApplication(ps, callingUid, userId) == true) goto L15;
        return UserHandle.getUid(userId, p.getUid());
    L15:
        if ((4299169792L & flags) == 0) goto L24;
        PackageStateInternal ps2 = this.mSettings.getPackage(packageName);
        if (ps2 != null) goto L19;
        return -1;
    L19:
        if (PackageStateUtils.isMatch(ps2, flags) == true) goto L21;
        return -1;
    L21:
        if (shouldFilterApplication(ps2, callingUid, userId) == false) goto L23;
        return -1;
    L23:
        return UserHandle.getUid(userId, ps2.getAppId());
    L24:
        return -1;
    }

    private long updateFlags(long flags, int userId) {
        if ((flags & 786432) != 0) goto L11;
        UserManagerInternal umInternal = this.mInjector.getUserManagerInternal();
        if (umInternal.isUserUnlockingOrUnlocked(userId) == false) goto L9;
        return flags | 786432;
    L9:
        return flags | 524288;
    L11:
        return flags;
    }

    @Override // com.android.server.pm.Computer
    public final long updateFlagsForApplication(long flags, int userId) {
        return updateFlagsForPackage(flags, userId);
    }

    @Override // com.android.server.pm.Computer
    public final long updateFlagsForComponent(long flags, int userId) {
        return updateFlags(flags, userId);
    }

    @Override // com.android.server.pm.Computer
    public final long updateFlagsForPackage(long flags, int userId) {
        if (UserHandle.getCallingUserId() == 0) goto L7;
    L7:
        if ((4194304 & flags) == 0) goto L9;
        int userId2 = userId;
        enforceCrossUserPermission(Binder.getCallingUid(), userId2, false, false, !isRecentsAccessingChildProfiles(Binder.getCallingUid(), userId), "MATCH_ANY_USER flag requires INTERACT_ACROSS_USERS permission");
    L11:
        return updateFlags(flags, userId2);
    L9:
        userId2 = userId;
        goto L11
    }

    @Override // com.android.server.pm.Computer
    public final long updateFlagsForResolve(long flags, int userId, int callingUid, boolean wantInstantApps, boolean isImplicitImageCaptureIntentAndNotSetByDpc) {
        return updateFlagsForResolve(flags, userId, callingUid, wantInstantApps, false, isImplicitImageCaptureIntentAndNotSetByDpc);
    }

    @Override // com.android.server.pm.Computer
    public final long updateFlagsForResolve(long flags, int userId, int callingUid, boolean wantInstantApps, boolean onlyExposedExplicitly, boolean isImplicitImageCaptureIntentAndNotSetByDpc) {
        if (safeMode() == true) goto L5;
        if (isImplicitImageCaptureIntentAndNotSetByDpc == true) goto L5;
    L7:
        if (getInstantAppPackageName(callingUid) == null) goto L11;
        if (onlyExposedExplicitly == false) goto L10;
        flags = flags | 33554432;
    L10:
        long flags2 = (flags | 16777216) | 8388608;
    L27:
        return updateFlagsForComponent(flags2, userId);
    L11:
        boolean allowMatchInstant = false;
        if ((flags & 8388608) == 0) goto L14;
        boolean wantMatchInstant = true;
    L16:
        if (wantInstantApps == true) goto L22;
        if (wantMatchInstant == true) goto L19;
    L23:
        flags2 = flags & (-50331649);
        if (allowMatchInstant == true) goto L27;
        flags2 = flags2 & (-8388609);
        goto L27
    L19:
        if (canViewInstantApps(callingUid, userId) == false) goto L23;
    L22:
        allowMatchInstant = true;
        goto L23
    L14:
        wantMatchInstant = false;
    L5:
        flags = flags | DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES;
        goto L7
    }

    @Override // com.android.server.pm.Computer
    public final void enforceCrossUserOrProfilePermission(int callingUid, int userId, boolean requireFullPermission, boolean checkShell, String message) {
        if (userId < 0) goto L16;
        if (checkShell == false) goto L5;
        PackageManagerServiceUtils.enforceShellRestriction(this.mInjector.getUserManagerInternal(), "no_debugging_features", callingUid, userId);
    L5:
        int callingUserId = UserHandle.getUserId(callingUid);
        if (hasCrossUserPermission(callingUid, callingUserId, userId, requireFullPermission, false) == false) goto L8;
        return;
    L8:
        boolean isSameProfileGroup = isSameProfileGroup(callingUserId, userId);
        if (isSameProfileGroup == true) goto L11;
    L13:
        String errorMessage = buildInvalidCrossUserOrProfilePermissionMessage(callingUid, userId, message, requireFullPermission, isSameProfileGroup);
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMessage);
        throw new SecurityException(errorMessage);
    L11:
        if (PermissionChecker.checkPermissionForPreflight(this.mContext, "android.permission.INTERACT_ACROSS_PROFILES", -1, callingUid, getPackage(callingUid).getPackageName()) != 0) goto L13;
        return;
    L16:
        throw new IllegalArgumentException("Invalid userId " + userId);
    }

    private static String buildInvalidCrossUserOrProfilePermissionMessage(int callingUid, int userId, String message, boolean requireFullPermission, boolean isSameProfileGroup) {
        StringBuilder builder = new StringBuilder();
        if (message == null) goto L5;
        builder.append(message);
        builder.append(": ");
    L5:
        builder.append("UID ");
        builder.append(callingUid);
        builder.append(" requires ");
        builder.append("android.permission.INTERACT_ACROSS_USERS_FULL");
        if (requireFullPermission == true) goto L10;
        builder.append(" or ");
        builder.append("android.permission.INTERACT_ACROSS_USERS");
        if (isSameProfileGroup == false) goto L10;
        builder.append(" or ");
        builder.append("android.permission.INTERACT_ACROSS_PROFILES");
    L10:
        builder.append(" to access user ");
        builder.append(userId);
        builder.append(".");
        return builder.toString();
    }

    @Override // com.android.server.pm.Computer
    public final void enforceCrossUserPermission(int callingUid, int userId, boolean requireFullPermission, boolean checkShell, String message) {
        enforceCrossUserPermission(callingUid, userId, requireFullPermission, checkShell, false, message);
    }

    @Override // com.android.server.pm.Computer
    public final void enforceCrossUserPermission(int callingUid, int userId, boolean requireFullPermission, boolean checkShell, boolean requirePermissionWhenSameUser, String message) {
        if (userId < 0) goto L11;
        if (checkShell == false) goto L5;
        PackageManagerServiceUtils.enforceShellRestriction(this.mInjector.getUserManagerInternal(), "no_debugging_features", callingUid, userId);
    L5:
        int callingUserId = UserHandle.getUserId(callingUid);
        if (hasCrossUserPermission(callingUid, callingUserId, userId, requireFullPermission, requirePermissionWhenSameUser) == false) goto L8;
        return;
    L8:
        String errorMessage = buildInvalidCrossUserPermissionMessage(callingUid, userId, message, requireFullPermission);
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMessage);
        throw new SecurityException(errorMessage);
    L11:
        throw new IllegalArgumentException("Invalid userId " + userId);
    }

    private static String buildInvalidCrossUserPermissionMessage(int callingUid, int userId, String message, boolean requireFullPermission) {
        StringBuilder builder = new StringBuilder();
        if (message == null) goto L5;
        builder.append(message);
        builder.append(": ");
    L5:
        builder.append("UID ");
        builder.append(callingUid);
        builder.append(" requires ");
        builder.append("android.permission.INTERACT_ACROSS_USERS_FULL");
        if (requireFullPermission == true) goto L8;
        builder.append(" or ");
        builder.append("android.permission.INTERACT_ACROSS_USERS");
    L8:
        builder.append(" to access user ");
        builder.append(userId);
        builder.append(".");
        return builder.toString();
    }

    @Override // com.android.server.pm.Computer
    public SigningDetails getSigningDetails(String packageName) {
        AndroidPackage p = this.mPackages.get(packageName);
        if (p != null) goto L7;
        return null;
    L7:
        return p.getSigningDetails();
    }

    @Override // com.android.server.pm.Computer
    public SigningDetails getSigningDetails(int uid) {
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if (obj == null) goto L13;
        if ((obj instanceof SharedUserSetting) == false) goto L9;
        return ((SharedUserSetting) obj).signatures.mSigningDetails;
    L9:
        if ((obj instanceof PackageStateInternal) == false) goto L13;
        PackageStateInternal ps = (PackageStateInternal) obj;
        return ps.getSigningDetails();
    L13:
        return SigningDetails.UNKNOWN;
    }

    @Override // com.android.server.pm.Computer
    public boolean filterAppAccess(AndroidPackage pkg, int callingUid, int userId) {
        PackageStateInternal ps = getPackageStateInternal(pkg.getPackageName());
        return shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId);
    }

    @Override // com.android.server.pm.Computer
    public boolean filterAppAccess(String packageName, int callingUid, int userId, boolean filterUninstalled) {
        PackageStateInternal ps = getPackageStateInternal(packageName);
        return shouldFilterApplication(ps, callingUid, null, 0, userId, filterUninstalled);
    }

    @Override // com.android.server.pm.Computer
    public boolean filterAppAccess(int uid, int callingUid) {
        if (Process.isSdkSandboxUid(uid) == true) goto L5;
        int userId = UserHandle.getUserId(uid);
        int appId = UserHandle.getAppId(uid);
        Object setting = this.mSettings.getSettingBase(appId);
        if (setting != null) goto L15;
        return true;
    L15:
        if ((setting instanceof SharedUserSetting) == false) goto L19;
        return shouldFilterApplicationIncludingUninstalled((SharedUserSetting) setting, callingUid, userId);
    L19:
        if ((setting instanceof PackageStateInternal) == true) goto L21;
        return true;
    L21:
        return shouldFilterApplicationIncludingUninstalled((PackageStateInternal) setting, callingUid, userId);
    L5:
        if (callingUid != uid) goto L7;
        return false;
    L7:
        int clientAppUid = Process.getAppUidForSdkSandboxUid(uid);
        if (clientAppUid != uid) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.android.server.pm.Computer
    public void dump(int type, FileDescriptor fd, PrintWriter pw, DumpState dumpState) {
        String packageName = dumpState.getTargetPackageName();
        PackageStateInternal setting = this.mSettings.getPackage(packageName);
        dumpState.isCheckIn();
        if (packageName == null) goto L8;
        if (setting != null) goto L8;
        if (isApexPackage(packageName) == true) goto L8;
        return;
    L8:
        Integer r0 = null;
        switch(type) {
            case 1: goto L90;
            case 512: goto L89;
            case 4096: goto L88;
            case 8192: goto L67;
            case 32768: goto L64;
            case 262144: goto L54;
            case 524288: goto L44;
            case 1048576: goto L39;
            case 2097152: goto L20;
            case 33554432: goto L16;
            case 67108864: goto L11;
            default: goto L106;
        };
    L11:
        if (setting == null) goto L14;
        r0 = Integer.valueOf(setting.getAppId());
    L14:
        Integer filteringAppId = r0;
        this.mAppsFilter.dumpQueries(pw, filteringAppId, dumpState, this.mUserManager.getUserIds(), new ComputerEngine$$ExternalSyntheticLambda2(this));
        return;
    L20:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        if (dumpState.onTitlePrinted() == false) goto L23;
        pw.println();
    L23:
        ipw.println("Compiler stats:");
        ipw.increaseIndent();
        if (setting == null) goto L26;
        Collection<? extends PackageStateInternal> pkgSettings = Collections.singletonList(setting);
    L27:
        Iterator<? extends PackageStateInternal> r1 = pkgSettings.iterator();
    L29:
        if (r1.hasNext() == false) goto L120;
        PackageStateInternal pkgSetting = r1.next();
        AndroidPackageInternal r5 = pkgSetting.getPkg();
        if (r5 == null) goto L29;
        String pkgName = r5.getPackageName();
        ipw.println("[" + pkgName + "]");
        ipw.increaseIndent();
        CompilerStats.PackageStats stats = this.mCompilerStats.getPackageStats(pkgName);
        if (stats != null) goto L36;
        ipw.println("(No recorded stats)");
    L37:
        ipw.decreaseIndent();
        goto L29
    L36:
        stats.dump(ipw);
        goto L37
    L120:
        return;
    L26:
        pkgSettings = this.mSettings.getPackages().values();
        goto L27
    L39:
        IndentingPrintWriter ipw2 = new IndentingPrintWriter(pw, "  ");
        if (dumpState.onTitlePrinted() == false) goto L42;
        pw.println();
    L42:
        ipw2.println("Dexopt state:");
        ipw2.increaseIndent();
        DexOptHelper.dumpDexoptState(ipw2, packageName);
        ipw2.decreaseIndent();
        return;
    L54:
        android.util.IndentingPrintWriter writer = new android.util.IndentingPrintWriter(pw);
        if (dumpState.onTitlePrinted() == false) goto L57;
        pw.println();
    L57:
        writer.println("Domain verification status:");
        writer.increaseIndent();
        this.mDomainVerificationManager.printState(this, writer, packageName, -1);     // Catch: Exception -> L60
    L62:
        writer.decreaseIndent();
        return;
    L60:
        e = move-exception;
        pw.println("Failure printing domain verification information");
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failure printing domain verification information", e);
        goto L62
    L67:
        pw.flush();
        TypedXmlSerializer serializer = Xml.newFastSerializer();
        BufferedOutputStream str = new BufferedOutputStream(new FileOutputStream(fd));     // Catch: IOException -> L72 IllegalStateException -> L74 IllegalArgumentException -> L76
        serializer.setOutput(str, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L78
        serializer.startDocument(null, true);     // Catch: Throwable -> L78
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L78
        this.mSettings.writePreferredActivitiesLPr(serializer, 0, dumpState.isFullPreferred());     // Catch: Throwable -> L78
        serializer.endDocument();     // Catch: Throwable -> L78
        serializer.flush();     // Catch: Throwable -> L78
        str.close();     // Catch: IOException -> L72 IllegalStateException -> L74 IllegalArgumentException -> L76
        return;
    L78:
        th = move-exception;
        str.close();     // Catch: Throwable -> L82
        throw th;     // Catch: IOException -> L72 IllegalStateException -> L74 IllegalArgumentException -> L76
    L82:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L72 IllegalStateException -> L74 IllegalArgumentException -> L76
        throw th;     // Catch: IOException -> L72 IllegalStateException -> L74 IllegalArgumentException -> L76
    L72:
        e = move-exception;
        pw.println("Failed writing: " + e);
        return;
    L76:
        e = move-exception;
        pw.println("Failed writing: " + e);
        return;
    L74:
        e = move-exception;
        pw.println("Failed writing: " + e);
        return;
    L88:
        this.mSettings.dumpPreferred(pw, dumpState, packageName);
        return;
    L89:
        this.mSettings.dumpReadMessages(pw, dumpState);
        return;
    L90:
        this.mSharedLibraries.dump(pw, dumpState);
        return;
    L106:
        return;
    L16:
        if (packageName != null) goto L18;
    L19:
        this.mApexManager.dump(pw);
        dumpApex(pw, packageName);
        return;
    L18:
        if (isApexPackage(packageName) == true) goto L19;
        return;
    L44:
        if (dumpState.onTitlePrinted() == false) goto L46;
        pw.println();
    L46:
        IndentingPrintWriter ipw3 = new IndentingPrintWriter(pw, "  ", 120);
        ipw3.println();
        ipw3.println("Frozen packages:");
        ipw3.increaseIndent();
        if (this.mFrozenPackages.size() != 0) goto L49;
        ipw3.println("(none)");
    L53:
        ipw3.decreaseIndent();
        return;
    L49:
        int i = 0;
    L51:
        if (i >= this.mFrozenPackages.size()) goto L53;
        ipw3.print("package=");
        ipw3.print(this.mFrozenPackages.keyAt(i));
        ipw3.print(", refCounts=");
        ipw3.println(this.mFrozenPackages.valueAt(i));
        i = i + 1;
        goto L51
    L64:
        if (dumpState.onTitlePrinted() == false) goto L66;
        pw.println();
    L66:
        pw.println("Database versions:");
        this.mSettings.dumpVersionLPr(new IndentingPrintWriter(pw, "  "));
    }

    private void generateApexPackageInfo(List<PackageStateInternal> activePackages, List<PackageStateInternal> inactivePackages, List<PackageStateInternal> factoryActivePackages, List<PackageStateInternal> factoryInactivePackages) {
        Iterator<AndroidPackage> r0 = this.mPackages.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        AndroidPackage p = r0.next();
        String packageName = p.getPackageName();
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (p.isApex() == false) goto L4;
        if (ps == null) goto L4;
        activePackages.add(ps);
        if (ps.isUpdatedSystemApp() == false) goto L11;
        PackageStateInternal psDisabled = this.mSettings.getDisabledSystemPkg(packageName);
        factoryInactivePackages.add(psDisabled);
        inactivePackages.add(psDisabled);
        goto L4
    L11:
        factoryActivePackages.add(ps);
        goto L4
    }

    private void dumpApex(PrintWriter pw, String packageName) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ", 120);
        List<PackageStateInternal> activePackages = new ArrayList();
        List<PackageStateInternal> inactivePackages = new ArrayList();
        List<PackageStateInternal> factoryActivePackages = new ArrayList();
        List<PackageStateInternal> factoryInactivePackages = new ArrayList();
        generateApexPackageInfo(activePackages, inactivePackages, factoryActivePackages, factoryInactivePackages);
        ipw.println("Active APEX packages:");
        dumpApexPackageStates(activePackages, true, packageName, ipw);
        ipw.println("Inactive APEX packages:");
        dumpApexPackageStates(inactivePackages, false, packageName, ipw);
        ipw.println("Factory APEX packages:");
        dumpApexPackageStates(factoryActivePackages, true, packageName, ipw);
        dumpApexPackageStates(factoryInactivePackages, false, packageName, ipw);
    }

    private static void dumpApexPackageStates(List<PackageStateInternal> packageStates, boolean isActive, String packageName, IndentingPrintWriter ipw) {
        ipw.println();
        ipw.increaseIndent();
        int i = 0;
        int size = packageStates.size();
    L3:
        if (i >= size) goto L11;
        PackageStateInternal packageState = packageStates.get(i);
        AndroidPackageInternal pkg = packageState.getPkg();
        if (packageName != null) goto L7;
    L9:
        ipw.println(pkg.getPackageName());
        ipw.increaseIndent();
        ipw.println("Version: " + pkg.getLongVersionCode());
        ipw.println("Path: " + pkg.getBaseApkPath());
        ipw.println("IsActive: " + isActive);
        ipw.println("IsFactory: " + (packageState.isUpdatedSystemApp() ^ true));
        ipw.println("ApplicationInfo: ");
        ipw.increaseIndent();
        AndroidPackageUtils.generateAppInfoWithoutState(pkg).dump(new PrintWriterPrinter(ipw), "");
        ipw.decreaseIndent();
        ipw.decreaseIndent();
    L10:
        i = i + 1;
        goto L3
    L7:
        if (packageName.equals(pkg.getPackageName()) == true) goto L9;
    L11:
        ipw.decreaseIndent();
        ipw.println();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not found block with instruction: 0x01ad: MOVE (r10v3 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('match' int)]) A[DONT_GENERATE, REMOVE] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected PackageManagerService.FindPreferredActivityBodyResult findPreferredActivityBody(Intent intent, String resolvedType, long flags, List<ResolveInfo> query, boolean always, boolean removeMatches, boolean debug, int userId, boolean queryMayBeFiltered, int callingUid, boolean isDeviceProvisioned) {
        PackageManagerService.FindPreferredActivityBodyResult result = new PackageManagerService.FindPreferredActivityBodyResult();
        ComputerEngine r0 = this;
        long flags2 = r0.updateFlagsForResolve(flags, userId, callingUid, false, r0.isImplicitImageCaptureIntentAndNotSetByDpc(intent, userId, resolvedType, flags));
        Intent intent2 = PackageManagerServiceUtils.updateIntentForResolve(intent);
        ResolveInfo r9 = r0.findPersistentPreferredActivity(intent2, resolvedType, flags2, query, debug, userId);
        long flags3 = flags2;
        Intent intent3 = intent2;
        result.mPreferredResolveInfo = r9;
        if (result.mPreferredResolveInfo == null) goto L5;
        return result;
    L5:
        PreferredIntentResolver pir = r0.mSettings.getPreferredActivities(userId);
        if (debug == false) goto L8;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Looking for preferred activities...");
    L8:
        if (pir != null) goto L10;
        int r14 = userId;
        String r3 = resolvedType;
        List r4 = null;
    L16:
        if (r4 == null) goto L128;
        if (r4.size() <= 0) goto L128;
        boolean shouldDelayDropStalePreferred = r0.mExt.shouldDelayDropStalePreferred(intent3, r3);
        int delayedDropPreferredIndex = -1;
        if (debug == false) goto L22;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Figuring out best match...");
    L22:
        int n = query.size();
        int match = 0;
        int j = 0;
    L23:
        if (j >= n) goto L32;
        int delayedDropPreferredIndex2 = delayedDropPreferredIndex;
        ResolveInfo ri = query.get(j);
        if (debug == false) goto L29;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Match for " + ri.activityInfo + ": 0x" + Integer.toHexString(ri.match));
    L29:
        if (ri.match <= match) goto L31;
        match = ri.match;
    L31:
        j = j + 1;
        delayedDropPreferredIndex = delayedDropPreferredIndex2;
        flags3 = flags3;
        goto L23
    L32:
        int delayedDropPreferredIndex3 = delayedDropPreferredIndex;
        long flags4 = flags3;
        if (debug == false) goto L35;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Best match: 0x" + Integer.toHexString(match));
    L35:
        int match2 = match & 268369920;
        int m = r4.size();
        int i = 0;
        int delayedDropPreferredIndex4 = delayedDropPreferredIndex3;
    L36:
        if (i >= m) goto L120;
        PreferredActivity pa = (PreferredActivity) r4.get(i);
        List r16 = r4;
        int m2 = m;
        if (debug == false) goto L47;
        StringBuilder r11 = new StringBuilder();
        r11.append("Checking PreferredActivity ds=");
        if (pa.countDataSchemes() <= 0) goto L43;
        String r22 = pa.getDataScheme(0);
    L44:
        r11.append(r22);
        r11.append("\n  component=");
        r11.append(pa.mPref.mComponent);
        Slog.v(PackageManagerServiceMonitorEx.TAG, r11.toString());
        pa.dump(new LogPrinter(2, PackageManagerServiceMonitorEx.TAG, 3), "  ");
        goto L47
    L43:
        r22 = "<none>";
    L47:
        if (pa.mPref.mMatch == match2) goto L51;
        if (debug == false) goto L50;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Skipping bad match " + Integer.toHexString(pa.mPref.mMatch));
        int n2 = n;
    L119:
        i = i + 1;
        r3 = resolvedType;
        r4 = r16;
        m = m2;
        shouldDelayDropStalePreferred = shouldDelayDropStalePreferred;
        match2 = match2;
        n = n2;
        goto L36
    L50:
        n2 = n;
        goto L119
    L51:
        if (always == true) goto L53;
    L57:
        ActivityInfo ai = r0.getActivityInfo(pa.mPref.mComponent, ((flags4 | 512) | 524288) | 262144, r14);
        if (debug == false) goto L65;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Found preferred activity:");
        if (ai == null) goto L62;
        ai.dump(new LogPrinter(2, PackageManagerServiceMonitorEx.TAG, 3), "  ");
        goto L65
    L62:
        Slog.v(PackageManagerServiceMonitorEx.TAG, "  null");
    L65:
        if (isHomeIntent(intent3) == false) goto L68;
        if (isDeviceProvisioned == true) goto L68;
        boolean excludeSetupWizardHomeActivity = true;
    L69:
        if (excludeSetupWizardHomeActivity == true) goto L72;
        if (queryMayBeFiltered == true) goto L72;
        boolean allowSetMutation = true;
    L73:
        if (ai != null) goto L77;
        if (allowSetMutation == true) goto L76;
        n2 = n;
        goto L119
    L76:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Removing dangling preferred activity: " + pa.mPref.mComponent);
        pir.removeFilter(pa);
        result.mChanged = true;
        n2 = n;
        goto L119
    L77:
        int j2 = 0;
    L78:
        if (j2 >= n) goto L118;
        ResolveInfo ri2 = query.get(j2);
        n2 = n;
        boolean allowSetMutation2 = allowSetMutation;
        if (ri2.activityInfo.applicationInfo.packageName.equals(ai.applicationInfo.packageName) == false) goto L84;
        if (ri2.activityInfo.name.equals(ai.name) == false) goto L84;
        if (removeMatches == false) goto L88;
        if (allowSetMutation2 == false) goto L88;
        pir.removeFilter(pa);
        result.mChanged = true;
    L88:
        if (always == false) goto L114;
        if (pa.mPref.sameSet(query, excludeSetupWizardHomeActivity, r14) == true) goto L114;
        if (pa.mPref.isSuperset(query, excludeSetupWizardHomeActivity) == true) goto L93;
        if ("android.intent.action.MAIN".equals(intent3.getAction()) == true) goto L99;
    L101:
        boolean isHomeActivity = false;
    L103:
        if (isHomeActivity == true) goto L114;
        if (allowSetMutation2 == false) goto L109;
        if (shouldDelayDropStalePreferred == 0) goto L107;
        delayedDropPreferredIndex4 = r0.mExt.recordFirstDelayedDropIndex(delayedDropPreferredIndex4, i);
        goto L119
    L107:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Result set changed, dropping preferred activity for " + intent3 + " type " + resolvedType);
        pir.removeFilter(pa);
        PreferredActivity lastChosen = new PreferredActivity(pa, pa.mPref.mMatch, null, pa.mPref.mComponent, false);
        pir.addFilter(r0, lastChosen);
        result.mChanged = true;
    L109:
        result.mPreferredResolveInfo = null;
        return result;
    L99:
        if (intent3.hasCategory("android.intent.category.HOME") == false) goto L101;
        isHomeActivity = true;
        goto L103
    L93:
        if (allowSetMutation2 == false) goto L114;
        PreferredActivity freshPa = new PreferredActivity(pa, pa.mPref.mMatch, pa.mPref.discardObsoleteComponents(query), pa.mPref.mComponent, pa.mPref.mAlways);
        pir.removeFilter(pa);
        pir.addFilter(r0, freshPa);
        result.mChanged = true;
    L114:
        if (debug == false) goto L116;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Returning preferred activity: " + ri2.activityInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + ri2.activityInfo.name);
    L116:
        result.mPreferredResolveInfo = ri2;
        return result;
    L84:
        j2 = j2 + 1;
        n = n2;
        allowSetMutation = allowSetMutation2;
        goto L78
    L118:
        n2 = n;
    L72:
        allowSetMutation = false;
    L68:
        excludeSetupWizardHomeActivity = false;
        goto L69
    L53:
        if (pa.mPref.mAlways == true) goto L57;
        if (debug == false) goto L56;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Skipping mAlways=false entry");
    L56:
        n2 = n;
        goto L119
    L120:
        String r13 = r3;
        List r17 = r4;
        if (shouldDelayDropStalePreferred == false) goto L128;
        PreferredIntentResolver pir2 = pir;
        ComputerEngine r1 = r0;
        if (r1.mExt.applyDelayedStalePreferredDrop(r1, delayedDropPreferredIndex4, pir2, r17, intent3, r13) == false) goto L128;
        result.mChanged = true;
        result.mPreferredResolveInfo = null;
        return result;
    L128:
        return result;
    L10:
        if ((65536 & flags3) == 0) goto L12;
        boolean r5 = true;
    L13:
        r3 = resolvedType;
        r4 = pir.queryIntent(r0, intent3, r3, r5, userId);
        pir = pir;
        r0 = r0;
        r14 = userId;
        intent3 = intent3;
        goto L16
    L12:
        r5 = false;
        goto L13
    }

    private static boolean isHomeIntent(Intent intent) {
        if ("android.intent.action.MAIN".equals(intent.getAction()) == true) goto L5;
    L9:
        return false;
    L5:
        if (intent.hasCategory("android.intent.category.HOME") == false) goto L9;
        if (intent.hasCategory("android.intent.category.DEFAULT") == false) goto L9;
        return true;
    }

    @Override // com.android.server.pm.Computer
    public final PackageManagerService.FindPreferredActivityBodyResult findPreferredActivityInternal(Intent intent, String resolvedType, long flags, List<ResolveInfo> query, boolean always, boolean removeMatches, boolean debug, int userId, boolean queryMayBeFiltered) {
        int callingUid = Binder.getCallingUid();
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0) != 1) goto L5;
        boolean isDeviceProvisioned = true;
    L7:
        return findPreferredActivityBody(intent, resolvedType, flags, query, always, removeMatches, debug, userId, queryMayBeFiltered, callingUid, isDeviceProvisioned);
    L5:
        isDeviceProvisioned = false;
        goto L7
    }

    @Override // com.android.server.pm.Computer
    public final ResolveInfo findPersistentPreferredActivity(Intent intent, String resolvedType, long flags, List<ResolveInfo> query, boolean debug, int userId) {
        int n = query.size();
        PersistentPreferredIntentResolver ppir = this.mSettings.getPersistentPreferredActivities(userId);
        if (debug == false) goto L5;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Looking for persistent preferred activities...");
    L5:
        int r9 = 0;
        if (ppir != null) goto L8;
        List r4 = null;
    L14:
        if (r4 == null) goto L49;
        if (r4.size() <= 0) goto L49;
        int m = r4.size();
        int i = 0;
    L18:
        if (i >= m) goto L56;
        PersistentPreferredActivity ppa = (PersistentPreferredActivity) r4.get(i);
        if (debug == false) goto L26;
        StringBuilder r14 = new StringBuilder();
        r14.append("Checking PersistentPreferredActivity ds=");
        if (ppa.countDataSchemes() <= 0) goto L24;
        String r15 = ppa.getDataScheme(r9);
    L25:
        r14.append(r15);
        r14.append("\n  component=");
        r14.append(ppa.mComponent);
        Slog.v(PackageManagerServiceMonitorEx.TAG, r14.toString());
        ppa.dump(new LogPrinter(2, PackageManagerServiceMonitorEx.TAG, 3), "  ");
        goto L26
    L24:
        r15 = "<none>";
    L26:
        ActivityInfo ai = getActivityInfo(ppa.mComponent, flags | 512, userId);
        if (debug == false) goto L32;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Found persistent preferred activity:");
        if (ai == null) goto L31;
        ai.dump(new LogPrinter(2, PackageManagerServiceMonitorEx.TAG, 3), "  ");
        goto L32
    L31:
        Slog.v(PackageManagerServiceMonitorEx.TAG, "  null");
    L32:
        if (ai == null) goto L46;
        int j = 0;
    L35:
        if (j >= n) goto L46;
        ResolveInfo ri = query.get(j);
        if (ri.activityInfo.applicationInfo.packageName.equals(ai.applicationInfo.packageName) == false) goto L41;
        if (ri.activityInfo.name.equals(ai.name) == false) goto L41;
        if (debug == false) goto L44;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Returning persistent preferred activity: " + ri.activityInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + ri.activityInfo.name);
    L44:
        return ri;
    L41:
        j = j + 1;
    L46:
        i = i + 1;
        r9 = 0;
        goto L18
    L56:
        return null;
    L49:
        return null;
    L8:
        if ((flags & 65536) == 0) goto L10;
        boolean r5 = true;
    L11:
        r4 = ppir.queryIntent(this, intent, resolvedType, r5, userId);
        goto L14
    L10:
        r5 = false;
        goto L11
    }

    @Override // com.android.server.pm.Computer
    public PreferredIntentResolver getPreferredActivities(int userId) {
        return this.mSettings.getPreferredActivities(userId);
    }

    @Override // com.android.server.pm.Computer
    public ArrayMap<String, ? extends PackageStateInternal> getPackageStates() {
        return this.mSettings.getPackages();
    }

    @Override // com.android.server.pm.Computer
    public ArrayMap<String, ? extends PackageStateInternal> getDisabledSystemPackageStates() {
        return this.mSettings.getDisabledSystemPackages();
    }

    @Override // com.android.server.pm.Computer
    public String getRenamedPackage(String packageName) {
        return this.mSettings.getRenamedPackageLPr(packageName);
    }

    @Override // com.android.server.pm.Computer
    public WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> getSharedLibraries() {
        return this.mSharedLibraries.getAll();
    }

    @Override // com.android.server.pm.Computer
    public ArraySet<String> getNotifyPackagesForReplacedReceived(String[] packages) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        ArraySet<String> packagesToNotify = new ArraySet();
        int r3 = packages.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        String packageName = packages[r4];
        PackageStateInternal packageState = getPackageStateInternal(packageName);
        if (shouldFilterApplication(packageState, callingUid, callingUserId) == true) goto L7;
        packagesToNotify.add(packageName);
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return packagesToNotify;
    }

    @Override // com.android.server.pm.Computer
    public int getPackageStartability(boolean safeMode, String packageName, int callingUid, int userId) {
        boolean ceStorageUnlocked = StorageManager.isCeStorageUnlocked(userId);
        PackageStateInternal ps = getPackageStateInternal(packageName);
        if (ps != null) goto L5;
        return 1;
    L5:
        if (shouldFilterApplication(ps, callingUid, userId) == false) goto L7;
        return 1;
    L7:
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L29;
        if (safeMode == false) goto L15;
        if (ps.isSystem() == true) goto L15;
        return 2;
    L15:
        if (this.mFrozenPackages.containsKey(packageName) == false) goto L18;
        return 3;
    L18:
        if (ceStorageUnlocked == false) goto L20;
        return 0;
    L20:
        if (AndroidPackageUtils.isEncryptionAware(ps.getPkg()) == true) goto L27;
        return 4;
    L27:
        return 0;
    L29:
        return 1;
    }

    @Override // com.android.server.pm.Computer
    public boolean isPackageAvailable(String packageName, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return false;
    L5:
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "is package available");
        PackageStateInternal ps = getPackageStateInternal(packageName);
        if (ps != null) goto L8;
    L16:
        return false;
    L8:
        if (ps.getPkg() == null) goto L16;
        if (shouldFilterApplication(ps, callingUid, userId) == false) goto L12;
        return false;
    L12:
        PackageUserStateInternal state = ps.getUserStateOrDefault(userId);
        if (state == null) goto L16;
        return PackageUserStateUtils.isAvailable(state, 0);
    }

    @Override // com.android.server.pm.Computer
    public boolean isApexPackage(String packageName) {
        AndroidPackage pkg = this.mPackages.get(packageName);
        if (pkg != null) goto L5;
    L7:
        return false;
    L5:
        if (pkg.isApex() == false) goto L7;
        return true;
    }

    @Override // com.android.server.pm.Computer
    public String[] currentToCanonicalPackageNames(String[] names) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L5;
        return names;
    L5:
        String[] out = new String[names.length];
        int callingUserId = UserHandle.getUserId(callingUid);
        boolean canViewInstantApps = canViewInstantApps(callingUid, callingUserId);
        int i = names.length - 1;
    L6:
        if (i < 0) goto L25;
        PackageStateInternal ps = getPackageStateInternal(names[i]);
        boolean translateName = false;
        if (ps != null) goto L10;
    L20:
        if (translateName == false) goto L22;
        String r8 = ps.getRealName();
    L23:
        out[i] = r8;
        i = i - 1;
        goto L6
    L22:
        r8 = names[i];
        goto L23
    L10:
        if (ps.getRealName() == null) goto L20;
        boolean targetIsInstantApp = ps.getUserStateOrDefault(callingUserId).isInstantApp();
        if (targetIsInstantApp == false) goto L18;
        if (canViewInstantApps == true) goto L18;
        if (this.mInstantAppRegistry.isInstantAccessGranted(callingUserId, UserHandle.getAppId(callingUid), ps.getAppId()) == true) goto L18;
        boolean r9 = false;
    L19:
        translateName = r9;
    L18:
        r9 = true;
        goto L19
    L25:
        return out;
    }

    @Override // com.android.server.pm.Computer
    public String[] canonicalToCurrentPackageNames(String[] names) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L5;
        return names;
    L5:
        String[] out = new String[names.length];
        int callingUserId = UserHandle.getUserId(callingUid);
        boolean canViewInstantApps = canViewInstantApps(callingUid, callingUserId);
        int i = names.length - 1;
    L6:
        if (i < 0) goto L27;
        String cur = getRenamedPackage(names[i]);
        boolean translateName = false;
        if (cur == null) goto L22;
        PackageStateInternal ps = getPackageStateInternal(names[i]);
        boolean r9 = false;
        if (ps != null) goto L12;
    L14:
        boolean targetIsInstantApp = false;
    L16:
        if (targetIsInstantApp == false) goto L20;
        if (canViewInstantApps == true) goto L20;
        if (this.mInstantAppRegistry.isInstantAccessGranted(callingUserId, UserHandle.getAppId(callingUid), ps.getAppId()) == true) goto L20;
    L21:
        translateName = r9;
    L20:
        r9 = true;
        goto L21
    L12:
        if (ps.getUserStateOrDefault(callingUserId).isInstantApp() == false) goto L14;
        targetIsInstantApp = true;
    L22:
        if (translateName == false) goto L24;
        String r8 = cur;
    L25:
        out[i] = r8;
        i = i - 1;
        goto L6
    L24:
        r8 = names[i];
        goto L25
    L27:
        return out;
    }

    @Override // com.android.server.pm.Computer
    public int[] getPackageGids(String packageName, long flags, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        int callingUid = Binder.getCallingUid();
        long flags2 = updateFlagsForPackage(flags, userId);
        enforceCrossUserPermission(callingUid, userId, false, false, "getPackageGids");
        PackageStateInternal ps = getPackageStateInternal(packageName);
        if (ps != null) goto L9;
        return null;
    L9:
        if (ps.getPkg() == null) goto L19;
        if (AndroidPackageUtils.isMatchForSystemOnly(ps, flags2) == false) goto L19;
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L19;
        if (shouldFilterApplication(ps, callingUid, userId) == true) goto L19;
        return this.mPermissionManager.getGidsForUid(UserHandle.getUid(userId, ps.getAppId()));
    L19:
        if ((4299169792L & flags2) != 0) goto L21;
    L26:
        return null;
    L21:
        if (PackageStateUtils.isMatch(ps, flags2) == false) goto L26;
        if (shouldFilterApplication(ps, callingUid, userId) == true) goto L26;
        return this.mPermissionManager.getGidsForUid(UserHandle.getUid(userId, ps.getAppId()));
    }

    @Override // com.android.server.pm.Computer
    public int getTargetSdkVersion(String packageName) {
        PackageStateInternal ps = getPackageStateInternal(packageName);
        if (ps != null) goto L5;
    L12:
        return -1;
    L5:
        if (ps.getPkg() == null) goto L12;
        if (shouldFilterApplicationIncludingUninstalled(ps, Binder.getCallingUid(), UserHandle.getCallingUserId()) == false) goto L11;
        return -1;
    L11:
        return ps.getPkg().getTargetSdkVersion();
    }

    @Override // com.android.server.pm.Computer
    public boolean activitySupportsIntentAsUser(ComponentName resolveComponentName, ComponentName component, Intent intent, String resolvedType, int userId) {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "activitySupportsIntentAsUser");
        if (component.equals(resolveComponentName) == false) goto L5;
        return true;
    L5:
        ParsedActivity a = this.mComponentResolver.getActivity(component);
        if (a != null) goto L8;
        return false;
    L8:
        PackageStateInternal ps = getPackageStateInternal(component.getPackageName());
        if (ps != null) goto L12;
        return false;
    L12:
        if (shouldFilterApplication(ps, callingUid, component, 1, userId, true) == false) goto L14;
        return false;
    L14:
        int i = 0;
    L16:
        if (i >= a.getIntents().size()) goto L22;
        if (((ParsedIntentInfo) a.getIntents().get(i)).getIntentFilter().match(intent.getAction(), resolvedType, intent.getScheme(), intent.getData(), intent.getCategories(), PackageManagerServiceMonitorEx.TAG) >= 0) goto L19;
        i = i + 1;
        goto L16
    L19:
        return true;
    L22:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public ActivityInfo getReceiverInfo(ComponentName component, long flags, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        int callingUid = Binder.getCallingUid();
        long flags2 = updateFlagsForComponent(flags, userId);
        enforceCrossUserPermission(callingUid, userId, false, false, "get receiver info");
        ParsedActivity a = this.mComponentResolver.getReceiver(component);
        if (a != null) goto L8;
        return null;
    L8:
        PackageStateInternal ps = getPackageStateInternal(a.getPackageName());
        if (ps == null) goto L22;
        if (ps.getPkg() == null) goto L22;
        if (PackageStateUtils.isEnabledAndMatches(ps, a, flags2, userId) == true) goto L16;
        return null;
    L16:
        if (shouldFilterApplication(ps, callingUid, component, 2, userId) == false) goto L19;
        return null;
    L19:
        return PackageInfoUtils.generateActivityInfo(ps.getPkg(), a, flags2, ps.getUserStateOrDefault(userId), userId, ps);
    L22:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public ParceledListSlice<SharedLibraryInfo> getSharedLibraries(String packageName, long flags, int userId) {
        ComputerEngine r1 = this;
        int r6 = userId;
        if (r1.mUserManager.exists(r6) == true) goto L5;
        return null;
    L5:
        Preconditions.checkArgumentNonnegative(r6, "userId must be >= 0");
        int callingUid = Binder.getCallingUid();
        if (r1.getInstantAppPackageName(callingUid) == null) goto L8;
        return null;
    L8:
        long flags2 = r1.updateFlagsForPackage(flags, r6);
        if (r1.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") == 0) goto L21;
        if (r1.mContext.checkCallingOrSelfPermission("android.permission.DELETE_PACKAGES") == 0) goto L21;
        boolean r0 = false;
        if (r1.canRequestPackageInstalls(packageName, callingUid, r6, false) == true) goto L21;
        if (r1.mContext.checkCallingOrSelfPermission("android.permission.REQUEST_DELETE_PACKAGES") == 0) goto L21;
        if (r1.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_SHARED_LIBRARIES") == 0) goto L21;
    L22:
        boolean canSeeStaticAndSdkLibraries = r0;
        WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> sharedLibraries = r1.getSharedLibraries();
        List<SharedLibraryInfo> result = null;
        int libCount = sharedLibraries.size();
        int i = 0;
    L23:
        if (i >= libCount) goto L71;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = sharedLibraries.valueAt(i);
        if (versionedLib != null) goto L27;
        libCount = libCount;
        i = i;
        callingUid = callingUid;
        flags2 = flags2;
    L69:
        r6 = userId;
        flags2 = flags2;
        callingUid = callingUid;
        libCount = libCount;
        i = i + 1;
        r1 = this;
        goto L23
    L27:
        int callingUid2 = versionedLib.size();
        int j = 0;
        List<SharedLibraryInfo> result2 = result;
    L28:
        if (j >= callingUid2) goto L68;
        SharedLibraryInfo libInfo = versionedLib.valueAt(j);
        if (canSeeStaticAndSdkLibraries == false) goto L32;
    L37:
        long identity = Binder.clearCallingIdentity();
        VersionedPackage declaringPackage = libInfo.getDeclaringPackage();
        int libCount2 = libCount;
        String r2 = declaringPackage.getPackageName();     // Catch: Throwable -> L63
        int i2 = i;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib2 = versionedLib;
        long r3 = declaringPackage.getLongVersionCode();     // Catch: Throwable -> L61
        long r22 = flags2 | 67108864;
        int j2 = j;
        int j3 = Binder.getCallingUid();     // Catch: Throwable -> L59
        int versionCount = callingUid2;
        int libCount3 = r6;
        PackageInfo packageInfo = r1.getPackageInfoInternal(r2, r3, r22, j3, libCount3);     // Catch: Throwable -> L57
        if (packageInfo != null) goto L47;
        Binder.restoreCallingIdentity(identity);
        int callingUid3 = callingUid;
        long flags3 = flags2;
    L56:
        j = j2 + 1;
        r1 = this;
        r6 = userId;
        flags2 = flags3;
        callingUid = callingUid3;
        libCount = libCount2;
        i = i2;
        versionedLib = versionedLib2;
        callingUid2 = versionCount;
        goto L28
    L47:
        Binder.restoreCallingIdentity(identity);
        String r21 = libInfo.getPath();
        String r23 = libInfo.getPackageName();
        List r24 = libInfo.getAllCodePaths();
        String r25 = libInfo.getName();
        long r26 = libInfo.getLongVersion();
        int r27 = libInfo.getType();
        if (libInfo.getDependencies() != null) goto L50;
        ArrayList r29 = null;
    L51:
        callingUid3 = callingUid;
        flags3 = flags2;
        SharedLibraryInfo resLibInfo = new SharedLibraryInfo(r21, r23, r24, r25, r26, r27, declaringPackage, r29, libInfo.isNative(), getPackagesUsingSharedLibrary(libInfo, flags3, callingUid3, userId));
        if (result2 != null) goto L54;
        List<SharedLibraryInfo> result3 = new ArrayList();
    L55:
        result3.add(resLibInfo);
        result2 = result3;
        goto L56
    L54:
        result3 = result2;
        goto L55
    L50:
        r29 = new ArrayList(libInfo.getDependencies());
    L57:
        th = th;
    L65:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L59:
        th = th;
    L61:
        th = th;
    L63:
        th = th;
        goto L65
    L32:
        if (libInfo.isStatic() == true) goto L68;
        if (libInfo.isSdk() == false) goto L37;
    L68:
        result = result2;
        goto L69
    L71:
        if (result != null) goto L73;
        return null;
    L73:
        return new ParceledListSlice(result);
    L21:
        r0 = true;
        goto L22
    }

    @Override // com.android.server.pm.Computer
    public boolean canRequestPackageInstalls(String packageName, int callingUid, int userId, boolean throwIfPermNotDeclared) {
        int uid = getPackageUidInternal(packageName, 0, userId, callingUid);
        if (callingUid == uid) goto L10;
        if (PackageManagerServiceUtils.isSystemOrRoot(callingUid) == true) goto L10;
        throw new SecurityException("Caller uid " + callingUid + " does not own package " + packageName);
    L10:
        if (isInstantAppInternal(packageName, userId, 1000) == false) goto L12;
        return false;
    L12:
        AndroidPackage pkg = this.mPackages.get(packageName);
        if (pkg != null) goto L16;
        return false;
    L16:
        if (pkg.getTargetSdkVersion() >= 26) goto L19;
        return false;
    L19:
        if (pkg.getRequestedPermissions().contains("android.permission.REQUEST_INSTALL_PACKAGES") == true) goto L27;
        if (throwIfPermNotDeclared == true) goto L25;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Need to declare android.permission.REQUEST_INSTALL_PACKAGES to call this api");
        return false;
    L25:
        throw new SecurityException("Need to declare android.permission.REQUEST_INSTALL_PACKAGES to call this api");
    L27:
        return !isInstallDisabledForPackage(packageName, uid, userId);
    }

    @Override // com.android.server.pm.Computer
    public final boolean isInstallDisabledForPackage(String packageName, int uid, int userId) {
        if (this.mUserManager.hasUserRestriction("no_install_unknown_sources", userId) == false) goto L5;
    L15:
        return true;
    L5:
        if (this.mUserManager.hasUserRestriction("no_install_unknown_sources_globally", userId) == true) goto L15;
        if (this.mExternalSourcesPolicy == null) goto L14;
        int isTrusted = this.mExternalSourcesPolicy.getPackageTrustedToInstallApps(packageName, uid);
        if (isTrusted == 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public Pair<List<VersionedPackage>, List<Boolean>> getPackagesUsingSharedLibrary(SharedLibraryInfo libInfo, long flags, int callingUid, int userId) {
        ComputerEngine r0 = this;
        List<VersionedPackage> versionedPackages = null;
        ArrayMap<String, ? extends PackageStateInternal> packageStates = r0.getPackageStates();
        int packageCount = packageStates.size();
        List<Boolean> usesLibsOptional = null;
        int i = 0;
    L3:
        if (i >= packageCount) goto L67;
        PackageStateInternal ps = packageStates.valueAt(i);
        if (ps != null) goto L8;
    L65:
        i = i + 1;
        r0 = this;
        packageStates = packageStates;
        packageCount = packageCount;
        goto L3
    L8:
        if (PackageUserStateUtils.isAvailable(ps.getUserStateOrDefault(userId), flags) == false) goto L65;
        String libName = libInfo.getName();
        if (libInfo.isStatic() == true) goto L28;
        if (libInfo.isSdk() == true) goto L28;
        if (ps.getPkg() == null) goto L65;
        if (ArrayUtils.contains(ps.getPkg().getUsesLibraries(), libName) == true) goto L22;
        if (ArrayUtils.contains(ps.getPkg().getUsesOptionalLibraries(), libName) == false) goto L65;
    L22:
        if (r0.shouldFilterApplication(ps, callingUid, userId) == true) goto L65;
        if (versionedPackages != null) goto L26;
        versionedPackages = new ArrayList();
    L26:
        versionedPackages.add(new VersionedPackage(ps.getPackageName(), ps.getVersionCode()));
    L28:
        if (libInfo.isStatic() == false) goto L30;
        String[] libs = ps.getUsesStaticLibraries();
    L32:
        if (libInfo.isStatic() == false) goto L34;
        long[] libsVersions = ps.getUsesStaticLibrariesVersions();
    L36:
        if (libInfo.isSdk() == false) goto L38;
        boolean[] libsOptional = ps.getUsesSdkLibrariesOptional();
    L39:
        int libIdx = ArrayUtils.indexOf(libs, libName);
        if (libIdx < 0) goto L65;
        if (libsVersions[libIdx] != libInfo.getLongVersion()) goto L65;
        if (r0.shouldFilterApplication(ps, callingUid, userId) == true) goto L65;
        if (versionedPackages != null) goto L50;
        versionedPackages = new ArrayList();
    L50:
        if (usesLibsOptional != null) goto L52;
        usesLibsOptional = new ArrayList();
    L52:
        String dependentPackageName = ps.getPackageName();
        if (ps.getPkg() != null) goto L55;
    L57:
        String dependentPackageName2 = dependentPackageName;
    L58:
        versionedPackages.add(new VersionedPackage(dependentPackageName2, ps.getVersionCode()));
        if (libsOptional != null) goto L61;
    L63:
        boolean r1 = false;
    L64:
        usesLibsOptional.add(Boolean.valueOf(r1));
        goto L65
    L61:
        if (libsOptional[libIdx] == false) goto L63;
        r1 = true;
        goto L64
    L55:
        if (ps.getPkg().isStaticSharedLibrary() == false) goto L57;
        String dependentPackageName3 = ps.getPkg().getManifestPackageName();
        dependentPackageName2 = dependentPackageName3;
        goto L58
    L38:
        libsOptional = null;
        goto L39
    L34:
        libsVersions = ps.getUsesSdkLibrariesVersionsMajor();
        goto L36
    L30:
        libs = ps.getUsesSdkLibraries();
        goto L32
    L67:
        return new Pair(versionedPackages, usesLibsOptional);
    }

    @Override // com.android.server.pm.Computer
    public ParceledListSlice<SharedLibraryInfo> getDeclaredSharedLibraries(String packageName, long flags, int userId) {
        ComputerEngine r1 = this;
        r1.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_SHARED_LIBRARIES", "getDeclaredSharedLibraries");
        int callingUid = Binder.getCallingUid();
        r1.enforceCrossUserPermission(callingUid, userId, true, false, "getDeclaredSharedLibraries");
        int callingUid2 = callingUid;
        Preconditions.checkNotNull(packageName, "packageName cannot be null");
        Preconditions.checkArgumentNonnegative(userId, "userId must be >= 0");
        if (r1.mUserManager.exists(userId) == true) goto L6;
        return null;
    L6:
        if (r1.getInstantAppPackageName(callingUid2) == null) goto L8;
        return null;
    L8:
        WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> sharedLibraries = r1.getSharedLibraries();
        List<SharedLibraryInfo> result = null;
        int libraryCount = sharedLibraries.size();
        int i = 0;
    L9:
        if (i >= libraryCount) goto L52;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLibrary = sharedLibraries.valueAt(i);
        if (versionedLibrary != null) goto L13;
        int callingUid3 = callingUid2;
    L50:
        i = i + 1;
        r1 = this;
        callingUid2 = callingUid3;
        goto L9
    L13:
        int callingUid4 = versionedLibrary.size();
        int j = 0;
        List<SharedLibraryInfo> result2 = result;
    L14:
        if (j >= callingUid4) goto L49;
        SharedLibraryInfo libraryInfo = versionedLibrary.valueAt(j);
        VersionedPackage declaringPackage = libraryInfo.getDeclaringPackage();
        if (Objects.equals(declaringPackage.getPackageName(), packageName) == true) goto L18;
        int versionCount = callingUid4;
        int j2 = j;
    L28:
        int versionCount2 = callingUid2;
    L38:
        j = j2 + 1;
        r1 = this;
        callingUid2 = versionCount2;
        callingUid4 = versionCount;
        goto L14
    L18:
        long identity = Binder.clearCallingIdentity();
        j2 = j;
        versionCount = callingUid4;
        PackageInfo packageInfo = r1.getPackageInfoInternal(declaringPackage.getPackageName(), declaringPackage.getLongVersionCode(), flags | 67108864, Binder.getCallingUid(), userId);     // Catch: Throwable -> L39
        if (packageInfo != null) goto L29;
        Binder.restoreCallingIdentity(identity);
        goto L28
    L29:
        Binder.restoreCallingIdentity(identity);
        int callingUid5 = callingUid2;
        Pair<List<VersionedPackage>, List<Boolean>> usingSharedLibraryPair = getPackagesUsingSharedLibrary(libraryInfo, flags, callingUid5, userId);
        versionCount2 = callingUid5;
        String r24 = libraryInfo.getPath();
        String r25 = libraryInfo.getPackageName();
        List r26 = libraryInfo.getAllCodePaths();
        String r27 = libraryInfo.getName();
        long r28 = libraryInfo.getLongVersion();
        int r30 = libraryInfo.getType();
        VersionedPackage r31 = libraryInfo.getDeclaringPackage();
        List r32 = (List) usingSharedLibraryPair.first;
        if (libraryInfo.getDependencies() != null) goto L32;
        ArrayList r33 = null;
    L33:
        SharedLibraryInfo resultLibraryInfo = new SharedLibraryInfo(r24, r25, r26, r27, r28, r30, r31, r32, r33, libraryInfo.isNative());
        if (result2 != null) goto L36;
        List<SharedLibraryInfo> result3 = new ArrayList();
    L37:
        result3.add(resultLibraryInfo);
        result2 = result3;
        goto L38
    L36:
        result3 = result2;
        goto L37
    L32:
        r33 = new ArrayList(libraryInfo.getDependencies());
    L39:
        th = th;
    L47:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L41:
        th = th;
    L43:
        th = th;
    L45:
        th = th;
        goto L47
    L49:
        callingUid3 = callingUid2;
        result = result2;
        goto L50
    L52:
        if (result != null) goto L54;
        return null;
    L54:
        return new ParceledListSlice(result);
    }

    @Override // com.android.server.pm.Computer
    public ProviderInfo getProviderInfo(ComponentName component, long flags, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        int callingUid = Binder.getCallingUid();
        long flags2 = updateFlagsForComponent(flags, userId);
        enforceCrossUserPermission(callingUid, userId, false, false, "get provider info");
        ParsedProvider p = this.mComponentResolver.getProvider(component);
        if (p != null) goto L8;
        return null;
    L8:
        PackageStateInternal ps = getPackageStateInternal(p.getPackageName());
        if (ps == null) goto L25;
        if (ps.getPkg() == null) goto L25;
        if (PackageStateUtils.isEnabledAndMatches(ps, p, flags2, userId) == true) goto L16;
        return null;
    L16:
        if (shouldFilterApplication(ps, callingUid, component, 4, userId) == false) goto L18;
        return null;
    L18:
        PackageUserStateInternal state = ps.getUserStateOrDefault(userId);
        ApplicationInfo appInfo = PackageInfoUtils.generateApplicationInfo(ps.getPkg(), flags2, state, userId, ps);
        if (appInfo != null) goto L22;
        return null;
    L22:
        return PackageInfoUtils.generateProviderInfo(ps.getPkg(), p, flags2, state, appInfo, userId, ps);
    L25:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public ArrayMap<String, String> getSystemSharedLibraryNamesAndPaths() {
        WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> sharedLibraries = getSharedLibraries();
        ArrayMap<String, String> libs = new ArrayMap();
        int libCount = sharedLibraries.size();
        int i = 0;
    L3:
        if (i >= libCount) goto L20;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = sharedLibraries.valueAt(i);
        if (versionedLib == null) goto L18;
        int versionCount = versionedLib.size();
        int j = 0;
    L8:
        if (j >= versionCount) goto L18;
        SharedLibraryInfo libraryInfo = versionedLib.valueAt(j);
        if (libraryInfo.isStatic() == false) goto L11;
        PackageStateInternal ps = getPackageStateInternal(libraryInfo.getPackageName());
        if (ps == null) goto L17;
        if (filterSharedLibPackage(ps, Binder.getCallingUid(), UserHandle.getUserId(Binder.getCallingUid()), 67108864) == true) goto L17;
        libs.put(libraryInfo.getName(), libraryInfo.getPath());
    L17:
        j = j + 1;
        goto L8
    L11:
        libs.put(libraryInfo.getName(), libraryInfo.getPath());
    L18:
        i = i + 1;
        goto L3
    L20:
        return libs;
    }

    @Override // com.android.server.pm.Computer
    public PackageStateInternal getPackageStateForInstalledAndFiltered(String packageName, int callingUid, int userId) {
        PackageStateInternal packageState = getPackageStateInternal(packageName);
        if (packageState != null) goto L5;
        return null;
    L5:
        if (shouldFilterApplicationIncludingUninstalled(packageState, callingUid, userId) == true) goto L10;
        return packageState;
    L10:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public int checkSignatures(String pkg1, String pkg2, int userId) {
        int callingUid = Binder.getCallingUid();
        if ("com.android.cts.launchertests.support".equals(pkg1) == false) goto L5;
        ComputerEngine r0 = this;
        int userId2 = userId;
    L9:
        AndroidPackage p1 = r0.mPackages.get(pkg1);
        AndroidPackage p2 = r0.mPackages.get(pkg2);
        PackageStateInternal ps2 = null;
        if (p1 != null) goto L12;
        PackageStateInternal ps1 = null;
    L13:
        if (p2 == null) goto L17;
        ps2 = getPackageStateInternal(p2.getPackageName());
    L17:
        if (p1 == null) goto L30;
        if (ps1 == null) goto L30;
        if (p2 == null) goto L30;
        if (ps2 == null) goto L30;
        if (shouldFilterApplicationIncludingUninstalled(ps1, callingUid, userId2) == false) goto L25;
    L29:
        return -4;
    L25:
        if (shouldFilterApplicationIncludingUninstalled(ps2, callingUid, userId2) == true) goto L29;
        return checkSignaturesInternal(p1.getSigningDetails(), p2.getSigningDetails());
    L30:
        return -4;
    L12:
        ps1 = getPackageStateInternal(p1.getPackageName());
        goto L13
    L5:
        if ("com.android.cts.launchertests.support".equals(pkg2) == true) goto L7;
        r0 = this;
        userId2 = userId;
        r0.enforceCrossUserPermission(callingUid, userId2, false, false, "checkSignatures");
        goto L9
    L7:
        r0 = this;
        userId2 = userId;
        goto L9
    }

    @Override // com.android.server.pm.Computer
    public int checkUidSignatures(int uid1, int uid2) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        SigningDetails p1SigningDetails = getSigningDetailsAndFilterAccess(uid1, callingUid, callingUserId);
        SigningDetails p2SigningDetails = getSigningDetailsAndFilterAccess(uid2, callingUid, callingUserId);
        if (p1SigningDetails == null) goto L8;
        if (p2SigningDetails != null) goto L7;
        return -4;
    L7:
        return checkSignaturesInternal(p1SigningDetails, p2SigningDetails);
    L8:
        return -4;
    }

    @Override // com.android.server.pm.Computer
    public int checkUidSignaturesForAllUsers(int uid1, int uid2) {
        int callingUid = Binder.getCallingUid();
        int userId1 = UserHandle.getUserId(uid1);
        int userId2 = UserHandle.getUserId(uid2);
        enforceCrossUserPermission(callingUid, userId1, false, false, "checkUidSignaturesForAllUsers");
        enforceCrossUserPermission(callingUid, userId2, false, false, "checkUidSignaturesForAllUsers");
        SigningDetails p1SigningDetails = getSigningDetailsAndFilterAccess(uid1, callingUid, userId1);
        SigningDetails p2SigningDetails = getSigningDetailsAndFilterAccess(uid2, callingUid, userId2);
        if (p1SigningDetails == null) goto L8;
        if (p2SigningDetails != null) goto L7;
        return -4;
    L7:
        return checkSignaturesInternal(p1SigningDetails, p2SigningDetails);
    L8:
        return -4;
    }

    private SigningDetails getSigningDetailsAndFilterAccess(int uid, int callingUid, int userId) {
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if (obj != null) goto L6;
        return null;
    L6:
        if ((obj instanceof SharedUserSetting) == false) goto L13;
        SharedUserSetting sus = (SharedUserSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(sus, callingUid, userId) == false) goto L11;
        return null;
    L11:
        return sus.signatures.mSigningDetails;
    L13:
        if ((obj instanceof PackageSetting) == false) goto L19;
        PackageSetting ps = (PackageSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId) == false) goto L18;
        return null;
    L18:
        return ps.getSigningDetails();
    L19:
        return null;
    }

    private int checkSignaturesInternal(SigningDetails p1SigningDetails, SigningDetails p2SigningDetails) {
        if (p1SigningDetails != null) goto L8;
        if (p2SigningDetails == null) goto L28;
        return -1;
    L28:
        return 1;
    L8:
        if (p2SigningDetails != null) goto L11;
        return -2;
    L11:
        int result = PackageManagerServiceUtils.compareSignatures(p1SigningDetails, p2SigningDetails);
        if (result != 0) goto L15;
        return result;
    L15:
        if (p1SigningDetails.hasPastSigningCertificates() == true) goto L19;
        if (p2SigningDetails.hasPastSigningCertificates() == true) goto L19;
        return result;
    L19:
        if (p1SigningDetails.hasPastSigningCertificates() == false) goto L21;
        Signature[] p1Signatures = {p1SigningDetails.getPastSigningCertificates()[0]};
    L23:
        if (p2SigningDetails.hasPastSigningCertificates() == false) goto L25;
        Signature[] p2Signatures = {p2SigningDetails.getPastSigningCertificates()[0]};
    L27:
        return PackageManagerServiceUtils.compareSignatureArrays(p1Signatures, p2Signatures);
    L25:
        p2Signatures = p2SigningDetails.getSignatures();
        goto L27
    L21:
        p1Signatures = p1SigningDetails.getSignatures();
        goto L23
    }

    @Override // com.android.server.pm.Computer
    public boolean hasSigningCertificate(String packageName, byte[] certificate, int type) {
        AndroidPackage p = this.mPackages.get(packageName);
        if (p != null) goto L5;
        return false;
    L5:
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        PackageStateInternal ps = getPackageStateInternal(p.getPackageName());
        if (ps != null) goto L8;
    L16:
        return false;
    L8:
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, callingUserId) == true) goto L16;
        switch(type) {
            case 0: goto L15;
            case 1: goto L13;
            default: goto L11;
        };
    L11:
        return false;
    L13:
        return p.getSigningDetails().hasSha256Certificate(certificate);
    L15:
        return p.getSigningDetails().hasCertificate(certificate);
    }

    @Override // com.android.server.pm.Computer
    public boolean hasUidSigningCertificate(int uid, byte[] certificate, int type) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        SigningDetails signingDetails = getSigningDetailsAndFilterAccess(uid, callingUid, callingUserId);
        if (signingDetails != null) goto L5;
        return false;
    L5:
        switch(type) {
            case 0: goto L10;
            case 1: goto L8;
            default: goto L6;
        };
    L6:
        return false;
    L8:
        return signingDetails.hasSha256Certificate(certificate);
    L10:
        return signingDetails.hasCertificate(certificate);
    }

    @Override // com.android.server.pm.Computer
    public List<String> getAllPackages() {
        PackageManagerServiceUtils.enforceSystemOrRootOrShell("getAllPackages is limited to privileged callers");
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (canViewInstantApps(callingUid, callingUserId) == true) goto L5;
        String instantAppPkgName = getInstantAppPackageName(callingUid);
        List<String> result = new ArrayList();
        if (instantAppPkgName == null) goto L16;
        Iterator<AndroidPackage> r4 = this.mPackages.values().iterator();
    L10:
        if (r4.hasNext() == false) goto L27;
        AndroidPackage pkg = r4.next();
        if (pkg.isVisibleToInstantApps() == false) goto L10;
        result.add(pkg.getPackageName());
    L27:
        return result;
    L16:
        Iterator<AndroidPackage> r5 = this.mPackages.values().iterator();
    L18:
        if (r5.hasNext() == false) goto L27;
        AndroidPackage pkg2 = r5.next();
        PackageStateInternal ps = getPackageStateInternal(pkg2.getPackageName());
        if (ps == null) goto L26;
        if (ps.getUserStateOrDefault(callingUserId).isInstantApp() == false) goto L26;
        if (this.mInstantAppRegistry.isInstantAccessGranted(callingUserId, UserHandle.getAppId(callingUid), ps.getAppId()) == false) goto L18;
    L26:
        result.add(pkg2.getPackageName());
        goto L18
    L5:
        return new ArrayList(this.mPackages.keySet());
    }

    @Override // com.android.server.pm.Computer
    public String getNameForUid(int uid) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L6;
        return null;
    L6:
        if (Process.isSdkSandboxUid(uid) == false) goto L8;
        uid = getBaseSdkSandboxUid();
    L8:
        int callingUserId = UserHandle.getUserId(callingUid);
        if (isKnownIsolatedComputeApp(uid) == true) goto L29;
    L14:
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof SharedUserSetting) == false) goto L22;
        SharedUserSetting sus = (SharedUserSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(sus, callingUid, callingUserId) == false) goto L20;
        return null;
    L20:
        return sus.name + ":" + sus.mAppId;
    L22:
        if ((obj instanceof PackageSetting) == false) goto L28;
        PackageSetting ps = (PackageSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, callingUserId) == false) goto L27;
        return null;
    L27:
        return ps.getPackageName();
    L28:
        return null;
    L29:
        uid = getIsolatedOwner(uid);     // Catch: IllegalStateException -> L12
    L12:
        e = move-exception;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Expected isolated uid " + uid + " to have an owner", e);
        goto L14
    }

    @Override // com.android.server.pm.Computer
    public String[] getNamesForUids(int[] uids) {
        if (uids != null) goto L5;
    L39:
        return null;
    L5:
        if (uids.length == 0) goto L39;
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L10;
        return null;
    L10:
        int callingUserId = UserHandle.getUserId(callingUid);
        String[] names = new String[uids.length];
        int i = uids.length - 1;
    L11:
        if (i < 0) goto L38;
        int uid = uids[i];
        if (Process.isSdkSandboxUid(uid) == false) goto L16;
        uid = getBaseSdkSandboxUid();
    L16:
        if (isKnownIsolatedComputeApp(uid) == true) goto L40;
    L21:
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof SharedUserSetting) == false) goto L29;
        SharedUserSetting sus = (SharedUserSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(sus, callingUid, callingUserId) == false) goto L26;
        names[i] = null;
    L36:
        i = i - 1;
        goto L11
    L26:
        names[i] = "shared:" + sus.name;
        goto L36
    L29:
        if ((obj instanceof PackageSetting) == false) goto L35;
        PackageSetting ps = (PackageSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, callingUserId) == false) goto L33;
        names[i] = null;
        goto L36
    L33:
        names[i] = ps.getPackageName();
        goto L36
    L35:
        names[i] = null;
        goto L36
    L40:
        uid = getIsolatedOwner(uid);     // Catch: IllegalStateException -> L19
    L19:
        e = move-exception;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Expected isolated uid " + uid + " to have an owner", e);
        goto L21
    L38:
        return names;
    }

    @Override // com.android.server.pm.Computer
    public int getUidForSharedUser(String sharedUserName) {
        if (sharedUserName != null) goto L5;
        return -1;
    L5:
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L8;
        return -1;
    L8:
        SharedUserSetting suid = this.mSettings.getSharedUserFromId(sharedUserName);
        if (suid != null) goto L11;
    L14:
        return -1;
    L11:
        if (shouldFilterApplicationIncludingUninstalled(suid, callingUid, UserHandle.getUserId(callingUid)) == true) goto L14;
        return suid.mAppId;
    }

    @Override // com.android.server.pm.Computer
    public int getFlagsForUid(int uid) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L6;
        return 0;
    L6:
        if (Process.isSdkSandboxUid(uid) == false) goto L8;
        uid = getBaseSdkSandboxUid();
    L8:
        int callingUserId = UserHandle.getUserId(callingUid);
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof SharedUserSetting) == false) goto L16;
        SharedUserSetting sus = (SharedUserSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(sus, callingUid, callingUserId) == false) goto L14;
        return 0;
    L14:
        return sus.getFlags();
    L16:
        if ((obj instanceof PackageSetting) == false) goto L22;
        PackageSetting ps = (PackageSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, callingUserId) == false) goto L21;
        return 0;
    L21:
        return ps.getFlags();
    L22:
        return 0;
    }

    @Override // com.android.server.pm.Computer
    public int getPrivateFlagsForUid(int uid) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L6;
        return 0;
    L6:
        if (Process.isSdkSandboxUid(uid) == false) goto L8;
        uid = getBaseSdkSandboxUid();
    L8:
        int callingUserId = UserHandle.getUserId(callingUid);
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof SharedUserSetting) == false) goto L16;
        SharedUserSetting sus = (SharedUserSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(sus, callingUid, callingUserId) == false) goto L14;
        return 0;
    L14:
        return sus.getPrivateFlags();
    L16:
        if ((obj instanceof PackageSetting) == false) goto L22;
        PackageSetting ps = (PackageSetting) obj;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, callingUserId) == false) goto L21;
        return 0;
    L21:
        return ps.getPrivateFlags();
    L22:
        return 0;
    }

    @Override // com.android.server.pm.Computer
    public boolean isUidPrivileged(int uid) {
        if (getInstantAppPackageName(Binder.getCallingUid()) == null) goto L6;
        return false;
    L6:
        if (Process.isSdkSandboxUid(uid) == false) goto L8;
        uid = getBaseSdkSandboxUid();
    L8:
        int appId = UserHandle.getAppId(uid);
        Object obj = this.mSettings.getSettingBase(appId);
        if ((obj instanceof SharedUserSetting) == false) goto L20;
        SharedUserSetting sus = (SharedUserSetting) obj;
        ArraySet<? extends PackageStateInternal> r4 = sus.getPackageStates();
        int numPackages = r4.size();
        int index = 0;
    L11:
        if (index >= numPackages) goto L23;
        PackageStateInternal ps = r4.valueAt(index);
        if (ps.isPrivileged() == true) goto L14;
        index = index + 1;
        goto L11
    L14:
        return true;
    L23:
        return false;
    L20:
        if ((obj instanceof PackageSetting) == false) goto L23;
        PackageSetting ps2 = (PackageSetting) obj;
        return ps2.isPrivileged();
    }

    @Override // com.android.server.pm.Computer
    public String[] getAppOpPermissionPackages(String permissionName, int userId) {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "getAppOpPermissionPackages");
        if (permissionName == null) goto L19;
        if (getInstantAppPackageName(callingUid) != null) goto L19;
        if (this.mUserManager.exists(userId) == false) goto L19;
        ArraySet<String> packageNames = new ArraySet(this.mPermissionManager.getAppOpPermissionPackages(permissionName));
        int i = packageNames.size() - 1;
    L10:
        if (i < 0) goto L16;
        String packageName = packageNames.valueAt(i);
        if (shouldFilterApplicationIncludingUninstalled(this.mSettings.getPackage(packageName), callingUid, userId) == false) goto L15;
        packageNames.removeAt(i);
    L15:
        i = i - 1;
        goto L10
    L16:
        int i2 = packageNames.size();
        return (String[]) packageNames.toArray(new String[i2]);
    L19:
        return EmptyArray.STRING;
    }

    @Override // com.android.server.pm.Computer
    public ParceledListSlice<PackageInfo> getPackagesHoldingPermissions(String[] permissions, long flags, int userId) {
        if (this.mUserManager.exists(userId) == false) goto L5;
        long flags2 = updateFlagsForPackage(flags, userId);
        int userId2 = userId;
        enforceCrossUserPermission(Binder.getCallingUid(), userId2, true, false, "get packages holding permissions");
        if ((4299169792L & flags2) == 0) goto L9;
        boolean listUninstalled = true;
    L10:
        ArrayList<PackageInfo> list = new ArrayList();
        boolean[] tmpBools = new boolean[permissions.length];
        Iterator<? extends PackageStateInternal> r13 = getPackageStates().values().iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        PackageStateInternal ps = r13.next();
        if (ps.getPkg() != null) goto L17;
        if (listUninstalled == false) goto L12;
    L17:
        int userId3 = userId2;
        addPackageHoldingPermissions(list, ps, permissions, tmpBools, flags2, userId3);
        userId2 = userId3;
        goto L12
    L19:
        return new ParceledListSlice(list);
    L9:
        listUninstalled = false;
        goto L10
    L5:
        return ParceledListSlice.emptyList();
    }

    private void addPackageHoldingPermissions(ArrayList<PackageInfo> list, PackageStateInternal ps, String[] permissions, boolean[] tmp, long flags, int userId) {
        int numMatch = 0;
        int i = 0;
    L4:
        if (i >= permissions.length) goto L14;
        String permission = permissions[i];
        if (this.mPermissionManager.checkPermission(ps.getPackageName(), permission, "default:0", userId) == 0) goto L8;
        tmp[i] = false;
    L12:
        i = i + 1;
        goto L4
    L8:
        if (this.mExt.skipHoldingPermissionsForXts(permission) == true) goto L12;
        tmp[i] = true;
        numMatch = numMatch + 1;
        goto L12
    L14:
        if (numMatch != 0) goto L16;
        return;
    L16:
        PackageInfo pi = generatePackageInfo(ps, flags, userId);
        if (pi != null) goto L19;
        return;
    L19:
        if ((4096 & flags) == 0) goto L21;
    L30:
        list.add(pi);
        return;
    L21:
        if (numMatch != permissions.length) goto L23;
        pi.requestedPermissions = permissions;
        goto L30
    L23:
        pi.requestedPermissions = new String[numMatch];
        int numMatch2 = 0;
        int i2 = 0;
    L25:
        if (i2 >= permissions.length) goto L30;
        if (tmp[i2] == false) goto L29;
        pi.requestedPermissions[numMatch2] = permissions[i2];
        numMatch2 = numMatch2 + 1;
    L29:
        i2 = i2 + 1;
        goto L25
    }

    @Override // com.android.server.pm.Computer
    public List<ApplicationInfo> getInstalledApplications(long flags, int userId, int callingUid, boolean forceAllowCrossUser) {
        ComputerEngine r0 = this;
        int r6 = callingUid;
        if (r0.getInstantAppPackageName(r6) == null) goto L7;
        return Collections.emptyList();
    L7:
        if (r0.mUserManager.exists(userId) == false) goto L9;
        long flags2 = updateFlagsForApplication(flags, userId);
        boolean r3 = false;
        if ((4202496 & flags2) == 0) goto L13;
        boolean r1 = true;
    L14:
        boolean listUninstalled = r1;
        if ((1073741824 & flags2) == 0) goto L17;
        boolean r2 = true;
    L18:
        boolean listApex = r2;
        if (listUninstalled == false) goto L21;
    L23:
        boolean listArchivedOnly = r3;
        if (forceAllowCrossUser == true) goto L27;
        r0.enforceCrossUserPermission(Binder.getCallingUid(), userId, false, false, "get installed application info");
    L27:
        long flags3 = flags2;
        if (r0.mExt.checkGetInstallAppsPermission(r0.mContext, userId, r6, flags3) == false) goto L30;
        ArrayMap<String, ? extends PackageStateInternal> packageStates = r0.getPackageStates();
        if (listUninstalled == true) goto L57;
        if (listArchivedOnly == true) goto L57;
        ArrayList<ApplicationInfo> list = new ArrayList(r0.mPackages.size());
        Iterator<? extends PackageStateInternal> r13 = packageStates.values().iterator();
    L37:
        if (r13.hasNext() == false) goto L91;
        PackageStateInternal packageState = r13.next();
        AndroidPackageInternal r14 = packageState.getPkg();
        if (r14 == null) goto L37;
        if (listApex == true) goto L46;
        if (r14.isApex() == true) goto L37;
    L46:
        if (r0.filterSharedLibPackage(packageState, Binder.getCallingUid(), userId, flags3) == true) goto L37;
        if (r0.shouldFilterApplication(packageState, r6, userId) == true) goto L37;
        long flags4 = flags3;
        ApplicationInfo ai = PackageInfoUtils.generateApplicationInfo(r14, flags4, packageState.getUserStateOrDefault(userId), userId, packageState);
        flags3 = flags4;
        if (ai == null) goto L37;
        ai.packageName = r0.resolveExternalPackageName(r14);
        list.add(ai);
    L91:
        return list;
    L57:
        list = new ArrayList(packageStates.size());
        Iterator<? extends PackageStateInternal> r15 = packageStates.values().iterator();
    L59:
        if (r15.hasNext() == false) goto L91;
        PackageStateInternal ps = r15.next();
        long effectiveFlags = flags3;
        if (ps.isSystem() == false) goto L64;
        effectiveFlags = effectiveFlags | 4194304;
    L64:
        if (ps.getPkg() == null) goto L86;
        if (listApex == true) goto L69;
        if (ps.getPkg().isApex() == true) goto L59;
    L69:
        PackageUserStateInternal userState = ps.getUserStateOrDefault(userId);
        if (listArchivedOnly == false) goto L76;
        if (userState.isInstalled() == true) goto L76;
        if (userState.getArchiveState() == null) goto L59;
    L76:
        int r4 = userId;
        int r5 = r6;
        boolean r7 = r0.filterSharedLibPackage(ps, r5, r4, flags3);
        userId = r4;
        long flags5 = flags3;
        if (r7 == true) goto L78;
        if (r0.shouldFilterApplication(ps, r5, userId) == true) goto L81;
        ApplicationInfo ai2 = PackageInfoUtils.generateApplicationInfo(ps.getPkg(), effectiveFlags, ps.getUserStateOrDefault(userId), userId, ps);
        if (ai2 == null) goto L87;
        ai2.packageName = r0.resolveExternalPackageName(ps.getPkg());
    L87:
        if (ai2 == null) goto L89;
        list.add(ai2);
    L89:
        r0 = this;
        userId = userId;
        r6 = callingUid;
        flags3 = flags5;
        goto L59
    L81:
        r6 = r5;
        flags3 = flags5;
        goto L59
    L78:
        r6 = r5;
        flags3 = flags5;
        goto L59
    L86:
        flags5 = flags3;
        ComputerEngine r8 = r0;
        ai2 = r8.generateApplicationInfoFromSettings(ps.getPackageName(), effectiveFlags, callingUid, userId);
        goto L87
    L30:
        return Collections.emptyList();
    L21:
        if ((4294967296L & flags2) == 0) goto L23;
        r3 = true;
        goto L23
    L17:
        r2 = false;
        goto L18
    L13:
        r1 = false;
        goto L14
    L9:
        return Collections.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public ProviderInfo resolveContentProviderForUid(String name, long flags, int userId, int filterCallingUid) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.RESOLVE_COMPONENT_FOR_UID", "resolveContentProviderForUid");
        int callingUid = Binder.getCallingUid();
        int filterUserId = UserHandle.getUserId(filterCallingUid);
        enforceCrossUserPermission(callingUid, filterUserId, false, false, "resolveContentProviderForUid");
        if (filterAppAccess(filterCallingUid, callingUid) == false) goto L5;
        return null;
    L5:
        ProviderInfo pInfo = resolveContentProvider(name, flags, userId, filterCallingUid);
        if (pInfo != null) goto L8;
        return null;
    L8:
        ProviderInfo pInfo2 = resolveContentProvider(name, flags, userId, callingUid);
        if (pInfo2 != null) goto L11;
    L15:
        return null;
    L11:
        if (Objects.equals(pInfo.name, pInfo2.name) == false) goto L15;
        if (Objects.equals(pInfo.authority, pInfo2.authority) == false) goto L15;
        return pInfo;
    }

    @Override // com.android.server.pm.Computer
    public ProviderInfo resolveContentProvider(String name, long flags, int userId, int callingUid) {
        String authorityWithoutUserId = ContentProvider.getAuthorityWithoutUserId(name);
        int userId2 = ContentProvider.getUserIdFromAuthority(name, userId);
        if (this.mUserManager.exists(userId2) == true) goto L5;
        return null;
    L5:
        long flags2 = updateFlagsForComponent(flags, userId2);
        ProviderInfo providerInfo = this.mComponentResolver.queryProvider(this, authorityWithoutUserId, flags2, userId2);
        boolean checkedGrants = false;
        if (providerInfo != null) goto L8;
    L10:
        if (checkedGrants == false) goto L12;
    L25:
        int callingUid2 = callingUid;
    L26:
        if (providerInfo != null) goto L28;
        return null;
    L28:
        PackageStateInternal packageState = getPackageStateInternal(providerInfo.packageName);
        if (PackageStateUtils.isEnabledAndMatches(packageState, providerInfo, flags2, userId2) == true) goto L31;
        return null;
    L31:
        ComponentName component = new ComponentName(providerInfo.packageName, providerInfo.name);
        int userId3 = callingUid2;
        if (shouldFilterApplication(packageState, userId3, component, 4, userId2) == false) goto L34;
        return null;
    L34:
        return providerInfo;
    L12:
        if (DoppelgangerManager.allowCrossUser(UserHandle.getUserId(callingUid), userId2) == true) goto L25;
        boolean enforceCrossUser = true;
        if (ContentProvider.isAuthorityRedirectedForCloneProfile(authorityWithoutUserId) == false) goto L22;
        UserManagerInternal umInternal = this.mInjector.getUserManagerInternal();
        UserInfo userInfo = umInternal.getUserInfo(UserHandle.getUserId(callingUid));
        if (userInfo == null) goto L22;
        if (userInfo.isCloneProfile() == false) goto L22;
        if (userInfo.profileGroupId != userId2) goto L22;
        enforceCrossUser = false;
    L22:
        if (enforceCrossUser == false) goto L24;
        callingUid2 = callingUid;
        enforceCrossUserPermission(callingUid2, userId2, false, false, "resolveContentProvider");
        goto L26
    L24:
        callingUid2 = callingUid;
        goto L26
    L8:
        if (userId2 == UserHandle.getUserId(callingUid)) goto L10;
        UriGrantsManagerInternal ugmInternal = (UriGrantsManagerInternal) this.mInjector.getLocalService(UriGrantsManagerInternal.class);
        checkedGrants = ugmInternal.checkAuthorityGrants(callingUid, providerInfo, userId2, true);
        goto L10
    }

    @Override // com.android.server.pm.Computer
    public ProviderInfo getGrantImplicitAccessProviderInfo(int recipientUid, String visibleAuthority) {
        int callingUid = Binder.getCallingUid();
        int recipientUserId = UserHandle.getUserId(recipientUid);
        ProviderInfo contactsProvider = resolveContentProvider("com.android.contacts", 0, UserHandle.getUserId(callingUid), callingUid);
        if (contactsProvider == null) goto L18;
        if (contactsProvider.applicationInfo == null) goto L18;
        if (UserHandle.isSameApp(contactsProvider.applicationInfo.uid, callingUid) == false) goto L18;
        long token = Binder.clearCallingIdentity();
        ProviderInfo r13 = resolveContentProvider(visibleAuthority, 0, recipientUserId, callingUid);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return r13;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L18:
        throw new SecurityException(callingUid + " is not allow to call grantImplicitAccess");
    }

    @Override // com.android.server.pm.Computer
    @Deprecated
    public void querySyncProviders(boolean safeMode, List<String> outNames, List<ProviderInfo> outInfo) {
        if (getInstantAppPackageName(Binder.getCallingUid()) == null) goto L5;
        return;
    L5:
        List<String> names = new ArrayList();
        List<ProviderInfo> infos = new ArrayList();
        int callingUserId = UserHandle.getCallingUserId();
        ComputerEngine r2 = this;
        this.mComponentResolver.querySyncProviders(r2, names, infos, safeMode, callingUserId);
        int i = infos.size() - 1;
    L6:
        if (i < 0) goto L13;
        ProviderInfo providerInfo = infos.get(i);
        PackageStateInternal ps = r2.mSettings.getPackage(providerInfo.packageName);
        ComponentName component = new ComponentName(providerInfo.packageName, providerInfo.name);
        int callingUserId2 = callingUserId;
        callingUserId = callingUserId2;
        if (r2.shouldFilterApplication(ps, Binder.getCallingUid(), component, 4, callingUserId2) == false) goto L11;
        infos.remove(i);
        names.remove(i);
    L11:
        i = i - 1;
        r2 = this;
        goto L6
    L13:
        if (names.isEmpty() == true) goto L16;
        outNames.addAll(names);
    L16:
        if (infos.isEmpty() == true) goto L22;
        outInfo.addAll(infos);
        return;
    }

    @Override // com.android.server.pm.Computer
    public ParceledListSlice<ProviderInfo> queryContentProviders(String processName, int uid, long flags, String metaDataKey) {
        int callingUid = Binder.getCallingUid();
        if (processName == null) goto L5;
        int userId = UserHandle.getUserId(uid);
    L6:
        int userId2 = userId;
        enforceCrossUserPermission(callingUid, userId, false, false, "queryContentProviders");
        if (this.mUserManager.exists(userId2) == false) goto L9;
        long flags2 = updateFlagsForComponent(flags, userId2);
        List<ProviderInfo> matchList = this.mComponentResolver.queryProviders(this, processName, metaDataKey, uid, flags2, userId2);
        if (matchList != null) goto L13;
        int r3 = 0;
    L14:
        int listSize = r3;
        ArrayList<ProviderInfo> finalList = null;
        int i = 0;
    L15:
        if (i >= listSize) goto L27;
        ProviderInfo providerInfo = matchList.get(i);
        if (PackageStateUtils.isEnabledAndMatches(this.mSettings.getPackage(providerInfo.packageName), providerInfo, flags2, userId2) == false) goto L25;
        PackageStateInternal ps = this.mSettings.getPackage(providerInfo.packageName);
        ComponentName component = new ComponentName(providerInfo.packageName, providerInfo.name);
        int callingUid2 = callingUid;
        callingUid = callingUid2;
        if (shouldFilterApplication(ps, callingUid2, component, 4, userId2) == true) goto L25;
        if (finalList != null) goto L24;
        finalList = new ArrayList(listSize - i);
    L24:
        finalList.add(providerInfo);
    L25:
        i = i + 1;
        goto L15
    L27:
        if (finalList == null) goto L31;
        finalList.sort(sProviderInitOrderSorter);
        return new ParceledListSlice(finalList);
    L31:
        return ParceledListSlice.emptyList();
    L13:
        r3 = matchList.size();
        goto L14
    L9:
        return ParceledListSlice.emptyList();
    L5:
        userId = UserHandle.getCallingUserId();
        goto L6
    }

    @Override // com.android.server.pm.Computer
    public InstrumentationInfo getInstrumentationInfoAsUser(ComponentName component, int flags, int userId) {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "getInstrumentationInfoAsUser");
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        String packageName = component.getPackageName();
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        AndroidPackage pkg = this.mPackages.get(packageName);
        if (ps == null) goto L15;
        if (pkg == null) goto L15;
        if (shouldFilterApplication(ps, callingUid, component, 0, userId) == false) goto L12;
        return null;
    L12:
        ParsedInstrumentation i = this.mInstrumentation.get(component);
        PackageUserStateInternal state = ps.getUserStateOrDefault(userId);
        return PackageInfoUtils.generateInstrumentationInfo(i, pkg, flags, state, userId, ps);
    L15:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public ParceledListSlice<InstrumentationInfo> queryInstrumentationAsUser(String targetPackage, int flags, int userId) {
        int callingUid = Binder.getCallingUid();
        int userId2 = userId;
        enforceCrossUserPermission(callingUid, userId2, false, false, "queryInstrumentationAsUser");
        if (this.mUserManager.exists(userId2) == false) goto L5;
        ArrayList<InstrumentationInfo> finalList = new ArrayList();
        int numInstrumentations = this.mInstrumentation.size();
        int index = 0;
    L7:
        if (index >= numInstrumentations) goto L24;
        ParsedInstrumentation p = this.mInstrumentation.valueAt(index);
        if (targetPackage != null) goto L11;
    L12:
        String packageName = p.getPackageName();
        AndroidPackage pkg = this.mPackages.get(packageName);
        PackageStateInternal pkgSetting = getPackageStateInternal(packageName);
        if (pkg == null) goto L22;
        if (pkgSetting == null) goto L22;
        if (shouldFilterApplication(pkgSetting, callingUid, userId2) == true) goto L22;
        PackageUserStateInternal state = pkgSetting.getUserStateOrDefault(userId2);
        int userId3 = userId2;
        InstrumentationInfo ii = PackageInfoUtils.generateInstrumentationInfo(p, pkg, flags, state, userId3, pkgSetting);
        userId2 = userId3;
        if (ii == null) goto L22;
        finalList.add(ii);
    L22:
        index = index + 1;
        goto L7
    L11:
        if (targetPackage.equals(p.getTargetPackage()) == false) goto L22;
    L24:
        return new ParceledListSlice(finalList);
    L5:
        return ParceledListSlice.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public List<PackageStateInternal> findSharedNonSystemLibraries(PackageStateInternal pkgSetting) {
        List<SharedLibraryInfo> deps = SharedLibraryUtils.findSharedLibraries(pkgSetting);
        if (deps.isEmpty() == true) goto L15;
        List<PackageStateInternal> retValue = new ArrayList();
        Iterator<SharedLibraryInfo> r2 = deps.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        SharedLibraryInfo info = r2.next();
        PackageStateInternal depPackageSetting = getPackageStateInternal(info.getPackageName());
        if (depPackageSetting == null) goto L6;
        if (depPackageSetting.getPkg() == null) goto L6;
        retValue.add(depPackageSetting);
        goto L6
    L13:
        return retValue;
    L15:
        return Collections.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public boolean getApplicationHiddenSettingAsUser(String packageName, int userId) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USERS", null);
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, true, false, "getApplicationHidden for user " + userId);
        long callingId = Binder.clearCallingIdentity();
        PackageStateInternal ps = this.mSettings.getPackage(packageName);     // Catch: Throwable -> L15
        if (ps != null) goto L9;
        Binder.restoreCallingIdentity(callingId);
        return true;
    L9:
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId) == false) goto L12;
        Binder.restoreCallingIdentity(callingId);
        return true;
    L12:
        boolean r0 = ps.getUserStateOrDefault(userId).isHidden();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(callingId);
        return r0;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    private PackageUserStateInternal getUserStateOrDefaultForUser(String packageName, int userId) throws PackageManager.NameNotFoundException {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, true, false, "when asking about packages for user " + userId);
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (ps == null) goto L9;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId) == true) goto L9;
        return ps.getUserStateOrDefault(userId);
    L9:
        throw new PackageManager.NameNotFoundException(packageName);
    }

    @Override // com.android.server.pm.Computer
    public boolean isPackageSuspendedForUser(String packageName, int userId) throws PackageManager.NameNotFoundException {
        return getUserStateOrDefaultForUser(packageName, userId).isSuspended();
    }

    @Override // com.android.server.pm.Computer
    public boolean isPackageQuarantinedForUser(String packageName, int userId) throws PackageManager.NameNotFoundException {
        return getUserStateOrDefaultForUser(packageName, userId).isQuarantined();
    }

    @Override // com.android.server.pm.Computer
    public boolean isPackageStoppedForUser(String packageName, int userId) throws PackageManager.NameNotFoundException {
        return getUserStateOrDefaultForUser(packageName, userId).isStopped();
    }

    @Override // com.android.server.pm.Computer
    public boolean isSuspendingAnyPackages(String suspendingPackage, int suspendingUserId, int targetUserId) {
        UserPackage suspender = UserPackage.of(suspendingUserId, suspendingPackage);
        Iterator<? extends PackageStateInternal> r1 = getPackageStates().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        PackageStateInternal packageState = r1.next();
        PackageUserStateInternal state = packageState.getUserStateOrDefault(targetUserId);
        if (state.getSuspendParams() == null) goto L4;
        if (state.getSuspendParams().containsKey(suspender) == false) goto L4;
        return true;
    L12:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public ParceledListSlice<IntentFilter> getAllIntentFilters(String packageName) {
        if (TextUtils.isEmpty(packageName) == true) goto L5;
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        PackageStateInternal ps = getPackageStateInternal(packageName);
        if (ps != null) goto L9;
        AndroidPackage pkg = null;
    L10:
        if (pkg == null) goto L28;
        if (ArrayUtils.isEmpty(pkg.getActivities()) == true) goto L28;
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, callingUserId) == true) goto L17;
        int count = ArrayUtils.size(pkg.getActivities());
        ArrayList<IntentFilter> result = new ArrayList();
        int n = 0;
    L19:
        if (n >= count) goto L26;
        ParsedActivity activity = (ParsedActivity) pkg.getActivities().get(n);
        List<ParsedIntentInfo> intentInfos = activity.getIntents();
        int index = 0;
    L22:
        if (index >= intentInfos.size()) goto L24;
        result.add(new IntentFilter(intentInfos.get(index).getIntentFilter()));
        index = index + 1;
        goto L22
    L24:
        n = n + 1;
        goto L19
    L26:
        return new ParceledListSlice(result);
    L17:
        return ParceledListSlice.emptyList();
    L28:
        return ParceledListSlice.emptyList();
    L9:
        pkg = ps.getPkg();
        goto L10
    L5:
        return ParceledListSlice.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public boolean getBlockUninstallForUser(String packageName, int userId) {
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        int callingUid = Binder.getCallingUid();
        if (ps != null) goto L5;
        return false;
    L5:
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId) == false) goto L8;
        return false;
    L8:
        return this.mSettings.getBlockUninstall(userId, packageName);
    }

    @Override // com.android.server.pm.Computer
    public String getInstallerPackageName(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        InstallSource installSource = getInstallSource(packageName, callingUid, userId);
        if (installSource == null) goto L13;
        String installerPackageName = installSource.mInstallerPackageName;
        if (installerPackageName == null) goto L14;
        PackageStateInternal ps = this.mSettings.getPackage(installerPackageName);
        if (ps != null) goto L9;
    L10:
        return null;
    L9:
        if (shouldFilterApplicationIncludingUninstalledNotArchived(ps, callingUid, UserHandle.getUserId(callingUid)) == true) goto L10;
        return installerPackageName;
    L14:
        return installerPackageName;
    L13:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    }

    private InstallSource getInstallSource(String packageName, int callingUid, int userId) {
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (isApexPackage(packageName) == true) goto L5;
        if (ps != null) goto L8;
        return null;
    L8:
        if (shouldFilterApplicationIncludingUninstalledNotArchived(ps, callingUid, userId) == false) goto L11;
        return null;
    L11:
        return ps.getInstallSource();
    L5:
        return InstallSource.EMPTY;
    }

    @Override // com.android.server.pm.Computer
    public InstallSourceInfo getInstallSourceInfo(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "getInstallSourceInfo");
        InstallSource installSource = getInstallSource(packageName, callingUid, userId);
        if (installSource != null) goto L6;
        return null;
    L6:
        String installerPackageName = installSource.mInstallerPackageName;
        if (installerPackageName == null) goto L13;
        PackageStateInternal ps = this.mSettings.getPackage(installerPackageName);
        if (ps != null) goto L11;
    L12:
        String installerPackageName2 = null;
    L14:
        String installerPackageName3 = installSource.mUpdateOwnerPackageName;
        boolean isInstantApp = true;
        if (installerPackageName3 == null) goto L31;
        PackageStateInternal ps2 = this.mSettings.getPackage(installerPackageName3);
        if (callingUid != 1000) goto L19;
    L22:
        boolean isCallerSystemOrUpdateOwner = true;
    L24:
        if (ps2 != null) goto L26;
    L30:
        String updateOwnerPackageName = null;
    L33:
        if (installSource.mIsInitiatingPackageUninstalled == false) goto L45;
        if (getInstantAppPackageName(callingUid) != null) goto L38;
        isInstantApp = false;
    L38:
        if (isInstantApp == false) goto L40;
    L42:
        String initiatingPackageName = null;
    L43:
        String initiatingPackageName2 = initiatingPackageName;
    L54:
        String originatingPackageName = installSource.mOriginatingPackageName;
        if (originatingPackageName == null) goto L61;
        PackageStateInternal ps3 = this.mSettings.getPackage(originatingPackageName);
        if (ps3 != null) goto L59;
    L60:
        originatingPackageName = null;
        goto L61
    L59:
        if (shouldFilterApplicationIncludingUninstalled(ps3, callingUid, userId) == true) goto L60;
    L61:
        if (originatingPackageName != null) goto L63;
    L65:
        String originatingPackageName2 = originatingPackageName;
    L66:
        PackageSignatures signatures = installSource.mInitiatingPackageSignatures;
        if (initiatingPackageName2 == null) goto L72;
        if (signatures == null) goto L72;
        if (signatures.mSigningDetails == SigningDetails.UNKNOWN) goto L72;
        SigningInfo initiatingPackageSigningInfo = new SigningInfo(signatures.mSigningDetails);
    L74:
        return new InstallSourceInfo(initiatingPackageName2, initiatingPackageSigningInfo, originatingPackageName2, installerPackageName2, updateOwnerPackageName, installSource.mPackageSource);
    L72:
        initiatingPackageSigningInfo = null;
        goto L74
    L63:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") == 0) goto L65;
        originatingPackageName2 = null;
        goto L66
    L40:
        if (isCallerSameApp(packageName, callingUid) == false) goto L42;
        initiatingPackageName = installSource.mInitiatingPackageName;
        goto L43
    L45:
        if (Objects.equals(installSource.mInitiatingPackageName, installSource.mInstallerPackageName) == false) goto L47;
        initiatingPackageName2 = installerPackageName2;
        goto L54
    L47:
        String initiatingPackageName3 = installSource.mInitiatingPackageName;
        PackageStateInternal ps4 = this.mSettings.getPackage(initiatingPackageName3);
        if (ps4 != null) goto L50;
    L53:
        initiatingPackageName2 = null;
        goto L54
    L50:
        if (shouldFilterApplicationIncludingUninstalled(ps4, callingUid, userId) == true) goto L53;
        initiatingPackageName2 = initiatingPackageName3;
        goto L54
    L26:
        if (shouldFilterApplicationIncludingUninstalled(ps2, callingUid, userId) == true) goto L30;
        if (isCallerSystemOrUpdateOwner == true) goto L31;
        if (isCallerFromManagedUserOrProfile(userId) == false) goto L31;
    L19:
        if (isCallerSameApp(installerPackageName3, callingUid) == true) goto L22;
        isCallerSystemOrUpdateOwner = false;
    L31:
        updateOwnerPackageName = installerPackageName3;
        goto L33
    L11:
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId) == true) goto L12;
    L13:
        installerPackageName2 = installerPackageName;
        goto L14
    }

    @Override // com.android.server.pm.Computer
    public int getApplicationEnabledSetting(String packageName, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L6;
        return 2;
    L6:
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "get enabled");
        if (shouldFilterApplicationIncludingUninstalled(this.mSettings.getPackage(packageName), callingUid, userId) == true) goto L14;
        return this.mSettings.getApplicationEnabledSetting(packageName, userId);
    L14:
        throw new PackageManager.NameNotFoundException(packageName);     // Catch: PackageManager.NameNotFoundException -> L11
    L16:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    }

    @Override // com.android.server.pm.Computer
    public int getComponentEnabledSetting(ComponentName component, int callingUid, int userId) {
        enforceCrossUserPermission(Binder.getCallingUid(), userId, false, false, "getComponentEnabled");
        return getComponentEnabledSettingInternal(component, callingUid, userId);
    }

    @Override // com.android.server.pm.Computer
    public int getComponentEnabledSettingInternal(ComponentName component, int callingUid, int userId) {
        if (component != null) goto L6;
        return 0;
    L6:
        if (this.mUserManager.exists(userId) == true) goto L23;
        return 2;
    L23:
        ComponentName component2 = component;
        if (shouldFilterApplication(this.mSettings.getPackage(component.getPackageName()), callingUid, component2, 0, userId, true) == true) goto L18;
        return this.mSettings.getComponentEnabledSetting(component2, userId);
    L18:
        throw new PackageManager.NameNotFoundException(component2.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L15
    L22:
        throw new IllegalArgumentException("Unknown component: " + component2);
    L20:
        component2 = component;
        goto L22
    }

    @Override // com.android.server.pm.Computer
    public boolean isComponentEffectivelyEnabled(ComponentInfo componentInfo, UserHandle userHandle) {
        String packageName = componentInfo.packageName;     // Catch: PackageManager.NameNotFoundException -> L8
        int userId = userHandle.getIdentifier();     // Catch: PackageManager.NameNotFoundException -> L8
        int appEnabledSetting = this.mSettings.getApplicationEnabledSetting(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L8
        if (appEnabledSetting == 0) goto L6;
        if (appEnabledSetting == 1) goto L12;
        return false;
    L12:
        int componentEnabledSetting = this.mSettings.getComponentEnabledSetting(componentInfo.getComponentName(), userId);     // Catch: PackageManager.NameNotFoundException -> L8
        if (componentEnabledSetting != 0) goto L16;
        return componentInfo.isEnabled();
    L16:
        if (componentEnabledSetting == 1) goto L18;
        return false;
    L18:
        return true;
    L6:
        if (componentInfo.applicationInfo.enabled == true) goto L12;
        return false;
    L20:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public boolean isApplicationEffectivelyEnabled(String packageName, UserHandle userHandle) {
        int appEnabledSetting = this.mSettings.getApplicationEnabledSetting(packageName, userHandle.getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L10
        if (appEnabledSetting != 0) goto L13;
        AndroidPackage pkg = getPackage(packageName);     // Catch: PackageManager.NameNotFoundException -> L10
        if (pkg != null) goto L8;
        return false;
    L8:
        return pkg.isEnabled();
    L13:
        if (appEnabledSetting == 1) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public KeySet getKeySetByAlias(String packageName, String alias) {
        if (packageName == null) goto L13;
        if (alias == null) goto L15;
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        AndroidPackage pkg = this.mPackages.get(packageName);
        if (pkg != null) goto L8;
    L11:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "KeySet requested for unknown package: " + packageName);
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L8:
        if (shouldFilterApplicationIncludingUninstalled(getPackageStateInternal(pkg.getPackageName()), callingUid, callingUserId) == true) goto L11;
        KeySetManagerService ksms = this.mSettings.getKeySetManagerService();
        return new KeySet(ksms.getKeySetByAliasAndPackageNameLPr(packageName, alias));
    L15:
        return null;
    L13:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public KeySet getSigningKeySet(String packageName) {
        if (packageName != null) goto L5;
        return null;
    L5:
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        AndroidPackage pkg = this.mPackages.get(packageName);
        if (pkg != null) goto L8;
    L18:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "KeySet requested for unknown package: " + packageName + ", uid:" + callingUid);
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L8:
        if (shouldFilterApplicationIncludingUninstalled(getPackageStateInternal(pkg.getPackageName()), callingUid, callingUserId) == true) goto L18;
        if (UserHandle.isSameApp(callingUid, pkg.getUid()) == false) goto L12;
    L16:
        KeySetManagerService ksms = this.mSettings.getKeySetManagerService();
        return new KeySet(ksms.getSigningKeySetByPackageNameLPr(packageName));
    L12:
        if (1000 == callingUid) goto L16;
        throw new SecurityException("May not access signing KeySet of other apps.");
    }

    @Override // com.android.server.pm.Computer
    public boolean isPackageSignedByKeySet(String packageName, KeySet ks) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L5;
        return false;
    L5:
        if (packageName == null) goto L19;
        if (ks == null) goto L19;
        AndroidPackage pkg = this.mPackages.get(packageName);
        int callingUserId = UserHandle.getUserId(callingUid);
        if (pkg != null) goto L11;
    L17:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "KeySet requested for unknown package: " + packageName);
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L11:
        if (shouldFilterApplicationIncludingUninstalled(getPackageStateInternal(pkg.getPackageName()), callingUid, callingUserId) == true) goto L17;
        IBinder ksh = ks.getToken();
        if ((ksh instanceof KeySetHandle) == false) goto L16;
        KeySetManagerService ksms = this.mSettings.getKeySetManagerService();
        return ksms.packageIsSignedByLPr(packageName, (KeySetHandle) ksh);
    L16:
        return false;
    L19:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public boolean isPackageSignedByKeySetExactly(String packageName, KeySet ks) {
        int callingUid = Binder.getCallingUid();
        if (getInstantAppPackageName(callingUid) == null) goto L5;
        return false;
    L5:
        if (packageName == null) goto L19;
        if (ks == null) goto L19;
        AndroidPackage pkg = this.mPackages.get(packageName);
        int callingUserId = UserHandle.getUserId(callingUid);
        if (pkg != null) goto L11;
    L17:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "KeySet requested for unknown package: " + packageName);
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L11:
        if (shouldFilterApplicationIncludingUninstalled(getPackageStateInternal(pkg.getPackageName()), callingUid, callingUserId) == true) goto L17;
        IBinder ksh = ks.getToken();
        if ((ksh instanceof KeySetHandle) == false) goto L16;
        KeySetManagerService ksms = this.mSettings.getKeySetManagerService();
        return ksms.packageIsSignedByExactlyLPr(packageName, (KeySetHandle) ksh);
    L16:
        return false;
    L19:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public SparseArray<int[]> getVisibilityAllowLists(String packageName, int[] userIds) {
        PackageStateInternal ps = getPackageStateInternal(packageName, 1000);
        if (ps != null) goto L7;
        return null;
    L7:
        return this.mAppsFilter.getVisibilityAllowList(this, ps, userIds, getPackageStates());
    }

    @Override // com.android.server.pm.Computer
    public int[] getVisibilityAllowList(String packageName, int userId) {
        SparseArray<int[]> visibilityAllowList = getVisibilityAllowLists(packageName, new int[]{userId});
        if (visibilityAllowList != null) goto L7;
        return null;
    L7:
        return visibilityAllowList.get(userId);
    }

    @Override // com.android.server.pm.Computer
    public boolean canQueryPackage(int callingUid, String targetPackageName) {
        if (callingUid == 0) goto L39;
        if (targetPackageName == null) goto L39;
        Object setting = this.mSettings.getSettingBase(UserHandle.getAppId(callingUid));
        if (setting != null) goto L9;
        return false;
    L9:
        int userId = UserHandle.getUserId(callingUid);
        int targetAppId = UserHandle.getAppId(getPackageUid(targetPackageName, 0, userId));
        if (targetAppId == (-1)) goto L21;
        Object targetSetting = this.mSettings.getSettingBase(targetAppId);
        if (targetSetting != null) goto L15;
        return false;
    L15:
        if ((targetSetting instanceof PackageSetting) == false) goto L19;
        return true ^ shouldFilterApplication((PackageSetting) targetSetting, callingUid, userId);
    L19:
        return true ^ shouldFilterApplication((SharedUserSetting) targetSetting, callingUid, userId);
    L21:
        if ((setting instanceof PackageSetting) == false) goto L29;
        AndroidPackage pkg = ((PackageSetting) setting).getPkg();
        if (pkg == null) goto L28;
        if (this.mAppsFilter.canQueryPackage(pkg, targetPackageName) == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        ArraySet<? extends PackageStateInternal> r5 = ((SharedUserSetting) setting).getPackageStates();
        int i = r5.size() - 1;
    L30:
        if (i < 0) goto L38;
        AndroidPackage pkg2 = r5.valueAt(i).getPkg();
        if (pkg2 == null) goto L36;
        if (this.mAppsFilter.canQueryPackage(pkg2, targetPackageName) == false) goto L36;
        return true;
    L36:
        i = i - 1;
        goto L30
    L38:
        return false;
    L39:
        return true;
    }

    @Override // com.android.server.pm.Computer
    public int getPackageUid(String packageName, long flags, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L6;
        return -1;
    L6:
        int callingUid = Binder.getCallingUid();
        long flags2 = updateFlagsForPackage(flags, userId);
        enforceCrossUserPermission(callingUid, userId, false, false, "getPackageUid");
        return getPackageUidInternal(packageName, flags2, userId, callingUid);
    }

    @Override // com.android.server.pm.Computer
    public boolean canAccessComponent(int callingUid, ComponentName component, int userId) {
        PackageStateInternal packageState = getPackageStateInternal(component.getPackageName());
        if (packageState == null) goto L8;
        if (shouldFilterApplication(packageState, callingUid, component, 0, userId, true) == true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public boolean isCallerInstallerOfRecord(AndroidPackage pkg, int callingUid) {
        if (pkg != null) goto L5;
        return false;
    L5:
        PackageStateInternal packageState = getPackageStateInternal(pkg.getPackageName());
        if (packageState != null) goto L8;
        return false;
    L8:
        PackageStateInternal installerPackageState = getPackageStateInternal(packageState.getInstallSource().mInstallerPackageName);
        if (installerPackageState != null) goto L11;
        return false;
    L11:
        if (UserHandle.isSameApp(installerPackageState.getAppId(), callingUid) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public int getInstallReason(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, true, false, "get install reason");
        PackageStateInternal ps = this.mSettings.getPackage(packageName);
        if (ps != null) goto L5;
        return 0;
    L5:
        if (shouldFilterApplicationIncludingUninstalled(ps, callingUid, userId) == false) goto L8;
        return 0;
    L8:
        return ps.getUserStateOrDefault(userId).getInstallReason();
    }

    @Override // com.android.server.pm.Computer
    public boolean[] canPackageQuery(String sourcePackageName, String[] targetPackageNames, int userId) {
        int targetSize = targetPackageNames.length;
        boolean[] results = new boolean[targetSize];
        if (this.mUserManager.exists(userId) == true) goto L5;
        return results;
    L5:
        int callingUid = Binder.getCallingUid();
        enforceCrossUserPermission(callingUid, userId, false, false, "can package query");
        PackageStateInternal sourceSetting = getPackageStateInternal(sourcePackageName);
        PackageStateInternal[] targetSettings = new PackageStateInternal[targetSize];
        if (sourceSetting != null) goto L8;
    L11:
        boolean throwException = true;
    L12:
        int i = 0;
    L13:
        if (throwException == true) goto L23;
        if (i >= targetSize) goto L23;
        targetSettings[i] = getPackageStateInternal(targetPackageNames[i]);
        if (targetSettings[i] != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        throwException = r10;
        i = i + 1;
        goto L13
    L18:
        if (shouldFilterApplicationIncludingUninstalled(targetSettings[i], callingUid, userId) == true) goto L21;
        r10 = false;
    L23:
        if (throwException == true) goto L30;
        int sourcePackageUid = UserHandle.getUid(userId, sourceSetting.getAppId());
        int i2 = 0;
    L25:
        if (i2 >= targetSize) goto L28;
        results[i2] = !shouldFilterApplication(targetSettings[i2], sourcePackageUid, userId);
        i2 = i2 + 1;
        goto L25
    L28:
        return results;
    L30:
        throw new ParcelableException(new PackageManager.NameNotFoundException("Package(s) " + sourcePackageName + " and/or " + Arrays.toString(targetPackageNames) + " not found."));
    L8:
        if (shouldFilterApplicationIncludingUninstalled(sourceSetting, callingUid, userId) == true) goto L11;
        throwException = false;
        goto L12
    }

    @Override // com.android.server.pm.Computer
    public boolean canForwardTo(Intent intent, String resolvedType, int sourceUserId, int targetUserId) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
        if (this.mCrossProfileIntentResolverEngine.canReachTo(this, intent, resolvedType, sourceUserId, targetUserId) == false) goto L6;
        return true;
    L6:
        if (intent.hasWebURI() == false) goto L15;
        int callingUid = Binder.getCallingUid();
        UserInfo parent = getProfileParent(sourceUserId);
        if (parent != null) goto L10;
        return false;
    L10:
        long flags = updateFlagsForResolve(0, parent.id, callingUid, false, isImplicitImageCaptureIntentAndNotSetByDpc(intent, parent.id, resolvedType, 0));
        CrossProfileDomainInfo xpDomainInfo = getCrossProfileDomainPreferredLpr(intent, resolvedType, 65536 | flags, sourceUserId, parent.id);
        if (xpDomainInfo == null) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    @Override // com.android.server.pm.Computer
    public List<ApplicationInfo> getPersistentApplications(boolean safeMode, int flags) {
        ArrayList<ApplicationInfo> finalList = new ArrayList();
        int numPackages = this.mPackages.size();
        int userId = UserHandle.getCallingUserId();
        int index = 0;
    L3:
        if (index >= numPackages) goto L30;
        AndroidPackage p = this.mPackages.valueAt(index);
        PackageStateInternal packageState = this.mSettings.getPackage(p.getPackageName());
        boolean r4 = false;
        if ((262144 & flags) != 0) goto L7;
    L9:
        boolean r3 = false;
    L10:
        boolean matchesUnaware = r3;
        if ((524288 & flags) != 0) goto L13;
    L16:
        boolean matchesAware = r4;
        if (p.isPersistent() == false) goto L28;
        if (safeMode == true) goto L20;
    L21:
        if (matchesUnaware == true) goto L23;
        if (matchesAware == false) goto L28;
    L23:
        PackageStateInternal ps = this.mSettings.getPackage(p.getPackageName());
        if (ps == null) goto L28;
        ApplicationInfo ai = PackageInfoUtils.generateApplicationInfo(p, flags, ps.getUserStateOrDefault(userId), userId, ps);
        if (ai == null) goto L28;
        finalList.add(ai);
        goto L28
    L20:
        if (packageState.isSystem() == true) goto L21;
    L28:
        index = index + 1;
        goto L3
    L13:
        if (p.isDirectBootAware() == false) goto L16;
        r4 = true;
        goto L16
    L7:
        if (p.isDirectBootAware() == true) goto L9;
        r3 = true;
        goto L10
    L30:
        return finalList;
    }

    @Override // com.android.server.pm.Computer
    public SparseArray<String> getAppsWithSharedUserIds() {
        SparseArray<String> sharedUserIds = new SparseArray();
        Iterator<? extends SharedUserApi> r1 = this.mSettings.getSharedUsers().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        SharedUserApi sharedUser = r1.next();
        sharedUserIds.put(UserHandle.getAppId(sharedUser.getAppId()), sharedUser.getName());
        goto L4
    L6:
        return sharedUserIds;
    }

    @Override // com.android.server.pm.Computer
    public String[] getSharedUserPackagesForPackage(String packageName, int userId) {
        PackageStateInternal packageSetting = this.mSettings.getPackage(packageName);
        if (packageSetting == null) goto L19;
        if (this.mSettings.getSharedUserFromPackageName(packageName) == null) goto L19;
        ArraySet<? extends PackageStateInternal> packages = this.mSettings.getSharedUserFromPackageName(packageName).getPackageStates();
        int numPackages = packages.size();
        String[] res = new String[numPackages];
        int i = 0;
        int index = 0;
    L8:
        if (index >= numPackages) goto L13;
        PackageStateInternal ps = packages.valueAt(index);
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L12;
        res[i] = ps.getPackageName();
        i = i + 1;
    L12:
        index = index + 1;
        goto L8
    L13:
        String[] res2 = (String[]) ArrayUtils.trimToSize(res, i);
        if (res2 == null) goto L17;
        return res2;
    L17:
        return EmptyArray.STRING;
    L19:
        return EmptyArray.STRING;
    }

    @Override // com.android.server.pm.Computer
    public Set<String> getUnusedPackages(long downgradeTimeThresholdMillis) {
        Set<String> unusedPackages = new ArraySet();
        long currentTimeInMillis = System.currentTimeMillis();
        ArrayMap<String, ? extends PackageStateInternal> packageStates = this.mSettings.getPackages();
        int index = 0;
    L4:
        if (index >= packageStates.size()) goto L13;
        PackageStateInternal packageState = packageStates.valueAt(index);
        if (packageState.getPkg() == null) goto L11;
        PackageDexUsage.PackageUseInfo packageUseInfo = this.mDexManager.getPackageUseInfoOrDefault(packageState.getPackageName());
        if (PackageManagerServiceUtils.isUnusedSinceTimeInMillis(PackageStateUtils.getEarliestFirstInstallTime(packageState.getUserStates()), currentTimeInMillis, downgradeTimeThresholdMillis, packageUseInfo, packageState.getTransientState().getLatestPackageUseTimeInMills(), packageState.getTransientState().getLatestForegroundPackageUseTimeInMills()) == false) goto L11;
        unusedPackages.add(packageState.getPackageName());
    L11:
        index = index + 1;
        goto L4
    L13:
        return unusedPackages;
    }

    @Override // com.android.server.pm.Computer
    public CharSequence getHarmfulAppWarning(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        int callingAppId = UserHandle.getAppId(callingUid);
        enforceCrossUserPermission(callingUid, userId, true, true, "getHarmfulAppInfo");
        if (PackageManagerServiceUtils.isSystemOrRoot(callingAppId) == false) goto L5;
    L9:
        PackageStateInternal packageState = getPackageStateInternal(packageName);
        if (packageState == null) goto L14;
        return packageState.getUserStateOrDefault(userId).getHarmfulAppWarning();
    L14:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L5:
        if (checkUidPermission("android.permission.SET_HARMFUL_APP_WARNINGS", callingUid) == 0) goto L9;
        throw new SecurityException("Caller must have the android.permission.SET_HARMFUL_APP_WARNINGS permission.");
    }

    @Override // com.android.server.pm.Computer
    public String[] filterOnlySystemPackages(String... pkgNames) {
        if (pkgNames == null) goto L4;
        ArrayList<String> systemPackageNames = new ArrayList(pkgNames.length);
        int r1 = pkgNames.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L22;
        String pkgName = pkgNames[r3];
        if (pkgName == null) goto L20;
        PackageStateInternal packageState = getPackageStateInternal(pkgName);
        if (packageState != null) goto L13;
    L19:
        Log.w(PackageManagerServiceMonitorEx.TAG, "Could not find package " + pkgName);
        goto L20
    L13:
        if (packageState.getAndroidPackage() == null) goto L19;
        if (packageState.isSystem() == true) goto L18;
        Log.w(PackageManagerServiceMonitorEx.TAG, pkgName + " is not system");
        goto L20
    L18:
        systemPackageNames.add(pkgName);
    L20:
        r3 = r3 + 1;
        goto L6
    L22:
        return (String[]) systemPackageNames.toArray(new String[0]);
    L4:
        return (String[]) ArrayUtils.emptyArray(String.class);
    }

    @Override // com.android.server.pm.Computer
    public List<AndroidPackage> getPackagesForAppId(int appId) {
        SettingBase settingBase = this.mSettings.getSettingBase(appId);
        if ((settingBase instanceof SharedUserSetting) == false) goto L7;
        SharedUserSetting sus = (SharedUserSetting) settingBase;
        return sus.getPackages();
    L7:
        if ((settingBase instanceof PackageSetting) == false) goto L15;
        PackageSetting ps = (PackageSetting) settingBase;
        AndroidPackageInternal r2 = ps.getPkg();
        if (r2 == null) goto L13;
        return Collections.singletonList(r2);
    L13:
        return Collections.emptyList();
    L15:
        return Collections.emptyList();
    }

    @Override // com.android.server.pm.Computer
    public int getUidTargetSdkVersion(int uid) {
        if (Process.isSdkSandboxUid(uid) == false) goto L5;
        uid = getBaseSdkSandboxUid();
    L5:
        int appId = UserHandle.getAppId(uid);
        SettingBase settingBase = this.mSettings.getSettingBase(appId);
        if ((settingBase instanceof SharedUserSetting) == false) goto L18;
        SharedUserSetting sus = (SharedUserSetting) settingBase;
        ArraySet<? extends PackageStateInternal> r3 = sus.getPackageStates();
        int vers = 10000;
        int numPackages = r3.size();
        int index = 0;
    L8:
        if (index >= numPackages) goto L16;
        PackageStateInternal ps = r3.valueAt(index);
        if (ps.getPkg() == null) goto L14;
        int v = ps.getPkg().getTargetSdkVersion();
        if (v >= vers) goto L14;
        vers = v;
    L14:
        index = index + 1;
        goto L8
    L16:
        return vers;
    L18:
        if ((settingBase instanceof PackageSetting) == false) goto L23;
        PackageSetting ps2 = (PackageSetting) settingBase;
        if (ps2.getPkg() != null) goto L22;
        return 10000;
    L22:
        return ps2.getPkg().getTargetSdkVersion();
    L23:
        return 10000;
    }

    @Override // com.android.server.pm.Computer
    public ArrayMap<String, ProcessInfo> getProcessesForUid(int uid) {
        if (Process.isSdkSandboxUid(uid) == false) goto L5;
        uid = getBaseSdkSandboxUid();
    L5:
        int appId = UserHandle.getAppId(uid);
        SettingBase settingBase = this.mSettings.getSettingBase(appId);
        if ((settingBase instanceof SharedUserSetting) == false) goto L10;
        SharedUserSetting sus = (SharedUserSetting) settingBase;
        return PackageInfoUtils.generateProcessInfo(sus.processes, 0);
    L10:
        if ((settingBase instanceof PackageSetting) == false) goto L16;
        PackageSetting ps = (PackageSetting) settingBase;
        AndroidPackageInternal r6 = ps.getPkg();
        if (r6 != null) goto L15;
        return null;
    L15:
        return PackageInfoUtils.generateProcessInfo(r6.getProcesses(), 0);
    L16:
        return null;
    }

    @Override // com.android.server.pm.Computer
    public boolean getBlockUninstall(int userId, String packageName) {
        return this.mSettings.getBlockUninstall(userId, packageName);
    }

    @Override // com.android.server.pm.Computer
    public Pair<PackageStateInternal, SharedUserApi> getPackageOrSharedUser(int appId) {
        Watchable r0 = this.mSettings.getSettingBase(appId);
        if ((r0 instanceof SharedUserSetting) == false) goto L7;
        return Pair.create(null, (SharedUserApi) r0);
    L7:
        if ((r0 instanceof PackageSetting) == true) goto L9;
        return null;
    L9:
        return Pair.create((PackageStateInternal) r0, null);
    }

    private int getBaseSdkSandboxUid() {
        return getPackage(this.mService.getSdkSandboxPackageName()).getUid();
    }

    private boolean isKnownIsolatedComputeApp(int uid) {
        if (Process.isIsolatedUid(uid) == true) goto L6;
        return false;
    L6:
        if (this.mPermissionManager.getHotwordDetectionServiceProvider() != null) goto L8;
    L10:
        boolean isHotword = false;
    L12:
        if (isHotword == false) goto L14;
        return true;
    L14:
        OnDeviceIntelligenceManagerLocal onDeviceIntelligenceManagerLocal = (OnDeviceIntelligenceManagerLocal) LocalManagerRegistry.getManager(OnDeviceIntelligenceManagerLocal.class);
        if (onDeviceIntelligenceManagerLocal != null) goto L17;
        return false;
    L17:
        if (uid == onDeviceIntelligenceManagerLocal.getInferenceServiceUid()) goto L20;
        return false;
    L20:
        return true;
    L8:
        if (uid != this.mPermissionManager.getHotwordDetectionServiceProvider().getUid()) goto L10;
        isHotword = true;
        goto L12
    }

    @Override // com.android.server.pm.Computer
    public SharedUserApi getSharedUser(int sharedUserAppId) {
        return this.mSettings.getSharedUserFromAppId(sharedUserAppId);
    }

    @Override // com.android.server.pm.Computer
    public ArraySet<PackageStateInternal> getSharedUserPackages(int sharedUserAppId) {
        return this.mSettings.getSharedUserPackages(sharedUserAppId);
    }

    @Override // com.android.server.pm.Computer
    public ComponentResolverApi getComponentResolver() {
        return this.mComponentResolver;
    }

    @Override // com.android.server.pm.Computer
    public PackageStateInternal getDisabledSystemPackage(String packageName) {
        return this.mSettings.getDisabledSystemPkg(packageName);
    }

    @Override // com.android.server.pm.Computer
    public ResolveInfo getInstantAppInstallerInfo() {
        return this.mInstantAppInstallerInfo;
    }

    @Override // com.android.server.pm.Computer
    public WatchedArrayMap<String, Integer> getFrozenPackages() {
        return this.mFrozenPackages;
    }

    @Override // com.android.server.pm.Computer
    public void checkPackageFrozen(String packageName) {
        if (this.mFrozenPackages.containsKey(packageName) == true) goto L6;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Expected " + packageName + " to be frozen!", new Throwable());
        return;
    }

    @Override // com.android.server.pm.Computer
    public ComponentName getInstantAppInstallerComponent() {
        if (this.mLocalInstantAppInstallerActivity != null) goto L6;
        return null;
    L6:
        return this.mLocalInstantAppInstallerActivity.getComponentName();
    }

    @Override // com.android.server.pm.Computer
    public void dumpPermissions(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState) {
        this.mSettings.dumpPermissions(pw, packageName, permissionNames, dumpState);
    }

    @Override // com.android.server.pm.Computer
    public void dumpPackages(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState, boolean checkin) {
        this.mSettings.dumpPackages(pw, packageName, permissionNames, dumpState, checkin);
    }

    @Override // com.android.server.pm.Computer
    public void dumpKeySet(PrintWriter pw, String packageName, DumpState dumpState) {
        this.mSettings.dumpKeySet(pw, packageName, dumpState);
    }

    @Override // com.android.server.pm.Computer
    public void dumpSharedUsers(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState, boolean checkin) {
        this.mSettings.dumpSharedUsers(pw, packageName, permissionNames, dumpState, checkin);
    }

    @Override // com.android.server.pm.Computer
    public void dumpSharedUsersProto(ProtoOutputStream proto) {
        this.mSettings.dumpSharedUsersProto(proto);
    }

    @Override // com.android.server.pm.Computer
    public void dumpPackagesProto(ProtoOutputStream proto) {
        this.mSettings.dumpPackagesProto(proto);
    }

    @Override // com.android.server.pm.Computer
    public void dumpSharedLibrariesProto(ProtoOutputStream proto) {
        this.mSharedLibraries.dumpProto(proto);
    }

    @Override // com.android.server.pm.Computer
    public List<? extends PackageStateInternal> getVolumePackages(String volumeUuid) {
        return this.mSettings.getVolumePackages(volumeUuid);
    }

    @Override // com.android.server.pm.Computer
    public ArrayMap<String, ? extends SharedUserApi> getSharedUsers() {
        return this.mSettings.getSharedUsers();
    }

    @Override // com.android.server.pm.Computer
    public UserInfo[] getUserInfos() {
        return this.mInjector.getUserManagerInternal().getUserInfos();
    }

    @Override // com.android.server.pm.Computer
    public IExtComputerEngine getExt() {
        return this.mExt;
    }
}
