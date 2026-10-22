package com.bytedance.android.ec.hybrid.anniex;

import android.net.Uri;
import android.os.Handler;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.forest.model.Response;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import yj.k;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends com.bytedance.android.anniex.ui.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IECLynxCardLifeCycle> f46282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f46283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f46284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f46285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f46286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f46287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f46288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f46289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final xj.a f46290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IECLynxCardLifeCycle f46291j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f46292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Response f46293b;

        public b(h r100, Response r101) {
            this.f46292a = r100;
            this.f46293b = r101;
        }

        public final void a() {
            Lazy r100 = HybridAppInfoService.f47530a;
            if (HybridAppInfoService.m() == false) goto L5;
            String r101 = "tobsdk_livesdk_ec_lynx_card_resource_monitor";
        L6:
            JSONObject r102 = new JSONObject();
            r102.putOpt("channel", this.f46293b.f244315q.getGeckoModel().f244349b);     // Catch: JSONException -> L9
            r102.putOpt("bundle", this.f46293b.f244315q.getGeckoModel().f244350c);     // Catch: JSONException -> L9
            r102.putOpt("is_preload", Boolean.valueOf(this.f46293b.f244309k));     // Catch: JSONException -> L9
            r102.putOpt("res", Boolean.valueOf(this.f46293b.f244316r));     // Catch: JSONException -> L9
            r102.putOpt("from", this.f46293b.f244319u);     // Catch: JSONException -> L9
            r102.putOpt("page_name", this.f46292a.f46288g);     // Catch: JSONException -> L9
            r102.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, this.f46292a.f46289h);     // Catch: JSONException -> L9
            r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: JSONException -> L9
        L10:
            IHybridHostService r103 = com.bytedance.android.ec.hybrid.a.h();
            if (r103 == null) goto L18;
            k r104 = r103.getIHybridHostEventService();
            if (r104 == null) goto L19;
            r104.logV3(r101, r102);
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r101 = "ec_lynx_card_resource_monitor";
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.anniex.ui.e.a
    public final void onDestroy() {
        Iterator r100 = ((ArrayList) this.f46282a).iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        ((IECLynxCardLifeCycle) r100.next()).onDestroy();
        goto L4
    L7:
        if (((Boolean) ECHybridSettings.f46246b.getValue()).booleanValue() == false) goto L11;
        u();
        return;
    }

    public final void u() {
        Long r100 = this.f46284c;
        if (r100 == null) goto L6;
        r100.longValue();
        ((Handler) this.f46286e.getValue()).removeCallbacks((Runnable) this.f46285d.getValue());
        return;
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void e(AnnieXLynxView r100) {
        Iterator r101 = ((ArrayList) this.f46282a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r101.next()).onFirstScreen();
        goto L4
    L6:
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "on first screen schema " + this.f46287f);
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void onTimingSetup(Map<String, Object> r100) {
        if (r100 == null) goto L17;
        int r101 = com.bytedance.android.ec.hybrid.card.util.f.f46602a;
        xj.a r102 = this.f46290i;
        String r103 = this.f46287f;
        if (r102 == null) goto L7;
        com.bytedance.android.ec.hybrid.card.util.a.a(new com.bytedance.android.ec.hybrid.card.util.d(r102, System.currentTimeMillis(), r103));
    L7:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(r100);
        xj.a r105 = this.f46290i;
        if (r105 == null) goto L10;
        r104.put("ec_session", r105);
    L10:
        Iterator r106 = ((ArrayList) this.f46282a).iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        IECLynxCardLifeCycle r107 = (IECLynxCardLifeCycle) r106.next();
        r107.onTimingSetup(r104);
        r107.onTimingSetupPref(null);
        goto L12
    L14:
        int r108 = com.bytedance.android.ec.hybrid.card.util.f.f46602a;
        return;
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void p(AnnieXLynxView r100) {
        Iterator r101 = ((ArrayList) this.f46282a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r101.next()).onRuntimeReady();
        goto L4
    L6:
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "on run time ready schema " + this.f46287f);
    }

    @Override // com.bytedance.android.anniex.ui.e.a
    public final void s(String r100) {
        u();
        Iterator r101 = ((ArrayList) this.f46282a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r101.next()).onLoadFailed(ECLynxCardErrorType.FAILED, -1, "");
        goto L4
    }

    @Override // com.bytedance.android.anniex.ui.e.a
    public final void t(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        if (r100.f244309k == false) goto L8;
        Iterator r101 = ((ArrayList) this.f46282a).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((IECLynxCardLifeCycle) r101.next()).useCache(IECLynxCardLifeCycle.ECLynxCardCacheType.GECKO_CACHE);
    L8:
        Lazy r102 = ECLynxAnnieXCompat.f46251a;
        Integer r103 = this.f46289h;
        Intrinsics.checkNotNullParameter(r100, "response");
        if (r103 == null) goto L24;
        r103.intValue();
        if (ECLynxAnnieXExperiment.b() == false) goto L24;
        int r104 = r103.intValue();
        if (ECLynxAnnieXExperiment.c().f46260a == true) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L24;
        Lazy r106 = ECLynxAnnieXCompat.f46256f;
        if (((ConcurrentHashMap) r106.getValue()).containsKey(r103) == true) goto L24;
        TemplateBundle r107 = TemplateBundle.b(r100.j());
        if (r107 == null) goto L24;
        ((ConcurrentHashMap) r106.getValue()).put(r103, r107);
        goto L24
    L15:
        if (ECLynxAnnieXExperiment.c().f46270k.contains(Integer.valueOf(r104)) == false) goto L17;
        r105 = true;
    L24:
        com.bytedance.android.ec.hybrid.card.util.a.a(new b(this, r100));
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void d(Uri r100, AnnieXLynxView r101) {
        u();
        Iterator r102 = ((ArrayList) this.f46282a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r102.next()).onLoadSuccess();
        goto L4
    L6:
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "lynx load success, schema: " + this.f46287f);
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void g(AnnieXLynxView r100, LynxError r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "lynx received error: schema=" + this.f46287f + ", code=" + r101.getErrorCode() + ", message=" + r101.getMsg());
        Iterator r103 = ((ArrayList) this.f46282a).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        ((IECLynxCardLifeCycle) r103.next()).onReceivedError(new com.bytedance.lynx.service.model.b(r101.getErrorCode(), r101.getMsg()));
        goto L6
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void m(AnnieXLynxView r100, JSONObject r101) {
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "on first load perf ready schema " + this.f46287f);
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void n(Uri r100, AnnieXLynxView r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Long r102 = this.f46284c;
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
        ((Handler) this.f46286e.getValue()).postDelayed((Runnable) this.f46285d.getValue(), r103);
    L5:
        Iterator r104 = ((ArrayList) this.f46282a).iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((IECLynxCardLifeCycle) r104.next()).onLoadStart();
        goto L7
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void onTemplateReady(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "resFrom");
        this.f46283b.put("res_from", r100);     // Catch: JSONException -> L5
        this.f46283b.put("is_memory", r101);     // Catch: JSONException -> L5
        return;
    }

    @Override // com.bytedance.android.anniex.ui.e.a, com.bytedance.android.anniex.ui.e
    public final void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        Iterator r103 = ((ArrayList) this.f46282a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((IECLynxCardLifeCycle) r103.next()).onTimingUpdatePref(null);
        goto L4
    L6:
        int r104 = com.bytedance.android.ec.hybrid.card.util.f.f46602a;
    }

    public h(String r100, String r101, Integer r102, xj.a r103, com.bytedance.android.ec.hybrid.card.util.k r104, xj.b r105, Long r106) {
        this.f46287f = r100;
        this.f46288g = r101;
        this.f46289h = r102;
        this.f46290i = r103;
        this.f46291j = r105;
        ArrayList r107 = new ArrayList();
        this.f46282a = r107;
        this.f46283b = new JSONObject();
        if (r105 == null) goto L5;
        r107.add(r105);
    L5:
        this.f46284c = r106;
        this.f46285d = LazyKt.lazy(new ECLynxAnnieXLifeCycle$timeoutNotifier$2(this));
        this.f46286e = LazyKt.lazy(ECLynxAnnieXLifeCycle$mainHandler$2.INSTANCE);
    }
}
