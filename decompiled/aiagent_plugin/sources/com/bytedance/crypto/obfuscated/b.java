package com.bytedance.crypto.obfuscated;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.fekwrap.FekWrapErrorCode;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f7840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f7841c;

        public a(int r1, byte[] r2, byte[] r3) {
            this.f7839a = r1;
            this.f7840b = r2;
            this.f7841c = r3;
        }
    }

    public static a a(int r3) {
        return new a(r3, new byte[0], new byte[0]);
    }

    public static a a(String r4, byte[] r5, byte[] r6) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return a(FekWrapErrorCode.ANDROID_KEYSTORE_UNSUPPORTED);
    L7:
        if (r4.isEmpty() == true) goto L41;
        if (r5.length != 32) goto L41;
        SecretKey r7 = a(r4);     // Catch: Exception -> L37
        if (r7 != null) goto L42;
        return a(FekWrapErrorCode.ANDROID_KEYSTORE_KEY_FAILED);
    L42:
        Cipher r2 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L34
        r2.init(1, r7);     // Catch: Exception -> L34
        if (r6 != null) goto L20;
    L22:
        byte[] r8 = r2.doFinal(r5);     // Catch: Exception -> L34
        byte[] r9 = r2.getIV();     // Catch: Exception -> L34
        if (r9 == null) goto L33;
        if (r9.length != 12) goto L33;
        if (r8 == null) goto L33;
        if (r8.length < 48) goto L33;
        return new a(0, r9, r8);
    L33:
        return a(FekWrapErrorCode.FEK_WRAP_FAILED);
    L20:
        if (r6.length <= 0) goto L22;
        r2.updateAAD(r6);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        LogUtils.e("AndroidKeyStoreFekWrapper", "wrap failed: " + e.getMessage());
        return a(FekWrapErrorCode.FEK_WRAP_FAILED);
    L37:
        e = move-exception;
        LogUtils.e("AndroidKeyStoreFekWrapper", "get or create wrap key failed: " + e.getMessage());
        return a(FekWrapErrorCode.ANDROID_KEYSTORE_KEY_FAILED);
    L41:
        return a(-2);
    }

    public static SecretKey a(String r5) {
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
        r1.load(null);
        if (r1.containsAlias(r5) == true) goto L6;
        KeyGenerator r0 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
        r0.init(new KeyGenParameterSpec.Builder(r5, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).setRandomizedEncryptionRequired(true).setUserAuthenticationRequired(false).build());
        r0.generateKey();
    L6:
        return (SecretKey) ZeusTransformUtils.preCheckCast(r1.getKey(r5, null), SecretKey.class, "com.obric.aiagent.plugin");
    }
}
