package com.byted.cast.sdk.core.rtc;

/* JADX INFO: loaded from: classes43.dex */
public interface IRemoteMirrorCallback {
    void onAudioFrame(byte[] r100, long r101);

    void onJoinRoomResult(String r100, String r101, int r102);

    void onRequestKeyFrame();

    void onStreamAdd(String r100);

    void onUserJoined(String r100);

    void onUserLeave(String r100, int r101);

    void onVideoFrame(byte[] r100, long r101);
}
