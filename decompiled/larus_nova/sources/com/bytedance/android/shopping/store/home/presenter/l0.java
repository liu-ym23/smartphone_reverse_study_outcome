package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;

/* JADX INFO: loaded from: classes14.dex */
public final class l0 extends ECShopBasePresenter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f184224u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f184225v;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f184226a;

        public a(l0 r100) {
            this.f184226a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
        L8:
            l0.q0(this.f184226a, true);
            return;
        L6:
            if (r101.intValue() != 0) goto L8;
            l0.q0(this.f184226a, false);
        }
    }

    public l0(Fragment r100) {
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        View r101 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_shop_go_top_icon));
        if (r101 != null) goto L5;
        return;
    L5:
        this.f184224u = r101;
        View r102 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_shop_slide_hint_wrapper));
        if (r102 != null) goto L8;
        return;
    L8:
        this.f184225v = r102;
        T().getScrollState().a(W(), new a(this), false);
    }

    public static final void q0(l0 r100, boolean r101) {
        if (r101 == false) goto L20;
        Integer r102 = r100.T().getSlideHintState().getValue();
        if (r102 != null) goto L7;
    L14:
        View r103 = r100.f184225v;
        if (r103 == null) goto L17;
        ExtensionsKt.gone(r103);
    L17:
        View r104 = r100.f184224u;
        if (r104 == null) goto L29;
        ExtensionsKt.visible(r104);
        return;
    L29:
        return;
    L7:
        if (r102.intValue() != 1) goto L14;
        View r105 = r100.f184225v;
        if (r105 == null) goto L11;
        ExtensionsKt.visible(r105);
    L11:
        View r106 = r100.f184224u;
        if (r106 == null) goto L27;
        ExtensionsKt.gone(r106);
        return;
    L27:
        return;
    L20:
        View r107 = r100.f184225v;
        if (r107 == null) goto L23;
        ExtensionsKt.gone(r107);
    L23:
        View r108 = r100.f184224u;
        if (r108 == null) goto L31;
        ExtensionsKt.visible(r108);
        return;
    }
}
