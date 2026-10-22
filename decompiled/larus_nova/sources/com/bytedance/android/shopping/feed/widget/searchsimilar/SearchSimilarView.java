package com.bytedance.android.shopping.feed.widget.searchsimilar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.inflow.view.d;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/searchsimilar/SearchSimilarView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSimilarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rd3.a f176070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f176071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f176072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECDraweeView f176073d;

    public interface a {
        void onClick();
    }

    public SearchSimilarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SearchSimilarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public SearchSimilarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_search_similar_view, this, true);
        this.f176072c = (LinearLayout) findViewById(R.id.search_similar_container);
        this.f176073d = (ECDraweeView) findViewById(R.id.search_similar_image);
    }

    public /* synthetic */ SearchSimilarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(final rd3.a r110, String r111, final View r210, final d r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        this.f176070a = r110;
        this.f176071b = r111;
        Promotion r100 = r110.f();
        if (r100 == null) goto L9;
        PromotionProductStruct r101 = r100.getPromotionInfo();
        if (r101 == null) goto L9;
        PromotionProductExtraStruct r102 = r101.getExtraInfo();
        if (r102 == null) goto L9;
        final String r103 = r102.getImgSearchSchema();
    L10:
        Promotion r104 = r110.f();
        if (r104 == null) goto L18;
        PromotionProductStruct r105 = r104.getPromotionInfo();
        if (r105 == null) goto L18;
        PromotionProductBaseStruct r106 = r105.getBaseInfo();
        if (r106 == null) goto L18;
        String r107 = r106.getProductId();
        if (r107 == null) goto L18;
    L19:
        final String r112 = r107;
        ECDraweeView r108 = this.f176073d;
        if (r108 == null) goto L22;
        h0.e(r108, r111, new r("ec_goods_feed", "ec_goods_feed_default"), null, null, 120);
    L22:
        LinearLayout r109 = this.f176072c;
        if (r109 == null) goto L25;
        f.c(r109, null, null, new SearchSimilarView$bind$2(this, r103, r210, r110, r112, r211), 3);
    L25:
        FeedProductEventTracker r113 = FeedProductEventTracker.f174442a;
        String r114 = k.d(CollectionsKt.emptyList());
        String r115 = LocationType.INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK.getType();
        String r116 = r110.f537237d;
        r113.getClass();
        FeedProductEventTracker.w("inflow_low_price_entrance_show", r110, r114, r115, "c12364.d714373", r112, r116);
        return;
    L18:
        r107 = "";
    L9:
        r103 = null;
        goto L10
    }
}
