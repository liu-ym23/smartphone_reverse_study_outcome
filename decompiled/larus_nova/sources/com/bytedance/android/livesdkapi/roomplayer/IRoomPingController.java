package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IRoomPingController;", "", "start", "", "stop", "PingListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomPingController {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IRoomPingController$PingListener;", "", "onIllegal", "", "roomId", "", "mosaicStatus", "onPingCheck", "", "onPingError", "errorCode", "", "onRoomFinished", "onUserNotInRoom", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface PingListener {
        void onIllegal(long r100, long r101);

        boolean onPingCheck();

        void onPingError(int r100);

        void onRoomFinished();

        void onUserNotInRoom();
    }

    void start();

    void stop();
}
