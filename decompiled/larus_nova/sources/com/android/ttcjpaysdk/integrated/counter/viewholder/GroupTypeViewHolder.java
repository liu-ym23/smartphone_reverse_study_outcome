package com.android.ttcjpaysdk.integrated.counter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.integrated.counter.CJPayUIStyleUtils;
import com.android.ttcjpaysdk.integrated.counter.adapter.CJPayConfirmAdapter;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.data.QuickPay;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayDiscountUtils;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayPaymentMethodUtils;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayViewHolderUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020VH\u0002J\u0010\u0010Z\u001a\u00020X2\u0006\u0010Y\u001a\u00020VH\u0002J\u0010\u0010[\u001a\u00020X2\u0006\u0010Y\u001a\u00020VH\u0002J\u0010\u0010\\\u001a\u0002052\u0006\u0010U\u001a\u00020VH\u0002J\u0012\u0010]\u001a\u0002052\b\u0010^\u001a\u0004\u0018\u00010_H\u0002J\b\u0010`\u001a\u00020aH\u0016J0\u0010b\u001a\u00020T2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010c\u001a\u00020_H\u0002J\u0012\u0010d\u001a\u0002052\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0012\u0010e\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u001a\u0010f\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010g\u001a\u000205H\u0002J\u0018\u0010h\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010i\u001a\u000205H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0014\u0010&\u001a\u00020'X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0014\u0010,\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R\u0014\u0010.\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0018R\u0014\u00100\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\bR\u0014\u00102\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\bR\u001a\u00104\u001a\u000205X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020'X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0014\u0010;\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0018R\u0014\u0010=\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0014\u0010?\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0014\u0010A\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001fR\u0014\u0010C\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u001fR\u0014\u0010E\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u001fR\u0014\u0010G\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001fR\u0014\u0010I\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001fR\u0014\u0010K\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001bR\u0014\u0010M\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u001fR\u0014\u0010O\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001fR\u0014\u0010Q\u001a\u00020\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u001f¨\u0006j"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/viewholder/GroupTypeViewHolder;", "Lcom/android/ttcjpaysdk/integrated/counter/viewholder/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrowView", "Landroid/widget/ImageView;", "getArrowView", "()Landroid/widget/ImageView;", "checkboxView", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", "getCheckboxView", "()Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", "contentLayout", "Landroid/widget/LinearLayout;", "getContentLayout", "()Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "detailSectionViewLayout", "Landroid/widget/FrameLayout;", "getDetailSectionViewLayout", "()Landroid/widget/FrameLayout;", "discountBannerArrow", "getDiscountBannerArrow", "()Landroid/view/View;", "discountBannerButton", "Landroid/widget/TextView;", "getDiscountBannerButton", "()Landroid/widget/TextView;", "discountBannerLayout", "Landroid/view/ViewGroup;", "getDiscountBannerLayout", "()Landroid/view/ViewGroup;", "discountBannerTextView", "getDiscountBannerTextView", "discountLoading", "Landroid/widget/ProgressBar;", "getDiscountLoading", "()Landroid/widget/ProgressBar;", "dividerView", "getDividerView", "guideSectionViewLayout", "getGuideSectionViewLayout", "iconLayout", "getIconLayout", "iconMaskView", "getIconMaskView", "iconView", "getIconView", "isDetailContentSingle", "", "()Z", "setDetailContentSingle", "(Z)V", "loadingView", "getLoadingView", "mergeIconLayout", "getMergeIconLayout", "mergeIconMaskView", "getMergeIconMaskView", "mergeIconView", "getMergeIconView", "mergeRecommendView", "getMergeRecommendView", "mergeSubTitleView", "getMergeSubTitleView", "mergeSubTitleViewIcon", "getMergeSubTitleViewIcon", "mergeTitleView", "getMergeTitleView", "recommendView", "getRecommendView", "sectionDividerView", "getSectionDividerView", "subTitleView", "getSubTitleView", "subTitleViewIcon", "getSubTitleViewIcon", "titleView", "getTitleView", "bindData", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "getBannerLayoutClickListener", "Landroid/view/View$OnClickListener;", "paymentMethodInfo", "getClickListener", "getDetailSectionViewLayoutClickListener", "getIsEnable", "getIsInsufficient", "cardNo", "", "getTitleColorRes", "", "setDiscountsInfoWithLength", "label", "updateDiscountBanner", "updateDiscountLabel", "updateDividerForFromType", "isShowDiscountBanner", "updateViewEnableColor", "subTitleColorSameToTitle", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class GroupTypeViewHolder extends BaseViewHolder {
    private final ImageView arrowView;
    private final CJPayCircleCheckBox checkboxView;
    private final LinearLayout contentLayout;
    private final Context context;
    private final FrameLayout detailSectionViewLayout;
    private final View discountBannerArrow;
    private final TextView discountBannerButton;
    private final ViewGroup discountBannerLayout;
    private final TextView discountBannerTextView;
    private final ProgressBar discountLoading;
    private final View dividerView;
    private final FrameLayout guideSectionViewLayout;
    private final FrameLayout iconLayout;
    private final ImageView iconMaskView;
    private final ImageView iconView;
    private boolean isDetailContentSingle;
    private final ProgressBar loadingView;
    private final FrameLayout mergeIconLayout;
    private final ImageView mergeIconMaskView;
    private final ImageView mergeIconView;
    private final TextView mergeRecommendView;
    private final TextView mergeSubTitleView;
    private final TextView mergeSubTitleViewIcon;
    private final TextView mergeTitleView;
    private final TextView recommendView;
    private final View sectionDividerView;
    private final TextView subTitleView;
    private final TextView subTitleViewIcon;
    private final TextView titleView;

    public int getTitleColorRes() {
        return this.context.getResources().getColor(R.color.cj_pay_color_black_34);
    }

    public final ImageView getArrowView() {
        return this.arrowView;
    }

    public final CJPayCircleCheckBox getCheckboxView() {
        return this.checkboxView;
    }

    public final LinearLayout getContentLayout() {
        return this.contentLayout;
    }

    public final Context getContext() {
        return this.context;
    }

    public final FrameLayout getDetailSectionViewLayout() {
        return this.detailSectionViewLayout;
    }

    public final View getDiscountBannerArrow() {
        return this.discountBannerArrow;
    }

    public final TextView getDiscountBannerButton() {
        return this.discountBannerButton;
    }

    public final ViewGroup getDiscountBannerLayout() {
        return this.discountBannerLayout;
    }

    public final TextView getDiscountBannerTextView() {
        return this.discountBannerTextView;
    }

    public final ProgressBar getDiscountLoading() {
        return this.discountLoading;
    }

    public final View getDividerView() {
        return this.dividerView;
    }

    public final FrameLayout getGuideSectionViewLayout() {
        return this.guideSectionViewLayout;
    }

    public final FrameLayout getIconLayout() {
        return this.iconLayout;
    }

    public final ImageView getIconMaskView() {
        return this.iconMaskView;
    }

    public final ImageView getIconView() {
        return this.iconView;
    }

    public final ProgressBar getLoadingView() {
        return this.loadingView;
    }

    public final FrameLayout getMergeIconLayout() {
        return this.mergeIconLayout;
    }

    public final ImageView getMergeIconMaskView() {
        return this.mergeIconMaskView;
    }

    public final ImageView getMergeIconView() {
        return this.mergeIconView;
    }

    public final TextView getMergeRecommendView() {
        return this.mergeRecommendView;
    }

    public final TextView getMergeSubTitleView() {
        return this.mergeSubTitleView;
    }

    public final TextView getMergeSubTitleViewIcon() {
        return this.mergeSubTitleViewIcon;
    }

    public final TextView getMergeTitleView() {
        return this.mergeTitleView;
    }

    public final TextView getRecommendView() {
        return this.recommendView;
    }

    public final View getSectionDividerView() {
        return this.sectionDividerView;
    }

    public final TextView getSubTitleView() {
        return this.subTitleView;
    }

    public final TextView getSubTitleViewIcon() {
        return this.subTitleViewIcon;
    }

    public final TextView getTitleView() {
        return this.titleView;
    }

    public final boolean isDetailContentSingle() {
        return this.isDetailContentSingle;
    }

    public GroupTypeViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.context = r100.getContext();
        this.iconLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_payment_method_icon_layout);
        this.iconView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon);
        this.iconMaskView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon_unable_mask);
        this.contentLayout = (LinearLayout) r100.findViewById(R.id.cj_pay_payment_method_content_layout);
        this.titleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_title);
        this.recommendView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_recommend_icon);
        this.subTitleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_title);
        this.subTitleViewIcon = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_title_icon);
        this.arrowView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_arrow);
        this.loadingView = (ProgressBar) r100.findViewById(R.id.cj_pay_payment_method_loading);
        this.checkboxView = (CJPayCircleCheckBox) r100.findViewById(R.id.cj_pay_payment_method_checkbox);
        this.dividerView = r100.findViewById(R.id.cj_pay_bottom_divider);
        this.mergeIconLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_payment_method_merge_icon_layout);
        this.mergeIconView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_merge_icon);
        this.mergeIconMaskView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_merge_icon_unable_mask);
        this.guideSectionViewLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_payment_guide_section);
        this.sectionDividerView = r100.findViewById(R.id.cj_pay_middle_divider);
        this.detailSectionViewLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_payment_detail_section);
        this.mergeTitleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_merge_title);
        this.mergeRecommendView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_merge_recommend_icon);
        this.mergeSubTitleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_merge_sub_title);
        this.mergeSubTitleViewIcon = (TextView) r100.findViewById(R.id.cj_pay_payment_method_merge_sub_title_icon);
        this.discountBannerLayout = (ViewGroup) r100.findViewById(R.id.cj_pay_discount_more_layout);
        this.discountBannerArrow = r100.findViewById(R.id.cj_pay_icon_discount_more_arrow);
        this.discountBannerTextView = (TextView) r100.findViewById(R.id.cj_pay_discount_more_tv);
        this.discountBannerButton = (TextView) r100.findViewById(R.id.cj_pay_discount_more_btn);
        this.discountLoading = (ProgressBar) r100.findViewById(R.id.cj_pay_discount_more_loading);
    }

    private final View.OnClickListener getBannerLayoutClickListener(final PaymentMethodInfo r100) {
        return new AnonymousClass1(this, r100);
    }

    private final View.OnClickListener getClickListener(final PaymentMethodInfo r100) {
        return new ViewOnClickListenerC92551(this, r100);
    }

    private final View.OnClickListener getDetailSectionViewLayoutClickListener(final PaymentMethodInfo r100) {
        return new C92561(this, r100);
    }

    private final boolean getIsEnable(PaymentMethodInfo r100) {
        boolean r101 = getIsInsufficient(r100.card_no);
        if (r100.isCardAvailable() == false) goto L6;
        if (r101 == true) goto L6;
        return true;
    L6:
        return false;
    }

    private final boolean getIsInsufficient(String r100) {
        return CJPayPaymentMethodUtils.Companion.getIsInsufficient(r100);
    }

    private final boolean updateDiscountBanner(PaymentMethodInfo r100) {
        if (ShareData.checkoutResponseBean == null) goto L23;
        if (r100 == null) goto L23;
        QuickPay.PromotionInfo r101 = CJPayDiscountUtils.Companion.getPromotionInfo(ShareData.checkoutResponseBean);
        if (TextUtils.isEmpty(r100.voucher_info.vouchers_label) == true) goto L9;
    L13:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        this.discountBannerLayout.setVisibility(0);
        this.discountBannerArrow.setVisibility(0);
        this.discountBannerTextView.setText(r101.card_banner);
        this.discountBannerButton.setText(r101.card_banner_button_label);
        this.discountBannerLayout.setOnClickListener(getBannerLayoutClickListener(r100));
    L19:
        if (CJPayConfirmAdapter.Companion.isBannerLoading() == false) goto L21;
        this.discountLoading.setVisibility(0);
        this.discountBannerButton.setText("");
    L22:
        return r102;
    L21:
        this.discountLoading.setVisibility(8);
        this.discountBannerButton.setText(r101.card_banner_button_label);
        goto L22
    L17:
        this.discountBannerLayout.setVisibility(8);
        this.discountBannerArrow.setVisibility(8);
        this.discountBannerLayout.setOnClickListener(null);
        goto L19
    L9:
        if (TextUtils.isEmpty(r101.card_banner) == true) goto L13;
        if (TextUtils.isEmpty(r101.card_banner_button_label) == true) goto L13;
        r102 = true;
    L23:
        return false;
    }

    private final void updateDiscountLabel(PaymentMethodInfo r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.voucher_info.vouchers_label) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100.mark) == true) goto L10;
        this.subTitleViewIcon.setText(r100.voucher_info.vouchers_label);
        return;
    L10:
        setDiscountsInfoWithLength(this.titleView, this.recommendView, this.subTitleView, this.subTitleViewIcon, r100.voucher_info.vouchers_label);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder
    public void bindData(PaymentMethodInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        super.bindData(r110);
        CJPayViewHolderUtils.Companion r100 = CJPayViewHolderUtils.Companion;
        r100.setIconSize(this.mergeIconLayout, this.mergeIconView, this.mergeIconMaskView, CJPayBasicUtils.dipToPX(this.context, 24.0f));
        r100.setIconUrl(this.mergeIconView, this.mergeIconMaskView, r110.tt_icon_url, true);
        r100.setTitleWithEllipsize(this.context, this.mergeTitleView, this.mergeRecommendView, r110.tt_title, r110.tt_mark, 120.0f, false);
        CJPayUIStyleUtils.Companion r111 = CJPayUIStyleUtils.Companion;
        r111.updateLabelStyle(this.mergeRecommendView, this.context, getIsEnable(r110), 5);
        r100.setRecommendView(this.context, this.mergeRecommendView, r110.tt_mark);
        Context r101 = this.context;
        r100.setSubTitleAndSubIcon(r101, this.mergeSubTitleView, this.mergeSubTitleViewIcon, r110.tt_sub_title_icon, r110.tt_sub_title, CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r101) - CJPayBasicUtils.dipToPX(this.context, 96.0f), false, null);
        r111.updateLabelStyle(this.mergeSubTitleViewIcon, this.context, getIsEnable(r110), 5);
        if (TextUtils.isEmpty(r110.tt_title) == false) goto L7;
        if (TextUtils.isEmpty(r110.tt_mark) == false) goto L7;
    L11:
        ViewGroup.LayoutParams r102 = this.mergeIconLayout.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r102).setMargins(CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f));
    L13:
        r100.setIconSize(this.iconLayout, this.iconView, this.iconMaskView, CJPayBasicUtils.dipToPX(this.context, 24.0f));
        if (Intrinsics.areEqual("addcard", r110.paymentType) == false) goto L17;
        this.iconView.setTag(null);
        this.iconMaskView.setTag(null);
        this.iconView.setImageResource(R.drawable.cj_pay_icon_add_new_style);
        this.iconMaskView.setVisibility(8);
        this.iconLayout.setVisibility(0);
        this.contentLayout.setPadding(CJPayBasicUtils.dipToPX(this.context, 30.0f), 0, 0, 0);
    L20:
        Context r103 = this.context;
        TextView r104 = this.titleView;
        TextView r105 = this.recommendView;
        String r106 = r110.title;
        String r107 = r110.mark;
        if (Intrinsics.areEqual("addcard", r110.paymentType) == false) goto L23;
        float r112 = 130.0f;
    L24:
        boolean r113 = Intrinsics.areEqual("quickpay", r110.paymentType);
        boolean r108 = r100.setTitleWithEllipsize(r103, r104, r105, r106, r107, r112, r113);
        r100.setRecommendView(this.context, this.recommendView, r110.mark);
        this.checkboxView.setWithCircleWhenUnchecked(true);
        this.checkboxView.setChecked(r110.isChecked);
        this.mergeTitleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_black_34));
        updateViewEnableColor(r110, r108);
        if (CJPayConfirmAdapter.Companion.isLoading() == false) goto L27;
        this.arrowView.setVisibility(8);
        this.loadingView.setVisibility(0);
    L28:
        Context r109 = this.context;
        TextView r114 = this.subTitleView;
        TextView r115 = this.subTitleViewIcon;
        String r116 = r110.sub_title_icon;
        String r117 = r110.sub_title;
        int r118 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r109);
        if (Intrinsics.areEqual("addcard", r110.paymentType) == false) goto L31;
        Context r119 = this.context;
        float r120 = 122.0f;
    L32:
        int r121 = r118 - CJPayBasicUtils.dipToPX(r119, r120);
        boolean r122 = getIsInsufficient(r110.card_no);
        if (r108 == false) goto L47;
        String r123 = r110.title;
        List<String> r124 = new Regex("[（|）|(|)]").split(r123, 0);
        if (r124.isEmpty() == true) goto L45;
        ListIterator<String> r125 = r124.listIterator(r124.size());
    L38:
        if (r125.hasPrevious() == false) goto L45;
        if (r125.previous().length() != 0) goto L42;
        boolean r126 = true;
    L43:
        if (r126 == true) goto L38;
        List r127 = CollectionsKt.take(r124, r125.nextIndex() + 1);
    L46:
        String r128 = ((String[]) r127.toArray(new String[0]))[1];
    L48:
        this.isDetailContentSingle = r100.setSubTitleAndSubIcon(r109, r114, r115, r116, r117, r121, r122, r128);
        updateDiscountLabel(r110);
        boolean r129 = updateDiscountBanner(r110);
        this.detailSectionViewLayout.setOnClickListener(getDetailSectionViewLayoutClickListener(r110));
        this.arrowView.setOnClickListener(getDetailSectionViewLayoutClickListener(r110));
        if (Intrinsics.areEqual("addcard", r110.paymentType) == true) goto L51;
        this.guideSectionViewLayout.setVisibility(0);
    L56:
        if (this.isDetailContentSingle == true) goto L58;
        ViewGroup.LayoutParams r130 = this.arrowView.getLayoutParams();
        Intrinsics.checkNotNull(r130, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r130).setMargins(0, CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f));
        ViewGroup.LayoutParams r131 = this.loadingView.getLayoutParams();
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r131).setMargins(0, CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f));
    L59:
        updateDividerForFromType(r110, r129);
        return;
    L58:
        ViewGroup.LayoutParams r132 = this.arrowView.getLayoutParams();
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r132).setMargins(0, CJPayBasicUtils.dipToPX(this.context, 11.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 11.0f));
        ViewGroup.LayoutParams r133 = this.loadingView.getLayoutParams();
        Intrinsics.checkNotNull(r133, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r133).setMargins(0, CJPayBasicUtils.dipToPX(this.context, 11.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 11.0f));
        goto L59
    L51:
        if (r110.is_hide_merge_guide_section == false) goto L53;
        this.guideSectionViewLayout.setVisibility(8);
        goto L56
    L53:
        this.guideSectionViewLayout.setVisibility(0);
        goto L56
    L42:
        r126 = false;
    L45:
        r127 = CollectionsKt.emptyList();
        goto L46
    L47:
        r128 = null;
        goto L48
    L31:
        r119 = this.context;
        r120 = 96.0f;
        goto L32
    L27:
        this.arrowView.setVisibility(0);
        this.loadingView.setVisibility(8);
        goto L28
    L23:
        r112 = 120.0f;
        goto L24
    L17:
        if (TextUtils.isEmpty(r110.icon_url) == true) goto L19;
        this.iconView.setTag(r110.icon_url);
        this.iconMaskView.setTag(r110.icon_url);
        r100.loadImage(r110.icon_url, this.iconView, this.iconMaskView, getIsEnable(r110));
        this.iconLayout.setVisibility(8);
        this.contentLayout.setPadding(0, 0, 0, 0);
        goto L20
    L19:
        this.iconView.setTag(null);
        this.iconMaskView.setTag(null);
        this.iconView.setImageBitmap(null);
        this.iconMaskView.setVisibility(8);
        this.iconLayout.setVisibility(8);
        this.contentLayout.setPadding(0, 0, 0, 0);
    L7:
        if (TextUtils.isEmpty(r110.tt_sub_title) == true) goto L9;
    L12:
        ViewGroup.LayoutParams r134 = this.mergeIconLayout.getLayoutParams();
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r134).setMargins(CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 18.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 18.0f));
        goto L13
    L9:
        if (TextUtils.isEmpty(r110.tt_sub_title_icon) == true) goto L11;
        goto L11
    }

    public final void setDetailContentSingle(boolean r100) {
        this.isDetailContentSingle = r100;
    }

    private final void updateDividerForFromType(PaymentMethodInfo r100, boolean r101) {
        if (r100 != null) goto L4;
    L5:
        if (r101 == false) goto L7;
    L6:
        this.dividerView.setVisibility(8);
        return;
    L7:
        this.dividerView.setVisibility(0);
        return;
    L4:
        if (getIsEnable(r100) == false) goto L6;
        goto L5
    }

    private final void updateViewEnableColor(PaymentMethodInfo r100, boolean r101) {
        boolean r102 = getIsEnable(r100);
        CJPayUIStyleUtils.Companion r103 = CJPayUIStyleUtils.Companion;
        r103.updateLabelStyle(this.recommendView, this.context, r102, 5);
        r103.updateLabelStyle(this.subTitleViewIcon, this.context, r102, 5);
        if (r102 == false) goto L27;
        int r104 = getTitleColorRes();
        this.titleView.setTextColor(r104);
        CounterResponseBean r105 = ShareData.checkoutResponseBean;     // Catch: Exception -> L20
        if (r105 != null) goto L8;
    L14:
        TextView r106 = this.subTitleView;     // Catch: Exception -> L20
        if (r101 == false) goto L17;
        int r107 = r104;
    L18:
        r106.setTextColor(r107);     // Catch: Exception -> L20
    L26:
        this.checkboxView.setEnabled(true);
        this.itemView.setOnClickListener(getClickListener(r100));
        this.checkboxView.setOnClickListener(getClickListener(r100));
        return;
    L17:
        r107 = Color.parseColor("#999999");     // Catch: Exception -> L20
        goto L18
    L8:
        if (TextUtils.isEmpty(r105.data.cashdesk_show_conf.theme.pay_type_msg_color) == true) goto L14;
        TextView r108 = this.subTitleView;     // Catch: Exception -> L20
        if (r101 == false) goto L12;
        int r109 = r104;
    L13:
        r108.setTextColor(r109);     // Catch: Exception -> L20
        goto L26
    L12:
        r109 = Color.parseColor(ShareData.checkoutResponseBean.data.cashdesk_show_conf.theme.pay_type_msg_color);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("GroupTypeViewHolder#updateViewEnableColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "GroupTypeViewHolder#updateViewEnableColor", e);
        TextView r110 = this.subTitleView;
        if (r101 == true) goto L25;
        r104 = ColorProtector.parseColor("#999999");
    L25:
        r110.setTextColor(r104);
        goto L26
    L27:
        this.titleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_gray_202));
        this.subTitleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_gray_202));
        this.checkboxView.setEnabled(true);
        this.itemView.setOnClickListener(getClickListener(r100));
        this.checkboxView.setOnClickListener(getClickListener(r100));
    }

    private final void setDiscountsInfoWithLength(TextView r100, TextView r101, TextView r102, TextView r103, String r110) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (((int) r101.getPaint().measureText(r110)) <= ((CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this.context) - CJPayBasicUtils.dipToPX(this.context, 160.0f)) - r100.getMeasuredWidth())) goto L5;
        r102.setVisibility(8);
        r103.setVisibility(0);
        r103.setText(r110);
        return;
    L5:
        r103.setVisibility(8);
        r101.setVisibility(0);
        r101.setText(r110);
    }
}
