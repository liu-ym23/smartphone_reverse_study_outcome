package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.performance.LiveHotRoomManager")
public interface IHotRoomManager extends IService {
    int getHotRoomType(long r100);

    long getTotalHotRoomTime(long r100);

    boolean isHotRoom(long r100);

    void notifyHotStatus(long r100);

    void onEnterPlay();

    void onEnterRoom();

    void onExitPlay();

    void onExitRoom();

    void release();

    void setHotRoomType(int r100);
}
