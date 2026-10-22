package com.android.server.audio;

/* JADX INFO: loaded from: classes.dex */
public interface ZAudioClientDispatcher {
    void dispatchAudioStreamActive(int r1, boolean r2);

    void dispatchPlaybackActive(ZPlaybackClientInterface r1, boolean r2);

    void dispatchPlaybackUidActive(int r1, boolean r2);

    void dispatchRecordingActive(ZRecordClientInterface r1, boolean r2);

    void dispatchRecordingSourceActive(int r1, boolean r2);

    void dispatchRecordingUidActive(int r1, boolean r2);

    void registerAudioPlaybackListener(String r1, ZAudioPlaybackListener r2);

    void registerAudioRecordListener(String r1, ZAudioRecordListener r2);

    void reset();

    void unregisterAudioPlaybackListener(ZAudioPlaybackListener r1);

    void unregisterAudioRecordListener(ZAudioRecordListener r1);
}
