package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/AdapterDataObserverProxy;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdapterDataObserverProxy extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f150839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f150840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f150841c;

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        this.f150839a.onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101) {
        this.f150839a.onItemRangeChanged(r100 + this.f150840b.invoke().intValue(), r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int r100, int r101) {
        this.f150839a.onItemRangeInserted(this.f150840b.invoke().intValue() + r100, r101);
        this.f150841c.invoke(Integer.valueOf(r100 + this.f150840b.invoke().intValue()), Integer.valueOf(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        this.f150839a.onItemRangeRemoved(r100 + this.f150840b.invoke().intValue(), r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdapterDataObserverProxy(RecyclerView.AdapterDataObserver r100, Function0<Integer> r101, Function2<? super Integer, ? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "adapterDataObserver");
        Intrinsics.checkNotNullParameter(r101, "getHeaderCount");
        Intrinsics.checkNotNullParameter(r102, "onItemRangeInsertedCallback");
        this.f150839a = r100;
        this.f150840b = r101;
        this.f150841c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101, Object r102) {
        this.f150839a.onItemRangeChanged(r100 + this.f150840b.invoke().intValue(), r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        super.onItemRangeMoved(r100 + this.f150840b.invoke().intValue(), r101 + this.f150840b.invoke().intValue(), r102);
    }
}
