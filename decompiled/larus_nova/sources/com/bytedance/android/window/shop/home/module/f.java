package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Integer> f188236m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowLinkageHeaderLivePresenter(this.f188236m);
    }

    public f(Function0 r100) {
        super(R.id.ec_shop_live_container_lowest);
        this.f188236m = r100;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        return k.a.a(this, R.layout.ec_window_layout_header_live_base);
    }
}
