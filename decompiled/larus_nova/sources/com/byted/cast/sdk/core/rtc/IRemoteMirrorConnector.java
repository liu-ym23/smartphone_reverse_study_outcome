package com.byted.cast.sdk.core.rtc;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes43.dex */
public interface IRemoteMirrorConnector {
    void init(Context r100, int r101, int r102, int r103, int r104);

    void leaveRoom();

    void requestRemoteVideoKeyFrame();

    int sendAudioFrame(byte[] r100, int r101, int r102, int r103, int r104, long r105);

    boolean sendVideoFrame(byte[] r100, byte[] r101, int r102, int r103, int r104, long r105, int r106, int r107);

    boolean sendVideoImage(Bitmap r100);

    void setRTCCallback(IRemoteMirrorCallback r100);

    int sinkInitAndJoinRoom(String r100, String r101, String r102, String r103);

    int sourceInitAndJoinRoom(String r100, String r101, String r102, String r103);
}
