package com.android.server.pm;

import android.app.doppelganger.DoppelgangerConfigure;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.Build;
import android.os.Environment;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Slog;
import android.util.apk.ApkSignatureVerifier;
import android.util.jar.StrictJarFile;
import bytedanceos.api.PackageManagerSmt;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.pm.pkg.component.ComponentMutateUtils;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.component.ParsedProcess;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemConfig;
import com.android.server.am.HostingRecord;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.parsing.library.PackageBackwardCompatibility;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateUtils;
import com.android.server.utils.WatchedArraySet;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class ScanPackageUtils {
    public static final int PAGE_SIZE_16KB = 16384;

    ScanPackageUtils() {
    }

    public static ScanResult scanPackageOnly(ScanRequest request, PackageManagerServiceInjector injector, boolean isUnderFactoryTest, long currentTime) throws PackageManagerException {
        PackageAbiHelper packageAbiHelper = injector.getAbiHelper();
        ParsedPackage parsedPackage = request.mParsedPackage;
        PackageSetting pkgSetting = request.mPkgSetting;
        PackageSetting disabledPkgSetting = request.mDisabledPkgSetting;
        PackageSetting disabledPkgSetting2 = request.mOriginalPkgSetting;
        int r8 = request.mParseFlags;
        int scanFlags = request.mScanFlags;
        String realPkgName = request.mRealPkgName;
        SharedUserSetting oldSharedUserSetting = request.mOldSharedUserSetting;
        SharedUserSetting sharedUserSetting = request.mSharedUserSetting;
        UserHandle r6 = request.mUser;
        boolean isPlatformPackage = request.mIsPlatformPackage;
        List<String> changedAbiCodePath = null;
        File destCodeFile = new File(parsedPackage.getPath());
        if ((scanFlags & 4096) == 0) goto L5;
        boolean needToDeriveAbi = true;
    L7:
        if ((scanFlags & 67108864) == 0) goto L9;
        boolean r20 = true;
    L10:
        boolean isApex = r20;
        if (needToDeriveAbi == true) goto L20;
        if (pkgSetting != null) goto L14;
        String secondaryCpuAbiFromSettings = null;
        String primaryCpuAbiFromSettings = null;
        boolean needToDeriveAbi2 = true;
    L22:
        if (pkgSetting == null) goto L33;
        if (oldSharedUserSetting == sharedUserSetting) goto L33;
        StringBuilder r2 = new StringBuilder();
        r2.append("Package ");
        r2.append(parsedPackage.getPackageName());
        r2.append(" shared user changed from ");
        String r7 = "<nothing>";
        if (oldSharedUserSetting == null) goto L28;
        r7 = oldSharedUserSetting.name;
    L28:
        r2.append(r7);
        r2.append(" to ");
        if (sharedUserSetting == null) goto L31;
        String r9 = sharedUserSetting.name;
    L32:
        r2.append(r9);
        r2.append("; replacing with new");
        PackageManagerService.reportSettingsProblem(5, r2.toString());
        boolean isPendingRestoreBefore = pkgSetting.isPendingRestore();
        PackageSetting pkgSetting2 = null;
        boolean isPendingRestoreBefore2 = isPendingRestoreBefore;
    L35:
        if (parsedPackage.getUsesSdkLibraries().isEmpty() == true) goto L37;
        String[] usesSdkLibraries = new String[parsedPackage.getUsesSdkLibraries().size()];
        parsedPackage.getUsesSdkLibraries().toArray(usesSdkLibraries);
        String[] usesSdkLibraries2 = usesSdkLibraries;
    L39:
        if (parsedPackage.getUsesStaticLibraries().isEmpty() == true) goto L41;
        String[] usesStaticLibraries = new String[parsedPackage.getUsesStaticLibraries().size()];
        parsedPackage.getUsesStaticLibraries().toArray(usesStaticLibraries);
        String[] usesStaticLibraries2 = usesStaticLibraries;
    L42:
        UUID newDomainSetId = injector.getDomainVerificationManagerInternal().generateNewId();
        if (pkgSetting2 != null) goto L45;
        boolean r5 = true;
    L46:
        boolean createNewPackage = r5;
        if (createNewPackage == true) goto L49;
        String[] usesStaticLibraries3 = usesStaticLibraries2;
        SharedUserSetting sharedUserSetting2 = sharedUserSetting;
        PackageSetting pkgSetting3 = new PackageSetting(pkgSetting2);
        pkgSetting3.setPkg(parsedPackage);
        if ((scanFlags & 1024) == 0) goto L67;
        boolean isDontKill = true;
    L68:
        Settings.updatePackageSetting(pkgSetting3, disabledPkgSetting, oldSharedUserSetting, sharedUserSetting2, destCodeFile, parsedPackage.getNativeLibraryDir(), pkgSetting3.getPrimaryCpuAbi(), pkgSetting3.getSecondaryCpuAbi(), PackageInfoUtils.appInfoFlags(parsedPackage, pkgSetting3), PackageInfoUtils.appInfoPrivateFlags(parsedPackage, pkgSetting3), UserManagerService.getInstance(), usesSdkLibraries2, parsedPackage.getUsesSdkLibrariesVersionsMajor(), parsedPackage.getUsesSdkLibrariesOptional(), usesStaticLibraries3, parsedPackage.getUsesStaticLibrariesVersions(), parsedPackage.getMimeGroups(), newDomainSetId, parsedPackage.getTargetSdkVersion(), parsedPackage.getRestrictUpdateHash(), isDontKill);
        disabledPkgSetting = disabledPkgSetting;
        SharedUserSetting oldSharedUserSetting2 = oldSharedUserSetting;
    L70:
        if (UserManagerService.getInstance().exists(10) == true) goto L72;
    L78:
        if (createNewPackage == false) goto L81;
        if (disabledPkgSetting2 == 0) goto L81;
        parsedPackage.setPackageName(disabledPkgSetting2.getPackageName());
        String msg = "New package " + pkgSetting3.getRealName() + " renamed to replace old package " + pkgSetting3.getPackageName();
        PackageManagerService.reportSettingsProblem(5, msg);
    L81:
        if (r6 != 0) goto L83;
        int r3 = 0;
    L84:
        int userId = r3;
        if (createNewPackage == false) goto L87;
        PackageManagerServiceInjector r10 = injector;
    L97:
        if (disabledPkgSetting == null) goto L99;
    L105:
        pkgSetting3.getPkgState().setUpdatedSystemApp(true);
    L106:
        pkgSetting3.getTransientState().setSeInfo(SELinuxMMAC.getSeInfo(pkgSetting3, parsedPackage, sharedUserSetting2, r10.getCompatibility()));
        if (pkgSetting3.isSystem() == false) goto L109;
        configurePackageComponents(parsedPackage);
    L109:
        String cpuAbiOverride = PackageManagerServiceUtils.deriveAbiOverride(request.mCpuAbiOverride);
        boolean isSystemApp = pkgSetting3.isSystem();
        boolean isUpdatedSystemApp = pkgSetting3.isUpdatedSystemApp();
        File appLib32InstallDir = getAppLib32InstallDir();
        if (isApex == false) goto L112;
        boolean isUpdatedSystemApp2 = isUpdatedSystemApp;
        int scanFlags2 = scanFlags;
        boolean r40 = false;
        boolean isUpdatedSystemApp3 = isSystemApp;
        String cpuAbiOverride2 = cpuAbiOverride;
        PackageAbiHelper packageAbiHelper2 = packageAbiHelper;
    L145:
        if ((scanFlags2 & 1) == 0) goto L147;
    L150:
        pkgSetting3.setPrimaryCpuAbi(AndroidPackageUtils.getRawPrimaryCpuAbi(parsedPackage)).setSecondaryCpuAbi(AndroidPackageUtils.getRawSecondaryCpuAbi(parsedPackage)).setCpuAbiOverride(cpuAbiOverride2);
        pkgSetting3.setLegacyNativeLibraryPath(parsedPackage.getNativeLibraryRootDir());
        if (Os.sysconf(OsConstants._SC_PAGESIZE) != 16384) goto L153;
        boolean is16KbDevice = true;
    L154:
        if (is16KbDevice == true) goto L156;
        int scanFlags3 = scanFlags2;
    L170:
        if ((scanFlags3 & 16) != 0) goto L174;
        if (oldSharedUserSetting2 == null) goto L174;
        changedAbiCodePath = applyAdjustedAbiToSharedUser(oldSharedUserSetting2, parsedPackage, packageAbiHelper2.getAdjustedAbiForSharedUser(oldSharedUserSetting2.getPackageStates(), parsedPackage));
    L174:
        if (isUnderFactoryTest == true) goto L176;
    L178:
        boolean r1 = r40;
    L179:
        parsedPackage.setFactoryTest(r1);
        if (isUpdatedSystemApp3 == false) goto L183;
        pkgSetting3.setIsOrphaned(true);
    L183:
        pkgSetting3.setDebuggable(parsedPackage.isDebuggable());
        pkgSetting3.setBaseRevisionCode(parsedPackage.getBaseRevisionCode());
        long scanFileTime = PackageManagerServiceUtils.getLastModifiedTime(parsedPackage);
        long earliestFirstInstallTime = PackageStateUtils.getEarliestFirstInstallTime(pkgSetting3.getUserStates());
        if (currentTime == 0) goto L192;
        if (earliestFirstInstallTime != 0) goto L189;
        pkgSetting3.setFirstInstallTime(currentTime, userId).setLastUpdateTime(currentTime);
    L199:
        pkgSetting3.setLastModifiedTime(scanFileTime);
        pkgSetting3.setPkg(parsedPackage).setFlags(PackageInfoUtils.appInfoFlags(parsedPackage, pkgSetting3)).setPrivateFlags(PackageInfoUtils.appInfoPrivateFlags(parsedPackage, pkgSetting3));
        if (parsedPackage.getLongVersionCode() == pkgSetting3.getVersionCode()) goto L202;
        pkgSetting3.setLongVersionCode(parsedPackage.getLongVersionCode());
    L202:
        String volumeUuid = parsedPackage.getVolumeUuid();
        if (Objects.equals(volumeUuid, pkgSetting3.getVolumeUuid()) == true) goto L210;
        StringBuilder r4 = new StringBuilder();
        r4.append("Update");
        if (pkgSetting3.isSystem() == false) goto L207;
        String r11 = " system";
    L208:
        r4.append(r11);
        r4.append(" package ");
        r4.append(parsedPackage.getPackageName());
        r4.append(" volume from ");
        r4.append(pkgSetting3.getVolumeUuid());
        r4.append(" to ");
        r4.append(volumeUuid);
        Slog.i(PackageManagerServiceMonitorEx.TAG, r4.toString());
        pkgSetting3.setVolumeUuid(volumeUuid);
        goto L210
    L207:
        r11 = "";
    L210:
        pkgSetting3.setLeavingSharedUser(parsedPackage.isLeavingSharedUser());
        SharedLibraryInfo sdkLibraryInfo = null;
        if (TextUtils.isEmpty(parsedPackage.getSdkLibraryName()) == true) goto L213;
        sdkLibraryInfo = AndroidPackageUtils.createSharedLibraryForSdk(parsedPackage);
    L213:
        SharedLibraryInfo staticSharedLibraryInfo = null;
        if (TextUtils.isEmpty(parsedPackage.getStaticSharedLibraryName()) == true) goto L216;
        staticSharedLibraryInfo = AndroidPackageUtils.createSharedLibraryForStatic(parsedPackage);
    L216:
        List<SharedLibraryInfo> dynamicSharedLibraryInfos = null;
        if (ArrayUtils.isEmpty(parsedPackage.getLibraryNames()) == true) goto L224;
        dynamicSharedLibraryInfos = new ArrayList(parsedPackage.getLibraryNames().size());
        Iterator r0 = parsedPackage.getLibraryNames().iterator();
    L220:
        if (r0.hasNext() == false) goto L224;
        String name = (String) r0.next();
        dynamicSharedLibraryInfos.add(AndroidPackageUtils.createSharedLibraryForDynamic(parsedPackage, name));
        r0 = r0;
    L224:
        if (createNewPackage == true) goto L226;
        boolean r43 = true;
    L227:
        SharedLibraryInfo staticSharedLibraryInfo2 = staticSharedLibraryInfo;
        List<SharedLibraryInfo> dynamicSharedLibraryInfos2 = dynamicSharedLibraryInfos;
        return new ScanResult(request, pkgSetting3, changedAbiCodePath, r43, -1, sdkLibraryInfo, staticSharedLibraryInfo2, dynamicSharedLibraryInfos2);
    L226:
        r43 = r40;
        goto L227
    L189:
        if ((scanFlags3 & 8) == 0) goto L199;
        pkgSetting3.setLastUpdateTime(currentTime);
        goto L199
    L192:
        if (earliestFirstInstallTime != 0) goto L195;
        pkgSetting3.setFirstInstallTime(scanFileTime, userId).setLastUpdateTime(scanFileTime);
        goto L199
    L195:
        if ((r8 & 16) == 0) goto L199;
        if (scanFileTime == pkgSetting3.getLastModifiedTime()) goto L199;
        pkgSetting3.setLastUpdateTime(scanFileTime);
        goto L199
    L176:
        if (parsedPackage.getRequestedPermissions().contains("android.permission.FACTORY_TEST") == false) goto L178;
        r1 = true;
        goto L179
    L156:
        if (parsedPackage.getPageSizeAppCompatFlags() <= 0) goto L159;
        pkgSetting3.setPageSizeAppCompatFlags(parsedPackage.getPageSizeAppCompatFlags());
        scanFlags3 = scanFlags2;
        goto L170
    L159:
        if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) goto L167;
        if (isUpdatedSystemApp3 == true) goto L167;
        if (isApex == true) goto L167;
        if (isPlatformPackage == true) goto L167;
        scanFlags3 = scanFlags2;
        int mode = packageAbiHelper2.checkPackageAlignment(parsedPackage, pkgSetting3.getLegacyNativeLibraryPath(), parsedPackage.isNativeLibraryRootRequiresIsa(), pkgSetting3.getCpuAbiOverride());
        if (mode < 0) goto L166;
        pkgSetting3.setPageSizeAppCompatFlags(mode);
        goto L170
    L166:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Error occurred while checking alignment of package : " + parsedPackage.getPackageName());
    L167:
        scanFlags3 = scanFlags2;
        goto L170
    L153:
        is16KbDevice = r40;
        goto L154
    L147:
        if ((scanFlags2 & 4) == 0) goto L150;
        if (cpuAbiOverride2 != null) goto L150;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Ignoring persisted ABI override for package " + parsedPackage.getPackageName());
        goto L150
    L112:
        if ((scanFlags & 4) != 0) goto L132;
        if (needToDeriveAbi2 == false) goto L131;
        Trace.traceBegin(262144, "derivePackageAbi");
        scanFlags2 = scanFlags;
        packageAbiHelper2 = packageAbiHelper;
        Pair<PackageAbiHelper.Abis, PackageAbiHelper.NativeLibraryPaths> derivedAbi = packageAbiHelper2.derivePackageAbi(parsedPackage, isSystemApp, isUpdatedSystemApp, cpuAbiOverride, appLib32InstallDir);     // Catch: Throwable -> L127
        isUpdatedSystemApp3 = isSystemApp;
        cpuAbiOverride2 = cpuAbiOverride;
        isUpdatedSystemApp2 = isUpdatedSystemApp;
        long r22 = 262144;
        ((PackageAbiHelper.Abis) derivedAbi.first).applyTo(parsedPackage);     // Catch: Throwable -> L125
        ((PackageAbiHelper.NativeLibraryPaths) derivedAbi.second).applyTo(parsedPackage);     // Catch: Throwable -> L125
        Trace.traceEnd(262144);
        String pkgRawPrimaryCpuAbi = AndroidPackageUtils.getRawPrimaryCpuAbi(parsedPackage);
        if (isUpdatedSystemApp3 == false) goto L136;
        if (isUpdatedSystemApp2 == true) goto L136;
        if (pkgRawPrimaryCpuAbi != null) goto L136;
        PackageAbiHelper.Abis abis = packageAbiHelper2.getBundledAppAbis(parsedPackage);
        abis.applyTo(parsedPackage);
        abis.applyTo(pkgSetting3);
        PackageAbiHelper.NativeLibraryPaths nativeLibraryPaths = packageAbiHelper2.deriveNativeLibraryPaths(parsedPackage, isUpdatedSystemApp3, isUpdatedSystemApp2, appLib32InstallDir);
        nativeLibraryPaths.applyTo(parsedPackage);
    L136:
        if (isPlatformPackage == true) goto L138;
        r40 = false;
        goto L145
    L138:
        if (VMRuntime.getRuntime().is64Bit() == false) goto L140;
        r40 = false;
        String r12 = Build.SUPPORTED_64_BIT_ABIS[0];
    L141:
        parsedPackage.setPrimaryCpuAbi(r12);
        goto L145
    L140:
        r40 = false;
        r12 = Build.SUPPORTED_32_BIT_ABIS[0];
    L125:
        th = th;
    L129:
        Trace.traceEnd(r22);
        throw th;
    L127:
        th = th;
        r22 = 262144;
        goto L129
    L131:
        isUpdatedSystemApp2 = isUpdatedSystemApp;
        scanFlags2 = scanFlags;
        isUpdatedSystemApp3 = isSystemApp;
        cpuAbiOverride2 = cpuAbiOverride;
        packageAbiHelper2 = packageAbiHelper;
        parsedPackage.setPrimaryCpuAbi(primaryCpuAbiFromSettings).setSecondaryCpuAbi(secondaryCpuAbiFromSettings);
        PackageAbiHelper.NativeLibraryPaths nativeLibraryPaths2 = packageAbiHelper2.deriveNativeLibraryPaths(parsedPackage, isUpdatedSystemApp3, isUpdatedSystemApp2, appLib32InstallDir);
        nativeLibraryPaths2.applyTo(parsedPackage);
        goto L136
    L132:
        isUpdatedSystemApp2 = isUpdatedSystemApp;
        scanFlags2 = scanFlags;
        isUpdatedSystemApp3 = isSystemApp;
        cpuAbiOverride2 = cpuAbiOverride;
        packageAbiHelper2 = packageAbiHelper;
        if ((scanFlags2 & 256) == 0) goto L135;
        parsedPackage.setPrimaryCpuAbi(pkgSetting3.getPrimaryCpuAbiLegacy()).setSecondaryCpuAbi(pkgSetting3.getSecondaryCpuAbiLegacy());
    L135:
        PackageAbiHelper.NativeLibraryPaths nativeLibraryPaths3 = packageAbiHelper2.deriveNativeLibraryPaths(parsedPackage, isUpdatedSystemApp3, isUpdatedSystemApp2, appLib32InstallDir);
        nativeLibraryPaths3.applyTo(parsedPackage);
        goto L136
    L99:
        if ((scanFlags & 4) == 0) goto L106;
        if (pkgSetting3 == null) goto L106;
        if (pkgSetting3.isSystem() == false) goto L106;
        if ((parsedPackage.getApplicationInfoSmtEx().bytedanceFlag & 256) != 0) goto L106;
    L87:
        if ((scanFlags & 8192) == 0) goto L89;
        boolean instantApp = true;
    L91:
        if ((scanFlags & 16384) == 0) goto L93;
        boolean fullApp = true;
    L94:
        r10 = injector;
        setInstantAppForUser(r10, pkgSetting3, userId, instantApp, fullApp);
        goto L97
    L93:
        fullApp = false;
        goto L94
    L89:
        instantApp = false;
        goto L91
    L83:
        r3 = r6.getIdentifier();
        goto L84
    L72:
        if (PackageManagerSmt.isGMSApp(pkgSetting3.getPackageName(), null) == false) goto L74;
    L77:
        pkgSetting3.setInstalled(false, 10);
        goto L78
    L74:
        if (PackageManagerServiceUtils.isSystemApp(pkgSetting3) == false) goto L78;
        if (DoppelgangerConfigure.DOPPELGANGER_NECESSARY_PACKAGES.contains(parsedPackage.getPackageName()) == true) goto L78;
    L67:
        isDontKill = false;
        goto L68
    L49:
        if ((scanFlags & 8192) == 0) goto L51;
        boolean instantApp2 = true;
    L53:
        if ((32768 & scanFlags) == 0) goto L55;
        boolean virtualPreload = true;
    L57:
        if ((134217728 & scanFlags) == 0) goto L59;
        boolean isStoppedSystemApp = true;
    L60:
        int pkgFlags = PackageInfoUtils.appInfoFlags(parsedPackage, null);
        int pkgPrivateFlags = PackageInfoUtils.appInfoPrivateFlags(parsedPackage, null);
        PackageSetting pkgSetting4 = Settings.createNewSetting(parsedPackage.getPackageName(), disabledPkgSetting2, disabledPkgSetting, realPkgName, sharedUserSetting, destCodeFile, parsedPackage.getNativeLibraryRootDir(), AndroidPackageUtils.getRawPrimaryCpuAbi(parsedPackage), AndroidPackageUtils.getRawSecondaryCpuAbi(parsedPackage), parsedPackage.getLongVersionCode(), pkgFlags, pkgPrivateFlags, r6, true, instantApp2, virtualPreload, isStoppedSystemApp, UserManagerService.getInstance(), usesSdkLibraries2, parsedPackage.getUsesSdkLibrariesVersionsMajor(), parsedPackage.getUsesSdkLibrariesOptional(), usesStaticLibraries2, parsedPackage.getUsesStaticLibrariesVersions(), parsedPackage.getMimeGroups(), newDomainSetId, parsedPackage.getTargetSdkVersion(), parsedPackage.getRestrictUpdateHash());
        sharedUserSetting2 = sharedUserSetting;
        if (isPendingRestoreBefore2 == false) goto L63;
        pkgSetting4.setPendingRestore(true);
    L63:
        pkgSetting3 = pkgSetting4;
        oldSharedUserSetting2 = oldSharedUserSetting;
        goto L70
    L59:
        isStoppedSystemApp = false;
        goto L60
    L55:
        virtualPreload = false;
        goto L57
    L51:
        instantApp2 = false;
        goto L53
    L45:
        r5 = false;
        goto L46
    L41:
        usesStaticLibraries2 = null;
        goto L42
    L37:
        usesSdkLibraries2 = null;
        goto L39
    L31:
        r9 = "<nothing>";
    L33:
        pkgSetting2 = pkgSetting;
        isPendingRestoreBefore2 = false;
        goto L35
    L14:
        if (pkgSetting.getPkg() != null) goto L16;
    L18:
        String primaryCpuAbiFromSettings2 = pkgSetting.getPrimaryCpuAbiLegacy();
        String secondaryCpuAbiFromSettings2 = pkgSetting.getSecondaryCpuAbiLegacy();
        secondaryCpuAbiFromSettings = secondaryCpuAbiFromSettings2;
        primaryCpuAbiFromSettings = primaryCpuAbiFromSettings2;
        needToDeriveAbi2 = needToDeriveAbi;
        goto L22
    L16:
        if (pkgSetting.getPkg().isStub() == false) goto L18;
        secondaryCpuAbiFromSettings = null;
        primaryCpuAbiFromSettings = null;
        needToDeriveAbi2 = true;
        goto L22
    L20:
        secondaryCpuAbiFromSettings = null;
        primaryCpuAbiFromSettings = null;
        needToDeriveAbi2 = needToDeriveAbi;
        goto L22
    L9:
        r20 = false;
        goto L10
    L5:
        needToDeriveAbi = false;
        goto L7
    }

    public static int adjustScanFlagsWithPackageSetting(int scanFlags, PackageSetting pkgSetting, PackageSetting disabledPkgSetting, UserHandle user) {
        if ((scanFlags & 4) == 0) goto L9;
        if (disabledPkgSetting != null) goto L9;
        if (pkgSetting == null) goto L9;
        if (pkgSetting.isSystem() == false) goto L9;
        PackageSetting systemPkgSetting = pkgSetting;
    L11:
        if (systemPkgSetting == null) goto L30;
        scanFlags = scanFlags | 65536;
        if ((systemPkgSetting.getPrivateFlags() & 8) == 0) goto L16;
        scanFlags = scanFlags | 131072;
    L16:
        if ((systemPkgSetting.getPrivateFlags() & 131072) == 0) goto L19;
        scanFlags = scanFlags | 262144;
    L19:
        if ((systemPkgSetting.getPrivateFlags() & 262144) == 0) goto L22;
        scanFlags = scanFlags | 524288;
    L22:
        if ((systemPkgSetting.getPrivateFlags() & 524288) == 0) goto L25;
        scanFlags = scanFlags | 1048576;
    L25:
        if ((systemPkgSetting.getPrivateFlags() & 2097152) == 0) goto L28;
        scanFlags = scanFlags | 2097152;
    L28:
        if ((systemPkgSetting.getPrivateFlags() & 1073741824) == 0) goto L30;
        scanFlags = scanFlags | 4194304;
    L30:
        if (pkgSetting == null) goto L41;
        if (user != null) goto L33;
        int userId = 0;
    L35:
        if (pkgSetting.getInstantApp(userId) == false) goto L38;
        scanFlags = scanFlags | 8192;
    L38:
        if (pkgSetting.getVirtualPreload(userId) == true) goto L40;
        return scanFlags;
    L40:
        return scanFlags | 32768;
    L33:
        userId = user.getIdentifier();
        goto L35
    L41:
        return scanFlags;
    L9:
        systemPkgSetting = disabledPkgSetting;
        goto L11
    }

    public static void assertCodePolicy(AndroidPackage pkg) throws PackageManagerException {
        boolean shouldHaveCode = pkg.isDeclaredHavingCode();
        if (shouldHaveCode == false) goto L10;
        if (apkHasCode(pkg.getBaseApkPath()) == true) goto L10;
        throw new PackageManagerException(-2, "Package " + pkg.getBaseApkPath() + " code is missing");
    L10:
        if (ArrayUtils.isEmpty(pkg.getSplitCodePaths()) == true) goto L25;
        int i = 0;
    L13:
        if (i >= pkg.getSplitCodePaths().length) goto L30;
        if ((pkg.getSplitFlags()[i] & 4) == 0) goto L17;
        boolean splitShouldHaveCode = true;
    L18:
        if (splitShouldHaveCode == false) goto L24;
        if (apkHasCode(pkg.getSplitCodePaths()[i]) == true) goto L24;
        throw new PackageManagerException(-2, "Package " + pkg.getSplitCodePaths()[i] + " code is missing");
    L24:
        i = i + 1;
        goto L13
    L17:
        splitShouldHaveCode = false;
        goto L18
    L30:
        return;
    }

    public static void assertStaticSharedLibraryIsValid(AndroidPackage pkg, int scanFlags) throws PackageManagerException {
        if (pkg.getTargetSdkVersion() < 26) goto L58;
        if ((scanFlags & 8192) != 0) goto L56;
        if (ArrayUtils.isEmpty(pkg.getOriginalPackages()) == false) goto L54;
        if (ArrayUtils.isEmpty(pkg.getLibraryNames()) == false) goto L52;
        if (pkg.getSharedUserId() != null) goto L50;
        if (pkg.getActivities().isEmpty() == false) goto L48;
        if (pkg.getServices().isEmpty() == false) goto L46;
        if (pkg.getProviders().isEmpty() == false) goto L44;
        if (pkg.getReceivers().isEmpty() == false) goto L42;
        if (pkg.getPermissionGroups().isEmpty() == false) goto L40;
        if (pkg.getAttributions().isEmpty() == false) goto L38;
        if (pkg.getPermissions().isEmpty() == false) goto L36;
        if (pkg.getProtectedBroadcasts().isEmpty() == false) goto L34;
        if (pkg.getOverlayTarget() != null) goto L32;
        return;
    L32:
        throw PackageManagerException.ofInternalError("Static shared libs cannot be overlay targets", -35);
    L34:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare protected broadcasts", -34);
    L36:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare permissions", -33);
    L38:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare features", -32);
    L40:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare permission groups", -31);
    L42:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare broadcast receivers", -30);
    L44:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare content providers", -29);
    L46:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare services", -28);
    L48:
        throw PackageManagerException.ofInternalError("Static shared libs cannot declare activities", -27);
    L50:
        throw PackageManagerException.ofInternalError("Packages declaring static-shared libs cannot declare shared users", -26);
    L52:
        throw PackageManagerException.ofInternalError("Packages declaring static-shared libs cannot declare dynamic libs", -25);
    L54:
        throw PackageManagerException.ofInternalError("Packages declaring static-shared libs cannot be renamed", -24);
    L56:
        throw PackageManagerException.ofInternalError("Packages declaring static-shared libs cannot be instant apps", -23);
    L58:
        throw PackageManagerException.ofInternalError("Packages declaring static-shared libs must target O SDK or higher", -22);
    }

    public static void assertProcessesAreValid(AndroidPackage pkg) throws PackageManagerException {
        Map<String, ParsedProcess> procs = pkg.getProcesses();
        if (procs.isEmpty() == false) goto L5;
        return;
    L5:
        if (procs.containsKey(pkg.getProcessName()) == false) goto L8;
        assertPackageProcesses(pkg, pkg.getActivities(), procs, HostingRecord.HOSTING_TYPE_ACTIVITY);
        assertPackageProcesses(pkg, pkg.getServices(), procs, HostingRecord.HOSTING_TYPE_SERVICE);
        assertPackageProcesses(pkg, pkg.getReceivers(), procs, "receiver");
        assertPackageProcesses(pkg, pkg.getProviders(), procs, "provider");
        return;
    L8:
        throw new PackageManagerException(-122, "Can't install because application tag's process attribute " + pkg.getProcessName() + " (in package " + pkg.getPackageName() + ") is not included in the <processes> list");
    }

    private static <T extends ParsedMainComponent> void assertPackageProcesses(AndroidPackage pkg, List<T> components, Map<String, ParsedProcess> procs, String compName) throws PackageManagerException {
        if (components != null) goto L4;
        return;
    L4:
        int i = components.size() - 1;
    L5:
        if (i < 0) goto L12;
        ParsedMainComponent component = components.get(i);
        if (procs.containsKey(component.getProcessName()) == false) goto L10;
        i = i - 1;
        goto L5
    L10:
        throw new PackageManagerException(-122, "Can't install because " + compName + " " + component.getClassName() + "'s process attribute " + component.getProcessName() + " (in package " + pkg.getPackageName() + ") is not included in the <processes> list");
    }

    public static void assertMinSignatureSchemeIsValid(AndroidPackage pkg, int parseFlags) throws PackageManagerException {
        int minSignatureSchemeVersion = ApkSignatureVerifier.getMinimumSignatureSchemeVersionForTargetSdk(pkg.getTargetSdkVersion());
        if (pkg.getSigningDetails().getSignatureSchemeVersion() < minSignatureSchemeVersion) goto L6;
        return;
    L6:
        throw new PackageManagerException(GnssNative.GeofenceCallbacks.GEOFENCE_STATUS_ERROR_INVALID_TRANSITION, "No signature found in package of version " + minSignatureSchemeVersion + " or newer for package " + pkg.getPackageName());
    }

    public static String getRealPackageName(AndroidPackage pkg, String renamedPkgName, boolean isSystemApp) {
        if (isPackageRenamed(pkg, renamedPkgName) == true) goto L5;
        return null;
    L5:
        return AndroidPackageUtils.getRealPackageOrNull(pkg, isSystemApp);
    }

    public static boolean isPackageRenamed(AndroidPackage pkg, String renamedPkgName) {
        return pkg.getOriginalPackages().contains(renamedPkgName);
    }

    public static void ensurePackageRenamed(ParsedPackage parsedPackage, String renamedPackageName) {
        if (parsedPackage.getOriginalPackages().contains(renamedPackageName) == true) goto L5;
        return;
    L5:
        if (parsedPackage.getPackageName().equals(renamedPackageName) == true) goto L10;
        parsedPackage.setPackageName(renamedPackageName);
        return;
    }

    public static boolean apkHasCode(String fileName) {
        StrictJarFile jarFile = null;
        boolean r1 = false;
        jarFile = new StrictJarFile(fileName, false, false);     // Catch: Throwable -> L11 IOException -> L13
        if (jarFile.findEntry("classes.dex") == null) goto L29;
        r1 = true;
    L29:
        jarFile.close();     // Catch: IOException -> L9
    L10:
        return r1;
    L11:
        th = move-exception;
        if (jarFile != null) goto L31;
    L21:
        throw th;
    L31:
        jarFile.close();     // Catch: IOException -> L18
    L22:
        if (jarFile != null) goto L33;
    L28:
        return false;
    L33:
        jarFile.close();     // Catch: IOException -> L25
        goto L28
    }

    public static void configurePackageComponents(AndroidPackage pkg) {
        ArrayMap<String, Boolean> componentsEnabledStates = SystemConfig.getInstance().getComponentsEnabledStates(pkg.getPackageName());
        if (componentsEnabledStates != null) goto L5;
        return;
    L5:
        int i = ArrayUtils.size(pkg.getActivities()) - 1;
    L6:
        if (i < 0) goto L11;
        ParsedActivity component = (ParsedActivity) pkg.getActivities().get(i);
        Boolean enabled = componentsEnabledStates.get(component.getName());
        if (enabled == null) goto L10;
        ComponentMutateUtils.setEnabled(component, enabled.booleanValue());
    L10:
        i = i - 1;
        goto L6
    L11:
        int i2 = ArrayUtils.size(pkg.getReceivers()) - 1;
    L12:
        if (i2 < 0) goto L17;
        ParsedActivity component2 = (ParsedActivity) pkg.getReceivers().get(i2);
        Boolean enabled2 = componentsEnabledStates.get(component2.getName());
        if (enabled2 == null) goto L16;
        ComponentMutateUtils.setEnabled(component2, enabled2.booleanValue());
    L16:
        i2 = i2 - 1;
        goto L12
    L17:
        int i3 = ArrayUtils.size(pkg.getProviders()) - 1;
    L18:
        if (i3 < 0) goto L23;
        ParsedProvider component3 = (ParsedProvider) pkg.getProviders().get(i3);
        Boolean enabled3 = componentsEnabledStates.get(component3.getName());
        if (enabled3 == null) goto L22;
        ComponentMutateUtils.setEnabled(component3, enabled3.booleanValue());
    L22:
        i3 = i3 - 1;
        goto L18
    L23:
        int i4 = ArrayUtils.size(pkg.getServices()) - 1;
    L24:
        if (i4 < 0) goto L30;
        ParsedService component4 = (ParsedService) pkg.getServices().get(i4);
        Boolean enabled4 = componentsEnabledStates.get(component4.getName());
        if (enabled4 == null) goto L28;
        ComponentMutateUtils.setEnabled(component4, enabled4.booleanValue());
    L28:
        i4 = i4 - 1;
        goto L24
    }

    public static int getVendorPartitionVersion() {
        String version = SystemProperties.get("ro.vndk.version");
        if (version.isEmpty() == false) goto L13;
        return 28;
    L13:
        return Integer.parseInt(version);
    L8:
        if (ArrayUtils.contains(Build.VERSION.ACTIVE_CODENAMES, version) == false) goto L15;
        return 10000;
    L15:
        return 28;
    }

    public static void applyPolicy(ParsedPackage parsedPackage, int scanFlags, AndroidPackage platformPkg, boolean isUpdatedSystemApp) {
        boolean isSystemApp = isUpdatedSystemApp;
        boolean r2 = true;
        if ((65536 & scanFlags) == 0) goto L10;
        isSystemApp = true;
        parsedPackage.setSystem(true);
        if (parsedPackage.isDirectBootAware() == false) goto L8;
        parsedPackage.setAllComponentsDirectBootAware(true);
    L8:
        if (PackageManagerServiceUtils.compressedFileExists(parsedPackage.getPath()) == false) goto L12;
        parsedPackage.setStub(true);
    L12:
        if ((scanFlags & 131072) != 0) goto L15;
        parsedPackage.markNotActivitiesAsNotExportedIfSingleUser();
    L15:
        if ((67108864 & scanFlags) == 0) goto L17;
        boolean r4 = true;
    L18:
        parsedPackage.setApex(r4);
        if ((131072 & scanFlags) == 0) goto L21;
        boolean r1 = true;
    L22:
        ParsedPackage r3 = parsedPackage.setPrivileged(r1);
        if ((262144 & scanFlags) == 0) goto L25;
        boolean r5 = true;
    L26:
        ParsedPackage r6 = r3.setOem(r5);
        if ((524288 & scanFlags) == 0) goto L29;
        boolean r7 = true;
    L30:
        ParsedPackage r8 = r6.setVendor(r7);
        if ((1048576 & scanFlags) == 0) goto L33;
        boolean r9 = true;
    L34:
        ParsedPackage r10 = r8.setProduct(r9);
        if ((2097152 & scanFlags) == 0) goto L37;
        boolean r11 = true;
    L38:
        ParsedPackage r12 = r10.setSystemExt(r11);
        if ((4194304 & scanFlags) == 0) goto L41;
        boolean r13 = true;
    L42:
        r12.setOdm(r13);
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(parsedPackage.getPackageName()) == true) goto L50;
        if (platformPkg != null) goto L46;
    L48:
        r2 = false;
        goto L50
    L46:
        if (PackageManagerServiceUtils.compareSignatures(platformPkg.getSigningDetails(), parsedPackage.getSigningDetails()) != 0) goto L48;
    L50:
        parsedPackage.setSignedWithPlatformKey(r2);
        if (isSystemApp == true) goto L53;
        parsedPackage.clearOriginalPackages().clearAdoptPermissions();
    L53:
        PackageBackwardCompatibility.modifySharedLibraries(parsedPackage, isSystemApp, isUpdatedSystemApp);
        return;
    L41:
        r13 = false;
        goto L42
    L37:
        r11 = false;
        goto L38
    L33:
        r9 = false;
        goto L34
    L29:
        r7 = false;
        goto L30
    L25:
        r5 = false;
        goto L26
    L21:
        r1 = false;
        goto L22
    L17:
        r4 = false;
        goto L18
    L10:
        parsedPackage.clearProtectedBroadcasts().setCoreApp(false).setPersistent(false).setDefaultToDeviceProtectedStorage(false).setDirectBootAware(false).capPermissionPriorities();
        goto L12
    }

    public static List<String> applyAdjustedAbiToSharedUser(SharedUserSetting sharedUserSetting, ParsedPackage scannedPackage, String adjustedAbi) {
        if (scannedPackage == null) goto L4;
        scannedPackage.setPrimaryCpuAbi(adjustedAbi);
    L4:
        List<String> changedAbiCodePath = null;
        WatchedArraySet<PackageSetting> sharedUserPackageSettings = sharedUserSetting.getPackageSettings();
        int i = 0;
    L6:
        if (i >= sharedUserPackageSettings.size()) goto L23;
        PackageSetting ps = sharedUserPackageSettings.valueAt(i);
        if (scannedPackage == null) goto L12;
        if (scannedPackage.getPackageName().equals(ps.getPackageName()) == false) goto L12;
    L21:
        i = i + 1;
    L12:
        if (ps.getPrimaryCpuAbiLegacy() != null) goto L21;
        ps.setPrimaryCpuAbi(adjustedAbi);
        ps.onChanged();
        if (ps.getPkg() == null) goto L21;
        if (TextUtils.equals(adjustedAbi, AndroidPackageUtils.getRawPrimaryCpuAbi(ps.getPkg())) == true) goto L21;
        if (changedAbiCodePath != null) goto L20;
        changedAbiCodePath = new ArrayList();
    L20:
        changedAbiCodePath.add(ps.getPathString());
        goto L21
    L23:
        return changedAbiCodePath;
    }

    public static void collectCertificatesLI(PackageSetting ps, ParsedPackage parsedPackage, Settings.VersionInfo settingsVersionForPackage, boolean forceCollect, boolean skipVerify, boolean isPreNMR1Upgrade) throws PackageManagerException {
        if (isPreNMR1Upgrade == false) goto L4;
        long lastModifiedTime = new File(parsedPackage.getPath()).lastModified();
    L6:
        if (ps == null) goto L25;
        if (forceCollect == true) goto L25;
        if (ps.getPathString().equals(parsedPackage.getPath()) == false) goto L25;
        if (ps.getLastModifiedTime() != lastModifiedTime) goto L25;
        if (ReconcilePackageUtils.isCompatSignatureUpdateNeeded(settingsVersionForPackage) == true) goto L25;
        if (ReconcilePackageUtils.isRecoverSignatureUpdateNeeded(settingsVersionForPackage) == true) goto L25;
        if (ps.getSigningDetails().getSignatures() != null) goto L19;
    L24:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "PackageSetting for " + ps.getPackageName() + " is missing signatures.  Collecting certs again to recover them.");
    L42:
        Trace.traceBegin(262144, "collectCertificates");     // Catch: Throwable -> L36
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();     // Catch: Throwable -> L36
        ParseResult<SigningDetails> result = ParsingPackageUtils.getSigningDetails(input, parsedPackage, skipVerify);     // Catch: Throwable -> L36
        if (result.isError() == true) goto L39;
        parsedPackage.setSigningDetails((SigningDetails) result.getResult());     // Catch: Throwable -> L36
        Trace.traceEnd(262144);
        return;
    L39:
        throw new PackageManagerException(result.getErrorCode(), result.getErrorMessage(), result.getException());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    L19:
        if (ps.getSigningDetails().getSignatures().length == 0) goto L24;
        if (ps.getSigningDetails().getSignatureSchemeVersion() == 0) goto L24;
        parsedPackage.setSigningDetails(new SigningDetails(ps.getSigningDetails()));
        return;
    L25:
        StringBuilder r3 = new StringBuilder();
        r3.append(parsedPackage.getPath());
        r3.append(" changed; collecting certs");
        if (forceCollect == false) goto L28;
        String r4 = " (forced)";
    L29:
        r3.append(r4);
        Slog.i(PackageManagerServiceMonitorEx.TAG, r3.toString());
        goto L42
    L28:
        r4 = "";
        goto L29
    L4:
        lastModifiedTime = PackageManagerServiceUtils.getLastModifiedTime(parsedPackage);
        goto L6
    }

    public static void setInstantAppForUser(PackageManagerServiceInjector injector, PackageSetting pkgSetting, int userId, boolean instantApp, boolean fullApp) {
        if (instantApp == true) goto L6;
        if (fullApp == true) goto L6;
        return;
    L6:
        if (userId == (-1)) goto L15;
        if (instantApp == true) goto L9;
    L11:
        if (fullApp == true) goto L13;
        return;
    L13:
        if (pkgSetting.getInstantApp(userId) == false) goto L35;
        pkgSetting.setInstantApp(false, userId);
        return;
    L35:
        return;
    L9:
        if (pkgSetting.getInstantApp(userId) == true) goto L11;
        pkgSetting.setInstantApp(true, userId);
        return;
    L15:
        int[] r0 = injector.getUserManagerInternal().getUserIds();
        int r3 = r0.length;
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L37;
        int currentUserId = r0[r4];
        if (instantApp == true) goto L21;
    L23:
        if (fullApp == false) goto L27;
        if (pkgSetting.getInstantApp(currentUserId) == false) goto L27;
        pkgSetting.setInstantApp(false, currentUserId);
    L27:
        r4 = r4 + 1;
        goto L17
    L21:
        if (pkgSetting.getInstantApp(currentUserId) == true) goto L23;
        pkgSetting.setInstantApp(true, currentUserId);
        goto L27
    }

    public static File getAppLib32InstallDir() {
        return new File(Environment.getDataDirectory(), "app-lib");
    }
}
