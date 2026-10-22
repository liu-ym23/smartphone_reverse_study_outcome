package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
interface IBackgroundDrawLayer {
    void onCreate();

    void onDestroy();

    void onDraw(BackgroundDrawMapView.CanvasProxy r100);

    void onSizeChanged(int r100, int r101);

    void onUpdated();
}
