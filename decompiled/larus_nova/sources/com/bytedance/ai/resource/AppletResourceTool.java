package com.bytedance.ai.resource;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.LruCache;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletResourceTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletResourceTool f37276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, String> f37277b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f37278c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f37279d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37280e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile r5.c f37281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f37282g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CompletableDeferred<Boolean> f37283h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f37284i;

    public static final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Bitmap>> f37285a;

        public a(AtomicReference<kotlinx.coroutines.i<Bitmap>> r100) {
            this.f37285a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f37285a.set(null);
            return Unit.INSTANCE;
        }
    }

    public AppletResourceTool() {
    }

    static {
        f37276a = new AppletResourceTool();
        f37277b = new LruCache(20);
        f37278c = LazyKt.lazy(new l());
        f37279d = LazyKt.lazy(new t());
        com.bytedance.ai.settings.a<Integer> r100 = com.bytedance.ai.settings.b.f37574a;
        f37280e = com.bytedance.ai.settings.b.f37579f.a().intValue();
        f37282g = new Object();
        f37283h = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r101 = com.bytedance.ai.resource.core.a.f37325a;
        f37284i = com.bytedance.ai.resource.core.a.f37325a;
    }

    public static Keva i() {
        return (Keva) f37278c.getValue();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.ai.utils.g.f37637a.d("AIManager", "closeSession: " + r100);
        IIvyAIPackageResourceService.f278317a.h(r100);
    }

    public static void b(String r100) {
        if (f37281f == null) goto L5;
        return;
    L5:
        Object r101 = f37282g;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (f37281f == null) goto L11;
        monitor-exit(r101);
        return;
    L11:
        f37281f = new r5.c(r100);     // Catch: Throwable -> L22
        r5.d r102 = r5.f.f536131a;     // Catch: Throwable -> L22
        if (r102 != null) goto L14;
    L15:
        r5.d r103 = r5.f.f536131a;     // Catch: Throwable -> L22
        if (r103 == null) goto L18;
        r103.evictAll();     // Catch: Throwable -> L22
    L18:
        r5.f.f536132b.clear();     // Catch: Throwable -> L22
        r5.f.f536131a = new r5.d();     // Catch: Throwable -> L22
    L19:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r101);
        return;
    L14:
        if (r102.maxSize() <= 5242880) goto L19;
        goto L15
    }

    public static String c(String r100) {
        if (StringsKt.startsWith$default(r100, ".", false, 2, null) == false) goto L6;
        r100 = StringsKt.substringAfter$default(r100, ".", null, 2, null);
    L6:
        if (StringsKt.startsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == true) goto L8;
        return r100;
    L8:
        return StringsKt.substringAfter$default(r100, HTTP.URL_DEFAULT, null, 2, null);
    }

    public static String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        LruCache<String, String> r101 = f37277b;
        String r102 = r101.get(r100);
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L18;
        r102 = i().getString(r100, null);
        if (r102 != null) goto L13;
    L16:
        if (r103 == true) goto L18;
        r101.put(r100, r102);
        goto L18
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
    L18:
        return r102;
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static String s(AppletResourceTool r100) {
        r100.getClass();
        return IIvyAIPackageResourceService.f278317a.b(null);
    }

    public static void v(Function0 r100) {
        if (f37283h.isCompleted() == false) goto L6;
        r100.invoke();
        Unit r101 = Unit.INSTANCE;
        return;
    L6:
        if (p2.c.b() == false) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AppletResourceTool$runAfterEnsureInitialized$1(r100, null), 3, null);
        return;
    L8:
        BuildersKt.runBlocking$default(null, new AppletResourceTool$runAfterEnsureInitialized$2(r100, null), 1, null);
    }

    public static IIvyAIPackageResourceService.a w(p5.a r100) {
        String r101 = r100.f527730a;
        long r102 = r100.f527731b;
        String r103 = r100.f527732c;
        String r104 = r100.f527733d;
        p5.b r105 = r100.f527734e;
        if (r105 == null) goto L5;
        IIvyAIPackageResourceService.a.C3878a r106 = new IIvyAIPackageResourceService.a.C3878a(r105.f527736a);
    L7:
        return new IIvyAIPackageResourceService.a(r101, r102, r103, r104, r106);
    L5:
        r106 = null;
        goto L7
    }

    public static IIvyAIPackageResourceService.a t(Uri r100, IIvyAIPackageResourceService.a r110) {
        if (Intrinsics.areEqual(q5.a.a(r100, "local_debug"), "1") == true) goto L5;
        return r110;
    L5:
        IIvyAIPackageResourceService.a.C3878a r101 = r110.f278324e;
        if (r101 == null) goto L47;
        byte[] r102 = r101.f278325a;
        if (r102 == null) goto L47;
        String r103 = q5.a.a(r100, "packageName");
        if (r103 == null) goto L46;
        String r104 = q5.a.a(r100, "packageVersion");
        if (r104 == null) goto L17;
        Long r105 = StringsKt.toLongOrNull(r104);
        if (r105 == null) goto L17;
        long r106 = r105.longValue();
    L18:
        String r107 = r100.buildUpon().clearQuery().build().getLastPathSegment();
        com.bytedance.ai.resource.security.e.f37520a.getClass();
        Intrinsics.checkNotNullParameter(r103, "packageName");
        Intrinsics.checkNotNullParameter(r102, "rawBytes");
        if (com.bytedance.ai.resource.security.e.c(r107) == false) goto L39;
        boolean r108 = false;
        if (r102.length >= 4) goto L24;
    L26:
        if (r108 == false) goto L39;
        com.bytedance.ai.resource.security.h.f37525a.getClass();
        Intrinsics.checkNotNullParameter(r103, "packageName");
        byte[] r109 = com.bytedance.ai.resource.security.h.f37532h.get(r103 + '_' + r106);
        if (r109 == null) goto L30;
        byte[] r111 = Arrays.copyOf(r109, r109.length);
    L31:
        if (r111 == null) goto L38;
        com.bytedance.lynx.service.security.decrypt.a r112 = com.bytedance.lynx.service.security.decrypt.b.b(r102, r111, (byte[]) com.bytedance.ai.resource.security.e.f37521b.invoke(r103));
        if ((r112 instanceof com.bytedance.lynx.service.security.decrypt.a.b) == false) goto L36;
        ByteBuffer r113 = ((com.bytedance.lynx.service.security.decrypt.a.b) r112).f264940c;
        byte[] r114 = new byte[r113.remaining()];
        r113.get(r114);
    L41:
        if (Arrays.equals(r114, r102) == false) goto L44;
        return r110;
    L44:
        return new IIvyAIPackageResourceService.a(r110.f278320a, r110.f278321b, r110.f278322c, r110.f278323d, new IIvyAIPackageResourceService.a.C3878a(r114));
    L36:
        throw new IllegalStateException("decrypt debug template errorCode: " + r112.a() + ", message: " + r112.b());
    L38:
        throw new IllegalStateException("missing debug DEK in memory: " + r103 + ' ' + r106);
    L30:
        r111 = null;
        goto L31
    L24:
        if (com.bytedance.ai.resource.security.a.a(r102) != (-1524879472)) goto L26;
        r108 = true;
    L39:
        r114 = r102;
    L17:
        r106 = 0;
        goto L18
    L46:
        throw new IllegalArgumentException("packageName is required for local debug resource decrypt");
    L47:
        return r110;
    }

    public final String g(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "packageName");
        String r100 = c(r110);
        Uri r101 = UriProtector.parse(c(r110));
        AIManager r102 = AIManager.f37211a;
        d0 r103 = AIManager.m(r111);
        if (r103 != null) goto L6;
        com.bytedance.ai.utils.g.f37637a.e("AppletResourceLoader", "getCommonResourceUrl exception: package: " + r111 + " is NOT Found");
        return r110;
    L6:
        String r104 = r101.getHost();
        boolean r105 = true;
        if (r104 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L45;
        IAISDKDebugService.Companion r112 = IAISDKDebugService.f36186a;
        String r107 = r112.G(r111);
        Applet r108 = r103.g(r111);
        if (r108 == null) goto L17;
        int r109 = r108.E;
    L18:
        if (r108 == null) goto L20;
        int r113 = r108.D;
    L21:
        long r114 = r103.f37489i;
        if (r103.f37482b == false) goto L31;
        if (com.bytedance.ai.utils.f.g(r107) == true) goto L26;
    L28:
        String r115 = "base_" + r103.f37489i;
        n5.a.f517985a.getClass();
        return d(r111, "base", r115, r100, r109, r113, r114, null);
    L26:
        if (r112.getDebugMode() != IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L28;
        return n(r107 + '/' + r100, r109, r113, r114, r111);
    L31:
        if (AIManager.g(r111) == false) goto L43;
        String r116 = h(r111);
        if (r116 != null) goto L35;
    L38:
        if (r105 == false) goto L41;
        return r100;
    L41:
        return o(r116 + '/' + r111 + '/' + r100, r103.f37485e, false);
    L35:
        if (r116.length() == 0) goto L38;
        r105 = false;
        goto L38
    L43:
        return e(this, r111, "base", "base_" + r103.f37489i, r100, r109, r113, r114);
    L20:
        r113 = 0;
        goto L21
    L17:
        r109 = 0;
        goto L18
    L45:
        if (r103.f37482b == false) goto L47;
        n5.a.f517985a.getClass();
    L47:
        return r110;
    L9:
        if (r104.length() == 0) goto L12;
        r106 = false;
        goto L13
    }

    public final String j(Applet r110, String r111) {
        String r100 = c(r111);
        IAISDKDebugService.Companion r112 = IAISDKDebugService.f36186a;
        String r101 = r112.G(r110.f36895b);
        int r102 = r110.E;
        int r103 = r110.D;
        if (r110.A == false) goto L13;
        if (com.bytedance.ai.utils.f.g(r101) == true) goto L7;
    L10:
        String r104 = "base_" + r110.f36896c;
        n5.a.f517985a.getClass();
        return d(r110.f36895b, r110.K, r104, r100, r102, r103, r110.f36896c, null);
    L7:
        if (r112.getDebugMode() != IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L10;
        return n(r101 + '/' + r100, r102, r103, r110.f36896c, r110.f36895b);
    L13:
        return e(this, r110.f36895b, r110.K, "base_" + r110.f36896c, r100, r102, r103, r110.f36896c);
    }

    public static String k(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "baseUrl");
        if (StringsKt.endsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == false) goto L6;
        r101 = r101.substring(0, r101.length() - 1);
    L6:
        return o(r101 + '/' + r100 + "/base/manifest.json", null, r102);
    }

    public static String l(AppletResourceTool r100, Applet r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        return r100.f(r101, r102, true);
    }

    public static String m(AppletResourceTool r110, Widget r111, String r112) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Intrinsics.checkNotNullParameter(r112, "filePath");
        String r100 = c(r112);
        IAISDKDebugService.Companion r113 = IAISDKDebugService.f36186a;
        String r101 = r113.G(r111.f36895b);
        int r102 = r111.E;
        int r103 = r111.D;
        long r104 = r111.f36896c;
        boolean r105 = false;
        boolean r106 = true;
        if (r111.A == true) goto L5;
        AIManager r114 = AIManager.f37211a;
        if (AIManager.g(r111.f36895b) == false) goto L29;
        String r115 = h(r111.f36895b);
        if (r115 != null) goto L21;
    L24:
        if (r106 == true) goto L32;
        r100 = o(r115 + '/' + r111.f36895b + '/' + r100, r111.f36917x, false);
    L32:
        return r100;
    L21:
        if (r115.length() == 0) goto L24;
        r106 = false;
        goto L24
    L29:
        return e(r110, r111.f36895b, r111.K, r111.K + '_' + r111.f36907n, r100, r102, r103, r104);
    L5:
        if (com.bytedance.ai.utils.f.g(r101) == true) goto L7;
    L15:
        String r107 = r111.K + '_' + r111.f36907n;
        n5.a.f517985a.getClass();
        return d(r111.f36895b, r111.K, r107, r100, r102, r103, r104, null);
    L7:
        if (r113.getDebugMode() != IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L15;
        if (h5.e.a(r111.f36901h, "3.0") < 0) goto L11;
        r105 = true;
    L11:
        if (r105 == true) goto L30;
        r100 = "widgets/" + r100;
    L30:
        return n(r101 + '/' + r100, r102, r103, r104, r111.f36895b);
    }

    public static String o(String r100, String r101, boolean r102) {
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
        r103.appendQueryParameter("loader_name", "forest");
        r103.appendQueryParameter("dynamic", "1");
        r103.appendQueryParameter("enable_memory_cache", "0");
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        r103.appendQueryParameter("forest_session_id", r101);
    L11:
        if (r102 == false) goto L14;
        r103.appendQueryParameter("dynamic", "2");
    L14:
        return r103.build().toString();
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static Object r(String r100, String r110, Continuation r111) {
        kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r111), 1);
        r101.C();
        AtomicReference r102 = new AtomicReference(r101);
        r101.i(new a(r102));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r101.getContext()), com.bytedance.ai.infra.thread_pool.b.f36600a, null, new AppletResourceTool$loadImage$2$2(r100, r110, r102, null), 2, null);
        Object r103 = r101.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L5:
        return r103;
    }

    public final String f(Applet r110, String r111, boolean r112) {
        String r100 = c(r111);
        IAISDKDebugService.Companion r101 = IAISDKDebugService.f36186a;
        String r102 = r101.G(r110.f36895b);
        int r103 = r110.E;
        int r113 = r110.D;
        boolean r104 = true;
        if (r110.A == true) goto L5;
        AIManager r105 = AIManager.f37211a;
        if (AIManager.g(r110.f36895b) == false) goto L38;
        String r106 = h(r110.f36895b);
        if (r106 != null) goto L27;
    L30:
        if (r104 == false) goto L33;
        return r100;
    L33:
        if (StringsKt.endsWith$default(r106, HTTP.URL_DEFAULT, false, 2, null) == false) goto L35;
        String r107 = r106 + r110.f36895b + '/' + r100;
    L37:
        return o(r107, r110.f36917x, false);
    L35:
        r107 = r106 + '/' + r110.f36895b + '/' + r100;
        goto L37
    L27:
        if (r106.length() == 0) goto L30;
        r104 = false;
        goto L30
    L38:
        if (r112 == false) goto L40;
        String r108 = r110.K + '_' + r110.f36907n;
    L42:
        return e(this, r110.f36895b, r110.K, r108, r100, r103, r113, r110.f36896c);
    L40:
        r108 = r110.K;
        goto L42
    L5:
        if (com.bytedance.ai.utils.f.g(r102) == true) goto L7;
    L17:
        if (r112 == false) goto L19;
        String r109 = r110.K + '_' + r110.f36907n;
    L20:
        String r114 = r109;
        n5.a.f517985a.getClass();
        return d(r110.f36895b, r110.K, r114, r100, r103, r113, r110.f36896c, null);
    L19:
        r109 = r110.K;
        goto L20
    L7:
        if (r101.getDebugMode() != IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L17;
        if (h5.e.a(r110.f36901h, "3.0") >= 0) goto L12;
        r104 = false;
    L12:
        if (r104 == true) goto L16;
        r100 = StringsKt.replaceFirst$default(r100, r110.K, "applet", false, 4, null);
    L16:
        return n(r102 + '/' + r100, r103, r113, r110.f36896c, r110.f36895b);
    }

    public static void u(Uri r100, IIvyAIPackageResourceService.a r101, Function1 r102, Function1 r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L4
        Object r105 = Result.m9449constructorimpl(t(r100, r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9456isSuccessimpl(r105) == false) goto L9;
        r102.invoke((IIvyAIPackageResourceService.a) r105);
    L9:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L15;
        com.bytedance.ai.utils.g.f37637a.e("AppletResourceLoader", "process debug resource failed. url:" + r100 + ", error:" + r106.getMessage());
        r103.invoke(r106);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String n(String r100, int r101, int r102, long r103, String r104) {
        return UriProtector.parse(r100).buildUpon().appendQueryParameter("loader_name", "forest").appendQueryParameter("disable_gecko", "1").appendQueryParameter("disable_builtin", "1").appendQueryParameter("disable_gecko_update", "1").appendQueryParameter("disable_offline", "1").appendQueryParameter("disable_cdn_cache", "1").appendQueryParameter("enable_memory_cache", "0").appendQueryParameter("local_debug", "1").appendQueryParameter("verifySignature", String.valueOf(r101)).appendQueryParameter("hasKeyStore", String.valueOf(r102)).appendQueryParameter("packageVersion", String.valueOf(r103)).appendQueryParameter("packageName", r104).build().toString();
    }

    public static void p(final String r100, final String r101, final boolean r102, final Function1 r110, final Function1 r111) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r110, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r111, "reject");
        v(new y(r100, r101, r102, r111, r110));
    }

    public static void q(final String r100, final String r101, final Function1 r102, final Function1 r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r110, "reject");
        v(new v(r100, r101, r111, r102, r110));
    }

    public static String d(String r100, String r101, String r102, String r103, int r104, int r105, long r106, String r110) {
        Uri.Builder r107 = UriProtector.parse("https://app.aisdk.local/" + r100 + '/' + r102 + '/' + r103).buildUpon().appendQueryParameter("packageName", r100);
        h2.a r108 = f2.b.f475099c;
        if (r108 == null) goto L6;
        String r109 = r108.f483574m;
        if (r109 == null) goto L6;
    L7:
        Uri.Builder r111 = r107.appendQueryParameter("bid", r109).appendQueryParameter("storeDir", r101).appendQueryParameter("intercept_request", "1").appendQueryParameter("verifySignature", String.valueOf(r104)).appendQueryParameter("hasKeyStore", String.valueOf(r105)).appendQueryParameter("packageVersion", String.valueOf(r106));
        if (r110 == null) goto L11;
        r111.appendQueryParameter("debugInfo", r110);
    L11:
        return r111.build().toString();
    L6:
        r109 = "";
        goto L7
    }

    public static /* synthetic */ String e(AppletResourceTool r100, String r110, String r111, String r112, String r113, int r114, int r115, long r116) {
        r100.getClass();
        return d(r110, r111, r112, r113, r114, r115, r116, null);
    }
}
