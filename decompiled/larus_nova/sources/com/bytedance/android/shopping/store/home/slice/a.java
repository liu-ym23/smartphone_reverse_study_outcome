package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends com.bytedance.android.shopping.store.home.module.b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        QGroupPresenter r100 = new QGroupPresenter();
        r100.a(new c(this.f183787l));
        r100.a(new ECShopSliceProfilePresenter(this.f183787l));
        r100.a(new ECShopFollowBubbleSlicePresenter(this.f183787l));
        return r100;
    }

    public a(Fragment r100) {
        super(R.id.ec_store_info_total_area_container, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        FrameLayout r101 = new FrameLayout(a().getContext());
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        return r101;
    }
}
