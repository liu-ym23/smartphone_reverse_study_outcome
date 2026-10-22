package com.android.ttcjpaysdk.integrated.counter.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.integrated.counter.adapter.CJPayConfirmAdapter;
import com.android.ttcjpaysdk.integrated.counter.adapter.CJPayMethodAdapter;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onConfirmAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;", "getOnConfirmAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;", "setOnConfirmAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;)V", "onConfirmBannerAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;", "getOnConfirmBannerAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;", "setOnConfirmBannerAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;)V", "onDyPayConfirmAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;", "getOnDyPayConfirmAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;", "setOnDyPayConfirmAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;)V", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayMethodAdapter$OnMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayMethodAdapter$OnMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayMethodAdapter$OnMethodAdapterListener;)V", "bindData", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private CJPayConfirmAdapter.OnConfirmAdapterListener onConfirmAdapterListener;
    private CJPayConfirmAdapter.OnConfirmBannerAdapterListener onConfirmBannerAdapterListener;
    private CJPayConfirmAdapter.OnDyPayConfirmAdapterListener onDyPayConfirmAdapterListener;
    private CJPayMethodAdapter.OnMethodAdapterListener onMethodAdapterListener;

    public void bindData(PaymentMethodInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
    }

    public final CJPayConfirmAdapter.OnConfirmAdapterListener getOnConfirmAdapterListener() {
        return this.onConfirmAdapterListener;
    }

    public final CJPayConfirmAdapter.OnConfirmBannerAdapterListener getOnConfirmBannerAdapterListener() {
        return this.onConfirmBannerAdapterListener;
    }

    public final CJPayConfirmAdapter.OnDyPayConfirmAdapterListener getOnDyPayConfirmAdapterListener() {
        return this.onDyPayConfirmAdapterListener;
    }

    public final CJPayMethodAdapter.OnMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    public BaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void setOnConfirmAdapterListener(CJPayConfirmAdapter.OnConfirmAdapterListener r100) {
        this.onConfirmAdapterListener = r100;
    }

    public final void setOnConfirmBannerAdapterListener(CJPayConfirmAdapter.OnConfirmBannerAdapterListener r100) {
        this.onConfirmBannerAdapterListener = r100;
    }

    public final void setOnDyPayConfirmAdapterListener(CJPayConfirmAdapter.OnDyPayConfirmAdapterListener r100) {
        this.onDyPayConfirmAdapterListener = r100;
    }

    public final void setOnMethodAdapterListener(CJPayMethodAdapter.OnMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }
}
