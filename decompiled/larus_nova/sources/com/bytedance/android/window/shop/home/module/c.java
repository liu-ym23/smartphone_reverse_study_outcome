package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowFloatGoTopPresenter;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Integer> f188235m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowFloatGoTopPresenter(this.f188235m);
    }

    public c(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "getViewHeight");
        super(R.id.ec_shop_float_go_top_container);
        this.f188235m = r100;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        View r101 = new View(a().getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(40), com.bytedance.android.shopping.extensions.b.b(40)));
        r101.setBackgroundResource(R.drawable.ec_store_ic_go_top_round_white);
        r101.setVisibility(4);
        r101.setTag("anchor_window_bottom_go_top");
        return r101;
    }
}
