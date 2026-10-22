package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import oc6.m0;

/* JADX INFO: loaded from: classes9.dex */
public final class u extends BaseMVIDataStore<u> implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127323n = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f127324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f127325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BehaviorSubject<m0> f127326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BehaviorSubject<m0> f127327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReadOnlyProperty f127328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BehaviorSubject<oc6.e> f127329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BehaviorSubject<oc6.e> f127330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ReadOnlyProperty f127331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.k f127332m;

    static {
        f127323n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(u.class, "availableDiamond", "getAvailableDiamond()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(u.class, "exchangeInfo", "getExchangeInfo()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final long k() {
        zv0.f r100 = this.f127332m.rechargeCenter();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAvailableDiamonds();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f127332m.rechargeCenter().sync("gift_panel");
        RxUtilKt.c(this.f127332m.rechargeCenter().observeExchangeInfo().compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this), p.f127318a), this.f127324e);
        RxUtilKt.c(this.f127332m.rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new s(this), t.f127322a), this.f127324e);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == false) goto L7;
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        if (r100 == null) goto L8;
        r100.k6();
    L8:
        com.bytedance.android.live.core.utils.rxutils.j.a r101 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        RxUtilKt.c(com.bytedance.android.live.core.utils.rxutils.j.c(1, TimeUnit.SECONDS).take(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this)), this.f127324e);
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == false) goto L16;
        int r102 = com.bytedance.android.live.recharge.util.d.f90424a;
        if (com.bytedance.android.live.recharge.util.d.b(s1.getContext()) == false) goto L17;
        ou0.a r103 = yt0.c.d();
        if (r103 == null) goto L18;
        r103.mn();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        RxUtilKt.c(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).pl().filter(q.f127319a).subscribe(new r(this)), this.f127324e);
        goto L8
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f127324e.clear();
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == false) goto L8;
        ou0.a r100 = yt0.c.d();
        if (r100 == null) goto L9;
        r100.mn();
        return;
    L9:
        return;
    }

    public u(com.bytedance.android.live.recharge.k r100) {
        Intrinsics.checkNotNullParameter(r100, "rechargeService");
        this.f127332m = r100;
        this.f127324e = new CompositeDisposable();
        this.f127325f = 2;
        m0 r101 = new m0();
        r101.b(k());
        Unit r102 = Unit.INSTANCE;
        BehaviorSubject<m0> r103 = BehaviorSubject.createDefault(r101);
        this.f127326g = r103;
        this.f127327h = r103;
        m0 r104 = r103.getValue();
        if (r104 == null) goto L5;
        long r105 = r104.a();
    L6:
        com.bytedance.android.anya.internal.k r106 = i(Long.valueOf(r105)).a();
        KProperty[] r107 = f127323n;
        this.f127328i = r106.a(r107[0]);
        zv0.f r108 = r100.rechargeCenter();
        if (r108 == null) goto L11;
        ExchangeInfo r109 = r108.getExchangeInfo();
        if (r109 == null) goto L11;
        oc6.e r110 = v.a(r109);
    L12:
        BehaviorSubject<oc6.e> r111 = BehaviorSubject.createDefault(r110);
        this.f127329j = r111;
        this.f127330k = r111;
        this.f127331l = j(r111.getValue()).a().a(r107[1]);
        return;
    L11:
        r110 = new oc6.e();
        goto L12
    L5:
        r105 = 0;
        goto L6
    }
}
