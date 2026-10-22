package com.bytedance.android.anniex.engine;

import android.content.MutableContextWrapper;
import com.bytedance.android.anniex.ability.f;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.h;
import com.lynx.tasm.o1;
import com.lynx.tasm.s0;
import com.lynx.tasm.t;
import i36.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXLynxEngine implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableContextWrapper f40709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxTemplateRender f40710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxBDXBridge f40711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.monitorV2.lynx.jsb.a f40712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f40713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f40714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f40715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f40716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f40717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d1 f40718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f40719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f40720l;

    @Override // com.lynx.tasm.h
    public final void updateMetaData(o1 r100) {
        throw null;
    }

    @Override // com.lynx.tasm.h
    public final void destroy() {
        com.bytedance.ies.bullet.secure.a r100 = (com.bytedance.ies.bullet.secure.a) this.f40719k.getValue();
        if (r100 == null) goto L5;
        r100.b();
    L5:
        this.f40710b.destroy();
    }

    public static void c(String r110) {
        TraceEvent.beginSection("AnnieXLynxEngine:setNpthLastUrl");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        HashMap r101 = new HashMap();     // Catch: Throwable -> L12
        if (r110 == null) goto L9;
        List r111 = StringsKt.split$default(r110, new String[]{"?"}, false, 0, 6, null);     // Catch: Throwable -> L12
        if (r111 == null) goto L9;
        String r112 = (String) r111.get(0);     // Catch: Throwable -> L12
        if (r112 == null) goto L9;
    L10:
        r101.put("last_lynx_url", r112);     // Catch: Throwable -> L12
        r101.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L12
        Npth.addTags(r101);     // Catch: Throwable -> L12
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L17
        TraceEvent.endSection("AnnieXLynxEngine:setNpthLastUrl");
        return;
    L9:
        r112 = "";
    L17:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxEngine:setNpthLastUrl");
        throw th;
    L12:
        th = move-exception;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L14
    }

    @Override // com.lynx.tasm.h
    public final void loadTemplate(s0 r100) {
        Intrinsics.checkNotNullParameter(r100, "metaData");
        this.f40710b.loadTemplate(r100);
    }

    public final void a(ra.a r100, String r101, p r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("res_from", r101);
        if (r102 == null) goto L5;
        r103.put("geckoId", String.valueOf(r102.f247863f));
        r103.put("geckoChannel", r102.f247878u);
    L5:
        UGLogger.c r104 = UGLogger.f270252a;
        StringBuilder r105 = new StringBuilder("annieXLynxModel.globalProps is not null: ");
        if (r100.f536746d == null) goto L8;
        boolean r106 = true;
    L9:
        r105.append(r106);
        UGLogger.d(r105.toString());
        TemplateData r107 = r100.f536746d;
        if (r107 == null) goto L27;
        Iterator r108 = r103.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.put((String) r109.getKey(), r109.getValue());
        goto L13
    L15:
        ConcurrentHashMap<String, Object> r110 = f.f40204a;
        Map r111 = f.o(this.f40709a, r100.f536749g);
        if (r111 == null) goto L21;
        Iterator r112 = r111.entrySet().iterator();
    L19:
        if (r112.hasNext() == false) goto L21;
        Map.Entry r113 = (Map.Entry) r112.next();
        r107.put((String) r113.getKey(), r113.getValue());
    L21:
        Boolean r114 = Boolean.FALSE;
        r107.put("isColdStart", r114);
        r107.put("isPreCreate", r114);
        r107.put("isAsyncLayout", r114);
        r107.put("isFromEngine", Boolean.TRUE);
        r107.markConcurrent();
        Intrinsics.checkNotNullParameter(r107, SlcElement.KEY_PROPS);
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        UGLogger.d("updateGlobalProps");     // Catch: Throwable -> L24
        this.f40710b.updateMetaData(new o1(null, r107));     // Catch: Throwable -> L24
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L24
        TraceEvent.endSection("LynxView:updateGlobalProps");
        return;
    L24:
        th = move-exception;
        TraceEvent.endSection("LynxView:updateGlobalProps");
        throw th;
    L27:
        return;
    L8:
        r106 = false;
        goto L9
    }

    public final void b(String r100, String r101, final String r102) {
        TraceEvent.beginSection("AnnieXLynxEngine:onLoadFail");
        final a r103 = this.f40717i;     // Catch: Throwable -> L6
        r103.getClass();     // Catch: Throwable -> L6
        r103.z(new AnnieXDefaultLynxEngineClient$onEngineLoadFailed$1(r103, r102));     // Catch: Throwable -> L6
        HybridLogger.i("XResourceLoader", r102, null, 12);     // Catch: Throwable -> L6
        Map<String, d> r104 = MonitorManager.f40977a;     // Catch: Throwable -> L6
        MonitorManager.p(r100, r101, AbsBulletMonitorCallback.ErrStage.RL, r102, null);     // Catch: Throwable -> L6
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxEngine:onLoadFail");
        return;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxEngine:onLoadFail");
        throw th;
    }

    public AnnieXLynxEngine(String r100, MutableContextWrapper r101, t r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "contextWrapper");
        Intrinsics.checkNotNullParameter(r102, "builder");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        this.f40709a = r101;
        this.f40714f = System.currentTimeMillis();
        this.f40715g = 5;
        this.f40716h = 15000;
        this.f40719k = LazyKt.lazy(new AnnieXLynxEngine$argusDelegate$2(this));
        this.f40720l = r101.getResources().getConfiguration().orientation;
        TraceEvent.beginSection("LynxEngineBuilder.build");
        LynxTemplateRender r104 = new LynxTemplateRender(r102);
        TraceEvent.endSection("LynxEngineBuilder.build");
        this.f40710b = r104;
        a r105 = new a(r100, r103);
        this.f40717i = r105;
        r105.f40725j = true;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.lynx.tasm.LynxTemplateRender");
        r104.addLynxViewClient(r105);
    }
}
