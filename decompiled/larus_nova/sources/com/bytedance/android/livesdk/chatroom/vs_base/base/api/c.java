package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import com.bytedance.android.livesdk.room.data.EndReason;

/* JADX INFO: loaded from: classes8.dex */
public interface c {
    void addLifecycleObserver(jm1.b r100);

    void addLifecycleObserver(jm1.b r100, int r101);

    void addTask(a r100);

    void destroy();

    void endVideo(EndReason r100);

    void enterVideo();
}
