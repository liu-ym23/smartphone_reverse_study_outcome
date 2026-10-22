package com.byted.cast.render.jitterbuffer;

/* JADX INFO: loaded from: classes43.dex */
public interface JitterBufferListener {
    void onAVSmoothOutput(byte[] r100, long r101);

    void onAudioReadyToPlay();
}
