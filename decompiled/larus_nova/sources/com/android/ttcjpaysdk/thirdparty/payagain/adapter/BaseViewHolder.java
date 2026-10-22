package com.android.ttcjpaysdk.thirdparty.payagain.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;)V", "bindData", "", "info", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private FrontMethodAdapter.OnMethodAdapterListener onMethodAdapterListener;

    public void bindData(FrontPaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
    }

    public final FrontMethodAdapter.OnMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    public BaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void setOnMethodAdapterListener(FrontMethodAdapter.OnMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }
}
