package com.byted.cast.mediacommon.render;

/* JADX INFO: loaded from: classes39.dex */
public interface ILatencyListener {
    void onDecodeIn(String r100, int r101, long r102, long r103);

    void onDecoded(String r100, int r101, long r102, long r103);

    void onRenderIn(String r100, int r101, long r102, long r103);

    void onRendered(String r100, int r101, long r102, long r103);
}
