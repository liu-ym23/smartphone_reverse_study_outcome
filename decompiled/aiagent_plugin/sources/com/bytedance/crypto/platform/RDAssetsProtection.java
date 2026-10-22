package com.bytedance.crypto.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class RDAssetsProtection {
    private static final int DATA_IV_LEN = 12;
    private static final int PLAT_DATAKEY_LEN = 32;
    private static final int PLAT_IV_LEN = 12;
    private static final int PLAT_TAG_LEN = 16;
    private static final int PLAT_TAIL_FIXED_LEN = 60;
    private static final int RD_BIZ_PUBKEY_LEN = 65;
    private static final int RD_HEADER_FIXED_LEN = 6;
    private static final int RD_HEADER_MAGIC_LEN = 4;
    private static final int RD_HEADER_PROD_NAME_LEN_FIELD = 1;
    private static final int RD_HEADER_VERSION_LEN = 1;
    private static final int RD_LEN_FIELD_LEN = 4;
    private static final String TAG = "RDAssetsProtection";
    private static volatile RDAssetsProtection sInstance;

    private RDAssetsProtection() {
    }

    private void cleanupPubKeys(byte[] r1, byte[] r2) {
        if (r2 == null) goto L6;
        if (r2 == r1) goto L7;
        Arrays.fill(r2, (byte) 0);
        return;
    L7:
        return;
    }

    public static RDAssetsProtection getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RDAssetsProtection.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RDAssetsProtection();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RDAssetsProtection.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private int getIntBigEndian(byte[] r2, int r3) {
        return ((((r2[r3] & 255) << 24) | ((r2[r3 + 1] & 255) << 16)) | ((r2[r3 + 2] & 255) << 8)) | (r2[r3 + 3] & 255);
    }

    private String getSystemProperty(String r8, String r9) {
        Class r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return (String) ZeusTransformUtils.preCheckCast(r0.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r0, new Object[]{r8, r9}), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getSystemProperty failed, key=" + r8 + ", exception: " + e.getMessage());
        return r9;
    }

    private byte[] normalizePubKey(byte[] r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.length != 65) goto L11;
        if (r5[0] != 4) goto L11;
        return r5;
    L11:
        if (r5.length > 65) goto L13;
    L20:
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("normalizePubKey: unsupported pubkey format, len=").append(r5.length).append(", firstByte=0x");
        String r6 = Integer.toHexString(r5[0] & 255);
    L18:
        LogUtils.e(r0, r1.append(r6).toString());
        return null;
    L13:
        if (r5[0] != 48) goto L20;
        return CryptoUtils.parseECCPublicKey(r5);
    L16:
        e = move-exception;
        r0 = TAG;
        r1 = new StringBuilder().append("normalizePubKey: parse X.509 DER failed: ");
        r6 = e.getMessage();
        goto L18
    }

    public byte[] decrypt(Context r9, byte[] r10, byte[] r11, byte[] r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("decrypt enter, dataInLen: ");
        if (r12 != null) goto L5;
        int r3 = 0;
    L6:
        LogUtils.i(r0, r1.append(r3).toString());
        if (r13 == null) goto L79;
        if (r12 == null) goto L79;
        if (r12.length == 0) goto L79;
        if (r10 != null) goto L14;
    L78:
        String r8 = "decrypt: invalid bizPubkey";
    L20:
        LogUtils.e(r0, r8);
    L22:
        return new byte[0];
    L14:
        if (r10.length == 0) goto L78;
        if (r12.length >= 102) goto L23;
        StringBuilder r14 = new StringBuilder().append("decrypt: dataIn too short, len=").append(r12.length);
    L19:
        r8 = r14.toString();
        goto L20
    L23:
        int r2 = getIntBigEndian(r12, 0);
        if (r2 == (-65536)) goto L26;
        r14 = new StringBuilder().append("decrypt: invalid RD assets magic: ").append(Integer.toHexString(r2));
        goto L19
    L26:
        int r4 = r12[4] & 255;
        if (r4 == 1) goto L30;
        StringBuilder r15 = new StringBuilder();
        String r16 = "decrypt: unsupported version: ";
    L29:
        r14 = r15.append(r16).append(r4);
        goto L19
    L30:
        r4 = r12[5] & 255;
        int r5 = r4 + 6;
        if (r5 <= r12.length) goto L33;
        r15 = new StringBuilder();
        r16 = "decrypt: invalid prodNameLen: ";
        goto L29
    L33:
        LogUtils.i(r0, "decrypt: prodName=" + new String(r12, 6, r4, StandardCharsets.UTF_8));
        byte[] r6 = normalizePubKey(r10);
        if (r6 != null) goto L36;
    L77:
        r8 = "decrypt: invalid bizPubkey format from param";
        goto L20
    L36:
        if (r6.length != 65) goto L77;
        int r7 = r5 + 4;
        if (r7 <= r12.length) goto L42;
        String r17 = "decrypt: dataIn too short for DataKeyCipherLen";
    L41:
        LogUtils.e(r0, r17);
        cleanupPubKeys(r10, r6);
        goto L22
    L42:
        int r18 = getIntBigEndian(r12, r5);
        if (r18 < 60) goto L76;
        int r19 = r7 + r18;
        if (r19 > r12.length) goto L76;
        byte[] r20 = Arrays.copyOfRange(r12, r7, r19);
        int r21 = r19 + 4;
        if (r21 <= r12.length) goto L50;
        r17 = "decrypt: dataIn too short for DataCipherLen";
        goto L41
    L50:
        int r22 = getIntBigEndian(r12, r19);
        if (r22 < 28) goto L74;
        int r23 = r21 + r22;
        if (r23 != r12.length) goto L74;
        byte[] r110 = Arrays.copyOfRange(r12, r21, r23);
        Bundle r24 = new Bundle();
        if (r11 != null) goto L58;
    L60:
        byte[] r25 = FrameworkSecurityCompat.platformKeyDecrypt(r13, PlatformConst.SM8750_PLATFORM_VERSION, r20, r6, r24);
        cleanupPubKeys(r10, r6);
        if (r25 != null) goto L63;
    L73:
        r8 = "decrypt: platformKeyDecrypt DataKey failed";
        goto L20
    L63:
        if (r25.length != 32) goto L73;
        byte[] r111 = Arrays.copyOfRange(r110, 0, 12);
        byte[] r26 = Arrays.copyOfRange(r110, 12, r110.length);
        byte[] r112 = AES.gcmXcrypt(2, r25, r11, r111, r26);
        Arrays.fill(r25, (byte) 0);
        Arrays.fill(r111, (byte) 0);
        Arrays.fill(r26, (byte) 0);
        if (r112 != null) goto L68;
    L72:
        r8 = "decrypt: AES-GCM decrypt data failed";
        goto L20
    L68:
        if (r112.length == 0) goto L72;
        LogUtils.i(r0, "decrypt success, plainLen: " + r112.length);
        return r112;
    L58:
        if (r11.length <= 0) goto L60;
        r24.putByteArray(FrameworkSecurityCompat.PlatformKeyConst.BUNDLE_KEY_AAD(), r11);
    L74:
        StringBuilder r27 = new StringBuilder().append("decrypt: invalid dataCipherLen: ").append(r22).append(", remaining: ").append(r12.length - r21);
    L75:
        r17 = r27.toString();
    L76:
        r27 = new StringBuilder().append("decrypt: invalid dataKeyCipherLen: ").append(r18);
    L79:
        r8 = "decrypt: invalid input params";
        goto L20
    L5:
        r3 = r12.length;
        goto L6
    }

    public byte[] encrypt(Context r11, byte[] r12, byte[] r13, byte[] r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("encrypt enter, dataInLen: ");
        if (r14 != null) goto L5;
        int r3 = 0;
    L6:
        LogUtils.i(r0, r1.append(r3).toString());
        if (r15 == null) goto L63;
        if (r12 == null) goto L63;
        if (r12.length == 0) goto L63;
        if (r14 == null) goto L63;
        if (r14.length == 0) goto L63;
        byte[] r2 = normalizePubKey(r12);
        if (r2 != null) goto L18;
    L61:
        LogUtils.e(r0, "encrypt: invalid bizPubkey format");
        return new byte[0];
    L18:
        if (r2.length != 65) goto L61;
        byte[] r10 = getSystemProperty(PlatformConst.PROP_PRODUCT_TYPE, "").getBytes(StandardCharsets.UTF_8);
        if (r10.length <= 255) goto L23;
        LogUtils.w(r0, "encrypt: prodName too long, truncating to 255 bytes");
        r10 = Arrays.copyOf(r10, 255);
    L23:
        byte[] r4 = CryptoUtils.generateSecureRandom(32);
        if (r4 != null) goto L26;
    L59:
        LogUtils.e(r0, "encrypt: generate DataKey failed");
        return new byte[0];
    L26:
        if (r4.length != 32) goto L59;
        byte[] r5 = CryptoUtils.generateSecureRandom(12);
        if (r5 != null) goto L31;
    L57:
        LogUtils.e(r0, "encrypt: generate data IV failed");
        Arrays.fill(r4, (byte) 0);
        return new byte[0];
    L31:
        if (r5.length != 12) goto L57;
        byte[] r16 = AES.gcmXcrypt(1, r4, r13, r5, r14);
        if (r16 != null) goto L36;
    L55:
        LogUtils.e(r0, "encrypt: AES-GCM encrypt data failed");
        Arrays.fill(r4, (byte) 0);
        Arrays.fill(r5, (byte) 0);
        return new byte[0];
    L36:
        if (r16.length == 0) goto L55;
        int r6 = r5.length + r16.length;
        byte[] r7 = new byte[r6];
        System.arraycopy(r5, 0, r7, 0, r5.length);
        System.arraycopy(r16, 0, r7, r5.length, r16.length);
        Arrays.fill(r5, (byte) 0);
        Bundle r17 = new Bundle();
        if (r13 != null) goto L41;
    L43:
        byte[] r18 = FrameworkSecurityCompat.platformKeyEncrypt(r15, PlatformConst.SM8750_PLATFORM_VERSION, r4, r2, r17);
        Arrays.fill(r4, (byte) 0);
        if (r18 != null) goto L46;
    L53:
        LogUtils.e(r0, "encrypt: platformKeyEncrypt DataKey failed");
        Arrays.fill(r7, (byte) 0);
        return new byte[0];
    L46:
        if (r18.length == 0) goto L53;
        ByteBuffer r19 = ByteBuffer.allocate(((((r10.length + 6) + 4) + r18.length) + 4) + r6);
        r19.putInt(-65536);
        r19.put((byte) 1);
        r19.put((byte) r10.length);
        r19.put(r10);
        r19.putInt(r18.length);
        r19.put(r18);
        r19.putInt(r6);
        r19.put(r7);
        byte[] r110 = r19.array();
        Arrays.fill(r7, (byte) 0);
        if (r2 == r12) goto L51;
        Arrays.fill(r2, (byte) 0);
    L51:
        LogUtils.i(r0, "encrypt success, resultLen: " + r110.length);
        return r110;
    L41:
        if (r13.length <= 0) goto L43;
        r17.putByteArray(FrameworkSecurityCompat.PlatformKeyConst.BUNDLE_KEY_AAD(), r13);
    L63:
        LogUtils.e(r0, "encrypt: invalid input params");
        return new byte[0];
    L5:
        r3 = r14.length;
        goto L6
    }
}
