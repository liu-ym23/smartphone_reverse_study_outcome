package com.android.server.pm.parsing;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.Attribution;
import android.content.pm.ComponentInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FallbackCategoryProvider;
import android.content.pm.FeatureGroupInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PathPermission;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProcessInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.content.pm.SigningInfo;
import android.content.pm.overlay.OverlayPaths;
import android.os.Bundle;
import android.os.Environment;
import android.os.PatternMatcher;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageLegacyUtils;
import com.android.internal.pm.parsing.pkg.PackageImpl;
import com.android.internal.pm.pkg.component.ComponentParseUtils;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedAttribution;
import com.android.internal.pm.pkg.component.ParsedComponent;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.internal.pm.pkg.component.ParsedPermissionGroup;
import com.android.internal.pm.pkg.component.ParsedProcess;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.internal.pm.pkg.component.ParsedUsesPermission;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemConfig;
import com.android.server.pm.PackageArchiver;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUnserialized;
import com.android.server.pm.pkg.PackageUserState;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.PackageUserStateUtils;
import com.android.server.pm.pkg.SELinuxUtil;
import com.android.server.pm.pkg.SharedLibraryWrapper;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInfoUtils {
    public static final long BD_PERMISSION_FILTER_CTS = 68719476736L;
    private static final String METADATA_ENABLE_G2_SMOOTH_RRECT = "android.graphics.enable_g2_smooth_rrect";
    private static final String METADATA_ENABLE_MATERIAL_EFFECT = "android.graphics.enable_obric_private_effectfilters";
    private static final String[] METADATA_MATERIAL_KEYS = null;
    private static final Set<String> SKIP_PERMISSION = null;
    private static final String SYSTEM_DATA_PATH = null;
    private static final String TAG = "PackageParsing";

    public static class CachedApplicationInfoGenerator {
        private final ArrayMap<String, ApplicationInfo> mCache;

        public CachedApplicationInfoGenerator() {
            this.mCache = new ArrayMap();
        }

        public ApplicationInfo generate(AndroidPackage pkg, long flags, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
            ApplicationInfo appInfo = this.mCache.get(pkg.getPackageName());
            if (appInfo == null) goto L5;
            return appInfo;
        L5:
            ApplicationInfo appInfo2 = PackageInfoUtils.generateApplicationInfo(pkg, flags, state, userId, pkgSetting);
            this.mCache.put(pkg.getPackageName(), appInfo2);
            return appInfo2;
        }
    }

    public PackageInfoUtils() {
    }

    static {
        SYSTEM_DATA_PATH = Environment.getDataDirectoryPath() + File.separator + "system";
        SKIP_PERMISSION = Set.of("android.permission.BD_SEND_MMS", "android.permission.ICON_MANAGER", "android.permission.MANAGE_ALWAYS_ON_RECORD", "com.android.permission.GET_INSTALLED_APPS", "android.permission.ACCESS_VIDEO_EVENT");
        METADATA_MATERIAL_KEYS = new String[]{METADATA_ENABLE_G2_SMOOTH_RRECT, METADATA_ENABLE_MATERIAL_EFFECT};
    }

    public static PackageInfo generate(AndroidPackage pkg, int[] gids, long flags, long firstInstallTime, long lastUpdateTime, Set<String> installedPermissions, Set<String> grantedPermissions, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
        return generateWithComponents(pkg, gids, flags, firstInstallTime, lastUpdateTime, installedPermissions, grantedPermissions, state, userId, pkgSetting);
    }

    private static PackageInfo generateWithComponents(AndroidPackage pkg, int[] gids, long flags, long firstInstallTime, long lastUpdateTime, Set<String> installedPermissions, Set<String> grantedPermissions, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
        ApplicationInfo applicationInfo = generateApplicationInfo(pkg, flags, state, userId, pkgSetting);
        long r9 = flags;
        if (applicationInfo != null) goto L5;
        return null;
    L5:
        PackageInfo info = new PackageInfo();
        info.packageName = pkg.getPackageName();
        info.splitNames = pkg.getSplitNames();
        AndroidPackage r2 = pkg;
        AndroidPackageUtils.fillVersionCodes(r2, info);
        info.baseRevisionCode = r2.getBaseRevisionCode();
        info.splitRevisionCodes = r2.getSplitRevisionCodes();
        info.versionName = r2.getVersionName();
        info.sharedUserId = r2.getSharedUserId();
        info.sharedUserLabel = r2.getSharedUserLabelResourceId();
        info.applicationInfo = applicationInfo;
        info.installLocation = r2.getInstallLocation();
        if ((info.applicationInfo.flags & 1) == 0) goto L8;
    L9:
        info.requiredForAllUsers = r2.isRequiredForAllUsers();
    L10:
        info.restrictedAccountType = r2.getRestrictedAccountType();
        info.requiredAccountType = r2.getRequiredAccountType();
        info.overlayTarget = r2.getOverlayTarget();
        info.targetOverlayableName = r2.getOverlayTargetOverlayableName();
        info.overlayCategory = r2.getOverlayCategory();
        info.overlayPriority = r2.getOverlayPriority();
        info.mOverlayIsStatic = r2.isOverlayIsStatic();
        info.compileSdkVersion = r2.getCompileSdkVersion();
        info.compileSdkVersionCodename = r2.getCompileSdkVersionCodeName();
        info.firstInstallTime = firstInstallTime;
        info.lastUpdateTime = lastUpdateTime;
        if (state.getArchiveState() == null) goto L14;
        info.setArchiveTimeMillis(state.getArchiveState().getArchiveTimeMillis());
    L14:
        if ((256 & r9) == 0) goto L18;
        info.gids = gids;
    L18:
        if ((16384 & r9) == 0) goto L29;
        int size = r2.getConfigPreferences().size();
        if (size <= 0) goto L22;
        info.configPreferences = new ConfigurationInfo[size];
        r2.getConfigPreferences().toArray(info.configPreferences);
    L22:
        int size2 = r2.getRequestedFeatures().size();
        if (size2 <= 0) goto L25;
        info.reqFeatures = new FeatureInfo[size2];
        r2.getRequestedFeatures().toArray(info.reqFeatures);
    L25:
        int size3 = r2.getFeatureGroups().size();
        if (size3 <= 0) goto L29;
        info.featureGroups = new FeatureGroupInfo[size3];
        r2.getFeatureGroups().toArray(info.featureGroups);
    L29:
        if ((4096 & r9) == 0) goto L64;
        int size4 = ArrayUtils.size(r2.getPermissions());
        if (size4 <= 0) goto L47;
        info.permissions = new PermissionInfo[size4];
        List<PermissionInfo> permissionList = new ArrayList();
        int i = 0;
    L33:
        if (i >= size4) goto L45;
        ParsedPermission permission = (ParsedPermission) r2.getPermissions().get(i);
        PermissionInfo permissionInfo = generatePermissionInfo(permission, r9);
        if (installedPermissions.contains(permission.getName()) == false) goto L38;
        permissionInfo.flags |= 1073741824;
    L38:
        if ((r9 & BD_PERMISSION_FILTER_CTS) != 0) goto L40;
    L42:
        permissionList.add(permissionInfo);
    L43:
        i = i + 1;
        r2 = pkg;
        goto L33
    L40:
        if (SKIP_PERMISSION.contains(permission.getName()) == false) goto L42;
        Slog.d(TAG, "GET_PERMISSIONS skip " + permission.getName());
        goto L43
    L45:
        if (permissionList.isEmpty() == true) goto L47;
        info.permissions = (PermissionInfo[]) permissionList.toArray(new PermissionInfo[0]);
    L47:
        List<ParsedUsesPermission> usesPermissions = pkg.getUsesPermissions();
        int size5 = usesPermissions.size();
        if (size5 <= 0) goto L64;
        info.requestedPermissions = new String[size5];
        info.requestedPermissionsFlags = new int[size5];
        int i2 = 0;
    L50:
        if (i2 >= size5) goto L64;
        ParsedUsesPermission usesPermission = usesPermissions.get(i2);
        info.requestedPermissions[i2] = usesPermission.getName();
        int[] r14 = info.requestedPermissionsFlags;
        r14[i2] = r14[i2] | 1;
        if (grantedPermissions == null) goto L57;
        if (grantedPermissions.contains(usesPermission.getName()) == false) goto L57;
        int[] r15 = info.requestedPermissionsFlags;
        r15[i2] = r15[i2] | 2;
    L57:
        if ((usesPermission.getUsesPermissionFlags() & 65536) == 0) goto L60;
        int[] r16 = info.requestedPermissionsFlags;
        r16[i2] = r16[i2] | 65536;
    L60:
        if (pkg.getImplicitPermissions().contains(info.requestedPermissions[i2]) == false) goto L62;
        int[] r17 = info.requestedPermissionsFlags;
        r17[i2] = r17[i2] | 4;
    L62:
        i2 = i2 + 1;
    L64:
        if ((2147483648L & r9) == 0) goto L81;
        int size6 = ArrayUtils.size(pkg.getAttributions());
        if (size6 <= 0) goto L77;
        info.attributions = new Attribution[size6];
        int i3 = 0;
    L68:
        if (i3 >= size6) goto L77;
        ParsedAttribution parsedAttribution = (ParsedAttribution) pkg.getAttributions().get(i3);
        if (parsedAttribution == null) goto L73;
        info.attributions[i3] = new Attribution(parsedAttribution.getTag(), parsedAttribution.getLabel());
    L73:
        i3 = i3 + 1;
        size6 = size6;
    L77:
        if (pkg.isAttributionsUserVisible() == false) goto L79;
        info.applicationInfo.privateFlagsExt |= 4;
    L82:
        SigningDetails signingDetails = pkg.getSigningDetails();
        info.signatures = getDeprecatedSignatures(signingDetails, r9);
        if ((134217728 & r9) != 0) goto L85;
    L88:
        info.isStub = pkg.isStub();
        info.coreApp = pkg.isCoreApp();
        info.isApex = pkg.isApex();
        if (pkgSetting.hasSharedUser() == true) goto L92;
        info.sharedUserId = null;
        info.sharedUserLabel = 0;
    L92:
        if ((1 & r9) == 0) goto L108;
        int N = pkg.getActivities().size();
        if (N <= 0) goto L107;
        long aflags = r9 | 8589934592L;
        int num = 0;
        ActivityInfo[] res = new ActivityInfo[N];
        int N2 = 0;
    L96:
        if (N2 >= N) goto L106;
        ParsedActivity a = (ParsedActivity) pkg.getActivities().get(N2);
        ActivityInfo[] res2 = res;
        int i4 = N2;
        if (PackageUserStateUtils.isMatch(state, pkgSetting.isSystem(), pkg.isEnabled(), a.isEnabled(), a.isDirectBootAware(), a.getName(), aflags) == false) goto L104;
        if (PackageManager.APP_DETAILS_ACTIVITY_CLASS_NAME.equals(a.getName()) == true) goto L104;
        signingDetails = signingDetails;
        info = info;
        N = N;
        ApplicationInfo applicationInfo2 = applicationInfo;
        aflags = aflags;
        applicationInfo = applicationInfo2;
        res2[num] = generateActivityInfo(pkg, a, aflags, state, applicationInfo2, userId, pkgSetting);
        num = num + 1;
    L105:
        info = info;
        applicationInfo = applicationInfo;
        aflags = aflags;
        N = N;
        N2 = i4 + 1;
        signingDetails = signingDetails;
        res = res2;
    L104:
        num = num;
        goto L105
    L106:
        PackageInfo info2 = info;
        ApplicationInfo applicationInfo3 = applicationInfo;
        info2.activities = (ActivityInfo[]) ArrayUtils.trimToSize(res, num);
    L110:
        if ((2 & r9) == 0) goto L122;
        int size7 = pkg.getReceivers().size();
        if (size7 <= 0) goto L122;
        ActivityInfo[] res3 = new ActivityInfo[size7];
        int num2 = 0;
        int i5 = 0;
    L114:
        if (i5 >= size7) goto L120;
        ParsedActivity a2 = (ParsedActivity) pkg.getReceivers().get(i5);
        if (PackageUserStateUtils.isMatch(state, pkgSetting.isSystem(), pkg.isEnabled(), a2.isEnabled(), a2.isDirectBootAware(), a2.getName(), r9) == false) goto L119;
        res3[num2] = generateActivityInfo(pkg, a2, flags, state, applicationInfo3, userId, pkgSetting);
        num2 = num2 + 1;
    L119:
        i5 = i5 + 1;
        r9 = flags;
        goto L114
    L120:
        info2.receivers = (ActivityInfo[]) ArrayUtils.trimToSize(res3, num2);
    L122:
        if ((flags & 4) == 0) goto L134;
        int size8 = pkg.getServices().size();
        if (size8 <= 0) goto L134;
        ServiceInfo[] res4 = new ServiceInfo[size8];
        int num3 = 0;
        int i6 = 0;
    L126:
        if (i6 >= size8) goto L132;
        ParsedService s = (ParsedService) pkg.getServices().get(i6);
        if (PackageUserStateUtils.isMatch(state, pkgSetting.isSystem(), pkg.isEnabled(), s.isEnabled(), s.isDirectBootAware(), s.getName(), flags) == false) goto L131;
        res4[num3] = generateServiceInfo(pkg, s, flags, state, applicationInfo3, userId, pkgSetting);
        num3 = num3 + 1;
    L131:
        i6 = i6 + 1;
        goto L126
    L132:
        info2.services = (ServiceInfo[]) ArrayUtils.trimToSize(res4, num3);
    L134:
        if ((flags & 8) == 0) goto L146;
        int size9 = pkg.getProviders().size();
        if (size9 <= 0) goto L146;
        ProviderInfo[] res5 = new ProviderInfo[size9];
        int num4 = 0;
        int i7 = 0;
    L138:
        if (i7 >= size9) goto L144;
        ParsedProvider pr = (ParsedProvider) pkg.getProviders().get(i7);
        if (PackageUserStateUtils.isMatch(state, pkgSetting.isSystem(), pkg.isEnabled(), pr.isEnabled(), pr.isDirectBootAware(), pr.getName(), flags) == false) goto L143;
        res5[num4] = generateProviderInfo(pkg, pr, flags, state, applicationInfo3, userId, pkgSetting);
        num4 = num4 + 1;
    L143:
        i7 = i7 + 1;
        goto L138
    L144:
        info2.providers = (ProviderInfo[]) ArrayUtils.trimToSize(res5, num4);
    L146:
        if ((flags & 16) == 0) goto L152;
        int N3 = pkg.getInstrumentations().size();
        if (N3 <= 0) goto L152;
        info2.instrumentation = new InstrumentationInfo[N3];
        int i8 = 0;
    L150:
        if (i8 >= N3) goto L152;
        info2.instrumentation[i8] = generateInstrumentationInfo((ParsedInstrumentation) pkg.getInstrumentations().get(i8), pkg, flags, state, userId, pkgSetting);
        i8 = i8 + 1;
    L152:
        return info2;
    L107:
        info2 = info;
        applicationInfo3 = applicationInfo;
        goto L110
    L108:
        info2 = info;
        applicationInfo3 = applicationInfo;
        goto L110
    L85:
        if (signingDetails == SigningDetails.UNKNOWN) goto L87;
        info.signingInfo = new SigningInfo(signingDetails);
        goto L88
    L87:
        info.signingInfo = null;
        goto L88
    L79:
        info.applicationInfo.privateFlagsExt &= -5;
        goto L82
    L81:
        info.applicationInfo.privateFlagsExt &= -5;
        goto L82
    L8:
        if ((info.applicationInfo.flags & 128) == 0) goto L10;
        goto L9
    }

    public static Signature[] getDeprecatedSignatures(SigningDetails signingDetails, long flags) {
        if ((64 & flags) != 0) goto L6;
        return null;
    L6:
        if (signingDetails.hasPastSigningCertificates() == false) goto L10;
        return new Signature[]{signingDetails.getPastSigningCertificates()[0]};
    L10:
        if (signingDetails.hasSignatures() == false) goto L13;
        int numberOfSigs = signingDetails.getSignatures().length;
        Signature[] signatures = new Signature[numberOfSigs];
        System.arraycopy(signingDetails.getSignatures(), 0, signatures, 0, numberOfSigs);
        return signatures;
    L13:
        return null;
    }

    private static void updateApplicationInfo(ApplicationInfo ai, long flags, PackageUserState state) {
        if ((128 & flags) != 0) goto L6;
        ai.metaData = maybeRetainMaterialMetaData(ai.metaData);
    L6:
        if ((DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES & flags) != 0) goto L9;
        ai.sharedLibraryFiles = null;
        ai.sharedLibraryInfos = null;
    L9:
        if (ParsingPackageUtils.sCompatibilityModeEnabled == true) goto L11;
        ai.disableCompatibilityMode();
    L11:
        ai.flags |= (flag(state.isStopped(), 2097152) | flag(state.isInstalled(), 8388608)) | flag(state.isSuspended(), 1073741824);
        boolean r6 = true;
        ai.privateFlags |= (flag(state.isInstantApp(), 128) | flag(state.isVirtualPreload(), 65536)) | flag(state.isHidden(), 1);
        ai.privateFlagsExt |= flag(state.isNotLaunched(), 64);
        if (state.getEnabledState() != 1) goto L15;
        ai.enabled = true;
    L26:
        ai.enabledSetting = state.getEnabledState();
        if (ai.category != (-1)) goto L29;
        ai.category = FallbackCategoryProvider.getFallbackCategory(ai.packageName);
    L29:
        ai.seInfoUser = SELinuxUtil.getSeinfoUser(state);
        OverlayPaths overlayPaths = state.getAllOverlayPaths();
        if (overlayPaths == null) goto L32;
        ai.resourceDirs = (String[]) overlayPaths.getResourceDirs().toArray(new String[0]);
        ai.overlayPaths = (String[]) overlayPaths.getOverlayPaths().toArray(new String[0]);
    L32:
        ai.isArchived = PackageArchiver.isArchived(state);
        if (ai.isArchived == false) goto L36;
        ai.nonLocalizedLabel = state.getArchiveState().getActivityInfos().get(0).getTitle();
    L36:
        if (state.isInstalled() == false) goto L38;
        return;
    L38:
        if (state.dataExists() == true) goto L42;
        ai.dataDir = null;
        return;
    L42:
        return;
    L15:
        if (state.getEnabledState() != 4) goto L22;
        if ((32768 & flags) != 0) goto L20;
        r6 = false;
    L20:
        ai.enabled = r6;
        goto L26
    L22:
        if (state.getEnabledState() != 2) goto L24;
    L25:
        ai.enabled = false;
        goto L26
    L24:
        if (state.getEnabledState() != 3) goto L26;
        goto L25
    }

    private static Bundle maybeRetainMaterialMetaData(Bundle metaData) {
        if (metaData != null) goto L5;
        return null;
    L5:
        Bundle filtered = null;
        String[] r1 = METADATA_MATERIAL_KEYS;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L17;
        String key = r1[r3];
        if (metaData.containsKey(key) == false) goto L16;
        Object value = metaData.get(key);
        if (value == null) goto L16;
        if (filtered != null) goto L15;
        filtered = new Bundle(METADATA_MATERIAL_KEYS.length);
    L15:
        putValue(filtered, key, value);
    L16:
        r3 = r3 + 1;
        goto L6
    L17:
        return filtered;
    }

    private static void putValue(Bundle bundle, String key, Object value) {
        if ((value instanceof Boolean) == false) goto L6;
        bundle.putBoolean(key, ((Boolean) value).booleanValue());
        return;
    L6:
        if ((value instanceof Integer) == false) goto L9;
        bundle.putInt(key, ((Integer) value).intValue());
        return;
    L9:
        if ((value instanceof Long) == false) goto L12;
        bundle.putLong(key, ((Long) value).longValue());
        return;
    L12:
        if ((value instanceof Float) == false) goto L15;
        bundle.putFloat(key, ((Float) value).floatValue());
        return;
    L15:
        if ((value instanceof Double) == false) goto L18;
        bundle.putDouble(key, ((Double) value).doubleValue());
        return;
    L18:
        if ((value instanceof String) == false) goto L21;
        bundle.putString(key, (String) value);
        return;
    L21:
        if ((value instanceof CharSequence) == false) goto L30;
        bundle.putCharSequence(key, (CharSequence) value);
        return;
    }

    public static ApplicationInfo generateDelegateApplicationInfo(ApplicationInfo ai, long flags, PackageUserState state, int userId) {
        if (ai != null) goto L4;
        return null;
    L4:
        if (checkUseInstalledOrHidden(flags, state, ai) == false) goto L16;
        ApplicationInfo ai2 = new ApplicationInfo(ai);
        ai2.initForUser(userId);
        if (ParsingPackageUtils.sUseRoundIcon == true) goto L9;
    L11:
        int r1 = ai2.iconRes;
    L12:
        ai2.icon = r1;
        updateApplicationInfo(ai2, flags, state);
        return ai2;
    L9:
        if (ai2.roundIconRes == 0) goto L11;
        r1 = ai2.roundIconRes;
        goto L12
    L16:
        return null;
    }

    public static ApplicationInfo generateApplicationInfo(AndroidPackage pkg, long flags, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
        if (pkg != null) goto L6;
        return null;
    L6:
        if (checkUseInstalledOrHidden(pkg, pkgSetting, state, flags) == true) goto L8;
    L27:
        return null;
    L8:
        if (AndroidPackageUtils.isMatchForSystemOnly(pkgSetting, flags) == false) goto L27;
        ApplicationInfo info = AndroidPackageUtils.generateAppInfoWithoutState(pkg);
        updateApplicationInfo(info, flags, state);
        initForUser(info, pkg, userId, state);
        PackageStateUnserialized pkgState = pkgSetting.getTransientState();
        info.hiddenUntilInstalled = pkgState.isHiddenUntilInstalled();
        List<String> usesLibraryFiles = pkgState.getUsesLibraryFiles();
        List<SharedLibraryWrapper> usesLibraries = pkgState.getUsesLibraryInfos();
        ArrayList<SharedLibraryInfo> usesLibraryInfos = new ArrayList();
        int index = 0;
    L12:
        if (index >= usesLibraries.size()) goto L15;
        usesLibraryInfos.add(usesLibraries.get(index).getInfo());
        index = index + 1;
        goto L12
    L15:
        if (usesLibraryFiles.isEmpty() == false) goto L17;
        String[] r6 = null;
    L18:
        info.sharedLibraryFiles = r6;
        if (usesLibraryInfos.isEmpty() == false) goto L21;
        ArrayList<SharedLibraryInfo> r7 = null;
    L22:
        info.sharedLibraryInfos = r7;
        info.optionalSharedLibraryInfos = null;
        if (info.category != (-1)) goto L25;
        info.category = pkgSetting.getCategoryOverride();
    L25:
        info.seInfo = pkgSetting.getSeInfo();
        info.primaryCpuAbi = pkgSetting.getPrimaryCpuAbi();
        info.secondaryCpuAbi = pkgSetting.getSecondaryCpuAbi();
        info.flags |= appInfoFlags(info.flags, pkgSetting);
        info.privateFlags |= appInfoPrivateFlags(info.privateFlags, pkgSetting);
        info.privateFlagsExt |= appInfoPrivateFlagsExt(info.privateFlagsExt, pkgSetting);
        info.getExt().setFlags(pkg.getFlagsExt());
        info.getExt().setNavigationBarColor(pkg.getNavigationBarColorExt());
        info.getExt().setIconTheme(pkg.getIconTheme());
        return info;
    L21:
        r7 = usesLibraryInfos;
        goto L22
    L17:
        r6 = (String[]) usesLibraryFiles.toArray(new String[0]);
        goto L18
    }

    public static ActivityInfo generateActivityInfo(AndroidPackage pkg, ParsedActivity a, long flags, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
        return generateActivityInfo(pkg, a, flags, state, null, userId, pkgSetting);
    }

    public static ActivityInfo generateActivityInfo(AndroidPackage pkg, ParsedActivity a, long flags, PackageUserStateInternal state, ApplicationInfo applicationInfo, int userId, PackageStateInternal pkgSetting) {
        Bundle r0 = null;
        if (a != null) goto L6;
        return null;
    L6:
        if (checkUseInstalledOrHidden(pkg, pkgSetting, state, flags) == true) goto L8;
        return null;
    L8:
        if (applicationInfo != null) goto L10;
        long flags2 = flags;
        int userId2 = userId;
        PackageStateInternal pkgSetting2 = pkgSetting;
        applicationInfo = generateApplicationInfo(pkg, flags2, state, userId2, pkgSetting2);
    L11:
        if (applicationInfo != null) goto L13;
        return null;
    L13:
        ActivityInfo ai = new ActivityInfo();
        ai.targetActivity = a.getTargetActivity();
        ai.processName = a.getProcessName();
        ai.exported = a.isExported();
        ai.theme = a.getTheme();
        ai.uiOptions = a.getUiOptions();
        ai.parentActivityName = a.getParentActivityName();
        ai.permission = a.getPermission();
        ai.taskAffinity = a.getTaskAffinity();
        ai.flags = a.getFlags();
        ai.privateFlags = a.getPrivateFlags();
        ai.launchMode = a.getLaunchMode();
        ai.documentLaunchMode = a.getDocumentLaunchMode();
        ai.maxRecents = a.getMaxRecents();
        ai.configChanges = a.getConfigChanges();
        ai.softInputMode = a.getSoftInputMode();
        ai.persistableMode = a.getPersistableMode();
        ai.lockTaskLaunchMode = a.getLockTaskLaunchMode();
        ai.screenOrientation = a.getScreenOrientation();
        ai.resizeMode = a.getResizeMode();
        ai.setMaxAspectRatio(a.getMaxAspectRatio());
        ai.setMinAspectRatio(a.getMinAspectRatio());
        ai.supportsSizeChanges = a.isSupportsSizeChanges();
        ai.requestedVrComponent = a.getRequestedVrComponent();
        ai.rotationAnimation = a.getRotationAnimation();
        ai.colorMode = a.getColorMode();
        ai.windowLayout = a.getWindowLayout();
        ai.attributionTags = a.getAttributionTags();
        if ((128 & flags2) == 0) goto L20;
        Bundle metaData = a.getMetaData();
        if (metaData.isEmpty() == true) goto L19;
        r0 = metaData;
    L19:
        ai.metaData = r0;
    L21:
        ai.applicationInfo = applicationInfo;
        ai.requiredDisplayCategory = a.getRequiredDisplayCategory();
        ai.requireContentUriPermissionFromCaller = a.getRequireContentUriPermissionFromCaller();
        ai.setKnownActivityEmbeddingCerts(a.getKnownActivityEmbeddingCerts());
        assignFieldsComponentInfoParsedMainComponent(ai, a, pkgSetting2, userId2);
        ai.getExt().setFlags(a.getFlagsExt());
        ai.getExt().setNavigationBarColor(a.getNavigationBarColorExt());
        PackageInfoUtilsSmtEx.updateBytedanceXMLFlags(ai);
        return ai;
    L20:
        ai.metaData = null;
        goto L21
    L10:
        flags2 = flags;
        userId2 = userId;
        pkgSetting2 = pkgSetting;
        goto L11
    }

    public static ActivityInfo generateDelegateActivityInfo(ActivityInfo a, long flags, PackageUserState state, int userId) {
        if (a != null) goto L4;
        return null;
    L4:
        if (checkUseInstalledOrHidden(flags, state, a.applicationInfo) == false) goto L10;
        ActivityInfo ai = new ActivityInfo(a);
        ai.applicationInfo = generateDelegateApplicationInfo(ai.applicationInfo, flags, state, userId);
        return ai;
    L10:
        return null;
    }

    public static ServiceInfo generateServiceInfo(AndroidPackage pkg, ParsedService s, long flags, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
        return generateServiceInfo(pkg, s, flags, state, null, userId, pkgSetting);
    }

    public static ServiceInfo generateServiceInfo(AndroidPackage pkg, ParsedService s, long flags, PackageUserStateInternal state, ApplicationInfo applicationInfo, int userId, PackageStateInternal pkgSetting) {
        Bundle r0 = null;
        if (s != null) goto L6;
        return null;
    L6:
        if (checkUseInstalledOrHidden(pkg, pkgSetting, state, flags) == true) goto L8;
        return null;
    L8:
        if (applicationInfo != null) goto L10;
        long flags2 = flags;
        int userId2 = userId;
        PackageStateInternal pkgSetting2 = pkgSetting;
        applicationInfo = generateApplicationInfo(pkg, flags2, state, userId2, pkgSetting2);
    L11:
        if (applicationInfo != null) goto L13;
        return null;
    L13:
        ServiceInfo si = new ServiceInfo();
        si.exported = s.isExported();
        si.flags = s.getFlags();
        si.permission = s.getPermission();
        si.processName = s.getProcessName();
        si.mForegroundServiceType = s.getForegroundServiceType();
        si.applicationInfo = applicationInfo;
        if ((128 & flags2) == 0) goto L20;
        Bundle metaData = s.getMetaData();
        if (metaData.isEmpty() == true) goto L19;
        r0 = metaData;
    L19:
        si.metaData = r0;
    L20:
        assignFieldsComponentInfoParsedMainComponent(si, s, pkgSetting2, userId2);
        return si;
    L10:
        flags2 = flags;
        userId2 = userId;
        pkgSetting2 = pkgSetting;
        goto L11
    }

    public static ProviderInfo generateProviderInfo(AndroidPackage pkg, ParsedProvider p, long flags, PackageUserStateInternal state, ApplicationInfo applicationInfo, int userId, PackageStateInternal pkgSetting) {
        Bundle r6 = null;
        if (p != null) goto L6;
        return null;
    L6:
        if (checkUseInstalledOrHidden(pkg, pkgSetting, state, flags) == true) goto L8;
        return null;
    L8:
        if (applicationInfo != null) goto L10;
    L11:
        StringBuilder r0 = new StringBuilder();
        r0.append("AppInfo's package name is different. Expected=");
        r0.append(pkg.getPackageName());
        r0.append(" actual=");
        if (applicationInfo != null) goto L14;
        String r1 = "(null AppInfo)";
    L15:
        r0.append(r1);
        Slog.wtf(TAG, r0.toString());
        applicationInfo = generateApplicationInfo(pkg, flags, state, userId, pkgSetting);
    L16:
        if (applicationInfo != null) goto L18;
        return null;
    L18:
        ProviderInfo pi = new ProviderInfo();
        pi.exported = p.isExported();
        pi.flags = p.getFlags();
        pi.processName = p.getProcessName();
        pi.authority = p.getAuthority();
        pi.isSyncable = p.isSyncable();
        pi.readPermission = p.getReadPermission();
        pi.writePermission = p.getWritePermission();
        pi.grantUriPermissions = p.isGrantUriPermissions();
        pi.forceUriPermissions = p.isForceUriPermissions();
        pi.multiprocess = p.isMultiProcess();
        pi.initOrder = p.getInitOrder();
        pi.uriPermissionPatterns = (PatternMatcher[]) p.getUriPermissionPatterns().toArray(new PatternMatcher[0]);
        pi.pathPermissions = (PathPermission[]) p.getPathPermissions().toArray(new PathPermission[0]);
        if ((2048 & flags) != 0) goto L22;
        pi.uriPermissionPatterns = null;
    L22:
        if ((128 & flags) == 0) goto L28;
        Bundle metaData = p.getMetaData();
        if (metaData.isEmpty() == true) goto L27;
        r6 = metaData;
    L27:
        pi.metaData = r6;
    L28:
        pi.applicationInfo = applicationInfo;
        assignFieldsComponentInfoParsedMainComponent(pi, p, pkgSetting, userId);
        return pi;
    L14:
        r1 = applicationInfo.packageName;
        goto L15
    L10:
        if (pkg.getPackageName().equals(applicationInfo.packageName) == true) goto L16;
        goto L11
    }

    public static InstrumentationInfo generateInstrumentationInfo(ParsedInstrumentation i, AndroidPackage pkg, long flags, PackageUserStateInternal state, int userId, PackageStateInternal pkgSetting) {
        Bundle r0 = null;
        if (i != null) goto L6;
        return null;
    L6:
        if (checkUseInstalledOrHidden(pkg, pkgSetting, state, flags) == true) goto L8;
        return null;
    L8:
        InstrumentationInfo info = new InstrumentationInfo();
        info.targetPackage = i.getTargetPackage();
        info.targetProcesses = i.getTargetProcesses();
        info.handleProfiling = i.isHandleProfiling();
        info.functionalTest = i.isFunctionalTest();
        info.sourceDir = pkg.getBaseApkPath();
        info.publicSourceDir = pkg.getBaseApkPath();
        info.splitNames = pkg.getSplitNames();
        if (pkg.getSplitCodePaths().length != 0) goto L11;
        String[] r2 = null;
    L12:
        info.splitSourceDirs = r2;
        if (pkg.getSplitCodePaths().length != 0) goto L15;
        String[] r3 = null;
    L16:
        info.splitPublicSourceDirs = r3;
        if (pkg.getSplitDependencies().size() != 0) goto L19;
        SparseArray r4 = null;
    L20:
        info.splitDependencies = r4;
        initForUser(info, pkg, userId, state);
        info.primaryCpuAbi = pkgSetting.getPrimaryCpuAbi();
        info.secondaryCpuAbi = pkgSetting.getSecondaryCpuAbi();
        info.nativeLibraryDir = pkg.getNativeLibraryDir();
        info.secondaryNativeLibraryDir = pkg.getSecondaryNativeLibraryDir();
        assignFieldsPackageItemInfoParsedComponent(info, i, pkgSetting, userId);
        if ((128 & flags) != 0) goto L23;
        info.metaData = null;
    L28:
        return info;
    L23:
        Bundle metaData = i.getMetaData();
        if (metaData.isEmpty() == true) goto L27;
        r0 = metaData;
    L27:
        info.metaData = r0;
        goto L28
    L19:
        r4 = pkg.getSplitDependencies();
        goto L20
    L15:
        r3 = pkg.getSplitCodePaths();
        goto L16
    L11:
        r2 = pkg.getSplitCodePaths();
        goto L12
    }

    public static PermissionInfo generatePermissionInfo(ParsedPermission p, long flags) {
        Bundle r0 = null;
        if (p != null) goto L5;
        return null;
    L5:
        PermissionInfo pi = new PermissionInfo(p.getBackgroundPermission());
        assignFieldsPackageItemInfoParsedComponent(pi, p);
        pi.group = p.getGroup();
        pi.requestRes = p.getRequestRes();
        pi.protectionLevel = p.getProtectionLevel();
        pi.descriptionRes = p.getDescriptionRes();
        pi.flags = p.getFlags();
        pi.knownCerts = p.getKnownCerts();
        if ((128 & flags) != 0) goto L8;
        pi.metaData = null;
    L13:
        return pi;
    L8:
        Bundle metaData = p.getMetaData();
        if (metaData.isEmpty() == true) goto L12;
        r0 = metaData;
    L12:
        pi.metaData = r0;
        goto L13
    }

    public static PermissionGroupInfo generatePermissionGroupInfo(ParsedPermissionGroup pg, long flags) {
        Bundle r0 = null;
        if (pg != null) goto L5;
        return null;
    L5:
        PermissionGroupInfo pgi = new PermissionGroupInfo(pg.getRequestDetailRes(), pg.getBackgroundRequestRes(), pg.getBackgroundRequestDetailRes());
        assignFieldsPackageItemInfoParsedComponent(pgi, pg);
        pgi.descriptionRes = pg.getDescriptionRes();
        pgi.priority = pg.getPriority();
        pgi.requestRes = pg.getRequestRes();
        pgi.flags = pg.getFlags();
        if ((128 & flags) != 0) goto L8;
        pgi.metaData = null;
    L13:
        return pgi;
    L8:
        Bundle metaData = pg.getMetaData();
        if (metaData.isEmpty() == true) goto L12;
        r0 = metaData;
    L12:
        pgi.metaData = r0;
        goto L13
    }

    public static ArrayMap<String, ProcessInfo> generateProcessInfo(Map<String, ParsedProcess> procs, long flags) {
        if (procs != null) goto L5;
        return null;
    L5:
        int numProcs = procs.size();
        ArrayMap<String, ProcessInfo> retProcs = new ArrayMap(numProcs);
        Iterator<String> r2 = procs.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        String key = r2.next();
        ParsedProcess proc = procs.get(key);
        retProcs.put(proc.getName(), new ProcessInfo(proc.getName(), new ArraySet(proc.getDeniedPermissions()), proc.getGwpAsanMode(), proc.getMemtagMode(), proc.getNativeHeapZeroInitialized(), proc.isUseEmbeddedDex()));
        goto L7
    L9:
        return retProcs;
    }

    public static boolean checkUseInstalledOrHidden(AndroidPackage pkg, PackageStateInternal pkgSetting, PackageUserStateInternal state, long flags) {
        if ((536870912 & flags) != 0) goto L10;
        if (state.isInstalled() == true) goto L10;
        if (pkgSetting.getTransientState().isHiddenUntilInstalled() == false) goto L10;
        return false;
    L10:
        if (PackageUserStateUtils.isAvailable(state, flags) == false) goto L12;
    L15:
        return true;
    L12:
        if (pkgSetting.isSystem() == true) goto L14;
        return false;
    L14:
        if (matchUninstalledOrHidden(flags) == true) goto L15;
        return false;
    }

    private static boolean checkUseInstalledOrHidden(long flags, PackageUserState state, ApplicationInfo appInfo) {
        if ((536870912 & flags) != 0) goto L11;
        if (state.isInstalled() == true) goto L11;
        if (appInfo == null) goto L11;
        if (appInfo.hiddenUntilInstalled == false) goto L11;
        return false;
    L11:
        if (PackageUserStateUtils.isAvailable(state, flags) == true) goto L19;
        if (appInfo != null) goto L14;
        return false;
    L14:
        if (appInfo.isSystemApp() == true) goto L16;
        return false;
    L16:
        if (matchUninstalledOrHidden(flags) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private static boolean matchUninstalledOrHidden(long flags) {
        if ((4836040704L & flags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void assignFieldsComponentInfoParsedMainComponent(ComponentInfo info, ParsedMainComponent component) {
        assignFieldsPackageItemInfoParsedComponent(info, component);
        info.descriptionRes = component.getDescriptionRes();
        info.directBootAware = component.isDirectBootAware();
        info.enabled = component.isEnabled();
        info.splitName = component.getSplitName();
        info.attributionTags = component.getAttributionTags();
    }

    private static void assignFieldsPackageItemInfoParsedComponent(PackageItemInfo packageItemInfo, ParsedComponent component) {
        packageItemInfo.nonLocalizedLabel = ComponentParseUtils.getNonLocalizedLabel(component);
        packageItemInfo.icon = ComponentParseUtils.getIcon(component);
        packageItemInfo.banner = component.getBanner();
        packageItemInfo.labelRes = component.getLabelRes();
        packageItemInfo.logo = component.getLogo();
        packageItemInfo.name = component.getName();
        packageItemInfo.packageName = component.getPackageName();
    }

    private static void assignFieldsComponentInfoParsedMainComponent(ComponentInfo info, ParsedMainComponent component, PackageStateInternal pkgSetting, int userId) {
        assignFieldsComponentInfoParsedMainComponent(info, component);
        Pair<CharSequence, Integer> labelAndIcon = ParsedComponentStateUtils.getNonLocalizedLabelAndIcon(component, pkgSetting, userId);
        info.nonLocalizedLabel = (CharSequence) labelAndIcon.first;
        info.icon = ((Integer) labelAndIcon.second).intValue();
    }

    private static void assignFieldsPackageItemInfoParsedComponent(PackageItemInfo info, ParsedComponent component, PackageStateInternal pkgSetting, int userId) {
        assignFieldsPackageItemInfoParsedComponent(info, component);
        Pair<CharSequence, Integer> labelAndIcon = ParsedComponentStateUtils.getNonLocalizedLabelAndIcon(component, pkgSetting, userId);
        info.nonLocalizedLabel = (CharSequence) labelAndIcon.first;
        info.icon = ((Integer) labelAndIcon.second).intValue();
    }

    private static int flag(boolean hasFlag, int flag) {
        if (hasFlag == true) goto L6;
        return 0;
    L6:
        return flag;
    }

    public static int appInfoFlags(AndroidPackage pkg, PackageStateInternal pkgSetting) {
        int pkgWithoutStateFlags = (((((((((((((((((((((((((flag(pkg.isExternalStorage(), 262144) | flag(pkg.isHardwareAccelerated(), 536870912)) | flag(pkg.isBackupAllowed(), 32768)) | flag(pkg.isKillAfterRestoreAllowed(), 65536)) | flag(pkg.isRestoreAnyVersion(), 131072)) | flag(pkg.isFullBackupOnly(), 67108864)) | flag(pkg.isPersistent(), 8)) | flag(pkg.isDebuggable(), 2)) | flag(pkg.isVmSafeMode(), 16384)) | flag(pkg.isDeclaredHavingCode(), 4)) | flag(pkg.isTaskReparentingAllowed(), 32)) | flag(pkg.isClearUserDataAllowed(), 64)) | flag(pkg.isLargeHeap(), 1048576)) | flag(pkg.isCleartextTrafficAllowed(), 134217728)) | flag(pkg.isRtlSupported(), 4194304)) | flag(pkg.isTestOnly(), 256)) | flag(pkg.isMultiArch(), Integer.MIN_VALUE)) | flag(pkg.isExtractNativeLibrariesRequested(), 268435456)) | flag(pkg.isGame(), 33554432)) | flag(pkg.isSmallScreensSupported(), 512)) | flag(pkg.isNormalScreensSupported(), 1024)) | flag(pkg.isLargeScreensSupported(), 2048)) | flag(pkg.isExtraLargeScreensSupported(), 524288)) | flag(pkg.isResizeable(), 4096)) | flag(pkg.isAnyDensity(), 8192)) | flag(AndroidPackageLegacyUtils.isSystem(pkg), 1)) | flag(pkg.isFactoryTest(), 16);
        return appInfoFlags(pkgWithoutStateFlags, pkgSetting);
    }

    public static int appInfoFlags(int pkgWithoutStateFlags, PackageStateInternal pkgSetting) {
        if (pkgSetting == null) goto L6;
        int flags = pkgWithoutStateFlags | flag(pkgSetting.isUpdatedSystemApp(), 128);
        return flags;
    L6:
        return pkgWithoutStateFlags;
    }

    public static int appInfoPrivateFlags(AndroidPackage pkg, PackageStateInternal pkgSetting) {
        int pkgWithoutStateFlags = (((((((((((((((((((((((flag(pkg.isStaticSharedLibrary(), 16384) | flag(pkg.isResourceOverlay(), 268435456)) | flag(pkg.isIsolatedSplitLoading(), 32768)) | flag(pkg.isHasDomainUrls(), 16)) | flag(pkg.isProfileableByShell(), 8388608)) | flag(pkg.isBackupInForeground(), 8192)) | flag(pkg.isUseEmbeddedDex(), 33554432)) | flag(pkg.isDefaultToDeviceProtectedStorage(), 32)) | flag(pkg.isDirectBootAware(), 64)) | flag(pkg.isPartiallyDirectBootAware(), 256)) | flag(pkg.isClearUserDataOnFailedRestoreAllowed(), 67108864)) | flag(pkg.isAllowAudioPlaybackCapture(), 134217728)) | flag(pkg.isRequestLegacyExternalStorage(), 536870912)) | flag(pkg.isNonSdkApiRequested(), 4194304)) | flag(pkg.isUserDataFragile(), 16777216)) | flag(pkg.isSaveStateDisallowed(), 2)) | flag(pkg.isResizeableActivityViaSdkVersion(), 4096)) | flag(pkg.isAllowNativeHeapPointerTagging(), Integer.MIN_VALUE)) | flag(AndroidPackageLegacyUtils.isSystemExt(pkg), 2097152)) | flag(AndroidPackageLegacyUtils.isPrivileged(pkg), 8)) | flag(AndroidPackageLegacyUtils.isOem(pkg), 131072)) | flag(AndroidPackageLegacyUtils.isVendor(pkg), 262144)) | flag(AndroidPackageLegacyUtils.isProduct(pkg), 524288)) | flag(AndroidPackageLegacyUtils.isOdm(pkg), 1073741824)) | flag(pkg.isSignedWithPlatformKey(), 1048576);
        Boolean resizeableActivity = pkg.getResizeableActivity();
        if (resizeableActivity == null) goto L9;
        if (resizeableActivity.booleanValue() == false) goto L7;
        pkgWithoutStateFlags = pkgWithoutStateFlags | 1024;
        goto L9
    L7:
        pkgWithoutStateFlags = pkgWithoutStateFlags | 2048;
    L9:
        return appInfoPrivateFlags(pkgWithoutStateFlags, pkgSetting);
    }

    public static int appInfoPrivateFlags(int pkgWithoutStateFlags, PackageStateInternal pkgSetting) {
        return pkgWithoutStateFlags;
    }

    public static int appInfoPrivateFlagsExt(AndroidPackage pkg, PackageStateInternal pkgSetting) {
        boolean isAllowlistedForHiddenApis = SystemConfig.getInstance().getHiddenApiWhitelistedApps().contains(pkg.getPackageName());
        int pkgWithoutStateFlags = (((flag(pkg.isProfileable(), 1) | flag(pkg.hasRequestForegroundServiceExemption(), 2)) | flag(pkg.isAttributionsUserVisible(), 4)) | flag(pkg.isOnBackInvokedCallbackEnabled(), 8)) | flag(isAllowlistedForHiddenApis, 16);
        return appInfoPrivateFlagsExt(pkgWithoutStateFlags, pkgSetting);
    }

    private static int appInfoPrivateFlagsExt(int pkgWithoutStateFlags, PackageStateInternal pkgSetting) {
        if (pkgSetting != null) goto L5;
        return pkgWithoutStateFlags;
    L5:
        if (pkgSetting.getCpuAbiOverride() == null) goto L7;
        boolean r1 = true;
    L8:
        int flags = pkgWithoutStateFlags | flag(r1, 32);
        return flags;
    L7:
        r1 = false;
        goto L8
    }

    private static void initForUser(ApplicationInfo output, AndroidPackage input, int userId, PackageUserStateInternal state) {
        PackageImpl pkg = (PackageImpl) input;
        String packageName = input.getPackageName();
        output.uid = UserHandle.getUid(userId, UserHandle.getAppId(input.getUid()));
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L7;
        output.dataDir = SYSTEM_DATA_PATH;
        return;
    L7:
        if (state.isInstalled() == false) goto L9;
    L12:
        if (userId != 0) goto L14;
        output.credentialProtectedDataDir = pkg.getBaseAppDataCredentialProtectedDirForSystemUser() + packageName;
        output.deviceProtectedDataDir = pkg.getBaseAppDataDeviceProtectedDirForSystemUser() + packageName;
    L16:
        if (input.isDefaultToDeviceProtectedStorage() == false) goto L18;
        output.dataDir = output.deviceProtectedDataDir;
        return;
    L18:
        output.dataDir = output.credentialProtectedDataDir;
        return;
    L14:
        String userIdString = String.valueOf(userId);
        int credentialLength = pkg.getBaseAppDataCredentialProtectedDirForSystemUser().length();
        StringBuilder r4 = new StringBuilder(pkg.getBaseAppDataCredentialProtectedDirForSystemUser()).replace(credentialLength - 2, credentialLength - 1, userIdString);
        r4.append(packageName);
        output.credentialProtectedDataDir = r4.toString();
        int deviceLength = pkg.getBaseAppDataDeviceProtectedDirForSystemUser().length();
        StringBuilder r5 = new StringBuilder(pkg.getBaseAppDataDeviceProtectedDirForSystemUser()).replace(deviceLength - 2, deviceLength - 1, userIdString);
        r5.append(packageName);
        output.deviceProtectedDataDir = r5.toString();
        goto L16
    L9:
        if (state.dataExists() == true) goto L12;
        output.dataDir = null;
    }

    private static void initForUser(InstrumentationInfo output, AndroidPackage input, int userId, PackageUserStateInternal state) {
        PackageImpl pkg = (PackageImpl) input;
        String packageName = input.getPackageName();
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L7;
        output.dataDir = SYSTEM_DATA_PATH;
        return;
    L7:
        if (state.isInstalled() == false) goto L9;
    L12:
        if (userId != 0) goto L14;
        output.credentialProtectedDataDir = pkg.getBaseAppDataCredentialProtectedDirForSystemUser() + packageName;
        output.deviceProtectedDataDir = pkg.getBaseAppDataDeviceProtectedDirForSystemUser() + packageName;
    L16:
        if (input.isDefaultToDeviceProtectedStorage() == false) goto L18;
        output.dataDir = output.deviceProtectedDataDir;
        return;
    L18:
        output.dataDir = output.credentialProtectedDataDir;
        return;
    L14:
        String userIdString = String.valueOf(userId);
        int credentialLength = pkg.getBaseAppDataCredentialProtectedDirForSystemUser().length();
        StringBuilder r4 = new StringBuilder(pkg.getBaseAppDataCredentialProtectedDirForSystemUser()).replace(credentialLength - 2, credentialLength - 1, userIdString);
        r4.append(packageName);
        output.credentialProtectedDataDir = r4.toString();
        int deviceLength = pkg.getBaseAppDataDeviceProtectedDirForSystemUser().length();
        StringBuilder r5 = new StringBuilder(pkg.getBaseAppDataDeviceProtectedDirForSystemUser()).replace(deviceLength - 2, deviceLength - 1, userIdString);
        r5.append(packageName);
        output.deviceProtectedDataDir = r5.toString();
        goto L16
    L9:
        if (state.dataExists() == true) goto L12;
        output.dataDir = null;
    }

    public static File getDataDir(PackageStateInternal ps, int userId) {
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(ps.getPackageName()) == false) goto L7;
        return Environment.getDataSystemDirectory();
    L7:
        if (ps.getUserStateOrDefault(userId).isInstalled() == true) goto L13;
        if (ps.getUserStateOrDefault(userId).dataExists() == true) goto L13;
        return null;
    L13:
        if (ps.isDefaultToDeviceProtectedStorage() == false) goto L17;
        return Environment.getDataUserDePackageDirectory(ps.getVolumeUuid(), userId, ps.getPackageName());
    L17:
        return Environment.getDataUserCePackageDirectory(ps.getVolumeUuid(), userId, ps.getPackageName());
    }
}
