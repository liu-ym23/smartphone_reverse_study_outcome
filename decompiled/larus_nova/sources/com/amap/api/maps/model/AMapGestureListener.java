package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public interface AMapGestureListener {
    void onDoubleTap(float r100, float r101);

    void onDown(float r100, float r101);

    void onFling(float r100, float r101);

    void onLongPress(float r100, float r101);

    void onMapStable();

    void onScroll(float r100, float r101);

    void onSingleTap(float r100, float r101);

    void onUp(float r100, float r101);
}
