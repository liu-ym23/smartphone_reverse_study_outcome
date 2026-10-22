package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/adapter/AdjustGuestPositionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdjustGuestPositionViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f79049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f79050b;

    public AdjustGuestPositionViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f79049a = r100.findViewById(R.id.vh_container);
        this.f79050b = (ImageView) r100.findViewById(R.id.image_adjust_position_panel_item);
    }
}
