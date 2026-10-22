package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECStoreFloatGoTopPresenterV2;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECStoreFloatGoTopPresenterV2(this.f183787l);
    }

    public e(Fragment r100) {
        super(R.id.ec_shop_go_top_icon, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        View r101 = new View(a().getContext());
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -1);
        r102.gravity = 17;
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        r101.setBackgroundResource(R.drawable.ec_store_ic_go_top_round);
        r101.setVisibility(8);
        return r101;
    }
}
