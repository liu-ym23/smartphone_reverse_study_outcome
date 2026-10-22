package com.android.server.pm;

import android.content.pm.parsing.ApkLiteParseUtils;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.incremental.IncrementalManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.util.ArrayUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
final class PackageAbiHelperImpl implements PackageAbiHelper {
    private static String[] sNativelySupported32BitAbis;
    private static String[] sNativelySupported64BitAbis;

    PackageAbiHelperImpl() {
    }

    static {
        sNativelySupported32BitAbis = null;
        sNativelySupported64BitAbis = null;
    }

    private static String calculateBundledApkRoot(String codePathString) {
        File codePath = new File(codePathString);
        if (FileUtils.contains(Environment.getRootDirectory(), codePath) == false) goto L5;
        File f = Environment.getRootDirectory();
    L37:
        return f.getPath();
    L5:
        File codeRoot = Environment.getOemDirectory();
        if (FileUtils.contains(codeRoot, codePath) == false) goto L8;
        f = Environment.getOemDirectory();
        goto L37
    L8:
        File codeRoot2 = Environment.getVendorDirectory();
        if (FileUtils.contains(codeRoot2, codePath) == false) goto L11;
        f = Environment.getVendorDirectory();
        goto L37
    L11:
        File codeRoot3 = Environment.getOdmDirectory();
        if (FileUtils.contains(codeRoot3, codePath) == false) goto L14;
        f = Environment.getOdmDirectory();
        goto L37
    L14:
        File codeRoot4 = Environment.getProductDirectory();
        if (FileUtils.contains(codeRoot4, codePath) == false) goto L17;
        f = Environment.getProductDirectory();
        goto L37
    L17:
        File codeRoot5 = Environment.getSystemExtDirectory();
        if (FileUtils.contains(codeRoot5, codePath) == false) goto L20;
        f = Environment.getSystemExtDirectory();
        goto L37
    L20:
        File codeRoot6 = Environment.getOdmDirectory();
        if (FileUtils.contains(codeRoot6, codePath) == false) goto L23;
        f = Environment.getOdmDirectory();
        goto L37
    L23:
        File codeRoot7 = Environment.getApexDirectory();
        if (FileUtils.contains(codeRoot7, codePath) == false) goto L41;
        String fullPath = codePath.getAbsolutePath();
        String[] parts = fullPath.split(File.separator);
        if (parts.length <= 2) goto L28;
        f = new File(parts[1] + File.separator + parts[2]);
        goto L37
    L28:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Can't canonicalize code path " + codePath);
        f = Environment.getApexDirectory();
        goto L37
    L41:
        File f2 = codePath.getCanonicalFile();     // Catch: IOException -> L38
        File parent = f2.getParentFile();     // Catch: IOException -> L38
    L31:
        File tmp = parent.getParentFile();     // Catch: IOException -> L38
        if (tmp == null) goto L34;
        f2 = parent;
        parent = tmp;
        goto L31
    L34:
        File codeRoot8 = f2;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unrecognized code path " + codePath + " - using " + codeRoot8);     // Catch: IOException -> L38
        f = codeRoot8;
    L39:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Can't canonicalize code path " + codePath);
        return Environment.getRootDirectory().getPath();
    }

    private static String deriveCodePathName(String codePath) {
        if (codePath != null) goto L5;
        return null;
    L5:
        File codeFile = new File(codePath);
        String name = codeFile.getName();
        if (codeFile.isDirectory() == false) goto L9;
        return name;
    L9:
        if (name.endsWith(".apk") == false) goto L11;
    L15:
        int lastDot = name.lastIndexOf(46);
        return name.substring(0, lastDot);
    L11:
        if (name.endsWith(".tmp") == true) goto L15;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Odd, " + codePath + " doesn't look like an APK");
        return null;
    }

    private static void maybeThrowExceptionForMultiArchCopy(String message, int copyRet, boolean forceMatch) throws PackageManagerException {
        if (copyRet < 0) goto L4;
        return;
    L4:
        if (copyRet == (-114)) goto L9;
        if (copyRet == (-113)) goto L9;
        throw new PackageManagerException(copyRet, message);
    L9:
        if (forceMatch == false) goto L15;
        if (copyRet == (-113)) goto L13;
        return;
    L13:
        throw new PackageManagerException(-131, "The multiArch app's native libs don't support all the natively supported ABIs of the device.");
    }

