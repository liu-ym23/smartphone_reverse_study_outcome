package com.android.ttcjpaysdk.bdpay.paymentmethod.viewholder;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PayWithSplitLineViewHolder;", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/NormalPayViewHolder;", "itemView", "Landroid/view/View;", "isCombine", "", "useVoucherMsgV2", "(Landroid/view/View;ZZ)V", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayWithSplitLineViewHolder extends NormalPayViewHolder {
    private final boolean isCombine;
    private final boolean useVoucherMsgV2;

    public PayWithSplitLineViewHolder(View r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r101, r102);
        this.isCombine = r101;
        this.useVoucherMsgV2 = r102;
    }
}
