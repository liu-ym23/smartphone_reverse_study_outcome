package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.panel.aio.PanelMode;
import com.bytedance.android.live.recharge.utils.k;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public class a implements vw0.d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90158x = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BehaviorSubject<IPanelProperties> f90159h;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f90160q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f90161r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f90162s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f90163t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f90164u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f90165v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f90166w;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.panel.context.a$a, reason: collision with other inner class name */
    public static final class C1381a {
    }

    public final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.revenue.common.reactive.b<T> f90167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f90168b;

        /* JADX INFO: renamed from: com.bytedance.android.live.recharge.panel.context.a$b$a, reason: collision with other inner class name */
        public static final class C1382a<T> implements com.bytedance.android.live.revenue.common.reactive.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f90169a;

            public C1382a(b r100) {
                this.f90169a = r100;
            }

            @Override // com.bytedance.android.live.revenue.common.reactive.f
            public final void a(T r100) {
                Intrinsics.checkNotNullParameter(r100, "newValue");
                this.f90169a.f90168b.a();
            }
        }

        public final Object a(KProperty r100) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            return this.f90167a.getValue();
        }

        public b(a r100, com.bytedance.android.live.revenue.common.reactive.b<T> r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f90168b = r100;
            this.f90167a = r101;
            com.bytedance.android.live.recharge.panel.context.b.a(r101.a(new C1382a(this)), r100.f90166w.getCd());
        }

        public final void b(KProperty r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (r101 != null) goto L5;
            return;
        L5:
            this.f90167a.setValue(r101);
        }
    }

    static {
        f90158x = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isRechargeAgreementAccepted", "isRechargeAgreementAccepted()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isCombinedPaySelected", "isCombinedPaySelected()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "customPrice", "getCustomPrice()Ljava/lang/Long;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isHidePanel", "isHidePanel()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isShowCenterLoading", "isShowCenterLoading()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "panelMode", "getPanelMode()I", 0))};
    }

    @Override // vw0.d
    public Long getCustomPrice() {
        return (Long) this.f90162s.a(f90158x[2]);
    }

    @Override // vw0.d
    public final int getPanelMode() {
        return ((Number) this.f90165v.a(f90158x[5])).intValue();
    }

    @Override // vw0.d
    public final Boolean isCombinedPaySelected() {
        return (Boolean) this.f90161r.a(f90158x[1]);
    }

    @Override // vw0.d
    public final Boolean isHidePanel() {
        return (Boolean) this.f90163t.a(f90158x[3]);
    }

    @Override // vw0.d
    public Boolean isRechargeAgreementAccepted() {
        return (Boolean) this.f90160q.a(f90158x[0]);
    }

    @Override // vw0.d
    public final Boolean isShowCenterLoading() {
        return (Boolean) this.f90164u.a(f90158x[4]);
    }

    @Override // vw0.d
    public final void setCombinedPaySelected(Boolean r100) {
        this.f90161r.b(f90158x[1], r100);
    }

    @Override // vw0.d
    public void setCustomPrice(Long r100) {
        this.f90162s.b(f90158x[2], r100);
    }

    @Override // vw0.d
    public final void setHidePanel(Boolean r100) {
        this.f90163t.b(f90158x[3], r100);
    }

    @Override // vw0.d
    public final void setPanelMode(int r100) {
        this.f90165v.b(f90158x[5], Integer.valueOf(r100));
    }

    @Override // vw0.d
    public void setRechargeAgreementAccepted(Boolean r100) {
        this.f90160q.b(f90158x[0], r100);
    }

    @Override // vw0.d
    public final void setShowCenterLoading(Boolean r100) {
        this.f90164u.b(f90158x[4], r100);
    }

    public final void a() {
        IPanelProperties r100 = vw0.f.a();
        vw0.e.a(r100, this);
        int r101 = w.f66424a;
        if (v.a() == false) goto L5;
        jy0.b.d("RechargePanelPropertiesProvider", "broadcast: " + r100);
    L5:
        this.f90159h.onNext(r100);
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        this.f90166w = r100;
        int r101 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f90159h = BehaviorSubject.create();
        Boolean r102 = Boolean.FALSE;
        com.bytedance.android.live.revenue.common.reactive.c r103 = new com.bytedance.android.live.revenue.common.reactive.c(r102);
        com.bytedance.android.live.revenue.common.reactive.c r104 = new com.bytedance.android.live.revenue.common.reactive.c(0L);
        com.bytedance.android.live.revenue.common.reactive.c r105 = new com.bytedance.android.live.revenue.common.reactive.c(r102);
        com.bytedance.android.live.revenue.common.reactive.c r106 = new com.bytedance.android.live.revenue.common.reactive.c(r102);
        int r107 = k.f90490a;
        com.bytedance.android.live.recharge.model.d r108 = r100.a();
        Intrinsics.checkNotNullParameter(r108, "entranceParams");
        com.bytedance.android.live.recharge.core.f.g(RechargeServices.b()).T0(r108);
        com.bytedance.android.live.revenue.common.reactive.c r109 = new com.bytedance.android.live.revenue.common.reactive.c(Integer.valueOf(PanelMode.NORMAL_MODE.getMode()));
        KProperty[] r110 = f90158x;
        KProperty r111 = r110[0];
        this.f90160q = b(r103);
        com.bytedance.android.live.recharge.combinedpay.a.C1374a r112 = com.bytedance.android.live.recharge.combinedpay.a.f89668a;
        KProperty r113 = r110[1];
        this.f90161r = b(r112);
        KProperty r114 = r110[2];
        this.f90162s = b(r104);
        KProperty r115 = r110[3];
        this.f90163t = b(r105);
        KProperty r116 = r110[4];
        this.f90164u = b(r106);
        KProperty r117 = r110[5];
        this.f90165v = b(r109);
    }

    public final b b(com.bytedance.android.live.revenue.common.reactive.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$provideDelegate");
        return new b(this, r100);
    }
}
