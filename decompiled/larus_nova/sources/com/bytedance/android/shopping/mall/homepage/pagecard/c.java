package com.bytedance.android.shopping.mall.homepage.pagecard;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements mf3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PageCard f178304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f178305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f178306c;

    @Override // mf3.b
    public final void onAppBackground() {
        PageCard.e(this.f178304a, "ec.mallActionAppBackgroundForeground", MapsKt.mapOf(new Pair("isForeground", Boolean.FALSE)), 4);
    }

    @Override // mf3.b
    public final void onAppForeground() {
        PageCard.e(this.f178304a, "ec.mallActionAppBackgroundForeground", MapsKt.mapOf(new Pair("isForeground", Boolean.TRUE)), 4);
    }

    @Override // mf3.b
    public final void onDestroy() {
        PageCard r100 = this.f178304a;
        r100.getClass();
        Lazy r101 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.b.f47502b, "pageCard destroy");
        r100.f178270h = null;
        r100.f178269g = new ConcurrentHashMap();
        r100.f178271i.clear();
        r100.f178272j.clear();
        com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a r102 = (com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r100.f178268f.getValue();
        r102.getClass();
        String r103 = r102.f178316f;     // Catch: Exception -> L10
        if (r103 == null) goto L12;
        Iterator r104 = ((LinkedHashMap) r102.f178315e).entrySet().iterator();     // Catch: Exception -> L10
    L7:
        if (r104.hasNext() == false) goto L12;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L10
        int r106 = lk.b.f509538a;     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r103, "sceneID");     // Catch: Exception -> L10
    L12:
        if (r100.f178263a == null) goto L21;
        IVerseService r107 = ECLynxCard.f46500f;
        if (r107 == null) goto L22;
        r107.getMallDebugService();
        return;
    L22:
        return;
    }

    @Override // mf3.b
    public final void onRefresh() {
        PageCard.e(this.f178304a, "ec.mallActionRefresh", null, 6);
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardSchema");
        this.f178306c = r100;
        this.f178304a = new PageCard();
    }

    @Override // mf3.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        PageCard r101 = this.f178304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        if (r101.f178277o == true) goto L10;
        r101.f178263a = new ECLynxCard();
        r101.f178264b = r100;
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.b.f47502b, "pageCard init");
        if (((Number) r101.f178267e.getValue()).intValue() != 1) goto L8;
        com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a r103 = (com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r101.f178268f.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        r103.f178316f = r100;
        int r104 = lk.b.f509538a;
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        Intrinsics.checkNotNullParameter(r100, "sceneID");
    L8:
        r101.f178277o = true;
        return;
    }

    public final void f(String r100) {
        PageCard r101 = this.f178304a;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        ECLynxCard r102 = r101.f178263a;
        if (r102 == null) goto L10;
        int r103 = com.bytedance.android.ec.hybrid.card.api.d.f46381e;
        r102.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r100), true);
        return;
    }

    @Override // mf3.b
    public final void a(boolean r100, boolean r101) {
        Intrinsics.checkNotNullParameter("page", "source");
        PageCard r102 = this.f178304a;
        Map<String, ? extends Object> r103 = MapsKt.mapOf(new Pair[]{new Pair("visible", Boolean.valueOf(r100)), new Pair("source", "page"), new Pair("isFirstShow", Boolean.valueOf(r101))});
        r102.getClass();
        Intrinsics.checkNotNullParameter("pageVisibilityChange", "eventName");
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.b.f47502b, "sendPrivateEvent, eventName = pageVisibilityChange , params =" + b0.m(r103));
        if (r102.f178276n == true) goto L5;
        r102.f178272j.add(new Pair("pageVisibilityChange", r103));
        return;
    L5:
        ECLynxCard r105 = r102.f178263a;
        if (r105 == null) goto L10;
        r105.p("pageVisibilityChange", r103);
        return;
    }

    public final Map<String, Object> d(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "paramContext");
        PageCard r102 = this.f178304a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "paramsContext");
        if (r102.a() == false) goto L12;
        Object r103 = r101.get("tab_id");
        if ((r103 instanceof String) == true) goto L7;
        r103 = null;
    L7:
        String r104 = (String) r103;
        if (r104 != null) goto L10;
        r104 = "0";
    L10:
        r102.f178275m.f518946b.setTPullDynamicParamsStart(Long.valueOf(System.currentTimeMillis()));
        Map<String, Object> r105 = ((com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r102.f178268f.getValue()).a(r104, r100, r101);
        r102.f178275m.a(true, true);
        return r105;
    L12:
        return r102.f178269g.get(r100);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "dynamicParamsJson");
        this.f178304a.d("ec.mallDataApiRequestSuccess", MapsKt.mapOf(new Pair[]{new Pair("apiKey", r100), new Pair("dynamicString", r101)}), true);
    }

    public final void g(List<String> r210, Map<String, ? extends Object> r211, long r212, Function0<Unit> r213) {
        Intrinsics.checkNotNullParameter(r210, "apiKeys");
        Intrinsics.checkNotNullParameter(r211, "paramContext");
        Intrinsics.checkNotNullParameter(r213, "onFinishCallBack");
        PageCard r100 = this.f178304a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "apiKeys");
        Intrinsics.checkNotNullParameter(r211, "paramContext");
        Intrinsics.checkNotNullParameter(r213, "onFinishCallBack");
        Lazy r101 = ECMallLogUtil.f47441a;
        k.b r102 = k.b.f47502b;
        ECMallLogUtil.c(r102, "pagecard asyncGetDynamicParams  : " + r210);
        r100.f178275m.f518946b.setTPullDynamicParamsStart(Long.valueOf(System.currentTimeMillis()));
        Function0<Unit> r103 = r100.f178270h;
        if (r103 == null) goto L5;
        r103.invoke();
        r100.f178275m.a(false, false);
        ECMallLogUtil.c(r102, "pagecard asyncGetDynamicParams 被重复触发,执行兜底保障");
    L5:
        r100.f178270h = r213;
        long r110 = System.currentTimeMillis();
        String r104 = r100.f178264b;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.mallDataGetApiParams", r110, r104, false, MapsKt.mapOf(new Pair[]{new Pair("apiKeys", r210), new Pair("paramContext", b0.m(r211))}), false, 32));
        r100.f178273k = Observable.timer(r212, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r100, r210));
    }

    @Override // mf3.b
    public final void b(Context r110, Lifecycle r111, ViewGroup r112, Map<String, ? extends Object> r113, String r114, Map<String, String> r210, Map<String, ? extends Object> r211, String r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r112, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r113, "globalProps");
        Intrinsics.checkNotNullParameter(r114, "bid");
        Intrinsics.checkNotNullParameter(r210, "consumerMonitor");
        Intrinsics.checkNotNullParameter(r212, "initData");
        if (this.f178305b == true) goto L6;
        this.f178304a.b(r110, r112, r111, this.f178306c, false, r113, r114, r210, r211, r212, r213);
        this.f178305b = true;
        return;
    }
}
