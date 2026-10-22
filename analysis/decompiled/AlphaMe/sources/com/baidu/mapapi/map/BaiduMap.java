package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.NetworkUpdate2MapListener;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.HexagonMap;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.bmsdk.ui.BaseUI;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.Bm3DModel;
import com.baidu.platform.comapi.bmsdk.BmArc;
import com.baidu.platform.comapi.bmsdk.BmBaseLine;
import com.baidu.platform.comapi.bmsdk.BmCircle;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGround;
import com.baidu.platform.comapi.bmsdk.BmIconMarker;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmMultiPoint;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.CaptureMapViewListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.map.w;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 22.0f;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0f;

    /* renamed from: a, reason: collision with root package name */
    private static final String f6159a = "BaiduMap";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f6160b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f6161c = false;
    public static int mapStatusReason = 256;

    /* renamed from: A, reason: collision with root package name */
    private OnMapLongClickListener f6162A;

    /* renamed from: K, reason: collision with root package name */
    private OnMarkerDragListener f6172K;

    /* renamed from: L, reason: collision with root package name */
    private OnMyLocationClickListener f6173L;

    /* renamed from: M, reason: collision with root package name */
    private SnapshotReadyCallback f6174M;

    /* renamed from: N, reason: collision with root package name */
    private Building3DListener f6175N;

    /* renamed from: O, reason: collision with root package name */
    private CopyOnWriteArrayList<Building> f6176O;

    /* renamed from: P, reason: collision with root package name */
    private OnMapDrawFrameCallback f6177P;

    /* renamed from: Q, reason: collision with root package name */
    private OnBaseIndoorMapListener f6178Q;

    /* renamed from: R, reason: collision with root package name */
    private OnMapRenderValidDataListener f6179R;

    /* renamed from: S, reason: collision with root package name */
    private OnHeatMapDrawFrameCallBack f6180S;
    private OnSynchronizationListener T;

    /* renamed from: U, reason: collision with root package name */
    NetworkUpdate2MapListener f6181U;

    /* renamed from: V, reason: collision with root package name */
    private TileOverlay f6182V;

    /* renamed from: W, reason: collision with root package name */
    private HeatMap f6183W;

    /* renamed from: X, reason: collision with root package name */
    private HexagonMap f6184X;

    /* renamed from: b0, reason: collision with root package name */
    private Map<String, InfoWindow> f6188b0;

    /* renamed from: c0, reason: collision with root package name */
    private Map<InfoWindow, Marker> f6189c0;

    /* renamed from: d, reason: collision with root package name */
    private Projection f6190d;

    /* renamed from: d0, reason: collision with root package name */
    private Marker f6191d0;

    /* renamed from: e, reason: collision with root package name */
    private UiSettings f6192e;

    /* renamed from: e0, reason: collision with root package name */
    private MyLocationData f6193e0;

    /* renamed from: f, reason: collision with root package name */
    private MapSurfaceView f6194f;

    /* renamed from: f0, reason: collision with root package name */
    private MyLocationConfiguration f6195f0;

    /* renamed from: g, reason: collision with root package name */
    private MapTextureView f6196g;

    /* renamed from: g0, reason: collision with root package name */
    private OnLocationModeChangeListener f6197g0;

    /* renamed from: h, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f6198h;

    /* renamed from: h0, reason: collision with root package name */
    MapView f6199h0;

    /* renamed from: i, reason: collision with root package name */
    private BmLayer f6200i;

    /* renamed from: i0, reason: collision with root package name */
    TextureMapView f6201i0;

    /* renamed from: j, reason: collision with root package name */
    private List<Overlay> f6202j;

    /* renamed from: j0, reason: collision with root package name */
    WearMapView f6203j0;

    /* renamed from: k, reason: collision with root package name */
    private List<Marker> f6204k;

    /* renamed from: k0, reason: collision with root package name */
    r f6205k0;

    /* renamed from: l, reason: collision with root package name */
    private List<Marker> f6206l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f6207l0;

    /* renamed from: m, reason: collision with root package name */
    private List<InfoWindow> f6208m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f6209m0;

    /* renamed from: n, reason: collision with root package name */
    private Overlay.a f6210n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f6211n0;

    /* renamed from: o, reason: collision with root package name */
    private BaseUI.onBaseUIListener f6212o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f6213o0;

    /* renamed from: p, reason: collision with root package name */
    private HexagonMap.b f6214p;

    /* renamed from: p0, reason: collision with root package name */
    private Point f6215p0;

    /* renamed from: q, reason: collision with root package name */
    private InfoWindow.a f6216q;

    /* renamed from: r, reason: collision with root package name */
    private InfoWindowAdapter f6218r;

    /* renamed from: s, reason: collision with root package name */
    private OnMapStatusChangeListener f6220s;

    /* renamed from: s0, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.z.c f6221s0;

    /* renamed from: t, reason: collision with root package name */
    private OnMapTouchListener f6222t;

    /* renamed from: u, reason: collision with root package name */
    private onMapGestureListener f6224u;

    /* renamed from: v, reason: collision with root package name */
    private OnMapClickListener f6225v;

    /* renamed from: w, reason: collision with root package name */
    private OnMapLoadedCallback f6226w;

    /* renamed from: x, reason: collision with root package name */
    private OnMapTileLoadedCallback f6227x;

    /* renamed from: y, reason: collision with root package name */
    private OnMapRenderCallback f6228y;

    /* renamed from: z, reason: collision with root package name */
    private OnMapDoubleClickListener f6229z;

    /* renamed from: B, reason: collision with root package name */
    private CopyOnWriteArrayList<OnMarkerClickListener> f6163B = new CopyOnWriteArrayList<>();

    /* renamed from: C, reason: collision with root package name */
    private CopyOnWriteArrayList<OnMarkerWithBaseUIClickListener> f6164C = new CopyOnWriteArrayList<>();

    /* renamed from: D, reason: collision with root package name */
    private CopyOnWriteArrayList<OnPolylineClickListener> f6165D = new CopyOnWriteArrayList<>();

    /* renamed from: E, reason: collision with root package name */
    private CopyOnWriteArrayList<OnMultiPointClickListener> f6166E = new CopyOnWriteArrayList<>();

    /* renamed from: F, reason: collision with root package name */
    private CopyOnWriteArrayList<OnCircleClickListener> f6167F = new CopyOnWriteArrayList<>();

    /* renamed from: G, reason: collision with root package name */
    private CopyOnWriteArrayList<OnPolygonClickListener> f6168G = new CopyOnWriteArrayList<>();

    /* renamed from: H, reason: collision with root package name */
    private CopyOnWriteArrayList<OnGroundOverlayClickListener> f6169H = new CopyOnWriteArrayList<>();

    /* renamed from: I, reason: collision with root package name */
    private CopyOnWriteArrayList<OnTextClickListener> f6170I = new CopyOnWriteArrayList<>();

    /* renamed from: J, reason: collision with root package name */
    private CopyOnWriteArrayList<OnArcClickListener> f6171J = new CopyOnWriteArrayList<>();

    /* renamed from: Y, reason: collision with root package name */
    private Lock f6185Y = new ReentrantLock();

    /* renamed from: Z, reason: collision with root package name */
    private Lock f6186Z = new ReentrantLock();

    /* renamed from: a0, reason: collision with root package name */
    private Lock f6187a0 = new ReentrantLock();

    /* renamed from: q0, reason: collision with root package name */
    private volatile boolean f6217q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f6219r0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f6223t0 = false;

    public interface OnArcClickListener {
        boolean onArcClick(Arc arc);
    }

    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z4, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    public interface OnCircleClickListener {
        boolean onCircleClick(Circle circle);
    }

    public interface OnGroundOverlayClickListener {
        boolean onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnHeatMapDrawFrameCallBack {
        void frameIndex(int i4);
    }

    public interface OnLocationModeChangeListener {
        void onLocationModeChange(MyLocationConfiguration.LocationMode locationMode);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        void onMapPoiClick(MapPoi mapPoi);
    }

    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean z4, int i4, String str);
    }

    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i4);
    }

    public interface OnMapTileLoadedCallback {
        void onFirstMapTileLoaded();
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMarkerWithBaseUIClickListener {
        void onMarkerClick(Marker marker);

        void onMarkerClick(Marker marker, BaseUI baseUI);
    }

    public interface OnMultiPointClickListener {
        boolean onMultiPointClick(MultiPoint multiPoint, MultiPointItem multiPointItem);
    }

    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    public interface OnPolygonClickListener {
        boolean onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i4);
    }

    public interface OnTextClickListener {
        boolean onTextClick(Text text);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public class a implements BaseUI.onBaseUIListener {
        public a() {
        }

        @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI.onBaseUIListener
        public void onBaseUIRemove(BaseUI baseUI) {
            if (BaiduMap.this.f6200i != null) {
                BaiduMap.this.f6200i.b();
            }
        }

        @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI.onBaseUIListener
        public void onBaseUIUpdate(BaseUI baseUI) {
            if (BaiduMap.this.f6200i != null) {
                BaiduMap.this.f6200i.b();
            }
        }
    }

    public class b implements CaptureMapViewListener {
        public b() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.f6174M.onSnapshotReady(bitmap);
        }
    }

    public class c implements CaptureMapViewListener {
        public c() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.f6174M.onSnapshotReady(bitmap);
        }
    }

    public class d implements CaptureMapViewListener {
        public d() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.f6174M.onSnapshotReady(bitmap);
        }
    }

    public class e implements CaptureMapViewListener {
        public e() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.f6174M.onSnapshotReady(bitmap);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4 = g.f6237b[BaiduMap.this.f6205k0.ordinal()];
            if (i4 == 1) {
                if (BaiduMap.this.f6196g != null) {
                    BaiduMap.this.f6196g.requestRender();
                }
            } else if (i4 == 2 && BaiduMap.this.f6194f != null) {
                BaiduMap.this.f6194f.requestRender();
            }
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6236a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f6237b;

        static {
            int[] iArr = new int[r.values().length];
            f6237b = iArr;
            try {
                iArr[r.TextureView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6237b[r.GLSurfaceView.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
            f6236a = iArr2;
            try {
                iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6236a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6236a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class h implements NetworkUpdate2MapListener {
        public h() {
        }

        @Override // com.baidu.mapapi.NetworkUpdate2MapListener
        public void networkUpdate() {
            if (BaiduMap.this.f6198h == null || !BaiduMap.this.f6198h.L()) {
                return;
            }
            BaiduMap.this.f6198h.Z();
        }
    }

    public class j implements Overlay.a {
        public j() {
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public void a(Overlay overlay) {
            if (BaiduMap.this.f6217q0) {
                return;
            }
            if (overlay != null && BaiduMap.this.f6202j.contains(overlay)) {
                Bundle bundleA = overlay.a();
                if (BaiduMap.this.f6198h != null) {
                    BaiduMap.this.f6198h.i(bundleA);
                }
                BaiduMap.this.f6202j.remove(overlay);
            }
            if (overlay != null && BaiduMap.this.f6206l.contains(overlay)) {
                BaiduMap.this.f6206l.remove(overlay);
            }
            if (overlay != null && BaiduMap.this.f6176O.contains(overlay)) {
                BaiduMap.this.f6176O.remove(overlay);
            }
            if (overlay == null || !BaiduMap.this.f6204k.contains(overlay)) {
                return;
            }
            Marker marker = (Marker) overlay;
            if (marker.f6605G != null) {
                BaiduMap.this.f6204k.remove(marker);
                if (BaiduMap.this.f6204k.size() != 0 || BaiduMap.this.f6198h == null) {
                    return;
                }
                BaiduMap.this.f6198h.s(false);
            }
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public boolean b(Overlay overlay) {
            return (BaiduMap.this.f6202j == null || BaiduMap.this.f6202j.contains(overlay)) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
        @Override // com.baidu.mapapi.map.Overlay.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(com.baidu.mapapi.map.Overlay r5) {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BaiduMap.j.c(com.baidu.mapapi.map.Overlay):void");
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public LatLngBounds d(Overlay overlay) {
            if (BaiduMap.this.f6198h == null || overlay == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            overlay.a(bundle);
            return BaiduMap.this.f6198h.f(bundle);
        }
    }

    public class k implements InfoWindow.a {
        public k() {
        }

        @Override // com.baidu.mapapi.map.InfoWindow.a
        public void a(InfoWindow infoWindow) {
            BaiduMap.this.hideInfoWindow(infoWindow);
        }

        @Override // com.baidu.mapapi.map.InfoWindow.a
        public void b(InfoWindow infoWindow) throws NoSuchAlgorithmException {
            BaiduMap.this.b(infoWindow);
        }
    }

    public class l implements w {
        public l() {
        }

        @Override // com.baidu.platform.comapi.map.w
        public void a(int i4) {
            for (int i5 = 0; i5 < BaiduMap.this.f6176O.size(); i5++) {
                if (((Building) BaiduMap.this.f6176O.get(i5)).getBuildingId() == i4) {
                    BaiduMap.this.f6175N.onBuildingFloorAnimationStop((Building) BaiduMap.this.f6176O.get(i5));
                }
            }
        }
    }

    public class m implements v {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InfoWindow f6244a;

            public a(InfoWindow infoWindow) {
                this.f6244a = infoWindow;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6244a.f6478c.setLayoutParams(new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(this.f6244a.f6479d).yOffset(this.f6244a.f6485j).build());
            }
        }

        public m() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6220s != null) {
                BaiduMap.this.f6220s.onMapStatusChangeFinish(mapStatusA);
            }
            if (BaiduMap.this.f6224u != null) {
                BaiduMap.this.f6224u.onMapStatusChangeFinish(mapStatusA);
            }
            BaiduMap.mapStatusReason = 0;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(s sVar) {
            if (BaiduMap.this.f6220s != null) {
                BaiduMap.this.f6220s.onMapStatusChange(MapStatus.a(sVar));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean d(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6224u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.f6224u.onMapKneading(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void e(GeoPoint geoPoint) {
            if (BaiduMap.this.f6191d0 == null || !BaiduMap.this.f6191d0.f6630o) {
                return;
            }
            BaiduMap.this.f6191d0.setPosition(BaiduMap.this.f6190d.fromScreenLocation(new Point(BaiduMap.this.f6190d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.f6172K != null && BaiduMap.this.f6191d0.f6630o) {
                BaiduMap.this.f6172K.onMarkerDragEnd(BaiduMap.this.f6191d0);
            }
            BaiduMap.this.f6191d0 = null;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void f(GeoPoint geoPoint) {
            if (BaiduMap.this.f6191d0 == null || !BaiduMap.this.f6191d0.f6630o) {
                return;
            }
            BaiduMap.this.f6191d0.setPosition(BaiduMap.this.f6190d.fromScreenLocation(new Point(BaiduMap.this.f6190d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.f6172K != null && BaiduMap.this.f6191d0.f6630o) {
                BaiduMap.this.f6172K.onMarkerDragEnd(BaiduMap.this.f6191d0);
            }
            BaiduMap.this.f6191d0 = null;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void g(GeoPoint geoPoint) {
            if (BaiduMap.this.f6191d0 == null || !BaiduMap.this.f6191d0.f6630o) {
                return;
            }
            BaiduMap.this.f6191d0.setPosition(BaiduMap.this.f6190d.fromScreenLocation(new Point(BaiduMap.this.f6190d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.f6172K == null || !BaiduMap.this.f6191d0.f6630o) {
                return;
            }
            BaiduMap.this.f6172K.onMarkerDrag(BaiduMap.this.f6191d0);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void onFirstMapTileLoaded() {
            if (BaiduMap.this.f6227x != null) {
                BaiduMap.this.f6227x.onFirstMapTileLoaded();
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(s sVar) {
            int i4 = BaiduMap.mapStatusReason;
            int i5 = (i4 & 256) == 256 ? 3 : (i4 & 16) == 16 ? 2 : 1;
            if (BaiduMap.this.f6220s != null) {
                MapStatus mapStatusA = MapStatus.a(sVar);
                BaiduMap.this.f6220s.onMapStatusChangeStart(mapStatusA);
                BaiduMap.this.f6220s.onMapStatusChangeStart(mapStatusA, i5);
            }
            if (BaiduMap.this.T != null) {
                BaiduMap.this.T.onMapStatusChangeReason(i5);
            }
            BaiduMap.mapStatusReason = 0;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean b(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6224u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.f6224u.onMapOverLooking(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d(GeoPoint geoPoint) {
            if (BaiduMap.this.f6162A != null) {
                BaiduMap.this.f6162A.onMapLongClick(CoordUtil.mc2ll(geoPoint));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(MotionEvent motionEvent) {
            if (BaiduMap.this.f6222t != null) {
                BaiduMap.this.f6222t.onTouch(motionEvent);
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(GeoPoint geoPoint) {
            if (BaiduMap.this.f6225v != null) {
                BaiduMap.this.f6225v.onMapClick(CoordUtil.mc2ll(geoPoint));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d() {
            BaiduMap baiduMap = BaiduMap.this;
            baiduMap.f6190d = new Projection(baiduMap.f6198h);
            BaiduMap.this.f6213o0 = true;
            if (BaiduMap.this.f6226w != null) {
                BaiduMap.this.f6226w.onMapLoaded();
            }
            BaiduMap.this.e();
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6224u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.f6224u.onMapTwoClick(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean c(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6224u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.f6224u.onMapScroll(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b() {
            if (BaiduMap.this.f6228y != null) {
                BaiduMap.this.f6228y.onMapRenderFinished();
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(MotionEvent motionEvent, float f4, float f5, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6224u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.f6224u.onMapFling(motionEvent, f4, f5, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(String str) {
            JSONObject jSONObjectOptJSONObject;
            String strOptString;
            InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener;
            s sVarY;
            try {
                JSONObject jSONObject = new JSONObject(str);
                GeoPoint geoPointA = BaiduMap.this.f6198h.a(jSONObject.optInt("px"), jSONObject.optInt("py"));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset");
                int iOptInt = -1;
                if (jSONArrayOptJSONArray != null) {
                    jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                    if (jSONObjectOptJSONObject != null) {
                        iOptInt = jSONObjectOptJSONObject.optInt(MapBundleKey.MapObjKey.OBJ_TYPE);
                    }
                } else {
                    jSONObjectOptJSONObject = null;
                }
                if (iOptInt == 17) {
                    if (BaiduMap.this.f6225v != null) {
                        MapPoi mapPoi = new MapPoi();
                        mapPoi.a(jSONObjectOptJSONObject);
                        BaiduMap.this.f6225v.onMapPoiClick(mapPoi);
                        return;
                    }
                    return;
                }
                if (iOptInt == 18) {
                    if (BaiduMap.this.f6173L != null) {
                        BaiduMap.this.f6173L.onMyLocationClick();
                        return;
                    } else {
                        b(geoPointA);
                        return;
                    }
                }
                if (iOptInt == 19) {
                    if (BaiduMap.this.f6198h == null || (sVarY = BaiduMap.this.f6198h.y()) == null) {
                        return;
                    }
                    sVarY.f8101c = 0;
                    sVarY.f8100b = 0;
                    BaiduMap.mapStatusReason |= 16;
                    BaiduMap.this.f6198h.a(sVarY, UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME);
                    return;
                }
                if (iOptInt == 6002) {
                    if (BaiduMap.this.f6225v != null) {
                        MapPoi mapPoi2 = new MapPoi();
                        mapPoi2.a(jSONObjectOptJSONObject);
                        BaiduMap.this.f6225v.onMapPoiClick(mapPoi2);
                        return;
                    }
                    return;
                }
                if (iOptInt == 90909) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("marker_id") : "";
                    Set<String> setKeySet = BaiduMap.this.f6188b0.keySet();
                    if (!setKeySet.isEmpty() && setKeySet.contains(strOptString)) {
                        for (String str2 : setKeySet) {
                            if (str2 != null && str2.equals(strOptString)) {
                                InfoWindow infoWindow = (InfoWindow) BaiduMap.this.f6188b0.get(str2);
                                if (infoWindow != null && (onInfoWindowClickListener = infoWindow.f6483h) != null) {
                                    onInfoWindowClickListener.onInfoWindowClick();
                                    return;
                                } else {
                                    b(geoPointA);
                                    return;
                                }
                            }
                        }
                        return;
                    }
                    for (Overlay overlay : BaiduMap.this.f6202j) {
                        if ((overlay instanceof Marker) && overlay.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6163B.isEmpty()) {
                                Iterator it = BaiduMap.this.f6163B.iterator();
                                while (it.hasNext()) {
                                    ((OnMarkerClickListener) it.next()).onMarkerClick((Marker) overlay);
                                }
                                return;
                            }
                            b(geoPointA);
                        }
                    }
                    return;
                }
                if (iOptInt == 90910) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("polyline_id") : "";
                    for (Overlay overlay2 : BaiduMap.this.f6202j) {
                        if ((overlay2 instanceof Polyline) && overlay2.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6165D.isEmpty()) {
                                Iterator it2 = BaiduMap.this.f6165D.iterator();
                                while (it2.hasNext()) {
                                    ((OnPolylineClickListener) it2.next()).onPolylineClick((Polyline) overlay2);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90911) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("multipoint_id") : "";
                    for (Overlay overlay3 : BaiduMap.this.f6202j) {
                        if ((overlay3 instanceof MultiPoint) && overlay3.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6166E.isEmpty()) {
                                Iterator it3 = BaiduMap.this.f6166E.iterator();
                                while (it3.hasNext()) {
                                    OnMultiPointClickListener onMultiPointClickListener = (OnMultiPointClickListener) it3.next();
                                    MultiPoint multiPoint = (MultiPoint) overlay3;
                                    List<MultiPointItem> multiPointItems = multiPoint.getMultiPointItems();
                                    if (jSONObjectOptJSONObject != null) {
                                        int iOptInt2 = jSONObjectOptJSONObject.optInt("multipoint_index");
                                        if (multiPointItems != null && iOptInt2 >= 0 && multiPointItems.size() > iOptInt2) {
                                            onMultiPointClickListener.onMultiPointClick(multiPoint, multiPointItems.get(iOptInt2));
                                        }
                                    }
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90912) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay4 : BaiduMap.this.f6202j) {
                        if ((overlay4 instanceof Polygon) && overlay4.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6168G.isEmpty()) {
                                Iterator it4 = BaiduMap.this.f6168G.iterator();
                                while (it4.hasNext()) {
                                    OnPolygonClickListener onPolygonClickListener = (OnPolygonClickListener) it4.next();
                                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("hole_clicked_index")) {
                                        ((Polygon) overlay4).f6753w = jSONObjectOptJSONObject.optInt("hole_clicked_index");
                                    }
                                    onPolygonClickListener.onPolygonClick((Polygon) overlay4);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90914) {
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString("overlay_id");
                        for (Overlay overlay5 : BaiduMap.this.f6202j) {
                            if ((overlay5 instanceof Circle) && overlay5.f6718a.equals(strOptString2)) {
                                if (!BaiduMap.this.f6167F.isEmpty()) {
                                    Iterator it5 = BaiduMap.this.f6167F.iterator();
                                    while (it5.hasNext()) {
                                        OnCircleClickListener onCircleClickListener = (OnCircleClickListener) it5.next();
                                        if (jSONObjectOptJSONObject.has("hole_clicked_index")) {
                                            ((Circle) overlay5).f6302q = jSONObjectOptJSONObject.optInt("hole_clicked_index");
                                        }
                                        onCircleClickListener.onCircleClick((Circle) overlay5);
                                    }
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (iOptInt == 90915) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay6 : BaiduMap.this.f6202j) {
                        if ((overlay6 instanceof GroundOverlay) && overlay6.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6169H.isEmpty()) {
                                Iterator it6 = BaiduMap.this.f6169H.iterator();
                                while (it6.hasNext()) {
                                    ((OnGroundOverlayClickListener) it6.next()).onGroundOverlayClick((GroundOverlay) overlay6);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90916) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay7 : BaiduMap.this.f6202j) {
                        if ((overlay7 instanceof Text) && overlay7.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6170I.isEmpty()) {
                                Iterator it7 = BaiduMap.this.f6170I.iterator();
                                while (it7.hasNext()) {
                                    ((OnTextClickListener) it7.next()).onTextClick((Text) overlay7);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90917) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay8 : BaiduMap.this.f6202j) {
                        if ((overlay8 instanceof Arc) && overlay8.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6171J.isEmpty()) {
                                Iterator it8 = BaiduMap.this.f6171J.iterator();
                                while (it8.hasNext()) {
                                    ((OnArcClickListener) it8.next()).onArcClick((Arc) overlay8);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90918) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay9 : BaiduMap.this.f6202j) {
                        if ((overlay9 instanceof Polyline) && overlay9.f6718a.equals(strOptString)) {
                            if (!BaiduMap.this.f6165D.isEmpty()) {
                                Iterator it9 = BaiduMap.this.f6165D.iterator();
                                while (it9.hasNext()) {
                                    ((OnPolylineClickListener) it9.next()).onPolylineClick((Polyline) overlay9);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(GeoPoint geoPoint) {
            if (BaiduMap.this.f6191d0 == null || !BaiduMap.this.f6191d0.f6630o) {
                return;
            }
            BaiduMap.this.f6191d0.setPosition(BaiduMap.this.f6190d.fromScreenLocation(new Point(BaiduMap.this.f6190d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.f6172K == null || !BaiduMap.this.f6191d0.f6630o) {
                return;
            }
            BaiduMap.this.f6172K.onMarkerDrag(BaiduMap.this.f6191d0);
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.f6224u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.f6224u.onMapDoubleTouch(point, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GeoPoint geoPoint) {
            if (BaiduMap.this.f6229z != null) {
                LatLng latLngMc2ll = CoordUtil.mc2ll(geoPoint);
                BaiduMap.mapStatusReason |= 1;
                BaiduMap.this.f6229z.onMapDoubleClick(latLngMc2ll);
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(BmDrawItem bmDrawItem) {
            if (bmDrawItem == null) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            Iterator it = BaiduMap.this.f6202j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Overlay overlay = (Overlay) it.next();
                if ((overlay instanceof Marker) && overlay.getName().equals(bmDrawItem.getName())) {
                    Marker marker = (Marker) overlay;
                    if (marker.f6630o) {
                        BaiduMap.this.f6191d0 = marker;
                        BaiduMap.this.f6191d0.setAnimateType(0);
                        BaiduMap.this.f6191d0.setPosition(BaiduMap.this.f6190d.fromScreenLocation(new Point(BaiduMap.this.f6190d.toScreenLocation(BaiduMap.this.f6191d0.f6622g).x, r7.y - 60)));
                        if (BaiduMap.this.f6172K != null) {
                            BaiduMap.this.f6172K.onMarkerDragStart(BaiduMap.this.f6191d0);
                        }
                        bool = Boolean.TRUE;
                    }
                }
            }
            return bool.booleanValue();
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(String str) {
            JSONObject jSONObjectOptJSONObject;
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("dataset");
                if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || jSONObjectOptJSONObject.optInt(MapBundleKey.MapObjKey.OBJ_TYPE) != 90909) {
                    return false;
                }
                String strOptString = jSONObjectOptJSONObject.optString("marker_id");
                Set setKeySet = BaiduMap.this.f6188b0.keySet();
                if (!setKeySet.isEmpty() && setKeySet.contains(strOptString)) {
                    return false;
                }
                for (Overlay overlay : BaiduMap.this.f6202j) {
                    if ((overlay instanceof Marker) && overlay.f6718a.equals(strOptString)) {
                        Marker marker = (Marker) overlay;
                        if (!marker.f6630o) {
                            return false;
                        }
                        BaiduMap.this.f6191d0 = marker;
                        BaiduMap.this.f6191d0.setPosition(BaiduMap.this.f6190d.fromScreenLocation(new Point(BaiduMap.this.f6190d.toScreenLocation(BaiduMap.this.f6191d0.f6622g).x, r5.y - 60)));
                        if (BaiduMap.this.f6172K != null) {
                            BaiduMap.this.f6172K.onMarkerDragStart(BaiduMap.this.f6191d0);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GL10 gl10, s sVar) {
            View view;
            if (BaiduMap.this.f6188b0 != null && !BaiduMap.this.f6188b0.values().isEmpty()) {
                for (InfoWindow infoWindow : BaiduMap.this.f6188b0.values()) {
                    if (infoWindow != null && (view = infoWindow.f6478c) != null) {
                        view.post(new a(infoWindow));
                    }
                }
            }
            if (BaiduMap.this.f6177P != null) {
                BaiduMap.this.f6177P.onMapDrawFrame(MapStatus.a(sVar));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z4) {
            if (BaiduMap.this.f6178Q != null) {
                if (z4) {
                    BaiduMap.this.f6178Q.onBaseIndoorMapMode(z4, BaiduMap.this.getFocusedBaseIndoorMapInfo());
                    BaiduMap.this.f6223t0 = true;
                } else if (BaiduMap.this.f6223t0) {
                    BaiduMap.this.f6178Q.onBaseIndoorMapMode(z4, null);
                    BaiduMap.this.f6223t0 = false;
                }
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a() {
            if (BaiduMap.this.f6198h != null) {
                BaiduMap.this.f6198h.s(false);
            }
            BaiduMap.this.f6185Y.lock();
            try {
                if (BaiduMap.this.f6183W != null) {
                    BaiduMap baiduMap = BaiduMap.this;
                    baiduMap.a(baiduMap.f6183W);
                }
            } finally {
                BaiduMap.this.f6185Y.unlock();
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z4, int i4) {
            if (BaiduMap.this.f6179R != null) {
                BaiduMap.this.f6179R.onMapRenderValidData(z4, i4, BaiduMap.this.a(i4));
            }
        }
    }

    public class n implements com.baidu.mapsdkplatform.comapi.map.h {
        public n() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.h
        public Bundle a(int i4, int i5) {
            BaiduMap.this.f6185Y.lock();
            try {
                if (BaiduMap.this.f6183W == null) {
                    BaiduMap.this.f6185Y.unlock();
                    return null;
                }
                if (BaiduMap.this.f6180S != null) {
                    BaiduMap.this.f6180S.frameIndex(i4);
                }
                HeatMapData data = BaiduMap.this.f6183W.getData(i4, i5);
                if (data == null) {
                    BaiduMap.this.f6185Y.unlock();
                    return null;
                }
                Bundle bundle = data.toBundle();
                BaiduMap.this.f6185Y.unlock();
                return bundle;
            } catch (Throwable th) {
                BaiduMap.this.f6185Y.unlock();
                throw th;
            }
        }
    }

    public class o implements com.baidu.mapsdkplatform.comapi.map.w {
        public o() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.w
        public Bundle a(int i4, int i5, int i6, Context context) {
            BaiduMap.this.f6187a0.lock();
            try {
                if (BaiduMap.this.f6182V != null) {
                    Tile tileA = BaiduMap.this.f6182V.a(i4, i5, i6);
                    StringBuilder sb = new StringBuilder("mapLayerDataReq tile t == null = ");
                    sb.append(tileA == null);
                    Log.e("SDKTileLayer", sb.toString());
                    if (tileA != null) {
                        return tileA.toBundle();
                    }
                }
                BaiduMap.this.f6187a0.unlock();
                return null;
            } finally {
                BaiduMap.this.f6187a0.unlock();
            }
        }
    }

    public interface onMapGestureListener {
        boolean onMapDoubleTouch(Point point, MapStatus mapStatus);

        boolean onMapFling(MotionEvent motionEvent, float f4, float f5, MapStatus mapStatus);

        boolean onMapKneading(Point point, Point point2, MapStatus mapStatus);

        boolean onMapOverLooking(Point point, Point point2, MapStatus mapStatus);

        boolean onMapScroll(Point point, Point point2, MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        boolean onMapTwoClick(Point point, Point point2, MapStatus mapStatus);
    }

    public BaiduMap(Context context, MapTextureView mapTextureView, q qVar) {
        this.f6196g = mapTextureView;
        com.baidu.mapsdkplatform.comapi.map.b bVar = new com.baidu.mapsdkplatform.comapi.map.b(context, mapTextureView, qVar, (String) null, 0);
        this.f6198h = bVar;
        mapTextureView.setBaseMap(bVar);
        this.f6205k0 = r.TextureView;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i4) {
        if (i4 == 0) {
            return "数据请求成功";
        }
        switch (i4) {
            case 1004:
                return "网络连接错误";
            case WebSocketProtocol.CLOSE_NO_STATUS_CODE /* 1005 */:
                return "请求发送错误";
            case 1006:
                return "响应数据读取失败";
            case 1007:
                return "返回响应数据过大，数据溢出";
            case 1008:
                return "当前网络类型有问题";
            case 1009:
                return "数据不一致";
            case 1010:
                return "请求取消";
            case 1011:
                return "网络超时错误";
            case 1012:
                return "网络连接超时";
            case 1013:
                return "网络发送超时";
            case 1014:
                return "网络接收超时";
            case 1015:
                return "DNS解析错误";
            case 1016:
                return "DNS解析超时";
            case 1017:
                return "网络写错误";
            case 1018:
                return "SSL握手错误";
            case 1019:
                return "SSL握手超时";
            default:
                return "";
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap == null || this.f6198h == null) {
            return;
        }
        this.f6185Y.lock();
        try {
            HeatMap heatMap2 = this.f6183W;
            if (heatMap == heatMap2) {
                this.f6185Y.unlock();
                return;
            }
            if (heatMap2 != null) {
                heatMap2.a();
                this.f6183W.c();
                this.f6183W.f6399C = null;
                this.f6198h.e();
            }
            this.f6183W = heatMap;
            heatMap.f6399C = this;
            Bundle bundle = heatMap.toBundle();
            this.f6198h.n(true);
            this.f6198h.g(bundle);
            HashMap map = new HashMap();
            HeatMap heatMap3 = this.f6183W;
            if (heatMap3 != null) {
                map.put("H", Integer.valueOf(heatMap3.getMaxHigh()));
                map.put("I", Integer.valueOf(this.f6183W.isInitAnimation() ? 1 : 0));
                map.put("F", Integer.valueOf(this.f6183W.isFrameAnimation() ? 1 : 0));
            }
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "H", "0", map);
            this.f6185Y.unlock();
        } catch (Throwable th) {
            this.f6185Y.unlock();
            throw th;
        }
    }

    public void addHexagonMap(HexagonMap hexagonMap) {
        if (hexagonMap == null || this.f6198h == null) {
            return;
        }
        this.f6186Z.lock();
        if (this.f6184X != null) {
            this.f6198h.f();
        }
        this.f6184X = hexagonMap;
        hexagonMap.hexagonMapLayerListener = this.f6214p;
        Bundle bundle = hexagonMap.toBundle();
        this.f6198h.o(true);
        this.f6198h.b(bundle);
        this.f6186Z.unlock();
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions != null && !this.f6217q0) {
            if (OverlayUtil.isOverlayUpgrade()) {
                c();
            }
            Overlay overlay = overlayOptions.getOverlay();
            if (overlay != null) {
                overlay.listener = this.f6210n;
                if (OverlayUtil.isOverlayUpgrade() && !(overlay instanceof Dot)) {
                    a(overlay);
                    if (overlay instanceof Marker) {
                        Marker marker = (Marker) overlay;
                        marker.f6615Q = this.f6216q;
                        InfoWindowAdapter infoWindowAdapter = this.f6218r;
                        if (infoWindowAdapter != null) {
                            marker.f6621X = infoWindowAdapter;
                        }
                        ArrayList<BitmapDescriptor> arrayList = marker.f6605G;
                        if (arrayList != null && arrayList.size() != 0) {
                            this.f6204k.add(marker);
                            com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
                            if (bVar != null) {
                                bVar.s(true);
                            }
                        }
                        this.f6206l.add(marker);
                        InfoWindow infoWindow = marker.f6614P;
                        if (infoWindow != null) {
                            showInfoWindow(infoWindow, false);
                        }
                    }
                    if (overlay instanceof Building) {
                        this.f6176O.add((Building) overlay);
                    }
                    return overlay;
                }
                if (overlay instanceof Marker) {
                    Marker marker2 = (Marker) overlay;
                    marker2.f6615Q = this.f6216q;
                    ArrayList<BitmapDescriptor> arrayList2 = marker2.f6605G;
                    if (arrayList2 != null && arrayList2.size() != 0) {
                        this.f6204k.add(marker2);
                        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.f6198h;
                        if (bVar2 != null) {
                            bVar2.s(true);
                        }
                    }
                    this.f6206l.add(marker2);
                    InfoWindow infoWindow2 = marker2.f6614P;
                    if (infoWindow2 != null) {
                        showInfoWindow(infoWindow2, false);
                    }
                } else if (overlay instanceof Building) {
                    this.f6176O.add((Building) overlay);
                }
                Bundle bundle = new Bundle();
                overlay.a(bundle);
                if (this.f6198h != null && !this.f6217q0) {
                    this.f6198h.d(bundle);
                }
                this.f6202j.add(overlay);
                return overlay;
            }
        }
        return null;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        if (list == null || this.f6217q0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
            for (int i4 = 0; i4 < size; i4++) {
                OverlayOptions overlayOptions = list.get(i4);
                if (overlayOptions != null) {
                    Overlay overlay = overlayOptions.getOverlay();
                    overlay.listener = this.f6210n;
                    if (!(overlay instanceof Dot)) {
                        if (overlay instanceof Marker) {
                            Marker marker = (Marker) overlay;
                            marker.f6615Q = this.f6216q;
                            InfoWindowAdapter infoWindowAdapter = this.f6218r;
                            if (infoWindowAdapter != null) {
                                marker.f6621X = infoWindowAdapter;
                            }
                            ArrayList<BitmapDescriptor> arrayList2 = marker.f6605G;
                            if (arrayList2 != null && arrayList2.size() != 0) {
                                this.f6204k.add(marker);
                                com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
                                if (bVar != null) {
                                    bVar.s(true);
                                }
                            }
                            this.f6206l.add(marker);
                            InfoWindow infoWindow = marker.f6614P;
                            if (infoWindow != null) {
                                showInfoWindow(infoWindow, false);
                            }
                        }
                        if (overlay instanceof Building) {
                            this.f6176O.add((Building) overlay);
                        }
                        this.f6202j.add(overlay);
                        arrayList.add(overlay);
                        overlay.setBmLayer(this.f6200i);
                        BmDrawItem drawItem = overlay.toDrawItem();
                        this.f6200i.a(drawItem, drawItem.b());
                    }
                }
            }
            this.f6200i.b();
        } else {
            Bundle[] bundleArr = new Bundle[size];
            for (int i5 = 0; i5 < size; i5++) {
                OverlayOptions overlayOptions2 = list.get(i5);
                if (overlayOptions2 != null) {
                    Overlay overlay2 = overlayOptions2.getOverlay();
                    overlay2.listener = this.f6210n;
                    if (overlay2 instanceof Marker) {
                        Marker marker2 = (Marker) overlay2;
                        marker2.f6615Q = this.f6216q;
                        InfoWindowAdapter infoWindowAdapter2 = this.f6218r;
                        if (infoWindowAdapter2 != null) {
                            marker2.f6621X = infoWindowAdapter2;
                        }
                        ArrayList<BitmapDescriptor> arrayList3 = marker2.f6605G;
                        if (arrayList3 != null && arrayList3.size() != 0) {
                            this.f6204k.add(marker2);
                            com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.f6198h;
                            if (bVar2 != null) {
                                bVar2.s(true);
                            }
                        }
                        this.f6206l.add(marker2);
                        InfoWindow infoWindow2 = marker2.f6614P;
                        if (infoWindow2 != null) {
                            showInfoWindow(infoWindow2, false);
                        }
                    }
                    if (overlay2 instanceof Building) {
                        this.f6176O.add((Building) overlay2);
                    }
                    this.f6202j.add(overlay2);
                    arrayList.add(overlay2);
                    Bundle bundle = new Bundle();
                    com.baidu.mapsdkplatform.comapi.map.b bVar3 = this.f6198h;
                    if (bVar3 != null) {
                        bVar3.c(bundle);
                        this.f6198h.a(bundle);
                    }
                    overlay2.a(bundle);
                    bundleArr[i5] = bundle;
                }
            }
            com.baidu.mapsdkplatform.comapi.map.b bVar4 = this.f6198h;
            if (bVar4 != null) {
                bVar4.a(bundleArr);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        TileOverlay tileOverlay = this.f6182V;
        if (tileOverlay != null) {
            tileOverlay.c();
            this.f6182V.f7021c = null;
        }
        HashMap map = new HashMap();
        map.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(tileOverlayOptions.datasource));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", ExifInterface.GPS_DIRECTION_TRUE, "0", map);
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null || !bVar.e(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay tileOverlayA = tileOverlayOptions.a(this);
        this.f6182V = tileOverlayA;
        return tileOverlayA;
    }

    public final TraceOverlay addTraceOverlay(TraceOptions traceOptions, TraceAnimationListener traceAnimationListener) {
        if (traceOptions == null) {
            return null;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "TO", "0", null);
        com.baidu.mapsdkplatform.comapi.map.z.c cVar = this.f6221s0;
        if (cVar == null || cVar.d()) {
            r rVar = this.f6205k0;
            if (rVar == r.GLSurfaceView) {
                this.f6221s0 = new com.baidu.mapsdkplatform.comapi.map.z.c(this.f6194f);
            } else {
                if (rVar != r.TextureView) {
                    return null;
                }
                this.f6221s0 = new com.baidu.mapsdkplatform.comapi.map.z.c(this.f6196g);
            }
            this.f6221s0.c();
            this.f6198h.a(this.f6221s0.b());
        }
        this.f6221s0.a(traceAnimationListener);
        return this.f6221s0.a(traceOptions);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i4) {
        if (mapStatusUpdate == null || i4 < 0) {
            return;
        }
        s sVarA = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        mapStatusReason |= 256;
        if (this.f6213o0) {
            bVar.a(sVarA, i4);
        } else {
            bVar.a(sVarA);
        }
    }

    public void changeLocationLayerOrder(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.a(z4);
    }

    public void cleanCache(int i4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.a(i4);
    }

    public final void clear() {
        if (this.f6217q0) {
            return;
        }
        BmLayer bmLayer = this.f6200i;
        if (bmLayer != null) {
            bmLayer.a();
            this.f6200i.b();
            Iterator<Overlay> it = this.f6202j.iterator();
            while (it.hasNext()) {
                BmDrawItem bmDrawItem = it.next().mDrawItem;
                if ((bmDrawItem instanceof BmIconMarker) && ((BmIconMarker) bmDrawItem).d() != null) {
                    try {
                        ((BmIconMarker) bmDrawItem).d().close();
                    } catch (Exception unused) {
                        Log.e("BmBitmapResource", "BmBitmapResource close failied");
                    }
                }
                try {
                    bmDrawItem.close();
                } catch (Exception unused2) {
                    Log.e("DrawItem", "DrawItem close failied");
                }
            }
        }
        this.f6202j.clear();
        this.f6204k.clear();
        this.f6206l.clear();
        this.f6176O.clear();
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.s(false);
            this.f6198h.d();
        }
        hideInfoWindow();
    }

    public void closeParticleEffectByType(ParticleEffectType particleEffectType) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.a(particleEffectType);
        }
    }

    public boolean customParticleEffectByType(ParticleEffectType particleEffectType, ParticleOptions particleOptions) throws NoSuchAlgorithmException {
        if (this.f6198h == null) {
            return false;
        }
        if (particleEffectType == ParticleEffectType.Fireworks || particleEffectType == ParticleEffectType.Flower) {
            a(particleEffectType);
        }
        Bundle bundle = new Bundle();
        if (particleOptions != null) {
            if (particleOptions.getParticleImgs() != null) {
                int size = particleOptions.getParticleImgs().size();
                bundle.putInt("total", size);
                for (int i4 = 0; i4 < size; i4++) {
                    if (particleOptions.getParticleImgs().get(i4) != null) {
                        bundle.putBundle(String.format("texture_%d", Integer.valueOf(i4)), particleOptions.getParticleImgs().get(i4).a());
                    }
                }
            }
            if (particleOptions.getParticlePos() != null) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(particleOptions.getParticlePos());
                bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
                bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
            }
        }
        return this.f6198h.a(particleEffectType, bundle);
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.f6208m;
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            return a(bVar.l());
        }
        return null;
    }

    public boolean getCustomTrafficColorEnable() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.m();
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return null;
        }
        return bVar.o();
    }

    public final int getFontSizeLevel() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            return bVar.p();
        }
        return 1;
    }

    public MapSurfaceView getGLMapView() {
        return this.f6194f;
    }

    public OnHeatMapDrawFrameCallBack getHeatMapDrawFrameCallBack() {
        return this.f6180S;
    }

    public boolean getIsSDKLayerBelowBmLayer() {
        return this.f6219r0;
    }

    @Deprecated
    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.f6195f0;
    }

    public final MyLocationData getLocationData() {
        return this.f6193e0;
    }

    public final String getMapApprovalNumber() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        return bVar == null ? "" : bVar.t();
    }

    public final String getMapCopyrightInfo() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        return bVar == null ? "" : bVar.u();
    }

    public MapLanguage getMapLanguage() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return MapLanguage.CHINESE;
        }
        return MapLanguage.values()[bVar.w()];
    }

    public final String getMapMappingQualificationInfo() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        return bVar == null ? "" : bVar.x();
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return null;
        }
        return MapStatus.a(bVar.y());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return null;
        }
        return bVar.z();
    }

    public MapTextureView getMapTextureView() {
        return this.f6196g;
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return 1;
        }
        if (bVar.L()) {
            return this.f6198h.P() ? 2 : 1;
        }
        return 3;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f6206l.size() == 0) {
            return null;
        }
        for (Marker marker : this.f6206l) {
            if (latLngBounds.contains(marker.getPosition())) {
                arrayList.add(marker);
            }
        }
        return arrayList;
    }

    public final float getMaxZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        return bVar == null ? Property.DEFAULT_FLOAT_VALUE : bVar.A();
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        return bVar == null ? Property.DEFAULT_FLOAT_VALUE : bVar.f8003e;
    }

    public LatLngBounds getOverlayLatLngBounds(OverlayOptions overlayOptions) {
        if (overlayOptions == null || this.f6198h == null) {
            return null;
        }
        Overlay overlay = overlayOptions.getOverlay();
        Bundle bundle = new Bundle();
        overlay.a(bundle);
        return this.f6198h.f(bundle);
    }

    public boolean getPoiTagEnable(PoiTagType poiTagType) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            return bVar.a(poiTagType);
        }
        return false;
    }

    public final Projection getProjection() {
        return this.f6190d;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return null;
        }
        return bVar.B();
    }

    public final UiSettings getUiSettings() {
        return this.f6192e;
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return null;
        }
        return bVar.C();
    }

    public float getZoomToBound(int i4, int i5, int i6, int i7, int i8, int i9) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        return bVar == null ? Property.DEFAULT_FLOAT_VALUE : bVar.a(i4, i5, i6, i7, i8, i9);
    }

    @Deprecated
    public MapSurfaceView getmGLMapView() {
        return this.f6194f;
    }

    public void hideInfoWindow() {
        View view;
        MapView mapView;
        Collection<InfoWindow> collectionValues = this.f6188b0.values();
        if (!collectionValues.isEmpty()) {
            for (InfoWindow infoWindow : collectionValues) {
                if (infoWindow != null && (view = infoWindow.f6478c) != null) {
                    int i4 = g.f6237b[this.f6205k0.ordinal()];
                    if (i4 == 1) {
                        TextureMapView textureMapView = this.f6201i0;
                        if (textureMapView != null) {
                            textureMapView.removeView(view);
                        }
                    } else if (i4 == 2 && (mapView = this.f6199h0) != null) {
                        mapView.removeView(view);
                    }
                }
            }
        }
        for (Overlay overlay : this.f6202j) {
            Set<String> setKeySet = this.f6188b0.keySet();
            String str = overlay.f6718a;
            if ((overlay instanceof Marker) && !setKeySet.isEmpty() && setKeySet.contains(str)) {
                overlay.remove();
            }
        }
        this.f6188b0.clear();
        this.f6189c0.clear();
        this.f6208m.clear();
    }

    public void hideSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.F();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.J();
    }

    public boolean isBaseIndoorMapMode() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.K();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.M();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.s();
    }

    public final boolean isShowMapPoi() {
        return this.f6207l0;
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.j();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.R();
    }

    public final void mapRefresh() {
        MapTaskManager.postToMainThread(new f(), 300L);
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.f6163B.contains(onMarkerClickListener)) {
            this.f6163B.remove(onMarkerClickListener);
        }
    }

    public final void removeMarkerWithBaseUIClickListener(OnMarkerWithBaseUIClickListener onMarkerWithBaseUIClickListener) {
        if (this.f6164C.contains(onMarkerWithBaseUIClickListener)) {
            this.f6164C.remove(onMarkerWithBaseUIClickListener);
        }
    }

    public void removeOverLays(List<Overlay> list) {
        int i4;
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        if (list == null || this.f6217q0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i5 = size / UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE;
        for (int i6 = 0; i6 < i5 + 1; i6++) {
            for (int i7 = 0; i7 < 400 && (i4 = (i6 * UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE) + i7) < size; i7++) {
                if (this.f6217q0) {
                    return;
                }
                Overlay overlay = list.get(i4);
                if (overlay != null) {
                    if (OverlayUtil.isOverlayUpgrade()) {
                        b(overlay);
                    } else {
                        Bundle bundleA = overlay.a();
                        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.f6198h;
                        if (bVar2 != null) {
                            bVar2.c(bundleA);
                        }
                        arrayList.add(bundleA);
                    }
                    List<Marker> list2 = this.f6206l;
                    if (list2 != null && list2.contains(overlay)) {
                        this.f6206l.remove(overlay);
                    }
                    CopyOnWriteArrayList<Building> copyOnWriteArrayList = this.f6176O;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(overlay)) {
                        this.f6176O.remove(overlay);
                    }
                    if (this.f6204k.contains(overlay)) {
                        Marker marker = (Marker) overlay;
                        if (marker.f6605G != null) {
                            this.f6204k.remove(marker);
                            if (this.f6204k.size() == 0 && (bVar = this.f6198h) != null) {
                                bVar.s(false);
                            }
                        }
                    }
                }
            }
            if (this.f6198h != null && !arrayList.isEmpty()) {
                int size2 = arrayList.size();
                Bundle[] bundleArr = new Bundle[size2];
                for (int i8 = 0; i8 < size2; i8++) {
                    bundleArr[i8] = (Bundle) arrayList.get(i8);
                }
                this.f6198h.b(bundleArr);
            }
        }
        this.f6202j.removeAll(list);
    }

    public final void setBaiduHeatMapEnabled(boolean z4) {
        if (this.f6198h != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "H", "0", null);
            this.f6198h.d(z4);
        }
    }

    public final void setBuildingsEnabled(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.b(z4);
        }
    }

    public void setCompassEnable(boolean z4) throws JSONException {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.c(z4);
    }

    public void setCompassIcon(Bitmap bitmap) throws JSONException {
        if (bitmap == null) {
            throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.f6198h == null) {
            return;
        }
        if (this.f6198h.a(new Point(point.x, point.y))) {
            this.f6215p0 = point;
        }
    }

    @Deprecated
    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (this.f6198h == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4)) {
                return true;
            }
            this.f6198h.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
            return true;
        }
        if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
            this.f6198h.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
            return true;
        }
        Log.e(f6159a, "the string of the input customTrafficColor is error");
        return false;
    }

    public void setCustomTrafficColorEnable(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.g(z4);
    }

    public void setDEMEnable(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.h(z4);
        }
    }

    public final void setFontSizeLevel(int i4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.c(i4);
        }
    }

    public void setHeatMapFrameAnimationIndex(int i4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.d(i4);
    }

    public final void setIndoorEnable(boolean z4) {
        if (this.f6198h != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3", null);
            this.f6211n0 = z4;
            this.f6198h.D(z4);
        }
        OnBaseIndoorMapListener onBaseIndoorMapListener = this.f6178Q;
        if (onBaseIndoorMapListener == null || z4) {
            return;
        }
        onBaseIndoorMapListener.onBaseIndoorMapMode(false, null);
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.f6218r = infoWindowAdapter;
    }

    public void setLayerClickable(MapLayer mapLayer, boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.a(mapLayer, z4);
    }

    public void setMapBackgroundColor(int i4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.b(i4);
    }

    public void setMapBackgroundImage(BitmapDescriptor bitmapDescriptor) throws NoSuchAlgorithmException {
        if (this.f6198h == null) {
            return;
        }
        if (bitmapDescriptor == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("reset", 1);
            this.f6198h.j(bundle);
        } else {
            if (bitmapDescriptor.getBitmap().getByteCount() > 10240000) {
                return;
            }
            Bundle bundleA = bitmapDescriptor.a();
            bundleA.putInt("reset", 0);
            this.f6198h.j(bundleA);
        }
    }

    public final void setMapLanguage(MapLanguage mapLanguage) {
        setMapLanguage(mapLanguage, com.baidu.platform.comapi.c.b.c().b() != mapLanguage);
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        s sVarA = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        mapStatusReason |= 256;
        bVar.a(sVarA);
        OnMapStatusChangeListener onMapStatusChangeListener = this.f6220s;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i4) {
        if (this.f6198h == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(i4));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "4", map);
        if (i4 == 1) {
            this.f6198h.x(false);
            this.f6198h.H(this.f6207l0);
            this.f6198h.E(this.f6209m0);
            this.f6198h.e(true);
            this.f6198h.D(this.f6211n0);
        } else if (i4 == 2) {
            this.f6198h.x(true);
            this.f6198h.H(this.f6207l0);
            this.f6198h.E(this.f6209m0);
            this.f6198h.e(true);
        } else if (i4 == 3) {
            if (this.f6198h.U()) {
                this.f6198h.H(false);
            }
            if (this.f6198h.G()) {
                this.f6198h.E(false);
            }
            this.f6198h.e(false);
            this.f6198h.D(false);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap setMapType type = " + i4);
        }
    }

    public final void setMaxAndMinZoomLevel(float f4, float f5) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        if (f4 <= 22.0f && f5 >= 4.0f && f4 >= f5 && (bVar = this.f6198h) != null) {
            bVar.a(f4, f5);
        }
    }

    @Deprecated
    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) throws JSONException {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) throws JSONException {
        OnLocationModeChangeListener onLocationModeChangeListener;
        this.f6195f0 = myLocationConfiguration;
        a(this.f6193e0, myLocationConfiguration);
        a(this.f6195f0);
        if (myLocationConfiguration == null || !isMyLocationEnabled() || (onLocationModeChangeListener = this.f6197g0) == null) {
            return;
        }
        onLocationModeChangeListener.onLocationModeChange(myLocationConfiguration.locationMode);
    }

    public final void setMyLocationData(MyLocationData myLocationData) throws JSONException {
        this.f6193e0 = myLocationData;
        if (this.f6195f0 == null) {
            this.f6195f0 = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.f6195f0);
    }

    public final void setMyLocationEnabled(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.q(z4);
        }
    }

    public final void setOn3DBuildingListener(Building3DListener building3DListener) {
        this.f6175N = building3DListener;
    }

    public final void setOnArcClickListener(OnArcClickListener onArcClickListener) {
        if (onArcClickListener != null) {
            this.f6171J.add(onArcClickListener);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.2", null);
        this.f6178Q = onBaseIndoorMapListener;
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener != null) {
            this.f6167F.add(onCircleClickListener);
        }
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener != null) {
            this.f6169H.add(onGroundOverlayClickListener);
        }
    }

    public void setOnHeatMapDrawFrameCallBack(OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack) {
        this.f6180S = onHeatMapDrawFrameCallBack;
    }

    public final void setOnLocationModeChangeListener(OnLocationModeChangeListener onLocationModeChangeListener) {
        this.f6197g0 = onLocationModeChangeListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.f6225v = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.f6229z = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.f6177P = onMapDrawFrameCallback;
    }

    public final void setOnMapGestureListener(onMapGestureListener onmapgesturelistener) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "GD", "0", null);
        this.f6224u = onmapgesturelistener;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.f6226w = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.f6162A = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.f6228y = onMapRenderCallback;
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener onMapRenderValidDataListener) {
        this.f6179R = onMapRenderValidDataListener;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.f6220s = onMapStatusChangeListener;
    }

    public void setOnMapTileLoadedCallback(OnMapTileLoadedCallback onMapTileLoadedCallback) {
        this.f6227x = onMapTileLoadedCallback;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.f6222t = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null || this.f6163B.contains(onMarkerClickListener)) {
            return;
        }
        this.f6163B.add(onMarkerClickListener);
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.f6172K = onMarkerDragListener;
    }

    public final void setOnMarkerWithBaseUIClickListener(OnMarkerWithBaseUIClickListener onMarkerWithBaseUIClickListener) {
        if (onMarkerWithBaseUIClickListener == null || this.f6164C.contains(onMarkerWithBaseUIClickListener)) {
            return;
        }
        this.f6164C.add(onMarkerWithBaseUIClickListener);
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        if (onMultiPointClickListener != null) {
            this.f6166E.add(onMultiPointClickListener);
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.f6173L = onMyLocationClickListener;
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener != null) {
            this.f6168G.add(onPolygonClickListener);
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.f6165D.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.T = onSynchronizationListener;
    }

    public final void setOnTextClickListener(OnTextClickListener onTextClickListener) {
        if (onTextClickListener != null) {
            this.f6170I.add(onTextClickListener);
        }
    }

    public void setOverlayUnderPoi(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.t(z4);
    }

    @Deprecated
    public final void setPadding(int i4, int i5, int i6, int i7) throws JSONException {
        setViewPadding(i4, i5, i6, i7);
    }

    public void setPixelFormatTransparent(boolean z4) {
        MapSurfaceView mapSurfaceView = this.f6194f;
        if (mapSurfaceView == null) {
            return;
        }
        if (z4) {
            mapSurfaceView.setPixelFormatTransparent(true);
        } else {
            mapSurfaceView.setPixelFormatTransparent(false);
        }
    }

    public void setPoiTagEnable(PoiTagType poiTagType, boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.a(poiTagType, z4);
        }
    }

    public final void setTrafficEnabled(boolean z4) {
        if (this.f6198h != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "1", null);
            this.f6198h.z(z4);
        }
    }

    public final void setViewPadding(int i4, int i5, int i6, int i7) throws JSONException {
        MapView mapView;
        if (i4 < 0 || i5 < 0 || i6 < 0 || i7 < 0 || this.f6198h == null) {
            return;
        }
        int i8 = g.f6237b[this.f6205k0.ordinal()];
        if (i8 != 1) {
            if (i8 == 2 && (mapView = this.f6199h0) != null) {
                com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
                Point point = this.f6215p0;
                bVar.a(new Point((int) ((point.x * (((mapView.getWidth() - i4) - i6) / this.f6199h0.getWidth())) + i4), (int) ((point.y * (((this.f6199h0.getHeight() - i5) - i7) / this.f6199h0.getHeight())) + i5)));
                this.f6199h0.setPadding(i4, i5, i6, i7);
                this.f6199h0.invalidate();
                return;
            }
            return;
        }
        if (this.f6201i0 == null) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.f6198h;
        Point point2 = this.f6215p0;
        bVar2.a(new Point((int) ((point2.x * (((r0.getWidth() - i4) - i6) / this.f6201i0.getWidth())) + i4), (int) ((point2.y * (((this.f6201i0.getHeight() - i5) - i7) / this.f6201i0.getHeight())) + i5)));
        this.f6201i0.setPadding(i4, i5, i6, i7);
        this.f6201i0.invalidate();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        showInfoWindow(infoWindow, true);
    }

    public void showInfoWindows(List<InfoWindow> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<InfoWindow> it = list.iterator();
        while (it.hasNext()) {
            showInfoWindow(it.next(), false);
        }
    }

    public final void showMapIndoorPoi(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.E(z4);
            this.f6209m0 = z4;
        }
    }

    public final void showMapPoi(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.H(z4);
            this.f6207l0 = z4;
        }
    }

    public void showOperateLayer(boolean z4) {
        if (this.f6198h == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "2", null);
        this.f6198h.F(z4);
    }

    public void showOperatePoiLayer(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.G(z4);
    }

    public boolean showParticleEffectByType(ParticleEffectType particleEffectType) {
        if (this.f6198h == null) {
            return false;
        }
        if (particleEffectType == ParticleEffectType.Fireworks || particleEffectType == ParticleEffectType.Flower) {
            a(particleEffectType);
        }
        return this.f6198h.b(particleEffectType);
    }

    public void showSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.W();
    }

    public void showTrafficUGCMap(boolean z4) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.I(z4);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        this.f6174M = snapshotReadyCallback;
        int i4 = g.f6237b[this.f6205k0.ordinal()];
        if (i4 != 1) {
            if (i4 != 2 || (mapSurfaceView = this.f6194f) == null || mapSurfaceView.getController() == null) {
                return;
            }
            this.f6194f.doCaptureMapView(new c(), new Rect(0, 0, this.f6194f.getController().getScreenWidth(), this.f6194f.getController().getScreenHeight()), Bitmap.Config.ARGB_8888);
            this.f6194f.requestRender();
            return;
        }
        MapTextureView mapTextureView = this.f6196g;
        if (mapTextureView == null || mapTextureView.getController() == null) {
            return;
        }
        this.f6196g.doCaptureMapView(new b(), new Rect(0, 0, this.f6196g.getController().getScreenWidth(), this.f6196g.getController().getScreenHeight()), Bitmap.Config.ARGB_8888);
        this.f6196g.requestRender();
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        if (this.f6198h == null) {
            return;
        }
        this.f6174M = snapshotReadyCallback;
        int i4 = g.f6237b[this.f6205k0.ordinal()];
        if (i4 != 1) {
            if (i4 == 2 && (mapSurfaceView = this.f6194f) != null) {
                mapSurfaceView.doCaptureMapView(new e(), rect, Bitmap.Config.ARGB_8888);
                this.f6194f.requestRender();
                return;
            }
            return;
        }
        MapTextureView mapTextureView = this.f6196g;
        if (mapTextureView != null) {
            mapTextureView.doCaptureMapView(new d(), rect, Bitmap.Config.ARGB_8888);
            this.f6196g.requestRender();
        }
    }

    public void startHeatMapFrameAnimation() {
        if (this.f6198h == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "H", "1", null);
        this.f6198h.X();
    }

    public void stopHeatMapFrameAnimation() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return;
        }
        bVar.Y();
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", map);
            return switchFloorError;
        }
        MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
        if (focusedBaseIndoorMapInfo == null) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError2 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError2.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", map);
            return switchFloorError2;
        }
        if (!str2.equals(focusedBaseIndoorMapInfo.f6499a)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError3 = MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError3.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", map);
            return switchFloorError3;
        }
        ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
        if (floors == null || !floors.contains(str)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError4 = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError4.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", map);
            return switchFloorError4;
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null || !bVar.b(str, str2)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError5 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError5.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", map);
            return switchFloorError5;
        }
        MapBaseIndoorMapInfo.SwitchFloorError switchFloorError6 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
        map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError6.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", map);
        return switchFloorError6;
    }

    public void switchLayerOrder(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.f6198h == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "5", null);
        if ((this.f6198h.a(mapLayer, mapLayer2) && mapLayer == MapLayer.BM_LAYER_OVERLAY && mapLayer2 == MapLayer.MAP_LAYER_OVERLAY) || (mapLayer == MapLayer.MAP_LAYER_OVERLAY && mapLayer2 == MapLayer.BM_LAYER_OVERLAY)) {
            boolean z4 = !this.f6219r0;
            this.f6219r0 = z4;
            this.f6198h.w(z4);
        }
    }

    public boolean switchOverlayLayerAndNavigationLayer(boolean z4) {
        if (this.f6198h == null) {
            return false;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "4", null);
        return this.f6198h.J(z4);
    }

    public void updateBaseLayers() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null || !bVar.L()) {
            return;
        }
        this.f6198h.Z();
    }

    public void updateHeatMap(HeatMap heatMap) {
        if (heatMap == null || this.f6198h == null) {
            return;
        }
        this.f6185Y.lock();
        try {
            this.f6183W = heatMap;
            heatMap.f6399C = this;
            this.f6198h.k(heatMap.toBundle());
        } finally {
            this.f6185Y.unlock();
        }
    }

    private synchronized void c() {
        if (OverlayUtil.isOverlayUpgrade()) {
            if (this.f6200i != null) {
                return;
            }
            r rVar = this.f6205k0;
            r rVar2 = r.GLSurfaceView;
            if (rVar == rVar2 && this.f6194f == null) {
                return;
            }
            r rVar3 = r.TextureView;
            if (rVar == rVar3 && this.f6196g == null) {
                return;
            }
            if (this.f6198h != null) {
                BmLayer bmLayer = new BmLayer(true);
                this.f6200i = bmLayer;
                bmLayer.setLayerTag("DefaultBmLayer");
                r rVar4 = this.f6205k0;
                if (rVar4 == rVar2) {
                    this.f6194f.addBmLayer(this.f6200i);
                } else if (rVar4 == rVar3) {
                    this.f6196g.addBmLayer(this.f6200i);
                }
                this.f6198h.a(this.f6200i);
                this.f6200i.a(new p());
                this.f6212o = new a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (getMapLanguage() != MapLanguage.ENGLISH) {
            com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
            if (bVar == null || bVar.v()) {
                return;
            }
            this.f6198h.r(false);
            return;
        }
        Context cachedContext = JNIInitializer.getCachedContext();
        if (cachedContext == null || this.f6198h == null) {
            return;
        }
        this.f6198h.a(AbstractC0351g.p(cachedContext.getFilesDir().getAbsolutePath(), "/cfg/a/mode_1/englishmap.sty"), "");
        AppBaseMap appBaseMapI = this.f6198h.i();
        if (appBaseMapI == null) {
            return;
        }
        appBaseMapI.setCustomStyleEnable(true);
    }

    public void d() {
        this.f6217q0 = true;
        com.baidu.mapsdkplatform.comapi.map.z.c cVar = this.f6221s0;
        if (cVar != null) {
            cVar.e();
            this.f6221s0 = null;
        }
        NetworkUtil.unregisterNetworkCallback();
        hideInfoWindow();
    }

    public final void setMapLanguage(MapLanguage mapLanguage, boolean z4) {
        TextureMapView textureMapView;
        MapTextureView mapTextureView;
        MapView mapView;
        MapSurfaceView mapSurfaceView;
        MapLanguage mapLanguage2 = MapLanguage.ENGLISH;
        if (mapLanguage == mapLanguage2 && !PermissionUtils.getInstance().isEnglishMapAuthorized()) {
            Log.e("baidumapsdk", " No advanced permission to set English map");
            if (com.baidu.platform.comapi.c.b.c().b() == mapLanguage2) {
                this.f6198h.a(mapLanguage2.ordinal(), true);
                setMapLanguage(MapLanguage.CHINESE, true);
                com.baidu.platform.comapi.c.b.c().a();
                return;
            }
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.a(mapLanguage.ordinal(), z4);
            showOperatePoiLayer(mapLanguage != mapLanguage2);
            r rVar = this.f6205k0;
            if (rVar == r.GLSurfaceView && (mapView = this.f6199h0) != null && (mapSurfaceView = this.f6194f) != null) {
                mapView.updateScaleUI(mapSurfaceView.getZoomLevel());
            } else if (rVar == r.TextureView && (textureMapView = this.f6201i0) != null && (mapTextureView = this.f6196g) != null) {
                textureMapView.updateScaleUI(mapTextureView.getZoomLevel());
            }
            com.baidu.platform.comapi.c.b.c().a(mapLanguage);
        }
        e();
    }

    public void showInfoWindow(InfoWindow infoWindow, boolean z4) {
        boolean z5;
        MapView mapView;
        Set<InfoWindow> setKeySet = this.f6189c0.keySet();
        if (infoWindow == null || setKeySet.contains(infoWindow) || this.f6217q0) {
            return;
        }
        if (z4) {
            hideInfoWindow();
        }
        infoWindow.f6484i = this.f6216q;
        View view = infoWindow.f6478c;
        if (view == null || !infoWindow.f6489n) {
            z5 = true;
        } else {
            view.destroyDrawingCache();
            MapViewLayoutParams mapViewLayoutParamsBuild = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f6479d).yOffset(infoWindow.f6485j).build();
            int i4 = g.f6237b[this.f6205k0.ordinal()];
            if (i4 == 1) {
                TextureMapView textureMapView = this.f6201i0;
                if (textureMapView != null) {
                    textureMapView.addView(view, mapViewLayoutParamsBuild);
                }
            } else if (i4 == 2 && (mapView = this.f6199h0) != null) {
                mapView.addView(view, mapViewLayoutParamsBuild);
            }
            z5 = false;
        }
        BitmapDescriptor bitmapDescriptorA = a(infoWindow);
        if (bitmapDescriptorA == null) {
            return;
        }
        Overlay overlay = (!infoWindow.f6480e ? new MarkerOptions().perspective(false).icon(bitmapDescriptorA).position(infoWindow.f6479d).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f6485j).infoWindow(infoWindow) : new MarkerOptions().perspective(false).icon(bitmapDescriptorA).position(infoWindow.f6479d).fixedScreenPosition(new Point(infoWindow.f6481f, infoWindow.f6482g)).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f6485j).infoWindow(infoWindow)).getOverlay();
        overlay.listener = this.f6210n;
        if (!infoWindow.f6480e) {
            overlay.type = com.baidu.mapsdkplatform.comapi.map.d.popup;
        }
        overlay.f6720c = 32767;
        Bundle bundle = new Bundle();
        overlay.a(bundle);
        if (infoWindow.f6478c != null) {
            bundle.putInt("draw_with_view", 1);
        } else {
            bundle.putInt("draw_with_view", 0);
        }
        Marker marker = (Marker) overlay;
        if (this.f6198h != null && z5 && !this.f6217q0) {
            if (OverlayUtil.isOverlayUpgrade()) {
                a(marker);
            } else {
                this.f6198h.d(bundle);
            }
            this.f6202j.add(overlay);
        }
        marker.f6615Q = this.f6216q;
        this.f6188b0.put(marker.f6718a, infoWindow);
        this.f6189c0.put(infoWindow, marker);
        this.f6208m.add(infoWindow);
    }

    private void b() {
        this.f6217q0 = false;
        this.f6202j = new CopyOnWriteArrayList();
        this.f6204k = new CopyOnWriteArrayList();
        this.f6206l = new CopyOnWriteArrayList();
        this.f6176O = new CopyOnWriteArrayList<>();
        this.f6188b0 = new ConcurrentHashMap();
        this.f6189c0 = new ConcurrentHashMap();
        this.f6208m = new CopyOnWriteArrayList();
        this.f6215p0 = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        h hVar = new h();
        this.f6181U = hVar;
        NetworkUtil.setNetworkUpdate2MapListener(hVar);
        this.f6192e = new UiSettings(this.f6198h);
        this.f6214p = new i();
        this.f6210n = new j();
        this.f6216q = new k();
        this.f6198h.a(new l());
        this.f6198h.a(new m());
        this.f6198h.a(new n());
        this.f6198h.a(new o());
        this.f6207l0 = this.f6198h.U();
        this.f6209m0 = this.f6198h.G();
    }

    public class i implements HexagonMap.b {
        public i() {
        }

        @Override // com.baidu.mapapi.map.HexagonMap.b
        public void a(HexagonMap hexagonMap) {
            if (BaiduMap.this.f6198h == null || hexagonMap == null) {
                return;
            }
            BaiduMap.this.f6186Z.lock();
            if (BaiduMap.this.f6184X != null && hexagonMap == BaiduMap.this.f6184X) {
                BaiduMap.this.f6198h.f();
                BaiduMap.this.f6184X = null;
                BaiduMap.this.f6198h.n(false);
            }
            BaiduMap.this.f6186Z.unlock();
        }

        @Override // com.baidu.mapapi.map.HexagonMap.b
        public void a(HexagonMap hexagonMap, boolean z4) {
            if (BaiduMap.this.f6198h == null || hexagonMap == null) {
                return;
            }
            BaiduMap.this.f6186Z.lock();
            BaiduMap.this.f6198h.o(z4);
            BaiduMap.this.f6186Z.unlock();
        }
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME);
    }

    public void setCustomTrafficColor(int i4, int i5, int i6, int i7) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.a(i4, i5, i6, i7);
        }
    }

    private Overlay a(Overlay overlay) {
        if (overlay == null || this.f6217q0 || this.f6200i == null || this.f6198h == null) {
            return null;
        }
        this.f6202j.add(overlay);
        overlay.setBmLayer(this.f6200i);
        BmDrawItem drawItem = overlay.toDrawItem();
        this.f6200i.a(drawItem, drawItem.b());
        this.f6200i.b();
        return overlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Overlay overlay) {
        BmLayer bmLayer;
        BmDrawItem bmDrawItemA;
        if (overlay == null || this.f6217q0 || (bmLayer = this.f6200i) == null || (bmDrawItemA = bmLayer.a(overlay.getName())) == null) {
            return;
        }
        this.f6200i.a(bmDrawItemA);
        BmDrawItem drawItem = overlay.toDrawItem();
        this.f6200i.a(drawItem, drawItem.b());
        this.f6200i.b();
    }

    private s a(MapStatusUpdate mapStatusUpdate) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return null;
        }
        s sVarY = bVar.y();
        MapStatus mapStatusA = mapStatusUpdate.a(this.f6198h, getMapStatus());
        if (mapStatusA == null) {
            return null;
        }
        return mapStatusA.b(sVarY);
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        MapView mapView;
        Set<InfoWindow> setKeySet = this.f6189c0.keySet();
        if (infoWindow == null || setKeySet.isEmpty() || !setKeySet.contains(infoWindow)) {
            return;
        }
        View view = infoWindow.f6478c;
        if (view != null) {
            int i4 = g.f6237b[this.f6205k0.ordinal()];
            if (i4 == 1) {
                TextureMapView textureMapView = this.f6201i0;
                if (textureMapView != null) {
                    textureMapView.removeView(view);
                }
            } else if (i4 == 2 && (mapView = this.f6199h0) != null) {
                mapView.removeView(view);
            }
        }
        Marker marker = this.f6189c0.get(infoWindow);
        if (marker != null) {
            marker.remove();
            this.f6188b0.remove(marker.f6718a);
        }
        this.f6189c0.remove(infoWindow);
        this.f6208m.remove(infoWindow);
    }

    private final void a(MyLocationConfiguration myLocationConfiguration) {
        Bitmap bitmap;
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        Bitmap bitmap2;
        Bitmap bitmap3;
        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.f6198h;
        if (bVar2 != null) {
            bVar2.g();
        }
        ArrayList arrayList = new ArrayList();
        if (myLocationConfiguration.isEnableCustom()) {
            if (myLocationConfiguration.getArrow() != null && (bitmap3 = myLocationConfiguration.getArrow().getBitmap()) != null && !bitmap3.isRecycled()) {
                OverlayLocationData overlayLocationData = new OverlayLocationData();
                overlayLocationData.setImage(bitmap3);
                overlayLocationData.setImgHeight(bitmap3.getHeight());
                overlayLocationData.setImgWidth(bitmap3.getWidth());
                overlayLocationData.setImgType("arrowicon");
                overlayLocationData.setImgName("arrowicon_" + bitmap3.hashCode());
                overlayLocationData.setArrowSize(myLocationConfiguration.getArrowSize());
                overlayLocationData.setRotation(1);
                arrayList.add(overlayLocationData);
            }
            if (myLocationConfiguration.getCustomMarker() != null && (bitmap2 = myLocationConfiguration.getCustomMarker().getBitmap()) != null && !bitmap2.isRecycled()) {
                OverlayLocationData overlayLocationData2 = new OverlayLocationData();
                overlayLocationData2.setImage(bitmap2);
                overlayLocationData2.setImgHeight(bitmap2.getHeight());
                overlayLocationData2.setImgWidth(bitmap2.getWidth());
                overlayLocationData2.setImgType("icon");
                overlayLocationData2.setImgName("icon_" + bitmap2.hashCode());
                overlayLocationData2.setMarkerSize(myLocationConfiguration.getMarkerSize());
                overlayLocationData2.setRotation(myLocationConfiguration.isEnableRotation() ? 1 : 0);
                overlayLocationData2.setAnimation(myLocationConfiguration.isNeedAnimation() ? 1 : 0);
                arrayList.add(overlayLocationData2);
            }
            if (myLocationConfiguration.getGifMarker() != null) {
                OverlayLocationData overlayLocationData3 = new OverlayLocationData();
                overlayLocationData3.setImgType("gificon");
                overlayLocationData3.setImgName("gificon");
                overlayLocationData3.setGIFImgPath(myLocationConfiguration.getGifMarker());
                overlayLocationData3.setMarkerSize(myLocationConfiguration.getMarkerSize());
                overlayLocationData3.setRotation(myLocationConfiguration.isEnableRotation() ? 1 : 0);
                overlayLocationData3.setAnimation(myLocationConfiguration.isNeedAnimation() ? 1 : 0);
                arrayList.add(overlayLocationData3);
            }
        } else if (myLocationConfiguration.getCustomMarker() != null && (bitmap = myLocationConfiguration.getCustomMarker().getBitmap()) != null && !bitmap.isRecycled()) {
            OverlayLocationData overlayLocationData4 = new OverlayLocationData();
            overlayLocationData4.setImage(bitmap);
            overlayLocationData4.setImgHeight(bitmap.getHeight());
            overlayLocationData4.setImgWidth(bitmap.getWidth());
            overlayLocationData4.setImgName("icon");
            overlayLocationData4.setRotation(myLocationConfiguration.enableDirection ? 1 : 0);
            arrayList.add(overlayLocationData4);
        }
        if (arrayList.size() <= 0 || (bVar = this.f6198h) == null) {
            return;
        }
        bVar.a(arrayList);
    }

    public BaiduMap(Context context, MapSurfaceView mapSurfaceView, q qVar) {
        this.f6194f = mapSurfaceView;
        com.baidu.mapsdkplatform.comapi.map.b bVar = new com.baidu.mapsdkplatform.comapi.map.b(context, mapSurfaceView, qVar, (String) null, 0);
        this.f6198h = bVar;
        mapSurfaceView.setBaseMap(bVar);
        this.f6205k0 = r.GLSurfaceView;
        b();
    }

    private void b(Overlay overlay) {
        BmLayer bmLayer;
        BmDrawItem bmDrawItem;
        if (overlay == null || this.f6217q0 || (bmLayer = this.f6200i) == null || (bmDrawItem = overlay.mDrawItem) == null) {
            return;
        }
        bmLayer.a(bmDrawItem);
        this.f6200i.b();
        if ((bmDrawItem instanceof BmIconMarker) && ((BmIconMarker) bmDrawItem).d() != null) {
            try {
                ((BmIconMarker) bmDrawItem).d().close();
            } catch (Exception unused) {
                Log.e("BmBitmapResource", "BmBitmapResource close failied");
            }
        }
        try {
            bmDrawItem.close();
        } catch (Exception unused2) {
            Log.e("DrawItem", "DrawItem close failied");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.baidu.mapapi.map.InfoWindow r8) throws java.security.NoSuchAlgorithmException {
        /*
            r7 = this;
            if (r8 == 0) goto Lbf
            boolean r0 = r7.f6217q0
            if (r0 == 0) goto L8
            goto Lbf
        L8:
            java.util.Map<com.baidu.mapapi.map.InfoWindow, com.baidu.mapapi.map.Marker> r0 = r7.f6189c0
            java.util.Set r0 = r0.keySet()
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 != 0) goto Lbc
            boolean r0 = r0.contains(r8)
            if (r0 != 0) goto L1d
            goto Lbc
        L1d:
            android.view.View r0 = r8.f6478c
            r1 = 1
            if (r0 == 0) goto L6c
            boolean r3 = r8.f6489n
            if (r3 == 0) goto L6c
            r0.destroyDrawingCache()
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = new com.baidu.mapapi.map.MapViewLayoutParams$Builder
            r3.<init>()
            com.baidu.mapapi.map.MapViewLayoutParams$ELayoutMode r4 = com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode.mapMode
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = r3.layoutMode(r4)
            com.baidu.mapapi.model.LatLng r4 = r8.f6479d
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = r3.position(r4)
            int r4 = r8.f6485j
            com.baidu.mapapi.map.MapViewLayoutParams$Builder r3 = r3.yOffset(r4)
            com.baidu.mapapi.map.MapViewLayoutParams r3 = r3.build()
            int[] r4 = com.baidu.mapapi.map.BaiduMap.g.f6237b
            com.baidu.mapsdkplatform.comapi.map.r r5 = r7.f6205k0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 == r1) goto L5c
            r5 = 2
            if (r4 == r5) goto L54
            goto L66
        L54:
            com.baidu.mapapi.map.MapView r4 = r7.f6199h0
            if (r4 == 0) goto L66
            r4.addView(r0, r3)
            goto L66
        L5c:
            com.baidu.mapapi.map.TextureMapView r4 = r7.f6201i0
            if (r4 == 0) goto L66
            r4.addView(r0, r3)
            r0.setLayoutParams(r3)
        L66:
            boolean r0 = r8.f6488m
            if (r0 == 0) goto L6c
            r0 = r2
            goto L6d
        L6c:
            r0 = r1
        L6d:
            com.baidu.mapapi.map.BitmapDescriptor r3 = r7.a(r8)
            java.util.Map<com.baidu.mapapi.map.InfoWindow, com.baidu.mapapi.map.Marker> r4 = r7.f6189c0
            java.lang.Object r4 = r4.get(r8)
            com.baidu.mapapi.map.Marker r4 = (com.baidu.mapapi.map.Marker) r4
            if (r4 == 0) goto Lbb
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            com.baidu.mapapi.map.BitmapDescriptor r6 = r8.f6477b
            if (r6 == 0) goto L97
            com.baidu.mapsdkplatform.comapi.map.d r6 = com.baidu.mapsdkplatform.comapi.map.d.popup
            r4.type = r6
            r4.f6623h = r3
            android.view.View r3 = r8.f6478c
            java.lang.String r6 = "draw_with_view"
            if (r3 == 0) goto L94
            r5.putInt(r6, r1)
            goto L97
        L94:
            r5.putInt(r6, r2)
        L97:
            com.baidu.mapapi.model.LatLng r1 = r8.f6479d
            r4.f6622g = r1
            int r8 = r8.f6485j
            r4.f6635t = r8
            r4.a(r5)
            com.baidu.mapsdkplatform.comapi.map.b r8 = r7.f6198h
            if (r8 == 0) goto Lbb
            if (r0 == 0) goto Lbb
            boolean r8 = r7.f6217q0
            if (r8 != 0) goto Lbb
            boolean r8 = com.baidu.mapapi.map.OverlayUtil.isOverlayUpgrade()
            if (r8 == 0) goto Lb6
            r7.a(r4)
            goto Lbb
        Lb6:
            com.baidu.mapsdkplatform.comapi.map.b r7 = r7.f6198h
            r7.l(r5)
        Lbb:
            return
        Lbc:
            r7.showInfoWindow(r8, r2)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.BaiduMap.b(com.baidu.mapapi.map.InfoWindow):void");
    }

    public class p implements com.baidu.platform.comapi.bmsdk.c {
        public p() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem bmDrawItem) {
            InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener;
            if (bmDrawItem instanceof BmArc) {
                BmArc bmArc = (BmArc) bmDrawItem;
                Iterator it = BaiduMap.this.f6171J.iterator();
                while (it.hasNext()) {
                    ((OnArcClickListener) it.next()).onArcClick(bmArc.c());
                }
                return;
            }
            if (bmDrawItem instanceof BmBaseLine) {
                BmBaseLine bmBaseLine = (BmBaseLine) bmDrawItem;
                Iterator it2 = BaiduMap.this.f6165D.iterator();
                while (it2.hasNext()) {
                    ((OnPolylineClickListener) it2.next()).onPolylineClick(bmBaseLine.c());
                }
                return;
            }
            if (bmDrawItem instanceof BmCircle) {
                BmCircle bmCircle = (BmCircle) bmDrawItem;
                bmCircle.e().f6302q = (int) bmCircle.a();
                Iterator it3 = BaiduMap.this.f6167F.iterator();
                while (it3.hasNext()) {
                    ((OnCircleClickListener) it3.next()).onCircleClick(bmCircle.e());
                }
                return;
            }
            if (bmDrawItem instanceof BmPolygon) {
                BmPolygon bmPolygon = (BmPolygon) bmDrawItem;
                bmPolygon.d().f6753w = (int) bmPolygon.a();
                Iterator it4 = BaiduMap.this.f6168G.iterator();
                while (it4.hasNext()) {
                    ((OnPolygonClickListener) it4.next()).onPolygonClick(bmPolygon.d());
                }
                return;
            }
            if (bmDrawItem instanceof BmIconMarker) {
                BmIconMarker bmIconMarker = (BmIconMarker) bmDrawItem;
                String name = bmIconMarker.getName();
                Set<String> setKeySet = BaiduMap.this.f6188b0.keySet();
                if (setKeySet.isEmpty() || !setKeySet.contains(name)) {
                    Iterator it5 = BaiduMap.this.f6163B.iterator();
                    while (it5.hasNext()) {
                        ((OnMarkerClickListener) it5.next()).onMarkerClick(bmIconMarker.e());
                    }
                    Iterator it6 = BaiduMap.this.f6164C.iterator();
                    while (it6.hasNext()) {
                        ((OnMarkerWithBaseUIClickListener) it6.next()).onMarkerClick(bmIconMarker.e());
                    }
                    return;
                }
                for (String str : setKeySet) {
                    if (str != null && str.equals(name)) {
                        InfoWindow infoWindow = (InfoWindow) BaiduMap.this.f6188b0.get(str);
                        if (infoWindow == null || (onInfoWindowClickListener = infoWindow.f6483h) == null) {
                            return;
                        }
                        onInfoWindowClickListener.onInfoWindowClick();
                        return;
                    }
                }
                return;
            }
            if (bmDrawItem instanceof BmTextMarker) {
                BmTextMarker bmTextMarker = (BmTextMarker) bmDrawItem;
                Iterator it7 = BaiduMap.this.f6170I.iterator();
                while (it7.hasNext()) {
                    ((OnTextClickListener) it7.next()).onTextClick(bmTextMarker.d());
                }
                return;
            }
            if (bmDrawItem instanceof BmGround) {
                BmGround bmGround = (BmGround) bmDrawItem;
                Iterator it8 = BaiduMap.this.f6169H.iterator();
                while (it8.hasNext()) {
                    ((OnGroundOverlayClickListener) it8.next()).onGroundOverlayClick(bmGround.c());
                }
                return;
            }
            if (bmDrawItem instanceof BmPrism) {
                return;
            }
            if (bmDrawItem instanceof BmMultiPoint) {
                BmMultiPoint bmMultiPoint = (BmMultiPoint) bmDrawItem;
                int iD = bmMultiPoint.d();
                MultiPoint multiPointE = bmMultiPoint.e();
                if (multiPointE == null) {
                    return;
                }
                Iterator it9 = BaiduMap.this.f6166E.iterator();
                while (it9.hasNext()) {
                    ((OnMultiPointClickListener) it9.next()).onMultiPointClick(bmMultiPoint.e(), multiPointE.getMultiPointItem(iD));
                }
            }
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem bmDrawItem, BmBaseUI bmBaseUI) {
            if (bmDrawItem instanceof BmIconMarker) {
                BmIconMarker bmIconMarker = (BmIconMarker) bmDrawItem;
                Iterator it = BaiduMap.this.f6164C.iterator();
                while (it.hasNext()) {
                    OnMarkerWithBaseUIClickListener onMarkerWithBaseUIClickListener = (OnMarkerWithBaseUIClickListener) it.next();
                    if (bmIconMarker.e() != null && bmBaseUI != null && bmBaseUI.a() != null) {
                        onMarkerWithBaseUIClickListener.onMarkerClick(bmIconMarker.e(), bmBaseUI.a());
                    }
                }
                return;
            }
            boolean z4 = bmDrawItem instanceof Bm3DModel;
        }
    }

    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) throws JSONException {
        float f4;
        if (myLocationData == null || myLocationConfiguration == null || !isMyLocationEnabled()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(new LatLng(myLocationData.latitude, myLocationData.longitude));
        try {
            jSONObject.put("type", 0);
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, geoPointLl2mc.getLongitudeE6());
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, geoPointLl2mc.getLatitudeE6());
            jSONObject2.put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(r14, (int) myLocationData.accuracy));
            float f5 = myLocationData.direction;
            if (myLocationConfiguration.enableDirection) {
                f4 = f5 % 360.0f;
                if (f4 > 180.0f) {
                    f4 -= 360.0f;
                } else if (f4 < -180.0f) {
                    f4 += 360.0f;
                }
            } else {
                f4 = -1001.0f;
            }
            jSONObject2.put("direction", f4);
            jSONObject2.put("iconarrownor", "NormalLocArrow");
            if (!myLocationConfiguration.isEnableCustom()) {
                jSONObject2.put("iconarrownorid", 28);
                jSONObject2.put("iconarrowfocid", 29);
            }
            jSONObject2.put("iconarrowfoc", "FocusLocArrow");
            jSONObject2.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
            jSONObject2.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
            jSONObject2.put("width", myLocationConfiguration.width);
            jSONArray.put(jSONObject2);
            if (myLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS) {
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, geoPointLl2mc.getLongitudeE6());
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, geoPointLl2mc.getLatitudeE6());
                jSONObject3.put("radius", 0);
                jSONObject3.put("direction", 0);
                jSONObject3.put("iconarrownor", "direction_wheel");
                jSONObject3.put("iconarrowfoc", "direction_wheel");
                jSONObject3.put("iconarrownorid", 54);
                jSONObject3.put("iconarrowfocid", 54);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar != null) {
            bVar.a(jSONObject.toString(), (Bundle) null);
        }
        int i4 = g.f6236a[myLocationConfiguration.locationMode.ordinal()];
        if (i4 == 1) {
            animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
        } else {
            if (i4 != 2) {
                return;
            }
            animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
        }
    }

    public void a(HeatMap heatMap) {
        this.f6185Y.lock();
        try {
            HeatMap heatMap2 = this.f6183W;
            if (heatMap2 != null && this.f6198h != null && heatMap == heatMap2) {
                heatMap2.a();
                this.f6183W.c();
                this.f6183W.f6399C = null;
                this.f6198h.e();
                this.f6183W = null;
                this.f6198h.n(false);
            }
        } finally {
            this.f6185Y.unlock();
        }
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIntValue = 0;
        int iIntValue2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",")) {
            String[] strArrSplit = str2.replaceAll("\"", "").split(AwarenessDataItem.USERID_SPLITTER);
            if ("x".equals(strArrSplit[0])) {
                iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
            }
            if ("y".equals(strArrSplit[0])) {
                iIntValue2 = Integer.valueOf(strArrSplit[1]).intValue();
            }
        }
        return new Point(iIntValue, iIntValue2);
    }

    private BitmapDescriptor a(InfoWindow infoWindow) {
        View view = infoWindow.f6478c;
        if (view != null && infoWindow.f6489n) {
            if (infoWindow.f6486k) {
                if (infoWindow.f6487l <= 0) {
                    infoWindow.f6487l = SysOSUtil.getDensityDpi();
                }
                return BitmapDescriptorFactory.fromViewWithDpi(infoWindow.f6478c, infoWindow.f6487l);
            }
            return BitmapDescriptorFactory.fromView(view);
        }
        return infoWindow.f6477b;
    }

    public boolean a() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
        if (bVar == null) {
            return false;
        }
        return bVar.c();
    }

    public void a(TileOverlay tileOverlay) {
        this.f6187a0.lock();
        if (tileOverlay != null) {
            try {
                if (this.f6182V == tileOverlay) {
                    tileOverlay.c();
                    tileOverlay.f7021c = null;
                    com.baidu.mapsdkplatform.comapi.map.b bVar = this.f6198h;
                    if (bVar != null) {
                        bVar.V();
                    }
                }
            } finally {
                this.f6182V = null;
                this.f6187a0.unlock();
            }
        }
    }

    private void a(ParticleEffectType particleEffectType) {
        BitmapDescriptor bitmapDescriptorFromAsset;
        if (ParticleEffectType.Flower == particleEffectType && !f6160b && (bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset("flower.png")) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            bundle.putBundle(String.format("texture_%d", 0), bitmapDescriptorFromAsset.a());
            if (this.f6198h.a(particleEffectType, bundle)) {
                f6160b = true;
            }
        }
        if (ParticleEffectType.Fireworks != particleEffectType || f6161c) {
            return;
        }
        BitmapDescriptor bitmapDescriptorFromAsset2 = BitmapDescriptorFactory.fromAsset("firework_bullet.png");
        BitmapDescriptor bitmapDescriptorFromAsset3 = BitmapDescriptorFactory.fromAsset("firework_tail.png");
        if (bitmapDescriptorFromAsset2 == null || bitmapDescriptorFromAsset3 == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("total", 2);
        bundle2.putBundle(String.format("texture_%d", 0), bitmapDescriptorFromAsset2.a());
        bundle2.putBundle(String.format("texture_%d", 1), bitmapDescriptorFromAsset3.a());
        if (this.f6198h.a(particleEffectType, bundle2)) {
            f6161c = true;
        }
    }
}
