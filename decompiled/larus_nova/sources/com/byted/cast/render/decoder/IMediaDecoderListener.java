package com.byted.cast.render.decoder;

/* JADX INFO: loaded from: classes43.dex */
public interface IMediaDecoderListener {
    void OnAVFrameAvailable(byte[] r100, long r101);

    void OnAVFrameRendered(byte[] r100, long r101);

    void OnError(int r100, String r101);

    void OnVideoSizeChanged(int r100, int r101, int r102, int r103, int r104);
}
