package com.android.server.pm;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.Checksum;
import android.content.pm.IOnChecksumsReadyListener;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.incremental.IncrementalManager;
import android.os.incremental.IncrementalStorage;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.util.apk.ApkSignatureSchemeV2Verifier;
import android.util.apk.ApkSignatureSchemeV3Verifier;
import android.util.apk.ApkSignatureSchemeV4Verifier;
import android.util.apk.ApkSignatureVerifier;
import android.util.apk.ApkSigningBlockUtils;
import android.util.apk.SignatureInfo;
import android.util.apk.SignatureNotFoundException;
import android.util.apk.VerityBuilder;
import com.android.internal.security.VerityUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ApkChecksums {
    static final String ALGO_MD5 = "MD5";
    static final String ALGO_SHA1 = "SHA1";
    static final String ALGO_SHA256 = "SHA256";
    static final String ALGO_SHA512 = "SHA512";
    private static final String DIGESTS_FILE_EXTENSION = ".digests";
    private static final String DIGESTS_SIGNATURE_FILE_EXTENSION = ".signature";
    private static final Certificate[] EMPTY_CERTIFICATE_ARRAY = null;
    static final int MAX_BUFFER_SIZE = 131072;
    private static final int MAX_SIGNATURE_SIZE_BYTES = 35840;
    static final int MIN_BUFFER_SIZE = 4096;
    private static final long PROCESS_REQUIRED_CHECKSUMS_DELAY_MILLIS = 1000;
    private static final long PROCESS_REQUIRED_CHECKSUMS_TIMEOUT_MILLIS = 86400000;
    static final String TAG = "ApkChecksums";

    static class Injector {
        private final Producer<Context> mContext;
        private final Producer<Handler> mHandlerProducer;
        private final Producer<IncrementalManager> mIncrementalManagerProducer;
        private final Producer<PackageManagerInternal> mPackageManagerInternalProducer;

        interface Producer<T> {
            T produce();
        }

        Injector(Producer<Context> context, Producer<Handler> handlerProducer, Producer<IncrementalManager> incrementalManagerProducer, Producer<PackageManagerInternal> packageManagerInternalProducer) {
            this.mContext = context;
            this.mHandlerProducer = handlerProducer;
            this.mIncrementalManagerProducer = incrementalManagerProducer;
            this.mPackageManagerInternalProducer = packageManagerInternalProducer;
        }

        public Context getContext() {
            return this.mContext.produce();
        }

        public Handler getHandler() {
            return this.mHandlerProducer.produce();
        }

        public IncrementalManager getIncrementalManager() {
            return this.mIncrementalManagerProducer.produce();
        }

        public PackageManagerInternal getPackageManagerInternal() {
            return this.mPackageManagerInternalProducer.produce();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$F-X-x3Vm6znwrAJ3_YRu0cbqhZQ, reason: not valid java name */
    public static /* synthetic */ void m6597$r8$lambda$FXx3Vm6znwrAJ3_YRu0cbqhZQ(List r0, List r1, int r2, IOnChecksumsReadyListener r3, Injector r4, long r5) {
        lambda$processRequiredChecksums$0(r0, r1, r2, r3, r4, r5);
    }

    public ApkChecksums() {
    }

    static {
        EMPTY_CERTIFICATE_ARRAY = new Certificate[0];
    }

    public static String buildDigestsPathForApk(String codePath) {
        if (ApkLiteParseUtils.isApkPath(codePath) == false) goto L7;
        return codePath.substring(0, codePath.length() - ".apk".length()) + DIGESTS_FILE_EXTENSION;
    L7:
        throw new IllegalStateException("Code path is not an apk " + codePath);
    }

    public static String buildSignaturePathForDigests(String digestsPath) {
        return digestsPath + DIGESTS_SIGNATURE_FILE_EXTENSION;
    }

    public static boolean isDigestOrDigestSignatureFile(File file) {
        String name = file.getName();
        if (name.endsWith(DIGESTS_FILE_EXTENSION) == false) goto L5;
    L8:
        return true;
    L5:
        if (name.endsWith(DIGESTS_SIGNATURE_FILE_EXTENSION) == true) goto L8;
        return false;
    }

    public static File findDigestsForFile(File targetFile) {
        String digestsPath = buildDigestsPathForApk(targetFile.getAbsolutePath());
        File digestsFile = new File(digestsPath);
        if (digestsFile.exists() == true) goto L7;
        return null;
    L7:
        return digestsFile;
    }

    public static File findSignatureForDigests(File digestsFile) {
        String signaturePath = buildSignaturePathForDigests(digestsFile.getAbsolutePath());
        File signatureFile = new File(signaturePath);
        if (signatureFile.exists() == true) goto L7;
        return null;
    L7:
        return signatureFile;
    }

    public static void writeChecksums(OutputStream os, Checksum[] checksums) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);
        int r1 = checksums.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        Checksum checksum = checksums[r2];     // Catch: Throwable -> L7
        Checksum.writeToStream(dos, checksum);     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L9:
        dos.close();
        return;
    L7:
        th = move-exception;
        dos.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    private static Checksum[] readChecksums(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        Checksum[] r1 = readChecksums(is);     // Catch: Throwable -> L6
        is.close();
        return r1;
    L6:
        th = move-exception;
        is.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public static Checksum[] readChecksums(InputStream is) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        ArrayList<Checksum> checksums = new ArrayList();     // Catch: Throwable -> L9
        int i = 0;
    L6:
        if (i >= 100) goto L14;
        checksums.add(Checksum.readFromStream(dis));     // Catch: Throwable -> L9 EOFException -> L11
        i = i + 1;
    L14:
        Checksum[] r2 = (Checksum[]) checksums.toArray(new Checksum[checksums.size()]);     // Catch: Throwable -> L9
        dis.close();
        return r2;
    L9:
        th = move-exception;
        dis.close();     // Catch: Throwable -> L19
    L21:
        throw th;
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    }

    public static Certificate[] verifySignature(Checksum[] checksums, byte[] signature) throws NoSuchAlgorithmException, IOException, SignatureException {
        if (signature == null) goto L35;
        if (signature.length > MAX_SIGNATURE_SIZE_BYTES) goto L35;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        writeChecksums(os, checksums);     // Catch: Throwable -> L28
        byte[] blob = os.toByteArray();     // Catch: Throwable -> L28
        os.close();
        PKCS7 pkcs7 = new PKCS7(signature);
        Certificate[] certs = pkcs7.getCertificates();
        if (certs == null) goto L27;
        if (certs.length == 0) goto L27;
        SignerInfo[] signerInfos = pkcs7.verify(blob);
        if (signerInfos == null) goto L25;
        if (signerInfos.length == 0) goto L25;
        ArrayList<Certificate> certificates = new ArrayList(signerInfos.length);
        int r5 = signerInfos.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L23;
        SignerInfo signerInfo = signerInfos[r6];
        ArrayList<X509Certificate> chain = signerInfo.getCertificateChain(pkcs7);
        if (chain == null) goto L21;
        certificates.addAll(chain);
        r6 = r6 + 1;
        goto L16
    L21:
        throw new SignatureException("Verification passed, but certification chain is empty.");
    L23:
        return (Certificate[]) certificates.toArray(new Certificate[certificates.size()]);
    L25:
        throw new SignatureException("Verification failed");
    L27:
        throw new SignatureException("Signature missing certificates");
    L28:
        th = move-exception;
        os.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        th.addSuppressed(th);
    L35:
        throw new SignatureException("Invalid signature");
    }

    public static void getChecksums(List<Pair<String, File>> filesToChecksum, int optional, int required, String installerPackageName, Certificate[] trustedInstallers, IOnChecksumsReadyListener onChecksumsReadyListener, Injector injector) {
        List<Map<Integer, ApkChecksum>> result = new ArrayList(filesToChecksum.size());
        int size = filesToChecksum.size();
        int i = 0;
    L3:
        if (i >= size) goto L10;
        String split = (String) filesToChecksum.get(i).first;
        File file = (File) filesToChecksum.get(i).second;
        Map<Integer, ApkChecksum> checksums = new ArrayMap();
        result.add(checksums);
        getAvailableApkChecksums(split, file, optional | required, installerPackageName, trustedInstallers, checksums, injector);     // Catch: Throwable -> L7
    L9:
        i = i + 1;
    L7:
        e = move-exception;
        Slog.e(TAG, "Preferred checksum calculation error", e);
        goto L9
    L10:
        long startTime = SystemClock.uptimeMillis();
        processRequiredChecksums(filesToChecksum, result, required, onChecksumsReadyListener, injector, startTime);
    }

    private static void processRequiredChecksums(List<Pair<String, File>> filesToChecksum, final List<Map<Integer, ApkChecksum>> result, final int required, final IOnChecksumsReadyListener onChecksumsReadyListener, final Injector injector, final long startTime) {
        final List<Pair<String, File>> r1 = filesToChecksum;
        if ((SystemClock.uptimeMillis() - startTime) < 86400000) goto L5;
        boolean r0 = true;
    L6:
        boolean timeout = r0;
        List<ApkChecksum> allChecksums = new ArrayList();
        int size = r1.size();
        int i = 0;
    L8:
        if (i >= size) goto L36;
        String split = (String) r1.get(i).first;
        File file = (File) r1.get(i).second;
        Map<Integer, ApkChecksum> checksums = result.get(i);
        if (timeout == false) goto L40;
        if (required != 0) goto L40;
    L38:
        allChecksums.addAll(checksums.values());     // Catch: Throwable -> L21
    L29:
        i = i + 1;
        r1 = filesToChecksum;
        timeout = timeout;
    L21:
        e = th;
    L28:
        Slog.e(TAG, "Required checksum calculation error", e);
    L40:
    L23:
        e = th;
        timeout = timeout;
        goto L28
    L16:
        if (needToWait(file, required, checksums, injector) == false) goto L25;
        timeout = timeout;
        injector.getHandler().postDelayed(new ApkChecksums$$ExternalSyntheticLambda0(r1, result, required, onChecksumsReadyListener, injector, startTime), 1000);     // Catch: Throwable -> L21
        return;
    L25:
        getRequiredApkChecksums(split, file, required, checksums);     // Catch: Throwable -> L21
        goto L38
    L36:
        onChecksumsReadyListener.onChecksumsReady(allChecksums);     // Catch: RemoteException -> L33
        return;
    L33:
        e = move-exception;
        Slog.w(TAG, e);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static /* synthetic */ void lambda$processRequiredChecksums$0(List filesToChecksum, List result, int required, IOnChecksumsReadyListener onChecksumsReadyListener, Injector injector, long startTime) {
        processRequiredChecksums(filesToChecksum, result, required, onChecksumsReadyListener, injector, startTime);
    }

    private static void getAvailableApkChecksums(String split, File file, int types, String installerPackageName, Certificate[] trustedInstallers, Map<Integer, ApkChecksum> checksums, Injector injector) {
        if (file.exists() == true) goto L5;
        return;
    L5:
        String filePath = file.getAbsolutePath();
        if (isRequired(1, types, checksums) == false) goto L11;
        ApkChecksum checksum = extractHashFromFS(split, filePath);
        if (checksum == null) goto L11;
        checksums.put(Integer.valueOf(checksum.getType()), checksum);
    L11:
        if (isRequired(32, types, checksums) == false) goto L13;
    L14:
        Map<Integer, ApkChecksum> v2v3checksums = extractHashFromV2V3Signature(split, filePath, types);
        if (v2v3checksums == null) goto L17;
        checksums.putAll(v2v3checksums);
    L17:
        getInstallerChecksums(split, file, types, installerPackageName, trustedInstallers, checksums, injector);
        return;
    L13:
        if (isRequired(64, types, checksums) == false) goto L17;
        goto L14
    }

    private static void getInstallerChecksums(String split, File file, int types, String installerPackageName, Certificate[] trustedInstallers, Map<Integer, ApkChecksum> checksums, Injector injector) {
        if (PackageManagerServiceUtils.isInstalledByAdb(installerPackageName) == false) goto L5;
        return;
    L5:
        if (trustedInstallers != null) goto L7;
    L9:
        File digestsFile = findDigestsForFile(file);
        if (digestsFile != null) goto L12;
        return;
    L12:
        File signatureFile = findSignatureForDigests(digestsFile);
        Checksum[] digests = readChecksums(digestsFile);     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        if (signatureFile == null) goto L32;
        Certificate[] certificates = verifySignature(digests, Files.readAllBytes(signatureFile.toPath()));     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        if (certificates == null) goto L30;
        if (certificates.length == 0) goto L30;
        Signature[] certs = new Signature[certificates.length];     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        int i = 0;
        int size = certificates.length;     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
    L21:
        if (i >= size) goto L29;
        certs[i] = new Signature(certificates[i].getEncoded());     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        i = i + 1;     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        goto L21
    L29:
        Signature[] pastCerts = null;
    L106:
        if (certs == null) goto L89;
        if (certs.length == 0) goto L89;
        if (certs[0] == null) goto L89;
        byte[] trustedCertBytes = certs[0].toByteArray();     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        Set<Signature> trusted = convertToSet(trustedInstallers);     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        if (trusted != null) goto L46;
    L53:
        int r12 = digests.length;     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        int r13 = 0;
    L54:
        if (r13 >= r12) goto L63;
        Checksum digest = digests[r13];     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        ApkChecksum system = checksums.get(Integer.valueOf(digest.getType()));     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        if (system == null) goto L62;
        if (Arrays.equals(system.getValue(), digest.getValue()) == true) goto L62;
        throw new InvalidParameterException("System digest " + digest.getType() + " mismatch, can't bind installer-provided digests to the APK.");     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
    L62:
        r13 = r13 + 1;     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        goto L54
    L63:
        int r2 = digests.length;     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        int r9 = 0;
    L64:
        if (r9 >= r2) goto L101;
        Checksum digest2 = digests[r9];     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
    L82:
        e = e;
    L100:
        Slog.e(TAG, "Error reading .digests or .signature", e);
    L80:
        e = e;
    L92:
        Slog.e(TAG, "Error validating digests. Invalid digests will be removed", e);
        Files.deleteIfExists(digestsFile.toPath());     // Catch: IOException -> L97
        if (signatureFile == null) goto L101;
        Files.deleteIfExists(signatureFile.toPath());     // Catch: IOException -> L97
    L78:
        e = e;
    L91:
        Slog.e(TAG, "Error encoding trustedInstallers", e);
        return;
    L68:
        if (isRequired(digest2.getType(), types, checksums) == false) goto L85;
    L71:
        checksums.put(Integer.valueOf(digest2.getType()), new ApkChecksum(split, digest2, installerPackageName, trustedCertBytes));     // Catch: CertificateEncodingException -> L72 Throwable -> L74 IOException -> L76
    L85:
        r9 = r9 + 1;     // Catch: CertificateEncodingException -> L72 Throwable -> L74 IOException -> L76
        r2 = r2;
    L101:
        return;
    L46:
        if (trusted.isEmpty() == true) goto L53;
        Signature trustedCert = isTrusted(certs, trusted);     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        if (trustedCert != null) goto L50;
        trustedCert = isTrusted(pastCerts, trusted);     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
    L50:
        if (trustedCert != null) goto L52;
        return;
    L52:
        trustedCertBytes = trustedCert.toByteArray();     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
    L89:
        Slog.e(TAG, "Can't obtain certificates.");     // Catch: CertificateEncodingException -> L72 Throwable -> L74 IOException -> L76
        return;
    L76:
        e = e;
    L74:
        e = e;
    L72:
        e = e;
    L30:
        Slog.e(TAG, "Error validating signature");     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        return;
    L32:
        AndroidPackage installer = injector.getPackageManagerInternal().getPackage(installerPackageName);     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        if (installer != null) goto L36;
        Slog.e(TAG, "Installer package not found.");     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        return;
    L36:
        certs = installer.getSigningDetails().getSignatures();     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
        pastCerts = installer.getSigningDetails().getPastSigningCertificates();     // Catch: CertificateEncodingException -> L23 Throwable -> L25 IOException -> L27
    L27:
        e = e;
    L25:
        e = e;
    L23:
        e = e;
        goto L91
    L7:
        if (trustedInstallers.length != 0) goto L9;
    }

    private static boolean needToWait(File file, int types, Map<Integer, ApkChecksum> checksums, Injector injector) throws IOException {
        if (isRequired(1, types, checksums) == false) goto L5;
    L17:
        String filePath = file.getAbsolutePath();
        if (IncrementalManager.isIncrementalPath(filePath) == true) goto L20;
        return false;
    L20:
        IncrementalManager manager = injector.getIncrementalManager();
        if (manager != null) goto L24;
        Slog.e(TAG, "IncrementalManager is missing.");
        return false;
    L24:
        IncrementalStorage storage = manager.openStorage(filePath);
        if (storage != null) goto L29;
        Slog.e(TAG, "IncrementalStorage is missing for a path on IncFs: " + filePath);
        return false;
    L29:
        return true ^ storage.isFileFullyLoaded(filePath);
    L5:
        if (isRequired(2, types, checksums) == true) goto L17;
        if (isRequired(4, types, checksums) == true) goto L17;
        if (isRequired(8, types, checksums) == true) goto L17;
        if (isRequired(16, types, checksums) == true) goto L17;
        if (isRequired(32, types, checksums) == true) goto L17;
        if (isRequired(64, types, checksums) == true) goto L17;
        return false;
    }

    private static void getRequiredApkChecksums(String split, File file, int types, Map<Integer, ApkChecksum> checksums) {
        String filePath = file.getAbsolutePath();
        if (isRequired(1, types, checksums) == true) goto L10;
    L8:
        calculateChecksumIfRequested(checksums, split, file, types, 2);
        calculateChecksumIfRequested(checksums, split, file, types, 4);
        calculateChecksumIfRequested(checksums, split, file, types, 8);
        calculateChecksumIfRequested(checksums, split, file, types, 16);
        calculatePartialChecksumsIfRequested(checksums, split, file, types);
        return;
    L10:
        byte[] generatedRootHash = VerityBuilder.generateFsVerityRootHash(filePath, null, new AnonymousClass1());     // Catch: Throwable -> L6
        checksums.put(1, new ApkChecksum(split, 1, verityHashForFile(file, generatedRootHash)));     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Error calculating WHOLE_MERKLE_ROOT_4K_SHA256", e);
        goto L8
    }

    private static boolean isRequired(int type, int types, Map<Integer, ApkChecksum> checksums) {
        if ((types & type) != 0) goto L6;
        return false;
    L6:
        if (checksums.containsKey(Integer.valueOf(type)) == false) goto L8;
        return false;
    L8:
        return true;
    }

    private static Set<Signature> convertToSet(Certificate[] array) throws CertificateEncodingException {
        if (array != null) goto L5;
        return null;
    L5:
        Set<Signature> set = new ArraySet(array.length);
        int r1 = array.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        Certificate item = array[r2];
        set.add(new Signature(item.getEncoded()));
        r2 = r2 + 1;
        goto L6
    L8:
        return set;
    }

    private static Signature isTrusted(Signature[] signatures, Set<Signature> trusted) {
        if (signatures != null) goto L5;
        return null;
    L5:
        int r1 = signatures.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        Signature signature = signatures[r2];
        if (trusted.contains(signature) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return signature;
    L11:
        return null;
    }

    private static ApkChecksum extractHashFromFS(String split, String filePath) {
        if (VerityUtils.hasFsverity(filePath) == false) goto L21;
        byte[] verityHash = VerityUtils.getFsverityDigest(filePath);
        if (verityHash == null) goto L21;
        return new ApkChecksum(split, 1, verityHash);
    L21:
        ApkSignatureSchemeV4Verifier.VerifiedSigner signer = ApkSignatureSchemeV4Verifier.extractCertificates(filePath);     // Catch: Throwable -> L13 SignatureNotFoundException -> L15
        byte[] rootHash = (byte[]) signer.contentDigests.getOrDefault(3, null);     // Catch: Throwable -> L13 SignatureNotFoundException -> L15
        if (rootHash == null) goto L20;
        return new ApkChecksum(split, 1, verityHashForFile(new File(filePath), rootHash));
    L13:
        e = move-exception;
        Slog.e(TAG, "V4 signature error", e);
    L20:
        return null;
    }

    static byte[] verityHashForFile(File file, byte[] rootHash) {
        ByteBuffer buffer = ByteBuffer.allocate(256);     // Catch: NoSuchAlgorithmException -> L7
        buffer.order(ByteOrder.LITTLE_ENDIAN);     // Catch: NoSuchAlgorithmException -> L7
        buffer.put((byte) 1);     // Catch: NoSuchAlgorithmException -> L7
        buffer.put((byte) 1);     // Catch: NoSuchAlgorithmException -> L7
        buffer.put((byte) 12);     // Catch: NoSuchAlgorithmException -> L7
        buffer.put((byte) 0);     // Catch: NoSuchAlgorithmException -> L7
        buffer.putInt(0);     // Catch: NoSuchAlgorithmException -> L7
        buffer.putLong(file.length());     // Catch: NoSuchAlgorithmException -> L7
        buffer.put(rootHash);     // Catch: NoSuchAlgorithmException -> L7
        int i = 0;
    L5:
        if (i >= 208) goto L9;
        buffer.put((byte) 0);     // Catch: NoSuchAlgorithmException -> L7
        i = i + 1;     // Catch: NoSuchAlgorithmException -> L7
        goto L5
    L9:
        buffer.flip();     // Catch: NoSuchAlgorithmException -> L7
        MessageDigest md = MessageDigest.getInstance(ALGO_SHA256);     // Catch: NoSuchAlgorithmException -> L7
        md.update(buffer);     // Catch: NoSuchAlgorithmException -> L7
        return md.digest();
    L7:
        e = move-exception;
        Slog.e(TAG, "Device does not support MessageDigest algorithm", e);
        return null;
    }

    private static Map<Integer, ApkChecksum> extractHashFromV2V3Signature(String split, String filePath, int types) {
        Map<Integer, byte[]> contentDigests = null;
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<ApkSignatureVerifier.SigningDetailsWithDigests> result = ApkSignatureVerifier.verifySignaturesInternal(input, filePath, 2, false);
        if (result.isError() == true) goto L5;
        contentDigests = ((ApkSignatureVerifier.SigningDetailsWithDigests) result.getResult()).contentDigests;
    L9:
        if (contentDigests != null) goto L11;
        return null;
    L11:
        Map<Integer, ApkChecksum> checksums = new ArrayMap();
        if ((types & 32) == 0) goto L17;
        byte[] hash = contentDigests.getOrDefault(1, null);
        if (hash == null) goto L17;
        checksums.put(32, new ApkChecksum(split, 32, hash));
    L17:
        if ((types & 64) == 0) goto L21;
        byte[] hash2 = contentDigests.getOrDefault(2, null);
        if (hash2 == null) goto L21;
        checksums.put(64, new ApkChecksum(split, 64, hash2));
    L21:
        return checksums;
    L5:
        if ((result.getException() instanceof SignatureNotFoundException) == true) goto L9;
        Slog.e(TAG, "Signature verification error", result.getException());
        goto L9
    }

    private static String getMessageDigestAlgoForChecksumKind(int type) throws NoSuchAlgorithmException {
        switch(type) {
            case 2: goto L11;
            case 4: goto L9;
            case 8: goto L7;
            case 16: goto L5;
            default: goto L4;
        };
    L5:
        return ALGO_SHA512;
    L7:
        return ALGO_SHA256;
    L9:
        return ALGO_SHA1;
    L11:
        return ALGO_MD5;
    L4:
        throw new NoSuchAlgorithmException("Invalid checksum type: " + type);
    }

    private static void calculateChecksumIfRequested(Map<Integer, ApkChecksum> checksums, String split, File file, int required, int type) {
        if ((required & type) != 0) goto L5;
        return;
    L5:
        if (checksums.containsKey(Integer.valueOf(type)) == true) goto L11;
        byte[] checksum = getApkChecksum(file, type);
        if (checksum == null) goto L12;
        checksums.put(Integer.valueOf(type), new ApkChecksum(split, type, checksum));
        return;
    L12:
        return;
    }

    private static byte[] getApkChecksum(File file, int type) {
        int bufferSize = (int) Math.max(4096, Math.min(131072, file.length()));
        FileInputStream fis = new FileInputStream(file);     // Catch: NoSuchAlgorithmException -> L13 IOException -> L15
        byte[] buffer = new byte[bufferSize];     // Catch: Throwable -> L8
        String algo = getMessageDigestAlgoForChecksumKind(type);     // Catch: Throwable -> L8
        MessageDigest md = MessageDigest.getInstance(algo);     // Catch: Throwable -> L8
    L5:
        int nread = fis.read(buffer);     // Catch: Throwable -> L8
        if (nread == (-1)) goto L10;
        md.update(buffer, 0, nread);     // Catch: Throwable -> L8
        goto L5
    L10:
        byte[] r8 = md.digest();     // Catch: Throwable -> L8
        fis.close();     // Catch: NoSuchAlgorithmException -> L13 IOException -> L15
        return r8;
    L8:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: NoSuchAlgorithmException -> L13 IOException -> L15
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NoSuchAlgorithmException -> L13 IOException -> L15
    L15:
        e = move-exception;
        Slog.e(TAG, "Error reading " + file.getAbsolutePath() + " to compute hash.", e);
        return null;
    L13:
        e = move-exception;
        Slog.e(TAG, "Device does not support MessageDigest algorithm", e);
        return null;
    }

    private static int[] getContentDigestAlgos(boolean needSignatureSha256, boolean needSignatureSha512) {
        if (needSignatureSha256 == false) goto L7;
        if (needSignatureSha512 == false) goto L7;
        return new int[]{1, 2};
    L7:
        if (needSignatureSha256 == false) goto L11;
        return new int[]{1};
    L11:
        return new int[]{2};
    }

    private static int getChecksumKindForContentDigestAlgo(int contentDigestAlgo) {
        switch(contentDigestAlgo) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 64;
    L7:
        return 32;
    }

    private static void calculatePartialChecksumsIfRequested(Map<Integer, ApkChecksum> checksums, String split, File file, int required) {
        boolean needSignatureSha512 = false;
        if ((required & 32) != 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean needSignatureSha256 = r0;
        if ((required & 64) != 0) goto L11;
    L15:
        if (needSignatureSha256 == true) goto L73;
        if (needSignatureSha512 == true) goto L73;
        return;
    L73:
        RandomAccessFile raf = new RandomAccessFile(file, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: Throwable -> L36
        SignatureInfo signatureInfo = null;
        signatureInfo = ApkSignatureSchemeV3Verifier.findSignature(raf);     // Catch: Throwable -> L24 SignatureNotFoundException -> L27
    L32:
        if (signatureInfo != null) goto L38;
        Slog.e(TAG, "V2/V3 signatures not found in " + file.getAbsolutePath());     // Catch: Throwable -> L24
        raf.close();     // Catch: Throwable -> L36 Throwable -> L36
        return;
    L38:
        int[] digestAlgos = getContentDigestAlgos(needSignatureSha256, needSignatureSha512);     // Catch: Throwable -> L24
        byte[][] digests = ApkSigningBlockUtils.computeContentDigestsPer1MbChunk(digestAlgos, raf.getFD(), signatureInfo);     // Catch: Throwable -> L24
        int i = 0;
        int size = digestAlgos.length;     // Catch: Throwable -> L24
    L39:
        if (i >= size) goto L51;
        int checksumKind = getChecksumKindForContentDigestAlgo(digestAlgos[i]);     // Catch: Throwable -> L24
        if (checksumKind == (-1)) goto L49;
        checksums.put(Integer.valueOf(checksumKind), new ApkChecksum(split, checksumKind, digests[i]));     // Catch: Throwable -> L46
    L46:
        th = th;
    L26:
        Throwable r7 = th;
        raf.close();     // Catch: Throwable -> L57
        throw r7;     // Catch: Throwable -> L53 Throwable -> L53
    L57:
        th = move-exception;
        r7.addSuppressed(th);     // Catch: Throwable -> L53 Throwable -> L53
        throw r7;     // Catch: Throwable -> L53 Throwable -> L53
    L49:
        i = i + 1;
        goto L39
    L51:
        raf.close();     // Catch: Throwable -> L53
        return;
    L53:
        e = e;
    L62:
        Slog.e(TAG, "Error computing hash.", e);
        return;
    L64:
        signatureInfo = ApkSignatureSchemeV2Verifier.findSignature(raf);     // Catch: Throwable -> L24 SignatureNotFoundException -> L31
    L24:
        th = th;
    L36:
        e = e;
    L60:
        e = e;
        goto L62
    L11:
        if (checksums.containsKey(64) == true) goto L15;
        needSignatureSha512 = true;
        goto L15
    L5:
        if (checksums.containsKey(32) == true) goto L7;
        r0 = true;
        goto L8
    }
}
