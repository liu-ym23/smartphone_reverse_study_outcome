package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.holder.presenter.WindowAnchorCardPresenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowAnchorCardHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAnchorCardHolder extends ShopWindowGenericHolder<sq3.c> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f187824v = null;

    public static final class a {
        public a() {
        }
    }

    static {
        f187824v = new a();
    }

    public WindowAnchorCardHolder(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ShoppingAsyncInflater.a r101 = ShoppingAsyncInflater.f45268e;
        Context r102 = r100.requireContext();
        r101.getClass();
        super(r100, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r102), R.layout.ec_window_layout_anchor_card, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r100) {
        return new Rect(d.a(12), 0, d.a(12), 0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return new WindowAnchorCardPresenter(r100);
    }
}
