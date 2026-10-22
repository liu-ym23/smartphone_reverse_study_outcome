package com.bytedance.crypto.engine;

import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class ChaCha20 {
    public static final String TAG = "ChaCha20";

    public ChaCha20() {
    }

    public static int decryptStream(SecretKey r2, byte[] r3, InputStream r4, OutputStream r5) {
        return decryptStreamFull((SecretKey) ZeusTransformUtils.wrapperContextForParams(r2, SecretKey.class, "com.obric.aiagent.plugin"), "ChaCha20", r3, r4, r5);
    }

    private static int decryptStreamBlock(SecretKey r6, String r7, byte[] r8, int r9, int r10, InputStream r11, OutputStream r12) {
        SecretKey r13 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r6, SecretKey.class, "com.obric.aiagent.plugin");
        if (r9 <= 1048576) goto L7;
        String r14 = TAG;
        StringBuilder r15 = new StringBuilder().append("blockSize: ").append(r9).append(" exceeds the maximum:").append(1048576);
    L5:
        LogUtils.e(r14, r15.toString());
        return -2;
    L7:
        if (r10 > 0) goto L9;
        r14 = TAG;
        r15 = new StringBuilder().append("input data length: ").append(r10);
        goto L5
    L9:
        int r0 = r9 + 16;
        byte[] r2 = new byte[r0];     // Catch: Exception -> L16
        byte[] r16 = new byte[r9];     // Catch: Exception -> L16
        Cipher r17 = Cipher.getInstance(r7);     // Catch: Exception -> L16
        r17.init(2, r13, new IvParameterSpec(r8));     // Catch: Exception -> L16
    L11:
        if (r10 <= 0) goto L23;
        int r18 = r11.read(r2, 0, Math.min(r0, r10));     // Catch: Exception -> L16
        if (r18 <= 0) goto L24;
        int r19 = r17.doFinal(r2, 0, r18, r16);     // Catch: Exception -> L16
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r19);     // Catch: Exception -> L16
        r12.write(r16, 0, r19);     // Catch: Exception -> L16
        r10 = r10 - r18;
        goto L11
    L24:
        return 0;
    L23:
        return 0;
    L16:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockDynamic(SecretKey r6, String r7, byte[] r8, byte[] r9, int r10, InputStream r11, OutputStream r12) {
        SecretKey r13 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r6, SecretKey.class, "com.obric.aiagent.plugin");
        if (r10 <= 1048576) goto L6;
        LogUtils.e(TAG, "blockSize: " + r10 + " exceeds the maximum:1048576");
        return -2;
    L6:
        byte[] r0 = new byte[4];
        String r1 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r1, "key:" + CryptoUtils.byteArrayToHexString(r13.getEncoded()));     // Catch: Exception -> L28
        LogUtils.d(r1, "iv:" + CryptoUtils.byteArrayToHexString(r8));     // Catch: Exception -> L28
        LogUtils.d(r1, "aad:" + new String(r9, StandardCharsets.UTF_8));     // Catch: Exception -> L28
    L9:
        if (r11.read(r0) == (-1)) goto L26;
        int r2 = CryptoUtils.byteArrayToInt(r0);     // Catch: Exception -> L28
        String r3 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r3, "readLen:" + r2);     // Catch: Exception -> L28
        if (r2 <= 0) goto L24;
        if (r2 > (r10 + 16)) goto L24;
        byte[] r4 = new byte[r2];     // Catch: Exception -> L28
        if (r11.read(r4) == (-1)) goto L23;
        Cipher r5 = Cipher.getInstance(r7);     // Catch: Exception -> L28
        r5.init(2, r13, new IvParameterSpec(r8));     // Catch: Exception -> L28
        if (r9 == null) goto L22;
        if (r9.length <= 0) goto L22;
        r5.updateAAD(r9);     // Catch: Exception -> L28
    L22:
        r12.write(r5.doFinal(r4));     // Catch: Exception -> L28
        goto L9
    L23:
        return -8;
    L24:
        LogUtils.e(r3, "read buffer len error, len:" + r2);     // Catch: Exception -> L28
        return -8;
    L26:
        r12.flush();     // Catch: Exception -> L28
        return 0;
    L28:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockLong(SecretKey r16, String r17, byte[] r18, int r19, long r20, InputStream r22, OutputStream r23) {
        long r1 = r20;
        SecretKey r3 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r16, SecretKey.class, "com.obric.aiagent.plugin");
        if (r19 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r19 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r1 > 0) goto L10;
        LogUtils.e(TAG, "input data length: " + r1);
        return -2;
    L10:
        int r4 = r19 + 16;
        int r7 = 0;
        byte[] r9 = new byte[r4];     // Catch: Exception -> L22
        byte[] r0 = new byte[r19];     // Catch: Exception -> L22
        Cipher r10 = Cipher.getInstance(r17);     // Catch: Exception -> L22
        r10.init(2, r3, new IvParameterSpec(r18));     // Catch: Exception -> L22
    L13:
        if (r1 <= 0) goto L28;
        int r5 = r22.read(r9, 0, (int) Math.min(r4, r1));     // Catch: Exception -> L22
        if (r5 <= 0) goto L28;
        int r12 = r10.doFinal(r9, 0, r5, r0);     // Catch: Exception -> L22
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r12);     // Catch: Exception -> L22
        r23.write(r0, 0, r12);     // Catch: Exception -> L22
        r1 = r1 - ((long) r5);
    L28:
        LogUtils.i(TAG, "ChaCha20 decrypt stream success, remaining: " + r1);     // Catch: Exception -> L20
    L25:
        return r7;
    L20:
        e = e;
    L24:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
    L22:
        e = e;
        r7 = -4;
        goto L24
    }

    public static byte[] decryptStreamBytes(SecretKey r4, String r5, byte[] r6, byte[] r7) {
        SecretKey r8 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r4, SecretKey.class, "com.obric.aiagent.plugin");
        String r1 = TAG;     // Catch: Exception -> L9
        LogUtils.d(r1, "dataCipher len:" + r7.length);     // Catch: Exception -> L9
        LogUtils.d(r1, "dataCipher:" + CryptoUtils.byteArrayToHexString(r7));     // Catch: Exception -> L9
        LogUtils.d(r1, "ivBytes:" + CryptoUtils.byteArrayToHexString(r6));     // Catch: Exception -> L9
        Cipher r9 = Cipher.getInstance(r5);     // Catch: Exception -> L9
        r9.init(2, r8, new IvParameterSpec(r6));     // Catch: Exception -> L9
        int r10 = CryptoUtils.byteArrayToInt(Arrays.copyOfRange(r7, 0, 4));     // Catch: Exception -> L9
        if (r10 == (r7.length - 4)) goto L8;
        LogUtils.e(r1, "ChaCha20 decrypt init failed, dataCipher len:" + r7.length + " dataLen:" + r10);     // Catch: Exception -> L9
        return null;
    L8:
        return r9.doFinal(Arrays.copyOfRange(r7, 4, r7.length));
    L9:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream bytes failed, error:" + e.getMessage());
        return null;
    }

    public static int decryptStreamDynamic(SecretKey r7, String r8, byte[] r9, byte[] r10, int r11, InputStream r12, OutputStream r13) {
        SecretKey r0 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.aiagent.plugin");
        if ("ChaCha20-Poly1305".equals(r8) == false) goto L7;
        return decryptStreamBlockDynamic(r0, r8, r9, r10, r11, r12, r13);
    L7:
        return decryptStreamFull(r0, r8, r9, r12, r13);
    }

    private static int decryptStreamFull(SecretKey r4, String r5, byte[] r6, InputStream r7, OutputStream r8) {
        SecretKey r9 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r4, SecretKey.class, "com.obric.aiagent.plugin");
        int r0 = -4;
        LogUtils.i(TAG, "inputStream len:" + r7.available());     // Catch: Exception -> L26
        Cipher r10 = Cipher.getInstance(r5);     // Catch: Exception -> L26
        r10.init(2, r9, new IvParameterSpec(r6));     // Catch: Exception -> L26
        CipherOutputStream r11 = new CipherOutputStream(r8, r10);     // Catch: Exception -> L23
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L17
        boolean r13 = false;
    L8:
        int r1 = r7.read(r12);     // Catch: Throwable -> L17
        if (r1 <= 0) goto L11;
        r11.write(r12, 0, r1);     // Catch: Throwable -> L17
        r13 = true;
        goto L8
    L11:
        if (r13 == false) goto L36;
        r11.flush();     // Catch: Throwable -> L17
    L36:
        r11.close();     // Catch: Exception -> L15
        return 0;
    L15:
        e = e;
        r0 = 0;
    L24:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return r0;
    L17:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Exception -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L23
    L23:
        e = e;
    L26:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int decryptStreamWithPoly1305(SecretKey r7, byte[] r8, int r9, int r10, InputStream r11, OutputStream r12) {
        return decryptStreamBlock((SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.aiagent.plugin"), "ChaCha20-Poly1305", r8, r9, r10, r11, r12);
    }

    public static int decryptStreamWithPoly1305(SecretKey r8, byte[] r9, int r10, long r11, InputStream r13, OutputStream r14) {
        return decryptStreamBlockLong((SecretKey) ZeusTransformUtils.wrapperContextForParams(r8, SecretKey.class, "com.obric.aiagent.plugin"), "ChaCha20-Poly1305", r9, r10, r11, r13, r14);
    }

    public static int encryptStream(SecretKey r2, byte[] r3, InputStream r4, OutputStream r5) {
        return encryptStreamFull((SecretKey) ZeusTransformUtils.wrapperContextForParams(r2, SecretKey.class, "com.obric.aiagent.plugin"), "ChaCha20", r3, r4, r5);
    }

    private static int encryptStreamBlock(SecretKey r8, String r9, byte[] r10, int r11, int r12, InputStream r13, OutputStream r14) {
        SecretKey r15 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r8, SecretKey.class, "com.obric.aiagent.plugin");
        if (r11 <= 1048576) goto L7;
        String r16 = TAG;
        StringBuilder r17 = new StringBuilder().append("blockSize: ").append(r11).append(" exceeds the maximum:").append(1048576);
    L5:
        LogUtils.e(r16, r17.toString());
        return -2;
    L7:
        if (r12 > 0) goto L19;
        r16 = TAG;
        r17 = new StringBuilder().append("input data length: ").append(r12);
        goto L5
    L19:
        byte[] r1 = new byte[r11];     // Catch: Exception -> L16
        byte[] r2 = new byte[r11 + 16];     // Catch: Exception -> L16
    L11:
        if (r12 <= 0) goto L23;
        int r3 = r13.read(r1, 0, Math.min(r11, r12));     // Catch: Exception -> L16
        if (r3 <= 0) goto L24;
        Cipher r4 = Cipher.getInstance(r9);     // Catch: Exception -> L16
        r4.init(1, r15, new IvParameterSpec(r10));     // Catch: Exception -> L16
        int r5 = r4.doFinal(r1, 0, r3, r2);     // Catch: Exception -> L16
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r5);     // Catch: Exception -> L16
        r14.write(r2, 0, r5);     // Catch: Exception -> L16
        r12 = r12 - r3;
        goto L11
    L24:
        return 0;
    L23:
        return 0;
    L16:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockDynamic(SecretKey r6, String r7, byte[] r8, byte[] r9, int r10, InputStream r11, OutputStream r12) {
        SecretKey r13 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r6, SecretKey.class, "com.obric.aiagent.plugin");
        if (r10 <= 1048576) goto L23;
        LogUtils.e(TAG, "blockSize: " + r10 + " exceeds the maximum:1048576");
        return -2;
    L23:
        byte[] r0 = new byte[r10];     // Catch: Exception -> L20
    L7:
        int r1 = r11.read(r0);     // Catch: Exception -> L20
        if (r1 == (-1)) goto L9;
        Cipher r2 = Cipher.getInstance(r7);     // Catch: Exception -> L20
        r2.init(1, r13, new IvParameterSpec(r8));     // Catch: Exception -> L20
        if (r9 != null) goto L14;
    L16:
        if (r1 == r10) goto L17;
        byte[] r3 = r2.doFinal(r0, 0, r1);     // Catch: Exception -> L20
        r12.write(CryptoUtils.intToBytes(r3.length));     // Catch: Exception -> L20
        r12.write(r3);     // Catch: Exception -> L20
        goto L7
    L17:
        byte[] r4 = r2.doFinal(r0);     // Catch: Exception -> L20
        r12.write(CryptoUtils.intToBytes(r4.length));     // Catch: Exception -> L20
        r12.write(r4);     // Catch: Exception -> L20
        goto L7
    L14:
        if (r9.length <= 0) goto L16;
        r2.updateAAD(r9);     // Catch: Exception -> L20
        goto L16
    L9:
        r12.flush();     // Catch: Exception -> L20
        return 0;
    L20:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream dynamic failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockLong(SecretKey r16, String r17, byte[] r18, int r19, long r20, InputStream r22, OutputStream r23) {
        long r1 = r20;
        SecretKey r3 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r16, SecretKey.class, "com.obric.aiagent.plugin");
        if (r19 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r19 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r1 > 0) goto L21;
        LogUtils.e(TAG, "input data length: " + r1);
        return -2;
    L21:
        byte[] r7 = new byte[r19];     // Catch: Exception -> L18
        byte[] r8 = new byte[r19 + 16];     // Catch: Exception -> L18
    L13:
        if (r1 <= 0) goto L25;
        int r9 = r22.read(r7, 0, (int) Math.min(r19, r1));     // Catch: Exception -> L18
        if (r9 <= 0) goto L26;
        Cipher r11 = Cipher.getInstance(r17);     // Catch: Exception -> L18
        r11.init(1, r3, new IvParameterSpec(r18));     // Catch: Exception -> L18
        int r12 = r11.doFinal(r7, 0, r9, r8);     // Catch: Exception -> L18
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r12);     // Catch: Exception -> L18
        r23.write(r8, 0, r12);     // Catch: Exception -> L18
        r1 = r1 - ((long) r9);
        goto L13
    L26:
        return 0;
    L25:
        return 0;
    L18:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamDynamic(SecretKey r7, String r8, byte[] r9, byte[] r10, int r11, InputStream r12, OutputStream r13) {
        SecretKey r0 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.aiagent.plugin");
        if ("ChaCha20-Poly1305".equals(r8) == false) goto L7;
        return encryptStreamBlockDynamic(r0, r8, r9, r10, r11, r12, r13);
    L7:
        return encryptStreamFull(r0, r8, r9, r12, r13);
    }

    private static int encryptStreamFull(SecretKey r4, String r5, byte[] r6, InputStream r7, OutputStream r8) {
        SecretKey r9 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r4, SecretKey.class, "com.obric.aiagent.plugin");
        int r0 = -4;
        LogUtils.d(TAG, "inputStream len:" + r7.available());     // Catch: Exception -> L26
        Cipher r10 = Cipher.getInstance(r5);     // Catch: Exception -> L26
        r10.init(1, r9, new IvParameterSpec(r6));     // Catch: Exception -> L26
        CipherOutputStream r1 = new CipherOutputStream(r8, r10);     // Catch: Exception -> L23
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L17
        boolean r12 = false;
    L8:
        int r2 = r7.read(r11);     // Catch: Throwable -> L17
        if (r2 <= 0) goto L11;
        r1.write(r11, 0, r2);     // Catch: Throwable -> L17
        r12 = true;
        goto L8
    L11:
        if (r12 == false) goto L36;
        r1.flush();     // Catch: Throwable -> L17
    L36:
        r1.close();     // Catch: Exception -> L15
        return 0;
    L15:
        e = e;
        r0 = 0;
    L24:
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return r0;
    L17:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Exception -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L23
    L23:
        e = e;
    L26:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamWithPoly1305(SecretKey r7, byte[] r8, int r9, int r10, InputStream r11, OutputStream r12) {
        return encryptStreamBlock((SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.aiagent.plugin"), "ChaCha20-Poly1305", r8, r9, r10, r11, r12);
    }

    public static int encryptStreamWithPoly1305(SecretKey r8, byte[] r9, int r10, long r11, InputStream r13, OutputStream r14) {
        return encryptStreamBlockLong((SecretKey) ZeusTransformUtils.wrapperContextForParams(r8, SecretKey.class, "com.obric.aiagent.plugin"), "ChaCha20-Poly1305", r9, r10, r11, r13, r14);
    }

    public static byte[] xcryptBytes(int r2, String r3, byte[] r4, byte[] r5, byte[] r6) {
        byte[] r0 = new byte[0];
        SecretKeySpec r1 = new SecretKeySpec(r4, r3);     // Catch: Exception -> L5
        Cipher r7 = Cipher.getInstance(r3);     // Catch: Exception -> L5
        r7.init(r2, r1, new IvParameterSpec(r5));     // Catch: Exception -> L5
        return r7.doFinal(r6);
    L5:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 xcrypt bytes failed, mode:" + r2 + " error:" + e.getMessage());
        return r0;
    }
}
