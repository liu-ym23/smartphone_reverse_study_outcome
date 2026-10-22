package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECShopBackgroundPresenterBrand;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECShopBackgroundPresenterBrand(this.f183787l);
    }

    public a(Fragment r100) {
        super(R.id.ec_store_background_container_brand, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        return q.a.a(this, R.layout.ec_shop_layout_background_brand);
    }
}
