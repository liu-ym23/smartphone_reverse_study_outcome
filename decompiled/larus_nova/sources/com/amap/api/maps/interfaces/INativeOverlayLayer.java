package com.amap.api.maps.interfaces;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public interface INativeOverlayLayer {
    void addNativeOverlay(Marker r100, MarkerOptions r101);

    boolean checkInBounds(String r100);

    void clear();

    BaseOverlay getHitOverlay(DPoint r100, int r101);

    List<Marker> getMapScreenMarkers();

    void getMarkerInfoWindowOffset(String r100, FPoint r101);

    Rect getOverlayBoundRect(String r100);

    void getOverlayScreenPos(String r100, FPoint r101);

    void hideInfoWindow(String r100);

    boolean isInfoWindowShown(String r100);

    void redrawOverlays();

    void removeNativeOverlay(String r100);

    void screenShotOverlays(Canvas r100);

    void set2Top(String r100);

    void showInfoWindow(String r100);

    void updateOverlayOption(String r100, MarkerOptions r101);

    void updateOverlaysPosition();
}
