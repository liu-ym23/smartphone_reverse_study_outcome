package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends me.drakeet.multitype.b<e, LiveVideoCommentSelectPanelLoadingMoreViewHolder> {
    public i() {
    }

    @Override // me.drakeet.multitype.b
    public final void e(RecyclerView.ViewHolder r100) {
        LiveVideoCommentSelectPanelLoadingMoreViewHolder r101 = (LiveVideoCommentSelectPanelLoadingMoreViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (r101.f71590c != 1) goto L8;
        LiveDoubleColorBallAnimationView r102 = r101.f71588a;
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void f(RecyclerView.ViewHolder r100) {
        LiveVideoCommentSelectPanelLoadingMoreViewHolder r101 = (LiveVideoCommentSelectPanelLoadingMoreViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (r101.f71590c != 1) goto L8;
        LiveDoubleColorBallAnimationView r102 = r101.f71588a;
        if (r102 == null) goto L9;
        r102.c();
        return;
    L9:
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, e r101) {
        LiveVideoCommentSelectPanelLoadingMoreViewHolder r102 = (LiveVideoCommentSelectPanelLoadingMoreViewHolder) r100;
        e r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        int r104 = r103.f71608a;
        r102.f71590c = r104;
        if (r104 != 1) goto L7;
        LiveDoubleColorBallAnimationView r105 = r102.f71588a;
        if (r105 == null) goto L11;
        r105.setVisibility(0);
        return;
    L11:
        return;
    L7:
        TextView r106 = r102.f71589b;
        if (r106 == null) goto L13;
        r106.setVisibility(0);
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new LiveVideoCommentSelectPanelLoadingMoreViewHolder(r100.inflate(R.layout.ttlive_video_comment_select_panel_list_loading_more_footer_layout, r101, false));
    }
}
