package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonStackAvatarViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f144143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f144144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public py.k f144145c;

    public KtvCommonStackAvatarViewHolder(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f144143a = LazyKt.lazy(new KtvCommonStackAvatarViewHolder$userAvatarIv$2(r100));
        this.f144144b = LazyKt.lazy(new KtvCommonStackAvatarViewHolder$totalCountTv$2(r100));
    }
}
