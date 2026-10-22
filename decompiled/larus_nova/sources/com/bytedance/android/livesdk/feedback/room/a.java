package com.bytedance.android.livesdk.feedback.room;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: classes8.dex */
public interface a {
    k<Long> getOnRoomBackgroundEvent();

    k<Long> getOnRoomForegroundEvent();

    n<? extends ILiveRoomPlayFragment.LiveRoomListener> getRoomListener();

    m<? extends Boolean> isHideViewsOnClearScreen();

    void notifyOnBackground(long r100);

    void notifyOnForeground(long r100);

    void updateRoomListener(ILiveRoomPlayFragment.LiveRoomListener r100);
}
