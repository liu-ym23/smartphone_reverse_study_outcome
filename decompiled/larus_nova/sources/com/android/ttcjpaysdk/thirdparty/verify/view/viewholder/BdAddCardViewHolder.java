package com.android.ttcjpaysdk.thirdparty.verify.view.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCircleCheckBox;
import com.android.ttcjpaysdk.bdpay.paymentmethod.utils.PaymentMethodUtils;
import com.android.ttcjpaysdk.thirdparty.data.FreqSuggestCardInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdAddCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkboxView", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCircleCheckBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "firstSubLabel", "Landroid/widget/TextView;", "iconMaskView", "Landroid/widget/ImageView;", "iconView", "onClickAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "getOnClickAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "setOnClickAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;)V", "secondSubLabel", "subTitleView", "titleView", "bindData", "", "info", "Lcom/android/ttcjpaysdk/thirdparty/data/FreqSuggestCardInfo;", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BdAddCardViewHolder extends RecyclerView.ViewHolder {
    private final CJPayCircleCheckBox checkboxView;
    private final Context context;
    private final TextView firstSubLabel;
    private final ImageView iconMaskView;
    private final ImageView iconView;
    private BdBankCardAdapter.OnClickAdapterListener onClickAdapterListener;
    private final TextView secondSubLabel;
    private final TextView subTitleView;
    private final TextView titleView;

    public final BdBankCardAdapter.OnClickAdapterListener getOnClickAdapterListener() {
        return this.onClickAdapterListener;
    }

    public BdAddCardViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.context = r100.getContext();
        this.iconView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon);
        this.iconMaskView = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon_unable_mask);
        this.titleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_title);
        this.subTitleView = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_title);
        this.firstSubLabel = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_label_first);
        this.secondSubLabel = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_label_second);
        this.checkboxView = (CJPayCircleCheckBox) r100.findViewById(R.id.cj_pay_payment_method_checkbox);
    }

    public final void bindData(FreqSuggestCardInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        this.firstSubLabel.setVisibility(8);
        this.secondSubLabel.setVisibility(8);
        CJPayCircleCheckBox r100 = this.checkboxView;
        r100.setIESNewStyle(true);
        r100.setWithCircleWhenUnchecked(true);
        r100.setChecked(true);
        TextView r101 = this.titleView;
        FrontSubPayTypeInfo r102 = r110.sub_pay_type_info;
        GradientDrawable r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getTitle();
    L6:
        r101.setText(r104);
        TextView r105 = this.subTitleView;
        FrontSubPayTypeInfo r106 = r110.sub_pay_type_info;
        if (r106 == null) goto L9;
        String r107 = r106.getSubTitle();
    L10:
        r105.setText(r107);
        PaymentMethodUtils r108 = PaymentMethodUtils.INSTANCE;
        ImageView r109 = this.iconView;
        ImageView r111 = this.iconMaskView;
        FrontSubPayTypeInfo r112 = r110.sub_pay_type_info;
        if (r112 == null) goto L13;
        String r113 = r112.getIconUrl();
    L14:
        FrontSubPayTypeInfo r114 = r110.sub_pay_type_info;
        if (r114 == null) goto L17;
        boolean r115 = r114.isEnable();
    L18:
        PaymentMethodUtils.setIconUrl$default(r108, r109, r111, r113, r115, null, 16, null);
        r108.updateDiscountLabelForBdCardList(r110, this.firstSubLabel, this.secondSubLabel, this.context);
        Drawable r116 = this.firstSubLabel.getBackground();
        if ((r116 instanceof GradientDrawable) == false) goto L21;
        GradientDrawable r117 = (GradientDrawable) r116;
    L23:
        if (r117 == null) goto L25;
        r117.setColor(ColorProtector.parseColor("#00000000"));
    L25:
        Drawable r118 = this.secondSubLabel.getBackground();
        if ((r118 instanceof GradientDrawable) == false) goto L28;
        r103 = (GradientDrawable) r118;
    L28:
        if (r103 == null) goto L31;
        r103.setColor(ColorProtector.parseColor("#00000000"));
        return;
    L31:
        return;
    L21:
        r117 = null;
        goto L23
    L17:
        r115 = false;
        goto L18
    L13:
        r113 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void setOnClickAdapterListener(BdBankCardAdapter.OnClickAdapterListener r100) {
        this.onClickAdapterListener = r100;
    }
}
