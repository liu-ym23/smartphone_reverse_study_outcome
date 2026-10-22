package com.bytedance.android.livesdk.chatroom.widget;

import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/BroadcastPauseStateLandscapeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/BroadcastPauseStateWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BroadcastPauseStateLandscapeWidget extends BroadcastPauseStateWidget {
    @Override // com.bytedance.android.livesdk.chatroom.widget.BroadcastPauseStateWidget, com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_broadcast_voluntary_pause_landscape_layout;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.BroadcastPauseStateWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a286";
    }

    public BroadcastPauseStateLandscapeWidget() {
    }
}
