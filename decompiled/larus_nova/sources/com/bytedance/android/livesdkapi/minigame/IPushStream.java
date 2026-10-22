package com.bytedance.android.livesdkapi.minigame;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005H&J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0015\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/IPushStream;", "", "changeGame", "", "newGameId", "", "newLiveTitle", "msg", "changeGameFinish", "hideSeiMessage", "type", "", "pause", "pushAudioFrame", "audio", "Lcom/bytedance/android/livesdkapi/minigame/AudioFrame;", "pushVideoFrame", "video", "Lcom/bytedance/android/livesdkapi/minigame/VideoFrame;", "resume", "setStreamCallback", "cb", "Lcom/bytedance/android/livesdkapi/minigame/LiveStreamCallback;", "showSeiMessage", "start", "roomParams", "Lcom/bytedance/android/livesdkapi/minigame/RoomParams;", "pushParams", "Lcom/bytedance/android/livesdkapi/minigame/PushParams;", "Lcom/bytedance/android/livesdkapi/minigame/RoomCreatedCallback;", "stop", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPushStream {
    void changeGame(String r100, String r101, String r102);

    void changeGameFinish();

    void hideSeiMessage(int r100);

    void pause();

    void pushAudioFrame(AudioFrame r100);

    void pushVideoFrame(VideoFrame r100);

    void resume();

    void setStreamCallback(LiveStreamCallback r100);

    void showSeiMessage(int r100, String r101);

    void start(RoomParams r100, PushParams r101, RoomCreatedCallback r102);

    void stop();
}
