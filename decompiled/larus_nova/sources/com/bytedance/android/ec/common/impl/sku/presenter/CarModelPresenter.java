package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
public final class CarModelPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f43150p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f43152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super String, Unit> f43153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f43154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f43155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f43156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f43157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f43158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f43159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f43160o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CarModelPresenter f43161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarAdaptComponent f43162b;

        public b(CarModelPresenter r100, CarAdaptComponent r101) {
            this.f43161a = r100;
            this.f43162b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super String, Unit> r101 = this.f43161a.f43153h;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f43162b.getUrl());
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CarModelPresenter f43163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarAdaptComponent f43164b;

        public c(CarModelPresenter r100, CarAdaptComponent r101) {
            this.f43163a = r100;
            this.f43164b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super String, Unit> r101 = this.f43163a.f43153h;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f43164b.getUrl());
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CarModelPresenter f43165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarAdaptComponent f43166b;

        public d(CarModelPresenter r100, CarAdaptComponent r101) {
            this.f43165a = r100;
            this.f43166b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super String, Unit> r101 = this.f43165a.f43153h;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f43166b.getUrl());
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

    public CarModelPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f43152g = true;
        this.f43154i = LazyKt.lazy(new CarModelPresenter$tvCarDesc$2(this));
        this.f43155j = LazyKt.lazy(new CarModelPresenter$tvSwitchModel$2(this));
        this.f43156k = LazyKt.lazy(new CarModelPresenter$ivRightArrow$2(this));
        this.f43157l = LazyKt.lazy(new CarModelPresenter$icon$2(this));
        this.f43158m = LazyKt.lazy(new CarModelPresenter$tvCarModelStatus$2(this));
        this.f43159n = LazyKt.lazy(new CarModelPresenter$flCarStatus$2(this));
        this.f43160o = LazyKt.lazy(new CarModelPresenter$ivModelRightArrow$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        SkuViewModel r101 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43151f = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        if (r102 == null) goto L8;
        CarAdaptComponent r103 = r102.getCarAdaptComponent();
    L9:
        d0(r103);
        if (this.f43152g == false) goto L16;
        SkuViewModel r104 = this.f43151f;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r104.getCurrentCarAdaptComponent().b(ECQuickUtilKt.a(Y()), new x(this));
        ECLiveHybridUtil.m("updateSelectedCarModel", com.bytedance.android.ec.core.utils.k.f45624a);
        com.bytedance.android.ec.core.utils.s0.c(this);
        this.f43152g = false;
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
        SkuViewModel r101 = this.f43151f;
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
        SkuViewModel r104 = this.f43151f;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Pair[] r105 = new Pair[3];
        r105[0] = TuplesKt.to("module_name", "adaptation");
        boolean r111 = true;
        r105[1] = TuplesKt.to("module_location", "2");
        if (r110 == null) goto L20;
        r100 = r110.getCarDesc();
    L20:
        if (r100 != null) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == false) goto L28;
        String r107 = "1";
    L29:
        r105[2] = TuplesKt.to("module_status", r107);
        SkuViewModel.doSkuEventAction$default(r104, "pd_page_module_show", r105, null, null, null, 28, null);
        ECUrlModel r108 = r103.getIcon();
        if (r108 == null) goto L32;
        com.bytedance.android.ec.core.utils.y.a((SimpleDraweeView) this.f43157l.getValue(), r108);
    L32:
        ((TextView) this.f43158m.getValue()).setText(r103.getAdaptResult());
        ImageView r109 = (ImageView) this.f43160o.getValue();
        String r112 = r103.getCarDesc();
        if (r112 != null) goto L35;
    L38:
        jg.g.d(r109, r111);
        ((FrameLayout) this.f43159n.getValue()).setOnClickListener(new d(this, r103));
        this.f43153h = new CarModelPresenter$updateCarInfo$3(this, r110);
        if (com.bytedance.android.ec.core.utils.a2.b(r103.getCarDesc()) == false) goto L41;
        ((TextView) this.f43154i.getValue()).setText(r103.getCarDesc());
        ((TextView) this.f43154i.getValue()).setVisibility(0);
        TextView r113 = (TextView) this.f43155j.getValue();
        r113.setVisibility(0);
        r113.setOnClickListener(new b(this, r103));
        ImageView r114 = (ImageView) this.f43156k.getValue();
        r114.setVisibility(0);
        r114.setOnClickListener(new c(this, r103));
        return;
    L41:
        ((TextView) this.f43154i.getValue()).setVisibility(8);
        ((ImageView) this.f43156k.getValue()).setVisibility(8);
        ((TextView) this.f43155j.getValue()).setVisibility(8);
        return;
    L35:
        if (r112.length() == 0) goto L38;
        r111 = false;
        goto L38
    L28:
        r107 = "0";
        goto L29
    L22:
        if (r100.length() == 0) goto L25;
        r106 = false;
        goto L26
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
        SkuViewModel r102 = this.f43151f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuParams r103 = r102.getSkuParams();
        if (r101 == null) goto L8;
        String r104 = r101.getId();
    L9:
        r103.setSelectCarId(r104);
        SkuViewModel r105 = this.f43151f;
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
