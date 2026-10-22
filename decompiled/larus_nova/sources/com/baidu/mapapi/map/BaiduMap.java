package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.NetworkUpdate2MapListener;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.bmsdk.ui.BaseUI;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.util.IAdvPermissionUpdateListener;
import com.baidu.mapsdkplatform.comapi.util.MapSDKAdvancedPermission;
import com.baidu.platform.comapi.JNIInitializer;
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
import com.baidu.platform.comapi.store.MapLanguageRecord;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
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
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class BaiduMap implements IAdvPermissionUpdateListener {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 22.0f;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f30701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f30702b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f30703c = false;
    public static int mapStatusReason = 256;
    private OnMapDoubleClickListener A;
    private OnMapLongClickListener B;
    private CopyOnWriteArrayList<OnMarkerClickListener> C;
    private CopyOnWriteArrayList<OnMarkerWithBaseUIClickListener> D;
    private CopyOnWriteArrayList<OnMarkerClickWithPositionListener> E;
    private CopyOnWriteArrayList<OnPolylineClickListener> F;
    private CopyOnWriteArrayList<OnMultiPointClickListener> G;
    private CopyOnWriteArrayList<OnCircleClickListener> H;
    private CopyOnWriteArrayList<OnPolygonClickListener> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private CopyOnWriteArrayList<OnGroundOverlayClickListener> f30704J;
    private CopyOnWriteArrayList<OnTextClickListener> K;
    private CopyOnWriteArrayList<OnArcClickListener> L;
    private CopyOnWriteArrayList<OnPrismClickListener> M;
    private OnMarkerDragListener N;
    private OnMyLocationClickListener O;
    private SnapshotReadyCallback P;
    private Building3DListener Q;
    private CopyOnWriteArrayList<Building> R;
    private OnMapDrawFrameCallback S;
    private OnBaseIndoorMapListener T;
    private OnMapRenderValidDataListener U;
    private OnHeatMapDrawFrameCallBack V;
    private OnSynchronizationListener W;
    NetworkUpdate2MapListener X;
    private TileOverlay Y;
    private HeatMap Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private HexagonMap f30705a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Lock f30706b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Lock f30707c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Projection f30708d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Lock f30709d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UiSettings f30710e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private Map<String, InfoWindow> f30711e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MapSurfaceView f30712f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Map<InfoWindow, Marker> f30713f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MapTextureView f30714g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Marker f30715g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private NaviMapExpand f30716h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private MyLocationData f30717h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.baidu.mapsdkplatform.comapi.map.b f30718i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private MyLocationConfiguration f30719i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BmLayer f30720j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private OnLocationModeChangeListener f30721j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Overlay> f30722k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    MapView f30723k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<Marker> f30724l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    TextureMapView f30725l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<Marker> f30726m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    WearMapView f30727m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<InfoWindow> f30728n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    com.baidu.mapsdkplatform.comapi.map.r f30729n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Overlay.a f30730o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f30731o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BaseUI.onBaseUIListener f30732p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f30733p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private HexagonMap.b f30734q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f30735q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private InfoWindow.a f30736r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f30737r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private InfoWindowAdapter f30738s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Point f30739s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private OnMapStatusChangeListener f30740t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private volatile boolean f30741t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private OnMapTouchListener f30742u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f30743u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private onMapGestureListener f30744v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.z.c f30745v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private OnMapClickListener f30746w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f30747w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private OnMapLoadedCallback f30748x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private OnMapTileLoadedCallback f30749y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private OnMapRenderCallback f30750z;

    public interface OnArcClickListener {
        boolean onArcClick(Arc r100);
    }

    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean r100, MapBaseIndoorMapInfo r101);
    }

    public interface OnCircleClickListener {
        boolean onCircleClick(Circle r100);
    }

    public interface OnFirstFrameDrawListener {
        void onFirstFrameDraw();
    }

    public interface OnGroundOverlayClickListener {
        boolean onGroundOverlayClick(GroundOverlay r100);
    }

    public interface OnHeatMapDrawFrameCallBack {
        void frameIndex(int r100);
    }

    public interface OnLocationModeChangeListener {
        void onLocationModeChange(MyLocationConfiguration.LocationMode r100);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng r100);

        void onMapPoiClick(MapPoi r100);
    }

    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng r100);
    }

    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus r100);

        void onMapDrawFrame(GL10 r100, MapStatus r101);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng r100);
    }

    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean r100, int r101, String r102);
    }

    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus r100);

        void onMapStatusChangeFinish(MapStatus r100);

        void onMapStatusChangeStart(MapStatus r100);

        void onMapStatusChangeStart(MapStatus r100, int r101);
    }

    public interface OnMapTileLoadedCallback {
        void onFirstMapTileLoaded();
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent r100);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker r100);
    }

    public interface OnMarkerClickWithPositionListener {
        void onMarkerClick(Marker r100, PointF r101);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker r100);

        void onMarkerDragEnd(Marker r100);

        void onMarkerDragStart(Marker r100);
    }

    public interface OnMarkerWithBaseUIClickListener {
        void onMarkerClick(Marker r100);

        void onMarkerClick(Marker r100, BaseUI r101);
    }

    public interface OnMultiPointClickListener {
        boolean onMultiPointClick(MultiPoint r100, MultiPointItem r101);
    }

    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    public interface OnPolygonClickListener {
        boolean onPolygonClick(Polygon r100);
    }

    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline r100);
    }

    public interface OnPrismClickListener {
        boolean onPrismOverlayClick(Prism r100);
    }

    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int r100);
    }

    public interface OnTextClickListener {
        boolean onTextClick(Text r100);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap r100);
    }

    public class a implements BaseUI.onBaseUIListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30751a;

        public a(BaiduMap r100) {
            this.f30751a = r100;
        }

        @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI.onBaseUIListener
        public void onBaseUIRemove(BaseUI r100) {
            if (BaiduMap.P(this.f30751a) == null) goto L6;
            BaiduMap.P(this.f30751a).b();
            return;
        }

        @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI.onBaseUIListener
        public void onBaseUIUpdate(BaseUI r100) {
            if (BaiduMap.P(this.f30751a) == null) goto L6;
            BaiduMap.P(this.f30751a).b();
            return;
        }
    }

    public class b implements CaptureMapViewListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30752a;

        public b(BaiduMap r100) {
            this.f30752a = r100;
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap r100) {
            BaiduMap.Q(this.f30752a).onSnapshotReady(r100);
        }
    }

    public class c implements CaptureMapViewListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30753a;

        public c(BaiduMap r100) {
            this.f30753a = r100;
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap r100) {
            BaiduMap.Q(this.f30753a).onSnapshotReady(r100);
        }
    }

    public class d implements CaptureMapViewListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30754a;

        public d(BaiduMap r100) {
            this.f30754a = r100;
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap r100) {
            BaiduMap.Q(this.f30754a).onSnapshotReady(r100);
        }
    }

    public class e implements CaptureMapViewListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30755a;

        public e(BaiduMap r100) {
            this.f30755a = r100;
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap r100) {
            BaiduMap.Q(this.f30755a).onSnapshotReady(r100);
        }
    }

    public class f implements com.baidu.platform.comapi.map.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnFirstFrameDrawListener f30756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30757b;

        @Override // com.baidu.platform.comapi.map.d
        public void a() {
            this.f30756a.onFirstFrameDraw();
        }

        public f(BaiduMap r100, OnFirstFrameDrawListener r101) {
            this.f30757b = r100;
            this.f30756a = r101;
        }
    }

    public class g implements com.baidu.platform.comapi.map.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnFirstFrameDrawListener f30758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30759b;

        @Override // com.baidu.platform.comapi.map.d
        public void a() {
            this.f30758a.onFirstFrameDraw();
        }

        public g(BaiduMap r100, OnFirstFrameDrawListener r101) {
            this.f30759b = r100;
            this.f30758a = r101;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30760a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapapi_map_BaiduMap$h_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapapi_map_BaiduMap$h__run$___twin___() {
            int r100 = i.f30762b[this.f30760a.f30729n0.ordinal()];
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L8;
            return;
        L8:
            if (BaiduMap.T(this.f30760a) == null) goto L14;
            BaiduMap.T(this.f30760a).requestRender();
            return;
        L14:
            return;
        L11:
            if (BaiduMap.S(this.f30760a) == null) goto L16;
            BaiduMap.S(this.f30760a).requestRender();
            return;
        }

        public h(BaiduMap r100) {
            this.f30760a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapapi_map_BaiduMap$h_com_larus_apm_impl_protector_RunnableLancet_run(h r100) {
            r100.com_baidu_mapapi_map_BaiduMap$h__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30761a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f30762b = null;

        static {
            int[] r100 = new int[com.baidu.mapsdkplatform.comapi.map.r.values().length];
            f30762b = r100;
            r100[com.baidu.mapsdkplatform.comapi.map.r.f32197b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L16:
            f30762b[com.baidu.mapsdkplatform.comapi.map.r.f32196a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            int[] r101 = new int[MyLocationConfiguration.LocationMode.values().length];
            f30761a = r101;
            r101[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L20:
            f30761a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L24:
            f30761a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public class j implements NetworkUpdate2MapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30763a;

        @Override // com.baidu.mapapi.NetworkUpdate2MapListener
        public void networkUpdate() {
            if (BaiduMap.a(this.f30763a) == false) goto L5;
            return;
        L5:
            if (BaiduMap.b(this.f30763a) != null) goto L7;
            return;
        L7:
            if (BaiduMap.b(this.f30763a).M() == false) goto L12;
            BaiduMap.b(this.f30763a).a0();
            return;
        }

        public j(BaiduMap r100) {
            this.f30763a = r100;
        }
    }

    public class k implements HexagonMap.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30764a;

        public k(BaiduMap r100) {
            this.f30764a = r100;
        }

        @Override // com.baidu.mapapi.map.HexagonMap.b
        public void a(HexagonMap r100) {
            if (BaiduMap.b(this.f30764a) == null) goto L13;
            if (r100 == null) goto L14;
            BaiduMap.l(this.f30764a).lock();
            if (BaiduMap.w(this.f30764a) != null) goto L9;
        L11:
            BaiduMap.l(this.f30764a).unlock();
            return;
        L9:
            if (r100 != BaiduMap.w(this.f30764a)) goto L11;
            BaiduMap.b(this.f30764a).f();
            BaiduMap.a(this.f30764a, null);
            BaiduMap.b(this.f30764a).o(false);
            goto L11
        L14:
            return;
        }

        @Override // com.baidu.mapapi.map.HexagonMap.b
        public void a(HexagonMap r100, boolean r101) {
            if (BaiduMap.b(this.f30764a) == null) goto L8;
            if (r100 == null) goto L9;
            BaiduMap.l(this.f30764a).lock();
            BaiduMap.b(this.f30764a).p(r101);
            BaiduMap.l(this.f30764a).unlock();
            return;
        L9:
            return;
        }
    }

    public class l implements Overlay.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30765a;

        public l(BaiduMap r100) {
            this.f30765a = r100;
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public void a(Overlay r100) {
            if (BaiduMap.a(this.f30765a) == false) goto L5;
            return;
        L5:
            if (r100 != null) goto L7;
        L16:
            if (r100 != null) goto L18;
        L20:
            if (r100 != null) goto L22;
        L24:
            if (r100 != null) goto L26;
            return;
        L26:
            if (BaiduMap.V(this.f30765a).contains(r100) == false) goto L36;
            Marker r101 = (Marker) r100;
            if (r101.G == null) goto L37;
            BaiduMap.V(this.f30765a).remove(r101);
            if (BaiduMap.V(this.f30765a).size() == 0) goto L32;
            return;
        L32:
            if (BaiduMap.b(this.f30765a) == null) goto L39;
            BaiduMap.b(this.f30765a).t(false);
            return;
        L39:
            return;
        L37:
            return;
        L36:
            return;
        L22:
            if (BaiduMap.U(this.f30765a).contains(r100) == false) goto L24;
            BaiduMap.U(this.f30765a).remove(r100);
            goto L24
        L18:
            if (BaiduMap.R(this.f30765a).contains(r100) == false) goto L20;
            BaiduMap.R(this.f30765a).remove(r100);
            goto L20
        L7:
            if (BaiduMap.H(this.f30765a).contains(r100) == false) goto L16;
            if (OverlayUtil.isOverlayUpgrade() == true) goto L11;
        L12:
            Bundle r102 = r100.a();
            if (BaiduMap.b(this.f30765a) == null) goto L15;
            BaiduMap.b(this.f30765a).i(r102);
        L15:
            BaiduMap.H(this.f30765a).remove(r100);
            goto L16
        L11:
            if ((r100 instanceof Dot) == false) goto L15;
            goto L12
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public boolean b(Overlay r100) {
            if (BaiduMap.H(this.f30765a) != null) goto L5;
        L7:
            return false;
        L5:
            if (BaiduMap.H(this.f30765a).contains(r100) == true) goto L7;
            return true;
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public void c(Overlay r100) {
            if (BaiduMap.a(this.f30765a) == false) goto L5;
            return;
        L5:
            if (r100 == null) goto L45;
            if (BaiduMap.H(this.f30765a).contains(r100) == false) goto L45;
            if ((r100 instanceof Marker) == false) goto L31;
            Marker r101 = (Marker) r100;
            boolean r102 = true;
            if (r101.f31110h == null) goto L21;
            ArrayList<BitmapDescriptor> r103 = r101.G;
            if (r103 == null) goto L31;
            if (r103.size() <= 1) goto L31;
            Bundle r104 = new Bundle();
            if (BaiduMap.b(this.f30765a) == null) goto L31;
            if (BaiduMap.a(this.f30765a) == true) goto L31;
            r101.remove();
            r101.G.clear();
            BaiduMap.b(this.f30765a).d(r100.a(r104));
            BaiduMap.H(this.f30765a).add(r100);
        L33:
            if (BaiduMap.b(this.f30765a) == null) goto L45;
            if (r102 == true) goto L45;
            if (BaiduMap.a(this.f30765a) == true) goto L45;
            if (OverlayUtil.isOverlayUpgrade() == true) goto L40;
            Bundle r105 = new Bundle();
            BaiduMap.b(this.f30765a).l(r100.a(r105));
            goto L45
        L40:
            if ((r100 instanceof Polyline) == false) goto L42;
            BaiduMap.a(this.f30765a, r100);
            goto L45
        L42:
            Bundle r106 = new Bundle();
            BaiduMap.b(this.f30765a).l(r100.a(r106));
            goto L45
        L21:
            ArrayList<BitmapDescriptor> r107 = r101.G;
            if (r107 == null) goto L31;
            if (r107.size() == 0) goto L31;
            if (BaiduMap.V(this.f30765a).contains(r101) == false) goto L28;
            BaiduMap.V(this.f30765a).remove(r101);
        L28:
            BaiduMap.V(this.f30765a).add(r101);
            if (BaiduMap.b(this.f30765a) == null) goto L31;
            BaiduMap.b(this.f30765a).t(true);
        L31:
            r102 = false;
        L45:
            if (BaiduMap.R(this.f30765a).contains(r100) == false) goto L48;
            BaiduMap.R(this.f30765a).remove(r100);
        L48:
            if (BaiduMap.U(this.f30765a).contains(r100) == false) goto L51;
            BaiduMap.U(this.f30765a).remove(r100);
        L51:
            if ((r100 instanceof Marker) == false) goto L54;
            List r108 = BaiduMap.R(this.f30765a);
            r108.add((Marker) r100);
        L54:
            if ((r100 instanceof Building) == false) goto L57;
            CopyOnWriteArrayList r109 = BaiduMap.U(this.f30765a);
            r109.add((Building) r100);
            return;
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public LatLngBounds d(Overlay r100) {
            if (BaiduMap.b(this.f30765a) == null) goto L7;
            if (r100 == null) goto L9;
            Bundle r101 = new Bundle();
            r100.a(r101);
            return BaiduMap.b(this.f30765a).f(r101);
        L9:
            return null;
        L7:
            return null;
        }
    }

    public class m implements InfoWindow.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30766a;

        public m(BaiduMap r100) {
            this.f30766a = r100;
        }

        @Override // com.baidu.mapapi.map.InfoWindow.a
        public void a(InfoWindow r100) {
            this.f30766a.hideInfoWindow(r100);
        }

        @Override // com.baidu.mapapi.map.InfoWindow.a
        public void b(InfoWindow r100) {
            BaiduMap.a(this.f30766a, r100);
        }
    }

    public class n implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30767a;

        public n(BaiduMap r100) {
            this.f30767a = r100;
        }

        @Override // com.baidu.platform.comapi.map.w
        public void a(int r100) {
            int r101 = 0;
        L4:
            if (r101 >= BaiduMap.U(this.f30767a).size()) goto L9;
            if (((Building) BaiduMap.U(this.f30767a).get(r101)).getBuildingId() != r100) goto L8;
            BaiduMap.c(this.f30767a).onBuildingFloorAnimationStop((Building) BaiduMap.U(this.f30767a).get(r101));
        L8:
            r101 = r101 + 1;
            goto L4
        }
    }

    public class o implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30768a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InfoWindow f30769a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ o f30770b;

            @Override // java.lang.Runnable
            public void run() {
                com_baidu_mapapi_map_BaiduMap$o$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_baidu_mapapi_map_BaiduMap$o$a__run$___twin___() {
                MapViewLayoutParams r100 = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(this.f30769a.f30994d).yOffset(this.f30769a.f31000j).build();
                this.f30769a.f30993c.setLayoutParams(r100);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_mapapi_map_BaiduMap$o$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
                r100.com_baidu_mapapi_map_BaiduMap$o$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(o r100, InfoWindow r101) {
                this.f30770b = r100;
                this.f30769a = r101;
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a() {
            if (BaiduMap.b(this.f30768a) == null) goto L5;
            BaiduMap.b(this.f30768a).t(false);
        L5:
            BaiduMap.C(this.f30768a).lock();
        L11:
            th = move-exception;
            BaiduMap.C(this.f30768a).unlock();
            throw th;
        L7:
            if (BaiduMap.D(this.f30768a) == null) goto L9;
            BaiduMap r100 = this.f30768a;     // Catch: Throwable -> L11
            r100.a(BaiduMap.D(r100));     // Catch: Throwable -> L11
        L9:
            BaiduMap.C(this.f30768a).unlock();
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b() {
            if (BaiduMap.n(this.f30768a) == null) goto L6;
            BaiduMap.n(this.f30768a).onMapRenderFinished();
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d() {
            BaiduMap r100 = this.f30768a;
            BaiduMap.a(r100, new Projection(BaiduMap.b(r100)));
            BaiduMap.a(this.f30768a, true);
            if (BaiduMap.m(this.f30768a) == null) goto L6;
            BaiduMap.m(this.f30768a).onMapLoaded();
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void onFirstMapTileLoaded() {
            if (BaiduMap.q(this.f30768a) == null) goto L6;
            BaiduMap.q(this.f30768a).onFirstMapTileLoaded();
            return;
        }

        public o(BaiduMap r100) {
            this.f30768a = r100;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(String r100) {
            JSONArray r101 = new JSONObject(r100).optJSONArray("dataset");     // Catch: Exception -> L29
            if (r101 != null) goto L6;
            return false;
        L6:
            JSONObject r102 = r101.optJSONObject(0);     // Catch: Exception -> L29
            if (r102 != null) goto L10;
            return false;
        L10:
            if (r102.optInt("ty") != 90909) goto L38;
            String r103 = r102.optString("marker_id");     // Catch: Exception -> L29
            Set r104 = BaiduMap.s(this.f30768a).keySet();     // Catch: Exception -> L29
            if (r104.isEmpty() == false) goto L14;
        L15:
            Iterator r105 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L29
        L17:
            if (r105.hasNext() == false) goto L42;
            Overlay r106 = (Overlay) r105.next();     // Catch: Exception -> L29
            if ((r106 instanceof Marker) == false) goto L17;
            if (r106.f31202a.equals(r103) == false) goto L17;
            Marker r107 = (Marker) r106;     // Catch: Exception -> L29
            if (r107.f31117o == false) goto L40;
            BaiduMap.a(this.f30768a, r107);     // Catch: Exception -> L29
            Point r108 = BaiduMap.k(this.f30768a).toScreenLocation(BaiduMap.o(this.f30768a).f31109g);     // Catch: Exception -> L29
            BaiduMap.o(this.f30768a).setPosition(BaiduMap.k(this.f30768a).fromScreenLocation(new Point(r108.x, r108.y - 60)));     // Catch: Exception -> L29
            if (BaiduMap.p(this.f30768a) == null) goto L27;
            BaiduMap.p(this.f30768a).onMarkerDragStart(BaiduMap.o(this.f30768a));     // Catch: Exception -> L29
        L27:
            return true;
        L40:
            return false;
        L42:
            return false;
        L14:
            if (r104.contains(r103) == false) goto L15;
            return false;
        L38:
            return false;
        L41:
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(String r110) {
            JSONObject r100 = new JSONObject(r110);     // Catch: Exception -> L229
            GeoPoint r111 = BaiduMap.b(this.f30768a).a(r100.optInt(GXTemplateKey.GAIAX_PX), r100.optInt("py"));     // Catch: Exception -> L229
            JSONArray r101 = r100.optJSONArray("dataset");     // Catch: Exception -> L229
            int r102 = -1;
            if (r101 == null) goto L7;
            JSONObject r103 = r101.optJSONObject(0);     // Catch: Exception -> L229
            if (r103 == null) goto L9;
            r102 = r103.optInt("ty");     // Catch: Exception -> L229
        L9:
            if (r102 != 17) goto L14;
            if (BaiduMap.h(this.f30768a) == null) goto L228;
            MapPoi r112 = new MapPoi();     // Catch: Exception -> L229
            r112.a(r103);     // Catch: Exception -> L229
            BaiduMap.h(this.f30768a).onMapPoiClick(r112);     // Catch: Exception -> L229
            return;
        L228:
            return;
        L14:
            if (r102 != 18) goto L20;
            if (BaiduMap.r(this.f30768a) == null) goto L18;
            BaiduMap.r(this.f30768a).onMyLocationClick();     // Catch: Exception -> L229
            return;
        L18:
            b(r111);     // Catch: Exception -> L229
            return;
        L20:
            if (r102 != 19) goto L28;
            if (BaiduMap.b(this.f30768a) == null) goto L343;
            s r113 = BaiduMap.b(this.f30768a).z();     // Catch: Exception -> L229
            if (r113 != null) goto L26;
            return;
        L26:
            r113.f32202c = 0;     // Catch: Exception -> L229
            r113.f32201b = 0;     // Catch: Exception -> L229
            BaiduMap.mapStatusReason |= 16;     // Catch: Exception -> L229
            BaiduMap.b(this.f30768a).a(r113, 300);     // Catch: Exception -> L229
            return;
        L343:
            return;
        L28:
            if (r102 == 6002) goto L30;
            String r104 = "";
            if (r102 != 90909) goto L69;
            if (r103 == null) goto L37;
            r104 = r103.optString("marker_id");     // Catch: Exception -> L229
        L37:
            Set r105 = BaiduMap.s(this.f30768a).keySet();     // Catch: Exception -> L229
            if (r105.isEmpty() == false) goto L40;
        L54:
            Iterator r106 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L56:
            if (r106.hasNext() == false) goto L353;
            Overlay r107 = (Overlay) r106.next();     // Catch: Exception -> L229
            if ((r107 instanceof Marker) == false) goto L56;
            if (r107.f31202a.equals(r104) == false) goto L56;
            if (BaiduMap.t(this.f30768a).isEmpty() == false) goto L63;
            b(r111);     // Catch: Exception -> L229
            goto L56
        L63:
            Iterator r114 = BaiduMap.t(this.f30768a).iterator();     // Catch: Exception -> L229
        L65:
            if (r114.hasNext() == false) goto L354;
            ((OnMarkerClickListener) r114.next()).onMarkerClick((Marker) r107);     // Catch: Exception -> L229
            goto L65
        L354:
            return;
        L353:
            return;
        L40:
            if (r105.contains(r104) == false) goto L54;
            Iterator r108 = r105.iterator();     // Catch: Exception -> L229
        L43:
            if (r108.hasNext() == false) goto L352;
            String r109 = (String) r108.next();     // Catch: Exception -> L229
            if (r109 == null) goto L43;
            if (r109.equals(r104) == false) goto L43;
            InfoWindow r115 = (InfoWindow) BaiduMap.s(this.f30768a).get(r109);     // Catch: Exception -> L229
            if (r115 == null) goto L53;
            InfoWindow.OnInfoWindowClickListener r116 = r115.f30998h;     // Catch: Exception -> L229
            if (r116 == null) goto L53;
            r116.onInfoWindowClick();     // Catch: Exception -> L229
            return;
        L53:
            b(r111);     // Catch: Exception -> L229
            return;
        L352:
            return;
        L69:
            if (r102 != 90910) goto L87;
            if (r103 == null) goto L72;
            r104 = r103.optString("polyline_id");     // Catch: Exception -> L229
        L72:
            Iterator r117 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L74:
            if (r117.hasNext() == false) goto L355;
            Overlay r118 = (Overlay) r117.next();     // Catch: Exception -> L229
            if ((r118 instanceof Polyline) == false) goto L74;
            if (r118.f31202a.equals(r104) == false) goto L74;
            if (BaiduMap.u(this.f30768a).isEmpty() == false) goto L81;
            b(r111);     // Catch: Exception -> L229
            goto L74
        L81:
            Iterator r119 = BaiduMap.u(this.f30768a).iterator();     // Catch: Exception -> L229
        L83:
            if (r119.hasNext() == false) goto L74;
            ((OnPolylineClickListener) r119.next()).onPolylineClick((Polyline) r118);     // Catch: Exception -> L229
            goto L83
        L355:
            return;
        L87:
            if (r102 != 90911) goto L113;
            if (r103 == null) goto L90;
            r104 = r103.optString("multipoint_id");     // Catch: Exception -> L229
        L90:
            Iterator r120 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L92:
            if (r120.hasNext() == false) goto L356;
            Overlay r121 = (Overlay) r120.next();     // Catch: Exception -> L229
            if ((r121 instanceof MultiPoint) == false) goto L92;
            if (r121.f31202a.equals(r104) == false) goto L92;
            if (BaiduMap.v(this.f30768a).isEmpty() == false) goto L99;
            b(r111);     // Catch: Exception -> L229
            goto L92
        L99:
            Iterator r122 = BaiduMap.v(this.f30768a).iterator();     // Catch: Exception -> L229
        L101:
            if (r122.hasNext() == false) goto L92;
            OnMultiPointClickListener r123 = (OnMultiPointClickListener) r122.next();     // Catch: Exception -> L229
            MultiPoint r124 = (MultiPoint) r121;     // Catch: Exception -> L229
            List<MultiPointItem> r125 = r124.getMultiPointItems();     // Catch: Exception -> L229
            if (r103 == null) goto L101;
            int r126 = r103.optInt("multipoint_index");     // Catch: Exception -> L229
            if (r125 == null) goto L101;
            if (r126 < 0) goto L101;
            if (r125.size() <= r126) goto L101;
            r123.onMultiPointClick(r124, (MultiPointItem) ListProtector.get(r125, r126));     // Catch: Exception -> L229
            goto L101
        L356:
            return;
        L113:
            if (r102 != 90912) goto L136;
            if (r103 == null) goto L116;
            r104 = r103.optString("overlay_id");     // Catch: Exception -> L229
        L116:
            Iterator r127 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L118:
            if (r127.hasNext() == false) goto L357;
            Overlay r128 = (Overlay) r127.next();     // Catch: Exception -> L229
            if ((r128 instanceof Polygon) == false) goto L118;
            if (r128.f31202a.equals(r104) == false) goto L118;
            if (BaiduMap.x(this.f30768a).isEmpty() == false) goto L125;
            b(r111);     // Catch: Exception -> L229
            goto L118
        L125:
            Iterator r129 = BaiduMap.x(this.f30768a).iterator();     // Catch: Exception -> L229
        L127:
            if (r129.hasNext() == false) goto L118;
            OnPolygonClickListener r130 = (OnPolygonClickListener) r129.next();     // Catch: Exception -> L229
            if (r103 == null) goto L133;
            if (r103.has("hole_clicked_index") == false) goto L133;
            ((Polygon) r128).f31230w = r103.optInt("hole_clicked_index");     // Catch: Exception -> L229
        L133:
            r130.onPolygonClick((Polygon) r128);     // Catch: Exception -> L229
            goto L127
        L357:
            return;
        L136:
            if (r102 != 90914) goto L156;
            if (r103 == null) goto L348;
            String r131 = r103.optString("overlay_id");     // Catch: Exception -> L229
            Iterator r132 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L140:
            if (r132.hasNext() == false) goto L358;
            Overlay r133 = (Overlay) r132.next();     // Catch: Exception -> L229
            if ((r133 instanceof Circle) == false) goto L154;
            if (r133.f31202a.equals(r131) == false) goto L154;
            if (BaiduMap.y(this.f30768a).isEmpty() == true) goto L140;
            Iterator r134 = BaiduMap.y(this.f30768a).iterator();     // Catch: Exception -> L229
        L149:
            if (r134.hasNext() == false) goto L140;
            OnCircleClickListener r135 = (OnCircleClickListener) r134.next();     // Catch: Exception -> L229
            if (r103.has("hole_clicked_index") == false) goto L153;
            ((Circle) r133).f30821q = r103.optInt("hole_clicked_index");     // Catch: Exception -> L229
        L153:
            r135.onCircleClick((Circle) r133);     // Catch: Exception -> L229
        L154:
            b(r111);     // Catch: Exception -> L229
            goto L140
        L358:
            return;
        L348:
            return;
        L156:
            if (r102 != 90915) goto L174;
            if (r103 == null) goto L159;
            r104 = r103.optString("overlay_id");     // Catch: Exception -> L229
        L159:
            Iterator r136 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L161:
            if (r136.hasNext() == false) goto L359;
            Overlay r137 = (Overlay) r136.next();     // Catch: Exception -> L229
            if ((r137 instanceof GroundOverlay) == false) goto L161;
            if (r137.f31202a.equals(r104) == false) goto L161;
            if (BaiduMap.z(this.f30768a).isEmpty() == false) goto L168;
            b(r111);     // Catch: Exception -> L229
            goto L161
        L168:
            Iterator r138 = BaiduMap.z(this.f30768a).iterator();     // Catch: Exception -> L229
        L170:
            if (r138.hasNext() == false) goto L161;
            ((OnGroundOverlayClickListener) r138.next()).onGroundOverlayClick((GroundOverlay) r137);     // Catch: Exception -> L229
            goto L170
        L359:
            return;
        L174:
            if (r102 != 90916) goto L192;
            if (r103 == null) goto L177;
            r104 = r103.optString("overlay_id");     // Catch: Exception -> L229
        L177:
            Iterator r139 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L179:
            if (r139.hasNext() == false) goto L360;
            Overlay r140 = (Overlay) r139.next();     // Catch: Exception -> L229
            if ((r140 instanceof Text) == false) goto L179;
            if (r140.f31202a.equals(r104) == false) goto L179;
            if (BaiduMap.A(this.f30768a).isEmpty() == false) goto L186;
            b(r111);     // Catch: Exception -> L229
            goto L179
        L186:
            Iterator r141 = BaiduMap.A(this.f30768a).iterator();     // Catch: Exception -> L229
        L188:
            if (r141.hasNext() == false) goto L179;
            ((OnTextClickListener) r141.next()).onTextClick((Text) r140);     // Catch: Exception -> L229
            goto L188
        L360:
            return;
        L192:
            if (r102 != 90917) goto L210;
            if (r103 == null) goto L195;
            r104 = r103.optString("overlay_id");     // Catch: Exception -> L229
        L195:
            Iterator r142 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L197:
            if (r142.hasNext() == false) goto L361;
            Overlay r143 = (Overlay) r142.next();     // Catch: Exception -> L229
            if ((r143 instanceof Arc) == false) goto L197;
            if (r143.f31202a.equals(r104) == false) goto L197;
            if (BaiduMap.B(this.f30768a).isEmpty() == false) goto L204;
            b(r111);     // Catch: Exception -> L229
            goto L197
        L204:
            Iterator r144 = BaiduMap.B(this.f30768a).iterator();     // Catch: Exception -> L229
        L206:
            if (r144.hasNext() == false) goto L197;
            ((OnArcClickListener) r144.next()).onArcClick((Arc) r143);     // Catch: Exception -> L229
            goto L206
        L361:
            return;
        L210:
            if (r102 != 90918) goto L349;
            if (r103 == null) goto L213;
            r104 = r103.optString("overlay_id");     // Catch: Exception -> L229
        L213:
            Iterator r145 = BaiduMap.H(this.f30768a).iterator();     // Catch: Exception -> L229
        L215:
            if (r145.hasNext() == false) goto L362;
            Overlay r146 = (Overlay) r145.next();     // Catch: Exception -> L229
            if ((r146 instanceof Polyline) == false) goto L215;
            if (r146.f31202a.equals(r104) == false) goto L215;
            if (BaiduMap.u(this.f30768a).isEmpty() == false) goto L222;
            b(r111);     // Catch: Exception -> L229
            goto L215
        L222:
            Iterator r147 = BaiduMap.u(this.f30768a).iterator();     // Catch: Exception -> L229
        L224:
            if (r147.hasNext() == false) goto L215;
            ((OnPolylineClickListener) r147.next()).onPolylineClick((Polyline) r146);     // Catch: Exception -> L229
            goto L224
        L362:
            return;
        L349:
            return;
        L30:
            if (BaiduMap.h(this.f30768a) == null) goto L345;
            MapPoi r148 = new MapPoi();     // Catch: Exception -> L229
            r148.a(r103);     // Catch: Exception -> L229
            BaiduMap.h(this.f30768a).onMapPoiClick(r148);     // Catch: Exception -> L229
            return;
        L345:
            return;
        L7:
            r103 = null;
            goto L9
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(GeoPoint r100) {
            if (BaiduMap.o(this.f30768a) != null) goto L5;
            return;
        L5:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L13;
            Point r101 = BaiduMap.k(this.f30768a).toScreenLocation(CoordUtil.mc2ll(r100));
            BaiduMap.o(this.f30768a).setPosition(BaiduMap.k(this.f30768a).fromScreenLocation(new Point(r101.x, r101.y - 60)));
            if (BaiduMap.p(this.f30768a) != null) goto L9;
            return;
        L9:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L15;
            BaiduMap.p(this.f30768a).onMarkerDrag(BaiduMap.o(this.f30768a));
            return;
        L15:
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d(GeoPoint r100) {
            if (BaiduMap.j(this.f30768a) == null) goto L6;
            LatLng r101 = CoordUtil.mc2ll(r100);
            BaiduMap.j(this.f30768a).onMapLongClick(r101);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void e(GeoPoint r100) {
            if (BaiduMap.o(this.f30768a) != null) goto L5;
            return;
        L5:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L14;
            Point r101 = BaiduMap.k(this.f30768a).toScreenLocation(CoordUtil.mc2ll(r100));
            BaiduMap.o(this.f30768a).setPosition(BaiduMap.k(this.f30768a).fromScreenLocation(new Point(r101.x, r101.y - 60)));
            if (BaiduMap.p(this.f30768a) != null) goto L9;
        L11:
            BaiduMap.a(this.f30768a, null);
            return;
        L9:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L11;
            BaiduMap.p(this.f30768a).onMarkerDragEnd(BaiduMap.o(this.f30768a));
            goto L11
        }

        @Override // com.baidu.platform.comapi.map.v
        public void f(GeoPoint r100) {
            if (BaiduMap.o(this.f30768a) != null) goto L5;
            return;
        L5:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L14;
            Point r101 = BaiduMap.k(this.f30768a).toScreenLocation(CoordUtil.mc2ll(r100));
            BaiduMap.o(this.f30768a).setPosition(BaiduMap.k(this.f30768a).fromScreenLocation(new Point(r101.x, r101.y - 60)));
            if (BaiduMap.p(this.f30768a) != null) goto L9;
        L11:
            BaiduMap.a(this.f30768a, null);
            return;
        L9:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L11;
            BaiduMap.p(this.f30768a).onMarkerDragEnd(BaiduMap.o(this.f30768a));
            goto L11
        }

        @Override // com.baidu.platform.comapi.map.v
        public void g(GeoPoint r100) {
            if (BaiduMap.o(this.f30768a) != null) goto L5;
            return;
        L5:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L13;
            Point r101 = BaiduMap.k(this.f30768a).toScreenLocation(CoordUtil.mc2ll(r100));
            BaiduMap.o(this.f30768a).setPosition(BaiduMap.k(this.f30768a).fromScreenLocation(new Point(r101.x, r101.y - 60)));
            if (BaiduMap.p(this.f30768a) != null) goto L9;
            return;
        L9:
            if (BaiduMap.o(this.f30768a).f31117o == false) goto L15;
            BaiduMap.p(this.f30768a).onMarkerDrag(BaiduMap.o(this.f30768a));
            return;
        L15:
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(BmDrawItem r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            Boolean r101 = Boolean.FALSE;
            Iterator r102 = BaiduMap.H(this.f30768a).iterator();
        L7:
            if (r102.hasNext() == false) goto L19;
            Overlay r103 = (Overlay) r102.next();
            if ((r103 instanceof Marker) == false) goto L7;
            if (r103.getName().equals(r100.getName()) == false) goto L7;
            Marker r104 = (Marker) r103;
            if (r104.f31117o == false) goto L19;
            BaiduMap.a(this.f30768a, r104);
            BaiduMap.o(this.f30768a).setAnimateType(0);
            Point r105 = BaiduMap.k(this.f30768a).toScreenLocation(BaiduMap.o(this.f30768a).f31109g);
            BaiduMap.o(this.f30768a).setPosition(BaiduMap.k(this.f30768a).fromScreenLocation(new Point(r105.x, r105.y - 60)));
            if (BaiduMap.p(this.f30768a) == null) goto L17;
            BaiduMap.p(this.f30768a).onMarkerDragStart(BaiduMap.o(this.f30768a));
        L17:
            r101 = Boolean.TRUE;
        L19:
            return r101.booleanValue();
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(s r100) {
            if (BaiduMap.d(this.f30768a) == null) goto L6;
            MapStatus r101 = MapStatus.a(r100);
            BaiduMap.d(this.f30768a).onMapStatusChange(r101);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(s r100) {
            int r101 = BaiduMap.mapStatusReason;
            if ((r101 & 256) != 256) goto L6;
            int r102 = 3;
        L10:
            if (BaiduMap.d(this.f30768a) == null) goto L13;
            MapStatus r103 = MapStatus.a(r100);
            BaiduMap.d(this.f30768a).onMapStatusChangeStart(r103);
            BaiduMap.d(this.f30768a).onMapStatusChangeStart(r103, r102);
        L13:
            if (BaiduMap.e(this.f30768a) == null) goto L15;
            BaiduMap.e(this.f30768a).onMapStatusChangeReason(r102);
        L15:
            BaiduMap.mapStatusReason = 0;
            return;
        L6:
            if ((r101 & 16) != 16) goto L8;
            r102 = 2;
            goto L10
        L8:
            r102 = 1;
            goto L10
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean r100) {
            if (BaiduMap.F(this.f30768a) == null) goto L10;
            if (r100 == false) goto L7;
            MapBaseIndoorMapInfo r101 = this.f30768a.getFocusedBaseIndoorMapInfo();
            BaiduMap.F(this.f30768a).onBaseIndoorMapMode(r100, r101);
            BaiduMap.b(this.f30768a, true);
            return;
        L7:
            if (BaiduMap.G(this.f30768a) == false) goto L12;
            BaiduMap.F(this.f30768a).onBaseIndoorMapMode(r100, null);
            BaiduMap.b(this.f30768a, false);
            return;
        L12:
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(GeoPoint r100) {
            if (BaiduMap.h(this.f30768a) == null) goto L6;
            LatLng r101 = CoordUtil.mc2ll(r100);
            BaiduMap.h(this.f30768a).onMapClick(r101);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(s r100) {
            MapStatus r101 = MapStatus.a(r100);
            if (BaiduMap.d(this.f30768a) == null) goto L6;
            BaiduMap.d(this.f30768a).onMapStatusChangeFinish(r101);
        L6:
            if (BaiduMap.f(this.f30768a) == null) goto L8;
            BaiduMap.f(this.f30768a).onMapStatusChangeFinish(r101);
        L8:
            BaiduMap.mapStatusReason = 0;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GeoPoint r100) {
            if (BaiduMap.i(this.f30768a) == null) goto L6;
            LatLng r101 = CoordUtil.mc2ll(r100);
            BaiduMap.mapStatusReason |= 1;
            BaiduMap.i(this.f30768a).onMapDoubleClick(r101);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(MotionEvent r100) {
            if (BaiduMap.g(this.f30768a) == null) goto L6;
            BaiduMap.g(this.f30768a).onTouch(r100);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GL10 r100, s r101) {
            if (BaiduMap.s(this.f30768a) == null) goto L15;
            if (BaiduMap.s(this.f30768a).values().isEmpty() == true) goto L15;
            Iterator r102 = BaiduMap.s(this.f30768a).values().iterator();
        L8:
            if (r102.hasNext() == false) goto L15;
            InfoWindow r103 = (InfoWindow) r102.next();
            if (r103 == null) goto L8;
            View r104 = r103.f30993c;
            if (r104 == null) goto L8;
            r104.post(new a(this, r103));
        L15:
            if (BaiduMap.E(this.f30768a) == null) goto L25;
            MapStatus r105 = MapStatus.a(r101);
            BaiduMap.E(this.f30768a).onMapDrawFrame(r105);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point r100, s r101) {
            MapStatus r102 = MapStatus.a(r101);
            if (BaiduMap.f(this.f30768a) == null) goto L6;
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.f(this.f30768a).onMapDoubleTouch(r100, r102);
        L6:
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean r100, int r101) {
            if (BaiduMap.I(this.f30768a) == null) goto L6;
            String r102 = BaiduMap.a(this.f30768a, r101);
            BaiduMap.I(this.f30768a).onMapRenderValidData(r100, r101, r102);
            return;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point r100, Point r101, s r102) {
            MapStatus r103 = MapStatus.a(r102);
            if (BaiduMap.f(this.f30768a) == null) goto L6;
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.f(this.f30768a).onMapTwoClick(r100, r101, r103);
        L6:
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean b(Point r100, Point r101, s r102) {
            MapStatus r103 = MapStatus.a(r102);
            if (BaiduMap.f(this.f30768a) == null) goto L6;
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.f(this.f30768a).onMapOverLooking(r100, r101, r103);
        L6:
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean c(Point r100, Point r101, s r102) {
            MapStatus r103 = MapStatus.a(r102);
            if (BaiduMap.f(this.f30768a) == null) goto L6;
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.f(this.f30768a).onMapScroll(r100, r101, r103);
        L6:
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean d(Point r100, Point r101, s r102) {
            MapStatus r103 = MapStatus.a(r102);
            if (BaiduMap.f(this.f30768a) == null) goto L6;
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.f(this.f30768a).onMapKneading(r100, r101, r103);
        L6:
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(MotionEvent r100, float r101, float r102, s r103) {
            MapStatus r104 = MapStatus.a(r103);
            if (BaiduMap.f(this.f30768a) == null) goto L6;
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.f(this.f30768a).onMapFling(r100, r101, r102, r104);
        L6:
            return false;
        }
    }

    public interface onMapGestureListener {
        boolean onMapDoubleTouch(Point r100, MapStatus r101);

        boolean onMapFling(MotionEvent r100, float r101, float r102, MapStatus r103);

        boolean onMapKneading(Point r100, Point r101, MapStatus r102);

        boolean onMapOverLooking(Point r100, Point r101, MapStatus r102);

        boolean onMapScroll(Point r100, Point r101, MapStatus r102);

        void onMapStatusChangeFinish(MapStatus r100);

        boolean onMapTwoClick(Point r100, Point r101, MapStatus r102);
    }

    public class p implements com.baidu.mapsdkplatform.comapi.map.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30771a;

        public p(BaiduMap r100) {
            this.f30771a = r100;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.h
        public Bundle a(int r100, int r101) {
            BaiduMap.C(this.f30771a).lock();
        L17:
            th = move-exception;
            BaiduMap.C(this.f30771a).unlock();
            throw th;
        L4:
            if (BaiduMap.D(this.f30771a) != null) goto L6;
            BaiduMap.C(this.f30771a).unlock();
            return null;
        L6:
            if (BaiduMap.J(this.f30771a) == null) goto L8;
            BaiduMap.J(this.f30771a).frameIndex(r100);     // Catch: Throwable -> L17
        L8:
            HeatMapData r102 = BaiduMap.D(this.f30771a).getData(r100, r101);     // Catch: Throwable -> L17
            if (r102 != null) goto L12;
            BaiduMap.C(this.f30771a).unlock();
            return null;
        L12:
            Bundle r103 = r102.toBundle();     // Catch: Throwable -> L17
            BaiduMap.C(this.f30771a).unlock();
            return r103;
        }
    }

    public class q implements com.baidu.mapsdkplatform.comapi.map.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30772a;

        public q(BaiduMap r100) {
            this.f30772a = r100;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.w
        public Bundle a(int r100, int r101, int r102, Context r103) {
            BaiduMap.K(this.f30772a).lock();
        L12:
            th = move-exception;
            BaiduMap.K(this.f30772a).unlock();
            throw th;
        L4:
            if (BaiduMap.L(this.f30772a) == null) goto L10;
            Tile r104 = BaiduMap.L(this.f30772a).a(r100, r101, r102);     // Catch: Throwable -> L12
            if (r104 == null) goto L10;
            Bundle r105 = r104.toBundle();     // Catch: Throwable -> L12
            BaiduMap.K(this.f30772a).unlock();
            return r105;
        L10:
            BaiduMap.K(this.f30772a).unlock();
            return null;
        }
    }

    public class r implements com.baidu.platform.comapi.bmsdk.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaiduMap f30773a;

        public r(BaiduMap r100) {
            this.f30773a = r100;
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem r100) {
            if ((r100 instanceof BmArc) == false) goto L9;
            BmArc r101 = (BmArc) r100;
            Iterator r102 = BaiduMap.B(this.f30773a).iterator();
        L6:
            if (r102.hasNext() == false) goto L99;
            ((OnArcClickListener) r102.next()).onArcClick(r101.c());
            goto L6
        L99:
            return;
        L9:
            if ((r100 instanceof BmBaseLine) == false) goto L15;
            BmBaseLine r103 = (BmBaseLine) r100;
            Iterator r104 = BaiduMap.u(this.f30773a).iterator();
        L12:
            if (r104.hasNext() == false) goto L100;
            ((OnPolylineClickListener) r104.next()).onPolylineClick(r103.d());
            goto L12
        L100:
            return;
        L15:
            if ((r100 instanceof BmCircle) == false) goto L21;
            BmCircle r105 = (BmCircle) r100;
            Circle r106 = r105.e();
            r106.f30821q = (int) r105.a();
            Iterator r107 = BaiduMap.y(this.f30773a).iterator();
        L18:
            if (r107.hasNext() == false) goto L101;
            ((OnCircleClickListener) r107.next()).onCircleClick(r105.e());
            goto L18
        L101:
            return;
        L21:
            if ((r100 instanceof BmPolygon) == false) goto L27;
            BmPolygon r108 = (BmPolygon) r100;
            Polygon r109 = r108.d();
            r109.f31230w = (int) r108.a();
            Iterator r110 = BaiduMap.x(this.f30773a).iterator();
        L24:
            if (r110.hasNext() == false) goto L102;
            ((OnPolygonClickListener) r110.next()).onPolygonClick(r108.d());
            goto L24
        L102:
            return;
        L27:
            if ((r100 instanceof BmIconMarker) == false) goto L53;
            BmIconMarker r111 = (BmIconMarker) r100;
            String r112 = r111.getName();
            Set r113 = BaiduMap.s(this.f30773a).keySet();
            if (r113.isEmpty() == false) goto L31;
        L44:
            Iterator r114 = BaiduMap.t(this.f30773a).iterator();
        L46:
            if (r114.hasNext() == false) goto L48;
            ((OnMarkerClickListener) r114.next()).onMarkerClick(r111.d());
            goto L46
        L48:
            Iterator r115 = BaiduMap.M(this.f30773a).iterator();
        L50:
            if (r115.hasNext() == false) goto L104;
            ((OnMarkerWithBaseUIClickListener) r115.next()).onMarkerClick(r111.d());
            goto L50
        L104:
            return;
        L31:
            if (r113.contains(r112) == false) goto L44;
            Iterator r116 = r113.iterator();
        L34:
            if (r116.hasNext() == false) goto L103;
            String r117 = (String) r116.next();
            if (r117 == null) goto L34;
            if (r117.equals(r112) == false) goto L34;
            InfoWindow r118 = (InfoWindow) BaiduMap.s(this.f30773a).get(r117);
            if (r118 == null) goto L79;
            InfoWindow.OnInfoWindowClickListener r119 = r118.f30998h;
            if (r119 == null) goto L96;
            r119.onInfoWindowClick();
            return;
        L96:
            return;
        L79:
            return;
        L103:
            return;
        L53:
            if ((r100 instanceof BmTextMarker) == false) goto L59;
            BmTextMarker r120 = (BmTextMarker) r100;
            Iterator r121 = BaiduMap.A(this.f30773a).iterator();
        L56:
            if (r121.hasNext() == false) goto L105;
            ((OnTextClickListener) r121.next()).onTextClick(r120.d());
            goto L56
        L105:
            return;
        L59:
            if ((r100 instanceof BmGround) == false) goto L65;
            BmGround r122 = (BmGround) r100;
            Iterator r123 = BaiduMap.z(this.f30773a).iterator();
        L62:
            if (r123.hasNext() == false) goto L106;
            ((OnGroundOverlayClickListener) r123.next()).onGroundOverlayClick(r122.c());
            goto L62
        L106:
            return;
        L65:
            if ((r100 instanceof BmPrism) == false) goto L71;
            BmPrism r124 = (BmPrism) r100;
            Iterator r125 = BaiduMap.N(this.f30773a).iterator();
        L68:
            if (r125.hasNext() == false) goto L107;
            ((OnPrismClickListener) r125.next()).onPrismOverlayClick(r124.d());
            goto L68
        L107:
            return;
        L71:
            if ((r100 instanceof BmMultiPoint) == false) goto L98;
            BmMultiPoint r126 = (BmMultiPoint) r100;
            int r127 = r126.d();
            MultiPoint r128 = r126.e();
            if (r128 != null) goto L75;
            return;
        L75:
            Iterator r129 = BaiduMap.v(this.f30773a).iterator();
        L77:
            if (r129.hasNext() == false) goto L108;
            ((OnMultiPointClickListener) r129.next()).onMultiPointClick(r126.e(), r128.getMultiPointItem(r127));
            goto L77
        L108:
            return;
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem r100, BmBaseUI r101) {
            if ((r100 instanceof BmIconMarker) == false) goto L13;
            BmIconMarker r102 = (BmIconMarker) r100;
            Iterator r103 = BaiduMap.M(this.f30773a).iterator();
        L6:
            if (r103.hasNext() == false) goto L24;
            OnMarkerWithBaseUIClickListener r104 = (OnMarkerWithBaseUIClickListener) r103.next();
            if (r102.d() == null) goto L6;
            if (r101 == null) goto L6;
            if (r101.a() == null) goto L6;
            r104.onMarkerClick(r102.d(), r101.a());
            goto L6
        L24:
            return;
        L13:
            boolean r105 = r100 instanceof Bm3DModel;
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem r100, PointF r101) {
            if ((r100 instanceof BmIconMarker) == false) goto L10;
            BmIconMarker r102 = (BmIconMarker) r100;
            if (r102.d() == null) goto L12;
            Iterator r103 = BaiduMap.O(this.f30773a).iterator();
        L8:
            if (r103.hasNext() == false) goto L13;
            ((OnMarkerClickWithPositionListener) r103.next()).onMarkerClick(r102.d(), r101);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    private String a(int r100) {
        if (r100 == 0) goto L21;
        switch(r100) {
            case 1004: goto L20;
            case 1005: goto L19;
            case 1006: goto L18;
            case 1007: goto L17;
            case 1008: goto L16;
            case 1009: goto L15;
            case 1010: goto L14;
            case 1011: goto L13;
            case 1012: goto L12;
            case 1013: goto L11;
            case 1014: goto L10;
            case 1015: goto L9;
            case 1016: goto L8;
            case 1017: goto L7;
            case 1018: goto L6;
            case 1019: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "SSL握手超时";
    L6:
        return "SSL握手错误";
    L7:
        return "网络写错误";
    L8:
        return "DNS解析超时";
    L9:
        return "DNS解析错误";
    L10:
        return "网络接收超时";
    L11:
        return "网络发送超时";
    L12:
        return "网络连接超时";
    L13:
        return "网络超时错误";
    L14:
        return "请求取消";
    L15:
        return "数据不一致";
    L16:
        return "当前网络类型有问题";
    L17:
        return "返回响应数据过大，数据溢出";
    L18:
        return "响应数据读取失败";
    L19:
        return "请求发送错误";
    L20:
        return "网络连接错误";
    L21:
        return "数据请求成功";
    }

    private void b() {
        this.f30741t0 = false;
        this.f30722k = new CopyOnWriteArrayList();
        this.f30724l = new CopyOnWriteArrayList();
        this.f30726m = new CopyOnWriteArrayList();
        this.R = new CopyOnWriteArrayList();
        this.f30711e0 = new ConcurrentHashMap();
        this.f30713f0 = new ConcurrentHashMap();
        this.f30728n = new CopyOnWriteArrayList();
        this.f30739s0 = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        j r100 = new j(this);
        this.X = r100;
        NetworkUtil.setNetworkUpdate2MapListener(r100);
        this.f30710e = new UiSettings(this.f30718i);
        this.f30734q = new k(this);
        this.f30730o = new l(this);
        this.f30736r = new m(this);
        n r101 = new n(this);
        this.f30718i.a(r101);
        o r102 = new o(this);
        this.f30718i.a(r102);
        p r103 = new p(this);
        this.f30718i.a(r103);
        q r104 = new q(this);
        this.f30718i.a(r104);
        this.f30731o0 = this.f30718i.V();
        this.f30733p0 = this.f30718i.H();
    }

    private synchronized void c() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
    L29:
        monitor-exit(this);
        return;
    L6:
        if (this.f30720j == null) goto L9;
        monitor-exit(this);
        return;
    L9:
        com.baidu.mapsdkplatform.comapi.map.r r100 = this.f30729n0;     // Catch: Throwable -> L31
        com.baidu.mapsdkplatform.comapi.map.r r101 = com.baidu.mapsdkplatform.comapi.map.r.f32196a;     // Catch: Throwable -> L31
        if (r100 == r101) goto L12;
    L15:
        com.baidu.mapsdkplatform.comapi.map.r r102 = com.baidu.mapsdkplatform.comapi.map.r.f32197b;     // Catch: Throwable -> L31
        if (r100 != r102) goto L22;
        if (this.f30714g != null) goto L22;
        monitor-exit(this);
        return;
    L22:
        if (this.f30718i == null) goto L29;
        BmLayer r103 = new BmLayer(true);     // Catch: Throwable -> L31
        this.f30720j = r103;     // Catch: Throwable -> L31
        r103.setLayerTag("DefaultBmLayer");     // Catch: Throwable -> L31
        com.baidu.mapsdkplatform.comapi.map.r r104 = this.f30729n0;     // Catch: Throwable -> L31
        if (r104 != r101) goto L26;
        this.f30712f.addBmLayer(this.f30720j);     // Catch: Throwable -> L31
    L28:
        this.f30718i.a(this.f30720j);     // Catch: Throwable -> L31
        this.f30720j.a(new r(this));     // Catch: Throwable -> L31
        this.f30732p = new a(this);     // Catch: Throwable -> L31
        goto L29
    L26:
        if (r104 != r102) goto L28;
        this.f30714g.addBmLayer(this.f30720j);     // Catch: Throwable -> L31
        goto L28
    L12:
        if (this.f30712f != null) goto L15;
        monitor-exit(this);
    }

    public void d() {
        this.f30741t0 = true;
        com.baidu.mapsdkplatform.comapi.map.z.c r100 = this.f30745v0;
        if (r100 == null) goto L5;
        r100.e();
        this.f30745v0 = null;
    L5:
        NetworkUtil.unregisterNetworkCallback();
        NetworkUtil.setNetworkUpdate2MapListener(null);
        hideInfoWindow();
        BmLayer r101 = this.f30720j;
        if (r101 == null) goto L13;
        r101.close();     // Catch: Exception -> L10
    L8:
        this.f30720j = null;
        return;
    }

    static {
        f30701a = "BaiduMap";
        f30702b = false;
        f30703c = false;
    }

    public boolean a() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    public final void clear() {
        if (this.f30741t0 == false) goto L5;
        return;
    L5:
        BmLayer r100 = this.f30720j;
        if (r100 == null) goto L14;
        r100.a();
        this.f30720j.b();
        Iterator<Overlay> r101 = this.f30722k.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        r101.next().mDrawItem.close();     // Catch: Exception -> L13
    L14:
        this.f30722k.clear();
        this.f30724l.clear();
        this.f30726m.clear();
        this.R.clear();
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 == null) goto L17;
        r102.t(false);
        this.f30718i.d();
    L17:
        hideInfoWindow();
        if (this.f30716h == null) goto L27;
        this.f30716h = null;
        return;
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L5;
        return null;
    L5:
        return a(r100.l());
    }

    public boolean getCustomTrafficColorEnable() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.m();
    }

    public final String getEnglishMapApprovalNumber() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.o();
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.p();
    }

    public final int getFontSizeLevel() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L5;
        return 1;
    L5:
        return r100.q();
    }

    public final String getMapApprovalNumber() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.u();
    }

    public final String getMapCopyrightInfo() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.v();
    }

    public MapLanguage getMapLanguage() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 == null) goto L7;
        int r101 = r100.x();
        return MapLanguage.values()[r101];
    L7:
        return MapLanguage.CHINESE;
    }

    public final String getMapMappingQualificationInfo() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.y();
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return MapStatus.a(r100.z());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.A();
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L6;
        return 1;
    L6:
        if (r100.M() == true) goto L10;
        return 3;
    L10:
        if (this.f30718i.Q() == false) goto L13;
        return 2;
    L13:
        return 1;
    }

    public final float getMaxZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.B();
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f32104e;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.C();
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.D();
    }

    public void hideInfoWindow() {
        Collection<InfoWindow> r100 = this.f30711e0.values();
        if (r100.isEmpty() == true) goto L22;
        Iterator<InfoWindow> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L22;
        InfoWindow r102 = r101.next();
        if (r102 == null) goto L6;
        View r103 = r102.f30993c;
        if (r103 == null) goto L6;
        int r104 = i.f30762b[this.f30729n0.ordinal()];
        if (r104 != 1) goto L14;
        TextureMapView r105 = this.f30725l0;
        if (r105 == null) goto L6;
        r105.removeView(r103);
        goto L6
    L14:
        if (r104 != 2) goto L6;
        MapView r106 = this.f30723k0;
        if (r106 == null) goto L6;
        r106.removeView(r103);
    L22:
        Iterator<Overlay> r107 = this.f30722k.iterator();
    L24:
        if (r107.hasNext() == false) goto L32;
        Overlay r108 = r107.next();
        Set<String> r109 = this.f30711e0.keySet();
        String r110 = r108.f31202a;
        if ((r108 instanceof Marker) == false) goto L24;
        if (r109.isEmpty() == true) goto L24;
        if (r109.contains(r110) == false) goto L24;
        r108.remove();
        goto L24
    L32:
        this.f30711e0.clear();
        this.f30713f0.clear();
        this.f30728n.clear();
    }

    public void hideSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.G();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.K();
    }

    public boolean isBaseIndoorMapMode() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.L();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.N();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.t();
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.j();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.S();
    }

    public void showSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.X();
    }

    public void startHeatMapFrameAnimation() {
        if (this.f30718i != null) goto L5;
        return;
    L5:
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", FaceService.neutralLabel, "1", null);
        this.f30718i.Y();
    }

    public void stopHeatMapFrameAnimation() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.Z();
    }

    public void updateBaseLayers() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.f30718i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.M() == false) goto L9;
        this.f30718i.a0();
        return;
    }

    private void e() {
        if (getMapLanguage() != MapLanguage.ENGLISH) goto L14;
        Context r100 = JNIInitializer.getCachedContext();
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f30718i == null) goto L21;
        this.f30718i.a(r100.getFilesDir().getAbsolutePath() + "/cfg/a/mode_1/englishmap.sty", "");
        AppBaseMap r101 = this.f30718i.i();
        if (r101 != null) goto L12;
        return;
    L12:
        r101.setCustomStyleEnable(true);
        return;
    L21:
        return;
    L14:
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 != null) goto L18;
        return;
    L18:
        if (r102.w() == true) goto L23;
        this.f30718i.s(false);
        return;
    }

    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.f30728n;
    }

    public MapSurfaceView getGLMapView() {
        return this.f30712f;
    }

    public OnHeatMapDrawFrameCallBack getHeatMapDrawFrameCallBack() {
        return this.V;
    }

    public boolean getIsSDKLayerBelowBmLayer() {
        return this.f30743u0;
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.f30719i0;
    }

    public final MyLocationData getLocationData() {
        return this.f30717h0;
    }

    public MapTextureView getMapTextureView() {
        return this.f30714g;
    }

    public NaviMapExpand getNaviMap() {
        return this.f30716h;
    }

    public final Projection getProjection() {
        return this.f30708d;
    }

    public final UiSettings getUiSettings() {
        return this.f30710e;
    }

    public MapSurfaceView getmGLMapView() {
        return this.f30712f;
    }

    public final boolean isShowMapPoi() {
        return this.f30731o0;
    }

    public static /* synthetic */ CopyOnWriteArrayList A(BaiduMap r100) {
        return r100.K;
    }

    public static /* synthetic */ CopyOnWriteArrayList B(BaiduMap r100) {
        return r100.L;
    }

    public static /* synthetic */ Lock C(BaiduMap r100) {
        return r100.f30706b0;
    }

    public static /* synthetic */ HeatMap D(BaiduMap r100) {
        return r100.Z;
    }

    public static /* synthetic */ OnMapDrawFrameCallback E(BaiduMap r100) {
        return r100.S;
    }

    public static /* synthetic */ OnBaseIndoorMapListener F(BaiduMap r100) {
        return r100.T;
    }

    public static /* synthetic */ boolean G(BaiduMap r100) {
        return r100.f30747w0;
    }

    public static /* synthetic */ List H(BaiduMap r100) {
        return r100.f30722k;
    }

    public static /* synthetic */ OnMapRenderValidDataListener I(BaiduMap r100) {
        return r100.U;
    }

    public static /* synthetic */ OnHeatMapDrawFrameCallBack J(BaiduMap r100) {
        return r100.V;
    }

    public static /* synthetic */ Lock K(BaiduMap r100) {
        return r100.f30709d0;
    }

    public static /* synthetic */ TileOverlay L(BaiduMap r100) {
        return r100.Y;
    }

    public static /* synthetic */ CopyOnWriteArrayList M(BaiduMap r100) {
        return r100.D;
    }

    public static /* synthetic */ CopyOnWriteArrayList N(BaiduMap r100) {
        return r100.M;
    }

    public static /* synthetic */ CopyOnWriteArrayList O(BaiduMap r100) {
        return r100.E;
    }

    public static /* synthetic */ BmLayer P(BaiduMap r100) {
        return r100.f30720j;
    }

    public static /* synthetic */ SnapshotReadyCallback Q(BaiduMap r100) {
        return r100.P;
    }

    public static /* synthetic */ List R(BaiduMap r100) {
        return r100.f30726m;
    }

    public static /* synthetic */ MapTextureView S(BaiduMap r100) {
        return r100.f30714g;
    }

    public static /* synthetic */ MapSurfaceView T(BaiduMap r100) {
        return r100.f30712f;
    }

    public static /* synthetic */ CopyOnWriteArrayList U(BaiduMap r100) {
        return r100.R;
    }

    public static /* synthetic */ List V(BaiduMap r100) {
        return r100.f30724l;
    }

    private final void a(MyLocationConfiguration r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L5;
        r101.g();
    L5:
        ArrayList r102 = new ArrayList();
        if (r100.isEnableCustom() == false) goto L25;
        if (r100.getArrow() == null) goto L15;
        Bitmap r103 = r100.getArrow().getBitmap();
        if (r103 == null) goto L15;
        if (r103.isRecycled() == true) goto L15;
        OverlayLocationData r104 = new OverlayLocationData();
        r104.setImage(r103);
        r104.setImgHeight(r103.getHeight());
        r104.setImgWidth(r103.getWidth());
        r104.setImgType("arrowicon");
        r104.setImgName("arrowicon_" + r103.hashCode());
        r104.setArrowSize(r100.getArrowSize());
        r104.setRotation(1);
        r102.add(r104);
    L15:
        if (r100.getCustomMarker() == null) goto L22;
        Bitmap r105 = r100.getCustomMarker().getBitmap();
        if (r105 == null) goto L22;
        if (r105.isRecycled() == true) goto L22;
        OverlayLocationData r106 = new OverlayLocationData();
        r106.setImage(r105);
        r106.setImgHeight(r105.getHeight());
        r106.setImgWidth(r105.getWidth());
        r106.setImgType("icon");
        r106.setImgName("icon_" + r105.hashCode());
        r106.setMarkerSize(r100.getMarkerSize());
        r106.setRotation(r100.isEnableRotation() ? 1 : 0);
        r106.setAnimation(r100.isNeedAnimation() ? 1 : 0);
        r102.add(r106);
    L22:
        if (r100.getGifMarker() == null) goto L32;
        OverlayLocationData r107 = new OverlayLocationData();
        r107.setImgType("gificon");
        r107.setImgName("gificon");
        r107.setGIFImgPath(r100.getGifMarker());
        r107.setMarkerSize(r100.getMarkerSize());
        r107.setRotation(r100.isEnableRotation() ? 1 : 0);
        r107.setAnimation(r100.isNeedAnimation() ? 1 : 0);
        r102.add(r107);
    L32:
        if (r102.size() <= 0) goto L37;
        com.baidu.mapsdkplatform.comapi.map.b r108 = this.f30718i;
        if (r108 == null) goto L38;
        r108.a(r102);
        return;
    L38:
        return;
    L37:
        return;
    L25:
        if (r100.getCustomMarker() == null) goto L32;
        Bitmap r109 = r100.getCustomMarker().getBitmap();
        if (r109 == null) goto L32;
        if (r109.isRecycled() == true) goto L32;
        OverlayLocationData r110 = new OverlayLocationData();
        r110.setImage(r109);
        r110.setImgHeight(r109.getHeight());
        r110.setImgWidth(r109.getWidth());
        r110.setImgName("icon");
        r110.setRotation(r100.enableDirection ? 1 : 0);
        r102.add(r110);
        goto L32
    }

    private void b(InfoWindow r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f30741t0 == true) goto L56;
        Set<InfoWindow> r101 = this.f30713f0.keySet();
        if (r101.isEmpty() == false) goto L9;
    L48:
        showInfoWindow(r100, false);
        return;
    L9:
        if (r101.contains(r100) == false) goto L48;
        View r102 = r100.f30993c;
        if (r102 != null) goto L14;
    L29:
        boolean r103 = true;
    L30:
        BitmapDescriptor r104 = a(r100);
        Marker r105 = this.f30713f0.get(r100);
        if (r105 != null) goto L33;
        return;
    L33:
        if (this.f30718i == null) goto L51;
        if (r103 == true) goto L36;
        return;
    L36:
        if (this.f30741t0 == false) goto L38;
        return;
    L38:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L40;
        r105.setPosition(r100.f30994d);
        r105.setYOffset(r100.f31000j);
        r105.setIcon(r104);
        return;
    L40:
        Bundle r106 = new Bundle();
        if (r100.f30992b == null) goto L46;
        r105.type = com.baidu.mapsdkplatform.comapi.map.d.f32142b;
        r105.f31110h = r104;
        if (r100.f30993c == null) goto L45;
        r106.putInt("draw_with_view", 1);
        goto L46
    L45:
        r106.putInt("draw_with_view", 0);
    L46:
        r105.f31109g = r100.f30994d;
        r105.f31122t = r100.f31000j;
        r105.a(r106);
        this.f30718i.l(r106);
        return;
    L51:
        return;
    L14:
        if (r100.f31004n == false) goto L29;
        r102.destroyDrawingCache();
        MapViewLayoutParams r107 = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(r100.f30994d).yOffset(r100.f31000j).build();
        int r108 = i.f30762b[this.f30729n0.ordinal()];
        if (r108 != 1) goto L18;
        TextureMapView r109 = this.f30725l0;
        if (r109 == null) goto L27;
        r109.addView(r102, r107);
        r102.setLayoutParams(r107);
    L27:
        if (r100.f31003m == false) goto L29;
        r103 = false;
        goto L30
    L18:
        if (r108 != 2) goto L27;
        MapView r110 = this.f30723k0;
        if (r110 == null) goto L27;
        r110.addView(r102, r107);
        goto L27
    }

    private void c(Overlay r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f30741t0 == true) goto L18;
        BmLayer r101 = this.f30720j;
        if (r101 == null) goto L20;
        BmDrawItem r102 = r100.mDrawItem;
        if (r102 == null) goto L19;
        r101.a(r102);
        r102.close();     // Catch: Exception -> L14
    L12:
        BmDrawItem r103 = r100.toDrawItem();
        this.f30720j.a(r103, r103.b());
        this.f30720j.b();
        return;
    L19:
        return;
    L20:
        return;
    }

    public static /* synthetic */ OnMapStatusChangeListener d(BaiduMap r100) {
        return r100.f30740t;
    }

    public static /* synthetic */ OnSynchronizationListener e(BaiduMap r100) {
        return r100.W;
    }

    public static /* synthetic */ onMapGestureListener f(BaiduMap r100) {
        return r100.f30744v;
    }

    public static /* synthetic */ OnMapTouchListener g(BaiduMap r100) {
        return r100.f30742u;
    }

    public static /* synthetic */ OnMapClickListener h(BaiduMap r100) {
        return r100.f30746w;
    }

    public static /* synthetic */ OnMapDoubleClickListener i(BaiduMap r100) {
        return r100.A;
    }

    public static /* synthetic */ OnMapLongClickListener j(BaiduMap r100) {
        return r100.B;
    }

    public static /* synthetic */ Projection k(BaiduMap r100) {
        return r100.f30708d;
    }

    public static /* synthetic */ Lock l(BaiduMap r100) {
        return r100.f30707c0;
    }

    public static /* synthetic */ OnMapLoadedCallback m(BaiduMap r100) {
        return r100.f30748x;
    }

    public static /* synthetic */ OnMapRenderCallback n(BaiduMap r100) {
        return r100.f30750z;
    }

    public static /* synthetic */ Marker o(BaiduMap r100) {
        return r100.f30715g0;
    }

    public static /* synthetic */ OnMarkerDragListener p(BaiduMap r100) {
        return r100.N;
    }

    public static /* synthetic */ OnMapTileLoadedCallback q(BaiduMap r100) {
        return r100.f30749y;
    }

    public static /* synthetic */ OnMyLocationClickListener r(BaiduMap r100) {
        return r100.O;
    }

    public static /* synthetic */ Map s(BaiduMap r100) {
        return r100.f30711e0;
    }

    public static /* synthetic */ CopyOnWriteArrayList t(BaiduMap r100) {
        return r100.C;
    }

    public static /* synthetic */ CopyOnWriteArrayList u(BaiduMap r100) {
        return r100.F;
    }

    public static /* synthetic */ CopyOnWriteArrayList v(BaiduMap r100) {
        return r100.G;
    }

    public static /* synthetic */ HexagonMap w(BaiduMap r100) {
        return r100.f30705a0;
    }

    public static /* synthetic */ CopyOnWriteArrayList x(BaiduMap r100) {
        return r100.I;
    }

    public static /* synthetic */ CopyOnWriteArrayList y(BaiduMap r100) {
        return r100.H;
    }

    public static /* synthetic */ CopyOnWriteArrayList z(BaiduMap r100) {
        return r100.f30704J;
    }

    public void addHeatMap(HeatMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f30718i == null) goto L30;
        this.f30706b0.lock();
        HeatMap r101 = this.Z;     // Catch: Throwable -> L24
        if (r100 != r101) goto L11;
        this.f30706b0.unlock();
        return;
    L11:
        if (r101 == null) goto L13;
        r101.a();     // Catch: Throwable -> L24
        this.Z.c();     // Catch: Throwable -> L24
        this.Z.C = null;     // Catch: Throwable -> L24
        this.f30718i.e();     // Catch: Throwable -> L24
    L13:
        this.Z = r100;     // Catch: Throwable -> L24
        r100.C = this;     // Catch: Throwable -> L24
        Bundle r102 = r100.toBundle();     // Catch: Throwable -> L24
        this.f30718i.o(true);     // Catch: Throwable -> L24
        this.f30718i.g(r102);     // Catch: Throwable -> L24
        HashMap r103 = new HashMap();     // Catch: Throwable -> L24
        HeatMap r104 = this.Z;     // Catch: Throwable -> L24
        if (r104 == null) goto L21;
        r103.put(FaceService.neutralLabel, Integer.valueOf(r104.getMaxHigh()));     // Catch: Throwable -> L24
        r103.put("I", Integer.valueOf(this.Z.isInitAnimation() ? 1 : 0));     // Catch: Throwable -> L24
        r103.put(FaceService.girlLabel, Integer.valueOf(this.Z.isFrameAnimation() ? 1 : 0));     // Catch: Throwable -> L24
    L21:
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", FaceService.neutralLabel, "0", r103);     // Catch: Throwable -> L24
        this.f30706b0.unlock();
        return;
    L24:
        th = move-exception;
        this.f30706b0.unlock();
        throw th;
    }

    public void addHexagonMap(HexagonMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f30718i == null) goto L12;
        this.f30707c0.lock();
        if (this.f30705a0 == null) goto L9;
        this.f30718i.f();
    L9:
        this.f30705a0 = r100;
        r100.hexagonMapLayerListener = this.f30734q;
        Bundle r101 = r100.toBundle();
        this.f30718i.p(true);
        this.f30718i.b(r101);
        this.f30707c0.unlock();
        return;
    }

    public final Overlay addOverlay(OverlayOptions r100) {
        if (r100 != null) goto L5;
    L57:
        return null;
    L5:
        if (this.f30741t0 == true) goto L57;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        c();
    L10:
        Overlay r101 = r100.getOverlay();
        if (r101 == null) goto L57;
        r101.listener = this.f30730o;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L36;
        if ((r101 instanceof Dot) == true) goto L36;
        a(r101);
        if ((r101 instanceof Marker) == false) goto L32;
        Marker r102 = (Marker) r101;
        r102.Q = this.f30736r;
        InfoWindowAdapter r103 = this.f30738s;
        if (r103 == null) goto L21;
        r102.X = r103;
    L21:
        ArrayList<BitmapDescriptor> r104 = r102.G;
        if (r104 != null) goto L24;
    L28:
        this.f30726m.add(r102);
        InfoWindow r105 = r102.P;
        if (r105 == null) goto L32;
        showInfoWindow(r105, false);
        goto L32
    L24:
        if (r104.size() == 0) goto L28;
        this.f30724l.add(r102);
        com.baidu.mapsdkplatform.comapi.map.b r106 = this.f30718i;
        if (r106 == null) goto L28;
        r106.t(true);
    L32:
        if ((r101 instanceof Building) == false) goto L34;
        CopyOnWriteArrayList<Building> r107 = this.R;
        r107.add((Building) r101);
    L34:
        return r101;
    L36:
        if ((r101 instanceof Marker) == false) goto L48;
        Marker r108 = (Marker) r101;
        r108.Q = this.f30736r;
        ArrayList<BitmapDescriptor> r109 = r108.G;
        if (r109 != null) goto L40;
    L44:
        this.f30726m.add(r108);
        InfoWindow r110 = r108.P;
        if (r110 == null) goto L50;
        showInfoWindow(r110, false);
    L50:
        Bundle r111 = new Bundle();
        r101.a(r111);
        if (this.f30718i != null) goto L53;
    L55:
        this.f30722k.add(r101);
        return r101;
    L53:
        if (this.f30741t0 == true) goto L55;
        this.f30718i.d(r111);
        goto L55
    L40:
        if (r109.size() == 0) goto L44;
        this.f30724l.add(r108);
        com.baidu.mapsdkplatform.comapi.map.b r112 = this.f30718i;
        if (r112 == null) goto L44;
        r112.t(true);
        goto L44
    L48:
        if ((r101 instanceof Building) == false) goto L50;
        CopyOnWriteArrayList<Building> r113 = this.R;
        r113.add((Building) r101);
        goto L50
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (this.f30741t0 == true) goto L78;
        ArrayList r100 = new ArrayList();
        int r101 = r110.size();
        if (OverlayUtil.isOverlayUpgrade() == false) goto L37;
        c();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L36;
        OverlayOptions r103 = (OverlayOptions) ListProtector.get(r110, r102);
        if (r103 == null) goto L35;
        Overlay r104 = r103.getOverlay();
        r104.listener = this.f30730o;
        if ((r104 instanceof Dot) == true) goto L35;
        if ((r104 instanceof Marker) == false) goto L32;
        Marker r105 = (Marker) r104;
        r105.Q = this.f30736r;
        InfoWindowAdapter r106 = this.f30738s;
        if (r106 == null) goto L21;
        r105.X = r106;
    L21:
        ArrayList<BitmapDescriptor> r107 = r105.G;
        if (r107 != null) goto L24;
    L28:
        this.f30726m.add(r105);
        InfoWindow r108 = r105.P;
        if (r108 == null) goto L32;
        showInfoWindow(r108, false);
        goto L32
    L24:
        if (r107.size() == 0) goto L28;
        this.f30724l.add(r105);
        com.baidu.mapsdkplatform.comapi.map.b r109 = this.f30718i;
        if (r109 == null) goto L28;
        r109.t(true);
    L32:
        if ((r104 instanceof Building) == false) goto L34;
        CopyOnWriteArrayList<Building> r111 = this.R;
        r111.add((Building) r104);
    L34:
        this.f30722k.add(r104);
        r100.add(r104);
        r104.setBmLayer(this.f30720j);
        BmDrawItem r112 = r104.toDrawItem();
        this.f30720j.a(r112, r112.b());
    L35:
        r102 = r102 + 1;
        goto L9
    L36:
        this.f30720j.b();
    L68:
        return r100;
    L37:
        Bundle[] r113 = new Bundle[r101];
        int r114 = 0;
    L38:
        if (r114 >= r101) goto L65;
        OverlayOptions r115 = (OverlayOptions) ListProtector.get(r110, r114);
        if (r115 == null) goto L64;
        Overlay r116 = r115.getOverlay();
        r116.listener = this.f30730o;
        if ((r116 instanceof Marker) == false) goto L58;
        Marker r117 = (Marker) r116;
        r117.Q = this.f30736r;
        InfoWindowAdapter r118 = this.f30738s;
        if (r118 == null) goto L47;
        r117.X = r118;
    L47:
        ArrayList<BitmapDescriptor> r119 = r117.G;
        if (r119 != null) goto L50;
    L54:
        this.f30726m.add(r117);
        InfoWindow r120 = r117.P;
        if (r120 == null) goto L58;
        showInfoWindow(r120, false);
        goto L58
    L50:
        if (r119.size() == 0) goto L54;
        this.f30724l.add(r117);
        com.baidu.mapsdkplatform.comapi.map.b r121 = this.f30718i;
        if (r121 == null) goto L54;
        r121.t(true);
    L58:
        if ((r116 instanceof Building) == false) goto L60;
        CopyOnWriteArrayList<Building> r122 = this.R;
        r122.add((Building) r116);
    L60:
        this.f30722k.add(r116);
        r100.add(r116);
        Bundle r123 = new Bundle();
        com.baidu.mapsdkplatform.comapi.map.b r124 = this.f30718i;
        if (r124 == null) goto L63;
        r124.c(r123);
        this.f30718i.a(r123);
    L63:
        r116.a(r123);
        r113[r114] = r123;
    L64:
        r114 = r114 + 1;
        goto L38
    L65:
        com.baidu.mapsdkplatform.comapi.map.b r125 = this.f30718i;
        if (r125 == null) goto L68;
        r125.a(r113);
        goto L68
    L78:
        return null;
    }

    public TileOverlay addTileLayer(TileOverlayOptions r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        TileOverlay r101 = this.Y;
        if (r101 == null) goto L8;
        r101.c();
        this.Y.f31466c = null;
    L8:
        HashMap r102 = new HashMap();
        r102.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(r100.datasource));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", ExifInterface.GPS_DIRECTION_TRUE, "0", r102);
        com.baidu.mapsdkplatform.comapi.map.b r103 = this.f30718i;
        if (r103 != null) goto L11;
    L14:
        return null;
    L11:
        if (r103.e(r100.a()) == false) goto L14;
        TileOverlay r104 = r100.a(this);
        this.Y = r104;
        return r104;
    }

    public final void animateMapStatus(MapStatusUpdate r100) {
        animateMapStatus(r100, 300);
    }

    public void changeLocationLayerOrder(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(r100);
    }

    public void cleanCache(int r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(r100);
    }

    public void closeParticleEffectByType(ParticleEffectType r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public boolean downloadMapStyle(String r100) {
        return this.f30718i.a(r100);
    }

    public List<Marker> getMarkersInBounds(LatLngBounds r100) {
        if (getMapStatus() != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        if (this.f30726m.size() != 0) goto L8;
        return null;
    L8:
        Iterator<Marker> r102 = this.f30726m.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Marker r103 = r102.next();
        if (r100.contains(r103.getPosition()) == false) goto L10;
        r101.add(r103);
        goto L10
    L14:
        return r101;
    }

    public LatLngBounds getOverlayLatLngBounds(OverlayOptions r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (this.f30718i == null) goto L10;
        Overlay r101 = r100.getOverlay();
        Bundle r102 = new Bundle();
        r101.a(r102);
        return this.f30718i.f(r102);
    L10:
        return null;
    }

    public boolean getPoiTagEnable(PoiTagType r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.a(r100);
    }

    public void hideInfoWindow(InfoWindow r100) {
        Set<InfoWindow> r101 = this.f30713f0.keySet();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return;
    L7:
        if (r101.contains(r100) == false) goto L29;
        View r102 = r100.f30993c;
        if (r102 == null) goto L22;
        int r103 = i.f30762b[this.f30729n0.ordinal()];
        if (r103 != 1) goto L14;
        TextureMapView r104 = this.f30725l0;
        if (r104 == null) goto L22;
        r104.removeView(r102);
        goto L22
    L14:
        if (r103 != 2) goto L22;
        MapView r105 = this.f30723k0;
        if (r105 == null) goto L22;
        r105.removeView(r102);
    L22:
        Marker r106 = this.f30713f0.get(r100);
        if (r106 == null) goto L25;
        r106.remove();
        this.f30711e0.remove(r106.f31202a);
    L25:
        this.f30713f0.remove(r100);
        this.f30728n.remove(r100);
        return;
    }

    public final void mapRefresh(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        MapTaskManager.postToMainThread(new h(this), r100);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.IAdvPermissionUpdateListener
    public void onAdvPermissionUpdate(int r100) {
        if (MapLanguageRecord.newInstance().getMapLanguage() == MapLanguage.ENGLISH) goto L5;
    L7:
        MapSDKAdvancedPermission.getInstance().removeListener(this);
        return;
    L5:
        if (PermissionUtils.getInstance().isEnglishMapAuthorized() == true) goto L7;
        setMapLanguage(MapLanguage.CHINESE, true);
        goto L7
    }

    public final void removeMarkerClickListener(OnMarkerClickListener r100) {
        if (this.C.contains(r100) == false) goto L6;
        this.C.remove(r100);
        return;
    }

    public final void removeMarkerClickWithPositionListener(OnMarkerClickWithPositionListener r100) {
        this.E.remove(r100);
    }

    public final void removeMarkerWithBaseUIClickListener(OnMarkerWithBaseUIClickListener r100) {
        if (this.D.contains(r100) == false) goto L6;
        this.D.remove(r100);
        return;
    }

    public void removeOverLays(List<Overlay> r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (this.f30741t0 == true) goto L73;
        ArrayList r100 = new ArrayList();
        int r101 = r110.size();
        int r102 = r101 / 400;
        int r103 = 0;
    L8:
        if (r103 >= (r102 + 1)) goto L56;
        int r104 = 0;
    L11:
        if (r104 >= 400) goto L48;
        int r105 = (r103 * 400) + r104;
        if (r105 >= r101) goto L48;
        if (this.f30741t0 == true) goto L16;
        Overlay r106 = (Overlay) ListProtector.get(r110, r105);
        if (r106 == null) goto L46;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L23;
        b(r106);
    L27:
        List<Marker> r107 = this.f30726m;
        if (r107 != null) goto L30;
    L32:
        CopyOnWriteArrayList<Building> r108 = this.R;
        if (r108 == null) goto L38;
        if (r108.contains(r106) == false) goto L38;
        this.R.remove(r106);
    L38:
        if (this.f30724l.contains(r106) == false) goto L46;
        Marker r109 = (Marker) r106;
        if (r109.G == null) goto L46;
        this.f30724l.remove(r109);
        if (this.f30724l.size() != 0) goto L46;
        com.baidu.mapsdkplatform.comapi.map.b r111 = this.f30718i;
        if (r111 == null) goto L46;
        r111.t(false);
        goto L46
    L30:
        if (r107.contains(r106) == false) goto L32;
        this.f30726m.remove(r106);
        goto L32
    L23:
        Bundle r112 = r106.a();
        com.baidu.mapsdkplatform.comapi.map.b r113 = this.f30718i;
        if (r113 == null) goto L26;
        r113.c(r112);
    L26:
        r100.add(r112);
    L46:
        r104 = r104 + 1;
        goto L11
    L16:
        return;
    L48:
        if (this.f30718i == null) goto L55;
        if (r100.isEmpty() == true) goto L55;
        int r114 = r100.size();
        Bundle[] r115 = new Bundle[r114];
        int r116 = 0;
    L52:
        if (r116 >= r114) goto L54;
        r115[r116] = (Bundle) ListProtector.get(r100, r116);
        r116 = r116 + 1;
        goto L52
    L54:
        this.f30718i.b(r115);
    L55:
        r103 = r103 + 1;
        goto L8
    L56:
        this.f30722k.removeAll(r110);
        return;
    }

    public final void removePrismClickListener(OnPrismClickListener r100) {
        if (this.M.contains(r100) == false) goto L6;
        this.M.remove(r100);
        return;
    }

    public final void setBaiduHeatMapEnabled(boolean r100) {
        if (this.f30718i == null) goto L6;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", FaceService.neutralLabel, "0", null);
        this.f30718i.d(r100);
        return;
    }

    public final void setBuildingsEnabled(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void setCompassEnable(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.c(r100);
    }

    public void setCompassIcon(Bitmap r100) {
        if (r100 == null) goto L9;
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L6;
        return;
    L6:
        r101.a(r100);
        return;
    L9:
        throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
    }

    public void setCompassPosition(Point r100) {
        if (this.f30718i != null) goto L5;
        return;
    L5:
        Point r101 = new Point(r100.x, r100.y);
        if (this.f30718i.a(r101) == false) goto L9;
        this.f30739s0 = r100;
        return;
    }

    public void setCustomTrafficColorEnable(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.g(r100);
    }

    public void setDEMEnable(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    public void setDotPoiShowEnable(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.i(r100);
    }

    public final void setFontSizeLevel(int r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public void setHeatMapFrameAnimationIndex(int r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.d(r100);
    }

    public final void setIndoorEnable(boolean r100) {
        if (this.f30718i == null) goto L5;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3", null);
        this.f30735q0 = r100;
        this.f30718i.E(r100);
    L5:
        OnBaseIndoorMapListener r101 = this.T;
        if (r101 == null) goto L10;
        if (r100 == true) goto L11;
        r101.onBaseIndoorMapMode(false, null);
        return;
    L11:
        return;
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter r100) {
        this.f30738s = r100;
    }

    public void setMapBackgroundColor(int r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.b(r100);
    }

    public void setMapBackgroundImage(BitmapDescriptor r100) {
        if (this.f30718i != null) goto L6;
        return;
    L6:
        if (r100 != null) goto L9;
        Bundle r101 = new Bundle();
        r101.putInt(BasicTestActionHandler.TEST_ACTION_RESET, 1);
        this.f30718i.j(r101);
        return;
    L9:
        if (r100.getBitmap().getByteCount() <= 10240000) goto L11;
        return;
    L11:
        Bundle r102 = r100.a();
        r102.putInt(BasicTestActionHandler.TEST_ACTION_RESET, 0);
        this.f30718i.j(r102);
    }

    public final void setMapLanguage(MapLanguage r100) {
        if (MapLanguageRecord.newInstance().getMapLanguage() == r100) goto L5;
        boolean r101 = true;
    L6:
        setMapLanguage(r100, r101);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setMapStatus(MapStatusUpdate r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        s r101 = a(r100);
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 != null) goto L7;
        return;
    L7:
        mapStatusReason |= 256;
        r102.a(r101);
        OnMapStatusChangeListener r103 = this.f30740t;
        if (r103 == null) goto L11;
        r103.onMapStatusChange(getMapStatus());
        return;
    }

    public final void setMapStatusLimits(LatLngBounds r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(r100, true);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(r100));
    }

    public final void setMapType(int r100) {
        if (this.f30718i != null) goto L5;
        return;
    L5:
        HashMap r101 = new HashMap();
        r101.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(r100));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "4", r101);
        if (r100 != 1) goto L8;
        this.f30718i.y(false);
        this.f30718i.I(this.f30731o0);
        this.f30718i.F(this.f30733p0);
        this.f30718i.e(true);
        this.f30718i.E(this.f30735q0);
    L22:
        if (OpenLogUtil.isMapLogEnable() == false) goto L25;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap setMapType type = " + r100);
        return;
    L25:
        return;
    L8:
        if (r100 != 2) goto L10;
        this.f30718i.y(true);
        this.f30718i.I(this.f30731o0);
        this.f30718i.F(this.f30733p0);
        this.f30718i.e(true);
        goto L22
    L10:
        if (r100 != 3) goto L22;
        if (this.f30718i.V() == false) goto L16;
        this.f30718i.I(false);
    L16:
        if (this.f30718i.H() == false) goto L18;
        this.f30718i.F(false);
    L18:
        this.f30718i.e(false);
        this.f30718i.E(false);
        goto L22
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration r100) {
        setMyLocationConfiguration(r100);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration r100) {
        this.f30719i0 = r100;
        a(this.f30717h0, r100);
        a(this.f30719i0);
        if (r100 != null) goto L5;
        return;
    L5:
        if (isMyLocationEnabled() == false) goto L11;
        OnLocationModeChangeListener r101 = this.f30721j0;
        if (r101 == null) goto L12;
        r101.onLocationModeChange(r100.locationMode);
        return;
    L12:
        return;
    }

    public final void setMyLocationData(MyLocationData r100) {
        this.f30717h0 = r100;
        if (this.f30719i0 != null) goto L5;
        this.f30719i0 = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
    L5:
        a(r100, this.f30719i0);
    }

    public final void setMyLocationEnabled(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.r(r100);
        return;
    }

    public final void setOn3DBuildingListener(Building3DListener r100) {
        this.Q = r100;
    }

    public final void setOnArcClickListener(OnArcClickListener r100) {
        if (r100 == null) goto L5;
        this.L.add(r100);
        return;
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener r100) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.2", null);
        this.T = r100;
    }

    public final void setOnCircleClickListener(OnCircleClickListener r100) {
        if (r100 == null) goto L5;
        this.H.add(r100);
        return;
    }

    public void setOnFirstFrameDrawListener(OnFirstFrameDrawListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        MapSurfaceView r101 = this.f30712f;
        if (r101 == null) goto L7;
        r101.setFirstFrameDrawListener(new f(this, r100));
    L7:
        MapTextureView r102 = this.f30714g;
        if (r102 == null) goto L11;
        r102.setFirstFrameDrawListener(new g(this, r100));
        return;
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener r100) {
        if (r100 == null) goto L5;
        this.f30704J.add(r100);
        return;
    }

    public void setOnHeatMapDrawFrameCallBack(OnHeatMapDrawFrameCallBack r100) {
        this.V = r100;
    }

    public final void setOnLocationModeChangeListener(OnLocationModeChangeListener r100) {
        this.f30721j0 = r100;
    }

    public final void setOnMapClickListener(OnMapClickListener r100) {
        this.f30746w = r100;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener r100) {
        this.A = r100;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback r100) {
        this.S = r100;
    }

    public final void setOnMapGestureListener(onMapGestureListener r100) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "GD", "0", null);
        this.f30744v = r100;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback r100) {
        this.f30748x = r100;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener r100) {
        this.B = r100;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback r100) {
        this.f30750z = r100;
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener r100) {
        this.U = r100;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener r100) {
        this.f30740t = r100;
    }

    public void setOnMapTileLoadedCallback(OnMapTileLoadedCallback r100) {
        this.f30749y = r100;
    }

    public final void setOnMapTouchListener(OnMapTouchListener r100) {
        this.f30742u = r100;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.C.contains(r100) == true) goto L8;
        this.C.add(r100);
        return;
    }

    public final void setOnMarkerClickWithPositionListener(OnMarkerClickWithPositionListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.E.contains(r100) == true) goto L8;
        this.E.add(r100);
        return;
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener r100) {
        this.N = r100;
    }

    public final void setOnMarkerWithBaseUIClickListener(OnMarkerWithBaseUIClickListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.D.contains(r100) == true) goto L8;
        this.D.add(r100);
        return;
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener r100) {
        if (r100 == null) goto L5;
        this.G.add(r100);
        return;
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener r100) {
        this.O = r100;
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener r100) {
        if (r100 == null) goto L5;
        this.I.add(r100);
        return;
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener r100) {
        if (r100 == null) goto L5;
        this.F.add(r100);
        return;
    }

    public final void setOnPrismClickListener(OnPrismClickListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.M.contains(r100) == true) goto L8;
        this.M.add(r100);
        return;
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener r100) {
        this.W = r100;
    }

    public final void setOnTextClickListener(OnTextClickListener r100) {
        if (r100 == null) goto L5;
        this.K.add(r100);
        return;
    }

    public void setOverlayUnderPoi(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.u(r100);
    }

    public void setPixelFormatTransparent(boolean r100) {
        MapSurfaceView r101 = this.f30712f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.setPixelFormatTransparent(true);
        return;
    L7:
        r101.setPixelFormatTransparent(false);
    }

    public final void setTrafficEnabled(boolean r100) {
        if (this.f30718i == null) goto L6;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "1", null);
        this.f30718i.A(r100);
        return;
    }

    public void showInfoWindow(InfoWindow r100) {
        showInfoWindow(r100, true);
    }

    public void showInfoWindows(List<InfoWindow> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L12;
        Iterator<InfoWindow> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        showInfoWindow(r101.next(), false);
        goto L8
    L13:
        return;
    }

    public final void showMapIndoorPoi(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.F(r100);
        this.f30733p0 = r100;
        return;
    }

    public final void showMapPoi(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.I(r100);
        this.f30731o0 = r100;
        return;
    }

    public void showOperateLayer(boolean r100) {
        if (this.f30718i != null) goto L5;
        return;
    L5:
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "2", null);
        this.f30718i.G(r100);
    }

    public void showOperatePoiLayer(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.H(r100);
    }

    public boolean showParticleEffectByType(ParticleEffectType r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.b(r100);
    }

    public void showTrafficUGCMap(boolean r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 == null) goto L6;
        r101.J(r100);
        return;
    }

    public final void snapshot(SnapshotReadyCallback r100) {
        this.P = r100;
        int r101 = i.f30762b[this.f30729n0.ordinal()];
        if (r101 != 1) goto L5;
        MapTextureView r102 = this.f30714g;
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.getController() == null) goto L22;
        Rect r103 = new Rect(0, 0, this.f30714g.getController().getScreenWidth(), this.f30714g.getController().getScreenHeight());
        this.f30714g.doCaptureMapView(new b(this), r103, Bitmap.Config.ARGB_8888);
        this.f30714g.requestRender();
        return;
    L22:
        return;
    L5:
        if (r101 != 2) goto L23;
        MapSurfaceView r104 = this.f30712f;
        if (r104 != null) goto L10;
        return;
    L10:
        if (r104.getController() == null) goto L19;
        Rect r105 = new Rect(0, 0, this.f30712f.getController().getScreenWidth(), this.f30712f.getController().getScreenHeight());
        this.f30712f.doCaptureMapView(new c(this), r105, Bitmap.Config.ARGB_8888);
        this.f30712f.requestRender();
        return;
    L19:
        return;
    }

    public boolean switchOverlayLayerAndNavigationLayer(boolean r100) {
        if (this.f30718i != null) goto L6;
        return false;
    L6:
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "4", null);
        return this.f30718i.K(r100);
    }

    public void updateHeatMap(HeatMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f30718i == null) goto L16;
        this.f30706b0.lock();
        this.Z = r100;     // Catch: Throwable -> L10
        r100.C = this;     // Catch: Throwable -> L10
        Bundle r101 = r100.toBundle();     // Catch: Throwable -> L10
        this.f30718i.k(r101);     // Catch: Throwable -> L10
        this.f30706b0.unlock();
        return;
    L10:
        th = move-exception;
        this.f30706b0.unlock();
        throw th;
    }

    private Point a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return null;
    L6:
        String[] r111 = r110.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",");
        int r100 = r111.length;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r101 >= r100) goto L16;
        String[] r104 = r111[r101].replaceAll("\"", "").split(":");
        if ("x".equals(r104[0]) == false) goto L12;
        r102 = CastIntegerProtector.valueOf(r104[1]).intValue();
    L12:
        if ("y".equals(r104[0]) == false) goto L14;
        r103 = CastIntegerProtector.valueOf(r104[1]).intValue();
    L14:
        r101 = r101 + 1;
        goto L7
    L16:
        return new Point(r102, r103);
    }

    private void b(Overlay r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f30741t0 == true) goto L17;
        BmLayer r101 = this.f30720j;
        if (r101 == null) goto L19;
        BmDrawItem r102 = r100.mDrawItem;
        if (r102 == null) goto L18;
        r101.a(r102);
        this.f30720j.b();
        r102.close();     // Catch: Exception -> L13
        return;
    L20:
        return;
    L18:
        return;
    L19:
        return;
    }

    public static /* synthetic */ Building3DListener c(BaiduMap r100) {
        return r100.Q;
    }

    public static /* synthetic */ com.baidu.mapsdkplatform.comapi.map.b b(BaiduMap r100) {
        return r100.f30718i;
    }

    public void a(HeatMap r100) {
        this.f30706b0.lock();
        HeatMap r101 = this.Z;     // Catch: Throwable -> L11
        if (r101 != null) goto L6;
    L9:
        this.f30706b0.unlock();
        return;
    L6:
        if (this.f30718i == null) goto L9;
        if (r100 != r101) goto L9;
        r101.a();     // Catch: Throwable -> L11
        this.Z.c();     // Catch: Throwable -> L11
        this.Z.C = null;     // Catch: Throwable -> L11
        this.f30718i.e();     // Catch: Throwable -> L11
        this.Z = null;     // Catch: Throwable -> L11
        this.f30718i.o(false);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f30706b0.unlock();
        throw th;
    }

    private Overlay a(Overlay r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (this.f30741t0 == false) goto L6;
        return null;
    L6:
        if (this.f30720j != null) goto L8;
        return null;
    L8:
        if (this.f30718i == null) goto L16;
        this.f30722k.add(r100);
        r100.setBmLayer(this.f30720j);
        BmDrawItem r101 = r100.toDrawItem();
        this.f30720j.a(r101, r101.b());
        this.f30720j.b();
        return r100;
    L16:
        return null;
    }

    public void a(TileOverlay r100) {
        this.f30709d0.lock();
        if (r100 != null) goto L15;
    L13:
        this.Y = null;
        this.f30709d0.unlock();
        return;
    L15:
    L10:
        th = move-exception;
        this.Y = null;
        this.f30709d0.unlock();
        throw th;
    L5:
        if (this.Y != r100) goto L13;
        r100.c();     // Catch: Throwable -> L10
        r100.f31466c = null;     // Catch: Throwable -> L10
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;     // Catch: Throwable -> L10
        if (r101 == null) goto L13;
        r101.W();     // Catch: Throwable -> L10
        goto L13
    }

    private BitmapDescriptor a(InfoWindow r100) {
        View r101 = r100.f30993c;
        if (r101 == null) goto L14;
        if (r100.f31004n == false) goto L14;
        if (r100.f31001k == false) goto L16;
        if (r100.f31002l > 0) goto L15;
        r100.f31002l = SysOSUtil.getDensityDpi();
    L15:
        return BitmapDescriptorFactory.fromViewWithDpi(r100.f30993c, r100.f31002l);
    L16:
        return BitmapDescriptorFactory.fromView(r101);
    L14:
        return r100.f30992b;
    }

    private s a(MapStatusUpdate r100) {
        com.baidu.mapsdkplatform.comapi.map.b r101 = this.f30718i;
        if (r101 != null) goto L5;
        return null;
    L5:
        s r102 = r101.z();
        MapStatus r103 = r100.a(this.f30718i, getMapStatus());
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.b(r102);
    }

    public static /* synthetic */ boolean a(BaiduMap r100) {
        return r100.f30741t0;
    }

    private final void a(MyLocationData r210, MyLocationConfiguration r211) {
        if (r210 == null) goto L49;
        if (r211 != null) goto L6;
        return;
    L6:
        if (isMyLocationEnabled() == false) goto L52;
        JSONObject r110 = new JSONObject();
        JSONArray r111 = new JSONArray();
        JSONObject r112 = new JSONObject();
        JSONObject r113 = new JSONObject();
        LatLng r114 = new LatLng(r210.latitude, r210.longitude);
        GeoPoint r100 = CoordUtil.ll2mc(r114);
        r110.put("type", 0);     // Catch: JSONException -> L34
        r112.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, r100.getLongitudeE6());     // Catch: JSONException -> L34
        r112.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, r100.getLatitudeE6());     // Catch: JSONException -> L34
        r112.put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(r114, (int) r210.accuracy));     // Catch: JSONException -> L34
        float r101 = r210.direction;     // Catch: JSONException -> L34
        if (r211.enableDirection == false) goto L17;
        float r102 = r101 % 360.0f;     // Catch: JSONException -> L34
        if (r102 <= 180.0f) goto L15;
        r102 = r102 - 360.0f;     // Catch: JSONException -> L34
    L18:
        r112.put("direction", r102);     // Catch: JSONException -> L34
        r112.put("iconarrownor", "NormalLocArrow");     // Catch: JSONException -> L34
        if (r211.isEnableCustom() == false) goto L22;
    L23:
        r112.put("iconarrowfoc", "FocusLocArrow");     // Catch: JSONException -> L34
        r112.put("lineid", r211.accuracyCircleStrokeColor);     // Catch: JSONException -> L34
        r112.put("areaid", r211.accuracyCircleFillColor);     // Catch: JSONException -> L34
        r112.put("width", r211.width);     // Catch: JSONException -> L34
        r111.put(r112);     // Catch: JSONException -> L34
        if (r211.locationMode != MyLocationConfiguration.LocationMode.COMPASS) goto L32;
        r113.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, r100.getLongitudeE6());     // Catch: JSONException -> L34
        r113.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, r100.getLatitudeE6());     // Catch: JSONException -> L34
        r113.put("radius", 0);     // Catch: JSONException -> L34
        r113.put("direction", 0);     // Catch: JSONException -> L34
        r113.put("iconarrownor", "direction_wheel");     // Catch: JSONException -> L34
        r113.put("iconarrowfoc", "direction_wheel");     // Catch: JSONException -> L34
        r113.put("iconarrownorid", 54);     // Catch: JSONException -> L34
        r113.put("iconarrowfocid", 54);     // Catch: JSONException -> L34
        r111.put(r113);     // Catch: JSONException -> L34
    L32:
        r110.put("data", r111);     // Catch: JSONException -> L34
    L36:
        com.baidu.mapsdkplatform.comapi.map.b r103 = this.f30718i;
        if (r103 == null) goto L39;
        r103.a(r110.toString(), null);
    L39:
        int r104 = i.f30761a[r211.locationMode.ordinal()];
        if (r104 != 1) goto L42;
        animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(r210.direction).overlook(-45.0f).target(new LatLng(r210.latitude, r210.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
        return;
    L42:
        if (r104 != 2) goto L53;
        animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(r210.latitude, r210.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
        return;
    L53:
        return;
    L22:
        r112.put("iconarrownorid", 28);     // Catch: JSONException -> L34
        r112.put("iconarrowfocid", 29);     // Catch: JSONException -> L34
        goto L23
    L15:
        if (r102 >= (-180.0f)) goto L18;
        r102 = r102 + 360.0f;     // Catch: JSONException -> L34
        goto L18
    L17:
        r102 = -1001.0f;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L52:
        return;
    }

    public static /* synthetic */ boolean b(BaiduMap r100, boolean r101) {
        r100.f30747w0 = r101;
        return r101;
    }

    public final TraceOverlay addTraceOverlay(TraceOptions r100, TraceAnimationListener r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "TO", "0", null);
        com.baidu.mapsdkplatform.comapi.map.z.c r102 = this.f30745v0;
        if (r102 != null) goto L8;
    L9:
        com.baidu.mapsdkplatform.comapi.map.r r103 = this.f30729n0;
        if (r103 != com.baidu.mapsdkplatform.comapi.map.r.f32196a) goto L13;
        this.f30745v0 = new com.baidu.mapsdkplatform.comapi.map.z.c(this.f30712f);
    L15:
        this.f30745v0.c();
        this.f30718i.a(this.f30745v0.b());
    L16:
        this.f30745v0.a(r101);
        return this.f30745v0.a(r100);
    L13:
        if (r103 != com.baidu.mapsdkplatform.comapi.map.r.f32197b) goto L18;
        this.f30745v0 = new com.baidu.mapsdkplatform.comapi.map.z.c(this.f30714g);
        goto L15
    L18:
        return null;
    L8:
        if (r102.d() == false) goto L16;
        goto L9
    }

    public final void animateMapStatus(MapStatusUpdate r100, int r101) {
        if (r100 == null) goto L13;
        if (r101 < 0) goto L15;
        s r102 = a(r100);
        com.baidu.mapsdkplatform.comapi.map.b r103 = this.f30718i;
        if (r103 != null) goto L8;
        return;
    L8:
        mapStatusReason |= 256;
        if (this.f30737r0 == true) goto L11;
        r103.a(r102);
        return;
    L11:
        r103.a(r102, r101);
        return;
    L15:
        return;
    }

    public boolean customParticleEffectByType(ParticleEffectType r100, ParticleOptions r101) {
        if (this.f30718i == null) goto L19;
        Bundle r102 = new Bundle();
        if (r101 == null) goto L18;
        if (r101.getParticleImgs() == null) goto L15;
        int r103 = r101.getParticleImgs().size();
        r102.putInt("total", r103);
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        if (ListProtector.get(r101.getParticleImgs(), r104) == null) goto L13;
        r102.putBundle(String.format("texture_%d", new Object[]{Integer.valueOf(r104)}), ((BitmapDescriptor) ListProtector.get(r101.getParticleImgs(), r104)).a());
    L13:
        r104 = r104 + 1;
    L15:
        if (r101.getParticlePos() == null) goto L18;
        GeoPoint r105 = CoordUtil.ll2mc(r101.getParticlePos());
        r102.putDouble("location_x", r105.getLongitudeE6());
        r102.putDouble("location_y", r105.getLatitudeE6());
    L18:
        return this.f30718i.a(r100, r102);
    L19:
        return false;
    }

    public void setLayerClickable(MapLayer r100, boolean r101) {
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.a(r100, r101);
    }

    public final void setMapLanguage(MapLanguage r100, boolean r101) {
        MapLanguage r102 = MapLanguage.ENGLISH;
        boolean r103 = true;
        if (r100 == r102) goto L5;
    L18:
        com.baidu.mapsdkplatform.comapi.map.b r104 = this.f30718i;
        if (r104 == null) goto L39;
        r104.a(r100.ordinal(), r101);
        if (r100 != r102) goto L24;
        r103 = false;
    L24:
        showOperatePoiLayer(r103);
        com.baidu.mapsdkplatform.comapi.map.r r105 = this.f30729n0;
        if (r105 != com.baidu.mapsdkplatform.comapi.map.r.f32196a) goto L32;
        MapView r106 = this.f30723k0;
        if (r106 == null) goto L32;
        MapSurfaceView r107 = this.f30712f;
        if (r107 == null) goto L32;
        r106.updateScaleUI(r107.getZoomLevel());
    L38:
        MapLanguageRecord.newInstance().setMapLanguage(r100);
    L32:
        if (r105 != com.baidu.mapsdkplatform.comapi.map.r.f32197b) goto L38;
        TextureMapView r108 = this.f30725l0;
        if (r108 == null) goto L38;
        MapTextureView r109 = this.f30714g;
        if (r109 == null) goto L38;
        r108.updateScaleUI(r109.getZoomLevel());
    L39:
        e();
        return;
    L5:
        if (PermissionUtils.getInstance().isEnglishMapAuthorized() == true) goto L18;
        if (MapLanguageRecord.newInstance().getMapLanguage() == r102) goto L9;
        return;
    L9:
        if (PermissionUtils.getInstance().getAdvancedPermission() == (-1)) goto L15;
        if (PermissionUtils.getInstance().isEnglishMapAuthorized() == true) goto L15;
        this.f30718i.a(r102.ordinal(), true);
        setMapLanguage(MapLanguage.CHINESE, true);
        MapLanguageRecord.newInstance().clearMapLanguage();
        return;
    L15:
        if (PermissionUtils.getInstance().getAdvancedPermission() != (-1)) goto L18;
        MapSDKAdvancedPermission.getInstance().addListener(this);
        goto L18
    }

    public final void setMapStatusLimits(LatLngBounds r100, boolean r101) {
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.a(r100, r101);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(r100));
    }

    public final void setMaxAndMinZoomLevel(float r100, float r101) {
        if (r100 <= 22.0f) goto L6;
        return;
    L6:
        if (r101 >= 4.0f) goto L9;
        return;
    L9:
        if (r100 >= r101) goto L11;
        return;
    L11:
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 == null) goto L15;
        r102.a(r100, r101);
        return;
    }

    public void setPoiTagEnable(PoiTagType r100, boolean r101) {
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public void showInfoWindow(InfoWindow r100, boolean r101) {
        Set<InfoWindow> r102 = this.f30713f0.keySet();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102.contains(r100) == false) goto L7;
        return;
    L7:
        if (this.f30741t0 == true) goto L56;
        if (r101 == false) goto L11;
        hideInfoWindow();
    L11:
        r100.f30999i = this.f30736r;
        View r103 = r100.f30993c;
        if (r103 != null) goto L14;
    L27:
        boolean r104 = true;
    L28:
        BitmapDescriptor r105 = a(r100);
        if (r105 != null) goto L32;
        return;
    L32:
        if (r100.f30995e == true) goto L34;
        MarkerOptions r106 = new MarkerOptions().perspective(false).icon(r105).position(r100.f30994d).zIndex(Integer.MAX_VALUE).yOffset(r100.f31000j).infoWindow(r100);
    L35:
        Overlay r107 = r106.getOverlay();
        r107.listener = this.f30730o;
        if (r100.f30995e == true) goto L38;
        r107.type = com.baidu.mapsdkplatform.comapi.map.d.f32142b;
    L38:
        r107.f31204c = 32767;
        Bundle r108 = new Bundle();
        r107.a(r108);
        if (r100.f30993c == null) goto L41;
        r108.putInt("draw_with_view", 1);
    L42:
        Marker r109 = (Marker) r107;
        if (this.f30718i == null) goto L52;
        if (r104 == false) goto L52;
        if (this.f30741t0 == true) goto L52;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L50;
        a(r109);
    L51:
        this.f30722k.add(r107);
        goto L52
    L50:
        this.f30718i.d(r108);
    L52:
        r109.Q = this.f30736r;
        this.f30711e0.put(r109.f31202a, r100);
        this.f30713f0.put(r100, r109);
        this.f30728n.add(r100);
        return;
    L41:
        r108.putInt("draw_with_view", 0);
        goto L42
    L34:
        Point r110 = new Point(r100.f30996f, r100.f30997g);
        r106 = new MarkerOptions().perspective(false).icon(r105).position(r100.f30994d).fixedScreenPosition(r110).zIndex(Integer.MAX_VALUE).yOffset(r100.f31000j).infoWindow(r100);
        goto L35
    L14:
        if (r100.f31004n == false) goto L27;
        r103.destroyDrawingCache();
        MapViewLayoutParams r111 = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(r100.f30994d).yOffset(r100.f31000j).build();
        int r112 = i.f30762b[this.f30729n0.ordinal()];
        if (r112 != 1) goto L18;
        TextureMapView r113 = this.f30725l0;
        if (r113 == null) goto L26;
        r113.addView(r103, r111);
    L26:
        r104 = false;
        goto L28
    L18:
        if (r112 != 2) goto L26;
        MapView r114 = this.f30723k0;
        if (r114 == null) goto L26;
        r114.addView(r103, r111);
        goto L26
    }

    public final void snapshotScope(Rect r100, SnapshotReadyCallback r101) {
        if (this.f30718i != null) goto L5;
        return;
    L5:
        this.P = r101;
        int r102 = i.f30762b[this.f30729n0.ordinal()];
        if (r102 != 1) goto L8;
        MapTextureView r103 = this.f30714g;
        if (r103 == null) goto L19;
        r103.doCaptureMapView(new d(this), r100, Bitmap.Config.ARGB_8888);
        this.f30714g.requestRender();
        return;
    L19:
        return;
    L8:
        if (r102 != 2) goto L20;
        MapSurfaceView r104 = this.f30712f;
        if (r104 == null) goto L17;
        r104.doCaptureMapView(new e(this), r100, Bitmap.Config.ARGB_8888);
        this.f30712f.requestRender();
        return;
    L17:
        return;
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String r100, String r101) {
        HashMap r102 = new HashMap();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L30:
        MapBaseIndoorMapInfo.SwitchFloorError r103 = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
        r102.put(ExifInterface.LATITUDE_SOUTH, r103.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", r102);
        return r103;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L30;
        MapBaseIndoorMapInfo r104 = getFocusedBaseIndoorMapInfo();
        if (r104 != null) goto L12;
        MapBaseIndoorMapInfo.SwitchFloorError r105 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        r102.put(ExifInterface.LATITUDE_SOUTH, r105.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", r102);
        return r105;
    L12:
        if (r101.equals(r104.f31014a) == true) goto L15;
        MapBaseIndoorMapInfo.SwitchFloorError r106 = MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
        r102.put(ExifInterface.LATITUDE_SOUTH, r106.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", r102);
        return r106;
    L15:
        ArrayList<String> r107 = r104.getFloors();
        if (r107 != null) goto L18;
    L28:
        MapBaseIndoorMapInfo.SwitchFloorError r108 = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
        r102.put(ExifInterface.LATITUDE_SOUTH, r108.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", r102);
        return r108;
    L18:
        if (r107.contains(r100) == false) goto L28;
        com.baidu.mapsdkplatform.comapi.map.b r109 = this.f30718i;
        if (r109 != null) goto L23;
    L26:
        MapBaseIndoorMapInfo.SwitchFloorError r110 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        r102.put(ExifInterface.LATITUDE_SOUTH, r110.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", r102);
        return r110;
    L23:
        if (r109.b(r100, r101) == false) goto L26;
        MapBaseIndoorMapInfo.SwitchFloorError r111 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
        r102.put(ExifInterface.LATITUDE_SOUTH, r111.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "3.1", r102);
        return r111;
    }

    public void switchLayerOrder(MapLayer r100, MapLayer r101) {
        if (this.f30718i != null) goto L5;
        return;
    L5:
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "C", "5", null);
        if (this.f30718i.a(r100, r101) == false) goto L12;
        if (r100 != MapLayer.BM_LAYER_OVERLAY) goto L12;
        if (r101 != MapLayer.MAP_LAYER_OVERLAY) goto L12;
    L15:
        boolean r102 = !this.f30743u0;
        this.f30743u0 = r102;
        this.f30718i.x(r102);
        return;
    L12:
        if (r100 == MapLayer.MAP_LAYER_OVERLAY) goto L14;
        return;
    L14:
        if (r101 == MapLayer.BM_LAYER_OVERLAY) goto L15;
    }

    public static /* synthetic */ String a(BaiduMap r100, int r101) {
        return r100.a(r101);
    }

    public static /* synthetic */ void a(BaiduMap r100, InfoWindow r101) {
        r100.b(r101);
    }

    public static /* synthetic */ void a(BaiduMap r100, Overlay r101) {
        r100.c(r101);
    }

    public static /* synthetic */ HexagonMap a(BaiduMap r100, HexagonMap r101) {
        r100.f30705a0 = r101;
        return r101;
    }

    public static /* synthetic */ Marker a(BaiduMap r100, Marker r101) {
        r100.f30715g0 = r101;
        return r101;
    }

    public static /* synthetic */ Projection a(BaiduMap r100, Projection r101) {
        r100.f30708d = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(BaiduMap r100, boolean r101) {
        r100.f30737r0 = r101;
        return r101;
    }

    public BaiduMap(Context r100, MapSurfaceView r110, com.baidu.mapsdkplatform.comapi.map.q r111) {
        this.C = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.E = new CopyOnWriteArrayList();
        this.F = new CopyOnWriteArrayList();
        this.G = new CopyOnWriteArrayList();
        this.H = new CopyOnWriteArrayList();
        this.I = new CopyOnWriteArrayList();
        this.f30704J = new CopyOnWriteArrayList();
        this.K = new CopyOnWriteArrayList();
        this.L = new CopyOnWriteArrayList();
        this.M = new CopyOnWriteArrayList();
        this.f30706b0 = new ReentrantLock();
        this.f30707c0 = new ReentrantLock();
        this.f30709d0 = new ReentrantLock();
        this.f30741t0 = false;
        this.f30743u0 = false;
        this.f30747w0 = false;
        this.f30712f = r110;
        com.baidu.mapsdkplatform.comapi.map.b r101 = new com.baidu.mapsdkplatform.comapi.map.b(r100, r110, r111, null, 0);
        this.f30718i = r101;
        r110.setBaseMap(r101);
        com.baidu.mapsdkplatform.comapi.map.r r102 = com.baidu.mapsdkplatform.comapi.map.r.f32196a;
        this.f30729n0 = r102;
        this.f30716h = new NaviMapExpand(r101, r102, this.f30723k0, r110, null, this.f30714g);
        b();
    }

    public BaiduMap(Context r100, MapTextureView r110, com.baidu.mapsdkplatform.comapi.map.q r111) {
        this.C = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.E = new CopyOnWriteArrayList();
        this.F = new CopyOnWriteArrayList();
        this.G = new CopyOnWriteArrayList();
        this.H = new CopyOnWriteArrayList();
        this.I = new CopyOnWriteArrayList();
        this.f30704J = new CopyOnWriteArrayList();
        this.K = new CopyOnWriteArrayList();
        this.L = new CopyOnWriteArrayList();
        this.M = new CopyOnWriteArrayList();
        this.f30706b0 = new ReentrantLock();
        this.f30707c0 = new ReentrantLock();
        this.f30709d0 = new ReentrantLock();
        this.f30741t0 = false;
        this.f30743u0 = false;
        this.f30747w0 = false;
        this.f30714g = r110;
        com.baidu.mapsdkplatform.comapi.map.b r101 = new com.baidu.mapsdkplatform.comapi.map.b(r100, r110, r111, null, 0);
        this.f30718i = r101;
        r110.setBaseMap(r101);
        com.baidu.mapsdkplatform.comapi.map.r r102 = com.baidu.mapsdkplatform.comapi.map.r.f32197b;
        this.f30729n0 = r102;
        this.f30716h = new NaviMapExpand(r101, r102, this.f30723k0, null, this.f30725l0, this.f30714g);
        b();
    }

    public boolean setCustomTrafficColor(String r100, String r110, String r111, String r112) {
        if (this.f30718i != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L24;
        if (TextUtils.isEmpty(r110) == true) goto L24;
        if (TextUtils.isEmpty(r111) == true) goto L24;
        if (TextUtils.isEmpty(r112) == true) goto L24;
        if (r100.matches("^#[0-9a-fA-F]{8}$") == true) goto L16;
    L22:
        return false;
    L16:
        if (r110.matches("^#[0-9a-fA-F]{8}$") == false) goto L22;
        if (r111.matches("^#[0-9a-fA-F]{8}$") == false) goto L22;
        if (r112.matches("^#[0-9a-fA-F]{8}$") == false) goto L22;
        this.f30718i.a(ColorProtector.parseColor(r100), ColorProtector.parseColor(r110), ColorProtector.parseColor(r111), ColorProtector.parseColor(r112), true);
        return true;
    L24:
        if (TextUtils.isEmpty(r100) == true) goto L26;
        return true;
    L26:
        if (TextUtils.isEmpty(r110) == true) goto L28;
        return true;
    L28:
        if (TextUtils.isEmpty(r111) == true) goto L30;
        return true;
    L30:
        if (TextUtils.isEmpty(r112) == false) goto L38;
        this.f30718i.a(ColorProtector.parseColor("#ffffffff"), ColorProtector.parseColor("#ffffffff"), ColorProtector.parseColor("#ffffffff"), ColorProtector.parseColor("#ffffffff"), false);
        return true;
    L38:
        return true;
    }

    public final void setPadding(int r100, int r101, int r102, int r103) {
        setViewPadding(r100, r101, r102, r103);
    }

    public final void setViewPadding(int r100, int r101, int r110, int r111) {
        if (r100 < 0) goto L24;
        if (r101 < 0) goto L25;
        if (r110 < 0) goto L26;
        if (r111 >= 0) goto L8;
        return;
    L8:
        if (this.f30718i != null) goto L10;
        return;
    L10:
        int r102 = i.f30762b[this.f30729n0.ordinal()];
        if (r102 != 1) goto L13;
        TextureMapView r103 = this.f30725l0;
        if (r103 != null) goto L22;
        return;
    L22:
        float r104 = ((r103.getWidth() - r100) - r110) / this.f30725l0.getWidth();
        float r105 = ((this.f30725l0.getHeight() - r101) - r111) / this.f30725l0.getHeight();
        com.baidu.mapsdkplatform.comapi.map.b r106 = this.f30718i;
        Point r107 = this.f30739s0;
        r106.a(new Point((int) (r100 + (r107.x * r104)), (int) (r101 + (r107.y * r105))));
        this.f30725l0.setPadding(r100, r101, r110, r111);
        this.f30725l0.invalidate();
        return;
    L13:
        if (r102 != 2) goto L29;
        MapView r108 = this.f30723k0;
        if (r108 != null) goto L18;
        return;
    L18:
        float r109 = ((r108.getWidth() - r100) - r110) / this.f30723k0.getWidth();
        float r112 = ((this.f30723k0.getHeight() - r101) - r111) / this.f30723k0.getHeight();
        com.baidu.mapsdkplatform.comapi.map.b r113 = this.f30718i;
        Point r114 = this.f30739s0;
        r113.a(new Point((int) (r100 + (r114.x * r109)), (int) (r101 + (r114.y * r112))));
        this.f30723k0.setPadding(r100, r101, r110, r111);
        this.f30723k0.invalidate();
        return;
    L29:
        return;
    L26:
        return;
    L25:
        return;
    }

    public void setCustomTrafficColor(int r100, int r101, int r102, int r103) {
        com.baidu.mapsdkplatform.comapi.map.b r104 = this.f30718i;
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    public float getZoomToBound(int r100, int r101, int r110, int r111, int r112, int r113) {
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.f30718i;
        if (r102 != null) goto L7;
        return 0.0f;
    L7:
        return r102.a(r100, r101, r110, r111, r112, r113);
    }
}
