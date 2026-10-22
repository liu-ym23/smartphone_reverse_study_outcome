package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.lynx.tasm.TemplateBundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletAppResourceLoader implements w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f34174f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletApplication f34175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.d f34176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, TemplateBundle> f34177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, kotlinx.coroutines.sync.a> f34178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f34179e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        this.f34179e = true;
        this.f34176b.c("onDestroy: clear " + this.f34177c.size() + " cached template bundles");
        this.f34177c.clear();
        this.f34178d.clear();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
        com.bytedance.ai.settings.a<Integer> r100 = com.bytedance.ai.settings.b.f37574a;
        List<String> r101 = com.bytedance.ai.settings.b.f37583j.a().b();
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        if (r101.contains(this.f34175a.getAppId()) == true) goto L8;
        return;
    L8:
        this.f34176b.c("onAttached: appId = " + this.f34175a.getAppId() + " matched preload list");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f34175a), null, null, new AppletAppResourceLoader$onAttached$1(this, null), 3, null);
    }

    public AppletAppResourceLoader(AppletApplication r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        this.f34175a = r100;
        this.f34176b = new com.bytedance.ai.applet.base.log.d("AppletAppResourceLoader", r100.getAppId());
        this.f34177c = new ConcurrentHashMap();
        this.f34178d = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static final Object b(AppletAppResourceLoader r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof AppletAppResourceLoader$preloadHomePageTemplateBundle$1) == false) goto L7;
        AppletAppResourceLoader$preloadHomePageTemplateBundle$1 r102 = (AppletAppResourceLoader$preloadHomePageTemplateBundle$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Page r107 = (Page) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Object r108 = ((Result) r104).m9458unboximpl();
    L25:
        if (Result.m9456isSuccessimpl(r108) == false) goto L27;
        TemplateBundle r109 = (TemplateBundle) r108;
        r100.f34176b.c("preloadHomePageTemplateBundle: success, page = " + r107.pageId());
    L27:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r108);
        if (r110 == null) goto L34;
        com.bytedance.ai.applet.base.log.d r111 = r100.f34176b;
        StringBuilder r112 = new StringBuilder("preloadHomePageTemplateBundle: failed, page = ");
        r112.append(r107.pageId());
        r112.append(", reason = ");
        String r113 = r110.getMessage();
        if (r113 != null) goto L32;
        r113 = "unknown";
    L32:
        r112.append(r113);
        com.bytedance.ai.applet.base.log.d.d(r111, r112.toString());
    L34:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r114 = r100.f34175a.j().O;
        if (StringsKt.isBlank(r114) == false) goto L17;
        r114 = "index";
    L17:
        Page r115 = r100.f34175a.j().q(r114);
        if (r115 != null) goto L20;
        AtomicInteger r116 = com.bytedance.ai.applet.base.log.d.f34519d;
        r100.f34176b.a("preloadHomePageTemplateBundle: home page is null, path = " + r114, null);
        return Unit.INSTANCE;
    L20:
        r100.f34176b.c("preloadHomePageTemplateBundle: start, page = " + r115.pageId());
        r102.L$0 = r115;
        r102.label = 1;
        r108 = r100.e(r115, r102);
        if (r108 == r105) goto L36;
        r107 = r115;
        goto L25
    L36:
        return r105;
    L7:
        r102 = new AppletAppResourceLoader$preloadHomePageTemplateBundle$1(r100, r101);
        goto L8
    }

    public final Object e(Page r110, Continuation<? super Result<TemplateBundle>> r111) {
        if ((r111 instanceof AppletAppResourceLoader$loadPageTemplateBundle$1) == false) goto L7;
        AppletAppResourceLoader$loadPageTemplateBundle$1 r100 = (AppletAppResourceLoader$loadPageTemplateBundle$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L59:
        TemplateBundle r114 = (TemplateBundle) r112;
        if (r114 != null) goto L64;
        String r115 = "templateBundle is null, url = " + r113;
        AtomicInteger r105 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34176b.a("loadPageTemplateBundle: " + r115, null);
        Result.Companion r116 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r115)));
    L64:
        return Result.m9449constructorimpl(r114);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r117 = (String) r100.L$1;
        Page r106 = (Page) r100.L$0;
        ResultKt.throwOnFailure(r112);
        String r118 = r117;
        r110 = r106;
        Object r107 = r112;
    L38:
        AIManager.a r108 = (AIManager.a) r107;
        if ((r108 instanceof AIManager.a.b) == false) goto L41;
        String r109 = AppletResourceTool.l(AppletResourceTool.f37276a, this.f34175a.j(), r110.getEntry());
        if (r109.length() != 0) goto L52;
        r104 = true;
    L52:
        if (r104 == false) goto L55;
        String r119 = "resUrl is null, page = " + r110.pageId();
        AtomicInteger r120 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34176b.a("loadPageTemplateBundle: " + r119, null);
        Result.Companion r121 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r119)));
    L55:
        r100.L$0 = r109;
        r100.L$1 = null;
        r100.label = 2;
        r112 = c(r110, r118, r109, r100);
        if (r112 != r102) goto L58;
        return r102;
    L58:
        r113 = r109;
        goto L59
    L41:
        if ((r108 instanceof AIManager.a.C0710a) == false) goto L48;
        StringBuilder r122 = new StringBuilder("ensureAppletFullReady failed, errorCode = ");
        AIManager.a.C0710a r123 = (AIManager.a.C0710a) r108;
        r122.append(r123.f37226a);
        r122.append(", errorMsg = ");
        String r124 = r123.f37227b;
        if (r124 != null) goto L45;
        r124 = "Applet page resources are not ready";
    L45:
        r122.append(r124);
        String r125 = r122.toString();
        AtomicInteger r126 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34176b.a("loadPageTemplateBundle: " + r125, null);
        Result.Companion r127 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r125)));
    L48:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r112);
        r118 = r110.getPath();
        if (r118 != null) goto L19;
    L26:
        r118 = r110.pageId();
    L28:
        if (this.f34179e == false) goto L31;
        String r128 = "page resource loader is destroyed, page = " + r110.pageId();
        com.bytedance.ai.applet.base.log.d.d(this.f34176b, "loadPageTemplateBundle: " + r128);
        Result.Companion r129 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r128)));
    L31:
        TemplateBundle r130 = this.f34177c.get(r118);
        if (r130 == null) goto L35;
        this.f34176b.c("loadPageTemplateBundle: hit memory cache, page = " + r110.pageId());
        return Result.m9449constructorimpl(r130);
    L35:
        AIManager r131 = AIManager.f37211a;
        String r132 = this.f34175a.j().K;
        long r133 = this.f34175a.j().f36896c;
        r100.L$0 = r110;
        r100.L$1 = r118;
        r100.label = 1;
        r107 = AIManager.h(r132, r133, r100);
        if (r107 != r102) goto L38;
        return r102;
    L19:
        if (r118.length() <= 0) goto L21;
        boolean r134 = true;
    L22:
        if (r134 == true) goto L25;
        r118 = null;
    L25:
        if (r118 != null) goto L28;
    L21:
        r134 = false;
    L7:
        r100 = new AppletAppResourceLoader$loadPageTemplateBundle$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(Page r110, String r111, String r112, Continuation<? super TemplateBundle> r113) {
        if ((r113 instanceof AppletAppResourceLoader$loadAndCachePageTemplateBundle$1) == false) goto L7;
        AppletAppResourceLoader$loadAndCachePageTemplateBundle$1 r100 = (AppletAppResourceLoader$loadAndCachePageTemplateBundle$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AppletAppResourceLoader$loadAndCachePageTemplateBundle$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        boolean r105 = true;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r102.L$1;
        r111 = (String) r102.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L56
    L46:
        TemplateBundle r116 = (TemplateBundle) r114;     // Catch: Throwable -> L56
        if (r116 != null) goto L49;
    L54:
        r115.unlock(null);
        return r116;
    L49:
        if (this.f34179e == true) goto L54;
        TemplateBundle r117 = this.f34177c.putIfAbsent(r111, r116);     // Catch: Throwable -> L56
        if (r117 == null) goto L54;
        r116 = r117;
        goto L54
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r115 = (kotlinx.coroutines.sync.a) r102.L$3;
        r112 = (String) r102.L$2;
        r111 = (String) r102.L$1;
        Page r106 = (Page) r102.L$0;
        ResultKt.throwOnFailure(r114);
        Page r107 = r106;
    L31:
        if (this.f34179e == false) goto L33;
        com.bytedance.ai.applet.base.log.d.d(this.f34176b, "loadPageTemplateBundle: loader is destroyed, page = " + r111);     // Catch: Throwable -> L56
        r116 = null;
        goto L54
    L33:
        r116 = this.f34177c.get(r111);     // Catch: Throwable -> L56
        if (r116 == null) goto L36;
        this.f34176b.c("loadPageTemplateBundle: hit memory cache after waiting, page = " + r111);     // Catch: Throwable -> L56
        goto L54
    L36:
        int r118 = AppletLynxViewApi.f36629a;     // Catch: Throwable -> L56
        String r119 = this.f34175a.j().f36917x;     // Catch: Throwable -> L56
        if (r119 != null) goto L40;
        r119 = "";
    L40:
        if (this.f34175a.j().E == 1) goto L43;
        r105 = false;
    L43:
        String r108 = this.f34175a.j().f36895b;     // Catch: Throwable -> L56
        String r109 = r107.getId();     // Catch: Throwable -> L56
        r102.L$0 = r111;     // Catch: Throwable -> L56
        r102.L$1 = r115;     // Catch: Throwable -> L56
        r102.L$2 = null;     // Catch: Throwable -> L56
        r102.L$3 = null;     // Catch: Throwable -> L56
        r102.label = 2;     // Catch: Throwable -> L56
        r114 = AppletLynxViewApi.b(r119, r112, r105, r108, r109, r102);     // Catch: Throwable -> L56
        if (r114 != r103) goto L46;
        return r103;
    L18:
        ResultKt.throwOnFailure(r114);
        TemplateBundle r120 = this.f34177c.get(r111);
        if (r120 == null) goto L22;
        this.f34176b.c("loadPageTemplateBundle: hit memory cache, page = " + r111);
        return r120;
    L22:
        kotlinx.coroutines.sync.a r121 = kotlinx.coroutines.sync.b.a();
        kotlinx.coroutines.sync.a r122 = this.f34178d.putIfAbsent(r111, r121);
        if (r122 == null) goto L26;
        r121 = r122;
    L26:
        r102.L$0 = r110;
        r102.L$1 = r111;
        r102.L$2 = r112;
        r102.L$3 = r121;
        r102.label = 1;
        if (r121.a(null, r102) != r103) goto L29;
        return r103;
    L29:
        r107 = r110;
        r115 = r121;
    L56:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L7:
        r100 = new AppletAppResourceLoader$loadAndCachePageTemplateBundle$1(this, r113);
        goto L8
    }
}
