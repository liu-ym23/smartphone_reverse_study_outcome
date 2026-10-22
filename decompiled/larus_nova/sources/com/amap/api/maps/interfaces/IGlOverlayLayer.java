package com.amap.api.maps.interfaces;

import android.graphics.Rect;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public interface IGlOverlayLayer {
    boolean IsCircleContainPoint(CircleOptions r100, LatLng r101);

    boolean IsPolygonContainsPoint(PolygonOptions r100, LatLng r101);

    BaseOverlay addOverlayObject(String r100, BaseOverlay r101, BaseOptions r102);

    void changeOverlayIndex();

    boolean checkInBounds(String r100);

    void clear(String... r100);

    void clearOverlayByType(String r100);

    void clearTileCache();

    String createId(String r100);

    void destroy();

    boolean draw(int r100, int r101, int r102, boolean r103, boolean r104);

    int getCurrentParticleNum(String r100);

    BaseOverlay getHitBaseOverlay(MotionEvent r100, int r101);

    BaseOverlay getHitBaseOverlay(LatLng r100, int r101);

    Polyline getHitOverlay(LatLng r100, int r101);

    IAMapDelegate getMap();

    List<Marker> getMapScreenMarkers();

    void getMarkerInfoWindowOffset(String r100, FPoint r101);

    MultiPointItem getMultiPointItem(LatLng r100);

    Object getNativeProperties(String r100, String r101, Object[] r102);

    LatLng getNearestLatLng(PolylineOptions r100, LatLng r101);

    Rect getOverlayBoundRect(String r100);

    void getOverlayScreenPos(String r100, FPoint r101);

    void hideInfoWindow(String r100);

    boolean isGLOverlay(String r100);

    boolean isGLTFAnimated();

    void onCreateAMapInstance();

    void removeOverlay(String r100) throws RemoteException;

    boolean removeOverlay(String r100, boolean r101) throws RemoteException;

    void set2Top(String r100);

    void setFlingState(boolean r100);

    void setRunLowFrame(boolean r100);

    void showInfoWindow(String r100);

    void updateOption(String r100, BaseOptions r101);
}
