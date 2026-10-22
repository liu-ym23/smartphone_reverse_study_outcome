package com.byted.cast.mediacommon.render;

/* JADX INFO: loaded from: classes39.dex */
public interface IAudioFrameListener {
    void onAudioOutput(String r100, int r101, byte[] r102, int r103, int r104, int r105, int r106, long r107);

    void onError(String r100, int r101, int r102);
}
