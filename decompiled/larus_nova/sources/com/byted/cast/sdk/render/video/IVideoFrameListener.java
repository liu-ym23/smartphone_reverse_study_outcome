package com.byted.cast.sdk.render.video;

/* JADX INFO: loaded from: classes43.dex */
public interface IVideoFrameListener {
    void onDecodeIn(String r100, long r101);

    void onDecoded(String r100, long r101);

    void onRendered(String r100, long r101);
}
