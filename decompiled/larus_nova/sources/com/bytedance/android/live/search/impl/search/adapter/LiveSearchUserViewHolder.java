package com.bytedance.android.live.search.impl.search.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchUserViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f100709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f100710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f100711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f100712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f100713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f100714f;

    public final ImageView T3() {
        return (ImageView) this.f100714f.getValue();
    }

    public LiveSearchUserViewHolder(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f100709a = LazyKt.lazy(new LiveSearchUserViewHolder$userSelectLayout$2(r100));
        this.f100710b = LazyKt.lazy(new LiveSearchUserViewHolder$ivAvatar$2(r100));
        this.f100711c = LazyKt.lazy(new LiveSearchUserViewHolder$tvUserTitle$2(r100));
        this.f100712d = LazyKt.lazy(new LiveSearchUserViewHolder$tvRelationLabel$2(r100));
        this.f100713e = LazyKt.lazy(new LiveSearchUserViewHolder$tvUserSubTitle$2(r100));
        this.f100714f = LazyKt.lazy(new LiveSearchUserViewHolder$ivUserCheckBox$2(r100));
    }
}
