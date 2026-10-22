package com.amap.api.maps;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.util.Pair;
import android.util.Size;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.p0;
import com.amap.api.mapcore.util.p4;
import com.amap.api.mapcore.util.q4;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BasePointOverlay;
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
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
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
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapState;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class AMap {
    public static final String CHINESE = "zh_cn";
    private static final String CLASSNAME = "AMap";
    public static final String CUSTOM = "custom";
    private static final int DEFAULT_MAP_BUILDING_Z_INDEX = -20000;
    public static final String ENGLISH = "en";
    public static final String LOCAL = "local";
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_BUS = 5;
    public static final int MAP_TYPE_NAVI = 4;
    public static final int MAP_TYPE_NAVI_NIGHT = 6;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MASK_LAYER_NONE = -1;
    public static final int MASK_LAYER_UNDER_LINE = 1;
    public static final int MASK_LAYER_UNDER_MARKER = 0;
    public static final String STYLE_CHINESE = "style_zh_cn";
    private final IAMap mapDelegate;
    private MyTrafficStyle myTrafficStyle;
    private Projection projection;
    private UiSettings uiSettings;

    public interface AMapAppResourceRequestListener {
        void onRequest(AMapAppRequestParam r100);
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface CommonInfoWindowAdapter {
        InfoWindowParams getInfoWindowParams(BasePointOverlay r100);
    }

    public interface ImageInfoWindowAdapter extends InfoWindowAdapter {
        long getInfoWindowUpdateTime();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker r100);

        View getInfoWindow(Marker r100);
    }

    public interface MultiPositionInfoWindowAdapter extends InfoWindowAdapter {
        View getInfoWindowClick(Marker r100);

        View getOverturnInfoWindow(Marker r100);

        View getOverturnInfoWindowClick(Marker r100);
    }

    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean r100);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition r100);

        void onCameraChangeFinish(CameraPosition r100);
    }

    public interface OnCustomMapStyleListener {
        void onFailure(int r100, String r101);
    }

    public interface OnIndoorBuildingActiveListener {
        void OnIndoorBuilding(IndoorBuildingInfo r100);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker r100);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng r100);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng r100);
    }

    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap r100);

        void onMapScreenShot(Bitmap r100, int r101);
    }

    public interface OnMapSnapshotListener {
        void onFinish();

        void onMapTile(Rect r100, Bitmap r101, int r102);
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent r100);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker r100);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker r100);

        void onMarkerDragEnd(Marker r100);

        void onMarkerDragStart(Marker r100);
    }

    public interface OnMultiPointClickListener {
        boolean onPointClick(MultiPointItem r100);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location r100);
    }

    public interface OnPOIClickListener {
        void onPOIClick(Poi r100);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline r100);
    }

    public interface SignleClickInterceptorListener {
        boolean isInterceptorSignleClick(MotionEvent r100);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f28604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnMapSnapshotListener f28605b;

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_maps_AMap$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_maps_AMap$a__run$___twin___() {
            this.f28604a.a();
            this.f28605b.onFinish();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_maps_AMap$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_maps_AMap$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AMap r100, b r101, OnMapSnapshotListener r102) {
            this.f28604a = r101;
            this.f28605b = r102;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Size f28606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CameraPosition f28607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f28608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AMap f28609d;

        public void a() {
            if ((AMap.a(this.f28609d) instanceof com.amap.api.mapcore.util.b) == false) goto L5;
            ((com.amap.api.mapcore.util.b) AMap.a(this.f28609d)).a(this.f28606a);
        L5:
            this.f28609d.animateCamera(CameraUpdateFactory.newCameraPosition(this.f28607b));
            this.f28609d.getUiSettings().setLogoPosition(this.f28608c);
        }

        private b(AMap r100) {
            this.f28609d = r100;
        }

        public void a(Size r100) {
            this.f28608c = this.f28609d.getUiSettings().getLogoPosition();
            this.f28609d.getUiSettings().setLogoPosition(2);
            this.f28607b = CameraPosition.builder(this.f28609d.getCameraPosition()).build();
            if ((AMap.a(this.f28609d) instanceof com.amap.api.mapcore.util.b) == false) goto L6;
            this.f28606a = ((com.amap.api.mapcore.util.b) AMap.a(this.f28609d)).b(r100);
            return;
        }

        public /* synthetic */ b(AMap r100, a r101) {
            this(r100);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SizeF f28610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RectF f28611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f28612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private IPoint f28613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IPoint f28614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IPoint f28615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f28616g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f28617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f28618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ AMap f28619j;

        public CameraUpdate a() {
            int r100 = this.f28618i;
            if (r100 != 0) goto L6;
            IPoint r101 = a(this.f28611b.centerX(), this.f28611b.centerY());
            DPoint r102 = new DPoint();
            GLMapState.geo2LonLat(((Point) r101).x, ((Point) r101).y, r102);
            LatLng r103 = new LatLng(r102.f30022y, r102.f30021x);
            long r104 = ((long) this.f28613d.distance(this.f28614e)) / ((long) this.f28616g);
            DPoint r105 = new DPoint();
            GLMapState.geo2LonLat(0, r104, r105);
            LatLng r106 = new LatLng(r105.f30022y, r105.f30021x);
            long r107 = ((long) this.f28615f.distance(this.f28613d)) / ((long) this.f28617h);
            DPoint r108 = new DPoint();
            GLMapState.geo2LonLat(r107, 0, r108);
            return CameraUpdateFactory.newCameraPosition(new CameraPosition(r103, this.f28619j.getZoomToSpanLevel(r106, new LatLng(r108.f30022y, r108.f30021x)), 0.0f, (float) ((this.f28612c * 180.0d) / 3.141592653589793d)));
        L6:
            int r109 = this.f28616g;
            if (((r100 - 1) / r109) >= (r100 / r109)) goto L11;
            return CameraUpdateFactory.scrollBy((-this.f28611b.width()) * (this.f28616g - 1), this.f28611b.height());
        L11:
            return CameraUpdateFactory.scrollBy(this.f28611b.width(), 0.0f);
        }

        public Rect b() {
            RectF r100 = this.f28611b;
            return new Rect((int) r100.left, (int) r100.top, (int) r100.right, (int) r100.bottom);
        }

        public Size c() {
            return new Size((int) this.f28611b.width(), (int) this.f28611b.height());
        }

        public boolean d() {
            if (this.f28618i == ((this.f28616g * this.f28617h) - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean e() {
            RectF r100 = this.f28611b;
            if ((r100.right + r100.width()) > this.f28610a.getWidth()) goto L5;
            RectF r101 = this.f28611b;
            r101.offset(r101.width(), 0.0f);
        L8:
            this.f28618i++;
            return true;
        L5:
            RectF r102 = this.f28611b;
            if ((r102.bottom + r102.height()) > this.f28610a.getHeight()) goto L10;
            RectF r103 = this.f28611b;
            r103.offset(-r103.left, r103.height());
            goto L8
        L10:
            return false;
        }

        private IPoint a(double r110, double r111) {
            double r100 = Math.sin(this.f28612c);
            double r101 = Math.cos(this.f28612c);
            double r102 = this.f28613d.distance(this.f28614e) / ((double) this.f28610a.getWidth());
            double r103 = ((r110 * r101) - (r111 * r100)) * r102;
            IPoint r112 = this.f28613d;
            return new IPoint((int) (r103 + ((double) ((Point) r112).x)), (int) ((r102 * ((r101 * r111) + (r100 * r110))) + ((double) ((Point) r112).y)));
        }

        public c(AMap r100, LatLng r101, LatLng r102, Size r103) {
            this.f28619j = r100;
            this.f28613d = new IPoint();
            this.f28614e = new IPoint();
            this.f28616g = 0;
            this.f28617h = 0;
            this.f28618i = 0;
            this.f28610a = new SizeF(r103.getWidth(), r103.getHeight());
            GLMapState.lonlat2Geo(r101.longitude, r101.latitude, this.f28613d);
            GLMapState.lonlat2Geo(r102.longitude, r102.latitude, this.f28614e);
            this.f28615f = a(AudioStats.AUDIO_AMPLITUDE_NONE, this.f28610a.getHeight());
            this.f28616g = ((int) this.f28610a.getWidth()) / 4096;
            if ((this.f28610a.getWidth() % 4096.0f) <= 0.0f) goto L5;
            this.f28616g++;
        L5:
            this.f28617h = ((int) this.f28610a.getHeight()) / 4096;
            if ((this.f28610a.getHeight() % 4096.0f) <= 0.0f) goto L8;
            this.f28617h++;
        L8:
            this.f28611b = new RectF(0.0f, 0.0f, this.f28610a.getWidth() / this.f28616g, this.f28610a.getHeight() / this.f28617h);
            IPoint r104 = this.f28614e;
            int r105 = ((Point) r104).y;
            IPoint r106 = this.f28613d;
            this.f28612c = Math.atan(((double) (r105 - ((Point) r106).y)) / ((double) (((Point) r104).x - ((Point) r106).x)));
        }
    }

    public interface onMapPrintScreenListener {
        void onMapPrint(Drawable r100);
    }

    public static String getVersion() {
        return "11.2.101";
    }

    public final BuildingOverlay addBuildingOverlay() {
        return this.mapDelegate.addBuildingOverlay();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public RouteOverlay addRouteOverlay() {
        return this.mapDelegate.addNaviRouteOverlay();
    }

    public final void clear() {
        this.mapDelegate.clear();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void clearPoiFilter() {
        this.mapDelegate.clearPoiFilter();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final CameraPosition getCameraPosition() {
        return this.mapDelegate.getCameraPosition();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getCurrentStyle() {
        IAMap r100 = this.mapDelegate;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        return r100.getCurrentWorldVectorMapStyle();
    L6:
        return "";
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return this.mapDelegate.getInfoWindowAnimationManager();
    }

    public final int getMapBuildingZIndex() {
        return this.mapDelegate.getMapBuildingZIndex();
    L4:
        th = move-exception;
        th.printStackTrace();
        return -20000;
    }

    public String getMapContentApprovalNumber() {
        return this.mapDelegate.getMapContentApprovalNumber();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final List<Marker> getMapScreenMarkers() {
        List<Marker> r100 = this.mapDelegate.getMapScreenMarkers();     // Catch: Throwable -> L6
        if (r100 != null) goto L11;
        return new ArrayList();
    L11:
        return r100;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final int getMapTextZIndex() {
        return this.mapDelegate.getMapTextZIndex();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public final int getMapType() {
        return this.mapDelegate.getMapType();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 1;
    }

    public final float getMaxZoomLevel() {
        return this.mapDelegate.getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return this.mapDelegate.getMinZoomLevel();
    }

    public final Location getMyLocation() {
        return this.mapDelegate.getMyLocation();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final MyLocationStyle getMyLocationStyle() {
        return this.mapDelegate.getMyLocationStyle();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public long getNativeMapController() {
        return this.mapDelegate.getNativeMapController();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getNativeMapEngineID() {
        return this.mapDelegate.getNativeEngineID();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public final Projection getProjection() {
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    L3:
        if (this.projection != null) goto L5;
        this.projection = this.mapDelegate.getAMapProjection();     // Catch: Throwable -> L7
    L5:
        return this.projection;
    }

    public float[] getProjectionMatrix() {
        return this.mapDelegate.getProjectionMatrix();
    }

    public String getSatelliteImageApprovalNumber() {
        return this.mapDelegate.getSatelliteImageApprovalNumber();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getScalePerPixel() {
        return this.mapDelegate.getScalePerPixel();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public String getTerrainApprovalNumber() {
        return this.mapDelegate.getTerrainApprovalNumber();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final UiSettings getUiSettings() {
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    L3:
        if (this.uiSettings != null) goto L5;
        this.uiSettings = this.mapDelegate.getAMapUiSettings();     // Catch: Throwable -> L7
    L5:
        return this.uiSettings;
    }

    public float[] getViewMatrix() {
        return this.mapDelegate.getViewMatrix();
    }

    public final boolean isMyLocationEnabled() {
        return this.mapDelegate.isMyLocationEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isShowsLocalLanguage() {
        return this.mapDelegate.isShowsLocalLanguage();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public boolean isTouchPoiEnable() {
        return this.mapDelegate.isTouchPoiEnable();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public final boolean isTrafficEnabled() {
        return this.mapDelegate.isTrafficEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void reloadMap() {
        this.mapDelegate.reloadMap();
    }

    public void removecache() {
        this.mapDelegate.removecache();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void resetMinMaxZoomPreference() {
        this.mapDelegate.resetMinMaxZoomPreference();
    }

    public void runOnDrawFrame() {
        this.mapDelegate.setRunLowFrame(false);
    }

    public final void stopAnimation() {
        this.mapDelegate.stopAnimation();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public MyTrafficStyle getMyTrafficStyle() {
        return this.myTrafficStyle;
    }

    public AMap(IAMap r100) {
        this.mapDelegate = r100;
    }

    public static /* synthetic */ IAMap a(AMap r100) {
        return r100.mapDelegate;
    }

    public void accelerateNetworkInChinese(boolean r100) {
        IAMap r101 = this.mapDelegate;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.accelerateNetworkInChinese(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions r100) {
        return this.mapDelegate.add3DModelTileOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void addAMapAppResourceListener(AMapAppResourceRequestListener r100) {
        this.mapDelegate.addAMapAppResourceListener(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final Arc addArc(ArcOptions r100) {
        return this.mapDelegate.addArc(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final Circle addCircle(CircleOptions r100) {
        return this.mapDelegate.addCircle(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public q4 addContourLineOverlay(p4 r100) {
        return this.mapDelegate.addContourLineOverlay(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public CrossOverlay addCrossOverlay(CrossOverlayOptions r100) {
        return this.mapDelegate.addCrossVector(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public GL3DModel addGL3DModel(GL3DModelOptions r100) {
        return this.mapDelegate.addGLModel(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions r100) {
        return this.mapDelegate.addGLTFOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions r100) {
        return this.mapDelegate.addGroundOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions r100) {
        return this.mapDelegate.addHeatMapGridLayer(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions r100) {
        return this.mapDelegate.addHeatMapLayer(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions r100) {
        return this.mapDelegate.addMVTTileOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final Marker addMarker(MarkerOptions r100) {
        return this.mapDelegate.addMarker(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions r100) {
        return this.mapDelegate.addMultiPointOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions r100) {
        return this.mapDelegate.addNavigateArrow(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void addOnCameraChangeListener(OnCameraChangeListener r100) {
        this.mapDelegate.addOnCameraChangeListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void addOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener r100) {
        this.mapDelegate.addOnIndoorBuildingActiveListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void addOnInfoWindowClickListener(OnInfoWindowClickListener r100) {
        this.mapDelegate.addOnInfoWindowClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnMapClickListener(OnMapClickListener r100) {
        this.mapDelegate.addOnMapClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnMapLoadedListener(OnMapLoadedListener r100) {
        this.mapDelegate.addOnMapLoadedListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void addOnMapLongClickListener(OnMapLongClickListener r100) {
        this.mapDelegate.addOnMapLongClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnMapTouchListener(OnMapTouchListener r100) {
        this.mapDelegate.addOnMapTouchListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnMarkerClickListener(OnMarkerClickListener r100) {
        this.mapDelegate.addOnMarkerClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnMarkerDragListener(OnMarkerDragListener r100) {
        this.mapDelegate.addOnMarkerDragListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void addOnMyLocationChangeListener(OnMyLocationChangeListener r100) {
        this.mapDelegate.addOnMyLocationChangeListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnPOIClickListener(OnPOIClickListener r100) {
        this.mapDelegate.addOnPOIClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void addOnPolylineClickListener(OnPolylineClickListener r100) {
        this.mapDelegate.addOnPolylineClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public ParticleOverlay addParticleOverlay(ParticleOverlayOptions r100) {
        return this.mapDelegate.addParticleOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void addPoiFilter(PoiFilter r100) {
        this.mapDelegate.addPoiFilter(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final Polygon addPolygon(PolygonOptions r100) {
        return this.mapDelegate.addPolygon(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final Polyline addPolyline(PolylineOptions r100) {
        return this.mapDelegate.addPolyline(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void addSignleClickInterceptorListener(SignleClickInterceptorListener r100) {
        this.mapDelegate.addSignleClickInterceptorListener(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final Text addText(TextOptions r100) {
        return this.mapDelegate.addText(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions r100) {
        return this.mapDelegate.addTileOverlay(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void animateCamera(CameraUpdate r100) {
        this.mapDelegate.animateCamera(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void clear(boolean r100) {
        this.mapDelegate.clear(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void getMapPrintScreen(onMapPrintScreenListener r100) {
        this.mapDelegate.getMapPrintScreen(r100);
    }

    public void getMapScreenShot(OnMapScreenShotListener r100) {
        this.mapDelegate.getMapScreenShot(r100, true);
    }

    public LatLngBounds getOverlayBoundRect(String r100) {
        return this.mapDelegate.getOverlayBoundRect(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void getP20MapCenter(IPoint r100) {
        if (r100 == null) goto L9;
    L4:
        ((Point) r100).x = this.mapDelegate.getSX();     // Catch: Throwable -> L6
        ((Point) r100).y = this.mapDelegate.getSY();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        r100 = new IPoint();     // Catch: Throwable -> L6
        goto L4
    }

    public int hideBuildings(List<LatLng> r100) {
        return this.mapDelegate.hideBuildings(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public final void moveCamera(CameraUpdate r100) {
        this.mapDelegate.moveCamera(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeAMapAppResourceListener(AMapAppResourceRequestListener r100) {
        this.mapDelegate.removeAMapAppResourceListener(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final void removeOnCameraChangeListener(OnCameraChangeListener r100) {
        this.mapDelegate.removeOnCameraChangeListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener r100) {
        this.mapDelegate.removeOnIndoorBuildingActiveListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeOnInfoWindowClickListener(OnInfoWindowClickListener r100) {
        this.mapDelegate.removeOnInfoWindowClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnMapClickListener(OnMapClickListener r100) {
        this.mapDelegate.removeOnMapClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnMapLoadedListener(OnMapLoadedListener r100) {
        this.mapDelegate.removeOnMapLoadedListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener r100) {
        this.mapDelegate.removeOnMapLongClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnMapTouchListener(OnMapTouchListener r100) {
        this.mapDelegate.removeOnMapTouchListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnMarkerClickListener(OnMarkerClickListener r100) {
        this.mapDelegate.removeOnMarkerClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnMarkerDragListener(OnMarkerDragListener r100) {
        this.mapDelegate.removeOnMarkerDragListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeOnMyLocationChangeListener(OnMyLocationChangeListener r100) {
        this.mapDelegate.removeOnMyLocationChangeListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnPOIClickListener(OnPOIClickListener r100) {
        this.mapDelegate.removeOnPOIClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void removeOnPolylineClickListener(OnPolylineClickListener r100) {
        this.mapDelegate.removeOnPolylineClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void removePoiFilter(String r100) {
        this.mapDelegate.removePoiFilter(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void removeSignleClickInterceptorListener(SignleClickInterceptorListener r100) {
        this.mapDelegate.removeSignleClickInterceptorListener(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void removecache(OnCacheRemoveListener r100) {
        this.mapDelegate.removecache(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setAMapGestureListener(AMapGestureListener r100) {
        this.mapDelegate.setAMapGestureListener(r100);
    }

    public final void setCommonInfoWindowAdapter(CommonInfoWindowAdapter r100) {
        this.mapDelegate.setInfoWindowAdapter(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setConstructingRoadEnable(boolean r100) {
        this.mapDelegate.setConstructingRoadEnable(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setCurrentLocation(LatLng r100) {
        this.mapDelegate.setCurrentLocation(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setCustomMapStyle(CustomMapStyleOptions r100) {
        this.mapDelegate.setCustomMapStyle(r100);
    }

    public void setCustomMapStyleID(String r100) {
        p0.a(2131034392);
    }

    public void setCustomMapStylePath(String r100) {
        p0.a(2131034392);
    }

    public void setCustomRenderer(CustomRenderer r100) {
        this.mapDelegate.setCustomRenderer(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setCustomScreenDensity(float r100) {
        this.mapDelegate.setCustomScreenDensity(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setCustomTextureResourcePath(String r100) {
        p0.a(2131034392);
    }

    public void setDisableRender(boolean r100) {
        this.mapDelegate.setDisableRender(r100);
    }

    public void setIndoorBuildingInfo(IndoorBuildingInfo r100) {
        this.mapDelegate.setIndoorBuildingInfo(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter r100) {
        this.mapDelegate.setInfoWindowAdapter(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setLoadOfflineData(boolean r100) {
        this.mapDelegate.setLoadOfflineData(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setLocationSource(LocationSource r100) {
        this.mapDelegate.setLocationSource(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setLogoLanguage(String r100) {
        MapsInitializer.setLogoLanguage(r100);     // Catch: Throwable -> L4
        this.mapDelegate.setLogoLanguage(MapsInitializer.getLogoLanguage());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setMapBuildingZIndex(int r100) {
        this.mapDelegate.setMapBuildingZIndex(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setMapCustomEnable(boolean r100) {
        p0.a(2131034392);
    }

    public void setMapLanguage(String r100) {
        this.mapDelegate.setMapLanguage(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setMapStatusLimits(LatLngBounds r100) {
        this.mapDelegate.setMapStatusLimits(r100);     // Catch: Throwable -> L4
        moveCamera(CameraUpdateFactory.newLatLngBounds(r100, 0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setMapTextZIndex(int r100) {
        this.mapDelegate.setMapTextZIndex(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setMapType(int r100) {
        this.mapDelegate.setMapType(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setMaxZoomLevel(float r100) {
        this.mapDelegate.setMaxZoomLevel(r100);
    }

    public void setMinZoomLevel(float r100) {
        this.mapDelegate.setMinZoomLevel(r100);
    }

    public final void setMyLocationEnabled(boolean r100) {
        this.mapDelegate.setMyLocationEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setMyLocationRotateAngle(float r100) {
        this.mapDelegate.setMyLocationRotateAngle(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setMyLocationStyle(MyLocationStyle r100) {
        this.mapDelegate.setMyLocationStyle(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setMyLocationType(int r100) {
        this.mapDelegate.setMyLocationType(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setMyTrafficStyle(MyTrafficStyle r100) {
        this.myTrafficStyle = r100;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener r100) {
        this.mapDelegate.setOnCameraChangeListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener r100) {
        this.mapDelegate.setOnIndoorBuildingActiveListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener r100) {
        this.mapDelegate.setOnInfoWindowClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMapClickListener(OnMapClickListener r100) {
        this.mapDelegate.setOnMapClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener r100) {
        this.mapDelegate.setOnMaploadedListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener r100) {
        this.mapDelegate.setOnMapLongClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMapTouchListener(OnMapTouchListener r100) {
        this.mapDelegate.setOnMapTouchListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener r100) {
        this.mapDelegate.setOnMarkerClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener r100) {
        this.mapDelegate.setOnMarkerDragListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setOnMultiPointClickListener(OnMultiPointClickListener r100) {
        this.mapDelegate.setOnMultiPointClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener r100) {
        this.mapDelegate.setOnMyLocationChangeListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnPOIClickListener(OnPOIClickListener r100) {
        this.mapDelegate.setOnPOIClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener r100) {
        this.mapDelegate.setOnPolylineClickListener(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setOptRecordState(boolean r100) {
        this.mapDelegate.setMapOptRecordState(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setRenderFps(int r100) {
        this.mapDelegate.setRenderFps(r100);
    }

    public void setRenderMode(int r100) {
        this.mapDelegate.setRenderMode(r100);
    }

    public void setRoadArrowEnable(boolean r100) {
        this.mapDelegate.setRoadArrowEnable(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setShowsLocalLanguage(boolean r100) {
        this.mapDelegate.setShowsLocalLanguage(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTileLoadCallback(ITileLoadCallback r100) {
        this.mapDelegate.setTileLoadCallback(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTouchPoiEnable(boolean r100) {
        this.mapDelegate.setTouchPoiEnable(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTrafficEnabled(boolean r100) {
        this.mapDelegate.setTrafficEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTrafficStyleWithTextureData(byte[] r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        this.mapDelegate.setTrafficStyleWithTextureData(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setUseForNavi(boolean r100) {
        this.mapDelegate.setUseForNavi(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setWorldVectorMapStyle(String r100) {
        this.mapDelegate.setWorldVectorMapStyle(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void showBuildings(boolean r100) {
        this.mapDelegate.set3DBuildingEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void showHideBuildings(int r100) {
        this.mapDelegate.showHideBuildings(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void showIndoorMap(boolean r100) {
        this.mapDelegate.setIndoorEnabled(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void showMapText(boolean r100) {
        this.mapDelegate.setMapTextEnable(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> r100, boolean r101) {
        return this.mapDelegate.addMarkers(r100, r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void animateCamera(CameraUpdate r100, CancelableCallback r101) {
        this.mapDelegate.animateCameraWithCallback(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void getMapScreenShot(OnMapScreenShotListener r100, Handler r101) {
        this.mapDelegate.getMapScreenShot(r100, true, r101);
    }

    public float getZoomToSpanLevel(LatLng r100, LatLng r101) {
        return this.mapDelegate.getZoomToSpanLevel(r100, r101);
    }

    public void setCustomMapStyle(CustomMapStyleOptions r100, OnCustomMapStyleListener r101) {
        this.mapDelegate.setCustomMapStyle(r100, r101);
    }

    public void setPointToCenter(int r100, int r101) {
        this.mapDelegate.setCenterToPixel(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setTrafficStyleWithTexture(byte[] r100, MyTrafficStyle r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        this.mapDelegate.setTrafficStyleWithTexture(r100, r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L13:
        return;
    }

    public final void animateCamera(CameraUpdate r100, long r101, CancelableCallback r102) {
        int r103 = (r101 > 0 ? 1 : (r101 == 0 ? 0 : -1));
        this.mapDelegate.animateCameraWithDurationAndCallback(r100, r101, r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public void setNaviLabelEnable(boolean r100, int r101, int r102) {
        this.mapDelegate.setNaviLabelEnable(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void getMapRegionSnapshot(LatLng r100, LatLng r101, Size r102, OnMapSnapshotListener r103) {
        IAMap r104 = this.mapDelegate;
        if ((r104 instanceof com.amap.api.mapcore.util.b) == true) goto L5;
    L8:
        c r105 = new c(this, r100, r101, r102);
        b r106 = new b(this, null);
        r106.a(r105.c());
        a r107 = new a(this, r106, r103);
        com.amap.api.maps.c r108 = new com.amap.api.maps.c(this, r103, r105, r107);
        animateCamera(r105.a(), new d(this, r108, r107));
        return;
    L5:
        if (((com.amap.api.mapcore.util.b) r104).getMapConfig().isTerrainEnable() == false) goto L8;
        r103.onFinish();
    }

    public Pair<Float, LatLng> calculateZoomToSpanLevel(int r100, int r101, int r110, int r111, LatLng r112, LatLng r113) {
        return this.mapDelegate.calculateZoomToSpanLevel(r100, r101, r110, r111, r112, r113);
    }

    public void setMaskLayerParams(int r100, int r110, int r111, int r112, int r113, long r114) {
        this.mapDelegate.setMaskLayerParams(r100, r110, r111, r112, r113, r114);
    }
}
