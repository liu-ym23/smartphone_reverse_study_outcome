package com.android.ttcjpaysdk.thirdparty.payagain.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/PGPayWithFoldAreaViewHolder;", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/PGNormalPayViewHolder;", "itemView", "Landroid/view/View;", "isCombine", "", "useVoucherMsgV2", "(Landroid/view/View;ZZ)V", "arrowView", "Landroid/widget/ImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "foldRootView", "foldTextView", "Landroid/widget/TextView;", "bindData", "", "info", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PGPayWithFoldAreaViewHolder extends PGNormalPayViewHolder {
    private final ImageView arrowView;
    private final Context context;
    private final View foldRootView;
    private final TextView foldTextView;
    private final boolean isCombine;
    private final boolean useVoucherMsgV2;

    @Override // com.android.ttcjpaysdk.thirdparty.payagain.adapter.PGNormalPayViewHolder
    public void bindData(FrontPaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.bindData(r100);
        if (ShareData.INSTANCE.isExpanded() == false) goto L9;
        TextView r101 = this.foldTextView;
        if (TextUtils.isEmpty(r100.new_bank_card_fold_desc) == true) goto L7;
        String r102 = this.context.getString(R.string.cj_pay_fold) + r100.new_bank_card_fold_desc;
    L8:
        r101.setText(r102);
        this.arrowView.setImageResource(R.drawable.cj_pay_icon_arrow_up);
    L14:
        this.foldRootView.setOnClickListener(new AnonymousClass1(this));
        return;
    L7:
        r102 = this.context.getString(R.string.cj_pay_method_bottom_text_folded_left_fold);
        goto L8
    L9:
        TextView r103 = this.foldTextView;
        if (TextUtils.isEmpty(r100.new_bank_card_fold_desc) == true) goto L12;
        String r104 = this.context.getString(R.string.cj_pay_unfold) + r100.new_bank_card_fold_desc;
    L13:
        r103.setText(r104);
        this.arrowView.setImageResource(R.drawable.cj_pay_icon_arrow_down);
        goto L14
    L12:
        r104 = this.context.getString(R.string.cj_pay_method_bottom_text_folded_left_expand);
        goto L13
    }

    public PGPayWithFoldAreaViewHolder(View r100, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r110, r111, false, 8, null);
        this.isCombine = r110;
        this.useVoucherMsgV2 = r111;
        this.context = r100.getContext();
        this.foldRootView = r100.findViewById(R.id.cj_pay_method_fold_layout);
        this.foldTextView = (TextView) r100.findViewById(R.id.cj_pay_method_fold_text);
        this.arrowView = (ImageView) r100.findViewById(R.id.cj_pay_method_fold_arrow);
    }
}
