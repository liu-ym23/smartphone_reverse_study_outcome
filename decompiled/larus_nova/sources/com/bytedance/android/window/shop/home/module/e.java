package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowBaseInfoPresenterBase;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import zq3.l;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends a {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowBaseInfoPresenterBase();
    }

    public e() {
        super(R.id.ec_shop_head_info_area_container);
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        if (l.b() == false) goto L7;
        return k.a.a(this, R.layout.ec_shop_layout_head_info_area_search_enhanced);
    L7:
        return k.a.a(this, R.layout.ec_shop_layout_head_info_area);
    }
}
