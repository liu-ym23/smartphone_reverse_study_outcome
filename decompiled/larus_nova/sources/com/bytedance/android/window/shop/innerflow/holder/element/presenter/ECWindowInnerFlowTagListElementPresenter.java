package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowTextTagGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowTagListElementPresenter extends d<wp3.f> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f189122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f189123h;

    public final ECWindowInnerFlowTextTagGroup F() {
        return (ECWindowInnerFlowTextTagGroup) this.f189122g.getValue();
    }

    public ECWindowInnerFlowTagListElementPresenter() {
        super(yp3.d.f568702a);
        this.f189122g = LazyKt.lazy(new ECWindowInnerFlowTagListElementPresenter$tagGroup$2(this));
        this.f189123h = LazyKt.lazy(new ECWindowInnerFlowTagListElementPresenter$viewModel$2(this));
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        List<View> r100 = com.bytedance.commerce.base.view.b.a(F());
        F().removeAllViews();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        View r102 = (View) r101.next();
        if ((r102 instanceof TextView) == true) goto L8;
        r102 = null;
    L8:
        TextView r103 = (TextView) r102;
        if (r103 == null) goto L4;
        ((ECWindowInnerFlowViewModel) this.f189123h.getValue()).getFlyWeight().f189035f.b(r103);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.f r100) {
        wp3.f r101 = r100;
        if (F().getChildCount() <= 0) goto L5;
        F().removeAllViews();
    L5:
        if (r101 == null) goto L12;
        List<String> r102 = r101.f560585a;
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        final String r104 = (String) r103.next();
        F().addView(((ECWindowInnerFlowViewModel) this.f189123h.getValue()).getFlyWeight().f189035f.a(new ECWindowInnerFlowTagListElementPresenter$onElementBind$$inlined$forEach$lambda$1(r104, this)));
        goto L10
    L15:
        return;
    L14:
        return;
    }
}
