package com.bytedance.android.sdk.bdticketguard.key;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.l1;
import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import javax.security.auth.x500.X500Principal;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import net.bytedance.zdplib.Delta;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TeeApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f163810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f163811c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Boolean f163812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f163813e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TeeApi f163814f = null;

    static {
        f163809a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TeeApi.class), "lazyKeyStore", "getLazyKeyStore()Ljava/security/KeyStore;"))};
        f163814f = new TeeApi();
        f163811c = LazyKt.lazy(TeeApi$lazyKeyStore$2.INSTANCE);
        f163813e = new Object();
    }

    public TeeApi() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static KeyStore f() {
        com.bytedance.android.sdk.bdticketguard.setting.l.f164015l0.getClass();
        com.bytedance.android.sdk.bdticketguard.setting.m r100 = com.bytedance.android.sdk.bdticketguard.setting.l.f164005g0;
        KProperty r101 = com.bytedance.android.sdk.bdticketguard.setting.l.f163998d[54];
        if (((Boolean) r100.f164030a.a()).booleanValue() == false) goto L5;
        Lazy r102 = f163811c;
        KProperty r103 = f163809a[0];
        return (KeyStore) r102.getValue();
    L5:
        KeyStore r104 = KeyStore.getInstance("AndroidKeyStore");
        r104.load(null);
        return r104;
    }

    public static void b(Context r100) {
        if (f163812d == null) goto L9;
        Boolean r101 = f163812d;
        if (r101 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r101.booleanValue();
        return;
    L9:
        Object r102 = f163813e;
        monitor-enter(r102);
    L32:
        th = move-exception;
        throw th;
    L12:
        if (f163812d == null) goto L36;
        Boolean r103 = f163812d;     // Catch: Throwable -> L32
        if (r103 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L32
    L16:
        r103.booleanValue();     // Catch: Throwable -> L32
        monitor-exit(r102);
        return;
    L36:
        f163814f.getClass();     // Catch: Throwable -> L22
        f();     // Catch: Throwable -> L22
        r0.c("TeeKeyHelper", "getAndroidKeyStore success");     // Catch: Throwable -> L22
        f163812d = Boolean.TRUE;     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        r0.d(6, "TeeKeyHelper", "getAndroidKeyStore failed, need fix", th);     // Catch: Throwable -> L32
        boolean r104 = false;
        Class r105 = a();     // Catch: Exception -> L27 Throwable -> L32
        Object r106 = r105.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L27 Throwable -> L32
        Field r107 = r105.getDeclaredField("mInitialApplication");     // Catch: Exception -> L27 Throwable -> L32
        r107.setAccessible(true);     // Catch: Exception -> L27 Throwable -> L32
        r107.set(r106, r100);     // Catch: Exception -> L27 Throwable -> L32
        r104 = true;
    L29:
        f163812d = Boolean.valueOf(r104);     // Catch: Throwable -> L32
        return;
    L27:
        e = move-exception;
        r0.d(6, "TeeKeyHelper", "fixAndroidKeyStore failed", e);     // Catch: Throwable -> L32
        goto L29
    }

    @JvmStatic
    public static final String j(ECPublicKey r100) {
        ECPoint r101 = r100.getW();
        BigInteger r102 = r101.getAffineX();
        BigInteger r103 = r101.getAffineY();
        f163814f.getClass();
        return "04" + Delta.d(l(r102)) + Delta.d(l(r103));
    }

    @JvmStatic
    public static final X509Certificate k(byte[] r100) throws IOException, CertificateException {
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);
        Certificate r102 = CertificateFactory.getInstance("X.509").generateCertificate(r101);
        r101.close();
        if ((r102 instanceof X509Certificate) == true) goto L7;
        return null;
    L7:
        return (X509Certificate) r102;
    }

    public static byte[] l(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (r101.length > 32) goto L5;
    L7:
        byte[] r102 = new byte[32];
        int r103 = Math.min(r101.length, 32);
        int r104 = Math.max(0, r101.length - 32);
        System.arraycopy(r101, r104, r102, 32 - r103, r103);
        return r102;
    L5:
        if (r101[0] != ((byte) 0)) goto L7;
        r101 = ArraysKt.copyOfRange(r101, 1, r101.length);
        goto L7
    }

    public static void c(com.bytedance.android.sdk.bdticketguard.d r100, com.bytedance.android.sdk.bdticketguard.key.attestation.c r101) throws Exception {
        String r102 = r101.f163870b;
        String r103 = r101.f163872d;
        com.bytedance.android.sdk.bdticketguard.key.attestation.d r104 = r101.f163873e;
        String r105 = r102 + '#' + r103;
        MessageDigest r106 = MessageDigest.getInstance("SHA-256");
        Charset r107 = Charsets.UTF_8;
        if (r105 == null) goto L7;
        byte[] r108 = r106.digest(r105.getBytes(r107));
        r100.e(Base64.encodeToString(r108, 2));
        r104.d(new KeyGenParameterSpec.Builder("bd_ticket_guard_key_attestation", 4).setDigests(new String[]{"SHA-256"}).setAttestationChallenge(r108).build()).generateKeyPair();
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmStatic
    public static final String d(KeyPair r110, String r111) throws Exception {
        if (r111 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if ((!r100) == false) goto L14;
        byte r101 = (byte) 255;
        byte[] r102 = com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.e(2, BigInteger.ZERO.toByteArray()), new X500Principal(r111).getEncoded(), r110.getPublic().getEncoded(), com.bytedance.android.sdk.bdticketguard.math.c.e(160, com.bytedance.android.sdk.bdticketguard.math.c.a(CollectionsKt.sortedWith(ArraysKt.toList(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.b("1.2.840.113549.1.9.14"), com.bytedance.android.sdk.bdticketguard.math.c.e(49, com.bytedance.android.sdk.bdticketguard.math.c.a(CollectionsKt.sortedWith(ArraysKt.toList(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.b("2.5.29.19"), com.bytedance.android.sdk.bdticketguard.math.c.e(1, new byte[]{r101}), com.bytedance.android.sdk.bdticketguard.math.c.e(4, com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.e(1, new byte[]{r101})}))})})}), com.bytedance.android.sdk.bdticketguard.math.b.f163965a)))})}), com.bytedance.android.sdk.bdticketguard.math.a.f163964a)))});
        byte[] r103 = com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{com.bytedance.android.sdk.bdticketguard.math.c.b("1.2.840.10045.4.3.2")});
        Signature r104 = Signature.getInstance("SHA256withECDSA");
        r104.initSign(r110.getPrivate());
        r104.update(r102);
        byte[] r105 = r104.sign();
        byte[] r106 = new byte[r105.length + 1];
        r106[0] = (byte) 0;
        ArraysKt.copyInto$default(r105, r106, 1, 0, 0, 12, null);
        return com.bytedance.android.sdk.bdticketguard.math.c.c("CERTIFICATE REQUEST", com.bytedance.android.sdk.bdticketguard.math.c.d(new byte[][]{r102, r103, com.bytedance.android.sdk.bdticketguard.math.c.e(3, r106)}));
    L14:
        throw new IllegalArgumentException("principal is empty".toString());
    L5:
        if (StringsKt.isBlank(r111) == true) goto L8;
        r100 = false;
        goto L10
    }

    public static KeyGenParameterSpec g(String r100, com.bytedance.android.sdk.bdticketguard.data.f r101) {
        if (r100 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        KeyGenParameterSpec.Builder r102 = new KeyGenParameterSpec.Builder(r100, 4).setDigests(new String[]{"SHA-256"});
        Date r103 = new Date(0);
        Date r104 = new Date(2461449600000L);
        r0.c("TeeKeyHelper", "enableTeeKeyGenWithCert");
        r102.setCertificateSubject(new X500Principal("CN=" + r100));
        r102.setCertificateSerialNumber(BigInteger.ONE);
        r102.setCertificateNotBefore(r103);
        r102.setCertificateNotAfter(r104);
        if (r101 == null) goto L8;
        r101.f163615a = 1;
    L8:
        r102.setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1"));
        if (r101 == null) goto L11;
        r101.f163616b = 1;
    L11:
        com.bytedance.android.sdk.bdticketguard.setting.l.f164015l0.getClass();
        com.bytedance.android.sdk.bdticketguard.setting.m r105 = com.bytedance.android.sdk.bdticketguard.setting.l.f164003f0;
        KProperty r106 = com.bytedance.android.sdk.bdticketguard.setting.l.f163998d[53];
        if (((Boolean) r105.f164030a.a()).booleanValue() == false) goto L16;
        r102.setUserAuthenticationRequired(false);
        if (r101 == null) goto L19;
        r101.f163618d = 1;
    L19:
        return r102.build();
    L16:
        if (r101 == null) goto L19;
        r101.f163618d = 0;
        goto L19
    }

    @JvmStatic
    public static final boolean h(byte[] r100, PrivateKey r101) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException, CertificateException {
        byte[] r102 = EffectConstants.CHANNEL_TEST.getBytes(Charsets.UTF_8);
        Signature r103 = Signature.getInstance("SHA256withECDSA");
        r103.initSign(r101);
        r103.update(r102);
        byte[] r104 = r103.sign();
        X509Certificate r105 = k(r100);
        if (r105 == null) goto L8;
        Signature r106 = Signature.getInstance("SHA256withECDSA");
        r106.initVerify(r105);
        r106.update(r102);
        boolean r107 = r106.verify(r104);
        if (r107 == true) goto L7;
        KProperty[] r108 = TicketGuardEventHelper.f163511a;
        TicketGuardEventHelper.B("bd_ticket_guard_key_cert_not_match", new JSONObject());
    L7:
        return r107;
    L8:
        return false;
    }

    @JvmStatic
    public static final KeyPair e(String r100, SharedPreferences.Editor r101, com.bytedance.android.sdk.bdticketguard.data.d r102) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (r102 != null) goto L25;
        com.bytedance.android.sdk.bdticketguard.data.f r103 = null;
    L8:
        int r104 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L5
        if (r104 < 23) goto L19;
        if (r103 == null) goto L12;
        r103.f163617c = 0;     // Catch: Throwable -> L5
    L12:
        KeyPairGenerator r105 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, "AndroidKeyStore");     // Catch: Throwable -> L5
        f163814f.getClass();     // Catch: Throwable -> L5
        r105.initialize(g(r100, r103));     // Catch: Throwable -> L5
        KeyPair r106 = r105.genKeyPair();     // Catch: Throwable -> L5
        TeeKeyRecovery r107 = TeeKeyRecovery.f163836d;     // Catch: Throwable -> L5
        PublicKey r108 = r106.getPublic();     // Catch: Throwable -> L5
        r107.getClass();     // Catch: Throwable -> L5
        TeeKeyRecovery.b(r100, r108);     // Catch: Throwable -> L5
        if (r100 != null) goto L16;
        r100 = "no_alias";
    L16:
        com.bytedance.android.sdk.bdticketguard.data.e.b(r101, r100, r102);
        r101.apply();
        return r106;
    L19:
        throw new UnsupportedOperationException("TEE not supported for current SDK ver: " + r104);     // Catch: Throwable -> L5
    L25:
        r103 = new com.bytedance.android.sdk.bdticketguard.data.f(-1, -1, -1, -1);     // Catch: Throwable -> L5
        r102.f163608a = r103;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        if (r100 != null) goto L23;
        r100 = "no_alias";
    L23:
        com.bytedance.android.sdk.bdticketguard.data.e.b(r101, r100, r102);
        r101.apply();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r33v1 */
    /* JADX WARN: Type inference failed for: r33v2 */
    /* JADX WARN: Type inference failed for: r33v3 */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.bytedance.android.sdk.bdticketguard.key.TeeKeyRecovery$tryRecoverTeeKeyPair$1] */
    @JvmStatic
    public static final KeyPair i(final String r310, boolean r311, final com.bytedance.android.sdk.bdticketguard.data.d r312) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableEntryException, InvalidKeySpecException {
        if (r312 == null) goto L5;
        com.bytedance.android.sdk.bdticketguard.data.g r100 = new com.bytedance.android.sdk.bdticketguard.data.g(null);
        r312.f163609b = r100;
        com.bytedance.android.sdk.bdticketguard.data.g r110 = r100;
    L6:
        TeeKeyRecovery.f163836d.getClass();
        TeeKeyRecovery.a();
        if (r110 == null) goto L9;
        r110.f163620b = "none";
    L9:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 23) goto L190;
        if (r110 == null) goto L13;
        r110.f163620b = "ks";
    L13:
        f163814f.getClass();
        KeyStore r102 = f();
        if (r110 == null) goto L192;
        r110.f163619a = true;
    L192:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L29
        if (r110 == null) goto L19;
        r110.f163620b = "1_cert";     // Catch: Throwable -> L29
    L19:
        r0.c("TeeKeyHelper", "load key pair from keystore, separated");     // Catch: Throwable -> L29
        Certificate r104 = r102.getCertificate(r310);     // Catch: Throwable -> L29
        if (r104 == null) goto L28;
        if (r110 == null) goto L23;
        r110.f163620b = "2_pub_key";     // Catch: Throwable -> L29
    L23:
        PublicKey r105 = r104.getPublicKey();     // Catch: Throwable -> L29
        if (r105 != null) goto L26;
        Intrinsics.throwNpe();     // Catch: Throwable -> L29
    L26:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L29
    L31:
        final com.bytedance.android.sdk.bdticketguard.utils.c r111 = com.bytedance.android.sdk.bdticketguard.utils.d.a(r106);
        if (r110 != null) goto L191;
    L34:
        Key r107 = r102.getKey(r310, null);     // Catch: Throwable -> L39
        if (r107 == null) goto L38;
        Object r108 = Result.m9449constructorimpl((PrivateKey) r107);     // Catch: Throwable -> L39
    L41:
        final com.bytedance.android.sdk.bdticketguard.utils.c r109 = com.bytedance.android.sdk.bdticketguard.utils.d.a(r108);
        if (r110 == null) goto L61;
        if ((r109 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) == false) goto L46;
        int r112 = l1.f163946c;
        l1 r113 = l1.a.a();
    L51:
        r110.f163623e = r113;
        if ((r111 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) == false) goto L54;
        l1 r114 = l1.a.a();
    L59:
        r110.f163624f = r114;
        goto L61
    L54:
        Throwable r115 = r111.a();
        if (r115 != null) goto L58;
        r115 = new RuntimeException("Public key load failed");
    L58:
        r114 = new l1(r115);
        goto L59
    L46:
        int r116 = l1.f163946c;
        Throwable r117 = r109.a();
        if (r117 != null) goto L50;
        r117 = new RuntimeException("Private key load failed");
    L50:
        r113 = new l1(r117);
    L61:
        if ((r111 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) == true) goto L63;
    L65:
        boolean r118 = false;
    L66:
        if (r118 == false) goto L69;
        if (r110 == null) goto L69;
        r110.f163626h = "keystore";
    L69:
        if (r118 == true) goto L118;
        if (r311 == false) goto L118;
        TeeKeyRecovery.f163836d.getClass();
        long r119 = SystemClock.elapsedRealtimeNanos();
        com.bytedance.android.sdk.bdticketguard.setting.l.f164015l0.getClass();
        com.bytedance.android.sdk.bdticketguard.setting.m r120 = com.bytedance.android.sdk.bdticketguard.setting.l.X;
        KProperty r121 = com.bytedance.android.sdk.bdticketguard.setting.l.f163998d[45];
        List r122 = (List) r120.f164030a.a();
        int r123 = r0.f163979a;
        r0.c("TeeKeyRecovery", "getMethods: " + r122);
        ArrayList r124 = new ArrayList();
        Iterator r125 = r122.iterator();
    L73:
        if (r125.hasNext() == false) goto L77;
        String r126 = (String) r125.next();
        TeeKeyRecovery.f163836d.getClass();
        Lazy r127 = TeeKeyRecovery.f163834b;
        KProperty r128 = TeeKeyRecovery.f163833a[0];
        o r129 = (o) ((Map) r127.getValue()).get(r126);
        if (r129 == null) goto L73;
        r124.add(r129);
        goto L73
    L77:
        final ArrayList r130 = new ArrayList();
        Ref.ObjectRef r131 = new Ref.ObjectRef();
        r131.element = null;
        final Ref.IntRef r132 = new Ref.IntRef();
        r132.element = -1;
        ?? r313 = r1;
        final Ref.ObjectRef r133 = r131;
        com.bytedance.android.sdk.bdticketguard.utils.c r210 = r109;
        Function2<o, Integer, Unit> r134 = new TeeKeyRecovery$tryRecoverTeeKeyPair$1(r310, r109, r111, r133, r132, r130);
        int r135 = r0.f163979a;
        StringBuilder r136 = new StringBuilder("tryRecoverTeeKeyPair start, methods: ");
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r138 = r124.iterator();
    L79:
        if (r138.hasNext() == false) goto L81;
        r137.add(((o) r138.next()).a());
        goto L79
    L81:
        r136.append(r137);
        r0.c("TeeKeyRecovery", r136.toString());
        Iterator r139 = r124.iterator();
        int r140 = 0;
    L83:
        if (r139.hasNext() == false) goto L88;
        ?? r141 = r313;
        r141.invoke((o) r139.next(), r140);
        Ref.ObjectRef r142 = r133;
        if (((Pair) r142.element) != null) goto L89;
        r140 = r140 + 1;
        r133 = r142;
        r313 = r141;
    L89:
        long r143 = SystemClock.elapsedRealtimeNanos();
        Pair r144 = (Pair) r142.element;
        if (r144 == null) goto L109;
        com.bytedance.android.sdk.bdticketguard.data.b.C2498b r145 = (com.bytedance.android.sdk.bdticketguard.data.b.C2498b) r144.getSecond();
        Pair r146 = (Pair) r142.element;
        if (r146 != null) goto L94;
        Intrinsics.throwNpe();
    L94:
        String r147 = (String) r146.getFirst();
        Lazy r148 = TeeKeyRecovery.f163835c;
        KProperty r149 = TeeKeyRecovery.f163833a[1];
        Boolean r150 = (Boolean) ((Map) r148.getValue()).get(r147);
        if (r150 == null) goto L97;
        boolean r151 = r150.booleanValue();
    L98:
        if (r151 == false) goto L100;
        ExecutorService r152 = j.f163904a;
        j.f163904a.submit(new i(r145.f163599b, r145.f163598a, r147, r132.element));
    L100:
        PublicKey r153 = r145.f163598a;
        PrivateKey r154 = r145.f163599b;
        boolean r155 = r145.f163600c;
        String r156 = r145.f163601d;
        long r211 = r143 - r119;
        ArrayList r157 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));
        Iterator r158 = r130.iterator();
    L102:
        if (r158.hasNext() == false) goto L104;
        Pair r159 = (Pair) r158.next();
        r157.add(TuplesKt.to(r159.getFirst(), ((com.bytedance.android.sdk.bdticketguard.data.b.a) r159.getSecond()).f163597a));
        goto L102
    L104:
        ArrayList r160 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r161 = r124.iterator();
    L106:
        if (r161.hasNext() == false) goto L108;
        r160.add(((o) r161.next()).a());
        goto L106
    L108:
        final com.bytedance.android.sdk.bdticketguard.data.h r162 = new com.bytedance.android.sdk.bdticketguard.data.h.b(r153, r154, r147, r155, r156, r157, r211, r160);
    L119:
        if (r162 == null) goto L141;
        if (r110 == null) goto L122;
        r110.f163620b = "3_keypair_reflect_recovery";
    L122:
        if (r110 == null) goto L129;
        String r163 = r162.d();
        if (r163 != null) goto L127;
        r163 = "";
    L127:
        r110.f163631m = r163;
    L129:
        if ((r162 instanceof com.bytedance.android.sdk.bdticketguard.data.h.b) == false) goto L134;
        int r164 = com.bytedance.android.sdk.bdticketguard.utils.c.f164084a;
        com.bytedance.android.sdk.bdticketguard.data.h.b r165 = (com.bytedance.android.sdk.bdticketguard.data.h.b) r162;
        r111 = new com.bytedance.android.sdk.bdticketguard.utils.c.C2503c(r165.f163636a);
        com.bytedance.android.sdk.bdticketguard.utils.c.C2503c r166 = new com.bytedance.android.sdk.bdticketguard.utils.c.C2503c(r165.f163637b);
        if (r110 == null) goto L133;
        r110.f163626h = r165.f163638c;
        r110.f163630l = Boolean.valueOf(r165.f163639d);
        r110.f163627i = r162.c().size() + 1;
    L133:
        com.bytedance.android.sdk.bdticketguard.utils.c r167 = r166;
    L135:
        if (r110 == null) goto L137;
        r110.f163628j = r162.a();
    L137:
        if (r110 == null) goto L139;
        r110.f163629k = r162.c();
    L139:
        if (r110 == null) goto L142;
        r110.f163625g = r162.b();
    L142:
        Function0<Unit> r168 = new TeeApi$loadKeyPair$3(r162, r312);
        boolean r169 = r167 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c;
        if (r169 == true) goto L151;
        if (r110 == null) goto L146;
        r110.f163622d = false;
    L146:
        r168.invoke2();
        Throwable r170 = r167.a();
        if (r170 == null) goto L150;
        throw r170;
    L150:
        throw new RuntimeException("Private key load failed");
    L151:
        if (r169 == false) goto L184;
        PrivateKey r171 = (PrivateKey) ((com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) r167).f164086b;
        if (r110 == null) goto L155;
        r110.f163622d = true;
    L155:
        boolean r172 = r111 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c;
        if (r172 == true) goto L165;
        int r173 = r0.f163979a;
        r0.d(6, "TeeKeyHelper", "Key pair load result failed after fix", r111.a());
        if (r110 == null) goto L160;
        r110.f163621c = false;
    L160:
        r168.invoke2();
        Throwable r174 = r111.a();
        if (r174 == null) goto L164;
        throw r174;
    L164:
        throw new RuntimeException("Public key load failed after fix");
    L165:
        if (r172 == false) goto L178;
        PublicKey r175 = (PublicKey) ((com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) r111).f164086b;
        if (r110 == null) goto L169;
        r110.f163621c = true;
    L169:
        TeeKeyRecovery.f163836d.getClass();
        TeeKeyRecovery.b(r310, r175);
        r168.invoke2();
        if (r110 == null) goto L172;
        r110.f163620b = "done";
    L172:
        if (r175 == null) goto L175;
        if (r171 == null) goto L175;
        return new KeyPair(r175, r171);
    L175:
        return null;
    L178:
        if ((r111 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.b) == false) goto L182;
        throw ((com.bytedance.android.sdk.bdticketguard.utils.c.b) r111).f164085b;
    L182:
        throw new NoWhenBranchMatchedException();
    L184:
        if ((r167 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.b) == false) goto L188;
        throw ((com.bytedance.android.sdk.bdticketguard.utils.c.b) r167).f164085b;
    L188:
        throw new NoWhenBranchMatchedException();
    L134:
        r167 = r210;
        goto L135
    L141:
        r167 = r210;
        goto L142
    L97:
        r151 = false;
        goto L98
    L109:
        long r176 = r143 - r119;
        ArrayList r177 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));
        Iterator r178 = r130.iterator();
    L111:
        if (r178.hasNext() == false) goto L113;
        Pair r179 = (Pair) r178.next();
        r177.add(TuplesKt.to(r179.getFirst(), ((com.bytedance.android.sdk.bdticketguard.data.b.a) r179.getSecond()).f163597a));
        goto L111
    L113:
        ArrayList r180 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r181 = r124.iterator();
    L115:
        if (r181.hasNext() == false) goto L117;
        r180.add(((o) r181.next()).a());
        goto L115
    L117:
        r162 = new com.bytedance.android.sdk.bdticketguard.data.h.a(r177, r176, r180);
        goto L119
    L88:
        r142 = r133;
    L118:
        r210 = r109;
        r162 = null;
        goto L119
    L63:
        if ((r109 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) == false) goto L65;
        r118 = true;
        goto L66
    L38:
        throw new TypeCastException("null cannot be cast to non-null type java.security.PrivateKey");     // Catch: Throwable -> L39
    L191:
        r110.f163620b = "3_priv_key";     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r182 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L28:
        throw new NullPointerException("certificate is null");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r183 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L190:
        throw new UnsupportedOperationException("TEE not supported for current SDK ver: " + r101);
    L5:
        r110 = null;
        goto L6
    }
}
