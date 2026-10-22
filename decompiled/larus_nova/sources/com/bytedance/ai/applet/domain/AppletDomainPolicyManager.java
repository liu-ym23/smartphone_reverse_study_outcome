package com.bytedance.ai.applet.domain;

import android.net.Uri;
import android.util.Base64;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.FetchDomainPolicyResponse;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.AppletSettings;
import com.bytedance.ai.utils.g;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletDomainPolicyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletDomainPolicyManager f34590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f34591b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f34592c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f34593d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f34594e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f34595f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Deferred<Result<a>>> f34596g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f34597h = null;

    public AppletDomainPolicyManager() {
    }

    static {
        f34590a = new AppletDomainPolicyManager();
        f34591b = SetsKt.setOf("https");
        f34592c = SetsKt.setOf("wss");
        f34593d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f34594e = new ConcurrentHashMap();
        f34595f = new ConcurrentHashMap();
        f34596g = new ConcurrentHashMap();
        f34597h = LazyKt.lazy(new b());
    }

    public static f i(String r100) {
        if (r100 != null) goto L5;
    L21:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L21;
        if (j(r100) == true) goto L13;
        a r101 = f34594e.get(r100);
        if (r101 != null) goto L20;
        r101 = f34595f.get(r100);
        if (r101 != null) goto L20;
        return null;
    L20:
        return new f(r101.f34600c, r101.f34605h);
    L13:
        return new f(false, SetsKt.emptySet());
    }

    public static boolean j(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r101 = AppletAppManagerService.b(r100);
        if (r101 == null) goto L5;
        Applet r102 = r101.j();
    L7:
        if (r102 != null) goto L10;
        g.f37637a.w("AppletDomainPolicyManager", "isDomainVerifyDisabled manifest miss, appKey:" + r100 + ", fallback verify enabled");
        return false;
    L10:
        AppletSettings r103 = r102.f36924k0;
        if (r103 == null) goto L15;
        Boolean r104 = r103.getUrlCheck();
        if (r104 == null) goto L15;
        boolean r105 = r104.booleanValue();
    L16:
        boolean r106 = !r105;
        g.f37637a.i("AppletDomainPolicyManager", "isDomainVerifyDisabled appKey:" + r100 + ", urlCheck:" + r105 + ", disabled:" + r106);
        return r106;
    L15:
        r105 = true;
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public static a k(String r110) {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L26
        String r102 = ((Keva) f34597h.getValue()).getString("domain_policy_" + r110, null);     // Catch: Throwable -> L26
        if (r102 != null) goto L7;
        g.f37637a.d("AppletDomainPolicyManager", "cache empty, appKey:" + r110);     // Catch: Throwable -> L26
        return null;
    L7:
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Throwable -> L26
        d r104 = (d) com.bytedance.ai.applet.base.gson.e.a(r102, d.class);     // Catch: Throwable -> L26
        long r105 = r104.f34610e;     // Catch: Throwable -> L26
        if (r105 > 0) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L25;
        a r107 = p(r110, r104.f34606a, r104.f34607b);     // Catch: Throwable -> L26
        if (r104.f34608c != r107.f34599b) goto L23;
        if (r104.f34609d != r107.f34600c) goto L21;
        g.f37637a.d("AppletDomainPolicyManager", "cache load, appKey:" + r110 + ", v:" + r107.f34599b + ", switch:" + r107.f34600c + ", age:" + (System.currentTimeMillis() - r104.f34610e));     // Catch: Throwable -> L26
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L26
    L28:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L40;
        f34590a.getClass();
        ((Keva) f34597h.getValue()).erase("domain_policy_" + r110);     // Catch: Throwable -> L33
        g.f37637a.d("AppletDomainPolicyManager", "cache remove, appKey:" + r110);     // Catch: Throwable -> L33
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L38;
        g.f37637a.e("AppletDomainPolicyManager", "remove cached policy failed: " + r112.getMessage());
    L38:
        g.f37637a.e("AppletDomainPolicyManager", "load cached policy failed: " + r109.getMessage());
    L33:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        if (Result.m9455isFailureimpl(r108) == true) goto L44;
        r100 = r108;
    L44:
        return (a) r100;
    L21:
        throw new IllegalStateException("cached domain_verify_switch mismatch");     // Catch: Throwable -> L26
    L23:
        throw new IllegalStateException("cached snapshot_version mismatch");     // Catch: Throwable -> L26
    L25:
        throw new IllegalStateException("cached policy expired");     // Catch: Throwable -> L26
    L10:
        if ((System.currentTimeMillis() - r105) > 604800000) goto L13;
        r106 = false;
    L26:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    public final void n(String r110) {
        Intrinsics.checkNotNullParameter("app_onAttached", "source");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        if (r110 != null) goto L6;
    L16:
        g.f37637a.e("AppletDomainPolicyManager", "prefetch skip: appKey empty, source:app_onAttached");     // Catch: Throwable -> L19
    L17:
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L27;
        g.f37637a.e("AppletDomainPolicyManager", "prefetch trigger failed, appKey:" + r110 + ", source:app_onAttached, error:" + r102.getMessage());
        return;
    L27:
        return;
    L6:
        if ((!StringsKt.isBlank(r110)) == false) goto L8;
        String r103 = r110;
    L9:
        if (r103 == null) goto L16;
        if (f34594e.containsKey(r103) == false) goto L15;
        g.f37637a.d("AppletDomainPolicyManager", "prefetch skip: already success, appKey:" + r103 + ", source:app_onAttached");     // Catch: Throwable -> L19
        goto L17
    L15:
        g.f37637a.d("AppletDomainPolicyManager", "prefetch start, appKey:" + r103 + ", source:app_onAttached");     // Catch: Throwable -> L19
        BuildersKt.launch$default(f34593d, null, null, new AppletDomainPolicyManager$prefetch$1$1(this, r103, "app_onAttached", null), 3, null);     // Catch: Throwable -> L19
        goto L17
    L8:
        r103 = null;
    L19:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static String l(String r100, Set r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        Uri r104 = (Uri) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        String r105 = r104.getScheme();
        if (r105 == null) goto L31;
        Locale r106 = Locale.ROOT;
        String r107 = r105.toLowerCase(r106);
        if (r107 == null) goto L31;
        if (r101.contains(r107) == true) goto L20;
        return null;
    L20:
        String r108 = r104.getHost();
        if (r108 == null) goto L31;
        String r109 = r108.toLowerCase(r106);
        if (r109 == null) goto L31;
        int r110 = r104.getPort();
        if (r110 <= 0) goto L28;
        String r111 = ":" + r110;
    L30:
        return r107 + "://" + r109 + r111;
    L28:
        r111 = "";
    L31:
        return null;
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Set m(String r100, Set r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        List r103 = StringsKt.split$default(r100, new char[]{','}, false, 0, 6, null);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r104.add(StringsKt.trim((String) r105.next()).toString());
        goto L14
    L16:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r104.iterator();
    L18:
        if (r107.hasNext() == false) goto L25;
        Object r108 = r107.next();
        if (((String) r108).length() <= 0) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L18;
        r106.add(r108);
        goto L18
    L22:
        r109 = false;
        goto L23
    L25:
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r111 = r106.iterator();
    L27:
        if (r111.hasNext() == false) goto L34;
        String r112 = (String) r111.next();
        f34590a.getClass();
        String r113 = l(r112, r101);
        if (r113 == null) goto L32;
        r110.add(r113);
        goto L27
    L32:
        throw new IllegalStateException("invalid allowlist domain");
    L34:
        return CollectionsKt.toSet(r110);
    L11:
        return SetsKt.emptySet();
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static a p(String r110, String r111, String r112) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        PublicKey r101 = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2rcHwDRl8JBb1XqLfddO1GdNMi+QebVdVH2D/FrlIOQPwamL2Sf6hchOTdXFZoWjE+aIfhCHbY//APXG0xXC7f7MH07HdWRtZ5aiKFyQotjZ6lDfZbIeHOxuxaMkbBxTdp2jF34a0LZLqdA3HHsw5eW+B/KgQk+ozqDVK5FLXrUzt7eOdrbhncnkrCDcaLBFxkWrXCS+fuLPk3IitCCNQQGqwueBb2zRl/dXg2tb6wJT9EobUEbaLvSZ3sasa1FpFK30IrfMARUlGrnS3MUQmUcWeqj445KQYlofh4GyVTltlnsDxaiNiANImUfBIf4fldvxNCOJnKCo1Z7wNYEvQQIDAQAB", 0)));     // Catch: Throwable -> L5
        Signature r102 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);     // Catch: Throwable -> L5
        r102.initVerify(r101);     // Catch: Throwable -> L5
        r102.update(r111.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L5
        Object r113 = Result.m9449constructorimpl(Boolean.valueOf(r102.verify(Base64.decode(r112, 0))));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r113);
        if (r103 == null) goto L12;
        g.f37637a.e("AppletDomainPolicyManager", "verify signature failed: " + r103.getMessage());
        r113 = Boolean.FALSE;
    L12:
        if (((Boolean) r113).booleanValue() == false) goto L55;
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator r115 = StringsKt.lineSequence(r111).iterator();
    L14:
        boolean r104 = true;
        if (r115.hasNext() == false) goto L27;
        String r105 = (String) r115.next();
        if (r105.length() == 0) goto L20;
        r104 = false;
    L20:
        if (r104 == true) goto L14;
        int r106 = StringsKt.indexOf$default(r105, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);
        if (r106 < 0) goto L25;
        r114.put(r105.substring(0, r106), r105.substring(r106 + 1));
        goto L14
    L25:
        throw new IllegalStateException("invalid payload line");
    L27:
        if (Intrinsics.areEqual(r114.get(BaseSwitches.V), "1") == false) goto L53;
        if (Intrinsics.areEqual((String) r114.get("mini_program_id"), r110) == false) goto L51;
        String r116 = (String) r114.get("snapshot_version");
        if (r116 == null) goto L49;
        Long r117 = StringsKt.toLongOrNull(r116);
        if (r117 == null) goto L49;
        long r107 = r117.longValue();
        String r118 = (String) r114.get("domain_verify_switch");
        if (r118 == null) goto L37;
        String r119 = r118.toLowerCase(Locale.ROOT);
    L39:
        if (Intrinsics.areEqual(r119, "true") == false) goto L42;
        boolean r108 = true;
    L44:
        String r109 = (String) r114.get("request");
        Set<String> r120 = f34591b;
        return new a(r110, r107, r108, m(r109, r120), m((String) r114.get("download"), r120), m((String) r114.get("upload"), r120), m((String) r114.get("socket"), f34592c), m((String) r114.get("webview"), r120));
    L42:
        if (Intrinsics.areEqual(r119, "false") == false) goto L47;
        r108 = false;
        goto L44
    L47:
        throw new IllegalStateException("invalid domain_verify_switch");
    L37:
        r119 = null;
    L49:
        throw new IllegalStateException("invalid snapshot_version");
    L51:
        throw new IllegalStateException("mini_program_id mismatch");
    L53:
        throw new IllegalStateException("unsupported payload version");
    L55:
        throw new IllegalStateException("signature verify failed");
    L5:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object c(String r110, String r111, Continuation<? super e> r112) {
        if ((r112 instanceof AppletDomainPolicyManager$ensureDownloadAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureDownloadAllowed$1 r100 = (AppletDomainPolicyManager$ensureDownloadAllowed$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r114 = (String) r100.L$2;
        String r115 = (String) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Object r116 = ((Result) r113).m9458unboximpl();
        String r105 = r114;
        String r106 = r104;
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L38;
        a r107 = (a) r116;
        return b(r107, r107.f34602e, r105, r106, "download_blocked", "download domain is not in whitelist");
    L38:
        g.f37637a.e("AppletDomainPolicyManager", "download blocked: policy unavailable, appKey:" + r115 + ", origin:" + r105 + ", error:" + r117.getMessage());
        int r118 = e.f34611c;
        return e.a.b("domain policy unavailable: " + r117.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 != null) goto L17;
    L40:
        g.f37637a.e("AppletDomainPolicyManager", "download blocked: appKey empty, url:" + r111);
        int r119 = e.f34611c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r110)) == true) goto L20;
        r110 = null;
    L20:
        if (r110 == null) goto L40;
        if (j(r110) == false) goto L26;
        g.f37637a.d("AppletDomainPolicyManager", "download allowed: dev bypass, appKey:" + r110 + ", url:" + r111);
        int r120 = e.f34611c;
        return e.a.a();
    L26:
        String r121 = l(r111, f34591b);
        if (r121 != null) goto L30;
        g.f37637a.e("AppletDomainPolicyManager", "download blocked: invalid url, appKey:" + r110 + ", url:" + r111);
        int r122 = e.f34611c;
        return e.a.b("invalid download url");
    L30:
        r100.L$0 = r111;
        r100.L$1 = r110;
        r100.L$2 = r121;
        r100.label = 1;
        Object r108 = h(r110, "download", r100);
        if (r108 != r102) goto L33;
        return r102;
    L33:
        r106 = r111;
        r105 = r121;
        r116 = r108;
        r115 = r110;
    L7:
        r100 = new AppletDomainPolicyManager$ensureDownloadAllowed$1(this, r112);
        goto L8
    }

    public final Object d(String r110, String r111, Continuation<? super e> r112) {
        if ((r112 instanceof AppletDomainPolicyManager$ensureRequestAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureRequestAllowed$1 r100 = (AppletDomainPolicyManager$ensureRequestAllowed$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r114 = (String) r100.L$2;
        String r115 = (String) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Object r116 = ((Result) r113).m9458unboximpl();
        String r105 = r114;
        String r106 = r104;
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L41;
        a r107 = (a) r116;
        if (r107.f34600c == true) goto L40;
        g.f37637a.d("AppletDomainPolicyManager", "request allowed: switch off, appKey:" + r107.f34598a + ", origin:" + r105 + ", v:" + r107.f34599b);
        int r118 = e.f34611c;
        return e.a.a();
    L40:
        return b(r107, r107.f34601d, r105, r106, "request_blocked", "request domain is not in whitelist");
    L41:
        g.f37637a.e("AppletDomainPolicyManager", "request blocked: policy unavailable, appKey:" + r115 + ", origin:" + r105 + ", error:" + r117.getMessage());
        int r119 = e.f34611c;
        return e.a.b("domain policy unavailable: " + r117.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 != null) goto L17;
    L43:
        g.f37637a.e("AppletDomainPolicyManager", "request blocked: appKey empty, url:" + r111);
        int r120 = e.f34611c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r110)) == true) goto L20;
        r110 = null;
    L20:
        if (r110 == null) goto L43;
        if (j(r110) == false) goto L26;
        g.f37637a.d("AppletDomainPolicyManager", "request allowed: dev bypass, appKey:" + r110 + ", url:" + r111);
        int r121 = e.f34611c;
        return e.a.a();
    L26:
        String r122 = l(r111, f34591b);
        if (r122 != null) goto L30;
        g.f37637a.e("AppletDomainPolicyManager", "request blocked: invalid url, appKey:" + r110 + ", url:" + r111);
        int r123 = e.f34611c;
        return e.a.b("invalid request url");
    L30:
        r100.L$0 = r111;
        r100.L$1 = r110;
        r100.L$2 = r122;
        r100.label = 1;
        Object r108 = h(r110, "request", r100);
        if (r108 != r102) goto L33;
        return r102;
    L33:
        r106 = r111;
        r105 = r122;
        r116 = r108;
        r115 = r110;
    L7:
        r100 = new AppletDomainPolicyManager$ensureRequestAllowed$1(this, r112);
        goto L8
    }

    public final Object e(String r110, String r111, Continuation<? super e> r112) {
        if ((r112 instanceof AppletDomainPolicyManager$ensureSocketAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureSocketAllowed$1 r100 = (AppletDomainPolicyManager$ensureSocketAllowed$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r114 = (String) r100.L$2;
        String r115 = (String) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Object r116 = ((Result) r113).m9458unboximpl();
        String r105 = r114;
        String r106 = r104;
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L38;
        a r107 = (a) r116;
        return b(r107, r107.f34604g, r105, r106, "socket_blocked", "socket domain is not in whitelist");
    L38:
        g.f37637a.e("AppletDomainPolicyManager", "socket blocked: policy unavailable, appKey:" + r115 + ", origin:" + r105 + ", error:" + r117.getMessage());
        int r118 = e.f34611c;
        return e.a.b("domain policy unavailable: " + r117.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 != null) goto L17;
    L40:
        g.f37637a.e("AppletDomainPolicyManager", "socket blocked: appKey empty, url:" + r111);
        int r119 = e.f34611c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r110)) == true) goto L20;
        r110 = null;
    L20:
        if (r110 == null) goto L40;
        if (j(r110) == false) goto L26;
        g.f37637a.d("AppletDomainPolicyManager", "socket allowed: dev bypass, appKey:" + r110 + ", url:" + r111);
        int r120 = e.f34611c;
        return e.a.a();
    L26:
        String r121 = l(r111, f34592c);
        if (r121 != null) goto L30;
        g.f37637a.e("AppletDomainPolicyManager", "socket blocked: invalid url, appKey:" + r110 + ", url:" + r111);
        int r122 = e.f34611c;
        return e.a.b("invalid socket url");
    L30:
        r100.L$0 = r111;
        r100.L$1 = r110;
        r100.L$2 = r121;
        r100.label = 1;
        Object r108 = h(r110, "socket", r100);
        if (r108 != r102) goto L33;
        return r102;
    L33:
        r106 = r111;
        r105 = r121;
        r116 = r108;
        r115 = r110;
    L7:
        r100 = new AppletDomainPolicyManager$ensureSocketAllowed$1(this, r112);
        goto L8
    }

    public final Object f(String r110, String r111, Continuation<? super e> r112) {
        if ((r112 instanceof AppletDomainPolicyManager$ensureUploadAllowed$1) == false) goto L7;
        AppletDomainPolicyManager$ensureUploadAllowed$1 r100 = (AppletDomainPolicyManager$ensureUploadAllowed$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r114 = (String) r100.L$2;
        String r115 = (String) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Object r116 = ((Result) r113).m9458unboximpl();
        String r105 = r114;
        String r106 = r104;
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L38;
        a r107 = (a) r116;
        return b(r107, r107.f34603f, r105, r106, "upload_blocked", "upload domain is not in whitelist");
    L38:
        g.f37637a.e("AppletDomainPolicyManager", "upload blocked: policy unavailable, appKey:" + r115 + ", origin:" + r105 + ", error:" + r117.getMessage());
        int r118 = e.f34611c;
        return e.a.b("domain policy unavailable: " + r117.getMessage());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 != null) goto L17;
    L40:
        g.f37637a.e("AppletDomainPolicyManager", "upload blocked: appKey empty, url:" + r111);
        int r119 = e.f34611c;
        return e.a.b("appletId is empty");
    L17:
        if ((!StringsKt.isBlank(r110)) == true) goto L20;
        r110 = null;
    L20:
        if (r110 == null) goto L40;
        if (j(r110) == false) goto L26;
        g.f37637a.d("AppletDomainPolicyManager", "upload allowed: dev bypass, appKey:" + r110 + ", url:" + r111);
        int r120 = e.f34611c;
        return e.a.a();
    L26:
        String r121 = l(r111, f34591b);
        if (r121 != null) goto L30;
        g.f37637a.e("AppletDomainPolicyManager", "upload blocked: invalid url, appKey:" + r110 + ", url:" + r111);
        int r122 = e.f34611c;
        return e.a.b("invalid upload url");
    L30:
        r100.L$0 = r111;
        r100.L$1 = r110;
        r100.L$2 = r121;
        r100.label = 1;
        Object r108 = h(r110, "upload", r100);
        if (r108 != r102) goto L33;
        return r102;
    L33:
        r106 = r111;
        r105 = r121;
        r116 = r108;
        r115 = r110;
    L7:
        r100 = new AppletDomainPolicyManager$ensureUploadAllowed$1(this, r112);
        goto L8
    }

    public final Object g(String r110, String r111, Continuation<? super Result<a>> r112) {
        if ((r112 instanceof AppletDomainPolicyManager$fetchPolicyOnce$1) == false) goto L7;
        AppletDomainPolicyManager$fetchPolicyOnce$1 r100 = (AppletDomainPolicyManager$fetchPolicyOnce$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        Deferred<Result<a>> r114 = (Deferred) r100.L$2;
        Deferred<Result<a>> r115 = (Deferred) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14
        Deferred<Result<a>> r116 = r114;
        r110 = r104;
        Object r105 = r113;
    L41:
        Object r106 = ((Result) r105).m9458unboximpl();     // Catch: Throwable -> L34
        if (r115 != null) goto L33;
        f34596g.remove(r110, r116);
    L33:
        return r106;
    L34:
        Throwable th10 = th;
    L38:
        if (r115 != null) goto L40;
        f34596g.remove(r110, r116);
    L40:
        throw th10;
    L14:
        th = move-exception;
        r116 = r114;
        r110 = r104;
        th10 = th;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r113);
        a r117 = f34594e.get(r110);
        if (r117 == null) goto L22;
        g.f37637a.d("AppletDomainPolicyManager", "fetch skip: memory policy exists, appKey:" + r110 + ", source:" + r111 + ", v:" + r117.f34599b);
        return Result.m9449constructorimpl(r117);
    L22:
        r116 = BuildersKt.async$default(f34593d, null, CoroutineStart.LAZY, new AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1(r110, r111, null), 1, null);
        Deferred<Result<a>> r107 = f34596g.putIfAbsent(r110, r116);
        if (r107 == null) goto L25;
        g.f37637a.d("AppletDomainPolicyManager", "fetch reuse in-flight, appKey:" + r110 + ", source:" + r111);
        r116 = r107;
    L43:
        r100.L$0 = r110;     // Catch: Throwable -> L36
        r100.L$1 = r107;     // Catch: Throwable -> L36
        r100.L$2 = r116;     // Catch: Throwable -> L36
        r100.label = 1;     // Catch: Throwable -> L36
        Object r118 = r116.await(r100);     // Catch: Throwable -> L36
        if (r118 != r102) goto L29;
        return r102;
    L29:
        r105 = r118;
        r115 = r107;
    L36:
        th = move-exception;
        th10 = th;
        r115 = r107;
        goto L38
    L25:
        g.f37637a.d("AppletDomainPolicyManager", "fetch start new, appKey:" + r110 + ", source:" + r111);
        r116.start();
    L7:
        r100 = new AppletDomainPolicyManager$fetchPolicyOnce$1(this, r112);
        goto L8
    }

    public final Object h(String r100, String r101, Continuation<? super Result<a>> r110) {
        if ((r110 instanceof AppletDomainPolicyManager$getPolicyForUse$1) == false) goto L7;
        AppletDomainPolicyManager$getPolicyForUse$1 r102 = (AppletDomainPolicyManager$getPolicyForUse$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r101 = (String) r102.L$1;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
        Object r112 = ((Result) r111).m9458unboximpl();
    L22:
        if (Result.m9456isSuccessimpl(r112) == true) goto L24;
        g r113 = g.f37637a;
        r113.e("AppletDomainPolicyManager", "policy fetch failed, try cache, appKey:" + r100 + ", source:" + r101);
        a r106 = k(r100);
        if (r106 != null) goto L29;
        r113.e("AppletDomainPolicyManager", "policy unavailable: cache empty or invalid, appKey:" + r100 + ", source:" + r101);
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("fetch failed and cache is empty")));
    L29:
        f34595f.put(r100, r106);
        r113.d("AppletDomainPolicyManager", "policy use cache, appKey:" + r100 + ", source:" + r101 + ", v:" + r106.f34599b + ", switch:" + r106.f34600c);
        return Result.m9449constructorimpl(r106);
    L24:
        return Result.m9449constructorimpl((a) r112);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        a r114 = f34594e.get(r100);
        if (r114 == null) goto L18;
        g.f37637a.d("AppletDomainPolicyManager", "policy hit memory, appKey:" + r100 + ", source:" + r101 + ", v:" + r114.f34599b);
        return Result.m9449constructorimpl(r114);
    L18:
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 1;
        r112 = g(r100, r101, r102);
        if (r112 != r104) goto L22;
        return r104;
    L7:
        r102 = new AppletDomainPolicyManager$getPolicyForUse$1(this, r110);
        goto L8
    }

    public static final Object a(AppletDomainPolicyManager r210, String r211, String r212, Continuation r213) {
        r210.getClass();
        if ((r213 instanceof AppletDomainPolicyManager$fetchPolicyFromServer$1) == false) goto L7;
        AppletDomainPolicyManager$fetchPolicyFromServer$1 r100 = (AppletDomainPolicyManager$fetchPolicyFromServer$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r110 = r100.label;
        if (r110 == 0) goto L14;
        if (r110 != 1) goto L13;
        String r104 = (String) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = ((Result) r102).m9458unboximpl();
        String r107 = r104;
        Object r108 = r106;
    L18:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 != null) goto L65;
        FetchDomainPolicyResponse.Data r111 = (FetchDomainPolicyResponse.Data) r108;
        String r112 = r111.getSignedPayload();     // Catch: Throwable -> L54
        if (r112 == null) goto L59;
        if (r112.length() <= 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == true) goto L30;
        r112 = null;
    L30:
        if (r112 == null) goto L59;
        String r114 = r111.getSignature();     // Catch: Throwable -> L54
        if (r114 == null) goto L57;
        if (r114.length() <= 0) goto L36;
        boolean r115 = true;
    L37:
        if (r115 == true) goto L40;
        r114 = null;
    L40:
        if (r114 == null) goto L57;
        a r116 = p(r105, r112, r114);     // Catch: Throwable -> L54
        g r117 = g.f37637a;     // Catch: Throwable -> L54
        r117.d("AppletDomainPolicyManager", "fetch remote verified, appKey:" + r105 + ", v:" + r116.f34599b + ", switch:" + r116.f34600c + ", request:" + r116.f34601d.size() + ", socket:" + r116.f34604g.size());     // Catch: Throwable -> L54
        a r118 = k(r105);     // Catch: Throwable -> L54
        if (r118 != null) goto L44;
    L52:
        f34594e.put(r105, r116);     // Catch: Throwable -> L54
        f34595f.put(r105, r116);     // Catch: Throwable -> L54
        o(r105, r112, r114, r116.f34599b, r116.f34600c);     // Catch: Throwable -> L54
        r117.d("AppletDomainPolicyManager", "fetch use remote, appKey:" + r105 + ", source:" + r107 + ", v:" + r116.f34599b + ", switch:" + r116.f34600c);     // Catch: Throwable -> L54
    L53:
        Object r119 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L54
    L61:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L68;
        g.f37637a.e("AppletDomainPolicyManager", "fetch policy invalid, appKey:" + r105 + ", source:" + r107 + ", error:" + r120.getMessage());
    L68:
        return r119;
    L44:
        if (r118.f34599b <= r116.f34599b) goto L46;
        boolean r121 = true;
    L47:
        if (r121 == false) goto L49;
        a r122 = r118;
    L50:
        if (r122 == null) goto L52;
        f34594e.put(r105, r122);     // Catch: Throwable -> L54
        f34595f.put(r105, r122);     // Catch: Throwable -> L54
        r117.d("AppletDomainPolicyManager", "fetch use newer cache, appKey:" + r105 + ", cacheV:" + r122.f34599b + ", remoteV:" + r116.f34599b);     // Catch: Throwable -> L54
        r116 = r122;
        goto L53
    L49:
        r122 = null;
        goto L50
    L46:
        r121 = false;
        goto L47
    L36:
        r115 = false;
    L57:
        throw new IllegalStateException("signature is empty");     // Catch: Throwable -> L54
    L26:
        r113 = false;
    L59:
        throw new IllegalStateException("signed_payload is empty");     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L61
    L65:
        g.f37637a.e("AppletDomainPolicyManager", "fetch remote failed, appKey:" + r105 + ", source:" + r107 + ", error:" + r109.getMessage());
        return Result.m9449constructorimpl(ResultKt.createFailure(r109));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        g.f37637a.d("AppletDomainPolicyManager", "fetch remote start, appKey:" + r211 + ", source:" + r212);
        UserAuthService r124 = UserAuthService.f36075a;
        r100.L$0 = r211;
        r100.L$1 = r212;
        r100.label = 1;
        Object r125 = r124.g(r211, r100);
        if (r125 == r103) goto L69;
        r105 = r211;
        r108 = r125;
        r107 = r212;
        goto L18
    L69:
        return r103;
    L7:
        r100 = new AppletDomainPolicyManager$fetchPolicyFromServer$1(r210, r213);
        goto L8
    }

    public static void o(String r110, String r111, String r112, long r113, boolean r114) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Keva r101 = (Keva) f34597h.getValue();     // Catch: Throwable -> L5
        String r102 = "domain_policy_".concat(r110);     // Catch: Throwable -> L5
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Throwable -> L5
        r101.storeString(r102, com.bytedance.ai.applet.base.gson.e.c(new d(r111, r112, r113, r114, System.currentTimeMillis())));     // Catch: Throwable -> L5
        g.f37637a.d("AppletDomainPolicyManager", "cache save, appKey:" + r110 + ", v:" + r113 + ", switch:" + r114);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        g.f37637a.e("AppletDomainPolicyManager", "save policy failed: " + r105.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static e b(a r100, Set r101, String r102, String r103, String r104, String r105) {
        String r106 = StringsKt.removeSuffix(r104, "_blocked");
        if (r100.f34600c == true) goto L7;
        g.f37637a.d("AppletDomainPolicyManager", r106 + " allowed: switch off, appKey:" + r100.f34598a + ", origin:" + r102 + ", v:" + r100.f34599b);
        int r107 = e.f34611c;
        return e.a.a();
    L7:
        if (r101.contains(r102) == false) goto L10;
        g.f37637a.d("AppletDomainPolicyManager", r106 + " allowed: whitelist hit, appKey:" + r100.f34598a + ", origin:" + r102 + ", v:" + r100.f34599b);
        int r108 = e.f34611c;
        return e.a.a();
    L10:
        g.f37637a.e("AppletDomainPolicyManager", r106 + " blocked: not in whitelist, appKey:" + r100.f34598a + ", origin:" + r102 + ", v:" + r100.f34599b + ", url:" + r103);
        int r109 = e.f34611c;
        return e.a.b(r105);
    }
}
