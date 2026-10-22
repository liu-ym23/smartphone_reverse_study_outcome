package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/view/AnchorLinkVideoLoadingMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkVideoLoadingMoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f147190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f147191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f147192c;

    public AnchorLinkVideoLoadingMoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f147190a = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.video_comment_panel_list_refresh_progress);
        this.f147191b = (TextView) r100.findViewById(R.id.video_comment_panel_list_not_more_text);
        this.f147192c = 1;
    }
}
