package com.autonavi.amap.mapcore.interfaces;

import android.location.Location;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.util.p4;
import com.amap.api.mapcore.util.q4;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.ITileLoadCallback;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PoiFilter;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public interface IAMap {
    void accelerateNetworkInChinese(boolean r100);

    AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions r100) throws RemoteException;

    void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener r100);

    Arc addArc(ArcOptions r100) throws RemoteException;

    BuildingOverlay addBuildingOverlay();

    Circle addCircle(CircleOptions r100) throws RemoteException;

    q4 addContourLineOverlay(p4 r100);

    CrossOverlay addCrossVector(CrossOverlayOptions r100);

    GL3DModel addGLModel(GL3DModelOptions r100);

    GLTFOverlay addGLTFOverlay(GLTFOverlayOptions r100) throws RemoteException;

    GroundOverlay addGroundOverlay(GroundOverlayOptions r100) throws RemoteException;

    HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions r100) throws RemoteException;

    HeatMapLayer addHeatMapLayer(HeatMapLayerOptions r100) throws RemoteException;

    MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions r100) throws RemoteException;

    Marker addMarker(MarkerOptions r100) throws RemoteException;

    ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> r100, boolean r101) throws RemoteException;

    MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions r100) throws RemoteException;

    RouteOverlay addNaviRouteOverlay();

    NavigateArrow addNavigateArrow(NavigateArrowOptions r100) throws RemoteException;

    void addOnCameraChangeListener(AMap.OnCameraChangeListener r100) throws RemoteException;

    void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener r100) throws RemoteException;

    void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener r100) throws RemoteException;

    void addOnMapClickListener(AMap.OnMapClickListener r100) throws RemoteException;

    void addOnMapLoadedListener(AMap.OnMapLoadedListener r100) throws RemoteException;

    void addOnMapLongClickListener(AMap.OnMapLongClickListener r100) throws RemoteException;

    void addOnMapTouchListener(AMap.OnMapTouchListener r100) throws RemoteException;

    void addOnMarkerClickListener(AMap.OnMarkerClickListener r100) throws RemoteException;

    void addOnMarkerDragListener(AMap.OnMarkerDragListener r100) throws RemoteException;

    void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener r100) throws RemoteException;

    void addOnPOIClickListener(AMap.OnPOIClickListener r100) throws RemoteException;

    void addOnPolylineClickListener(AMap.OnPolylineClickListener r100) throws RemoteException;

    ParticleOverlay addParticleOverlay(ParticleOverlayOptions r100);

    void addPoiFilter(PoiFilter r100);

    Polygon addPolygon(PolygonOptions r100) throws RemoteException;

    Polyline addPolyline(PolylineOptions r100) throws RemoteException;

    void addSignleClickInterceptorListener(AMap.SignleClickInterceptorListener r100);

    Text addText(TextOptions r100) throws RemoteException;

    TileOverlay addTileOverlay(TileOverlayOptions r100) throws RemoteException;

    void animateCamera(CameraUpdate r100) throws RemoteException;

    void animateCameraWithCallback(CameraUpdate r100, AMap.CancelableCallback r101) throws RemoteException;

    void animateCameraWithDurationAndCallback(CameraUpdate r100, long r101, AMap.CancelableCallback r102) throws RemoteException;

    Pair<Float, LatLng> calculateZoomToSpanLevel(int r100, int r101, int r102, int r103, LatLng r104, LatLng r105);

    boolean canStopMapRender();

    void changeSurface(GL10 r100, int r101, int r102);

    void checkMapState(IGLMapState r100);

    void clear() throws RemoteException;

    void clear(boolean r100) throws RemoteException;

    void clearPoiFilter();

    long createGLOverlay(int r100);

    void createSurface(GL10 r100, EGLConfig r101);

    void destroy();

    void destroySurface(int r100);

    void drawFrame(GL10 r100);

    Projection getAMapProjection() throws RemoteException;

    UiSettings getAMapUiSettings() throws RemoteException;

    AMapCameraInfo getCamerInfo();

    float getCameraAngle();

    CameraPosition getCameraPosition() throws RemoteException;

    String getCurrentWorldVectorMapStyle();

    long getGlOverlayMgrPtr();

    InfoWindowAnimationManager getInfoWindowAnimationManager();

    void getLatLngRect(DPoint[] r100);

    Handler getMainHandler();

    int getMapBuildingZIndex() throws RemoteException;

    String getMapContentApprovalNumber();

    int getMapHeight();

    void getMapPrintScreen(AMap.onMapPrintScreenListener r100);

    List<Marker> getMapScreenMarkers() throws RemoteException;

    void getMapScreenShot(AMap.OnMapScreenShotListener r100, boolean r101);

    void getMapScreenShot(AMap.OnMapScreenShotListener r100, boolean r101, Handler r102);

    int getMapTextZIndex() throws RemoteException;

    int getMapType() throws RemoteException;

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation() throws RemoteException;

    MyLocationStyle getMyLocationStyle() throws RemoteException;

    int getNativeEngineID();

    long getNativeMapController();

    LatLngBounds getOverlayBoundRect(String r100);

    float[] getProjectionMatrix();

    int getRenderMode();

    int getSX();

    int getSY();

    String getSatelliteImageApprovalNumber();

    float getScalePerPixel() throws RemoteException;

    float getSkyHeight();

    String getTerrainApprovalNumber();

    View getView() throws RemoteException;

    float[] getViewMatrix();

    String getWorldVectorMapLanguage();

    String getWorldVectorMapStyle();

    float getZoomToSpanLevel(LatLng r100, LatLng r101);

    int hideBuildings(List<LatLng> r100);

    boolean isIndoorEnabled() throws RemoteException;

    boolean isMaploaded();

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isShowsLocalLanguage();

    boolean isTouchPoiEnable();

    boolean isTrafficEnabled() throws RemoteException;

    boolean isUseForNavi();

    void loadWorldVectorMap(boolean r100);

    void moveCamera(CameraUpdate r100) throws RemoteException;

    void onActivityPause();

    void onActivityResume();

    void onChangeFinish();

    void onFling();

    void onIndoorBuildingActivity(int r100, byte[] r101);

    boolean onTouchEvent(MotionEvent r100);

    void queueEvent(Runnable r100);

    void reloadMap();

    void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener r100);

    void removeOnCameraChangeListener(AMap.OnCameraChangeListener r100) throws RemoteException;

    void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener r100) throws RemoteException;

    void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener r100) throws RemoteException;

    void removeOnMapClickListener(AMap.OnMapClickListener r100) throws RemoteException;

    void removeOnMapLoadedListener(AMap.OnMapLoadedListener r100) throws RemoteException;

    void removeOnMapLongClickListener(AMap.OnMapLongClickListener r100) throws RemoteException;

    void removeOnMapTouchListener(AMap.OnMapTouchListener r100) throws RemoteException;

    void removeOnMarkerClickListener(AMap.OnMarkerClickListener r100) throws RemoteException;

    void removeOnMarkerDragListener(AMap.OnMarkerDragListener r100) throws RemoteException;

    void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener r100) throws RemoteException;

    void removeOnPOIClickListener(AMap.OnPOIClickListener r100) throws RemoteException;

    void removeOnPolylineClickListener(AMap.OnPolylineClickListener r100) throws RemoteException;

    void removePoiFilter(String r100);

    void removeSignleClickInterceptorListener(AMap.SignleClickInterceptorListener r100);

    void removecache() throws RemoteException;

    void removecache(AMap.OnCacheRemoveListener r100) throws RemoteException;

    void renderSurface(GL10 r100);

    void requestRender();

    void resetMinMaxZoomPreference();

    void resetRenderTime();

    void set3DBuildingEnabled(boolean r100) throws RemoteException;

    void setAMapGestureListener(AMapGestureListener r100);

    void setCenterToPixel(int r100, int r101) throws RemoteException;

    void setConstructingRoadEnable(boolean r100) throws RemoteException;

    void setCurrentLocation(LatLng r100);

    void setCustomMapStyle(CustomMapStyleOptions r100);

    void setCustomMapStyle(CustomMapStyleOptions r100, AMap.OnCustomMapStyleListener r101);

    void setCustomMapStyleID(String r100);

    void setCustomMapStylePath(String r100);

    void setCustomRenderer(CustomRenderer r100) throws RemoteException;

    void setCustomScreenDensity(float r100);

    void setCustomTextureResourcePath(String r100);

    void setDisableRender(boolean r100);

    void setIndoorBuildingInfo(IndoorBuildingInfo r100) throws RemoteException;

    void setIndoorEnabled(boolean r100) throws RemoteException;

    void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter r100) throws RemoteException;

    void setInfoWindowAdapter(AMap.InfoWindowAdapter r100) throws RemoteException;

    void setLoadOfflineData(boolean r100) throws RemoteException;

    void setLocationSource(LocationSource r100) throws RemoteException;

    void setLogoLanguage(String r100);

    void setMapBuildingZIndex(int r100) throws RemoteException;

    void setMapCustomEnable(boolean r100);

    void setMapLanguage(String r100);

    void setMapOptRecordState(boolean r100);

    void setMapStatusLimits(LatLngBounds r100);

    void setMapTextEnable(boolean r100) throws RemoteException;

    void setMapTextZIndex(int r100) throws RemoteException;

    void setMapType(int r100) throws RemoteException;

    void setMaskLayerParams(int r100, int r101, int r102, int r103, int r104, long r105);

    void setMaxZoomLevel(float r100);

    void setMinZoomLevel(float r100);

    void setMyLocationEnabled(boolean r100) throws RemoteException;

    void setMyLocationRotateAngle(float r100) throws RemoteException;

    void setMyLocationStyle(MyLocationStyle r100) throws RemoteException;

    void setMyLocationType(int r100) throws RemoteException;

    void setNaviLabelEnable(boolean r100, int r101, int r102) throws RemoteException;

    void setOnCameraChangeListener(AMap.OnCameraChangeListener r100) throws RemoteException;

    void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener r100) throws RemoteException;

    void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener r100) throws RemoteException;

    void setOnMapClickListener(AMap.OnMapClickListener r100) throws RemoteException;

    void setOnMapLongClickListener(AMap.OnMapLongClickListener r100) throws RemoteException;

    void setOnMapTouchListener(AMap.OnMapTouchListener r100) throws RemoteException;

    void setOnMaploadedListener(AMap.OnMapLoadedListener r100) throws RemoteException;

    void setOnMarkerClickListener(AMap.OnMarkerClickListener r100) throws RemoteException;

    void setOnMarkerDragListener(AMap.OnMarkerDragListener r100) throws RemoteException;

    void setOnMultiPointClickListener(AMap.OnMultiPointClickListener r100);

    void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener r100) throws RemoteException;

    void setOnPOIClickListener(AMap.OnPOIClickListener r100) throws RemoteException;

    void setOnPolylineClickListener(AMap.OnPolylineClickListener r100) throws RemoteException;

    void setRenderFps(int r100);

    void setRenderMode(int r100);

    void setRoadArrowEnable(boolean r100) throws RemoteException;

    void setRunLowFrame(boolean r100);

    void setShowsLocalLanguage(boolean r100);

    void setTileLoadCallback(ITileLoadCallback r100);

    void setTouchPoiEnable(boolean r100);

    void setTrafficEnabled(boolean r100) throws RemoteException;

    void setTrafficStyleWithTexture(byte[] r100, MyTrafficStyle r101);

    void setTrafficStyleWithTextureData(byte[] r100);

    void setUseForNavi(boolean r100);

    void setVisibilityEx(int r100);

    void setWorldVectorMapStyle(String r100);

    void setZOrderOnTop(boolean r100) throws RemoteException;

    void setZoomScaleParam(float r100);

    void showHideBuildings(int r100);

    void stopAnimation() throws RemoteException;

    void switchLanguage(String r100);
}
