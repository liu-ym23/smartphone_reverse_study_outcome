package com.bytedance.android.live.recharge.panel.context;

import android.content.Context;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.k;
import com.bytedance.android.live.recharge.deal.l;
import com.bytedance.android.live.recharge.deal.r;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.o;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vw0.g;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f90170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f90171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f90172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f90173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f90174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f90175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<Unit> f90176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f90177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.model.d f90178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f90179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.trace.session.a f90180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f90181l;

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final void h() {
        this.f90177h = null;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.model.d a() {
        return this.f90178i;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final a b() {
        return this.f90175f;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final PublishSubject<Unit> c() {
        return this.f90176g;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.c d() {
        return this.f90174e;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final String e() {
        return this.f90177h;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.b<Order> f() {
        return this.f90172c;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.revenue.common.reactive.e g() {
        return this.f90171b;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final CompositeDisposable getCd() {
        return this.f90170a;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final com.bytedance.android.live.recharge.trace.session.a getSession() {
        return this.f90180k;
    }

    @Override // com.bytedance.android.live.recharge.panel.context.c
    public final Context i() {
        return this.f90181l;
    }

    public f(com.bytedance.android.live.recharge.model.d r110, g r111, com.bytedance.android.live.recharge.trace.session.a r112, Context r113) {
        Intrinsics.checkNotNullParameter(r110, "entranceParams");
        Intrinsics.checkNotNullParameter(r111, "rechargeCommonParams");
        Intrinsics.checkNotNullParameter(r112, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r113, "androidContext");
        this.f90178i = r110;
        this.f90179j = r111;
        this.f90180k = r112;
        this.f90181l = r113;
        this.f90170a = new CompositeDisposable();
        Intrinsics.checkNotNullParameter(this, "panelContext");
        com.bytedance.android.live.recharge.deal.a r114 = com.bytedance.android.live.recharge.core.f.c(RechargeServices.b()).o0();
        if (com.bytedance.android.live.recharge.model.g.f90033a.j1() == true) goto L5;
    L64:
        com.bytedance.android.live.recharge.deal.a r115 = l.f89720a;
        jy0.b.a("Recharge/DealSetMemoryCache", "clear cache");
        Object r116 = null;
        l.f89720a = null;
        Object r117 = r.f89735b;
    L65:
        this.f90171b = new com.bytedance.android.live.revenue.common.reactive.c(r117);
        this.f90172c = new com.bytedance.android.live.revenue.common.reactive.c(r116);
        this.f90173d = Long.MAX_VALUE;
        this.f90174e = new com.bytedance.android.live.revenue.common.reactive.c(r116);
        this.f90175f = new a(this);
        int r118 = o.f267521a;
        this.f90176g = PublishSubject.create();
        return;
    L5:
        if (com.bytedance.android.live.recharge.deal.c.a(r114) == false) goto L64;
        Intrinsics.checkNotNullParameter(r110, "$this$isEnableCache");
        if (r110.f90026o.length() != 0) goto L9;
        boolean r119 = true;
    L10:
        if (r119 == false) goto L64;
        int r120 = com.bytedance.android.live.recharge.deal.b.f89704a;
        Intrinsics.checkNotNullParameter(r114, "cachedDealSet");
        Intrinsics.checkNotNullParameter(this, "panelContext");
        i r100 = r114.f89694b;
        long r121 = r110.f90015d * 10;
        if (r121 <= 0) goto L60;
        cy0.e.f465759a.getClass();
        j r122 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r123 = m.b(r122).b(wh6.a.class);
        Intrinsics.checkNotNull(r123);
        if (((wh6.a) ((com.bytedance.live.kmp.core.c) r123)).isPersonalRecommendOn() == true) goto L17;
        String r124 = "推荐";
    L18:
        long r101 = 100;
        if (r121 > 100) goto L22;
    L28:
        u r125 = com.bytedance.android.live.recharge.deal.dto.a.a((int) r101, r124);
        List r102 = CollectionsKt.toMutableList(r100.c());
        Iterator r126 = r102.iterator();
    L30:
        if (r126.hasNext() == false) goto L37;
        Object r127 = r126.next();
        if (((u) r127).f89765c != r125.f89765c) goto L34;
        boolean r128 = true;
    L35:
        if (r128 == false) goto L30;
    L38:
        u r129 = (u) r127;
        if (r129 != null) goto L41;
        r129 = (u) CollectionsKt.first(r102);
    L41:
        r102.remove(r129);
        ListProtector.add(r102, 0, r125);
        int r130 = k.f89719a;
        Long r103 = Long.valueOf(r125.f89764b);
        Long r104 = Long.valueOf(r125.f89764b);
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r131 = r100.getPanelExtraInfo();
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r132 = r131.entrySet().iterator();
    L43:
        if (r132.hasNext() == false) goto L50;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r133 = r132.next();
        if (r133.getKey().longValue() == r129.f89765c) goto L47;
        boolean r134 = true;
    L48:
        if (r134 == false) goto L43;
        r105.put(r133.getKey(), r133.getValue());
        goto L43
    L47:
        r134 = false;
        goto L48
    L50:
        Map<Long, com.bytedance.android.live.recharge.model.diamond.e> r135 = r100.j();
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e>> r136 = r135.entrySet().iterator();
    L52:
        if (r136.hasNext() == false) goto L59;
        Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e> r137 = r136.next();
        if (r137.getKey().longValue() == r129.f89765c) goto L56;
        boolean r138 = true;
    L57:
        if (r138 == false) goto L52;
        r106.put(r137.getKey(), r137.getValue());
        goto L52
    L56:
        r138 = false;
        goto L57
    L59:
        r100 = k.a(r100, r102, r103, r104, r106, r105, 4);
        goto L60
    L34:
        r128 = false;
        goto L35
    L37:
        r127 = null;
        goto L38
    L22:
        if (101 > r121) goto L27;
        r101 = 600;
        if (600 >= r121) goto L28;
    L27:
        long r107 = 100;
        r101 = (((r121 - 1) / r107) + 1) * r107;
        goto L28
    L17:
        r124 = "";
    L60:
        IPrePayCashierInfo r139 = r100.n();
        if (r139 == null) goto L63;
        r139.setRenderDataMap(com.bytedance.revenue.platform.api.core.d.a(new Pair[0]));
    L63:
        r117 = LastCustomRechargeRecoder.c(r100, this);
        r116 = null;
        goto L65
    L9:
        r119 = false;
        goto L10
    }
}
