package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.o0;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new o0(this.f183787l);
    }

    public i(Fragment r100) {
        super(R.id.ec_store_collapsing_layout_promotion_background_wrapper, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        return q.a.a(this, R.layout.ec_store_layout_shop_info_background);
    }
}
