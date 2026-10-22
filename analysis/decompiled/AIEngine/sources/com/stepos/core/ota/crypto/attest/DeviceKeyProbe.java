package com.stepos.core.ota.crypto.attest;

import ai.onnxruntime.a;
import android.os.Build;
import android.os.SystemClock;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import b6.e;
import b6.i;
import com.stepos.core.ota.crypto.ModelKeystoreManager;
import com.stepos.core.ota.crypto.attest.KeyAttestation;
import com.stepos.core.ota.d;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceKeyProbe {
    private static final String ALIAS_EC = "aiengine_probe_ec";
    private static final String ALIAS_RSA = "aiengine_probe_rsa";
    private static final String KEYSTORE = "AndroidKeyStore";
    private static final String PROBE_DEVICE_APP_ID = "model-device";
    private static final String PROBE_DEVICE_ID = "probe-oaid-0000";
    private static final int PROBE_KEY_EPOCH = 1;
    public static final DeviceKeyProbe INSTANCE = new DeviceKeyProbe();
    private static final SecureRandom rnd = new SecureRandom();

    private DeviceKeyProbe() {
    }

    private final String b64u(byte[] bArr) {
        String strEncodeToString = Base64.encodeToString(bArr, 11);
        g.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    private final String describe(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String message = th.getMessage();
        if (message == null) {
            message = "(no message)";
        }
        return d.i(simpleName, ": ", message);
    }

    private final void dumpAttestation(PrintWriter printWriter, X509Certificate x509Certificate) {
        Object objA;
        try {
            objA = AttestationParser.INSTANCE.parse(x509Certificate);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            d.r("  attestation parse FAILED: ", INSTANCE.describe(thB), printWriter);
            return;
        }
        KeyAttestation keyAttestation = (KeyAttestation) objA;
        if (keyAttestation == null) {
            printWriter.println("  attestation extension absent");
            return;
        }
        printWriter.println("  attestation extension (OID 1.3.6.1.4.1.11129.2.1.17):");
        printWriter.println("    attestationVersion       : " + keyAttestation.getAttestationVersion());
        printWriter.println("    attestationSecurityLevel : " + keyAttestation.getAttestationSecurityLevel());
        printWriter.println("    keymasterVersion         : " + keyAttestation.getKeymasterVersion());
        printWriter.println("    keymasterSecurityLevel   : " + keyAttestation.getKeymasterSecurityLevel());
        printWriter.println(a.i("    attestationChallenge     : ", keyAttestation.getChallenge().length, hex(keyAttestation.getChallenge()), " (", " bytes)"));
        String uniqueIdHex = keyAttestation.getUniqueIdHex();
        if (uniqueIdHex.length() == 0) {
            uniqueIdHex = "(empty)";
        }
        printWriter.println("    uniqueId                 : " + ((Object) uniqueIdHex));
        dumpAuthList(printWriter, "softwareEnforced", keyAttestation.getSoftwareEnforced());
        dumpAuthList(printWriter, "teeEnforced", keyAttestation.getTeeEnforced());
    }

    private final void dumpAuthList(PrintWriter printWriter, String str, KeyAttestation.AuthorizationList authorizationList) {
        printWriter.println("    " + str + ":");
        if (!authorizationList.getPurposes().isEmpty()) {
            d.r("      purpose        : ", kotlin.collections.a.z0(authorizationList.getPurposes(), null, null, null, new e(3), 31), printWriter);
        }
        Long algorithm = authorizationList.getAlgorithm();
        if (algorithm != null) {
            d.r("      algorithm      : ", AttestationParser.INSTANCE.algorithmName(algorithm.longValue()), printWriter);
        }
        Long keySize = authorizationList.getKeySize();
        if (keySize != null) {
            h0.e.j("      keySize        : ", keySize.longValue(), printWriter);
        }
        if (!authorizationList.getDigests().isEmpty()) {
            d.r("      digest         : ", kotlin.collections.a.z0(authorizationList.getDigests(), null, null, null, new i(4), 31), printWriter);
        }
        if (!authorizationList.getPaddings().isEmpty()) {
            d.r("      padding        : ", kotlin.collections.a.z0(authorizationList.getPaddings(), null, null, null, new e(4), 31), printWriter);
        }
        Long ecCurve = authorizationList.getEcCurve();
        if (ecCurve != null) {
            d.r("      ecCurve        : ", AttestationParser.INSTANCE.ecCurveName(ecCurve.longValue()), printWriter);
        }
        if (authorizationList.getNoAuthRequired()) {
            printWriter.println("      noAuthRequired : true");
        }
        Long origin = authorizationList.getOrigin();
        if (origin != null) {
            d.r("      origin         : ", AttestationParser.INSTANCE.originName(origin.longValue()), printWriter);
        }
        Long osVersion = authorizationList.getOsVersion();
        if (osVersion != null) {
            h0.e.j("      osVersion      : ", osVersion.longValue(), printWriter);
        }
        Long osPatchLevel = authorizationList.getOsPatchLevel();
        if (osPatchLevel != null) {
            h0.e.j("      osPatchLevel   : ", osPatchLevel.longValue(), printWriter);
        }
        KeyAttestation.RootOfTrust rootOfTrust = authorizationList.getRootOfTrust();
        if (rootOfTrust != null) {
            printWriter.println("      rootOfTrust:");
            printWriter.println("        deviceLocked      : " + rootOfTrust.getDeviceLocked());
            printWriter.println("        verifiedBootState : " + rootOfTrust.getVerifiedBootState());
            printWriter.println("        verifiedBootKey   : " + rootOfTrust.getVerifiedBootKeyHex());
            String verifiedBootHashHex = rootOfTrust.getVerifiedBootHashHex();
            if (verifiedBootHashHex == null) {
                verifiedBootHashHex = "(absent)";
            }
            printWriter.println("        verifiedBootHash  : ".concat(verifiedBootHashHex));
        }
        KeyAttestation.AttestationApplicationId attestationApplicationId = authorizationList.getAttestationApplicationId();
        if (attestationApplicationId != null) {
            printWriter.println("      attestationApplicationId:");
            if (attestationApplicationId.getPackages().isEmpty()) {
                printWriter.println("        packages : (none) — ROM did not populate package info");
            } else {
                for (KeyAttestation.AttestationApplicationId.PackageInfo packageInfo : attestationApplicationId.getPackages()) {
                    StringBuilder sbL = d.l("        package  : ", packageInfo.getVersion(), packageInfo.getPackageName(), " (version ");
                    sbL.append(")");
                    printWriter.println(sbL.toString());
                }
            }
            if (attestationApplicationId.getSignatureDigestsHex().isEmpty()) {
                printWriter.println("        sigDigest: (none) — ROM did not populate signing certificate digest");
            } else {
                Iterator<T> it = attestationApplicationId.getSignatureDigestsHex().iterator();
                while (it.hasNext()) {
                    d.r("        sigDigest: ", (String) it.next(), printWriter);
                }
            }
        }
        if (authorizationList.getOtherTags().isEmpty()) {
            return;
        }
        printWriter.println("      (other tags present: " + kotlin.collections.a.z0(kotlin.collections.a.H0(authorizationList.getOtherTags()), null, null, null, null, 63) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpAuthList$lambda$48(long j10) {
        return AttestationParser.INSTANCE.purposeName(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpAuthList$lambda$51(long j10) {
        return AttestationParser.INSTANCE.digestName(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpAuthList$lambda$52(long j10) {
        return AttestationParser.INSTANCE.paddingName(j10);
    }

    private final void dumpChain(PrintWriter printWriter, Certificate[] certificateArr, boolean z, boolean z3) {
        printWriter.println();
        if (certificateArr == null || certificateArr.length == 0) {
            printWriter.println("chain       : NONE — getCertificateChain returned ".concat(certificateArr == null ? "null" : "empty"));
            return;
        }
        printWriter.println("chain       : " + certificateArr.length + " certificate(s)");
        int i10 = 0;
        Certificate certificate = certificateArr[0];
        g.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate x509Certificate = (X509Certificate) certificate;
        boolean z10 = x509Certificate.getExtensionValue(AttestationParser.ATTESTATION_OID) != null;
        StringBuilder sbM = d.m("self-check  : ", (certificateArr.length < 2 || !z10) ? "FAIL" : "PASS", " — size>=2:", ", leaf has attestation OID:", certificateArr.length >= 2);
        sbM.append(z10);
        printWriter.println(sbM.toString());
        if (!z) {
            printWriter.println("              (key was generated WITHOUT attestation, degraded path)");
        }
        int length = certificateArr.length;
        int i11 = 0;
        while (i10 < length) {
            Certificate certificate2 = certificateArr[i10];
            int i12 = i11 + 1;
            g.d(certificate2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate2 = (X509Certificate) certificate2;
            String str = i11 == 0 ? "leaf" : i11 == certificateArr.length - 1 ? "root (NOT uploaded)" : "intermediate";
            printWriter.println();
            printWriter.println("  [" + i11 + "] " + str);
            Principal subjectDN = x509Certificate2.getSubjectDN();
            StringBuilder sb2 = new StringBuilder("      subject : ");
            sb2.append(subjectDN);
            printWriter.println(sb2.toString());
            printWriter.println("      issuer  : " + x509Certificate2.getIssuerDN());
            printWriter.println("      serial  : " + x509Certificate2.getSerialNumber().toString(16));
            printWriter.println("      sigAlg  : " + x509Certificate2.getSigAlgName());
            printWriter.println("      validity: " + x509Certificate2.getNotBefore() + " .. " + x509Certificate2.getNotAfter());
            printWriter.println("      der     : " + x509Certificate2.getEncoded().length + " bytes");
            if (z3) {
                d.r("      base64  : ", Base64.encodeToString(x509Certificate2.getEncoded(), 2), printWriter);
            }
            i10++;
            i11 = i12;
        }
        if (z10) {
            printWriter.println();
            dumpAttestation(printWriter, x509Certificate);
        } else {
            printWriter.println();
            printWriter.println("  attestation extension absent on leaf — device cannot produce an attested chain");
        }
    }

    private final Boolean generate(PrintWriter printWriter, String str, l<? super Boolean, KeyGenParameterSpec> lVar) {
        Object objA;
        Object objA2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str, "AndroidKeyStore");
            keyPairGenerator.initialize(lVar.invoke(Boolean.TRUE));
            objA = keyPairGenerator.generateKeyPair();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            printWriter.println("generate    : ok with attestation, " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
            return Boolean.TRUE;
        }
        Throwable thB = Result.b(objA);
        printWriter.println("generate    : attestation FAILED — " + (thB != null ? describe(thB) : null));
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance(str, "AndroidKeyStore");
            keyPairGenerator2.initialize(lVar.invoke(Boolean.FALSE));
            objA2 = keyPairGenerator2.generateKeyPair();
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        if (objA2 instanceof Result.Failure) {
            Throwable thB2 = Result.b(objA2);
            d.r("generate    : fallback also FAILED — ", thB2 != null ? describe(thB2) : null, printWriter);
            return null;
        }
        printWriter.println("generate    : fallback without attestation ok, " + (SystemClock.elapsedRealtime() - jElapsedRealtime2) + " ms");
        return Boolean.FALSE;
    }

    private final String hex(byte[] bArr) {
        g.f(bArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (byte b10 : bArr) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(hex$lambda$63(b10));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    private static final CharSequence hex$lambda$63(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final KeyStore keystore() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    }

    private final OAEPParameterSpec oaepSha256() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
    }

    private final void probeEc(PrintWriter printWriter, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        printWriter.println("--- [2] EC P-256 / PURPOSE_AGREE_KEY / ECDH ---");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            probeEcAgreement(printWriter, z);
            return;
        }
        printWriter.println("UNSUPPORTED : PURPOSE_AGREE_KEY requires API 31, this device is API " + i10);
        printWriter.println("              Keystore-held EC private keys cannot do ECDH below API 31");
    }

    private final void probeEcAgreement(PrintWriter printWriter, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keystore = keystore();
        keystore.deleteEntry(ALIAS_EC);
        try {
            byte[] bArrRandomChallenge = randomChallenge();
            printWriter.println("challenge   : " + hex(bArrRandomChallenge) + " (" + bArrRandomChallenge.length + " bytes)");
            Boolean boolGenerate = generate(printWriter, "EC", new androidx.compose.runtime.i(bArrRandomChallenge, 4));
            if (boolGenerate == null) {
                try {
                    keystore.deleteEntry(ALIAS_EC);
                    n nVar = n.f10413a;
                    return;
                } catch (Throwable th) {
                    c.a(th);
                    return;
                }
            }
            boolean zBooleanValue = boolGenerate.booleanValue();
            Certificate certificate = keystore.getCertificate(ALIAS_EC);
            g.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            PublicKey publicKey = ((X509Certificate) certificate).getPublicKey();
            g.e(publicKey, "getPublicKey(...)");
            PublicKey publicKeyRebuild = rebuild(publicKey, "EC");
            printWriter.println("SPKI DER    : " + publicKeyRebuild.getEncoded().length + " bytes");
            printWriter.println("fingerprint : " + spkiFingerprint(publicKeyRebuild));
            runEcies(printWriter, keystore, publicKeyRebuild);
            dumpChain(printWriter, keystore.getCertificateChain(ALIAS_EC), zBooleanValue, z);
        } finally {
            try {
                keystore.deleteEntry(ALIAS_EC);
                n nVar2 = n.f10413a;
            } catch (Throwable th2) {
                c.a(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyGenParameterSpec probeEcAgreement$lambda$19(byte[] bArr, boolean z) {
        KeyGenParameterSpec.Builder userAuthenticationRequired = new KeyGenParameterSpec.Builder(ALIAS_EC, 64).setAlgorithmParameterSpec(new ECGenParameterSpec(ModelKeystoreManager.CURVE)).setDigests("SHA-256").setUserAuthenticationRequired(false);
        if (z) {
            userAuthenticationRequired.setAttestationChallenge(bArr);
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = userAuthenticationRequired.build();
        g.e(keyGenParameterSpecBuild, "build(...)");
        return keyGenParameterSpecBuild;
    }

    private final void probeRsa(PrintWriter printWriter, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        printWriter.println("--- [1] RSA-2048 / PURPOSE_DECRYPT / OAEP ---");
        KeyStore keystore = keystore();
        keystore.deleteEntry(ALIAS_RSA);
        try {
            byte[] bArrRandomChallenge = randomChallenge();
            printWriter.println("challenge   : " + hex(bArrRandomChallenge) + " (" + bArrRandomChallenge.length + " bytes)");
            Boolean boolGenerate = generate(printWriter, "RSA", new androidx.compose.runtime.g(bArrRandomChallenge, 5));
            if (boolGenerate == null) {
                try {
                    keystore.deleteEntry(ALIAS_RSA);
                    n nVar = n.f10413a;
                    return;
                } catch (Throwable th) {
                    c.a(th);
                    return;
                }
            }
            boolean zBooleanValue = boolGenerate.booleanValue();
            Certificate certificate = keystore.getCertificate(ALIAS_RSA);
            g.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            PublicKey publicKey = ((X509Certificate) certificate).getPublicKey();
            g.e(publicKey, "getPublicKey(...)");
            PublicKey publicKeyRebuild = rebuild(publicKey, "RSA");
            printWriter.println("SPKI DER    : " + publicKeyRebuild.getEncoded().length + " bytes");
            printWriter.println("fingerprint : " + spkiFingerprint(publicKeyRebuild));
            sealAndUnsealRsa(printWriter, keystore, publicKeyRebuild);
            dumpChain(printWriter, keystore.getCertificateChain(ALIAS_RSA), zBooleanValue, z);
        } finally {
            try {
                keystore.deleteEntry(ALIAS_RSA);
                n nVar2 = n.f10413a;
            } catch (Throwable th2) {
                c.a(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyGenParameterSpec probeRsa$lambda$5(byte[] bArr, boolean z) {
        KeyGenParameterSpec.Builder userAuthenticationRequired = new KeyGenParameterSpec.Builder(ALIAS_RSA, 2).setKeySize(2048).setDigests("SHA-256").setEncryptionPaddings("OAEPPadding").setUserAuthenticationRequired(false);
        if (z) {
            userAuthenticationRequired.setAttestationChallenge(bArr);
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = userAuthenticationRequired.build();
        g.e(keyGenParameterSpecBuild, "build(...)");
        return keyGenParameterSpecBuild;
    }

    private final byte[] randomChallenge() {
        byte[] bArr = new byte[32];
        rnd.nextBytes(bArr);
        return bArr;
    }

    private final PublicKey rebuild(PublicKey publicKey, String str) throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(publicKey.getEncoded()));
        g.e(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    private final void reportLength(PrintWriter printWriter, String str, byte[] bArr, int i10) {
        CharSequence charSequenceSubSequence;
        int length = b64u(bArr).length();
        String strG = length == i10 ? "ok" : a.g(i10, "MISMATCH (contract ", ")");
        g.f(str, "<this>");
        if (12 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb2 = new StringBuilder(12);
            sb2.append((CharSequence) str);
            int length2 = 12 - str.length();
            int i11 = 1;
            if (1 <= length2) {
                while (true) {
                    sb2.append(' ');
                    if (i11 == length2) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            charSequenceSubSequence = sb2;
        }
        printWriter.println(charSequenceSubSequence.toString() + ": " + bArr.length + " bytes → " + length + " chars  " + strG);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void runEcies(java.io.PrintWriter r22, java.security.KeyStore r23, java.security.PublicKey r24) throws java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException, java.security.KeyStoreException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.attest.DeviceKeyProbe.runEcies(java.io.PrintWriter, java.security.KeyStore, java.security.PublicKey):void");
    }

    private final void sealAndUnsealRsa(PrintWriter printWriter, KeyStore keyStore, PublicKey publicKey) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        Object objA;
        Object objA2;
        Object objA3;
        String strK;
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = (byte) i10;
        }
        Key key = keyStore.getKey(ALIAS_RSA, null);
        g.d(key, "null cannot be cast to non-null type java.security.PrivateKey");
        PrivateKey privateKey = (PrivateKey) key;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
            cipher.init(1, publicKey, oaepSha256());
            objA = cipher.doFinal(bArr);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            d.r("seal        : FAIL ", INSTANCE.describe(thB), printWriter);
            return;
        }
        byte[] bArr2 = (byte[]) objA;
        printWriter.println("seal        : ok, ciphertext " + bArr2.length + " bytes");
        try {
            Cipher cipher2 = Cipher.getInstance("RSA/ECB/OAEPPadding");
            cipher2.init(2, privateKey, oaepSha256());
            objA2 = cipher2.doFinal(bArr2);
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        printWriter.println("unseal(spec): " + ((Object) (thB2 == null ? Arrays.equals((byte[]) objA2, bArr) ? "PASS — plaintext matches (32 bytes)" : "FAIL — plaintext differs" : a.k("FAIL ", INSTANCE.describe(thB2)))));
        try {
            Cipher cipher3 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher3.init(2, privateKey);
            objA3 = cipher3.doFinal(bArr2);
        } catch (Throwable th3) {
            objA3 = c.a(th3);
        }
        Throwable thB3 = Result.b(objA3);
        if (thB3 == null) {
            strK = "UNEXPECTED — decrypted without explicit spec, provider MGF1 default is SHA-256 here";
        } else {
            strK = a.k("as expected, failed — ", INSTANCE.describe(thB3));
        }
        printWriter.println("unseal(bare): " + ((Object) strK));
    }

    private final String spkiFingerprint(PublicKey publicKey) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(publicKey.getEncoded());
        g.e(bArrDigest, "digest(...)");
        return hex(bArrDigest);
    }

    public final void dump(PrintWriter writer, boolean z) {
        Object objA;
        Object objA2;
        g.f(writer, "writer");
        writer.println("=== Device key probe ===");
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String str3 = Build.DEVICE;
        StringBuilder sbS = a.s("device      : ", str, " ", str2, " (");
        sbS.append(str3);
        sbS.append(")");
        writer.println(sbS.toString());
        writer.println(a.i("android     : ", Build.VERSION.SDK_INT, Build.VERSION.RELEASE, " (API ", ")"));
        d.r("patch       : ", Build.VERSION.SECURITY_PATCH, writer);
        writer.println("fingerprint : " + Build.FINGERPRINT);
        writer.println();
        try {
            probeRsa(writer, z);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            d.r("  !! RSA probe aborted: ", INSTANCE.describe(thB), writer);
        }
        writer.println();
        try {
            probeEc(writer, z);
            objA2 = n.f10413a;
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        if (thB2 != null) {
            d.r("  !! EC probe aborted: ", INSTANCE.describe(thB2), writer);
        }
        writer.println();
        writer.println("=== probe end (probe aliases deleted) ===");
    }
}
