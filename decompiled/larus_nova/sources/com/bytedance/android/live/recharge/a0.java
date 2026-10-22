package com.bytedance.android.live.recharge;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.r;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.depend.model.IDiamondRenderDataInfo;
import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.ReplaySubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 {
    public final PropertyOwner A;
    public final PropertyOwner<com.bytedance.android.live.recharge.deal.i> B;
    public final PropertyOwner C;
    public final ReplaySubject<Throwable> D;
    public final ReplaySubject E;
    public final ReplaySubject F;
    public final ReplaySubject G;
    public final ReplaySubject H;
    public final ReplaySubject I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89596J;
    public final PropertyOwner<Boolean> K;
    public final PropertyOwner L;
    public final PropertyOwner<Map<Long, com.bytedance.android.live.recharge.model.diamond.e>> M;
    public final PropertyOwner<Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> N;
    public final PropertyOwner<Map<Long, String>> O;
    public final PropertyOwner<com.bytedance.android.live.recharge.platform.model.f> P;
    public final PropertyOwner Q;
    public final ReplaySubject<Integer> R;
    public boolean S;
    public boolean T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f89597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner<Long> f89598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner f89599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner f89601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner<List<com.bytedance.android.live.recharge.deal.d>> f89602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner f89603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner<List<Long>> f89604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner f89605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PropertyOwner<List<com.bytedance.android.live.recharge.deal.f>> f89606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PropertyOwner f89607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PropertyOwner<ExchangeInfo> f89608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PropertyOwner f89609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PropertyOwner<Long> f89610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PropertyOwner f89611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PropertyOwner f89613q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PropertyOwner<Map<Long, IRenderDataInfoBase>> f89614r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PropertyOwner f89615s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89616t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PropertyOwner f89617u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89618v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PropertyOwner f89619w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89620x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final PropertyOwner f89621y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PropertyOwner<Boolean> f89622z;

    public static final class a {
    }

    static {
    }

    public a0() {
        this.f89597a = new CompositeDisposable();
        PropertyOwner<Long> r100 = new PropertyOwner(0L);
        this.f89598b = r100;
        this.f89599c = r100;
        Boolean r101 = Boolean.FALSE;
        PropertyOwner<Boolean> r102 = new PropertyOwner(r101);
        this.f89600d = r102;
        this.f89601e = r102;
        PropertyOwner<List<com.bytedance.android.live.recharge.deal.d>> r103 = new PropertyOwner(CollectionsKt.emptyList());
        this.f89602f = r103;
        this.f89603g = r103;
        PropertyOwner<List<Long>> r104 = new PropertyOwner(CollectionsKt.emptyList());
        this.f89604h = r104;
        this.f89605i = r104;
        PropertyOwner<List<com.bytedance.android.live.recharge.deal.f>> r105 = new PropertyOwner(CollectionsKt.emptyList());
        this.f89606j = r105;
        this.f89607k = r105;
        PropertyOwner<ExchangeInfo> r106 = new PropertyOwner(new ExchangeInfo(-1, -1, false, null, 0, 0, 0, 0, 0, 0, false, false, 0, false, 0, 32764, null));
        this.f89608l = r106;
        this.f89609m = r106;
        PropertyOwner<Long> r107 = new PropertyOwner(0L);
        this.f89610n = r107;
        this.f89611o = r107;
        PropertyOwner<Boolean> r108 = new PropertyOwner(r101);
        this.f89612p = r108;
        this.f89613q = r108;
        PropertyOwner<Map<Long, IRenderDataInfoBase>> r109 = new PropertyOwner(new LinkedHashMap());
        this.f89614r = r109;
        this.f89615s = r109;
        PropertyOwner<Boolean> r110 = new PropertyOwner(r101);
        this.f89616t = r110;
        this.f89617u = r110;
        PropertyOwner<Boolean> r111 = new PropertyOwner(r101);
        this.f89618v = r111;
        this.f89619w = r111;
        PropertyOwner<Boolean> r112 = new PropertyOwner(r101);
        this.f89620x = r112;
        this.f89621y = r112;
        PropertyOwner<Boolean> r113 = new PropertyOwner(r101);
        this.f89622z = r113;
        this.A = r113;
        PropertyOwner<com.bytedance.android.live.recharge.deal.i> r114 = new PropertyOwner(r.f89735b);
        this.B = r114;
        this.C = r114;
        this.D = ReplaySubject.a();
        this.E = ReplaySubject.a();
        this.F = ReplaySubject.a();
        this.G = ReplaySubject.a();
        this.H = ReplaySubject.a();
        this.I = ReplaySubject.a();
        this.f89596J = new PropertyOwner(r101);
        PropertyOwner<Boolean> r115 = new PropertyOwner(r101);
        this.K = r115;
        this.L = r115;
        this.M = new PropertyOwner(MapsKt.emptyMap());
        this.N = new PropertyOwner(MapsKt.emptyMap());
        this.O = new PropertyOwner(new LinkedHashMap());
        PropertyOwner<com.bytedance.android.live.recharge.platform.model.f> r116 = new PropertyOwner(new com.bytedance.android.live.recharge.platform.model.f(0));
        this.P = r116;
        this.Q = r116;
        this.R = ReplaySubject.a();
    }

    public final void a() {
        this.f89596J.a(Boolean.TRUE);
        PropertyOwner<Boolean> r100 = this.f89616t;
        Boolean r101 = Boolean.FALSE;
        r100.a(r101);
        this.f89618v.a(r101);
    }

    public final boolean d() {
        Iterator r100 = ((Iterable) this.f89607k.f64752a).iterator();
    L3:
        boolean r101 = false;
    L5:
        if (r100.hasNext() == false) goto L9;
        if (((com.bytedance.android.live.recharge.deal.f) r100.next()).h() <= 0) goto L3;
        r101 = true;
        goto L5
    L9:
        return r101;
    }

    public final void b() {
        com.bytedance.android.live.recharge.core.f.d(RechargeServices.b()).getClass();
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        Integer r103 = 2;
        String r104 = r103.toString();
        Intrinsics.checkNotNullParameter(SoloKtvContext.SOLO_PAGE_ENTRANCE, "$this$setTo");
        if (r104 == null) goto L5;
        r102.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, r104);
    L5:
        Integer r105 = 1;
        String r106 = r105.toString();
        Intrinsics.checkNotNullParameter("type", "$this$setTo");
        if (r106 == null) goto L8;
        r102.put("type", r106);
    L8:
        com.bytedance.android.live.revenue.common.x.a(r101, false);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/diamond/extra/", TypesJVMKt.getJavaType(Reflection.typeOf(DiamondExtraListResult.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c).map(com.bytedance.android.live.recharge.platform.service.f.f90298a).compose(RxUtil.rxSchedulerHelper()).singleOrError().subscribe(new f0(this), new g0(this)), this.f89597a);
    }

    public final void e(com.bytedance.android.live.recharge.deal.i r110, boolean r111) {
        String r100 = "0";
        boolean r101 = false;
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == true) goto L5;
    L39:
        this.f89602f.a(r110.k());
        this.f89604h.a(r110.a());
        this.f89606j.a(r110.c());
        PropertyOwner<Boolean> r102 = this.f89600d;
        if (r110.b() == true) goto L42;
    L44:
        boolean r103 = false;
    L45:
        r102.a(Boolean.valueOf(r103));
        this.f89598b.a(Long.valueOf(r110.d()));
        this.B.a(r110);
        PropertyOwner<Boolean> r104 = this.f89612p;
        IOneKeyPay r105 = r110.f();
        if (r105 == null) goto L48;
        boolean r106 = r105.getSupportOneKeyPay();
    L49:
        r104.a(Boolean.valueOf(r106));
        this.f89620x.a(Boolean.valueOf(r110.m()));
        PropertyOwner<Boolean> r107 = this.f89616t;
        IPrePayCashierInfo r108 = r110.n();
        if (r108 != null) goto L52;
    L54:
        boolean r109 = false;
    L55:
        r107.a(Boolean.valueOf(r109));
        PropertyOwner<Boolean> r112 = this.f89618v;
        IPrePayCashierInfo r113 = r110.n();
        if (r113 != null) goto L58;
    L60:
        boolean r114 = false;
    L61:
        r112.a(Boolean.valueOf(r114));
        PropertyOwner<Map<Long, IRenderDataInfoBase>> r115 = this.f89614r;
        IPrePayCashierInfo r116 = r110.n();
        if (r116 == null) goto L67;
        Map<Long, IDiamondRenderDataInfo> r117 = r116.getRenderDataMap();
        if (r117 == null) goto L67;
        Map<Long, IRenderDataInfoBase> r118 = MapsKt.toMutableMap(r117);
        if (r118 == null) goto L67;
    L68:
        r115.a(r118);
        this.f89622z.a(Boolean.valueOf(r111));
        PropertyOwner<Boolean> r119 = this.K;
        if (r110.e() != 1) goto L71;
        r101 = true;
    L71:
        r119.a(Boolean.valueOf(r101));
        qw0.a r120 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r120 == null) goto L89;
        r120.Ue(rw0.f.class, new rw0.e(new rw0.f(r110)));
        if (this.f89612p.f64752a.booleanValue() == false) goto L76;
        String r121 = "1";
    L78:
        if (this.f89612p.f64752a.booleanValue() == true) goto L80;
    L82:
        r120.Ue(rw0.c.class, new rw0.d(new rw0.c(r121, r100)));
        return;
    L80:
        if (com.bytedance.android.live.recharge.util.g.a().a() == false) goto L82;
        r100 = "1";
        goto L82
    L76:
        r121 = "0";
        goto L78
    L89:
        return;
    L67:
        r118 = new LinkedHashMap();
        goto L68
    L58:
        if (r113.getBatchQueryInfo() != 1) goto L60;
        r114 = true;
        goto L61
    L52:
        if (r108.getOneStepPay() != 1) goto L54;
        r109 = true;
        goto L55
    L48:
        r106 = false;
        goto L49
    L42:
        if (com.bytedance.android.live.recharge.utils.j.c() == true) goto L44;
        r103 = true;
        goto L45
    L5:
        if (this.S == false) goto L39;
        if (r111 == true) goto L39;
        if (this.B.f64752a.c().isEmpty() == true) goto L39;
        if (r110.c().isEmpty() == true) goto L39;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L37
        List<com.bytedance.android.live.recharge.deal.u> r123 = this.B.f64752a.c();     // Catch: Throwable -> L37
        if (r123.size() != r110.c().size()) goto L15;
        boolean r124 = true;
    L16:
        if (r124 == true) goto L19;
        r123 = null;
    L19:
        if (r123 == null) goto L30;
        Iterator<T> r125 = r123.iterator();     // Catch: Throwable -> L37
        boolean r126 = false;
        int r127 = 0;
    L22:
        if (r125.hasNext() == false) goto L31;
        Object r128 = r125.next();     // Catch: Throwable -> L37
        int r129 = r127 + 1;     // Catch: Throwable -> L37
        if (r127 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L37
    L27:
        if (((com.bytedance.android.live.recharge.deal.u) ListProtector.get(r110.c(), r127)).f89764b == ((com.bytedance.android.live.recharge.deal.u) r128).f89764b) goto L29;
        r126 = true;
    L29:
        r127 = r129;
    L31:
        int r130 = com.bytedance.android.live.recharge.utils.m.f90492a;     // Catch: Throwable -> L37
        HashMap r131 = new HashMap();     // Catch: Throwable -> L37
        if (r126 == false) goto L34;
        Object r132 = "0";
    L35:
        r131.put("ui_change", r132);     // Catch: Throwable -> L37
        com.bytedance.android.live.recharge.utils.f.c("livesdk_rd_recharge_ui_change", r131);     // Catch: Throwable -> L37
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
        goto L39
    L34:
        r132 = "1";
        goto L35
    L30:
        r126 = true;
        goto L31
    L15:
        r124 = false;
    L37:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    }

    public final Single<IQueryPrePayCashierData> c(long r100, List<Long> r110, com.bytedance.android.live.recharge.model.d r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "priceList");
        Intrinsics.checkNotNullParameter(r111, "entranceParams");
        com.bytedance.android.live.recharge.model.diamond.e r101 = this.M.f64752a.get(Long.valueOf(r100));
        if (r101 == null) goto L8;
        String r102 = r101.getCouponInfo();
        if (r102 == null) goto L8;
        String r103 = r102;
    L9:
        Map<Long, String> r104 = this.O.f64752a;
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r105 = this.N.f64752a;
        LinkedHashMap r106 = new LinkedHashMap(MapsKt.mapCapacity(r105.size()));
        Iterator<T> r107 = r105.entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L16;
        Map.Entry r108 = (Map.Entry) r107.next();
        Object r109 = r108.getKey();
        String r113 = ((com.bytedance.android.live.recharge.platform.business.model.diamond.g) r108.getValue()).getPreCalcInfo();
        if (r113 != null) goto L15;
        r113 = "";
    L15:
        r106.put(r109, r113);
        goto L11
    L16:
        RechargeBizScene r114 = com.bytedance.android.live.recharge.panel.b.a(r111);
        com.bytedance.android.live.recharge.platform.service.h r115 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());
        String r116 = r111.f90019h;
        r115.getClass();
        Single r117 = com.bytedance.android.live.recharge.platform.service.h.E1(r110, r116, r103, r104, r106, r114);
        int r118 = qw0.c.f534955a;
        Intrinsics.checkNotNullParameter(r110, "priceList");
        return r117.compose(new qw0.b(r110, r112));
    L8:
        r103 = "";
        goto L9
    }
}
