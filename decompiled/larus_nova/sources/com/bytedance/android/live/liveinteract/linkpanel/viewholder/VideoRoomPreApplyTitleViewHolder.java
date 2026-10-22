package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/VideoRoomPreApplyTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomPreApplyTitleViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f75176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f75177b;

    public VideoRoomPreApplyTitleViewHolder(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f75176a = LazyKt.lazy(new VideoRoomPreApplyTitleViewHolder$currentOrder$2(r100));
        this.f75177b = LazyKt.lazy(new VideoRoomPreApplyTitleViewHolder$tvSortType$2(r100));
    }
}
