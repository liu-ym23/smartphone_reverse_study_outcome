package com.bytedance.android.livesdk.widget;

import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/widget/VSFirstShowPopUpServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSFirstShowPopUpServiceWidget extends RoomRecyclableWidget {
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public VSFirstShowPopUpServiceWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        runWithRoomEntered(new q2(this));
    }
}
