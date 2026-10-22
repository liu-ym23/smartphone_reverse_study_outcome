package com.bytedance.ai.lynx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.bytedance.ai.applet.render.core.lynx.LynxAIBridgePort;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.s0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends LynxView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f36655l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ai.lynx.b f36658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f36659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ivy.ivykit.api.bridge.g f36660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ivy.ivykit.api.plugin.b f36661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IAISDKDebugService.d f36662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s4.c<ReadableMap> f36663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f36665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f36666k;

    public static final class a {
    }

    public interface b {
        boolean onTouchEvent(MotionEvent r100);
    }

    static {
    }

    @Override // com.lynx.tasm.LynxView, w2.a
    public final void destroy() {
        setDebugOverlay(null);
        com.bytedance.ai.debug.f.f36213a.getClass();
        IAISDKDebugService.Companion r100 = IAISDKDebugService.f36186a;
        r100.getClass();
        IAISDKDebugService r101 = IAISDKDebugService.Companion.f36188c;
        if ((r101 instanceof IAISDKDebugService.b) == false) goto L5;
        IAISDKDebugService.b r102 = (IAISDKDebugService.b) r101;
    L6:
        if (r102 == null) goto L8;
        r102.K(this);
    L8:
        r100.D(this.f36662g);
        com.ivy.ivykit.api.plugin.b r103 = this.f36661f;
        if (r103 == null) goto L11;
        r103.release();
    L11:
        this.f36661f = null;
        removeLynxViewClient(this.f36658c);
        setAsyncImageInterceptor(null);
        com.ivy.ivykit.api.bridge.g r104 = this.f36660e;
        if (r104 == null) goto L14;
        r104.release();
    L14:
        super.destroy();
        return;
    L5:
        r102 = null;
        goto L6
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

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r r100 = this.f36658c.f36645d;
        if (r100 == null) goto L6;
        r100.onDetachedFromWindow(this);
        return;
    }

    public final Drawable getDebugOverlay() {
        return this.f36666k;
    }

    public final s4.c<ReadableMap> getLynxRemoteBridgeMessages() {
        return this.f36663h;
    }

    public final Uri getOriginalUri$ai_sdk_release() {
        return this.f36659d;
    }

    public final b getTouchEventCallback() {
        return this.f36665j;
    }

    private final void setNpthLastUrl(String r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        HashMap r101 = new HashMap();     // Catch: Throwable -> L11
        if (r110 == null) goto L8;
        List r111 = StringsKt.split$default(r110, new String[]{"?"}, false, 0, 6, null);     // Catch: Throwable -> L11
        if (r111 == null) goto L8;
        String r112 = (String) ListProtector.get(r111, 0);     // Catch: Throwable -> L11
        if (r112 == null) goto L8;
    L9:
        r101.put("last_lynx_url", r112);     // Catch: Throwable -> L11
        r101.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L11
        Npth.addTags(r101);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L8:
        r112 = "";
    L11:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.lynx.tasm.LynxView, com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        Drawable r101 = this.f36666k;
        if (r101 == null) goto L6;
        r101.setBounds(0, 0, getWidth(), getHeight());
        r101.draw(r100);
        return;
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        b r101 = this.f36665j;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L11;
        MotionEvent r103 = MotionEvent.obtain(r100);
        r103.setAction(3);
        super.dispatchTouchEvent(r103);
        r103.recycle();
        return true;
    L11:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101.onTouchEvent(r100) != true) goto L7;
        r102 = true;
        goto L7
    }

    public final LynxAIBridgePort h(s4.c<ReadableMap> r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteMessageCache");
        LynxAIBridgePort r101 = new LynxAIBridgePort(this, r100);
        r101.setRemoteReadyListener(new f(this));
        return r101;
    }

    public final void setDebugOverlay(Drawable r100) {
        Drawable r101 = this.f36666k;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 == null) goto L8;
        r101.setCallback(null);
    L8:
        if (r100 == null) goto L10;
        r100.setCallback(this);
    L11:
        this.f36666k = r100;
        invalidate();
        return;
    L10:
        r100 = null;
        goto L11
    }

    public final void setLynxRemoteBridgeMessages(s4.c<ReadableMap> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f36663h = r100;
    }

    public final void setReused(boolean r100) {
        this.f36664i = r100;
    }

    public final void setTouchEventCallback(b r100) {
        this.f36665j = r100;
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateData(TemplateData r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        r100.markReadOnly();
        super.updateData(r100);
    }

    public final void k(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        int r103 = com.bytedance.ai.applet.render.core.lynx.p.f35155a;
        com.bytedance.ai.applet.render.core.lynx.p.a.a(this, r100, r101, r102);
    }

    public g(Context r100, String r101, String r102, LynxViewBuilder r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerId");
        Intrinsics.checkNotNullParameter(r102, "bid");
        Intrinsics.checkNotNullParameter(r103, "builder");
        super(r100, r103);
        this.f36656a = r101;
        this.f36657b = r102;
        com.bytedance.ai.lynx.b r105 = new com.bytedance.ai.lynx.b(this, this.f36657b);
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r105.f36647f = r104;
        this.f36658c = r105;
        this.f36659d = Uri.EMPTY;
        this.f36663h = new s4.c();
        addLynxViewClient(r105);
    }

    public static /* synthetic */ void j(g r100, String r101, TemplateBundle r102, TemplateData r103, r r110) {
        r100.i(r101, r102, r103, r110, null);
    }

    public final void i(String r100, TemplateBundle r101, TemplateData r102, r r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "templateBundle");
        Intrinsics.checkNotNullParameter(r102, "initData");
        Intrinsics.checkNotNullParameter(r103, "lifeCycle");
        Uri r105 = UriProtector.parse(r100);
        this.f36659d = r105;
        String r106 = UriProtector.getQueryParameter(r105, "forest_session_id");     // Catch: Exception -> L5
    L7:
        if (r106 != null) goto L9;
        r106 = this.f36656a;
    L9:
        com.bytedance.ai.lynx.b r107 = this.f36658c;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r107.f36646e = r106;
        r107.f36644c = this.f36659d;
        r107.f36645d = r103;
        setNpthLastUrl(r100);
        s0.a r108 = new s0.a();
        r108.f383725a = r100;
        r108.f383727c = r101;
        r108.f383728d = r102;
        r108.f383730f = LynxLoadMode.NORMAL;
        r108.a(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        s0 r109 = r108.b();
        q r110 = q.f36678a;
        TemplateData r111 = TemplateData.fromMap(q.c(this.f36657b));
        Map r112 = q.f(getContext());
        if (r112 == null) goto L15;
        Iterator r113 = r112.entrySet().iterator();
    L13:
        if (r113.hasNext() == false) goto L15;
        Map.Entry r114 = (Map.Entry) r113.next();
        r111.put((String) r114.getKey(), r114.getValue());
    L15:
        r111.put("__AI_SDK_VERSION__", "1.15.0-rc.7");
        if (r104 == null) goto L21;
        Iterator<Map.Entry<String, ? extends Object>> r115 = r104.entrySet().iterator();
    L19:
        if (r115.hasNext() == false) goto L21;
        Map.Entry<String, ? extends Object> r116 = r115.next();
        r111.put(r116.getKey(), r116.getValue());
    L21:
        r111.markReadOnly();
        updateGlobalProps(r111);
        loadTemplate(r109);
        return;
    L5:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AppletLynxView", "loadTemplateBundle parse forest_session_id error", e);
        r106 = null;
        goto L7
    }
}
