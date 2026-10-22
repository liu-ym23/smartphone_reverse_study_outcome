package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.util.a;
import com.amap.api.mapcore.util.z0;
import com.amap.api.maps.AMap;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.extra.b;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public interface IAMapDelegate extends IAMap {
    void addGestureMapMessage(int r100, AbstractGestureMapMessage r101);

    void addOverlayTexture(int r100, GLTextureProperty r101);

    void animateCamera(AbstractCameraUpdateMessage r100) throws RemoteException;

    void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage r100, long r101, AMap.CancelableCallback r102);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(String r100, boolean r101, int r102);

    void changeMapLogo(int r100, boolean r101);

    void changeSize(int r100, int r101);

    void changeSurface(int r100, GL10 r101, int r102, int r103);

    float checkZoomLevel(float r100) throws RemoteException;

    void clearTileCache();

    String createId(String r100);

    int createOverlayTexture(int r100, Bitmap r101);

    void createSurface(int r100, GL10 r101, EGLConfig r102);

    void geo2Latlng(int r100, int r101, DPoint r102);

    void geo2Map(int r100, int r101, FPoint r102);

    b getAMapExtraInterfaceManager();

    float getCameraDegree(int r100);

    CameraPosition getCameraPositionPrj(boolean r100);

    Context getContext();

    a getCustomStyleManager();

    int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo r100);

    float[] getFinalMatrix();

    GLMapEngine getGLMapEngine();

    View getGLMapView();

    void getGeoCenter(int r100, IPoint r101);

    IGlOverlayLayer getGlOverlayLayer();

    z0 getInfoWindowDelegate();

    void getLatLng2Map(double r100, double r101, FPoint r102);

    void getLatLng2Pixel(double r100, double r101, IPoint r102);

    float getLogoMarginRate(int r100);

    int getLogoPosition();

    Point getLogoSize();

    float getLogoSizeScale();

    int getLogoWidth();

    float getMapAngle(int r100);

    LatLngBounds getMapBounds(LatLng r100, float r101, float r102, float r103);

    MapConfig getMapConfig();

    GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    void getPixel2Geo(int r100, int r101, IPoint r102);

    void getPixel2LatLng(int r100, int r101, DPoint r102);

    float getPreciseLevel(int r100);

    IProjectionDelegate getProjection() throws RemoteException;

    Rect getRect();

    UiSettings.ScaleControlsUnit getScaleControlsUnit();

    IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int r100);

    Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int r100);

    boolean isLockMapCameraDegree(int r100);

    boolean isOverseaAuthed();

    boolean isUseAnchor();

    boolean isUseGLTF();

    boolean isUseMVT();

    void latlon2Geo(double r100, double r101, IPoint r102);

    void map2Geo(float r100, float r101, IPoint r102);

    void moveCamera(AbstractCameraUpdateMessage r100) throws RemoteException;

    void onAMapAppResourceRequest(AMapAppRequestParam r100);

    boolean onDoubleTap(int r100, MotionEvent r101);

    void onLongPress(int r100, MotionEvent r101);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int r100, MotionEvent r101);

    void pixel2Map(int r100, int r101, PointF r102);

    void post(Runnable r100);

    void redrawInfoWindow();

    void redrawNativeOverlays();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(BaseMapOverlay r100);

    boolean removeGLModel(String r100);

    void removeGLOverlay(String r100) throws RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean r100, byte[] r101);

    void setGestureStatus(int r100, int r101);

    void setHideLogoEnble(boolean r100);

    void setLanguageAuth(boolean r100);

    void setLayoutDirectionRtl(boolean r100);

    void setLogoBottomMargin(int r100);

    void setLogoLeftMargin(int r100);

    void setLogoMarginRate(int r100, float r101);

    void setLogoPosition(int r100);

    void setLogoSizeScale(float r100);

    void setMapCustomEnable(boolean r100, boolean r101);

    void setMapEnable(boolean r100);

    void setMapWidgetListener(AMapWidgetListener r100);

    void setOverseaAuth(boolean r100);

    void setScaleControlsPosition(Point r100);

    void setScaleControlsUnit(UiSettings.ScaleControlsUnit r100);

    void setTerrainAuth(boolean r100);

    void setZoomPosition(int r100);

    void showCompassEnabled(boolean r100);

    void showIndoorSwitchControlsEnabled(boolean r100);

    void showInfoWindow(BaseOverlay r100) throws RemoteException;

    void showInfoWindow(BaseOverlayImp r100) throws RemoteException;

    void showLogoEnabled(boolean r100);

    void showMyLocationButtonEnabled(boolean r100);

    void showMyLocationOverlay(Location r100) throws RemoteException;

    void showScaleEnabled(boolean r100);

    void showZoomControlsEnabled(boolean r100);

    float toMapLenWithWin(int r100);

    void zoomOut(int r100);
}
