package com.android.ttcjpaysdk.thirdparty.verify.view.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.TextViewExtKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.base.ui.Utils.PaymentUIUtils;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.bdpay.paymentmethod.bean.MethodPayTypeInfo;
import com.android.ttcjpaysdk.bdpay.paymentmethod.utils.PaymentMethodUtils;
import com.android.ttcjpaysdk.thirdparty.data.FreqSuggestCardInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J:\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J4\u0010'\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J4\u0010(\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010)2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isBottom", "", "holderStyle", "", "(Landroid/view/View;ZLjava/lang/String;)V", "bottomLayout", "Landroid/widget/LinearLayout;", "bottomTitle", "Landroid/widget/TextView;", "checkboxView", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "firstSubLabel", "iconMaskView", "Landroid/widget/ImageView;", "iconView", "onClickAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "getOnClickAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "setOnClickAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;)V", "secondSubLabel", "titleView", "upperLayout", "bindData", "", "info", "Lcom/android/ttcjpaysdk/thirdparty/data/FreqSuggestCardInfo;", "foldBankInfoIfNeeded", "firstView", "secondView", "firstInfo", "secondInfo", "updateDiscountLabelForBdCardList", "updateDiscountLabelForCardList", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BdBankCardViewHolder extends RecyclerView.ViewHolder {
    private final LinearLayout bottomLayout;
    private final TextView bottomTitle;
    private final CJPayCircleCheckBox checkboxView;
    private final Context context;
    private final TextView firstSubLabel;
    private final String holderStyle;
    private final ImageView iconMaskView;
    private final ImageView iconView;
    private final boolean isBottom;
    private BdBankCardAdapter.OnClickAdapterListener onClickAdapterListener;
    private final TextView secondSubLabel;
    private final TextView titleView;
    private final View upperLayout;

    public final BdBankCardAdapter.OnClickAdapterListener getOnClickAdapterListener() {
        return this.onClickAdapterListener;
    }

    public final void bindData(final FreqSuggestCardInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        int r100 = 8;
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        CJPayCircleCheckBox r101 = this.checkboxView;
        r101.setIESNewStyle(true);
        r101.setWithCircleWhenUnchecked(true);
        FrontSubPayTypeInfo r102 = r110.sub_pay_type_info;
        if (r102 == null) goto L5;
        boolean r103 = r102.getIsChoose();
    L6:
        r101.setChecked(r103);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.upperLayout, new AnonymousClass2(this, r110));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.bottomLayout, new AnonymousClass3(this));
        TextView r104 = this.titleView;
        FrontSubPayTypeInfo r105 = r110.sub_pay_type_info;
        GradientDrawable r106 = null;
        if (r105 == null) goto L9;
        String r107 = r105.getTitle();
    L10:
        r104.setText(r107);
        LinearLayout r108 = this.bottomLayout;
        if (this.isBottom == false) goto L13;
        r100 = 0;
    L13:
        r108.setVisibility(r100);
        this.bottomTitle.setText(r110.title_button_label);
        PaymentMethodUtils r109 = PaymentMethodUtils.INSTANCE;
        ImageView r111 = this.iconView;
        ImageView r112 = this.iconMaskView;
        FrontSubPayTypeInfo r113 = r110.sub_pay_type_info;
        if (r113 == null) goto L16;
        String r114 = r113.getIconUrl();
    L17:
        FrontSubPayTypeInfo r115 = r110.sub_pay_type_info;
        if (r115 == null) goto L20;
        boolean r116 = r115.isEnable();
    L21:
        PaymentMethodUtils.setIconUrl$default(r109, r111, r112, r114, r116, null, 16, null);
        updateDiscountLabelForBdCardList(r110, this.titleView, this.firstSubLabel, this.secondSubLabel, this.context);
        if (Intrinsics.areEqual(this.holderStyle, "split") == false) goto L36;
        Drawable r117 = this.firstSubLabel.getBackground();
        if ((r117 instanceof GradientDrawable) == false) goto L26;
        GradientDrawable r118 = (GradientDrawable) r117;
    L28:
        if (r118 == null) goto L30;
        r118.setColor(ColorProtector.parseColor("#00000000"));
    L30:
        Drawable r119 = this.secondSubLabel.getBackground();
        if ((r119 instanceof GradientDrawable) == false) goto L33;
        r106 = (GradientDrawable) r119;
    L33:
        if (r106 == null) goto L37;
        r106.setColor(ColorProtector.parseColor("#00000000"));
        return;
    L37:
        return;
    L26:
        r118 = null;
        goto L28
    L36:
        return;
    L20:
        r116 = false;
        goto L21
    L16:
        r114 = null;
        goto L17
    L9:
        r107 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public final void setOnClickAdapterListener(BdBankCardAdapter.OnClickAdapterListener r100) {
        this.onClickAdapterListener = r100;
    }

    public BdBankCardViewHolder(View r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "holderStyle");
        super(r100);
        this.isBottom = r101;
        this.holderStyle = r102;
        this.context = r100.getContext();
        this.iconView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon);
        this.iconMaskView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon_unable_mask);
        this.titleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_title);
        this.firstSubLabel = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_label_first);
        this.secondSubLabel = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_label_second);
        this.checkboxView = (CJPayCircleCheckBox) r100.findViewById(R.id.cj_pay_payment_method_checkbox);
        this.bottomLayout = (LinearLayout) r100.findViewById(R.id.cj_pay_payment_method_more_bank);
        this.bottomTitle = (TextView) r100.findViewById(R.id.cj_pay_payment_method_more_bank_title);
        this.upperLayout = r100.findViewById(R.id.cj_pay_payment_method_upper_layout);
    }

    public /* synthetic */ BdBankCardViewHolder(View r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101, r102);
    }

    private final boolean updateDiscountLabelForBdCardList(FreqSuggestCardInfo r100, TextView r101, TextView r102, TextView r110, Context r111) {
        MethodPayTypeInfo r103 = new MethodPayTypeInfo();
        ArrayList<String> r104 = null;
        if (r100 == null) goto L7;
        FrontSubPayTypeInfo r105 = r100.sub_pay_type_info;
        if (r105 == null) goto L7;
        CJPayVoucherInfo r106 = r105.getVoucherInfo();
    L8:
        if (r106 != null) goto L10;
        r106 = new CJPayVoucherInfo();
    L10:
        r103.setVoucher_info(r106);
        if (r100 == null) goto L15;
        FrontSubPayTypeInfo r107 = r100.sub_pay_type_info;
        if (r107 == null) goto L15;
        r104 = r107.getVoucherMsgList();
    L15:
        if (r104 != null) goto L17;
        r104 = new ArrayList();
    L17:
        r103.setVoucher_msg_list(r104);
        r103.setStatus("1");
        return updateDiscountLabelForCardList(r103, r101, r102, r110, r111);
    L7:
        r106 = null;
        goto L8
    }

    private final boolean updateDiscountLabelForCardList(MethodPayTypeInfo r110, TextView r111, TextView r210, TextView r211, Context r212) {
        if (r110 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r110.getVoucher_info().vouchers_label) == true) goto L8;
    L11:
        String r100 = (String) CollectionsKt.getOrNull(r110.getVoucher_msg_list(), 0);
        String r101 = null;
        if (r100 != null) goto L14;
    L21:
        r100 = r110.getVoucher_info().vouchers_label;
    L22:
        String r102 = r100;
        String r103 = (String) CollectionsKt.getOrNull(r110.getVoucher_msg_list(), 1);
        if (r103 != null) goto L25;
    L33:
        String r104 = "";
    L35:
        if (TextUtils.isEmpty(r102) == false) goto L37;
        return false;
    L37:
        TextViewExtKt.showText(r210, r102);
        foldBankInfoIfNeeded(r111, r210, r211, r102, r104, r212);
        PaymentUIUtils.Companion r105 = PaymentUIUtils.Companion;
        PaymentUIUtils.Companion.updateLabelStyle$default(r105, r210, r212, r110.isEnable(), 5, null, 16, null);
        PaymentUIUtils.Companion.updateLabelStyle$default(r105, r211, r212, r110.isEnable(), 5, null, 16, null);
        return true;
    L25:
        if (r103.length() <= 0) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L30;
        r101 = r103;
    L30:
        if (r101 == null) goto L33;
        r104 = r101;
        goto L35
    L27:
        r106 = false;
        goto L28
    L14:
        if (r100.length() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r100 = null;
    L20:
        if (r100 != null) goto L22;
    L16:
        r107 = false;
        goto L17
    L8:
        if (r110.getVoucher_msg_list().size() != 0) goto L11;
        r210.setVisibility(8);
        return false;
    }

    private final void foldBankInfoIfNeeded(TextView r100, TextView r101, TextView r102, String r103, String r104, Context r105) {
        float r106 = (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r105) - CJPayBasicExtensionKt.dp(127.0f)) - ((int) r101.getPaint().measureText(r103));
        TextPaint r107 = r100.getPaint();
        CharSequence r108 = r100.getText();
        if (r108 == null) goto L5;
        String r109 = r108.toString();
    L6:
        float r110 = r106 - r107.measureText(r109);
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r102.setEllipsize(TextUtils.TruncateAt.END);
        r102.setMaxWidth((int) r110);
        r102.setSingleLine();
        TextViewExtKt.showText(r102, r104);
        return;
    L10:
        return;
    L5:
        r109 = null;
        goto L6
    }
}
