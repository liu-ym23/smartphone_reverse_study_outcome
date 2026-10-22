package com.bytedance.android.shopping.store.home.presenter;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.locallife.live.view.LiveLifeAtmosphereAnimView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopProductTabSlideHintPresenter extends ECShopBasePresenter {
    public boolean A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f183975u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f183976v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f183977w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f183978x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f183979y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f183980z;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopProductTabSlideHintPresenter f183981a;

        public a(ECShopProductTabSlideHintPresenter r100) {
            this.f183981a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ECShopProductTabSlideHintPresenter.q0(this.f183981a);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopProductTabSlideHintPresenter f183982a;

        public b(ECShopProductTabSlideHintPresenter r100) {
            this.f183982a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ECShopProductTabSlideHintPresenter.q0(this.f183982a);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopProductTabSlideHintPresenter f183983a;

        public c(ECShopProductTabSlideHintPresenter r100) {
            this.f183983a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.FALSE) == false) goto L5;
            this.f183983a.y().setVisibility(8);
            ECShopProductTabSlideHintPresenter r101 = this.f183983a;
            r101.f183980z = false;
            r101.T().getSlideHintState().setValue(0);
            return;
        L5:
            ECShopProductTabSlideHintPresenter r102 = this.f183983a;
            r102.f183980z = true;
            ECShopProductTabSlideHintPresenter.q0(r102);
        }
    }

    public ECShopProductTabSlideHintPresenter(Fragment r100) {
        super(r100);
        this.f183975u = LazyKt.lazy(ECShopProductTabSlideHintPresenter$slideHintConfig$2.INSTANCE);
        this.f183976v = LazyKt.lazy(new ECShopProductTabSlideHintPresenter$limitNumerator$2(this));
        this.f183977w = LazyKt.lazy(new ECShopProductTabSlideHintPresenter$limitDenominator$2(this));
        this.f183980z = true;
    }

    public static final void q0(ECShopProductTabSlideHintPresenter r100) {
        Integer r101 = r100.T().getProductViewsNum().getValue();
        Integer r102 = r100.T().getTotalProductNum().getValue();
        dm.a.a("slide_hint_debug").a("viewNums:" + r101 + ",totalNums:" + r102 + ",limitNumerator:" + ((Number) r100.f183976v.getValue()).intValue() + ",limitDenominator:" + ((Number) r100.f183977w.getValue()).intValue() + ",canShowSlideHint:" + r100.f183980z);
        if (r101 == null) goto L32;
        if (r102 == null) goto L32;
        if (r101.intValue() < ((Number) r100.f183976v.getValue()).intValue()) goto L32;
        if (r102.intValue() < ((Number) r100.f183977w.getValue()).intValue()) goto L32;
        if (r100.f183980z == false) goto L32;
        uj3.j r103 = r100.T().getCurrentTab();
        if (r103 != null) goto L14;
    L16:
        r100.y().setVisibility(0);
        r100.T().getSlideHintState().setValue(1);
        TextView r104 = r100.f183978x;
        String r105 = LiveLifeAtmosphereAnimView.TV_MAX_NUM_FLAMES;
        if (r104 != null) goto L19;
    L23:
        TextView r106 = r100.f183979y;
        if (r106 == null) goto L30;
        if (r102.intValue() > 999) goto L28;
        r105 = String.valueOf(r102.intValue());
    L28:
        r106.setText(r105);
    L30:
        if (r100.A == true) goto L34;
        r100.A = true;
        r100.T().doEventAction("show_shop_float_pendant", new Pair[]{TuplesKt.to("type", "slide_progress"), TuplesKt.to("product_view_num", String.valueOf(((Number) r100.f183976v.getValue()).intValue())), TuplesKt.to("product_total_num", String.valueOf(r102.intValue()))});
        return;
    L34:
        return;
    L19:
        if (r101.intValue() > 999) goto L21;
        String r107 = String.valueOf(r101.intValue());
    L22:
        r104.setText(r107);
        goto L23
    L21:
        r107 = LiveLifeAtmosphereAnimView.TV_MAX_NUM_FLAMES;
        goto L22
    L14:
        if ((!r103.i()) != true) goto L16;
    L32:
        r100.y().setVisibility(8);
        r100.T().getSlideHintState().setValue(0);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f183978x = (TextView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_shop_slide_hint_numerator));
        this.f183979y = (TextView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_shop_slide_hint_denominator));
        T().getProductViewsNum().a(W(), new a(this), false);
        T().getTotalProductNum().a(W(), new b(this), false);
        T().getCanShowSlideHint().a(W(), new c(this), false);
    }
}
