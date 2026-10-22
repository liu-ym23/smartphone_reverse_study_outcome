package com.baidu.platform.comapi.map;

import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface MapViewInterface {
    boolean addBmLayer(BmLayer r100);

    boolean addBmLayerBelow(Overlay r100, BmLayer r101);

    boolean addOverlay(Overlay r100);

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

    float getZoomToBound(MapBound r100);

    float getZoomToBound(MapBound r100, int r101, int r102);

    float getZoomToBoundF(MapBound r100);

    float getZoomToBoundF(MapBound r100, int r101, int r102);

    boolean isBaseIndoorMap();

    boolean isSatellite();

    boolean isStreetRoad();

    boolean isTraffic();

    boolean onTouchEvent(MotionEvent r100);

    void refresh(Overlay r100);

    boolean removeBmLayer(BmLayer r100);

    boolean removeOverlay(Overlay r100);

    void saveScreenToLocal(String r100);

    void setBaseIndoorMap(boolean r100);

    void setGeoRound(MapStatus.GeoBound r100);

    void setMapCenter(GeoPoint r100);

    void setMapStatus(MapStatus r100);

    void setMapTo2D(boolean r100);

    void setOverlooking(int r100);

    void setRotation(int r100);

    void setSatellite(boolean r100);

    void setStreetRoad(boolean r100);

    void setTraffic(boolean r100);

    void setWinRound(MapStatus.WinRound r100);

    void setZoomLevel(float r100);

    void setZoomLevel(int r100);

    boolean switchOverlay(Overlay r100, Overlay r101);
}
