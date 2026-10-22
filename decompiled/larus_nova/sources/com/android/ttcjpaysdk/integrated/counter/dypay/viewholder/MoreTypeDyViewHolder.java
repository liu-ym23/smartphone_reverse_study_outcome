package com.android.ttcjpaysdk.integrated.counter.dypay.viewholder;

import android.view.View;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/dypay/viewholder/MoreTypeDyViewHolder;", "Lcom/android/ttcjpaysdk/integrated/counter/viewholder/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindData", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "integrated-counter-dy-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class MoreTypeDyViewHolder extends BaseViewHolder {
    public MoreTypeDyViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder
    public void bindData(PaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.bindData(r100);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.itemView, new AnonymousClass1(this));
    }
}