    @Override // com.android.server.pm.PackageAbiHelper
    public PackageAbiHelper.NativeLibraryPaths deriveNativeLibraryPaths(AndroidPackage pkg, boolean isSystemApp, boolean isUpdatedSystemApp, File appLib32InstallDir) {
        return deriveNativeLibraryPaths(new PackageAbiHelper.Abis(AndroidPackageUtils.getRawPrimaryCpuAbi(pkg), AndroidPackageUtils.getRawSecondaryCpuAbi(pkg)), appLib32InstallDir, pkg.getPath(), pkg.getBaseApkPath(), isSystemApp, isUpdatedSystemApp);
    }

    private static PackageAbiHelper.NativeLibraryPaths deriveNativeLibraryPaths(PackageAbiHelper.Abis abis, File appLib32InstallDir, String codePath, String sourceDir, boolean isSystemApp, boolean isUpdatedSystemApp) {
        File codeFile = new File(codePath);
        if (isSystemApp == false) goto L6;
        if (isUpdatedSystemApp == true) goto L6;
        boolean bundledApp = true;
    L7:
        String secondaryLibDir = "lib";
        if (ApkLiteParseUtils.isApkFile(codeFile) == false) goto L24;
        if (bundledApp == false) goto L22;
        String apkRoot = calculateBundledApkRoot(sourceDir);
        boolean is64Bit = VMRuntime.is64BitInstructionSet(InstructionSets.getPrimaryInstructionSet(abis));
        String apkName = deriveCodePathName(codePath);
        if (is64Bit == false) goto L13;
        String libDir = "lib64";
    L14:
        String nativeLibraryRootDir = Environment.buildPath(new File(apkRoot), new String[]{libDir, apkName}).getAbsolutePath();
        if (abis.secondary == null) goto L20;
        if (is64Bit == true) goto L19;
        secondaryLibDir = "lib64";
    L19:
        String secondaryLibDir2 = Environment.buildPath(new File(apkRoot), new String[]{secondaryLibDir, apkName}).getAbsolutePath();
    L23:
        boolean nativeLibraryRootRequiresIsa = false;
        String nativeLibraryDir = nativeLibraryRootDir;
    L29:
        return new PackageAbiHelper.NativeLibraryPaths(nativeLibraryRootDir, nativeLibraryRootRequiresIsa, nativeLibraryDir, secondaryLibDir2);
    L20:
        secondaryLibDir2 = null;
        goto L23
    L13:
        libDir = "lib";
        goto L14
    L22:
        nativeLibraryRootDir = new File(appLib32InstallDir, deriveCodePathName(codePath)).getAbsolutePath();
        secondaryLibDir2 = null;
        goto L23
    L24:
        nativeLibraryRootDir = new File(codeFile, "lib").getAbsolutePath();
        nativeLibraryRootRequiresIsa = true;
        nativeLibraryDir = new File(nativeLibraryRootDir, InstructionSets.getPrimaryInstructionSet(abis)).getAbsolutePath();
        if (abis.secondary == null) goto L27;
        secondaryLibDir2 = new File(nativeLibraryRootDir, VMRuntime.getInstructionSet(abis.secondary)).getAbsolutePath();
        goto L29
    L27:
        secondaryLibDir2 = null;
    L6:
        bundledApp = false;
        goto L7
    }

    @Override // com.android.server.pm.PackageAbiHelper
    public PackageAbiHelper.Abis getBundledAppAbis(AndroidPackage pkg) {
        String apkName = deriveCodePathName(pkg.getPath());
        String apkRoot = calculateBundledApkRoot(pkg.getBaseApkPath());
        PackageAbiHelper.Abis abis = getBundledAppAbi(pkg, apkRoot, apkName);
        return abis;
    }

