package com.amap.api.maps;

/* loaded from: classes.dex */
public interface AMapGestureListener {
    void onDoubleTap(float f10, float f11);

    void onDown(float f10, float f11);

    void onFling(float f10, float f11);

    void onLongPress(float f10, float f11);

    void onMapStable();

    void onScroll(float f10, float f11);

    void onSingleTap(float f10, float f11);

    void onUp(float f10, float f11);
}
