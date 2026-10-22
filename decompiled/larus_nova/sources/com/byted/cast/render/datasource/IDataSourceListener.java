package com.byted.cast.render.datasource;

/* JADX INFO: loaded from: classes43.dex */
public interface IDataSourceListener {
    void onAudioPacketAvailable(byte[] r100, long r101);

    void onVideoPacketAvailable(byte[] r100, long r101);
}
