package com.bytedance.crypto.cloudsync;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public class DataCrypto {
    public static final String TAG = "DataCrypto";
    private static volatile DataCrypto dataCrypto;

    public DataCrypto() {
    }

    private byte[] bytesDecrypt(Context r6, int r7, String r8, byte[] r9) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        byte[] r0 = new byte[4];
        if (r9.length >= 4) goto L9;
        String r10 = TAG;
        StringBuilder r11 = new StringBuilder();
        String r12 = "Input data len is too short! len:";
    L5:
        StringBuilder r13 = r11.append(r12).append(r9.length);
    L6:
        String r14 = r13.toString();
    L7:
        LogUtils.e(r10, r14);
        return new byte[0];
    L9:
        System.arraycopy(r9, 0, r0, 0, 4);
        int r1 = CryptoUtils.byteArrayToInt(r0);
        if (r1 == 315429581) goto L13;
        r10 = TAG;
        r13 = new StringBuilder().append("Cannot parse input cipher data! magic:").append(r1);
        goto L6
    L13:
        if (r9.length >= 5) goto L15;
        r10 = TAG;
        r11 = new StringBuilder();
        r12 = "Input data len is too short!! len:";
        goto L5
    L15:
        int r15 = Byte.toUnsignedInt(r9[4]);
        if (r15 == 1) goto L21;
        if (r15 == 2) goto L21;
        r10 = TAG;
        r13 = new StringBuilder().append("Input cipher data version is wrong! version:").append(r15);
    L21:
        if (r9.length >= 17) goto L23;
        r10 = TAG;
        r11 = new StringBuilder();
        r12 = "Input data len is too short for iv! len:";
        goto L5
    L23:
        byte[] r3 = new byte[12];
        System.arraycopy(r9, 5, r3, 0, 12);
        if (r9.length >= 82) goto L26;
        r10 = TAG;
        r11 = new StringBuilder();
        r12 = "Input data len is too short for key cipher! len:";
        goto L5
    L26:
        byte[] r2 = new byte[65];
        System.arraycopy(r9, 17, r2, 0, 65);
        if (r9.length >= 98) goto L29;
        r10 = TAG;
        r11 = new StringBuilder();
        r12 = "Input data len is too short for data cipher! len:";
        goto L5
    L29:
        int r16 = r9.length - 82;
        byte[] r4 = new byte[r16];
        System.arraycopy(r9, 82, r4, 0, r16);
        String r17 = CloudConfig.getInstance().getPkgName(r8) + r8;
        byte[] r18 = SyncKeyManager.getInstance().decryptByKeyManager(r5, r8, r2, r17);
        if (r18 != null) goto L32;
    L41:
        r10 = TAG;
        r14 = "Data key decrypt failed!!";
        goto L7
    L32:
        if (r18.length == 0) goto L41;
        byte[] r19 = AES.gcmXcrypt(r7, r18, r17.getBytes(), r3, r4);
        if (r19 != null) goto L37;
    L40:
        r10 = TAG;
        r14 = "AES GCM decrypt failed!!";
        goto L7
    L37:
        if (r19.length == 0) goto L40;
        return r19;
    }

    private byte[] bytesEncrypt(Context r6, int r7, String r8, byte[] r9) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        byte[] r10 = CryptoUtils.generateSecureRandom(32);
        if (r10.length != 0) goto L8;
        String r11 = TAG;
        String r12 = "Generate data key failed!!";
    L5:
        LogUtils.e(r11, r12);
    L7:
        return new byte[0];
    L8:
        byte[] r2 = CryptoUtils.generateSecureRandom(12);
        if (r2.length != 0) goto L11;
        r11 = TAG;
        r12 = "Generate IV failed!!";
        goto L5
    L11:
        String r3 = CloudConfig.getInstance().getPkgName(r8) + r8;
        byte[] r13 = AES.gcmXcrypt(r7, r10, r3.getBytes(), r2, r9);
        if (r13 != null) goto L14;
    L27:
        r11 = TAG;
        r12 = "AES GCM encrypt failed!!";
        goto L5
    L14:
        if (r13.length == 0) goto L27;
        byte[] r14 = SyncKeyManager.getInstance().encryptByKeyManager(r5, r8, r10, r3);
        if (r14 != null) goto L19;
    L26:
        r11 = TAG;
        r12 = "Data key encrypt failed!!";
        goto L5
    L19:
        if (r14.length == 0) goto L26;
        if (r14.length == 65) goto L24;
        LogUtils.e(TAG, "Data key cipher length is error, length:" + r14.length);
        goto L7
    L24:
        byte[] r15 = new byte[(r14.length + 17) + r13.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_MAGIC_NUM), 0, r15, 0, 4);
        r15[4] = 2;
        System.arraycopy(r2, 0, r15, 5, 12);
        System.arraycopy(r14, 0, r15, 17, 65);
        System.arraycopy(r13, 0, r15, 82, r13.length);
        return r15;
    }

    private int checkInputParams(Context r3, int r4, String r5, byte[] r6) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")) != null) goto L7;
        String r2 = TAG;
        String r7 = "Context is null!!";
    L5:
        LogUtils.e(r2, r7);
        return -2;
    L7:
        if (r6 != null) goto L9;
    L28:
        r2 = TAG;
        r7 = "Input data is empty!!";
        goto L5
    L9:
        if (r6.length == 0) goto L28;
        if (r4 != 1) goto L14;
        int r0 = 1048576;
    L16:
        if (r6.length <= r0) goto L20;
        r2 = TAG;
        StringBuilder r8 = new StringBuilder().append("Input data is too large!! len:").append(r6.length);
    L18:
        r7 = r8.toString();
        goto L5
    L20:
        if (TextUtils.isEmpty(r5) == false) goto L22;
        r2 = TAG;
        r7 = "Input alias is empty!!";
        goto L5
    L22:
        if (r4 != 1) goto L24;
    L26:
        LogUtils.i(TAG, "Byte xcrypt params check ok, mode:" + r4 + ", alias:" + r5 + ", data len:" + r6.length);
        return 0;
    L24:
        if (r4 == 2) goto L26;
        r2 = TAG;
        r8 = new StringBuilder().append("Input mode is invalid!! mode:").append(r4);
        goto L18
    L14:
        r0 = 1048674;
        goto L16
    }

    private int checkInputParams(CryptoContext r5, int r6, InputStream r7, OutputStream r8) {
        if (r5 != null) goto L7;
        String r9 = TAG;
        String r10 = "CryptoContext is null!!";
    L5:
        LogUtils.e(r9, r10);
        return -2;
    L7:
        if (r7 == null) goto L33;
        if (r8 == null) goto L33;
        if (TextUtils.isEmpty(r5.getAppId()) == false) goto L14;
        r9 = TAG;
        r10 = "Input appid is empty!!";
        goto L5
    L14:
        if (r6 == 1) goto L34;
        if (r6 == 2) goto L34;
        r9 = TAG;
        StringBuilder r11 = new StringBuilder().append("Input mode is invalid!! mode:").append(r6);
    L18:
        r10 = r11.toString();
    L34:
        int r12 = r7.available();     // Catch: Exception -> L22
    L24:
        if (r6 != 1) goto L26;
        int r13 = 1073741824;
    L27:
        if (r12 == 0) goto L32;
        if (r12 > r13) goto L32;
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r6 + ", app:" + r5.getAppId() + ", data len:" + r12);
        return 0;
    L32:
        r9 = TAG;
        r11 = new StringBuilder().append("Input stream data is empty or too large, len:").append(r12);
        goto L18
    L26:
        r13 = 1074266130;
    L22:
        e = move-exception;
        LogUtils.e(TAG, "Input stream each block is encrypted, a TAG will be added to the ciphertexteach block is encrypted, a TAG will be added to the ciphertextatch exception:" + e.getMessage());
        r12 = 0;
    L33:
        r9 = TAG;
        r10 = "Input stream is null!!";
        goto L5
    }

    public static DataCrypto getInstance() {
        if (dataCrypto != null) goto L15;
        monitor-enter(DataCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (dataCrypto != null) goto L9;
        dataCrypto = new DataCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DataCrypto.class);     // Catch: Throwable -> L11
    L15:
        return dataCrypto;
    }

    public byte[] bytesXcrypt(Context r11, int r12, String r13, byte[] r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        int r0 = checkInputParams(r15, r12, r13, r14);
        if (r12 != 1) goto L5;
        int r2 = 4;
    L6:
        int r4 = r2;
        if (r0 == 0) goto L10;
        LogUtils.e(TAG, "Input param is invalid!!");
        EventTrace.eventTrace(r0, r4, r15.getPackageName(), r13, 0, 0);
        return new byte[0];
    L10:
        long r3 = System.currentTimeMillis();
        if (r12 != 1) goto L13;
        byte[] r10 = bytesEncrypt(r15, r12, r13, r14);
    L14:
        long r1 = System.currentTimeMillis() - r3;
        if (r10.length != 0) goto L17;
        int r5 = -4;
    L18:
        EventTrace.eventTrace(r5, r4, r15.getPackageName(), r13, r1, r14.length);
        return r10;
    L17:
        r5 = 0;
        goto L18
    L13:
        r10 = bytesDecrypt(r15, r12, r13, r14);
        goto L14
    L5:
        r2 = 5;
        goto L6
    }

    public int streamXcrypt(CryptoContext r21, int r22, InputStream r23, OutputStream r24) {
        int r2 = checkInputParams(r21, r22, r23, r24);
        if (r2 == 0) goto L6;
        LogUtils.e(TAG, "Input param is invalid!!");
        return r2;
    L6:
        long r9 = System.currentTimeMillis();
        int r11 = -4;
        if (r22 != 1) goto L49;
        SecretKey r6 = r21.getFileEncryptKey();
        LogUtils.d(TAG, "data key len:" + r6.getEncoded().length);
        byte[] r3 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L11
        r24.write(CryptoUtils.intToBytes(CryptoConst.STREAM_CIPHER_MAGIC_NUM));     // Catch: Exception -> L11
        r24.write(2);     // Catch: Exception -> L11
        r24.write(r3.length);     // Catch: Exception -> L11
        r24.write(r3);     // Catch: Exception -> L11
        int r0 = ChaCha20.encryptStreamWithPoly1305(r6, r3, 32768, r23.available(), r23, r24);     // Catch: Exception -> L11
    L10:
        r11 = r0;
    L35:
        long r4 = System.currentTimeMillis() - r9;
        int r19 = r23.available();     // Catch: Exception -> L38
    L40:
        if (r22 != 1) goto L42;
        int r1 = 6;
    L43:
        EventTrace.eventTrace(r11, r1, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r21.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName(), r21.getAppId(), r4, r19);
        LogUtils.i(TAG, "Stream xcrypt end. result:" + r11 + " cost time:" + r4);
        return r11;
    L42:
        r1 = 7;
    L38:
        e = move-exception;
        LogUtils.e(TAG, "Get input stream length failed, exception:" + e.getMessage());
        r19 = 0;
    L11:
        e = e;
        String r5 = TAG;
        StringBuilder r7 = new StringBuilder();
        String r8 = "Data encrypt failed! exception:";
    L34:
        LogUtils.e(r5, r7.append(r8).append(e.getMessage()).toString());
        goto L35
    L49:
        byte[] r10 = new byte[4];     // Catch: Exception -> L32
        r23.read(r10);     // Catch: Exception -> L32
        int r12 = CryptoUtils.byteArrayToInt(r10);     // Catch: Exception -> L32
        if (r12 == 313201323) goto L18;
        LogUtils.e(TAG, "Cannot parse input cipher data! magic:" + r12);     // Catch: Exception -> L32
        return -2;
    L18:
        int r13 = r23.read();     // Catch: Exception -> L32
        String r14 = TAG;     // Catch: Exception -> L32
        LogUtils.i(r14, "Cipher Version:" + r13);     // Catch: Exception -> L32
        if (r13 == 2) goto L23;
        if (r13 == 1) goto L23;
        LogUtils.e(r14, "Input cipher data version is wrong! version:" + r13);     // Catch: Exception -> L32
        return -2;
    L23:
        int r15 = r23.read();     // Catch: Exception -> L32
        LogUtils.d(r14, "ivLen:" + r15);     // Catch: Exception -> L32
        if (r15 == 12) goto L27;
        LogUtils.e(r14, "IV length is wrong! len:" + r15);     // Catch: Exception -> L32
        return -2;
    L27:
        byte[] r16 = new byte[r15];     // Catch: Exception -> L32
        r23.read(r16);     // Catch: Exception -> L32
        SecretKey r17 = r21.getFileEncryptKey();     // Catch: Exception -> L32
        LogUtils.d(r14, "data key len:" + r17.getEncoded().length);     // Catch: Exception -> L32
        if (r13 != 2) goto L30;
        r0 = ChaCha20.decryptStreamWithPoly1305(r17, r16, 32768, r23.available(), r23, r24);     // Catch: Exception -> L32
        goto L10
    L30:
        r0 = ChaCha20.decryptStream(r17, r16, r23, r24);     // Catch: Exception -> L32
    L32:
        e = e;
        r5 = TAG;
        r7 = new StringBuilder();
        r8 = "Data decrypt failed! exception:";
        goto L34
    }
}
