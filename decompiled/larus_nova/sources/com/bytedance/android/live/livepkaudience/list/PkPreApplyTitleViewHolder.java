package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkPreApplyTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkPreApplyTitleViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f82069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f82070b;

    public PkPreApplyTitleViewHolder(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f82069a = LazyKt.lazy(new PkPreApplyTitleViewHolder$currentOrder$2(r100));
        this.f82070b = LazyKt.lazy(new PkPreApplyTitleViewHolder$tvSortType$2(r100));
    }
}
