package com.bytedance.crypto.envelope;

import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.PublicKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class EnvelopeCryptoImpl {
    private static final int ENVELOPE_MAGIC = -57307;
    private static final int ENVELOPE_VERSION = 1;
    private static final int FILE_MAGIC = -57306;
    private static final int FILE_VERSION = 1;
    private static final String TAG = "EnvelopeCryptoImpl";
    private static volatile EnvelopeCryptoImpl instance;

    private EnvelopeCryptoImpl() {
    }

    private byte[] buildDEKEnvelope(byte[] r6, byte[] r7, byte[] r8) {
        StringBuilder r5 = new StringBuilder().append("buildDEKEnvelope enter, bizPubkeyLen: ").append(r6.length).append(", aadLen: ");
        if (r8 != null) goto L5;
        int r0 = 0;
    L6:
        LogUtils.i(TAG, r5.append(r0).toString());
        KeyPair r1 = CryptoUtils.generateECCKeyPair();     // Catch: Exception -> L31
        if (r1 != null) goto L11;
        LogUtils.e(TAG, "Generate temp ECC keypair failed");     // Catch: Exception -> L31
        return null;
    L11:
        byte[] r2 = CryptoUtils.parseECCPublicKey(r1.getPublic().getEncoded());     // Catch: Exception -> L31
        PublicKey r9 = CryptoUtils.byteArrayToECPublicKey(r6);     // Catch: Exception -> L31
        if (r9 != null) goto L15;
        LogUtils.e(TAG, "Parse biz public key failed");     // Catch: Exception -> L31
        return null;
    L15:
        byte[] r10 = ECDHHelper.generateSharedSecret(r1.getPrivate(), r9);     // Catch: Exception -> L31
        if (r10 != null) goto L18;
    L29:
        LogUtils.e(TAG, "ECDH key agreement failed");     // Catch: Exception -> L31
        return null;
    L18:
        if (r10.length == 0) goto L29;
        LogUtils.d(TAG, "sharedKey length: " + r10.length);     // Catch: Exception -> L31
        byte[] r3 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L31
        byte[] r11 = AES.gcmXcrypt(1, r10, r8, r3, r7);     // Catch: Exception -> L31
        if (r11 != null) goto L23;
    L27:
        LogUtils.e(TAG, "AES-GCM encrypt DEK failed");     // Catch: Exception -> L31
        return null;
    L23:
        if (r11.length == 0) goto L27;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: Exception -> L31
        DataOutputStream r13 = new DataOutputStream(r12);     // Catch: Exception -> L31
        r13.writeInt(ENVELOPE_MAGIC);     // Catch: Exception -> L31
        r13.writeInt(1);     // Catch: Exception -> L31
        r13.writeInt(r2.length);     // Catch: Exception -> L31
        r13.write(r2);     // Catch: Exception -> L31
        r13.writeInt(r3.length);     // Catch: Exception -> L31
        r13.write(r3);     // Catch: Exception -> L31
        r13.writeLong(r11.length);     // Catch: Exception -> L31
        r13.write(r11);     // Catch: Exception -> L31
        r13.flush();     // Catch: Exception -> L31
        byte[] r14 = r12.toByteArray();     // Catch: Exception -> L31
        LogUtils.i(TAG, "buildDEKEnvelope success, envelopeLen: " + r14.length);     // Catch: Exception -> L31
        return r14;
    L31:
        e = move-exception;
        LogUtils.e(TAG, "Build DEK envelope failed, error: " + e.getMessage());
        return null;
    L5:
        r0 = r8.length;
        goto L6
    }

    public static EnvelopeCryptoImpl getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EnvelopeCryptoImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EnvelopeCryptoImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EnvelopeCryptoImpl.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public int decrypt(byte[] r12, InputStream r13, OutputStream r14) {
        StringBuilder r11 = new StringBuilder().append("decrypt enter, dekLen: ");
        if (r12 != null) goto L5;
        int r0 = 0;
    L6:
        LogUtils.i(TAG, r11.append(r0).toString());
        if (r12 != null) goto L9;
    L37:
        LogUtils.e(TAG, "Invalid input params");
        return -2;
    L9:
        if (r12.length != 32) goto L37;
        if (r13 == null) goto L37;
        if (r14 == null) goto L37;
        DataInputStream r15 = new DataInputStream(r13);     // Catch: IOException -> L34
        int r1 = r15.readInt();     // Catch: IOException -> L34
        if (r1 == FILE_MAGIC) goto L17;
        LogUtils.e(TAG, "File magic mismatch: 0x" + Integer.toHexString(r1));     // Catch: IOException -> L34
        return -10;
    L17:
        int r2 = r15.readInt();     // Catch: IOException -> L34
        if (r2 == 1) goto L21;
        LogUtils.e(TAG, "Unsupported file version: " + r2);     // Catch: IOException -> L34
        return -8;
    L21:
        int r3 = r15.readInt();     // Catch: IOException -> L34
        if (r3 > 0) goto L25;
        LogUtils.e(TAG, "Invalid DEK envelope length: " + r3);     // Catch: IOException -> L34
        return -8;
    L25:
        int r4 = r15.skipBytes(r3);     // Catch: IOException -> L34
        if (r4 == r3) goto L29;
        LogUtils.e(TAG, "Skip DEK envelope failed, expected: " + r3 + ", actual: " + r4);     // Catch: IOException -> L34
        return -8;
    L29:
        byte[] r5 = new byte[12];     // Catch: IOException -> L34
        r15.readFully(r5);     // Catch: IOException -> L34
        long r9 = r15.readLong();     // Catch: IOException -> L34
        long r6 = 4096;
        long r7 = ((r9 + r6) - 1) / r6;     // Catch: IOException -> L34
        long r8 = r9 + (16 * r7);     // Catch: IOException -> L34
        LogUtils.i(TAG, "decrypt stream, dataLen: " + r9 + ", cipherLen: " + r8 + ", numBlocks: " + r7);     // Catch: IOException -> L34
        int r16 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r12, "ChaCha20-Poly1305"), r5, 4096, r8, r13, r14);     // Catch: IOException -> L34
        if (r16 == 0) goto L32;
        LogUtils.e(TAG, "Decrypt stream failed, ret: " + r16);     // Catch: IOException -> L34
    L33:
        return r16;
    L32:
        LogUtils.i(TAG, "decrypt success, dataLen: " + r9);     // Catch: IOException -> L34
    L34:
        e = move-exception;
        LogUtils.e(TAG, "Decrypt failed, error: " + e.getMessage());
        return -4;
    L5:
        r0 = r12.length;
        goto L6
    }

    public int encrypt(byte[] r14, byte[] r15, long r16, InputStream r18, OutputStream r19) {
        StringBuilder r2 = new StringBuilder().append("encrypt enter, bizPubkeyLen: ");
        if (r14 != null) goto L5;
        int r3 = 0;
    L6:
        StringBuilder r4 = r2.append(r3).append(", aadLen: ");
        if (r15 != null) goto L9;
        int r5 = 0;
    L10:
        LogUtils.i(TAG, r4.append(r5).append(", dataLen: ").append(r16).toString());
        if (r14 != null) goto L13;
    L31:
        LogUtils.e(TAG, "Invalid input params");
        return -2;
    L13:
        if (r14.length == 0) goto L31;
        if (r18 == null) goto L31;
        if (r19 == null) goto L31;
        byte[] r6 = CryptoUtils.generateSecureRandom(32);     // Catch: Exception -> L28
        byte[] r12 = buildDEKEnvelope(r14, r6, r15);     // Catch: Exception -> L28
        if (r12 != null) goto L22;
        LogUtils.e(TAG, "Build DEK envelope failed");     // Catch: Exception -> L28
        return -4;
    L22:
        byte[] r1 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L28
        DataOutputStream r0 = new DataOutputStream(r19);     // Catch: Exception -> L28
        r0.writeInt(FILE_MAGIC);     // Catch: Exception -> L28
        r0.writeInt(1);     // Catch: Exception -> L28
        r0.writeInt(r12.length);     // Catch: Exception -> L28
        r0.write(r12);     // Catch: Exception -> L28
        r0.write(r1);     // Catch: Exception -> L28
        r0.writeLong(r16);     // Catch: Exception -> L28
        int r7 = ChaCha20.encryptStreamWithPoly1305(new SecretKeySpec(r6, "ChaCha20-Poly1305"), r1, 4096, r16, r18, r19);     // Catch: Exception -> L28
        if (r7 == 0) goto L26;
        LogUtils.e(TAG, "Encrypt data stream failed, ret: " + r7);     // Catch: Exception -> L28
        return r7;
    L26:
        LogUtils.i(TAG, "encrypt success, dataLen: " + r16 + ", dekEnvelopeLen: " + r12.length);     // Catch: Exception -> L28
        return 0;
    L28:
        e = move-exception;
        LogUtils.e(TAG, "Encrypt failed, error: " + e.getMessage());
        return -4;
    L9:
        r5 = r15.length;
        goto L10
    L5:
        r3 = r14.length;
        goto L6
    }

    public byte[] extractDEKCipher(InputStream r5) {
        LogUtils.i(TAG, "extractDEKCipher enter");
        if (r5 != null) goto L23;
        String r6 = "Invalid input params";
    L5:
        LogUtils.e(TAG, r6);
        return null;
    L23:
        DataInputStream r1 = new DataInputStream(r5);     // Catch: IOException -> L21
        int r7 = r1.readInt();     // Catch: IOException -> L21
        if (r7 == FILE_MAGIC) goto L11;
        LogUtils.e(TAG, "File magic mismatch: 0x" + Integer.toHexString(r7));     // Catch: IOException -> L21
        return null;
    L11:
        int r8 = r1.readInt();     // Catch: IOException -> L21
        if (r8 == 1) goto L15;
        LogUtils.e(TAG, "Unsupported file version: " + r8);     // Catch: IOException -> L21
        return null;
    L15:
        int r9 = r1.readInt();     // Catch: IOException -> L21
        if (r9 > 0) goto L19;
        LogUtils.e(TAG, "Invalid DEK envelope length: " + r9);     // Catch: IOException -> L21
        return null;
    L19:
        byte[] r2 = new byte[r9];     // Catch: IOException -> L21
        r1.readFully(r2);     // Catch: IOException -> L21
        LogUtils.i(TAG, "extractDEKCipher success, dekEnvelopeLen: " + r9);     // Catch: IOException -> L21
        return r2;
    L21:
        e = move-exception;
        r6 = "Extract DEK cipher failed, error: " + e.getMessage();
        goto L5
    }
}
