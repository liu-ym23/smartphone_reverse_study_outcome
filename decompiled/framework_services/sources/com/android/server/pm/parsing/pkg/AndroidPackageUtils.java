package com.android.server.pm.parsing.pkg;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.pm.dex.DexMetadataHelper;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.incremental.IncrementalManager;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.pm.parsing.PackageParserException;
import com.android.internal.pm.parsing.pkg.AndroidPackageHidden;
import com.android.internal.pm.parsing.pkg.PackageImpl;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.internal.pm.pkg.parsing.ParsingPackageHidden;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemConfig;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidPackageUtils {
    private AndroidPackageUtils() {
    }

    public static List<String> getAllCodePathsExcludingResourceOnly(AndroidPackage aPkg) {
        PackageImpl pkg = (PackageImpl) aPkg;
        ArrayList<String> paths = new ArrayList();
        if (pkg.isDeclaredHavingCode() == false) goto L5;
        paths.add(pkg.getBaseApkPath());
    L5:
        String[] splitCodePaths = pkg.getSplitCodePaths();
        if (ArrayUtils.isEmpty(splitCodePaths) == true) goto L14;
        int i = 0;
    L9:
        if (i >= splitCodePaths.length) goto L14;
        if ((pkg.getSplitFlags()[i] & 4) == 0) goto L13;
        paths.add(splitCodePaths[i]);
    L13:
        i = i + 1;
    L14:
        return paths;
    }

    public static List<String> getAllCodePaths(AndroidPackage aPkg) {
        PackageImpl pkg = (PackageImpl) aPkg;
        ArrayList<String> paths = new ArrayList();
        paths.add(pkg.getBaseApkPath());
        String[] splitCodePaths = pkg.getSplitCodePaths();
        if (ArrayUtils.isEmpty(splitCodePaths) == true) goto L5;
        Collections.addAll(paths, splitCodePaths);
    L5:
        return paths;
    }

    public static SharedLibraryInfo createSharedLibraryForSdk(AndroidPackage pkg) {
        return new SharedLibraryInfo(null, pkg.getPackageName(), getAllCodePaths(pkg), pkg.getSdkLibraryName(), pkg.getSdkLibVersionMajor(), 3, new VersionedPackage(pkg.getManifestPackageName(), pkg.getLongVersionCode()), null, null, false);
    }

    public static SharedLibraryInfo createSharedLibraryForStatic(AndroidPackage pkg) {
        return new SharedLibraryInfo(null, pkg.getPackageName(), getAllCodePaths(pkg), pkg.getStaticSharedLibraryName(), pkg.getStaticSharedLibraryVersion(), 2, new VersionedPackage(pkg.getManifestPackageName(), pkg.getLongVersionCode()), null, null, false);
    }

    public static SharedLibraryInfo createSharedLibraryForDynamic(AndroidPackage pkg, String name) {
        return new SharedLibraryInfo(null, pkg.getPackageName(), getAllCodePaths(pkg), name, -1, 1, new VersionedPackage(pkg.getPackageName(), pkg.getLongVersionCode()), null, null, false);
    }

    public static Map<String, String> getPackageDexMetadata(AndroidPackage pkg) {
        return DexMetadataHelper.buildPackageApkToDexMetadataMap(getAllCodePaths(pkg));
    }

    public static void validatePackageDexMetadata(AndroidPackage pkg) throws PackageParserException {
        Collection<String> apkToDexMetadataList = getPackageDexMetadata(pkg).values();
        String packageName = pkg.getPackageName();
        long versionCode = pkg.getLongVersionCode();
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        Iterator<String> r5 = apkToDexMetadataList.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        String dexMetadata = r5.next();
        ParseResult result = DexMetadataHelper.validateDexMetadataFile(input.reset(), dexMetadata, packageName, versionCode);
        if (result.isError() == false) goto L4;
        throw new PackageParserException(result.getErrorCode(), result.getErrorMessage(), result.getException());
    }

    public static NativeLibraryHelper.Handle createNativeLibraryHandle(AndroidPackage pkg) throws IOException {
        if (pkg.getPageSizeAppCompatFlags() != 64) goto L5;
        boolean pageSizeCompatDisabled = true;
    L7:
        return NativeLibraryHelper.Handle.create(getAllCodePaths(pkg), pkg.isMultiArch(), pkg.isExtractNativeLibrariesRequested(), pkg.isDebuggable(), pageSizeCompatDisabled);
    L5:
        pageSizeCompatDisabled = false;
        goto L7
    }

    public static boolean canHaveOatDir(PackageState packageState, AndroidPackage pkg) {
        if (packageState.isSystem() == false) goto L8;
        if (packageState.isUpdatedSystemApp() == true) goto L8;
        return false;
    L8:
        if (IncrementalManager.isIncrementalPath(pkg.getPath()) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean hasComponentClassName(AndroidPackage pkg, String className) {
        List<ParsedActivity> activities = pkg.getActivities();
        int activitiesSize = activities.size();
        int index = 0;
    L4:
        if (index >= activitiesSize) goto L9;
        if (Objects.equals(className, activities.get(index).getName()) == true) goto L7;
        index = index + 1;
        goto L4
    L7:
        return true;
    L9:
        List<ParsedActivity> receivers = pkg.getReceivers();
        int receiversSize = receivers.size();
        int index2 = 0;
    L10:
        if (index2 >= receiversSize) goto L15;
        if (Objects.equals(className, receivers.get(index2).getName()) == true) goto L13;
        index2 = index2 + 1;
        goto L10
    L13:
        return true;
    L15:
        List<ParsedProvider> providers = pkg.getProviders();
        int providersSize = providers.size();
        int index3 = 0;
    L16:
        if (index3 >= providersSize) goto L21;
        if (Objects.equals(className, providers.get(index3).getName()) == true) goto L19;
        index3 = index3 + 1;
        goto L16
    L19:
        return true;
    L21:
        List<ParsedService> services = pkg.getServices();
        int servicesSize = services.size();
        int index4 = 0;
    L22:
        if (index4 >= servicesSize) goto L27;
        if (Objects.equals(className, services.get(index4).getName()) == true) goto L25;
        index4 = index4 + 1;
        goto L22
    L25:
        return true;
    L27:
        List<ParsedInstrumentation> instrumentations = pkg.getInstrumentations();
        int instrumentationsSize = instrumentations.size();
        int index5 = 0;
    L28:
        if (index5 >= instrumentationsSize) goto L34;
        if (Objects.equals(className, instrumentations.get(index5).getName()) == true) goto L31;
        index5 = index5 + 1;
        goto L28
    L31:
        return true;
    L34:
        if (pkg.getBackupAgentName() != null) goto L36;
        return false;
    L36:
        if (Objects.equals(className, pkg.getBackupAgentName()) == false) goto L50;
        return true;
    L50:
        return false;
    }

    public static boolean isEncryptionAware(AndroidPackage pkg) {
        if (pkg.isDirectBootAware() == false) goto L5;
    L8:
        return true;
    L5:
        if (pkg.isPartiallyDirectBootAware() == true) goto L8;
        return false;
    }

    public static boolean isLibrary(AndroidPackage pkg) {
        if (pkg.getSdkLibraryName() == null) goto L5;
    L10:
        return true;
    L5:
        if (pkg.getStaticSharedLibraryName() != null) goto L10;
        if (pkg.getLibraryNames().isEmpty() == false) goto L10;
        return false;
    }

    public static int getHiddenApiEnforcementPolicy(AndroidPackage pkg, PackageStateInternal packageState) {
        if (pkg != null) goto L5;
        boolean isAllowedToUseHiddenApis = false;
    L19:
        if (isAllowedToUseHiddenApis == false) goto L21;
        return 0;
    L21:
        return 2;
    L5:
        boolean isAllowedToUseHiddenApis2 = pkg.isSignedWithPlatformKey();
        if (isAllowedToUseHiddenApis2 == false) goto L8;
        isAllowedToUseHiddenApis = true;
        goto L19
    L8:
        boolean isAllowedToUseHiddenApis3 = packageState.isSystem();
        if (isAllowedToUseHiddenApis3 == true) goto L11;
        isAllowedToUseHiddenApis = false;
        goto L19
    L11:
        if (pkg.isNonSdkApiRequested() == false) goto L13;
    L16:
        isAllowedToUseHiddenApis = true;
        goto L19
    L13:
        if (SystemConfig.getInstance().getHiddenApiWhitelistedApps().contains(pkg.getPackageName()) == true) goto L16;
        isAllowedToUseHiddenApis = false;
        goto L19
    }

    public static boolean isMatchForSystemOnly(PackageState packageState, long flags) {
        if ((DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES & flags) != 0) goto L5;
        return true;
    L5:
        return packageState.isSystem();
    }

    public static String getRawPrimaryCpuAbi(AndroidPackage pkg) {
        return ((AndroidPackageHidden) pkg).getPrimaryCpuAbi();
    }

    public static String getRawSecondaryCpuAbi(AndroidPackage pkg) {
        return ((AndroidPackageHidden) pkg).getSecondaryCpuAbi();
    }

    @Deprecated
    public static ApplicationInfo generateAppInfoWithoutState(AndroidPackage pkg) {
        return ((AndroidPackageHidden) pkg).toAppInfoWithoutState();
    }

    public static String getRealPackageOrNull(AndroidPackage pkg, boolean isSystem) {
        if (pkg.getOriginalPackages().isEmpty() == true) goto L8;
        if (isSystem == true) goto L7;
        return null;
    L7:
        return pkg.getManifestPackageName();
    L8:
        return null;
    }

    public static void fillVersionCodes(AndroidPackage pkg, PackageInfo info) {
        info.versionCode = ((ParsingPackageHidden) pkg).getVersionCode();
        info.versionCodeMajor = ((ParsingPackageHidden) pkg).getVersionCodeMajor();
    }
}
