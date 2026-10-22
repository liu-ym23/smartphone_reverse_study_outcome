package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

/* loaded from: classes.dex */
public interface NaviMapViewListener {
    void onAction(int i4, Object obj);

    boolean onItemClick(String str, int i4, int i5);

    void onMapAnimationFinish();

    void onMapRenderModeChange(int i4);

    Point onTapInterception(Point point);

    void resizeScreen(int i4, int i5);
}
