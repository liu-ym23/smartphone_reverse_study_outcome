package com.bytedance.ai.resource.security;

import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptCryptoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptCryptoResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptResponseData;
import com.bytedance.ai.resource.core.bean.OpenPlatformPublicKeyListData;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f37536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f37537b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f37538c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f37541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final PrivateKey f37542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f37543e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37539a, r101.f37539a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37540b, r101.f37540b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37541c, r101.f37541c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f37542d, r101.f37542d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f37543e, r101.f37543e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f37539a.hashCode() * 31) + this.f37540b.hashCode()) * 31) + Arrays.hashCode(this.f37541c)) * 31) + this.f37542d.hashCode()) * 31) + Arrays.hashCode(this.f37543e);
        }

        public final String toString() {
            return "DebugDekDecryptRequestContext(requestId=" + this.f37539a + ", requestJson=" + this.f37540b + ", clientPublicKey=" + Arrays.toString(this.f37541c) + ", privateKey=" + this.f37542d + ", salt=" + Arrays.toString(this.f37543e) + ')';
        }

        public a(String r100, String r101, byte[] r102, PrivateKey r103, byte[] r104) {
            Intrinsics.checkNotNullParameter(r100, "requestId");
            Intrinsics.checkNotNullParameter(r101, "requestJson");
            Intrinsics.checkNotNullParameter(r102, "clientPublicKey");
            Intrinsics.checkNotNullParameter(r103, "privateKey");
            Intrinsics.checkNotNullParameter(r104, "salt");
            this.f37539a = r100;
            this.f37540b = r101;
            this.f37541c = r102;
            this.f37542d = r103;
            this.f37543e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f37545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f37546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Unit> f37547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<Throwable, Unit> f37548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Job f37549f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f37544a, r101.f37544a) == true) goto L12;
            return false;
        L12:
            if (this.f37545b == r101.f37545b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37546c, r101.f37546c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f37547d, r101.f37547d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f37548e, r101.f37548e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f37549f, r101.f37549f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f37544a.hashCode() * 31;
            long r101 = this.f37545b;
            int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f37546c.hashCode()) * 31) + this.f37547d.hashCode()) * 31) + this.f37548e.hashCode()) * 31;
            Job r103 = this.f37549f;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingDebugDekRequest(packageName=" + this.f37544a + ", versionCode=" + this.f37545b + ", requestContext=" + this.f37546c + ", resolve=" + this.f37547d + ", reject=" + this.f37548e + ", timeoutJob=" + this.f37549f + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, long r101, a r102, Function0<Unit> r103, Function1<? super Throwable, Unit> r104, Job r105) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            Intrinsics.checkNotNullParameter(r102, "requestContext");
            Intrinsics.checkNotNullParameter(r103, JSEventListener.ACTION_RESOLVE);
            Intrinsics.checkNotNullParameter(r104, "reject");
            this.f37544a = r100;
            this.f37545b = r101;
            this.f37546c = r102;
            this.f37547d = r103;
            this.f37548e = r104;
            this.f37549f = r105;
        }
    }

    public j() {
    }

    static {
        f37536a = new j();
        f37537b = new ConcurrentHashMap();
        f37538c = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static a a(byte[] r210) {
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);
        r100.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair r101 = r100.generateKeyPair();
        byte[] r102 = g(r101);
        String r103 = UUID.randomUUID().toString();
        byte[] r104 = new byte[16];
        new SecureRandom().nextBytes(r104);
        byte[] r105 = new byte[16];
        new SecureRandom().nextBytes(r105);
        long r110 = System.currentTimeMillis() / 1000;
        OpenPlatformDekDecryptCryptoRequest r106 = new OpenPlatformDekDecryptCryptoRequest(null, Base64.encodeToString(r102, 2), Base64.encodeToString(r104, 2), Base64.encodeToString(r105, 2), r110, 1, null);
        JSONObject r107 = new JSONObject().put("request_id", r103).put("wrapped_dek", Base64.encodeToString(r210, 2)).put("crypto", new JSONObject(com.bytedance.ai.applet.base.gson.e.c(r106)));
        return new a(r103, new JSONObject().put(com.alipay.sdk.m.p.e.f25671s, "Applet_DecryptDEK").put("params", r107).toString(), r102, r101.getPrivate(), r104);
    }

    public static Pair e(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        Lazy r101 = o5.b.f522025a;
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        OpenPlatformBaseResponse<OpenPlatformPublicKeyListData> r102 = o5.b.a().getSignPublicKeys(r100);
        boolean r103 = true;
        if (r102.getCode() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L34;
        OpenPlatformPublicKeyListData r105 = r102.getData();
        if (r105 == null) goto L32;
        Map<String, String> r106 = r105.getKeys();
        String r107 = r105.getVersion();
        if (r106 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == true) goto L30;
        if (r107 != null) goto L19;
    L22:
        if (r103 == true) goto L30;
        LinkedHashMap r109 = new LinkedHashMap(r106.size());
        Iterator<Map.Entry<String, String>> r110 = r106.entrySet().iterator();
    L25:
        if (r110.hasNext() == false) goto L28;
        Map.Entry<String, String> r111 = r110.next();
        String r112 = r111.getKey();
        String r113 = r111.getValue();
        f37536a.getClass();
        long r114 = CastLongProtector.parseLong(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r112).toString(), "0x"), "0X"), CharsKt.checkRadix(16));
        r109.put(Long.valueOf(r114), KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode(r113, 0))));
        goto L25
    L28:
        return new Pair(r107, r109);
    L19:
        if (r107.length() == 0) goto L22;
        r103 = false;
    L30:
        throw new IllegalStateException("fetch sign public keys failed: INVALID results");
    L12:
        if (r106.isEmpty() == true) goto L15;
        r108 = false;
        goto L16
    L32:
        throw new IllegalStateException("fetch sign public keys failed: data is NULL");
    L34:
        throw new IllegalStateException("fetch sign public keys failed: " + r102.getCode() + ' ' + r102.getMessage());
    L5:
        r104 = false;
        goto L6
    }

    public static byte[] f(byte[] r100) {
        if (r100.length != 32) goto L5;
        return r100;
    L5:
        byte[] r101 = new byte[32];
        if (r100.length <= 32) goto L8;
        System.arraycopy(r100, r100.length - 32, r101, 0, 32);
    L9:
        return r101;
    L8:
        System.arraycopy(r100, 0, r101, 32 - r100.length, r100.length);
        goto L9
    }

    public static byte[] g(KeyPair r100) {
        PublicKey r101 = r100.getPublic();
        if ((r101 instanceof ECPublicKey) == false) goto L5;
        ECPublicKey r102 = (ECPublicKey) r101;
    L6:
        if (r102 == null) goto L10;
        ECPoint r103 = r102.getW();
        byte[] r104 = f(r103.getAffineX().toByteArray());
        byte[] r105 = f(r103.getAffineY().toByteArray());
        byte[] r106 = new byte[65];
        r106[0] = 4;
        System.arraycopy(r104, 0, r106, 1, 32);
        System.arraycopy(r105, 0, r106, 33, 32);
        return r106;
    L10:
        throw new IllegalArgumentException("not ec public key");
    L5:
        r102 = null;
        goto L6
    }

    public static byte[] b(a r110, JSONObject r111) {
        if (r111.optBoolean("success", false) == false) goto L44;
        JSONObject r100 = r111.optJSONObject("crypto");
        if (r100 == null) goto L42;
        String r101 = r100.optString("server_pub");
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L40;
        String r104 = r100.optString("srv_iv");
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L38;
        String r112 = r111.optString("dek_cipher");
        if (r112 != null) goto L25;
    L28:
        if (r102 == true) goto L36;
        byte[] r106 = Base64.decode(r101, 0);
        byte[] r107 = Base64.decode(r104, 0);
        byte[] r108 = Base64.decode(r112, 0);
        if (r107.length != 12) goto L34;
        PrivateKey r109 = r110.f37542d;
        byte[] r113 = r110.f37541c;
        byte[] r114 = r110.f37543e;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r107);
        Intrinsics.checkNotNull(r108);
        return d(r109, r113, r114, r106, r107, r108);
    L34:
        throw new IllegalArgumentException("srv_iv must be 12 bytes");
    L36:
        throw new IllegalStateException("missing dek_cipher in response");
    L25:
        if (StringsKt.isBlank(r112) == true) goto L28;
        r102 = false;
        goto L28
    L38:
        throw new IllegalStateException("missing srv_iv in response");
    L17:
        if (StringsKt.isBlank(r104) == true) goto L20;
        r105 = false;
        goto L21
    L40:
        throw new IllegalStateException("missing server_pub in response");
    L9:
        if (StringsKt.isBlank(r101) == true) goto L12;
        r103 = false;
        goto L13
    L42:
        throw new IllegalArgumentException("crypto is empty");
    L44:
        throw new IllegalStateException(r111.optString("message", "debug DEK decrypt failed"));
    }

    public static byte[] c(String r210, byte[] r211) {
        Intrinsics.checkNotNullParameter(r210, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r211, "wrappedDekBytes");
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);
        r100.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair r101 = r100.generateKeyPair();
        byte[] r102 = g(r101);
        byte[] r103 = new byte[16];
        new SecureRandom().nextBytes(r103);
        byte[] r104 = new byte[16];
        new SecureRandom().nextBytes(r104);
        OpenPlatformDekDecryptRequest r105 = new OpenPlatformDekDecryptRequest(Base64.encodeToString(r211, 2), new OpenPlatformDekDecryptCryptoRequest(null, Base64.encodeToString(r102, 2), Base64.encodeToString(r103, 2), Base64.encodeToString(r104, 2), System.currentTimeMillis() / 1000, 1, null));
        Lazy r106 = o5.b.f522025a;
        Intrinsics.checkNotNullParameter(r210, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r105, "request");
        OpenPlatformBaseResponse<OpenPlatformDekDecryptResponseData> r107 = o5.b.a().decryptDek(r210, r105);
        if (r107.getCode() != 0) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L34;
        OpenPlatformDekDecryptResponseData r109 = r107.getData();
        if (r109 == null) goto L32;
        OpenPlatformDekDecryptCryptoResponse r110 = r109.getCrypto();
        if (r110 == null) goto L30;
        String r111 = r110.getServerPub();
        if (r111 == null) goto L28;
        String r112 = r110.getSrvIv();
        if (r112 == null) goto L26;
        String r113 = r109.getDekCipher();
        if (r113 == null) goto L24;
        byte[] r114 = Base64.decode(r111, 0);
        byte[] r115 = Base64.decode(r112, 0);
        byte[] r116 = Base64.decode(r113, 0);
        if (r115.length != 12) goto L22;
        PrivateKey r117 = r101.getPrivate();
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNull(r116);
        return d(r117, r102, r103, r114, r115, r116);
    L22:
        throw new IllegalArgumentException("srv_iv must be 12 bytes");
    L24:
        throw new IllegalStateException("missing dek_cipher in response");
    L26:
        throw new IllegalStateException("missing srv_iv in response");
    L28:
        throw new IllegalStateException("missing server_pub in response");
    L30:
        throw new IllegalStateException("missing crypto in response");
    L32:
        throw new IllegalStateException("empty data");
    L34:
        throw new IllegalStateException("decrypt dek failed: " + r107.getCode() + ' ' + r107.getMessage());
    L5:
        r108 = false;
        goto L6
    }

    public static byte[] d(PrivateKey r100, byte[] r101, byte[] r110, byte[] r111, byte[] r112, byte[] r113) {
        if (r111.length != 65) goto L18;
        int r102 = 0;
        if (r111[0] != 4) goto L18;
        ECPoint r103 = new ECPoint(new BigInteger(1, ArraysKt.copyOfRange(r111, 1, 33)), new BigInteger(1, ArraysKt.copyOfRange(r111, 33, 65)));
        KeyPairGenerator r104 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);
        r104.initialize(new ECGenParameterSpec("secp256r1"));
        PublicKey r105 = r104.generateKeyPair().getPublic();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        PublicKey r114 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new ECPublicKeySpec(r103, ((ECPublicKey) r105).getParams()));
        KeyAgreement r106 = KeyAgreement.getInstance("ECDH");
        r106.init(r100);
        r106.doPhase(r114, true);
        byte[] r107 = r106.generateSecret();
        Intrinsics.checkNotNull(r107);
        byte[] r108 = f(r107);
        int r115 = com.bytedance.ai.resource.security.a.f37517a;
        Intrinsics.checkNotNullParameter("pwd-transfer-v1|resp|", "s");
        byte[][] r109 = {"pwd-transfer-v1|resp|".getBytes(StandardCharsets.UTF_8), r101};
        Intrinsics.checkNotNullParameter(r109, "parts");
        ByteArrayOutputStream r116 = new ByteArrayOutputStream();
        int r117 = 0;
    L7:
        if (r117 >= 2) goto L9;
        r116.write(r109[r117]);
        r117 = r117 + 1;
        goto L7
    L9:
        byte[] r118 = r116.toByteArray();
        Intrinsics.checkNotNullParameter(r110, "salt");
        Intrinsics.checkNotNullParameter(r108, "ikm");
        Intrinsics.checkNotNullParameter(r118, "info");
        Mac r119 = Mac.getInstance("HmacSHA256");
        r119.init(new SecretKeySpec(r110, "HmacSHA256"));
        byte[] r120 = r119.doFinal(r108);
        ByteArrayOutputStream r121 = new ByteArrayOutputStream(32);
        byte[][] r122 = {new byte[0], r118, new byte[]{(byte) 1}};
        Intrinsics.checkNotNullParameter(r122, "parts");
        ByteArrayOutputStream r123 = new ByteArrayOutputStream();
    L10:
        if (r102 >= 3) goto L12;
        r123.write(r122[r102]);
        r102 = r102 + 1;
        goto L10
    L12:
        byte[] r124 = r123.toByteArray();
        Mac r125 = Mac.getInstance("HmacSHA256");
        r125.init(new SecretKeySpec(r120, "HmacSHA256"));
        r121.write(r125.doFinal(r124));
        byte[] r126 = r121.toByteArray();
        Intrinsics.checkNotNull(r126);
        byte[] r127 = Arrays.copyOf(r126, 32);
        Cipher r128 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r128.init(2, new SecretKeySpec(r127, CryptoConst.ALGORITHM_AES), new GCMParameterSpec(128, r112));
        byte[] r129 = r128.doFinal(r113);
        if (r129.length != 32) goto L16;
        return r129;
    L16:
        throw new IllegalArgumentException("DEK must be 32 bytes, got " + r129.length);
    L18:
        throw new IllegalArgumentException("pub must be 65-byte uncompressed: 0x04||X||Y");
    }
}
