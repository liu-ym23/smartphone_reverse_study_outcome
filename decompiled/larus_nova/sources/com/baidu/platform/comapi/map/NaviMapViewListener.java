package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: classes39.dex */
public interface NaviMapViewListener {
    void onAction(int r100, Object r101);

    boolean onItemClick(String r100, int r101, int r102);

    void onMapAnimationFinish();

    void onMapRenderModeChange(int r100);

    Point onTapInterception(Point r100);

    void resizeScreen(int r100, int r101);
}
