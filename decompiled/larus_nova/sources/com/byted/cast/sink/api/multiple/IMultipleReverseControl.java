package com.byted.cast.sink.api.multiple;

/* JADX INFO: loaded from: classes43.dex */
public interface IMultipleReverseControl {
    int getCurrentPosition(String r100);

    int getDuration(String r100);

    void lowerVolume(String r100);

    boolean pause(String r100);

    void raiseVolume(String r100);

    void seekTo(String r100, int r101);

    void sendMetaData(String r100);

    void setVolume(String r100, int r101);

    boolean start(String r100);

    boolean stop(String r100);
}
