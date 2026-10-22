package com.baidu.mapapi.map;

import com.baidu.mapapi.map.BackgroundDrawMapView;

/* loaded from: classes.dex */
interface IBackgroundDrawLayer {
    void onCreate();

    void onDestroy();

    void onDraw(BackgroundDrawMapView.CanvasProxy canvasProxy);

    void onSizeChanged(int i4, int i5);

    void onUpdated();
}
