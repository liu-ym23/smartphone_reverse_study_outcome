package com.bytedance.android.livesdk.chatroom.detail;

/* JADX INFO: loaded from: classes7.dex */
public interface q {

    public interface a {
        void a();

        boolean onPingCheck();

        void onPingError(int r100);

        void onRoomFinished();

        void onUserNotInRoom();
    }

    void start();

    void stop();
}
