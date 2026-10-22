package com.android.ttcjpaysdk.thirdparty.payagain.adapter;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/PGPayWithSplitLineViewHolder;", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/PGNormalPayViewHolder;", "itemView", "Landroid/view/View;", "isCombine", "", "useVoucherMsgV2", "(Landroid/view/View;ZZ)V", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PGPayWithSplitLineViewHolder extends PGNormalPayViewHolder {
    private final boolean isCombine;
    private final boolean useVoucherMsgV2;

    public PGPayWithSplitLineViewHolder(View r100, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r110, r111, false, 8, null);
        this.isCombine = r110;
        this.useVoucherMsgV2 = r111;
    }
}
