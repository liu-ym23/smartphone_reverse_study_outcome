package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class c1 implements com.bytedance.android.livesdk.room.util.i {
    public /* synthetic */ c1() {
    }

    @Override // com.bytedance.android.livesdk.room.util.i
    public final void call(ILiveRoomController r100) {
        r100.onEnterRoomPrepared();
    }
}
