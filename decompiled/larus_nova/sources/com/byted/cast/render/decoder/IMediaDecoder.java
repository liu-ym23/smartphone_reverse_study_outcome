package com.byted.cast.render.decoder;

import com.byted.cast.mediacommon.render.MediaRenderState;

/* JADX INFO: loaded from: classes43.dex */
public interface IMediaDecoder {
    MediaRenderState getState();

    boolean sendPacket(byte[] r100, long r101);

    void setMediaDecoderListener(IMediaDecoderListener r100);

    boolean start();

    boolean stop();
}
