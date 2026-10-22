package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends BaseMVIDataStore<m> implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127306n = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReadOnlyProperty f127307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReadOnlyProperty f127308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReadOnlyProperty f127309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.anya.t f127310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.anya.t f127311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.anya.t f127312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BehaviorSubject<String> f127313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BehaviorSubject<PayGrade> f127314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f127315m;

    static {
        f127306n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(m.class, "currentPayGrade", "getCurrentPayGrade()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "touchPositionsStr", "getTouchPositionsStr()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "needShowDetail", "getNeedShowDetail()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "_touchPositionsStr", "get_touchPositionsStr()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "_currentPayGarde", "get_currentPayGarde()Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "_needShowDetail", "get_needShowDetail()Z", 0))};
    }

    public m() {
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        Object r101 = null;
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<? extends PayGrade> r102 = r100.getPayGrade();
        if (r102 == null) goto L7;
        PayGrade r103 = r102.getValue();
    L8:
        if (r103 != null) goto L10;
    L13:
        py.d r104 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getUserHonor();
        if (r104 == null) goto L16;
        Intrinsics.checkNotNullParameter(r104, "$this$toPayGrade");
        long r105 = r104.getScore();
        Intrinsics.checkNotNullParameter(r104, "$this$levelKt");
        long r106 = r104.getLevel();
        long r110 = r104.getThisGradeMaxDiamond();
        r103 = new PayGrade(r105, r106, r104.getThisGradeMinDiamond(), r110, r104.getGradeDescribe(), r104.getNewImIconWithLevel(), r104.getNewLiveIcon(), r104.getBuffInfo(), r104.getGradeDescribeShining(), 0, null, 0, null, null, null, null, 0, 0, null, 523264, null);
    L17:
        com.bytedance.android.anya.internal.k r107 = i(r103).a();
        KProperty<?>[] r108 = f127306n;
        com.bytedance.android.anya.internal.h r109 = r107.a(r108[0]);
        this.f127307e = r109;
        com.bytedance.android.live.profit.privilege.a r111 = yt0.c.i();
        if (r111 == null) goto L24;
        com.bytedance.live.datacontext.m<? extends TouchPositionData> r112 = r111.getTouchPositionData();
        if (r112 == null) goto L24;
        TouchPositionData r113 = r112.getValue();
        if (r113 == null) goto L24;
        r101 = r113.getTouchPositionsStr();
    L24:
        com.bytedance.android.anya.internal.h r114 = j(r101).a().a(r108[1]);
        this.f127308f = r114;
        com.bytedance.android.live.profit.privilege.a r115 = yt0.c.i();
        if (r115 == null) goto L31;
        com.bytedance.live.datacontext.m<? extends TouchPositionData> r116 = r115.getTouchPositionData();
        if (r116 == null) goto L31;
        TouchPositionData r117 = r116.getValue();
        if (r117 == null) goto L31;
        boolean r118 = r117.getNeedShowTopDetail();
    L32:
        com.bytedance.android.anya.internal.h r119 = i(Boolean.valueOf(r118)).a().a(r108[2]);
        this.f127309g = r119;
        this.f127310h = (com.bytedance.android.anya.t) r114.getValue(this, r108[1]);
        this.f127311i = (com.bytedance.android.anya.t) r109.getValue(this, r108[0]);
        this.f127312j = (com.bytedance.android.anya.t) r119.getValue(this, r108[2]);
        this.f127313k = BehaviorSubject.create();
        this.f127314l = BehaviorSubject.create();
        this.f127315m = new CompositeDisposable();
        return;
    L31:
        r118 = true;
        goto L32
    L16:
        r103 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        goto L17
    L10:
        if (r103.getLevel() != 0) goto L17;
        if (r103.getScore() != 0) goto L17;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f127315m.clear();
    }

    public final void k() {
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        if (r100 == null) goto L5;
        r100.Te();
    L5:
        com.bytedance.android.live.profit.privilege.a r101 = yt0.c.i();
        if (r101 == null) goto L8;
        RxUtilKt.c(r101.getTouchPositionData().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this)), this.f127315m);
    L8:
        com.bytedance.android.live.profit.privilege.a r102 = yt0.c.i();
        if (r102 == null) goto L12;
        RxUtilKt.c(RxUtilKt.h(r102.getPayGrade().a().subscribeOn(Schedulers.io())).subscribe(new i(this)), this.f127315m);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == false) goto L5;
        k();
        return;
    L5:
        this.f127315m.add(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).pl().filter(k.f127304a).subscribe(new l(this)));
    }
}
