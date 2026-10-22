package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.CarModelSelectInfo;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes43.dex */
public final class CarModelOptimizePresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f43137p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f43139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super String, Unit> f43140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f43141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f43142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f43143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f43144l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f43145m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f43146n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f43147o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CarModelOptimizePresenter f43148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarAdaptComponent f43149b;

        public b(CarModelOptimizePresenter r100, CarAdaptComponent r101) {
            this.f43148a = r100;
            this.f43149b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super String, Unit> r101 = this.f43148a.f43140h;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f43149b.getUrl());
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        ECLiveHybridUtil.p("updateSelectedCarModel", com.bytedance.android.ec.core.utils.k.f45624a);
        com.bytedance.android.ec.core.utils.s0.e(this);
    }

    public CarModelOptimizePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f43139g = true;
        this.f43141i = LazyKt.lazy(new CarModelOptimizePresenter$ivModelStatus$2(this));
        this.f43142j = LazyKt.lazy(new CarModelOptimizePresenter$tvCarDesc$2(this));
        this.f43143k = LazyKt.lazy(new CarModelOptimizePresenter$tvCarModelAdd$2(this));
        this.f43144l = LazyKt.lazy(new CarModelOptimizePresenter$tvCarModelStatus$2(this));
        this.f43145m = LazyKt.lazy(new CarModelOptimizePresenter$tvSwitchModel$2(this));
        this.f43146n = LazyKt.lazy(new CarModelOptimizePresenter$ivModelRightArrow$2(this));
        this.f43147o = LazyKt.lazy(new CarModelOptimizePresenter$clModelContainer$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        SkuViewModel r101 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43138f = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        if (r102 == null) goto L8;
        CarAdaptComponent r103 = r102.getCarAdaptComponent();
    L9:
        d0(r103);
        if (this.f43139g == false) goto L16;
        SkuViewModel r104 = this.f43138f;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r104.getCurrentCarAdaptComponent().b(ECQuickUtilKt.a(Y()), new w(this));
        ECLiveHybridUtil.m("updateSelectedCarModel", com.bytedance.android.ec.core.utils.k.f45624a);
        com.bytedance.android.ec.core.utils.s0.c(this);
        this.f43139g = false;
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void d0(final CarAdaptComponent r110) {
        String r100 = null;
        if (r110 != null) goto L11;
        SkuViewModel r101 = this.f43138f;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        if (r102 == null) goto L10;
        CarAdaptComponent r103 = r102.getCarAdaptComponent();
    L12:
        if (r103 != null) goto L14;
        return;
    L14:
        SkuViewModel r104 = this.f43138f;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Pair[] r105 = new Pair[3];
        r105[0] = TuplesKt.to("module_name", "adaptation");
        boolean r106 = true;
        r105[1] = TuplesKt.to("module_location", "2");
        if (r110 == null) goto L20;
        r100 = r110.getCarDesc();
    L20:
        if (r100 != null) goto L22;
    L25:
        if (r106 == false) goto L27;
        String r107 = "1";
    L28:
        r105[2] = TuplesKt.to("module_status", r107);
        SkuViewModel.doSkuEventAction$default(r104, "pd_page_module_show", r105, null, null, null, 28, null);
        this.f43140h = new CarModelOptimizePresenter$updateCarInfo$1(this, r110);
        ECUrlModel r111 = r103.getIcon();
        if (r111 == null) goto L32;
        com.bytedance.android.ec.core.utils.y.a((SimpleDraweeView) this.f43141i.getValue(), r111);
    L32:
        if (com.bytedance.android.ec.core.utils.a2.b(r103.getCarDesc()) == false) goto L34;
        ((TextView) this.f43143k.getValue()).setVisibility(8);
        ((TextView) this.f43142j.getValue()).setVisibility(0);
        ((TextView) this.f43144l.getValue()).setVisibility(0);
        ((TextView) this.f43145m.getValue()).setVisibility(0);
        ((TextView) this.f43142j.getValue()).setText(r103.getCarDesc());
        ((TextView) this.f43144l.getValue()).setText(r103.getAdaptResult());
    L35:
        ((ConstraintLayout) this.f43147o.getValue()).setOnClickListener(new b(this, r103));
        return;
    L34:
        ((TextView) this.f43143k.getValue()).setVisibility(0);
        ((TextView) this.f43142j.getValue()).setVisibility(8);
        ((TextView) this.f43144l.getValue()).setVisibility(8);
        ((TextView) this.f43145m.getValue()).setVisibility(8);
        goto L35
    L27:
        r107 = "0";
        goto L28
    L22:
        if (r100.length() == 0) goto L25;
        r106 = false;
        goto L25
    L10:
        r103 = null;
        goto L12
    L11:
        r103 = r110;
        goto L12
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCarModelUpdated(com.bytedance.android.ec.core.utils.f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        CarModelSelectInfo r101 = r100.f45581a;
        SkuViewModel r102 = this.f43138f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuParams r103 = r102.getSkuParams();
        if (r101 == null) goto L8;
        String r104 = r101.getId();
    L9:
        r103.setSelectCarId(r104);
        SkuViewModel r105 = this.f43138f;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r105.m8150getSkuInfo();
        return;
    L8:
        r104 = null;
        goto L9
    }
}
