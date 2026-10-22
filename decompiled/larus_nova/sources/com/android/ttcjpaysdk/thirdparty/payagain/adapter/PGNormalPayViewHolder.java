package com.android.ttcjpaysdk.thirdparty.payagain.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.TextViewExtKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.ui.Utils.PaymentUIUtils;
import com.android.ttcjpaysdk.base.ui.data.ButtonInfoLabel;
import com.android.ttcjpaysdk.base.ui.data.LabelData;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import com.android.ttcjpaysdk.thirdparty.payagain.utils.PGPaymentMethodUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J(\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u00100\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u00101\u001a\u00020&H\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/PGNormalPayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isCombine", "", "useVoucherMsgV2", "isEnableCheckbox", "(Landroid/view/View;ZZZ)V", "arrowView", "Landroid/widget/ImageView;", "checkboxView", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "firstSubLabel", "Landroid/widget/TextView;", "iconMaskView", "iconView", "itemRootView", "loadingView", "Landroid/widget/ProgressBar;", "methodLabelTextView", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;)V", "recommendTagView", "secondSubLabel", "subTitleView", "titleView", "bindData", "", "info", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "foldBankInfoIfNeeded", "", "textView", "bankInfo", "", "labelView", "labelInfo", "getClickListener", "Landroid/view/View$OnClickListener;", "loadImage", "setLoadingView", "setRecommendTag", "spareWidth", "updateViewEnableColor", "updateViewForFromType", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PGNormalPayViewHolder extends RecyclerView.ViewHolder {
    private final ImageView arrowView;
    private final CJPayCircleCheckBox checkboxView;
    private final Context context;
    private final TextView firstSubLabel;
    private final ImageView iconMaskView;
    private final ImageView iconView;
    private final boolean isCombine;
    private final boolean isEnableCheckbox;
    private final View itemRootView;
    private final ProgressBar loadingView;
    private final TextView methodLabelTextView;
    private GroupStylePaymentMethodAdapter.OnGroupStyleMethodAdapterListener onMethodAdapterListener;
    private final TextView recommendTagView;
    private final TextView secondSubLabel;
    private final TextView subTitleView;
    private final TextView titleView;
    private final boolean useVoucherMsgV2;

    public final GroupStylePaymentMethodAdapter.OnGroupStyleMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    private final View.OnClickListener getClickListener(final FrontPaymentMethodInfo r100) {
        return new AnonymousClass1(r100, this);
    }

    private final void loadImage(FrontPaymentMethodInfo r100) {
        PGPaymentMethodUtils.INSTANCE.setIconUrl(this.iconView, this.iconMaskView, r100.icon_url, r100.isEnable());
    }

    private final void setLoadingView(FrontPaymentMethodInfo r100) {
        this.loadingView.setVisibility(8);
        if (r100.isEnable() == true) goto L5;
        return;
    L5:
        if (this.isEnableCheckbox == false) goto L8;
        return;
    L8:
        if (r100.isShowLoading == false) goto L10;
        this.arrowView.setVisibility(8);
        this.loadingView.setVisibility(0);
        return;
    L10:
        this.arrowView.setVisibility(0);
        this.loadingView.setVisibility(8);
    }

    private final void updateViewEnableColor(FrontPaymentMethodInfo r110) {
        PaymentUIUtils.Companion r100 = PaymentUIUtils.Companion;
        PaymentUIUtils.Companion.updateLabelStyle$default(r100, this.firstSubLabel, this.context, r110.isEnable(), 5, null, 16, null);
        PaymentUIUtils.Companion.updateLabelStyle$default(r100, this.secondSubLabel, this.context, r110.isEnable(), 5, null, 16, null);
        if (r110.isEnable() == false) goto L5;
        this.titleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_black_161823));
        this.subTitleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50));
        this.itemView.setOnClickListener(getClickListener(r110));
        return;
    L5:
        this.titleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_cashdesk_unable));
        this.subTitleView.setTextColor(this.context.getResources().getColor(R.color.cj_pay_color_cashdesk_unable));
        this.itemView.setOnClickListener(null);
    }

    private final void updateViewForFromType(FrontPaymentMethodInfo r100) {
        if (r100.isEnable() == true) goto L6;
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(8);
        return;
    L6:
        String r101 = r100.paymentType;
        if (r101 != null) goto L9;
        return;
    L9:
        switch(r101.hashCode()) {
            case -1787710669: goto L27;
            case -1581701048: goto L24;
            case -1184259671: goto L21;
            case -563976606: goto L18;
            case -339185956: goto L15;
            case -127611052: goto L12;
            default: goto L37;
        };
    L37:
        return;
    L12:
        if (r101.equals("new_bank_card") == true) goto L30;
        return;
    L30:
        if (this.isEnableCheckbox == false) goto L32;
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(0);
        return;
    L32:
        this.arrowView.setVisibility(0);
        return;
    L15:
        if (r101.equals("balance") == true) goto L30;
        return;
    L18:
        if (r101.equals("credit_pay") == true) goto L30;
        return;
    L21:
        if (r101.equals("income") == true) goto L30;
        return;
    L24:
        if (r101.equals("share_pay") == true) goto L30;
        return;
    L27:
        if (r101.equals("bank_card") == true) goto L30;
    }

    public void bindData(FrontPaymentMethodInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = 8;
        this.subTitleView.setVisibility(8);
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        ImageView r101 = this.iconView;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        ((ViewGroup.MarginLayoutParams) r103).width = CJPayBasicExtensionKt.dp(20.0f);
        ((ViewGroup.MarginLayoutParams) r103).height = CJPayBasicExtensionKt.dp(20.0f);
        r101.setLayoutParams(r103);
        ImageView r104 = this.iconMaskView;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        ((ViewGroup.MarginLayoutParams) r106).width = CJPayBasicExtensionKt.dp(20.0f);
        ((ViewGroup.MarginLayoutParams) r106).height = CJPayBasicExtensionKt.dp(20.0f);
        r104.setLayoutParams(r106);
        loadImage(r110);
        CJPayViewExtensionsKt.setTextAndVisible(this.methodLabelTextView, r110.select_page_guide_text);
        CJPayCircleCheckBox r107 = this.checkboxView;
        boolean r108 = true;
        r107.setIESNewStyle(true);
        r107.setWithCircleWhenUnchecked(true);
        r107.setChecked(r110.choose);
        updateViewEnableColor(r110);
        updateViewForFromType(r110);
        setLoadingView(r110);
        setRecommendTag(r110, foldBankInfoIfNeeded(this.titleView, r110.title, this.methodLabelTextView, r110.select_page_guide_text));
        if (this.useVoucherMsgV2 == false) goto L7;
        PGPaymentMethodUtils r109 = PGPaymentMethodUtils.INSTANCE;
        boolean r111 = r109.updateDiscountLabelV2ForCardList(r110, this.firstSubLabel, this.secondSubLabel, this.isCombine, this.context);
        if (r111 == true) goto L8;
        r111 = r109.updateDiscountLabelForCardList(r110, this.firstSubLabel, this.secondSubLabel, this.context);
    L8:
        boolean r112 = false;
        if (TextUtils.isEmpty(r110.msg) == true) goto L16;
        TextViewExtKt.showText(this.subTitleView, r110.msg);
        if (r110.isEnable() == true) goto L13;
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        r108 = false;
    L14:
        r112 = true;
    L43:
        if (r108 == false) goto L46;
        if (r112 == false) goto L46;
        ViewGroup.LayoutParams r113 = this.itemRootView.getLayoutParams();
        r113.height = CJPayBasicExtensionKt.dp(80.0f);
    L52:
        if (r110.isCardInactive() == false) goto L58;
        if (Intrinsics.areEqual(r110.status, "1") == false) goto L56;
        TextViewExtKt.showText(this.methodLabelTextView, r110.select_page_guide_text);
        return;
    L56:
        CJPayViewExtensionsKt.viewGone(this.methodLabelTextView);
        return;
    L58:
        if (r110.isEnable() == false) goto L66;
        TextView r114 = this.methodLabelTextView;
        if (r110.show_combine_pay == true) goto L62;
    L64:
        String r115 = r110.select_page_guide_text;
    L65:
        TextViewExtKt.showText(r114, r115);
        return;
    L62:
        if (r110.choose == false) goto L64;
        r115 = this.itemView.getContext().getResources().getString(R.string.cj_pay_combine_pay_method);
        goto L65
    L66:
        CJPayViewExtensionsKt.viewGone(this.methodLabelTextView);
        return;
    L46:
        if (r108 == true) goto L50;
        if (r112 == true) goto L50;
        ViewGroup.LayoutParams r116 = this.itemRootView.getLayoutParams();
        r116.height = CJPayBasicExtensionKt.dp(52.0f);
    L50:
        ViewGroup.LayoutParams r117 = this.itemRootView.getLayoutParams();
        r117.height = CJPayBasicExtensionKt.dp(59.0f);
        goto L52
    L13:
        r108 = r111;
        goto L14
    L16:
        if (r110.isCardInactive() == false) goto L42;
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        this.subTitleView.setVisibility(8);
        if (this.isEnableCheckbox == false) goto L20;
        this.checkboxView.setVisibility(0);
        this.arrowView.setVisibility(8);
        this.loadingView.setVisibility(8);
    L29:
        if (this.firstSubLabel.getText().length() <= 0) goto L31;
        boolean r118 = true;
    L32:
        if (r118 == false) goto L34;
        this.firstSubLabel.setVisibility(0);
        boolean r119 = true;
    L36:
        if (this.secondSubLabel.getText().length() <= 0) goto L38;
        boolean r120 = true;
    L39:
        if (r120 == false) goto L41;
        this.secondSubLabel.setVisibility(0);
        goto L43
    L41:
        r108 = r119;
        goto L43
    L38:
        r120 = false;
        goto L39
    L34:
        r119 = false;
        goto L36
    L31:
        r118 = false;
        goto L32
    L20:
        this.checkboxView.setVisibility(8);
        ImageView r121 = this.arrowView;
        if (r110.isShowLoading == false) goto L23;
        int r122 = 8;
    L24:
        r121.setVisibility(r122);
        ProgressBar r123 = this.loadingView;
        if (r110.isShowLoading == false) goto L27;
        r100 = 0;
    L27:
        r123.setVisibility(r100);
        goto L29
    L23:
        r122 = 0;
        goto L24
    L42:
        this.subTitleView.setVisibility(8);
        r108 = r111;
        goto L43
    L7:
        r111 = PGPaymentMethodUtils.INSTANCE.updateDiscountLabelForCardList(r110, this.firstSubLabel, this.secondSubLabel, this.context);
        goto L8
    }

    public final void setOnMethodAdapterListener(GroupStylePaymentMethodAdapter.OnGroupStyleMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }

    private final void setRecommendTag(FrontPaymentMethodInfo r100, int r101) {
        ButtonInfoLabel r102 = r100.bubble_info_map.paytype;
        Unit r103 = null;
        if (r102 == null) goto L19;
        List<LabelData> r104 = r102.label;
        if (r104 == null) goto L19;
        boolean r105 = true;
        if ((!r104.isEmpty()) == true) goto L9;
    L13:
        r105 = false;
    L14:
        if (r105 == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L19;
        CJPayViewExtensionsKt.setTextAndVisible(this.recommendTagView, ((LabelData) ListProtector.get(r104, 0)).text);
        r103 = Unit.INSTANCE;
        goto L19
    L9:
        if (TextUtils.isEmpty(((LabelData) ListProtector.get(r104, 0)).text) == true) goto L13;
        if ((this.recommendTagView.getPaint().measureText(((LabelData) ListProtector.get(r104, 0)).text) + CJPayBasicExtensionKt.dp(12.0f)) > r101) goto L13;
    L19:
        if (r103 != null) goto L22;
        this.recommendTagView.setVisibility(8);
        return;
    }

    public PGNormalPayViewHolder(View r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.isCombine = r101;
        this.useVoucherMsgV2 = r102;
        this.isEnableCheckbox = r103;
        this.context = r100.getContext();
        this.iconView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon);
        this.iconMaskView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon_unable_mask);
        this.titleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_title);
        this.subTitleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_title);
        this.firstSubLabel = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_label_first);
        this.secondSubLabel = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_label_second);
        this.arrowView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_arrow);
        this.checkboxView = (CJPayCircleCheckBox) r100.findViewById(R.id.cj_pay_payment_method_checkbox);
        this.loadingView = (ProgressBar) r100.findViewById(R.id.cj_pay_payment_method_loading);
        this.methodLabelTextView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_label);
        this.recommendTagView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_recommend_tag);
        this.itemRootView = r100.findViewById(R.id.cj_pay_item_normal_pay_root_layout);
    }

    private final int foldBankInfoIfNeeded(TextView r100, String r101, TextView r102, String r103) {
        int r104 = CJPayBasicExtensionKt.dp(12.0f);
        int r105 = CJPayBasicExtensionKt.dp(44.0f) + r104;
        int r106 = ((int) r102.getPaint().measureText(r103)) + CJPayBasicExtensionKt.dp(4.0f);
        int r107 = CJPayBasicExtensionKt.dp(8.0f);
        int r108 = ((CJPayBasicExtensionKt.dp(32.0f) + r106) + r107) + r104;
        int r109 = (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this.context) - r105) - r108;
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r100.setMaxWidth(r109);
        r100.setSingleLine();
        r100.setText(r101);
        Integer r110 = Integer.valueOf((int) r100.getPaint().measureText(r101));
        if (r110.intValue() >= r109) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == true) goto L11;
        r110 = null;
    L11:
        if (r110 != null) goto L13;
        return 0;
    L13:
        return r109 - r110.intValue();
    L7:
        r111 = false;
        goto L8
    L14:
        return 0;
    }

    public /* synthetic */ PGNormalPayViewHolder(View r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}
