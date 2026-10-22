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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.integrated.counter.CJPayUIStyleUtils;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayPaymentMethodUtils;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayViewHolderUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000201H\u0014J\u0010\u00105\u001a\u0002062\u0006\u00100\u001a\u000201H\u0004J\u0012\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020;H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u000206H\u0002J\u0018\u0010A\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010B\u001a\u000206H\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u0014\u0010\u001e\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\u00020!X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020%X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020%X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'¨\u0006D"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/viewholder/SingleTypeViewHolder;", "Lcom/android/ttcjpaysdk/integrated/counter/viewholder/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrowView", "Landroid/widget/ImageView;", "getArrowView", "()Landroid/widget/ImageView;", "checkboxView", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", "getCheckboxView", "()Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", "contentLayout", "Landroid/widget/LinearLayout;", "getContentLayout", "()Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dividerView", "getDividerView", "()Landroid/view/View;", "iconLayout", "Landroid/widget/FrameLayout;", "getIconLayout", "()Landroid/widget/FrameLayout;", "iconMaskView", "getIconMaskView", "iconView", "getIconView", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "recommendView", "Landroid/widget/TextView;", "getRecommendView", "()Landroid/widget/TextView;", "subTitleView", "getSubTitleView", "subTitleViewIcon", "getSubTitleViewIcon", "titleView", "getTitleView", "bindData", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "getClickListener", "Landroid/view/View$OnClickListener;", "paymentMethodInfo", "getIsEnable", "", "getIsInsufficient", "cardNo", "", "getSubTitleColorRes", "", "getTitleColorRes", "getUnableColorRes", "loaderIcon", "updateLoading", "isLoading", "updateViewEnableColor", "subTitleColorSameToTitle", "updateViewForFromType", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SingleTypeViewHolder extends BaseViewHolder {
    private final ImageView arrowView;
    private final CJPayCircleCheckBox checkboxView;
    private final LinearLayout contentLayout;
    private final Context context;
    private final View dividerView;
    private final FrameLayout iconLayout;
    private final ImageView iconMaskView;
    private final ImageView iconView;
    private final ProgressBar loadingView;
    private final TextView recommendView;
    private final TextView subTitleView;
    private final TextView subTitleViewIcon;
    private final TextView titleView;

    public int getSubTitleColorRes() {
        return this.context.getResources().getColor(R.color.cj_pay_color_gray_153);
    }

    public int getTitleColorRes() {
        return this.context.getResources().getColor(R.color.cj_pay_color_black_34);
    }

    public int getUnableColorRes() {
        return this.context.getResources().getColor(R.color.cj_pay_color_gray_202);
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

    public final View getDividerView() {
        return this.dividerView;
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

    public final TextView getRecommendView() {
        return this.recommendView;
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

    public SingleTypeViewHolder(View r100) {
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
    }

    private final boolean getIsInsufficient(String r100) {
        return CJPayPaymentMethodUtils.Companion.getIsInsufficient(r100);
    }

    private final void updateLoading(boolean r100) {
        if (this.arrowView.getVisibility() == 0) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.arrowView.setVisibility(8);
        this.loadingView.setVisibility(0);
        return;
    L7:
        this.arrowView.setVisibility(0);
        this.loadingView.setVisibility(8);
    }

    private final void updateViewForFromType(PaymentMethodInfo r100) {
        if (Intrinsics.areEqual("balance", r100.paymentType) == false) goto L9;
        this.arrowView.setVisibility(8);
        if (r100.isCardAvailable() == false) goto L7;
        this.checkboxView.setVisibility(0);
    L23:
        ViewGroup.LayoutParams r101 = this.dividerView.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r101).setMargins(CJPayBasicUtils.dipToPX(this.context, 16.0f), 0, 0, 0);
        return;
    L7:
        this.checkboxView.setVisibility(8);
        goto L23
    L9:
        if (Intrinsics.areEqual("quickpay", r100.paymentType) == false) goto L20;
        if (r100.isCardInactive() == false) goto L14;
        this.arrowView.setVisibility(0);
        this.checkboxView.setVisibility(8);
        goto L23
    L14:
        if (r100.isCardAvailable() == true) goto L16;
    L18:
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(8);
        goto L23
    L16:
        if (getIsInsufficient(r100.card_no) == true) goto L18;
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(0);
        goto L23
    L20:
        if (Intrinsics.areEqual("qrcode", r100.paymentType) == false) goto L22;
        this.arrowView.setVisibility(0);
        this.checkboxView.setVisibility(8);
        goto L23
    L22:
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(0);
        goto L23
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder
    public void bindData(PaymentMethodInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        super.bindData(r110);
        CJPayViewHolderUtils.Companion r100 = CJPayViewHolderUtils.Companion;
        r100.setIconSize(this.iconLayout, this.iconView, this.iconMaskView, CJPayBasicUtils.dipToPX(this.context, 24.0f));
        loaderIcon(r110);
        if (TextUtils.isEmpty(r110.title) == false) goto L7;
        if (TextUtils.isEmpty(r110.mark) == false) goto L7;
    L11:
        ViewGroup.LayoutParams r101 = this.iconLayout.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r101).setMargins(CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f));
    L13:
        boolean r111 = r100.setTitleWithEllipsize(this.context, this.titleView, this.recommendView, r110.title, r110.mark, 120.0f, Intrinsics.areEqual("quickpay", r110.paymentType));
        r100.setRecommendView(this.context, this.recommendView, r110.mark);
        Context r102 = this.context;
        TextView r103 = this.subTitleView;
        TextView r104 = this.subTitleViewIcon;
        String r105 = r110.sub_title_icon;
        String r106 = r110.sub_title;
        int r107 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r102) - CJPayBasicUtils.dipToPX(this.context, 108.0f);
        boolean r108 = getIsInsufficient(r110.card_no);
        if (r111 == false) goto L28;
        String r109 = r110.title;
        List<String> r112 = new Regex("[（|）|(|)]").split(r109, 0);
        if (r112.isEmpty() == true) goto L26;
        ListIterator<String> r113 = r112.listIterator(r112.size());
    L19:
        if (r113.hasPrevious() == false) goto L26;
        if (r113.previous().length() != 0) goto L23;
        boolean r114 = true;
    L24:
        if (r114 == true) goto L19;
        List r115 = CollectionsKt.take(r112, r113.nextIndex() + 1);
    L27:
        String r116 = ((String[]) r115.toArray(new String[0]))[1];
    L29:
        r100.setSubTitleAndSubIcon(r102, r103, r104, r105, r106, r107, r108, r116);
        updateViewEnableColor(r110, r111);
        updateViewForFromType(r110);
        this.dividerView.setVisibility(0);
        updateLoading(r110.isLoading);
        if (r110.is_sign_withholding == false) goto L38;
        CJPayViewHolderUtils.Companion r117 = CJPayViewHolderUtils.Companion;
        Context r118 = this.context;
        r117.setRecommendView(r118, this.recommendView, r118.getResources().getString(R.string.cj_pay_counter_outer_pay_signed));
        CJPayUIStyleUtils.Companion.updateLabel(this.recommendView, this.context, "#7E161823", "#7E161823", "#00000000", 2.0f);
        this.checkboxView.setUnavailable();
        return;
    L38:
        return;
    L23:
        r114 = false;
    L26:
        r115 = CollectionsKt.emptyList();
        goto L27
    L28:
        r116 = null;
    L7:
        if (TextUtils.isEmpty(r110.sub_title) == true) goto L9;
    L12:
        ViewGroup.LayoutParams r119 = this.iconLayout.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r119).setMargins(CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 18.0f), CJPayBasicUtils.dipToPX(this.context, 16.0f), CJPayBasicUtils.dipToPX(this.context, 18.0f));
        goto L13
    L9:
        if (TextUtils.isEmpty(r110.sub_title_icon) == true) goto L11;
        goto L11
    }

    public View.OnClickListener getClickListener(final PaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "paymentMethodInfo");
        return new AnonymousClass1(r100, this);
    }

    public final boolean getIsEnable(PaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        boolean r101 = getIsInsufficient(r100.card_no);
        if (r100.isCardAvailable() == false) goto L5;
    L6:
        if (r101 == true) goto L8;
        return true;
    L8:
        return false;
    L5:
        if (r100.isCardInactive() == false) goto L8;
        goto L6
    }

    public void loaderIcon(PaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        CJPayViewHolderUtils.Companion.setIconUrl(this.iconView, this.iconMaskView, r100.icon_url, getIsEnable(r100));
    }

    private final void updateViewEnableColor(PaymentMethodInfo r100, boolean r101) {
        boolean r102 = getIsEnable(r100);
        CJPayUIStyleUtils.Companion r103 = CJPayUIStyleUtils.Companion;
        r103.updateLabelStyle(this.recommendView, this.context, r102, 5);
        r103.updateLabelStyle(this.subTitleViewIcon, this.context, r102, 5);
        if (r102 == false) goto L26;
        int r104 = getSubTitleColorRes();
        int r105 = getTitleColorRes();
        this.titleView.setTextColor(r105);
        CounterResponseBean r106 = ShareData.checkoutResponseBean;     // Catch: Exception -> L20
        if (r106 != null) goto L8;
    L14:
        TextView r107 = this.subTitleView;     // Catch: Exception -> L20
        if (r101 == false) goto L17;
        int r108 = r105;
    L18:
        r107.setTextColor(r108);     // Catch: Exception -> L20
    L25:
        this.checkboxView.setEnabled(true);
        this.itemView.setOnClickListener(getClickListener(r100));
        this.checkboxView.setOnClickListener(getClickListener(r100));
        this.checkboxView.setWithCircleWhenUnchecked(true);
        this.checkboxView.setChecked(r100.isChecked);
        return;
    L17:
        r108 = r104;
        goto L18
    L8:
        if (TextUtils.isEmpty(r106.data.cashdesk_show_conf.theme.pay_type_msg_color) == true) goto L14;
        TextView r109 = this.subTitleView;     // Catch: Exception -> L20
        if (r101 == false) goto L12;
        int r110 = r105;
    L13:
        r109.setTextColor(r110);     // Catch: Exception -> L20
        goto L25
    L12:
        r110 = Color.parseColor(ShareData.checkoutResponseBean.data.cashdesk_show_conf.theme.pay_type_msg_color);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SingleTypeViewHolder#updateViewEnableColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SingleTypeViewHolder#updateViewEnableColor", e);
        TextView r111 = this.subTitleView;
        if (r101 == false) goto L24;
        r104 = r105;
    L24:
        r111.setTextColor(r104);
        goto L25
    L26:
        int r112 = getUnableColorRes();
        this.titleView.setTextColor(r112);
        this.subTitleView.setTextColor(r112);
        this.checkboxView.setEnabled(false);
        this.itemView.setOnClickListener(null);
        this.checkboxView.setOnClickListener(null);
        this.checkboxView.setWithCircleWhenUnchecked(false);
        this.checkboxView.setChecked(false);
    }
}
