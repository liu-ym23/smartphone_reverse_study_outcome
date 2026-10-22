package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowFloatLayerPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends a {
    public d() {
        super(null);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowFloatLayerPresenter();
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        return new View(a().getContext());
    }
}
