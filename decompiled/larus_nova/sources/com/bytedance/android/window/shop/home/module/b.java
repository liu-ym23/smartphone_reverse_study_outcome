package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowFloatCartEntryPresenter;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Integer> f188234m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowFloatCartEntryPresenter(this.f188234m);
    }

    public b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "getViewHeight");
        super(R.id.ec_shop_float_cart_entry_container);
        this.f188234m = r100;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        View r101 = new View(a().getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(40), com.bytedance.android.shopping.extensions.b.b(40)));
        r101.setBackgroundResource(R.drawable.ec_store_ic_cart_round_white_new);
        r101.setVisibility(4);
        r101.setTag("anchor_window_bottom_shop_cart");
        return r101;
    }
}
