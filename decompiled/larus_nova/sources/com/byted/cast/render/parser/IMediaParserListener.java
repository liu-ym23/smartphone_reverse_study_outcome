package com.byted.cast.render.parser;

/* JADX INFO: loaded from: classes43.dex */
public interface IMediaParserListener {
    void OnAudioPacketAvalibale(byte[] r100, long r101);

    void OnError(String r100);

    void OnVideoPacketAvalibale(byte[] r100, long r101);

    void OnVideoParamtersChanged(int r100, int r101);
}
