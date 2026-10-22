package com.bytedance.android.live.broadcastgame.api.toolbar;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/toolbar/InteractGroupNameViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGroupNameViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f59431a;

    public InteractGroupNameViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f59431a = (TextView) r100.findViewById(R.id.group_name);
    }
}