    private PackageAbiHelper.Abis getBundledAppAbi(AndroidPackage pkg, String apkRoot, String apkName) {
        File codeFile = new File(pkg.getPath());
        if (ApkLiteParseUtils.isApkFile(codeFile) == false) goto L5;
        boolean has64BitLibs = new File(apkRoot, new File("lib64", apkName).getPath()).exists();
        boolean has64BitLibs2 = new File(apkRoot, new File("lib", apkName).getPath()).exists();
    L17:
        if (has64BitLibs == false) goto L20;
        if (has64BitLibs2 == true) goto L20;
        String primaryCpuAbi = Build.SUPPORTED_64_BIT_ABIS[0];
        String secondaryCpuAbi = null;
    L34:
        return new PackageAbiHelper.Abis(primaryCpuAbi, secondaryCpuAbi);
    L20:
        if (has64BitLibs2 == false) goto L23;
        if (has64BitLibs == true) goto L23;
        primaryCpuAbi = Build.SUPPORTED_32_BIT_ABIS[0];
        secondaryCpuAbi = null;
    L23:
        if (has64BitLibs2 == false) goto L32;
        if (has64BitLibs == false) goto L32;
        if (pkg.isMultiArch() == true) goto L29;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Package " + pkg + " has multiple bundled libs, but is not multiarch.");
    L29:
        if (VMRuntime.is64BitInstructionSet(InstructionSets.getPreferredInstructionSet()) == false) goto L31;
        String primaryCpuAbi2 = Build.SUPPORTED_64_BIT_ABIS[0];
        secondaryCpuAbi = Build.SUPPORTED_32_BIT_ABIS[0];
        primaryCpuAbi = primaryCpuAbi2;
        goto L34
    L31:
        String primaryCpuAbi3 = Build.SUPPORTED_32_BIT_ABIS[0];
        secondaryCpuAbi = Build.SUPPORTED_64_BIT_ABIS[0];
        primaryCpuAbi = primaryCpuAbi3;
    L32:
        primaryCpuAbi = null;
        secondaryCpuAbi = null;
        goto L34
    L5:
        File rootDir = new File(codeFile, "lib");
        if (ArrayUtils.isEmpty(Build.SUPPORTED_64_BIT_ABIS) == false) goto L8;
    L10:
        boolean has64BitLibs3 = false;
    L12:
        if (ArrayUtils.isEmpty(Build.SUPPORTED_32_BIT_ABIS) == false) goto L14;
    L16:
        has64BitLibs = has64BitLibs3;
        has64BitLibs2 = false;
        goto L17
    L14:
        if (TextUtils.isEmpty(Build.SUPPORTED_32_BIT_ABIS[0]) == true) goto L16;
        String isa = VMRuntime.getInstructionSet(Build.SUPPORTED_32_BIT_ABIS[0]);
        boolean has32BitLibs = new File(rootDir, isa).exists();
        has64BitLibs = has64BitLibs3;
        has64BitLibs2 = has32BitLibs;
        goto L17
    L8:
        if (TextUtils.isEmpty(Build.SUPPORTED_64_BIT_ABIS[0]) == true) goto L10;
        String isa2 = VMRuntime.getInstructionSet(Build.SUPPORTED_64_BIT_ABIS[0]);
        has64BitLibs3 = new File(rootDir, isa2).exists();
        goto L12
    }

    private static String[] getNativelySupportedAbis(String[] supportedAbis) {
        List<String> nativelySupportedAbis = new ArrayList();
        int i = 0;
    L4:
        if (i >= supportedAbis.length) goto L10;
        String currentAbi = supportedAbis[i];
        String currentIsa = VMRuntime.getInstructionSet(currentAbi);
        if (TextUtils.isEmpty(SystemProperties.get("ro.dalvik.vm.isa." + currentIsa)) == false) goto L8;
        nativelySupportedAbis.add(currentAbi);
    L8:
        i = i + 1;
        goto L4
    L10:
        return (String[]) nativelySupportedAbis.toArray(new String[0]);
    }

    private static String[] getNativelySupported32BitAbis() {
        if (sNativelySupported32BitAbis != null) goto L5;
        sNativelySupported32BitAbis = getNativelySupportedAbis(Build.SUPPORTED_32_BIT_ABIS);
        return sNativelySupported32BitAbis;
    L5:
        return sNativelySupported32BitAbis;
    }

