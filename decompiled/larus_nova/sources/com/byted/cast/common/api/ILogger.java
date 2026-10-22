package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public interface ILogger {
    void onDebug(String r100, String r101);

    void onError(String r100, String r101);

    void onError(String r100, String r101, Throwable r102);

    void onInfo(String r100, String r101);

    void onVerbose(String r100, String r101);

    void onWarn(String r100, String r101);
}
