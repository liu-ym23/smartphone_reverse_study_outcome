package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv3.repository.dto.FeedCardStyle;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/GuessULikeProductCardDetailView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardDetailView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeProductCardDetailView extends BaseCardDetailView {
    public static final /* synthetic */ int Q = 0;

    public static final class a {
    }

    static {
    }

    public GuessULikeProductCardDetailView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GuessULikeProductCardDetailView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void e() {
        FeedProductEventTracker r100 = FeedProductEventTracker.f174442a;
        Context r101 = getContext();
        r100.getClass();
        FeedProductEventTracker.A(r101, "click_inflow_similar_tab", true, null);
    }

    public static DisplayMetrics i(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void b(Function3<? super View, ? super String, ? super String, Unit> r100, rd3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "detailOnClickListener");
        super.b(r100, r101);
        if (r101 == null) goto L53;
        ProductFeedViewModel r102 = r101.f537236c;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.B == true) goto L38;
        InnerFlowPageStyleDTO r103 = r102.getInnerFlowPageStyle();
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L14;
        FeedCardStyle r105 = r103.getFeedCardStyle();
        if (r105 == null) goto L14;
        Integer r106 = r105.getCardSpacing();
    L15:
        if (r106 == null) goto L38;
        if (r106.intValue() != 1) goto L38;
        ViewGroup.LayoutParams r107 = getPriceAndSalesView().getLayoutParams();
        if ((r107 instanceof LinearLayout.LayoutParams) == true) goto L22;
        r107 = null;
    L22:
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
        if (r108 == null) goto L25;
        r108.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, i(Resources.getSystem())));
    L25:
        ViewGroup.LayoutParams r109 = getProductTitleView().getLayoutParams();
        if ((r109 instanceof LinearLayout.LayoutParams) == true) goto L28;
        r109 = null;
    L28:
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r109;
        if (r110 == null) goto L31;
        r110.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, i(Resources.getSystem())));
    L31:
        ViewGroup.LayoutParams r111 = getBottomBarView().getLayoutParams();
        if ((r111 instanceof LinearLayout.LayoutParams) == false) goto L35;
        r104 = r111;
    L35:
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r104;
        if (r112 == null) goto L38;
        float r113 = 12;
        r112.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r113, i(Resources.getSystem())));
        r112.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r113, i(Resources.getSystem())));
    L14:
        r106 = null;
    L38:
        InnerFlowPageStyleDTO r114 = r102.getInnerFlowPageStyle();
        if (r114 == null) goto L51;
        PageStyle r115 = r114.getPageStyle();
        if (r115 == null) goto L51;
        if (r115.isGuessULikeShowSearchPdt() != true) goto L51;
        InnerFlowPageStyleDTO r116 = r102.getInnerFlowPageStyle();
        if (r116 == null) goto L51;
        PageStyle r117 = r116.getPageStyle();
        if (r117 == null) goto L51;
        if (r117.getSearchPdtStyle() != 1) goto L51;
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f175760h.setOnClickListener(new com.bytedance.android.shopping.feed.widget.a(this));
        getSameProductEntrance().setVisibility(0);
        getProductTitleDivider().setVisibility(0);
        return;
    L51:
        getSameProductEntrance().setVisibility(8);
        getProductTitleDivider().setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuessULikeProductCardDetailView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewGroup.LayoutParams r103 = null;
        setCardHeaderView(new GuessULikeProductCardHeaderView(r100, 0 == true ? 1 : 0, 6, 0));
        getHeaderViewContainer().addView(getCardHeaderView(), new FrameLayout.LayoutParams(-1, -2));
        if (this.B == true) goto L36;
        ProductFeedViewModel r104 = getViewModel();
        if (r104 == null) goto L11;
        InnerFlowPageStyleDTO r105 = r104.getInnerFlowPageStyle();
        if (r105 == null) goto L11;
        FeedCardStyle r106 = r105.getFeedCardStyle();
        if (r106 == null) goto L11;
        Integer r107 = r106.getCardSpacing();
    L12:
        if (r107 != null) goto L15;
        return;
    L15:
        if (r107.intValue() != 1) goto L37;
        ViewGroup.LayoutParams r108 = getPriceAndSalesView().getLayoutParams();
        if ((r108 instanceof LinearLayout.LayoutParams) == true) goto L19;
        r108 = null;
    L19:
        LinearLayout.LayoutParams r109 = (LinearLayout.LayoutParams) r108;
        if (r109 == null) goto L22;
        r109.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, i(Resources.getSystem())));
    L22:
        ViewGroup.LayoutParams r110 = getProductTitleView().getLayoutParams();
        if ((r110 instanceof LinearLayout.LayoutParams) == true) goto L25;
        r110 = null;
    L25:
        LinearLayout.LayoutParams r111 = (LinearLayout.LayoutParams) r110;
        if (r111 == null) goto L28;
        r111.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, i(Resources.getSystem())));
    L28:
        ViewGroup.LayoutParams r112 = getBottomBarView().getLayoutParams();
        if ((r112 instanceof LinearLayout.LayoutParams) == false) goto L32;
        r103 = r112;
    L32:
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) r103;
        if (r113 == null) goto L38;
        float r114 = 12;
        r113.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r114, i(Resources.getSystem())));
        r113.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r114, i(Resources.getSystem())));
        return;
    L38:
        return;
    L37:
        return;
    L11:
        r107 = null;
        goto L12
    }

    public /* synthetic */ GuessULikeProductCardDetailView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