    private static String[] getNativelySupported64BitAbis() {
        if (sNativelySupported64BitAbis != null) goto L5;
        sNativelySupported64BitAbis = getNativelySupportedAbis(Build.SUPPORTED_64_BIT_ABIS);
        return sNativelySupported64BitAbis;
    L5:
        return sNativelySupported64BitAbis;
    }

    /* JADX WARN: Not initialized variable reg: 22, insn: 0x010f: MOVE (r4 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('primaryCpuAbi' java.lang.String)]), block:B:68:0x010f */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0116: MOVE (r4 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('primaryCpuAbi' java.lang.String)]), block:B:70:0x0116 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0111: MOVE (r5 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('secondaryCpuAbi' java.lang.String)]), block:B:68:0x010f */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0118: MOVE (r5 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('secondaryCpuAbi' java.lang.String)]), block:B:70:0x0116 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // com.android.server.pm.PackageAbiHelper
    public Pair<PackageAbiHelper.Abis, PackageAbiHelper.NativeLibraryPaths> derivePackageAbi(AndroidPackage pkg, boolean isSystemApp, boolean isUpdatedSystemApp, String cpuAbiOverride, File appLib32InstallDir) throws PackageManagerException {
        String pkgRawPrimaryCpuAbi = AndroidPackageUtils.getRawPrimaryCpuAbi(pkg);
        String pkgRawSecondaryCpuAbi = AndroidPackageUtils.getRawSecondaryCpuAbi(pkg);
        PackageAbiHelper.NativeLibraryPaths initialLibraryPaths = deriveNativeLibraryPaths(new PackageAbiHelper.Abis(pkgRawPrimaryCpuAbi, pkgRawSecondaryCpuAbi), appLib32InstallDir, pkg.getPath(), pkg.getBaseApkPath(), isSystemApp, isUpdatedSystemApp);
        boolean extractLibs = shouldExtractLibs(pkg, isSystemApp, isUpdatedSystemApp);
        String nativeLibraryRootStr = initialLibraryPaths.nativeLibraryRootDir;
        boolean useIsaSpecificSubdirs = initialLibraryPaths.nativeLibraryRootRequiresIsa;
        boolean onIncremental = IncrementalManager.isIncrementalPath(pkg.getPath());
        String primaryCpuAbi = null;
        String secondaryCpuAbi = null;
        NativeLibraryHelper.Handle handle = null;
        handle = AndroidPackageUtils.createNativeLibraryHandle(pkg);     // Catch: Throwable -> L154 IOException -> L156
        File nativeLibraryRoot = new File(nativeLibraryRootStr);     // Catch: Throwable -> L154 IOException -> L156
        primaryCpuAbi = null;
        secondaryCpuAbi = null;
    L114:
        ioe = e;
    L159:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Unable to get canonical file " + ioe.toString());     // Catch: Throwable -> L41
    L153:
        IoUtils.closeQuietly(handle);
        PackageAbiHelper.Abis abis = new PackageAbiHelper.Abis(primaryCpuAbi, secondaryCpuAbi);
        return new Pair(abis, deriveNativeLibraryPaths(abis, appLib32InstallDir, pkg.getPath(), pkg.getBaseApkPath(), isSystemApp, isUpdatedSystemApp));
    L112:
        th = th;
    L163:
        IoUtils.closeQuietly(handle);
        throw th;
    L171:
        if (pkg.isMultiArch() == false) goto L117;
        if (pkg.getTargetSdkVersion() < 35) goto L13;
        if (cpuAbiOverride != null) goto L13;
        boolean forceMatch = true;
    L14:
        if (forceMatch == true) goto L169;
        String[] supported32BitAbis = Build.SUPPORTED_32_BIT_ABIS;     // Catch: Throwable -> L112 IOException -> L114
    L23:
        if (forceMatch == false) goto L26;
        String[] r19 = getNativelySupported64BitAbis();     // Catch: Throwable -> L17 IOException -> L19
    L27:
        String[] supported64BitAbis = r19;
        if (supported32BitAbis.length <= 0) goto L30;
        boolean systemSupports32BitAbi = true;
    L172:
        if (supported64BitAbis.length <= 0) goto L35;
        boolean systemSupports64BitAbi = true;
    L165:
        if (systemSupports32BitAbi == false) goto L48;
        if (extractLibs == true) goto L40;
        long r2 = 262144;
        Trace.traceBegin(262144, "findSupportedAbi");     // Catch: Throwable -> L41 IOException -> L43
        int abi32 = NativeLibraryHelper.findSupportedAbi(handle, supported32BitAbis);     // Catch: Throwable -> L41 IOException -> L43
        int abi33 = abi32;
    L46:
        Trace.traceEnd(r2);     // Catch: Throwable -> L41 IOException -> L43
        int abi34 = abi33;
    L50:
        if (abi34 < 0) goto L59;
        if (AndroidPackageUtils.isLibrary(pkg) == false) goto L59;
        if (extractLibs == false) goto L59;
        throw new PackageManagerException(-110, "Shared library native lib extraction not supported");     // Catch: Throwable -> L41 IOException -> L43
    L59:
        if (forceMatch == false) goto L62;
        if (systemSupports32BitAbi == false) goto L62;
        boolean r5 = true;
    L63:
        maybeThrowExceptionForMultiArchCopy("Error unpackaging 32 bit native libs for multiarch app.", abi34, r5);     // Catch: Throwable -> L67 IOException -> L69
        if (systemSupports64BitAbi == false) goto L73;
        if (extractLibs == false) goto L71;
        Trace.traceBegin(262144, "copyNativeBinaries");     // Catch: Throwable -> L67 IOException -> L69
        int abi64 = NativeLibraryHelper.copyNativeBinariesForSupportedAbi(handle, nativeLibraryRoot, supported64BitAbis, useIsaSpecificSubdirs, onIncremental);     // Catch: Throwable -> L67 IOException -> L69
        long r4 = 262144;
    L72:
        Trace.traceEnd(r4);     // Catch: Throwable -> L67 IOException -> L69
        int abi65 = abi64;
    L75:
        if (forceMatch == false) goto L78;
        if (systemSupports64BitAbi == false) goto L78;
        boolean r8 = true;
    L79:
        maybeThrowExceptionForMultiArchCopy("Error unpackaging 64 bit native libs for multiarch app.", abi65, r8);     // Catch: Throwable -> L67 IOException -> L69
        if (abi65 < 0) goto L89;
        if (extractLibs == false) goto L87;
        if (AndroidPackageUtils.isLibrary(pkg) == false) goto L87;
        throw new PackageManagerException(-110, "Shared library native lib extraction not supported");     // Catch: Throwable -> L67 IOException -> L69
    L87:
        String primaryCpuAbi2 = supported64BitAbis[abi65];     // Catch: Throwable -> L67 IOException -> L69
    L90:
        if (abi34 >= 0) goto L174;
        primaryCpuAbi = primaryCpuAbi2;
        secondaryCpuAbi = secondaryCpuAbi;
        goto L153
    L174:
        secondaryCpuAbi = supported32BitAbis[abi34];     // Catch: Throwable -> L97 IOException -> L99
        if (abi65 < 0) goto L101;
        if (pkg.is32BitAbiPreferred() == false) goto L96;
        String secondaryCpuAbi2 = primaryCpuAbi2;
        primaryCpuAbi = secondaryCpuAbi;
        secondaryCpuAbi = secondaryCpuAbi2;
        goto L153
    L96:
        primaryCpuAbi = primaryCpuAbi2;
        goto L153
    L101:
        primaryCpuAbi = secondaryCpuAbi;
        secondaryCpuAbi = secondaryCpuAbi;
    L99:
        ioe = e;
        primaryCpuAbi = primaryCpuAbi2;
        secondaryCpuAbi = secondaryCpuAbi;
    L97:
        th = th;
        goto L163
    L89:
        primaryCpuAbi2 = null;
    L78:
        r8 = false;
        goto L79
    L71:
        r4 = 262144;
        Trace.traceBegin(262144, "findSupportedAbi");     // Catch: Throwable -> L67 IOException -> L69
        int abi66 = NativeLibraryHelper.findSupportedAbi(handle, supported64BitAbis);     // Catch: Throwable -> L67 IOException -> L69
        abi64 = abi66;
        goto L72
    L73:
        abi65 = -114;
    L62:
        r5 = false;
        goto L63
    L40:
        Trace.traceBegin(262144, "copyNativeBinaries");     // Catch: Throwable -> L41 IOException -> L43
        abi33 = NativeLibraryHelper.copyNativeBinariesForSupportedAbi(handle, nativeLibraryRoot, supported32BitAbis, useIsaSpecificSubdirs, onIncremental);     // Catch: Throwable -> L41 IOException -> L43
        r2 = 262144;
        goto L46
    L48:
        systemSupports64BitAbi = systemSupports64BitAbi;
        abi34 = -114;
    L43:
        ioe = e;
        goto L159
    L35:
        systemSupports64BitAbi = false;
        goto L165
    L110:
        ioe = e;
    L108:
        th = th;
        goto L163
    L30:
        systemSupports32BitAbi = false;
        goto L172
    L19:
        ioe = e;
    L17:
        th = th;
        goto L163
    L26:
        r19 = Build.SUPPORTED_64_BIT_ABIS;     // Catch: Throwable -> L112 IOException -> L114
        goto L27
    L169:
        supported32BitAbis = getNativelySupported32BitAbis();     // Catch: Throwable -> L17 IOException -> L19
    L13:
        forceMatch = false;
        goto L14
    L117:
        if (cpuAbiOverride == null) goto L119;
        String[] abiList = {cpuAbiOverride};     // Catch: Throwable -> L67 IOException -> L69
    L120:
        boolean needsRenderScriptOverride = false;
        if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) goto L130;
        if (cpuAbiOverride != null) goto L130;
        if (NativeLibraryHelper.hasRenderscriptBitcode(handle) == false) goto L130;
        if (Build.SUPPORTED_32_BIT_ABIS.length <= 0) goto L129;
        abiList = Build.SUPPORTED_32_BIT_ABIS;     // Catch: Throwable -> L67 IOException -> L69
        needsRenderScriptOverride = true;
        goto L130
    L129:
        throw new PackageManagerException(-16, "Apps that contain RenderScript with target API level < 21 are not supported on 64-bit only platforms");     // Catch: Throwable -> L67 IOException -> L69
    L130:
        if (extractLibs == false) goto L132;
        Trace.traceBegin(262144, "copyNativeBinaries");     // Catch: Throwable -> L67 IOException -> L69
        int copyRet = NativeLibraryHelper.copyNativeBinariesForSupportedAbi(handle, nativeLibraryRoot, abiList, useIsaSpecificSubdirs, onIncremental);     // Catch: Throwable -> L67 IOException -> L69
    L133:
        Trace.traceEnd(262144);     // Catch: Throwable -> L67 IOException -> L69
        if (copyRet >= 0) goto L139;
        if (copyRet == (-114)) goto L139;
        throw new PackageManagerException(-110, "Error unpackaging native libs for app, errorCode=" + copyRet);     // Catch: Throwable -> L67 IOException -> L69
    L139:
        if (copyRet >= 0) goto L141;
        if (copyRet != (-114)) goto L148;
        if (cpuAbiOverride == null) goto L148;
        primaryCpuAbi = cpuAbiOverride;
        secondaryCpuAbi = null;
    L148:
        if (needsRenderScriptOverride == false) goto L151;
        primaryCpuAbi = abiList[0];     // Catch: Throwable -> L67 IOException -> L69
        secondaryCpuAbi = null;
        goto L153
    L151:
        primaryCpuAbi = null;
        secondaryCpuAbi = null;
        goto L153
    L141:
        if (AndroidPackageUtils.isLibrary(pkg) == true) goto L144;
        primaryCpuAbi = abiList[copyRet];     // Catch: Throwable -> L67 IOException -> L69
        secondaryCpuAbi = null;
        goto L153
    L144:
        throw new PackageManagerException(-110, "Shared library with native libs must be multiarch");     // Catch: Throwable -> L67 IOException -> L69
    L132:
        Trace.traceBegin(262144, "findSupportedAbi");     // Catch: Throwable -> L67 IOException -> L69
        copyRet = NativeLibraryHelper.findSupportedAbi(handle, abiList);     // Catch: Throwable -> L67 IOException -> L69
        goto L133
    L119:
        abiList = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L67 IOException -> L69
    L69:
        ioe = e;
        primaryCpuAbi = primaryCpuAbi;
        secondaryCpuAbi = secondaryCpuAbi;
    L67:
        th = th;
        goto L163
    L41:
        th = th;
    L156:
        ioe = e;
    L154:
        th = th;
        goto L163
    }

    private boolean shouldExtractLibs(AndroidPackage pkg, boolean isSystemApp, boolean isUpdatedSystemApp) {
        if (AndroidPackageUtils.isLibrary(pkg) == false) goto L5;
    L7:
        boolean extractLibs = false;
    L9:
        if (isSystemApp == false) goto L13;
        if (isUpdatedSystemApp == true) goto L14;
        return false;
    L14:
        return extractLibs;
    L13:
        return extractLibs;
    L5:
        if (pkg.isExtractNativeLibrariesRequested() == false) goto L7;
        extractLibs = true;
        goto L9
    }

    @Override // com.android.server.pm.PackageAbiHelper
    public String getAdjustedAbiForSharedUser(ArraySet<? extends PackageStateInternal> packagesForUser, AndroidPackage scannedPackage) {
        String requiredInstructionSet = null;
        if (scannedPackage == null) goto L7;
        String pkgRawPrimaryCpuAbi = AndroidPackageUtils.getRawPrimaryCpuAbi(scannedPackage);
        if (pkgRawPrimaryCpuAbi == null) goto L7;
        requiredInstructionSet = VMRuntime.getInstructionSet(pkgRawPrimaryCpuAbi);
    L7:
        PackageStateInternal requirer = null;
        Iterator<? extends PackageStateInternal> r2 = packagesForUser.iterator();
    L9:
        if (r2.hasNext() == false) goto L30;
        PackageStateInternal ps = r2.next();
        if (scannedPackage == null) goto L16;
        if (scannedPackage.getPackageName().equals(ps.getPackageName()) == true) goto L9;
    L16:
        if (ps.getPrimaryCpuAbiLegacy() == null) goto L9;
        String instructionSet = VMRuntime.getInstructionSet(ps.getPrimaryCpuAbiLegacy());
        if (requiredInstructionSet != null) goto L21;
    L27:
        if (requiredInstructionSet != null) goto L9;
        requiredInstructionSet = instructionSet;
        requirer = ps;
        goto L9
    L21:
        if (requiredInstructionSet.equals(instructionSet) == true) goto L27;
        StringBuilder r5 = new StringBuilder();
        r5.append("Instruction set mismatch, ");
        if (requirer != null) goto L25;
        Object r6 = "[caller]";
    L26:
        r5.append(r6);
        r5.append(" requires ");
        r5.append(requiredInstructionSet);
        r5.append(" whereas ");
        r5.append(ps);
        r5.append(" requires ");
        r5.append(instructionSet);
        String errorMessage = r5.toString();
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMessage);
        goto L27
    L25:
        r6 = requirer;
        goto L26
    L30:
        if (requiredInstructionSet != null) goto L33;
        return null;
    L33:
        if (requirer == null) goto L35;
        String adjustedAbi = requirer.getPrimaryCpuAbiLegacy();
        return adjustedAbi;
    L35:
        String adjustedAbi2 = AndroidPackageUtils.getRawPrimaryCpuAbi(scannedPackage);
        return adjustedAbi2;
    }

    @Override // com.android.server.pm.PackageAbiHelper
    public int checkPackageAlignment(AndroidPackage pkg, String libraryRoot, boolean nativeLibraryRootRequiresIsa, String abiOverride) {
        NativeLibraryHelper.Handle handle = AndroidPackageUtils.createNativeLibraryHandle(pkg);     // Catch: IOException -> L5
        return NativeLibraryHelper.checkAlignmentForCompatMode(handle, libraryRoot, nativeLibraryRootRequiresIsa, abiOverride);
    L6:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to check alignment of package : " + pkg.getPackageName());
        return -1;
    }
}
