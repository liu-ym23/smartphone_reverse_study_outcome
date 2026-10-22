package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.fekwrap.FekWrapErrorCode;
import com.bytedance.crypto.fekwrap.FekWrapResult;
import com.bytedance.crypto.keymanager.AttestKeyManager;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f7843a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f7845b;

        public a(int r1, byte[] r2) {
            this.f7844a = r1;
            this.f7845b = r2;
        }
    }

    public d() {
    }

    public static FekWrapResult a(int r2, String r3) {
        return new FekWrapResult(r2, r3, new byte[0]);
    }

    public static d a() {
        if (f7843a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7843a != null) goto L9;
        f7843a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f7843a;
    }

    public int a(Context r2, InputStream r3, OutputStream r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L12;
        if (r3 == null) goto L12;
        if (r4 == null) goto L12;
        if (r5 == null) goto L12;
        if (r5.isEmpty() == true) goto L12;
        return c.a(r1, r3, r4, r5, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    L12:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    }

    public ModelInitResult a(Context r9, String r10, String r11, Bundle r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L38:
        LogUtils.e("ModelDistributionManagerImpl", "Input params is invalid.");
        return new ModelInitResult(-2, "");
    L5:
        if (c.a(r10) == false) goto L38;
        if (r12 == null) goto L38;
        boolean r2 = false;
        int r13 = r12.getInt(ModelDistConst.KEY_ATTEST_STRATEGY, 0);
        FrameworkSecurityCompat.KmResult r0 = FrameworkSecurityCompat.getCertificateChain(r1, r10, new Bundle());
        List<Certificate> r3 = r0.getCertChain();
        if (r0.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L14;
        if (r3 == null) goto L14;
        if (r3.size() != 4) goto L14;
        r2 = true;
    L14:
        if (r2 == false) goto L22;
        if (r13 != 1) goto L19;
        return c.a(r3, true);
    L19:
        if (r13 != 2) goto L22;
        return new ModelInitResult(-13, "");
    L22:
        LogUtils.i("ModelDistributionManagerImpl", "Regenerate the certificate chain.");
        List<Certificate> r14 = null;
        if (c.a(r10) == true) goto L40;
        String r8 = "Invalid input params.";
    L25:
        LogUtils.e("ModelDistUtils", r8);
    L37:
        return c.a(r14, true);
    L40:
        AttestKeyManager r4 = AttestKeyManager.getInstance();     // Catch: Exception -> L34
        r4.deleteAttestKey(r1, r10);     // Catch: Exception -> L34
        Bundle r5 = new Bundle();     // Catch: Exception -> L34
        r5.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Exception -> L34
        r5.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Exception -> L34
        r5.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY());     // Catch: Exception -> L34
        List<Certificate> r15 = r4.getAttestCertChain(r1, r10, r11, true, r5);     // Catch: Exception -> L34
        if (r15 != null) goto L29;
    L32:
        LogUtils.e("ModelDistUtils", "The issued certificate chain is invalid.");     // Catch: Exception -> L34
        goto L37
    L29:
        if (r15.size() != 4) goto L32;
        r14 = r15;
    L34:
        e = move-exception;
        r8 = "generateCertChain failed, exception: " + e.getMessage();
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int a(InputStream r17) {
        ConcurrentHashMap<String, Object> r1 = c.f7842a;
        if (r17 != null) goto L5;
        LogUtils.e("ModelDistUtils", "InputStream is null!!");
        return -2;
    L5:
        DataInputStream r4 = new DataInputStream(r17);
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L49
        int r6 = r4.readInt();     // Catch: Exception -> L49
        if (r6 == 329978795) goto L10;
        StringBuilder r2 = new StringBuilder().append("Model magic number mismatch, excepted: 329978795, actually: ");     // Catch: Exception -> L49
        int r7 = r6;
    L9:
        StringBuilder r3 = r2.append(r7);     // Catch: Exception -> L49
    L47:
        LogUtils.e("ModelDistUtils", r3.toString());     // Catch: Exception -> L49
    L51:
        g r5 = null;
    L52:
        if (r5 != null) goto L54;
        LogUtils.e("ModelDistUtils", "Parse model signature info failed!!");
        return -8;
    L54:
        LogUtils.d("ModelDistUtils", "modelSignatureInfo.getModelDigest()" + CryptoUtils.byteArrayToHexString(r5.f7851a));
        X509Certificate r8 = CertUtils.pemStringToX509("-----BEGIN CERTIFICATE-----\nMIIChDCCAgugAwIBAgIUGCf2KtXCv2wJLJDhPWmqC4NogUcwCgYIKoZIzj0EAwMw\nWzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSQwIgYDVQQDExtCeXRlRGFuY2UgU21hcnQgRGV2aWNlIFJvb3QwHhcN\nMjUwMjI3MDQxNzI0WhcNNDUxMjMxMTYwMDAwWjBXMRIwEAYDVQQKEwlCeXRlRGFu\nY2UxHzAdBgNVBAsTFkJ5dGVEYW5jZSBTbWFydCBEZXZpY2UxIDAeBgNVBAMTF0J5\ndGVEYW5jZSBTbWFydCBTSUdOIENBMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE\nqEY1tOqjueVxviuVOIBdV+g2BqMOKTRYmTSx0vC9M2fKGCcJeFE32VqtYPtvyDgB\nmVZbvZYxnwdo6dx0MD6RtKOBsDCBrTAOBgNVHQ8BAf8EBAMCAYYwDwYDVR0TAQH/\nBAUwAwEB/zAdBgNVHQ4EFgQUYCEn27oKiFHtO+Q1xHonw5OL4QEwHwYDVR0jBBgw\nFoAU7K7HzdlIzACUAX0TGkAcXyFk6yQwSgYIKwYBBQUHAQEEPjA8MDoGCCsGAQUF\nBzABhi5odHRwOi8vbmV4dXMtcHJvZHVjdGlvbi5ieXRlZGFuY2UubmV0L3BjYS9v\nY3NwMAoGCCqGSM49BAMDA2cAMGQCMEafgMxo9+h04fWDCdF46K2II1RrOC9BUrRS\n50o7HM4wRjYNXTsF11J2enOaTzixzwIwL9l+Hq3OlSYLvRTOnIRD+DmpeSeTsbaV\nrMdjGbg1eRm2P59lkfFFES1BssyzQ5xd\n-----END CERTIFICATE-----");
        if (r8 != null) goto L59;
        LogUtils.e("ModelDistUtils", "Load the preset server signing certificate failed!!");
    L57:
        return -11;
    L59:
        if (CertUtils.validateCertChain(r8, r5.f7853c) == true) goto L62;
        LogUtils.e("ModelDistUtils", "Certificate verification failed!!");
        goto L57
    L62:
        if (CryptoUtils.verifyECDSASignature(((X509Certificate) ZeusTransformUtils.preCheckCast(r5.f7853c.get(0), X509Certificate.class, "com.obric.aiagent.plugin")).getPublicKey(), r5.f7851a, r5.f7852b, "NONEwithECDSA") == true) goto L65;
        LogUtils.e("ModelDistUtils", "Signature verification failed!!");
        return -12;
    L65:
        return 0;
    L10:
        r0.update(CryptoUtils.intToBytes(r6));     // Catch: Exception -> L49
        byte r9 = r4.readByte();     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "version: " + r9);     // Catch: Exception -> L49
        r0.update(r9);     // Catch: Exception -> L49
        int r10 = r4.readByte();     // Catch: Exception -> L49
        if (r10 == 12) goto L13;
        r2 = new StringBuilder().append("Invalid iv len: ");     // Catch: Exception -> L49
        r7 = r10;
        goto L9
    L13:
        LogUtils.d("ModelDistUtils", "dataIVLen: " + r10);     // Catch: Exception -> L49
        r0.update(r10);     // Catch: Exception -> L49
        byte[] r11 = new byte[r10];     // Catch: Exception -> L49
        r4.readFully(r11);     // Catch: Exception -> L49
        r0.update(r11);     // Catch: Exception -> L49
        int r12 = r4.readInt();     // Catch: Exception -> L49
        if (r12 > 0) goto L16;
    L46:
        r2 = new StringBuilder().append("Invalid blockSize: ");     // Catch: Exception -> L49
        r7 = r12;
        goto L9
    L16:
        if (r12 > 1048576) goto L46;
        LogUtils.d("ModelDistUtils", "blockSize: " + r12);     // Catch: Exception -> L49
        r0.update(CryptoUtils.intToBytes(r12));     // Catch: Exception -> L49
        int r13 = r4.readInt();     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "cipherLen: " + r13);     // Catch: Exception -> L49
        r0.update(CryptoUtils.intToBytes(r13));     // Catch: Exception -> L49
        byte[] r14 = new byte[32768];     // Catch: Exception -> L49
        long r15 = 0;
        long r16 = 0;
    L19:
        long r18 = r13;
        if (r16 >= r18) goto L24;
        int r19 = r13;
        int r20 = r4.read(r14, 0, (int) Math.min(32768, r18 - r16));     // Catch: Exception -> L49
        if (r20 == (-1)) goto L24;
        r0.update(r14, 0, r20);     // Catch: Exception -> L49
        r16 = r16 + ((long) r20);     // Catch: Exception -> L49
        r13 = r19;
    L24:
        long r21 = r4.readLong();     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "plainDataLen: " + r21);     // Catch: Exception -> L49
        r0.update(CryptoUtils.longToBytes(r21));     // Catch: Exception -> L49
    L26:
        if (r15 >= r21) goto L30;
        int r110 = r4.read(r14, 0, (int) Math.min(32768, r21 - r15));     // Catch: Exception -> L49
        if (r110 == (-1)) goto L30;
        r0.update(r14, 0, r110);     // Catch: Exception -> L49
        r15 = r15 + ((long) r110);     // Catch: Exception -> L49
    L30:
        byte[] r22 = r0.digest();     // Catch: Exception -> L49
        int r23 = r4.readInt();     // Catch: Exception -> L49
        if (r23 > 0) goto L33;
    L45:
        StringBuilder r24 = new StringBuilder().append("Invalid signatureLen: ");     // Catch: Exception -> L49
    L44:
        r3 = r24.append(r23);     // Catch: Exception -> L49
        goto L47
    L33:
        if (r23 > 128) goto L45;
        byte[] r25 = new byte[r23];     // Catch: Exception -> L49
        r4.readFully(r25);     // Catch: Exception -> L49
        LogUtils.d("ModelDistUtils", "signatureLen: " + r23);     // Catch: Exception -> L49
        r23 = r4.readInt();     // Catch: Exception -> L49
        if (r23 <= 0) goto L43;
        if (r23 > 32768) goto L43;
        LogUtils.d("ModelDistUtils", "certificateLen: " + r23);     // Catch: Exception -> L49
        byte[] r26 = new byte[r23];     // Catch: Exception -> L49
        r4.readFully(r26);     // Catch: Exception -> L49
        List<X509Certificate> r27 = CertUtils.convertToX509Certificates(r26);     // Catch: Exception -> L49
        if (r27.size() != 1) goto L51;
        LogUtils.d("ModelDistUtils", "certificates.size(): " + r27.size());     // Catch: Exception -> L49
        r5 = new g(r22, r25, r27);     // Catch: Exception -> L49
    L43:
        r24 = new StringBuilder().append("Invalid certificateLen: ");     // Catch: Exception -> L49
    L49:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed, exception: " + e.getMessage());
        goto L51
    }

    public final a a(Context r6, String r7, String r8) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        byte[] r0 = null;
        f r9 = c.a(r7, ModelDistConst.EPHEMERAL_PUBLIC_KEY);     // Catch: Throwable -> L41
        if (r9 != null) goto L8;
        LogUtils.e("ModelDistributionManagerImpl", "Parse model key cipher failed.");     // Catch: Throwable -> L41
        return new a(-8, null);
    L8:
        Bundle r2 = new Bundle();     // Catch: Throwable -> L41
        r2.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Throwable -> L41
        r2.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Throwable -> L41
        FrameworkSecurityCompat.KmResult r10 = FrameworkSecurityCompat.keyAgreement(r5, r8, CryptoUtils.hexStringToByteArray(r9.f7850c), r2);     // Catch: Throwable -> L41
        if (r10 != null) goto L11;
    L37:
        if (r10 == null) goto L40;
        LogUtils.e("ModelDistributionManagerImpl", "keyAgreement failed, system errorCode: " + r10.getResultCode());     // Catch: Throwable -> L41
    L40:
        return new a(-2005, null);
    L11:
        if (r10.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L37;
        byte[] r11 = r10.getOutData();     // Catch: Throwable -> L41
        if (r11 != null) goto L45;
    L31:
        a r12 = new a(-2005, null);     // Catch: Throwable -> L35
        if (r11 == null) goto L34;
        Arrays.fill(r11, (byte) 0);
    L34:
        return r12;
    L45:
    L35:
        th = move-exception;
        r0 = r11;
        th = th;
    L42:
        if (r0 == null) goto L44;
        Arrays.fill(r0, (byte) 0);
    L44:
        throw th;
    L16:
        if (r11.length == 0) goto L31;
        byte[] r13 = AES.gcmXcrypt(2, r11, null, r9.f7848a, r9.f7849b);     // Catch: Throwable -> L35
        if (r13 != null) goto L21;
    L26:
        if (r13 == null) goto L28;
        Arrays.fill(r13, (byte) 0);     // Catch: Throwable -> L35
    L28:
        LogUtils.e("ModelDistributionManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");     // Catch: Throwable -> L35
        a r14 = new a(FekWrapErrorCode.DATA_KEY_DECRYPT_FAILED, null);     // Catch: Throwable -> L35
        Arrays.fill(r11, (byte) 0);
        return r14;
    L21:
        if (r13.length != 32) goto L26;
        a r15 = new a(0, r13);     // Catch: Throwable -> L35
        Arrays.fill(r11, (byte) 0);
        return r15;
    L41:
        th = th;
        goto L42
    }
}
