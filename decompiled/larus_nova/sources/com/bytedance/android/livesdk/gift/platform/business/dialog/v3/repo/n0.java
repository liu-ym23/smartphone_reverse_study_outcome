package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f128387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<oc6.m0> f128388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i12.e f128389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final uz1.a f128390d;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f128387a.add(((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new l0(this), m0.f128386a));
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == true) goto L6;
        this.f128387a.add(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).pl().filter(j0.f128359a).subscribe(new k0(this)));
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128387a.clear();
    }

    public n0(DataCenter r100, i12.e r101, uz1.a r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "giftMVIFacade");
        this.f128389c = r101;
        this.f128390d = r102;
        this.f128387a = new CompositeDisposable();
        oc6.m0 r103 = new oc6.m0();
        IRechargeService r104 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r104 == null) goto L7;
        zv0.f r105 = r104.rechargeCenter();
        if (r105 == null) goto L7;
        long r106 = r105.getAvailableDiamonds();
    L8:
        r103.b(r106);
        Unit r107 = Unit.INSTANCE;
        this.f128388b = BehaviorSubject.createDefault(r103);
        return;
    L7:
        r106 = 0;
        goto L8
    }
}
