package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class TransCryptoContext {
    private static final String TAG = "TransCryptoContext";
    private final String mAppId;
    private final Context mContext;
    private byte[] mDataIv;
    private final String mDid;
    private SecretKey mEncryptKey;
    private byte[] mKeyCipher;
    private byte[] mKeyCipherHash;

    public TransCryptoContext(Context r3, String r4, String r5) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mAppId = r5;
        this.mDid = r4;
    }

    private byte[] buildFullEncDataKeyCipher(byte[] r4, byte[] r5, boolean r6, SensitiveData r7) {
        LogUtils.d(TAG, "fileEncrypt:" + r6);     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyVersion:" + r7.getKeyVersion());     // Catch: IOException -> L9
        LogUtils.d(TAG, "dataIv:" + CryptoUtils.byteArrayToHexString(r5));     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyCipher:" + CryptoUtils.byteArrayToHexString(r4));     // Catch: IOException -> L9
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r7.getHKDFSalt()));     // Catch: IOException -> L9
        if (r6 == false) goto L6;
        int r3 = CryptoConst.TRANS_FILE_FULL_KEY_MAGIC_NUM;
    L7:
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r3), TransUtils.longToByteArray(r7.getKeyVersion()), TransUtils.intToByteArray(r5.length + r4.length), r5, r4});
    L6:
        r3 = CryptoConst.STREAM_CIPHER_MAGIC_NUM;
    L10:
        throw new CloudTransException("data full encrypt failed, concatenate error.");
    }

    private byte[] buildPageEncDataKeyCipher(byte[] r9, byte[] r10, SensitiveData r11) {
        byte[] r0 = this.mDid.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        byte[] r1 = this.mAppId.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        this.mKeyCipherHash = CryptoUtils.messageDigest(r9, CryptoConst.ALGORITHM_MD5);     // Catch: IOException -> L4
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(CryptoConst.TRANS_FILE_PAGE_KEY_MAGIC_NUM), TransUtils.intToByteArray(1), new byte[]{(byte) r0.length}, r0, new byte[]{(byte) r1.length}, r1, r11.getHKDFSalt(), TransUtils.longToByteArray(r11.getKeyVersion()), TransUtils.intToByteArray(r10.length + r9.length), r10, r9, this.mKeyCipherHash});
    L5:
        throw new CloudTransException("data page encrypt failed, concatenate error.");
    }

    private static SecretKey constructChaCha20Key(byte[] r2) {
        return new SecretKeySpec(r2, "ChaCha20");
    }

    public void deInitKey() {
        this.mEncryptKey = null;
        this.mKeyCipher = new byte[0];
    }

    public String getAppId() {
        return this.mAppId;
    }

    public byte[] getDataIv() {
        return this.mDataIv;
    }

    public String getDid() {
        return this.mDid;
    }

    public SecretKey getEncryptKey() {
        return this.mEncryptKey;
    }

    public byte[] getKeyCipher() {
        return this.mKeyCipher;
    }

    public byte[] getKeyCipherHash() {
        return this.mKeyCipherHash;
    }

    public boolean initEncryptKey(SensitiveData r8, boolean r9, boolean r10) {
        if (this.mContext != null) goto L8;
        String r7 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r7);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L31:
        r7 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L31;
        if (r8 != null) goto L14;
    L30:
        r7 = "session key is null!!";
        goto L5
    L14:
        if (r8.getSessionEncryptKey() == null) goto L30;
        SecretKey r0 = CryptoUtils.generateSymmetricKey("ChaCha20", 32);
        if (r0 != null) goto L19;
        r7 = "Generate file encrypt key failed!!";
        goto L5
    L19:
        LogUtils.d(TAG, "file key len:" + r0.getEncoded().length);
        byte[] r3 = new byte[12];
        new SecureRandom().nextBytes(r3);
        byte[] r4 = DataEncryptHelper.encrypt(r0.getEncoded(), constructChaCha20Key(r8.getSessionEncryptKey()), r3, CryptoConst.TRANS_AES_KEY_AAD.getBytes());
        if (r4 != null) goto L22;
    L29:
        r7 = "File key encrypt failed!!";
        goto L5
    L22:
        if (r4.length == 0) goto L29;
        if (r9 == false) goto L26;
        this.mKeyCipher = buildPageEncDataKeyCipher(r4, r3, r8);
    L27:
        this.mEncryptKey = r0;
        return true;
    L26:
        this.mKeyCipher = buildFullEncDataKeyCipher(r4, r3, r10, r8);
        goto L27
    }

    public boolean initFullDecryptKey(byte[] r10, byte[] r11, boolean r12, SensitiveData r13) {
        if (this.mContext != null) goto L8;
        String r9 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r9);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L51:
        r9 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L51;
        LogUtils.i(TAG, "full file key cipher len:" + r10.length);
        byte[] r3 = new byte[4];
        if (r10.length >= 4) goto L17;
        StringBuilder r14 = new StringBuilder().append("Input data len is too short! len:");
    L15:
        StringBuilder r15 = r14.append(r10.length);
    L16:
        r9 = r15.toString();
        goto L5
    L17:
        System.arraycopy(r10, 0, r3, 0, 4);
        int r4 = CryptoUtils.byteArrayToInt(r3);
        if (r12 == true) goto L20;
    L23:
        if (r12 == true) goto L28;
        if (r4 == 305450445) goto L28;
        StringBuilder r16 = new StringBuilder();
        String r17 = "Cannot parse input stream cipher data! magic:";
    L22:
        r15 = r16.append(r17).append(r4);
    L28:
        if (r10.length >= 12) goto L31;
        StringBuilder r18 = new StringBuilder();
    L30:
        r14 = r18.append("Input data len is too short!! len:");
        goto L15
    L31:
        long r5 = TransUtils.bytesToLong(Arrays.copyOfRange(r10, 4, 12));
        LogUtils.d(TAG, "keyVersion:" + r5);
        if (r5 != r13.getKeyVersion()) goto L35;
        byte[] r19 = HKDFHelper.deriveKey(r13.getDeviceShareKey(), r11, r13.getHKDFInfo());
        SecretKeySpec r110 = new SecretKeySpec(r19, CryptoConst.ALGORITHM_AES);
        LogUtils.d(TAG, "sessionKey:" + CryptoUtils.byteArrayToHexString(r19));
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r11));
    L40:
        if (r10.length >= 16) goto L42;
        r18 = new StringBuilder();
        goto L30
    L42:
        int r111 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, 12, 16));
        if (r10.length >= 28) goto L45;
        r18 = new StringBuilder();
        goto L30
    L45:
        byte[] r112 = Arrays.copyOfRange(r10, 16, 28);
        if (r10.length >= 44) goto L48;
        r18 = new StringBuilder();
        goto L30
    L48:
        byte[] r113 = DataEncryptHelper.decrypt(Arrays.copyOfRange(r10, 28, (r111 + 28) - 12), r110, r112, CryptoConst.TRANS_AES_KEY_AAD.getBytes());
        this.mKeyCipher = r10;
        this.mEncryptKey = constructChaCha20Key(r113);
        return true;
    L35:
        if (r13.isOlidKeyExist() == true) goto L37;
    L50:
        r15 = new StringBuilder().append("key version is error, web version: ").append(r5).append(", current version: ").append(r13.getKeyVersion());
        goto L16
    L37:
        if (r5 != r13.getOldKeyVersion()) goto L50;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r5);
        r110 = new SecretKeySpec(HKDFHelper.deriveKey(r13.getOldDeviceShareKey(), r11, r13.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
        goto L40
    L20:
        if (r4 == 305419896) goto L23;
        r16 = new StringBuilder();
        r17 = "Cannot parse input full cipher data! magic:";
        goto L22
    }

    public boolean initPageDecryptKey(byte[] r13, SensitiveData r14) {
        if (this.mContext != null) goto L8;
        String r12 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r12);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L64:
        r12 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L64;
        if (r13 != null) goto L14;
    L63:
        r12 = "dataKeyCipher is empty!!";
        goto L5
    L14:
        if (r13.length == 0) goto L63;
        LogUtils.i(TAG, "page file key cipher len:" + r13.length);
        byte[] r3 = new byte[4];
        if (r13.length >= 4) goto L21;
        StringBuilder r15 = new StringBuilder().append("Input data len is too short! len:");
    L19:
        StringBuilder r16 = r15.append(r13.length);
    L20:
        r12 = r16.toString();
        goto L5
    L21:
        System.arraycopy(r13, 0, r3, 0, 4);
        int r4 = CryptoUtils.byteArrayToInt(r3);
        if (r4 == 591751049) goto L25;
        r16 = new StringBuilder().append("Cannot parse input cipher data! magic:").append(r4);
        goto L20
    L25:
        if (r13.length >= 8) goto L28;
        StringBuilder r17 = new StringBuilder();
    L27:
        r15 = r17.append("Input data len is too short!! len:");
        goto L19
    L28:
        byte[] r5 = new byte[4];
        System.arraycopy(r13, 4, r5, 0, 4);
        int r0 = CryptoUtils.byteArrayToInt(r5);
        if (r0 == 1) goto L32;
        r16 = new StringBuilder().append("Input cipher data version is wrong! version:").append(r0);
        goto L20
    L32:
        if (r13.length >= (r14.getExtraInfo().length + 8)) goto L35;
        r17 = new StringBuilder();
        goto L27
    L35:
        if (Arrays.equals(r14.getExtraInfo(), Arrays.copyOfRange(r13, 8, r14.getExtraInfo().length + 8)) == true) goto L37;
        r16 = new StringBuilder().append("dId and appId is error, ").append(CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r13, 8, r14.getExtraInfo().length + 8)));
        goto L20
    L37:
        int r1 = r14.getExtraInfo().length + 8;
        int r6 = r1 + 32;
        if (r13.length >= r6) goto L40;
        r17 = new StringBuilder();
        goto L27
    L40:
        byte[] r2 = Arrays.copyOfRange(r13, r1, r6);
        int r7 = r6 + 8;
        if (r13.length >= r7) goto L43;
        r17 = new StringBuilder();
        goto L27
    L43:
        long r8 = TransUtils.bytesToLong(Arrays.copyOfRange(r13, r6, r7));
        if (r8 != r14.getKeyVersion()) goto L47;
        SecretKeySpec r9 = new SecretKeySpec(HKDFHelper.deriveKey(r14.getDeviceShareKey(), r2, r14.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
    L51:
        int r10 = r7 + 4;
        if (r13.length >= r10) goto L54;
        r17 = new StringBuilder();
        goto L27
    L54:
        int r18 = TransUtils.bytesToInt(Arrays.copyOfRange(r13, r7, r10));
        int r11 = r10 + 12;
        if (r13.length >= r11) goto L57;
        r17 = new StringBuilder();
        goto L27
    L57:
        byte[] r19 = Arrays.copyOfRange(r13, r10, r11);
        if (r13.length >= (r11 + 16)) goto L60;
        r17 = new StringBuilder();
        goto L27
    L60:
        this.mEncryptKey = constructChaCha20Key(DataEncryptHelper.decrypt(Arrays.copyOfRange(r13, r11, (r18 + r11) - 12), r9, r19, CryptoConst.TRANS_AES_KEY_AAD.getBytes()));
        return true;
    L47:
        if (r14.isOlidKeyExist() == true) goto L49;
    L62:
        r16 = new StringBuilder().append("key version is error, web version: ").append(r8).append(", current version: ").append(r14.getKeyVersion());
        goto L20
    L49:
        if (r8 != r14.getOldKeyVersion()) goto L62;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r8);
        r9 = new SecretKeySpec(HKDFHelper.deriveKey(r14.getOldDeviceShareKey(), r2, r14.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
        goto L51
    }

    public void setDataIv(byte[] r1) {
        this.mDataIv = r1;
    }
}
