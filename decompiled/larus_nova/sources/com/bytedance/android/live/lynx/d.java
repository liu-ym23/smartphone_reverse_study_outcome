package com.bytedance.android.live.lynx;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.lynx.callback.AnnieLynxMonitorCallback;
import com.bytedance.android.live.lynx.components.LiveLynxComponentForSaas;
import com.bytedance.android.live.lynx.components.n;
import com.bytedance.android.live.lynx.monitor.LynxMonitor;
import com.bytedance.android.live.lynx.open.OpenLynxComponent;
import com.bytedance.android.live.lynx.ui.LiveLynxBehaviorProvider;
import com.bytedance.android.live.lynx.ui.paidlive.LynxLiveFeature;
import com.bytedance.android.live.lynx.ui.replay.ReplayVideoLynxView;
import com.bytedance.android.live.lynx.widget.LynxTestWidget;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.ies.xelement.live.LynxLiveView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.canvas.LynxCanvasDownStreamManager;
import com.lynx.devtoolwrapper.DevToolLifecycle;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public class d implements w {
    private final n30.a hybridMonitor;

    public static final class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("x-live");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxLiveView(r100);
        }
    }

    public static final class b implements n30.a {
        public b() {
        }

        @Override // n30.a
        public final void a(View r110, String r111, String r112, JSONObject r113, JSONObject r114, JSONObject r115, boolean r116) {
            int r100 = rl0.b.f538445a;
            rl0.a r101 = rl0.a.f538441b;
            View r102 = r110;
            if ((r102 instanceof LynxView) == true) goto L5;
            r102 = null;
        L5:
            r101.j((LynxView) r102, r111, r112, r113, r114, r115, null, r116);
        }

        @Override // n30.a
        public final void reportCustomV2(View r110, String r111, String r112, JSONObject r113, JSONObject r114, JSONObject r115, JSONObject r116, int r117) {
            int r100 = rl0.b.f538445a;
            rl0.a r101 = rl0.a.f538441b;
            View r102 = r110;
            if ((r102 instanceof LynxView) == true) goto L5;
            r102 = null;
        L5:
            r101.k((LynxView) r102, r111, r112, r113, r114, r115, r116, r117);
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("x-live-feature");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            return new LynxLiveFeature(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.lynx.d$d, reason: collision with other inner class name */
    public static final class C1259d extends com.lynx.tasm.behavior.a {
        public C1259d() {
            super("x-record-video");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new ReplayVideoLynxView(r100);
        }
    }

    @Override // com.bytedance.android.live.browser.w
    public void addHybridDebugTool(Context r100, ViewGroup r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        Intrinsics.checkNotNullParameter(r102, "url");
    }

    public void createHybridCard(Context r100, Uri r101, b7.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
    }

    public List<f> getLynxLifeCallback() {
        return CollectionsKt.mutableListOf(new AnnieLynxMonitorCallback[]{new AnnieLynxMonitorCallback()});
    }

    @Override // com.bytedance.android.live.browser.w
    public void prepareRemoteDebug(String r100) {
    }

    @Override // com.bytedance.android.live.browser.w
    public List<com.lynx.tasm.behavior.a> provideLynxLiveBehaviors() {
        return CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new c(), new C1259d()});
    }

    @Override // com.bytedance.android.live.browser.w
    public List<com.lynx.tasm.behavior.a> getBehaviorList() {
        Lazy r100 = LiveLynxBehaviorProvider.f82699a;
        ArrayList r101 = new ArrayList();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Boolean.valueOf(r101.addAll((List) LiveLynxBehaviorProvider.f82700b.getValue())));     // Catch: Throwable -> L5
    L7:
        IHostAction r103 = (IHostAction) k.f(IHostAction.class);
        if (r103 == null) goto L10;
        List r104 = r103.getECLynxBehaviorList();
    L11:
        ALogger.i("LiveLynxBehaviorProvider-ECLynxBehaviorList", String.valueOf(r104));
        if (r104 == null) goto L19;
        Iterator r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        if ((r106 instanceof com.lynx.tasm.behavior.a) == false) goto L15;
        ALogger.i("LiveLynxBehaviorProvider-ECLynxBehavior", String.valueOf(r106));
        r101.add(r106);
    L19:
        return r101;
    L10:
        r104 = null;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.android.live.browser.w
    public k7a.a getDynamicComponentFetcher() {
        return new n();
    }

    @Override // com.bytedance.android.live.browser.w
    public List<com.lynx.tasm.behavior.a> getLiveExportedXElements() {
        return CollectionsKt.listOf(new a());
    }

    @Override // com.bytedance.android.live.browser.w
    public boolean isEnableDevtoolDebug() {
        com.bytedance.android.live.lynx.a r100 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r100 == null) goto L6;
        return r100.isEnableDebug();
    L6:
        return LynxEnv.inst().isEnableDevtoolDebug();
    }

    public d() {
        this.hybridMonitor = new b();
    }

    public String getLynxVersion() {
        return LynxEnv.inst().getLynxVersion();
    }

    public boolean isV8Enable() {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (DevToolSettings.inst().isDevToolEnabled() == false) goto L9;
        if (DevToolSettings.inst().getV8Enabled() == 0) goto L9;
        return true;
    }

    @Override // com.bytedance.android.live.browser.w
    public <T extends LiveRecyclableWidget> Class<T> createTestWidgetClass() {
        return LynxTestWidget.class;
    }

    @Override // com.bytedance.android.live.browser.w
    public d8a.b getAbsTemplateProvider() {
        return ol0.b.f524116a;
    }

    @Override // com.bytedance.android.live.browser.w
    public n30.a getHybridMonitor() {
        return this.hybridMonitor;
    }

    private final LynxMonitor.FallbackType getLynxFallbackType(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if (tb1.c.f545231c == false) goto L9;
        if (((IHostBusiness) k.n(IHostBusiness.class)).checkLynxPlugin() == true) goto L9;
        return LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED;
    L9:
        if (LynxEnv.inst().hasInited() == true) goto L13;
        return LynxMonitor.FallbackType.INIT_FAILED;
    L13:
        if (r100 == 400) goto L15;
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        return LynxMonitor.FallbackType.UNKNOWN;
    L15:
        return LynxMonitor.FallbackType.LOAD_FAILED;
    L18:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final String getPath(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L17;
        return "";
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100).getPath());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        String r103 = (String) r102;
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public List<u> getJsbMonitors(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        if ((r100 instanceof LynxView) == true) goto L5;
        View r101 = null;
    L7:
        if (((LynxView) r101) == null) goto L11;
        List<u> r102 = CollectionsKt.mutableListOf(new ql0.a[]{new ql0.a((LynxView) r100)});
        if (r102 == null) goto L11;
        return r102;
    L11:
        return new ArrayList();
    L5:
        r101 = r100;
        goto L7
    }

    @Override // com.bytedance.android.live.browser.w
    public void setEnableDevtoolDebug(boolean r100) {
        com.bytedance.android.live.lynx.a r101 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r101 == null) goto L5;
        r101.b(r100);
        return;
    L5:
        LynxEnv.inst().setEnableDevtoolDebug(r100);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, kotlin.Unit] */
    @Override // com.bytedance.android.live.browser.w
    public void tryInitEnvIfNeeded(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        kjc.c r101 = new kjc.c();
        if (2 != kjc.a.a()) goto L9;
        kjc.b<T> r102 = r101.f503730a;
        if (((IHostBusiness) k.n(IHostBusiness.class)).checkLynxPlugin() == true) goto L7;
        return;
    L7:
        pl0.b.a(r100);
        r102.f503729a = Unit.INSTANCE;
        r101.f503731b = true;
    L9:
        if (r101.f503731b == true) goto L11;
        kjc.b<T> r103 = r101.f503730a;
        pl0.b.a(r100);
        r103.f503729a = Unit.INSTANCE;
    L11:
        T r104 = r101.f503730a.f503729a;
    }

    private final com.bytedance.android.live.lynx.api.c catchingCreate(String r100, Function0<? extends com.bytedance.android.live.lynx.api.c> r101) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        if (tb1.c.f545231c == true) goto L6;
    L9:
        Object r104 = Result.m9449constructorimpl(r101.invoke());     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L21;
        boolean r106 = LynxMonitor.f82613a;
        if (LynxEnv.inst().hasInited() == true) goto L18;
        LynxMonitor.FallbackType r107 = LynxMonitor.FallbackType.INIT_FAILED;
    L19:
        LynxMonitor.b(r107, e.a(r105), null, 0, 28);
        goto L21
    L18:
        r107 = LynxMonitor.FallbackType.UNKNOWN;
    L21:
        if (Result.m9455isFailureimpl(r104) == true) goto L25;
        r102 = r104;
    L25:
        return (com.bytedance.android.live.lynx.api.c) r102;
    L6:
        if (((IHostBusiness) k.n(IHostBusiness.class)).checkLynxPlugin() == true) goto L9;
        boolean r108 = LynxMonitor.f82613a;     // Catch: Throwable -> L11
        LynxMonitor.d(LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED, r100);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.bytedance.android.live.browser.w
    public Object map2TemplateData(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (((IHostBusiness) k.n(IHostBusiness.class)).checkLynxPlugin() == true) goto L6;
        return null;
    L6:
        TemplateData r102 = TemplateData.fromMap(r100);
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        r102.markState(r101);
    L15:
        return r102;
    L9:
        if (StringsKt.isBlank(r101) == true) goto L12;
        r103 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.browser.w
    public void monitorCachePropsInject(String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r111, "categoryJson");
        boolean r100 = LynxMonitor.f82613a;
        Intrinsics.checkNotNullParameter(r111, "categoryJson");
        JSONObject r101 = new JSONObject();
        r101.put("virtual_aid", "88888");
        if (LynxMonitor.f82613a == false) goto L5;
        int r102 = rl0.b.f538445a;
        rl0.a.f538441b.k(null, "inject_data_to_props", r110, r111, null, null, r101, 0);
        return;
    L5:
        int r103 = rl0.b.f538445a;
        rl0.a.f538441b.j(null, "inject_data_to_props", r110, r111, null, null, r101, false);
    }

    @Override // com.bytedance.android.live.browser.w
    public void setEnableJSRuntime(LynxViewBuilder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        com.bytedance.android.live.lynx.a r102 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r102 == null) goto L6;
        r102.setEnableJSRuntime(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.browser.w
    public Fragment createLynxFragment(Context r100, Bundle r101, d0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        return vl0.c.f555615b.createLiveLynxFragment(r101, r102, new vl0.b());
    }

    @Override // com.bytedance.android.live.browser.w
    public void reportLynxFallback(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        boolean r103 = LynxMonitor.f82613a;
        LynxMonitor.a(getLynxFallbackType(r101), r102, getPath(r100), r101);
    }

    @Override // com.bytedance.android.live.browser.w
    public void setEnableUserCodeCache(LynxViewBuilder r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        com.bytedance.android.live.lynx.a r103 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r103 == null) goto L6;
        r103.a(r100, r102);
        return;
    }

    @Override // com.bytedance.android.live.browser.w
    public void stopLynxCast(LynxView r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r101, "canvasId");
        LynxCanvasDownStreamManager.getInstance().RemoveDownStreamSurface(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.browser.w
    public void updateData(View r100, Object r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r101, "data");
        if ((r100 instanceof LynxView) == true) goto L6;
        return;
    L6:
        if ((r101 instanceof Map) == false) goto L9;
        ((LynxView) r100).updateData((Map) r101);
        return;
    L9:
        if ((r101 instanceof TemplateData) == false) goto L17;
        if (r102 == false) goto L14;
        com.bytedance.android.live.lynx.a r103 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r103 == null) goto L14;
        r103.d((TemplateData) r101);
    L14:
        ((LynxView) r100).updateData((TemplateData) r101);
        return;
    }

    @Override // com.bytedance.android.live.browser.w
    public com.bytedance.android.live.lynx.api.d create(Context r100, Integer r101, LynxThreadStrategy r110, d0 r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "threadStrategy");
        return new OpenLynxComponent(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.browser.w
    public void monitorLynxListFps(LynxView r110, String r111, String r112, double r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "lynxView");
        Intrinsics.checkNotNullParameter(r111, "path");
        Intrinsics.checkNotNullParameter(r112, "tag");
        boolean r100 = LynxMonitor.f82613a;
        Intrinsics.checkNotNullParameter(r110, "lynxView");
        Intrinsics.checkNotNullParameter(r111, "path");
        Intrinsics.checkNotNullParameter(r112, "tag");
        JSONObject r101 = new JSONObject();
        r101.put("fps", r113);
        JSONObject r102 = new JSONObject();
        r102.put("tag", r112);
        r102.put(ILiveHybridMonitor.ContainerType.ANNIE, "0");
        Object r103 = r110.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r103 == null) goto L12;
        r102.put("refresh_rate", String.valueOf((int) ((WindowManager) r103).getDefaultDisplay().getRefreshRate()));
        JSONObject r104 = new JSONObject();
        r104.put("virtual_aid", "88888");
        if (LynxMonitor.f82613a == false) goto L9;
        if (r114 == false) goto L8;
        int r105 = rl0.b.f538445a;
        rl0.a.f538441b.k(r110, "lynx_list_fps", r111, r102, r101, null, r104, 2);
        return;
    L8:
        int r106 = rl0.b.f538445a;
        rl0.a.f538441b.k(r110, "lynx_list_fps", r111, r102, r101, null, r104, 0);
        return;
    L9:
        int r107 = rl0.b.f538445a;
        rl0.a.f538441b.j(r110, "lynx_list_fps", r111, r102, r101, null, r104, r114);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @Override // com.bytedance.android.live.browser.w
    public void reportLynxFetchJsbError(View r110, String r111, String r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "lynxView");
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, com.alipay.sdk.m.p.e.f25671s);
        if ((r110 instanceof LynxView) == true) goto L5;
        View r100 = null;
    L7:
        if (((LynxView) r100) == null) goto L31;
        int r101 = rl0.b.f538445a;
        LynxView r115 = (LynxView) r110;
        rl0.a.f538441b.getClass();
        Intrinsics.checkNotNullParameter(r115, "view");
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, com.alipay.sdk.m.p.e.f25671s);
        Object r116 = 0;
        if (r114 == null) goto L20;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        int r103 = StringsKt.lastIndexOf$default(r114, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L13
        int r104 = StringsKt.indexOf$default(r114, ',', r103, false, 4, null);     // Catch: Throwable -> L13
        r116 = Integer.valueOf(CastIntegerProtector.parseInt(r114.substring(r103 + 18, r104)));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r116 = r106;
    L18:
        r116 = (Number) r116;
    L20:
        if (rl0.a.f538440a == false) goto L26;
        qz2.c r107 = new qz2.c();
        r107.f535297c = r111;
        r107.f535296b = r112;
        r107.f535298d = r113;
        if (r116 == null) goto L25;
        r107.f535299e = ((Integer) r116).intValue();
        r107.f535301g = r114;
        LynxViewMonitor.f163126b.getClass();
        LynxViewMonitor.n(r115, r107);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L26:
        vy2.c r108 = new vy2.c();
        r108.f557576c = r111;
        r108.f557575b = r112;
        r108.f557577d = r113;
        if (r116 == null) goto L30;
        r108.f557578e = ((Integer) r116).intValue();
        r108.f557579f = r114;
        com.bytedance.android.monitor.lynx.LynxMonitor.f162823j.l(r115, r108);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L31:
        return;
    L5:
        r100 = r110;
        goto L7
    }

    @Override // com.bytedance.android.live.browser.w
    public long startLynxCast(LynxView r100, String r101, Surface r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r101, "canvasId");
        Intrinsics.checkNotNullParameter(r110, "surface");
        return LynxCanvasDownStreamManager.getInstance().AddDownStreamSurface(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.browser.w
    public com.bytedance.android.live.lynx.api.c create(Activity r110, Integer r111, String r112, LynxThreadStrategy r113, String r114, d0 r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, "url");
        Intrinsics.checkNotNullParameter(r113, "threadStrategy");
        Intrinsics.checkNotNullParameter(r114, "oriScheme");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(UriProtector.parse(r112).getPath());     // Catch: Throwable -> L5
    L7:
        Object r116 = null;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        String r102 = (String) r101;
        if (r102 != null) goto L35;
        r102 = "";
    L35:
    L20:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Object r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L22:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L30;
        boolean r106 = LynxMonitor.f82613a;
        if (LynxEnv.inst().hasInited() == true) goto L27;
        LynxMonitor.FallbackType r107 = LynxMonitor.FallbackType.INIT_FAILED;
    L28:
        LynxMonitor.b(r107, e.a(r105), null, 0, 28);
        goto L30
    L27:
        r107 = LynxMonitor.FallbackType.UNKNOWN;
    L30:
        if (Result.m9455isFailureimpl(r104) == true) goto L34;
        r116 = r104;
    L34:
        return (com.bytedance.android.live.lynx.api.c) r116;
    L14:
        if (tb1.c.f545231c == true) goto L16;
    L18:
        r104 = Result.m9449constructorimpl(new LiveLynxComponentForSaas(r110, null, r112, r111, r113, r114, r115, false));     // Catch: Throwable -> L20
        goto L22
    L16:
        if (((IHostBusiness) k.n(IHostBusiness.class)).checkLynxPlugin() == true) goto L18;
        boolean r108 = LynxMonitor.f82613a;     // Catch: Throwable -> L20
        LynxMonitor.d(LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED, r102);     // Catch: Throwable -> L20
        return null;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.android.live.browser.w
    public com.bytedance.android.live.lynx.api.c createAndLoad(ILiveHybridContainer r110, String r111, Integer r112, LynxThreadStrategy r113, String r114, d0 r115) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r113, "threadStrategy");
        Intrinsics.checkNotNullParameter(r114, "oriScheme");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(UriProtector.parse(r111).getPath());     // Catch: Throwable -> L5
    L7:
        Object r116 = null;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        String r102 = (String) r101;
        if (r102 != null) goto L37;
        r102 = "";
    L37:
    L20:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Object r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L22:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L30;
        boolean r106 = LynxMonitor.f82613a;
        if (LynxEnv.inst().hasInited() == true) goto L27;
        LynxMonitor.FallbackType r107 = LynxMonitor.FallbackType.INIT_FAILED;
    L28:
        LynxMonitor.b(r107, e.a(r105), null, 0, 28);
        goto L30
    L27:
        r107 = LynxMonitor.FallbackType.UNKNOWN;
    L30:
        if (Result.m9455isFailureimpl(r104) == true) goto L34;
        r116 = r104;
    L34:
        return (com.bytedance.android.live.lynx.api.c) r116;
    L14:
        if (tb1.c.f545231c == true) goto L16;
    L18:
        ALogger.i("LynxService", "lynx version: 3.9.1-rc.11");     // Catch: Throwable -> L20
        r104 = Result.m9449constructorimpl(new LiveLynxComponentForSaas(r110.getCurrentActivity(), r110, r111, r112, r113, r114, r115, true));     // Catch: Throwable -> L20
        goto L22
    L16:
        if (((IHostBusiness) k.n(IHostBusiness.class)).checkLynxPlugin() == true) goto L18;
        boolean r108 = LynxMonitor.f82613a;     // Catch: Throwable -> L20
        LynxMonitor.d(LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED, r102);     // Catch: Throwable -> L20
        return null;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.android.live.browser.w
    public LynxGroup getLynxGroup(String r100, String[] r110, boolean r111, boolean r112, boolean r113, int r114) {
        com.bytedance.android.live.lynx.a r101 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.e(r100, r110, r111, r112, r113, r114);
    }
}
