package com.bytedance.android.livesdk.chatroom.end.tabliveguide.view;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.view.LiveCircleView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/tabliveguide/view/LiveEndPageSkylightVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEndPageSkylightVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f106120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveCircleView f106121b;

    public LiveEndPageSkylightVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f106120a = (ImageView) r100.findViewById(R.id.skylight_avatar);
        this.f106121b = (LiveCircleView) r100.findViewById(R.id.live_end_guide_circle);
    }
}
