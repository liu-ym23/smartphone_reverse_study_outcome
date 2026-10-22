package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface l {
    ILiveRoomController a(long r100, int r101);

    void c();

    void d(String r100);

    IRoom f();

    Bundle g(Bundle r100);

    boolean h(DataCenter r100, Bundle r101);

    boolean isMicRoom(IRoom r100);
}
