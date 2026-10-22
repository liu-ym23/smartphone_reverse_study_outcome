package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.mapcore.util.r4;
import com.amap.api.mapcore.util.s4;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface IRouteOverlayInner {
    void addRouteItem(int r100, s4[] r101, int r102, r4 r103, int[] r104);

    void addRouteName();

    Pair<Float, Float> getDisplayRange();

    int getOverlayProperty();

    boolean isVisible();

    void remove();

    void removeRouteName();

    void setArrow3DTexture(BitmapDescriptor r100);

    void setArrowFlow(boolean r100);

    void setCar2DPosition(int r100, float r101);

    void setCar3DPosition(int r100, float r101);

    void setDisplayRange(float r100, float r101);

    void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam r100);

    void setHighlightType(int r100);

    void setLine2DWidth(int r100, int r101);

    void setLineWidthScale(float r100);

    void setOverlayProperty(int r100);

    void setRouteItemParam(s4 r100);

    void setSelectStatus(boolean r100);

    void setShowArrow(boolean r100);

    void setShowNaviRouteNameCountMap(Map<Integer, Integer> r100);

    void setVisible(boolean r100);
}
