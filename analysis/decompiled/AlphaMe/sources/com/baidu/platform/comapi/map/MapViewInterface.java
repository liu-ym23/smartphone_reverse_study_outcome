package com.baidu.platform.comapi.map;

import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import java.util.List;

/* loaded from: classes.dex */
public interface MapViewInterface {
    boolean addBmLayer(BmLayer bmLayer);

    boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer);

    boolean addOverlay(Overlay overlay);

    boolean enable3D();

    List<BmLayer> getBmlayers();

    MapController getController();

    MapStatus getCurrentMapStatus();

    float getCurrentZoomLevel();

    MapStatus.GeoBound getGeoRound();

    int getLatitudeSpan();

    int getLongitudeSpan();

    GeoPoint getMapCenter();

    int getMapRotation();

    MapStatus getMapStatus();

    List<Overlay> getOverlays();

    double getOverlooking();

    Projection getProjection();

    MapStatus.WinRound getWinRound();

    float getZoomLevel();

    float getZoomToBound(MapBound mapBound);

    float getZoomToBound(MapBound mapBound, int i4, int i5);

    float getZoomToBoundF(MapBound mapBound);

    float getZoomToBoundF(MapBound mapBound, int i4, int i5);

    boolean isBaseIndoorMap();

    boolean isSatellite();

    boolean isStreetRoad();

    boolean isTraffic();

    boolean onTouchEvent(MotionEvent motionEvent);

    void refresh(Overlay overlay);

    boolean removeBmLayer(BmLayer bmLayer);

    boolean removeOverlay(Overlay overlay);

    void saveScreenToLocal(String str);

    void setBaseIndoorMap(boolean z4);

    void setGeoRound(MapStatus.GeoBound geoBound);

    void setMapCenter(GeoPoint geoPoint);

    void setMapStatus(MapStatus mapStatus);

    void setMapTo2D(boolean z4);

    void setOverlooking(int i4);

    void setRotation(int i4);

    void setSatellite(boolean z4);

    void setStreetRoad(boolean z4);

    void setTraffic(boolean z4);

    void setWinRound(MapStatus.WinRound winRound);

    void setZoomLevel(float f4);

    void setZoomLevel(int i4);

    boolean switchOverlay(Overlay overlay, Overlay overlay2);
}
