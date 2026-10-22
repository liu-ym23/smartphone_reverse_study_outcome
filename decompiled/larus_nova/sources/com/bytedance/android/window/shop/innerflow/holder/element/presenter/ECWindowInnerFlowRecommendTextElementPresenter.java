package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECExpandableTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowRecommendTextElementPresenter extends d<wp3.e> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f189119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f189120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f189121i;

    public final ECExpandableTextView F() {
        return (ECExpandableTextView) this.f189120h.getValue();
    }

    public ECWindowInnerFlowRecommendTextElementPresenter() {
        super(yp3.g.f568703a);
        this.f189119g = LazyKt.lazy(new ECWindowInnerFlowRecommendTextElementPresenter$viewModel$2(this));
        this.f189120h = LazyKt.lazy(new ECWindowInnerFlowRecommendTextElementPresenter$tvRecommend$2(this));
        this.f189121i = LazyKt.lazy(new ECWindowInnerFlowRecommendTextElementPresenter$tvTitle$2(this));
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        ECExpandableTextView r100 = F();
        r100.f189207b = true;
        r100.invalidate();
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.e r100) {
        wp3.e r101 = r100;
        if (r101 == null) goto L18;
        ECWindowInnerFlowViewModel r102 = (ECWindowInnerFlowViewModel) this.f189119g.getValue();
        if (r102.getFlyWeight().f189031b != null) goto L8;
        ECWindowInnerFlowViewModel.a r103 = r102.getFlyWeight();
        r103.f189031b = F().getBitmapFixedHeight();
    L8:
        F().setBitmapCache(((ECWindowInnerFlowViewModel) this.f189119g.getValue()).getFlyWeight().f189031b);
        if (r101.f560582a == null) goto L11;
        F().setText(r101.f560582a);
        F().setVisibility(0);
    L12:
        String r104 = a2.d(r101.f560583b);
        if (r104 != null) goto L15;
        ((TextView) this.f189121i.getValue()).setVisibility(8);
        return;
    L15:
        ((TextView) this.f189121i.getValue()).setText(r104);
        ((TextView) this.f189121i.getValue()).setVisibility(0);
        return;
    L11:
        F().setVisibility(8);
        Unit r105 = Unit.INSTANCE;
        goto L12
    }
}
