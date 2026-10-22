package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFlowLynxCardView;", "Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedLynxCardView;", "", ce.f26391f, "D", "getShowPercent", "()D", "setShowPercent", "(D)V", "showPercent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFlowLynxCardView extends AbsShopFeedLynxCardView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f186220g;

    public static final class a {
    }

    static {
    }

    public final double getShowPercent() {
        return this.f186220g;
    }

    public final void setShowPercent(double r100) {
        this.f186220g = r100;
    }

    public ShopFlowLynxCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = (k1.j(r100) * 9) / 10;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_shop_feed_lynx_card, this, true);
        setLoadingImageView((ImageView) findViewById(R.id.shop_feed_loading_image));
        setLynxContainer((FrameLayout) findViewById(R.id.shop_feed_lynx_container));
        ImageView r104 = getLoadingImageView();
        if (r104 == null) goto L6;
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, r103));
        return;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedLynxCardView
    public final Map b(ShopFeedItemCard r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "passThroughParams");
        if (k1.k() >= 790) goto L5;
        int r103 = 3;
    L6:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("product_num", String.valueOf(r103));
        r104.put("is_top", Integer.valueOf(r102 ? 1 : 0));
        return r104;
    L5:
        r103 = 4;
        goto L6
    }
}
