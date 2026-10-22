package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/MainProductCardDetailView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardDetailView;", "", "factor", "", "setHeaderInfoViewAlpha", "", "visible", "setProductAttentionVisible", "Landroid/view/ViewGroup;", "Q", "Landroid/view/ViewGroup;", "getSkeletonView", "()Landroid/view/ViewGroup;", "setSkeletonView", "(Landroid/view/ViewGroup;)V", "skeletonView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardDetailView extends BaseCardDetailView {
    public static final /* synthetic */ int R = 0;
    public ViewGroup Q;

    public static final class a {
    }

    static {
    }

    public MainProductCardDetailView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MainProductCardDetailView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void e() {
        FeedProductEventTracker r100 = FeedProductEventTracker.f174442a;
        Context r101 = getContext();
        r100.getClass();
        FeedProductEventTracker.A(r101, "click_inflow_similar_tab", true, "product_info");
    }

    public final ViewGroup getSkeletonView() {
        return this.Q;
    }

    public final void setHeaderInfoViewAlpha(float r100) {
        BaseCardHeaderView r101 = getCardHeaderView();
        if (r101 == null) goto L7;
        ((MainProductCardHeaderView) r101).setInfoViewTransitionAlpha(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    }

    public final void setProductAttentionVisible(boolean r100) {
        BaseCardHeaderView r101 = getCardHeaderView();
        if (r101 == null) goto L7;
        ((MainProductCardHeaderView) r101).setProductAttentionVisible(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    }

    public final void setSkeletonView(ViewGroup r100) {
        this.Q = r100;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardDetailView
    public final void b(Function3<? super View, ? super String, ? super String, Unit> r100, rd3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "detailOnClickListener");
        getPriceAndSalesView().setVisibility(0);
        getPriceContainer().setVisibility(0);
        getBarContainer().setVisibility(0);
        getExtraInfoContainer().setVisibility(0);
        getDiscountInfoContainer().setVisibility(0);
        getProductTitleView().setVisibility(0);
        getBottomBarView().setVisibility(0);
        ViewGroup r102 = this.Q;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        super.b(r100, r101);
        ProductFeedViewModel r103 = getViewModel();
        if (r103 == null) goto L25;
        InnerFlowPageStyleDTO r104 = r103.getInnerFlowPageStyle();
        if (r104 == null) goto L25;
        PageStyle r105 = r104.getPageStyle();
        if (r105 == null) goto L25;
        if (r105.getSearchPdtSwitch() != 1) goto L25;
        ProductFeedViewModel r106 = getViewModel();
        if (r106 == null) goto L25;
        InnerFlowPageStyleDTO r107 = r106.getInnerFlowPageStyle();
        if (r107 == null) goto L25;
        PageStyle r108 = r107.getPageStyle();
        if (r108 == null) goto L25;
        if (r108.getSearchPdtStyle() != 1) goto L25;
        ProductFeedViewModel r109 = getViewModel();
        if (r109 == null) goto L24;
        Intrinsics.checkNotNullParameter(r109, "viewModel");
        this.f175760h.setOnClickListener(new com.bytedance.android.shopping.feed.widget.a(this));
        getSameProductEntrance().setVisibility(0);
        getProductTitleDivider().setVisibility(0);
    L26:
        p r110 = new p(this);
        if (ld3.d.e(ld3.d.b()) == false) goto L32;
        ViewTreeObserver r111 = getViewTreeObserver();
        if (r111 == null) goto L33;
        r111.addOnGlobalLayoutListener(r110);
        return;
    L33:
        return;
    L32:
        return;
    L24:
        getSameProductEntrance().setVisibility(8);
        getProductTitleDivider().setVisibility(8);
    L25:
        getSameProductEntrance().setVisibility(8);
        getProductTitleDivider().setVisibility(8);
        goto L26
    }

    public MainProductCardDetailView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AttributeSet r103 = null;
        setCardHeaderView(new MainProductCardHeaderView(r100, r103, 6, 0));
        getHeaderViewContainer().addView(getCardHeaderView(), new FrameLayout.LayoutParams(-1, -2));
    }

    public /* synthetic */ MainProductCardDetailView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
