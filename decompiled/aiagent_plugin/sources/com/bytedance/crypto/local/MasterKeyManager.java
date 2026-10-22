package com.bytedance.crypto.local;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.obfuscated.j;
import com.bytedance.crypto.obfuscated.k;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class MasterKeyManager {
    private static final String MASTER_KEY_ALIAS = "local_master_key";
    private static final int MASTER_KEY_VERSION = 1;
    public static final String TAG = "MasterKeyManager";
    private static volatile MasterKeyManager keyManager;
    private byte[] localMasterKey;

    public MasterKeyManager() {
        this.localMasterKey = null;
    }

    public static MasterKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(MasterKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new MasterKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MasterKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    private boolean isMasterKeyExist(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Bundle r5 = new Bundle();
        r5.putInt("query_mode", 0);
        if (k.a().a(r3, MASTER_KEY_ALIAS, r5).f7861a == 0) goto L5;
        return false;
    L5:
        return true;
    }

    private byte[] loadMasterKey(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (isMasterKeyExist(r6) == true) goto L5;
        byte[] r4 = CryptoUtils.generateSecureRandom(32);
        if (r4.length != 0) goto L10;
        LogUtils.e(TAG, "Generate master key failed!!");
        return new byte[0];
    L10:
        j r0 = new j();
        r0.f = CryptoUtils.byteArrayToHexString(r4);
        r0.f7863a = MASTER_KEY_ALIAS;
        r0.f7864b = "local_key";
        if (k.a().a(r6, r0, new Bundle()).f7838a == 0) goto L14;
        LogUtils.e(TAG, "Store master key failed!!");
        return new byte[0];
    L14:
        return r4;
    L5:
        return queryMasterKey(r6);
    }

    private byte[] queryMasterKey(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Bundle r5 = new Bundle();
        r5.putInt("query_mode", 2);
        i r6 = k.a().a(r3, MASTER_KEY_ALIAS, r5);
        if (r6.f7861a == 0) goto L7;
        LogUtils.e(TAG, "Query master key failed!!");
        return new byte[0];
    L7:
        return CryptoUtils.hexStringToByteArray(((j) ZeusTransformUtils.preCheckCast(r6.f7862b.get(0), j.class, "com.obric.aiagent.plugin")).f);
    }

    public byte[] decryptByMasterKey(Context r6, String r7, byte[] r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (this.localMasterKey != null) goto L9;
        byte[] r10 = loadMasterKey(r9);
        this.localMasterKey = r10;
        if (r10 != null) goto L9;
        String r5 = TAG;
        String r11 = "Load master key failed!!";
    L7:
        LogUtils.e(r5, r11);
        return new byte[0];
    L9:
        byte[] r0 = new byte[4];
        if (r8.length >= 4) goto L14;
        r5 = TAG;
        StringBuilder r12 = new StringBuilder().append("Input data len is too short! len:");
    L12:
        StringBuilder r13 = r12.append(r8.length);
    L13:
        r11 = r13.toString();
        goto L7
    L14:
        System.arraycopy(r8, 0, r0, 0, 4);
        int r1 = CryptoUtils.byteArrayToInt(r0);
        if (r1 == 317657839) goto L18;
        r5 = TAG;
        r13 = new StringBuilder().append("Cannot parse input cipher data! magic:").append(r1);
        goto L13
    L18:
        if (r8.length >= 5) goto L21;
        r5 = TAG;
        StringBuilder r14 = new StringBuilder();
    L20:
        r12 = r14.append("Input data len is too short!! len:");
        goto L12
    L21:
        int r15 = Byte.toUnsignedInt(r8[4]);
        if (r15 == 1) goto L25;
        r5 = TAG;
        r13 = new StringBuilder().append("Input cipher data version is wrong! version:").append(r15);
        goto L13
    L25:
        if (r8.length >= 17) goto L27;
        r5 = TAG;
        r14 = new StringBuilder();
        goto L20
    L27:
        byte[] r4 = new byte[12];
        System.arraycopy(r8, 5, r4, 0, 12);
        if (r8.length >= 33) goto L30;
        r5 = TAG;
        r14 = new StringBuilder();
        goto L20
    L30:
        int r16 = r8.length - 17;
        byte[] r2 = new byte[r16];
        System.arraycopy(r8, 17, r2, 0, r16);
        byte[] r17 = AES.gcmXcrypt(2, this.localMasterKey, r7.getBytes(), r4, r2);
        if (r17 != null) goto L33;
    L36:
        r5 = TAG;
        r11 = "Data key decrypt failed!!";
        goto L7
    L33:
        if (r17.length == 0) goto L36;
        return r17;
    }

    public byte[] encryptByMasterKey(Context r5, String r6, byte[] r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        byte[] r0 = this.localMasterKey;
        if (r0 != null) goto L5;
    L6:
        byte[] r9 = loadMasterKey(r8);
        this.localMasterKey = r9;
        if (r9 != null) goto L9;
    L24:
        String r4 = TAG;
        String r10 = "Load master key failed!!";
    L14:
        LogUtils.e(r4, r10);
        return new byte[0];
    L9:
        if (r9.length == 0) goto L24;
    L11:
        byte[] r11 = CryptoUtils.generateSecureRandom(12);
        if (r11.length != 0) goto L16;
        r4 = TAG;
        r10 = "Generate IV failed!!";
        goto L14
    L16:
        byte[] r12 = AES.gcmXcrypt(1, this.localMasterKey, r6.getBytes(), r11, r7);
        if (r12 != null) goto L19;
    L23:
        r4 = TAG;
        r10 = "Data key encrypt failed!!";
        goto L14
    L19:
        if (r12.length == 0) goto L23;
        byte[] r13 = new byte[(r11.length + 5) + r12.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r13, 0, 4);
        r13[4] = 1;
        System.arraycopy(r11, 0, r13, 5, r11.length);
        System.arraycopy(r12, 0, r13, r11.length + 5, r12.length);
        return r13;
    L5:
        if (r0.length != 0) goto L11;
        goto L6
    }
}
