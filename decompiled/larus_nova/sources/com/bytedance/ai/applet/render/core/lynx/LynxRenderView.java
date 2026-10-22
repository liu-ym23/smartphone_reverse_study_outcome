package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.crash.Npth;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.q1;
import com.lynx.tasm.s0;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class LynxRenderView extends LynxView implements w2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f35122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f35123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ivy.ivykit.api.bridge.g f35124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ivy.ivykit.api.plugin.b f35125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s4.c<ReadableMap> f35126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.d f35127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w2.c f35128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f35129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n f35130i;

    public static final class a extends w2.a.AbstractC8061a<a, LynxRenderView> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LynxViewBuilder f35131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f35132e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public o f35133f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function2<? super String, ? super ContainerType, Boolean> f35134g;

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this(r100, new LynxViewBuilder());
        }

        public a(Context r100, LynxViewBuilder r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "lynxViewBuilder");
            super(r100);
            this.f35131d = r101;
            this.f35132e = UUID.randomUUID().toString();
        }
    }

    public static final class b {
    }

    static {
    }

    public LynxRenderView() {
        throw null;
    }

    @Override // w2.a
    public final View asView() {
        return this;
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // w2.a
    public final View realView() {
        return this;
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    @Override // com.lynx.tasm.LynxView, w2.a
    public final void destroy() {
        com.ivy.ivykit.api.plugin.b r100 = this.f35125d;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        com.ivy.ivykit.api.bridge.g r101 = this.f35124c;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        super.destroy();
    }

    private final TemplateData getGlobalPropsTemplateData() {
        return TemplateData.fromMap(getLynxGlobalProps());
    }

    private final Map<String, Object> getLynxGlobalProps() {
        Map<String, Object> r100 = MapsKt.toMutableMap(getComposition().f557957b);
        r100.put("__RENDER_DATA__", getComposition().f557959d.toString());
        r100.put("__VIEW_CONTEXT__", getComposition().f557958c);
        return r100;
    }

    @Override // w2.a
    public final void a() {
        getComposition().f557961f = null;
    }

    @Override // w2.a
    public final void c() {
        getComposition().f557960e = null;
        n r100 = this.f35130i;
        if (r100 == null) goto L6;
        removeLynxViewClient(r100);
        this.f35130i = null;
        return;
    }

    @Override // w2.a
    public w getBridge() {
        return getComposition().f557956a;
    }

    @Override // w2.a
    public final boolean d() {
        return this.f35129h;
    }

    @Override // w2.a
    public w2.c getComposition() {
        return this.f35128g;
    }

    public final com.ivy.ivykit.api.bridge.g getIvyLynxBridge() {
        return this.f35124c;
    }

    public final s4.c<ReadableMap> getLynxBridgeMessages() {
        return this.f35126e;
    }

    @Override // w2.a
    public RenderType getRenderType() {
        return RenderType.LYNX;
    }

    public final String getViewUuid() {
        return this.f35123b;
    }

    private final void setNpthLastUrl(String r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L4
        r101.put("last_lynx_url", CollectionsKt.first(StringsKt.split$default(r110, new String[]{"?"}, false, 0, 6, null)));     // Catch: Throwable -> L4
        r101.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L4
        Npth.addTags(r101);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        w2.a.c r101 = getComposition().f557961f;
        if (r101 == null) goto L6;
        r101.onTouchEvent(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // w2.a
    public final void e(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        w2.a.b.b(this, r100);
        updateGlobalProps(TemplateData.fromMap(r100));
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        sendGlobalEvent("globalPropsUpdated", new JavaOnlyArray());     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("LynxRenderView", "sendGlobalEvent globalPropsUpdated error: " + r103.getMessage(), null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final TemplateData h(JSONObject r100) {
        TemplateData r101 = TemplateData.empty();
        if ((!getComposition().f557958c.isEmpty()) == false) goto L6;
        r101.put("viewContext", getComposition().f557958c);
    L6:
        if (getComposition().f557959d.length() <= 0) goto L9;
        r101.put("viewData", getComposition().f557959d);
        r101.put("widgetData", getComposition().f557959d);
    L9:
        if (r100.length() <= 0) goto L11;
        r101.updateWithTemplateData(TemplateData.fromString(r100.toString()));
    L11:
        return r101;
    }

    @Override // w2.a
    public void setGlobalProperties(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        w2.c r101 = getComposition();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f557957b = r100;
    }

    @Override // w2.a
    public void setOnTouchEventListener(w2.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getComposition().f557961f = r100;
    }

    @Override // w2.a
    public void setReused(boolean r100) {
        this.f35129h = r100;
    }

    @Override // w2.a
    public void setViewClient(w2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r100, "client");
        getComposition().f557960e = r100;
        q1 r101 = this.f35130i;
        if (r101 == null) goto L5;
        removeLynxViewClient(r101);
    L5:
        n r102 = new n(this, r100, this.f35122a);
        this.f35130i = r102;
        addLynxViewClient(r102);
    }

    @Override // w2.a
    public void setViewContext(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        w2.c r101 = getComposition();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f557958c = r100;
    }

    @Override // w2.a
    public void setViewData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        w2.c r101 = getComposition();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f557959d = r100;
    }

    @Override // w2.a
    public final void b(JSONObject r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 == false) goto L5;
        reloadTemplate(h(r100), getGlobalPropsTemplateData());
        return;
    L5:
        updateData(h(r100));
    }

    @Override // w2.a
    public final Object f(String r100, JSONObject r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof LynxRenderView$loadUrl$1) == false) goto L7;
        LynxRenderView$loadUrl$1 r103 = (LynxRenderView$loadUrl$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (JSONObject) r103.L$1;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        TemplateBundle r108 = (TemplateBundle) r105;
        String r109 = null;
        if (r108 != null) goto L27;
        com.bytedance.ai.applet.base.log.d r110 = this.f35127f;
        AtomicInteger r111 = com.bytedance.ai.applet.base.log.d.f34519d;
        r110.a("load resource failed, bundle is NULL", null);
        w2.b r112 = getComposition().f557960e;
        if (r112 == null) goto L26;
        r112.f(this, true, 103, "load resource failed, bundle is NULL");
    L26:
        return Unit.INSTANCE;
    L27:
        w2.b r113 = getComposition().f557960e;
        if (r113 == null) goto L30;
        r113.a(this, r100);
    L30:
        setNpthLastUrl(r100);
        updateGlobalProps(getLynxGlobalProps());
        Object r114 = getComposition().f557958c.get(IFlowAppIntentIDL.PARAM_APPLET_ID);
        if ((r114 instanceof String) == false) goto L33;
        String r115 = (String) r114;
    L34:
        Object r116 = getComposition().f557958c.get("pageName");
        if ((r116 instanceof String) == false) goto L37;
        r109 = (String) r116;
    L37:
        int r117 = p.f35155a;
        p.a.a(this, r100, r115, r109);
        s0.a r118 = new s0.a();
        r118.f383725a = r100;
        r118.f383727c = r108;
        r118.f383728d = h(r101);
        r118.f383730f = LynxLoadMode.NORMAL;
        r118.a(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        loadTemplate(r118.b());
        return Unit.INSTANCE;
    L33:
        r115 = null;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        w2.b r119 = getComposition().f557960e;
        if (r119 == null) goto L17;
        r119.g(this, r100);
    L17:
        o r120 = this.f35122a;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = r120.a(r100, r103);
        if (r105 != r106) goto L20;
        return r106;
    L7:
        r103 = new LynxRenderView$loadUrl$1(this, r102);
        goto L8
    }

    public LynxRenderView(Context r100, LynxViewBuilder r101, o r102, String r103, com.ivy.ivykit.api.bridge.g r104, com.ivy.ivykit.api.plugin.b r105, s4.c r106) {
        super(r100, r101);
        this.f35122a = r102;
        this.f35123b = r103;
        this.f35124c = r104;
        this.f35125d = r105;
        this.f35126e = r106;
        this.f35127f = new com.bytedance.ai.applet.base.log.d("LynxRenderView", null);
        this.f35128g = new w2.c();
        addLynxViewClient(new m(this));
        LynxAIBridgePort r107 = new LynxAIBridgePort(this, r106);
        getBridge().j(this);
        getBridge().k(r107);
    }
}
