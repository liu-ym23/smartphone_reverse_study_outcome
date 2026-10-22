package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoTalkRoomApplyCancelDialog f72468a;

    public j(VideoTalkRoomApplyCancelDialog r100) {
        this.f72468a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        VideoTalkRoomApplyCancelDialog r102 = this.f72468a;
        x r103 = (x) r101.data;
        int r104 = VideoTalkRoomApplyCancelDialog.f72433e;
        ((FrameLayout) r102.findViewById(R.id.layout_apply_waiting_rank_tips)).setVisibility(0);
        ((TextView) r102.findViewById(R.id.tv_waiting_rank)).setText(r103.getPrompt());
    }
}
