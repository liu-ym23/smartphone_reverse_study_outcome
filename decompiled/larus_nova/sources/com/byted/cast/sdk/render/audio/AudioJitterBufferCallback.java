package com.byted.cast.sdk.render.audio;

/* JADX INFO: loaded from: classes43.dex */
public interface AudioJitterBufferCallback {
    void onAudioReadyToPlay();

    void onAudioSmoothOutput(byte[] r100);
}
