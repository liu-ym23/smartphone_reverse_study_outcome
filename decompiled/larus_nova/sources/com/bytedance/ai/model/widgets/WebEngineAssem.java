package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.assem.arch.extensions.VMExtKt;
import com.bytedance.assem.arch.view.UIContentAssem;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.plugin.impl.web.PluginWebView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import m5.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010,\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u001f\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020.2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0016J\b\u00109\u001a\u00020.H\u0002J\b\u0010:\u001a\u00020.H\u0002J&\u0010;\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u00010&2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=H\u0002J2\u0010>\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=2\b\u00102\u001a\u0004\u0018\u00010&2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=H\u0002J&\u0010?\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010&2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=H\u0002J\u000e\u0010@\u001a\u00020\u001c*\u0004\u0018\u00010&H\u0002J\b\u0010A\u001a\u00020.H\u0016J\u0012\u0010B\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010&H\u0002J\n\u00102\u001a\u0004\u0018\u00010&H\u0016J\n\u0010C\u001a\u0004\u0018\u000100H\u0016J\n\u0010D\u001a\u0004\u0018\u000100H\u0016J\b\u0010E\u001a\u00020.H\u0016J\u0012\u0010J\u001a\u00020.2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\b\u0010K\u001a\u00020.H\u0002J\u0012\u0010L\u001a\u00020.2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010M\u001a\u00020&H\u0002J\u0010\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020&H\u0016J\u001a\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020&2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020&H\u0016J\u001c\u0010X\u001a\u00020.2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020[0ZH\u0016J\b\u0010\\\u001a\u00020.H\u0016J\b\u0010]\u001a\u00020\u001cH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/bytedance/ai/model/widgets/WebEngineAssem;", "Lcom/bytedance/assem/arch/view/UIContentAssem;", "Lcom/bytedance/ai/api/model/view/IAIRenderEngineService;", "<init>", "()V", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "mRenderStateVM", "Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "getMRenderStateVM", "()Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "mRenderStateVM$delegate", "Lcom/bytedance/assem/arch/viewModel/AssemVMLazy;", "mRenderData", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "getMRenderData", "()Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "mRenderData$delegate", "Lcom/bytedance/assem/arch/extensions/HierarchyLazy;", "webView", "Landroid/webkit/WebView;", "mHandler", "Landroid/os/Handler;", "webViewJSBridge", "Lcom/bytedance/ai/model/WebViewJSBridge;", "isPopup", "", "isReachTop", "isReachBottom", "lastY", "", "pullUp", "touchSlop", "activePointerId", "isBeingDragged", "traceId", "", "eventType", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "safeGetRenderState", "onViewCreated", "", "view", "Landroid/view/View;", "shouldOverrideUrlLoading", "url", "openHttpBySystem", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", "handleWebViewDrawEnd", "navigationStart", "", "drawEnd", "createIvyWebClient", "createHybridKit", "addCommonQuery", "requestHeaders", "", "addCommonHeaders", "checkWhiteList", "urlCheck", "doRefresh", "isDomStorageEnabled", "realView", "engineView", LiveCommonConstants.REASON_ON_DEDTROY, "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "webViewPort", "Lcom/bytedance/ai/applet/render/core/web/WebViewAIBridgePort;", "bindingWebView", "registerAIBridgeMethods", "injectWebViewData", "viewContext", "onMessageToJS", "message", "onMessageToAIBridge", "eventName", "params", "Lcom/google/gson/JsonObject;", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", com.alipay.sdk.m.x.d.f25925o, "title", "setTitleBar", "settings", "", "", "onBackPress", "goBack", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebEngineAssem extends UIContentAssem implements k2.q {
    public static final /* synthetic */ int C = 0;
    public d3.w A;
    public WebViewAIBridgePort B;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public lx7.a f36979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public kx7.c f36980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.assem.arch.viewModel.b f36981l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.assem.arch.extensions.f f36982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WebView f36983n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f36984o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ai.model.o0 f36985p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f36986q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f36987r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f36988s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f36989t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f36990u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f36991v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f36992w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f36993x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f36994y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f36995z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.assem.arch.service.c
    public final /* synthetic */ void f() {
    }

    @Override // k2.q
    public final void doRefresh() {
        kx7.c r100 = this.f36980k;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.i();
    L6:
        k2.b r103 = t();
        if (r103 == null) goto L9;
        String r104 = r103.f501423b;
    L11:
        if (Intrinsics.areEqual(r102, r104) == false) goto L13;
        s();
        return;
    L13:
        kx7.c r105 = this.f36980k;
        if (r105 == null) goto L16;
        r101 = r105.i();
    L16:
        if (r101 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L30;
        k2.b r107 = t();
        if (r107 == null) goto L35;
        String r108 = r107.f501423b;
        if (r108 == null) goto L36;
        kx7.c r109 = this.f36980k;
        if (r109 == null) goto L37;
        r109.d(r108);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L30:
        kx7.c r110 = this.f36980k;
        if (r110 == null) goto L39;
        r110.g();
        return;
    L39:
        return;
    L18:
        if (r101.length() == 0) goto L21;
        r106 = false;
        goto L22
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // k2.q
    public final boolean goBack() {
        kx7.c r100 = this.f36980k;
        if (r100 == null) goto L5;
        boolean r101 = r100.a();
    L6:
        if (r101 == false) goto L12;
        kx7.c r102 = this.f36980k;
        if (r102 == null) goto L10;
        r102.c();
    L10:
        return true;
    L12:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // k2.q
    public final void onBackPress() {
        kx7.c r100 = this.f36980k;
        if (r100 == null) goto L10;
        JSONObject r101 = new JSONObject();
        kx7.c r102 = this.f36980k;
        if (r102 == null) goto L7;
        String r103 = r102.b();
    L8:
        r101.put("containerID", r103);
        Unit r104 = Unit.INSTANCE;
        r100.h("bulletOnBackPressAction", r101);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.assem.arch.core.UIAssem, com.bytedance.assem.arch.core.Assem
    public final void onDestroy() {
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", LiveCommonConstants.REASON_ON_DEDTROY);
        this.f36984o.postDelayed(new e0(this), 2000);
        String r100 = this.f36994y;
        if (r100 == null) goto L8;
        String r101 = this.f36995z;
        if (r101 == null) goto L9;
        i1 r102 = m5.y0.f512051a;
        m5.y0.p(r100, r101, true);
        m5.y0.o(r100, r101);
        return;
    L9:
        return;
    }

    @Override // k2.o
    public final View realView() {
        kx7.c r100 = this.f36980k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k2.b t() {
        return (k2.b) this.f36982m.getValue();
    }

    @Override // k2.q
    public final String url() {
        kx7.c r100 = this.f36980k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.i();
    }

    public WebEngineAssem() {
        com.bytedance.assem.arch.viewModel.g.c r100 = com.bytedance.assem.arch.viewModel.g.c.f193086a;
        final KClass r101 = Reflection.getOrCreateKotlinClass(RenderStateVM.class);
        Function0<String> r102 = new WebEngineAssem$special$$inlined$assemViewModel$default$1(r101);
        WebEngineAssem$special$$inlined$assemViewModel$default$2 r103 = WebEngineAssem$special$$inlined$assemViewModel$default$2.INSTANCE;
        boolean r110 = false;
        if (Intrinsics.areEqual(r100, com.bytedance.assem.arch.viewModel.g.a.f193084a) == false) goto L6;
        com.bytedance.assem.arch.viewModel.b r104 = new com.bytedance.assem.arch.viewModel.b(r101, r102, VMExtKt.h(), VMExtKt.c(this, true), VMExtKt.f(this, true), VMExtKt.b(), r103, VMExtKt.a(this, true), VMExtKt.e(this, true));
    L15:
        this.f36981l = r104;
        if (this.f192855d == null) goto L18;
        r110 = true;
    L18:
        this.f36982m = new com.bytedance.assem.arch.extensions.f(r110, com.bytedance.assem.arch.extensions.d.a(this, k2.b.class));
        this.f36984o = new Handler(Looper.getMainLooper());
        this.f36986q = true;
        this.f36990u = true;
        this.f36992w = -1;
        return;
    L6:
        if (Intrinsics.areEqual(r100, r100) == false) goto L8;
        r104 = new com.bytedance.assem.arch.viewModel.b(r101, r102, VMExtKt.h(), VMExtKt.c(this, false), VMExtKt.f(this, false), VMExtKt.b(), r103, VMExtKt.a(this, false), VMExtKt.e(this, false));
        goto L15
    L8:
        if (r100 != null) goto L10;
    L14:
        r104 = new com.bytedance.assem.arch.viewModel.b(r101, r102, VMExtKt.h(), VMExtKt.m(this), VMExtKt.o(this), VMExtKt.b(), r103, VMExtKt.j(this), VMExtKt.k(this));
        goto L15
    L10:
        if (Intrinsics.areEqual(r100, com.bytedance.assem.arch.viewModel.g.b.f193085a) == true) goto L14;
        throw new IllegalArgumentException("Don't support this VMScope here.");
    }

    public final void s() {
        Context r100 = getContext();     // Catch: Exception -> L42
        if (r100 == null) goto L52;
        kx7.c r101 = this.f36980k;     // Catch: Exception -> L42
        if (r101 == null) goto L7;
        ((PluginWebView) r101).k();     // Catch: Exception -> L42
    L7:
        IIvyWebService.Companion r102 = IIvyWebService.f278339a;     // Catch: Exception -> L42
        k2.b r103 = t();     // Catch: Exception -> L42
        if (r103 == null) goto L11;
        String r104 = r103.f501422a;     // Catch: Exception -> L42
        if (r104 == null) goto L11;
    L12:
        lx7.a r105 = this.f36979j;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L42
        kx7.c r106 = r102.b(r104, r105, r100);     // Catch: Exception -> L42
        this.f36980k = r106;     // Catch: Exception -> L42
        if (r106 == null) goto L24;
        BulletContainerView r107 = r106.f();     // Catch: Exception -> L42
        if (r107 == null) goto L24;
        View r108 = this.f192883h;     // Catch: Exception -> L42
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");     // Catch: Exception -> L42
    L19:
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Exception -> L42
        ViewGroup r109 = (ViewGroup) r108;     // Catch: Exception -> L42
        r109.removeAllViews();     // Catch: Exception -> L42
        r109.addView(r107, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L42
        r107.setOnKeyListener(new f0(this));     // Catch: Exception -> L42
        String r110 = this.f36994y;     // Catch: Exception -> L42
        if (r110 == null) goto L24;
        String r111 = this.f36995z;     // Catch: Exception -> L42
        if (r111 == null) goto L24;
        i1 r112 = m5.y0.f512051a;     // Catch: Exception -> L42
        m5.y0.h(r110, r111);     // Catch: Exception -> L42
    L24:
        k2.b r113 = t();     // Catch: Exception -> L42
        if (r113 == null) goto L53;
        String r114 = r113.f501423b;     // Catch: Exception -> L42
        if (r114 == null) goto L54;
        String r115 = this.f36994y;     // Catch: Exception -> L42
        if (r115 == null) goto L33;
        String r116 = this.f36995z;     // Catch: Exception -> L42
        if (r116 == null) goto L33;
        i1 r117 = m5.y0.f512051a;     // Catch: Exception -> L42
        m5.y0.k(r115, r116, MapsKt.mapOf(TuplesKt.to("url", r114)));     // Catch: Exception -> L42
    L33:
        kx7.c r118 = this.f36980k;     // Catch: Exception -> L42
        if (r118 == null) goto L36;
        r118.d(r114);     // Catch: Exception -> L42
    L36:
        String r119 = this.f36994y;     // Catch: Exception -> L42
        if (r119 == null) goto L55;
        String r120 = this.f36995z;     // Catch: Exception -> L42
        if (r120 == null) goto L56;
        i1 r121 = m5.y0.f512051a;     // Catch: Exception -> L42
        m5.y0.j(r119, r120);     // Catch: Exception -> L42
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L11:
        r104 = "";
        goto L12
    L52:
        return;
    L42:
        e = move-exception;
        String r122 = this.f36994y;
        if (r122 == null) goto L48;
        String r123 = this.f36995z;
        if (r123 == null) goto L48;
        i1 r124 = m5.y0.f512051a;
        m5.y0.b(r122, "fail to create webview: " + e.getMessage(), AppletErrorCode.WEB_VIEW_CREATE_ERROR.getType(), r123);
    L48:
        com.bytedance.ai.utils.g.f37637a.e("WebViewAssem", "createHybridKit: " + e);
    }

    public final RenderStateVM u() {
        if (o() == true) goto L7;
        return null;
    L7:
        return (RenderStateVM) this.f36981l.getValue();
    }

    @Override // k2.o
    public final View engineView() {
        return this.f36983n;
    }

    @Override // k2.h
    public final d3.b0 getAIBridge() {
        return this.A;
    }

    @Override // com.bytedance.assem.arch.core.Assem, androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f192854c;
    }

    @Override // k2.q
    public final void b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        RenderStateVM r101 = u();
        if (r101 == null) goto L6;
        r101.updateState(new i5.k(r100));
        return;
    }

    @Override // k2.r
    public final void onMessageToJS(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        com.bytedance.ai.model.o0 r101 = this.f36985p;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.bytedance.assem.arch.core.UIAssem
    public final void r(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        k2.b r100 = t();
        String r101 = null;
        if (r100 == null) goto L11;
        k2.j r102 = r100.f501435n;
        if (r102 == null) goto L11;
        PageInfo r103 = r102.getPageInfo();
        if (r103 == null) goto L11;
        Map<String, Object> r104 = r103.getTraceInfo();
        if (r104 == null) goto L11;
        Object r105 = r104.get(BindCardPayConfirmConstants.Key.TRACE_ID);
    L13:
        if ((r105 instanceof String) == false) goto L15;
        String r106 = (String) r105;
    L16:
        this.f36994y = r106;
        k2.b r107 = t();
        if (r107 == null) goto L25;
        k2.j r108 = r107.f501435n;
        if (r108 == null) goto L25;
        PageInfo r109 = r108.getPageInfo();
        if (r109 == null) goto L25;
        Map<String, Object> r111 = r109.getTraceInfo();
        if (r111 == null) goto L25;
        Object r112 = r111.get("eventName");
    L27:
        if ((r112 instanceof String) == false) goto L29;
        r101 = (String) r112;
    L29:
        this.f36995z = r101;
        String r113 = this.f36994y;
        if (r113 == null) goto L33;
        if (r101 == null) goto L33;
        i1 r114 = m5.y0.f512051a;
        m5.y0.i(r113, r101);
    L33:
        k2.b r115 = t();
        if (r115 == null) goto L36;
        boolean r116 = r115.f501437p;
    L37:
        this.f36986q = r116;
        this.f36991v = ViewConfiguration.get(r110.getContext()).getScaledTouchSlop();
        h2.a r117 = f2.b.f475099c;
        if (r117 == null) goto L46;
        IIvyWebService.Companion r118 = IIvyWebService.f278339a;
        String r119 = r117.f483574m;
        k2.b r120 = t();
        if (r120 == null) goto L44;
        String r121 = r120.f501422a;
        if (r121 == null) goto L44;
    L45:
        this.f36979j = IIvyWebService.a.a(r118, r119, r121, new h0(this), new j0(this), new k0(this), new l0(this), new m0(this), null, 384);
    L44:
        r121 = "";
    L46:
        s();
        return;
    L36:
        r116 = false;
    L25:
        r112 = null;
        goto L27
    L15:
        r106 = null;
    L11:
        r105 = null;
        goto L13
    }

    @Override // k2.q
    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        RenderStateVM r101 = u();
        if (r101 == null) goto L6;
        r101.updateState(new i5.f(r100));
        return;
    }

    public final boolean v(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        String r102 = null;
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == true) goto L14;
        return false;
    L14:
        k2.b r103 = t();
        if (r103 == null) goto L17;
        List<String> r104 = r103.f501432k;
    L18:
        k2.b r105 = t();
        if (r105 == null) goto L21;
        r102 = r105.f501423b;
    L21:
        Uri r106 = UriProtector.parse(r102);
        if (Intrinsics.areEqual(r106.getScheme(), "https") == false) goto L30;
        if (r104 != null) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == false) goto L30;
        return true;
    L25:
        if (CollectionsKt.contains(r104, r106.getHost()) != true) goto L27;
        r107 = true;
    L30:
        return false;
    L17:
        r104 = null;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // k2.o
    public final void handleWebViewDrawEnd(final long r110, final long r111) {
        com.bytedance.ai.utils.g r100 = com.bytedance.ai.utils.g.f37637a;
        r100.d("WebViewAssem", "navigationStart:" + r110 + " drawEnd:" + r111 + ", duration:" + (r111 - r110));
        final String r101 = this.f36994y;
        if (r101 == null) goto L13;
        String r102 = this.f36995z;
        if (r102 == null) goto L14;
        i1 r103 = m5.y0.f512051a;
        Intrinsics.checkNotNullParameter(r101, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        r100.d("AppletEventMonitorManager", "onWebDrawEnd: " + r101 + ", " + r110 + ", " + r111 + ", " + r102);
        if (Intrinsics.areEqual(r102, "applet_widget_timeline_full") == false) goto L10;
        m5.y0.r(new m5.o0(r101, r110, r111));
        return;
    L10:
        if (Intrinsics.areEqual(r102, "applet_page_timeline_full") == false) goto L16;
        m5.y0.r(new m5.p0(r101, r110, r111));
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        d3.w r102 = this.A;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
