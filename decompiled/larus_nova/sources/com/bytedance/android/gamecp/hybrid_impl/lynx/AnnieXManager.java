package com.bytedance.android.gamecp.hybrid_impl.lynx;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.hybrid_impl.jsb.jsbfinder.Jsb2MethodFinder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateData;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wu.m4;
import wu.p3;

/* JADX INFO: loaded from: classes44.dex */
public final class AnnieXManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f57562a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f57563b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, com.bytedance.ies.web.jsbridge2.f.b> f57564c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> f57565d = null;

    public AnnieXManager() {
    }

    static {
        f57562a = new AtomicBoolean(false);
        f57563b = new AtomicBoolean(false);
        f57564c = new LinkedHashMap();
        f57565d = new LinkedHashMap();
    }

    public static final void b() {
        AtomicBoolean r100 = f57563b;
        if (r100.get() == true) goto L7;
        yr.b.b(4, "GameCpAnnieXManager", "registerMethodToLive");
        g r101 = new g();
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().K(r101);
        r100.compareAndSet(false, true);
        return;
    }

    public static void d(Context r100) {
        AtomicBoolean r101 = f57562a;
        if (r101.get() == false) goto L5;
        return;
    L5:
        long r102 = System.currentTimeMillis();
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().initAnnie();
        yr.b.b(4, "GameCpAnnieXManager", "initAnnie duration: " + (System.currentTimeMillis() - r102));
        com.bytedance.android.anniex.assemble.a.f40251a.c(r100);
        yr.b.b(4, "GameCpAnnieXManager", "initAnnie + ensureLynxInitialized duration: " + (System.currentTimeMillis() - r102));
        yr.b.b(4, "GameCpAnnieXManager", "initAnnie + ensureLynxInitialized + initMethod duration: " + (System.currentTimeMillis() - r102));
        r101.compareAndSet(false, true);
    }

    public static final void a(AnnieXLynxView r100, final Function1 r110) {
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getContextProviderFactory();
        final m16.b r101 = new m16.b();
        if (p3.f561369a.getValue().c() == false) goto L5;
        ThreadsKt.thread$default(false, false, null, null, 0, new AnnieXManager$registerActionInvoke$1(r110, r101), 31, null);
        return;
    L5:
        r110.invoke(r101);
    }

    public static AnnieXLynxView c(Context r310, String r311, Map r312, final Map r410, final Map r411, String r412, Function1 r413, jw.a r414) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "schema");
        if (f57562a.get() == true) goto L5;
        yr.b.b(4, "GameCpAnnieXManager", "createAnnieXLynxView hasInit = false");
        d(r310);
        UtilityKotlinExtentionsKt.g(0, false, false, AnnieXManager$createAnnieXLynxView$1.INSTANCE, 7);
    L5:
        long r110 = System.currentTimeMillis();
        Uri r100 = UriProtector.parse(r311);
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().m1(r100);
        LinkedHashMap r101 = new LinkedHashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        String r103 = UriProtector.getQueryParameter(r100, "url");     // Catch: Throwable -> L11
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r101.put("location", r103);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(r101);
        ra.b r111 = ra.b.B.c(r100);
        ArrayList r105 = new ArrayList();
        Iterator<Object> r106 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getBehaviorList().iterator();
    L15:
        if (r106.hasNext() == false) goto L19;
        Object r112 = r106.next();
        if ((r112 instanceof com.lynx.tasm.behavior.a) == false) goto L15;
        r105.add(r112);
        goto L15
    L19:
        r105.addAll(GameCpBehaviorProvider.getBehaviorList());
        com.bytedance.android.anniex.api.d r107 = new com.bytedance.android.anniex.api.d("webcast", r104, ra.b.b(r111, false, null, null, null, 0, 0, 0.0f, false, false, null, false, r105, null, false, false, false, null, false, 0.0f, 16769023), 8);
        if (r312 != null) goto L22;
    L24:
        TemplateData r113 = null;
    L25:
        ra.a r114 = com.bytedance.android.anniex.api.d.g(r107, r100, r113, r101, 16);
        int r108 = com.bytedance.android.anniex.api.b.f40245a;
        AnnieXLynxView r109 = com.bytedance.android.anniex.api.b.e(r310, r114);
        final Jsb2MethodFinder r115 = new Jsb2MethodFinder();
        Function1<m16.b, Unit> r116 = new AnnieXManager$createAnnieXLynxViewInner$registerMethodAction$1(r410, r115, r411);
        r109.n(r115, 0);
        com.bytedance.android.gamecp.common.setting.config.q1 r117 = m4.f561352a.getValue();
        if (r117.a() == true) goto L32;
        yr.c.b("HybridCardRecyclePool", "hookImageInterceptor: fail, switch is close.");
        if (r414 != null) goto L30;
        com.bytedance.android.anniex.ui.e r118 = null;
    L31:
        ra.a r119 = r114;
    L58:
        if ((r118 instanceof r1) == false) goto L61;
        if (r413 == null) goto L61;
        Unit r120 = (Unit) r413.invoke(new Triple(Boolean.TRUE, "success", r118));
    L61:
        r109.E(r119, Long.valueOf(r110));
        r109.A(r119, null, r118);
        yr.b.b(4, "GameCpAnnieXManager", "createAnnieXLynxView duration:  " + (System.currentTimeMillis() - r110));
        return r109;
    L30:
        r118 = new a(r414, r116);
        goto L31
    L32:
        Map<String, com.bytedance.android.gamecp.common.setting.config.r1> r121 = r117.d();
        if (r121 == null) goto L35;
        com.bytedance.android.gamecp.common.setting.config.r1 r122 = r121.get(r412);
    L36:
        if (r122 != null) goto L38;
    L53:
        r119 = r114;
        yr.c.b("HybridCardRecyclePool", "hookImageInterceptor: fail, memory switch is close.");
        if (r414 != null) goto L56;
        r118 = null;
        goto L58
    L56:
        r118 = new a(r414, r116);
        goto L58
    L38:
        if (r122.b() != true) goto L53;
        LinkedHashMap r123 = new LinkedHashMap();
        if (r312 == null) goto L49;
        Iterator r124 = r312.entrySet().iterator();
    L44:
        if (r124.hasNext() == false) goto L49;
        Map.Entry r125 = (Map.Entry) r124.next();
        Object r126 = r125.getValue();
        if (r126 == null) goto L44;
        r123.put(r125.getKey(), r126);
    L49:
        if (r412 != null) goto L51;
        String r127 = "";
    L52:
        r119 = r114;
        r118 = new b(r109, r116, r123, r414, r127, r122, r123);
        goto L58
    L51:
        r127 = r412;
        goto L52
    L35:
        r122 = null;
        goto L36
    L22:
        if ((!r312.isEmpty()) != true) goto L24;
        r113 = TemplateData.fromMap(r312);
    L11:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
