package com.android.ttcjpaysdk.bdpay.paymentmethod.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.TextViewExtKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.ui.Utils.PaymentUIUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.bdpay.paymentmethod.bean.MethodPayTypeInfo;
import com.android.ttcjpaysdk.bdpay.paymentmethod.utils.PaymentMethodUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J(\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/NormalPayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isCombine", "", "useVoucherMsgV2", "(Landroid/view/View;ZZ)V", "arrowView", "Landroid/widget/ImageView;", "checkboxView", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "firstSubLabel", "Landroid/widget/TextView;", "iconMaskView", "iconView", "itemRootView", "loadingView", "Landroid/widget/ProgressBar;", "methodLabelTextView", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;)V", "secondSubLabel", "subTitleView", "titleView", "bindData", "", "info", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "foldBankInfoIfNeeded", "textView", "labelView", "bankInfo", "", "labelInfo", "getClickListener", "Landroid/view/View$OnClickListener;", "loadImage", "setLoadingView", "updateViewEnableColor", "updateViewForFromType", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NormalPayViewHolder extends RecyclerView.ViewHolder {
    private final ImageView arrowView;
    private final CJPayCircleCheckBox checkboxView;
    private final Context context;
    private final TextView firstSubLabel;
    private final ImageView iconMaskView;
    private final ImageView iconView;
    private final boolean isCombine;
    private final View itemRootView;
    private final ProgressBar loadingView;
    private final TextView methodLabelTextView;
    private PaymentMethodAdapter.OnMethodAdapterListener onMethodAdapterListener;
    private final TextView secondSubLabel;
    private final TextView subTitleView;
    private final TextView titleView;
    private final boolean useVoucherMsgV2;

    public final PaymentMethodAdapter.OnMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    private final View.OnClickListener getClickListener(final MethodPayTypeInfo r100) {
        return new AnonymousClass1(r100, this);
    }

    private final void loadImage(MethodPayTypeInfo r100) {
        PaymentMethodUtils.setIconUrl$default(PaymentMethodUtils.INSTANCE, this.iconView, this.iconMaskView, r100.getIcon_url(), r100.isEnable(), null, 16, null);
    }

    private final void setLoadingView(MethodPayTypeInfo r100) {
        this.loadingView.setVisibility(8);
        if (r100.isEnable() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100.getPaymentType(), "new_bank_card") == true) goto L8;
        return;
    L8:
        if (r100.isShowLoading() == false) goto L10;
        this.arrowView.setVisibility(8);
        this.loadingView.setVisibility(0);
        return;
    L10:
        this.arrowView.setVisibility(0);
        this.loadingView.setVisibility(8);
    }

    private final void updateViewEnableColor(MethodPayTypeInfo r110) {
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

    private final void updateViewForFromType(MethodPayTypeInfo r100) {
        if (r100.isEnable() == true) goto L6;
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(8);
        return;
    L6:
        String r101 = r100.getPaymentType();
        switch(r101.hashCode()) {
            case -1787710669: goto L33;
            case -1581701048: goto L30;
            case -1184259671: goto L26;
            case -563976606: goto L23;
            case -339185956: goto L20;
            case -159369463: goto L17;
            case -127611052: goto L13;
            case 3107561: goto L10;
            default: goto L40;
        };
    L40:
        return;
    L10:
        if (r101.equals(PaymentMethodUtils.ECNY) == false) goto L41;
    L35:
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(0);
        return;
    L41:
        return;
    L13:
        if (r101.equals("new_bank_card") == false) goto L42;
        this.arrowView.setVisibility(0);
        this.checkboxView.setVisibility(8);
        return;
    L42:
        return;
    L17:
        if (r101.equals("combinepay") == true) goto L35;
        return;
    L20:
        if (r101.equals("balance") == true) goto L35;
        return;
    L23:
        if (r101.equals("credit_pay") == true) goto L35;
        return;
    L26:
        if (r101.equals("income") == false) goto L45;
        this.arrowView.setVisibility(8);
        this.checkboxView.setVisibility(0);
        return;
    L45:
        return;
    L30:
        if (r101.equals("share_pay") == true) goto L35;
        return;
    L33:
        if (r101.equals("bank_card") == true) goto L35;
    }

    public void bindData(MethodPayTypeInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = 8;
        this.subTitleView.setVisibility(8);
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        loadImage(r110);
        foldBankInfoIfNeeded(this.titleView, this.methodLabelTextView, r110.getTitle(), r110.getSelect_page_guide_text());
        CJPayViewExtensionsKt.setTextAndVisible(this.methodLabelTextView, r110.getSelect_page_guide_text());
        CJPayCircleCheckBox r101 = this.checkboxView;
        boolean r102 = true;
        r101.setIESNewStyle(true);
        r101.setWithCircleWhenUnchecked(true);
        r101.setChecked(r110.getChoose());
        updateViewEnableColor(r110);
        updateViewForFromType(r110);
        setLoadingView(r110);
        if (this.useVoucherMsgV2 == false) goto L5;
        boolean r103 = PaymentMethodUtils.INSTANCE.updateDiscountLabelV2ForCardList(r110, this.firstSubLabel, this.secondSubLabel, this.isCombine, this.context);
    L7:
        if (TextUtils.isEmpty(r110.getMsg()) == true) goto L12;
        TextViewExtKt.showText(this.subTitleView, r110.getMsg());
        if (r110.isEnable() == true) goto L32;
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        r103 = false;
    L32:
        if (r102 == false) goto L35;
        if (r103 == false) goto L35;
        ViewGroup.LayoutParams r104 = this.itemRootView.getLayoutParams();
        r104.height = CJPayBasicExtensionKt.dp(79.0f);
    L41:
        if (r110.isCardInactive() == true) goto L43;
        TextView r105 = this.methodLabelTextView;
        if (Intrinsics.areEqual(r110.getPaymentType(), "combinepay") == true) goto L49;
    L51:
        String r111 = r110.getSelect_page_guide_text();
    L52:
        TextViewExtKt.showText(r105, r111);
        return;
    L49:
        if (r110.getChoose() == false) goto L51;
        r111 = this.itemView.getContext().getResources().getString(R.string.cj_pay_combine_pay_method);
        goto L52
    L43:
        if (Intrinsics.areEqual(r110.getStatus(), "1") == false) goto L45;
        TextViewExtKt.showText(this.methodLabelTextView, r110.getSelect_page_guide_text());
        return;
    L45:
        CJPayViewExtensionsKt.viewGone(this.methodLabelTextView);
        return;
    L35:
        if (r103 == true) goto L39;
        if (r102 == true) goto L39;
        ViewGroup.LayoutParams r106 = this.itemRootView.getLayoutParams();
        r106.height = CJPayBasicExtensionKt.dp(53.0f);
    L39:
        ViewGroup.LayoutParams r107 = this.itemRootView.getLayoutParams();
        r107.height = CJPayBasicExtensionKt.dp(59.0f);
        goto L41
    L12:
        if (r110.isCardInactive() == false) goto L30;
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        this.subTitleView.setVisibility(8);
        this.checkboxView.setVisibility(8);
        ImageView r108 = this.arrowView;
        if (r110.isShowLoading() == true) goto L17;
        r100 = 0;
    L17:
        r108.setVisibility(r100);
        if (this.firstSubLabel.getText().length() <= 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
        this.firstSubLabel.setVisibility(0);
        r103 = true;
    L25:
        if (this.secondSubLabel.getText().length() <= 0) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L31;
        this.secondSubLabel.setVisibility(0);
        r103 = true;
    L31:
        r102 = false;
        goto L32
    L27:
        r112 = false;
        goto L28
    L23:
        r103 = false;
        goto L25
    L20:
        r109 = false;
        goto L21
    L30:
        this.subTitleView.setVisibility(8);
        goto L31
    L5:
        r103 = PaymentMethodUtils.INSTANCE.updateDiscountLabelForCardList(r110, this.firstSubLabel, this.secondSubLabel, this.context);
        goto L7
    }

    public final void setOnMethodAdapterListener(PaymentMethodAdapter.OnMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }

    public NormalPayViewHolder(View r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.isCombine = r101;
        this.useVoucherMsgV2 = r102;
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
        this.itemRootView = r100.findViewById(R.id.cj_pay_item_normal_pay_root_layout);
    }

    private final void foldBankInfoIfNeeded(TextView r100, TextView r101, String r102, String r103) {
        int r104 = (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this.context) - CJPayBasicExtensionKt.dp(112.0f)) - ((int) r101.getPaint().measureText(r103));
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setMaxWidth(r104);
        r100.setSingleLine();
        r100.setText(r102);
        return;
    }
}
