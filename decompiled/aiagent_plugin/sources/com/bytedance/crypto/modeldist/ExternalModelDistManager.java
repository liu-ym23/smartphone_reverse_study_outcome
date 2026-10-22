package com.bytedance.crypto.modeldist;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.engine.KeyPairHelper;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.d;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.obfuscated.f;
import com.bytedance.crypto.obfuscated.j;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ExternalModelDistManager {
    public static final String TAG = "ExternalModelDistManager";
    private static volatile ExternalModelDistManager externalModelDistManager;

    private ExternalModelDistManager() {
    }

    public static ExternalModelDistManager getInstance() {
        if (externalModelDistManager != null) goto L15;
        monitor-enter(ExternalModelDistManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (externalModelDistManager != null) goto L9;
        externalModelDistManager = new ExternalModelDistManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExternalModelDistManager.class);     // Catch: Throwable -> L11
    L15:
        return externalModelDistManager;
    }

    public long calculateModelSize(InputStream r8) {
        d.a().getClass();
        ConcurrentHashMap<String, Object> r7 = c.f7842a;
        if (r8 != null) goto L38;
        LogUtils.e("ModelDistUtils", "InputStream is null.");
        return -2;
    L38:
        DataInputStream r0 = new DataInputStream(r8);     // Catch: IOException -> L32
        e r9 = c.a(r0);     // Catch: Throwable -> L26
        if (r9 != null) goto L9;
        String r10 = "parseModelHeader failed.";
    L17:
        LogUtils.e("ModelDistUtils", r10);     // Catch: Throwable -> L26
        long r1 = -8;
    L24:
        r0.close();     // Catch: IOException -> L32
        return r1;
    L9:
        int r2 = r0.readInt();     // Catch: Throwable -> L26
        if (r2 >= 0) goto L14;
        StringBuilder r11 = new StringBuilder().append("Model cipher length is invalid: ").append(r2);     // Catch: Throwable -> L26
    L13:
        r10 = r11.toString();     // Catch: Throwable -> L26
        goto L17
    L14:
        r0.skip(r2);     // Catch: Throwable -> L26
        long r3 = r0.readLong();     // Catch: Throwable -> L26
        if (r3 >= 0) goto L18;
        r11 = new StringBuilder().append("Model cipher length is invalid: ").append(r3);     // Catch: Throwable -> L26
        goto L13
    L18:
        int r12 = r9.f7847b;     // Catch: Throwable -> L26
        int r4 = r12 + 16;     // Catch: Throwable -> L26
        int r5 = r2 / r4;     // Catch: Throwable -> L26
        int r6 = r2 % r4;     // Catch: Throwable -> L26
        int r13 = r5 * r12;
        if (r6 == 0) goto L23;
        r13 = r13 + (r6 - 16);
    L23:
        r1 = ((long) r13) + r3;
    L26:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: IOException -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "calculateModelSize failed, exception: " + e.getMessage());
        return -100;
    }

    public int checkModelIntegrity(InputStream r1) {
        return d.a().a(r1);
    }

    public int decryptModelFile(Context r2, InputStream r3, OutputStream r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return d.a().a(r1, r3, r4, r5);
    }

    public int deleteAttestKey(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.a().getClass();
        if (r1 != null) goto L5;
    L8:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    L5:
        if (c.a(r3) == false) goto L8;
        KeyPairHelper.deleteKey(r3);
        return 0;
    }

    public ModelInitResult initModelRequest(Context r6, String r7, Bundle r8) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.a().getClass();
        if (r5 != null) goto L5;
    L35:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new ModelInitResult(-2, "");
    L5:
        if (c.a(r7) == false) goto L35;
        if (r8 == null) goto L35;
        int r9 = r8.getInt(ModelDistConst.KEY_ATTEST_STRATEGY, 0);
        Certificate[] r10 = null;
        Certificate[] r2 = KeyPairHelper.getCertificateChain(r7);     // Catch: CloudTransException -> L11
    L13:
        if (r2 != null) goto L15;
    L21:
        String r11 = ChallengeManager.requestChallenge();
        if (r11 != null) goto L24;
    L30:
        String r12 = "Request challenge failed!!";
    L31:
        LogUtils.e("ModelDistUtils", r12);
    L32:
        if (r10 != null) goto L44;
        return new ModelInitResult(-100, "");
    L44:
        return c.a(Arrays.asList(r10), false);
    L24:
        if (r11.isEmpty() == true) goto L30;
        KeyPairHelper.deleteKey(r7);     // Catch: CloudTransException -> L28
        KeyPairHelper.generateECDSAKeyPair(r7, r11);     // Catch: CloudTransException -> L28
        r10 = KeyPairHelper.getCertificateChain(r7);     // Catch: CloudTransException -> L28
    L28:
        e = move-exception;
        r12 = "generateECDSAKeyPair failed, errorCode: " + e.getErrorCode() + ", message: " + e.getMessage();
        goto L31
    L15:
        if (r9 != 1) goto L18;
        return c.a(Arrays.asList(r2), false);
    L18:
        if (r9 == 2) goto L42;
        LogUtils.i("ModelDistributionManagerImpl", "Re-generating certificate chain as per strategy.");
        goto L21
    L42:
        return new ModelInitResult(-13, "");
    L11:
        e = move-exception;
        LogUtils.e("ModelDistributionManagerImpl", "getCertificateChain of alias: " + r7 + " failed, exception: " + e.getMessage());
        r2 = null;
        goto L13
    }

    public String reEncryptFEK(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.a().getClass();
        if (r3 != null) goto L5;
    L30:
        String r7 = "Invalid input params.";
    L31:
        LogUtils.e("ModelDistributionManagerImpl", r7);
        return null;
    L5:
        if (c.a(r5) == false) goto L30;
        if (r6 == null) goto L30;
        LogUtils.d("ModelDistributionManagerImpl", "reEncryptFEK keyInfo: " + r6);
        f r8 = c.a(r6, ModelDistConst.EPHEMERAL_PUBLIC_KEY);
        if (r8 != null) goto L33;
        LogUtils.e("ModelDistributionManagerImpl", "Parse model key cipher failed!!");
        return null;
    L33:
        byte[] r9 = ECDHHelper.generateSharedSecret(KeyPairHelper.loadKeyPair(r5).getPrivate(), CryptoUtils.byteArrayToECPublicKey(CryptoUtils.hexStringToByteArray(r8.f7850c)));     // Catch: Exception -> L25 CloudTransException -> L27
        LogUtils.d("ModelDistributionManagerImpl", "sharedSecret.length: " + r9.length);     // Catch: Exception -> L25 CloudTransException -> L27
        byte[] r10 = AES.gcmXcrypt(2, r9, null, r8.f7848a, r8.f7849b);
        if (r10.length == 32) goto L15;
        r7 = "decrypt dataKeyCipher failed or dataKey length invalid";
        goto L31
    L15:
        j r11 = c.b(r3, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
        if (r11 != null) goto L18;
        r7 = "prepareExternalDeviceKey failed.";
        goto L31
    L18:
        byte[] r12 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r11.f), null, CryptoUtils.hexStringToByteArray(r11.f7866d), r10);
        if (r12 != null) goto L21;
    L24:
        r7 = "Re-encrypt FEK failed.";
        goto L31
    L21:
        if (r12.length == 0) goto L24;
        return CryptoUtils.byteArrayToHexString(r12);
    L27:
        e = move-exception;
        StringBuilder r13 = new StringBuilder().append("loadKeyPair failed, errorCode: ").append(e.getErrorCode());
        String r14 = ", message: ";
        Exception r15 = e;
    L29:
        r7 = r13.append(r14).append(r15.getMessage()).toString();
    L25:
        e = move-exception;
        r13 = new StringBuilder();
        r14 = "generateSharedSecret failed, exception: ";
        r15 = e;
        goto L29
    }
}
