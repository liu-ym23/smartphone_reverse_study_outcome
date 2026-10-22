package a30;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectEnableResultModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import dq2.r;
import fr2.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.g6;
import w20.ne;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends g6<ne, SetEffectEnableResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vy0.c f1512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f1513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1514c;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.revenue.service.effect.g {
        public b() {
        }

        @Override // com.bytedance.android.livesdk.revenue.service.effect.g
        public final void onResult(int r100) {
        }
    }

    public static final class c implements ca0.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f1515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f1516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ca0.i f1517c;

        @Override // ca0.h
        public final void onResult(int r100) {
            boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
            p11.i r102 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getLinkRegionService();
            if (this.f1516b == false) goto L9;
            if (r102 == null) goto L7;
            Pair<Integer, Integer> r103 = r102.getSurfaceSize();
            if (r103 == null) goto L7;
        L8:
            this.f1517c.k(r103.getFirst().intValue(), r103.getSecond().intValue(), this.f1516b);
            jy0.b.a("SetEffectEnableMethod", "setMixOutput, surfaceSize = " + r103);
        L7:
            r103 = new Pair(0, 0);
        L9:
            if (r102 == null) goto L11;
            Map<String, r> r104 = r102.getRevStreamRegions();
        L12:
            JSONObject r105 = new JSONObject();
            JSONArray r106 = new JSONArray();
            if (r104 == null) goto L18;
            Iterator<Map.Entry<String, r>> r107 = r104.entrySet().iterator();
        L16:
            if (r107.hasNext() == false) goto L18;
            Map.Entry<String, r> r108 = r107.next();
            JSONObject r109 = new JSONObject();
            r109.put("areaKey", r108.getValue().f469645a);
            r109.put("x", Float.valueOf(r108.getValue().f469646b));
            r109.put("y", Float.valueOf(r108.getValue().f469647c));
            r109.put("w", Float.valueOf(r108.getValue().f469648d));
            r109.put("h", Float.valueOf(r108.getValue().f469649e));
            Unit r110 = Unit.INSTANCE;
            r106.put(r109);
        L18:
            r105.put("LiveGrids", r106);
            String r111 = r105.toString();
            jy0.b.a("SetEffectEnableMethod", "renderCache = " + r111);
            this.f1517c.j(r111, this.f1516b);
            if (r100 != 0) goto L21;
            this.f1515a.k("enable success, callback result = " + r100);
            return;
        L21:
            this.f1515a.j("enable failure, callback result = " + r100);
            return;
        L11:
            r104 = null;
            goto L12
        }

        public c(j r100, boolean r101, ca0.i r102) {
            this.f1515a = r100;
            this.f1516b = r101;
            this.f1517c = r102;
        }
    }

    public static final class d implements ca0.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f1518a;

        public d(j r100) {
            this.f1518a = r100;
        }

        @Override // ca0.h
        public final void onResult(int r100) {
            this.f1518a.k("disable success, callback result = " + r100);
        }
    }

    public static final class e implements ca0.f {
        public e(j r100) {
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f1513b.dispose();
    }

    public j() {
        this.f1512a = (vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        this.f1513b = new CompositeDisposable();
        this.f1514c = new b();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f1513b.dispose();
    }

    public final void j(String r100) {
        jy0.b.c("SetEffectEnableMethod", "fail: " + r100, null, 4);
        SetEffectEnableResultModel r101 = new SetEffectEnableResultModel();
        r101.a(SetEffectEnableResultModel.Code.Failed);
        r101.c(r100);
        finishWithResult(r101);
    }

    public final void k(String r100) {
        jy0.b.d("SetEffectEnableMethod", "finish: " + r100);
        SetEffectEnableResultModel r101 = new SetEffectEnableResultModel();
        r101.a(SetEffectEnableResultModel.Code.Success);
        JsonObject r102 = new JsonObject();
        r102.addProperty("message", r100);
        Unit r103 = Unit.INSTANCE;
        r101.b(r102);
        finishWithResult(r101);
    }

    public final void l(ne r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        boolean r100 = m.e();
        boolean r101 = m.g();
        StringBuilder r102 = new StringBuilder("setUp, enable = ");
        r102.append(r110.a());
        r102.append(", scene = ");
        ne.a r103 = r110.b();
        Boolean r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.b();
    L6:
        r102.append(r105);
        r102.append(", isInit = ");
        r102.append(r100);
        r102.append(", isLiveCore = ");
        r102.append(r101);
        jy0.b.d("SetEffectEnableMethod", r102.toString());
        p11.i r106 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkRegionService();
        ne.a r107 = r110.b();
        if (r107 == null) goto L10;
        String r108 = r107.b();
        if (r108 == null) goto L10;
    L11:
        ne.a r109 = r110.b();
        if (r109 == null) goto L14;
        Integer r111 = r109.c();
    L15:
        ne.a r112 = r110.b();
        if (r112 == null) goto L18;
        Boolean r113 = r112.a();
    L19:
        Boolean r114 = Boolean.TRUE;
        boolean r115 = Intrinsics.areEqual(r113, r114);
        boolean r116 = true;
        if ((!Intrinsics.areEqual(r110.a(), r114)) == false) goto L26;
        if (r100 == false) goto L24;
        if (r106 == null) goto L24;
        r106.enableRenderFilter(r108, false, r115);
    L24:
        k("disable success, linkService = " + r106);
        return;
    L26:
        if (r100 == true) goto L28;
        ((com.bytedance.android.livesdk.revenue.service.effect.c) vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class)).providerResourceFinder();
        jy0.b.f("SetEffectEnableMethod", "resourceFilter is null", null, 4);
        return;
    L28:
        if (m.d() == false) goto L79;
        GiftContext r117 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r117 == null) goto L38;
        com.bytedance.live.datacontext.i<Map<String, CopyOnWriteArrayList<String>>> r118 = r117.getLoadedEffectResourceMap();
        if (r118 == null) goto L38;
        Map<String, CopyOnWriteArrayList<String>> r119 = r118.getValue();
        if (r119 == null) goto L38;
        CopyOnWriteArrayList<String> r120 = r119.get(r108);
        if (r120 == null) goto L38;
        int r121 = r120.size();
    L39:
        if (r121 <= 0) goto L79;
        jy0.b.a("SetEffectEnableMethod", "remove with delay");
        Intrinsics.checkNotNullParameter(r108, "scene");
        GiftContext r122 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r122 == null) goto L45;
        com.bytedance.live.datacontext.m<ca0.i> r123 = r122.getGiftRenderFilterWrapper();
        if (r123 == null) goto L45;
        ca0.i r124 = r123.getValue();
    L47:
        if (Intrinsics.areEqual(r108, "") == false) goto L54;
        if (r124 == null) goto L54;
        if (r124.d() != true) goto L54;
        if (r124.f() == true) goto L54;
    L78:
        n(this, "removeAndEnableWithDelay");
    L83:
        if (r111 != null) goto L85;
        return;
    L85:
        if (r111.intValue() == 0) goto L105;
        GiftContext r125 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r125 == null) goto L91;
        com.bytedance.live.datacontext.m<ca0.i> r126 = r125.getGiftRenderFilterWrapper();
        if (r126 == null) goto L91;
        ca0.i r127 = r126.getValue();
    L92:
        if (r127 != null) goto L94;
        return;
    L94:
        if (r111.intValue() == 1) goto L97;
        r116 = false;
    L97:
        ne.a r128 = r110.b();
        if (r128 == null) goto L100;
        r104 = r128.a();
    L100:
        r127.m(r116, r101, r108, Intrinsics.areEqual(r104, r114));
        return;
    L91:
        r127 = null;
        goto L92
    L105:
        return;
    L54:
        GiftContext r129 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r129 == null) goto L67;
        com.bytedance.live.datacontext.i<Map<String, CopyOnWriteArrayList<String>>> r130 = r129.getLoadedEffectResourceMap();
        if (r130 == null) goto L67;
        Map<String, CopyOnWriteArrayList<String>> r131 = r130.getValue();
        if (r131 == null) goto L67;
        CopyOnWriteArrayList<String> r132 = r131.get(r108);
        if (r132 == null) goto L67;
        Object[] r133 = r132.toArray(new String[0]);
        if (r133 == null) goto L66;
        String[] r134 = (String[]) r133;
    L68:
        if (r134 != null) goto L70;
    L77:
        RxUtilKt.c(Observable.timer(100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r108)), this.f1513b);
        goto L78
    L70:
        if (m.g() == false) goto L74;
        ca0.b r135 = m.c();
        jy0.b.a("SetEffectEnableMethod", "removeAndEnableWithDelay, isLiveCore = true, stickerHandler = " + r135);
        if (r135 == null) goto L77;
        r135.x(r134);
        goto L77
    L74:
        or2.a r136 = m.a();
        jy0.b.a("SetEffectEnableMethod", "removeAndEnableWithDelay, isLiveCore = false, livePlayerClient = " + r136);
        if (r136 == null) goto L77;
        ((or2.j) r136).h(r134, this.f1514c);
        goto L77
    L66:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L67:
        r134 = null;
    L45:
        r124 = null;
    L38:
        r121 = 0;
    L79:
        jy0.b.a("SetEffectEnableMethod", "remove");
        if (r106 == null) goto L82;
        kc0.i.a.a(r106, r108);
    L82:
        k("enable success, linkService = " + r106);
        goto L83
    L18:
        r113 = null;
        goto L19
    L14:
        r111 = null;
    L10:
        r108 = "";
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    public final void m(ne r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        StringBuilder r100 = new StringBuilder("setUpNew, enable = ");
        r100.append(r110.a());
        r100.append(", scene = ");
        ne.a r101 = r110.b();
        Boolean r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.b();
    L6:
        r100.append(r103);
        jy0.b.d("SetEffectEnableMethod", r100.toString());
        GiftContext r104 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r104 == null) goto L11;
        com.bytedance.live.datacontext.m<ca0.i> r105 = r104.getGiftRenderFilterWrapper();
        if (r105 == null) goto L11;
        ca0.i r106 = r105.getValue();
    L12:
        if (r106 != null) goto L15;
        j("giftRenderFilter is null");
        return;
    L15:
        boolean r111 = m.g();
        jy0.b.a("SetEffectEnableMethod", "isLiveCore = " + r111);
        if (r111 == false) goto L22;
        p r107 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLiveCore();
        if (r107 != null) goto L21;
        j("liveCore is null");
        return;
    L21:
        r106.e(new vc0.a(r107));
    L22:
        ne.a r108 = r110.b();
        if (r108 == null) goto L26;
        String r109 = r108.b();
        if (r109 == null) goto L26;
    L27:
        ne.a r112 = r110.b();
        if (r112 == null) goto L30;
        Integer r113 = r112.c();
    L31:
        Boolean r114 = r110.a();
        Boolean r115 = Boolean.TRUE;
        if (Intrinsics.areEqual(r114, r115) == false) goto L34;
        ca0.i.a.a(r106, true, new e(this), new c(this, r111, r106), r111, r109, 32);
        n(this, "giftRenderFilter.setEnable");
    L39:
        if (r113 != null) goto L41;
        return;
    L41:
        if (r113.intValue() == 0) goto L52;
        boolean r116 = true;
        if (r113.intValue() == 1) goto L46;
        r116 = false;
    L46:
        ne.a r117 = r110.b();
        if (r117 == null) goto L49;
        r102 = r117.a();
    L49:
        r106.m(r116, r111, r109, Intrinsics.areEqual(r102, r115));
        return;
    L52:
        return;
    L34:
        d r118 = new d(this);
        ne.a r119 = r110.b();
        if (r119 == null) goto L37;
        Boolean r120 = r119.a();
    L38:
        r106.l(false, null, r118, r111, r109, Intrinsics.areEqual(r120, r115));
        n(this, "giftRenderFilter.setEnable");
        goto L39
    L37:
        r120 = null;
        goto L38
    L30:
        r113 = null;
    L26:
        r109 = "";
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static void n(j r100, String r101) {
        r100.getClass();
        RxUtilKt.c(RxUtilKt.h(Observable.timer(10000, TimeUnit.MILLISECONDS)).subscribe(new l(r100, r101)), r100.f1513b);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ne r102 = (ne) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    L8:
        th = move-exception;
        finishWithFailure(th);
        return;
    L4:
        if (com.bytedance.android.livesdk.gift.platform.core.h.q() == false) goto L6;
        m(r102);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        l(r102);     // Catch: Throwable -> L8
        goto L11
    }
}
