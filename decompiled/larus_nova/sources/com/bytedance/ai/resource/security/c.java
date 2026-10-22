package com.bytedance.ai.resource.security;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.keva.Keva;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.security.auth.x500.X500Principal;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f37518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f37519b = null;

    public static final class a {
        static {
        }

        public static SecretKey a() {
            KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");
            SecretKey r101 = null;
            r100.load(null);
            KeyStore.Entry r102 = r100.getEntry("AISDK_DEK_MASTER_AES", null);
            if ((r102 instanceof KeyStore.SecretKeyEntry) == false) goto L5;
            KeyStore.SecretKeyEntry r103 = (KeyStore.SecretKeyEntry) r102;
        L6:
            if (r103 == null) goto L8;
            r101 = r103.getSecretKey();
        L8:
            if (r101 == null) goto L10;
            return r101;
        L10:
            KeyGenerator r104 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
            r104.init(new KeyGenParameterSpec.Builder("AISDK_DEK_MASTER_AES", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());
            return r104.generateKey();
        L5:
            r103 = null;
            goto L6
        }
    }

    public c() {
    }

    static {
        f37518a = new c();
        f37519b = LazyKt.lazy(new b());
    }

    public static KeyPair a(Context r100) {
        KeyStore r101 = KeyStore.getInstance("AndroidKeyStore");
        r101.load(null);
        KeyStore.Entry r102 = r101.getEntry("AISDK_DEK_MASTER_RSA", null);
        if ((r102 instanceof KeyStore.PrivateKeyEntry) == false) goto L6;
        KeyStore.PrivateKeyEntry r103 = (KeyStore.PrivateKeyEntry) r102;
        return new KeyPair(r103.getCertificate().getPublicKey(), r103.getPrivateKey());
    L6:
        Calendar r104 = Calendar.getInstance();
        Calendar r105 = Calendar.getInstance();
        r105.add(1, 30);
        KeyPairGeneratorSpec r106 = new KeyPairGeneratorSpec.Builder(r100).setAlias("AISDK_DEK_MASTER_RSA").setSubject(new X500Principal("CN=AISDK_DEK_WRAP")).setSerialNumber(BigInteger.ONE).setStartDate(r104.getTime()).setEndDate(r105.getTime()).build();
        KeyPairGenerator r107 = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f25615a, "AndroidKeyStore");
        r107.initialize(r106);
        return r107.generateKeyPair();
    }

    public static String b(String r100, long r101) {
        return "dek_" + r100 + '_' + r101;
    }

    public static byte[] c(Context r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "packageName");
        String r100 = ((Keva) f37519b.getValue()).getString(b(r111, r112), null);
        if (r100 != null) goto L6;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: no blob in store. package=" + r111 + " version=" + r112);
        return null;
    L6:
        byte[] r101 = Base64.decode(r100, 2);
        Intrinsics.checkNotNull(r101);
        if (r101.length != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: blob is empty after Base64 decode. package=" + r111 + " version=" + r112);
        return null;
    L13:
        byte r103 = r101[0];
        if (r103 != 65) goto L33;
        int r113 = Build.VERSION.SDK_INT;
        if (r113 >= 23) goto L18;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: V_AES_GCM blob but SDK < M (" + r113 + "). package=" + r111 + " version=" + r112);
    L71:
        byte[] r114 = null;
    L72:
        if (r114 != null) goto L75;
        return null;
    L75:
        if (r114.length == 32) goto L78;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: decrypted DEK size is " + r114.length + ", expected 32. package=" + r111 + " version=" + r112);
        return null;
    L78:
        return r114;
    L18:
        if (r101.length >= 29) goto L20;
        r114 = null;
    L29:
        if (r114 != null) goto L72;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: AES-GCM decryption returned null. package=" + r111 + " version=" + r112);
        goto L72
    L20:
        byte[] r104 = ArraysKt.copyOfRange(r101, 1, 13);
        byte[] r115 = ArraysKt.copyOfRange(r101, 13, r101.length);
        SecretKey r105 = a.a();
        Cipher r106 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r106.init(2, r105, new GCMParameterSpec(128, r104));
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L23
        Object r116 = Result.m9449constructorimpl(r106.doFinal(r115));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r116) == false) goto L28;
        r116 = null;
    L28:
        r114 = (byte[]) r116;
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L33:
        if (r103 != 97) goto L58;
        int r117 = Build.VERSION.SDK_INT;
        if (r117 >= 23) goto L37;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: V_AES_GCM_V2 blob but SDK < M (" + r117 + "). package=" + r111 + " version=" + r112);
        goto L71
    L37:
        if (r101.length < 19) goto L44;
        int r118 = r101[1] & UByte.MAX_VALUE;
        if (r118 <= 0) goto L44;
        int r119 = r118 + 2;
        if (r101.length < (r119 + 16)) goto L44;
        byte[] r109 = ArraysKt.copyOfRange(r101, 2, r119);
        byte[] r120 = ArraysKt.copyOfRange(r101, r119, r101.length);
        SecretKey r121 = a.a();
        Cipher r122 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r122.init(2, r121, new GCMParameterSpec(128, r109));
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L48
        Object r124 = Result.m9449constructorimpl(r122.doFinal(r120));     // Catch: Throwable -> L48
    L51:
        if (Result.m9455isFailureimpl(r124) == false) goto L53;
        r124 = null;
    L53:
        r114 = (byte[]) r124;
    L54:
        if (r114 != null) goto L72;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: AES-GCM-V2 decryption returned null. package=" + r111 + " version=" + r112);
    L48:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        r114 = null;
        goto L54
    L58:
        if (r103 != 82) goto L70;
        PrivateKey r126 = a(r110).getPrivate();
        byte[] r127 = ArraysKt.copyOfRange(r101, 1, r101.length);
        Cipher r128 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r128.init(2, r126);
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L62
        Object r130 = Result.m9449constructorimpl(r128.doFinal(r127));     // Catch: Throwable -> L62
    L65:
        if (Result.m9455isFailureimpl(r130) == false) goto L67;
        r130 = null;
    L67:
        r114 = (byte[]) r130;
        if (r114 != null) goto L72;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: RSA decryption returned null. package=" + r111 + " version=" + r112);
    L62:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L65
    L70:
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "loadDek32 failed: unknown version byte 0x" + Integer.toString(r103, CharsKt.checkRadix(16)) + ". package=" + r111 + " version=" + r112);
        goto L71
    L9:
        r102 = false;
        goto L10
    }

    public static void d(Context r100, String r101, long r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r103, "dek32");
        boolean r104 = false;
        if (r103.length != 32) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L29;
        if (Build.VERSION.SDK_INT < 23) goto L25;
        SecretKey r106 = a.a();
        Cipher r107 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r107.init(1, r106);
        byte[] r108 = r107.getIV();
        if (r108 == null) goto L24;
        byte[] r109 = r107.doFinal(r103);
        if (r108.length != 12) goto L14;
        ByteArrayOutputStream r110 = new ByteArrayOutputStream(r109.length + 13);
        r110.write(65);
        r110.write(r108);
        r110.write(r109);
        byte[] r111 = r110.toByteArray();
        Intrinsics.checkNotNull(r111);
    L26:
        ((Keva) f37519b.getValue()).storeString(b(r101, r102), Base64.encodeToString(r111, 2));
        return;
    L14:
        int r112 = r108.length;
        if (1 <= r112) goto L17;
    L19:
        if (r104 == false) goto L22;
        ByteArrayOutputStream r113 = new ByteArrayOutputStream((r108.length + 2) + r109.length);
        r113.write(97);
        r113.write(r108.length);
        r113.write(r108);
        r113.write(r109);
        r111 = r113.toByteArray();
        Intrinsics.checkNotNull(r111);
        goto L26
    L22:
        throw new IllegalArgumentException(("Unsupported GCM IV length: " + r108.length).toString());
    L17:
        if (r112 >= 256) goto L19;
        r104 = true;
        goto L19
    L24:
        throw new IllegalStateException("GCM IV is null");
    L25:
        PublicKey r114 = a(r100).getPublic();
        Cipher r115 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r115.init(1, r114);
        byte[] r116 = r115.doFinal(r103);
        ByteArrayOutputStream r117 = new ByteArrayOutputStream(r116.length + 1);
        r117.write(82);
        r117.write(r116);
        r111 = r117.toByteArray();
        goto L26
    L29:
        throw new IllegalArgumentException("DEK must be 32 bytes".toString());
    L5:
        r105 = false;
        goto L6
    }
}
