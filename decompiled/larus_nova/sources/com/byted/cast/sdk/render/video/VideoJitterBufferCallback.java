package com.byted.cast.sdk.render.video;

/* JADX INFO: loaded from: classes43.dex */
public interface VideoJitterBufferCallback {
    void onOutputFrame(long r100);

    void onRenderFrame(long r100);

    void onVideoSize(int r100, int r101);
}
