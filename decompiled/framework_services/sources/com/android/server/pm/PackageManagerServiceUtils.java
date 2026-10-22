package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfoLite;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackagePartitions;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.PackageLite;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.content.res.ApkAssets;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.Environment;
import android.os.FileUtils;
import android.os.SELinux;
import android.os.SystemProperties;
import android.os.incremental.IncrementalManager;
import android.os.incremental.IncrementalStorage;
import android.os.incremental.V4Signature;
import android.os.storage.DiskInfo;
import android.os.storage.VolumeInfo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.telephony.TelephonyPermissions;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastPrintWriter;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.HexDump;
import com.android.server.EventLogTags;
import com.android.server.LocalManagerRegistry;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.Watchdog;
import com.android.server.pm.dex.PackageDexUsage;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.AndroidPackageSplit;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import dalvik.system.VMRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.zip.GZIPInputStream;
import libcore.io.IoUtils;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerServiceUtils {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_PACKAGE_PARSER_CACHE_ENABLED = true;
    private static final boolean FORCE_PACKAGE_PARSED_CACHE_ENABLED = false;
    private static final long MAX_CRITICAL_INFO_DUMP_SIZE = 3000000;
    public static final Predicate<PackageStateInternal> REMOVE_IF_APEX_PKG = null;
    public static final Predicate<PackageStateInternal> REMOVE_IF_NULL_PKG = null;
    public static final int SHARED_USER_ID_JOIN_TYPE_INSTALL = 0;
    public static final int SHARED_USER_ID_JOIN_TYPE_SYSTEM = 2;
    public static final int SHARED_USER_ID_JOIN_TYPE_UPDATE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SharedUserIdJoinType {
    }

    /* JADX INFO: renamed from: $r8$lambda$cIcNbRolf3vpNJXQFKHZq66-GNo, reason: not valid java name */
    public static /* synthetic */ void m6872$r8$lambda$cIcNbRolf3vpNJXQFKHZq66GNo(long r0, AtomicBoolean r2, CancellationSignal r3, long r4) {
        lambda$extractAppMetadataFromApk$2(r0, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$lUdBVbwGolvSStCURcFIprX9_1g(PackageStateInternal r0) {
        return lambda$static$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$sDbX46zTLkJ8LreyTaY8ScPIlsA(PackageStateInternal r0) {
        return lambda$static$0(r0);
    }

    public PackageManagerServiceUtils() {
    }

    static {
        DEBUG = Build.IS_DEBUGGABLE;
        REMOVE_IF_APEX_PKG = new PackageManagerServiceUtils$$ExternalSyntheticLambda0();
        REMOVE_IF_NULL_PKG = new PackageManagerServiceUtils$$ExternalSyntheticLambda1();
    }

    private static /* synthetic */ boolean lambda$static$0(PackageStateInternal pkgSetting) {
        return pkgSetting.getPkg().isApex();
    }

    private static /* synthetic */ boolean lambda$static$1(PackageStateInternal pkgSetting) {
        if (pkgSetting.getPkg() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static PackageManagerLocal getPackageManagerLocal() {
        return (PackageManagerLocal) LocalManagerRegistry.getManagerOrThrow(PackageManagerLocal.class);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean isUnusedSinceTimeInMillis(long firstInstallTime, long currentTimeInMillis, long thresholdTimeinMillis, PackageDexUsage.PackageUseInfo packageUseInfo, long latestPackageUseTimeInMillis, long latestForegroundPackageUseTimeInMillis) {
        if ((currentTimeInMillis - firstInstallTime) >= thresholdTimeinMillis) goto L6;
        return false;
    L6:
        if ((currentTimeInMillis - latestForegroundPackageUseTimeInMillis) >= thresholdTimeinMillis) goto L8;
        boolean isActiveInForeground = true;
    L9:
        if (isActiveInForeground == false) goto L12;
        return false;
    L12:
        if ((currentTimeInMillis - latestPackageUseTimeInMillis) < thresholdTimeinMillis) goto L14;
    L16:
        boolean isActiveInBackgroundAndUsedByOtherPackages = false;
    L18:
        if (isActiveInBackgroundAndUsedByOtherPackages == false) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (packageUseInfo.isAnyCodePathUsedByOtherApps() == false) goto L16;
        isActiveInBackgroundAndUsedByOtherPackages = true;
        goto L18
    L8:
        isActiveInForeground = false;
        goto L9
    }

    public static String realpath(File path) throws IOException {
        return Os.realpath(path.getAbsolutePath());
    L4:
        ee = move-exception;
        throw ee.rethrowAsIOException();
    }

    public static boolean checkISA(String isa) {
        String[] r0 = Build.SUPPORTED_ABIS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String abi = r0[r3];
        if (VMRuntime.getInstructionSet(abi).equals(isa) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static long getLastModifiedTime(AndroidPackage pkg) {
        File srcFile = new File(pkg.getPath());
        if (srcFile.isDirectory() == false) goto L5;
        File baseFile = new File(pkg.getBaseApkPath());
        long maxModifiedTime = baseFile.lastModified();
        int i = pkg.getSplitCodePaths().length - 1;
    L7:
        if (i < 0) goto L10;
        File splitFile = new File(pkg.getSplitCodePaths()[i]);
        maxModifiedTime = Math.max(maxModifiedTime, splitFile.lastModified());
        i = i - 1;
        goto L7
    L10:
        return maxModifiedTime;
    L5:
        return srcFile.lastModified();
    }

    private static File getSettingsProblemFile() {
        File dataDir = Environment.getDataDirectory();
        File systemDir = new File(dataDir, "system");
        File fname = new File(systemDir, "uiderrors.txt");
        return fname;
    }

    public static void dumpCriticalInfo(ProtoOutputStream proto) {
        File file = getSettingsProblemFile();
        long skipSize = file.length() - MAX_CRITICAL_INFO_DUMP_SIZE;
        BufferedReader in = new BufferedReader(new FileReader(file));     // Catch: IOException -> L20
        if (skipSize <= 0) goto L10;
        in.skip(skipSize);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        in.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IOException -> L20
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L10:
        String line = in.readLine();     // Catch: Throwable -> L7
        if (line == null) goto L18;
        if (line.contains("ignored: updated version") == true) goto L10;
        proto.write(2237677961223L, line);     // Catch: Throwable -> L7
        goto L10
    L18:
        in.close();     // Catch: IOException -> L20
        return;
    }

    public static void dumpCriticalInfo(PrintWriter pw, String msg) {
        File file = getSettingsProblemFile();
        long skipSize = file.length() - MAX_CRITICAL_INFO_DUMP_SIZE;
        BufferedReader in = new BufferedReader(new FileReader(file));     // Catch: IOException -> L22
        if (skipSize <= 0) goto L10;
        in.skip(skipSize);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        in.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: IOException -> L22
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L10:
        String line = in.readLine();     // Catch: Throwable -> L7
        if (line == null) goto L20;
        if (line.contains("ignored: updated version") == true) goto L10;
        if (msg == null) goto L17;
        pw.print(msg);     // Catch: Throwable -> L7
    L17:
        pw.println(line);     // Catch: Throwable -> L7
        goto L10
    L20:
        in.close();     // Catch: IOException -> L22
        return;
    }

    public static void logCriticalInfo(int priority, String msg) {
        Slog.println(priority, PackageManagerServiceMonitorEx.TAG, msg);
        EventLogTags.writePmCriticalInfo(msg);
        File fname = getSettingsProblemFile();     // Catch: IOException -> L5
        FileOutputStream out = new FileOutputStream(fname, true);     // Catch: IOException -> L5
        FastPrintWriter r2 = new FastPrintWriter(out);     // Catch: IOException -> L5
        SimpleDateFormat formatter = new SimpleDateFormat();     // Catch: IOException -> L5
        String dateString = formatter.format(new Date(System.currentTimeMillis()));     // Catch: IOException -> L5
        r2.println(dateString + ": " + msg);     // Catch: IOException -> L5
        r2.close();     // Catch: IOException -> L5
        FileUtils.setPermissions(fname.toString(), TarConstants.XSTAR_MAGIC_OFFSET, -1, -1);     // Catch: IOException -> L5
        return;
    }

    public static void enforceShellRestriction(UserManagerInternal userManager, String restriction, int callingUid, int userHandle) {
        if (callingUid != 2000) goto L13;
        if (userHandle >= 0) goto L6;
    L10:
        if (userHandle >= 0) goto L14;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Unable to check shell permission for user " + userHandle + "\n\t" + Debug.getCallers(3));
        return;
    L14:
        return;
    L6:
        if (userManager.hasUserRestriction(restriction, userHandle) == false) goto L10;
        throw new SecurityException("Shell does not have permission to access user " + userHandle);
    }

    public static void enforceSystemOrPhoneCaller(String methodName, int callingUid) {
        if (TelephonyPermissions.isSystemOrPhone(callingUid) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Cannot call " + methodName + " from UID " + callingUid);
    }

    public static String deriveAbiOverride(String abiOverride) {
        if ("-".equals(abiOverride) == false) goto L6;
        return null;
    L6:
        return abiOverride;
    }

    public static int compareSignatures(SigningDetails sd1, SigningDetails sd2) {
        return compareSignatureArrays(sd1.getSignatures(), sd2.getSignatures());
    }

    static int compareSignatureArrays(Signature[] s1, Signature[] s2) {
        if (s1 != null) goto L8;
        if (s2 == null) goto L33;
        return -1;
    L33:
        return 1;
    L8:
        if (s2 != null) goto L12;
        return -2;
    L12:
        if (s1.length == s2.length) goto L15;
        return -3;
    L15:
        if (s1.length == 1) goto L17;
        ArraySet<Signature> set1 = new ArraySet();
        int r1 = s1.length;
        int r4 = 0;
    L22:
        if (r4 >= r1) goto L24;
        Signature sig = s1[r4];
        set1.add(sig);
        r4 = r4 + 1;
        goto L22
    L24:
        ArraySet<Signature> set2 = new ArraySet();
        int r5 = s2.length;
        int r6 = 0;
    L25:
        if (r6 >= r5) goto L28;
        Signature sig2 = s2[r6];
        set2.add(sig2);
        r6 = r6 + 1;
        goto L25
    L28:
        if (set1.equals(set2) == false) goto L30;
        return 0;
    L30:
        return -3;
    L17:
        if (s1[0].equals(s2[0]) == true) goto L20;
        return -3;
    L20:
        return 0;
    }

    public static boolean comparePackageSignatures(PackageSetting pkgSetting, SigningDetails otherSigningDetails) {
        SigningDetails signingDetails = pkgSetting.getSigningDetails();
        if (signingDetails != SigningDetails.UNKNOWN) goto L5;
    L8:
        return true;
    L5:
        if (compareSignatures(signingDetails, otherSigningDetails) == 0) goto L8;
        return false;
    }

    private static boolean matchSignaturesCompat(String packageName, PackageSignatures packageSignatures, SigningDetails parsedSignatures) {
        ArraySet<Signature> existingSet = new ArraySet();
        Signature[] r1 = packageSignatures.mSigningDetails.getSignatures();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        existingSet.add(r1[r4]);
        r4 = r4 + 1;
        goto L3
    L5:
        ArraySet<Signature> scannedCompatSet = new ArraySet();
        Signature[] r3 = parsedSignatures.getSignatures();
        int r5 = r3.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L18;
        Signature sig = r3[r6];
        Signature[] chainSignatures = sig.getChainSignatures();     // Catch: CertificateEncodingException -> L12
        int r8 = chainSignatures.length;     // Catch: CertificateEncodingException -> L12
        int r9 = 0;
    L9:
        if (r9 >= r8) goto L16;
        Signature chainSig = chainSignatures[r9];     // Catch: CertificateEncodingException -> L12
        scannedCompatSet.add(chainSig);     // Catch: CertificateEncodingException -> L12
        r9 = r9 + 1;
    L16:
        r6 = r6 + 1;
    L15:
        scannedCompatSet.add(sig);
        goto L16
    L18:
        if (scannedCompatSet.equals(existingSet) == false) goto L22;
        packageSignatures.mSigningDetails = parsedSignatures;
        return true;
    L22:
        if (parsedSignatures.hasPastSigningCertificates() == false) goto L24;
        logCriticalInfo(4, "Existing package " + packageName + " has flattened signing certificate chain. Unable to install newer version with rotated signing certificate.");
    L24:
        return false;
    }

    private static boolean matchSignaturesRecover(String packageName, SigningDetails existingSignatures, SigningDetails parsedSignatures, int flags) {
        String msg = null;
    L8:
        e = move-exception;
        msg = e.getMessage();
    L12:
        logCriticalInfo(4, "Failed to recover certificates for " + packageName + ": " + msg);
        return false;
    L4:
        if (parsedSignatures.checkCapabilityRecover(existingSignatures, flags) == false) goto L12;
        logCriticalInfo(4, "Recovered effectively matching certificates for " + packageName);     // Catch: CertificateException -> L8
        return true;
    }

    private static boolean matchSignatureInSystem(String packageName, SigningDetails signingDetails, PackageSetting disabledPkgSetting) {
        if (signingDetails.checkCapability(disabledPkgSetting.getSigningDetails(), 1) == false) goto L5;
    L9:
        return true;
    L5:
        if (disabledPkgSetting.getSigningDetails().checkCapability(signingDetails, 8) == true) goto L9;
        logCriticalInfo(6, "Updated system app mismatches cert on /system: " + packageName);
        return false;
    }

    public static boolean verifySignatures(PackageSetting pkgSetting, SharedUserSetting sharedUserSetting, PackageSetting disabledPkgSetting, SigningDetails parsedSignatures, boolean compareCompat, boolean compareRecover, boolean isRollback) throws PackageManagerException {
        String packageName = pkgSetting.getPackageName();
        boolean compatMatch = false;
        boolean r3 = false;
        if (pkgSetting.getSigningDetails().getSignatures() != null) goto L5;
    L37:
        if (sharedUserSetting != null) goto L39;
    L65:
        return compatMatch;
    L39:
        if (sharedUserSetting.getSigningDetails() == SigningDetails.UNKNOWN) goto L65;
        if (pkgSetting.getSigningDetails().getSignatures() == null) goto L43;
        int r2 = 1;
    L44:
        boolean match = canJoinSharedUserId(packageName, parsedSignatures, sharedUserSetting, r2);
        if (match == true) goto L48;
        if (compareCompat == false) goto L48;
        match = matchSignaturesCompat(packageName, sharedUserSetting.signatures, parsedSignatures);
    L48:
        if (match == true) goto L57;
        if (compareRecover == false) goto L57;
        if (matchSignaturesRecover(packageName, sharedUserSetting.signatures.mSigningDetails, parsedSignatures, 2) == false) goto L53;
    L54:
        r3 = true;
    L55:
        match = r3;
        compatMatch = compatMatch | match;
        goto L57
    L53:
        if (matchSignaturesRecover(packageName, parsedSignatures, sharedUserSetting.signatures.mSigningDetails, 2) == false) goto L55;
    L57:
        if (match == false) goto L64;
        if (parsedSignatures.hasCommonAncestor(sharedUserSetting.signatures.mSigningDetails) == true) goto L65;
        throw new PackageManagerException(-8, "Package " + packageName + " has a signing lineage that diverges from the lineage of the sharedUserId");
    L64:
        throw new PackageManagerException(-8, "Package " + packageName + " has no signatures that match those in shared user " + sharedUserSetting.name + "; ignoring!");
    L43:
        r2 = 0;
        goto L44
    L5:
        if (parsedSignatures.checkCapability(pkgSetting.getSigningDetails(), 1) == false) goto L7;
    L10:
        boolean match2 = true;
    L12:
        if (match2 == false) goto L17;
        if (disabledPkgSetting == null) goto L17;
        if (disabledPkgSetting.getSigningDetails() == SigningDetails.UNKNOWN) goto L17;
        match2 = matchSignatureInSystem(packageName, parsedSignatures, disabledPkgSetting);
    L17:
        if (match2 == true) goto L20;
        if (compareCompat == false) goto L20;
        match2 = matchSignaturesCompat(packageName, pkgSetting.getSignatures(), parsedSignatures);
        compatMatch = match2;
    L20:
        if (match2 == true) goto L30;
        if (compareRecover == false) goto L30;
        if (matchSignaturesRecover(packageName, pkgSetting.getSigningDetails(), parsedSignatures, 1) == false) goto L25;
    L28:
        boolean r5 = true;
    L29:
        match2 = r5;
        goto L30
    L25:
        if (matchSignaturesRecover(packageName, parsedSignatures, pkgSetting.getSigningDetails(), 8) == true) goto L28;
        r5 = false;
    L30:
        if (match2 == true) goto L33;
        if (isRollback == false) goto L33;
        match2 = pkgSetting.getSigningDetails().hasAncestorOrSelf(parsedSignatures);
    L33:
        if (match2 == true) goto L37;
        throw new PackageManagerException(-7, "Existing package " + packageName + " signatures do not match newer version; ignoring!");
    L7:
        if (pkgSetting.getSigningDetails().checkCapability(parsedSignatures, 8) == true) goto L10;
        match2 = false;
        goto L12
    }

    public static boolean canJoinSharedUserId(String packageName, SigningDetails packageSigningDetails, SharedUserSetting sharedUserSetting, int joinType) {
        SigningDetails sharedUserSigningDetails = sharedUserSetting.getSigningDetails();
        if (packageSigningDetails.checkCapability(sharedUserSigningDetails, 2) == false) goto L5;
    L8:
        boolean capabilityGranted = true;
    L10:
        if (capabilityGranted == false) goto L13;
        if (joinType == 0) goto L13;
        return true;
    L13:
        if (capabilityGranted == false) goto L15;
    L19:
        if (capabilityGranted == false) goto L21;
    L25:
        if (capabilityGranted == true) goto L27;
        return false;
    L27:
        ArraySet<? extends PackageStateInternal> r5 = sharedUserSetting.getPackageStates();
        if (packageSigningDetails.hasPastSigningCertificates() == false) goto L39;
        Iterator<? extends PackageStateInternal> r6 = r5.iterator();
    L31:
        if (r6.hasNext() == false) goto L39;
        PackageStateInternal shUidPkgSetting = r6.next();
        SigningDetails shUidSigningDetails = shUidPkgSetting.getSigningDetails();
        if (packageSigningDetails.hasAncestor(shUidSigningDetails) == false) goto L31;
        if (packageSigningDetails.checkCapability(shUidSigningDetails, 2) == true) goto L31;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Package " + packageName + " revoked the sharedUserId capability from the signing key used to sign " + shUidPkgSetting.getPackageName());
        return false;
    L39:
        return true;
    L21:
        if (packageSigningDetails.hasAncestor(sharedUserSigningDetails) == false) goto L25;
        if (joinType == 0) goto L24;
        return true;
    L24:
        return false;
    L15:
        if (sharedUserSigningDetails.hasAncestor(packageSigningDetails) == false) goto L19;
        if (joinType != 2) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (sharedUserSigningDetails.checkCapability(packageSigningDetails, 2) == true) goto L8;
        capabilityGranted = false;
        goto L10
    }

    public static int extractNativeBinaries(File dstCodePath, String packageName) {
        File libraryRoot = new File(dstCodePath, "lib");
        NativeLibraryHelper.Handle handle = null;
        handle = NativeLibraryHelper.Handle.create(dstCodePath);     // Catch: Throwable -> L6 IOException -> L8
        int r2 = NativeLibraryHelper.copyNativeBinariesWithOverride(handle, libraryRoot, null, false);     // Catch: Throwable -> L6 IOException -> L8
        IoUtils.closeQuietly(handle);
        return r2;
    L8:
        e = move-exception;
        logCriticalInfo(6, "Failed to extract native libraries; pkg: " + packageName + "; err: " + e.getMessage());     // Catch: Throwable -> L6
        IoUtils.closeQuietly(handle);
        return -110;
    L6:
        th = move-exception;
        IoUtils.closeQuietly(handle);
        throw th;
    }

    public static void removeNativeBinariesLI(PackageSetting ps) {
        if (ps == null) goto L5;
        NativeLibraryHelper.removeNativeBinariesLI(ps.getLegacyNativeLibraryPath());
        return;
    }

    public static void waitForNativeBinariesExtractionForIncremental(ArraySet<IncrementalStorage> incrementalStorages) {
        if (incrementalStorages.isEmpty() == false) goto L16;
        return;
    L16:
        Watchdog.getInstance().pauseWatchingCurrentThread("native_lib_extract");     // Catch: Throwable -> L10
        int i = 0;
    L7:
        if (i >= incrementalStorages.size()) goto L12;
        IncrementalStorage storage = (IncrementalStorage) incrementalStorages.valueAtUnchecked(i);     // Catch: Throwable -> L10
        storage.waitForNativeBinariesExtraction();     // Catch: Throwable -> L10
        i = i + 1;
        goto L7
    L12:
        Watchdog.getInstance().resumeWatchingCurrentThread("native_lib_extract");
        return;
    L10:
        th = move-exception;
        Watchdog.getInstance().resumeWatchingCurrentThread("native_lib_extract");
        throw th;
    }

    public static int decompressFiles(String codePath, File dstCodePath, String packageName) {
        File[] compressedFiles = getCompressedFiles(codePath);
        int ret = 1;
        makeDirRecursive(dstCodePath, UnixStat.DEFAULT_DIR_PERM);     // Catch: ErrnoException -> L9
        int r3 = compressedFiles.length;     // Catch: ErrnoException -> L9
        int r6 = 0;
    L4:
        if (r6 >= r3) goto L14;
        File srcFile = compressedFiles[r6];     // Catch: ErrnoException -> L9
        String srcFileName = srcFile.getName();     // Catch: ErrnoException -> L9
        String dstFileName = srcFileName.substring(0, srcFileName.length() - PackageManagerService.COMPRESSED_EXTENSION.length());     // Catch: ErrnoException -> L9
        File dstFile = new File(dstCodePath, dstFileName);     // Catch: ErrnoException -> L9
        ret = decompressFile(srcFile, dstFile);     // Catch: ErrnoException -> L9
        if (ret != 1) goto L7;
        r6 = r6 + 1;
        goto L4
    L7:
        logCriticalInfo(6, "Failed to decompress; pkg: " + packageName + ", file: " + dstFileName);     // Catch: ErrnoException -> L9
    L14:
        return ret;
    L9:
        e = move-exception;
        logCriticalInfo(6, "Failed to decompress; pkg: " + packageName + ", err: " + e.errno);
        goto L14
    }

    public static int decompressFile(File srcFile, File dstFile) throws ErrnoException {
        if (PackageManagerService.DEBUG_COMPRESSION == false) goto L5;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Decompress file; src: " + srcFile.getAbsolutePath() + ", dst: " + dstFile.getAbsolutePath());
    L5:
        AtomicFile atomicFile = new AtomicFile(dstFile);
        FileOutputStream outputStream = null;
        InputStream fileIn = new GZIPInputStream(new FileInputStream(srcFile));     // Catch: IOException -> L11
        outputStream = atomicFile.startWrite();     // Catch: Throwable -> L13
        FileUtils.copy(fileIn, outputStream);     // Catch: Throwable -> L13
        outputStream.flush();     // Catch: Throwable -> L13
        Os.fchmod(outputStream.getFD(), 420);     // Catch: Throwable -> L13
        atomicFile.finishWrite(outputStream);     // Catch: Throwable -> L13
        fileIn.close();     // Catch: IOException -> L11
        return 1;
    L13:
        th = move-exception;
        fileIn.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: IOException -> L11
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L11
    L19:
        logCriticalInfo(6, "Failed to decompress file; src: " + srcFile.getAbsolutePath() + ", dst: " + dstFile.getAbsolutePath());
        atomicFile.failWrite(outputStream);
        return -110;
    }

    public static File[] getCompressedFiles(String codePath) {
        File stubCodePath = new File(codePath);
        String stubName = stubCodePath.getName();
        int idx = stubName.lastIndexOf(PackageManagerService.STUB_SUFFIX);
        if (idx >= 0) goto L5;
    L18:
        return null;
    L5:
        if (stubName.length() != (PackageManagerService.STUB_SUFFIX.length() + idx)) goto L18;
        File stubParentDir = stubCodePath.getParentFile();
        if (stubParentDir != null) goto L11;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Unable to determine stub parent dir for codePath: " + codePath);
        return null;
    L11:
        File compressedPath = new File(stubParentDir, stubName.substring(0, idx));
        File[] files = compressedPath.listFiles(new AnonymousClass1());
        if (PackageManagerService.DEBUG_COMPRESSION == false) goto L17;
        if (files == null) goto L17;
        if (files.length <= 0) goto L17;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "getCompressedFiles[" + codePath + "]: " + Arrays.toString(files));
    L17:
        return files;
    }

    public static boolean compressedFileExists(String codePath) {
        File[] compressedFiles = getCompressedFiles(codePath);
        if (compressedFiles != null) goto L5;
    L7:
        return false;
    L5:
        if (compressedFiles.length <= 0) goto L7;
        return true;
    }

    public static PackageInfoLite getMinimalPackageInfo(Context context, PackageLite pkg, String packagePath, int flags, String abiOverride) {
        PackageInfoLite ret = new PackageInfoLite();
        if (packagePath == null) goto L24;
        if (pkg == null) goto L24;
        File packageFile = new File(packagePath);
        if (PackageInstallerSession.isArchivedInstallation(flags) == false) goto L28;
        long sizeBytes = 0;
    L17:
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(-1);
        sessionParams.appPackageName = pkg.getPackageName();
        sessionParams.installLocation = pkg.getInstallLocation();
        sessionParams.sizeBytes = sizeBytes;
        sessionParams.installFlags = flags;
        int recommendedInstallLocation = InstallLocationUtils.resolveInstallLocation(context, sessionParams);     // Catch: IOException -> L21
        ret.packageName = pkg.getPackageName();
        ret.splitNames = pkg.getSplitNames();
        ret.versionCode = pkg.getVersionCode();
        ret.versionCodeMajor = pkg.getVersionCodeMajor();
        ret.baseRevisionCode = pkg.getBaseRevisionCode();
        ret.splitRevisionCodes = pkg.getSplitRevisionCodes();
        ret.installLocation = pkg.getInstallLocation();
        ret.verifiers = pkg.getVerifiers();
        ret.recommendedInstallLocation = recommendedInstallLocation;
        ret.multiArch = pkg.isMultiArch();
        ret.debuggable = pkg.isDebuggable();
        ret.isSdkLibrary = pkg.isIsSdkLibrary();
        return ret;
    L21:
        e = move-exception;
        throw new IllegalStateException(e);
    L28:
        sizeBytes = InstallLocationUtils.calculateInstalledSize(pkg, abiOverride);     // Catch: IOException -> L10
    L12:
        if (packageFile.exists() == true) goto L14;
        ret.recommendedInstallLocation = -6;
    L15:
        return ret;
    L14:
        ret.recommendedInstallLocation = -2;
    L24:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Invalid package file " + packagePath);
        ret.recommendedInstallLocation = -2;
        return ret;
    }

    public static long calculateInstalledSize(String packagePath, String abiOverride) {
        File packageFile = new File(packagePath);
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();     // Catch: Throwable -> L7
        ParseResult<PackageLite> result = ApkLiteParseUtils.parsePackageLite(input.reset(), packageFile, 0);     // Catch: Throwable -> L7
        if (result.isError() == true) goto L10;
        return InstallLocationUtils.calculateInstalledSize((PackageLite) result.getResult(), abiOverride);
    L10:
        throw new PackageManagerException(result.getErrorCode(), result.getErrorMessage(), result.getException());     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to calculate installed size: " + e);
        return -1;
    }

    public static boolean isDowngradePermitted(int installFlags, boolean isAppDebuggable) {
        if ((installFlags & 128) == 0) goto L5;
        boolean downgradeRequested = true;
    L6:
        if (downgradeRequested == true) goto L9;
        return false;
    L9:
        if (Build.IS_DEBUGGABLE == true) goto L13;
        if (isAppDebuggable == true) goto L13;
        boolean isDebuggable = false;
    L14:
        if (isDebuggable == false) goto L17;
        return true;
    L17:
        if ((1048576 & installFlags) != 0) goto L19;
        return false;
    L19:
        return true;
    L13:
        isDebuggable = true;
        goto L14
    L5:
        downgradeRequested = false;
        goto L6
    }

    public static int copyPackage(String packagePath, File targetDir) {
        if (packagePath != null) goto L23;
        return -3;
    L23:
        File packageFile = new File(packagePath);     // Catch: Throwable -> L10
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();     // Catch: Throwable -> L10
        ParseResult<PackageLite> result = ApkLiteParseUtils.parsePackageLite(input.reset(), packageFile, 0);     // Catch: Throwable -> L10
        if (result.isError() == false) goto L12;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to parse package at " + packagePath);     // Catch: Throwable -> L10
        return result.getErrorCode();
    L12:
        PackageLite pkg = (PackageLite) result.getResult();     // Catch: Throwable -> L10
        copyFile(pkg.getBaseApkPath(), targetDir, "base.apk");     // Catch: Throwable -> L10
        if (ArrayUtils.isEmpty(pkg.getSplitNames()) == true) goto L19;
        int i = 0;
    L16:
        if (i >= pkg.getSplitNames().length) goto L25;
        copyFile(pkg.getSplitApkPaths()[i], targetDir, "split_" + pkg.getSplitNames()[i] + ".apk");     // Catch: Throwable -> L10
        i = i + 1;
        goto L16
    L25:
        return 1;
    L19:
        return 1;
    L10:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to copy package at " + packagePath + ": " + e);
        return -4;
    }

    private static void copyFile(String sourcePath, File targetDir, String targetName) throws ErrnoException, IOException {
        if (FileUtils.isValidExtFilename(targetName) == false) goto L12;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Copying " + sourcePath + " to " + targetName);
        File targetFile = new File(targetDir, targetName);
        FileDescriptor targetFd = Os.open(targetFile.getAbsolutePath(), OsConstants.O_RDWR | OsConstants.O_CREAT, 420);
        Os.chmod(targetFile.getAbsolutePath(), 420);
        FileInputStream source = null;
        source = new FileInputStream(sourcePath);     // Catch: Throwable -> L8
        FileUtils.copy(source.getFD(), targetFd);     // Catch: Throwable -> L8
        IoUtils.closeQuietly(source);
        return;
    L8:
        th = move-exception;
        IoUtils.closeQuietly(source);
        throw th;
    L12:
        throw new IllegalArgumentException("Invalid filename: " + targetName);
    }

    public static void makeDirRecursive(File targetDir, int mode) throws ErrnoException {
        Path targetDirPath = targetDir.toPath();
        int directoriesCount = targetDirPath.getNameCount();
        int i = 1;
    L3:
        if (i > directoriesCount) goto L10;
        File currentDir = targetDirPath.subpath(0, i).toFile();
        if (currentDir.exists() == true) goto L8;
        Os.mkdir(currentDir.getAbsolutePath(), mode);
        Os.chmod(currentDir.getAbsolutePath(), mode);
    L8:
        i = i + 1;
        goto L3
    }

    public static String buildVerificationRootHashString(String baseFilename, String[] splitFilenameArray) {
        StringBuilder sb = new StringBuilder();
        String baseFilePath = baseFilename.substring(baseFilename.lastIndexOf(File.separator) + 1);
        sb.append(baseFilePath);
        sb.append(":");
        byte[] baseRootHash = getRootHash(baseFilename);
        if (baseRootHash != null) goto L5;
        sb.append("0");
    L6:
        if (splitFilenameArray == null) goto L20;
        if (splitFilenameArray.length == 0) goto L20;
        int i = splitFilenameArray.length - 1;
    L11:
        if (i < 0) goto L18;
        String splitFilename = splitFilenameArray[i];
        String splitFilePath = splitFilename.substring(splitFilename.lastIndexOf(File.separator) + 1);
        byte[] splitRootHash = getRootHash(splitFilename);
        sb.append(";");
        sb.append(splitFilePath);
        sb.append(":");
        if (splitRootHash != null) goto L15;
        sb.append("0");
    L16:
        i = i - 1;
        goto L11
    L15:
        sb.append(HexDump.toHexString(splitRootHash));
        goto L16
    L18:
        return sb.toString();
    L20:
        return sb.toString();
    L5:
        sb.append(HexDump.toHexString(baseRootHash));
        goto L6
    }

    private static byte[] getRootHash(String filename) {
        byte[] baseFileSignature = IncrementalManager.unsafeGetFileSignature(filename);     // Catch: IOException -> L10
        if (baseFileSignature == null) goto L17;
        V4Signature signature = V4Signature.readFrom(baseFileSignature);     // Catch: IOException -> L10
        if (signature.hashingInfo == null) goto L15;
        V4Signature.HashingInfo hashInfo = V4Signature.HashingInfo.fromByteArray(signature.hashingInfo);     // Catch: IOException -> L10
        if (ArrayUtils.isEmpty(hashInfo.rawRootHash) == true) goto L13;
        return ApkChecksums.verityHashForFile(new File(filename), hashInfo.rawRootHash);
    L13:
        throw new IOException("Root has not present");     // Catch: IOException -> L10
    L15:
        throw new IOException("Hashing info not present");     // Catch: IOException -> L10
    L17:
        throw new IOException("File signature not present");     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Could not obtain verity root hash", e);
        return null;
    }

    public static boolean isSystemApp(PackageStateInternal ps) {
        if ((ps.getFlags() & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isUpdatedSystemApp(PackageStateInternal ps) {
        if ((ps.getFlags() & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasAnyDomainApproval(DomainVerificationManagerInternal manager, PackageStateInternal pkgSetting, Intent intent, long resolveInfoFlags, int userId) {
        if (manager.approvalLevelForDomain(pkgSetting, intent, resolveInfoFlags, userId) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Intent updateIntentForResolve(Intent intent) {
        if (intent.getSelector() != null) goto L5;
        return intent;
    L5:
        return intent.getSelector();
    }

    public static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append('[');
        if (array == null) goto L10;
        int i = 0;
    L6:
        if (i >= array.length) goto L10;
        if (i <= 0) goto L9;
        stringBuilder.append(", ");
    L9:
        stringBuilder.append(array[i]);
        i = i + 1;
    L10:
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static File getNextCodePath(File targetDir, String packageName) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
    L3:
        random.nextBytes(bytes);
        String firstLevelDirName = "~~" + Base64.encodeToString(bytes, 10);
        File firstLevelDir = new File(targetDir, firstLevelDirName);
        if (firstLevelDir.exists() == true) goto L3;
        random.nextBytes(bytes);
        String dirName = packageName + '-' + Base64.encodeToString(bytes, 10);
        File result = new File(firstLevelDir, dirName);
        if (DEBUG == true) goto L8;
    L12:
        return result;
    L8:
        if (Objects.equals(tryParsePackageName(result.getName()), packageName) == true) goto L12;
        throw new RuntimeException("codepath is off: " + result.getName() + " (" + packageName + ")");
    }

    static String tryParsePackageName(String codePath) throws IllegalArgumentException {
        int packageNameEnds = codePath.indexOf(45);
        if (packageNameEnds == (-1)) goto L7;
        return codePath.substring(0, packageNameEnds);
    L7:
        throw new IllegalArgumentException("Not a valid package folder name");
    }

    public static int getPackageExternalStorageType(VolumeInfo packageVolume, boolean packageIsExternal) {
        if (packageVolume == null) goto L16;
        DiskInfo disk = packageVolume.getDisk();
        if (disk != null) goto L6;
        return 0;
    L6:
        if (disk.isSd() == false) goto L10;
        return 1;
    L10:
        if (disk.isUsb() == false) goto L13;
        return 2;
    L13:
        if (packageIsExternal == false) goto L19;
        return 3;
    L19:
        return 0;
    L16:
        return 0;
    }

    public static void enforceSystemOrRootOrShell(String message) {
        if (isSystemOrRootOrShell() == false) goto L6;
        return;
    L6:
        throw new SecurityException(message);
    }

    public static boolean isSystemOrRootOrShell() {
        return isSystemOrRootOrShell(Binder.getCallingUid());
    }

    public static boolean isSystemOrRootOrShell(int uid) {
        if (uid == 1000) goto L9;
        if (uid == 0) goto L9;
        if (uid == 2000) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean isSystemOrRoot() {
        int uid = Binder.getCallingUid();
        return isSystemOrRoot(uid);
    }

    public static boolean isSystemOrRoot(int uid) {
        if (uid == 1000) goto L7;
        if (uid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isAdoptedShell(int uid, Context context) {
        if (uid != 1000) goto L5;
    L7:
        return false;
    L5:
        if (context.checkCallingOrSelfPermission("com.android.permission.USE_SYSTEM_DATA_LOADERS") != 0) goto L7;
        return true;
    }

    public static boolean isRootOrShell(int uid) {
        if (uid != 0) goto L4;
    L7:
        return true;
    L4:
        if (uid == 2000) goto L7;
        return false;
    }

    public static void enforceSystemOrRoot(String message) {
        if (isSystemOrRoot() == false) goto L6;
        return;
    L6:
        throw new SecurityException(message);
    }

    public static File preparePackageParserCache(boolean forEngBuild, boolean isUserDebugBuild, String incrementalVersion) {
        if (forEngBuild == false) goto L5;
        return null;
    L5:
        int r2 = 0;
        if (SystemProperties.getBoolean("pm.boot.disable_package_cache", false) == false) goto L9;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Disabling package parser cache due to system property.");
        return null;
    L9:
        File cacheBaseDir = Environment.getPackageCacheDirectory();
        if (FileUtils.createDir(cacheBaseDir) == true) goto L12;
        return null;
    L12:
        String cacheName = PackagePartitions.FINGERPRINT;
        File[] r5 = FileUtils.listFilesOrEmpty(cacheBaseDir);
        int r6 = r5.length;
    L13:
        if (r2 >= r6) goto L19;
        File cacheDir = r5[r2];
        if (Objects.equals(cacheName, cacheDir.getName()) == false) goto L17;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Keeping known cache " + cacheDir.getName());
    L18:
        r2 = r2 + 1;
        goto L13
    L17:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Destroying unknown cache " + cacheDir.getName());
        FileUtils.deleteContentsAndDir(cacheDir);
        goto L18
    L19:
        File cacheDir2 = FileUtils.createDir(cacheBaseDir, cacheName);
        if (cacheDir2 != null) goto L23;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Cache directory cannot be created - wiping base dir " + cacheBaseDir);
        FileUtils.deleteContentsAndDir(cacheBaseDir);
        return null;
    L23:
        if (isUserDebugBuild == true) goto L25;
        return cacheDir2;
    L25:
        if (incrementalVersion.startsWith("eng.") == false) goto L34;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Wiping cache directory because the system partition changed.");
        File frameworkDir = new File(Environment.getRootDirectory(), "framework");
        if (cacheDir2.lastModified() >= frameworkDir.lastModified()) goto L35;
        FileUtils.deleteContents(cacheBaseDir);
        return FileUtils.createDir(cacheBaseDir, cacheName);
    L35:
        return cacheDir2;
    L34:
        return cacheDir2;
    }

    public static void checkDowngrade(PackageSetting before, PackageInfoLite after) throws PackageManagerException {
        checkDowngrade(before.getVersionCode(), before.getBaseRevisionCode(), before.getSplitNames(), before.getSplitRevisionCodes(), after);
    }

    public static void checkDowngrade(AndroidPackage before, PackageInfoLite after) throws PackageManagerException {
        checkDowngrade(before.getLongVersionCode(), before.getBaseRevisionCode(), before.getSplitNames(), before.getSplitRevisionCodes(), after);
    }

    private static void checkDowngrade(long beforeVersionCode, int beforeBaseRevisionCode, String[] beforeSplitNames, int[] beforeSplitRevisionCodes, PackageInfoLite after) throws PackageManagerException {
        if (after.getLongVersionCode() < beforeVersionCode) goto L29;
        if (after.getLongVersionCode() == beforeVersionCode) goto L7;
        return;
    L7:
        if (after.baseRevisionCode < beforeBaseRevisionCode) goto L26;
        if (ArrayUtils.isEmpty(after.splitNames) == false) goto L11;
        return;
    L11:
        if (beforeSplitNames.length != beforeSplitRevisionCodes.length) goto L24;
        int i = 0;
    L14:
        if (i >= after.splitNames.length) goto L35;
        String splitName = after.splitNames[i];
        int j = ArrayUtils.indexOf(beforeSplitNames, splitName);
        if (j == (-1)) goto L22;
        if (after.splitRevisionCodes[i] >= beforeSplitRevisionCodes[j]) goto L22;
        throw new PackageManagerException(-25, "Update split " + splitName + " revision code " + after.splitRevisionCodes[i] + " is older than current " + beforeSplitRevisionCodes[j]);
    L22:
        i = i + 1;
        goto L14
    L35:
        return;
    L24:
        throw new PackageManagerException(-25, "Current split names and the split revision codes are not 1:1 mapping.This indicates that the package info data has been corrupted.");
    L26:
        throw new PackageManagerException(-25, "Update base revision code " + after.baseRevisionCode + " is older than current " + beforeBaseRevisionCode);
    L29:
        throw new PackageManagerException(-25, "Update version code " + after.versionCode + " is older than current " + beforeVersionCode);
    }

    public static boolean isInstalledByAdb(String initiatingPackageName) {
        if (initiatingPackageName != null) goto L4;
    L7:
        return true;
    L4:
        if ("com.android.shell".equals(initiatingPackageName) == true) goto L7;
        return false;
    }

    public static boolean extractAppMetadataFromApk(AndroidPackage pkg, String appMetadataFilePath, boolean isSystem) {
        if (appMetadataFilePath != null) goto L5;
        return false;
    L5:
        File appMetadataFile = new File(appMetadataFilePath);
        if (appMetadataFile.exists() == false) goto L8;
        return true;
    L8:
        Map<String, PackageManager.Property> properties = pkg.getProperties();
        if (properties.containsKey("android.content.PROPERTY_ANDROID_SAFETY_LABEL") == true) goto L11;
        return false;
    L11:
        PackageManager.Property fileInApkProperty = properties.get("android.content.PROPERTY_ANDROID_SAFETY_LABEL");
        if (fileInApkProperty.isResourceId() == true) goto L15;
        return false;
    L15:
        if (isSystem == true) goto L17;
    L23:
        List<AndroidPackageSplit> splits = pkg.getSplits();
        AssetManager.Builder builder = new AssetManager.Builder();
        int i = 0;
    L25:
        if (i >= splits.size()) goto L31;
        builder.addApkAssets(ApkAssets.loadFromPath(splits.get(i).getPath()));     // Catch: IOException -> L28
    L30:
        i = i + 1;
    L29:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to load resources from APK " + splits.get(i).getPath());
        goto L30
    L31:
        AssetManager assetManager = builder.build();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        Resources res = new Resources(assetManager, displayMetrics, null);
        final AtomicBoolean copyFailed = new AtomicBoolean(false);
        InputStream in = res.openRawResource(fileInApkProperty.getResourceId());     // Catch: Throwable -> L76 Exception -> L78
    L109:
        FileOutputStream out = new FileOutputStream(appMetadataFile);     // Catch: Throwable -> L67
        if (isSystem == false) goto L102;
        FileUtils.copy(in, out);     // Catch: Throwable -> L39
    L44:
        Os.chmod(appMetadataFile.getAbsolutePath(), FrameworkStatsLog.DISPLAY_HBM_STATE_CHANGED);     // Catch: Throwable -> L58
        out.close();     // Catch: Throwable -> L56
        if (in == null) goto L54;
        in.close();     // Catch: Throwable -> L49 Exception -> L51
    L54:
        if (copyFailed.get() == false) goto L86;
    L55:
        appMetadataFile.delete();
    L86:
        return !copyFailed.get();
    L58:
        th = move-exception;
        Throwable r4 = th;
    L106:
        out.close();     // Catch: Throwable -> L64
    L114:
        throw r4;     // Catch: Throwable -> L56
    L64:
        th = move-exception;
        r4.addSuppressed(th);     // Catch: Throwable -> L56
        throw r4;     // Catch: Throwable -> L56
    L39:
        th = move-exception;
        r4 = th;
        goto L106
    L102:
        final long sizeLimit = PackageInstallerSession.getAppMetadataSizeLimit();     // Catch: Throwable -> L60
        final CancellationSignal signal = new CancellationSignal();     // Catch: Throwable -> L60
        FileUtils.copy(in, out, signal, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new PackageManagerServiceUtils$$ExternalSyntheticLambda2(sizeLimit, copyFailed, signal));     // Catch: Throwable -> L58
    L60:
        th = move-exception;
        r4 = th;
    L56:
        th = move-exception;
        Throwable r5 = th;
    L69:
        if (in == null) goto L115;
        in.close();     // Catch: Throwable -> L72
        throw r5;     // Catch: Throwable -> L49 Exception -> L51
    L72:
        th = move-exception;
        r5.addSuppressed(th);     // Catch: Throwable -> L49 Exception -> L51
        throw r5;     // Catch: Throwable -> L49 Exception -> L51
    L115:
        throw r5;     // Catch: Throwable -> L49 Exception -> L51
    L67:
        th = move-exception;
        r5 = th;
    L51:
        e = e;
    L81:
        Slog.e(PackageManagerServiceMonitorEx.TAG, e.getMessage());     // Catch: Throwable -> L49
        copyFailed.set(true);     // Catch: Throwable -> L49
        if (copyFailed.get() == false) goto L86;
    L49:
        th = th;
    L88:
        if (copyFailed.get() == false) goto L90;
        appMetadataFile.delete();
    L90:
        throw th;
    L78:
        e = e;
    L76:
        th = th;
        goto L88
    L17:
        if (appMetadataFile.getParentFile().exists() == true) goto L23;
        makeDirRecursive(appMetadataFile.getParentFile(), 448);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to create app metadata dir for package " + pkg.getPackageName() + ": " + e.getMessage());
        return false;
    }

    private static /* synthetic */ void lambda$extractAppMetadataFromApk$2(long sizeLimit, AtomicBoolean copyFailed, CancellationSignal signal, long progress) {
        if (progress <= sizeLimit) goto L6;
        copyFailed.set(true);
        signal.cancel();
        return;
    }

    public static void linkFilesToOldDirs(Installer installer, String packageName, File newPath, Set<File> oldPaths) {
        if (oldPaths == null) goto L36;
        if (oldPaths.isEmpty() == false) goto L7;
        return;
    L7:
        if (IncrementalManager.isIncrementalPath(newPath.getPath()) == false) goto L9;
        return;
    L9:
        File[] filesInNewPath = newPath.listFiles();
        if (filesInNewPath == null) goto L34;
        if (filesInNewPath.length == 0) goto L46;
        List<File> splitApks = new ArrayList();
        int r2 = filesInNewPath.length;
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L23;
        File file = filesInNewPath[r4];
        if (file.isDirectory() == true) goto L21;
        if (file.toString().endsWith(".apk") == false) goto L21;
        splitApks.add(file);
    L21:
        r4 = r4 + 1;
        goto L15
    L23:
        if (splitApks.isEmpty() == false) goto L25;
        return;
    L25:
        File[] splitApkNames = (File[]) splitApks.toArray(new File[0]);
        Iterator<File> r3 = oldPaths.iterator();
    L27:
        if (r3.hasNext() == false) goto L32;
        File oldPath = r3.next();
        if (oldPath.exists() == false) goto L27;
        Installer installer2 = installer;
        linkFilesAndSetModes(installer2, packageName, newPath, oldPath, splitApkNames, 420);
        linkNativeLibraries(installer2, packageName, newPath, oldPath, "lib");
        linkNativeLibraries(installer2, packageName, newPath, oldPath, "lib64");
        installer = installer2;
        goto L27
    L32:
        return;
    L46:
        return;
    L34:
        return;
    }

    private static void linkNativeLibraries(Installer installer, String packageName, File sourcePath, File targetPath, String libDirName) {
        File sourceLibDir = new File(sourcePath, libDirName);
        if (sourceLibDir.exists() == true) goto L5;
        return;
    L5:
        File targetLibDir = new File(targetPath, libDirName);
        if (targetLibDir.exists() == false) goto L32;
    L12:
        File[] archs = sourceLibDir.listFiles();
        if (archs != null) goto L15;
        return;
    L15:
        int r9 = archs.length;
        int r10 = 0;
    L16:
        if (r10 >= r9) goto L31;
        File arch = archs[r10];
        File targetArchDir = new File(targetLibDir, arch.getName());
        if (targetArchDir.exists() == false) goto L34;
    L23:
        File sourceArchDir = new File(sourceLibDir, arch.getName());
        File[] files = sourceArchDir.listFiles();
        if (files == null) goto L30;
        if (files.length == 0) goto L30;
        linkFilesAndSetModes(installer, packageName, sourceArchDir, targetArchDir, files, UnixStat.DEFAULT_DIR_PERM);
    L30:
        r10 = r10 + 1;
        goto L16
    L34:
        NativeLibraryHelper.createNativeLibrarySubdir(targetArchDir);     // Catch: IOException -> L21
    L21:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to create native library subdir at <" + targetArchDir + ">", e);
        goto L30
    L31:
        return;
    L32:
        NativeLibraryHelper.createNativeLibrarySubdir(targetLibDir);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to create native library dir at <" + targetLibDir + ">", e);
    }

    private static void linkFilesAndSetModes(Installer installer, String packageName, File sourcePath, File targetPath, File[] files, int mode) {
        File[] r1 = files;
        int r3 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L37;
        File file = r1[r4];
        String fileName = file.getName();
        File sourceFile = new File(sourcePath, fileName);
        File targetFile = new File(targetPath, fileName);
        if (targetFile.exists() == true) goto L7;
        installer.linkFile(packageName, fileName, sourcePath.getAbsolutePath(), targetPath.getAbsolutePath());     // Catch: Installer.InstallerException -> L17
        if (DEBUG == false) goto L38;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Linked <" + sourceFile + "> to <" + targetFile + ">");     // Catch: Installer.InstallerException -> L17
    L38:
        Os.chmod(targetFile.getAbsolutePath(), mode);     // Catch: ErrnoException -> L27
        if (SELinux.restorecon(targetFile) == true) goto L35;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to restorecon for linked file <" + targetFile + ">");
    L35:
        r4 = r4 + 1;
        r1 = files;
        r3 = r3;
    L27:
        e = e;
    L31:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to set mode for linked file <" + targetFile + ">", e);
    L29:
        e = e;
    L17:
        e = e;
    L34:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to link native library <" + sourceFile + "> to <" + targetFile + ">", e);
    L32:
        e = e;
        goto L34
    L7:
        if (DEBUG == false) goto L35;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Skipping existing linked file <" + targetFile + ">");
        goto L35
    }
}
