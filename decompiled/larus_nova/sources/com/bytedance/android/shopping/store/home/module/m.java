package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECShopProductTabSlideHintPresenter;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECShopProductTabSlideHintPresenter(this.f183787l);
    }

    public m(Fragment r100) {
        super(R.id.ec_shop_slide_hint_wrapper, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        View r101 = q.a.a(this, R.layout.ec_shop_layout_slide_hint);
        r101.setAlpha(0.75f);
        ExtensionsKt.gone(r101);
        return r101;
    }
}
