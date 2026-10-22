package com.android.server.pm;

import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.os.Build;
import android.os.SystemProperties;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.server.SystemConfig;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.utils.WatchedLongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ReconcilePackageUtils {
    private static final boolean ALLOW_NON_PRELOADS_SYSTEM_SHAREDUIDS = false;

    ReconcilePackageUtils() {
    }

    static {
        if (Build.IS_DEBUGGABLE == true) goto L5;
        boolean r0 = false;
    L6:
        ALLOW_NON_PRELOADS_SYSTEM_SHAREDUIDS = r0;
        return;
    L5:
        r0 = true;
        goto L6
    }

    public static List<ReconciledPackage> reconcilePackages(List<InstallRequest> installRequests, Map<String, AndroidPackage> allPackages, Map<String, Settings.VersionInfo> versionInfos, SharedLibrariesImpl sharedLibraries, KeySetManagerService ksms, Settings settings, SystemConfig systemConfig) throws ReconcileFailure {
        List<ReconciledPackage> result = new ArrayList(installRequests.size());
        ArrayMap<String, AndroidPackage> combinedPackages = new ArrayMap(allPackages.size() + installRequests.size());
        combinedPackages.putAll(allPackages);
        Map<String, WatchedLongSparseArray<SharedLibraryInfo>> incomingSharedLibraries = new ArrayMap();
        Iterator<InstallRequest> r0 = installRequests.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        InstallRequest installRequest = r0.next();
        installRequest.onReconcileStarted();
        combinedPackages.put(installRequest.getScannedPackageSetting().getPackageName(), installRequest.getParsedPackage());
        List<SharedLibraryInfo> allowedSharedLibInfos = sharedLibraries.getAllowedSharedLibInfos(installRequest);
        if (allowedSharedLibInfos == null) goto L4;
        Iterator<SharedLibraryInfo> r4 = allowedSharedLibInfos.iterator();
    L9:
        if (r4.hasNext() == false) goto L4;
        SharedLibraryInfo info = r4.next();
        if (SharedLibraryUtils.addSharedLibraryToPackageVersionMap(incomingSharedLibraries, info) == true) goto L9;
        throw ReconcileFailure.ofInternalError("Shared Library " + info.getName() + " is being installed twice in this set!", -6);
    L16:
        AndroidPackage systemPackage = allPackages.get(PackageManagerService.PLATFORM_PACKAGE_NAME);
        Iterator<InstallRequest> r16 = installRequests.iterator();
    L18:
        if (r16.hasNext() == false) goto L190;
        InstallRequest installRequest2 = r16.next();
        String installPackageName = installRequest2.getParsedPackage().getPackageName();
        List<SharedLibraryInfo> allowedSharedLibInfos2 = sharedLibraries.getAllowedSharedLibInfos(installRequest2);
        PackageSetting r5 = null;
        if (installRequest2.isInstallReplace() == true) goto L22;
    L36:
        DeletePackageAction deletePackageAction = null;
    L37:
        int scanFlags = installRequest2.getScanFlags();
        int parseFlags = installRequest2.getParseFlags();
        ParsedPackage parsedPackage = installRequest2.getParsedPackage();
        PackageSetting disabledPkgSetting = installRequest2.getDisabledPackageSetting();
        if (installRequest2.getStaticSharedLibraryInfo() == null) goto L41;
        r5 = sharedLibraries.getStaticSharedLibLatestVersionSetting(installRequest2);
    L41:
        PackageSetting lastStaticSharedLibSetting = r5;
        if (lastStaticSharedLibSetting == null) goto L44;
        PackageSetting r20 = lastStaticSharedLibSetting;
    L45:
        PackageSetting signatureCheckPs = r20;
        boolean removeAppKeySetData = false;
        boolean sharedUserSignaturesChanged = false;
        if (parsedPackage == null) goto L48;
        SigningDetails signingDetails = parsedPackage.getSigningDetails();
        SigningDetails signingDetails2 = signingDetails;
    L50:
        if ((parseFlags & 16) == 0) goto L52;
        boolean r1 = true;
    L53:
        boolean isSystemPackage = r1;
        if ((67108864 & scanFlags) == 0) goto L56;
        boolean isApex = true;
    L57:
        AndroidPackage systemPackage2 = systemPackage;
        SharedUserSetting sharedUserSetting = settings.getSharedUserSettingLPr(signatureCheckPs);
        if (ksms.shouldCheckUpgradeKeySetLocked(signatureCheckPs, sharedUserSetting, scanFlags) == false) goto L199;
        if (ksms.checkUpgradeKeySetLocked(signatureCheckPs, parsedPackage) == true) goto L64;
        if (isSystemPackage == false) goto L66;
        PackageManagerService.reportSettingsProblem(5, "System package " + parsedPackage.getPackageName() + " signature changed; retaining data.");
        goto L64
    L66:
        throw new ReconcileFailure(-7, "Package " + parsedPackage.getPackageName() + " upgrade keys do not match the previously installed version");
    L64:
        deletePackageAction = deletePackageAction;
        SigningDetails signingDetails3 = signingDetails2;
        List<SharedLibraryInfo> allowedSharedLibInfos3 = allowedSharedLibInfos2;
    L178:
        DeletePackageAction deletePackageAction2 = deletePackageAction;
        ReconciledPackage reconciledPackage = new ReconciledPackage(installRequests, allPackages, installRequest2, deletePackageAction2, allowedSharedLibInfos3, signingDetails3, sharedUserSignaturesChanged, removeAppKeySetData);
        if ((installRequest2.getScanFlags() & 16) != 0) goto L187;
        if ((installRequest2.getParseFlags() & 16) != 0) goto L187;
        reconciledPackage.mCollectedSharedLibraryInfos = sharedLibraries.collectSharedLibraryInfos(installRequest2.getParsedPackage(), combinedPackages, incomingSharedLibraries);     // Catch: PackageManagerException -> L184
    L184:
        e = move-exception;
        throw new ReconcileFailure(e.error, e.getMessage());
    L187:
        installRequest2.onReconcileFinished();
        result.add(reconciledPackage);
        systemPackage = systemPackage2;
        goto L18
    L199:
        Settings.VersionInfo versionInfo = versionInfos.get(installPackageName);     // Catch: IllegalArgumentException -> L156 PackageManagerException -> L158
        boolean compareCompat = isCompatSignatureUpdateNeeded(versionInfo);     // Catch: IllegalArgumentException -> L156 PackageManagerException -> L158
        boolean compareRecover = isRecoverSignatureUpdateNeeded(versionInfo);     // Catch: IllegalArgumentException -> L156 PackageManagerException -> L158
        boolean isRollback = installRequest2.isRollback();     // Catch: IllegalArgumentException -> L156 PackageManagerException -> L158
        boolean compatMatch = PackageManagerServiceUtils.verifySignatures(signatureCheckPs, sharedUserSetting, disabledPkgSetting, signingDetails2, compareCompat, compareRecover, isRollback);     // Catch: IllegalArgumentException -> L156 PackageManagerException -> L158
        SharedUserSetting sharedUserSetting2 = sharedUserSetting;
        SigningDetails signingDetails4 = signingDetails2;
        if (compatMatch == false) goto L205;
        removeAppKeySetData = true;
    L205:
    L74:
        if ((installRequest2.getScanFlags() & 16) == 0) goto L197;
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
    L121:
        if (sharedUserSetting2 != null) goto L201;
        SigningDetails signingDetails5 = signingDetails4;
    L151:
        signingDetails3 = signingDetails5;
        goto L178
    L201:
        SigningDetails sharedSigningDetails = sharedUserSetting2.signatures.mSigningDetails;     // Catch: IllegalArgumentException -> L138 PackageManagerException -> L140
        SigningDetails mergedDetails = sharedSigningDetails.mergeLineageWith(signingDetails4);     // Catch: IllegalArgumentException -> L138 PackageManagerException -> L140
        if (mergedDetails == sharedSigningDetails) goto L145;
        Iterator<AndroidPackage> r6 = sharedUserSetting2.getPackages().iterator();     // Catch: IllegalArgumentException -> L138 PackageManagerException -> L140
    L126:
        if (r6.hasNext() == false) goto L144;
        AndroidPackage androidPackage = r6.next();     // Catch: IllegalArgumentException -> L138 PackageManagerException -> L140
        if (androidPackage.getPackageName() == null) goto L142;
        SigningDetails sharedSigningDetails2 = sharedSigningDetails;
        SigningDetails signingDetails6 = signingDetails4;
        if (androidPackage.getPackageName().equals(parsedPackage.getPackageName()) == true) goto L143;
        mergedDetails = mergedDetails.mergeLineageWith(androidPackage.getSigningDetails(), 2);     // Catch: IllegalArgumentException -> L134 PackageManagerException -> L136
    L143:
        sharedSigningDetails = sharedSigningDetails2;
        signingDetails4 = signingDetails6;
        goto L126
    L136:
        e = e;
    L163:
        if (isSystemPackage == false) goto L189;
        SigningDetails signingDetails7 = parsedPackage.getSigningDetails();
        if (sharedUserSetting2 != null) goto L167;
    L177:
        PackageManagerService.reportSettingsProblem(5, "System package " + parsedPackage.getPackageName() + " signature changed; retaining data.");
        signingDetails3 = signingDetails7;
        goto L178
    L167:
        if (sharedUserSetting2.signaturesChanged != null) goto L169;
    L176:
        sharedUserSignaturesChanged = true;
        sharedUserSetting2.signatures.mSigningDetails = parsedPackage.getSigningDetails();
        sharedUserSetting2.signaturesChanged = Boolean.TRUE;
        goto L177
    L169:
        if (PackageManagerServiceUtils.canJoinSharedUserId(parsedPackage.getPackageName(), parsedPackage.getSigningDetails(), sharedUserSetting2, 2) == true) goto L176;
        if (SystemProperties.getInt("ro.product.first_api_level", 0) > 29) goto L175;
        throw new ReconcileFailure(-104, "Signature mismatch for shared user: " + sharedUserSetting2);
    L175:
        throw new IllegalStateException("Signature mismatch on system package " + parsedPackage.getPackageName() + " for shared user " + sharedUserSetting2);
    L189:
        throw new ReconcileFailure(e);
    L134:
        e = e;
    L161:
        throw new RuntimeException("Signing certificates comparison made on incomparable signing details but somehow passed verifySignatures!", e);
    L142:
        sharedSigningDetails2 = sharedSigningDetails;
        signingDetails6 = signingDetails4;
        goto L143
    L144:
        signingDetails5 = signingDetails4;
        sharedUserSetting2.signatures.mSigningDetails = mergedDetails;     // Catch: IllegalArgumentException -> L134 PackageManagerException -> L136
    L147:
        if (sharedUserSetting2.signaturesChanged != null) goto L151;
        sharedUserSetting2.signaturesChanged = Boolean.FALSE;     // Catch: IllegalArgumentException -> L134 PackageManagerException -> L136
        goto L151
    L145:
        signingDetails5 = signingDetails4;
    L140:
        e = e;
    L138:
        e = e;
        goto L161
    L197:
    L114:
        e = e;
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
        deletePackageAction = deletePackageAction;
    L112:
        e = e;
        goto L161
    L76:
        if (installRequest2.isInstallSystem() == true) goto L119;
        if (isSystemPackage == true) goto L119;
        if (isApex == true) goto L119;
        if (signingDetails4 == null) goto L119;
        if (systemPackage2 == null) goto L119;
        if (systemPackage2.getSigningDetails() != null) goto L84;
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
        goto L121
    L84:
        if (systemPackage2.getSigningDetails().checkCapability(signingDetails4, 4) == false) goto L117;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Non-preload app associated with system signature: " + signatureCheckPs.getPackageName());     // Catch: IllegalArgumentException -> L112 PackageManagerException -> L114
        if (sharedUserSetting2 != null) goto L88;
    L116:
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
        goto L121
    L88:
        if (ALLOW_NON_PRELOADS_SYSTEM_SHAREDUIDS == true) goto L116;
        ArrayMap<String, String> allowList = systemConfig.getPackageToSharedUidAllowList();     // Catch: IllegalArgumentException -> L112 PackageManagerException -> L114
        String sharedUidName = allowList.get(signatureCheckPs.getPackageName());     // Catch: IllegalArgumentException -> L112 PackageManagerException -> L114
        if (sharedUidName == null) goto L99;
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
        if (sharedUserSetting2.name.equals(sharedUidName) == true) goto L121;
    L195:
        String msg = "Non-preload app " + signatureCheckPs.getPackageName() + " signed with platform signature and joining shared uid: " + sharedUserSetting2.name;     // Catch: IllegalArgumentException -> L108 PackageManagerException -> L110
        StringBuilder r7 = new StringBuilder();     // Catch: IllegalArgumentException -> L108 PackageManagerException -> L110
        r7.append(msg);     // Catch: IllegalArgumentException -> L108 PackageManagerException -> L110
        deletePackageAction = deletePackageAction;
        r7.append(", allowList: ");     // Catch: IllegalArgumentException -> L104 PackageManagerException -> L106
        r7.append(allowList);     // Catch: IllegalArgumentException -> L104 PackageManagerException -> L106
        Slog.e(PackageManagerServiceMonitorEx.TAG, r7.toString());     // Catch: IllegalArgumentException -> L104 PackageManagerException -> L106
        throw new ReconcileFailure(-107, msg);     // Catch: IllegalArgumentException -> L104 PackageManagerException -> L106
    L106:
        e = e;
    L104:
        e = e;
        goto L161
    L110:
        e = e;
        deletePackageAction = deletePackageAction;
    L108:
        e = e;
        goto L161
    L97:
        e = e;
        deletePackageAction = deletePackageAction;
    L95:
        e = e;
        goto L161
    L99:
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
        goto L195
    L117:
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
    L119:
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
    L154:
        e = e;
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
        deletePackageAction = deletePackageAction;
    L152:
        e = e;
        goto L161
    L158:
        e = e;
        deletePackageAction = deletePackageAction;
        sharedUserSetting2 = sharedUserSetting;
        allowedSharedLibInfos3 = allowedSharedLibInfos2;
    L156:
        e = e;
        goto L161
    L56:
        isApex = false;
        goto L57
    L52:
        r1 = false;
        goto L53
    L48:
        signingDetails2 = null;
        goto L50
    L44:
        r20 = installRequest2.getScannedPackageSetting();
        goto L45
    L22:
        if (installRequest2.isInstallSystem() == true) goto L36;
        if ((installRequest2.getScanFlags() & 1024) != 0) goto L26;
        boolean killApp = true;
    L28:
        if (killApp == false) goto L30;
        int r8 = 0;
    L31:
        int deleteFlags = r8 | 1;
        DeletePackageAction deletePackageAction3 = DeletePackageHelper.mayDeletePackageLocked(installRequest2.getRemovedInfo(), installRequest2.getOriginalPackageSetting(), installRequest2.getDisabledPackageSetting(), deleteFlags, null);
        if (deletePackageAction3 == null) goto L35;
        deletePackageAction = deletePackageAction3;
        goto L37
    L35:
        throw new ReconcileFailure(-10, "May not delete " + installPackageName + " to replace");
    L30:
        r8 = 8;
        goto L31
    L26:
        killApp = false;
        goto L28
    L190:
        return result;
    }

    public static boolean isCompatSignatureUpdateNeeded(Settings.VersionInfo ver) {
        if (ver.databaseVersion >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isRecoverSignatureUpdateNeeded(Settings.VersionInfo ver) {
        if (ver.databaseVersion >= 3) goto L5;
        return true;
    L5:
        return false;
    }
}
