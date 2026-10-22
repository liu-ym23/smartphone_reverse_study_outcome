package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.app.AppStateEngine;
import com.stepos.alphame.utils.Property;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.time.DurationKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MapController {
    public static final String ANDROID_SDK_LAYER_TAG = "android_sdk";
    public static final String CITY_AREA_TAG = "cityarea";
    public static final String COMPASS_LAYER_TAG = "compass";
    public static final String DEFAULT_LAYER_TAG = "default";
    public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
    public static final String FOOTSURFACE_LAYER_TAG = "footsurface";
    public static final String HEATMAP_LAYER_TAG = "heatmap";
    public static final String ITEM_LAYER_TAG = "item";
    public static final String ITSROUTE_LAYER_TAG = "itsroute";
    public static final String LOCAL_LIMIT_MAP_LAYER_TAG = "dynamiclimit";
    public static final String LOCATION_LAYER_TAG = "location";
    public static final int MSG_LONGLINK_CONNECT = 1;
    public static final int MSG_LONGLINK_DISCONNECT = 2;
    public static final String POISON_LAYER_TAG = "poison";
    public static final String POPUP_LAYER_TAG = "popup";
    public static final String RTPOPUP_LAYER_TAG = "rtpopup";
    public static final String RT_POPUP_LAYER_TAG = "rtpopup";
    public static final String SHARELOCATION_BUBBLE = "smshare";
    public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
    public static final String STREETROUTE_LAYER_TAG = "streetroute";

    /* renamed from: a, reason: collision with root package name */
    private static final String f8872a = "MapController";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f8873b = true;

    /* renamed from: c, reason: collision with root package name */
    private static float f8874c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private static float f8875d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f8876e = false;

    /* renamed from: f, reason: collision with root package name */
    private static long f8877f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static List<AppBaseMap> f8878g = new ArrayList();
    public static boolean isCompass = false;
    public static boolean mLocIconOnScreen = true;
    public static boolean m_registered_SENSOR_ORIENTATION;

    /* renamed from: N, reason: collision with root package name */
    private long f8892N;

    /* renamed from: d0, reason: collision with root package name */
    SoftReference<MapViewInterface> f8907d0;

    /* renamed from: e0, reason: collision with root package name */
    NaviMapViewListener f8908e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f8909f0;

    /* renamed from: h, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.c f8911h;
    public boolean mHasBmDrawItemDraging;
    public boolean mHasMapObjDraging;
    public boolean mIsMapLoadFinish;
    public boolean mIsMapLoadStart;
    public w mOverlayListener;

    /* renamed from: o, reason: collision with root package name */
    private MapFirstFrameCallback f8921o;

    /* renamed from: q, reason: collision with root package name */
    private Point f8923q;

    /* renamed from: r, reason: collision with root package name */
    private LatLng f8924r;

    /* renamed from: x, reason: collision with root package name */
    private Handler f8930x;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8913i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8915j = true;

    /* renamed from: k, reason: collision with root package name */
    int f8917k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f8918l = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f8919m = 1;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8920n = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8922p = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8925s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8926t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8927u = false;

    /* renamed from: v, reason: collision with root package name */
    private AppBaseMap f8928v = null;

    /* renamed from: w, reason: collision with root package name */
    private long f8929w = 0;
    public int nearlyRadius = 20;

    /* renamed from: A, reason: collision with root package name */
    private boolean f8879A = false;

    /* renamed from: B, reason: collision with root package name */
    private boolean f8880B = false;

    /* renamed from: C, reason: collision with root package name */
    private boolean f8881C = false;

    /* renamed from: D, reason: collision with root package name */
    private boolean f8882D = false;

    /* renamed from: E, reason: collision with root package name */
    private a f8883E = new a();

    /* renamed from: F, reason: collision with root package name */
    private boolean f8884F = true;

    /* renamed from: G, reason: collision with root package name */
    private boolean f8885G = false;

    /* renamed from: H, reason: collision with root package name */
    private boolean f8886H = true;

    /* renamed from: I, reason: collision with root package name */
    private boolean f8887I = true;

    /* renamed from: J, reason: collision with root package name */
    private boolean f8888J = false;

    /* renamed from: K, reason: collision with root package name */
    private float f8889K = -1.0f;

    /* renamed from: L, reason: collision with root package name */
    private float f8890L = -1.0f;

    /* renamed from: M, reason: collision with root package name */
    private float f8891M = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: O, reason: collision with root package name */
    private boolean f8893O = false;

    /* renamed from: P, reason: collision with root package name */
    private boolean f8894P = false;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f8895Q = false;

    /* renamed from: R, reason: collision with root package name */
    private boolean f8896R = true;

    /* renamed from: S, reason: collision with root package name */
    private boolean f8897S = true;
    private boolean T = true;

    /* renamed from: U, reason: collision with root package name */
    private boolean f8898U = true;
    public boolean mIsInertialAnimation = true;

    /* renamed from: V, reason: collision with root package name */
    private boolean f8899V = false;

    /* renamed from: W, reason: collision with root package name */
    MapViewListener f8900W = null;

    /* renamed from: X, reason: collision with root package name */
    CaptureMapListener f8901X = null;

    /* renamed from: Y, reason: collision with root package name */
    g f8902Y = null;

    /* renamed from: Z, reason: collision with root package name */
    y f8903Z = null;

    /* renamed from: a0, reason: collision with root package name */
    MapRenderModeChangeListener f8904a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    EngineMsgListener f8905b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    MapViewSurfaceListener f8906c0 = null;
    public float mMaxZoomLevel = 22.0f;
    public float mMinZoomLevel = 4.0f;
    public boolean mIsMoving = false;
    public boolean mIsAnimating = false;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f8910g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f8912h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.b f8914i0 = new com.baidu.platform.comapi.map.c0.b(this);

    /* renamed from: j0, reason: collision with root package name */
    private MapControlMode f8916j0 = MapControlMode.DEFAULT;
    public List<v> mListeners = new CopyOnWriteArrayList();

    /* renamed from: y, reason: collision with root package name */
    private int f8931y = SysOSUtil.getInstance().getScreenWidth();

    /* renamed from: z, reason: collision with root package name */
    private int f8932z = SysOSUtil.getInstance().getScreenHeight();

    public enum HeatMapType {
        CITY(0),
        SCENERY(1),
        CEMETERY(2);


        /* renamed from: b, reason: collision with root package name */
        private final int f8934b;

        HeatMapType(int i4) {
            this.f8934b = i4;
        }

        public int getId() {
            return this.f8934b;
        }
    }

    public enum MapControlMode {
        DEFAULT(1),
        INDOOR(2),
        STREET(3),
        STREET_WAITING(4);


        /* renamed from: b, reason: collision with root package name */
        private final int f8936b;

        MapControlMode(int i4) {
            this.f8936b = i4;
        }
    }

    public interface MapFirstFrameCallback {
        void onFirstFrameDrawing(MapController mapController);
    }

    public enum MapLayerType {
        DEFAULT(1),
        SATELLITE(2),
        INDOOR(3),
        STREET(5);


        /* renamed from: b, reason: collision with root package name */
        private final int f8938b;

        MapLayerType(int i4) {
            this.f8938b = i4;
        }
    }

    public enum MapSceneMode {
        DEFAULT(0),
        POI(1),
        ROUTE(2),
        INTERNAL(3),
        INDOOR(7);


        /* renamed from: b, reason: collision with root package name */
        private final int f8940b;

        MapSceneMode(int i4) {
            this.f8940b = i4;
        }

        public int getMode() {
            return this.f8940b;
        }
    }

    public enum MapStyleMode {
        DEFAULT(1),
        SEARCH_POI(2),
        SEARCH_ROUTE(3),
        NAV_DAY(4),
        NAV_NIGHT(5),
        WALK_DAY(6),
        INTERNAL(7),
        INTERNAL_SPECIAL(8),
        FOOT_PRINT(9);


        /* renamed from: b, reason: collision with root package name */
        private final int f8942b;

        MapStyleMode(int i4) {
            this.f8942b = i4;
        }

        public int getMode() {
            return this.f8942b;
        }
    }

    public enum RecommendPoiScene {
        BASE(0),
        INTERNATIONAL(1);

        public int value;

        RecommendPoiScene(int i4) {
            this.value = i4;
        }
    }

    public enum RecycleMemoryLevel {
        NORMAL(0),
        FULL(1);


        /* renamed from: b, reason: collision with root package name */
        private final int f8945b;

        RecycleMemoryLevel(int i4) {
            this.f8945b = i4;
        }

        public int getLevel() {
            return this.f8945b;
        }
    }

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8946a = false;

        /* renamed from: b, reason: collision with root package name */
        float f8947b = Property.DEFAULT_FLOAT_VALUE;

        /* renamed from: c, reason: collision with root package name */
        GeoPoint f8948c;

        /* renamed from: d, reason: collision with root package name */
        com.baidu.platform.comapi.basestruct.Point f8949d;

        public a() {
        }

        public void a() {
            this.f8946a = false;
            this.f8947b = Property.DEFAULT_FLOAT_VALUE;
            this.f8948c = null;
            this.f8949d = null;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class b extends com.baidu.platform.comapi.util.i {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MapStatus f8952a;

            public a(MapStatus mapStatus) {
                this.f8952a = mapStatus;
            }

            @Override // java.lang.Runnable
            public void run() {
                GeoPoint geoPointFromPixels;
                if (MapController.this.getMapView() == null || MapController.this.getMapView().getProjection() == null) {
                    geoPointFromPixels = null;
                } else {
                    geoPointFromPixels = MapController.this.f8907d0.get().getProjection().fromPixels((MapController.this.getScreenWidth() / 2) + this.f8952a.winRound.left, (MapController.this.getScreenHeight() / 2) + this.f8952a.winRound.top);
                }
                if (geoPointFromPixels != null) {
                    MapController.CleanAfterDBClick(MapController.this.f8929w, (float) geoPointFromPixels.getLongitudeE6(), (float) geoPointFromPixels.getLatitudeE6());
                }
                MapController.this.f8894P = false;
            }
        }

        /* renamed from: com.baidu.platform.comapi.map.MapController$b$b, reason: collision with other inner class name */
        public class RunnableC0045b implements Runnable {
            public RunnableC0045b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = MapController.this.getMapStatusInner();
                if (MapController.this.mListeners != null) {
                    for (int i4 = 0; i4 < MapController.this.mListeners.size(); i4++) {
                        v vVar = MapController.this.mListeners.get(i4);
                        if (vVar != null) {
                            vVar.d();
                            MapController.this.f8893O = true;
                            vVar.a(mapStatusInner);
                        }
                    }
                }
            }
        }

        public b() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            boolean z4;
            NaviMapViewListener naviMapViewListener;
            NaviMapViewListener naviMapViewListener2;
            w wVar;
            g gVar;
            CaptureMapListener captureMapListener;
            if (message.what == 4000 && (captureMapListener = MapController.this.f8901X) != null) {
                captureMapListener.onGetCaptureMap(message.arg2 == 1);
            }
            if (message.what == 519 && (gVar = MapController.this.f8902Y) != null) {
                gVar.a();
            }
            if (message.what == 65304 && (wVar = MapController.this.mOverlayListener) != null) {
                wVar.a(message.arg2);
            }
            int i4 = message.what;
            if (i4 == 39) {
                if (((Long) message.obj).longValue() != MapController.this.f8929w) {
                    return;
                }
                int i5 = message.arg1;
                if (i5 == 2) {
                    if (MapController.this.mListeners == null) {
                        return;
                    }
                    for (int i6 = 0; i6 < MapController.this.mListeners.size(); i6++) {
                        v vVar = MapController.this.mListeners.get(i6);
                        if (vVar != null) {
                            vVar.b();
                        }
                    }
                    MapController mapController = MapController.this;
                    mapController.mIsMoving = false;
                    mapController.mIsAnimating = false;
                } else if (i5 == 100) {
                    if (MapController.this.f8894P) {
                        SoftReference<MapViewInterface> softReference = MapController.this.f8907d0;
                        if (softReference == null || softReference.get() == null) {
                            return;
                        } else {
                            MapTaskManager.getDefaultThreadPool().execute(new a(MapController.this.getMapStatus()));
                        }
                    }
                    if (MapController.this.f8895Q) {
                        MapController.this.f8895Q = false;
                    }
                    MapController.this.f8880B = false;
                    MapController mapController2 = MapController.this;
                    mapController2.mIsMoving = false;
                    mapController2.mIsAnimating = false;
                    if (mapController2.getMapViewListener() != null) {
                        MapController.this.getMapViewListener().onMapAnimationFinish();
                    }
                    if (MapController.this.isNaviMode() && (naviMapViewListener = MapController.this.f8908e0) != null) {
                        naviMapViewListener.onMapAnimationFinish();
                    }
                    MapController mapController3 = MapController.this;
                    if (mapController3.mListeners != null && mapController3.f8893O) {
                        com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = MapController.this.getMapStatusInner();
                        for (int i7 = 0; i7 < MapController.this.mListeners.size(); i7++) {
                            v vVar2 = MapController.this.mListeners.get(i7);
                            if (vVar2 != null) {
                                vVar2.a(mapStatusInner);
                            }
                        }
                    }
                } else if (i5 == 200) {
                    MapController.this.mIsMoving = false;
                } else if (i5 != 300) {
                    if (i5 != 400) {
                        MapRenderModeChangeListener mapRenderModeChangeListener = MapController.this.f8904a0;
                        if (mapRenderModeChangeListener != null) {
                            mapRenderModeChangeListener.onMapRenderModeChange(i5);
                        }
                        if (MapController.this.isNaviMode() && (naviMapViewListener2 = MapController.this.f8908e0) != null) {
                            naviMapViewListener2.onMapRenderModeChange(message.arg1);
                        }
                    } else {
                        for (int i8 = 0; i8 < MapController.this.mListeners.size(); i8++) {
                            v vVar3 = MapController.this.mListeners.get(i8);
                            if (vVar3 != null) {
                                vVar3.onFirstMapTileLoaded();
                            }
                        }
                    }
                } else if (MapController.this.f8921o != null) {
                    MapController.this.f8921o.onFirstFrameDrawing(MapController.this);
                }
                MapController mapController4 = MapController.this;
                if (!mapController4.mIsMapLoadFinish && mapController4.f8932z > 0 && MapController.this.f8931y > 0 && MapController.this.getMapView() != null && MapController.this.getMapView().getProjection() != null && MapController.this.getMapView().getProjection().fromPixels(0, 0) != null) {
                    MapController.this.mIsMapLoadFinish = true;
                    MapTaskManager.postToMainThread(new RunnableC0045b(), 0L);
                }
                if (MapController.this.mListeners != null) {
                    for (int i9 = 0; i9 < MapController.this.mListeners.size(); i9++) {
                        v vVar4 = MapController.this.mListeners.get(i9);
                        if (vVar4 != null) {
                            vVar4.c();
                        }
                    }
                }
            } else if (i4 == 41) {
                if (((Long) message.obj).longValue() != MapController.this.f8929w) {
                    return;
                }
                MapController mapController5 = MapController.this;
                if (mapController5.mListeners == null) {
                    return;
                }
                if (mapController5.mIsMoving || mapController5.mIsAnimating) {
                    com.baidu.mapsdkplatform.comapi.map.s mapStatusInner2 = mapController5.getMapStatusInner();
                    for (int i10 = 0; i10 < MapController.this.mListeners.size(); i10++) {
                        v vVar5 = MapController.this.mListeners.get(i10);
                        if (vVar5 != null) {
                            vVar5.b(mapStatusInner2);
                        }
                    }
                }
            } else if (i4 == 2082) {
                int i11 = message.arg1;
                if (i11 == 1003) {
                    z4 = true;
                    i11 = 0;
                } else {
                    z4 = false;
                }
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("onMapRenderValidFrame isValid = " + z4 + "; errorCode = " + i11);
                }
                if (MapController.this.mListeners != null) {
                    for (int i12 = 0; i12 < MapController.this.mListeners.size(); i12++) {
                        v vVar6 = MapController.this.mListeners.get(i12);
                        if (vVar6 != null) {
                            vVar6.a(z4, i11);
                        }
                    }
                }
            }
            if (message.what == 512) {
                int i13 = message.arg1;
                if (MapController.this.getMapViewListener() != null) {
                    MapController.this.getMapViewListener().onClickedPopup(i13);
                }
            }
            if (message.what == 50) {
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("EngineMeassage IndoorMap msg.what = " + message.what + "; msg.arg1 = " + message.arg1);
                }
                MapController mapController6 = MapController.this;
                EngineMsgListener engineMsgListener = mapController6.f8905b0;
                if (engineMsgListener != null) {
                    int i14 = message.arg1;
                    if (i14 == 1) {
                        MapController.this.f8905b0.onEnterIndoorMapMode(mapController6.getFocusedBaseIndoorMapInfo());
                    } else if (i14 == 0) {
                        engineMsgListener.onExitIndoorMapMode();
                    }
                }
                MapController mapController7 = MapController.this;
                if (mapController7.mListeners == null) {
                    return;
                }
                IndoorMapInfo focusedBaseIndoorMapInfo = mapController7.getFocusedBaseIndoorMapInfo();
                for (int i15 = 0; i15 < MapController.this.mListeners.size(); i15++) {
                    v vVar7 = MapController.this.mListeners.get(i15);
                    if (vVar7 != null) {
                        int i16 = message.arg1;
                        if (i16 == 0) {
                            vVar7.a(false);
                            MapController.this.mMaxZoomLevel = 22.0f;
                        } else if (i16 == 1) {
                            if (MapController.this.getMapStatus().level < 18.0f || focusedBaseIndoorMapInfo == null) {
                                vVar7.a(false);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            } else {
                                vVar7.a(true);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            }
                        }
                    }
                }
            }
            if (message.what == 51) {
                MapController.this.setNetStatus(message.arg1);
            }
            if (message.what == 65301) {
                MapController mapController8 = MapController.this;
                if (mapController8.f8905b0 != null) {
                    int i17 = message.arg1;
                    if (i17 == 1) {
                        mapController8.getMapBarData();
                    } else if (i17 == 0) {
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a());
                    }
                }
            }
        }
    }

    public MapController() {
        this.f8930x = null;
        this.f8930x = new b();
        b();
    }

    public static native int CleanAfterDBClick(long j4, float f4, float f5);

    public static int GetAdaptKeyCode(int i4) {
        switch (i4) {
            case 19:
                return 17;
            case 20:
                return 19;
            case 21:
                return 16;
            case 22:
                return 18;
            default:
                return 0;
        }
    }

    public static native int MapProc(long j4, int i4, int i5, int i6, int i7, int i8, double d4, double d5, double d6, double d7);

    public static int getScaleDis(int i4) {
        switch (i4) {
            case 1:
                return 10000000;
            case 2:
                return 5000000;
            case 3:
                return 2000000;
            case 4:
                return DurationKt.NANOS_IN_MILLIS;
            case 5:
                return 500000;
            case 6:
                return 200000;
            case 7:
                return ComplexPt.TEN_THOUSAND;
            case 8:
                return SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
            case 9:
                return AppStateEngine.QUICK_CHECK_TIME;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        return !a() ? Property.DEFAULT_FLOAT_VALUE : this.f8928v.GetFZoomToBoundF(bundle, bundle2);
    }

    public int MapMsgProc(int i4, int i5, int i6) {
        return MapMsgProc(i4, i5, i6, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public void SetStyleMode(int i4) {
        setMapScene(i4);
    }

    public void addOneOverlayItem(Bundle bundle) {
        this.f8928v.addOneOverlayItem(bundle);
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (a()) {
            this.f8928v.AddStreetCustomMarker(bundle, bitmap);
        }
    }

    public void animateTo(GeoPoint geoPoint, int i4) {
        if (a()) {
            MapStatus mapStatus = getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            setMapStatusWithAnimation(mapStatus, i4);
        }
    }

    public boolean cleanCache(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.f8928v;
        return appBaseMap != null && appBaseMap.cleanCache(mapLayerType.f8938b, false);
    }

    public void clearUniversalLayer() {
        if (a()) {
            this.f8928v.clearUniversalLayer();
        }
    }

    public boolean createByDuplicateAppBaseMap(long j4) {
        AppBaseMap appBaseMap = new AppBaseMap();
        this.f8928v = appBaseMap;
        if (!appBaseMap.CreateByDuplicate(j4)) {
            this.f8928v = null;
            this.f8929w = 0L;
            return false;
        }
        this.f8912h0 = true;
        this.f8929w = this.f8928v.GetId();
        List<AppBaseMap> list = f8878g;
        if (list != null) {
            list.add(this.f8928v);
        }
        return true;
    }

    public void enablePOIAnimation(boolean z4) {
        if (a()) {
            this.f8928v.enablePOIAnimation(z4);
        }
    }

    public void forceSetMapScene(int i4) {
        this.f8918l = i4;
        if (a()) {
            this.f8928v.setMapScene(this.f8918l);
        }
    }

    public boolean forceSetMapThemeScene(int i4, int i5, Bundle bundle) {
        this.f8919m = i4;
        this.f8918l = i5;
        if (a()) {
            return this.f8928v.setMapThemeScene(i4, i5, bundle);
        }
        return false;
    }

    public float getAdapterZoomUnitsEx() {
        return !a() ? Property.DEFAULT_FLOAT_VALUE : this.f8928v.GetAdapterZoomUnitsEx();
    }

    public AppBaseMap getBaseMap() {
        return this.f8928v;
    }

    public int getCacheSize(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.f8928v;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.GetCacheSize(mapLayerType.f8938b);
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.f8901X;
    }

    public String getCityInfoByID(int i4) {
        AppBaseMap appBaseMap = this.f8928v;
        if (appBaseMap != null) {
            return appBaseMap.GetCityInfoByID(i4);
        }
        return null;
    }

    public MapStatus getCurrentMapStatus() {
        return a(false);
    }

    public float getCurrentZoomLevel() {
        Bundle bundleGetMapStatus;
        AppBaseMap appBaseMap = this.f8928v;
        if (appBaseMap == null || (bundleGetMapStatus = appBaseMap.GetMapStatus(false)) == null) {
            return 4.0f;
        }
        return (float) bundleGetMapStatus.getDouble("level");
    }

    public IndoorMapInfo getFocusedBaseIndoorMapInfo() {
        String[] strArr;
        int[] iArr;
        if (!a()) {
            return null;
        }
        String strGetFocusedBaseIndoorMapInfo = this.f8928v.GetFocusedBaseIndoorMapInfo();
        if (!TextUtils.isEmpty(strGetFocusedBaseIndoorMapInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(strGetFocusedBaseIndoorMapInfo);
                String strOptString = jSONObject.optString("focusindoorid");
                String strOptString2 = jSONObject.optString("curfloor");
                int iOptInt = jSONObject.optInt("idrtype");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("floorlist");
                if (jSONArrayOptJSONArray != null) {
                    strArr = new String[jSONArrayOptJSONArray.length()];
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        arrayList.add(jSONArrayOptJSONArray.getString(i4));
                    }
                    arrayList.toArray(strArr);
                } else {
                    strArr = null;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("floorattribute");
                if (jSONArrayOptJSONArray2 != null) {
                    iArr = new int[jSONArrayOptJSONArray2.length()];
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                        iArr[i5] = jSONArrayOptJSONArray2.optInt(i5);
                    }
                } else {
                    iArr = null;
                }
                return new IndoorMapInfo(strOptString, strOptString2, strArr, iArr, iOptInt, jSONObject.optInt("idrguide"), jSONObject.optString("idrsearch"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public com.baidu.platform.comapi.map.c0.c getGestureMonitor() {
        if (this.f8911h == null) {
            this.f8911h = new com.baidu.platform.comapi.map.c0.c(this);
        }
        return this.f8911h;
    }

    public Bundle getGestureOptInfoForLog() {
        Bundle bundle = null;
        if (!this.f8883E.f8946a) {
            return null;
        }
        MapStatus mapStatus = getMapStatus();
        int intX = this.f8883E.f8949d.getIntX();
        int intY = this.f8883E.f8949d.getIntY();
        double dSqrt = Math.sqrt((intY * intY) + (intX * intX));
        boolean z4 = false;
        boolean z5 = dSqrt > 100.0d;
        if (this.f8883E.f8947b > Property.DEFAULT_FLOAT_VALUE && Math.abs(mapStatus.level - r5) >= 0.5d) {
            z4 = true;
        }
        if (z5 || z4) {
            bundle = new Bundle();
            bundle.putDouble("pre_x", this.f8883E.f8948c.getLongitude());
            bundle.putDouble("pre_y", this.f8883E.f8948c.getLatitude());
            bundle.putFloat("pre_level", this.f8883E.f8947b);
        }
        this.f8883E.a();
        return bundle;
    }

    public g getHideIndoorPopupListener() {
        return this.f8902Y;
    }

    public EngineMsgListener getIndoorMapListener() {
        return this.f8905b0;
    }

    public LatLng getLatLngGesturesCenter() {
        return this.f8924r;
    }

    public List<v> getListeners() {
        return this.mListeners;
    }

    public boolean getMapBarData() {
        if (!a()) {
            return false;
        }
        Bundle bundle = new Bundle();
        this.f8928v.getMapBarData(bundle);
        byte[] byteArray = new byte[0];
        String string = bundle.containsKey("uid") ? bundle.getString("uid") : null;
        String string2 = bundle.containsKey("searchbound") ? bundle.getString("searchbound") : null;
        String string3 = bundle.containsKey("curfloor") ? bundle.getString("curfloor") : null;
        if (bundle.containsKey("barinfo")) {
            byteArray = bundle.getByteArray("barinfo");
        }
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b(string, string2, string3, byteArray));
        return true;
    }

    public boolean getMapBarShowData() {
        if (!a()) {
            return false;
        }
        return this.f8928v.getMapBarData(new Bundle());
    }

    public boolean getMapClickEnable() {
        return this.f8879A;
    }

    public MapControlMode getMapControlMode() {
        return this.f8916j0;
    }

    public long getMapId() {
        return this.f8929w;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        return this.f8904a0;
    }

    public int getMapScene() {
        if (a()) {
            return this.f8928v.getMapScene();
        }
        return 0;
    }

    public MapStatus getMapStatus() {
        return a(true);
    }

    public com.baidu.mapsdkplatform.comapi.map.s getMapStatusInner() {
        if (!a()) {
            return null;
        }
        Bundle bundleGetMapStatus = this.f8928v.GetMapStatus();
        com.baidu.mapsdkplatform.comapi.map.s sVar = new com.baidu.mapsdkplatform.comapi.map.s();
        sVar.a(bundleGetMapStatus);
        return sVar;
    }

    public int getMapTheme() {
        if (a()) {
            return this.f8928v.getMapTheme();
        }
        return 0;
    }

    public MapViewInterface getMapView() {
        SoftReference<MapViewInterface> softReference = this.f8907d0;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        return this.f8900W;
    }

    public MapViewSurfaceListener getMapViewSurfaceListener() {
        return this.f8906c0;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        return this.f8908e0;
    }

    public Point getPointGesturesCenter() {
        return this.f8923q;
    }

    public String getProjectionPt(String str) {
        if (a()) {
            return this.f8928v.getProjectionPt(str);
        }
        return null;
    }

    public int getScaleLevel(int i4, int i5) {
        if (a()) {
            return this.f8928v.getScaleLevel(i4, i5);
        }
        return 0;
    }

    public int getSceneLayerScene() {
        return this.f8918l;
    }

    public int getSceneLayerTheme() {
        return this.f8919m;
    }

    public int getScreenHeight() {
        MapStatus.WinRound winRound = getMapStatus().winRound;
        int i4 = winRound.bottom - winRound.top;
        this.f8932z = i4;
        return i4;
    }

    public int getScreenWidth() {
        MapStatus.WinRound winRound = getMapStatus().winRound;
        int i4 = winRound.right - winRound.left;
        this.f8931y = i4;
        return i4;
    }

    public y getStreetArrowClickListener() {
        return this.f8903Z;
    }

    public int getVMPMapCityCode() {
        if (this.f8928v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "map");
        this.f8928v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("code");
    }

    public int getVMPMapCityItsInfo() {
        if (this.f8928v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "its");
        this.f8928v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("rst");
    }

    public int getVMPMapCityLevel() {
        if (this.f8928v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "map");
        this.f8928v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("level");
    }

    public int getVMPMapCitySatInfo() {
        if (this.f8928v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "sat");
        this.f8928v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("rst");
    }

    public float getZoomLevel() {
        Bundle bundleGetMapStatus;
        AppBaseMap appBaseMap = this.f8928v;
        if (appBaseMap == null || (bundleGetMapStatus = appBaseMap.GetMapStatus()) == null) {
            return 4.0f;
        }
        return (float) bundleGetMapStatus.getDouble("level");
    }

    public float getZoomToBound(Bundle bundle, int i4, int i5) {
        return !a() ? Property.DEFAULT_FLOAT_VALUE : this.f8928v.GetZoomToBound(bundle, i4, i5);
    }

    public float getZoomToBoundF(Bundle bundle) {
        return !a() ? Property.DEFAULT_FLOAT_VALUE : this.f8928v.GetZoomToBoundF(bundle);
    }

    public double getZoomUnitsInMeter() {
        Bundle bundleGetMapStatus;
        AppBaseMap baseMap = getBaseMap();
        if (baseMap != null && (bundleGetMapStatus = baseMap.GetMapStatus()) != null) {
            double d4 = bundleGetMapStatus.getFloat("adapterZoomUnits");
            if (d4 > 1.0E-4d) {
                return d4;
            }
        }
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public void handleClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
    }

    public void handleDoubleClickZoom(MotionEvent motionEvent) {
        if (this.f8886H && System.currentTimeMillis() - this.f8892N >= 100) {
            mapStatusChangeStart();
            this.mIsAnimating = true;
            float y4 = motionEvent.getY();
            float f4 = this.f8890L - y4;
            MapMsgProc(8193, 3, (int) ((f4 / (getScreenHeight() / 9.0f)) * 10000.0f));
            this.f8891M = f4;
            this.f8890L = y4;
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
            if (!isNaviMode() || getNaviMapViewListener() == null) {
                return;
            }
            getNaviMapViewListener().onAction(521, null);
        }
    }

    public void handleDoubleDownClick(MotionEvent motionEvent) {
        this.f8885G = true;
        this.f8889K = motionEvent.getX();
        this.f8890L = motionEvent.getY();
        this.f8892N = System.currentTimeMillis();
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
    }

    public void handleDoubleTouch(MotionEvent motionEvent) {
        SoftReference<MapViewInterface> softReference;
        GeoPoint geoPointFromPixels;
        float latitudeE6;
        NaviMapViewListener naviMapViewListener;
        if (System.currentTimeMillis() - this.f8892N > 150) {
            return;
        }
        if (isNaviMode() && (naviMapViewListener = this.f8908e0) != null) {
            naviMapViewListener.onAction(513, motionEvent);
            return;
        }
        if (!this.f8884F || (softReference = this.f8907d0) == null || softReference.get() == null || this.f8907d0.get().getProjection() == null) {
            return;
        }
        MapStatus mapStatus = getMapStatus();
        float x4 = motionEvent.getX() - ((getScreenWidth() / 2) + mapStatus.winRound.left);
        float y4 = (motionEvent.getY() - ((getScreenHeight() / 2) + mapStatus.winRound.top)) * (-1.0f);
        boolean z4 = isCompass;
        float longitudeE6 = Property.DEFAULT_FLOAT_VALUE;
        if (z4 || this.f8888J) {
            geoPointFromPixels = this.f8907d0.get().getProjection().fromPixels((getScreenWidth() / 2) + mapStatus.winRound.left, (getScreenHeight() / 2) + mapStatus.winRound.top);
            x4 = 0.0f;
            y4 = 0.0f;
        } else if (this.f8923q == null || !this.f8925s) {
            LatLng latLng = this.f8924r;
            geoPointFromPixels = (latLng == null || !this.f8925s) ? this.f8907d0.get().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : CoordUtil.ll2mc(latLng);
        } else {
            Projection projection = this.f8907d0.get().getProjection();
            Point point = this.f8923q;
            geoPointFromPixels = projection.fromPixels(point.x, point.y);
        }
        if (geoPointFromPixels != null) {
            longitudeE6 = (float) geoPointFromPixels.getLongitudeE6();
            latitudeE6 = (float) geoPointFromPixels.getLatitudeE6();
        } else {
            latitudeE6 = 0.0f;
        }
        this.f8894P = true;
        Point point2 = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        if (geoPointFromPixels != null && this.mListeners != null) {
            for (int i4 = 0; i4 < this.mListeners.size(); i4++) {
                v vVar = this.mListeners.get(i4);
                if (vVar != null) {
                    vVar.a(geoPointFromPixels);
                    if (vVar.a(point2, getMapStatusInner())) {
                        return;
                    }
                }
            }
        }
        getGestureMonitor().a(this.f8907d0.get().getZoomLevel() + 1.0f);
        mapStatusChangeStart();
        MapMsgProc(8195, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16), (this.f8931y / 2) | ((this.f8932z / 2) << 16), 0, 0, longitudeE6, latitudeE6, x4, y4);
        f8877f = System.currentTimeMillis();
        procGestureForLog(false, null);
    }

    @SuppressLint({"FloatMath"})
    public boolean handleFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        if (!f8873b || !this.f8898U || !this.f8915j) {
            return false;
        }
        float fSqrt = (float) ((((float) Math.sqrt((f5 * f5) + (f4 * f4))) / (SysOSUtil.getInstance().getDensityDPI() / 310.0f)) * 1.3d);
        if (getMapControlMode() != MapControlMode.STREET && fSqrt < 300.0f) {
            this.f8880B = false;
            return false;
        }
        this.f8880B = true;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
            for (int i4 = 0; i4 < this.mListeners.size(); i4++) {
                v vVar = this.mListeners.get(i4);
                if (vVar != null && vVar.a(motionEvent2, f4, f5, mapStatusInner)) {
                    this.f8910g0 = false;
                    return false;
                }
            }
        }
        getGestureMonitor().a();
        mapStatusChangeStart();
        MapMsgProc(34, (int) fSqrt, (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
        if (getMapViewListener() != null) {
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.c());
        }
        this.f8910g0 = false;
        if (this.mListeners != null) {
            for (int i5 = 0; i5 < this.mListeners.size(); i5++) {
                v vVar2 = this.mListeners.get(i5);
                if (vVar2 != null) {
                    vVar2.a(motionEvent2);
                }
            }
        }
        return true;
    }

    public boolean handleKeyEvent(int i4, KeyEvent keyEvent) {
        int iGetAdaptKeyCode = GetAdaptKeyCode(i4);
        if (iGetAdaptKeyCode == 0) {
            return false;
        }
        MapMsgProc(1, iGetAdaptKeyCode, 0);
        return true;
    }

    public void handleLongClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONLONGCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
    }

    public int handleMapModeGet() {
        return MapMsgProc(4113, 0, 0);
    }

    public boolean handlePopupClick(int i4, int i5) {
        return false;
    }

    public void handleRightClick() {
        MapMsgProc(UIMsg.KEvent.V_WM_RBUTTONCLICK, 0, 0);
    }

    public void handleStreetscapeDoubleTouch(MotionEvent motionEvent) {
        float longitudeE6;
        float latitudeE6;
        SoftReference<MapViewInterface> softReference = this.f8907d0;
        if (softReference == null || softReference.get() == null || this.f8907d0.get().getProjection() == null) {
            return;
        }
        MapStatus mapStatus = getMapStatus();
        Projection projection = this.f8907d0.get().getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint geoPointFromPixels = projection.fromPixels((this.f8931y / 2) + winRound.left, (this.f8932z / 2) + winRound.top);
        if (geoPointFromPixels != null) {
            longitudeE6 = (float) geoPointFromPixels.getLongitudeE6();
            latitudeE6 = (float) geoPointFromPixels.getLatitudeE6();
        } else {
            longitudeE6 = Property.DEFAULT_FLOAT_VALUE;
            latitudeE6 = 0.0f;
        }
        MapMsgProc(8195, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()), ((this.f8932z / 2) << 16) | (this.f8931y / 2), 0, 0, longitudeE6, latitudeE6, 0.0d, 0.0d);
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (!a()) {
            return false;
        }
        if (!this.f8880B) {
            this.f8914i0.a(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2) {
            this.f8913i = true;
            f8873b = false;
            c();
            procGestureForLog(false, null);
        }
        if (motionEvent.getAction() != 2 && this.f8885G) {
            this.f8913i = true;
            c();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8913i = true;
            a(motionEvent);
        } else if (action == 1) {
            f8873b = true;
            this.f8913i = true;
            handleTouchUp(motionEvent);
        } else {
            if (action != 2) {
                return false;
            }
            if (this.f8885G) {
                handleDoubleClickZoom(motionEvent);
            } else if (this.f8898U) {
                handleTouchMove(motionEvent);
            }
        }
        if (this.mListeners != null) {
            for (int i4 = 0; i4 < this.mListeners.size(); i4++) {
                v vVar = this.mListeners.get(i4);
                if (vVar != null) {
                    vVar.a(motionEvent);
                }
            }
        }
        return true;
    }

    public boolean handleTouchMove(MotionEvent motionEvent) {
        if (!f8873b || System.currentTimeMillis() - f8877f < 300) {
            return true;
        }
        int i4 = 0;
        if (this.mHasMapObjDraging) {
            if (getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.mListeners != null) {
                    while (i4 < this.mListeners.size()) {
                        v vVar = this.mListeners.get(i4);
                        if (vVar != null && geoPointFromPixels != null) {
                            vVar.g(geoPointFromPixels);
                        }
                        i4++;
                    }
                }
            }
            return true;
        }
        if (this.mHasBmDrawItemDraging) {
            if (getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels2 = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.mListeners != null) {
                    while (i4 < this.mListeners.size()) {
                        v vVar2 = this.mListeners.get(i4);
                        if (vVar2 != null && geoPointFromPixels2 != null) {
                            vVar2.c(geoPointFromPixels2);
                        }
                        i4++;
                    }
                }
            }
            return true;
        }
        float fAbs = Math.abs(motionEvent.getX() - f8874c);
        float fAbs2 = Math.abs(motionEvent.getY() - f8875d);
        double density = SysOSUtil.getInstance().getDensity();
        if (density > 1.5d) {
            density *= 1.5d;
        }
        float f4 = (float) density;
        if (f8876e && fAbs / f4 <= 3.0f && fAbs2 / f4 <= 3.0f) {
            return true;
        }
        f8876e = false;
        if (isCompass) {
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
        }
        procGestureForLog(true, new com.baidu.platform.comapi.basestruct.Point(fAbs, fAbs2));
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        float x5 = f8874c - motionEvent.getX();
        float y5 = f8875d - motionEvent.getY();
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        Point point2 = new Point((int) (motionEvent.getRawX() + x5), (int) (motionEvent.getRawY() + y5));
        if (x4 < 0) {
            x4 = 0;
        }
        if (y4 < 0) {
            y4 = 0;
        }
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
            for (int i5 = 0; i5 < this.mListeners.size(); i5++) {
                v vVar3 = this.mListeners.get(i5);
                if (vVar3 != null && vVar3.c(point2, point, mapStatusInner)) {
                    this.f8880B = false;
                    this.f8922p = true;
                    this.f8910g0 = true;
                    return false;
                }
            }
        }
        if (this.f8913i) {
            getGestureMonitor().d();
            this.f8913i = false;
        }
        mapStatusChangeStart();
        MapMsgProc(3, 0, (y4 << 16) | x4);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.b(false, true));
        this.f8880B = false;
        this.f8922p = true;
        this.f8910g0 = true;
        return false;
    }

    public boolean handleTouchSingleClick(MotionEvent motionEvent) {
        NaviMapViewListener naviMapViewListener;
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        if (b(x4, y4) || handlePopupClick(x4, y4)) {
            return true;
        }
        if (OverlayUtil.isOverlayUpgrade() && a(x4, y4, this.f8927u)) {
            return true;
        }
        this.f8927u = c(x4, y4);
        if (a(1, x4, y4)) {
            return true;
        }
        if (this.f8879A && a(x4, y4)) {
            return true;
        }
        if (isNaviMode() && (naviMapViewListener = this.f8908e0) != null) {
            naviMapViewListener.onAction(514, motionEvent);
        }
        if (getMapViewListener() == null) {
            return false;
        }
        getMapViewListener().onClickedBackground((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleTouchUp(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.handleTouchUp(android.view.MotionEvent):boolean");
    }

    public boolean handleTrackballEvent(MotionEvent motionEvent) {
        if (!a()) {
            return false;
        }
        if (motionEvent.getAction() == 2) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int i4 = rawX > Property.DEFAULT_FLOAT_VALUE ? 18 : rawX < Property.DEFAULT_FLOAT_VALUE ? 16 : 0;
            if (rawY > Property.DEFAULT_FLOAT_VALUE) {
                i4 = 19;
            } else if (rawY < Property.DEFAULT_FLOAT_VALUE) {
                i4 = 17;
            }
            if (i4 == 0) {
                return false;
            }
            MapMsgProc(1, i4, 0);
        }
        return true;
    }

    public boolean handleZoomTo(int i4) {
        if (i4 == 0) {
            MapMsgProc(4097, -1, 0);
        } else if (i4 == 1) {
            MapMsgProc(4096, -1, 0);
        }
        return false;
    }

    public boolean importMapTheme(int i4) {
        if (a()) {
            return this.f8928v.importMapTheme(i4);
        }
        return false;
    }

    public void initAppBaseMap() {
        if (f8878g.size() == 0) {
            initBaseMap();
        } else {
            createByDuplicateAppBaseMap(f8878g.get(0).GetId());
        }
    }

    public void initBaseMap() {
        AppBaseMap appBaseMap = new AppBaseMap();
        this.f8928v = appBaseMap;
        appBaseMap.Create();
        this.f8929w = this.f8928v.GetId();
        List<AppBaseMap> list = f8878g;
        if (list != null) {
            list.add(this.f8928v);
        }
    }

    public void initMapResources(Bundle bundle) {
        if (this.f8881C || bundle == null || this.f8928v == null) {
            return;
        }
        boolean z4 = SysOSUtil.getInstance().getDensityDPI() >= 180;
        this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25) / 240;
        String string = bundle.getString("modulePath");
        String string2 = bundle.getString("appSdcardPath");
        String string3 = bundle.getString("appCachePath");
        String string4 = bundle.getString("appSecondCachePath");
        String string5 = bundle.getString("engineErrorPath");
        int i4 = bundle.getInt("mapTmpMax");
        int i5 = bundle.getInt("domTmpMax");
        int i6 = bundle.getInt("itsTmpMax");
        int i7 = bundle.getInt("ssgTmpMax");
        String str = z4 ? "/h/" : "/l/";
        String strP = AbstractC0351g.p(string, "/cfg");
        String strP2 = AbstractC0351g.p(string2, "/vmp");
        String strP3 = AbstractC0351g.p(strP, "/a/");
        String strP4 = AbstractC0351g.p(strP, "/a/");
        String strP5 = AbstractC0351g.p(strP2, str);
        String strP6 = AbstractC0351g.p(strP2, str);
        String strP7 = AbstractC0351g.p(string3, "/tmp/");
        String strP8 = AbstractC0351g.p(string4, "/tmp/");
        Bundle bundle2 = new Bundle();
        bundle2.putString("cfgdataroot", strP3);
        bundle2.putString("vmpdataroot", strP5);
        bundle2.putString("tmpdataroot", strP7);
        bundle2.putString("tmpdatapast", strP8);
        bundle2.putString("importroot", strP6);
        bundle2.putString("stylerespath", strP4);
        if (string5 != null && string5.length() > 0) {
            bundle2.putString("engineerrorpath", string5);
        }
        if (this.f8931y <= 0 || this.f8932z <= 0) {
            this.f8931y = SysOSUtil.getInstance().getScreenWidth();
            this.f8932z = SysOSUtil.getInstance().getScreenWidth();
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapControl init screenWidth: " + this.f8931y + "; screenHeight: " + this.f8932z);
        }
        bundle2.putInt("cx", this.f8931y);
        bundle2.putInt("cy", this.f8932z);
        bundle2.putInt("ndpi", SysOSUtil.getInstance().getDensityDPI());
        bundle2.putFloat("fdpi", SysOSUtil.getInstance().getDensityDPI());
        bundle2.putInt("maptmpmax", i4);
        bundle2.putInt("domtmpmax", i5);
        bundle2.putInt("itstmpmax", i6);
        bundle2.putInt("ssgtmpmax", i7);
        bundle2.putInt("pathchange", 0);
        if (bundle.containsKey("maptheme")) {
            bundle2.putInt("maptheme", bundle.getInt("maptheme"));
        }
        if (bundle.containsKey("mapscene")) {
            bundle2.putInt("mapscene", bundle.getInt("mapscene"));
        }
        if (bundle.containsKey("fontsizelevel")) {
            bundle2.putInt("fontsizelevel", bundle.getInt("fontsizelevel"));
        }
        if (!JNIInitializer.isUserTest()) {
            JNIInitializer.isDebug();
        }
        if (this.f8928v.initWithOptions(bundle2, false)) {
            this.f8928v.SetMapStatus(bundle);
            this.f8881C = true;
            return;
        }
        Log.e(f8872a, "MapControl init fail!");
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapControl init fail");
        }
        HashMap map = new HashMap();
        map.put(ExifInterface.LONGITUDE_EAST, "0");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0.2", map);
    }

    public boolean is3DGestureEnable() {
        return this.f8896R;
    }

    public boolean isBaseIndoorMapMode() {
        if (a()) {
            return this.f8928v.IsBaseIndoorMapMode();
        }
        return false;
    }

    public boolean isCanTouchMove() {
        return this.f8898U;
    }

    public boolean isDoubleClickMoveZoom() {
        return this.f8886H;
    }

    public boolean isDoubleClickZoom() {
        return this.f8884F;
    }

    public boolean isDuplicate() {
        return this.f8912h0;
    }

    public boolean isEnableDMoveZoom() {
        return this.f8885G;
    }

    public boolean isEnableIndoor3D() {
        if (a()) {
            return this.f8928v.isEnableIndoor3D();
        }
        return true;
    }

    public boolean isEnableZoom() {
        return this.T;
    }

    public boolean isEnlargeCenterWithDoubleClickEnabled() {
        return this.f8888J;
    }

    public boolean isFlingEnabled() {
        return this.f8915j;
    }

    public boolean isInFocusBarBorder(GeoPoint geoPoint, double d4) {
        return a() && geoPoint != null && this.f8928v.IsPointInFocusBarBorder(geoPoint.getLongitude(), geoPoint.getLatitude(), d4);
    }

    public boolean isInFocusIndoorBuilding(GeoPoint geoPoint) {
        return a() && geoPoint != null && this.f8928v.IsPointInFocusIDRBorder(geoPoint.getLongitude(), geoPoint.getLatitude());
    }

    public boolean isMapAnimationRunning() {
        if (a()) {
            return this.f8928v.isAnimationRunning();
        }
        return false;
    }

    public boolean isMovedMap() {
        return this.f8922p;
    }

    public boolean isNaviMode() {
        if (a()) {
            return this.f8928v.isNaviMode();
        }
        return false;
    }

    public boolean isOverlookGestureEnable() {
        return this.f8897S;
    }

    public boolean isPressedOnPopup(int i4, int i5) {
        return false;
    }

    public boolean isSetBackgroundDraw() {
        AppBaseMap appBaseMap = this.f8928v;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.isSupBackgroundDraw();
    }

    public boolean isStreetArrowShown() {
        if (a()) {
            return this.f8928v.IsStreetArrowShown();
        }
        return false;
    }

    public boolean isStreetCustomMarkerShown() {
        if (a()) {
            return this.f8928v.IsStreetCustomMarkerShown();
        }
        return false;
    }

    public boolean isStreetPOIMarkerShown() {
        if (a()) {
            return this.f8928v.IsStreetPOIMarkerShown();
        }
        return false;
    }

    public boolean isStreetRoadClickable() {
        if (a()) {
            return this.f8928v.IsStreetRoadClickable();
        }
        return false;
    }

    public boolean isTwoTouchClickZoomEnabled() {
        return this.f8887I;
    }

    public void mapStatusChangeStart() {
        if (this.mIsMoving) {
            return;
        }
        this.mIsMoving = true;
        this.mIsAnimating = false;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
            for (int i4 = 0; i4 < this.mListeners.size(); i4++) {
                v vVar = this.mListeners.get(i4);
                if (vVar != null) {
                    vVar.c(mapStatusInner);
                }
            }
        }
    }

    public void onPause() {
        if (a()) {
            this.f8928v.OnPause();
        }
    }

    public void onResume() {
        if (a()) {
            this.f8928v.OnResume();
        }
    }

    public void procGestureForLog(boolean z4, com.baidu.platform.comapi.basestruct.Point point) {
        if (!this.f8883E.f8946a) {
            MapStatus mapStatus = getMapStatus();
            a aVar = this.f8883E;
            aVar.f8946a = true;
            aVar.f8947b = mapStatus.level;
            aVar.f8948c = new GeoPoint(mapStatus.centerPtX, mapStatus.centerPtY);
            this.f8883E.f8949d = new com.baidu.platform.comapi.basestruct.Point(0, 0);
        }
        if (z4) {
            int iAbs = Math.abs(point.getIntX());
            int iAbs2 = Math.abs(point.getIntY());
            com.baidu.platform.comapi.basestruct.Point point2 = this.f8883E.f8949d;
            point2.setIntX(point2.getIntX() + iAbs);
            com.baidu.platform.comapi.basestruct.Point point3 = this.f8883E.f8949d;
            point3.setIntY(point3.getIntY() + iAbs2);
        }
    }

    public void recycleMemory(RecycleMemoryLevel recycleMemoryLevel) {
        if (a()) {
            this.f8928v.recycleMemory(recycleMemoryLevel.getLevel());
        }
    }

    public void registMapViewListener(v vVar) {
        List<v> list;
        if (vVar == null || (list = this.mListeners) == null) {
            return;
        }
        list.add(vVar);
    }

    public void removeOneOverlayItem(Bundle bundle) {
        this.f8928v.removeOneOverlayItem(bundle);
    }

    public void removeStreetAllCustomMarker() {
        if (a()) {
            this.f8928v.RemoveStreetAllCustomMarker();
        }
    }

    public void removeStreetCustomMarker(String str) {
        if (a()) {
            this.f8928v.RemoveStreetCustomMaker(str);
        }
    }

    public void saveScreenToLocal(String str, int i4, int i5, int i6, int i7) throws JSONException {
        if (!a() || TextUtils.isEmpty(str)) {
            return;
        }
        String string = null;
        if (i6 != 0 && i7 != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", i4);
                jSONObject.put("y", i5);
                jSONObject.put("width", i6);
                jSONObject.put("height", i7);
                string = jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        this.f8928v.SaveScreenToLocal(str, string);
    }

    public void scrollBy(int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return;
        }
        MapStatus.WinRound winRound = getMapStatus().winRound;
        d((this.f8931y / 2) + winRound.left + i4, (this.f8932z / 2) + winRound.top + i5);
    }

    public void set3DGestureEnable(boolean z4) {
        this.f8896R = z4;
    }

    public void setActingTwoClickZoom(boolean z4) {
        this.f8895Q = z4;
    }

    public void setAllStreetCustomMarkerVisibility(boolean z4) {
        if (a()) {
            this.f8928v.SetAllStreetCustomMarkerVisibility(z4);
        }
    }

    public void setCanTouchMove(boolean z4) {
        this.f8898U = z4;
    }

    public void setCaptureMapListener(CaptureMapListener captureMapListener) {
        this.f8901X = captureMapListener;
    }

    public void setDoubleClickGesturesCenter(boolean z4) {
        this.f8925s = z4;
    }

    public void setDoubleClickMoveZoomEnable(boolean z4) {
        this.f8886H = z4;
    }

    public void setDoubleClickZoom(boolean z4) {
        this.f8884F = z4;
    }

    public void setEnableIndoor3D(boolean z4) {
        if (a()) {
            this.f8928v.setEnableIndoor3D(z4);
        }
    }

    public void setEnableZoom(boolean z4) {
        this.T = z4;
    }

    public void setEngineMsgListener(EngineMsgListener engineMsgListener) {
        this.f8905b0 = engineMsgListener;
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z4) {
        this.f8888J = z4;
    }

    public void setFlingEnable(boolean z4) {
        this.f8915j = z4;
    }

    public void setHideIndoorPopupListener(g gVar) {
        this.f8902Y = gVar;
    }

    public void setInertialAnimation(boolean z4) {
        this.mIsInertialAnimation = z4;
        this.f8894P = z4;
        this.f8895Q = z4;
    }

    public void setLatLngGesturesCenter(LatLng latLng) {
        this.f8924r = latLng;
    }

    public boolean setLayerSceneMode(long j4, MapSceneMode mapSceneMode) {
        if (a()) {
            return this.f8928v.SetLayerSceneMode(j4, mapSceneMode.getMode());
        }
        return false;
    }

    public void setMapClickEnable(boolean z4) {
        this.f8879A = z4;
    }

    public int setMapControlMode(MapControlMode mapControlMode) {
        if (!a()) {
            return -1;
        }
        this.f8916j0 = mapControlMode;
        return this.f8928v.SetMapControlMode(mapControlMode.f8936b);
    }

    public void setMapFirstFrameCallback(MapFirstFrameCallback mapFirstFrameCallback) {
        this.f8921o = mapFirstFrameCallback;
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener mapRenderModeChangeListener) {
        this.f8904a0 = mapRenderModeChangeListener;
    }

    public void setMapScene(int i4) {
        if (i4 == getMapScene()) {
            return;
        }
        this.f8918l = i4;
        if (a()) {
            this.f8928v.setMapScene(this.f8918l);
        }
    }

    public void setMapStatus(MapStatus mapStatus, boolean z4) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt(ViewTweenItem.LEFT, mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(ViewTweenItem.TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animation", 0);
        bundle.putInt("animatime", 0);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z4 ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        this.f8928v.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i4, boolean z4) {
        if (!a() || this.f8928v == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt(ViewTweenItem.LEFT, mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(ViewTweenItem.TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i4);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z4 ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        this.f8928v.SetMapStatus(bundle);
    }

    public boolean setMapTheme(int i4, Bundle bundle) {
        if (!a()) {
            return false;
        }
        if (this.f8928v.getMapTheme() == i4) {
            return true;
        }
        this.f8919m = i4;
        return this.f8928v.setMapTheme(i4, bundle);
    }

    public boolean setMapThemeScene(int i4, int i5, Bundle bundle) {
        if (!a()) {
            return false;
        }
        if (this.f8928v.getMapTheme() == i4 && this.f8928v.getMapScene() == i5) {
            return true;
        }
        this.f8919m = i4;
        this.f8918l = i5;
        return this.f8928v.setMapThemeScene(i4, i5, bundle);
    }

    public void setMapViewInterface(MapViewInterface mapViewInterface) {
        this.f8907d0 = new SoftReference<>(mapViewInterface);
    }

    public void setMapViewListener(MapViewListener mapViewListener) {
        this.f8900W = mapViewListener;
    }

    public void setMapViewSurfaceListener(MapViewSurfaceListener mapViewSurfaceListener) {
        this.f8906c0 = mapViewSurfaceListener;
    }

    public void setMaxAndMinZoomLevel(float f4, float f5) {
        this.mMaxZoomLevel = f4;
        this.mMinZoomLevel = f5;
    }

    public void setNaviMapViewListener(NaviMapViewListener naviMapViewListener) {
        this.f8908e0 = naviMapViewListener;
    }

    public void setNetStatus(int i4) {
        EngineMsgListener engineMsgListener = this.f8905b0;
        if (engineMsgListener == null) {
            return;
        }
        if (i4 == 1) {
            engineMsgListener.onLongLinkConnect();
        } else if (i4 == 2 && this.f8917k != i4) {
            engineMsgListener.onLongLinkDisConnect();
        }
        this.f8917k = i4;
    }

    public void setOverlayListener(w wVar) {
        this.mOverlayListener = wVar;
    }

    public void setOverlayMapCallBack(p pVar) {
        AppBaseMap appBaseMap;
        if (pVar == null || (appBaseMap = this.f8928v) == null) {
            return;
        }
        appBaseMap.SetCallback(pVar);
    }

    public void setOverlookGestureEnable(boolean z4) {
        this.f8897S = z4;
    }

    public void setPointGesturesCenter(Point point) {
        this.f8923q = point;
    }

    public void setRecommendPOIScene(RecommendPoiScene recommendPoiScene) {
        if (a()) {
            this.f8928v.setRecommendPOIScene(recommendPoiScene.value);
        }
    }

    public void setSDKLayerBelowBmLayer(boolean z4) {
        this.f8899V = z4;
    }

    public void setScreenSize(int i4, int i5) {
        this.f8931y = i4;
        this.f8932z = i5;
    }

    public void setStreetArrowClickListener(y yVar) {
        this.f8903Z = yVar;
    }

    public void setStreetArrowShow(boolean z4) {
        if (a()) {
            this.f8928v.SetStreetArrowShow(z4);
        }
    }

    public void setStreetMarkerClickable(String str, boolean z4) {
        if (a()) {
            this.f8928v.SetStreetMarkerClickable(str, z4);
        }
    }

    public void setStreetRoadClickable(boolean z4) {
        if (a()) {
            this.f8928v.SetStreetRoadClickable(z4);
        }
    }

    public void setStyleMode(MapStyleMode mapStyleMode) {
        if (a()) {
            this.f8928v.SetStyleMode(mapStyleMode.getMode());
        }
    }

    public void setSupBackgroundDraw(boolean z4) {
        AppBaseMap appBaseMap = this.f8928v;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setSupBackgroundDraw(z4);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z4, String str) {
        if (a()) {
            this.f8928v.SetTargetStreetCustomMarkerVisibility(z4, str);
        }
    }

    public void setTravelMode(boolean z4) {
        this.f8920n = z4;
    }

    public void setTwoTouchClickZoomEnabled(boolean z4) {
        this.f8887I = z4;
    }

    public void setUniversalFilter(String str) {
        if (a()) {
            this.f8928v.setUniversalFilter(str);
        }
    }

    public void showBaseIndoorMap(boolean z4) {
        if (a()) {
            this.f8928v.ShowBaseIndoorMap(z4);
        }
    }

    public void showStreetPOIMarker(boolean z4) {
        if (a()) {
            this.f8928v.ShowStreetPOIMarker(z4);
        }
    }

    public void showUniversalLayer(Bundle bundle) {
        if (a()) {
            this.f8928v.showUniversalLayer(bundle);
        }
    }

    public void startIndoorAnimation() {
        if (a()) {
            this.f8928v.StartIndoorAnimation();
        }
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        if (a()) {
            return this.f8928v.SwitchBaseIndoorMapFloor(str, str2);
        }
        return false;
    }

    public void unInit() {
        AppBaseMap appBaseMap;
        d();
        Handler handler = this.f8930x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f8930x = null;
        }
        List<AppBaseMap> list = f8878g;
        if (list != null) {
            list.remove(this.f8928v);
        }
        List<v> list2 = this.mListeners;
        if (list2 != null) {
            list2.clear();
        }
        if (this.f8881C && (appBaseMap = this.f8928v) != null) {
            appBaseMap.Release();
            this.f8928v = null;
            this.f8881C = false;
        }
        if (this.f8904a0 != null) {
            this.f8904a0 = null;
        }
    }

    public void unInitForMultiTextureView() {
        AppBaseMap appBaseMap;
        if (!this.f8881C || (appBaseMap = this.f8928v) == null) {
            return;
        }
        appBaseMap.Release();
        this.f8928v = null;
        this.f8881C = false;
    }

    public void updateDrawFPS() {
        if (a()) {
            this.f8928v.updateDrawFPS();
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        this.f8928v.updateOneOverlayItem(bundle);
    }

    public int MapMsgProc(int i4, int i5, int i6, int i7, int i8, double d4, double d5, double d6, double d7) {
        if (a()) {
            return MapProc(this.f8929w, i4, i5, i6, i7, i8, d4, d5, d6, d7);
        }
        return -1;
    }

    private boolean a() {
        return this.f8881C && this.f8928v != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0243 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0254 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x025d A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0267 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0270 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x027a A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0283 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x028d A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0296 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02a0 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a9 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02b3 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02bc A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c6 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02cf A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d9 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02e4 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016d A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0179 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0185 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a2 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b0 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bc A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ca A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d8 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ef A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020e A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021c A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0233 A[Catch: JSONException -> 0x0313, TryCatch #1 {JSONException -> 0x0313, blocks: (B:13:0x0064, B:15:0x007e, B:16:0x0084, B:136:0x02ea, B:25:0x00b6, B:28:0x00c5, B:32:0x00d6, B:34:0x00e1, B:36:0x00ef, B:41:0x0106, B:43:0x010c, B:50:0x013c, B:57:0x0167, B:59:0x016d, B:60:0x0173, B:62:0x0179, B:63:0x017f, B:65:0x0185, B:66:0x018b, B:68:0x0194, B:69:0x019a, B:71:0x01a2, B:72:0x01a8, B:74:0x01b0, B:75:0x01b6, B:77:0x01bc, B:78:0x01c2, B:80:0x01ca, B:81:0x01d0, B:83:0x01d8, B:84:0x01e7, B:86:0x01ef, B:89:0x0208, B:91:0x020e, B:92:0x0214, B:94:0x021c, B:96:0x022b, B:98:0x0233, B:99:0x023b, B:101:0x0243, B:102:0x024b, B:104:0x0254, B:106:0x025f, B:108:0x0267, B:110:0x0272, B:112:0x027a, B:114:0x0285, B:116:0x028d, B:118:0x0298, B:120:0x02a0, B:122:0x02ab, B:124:0x02b3, B:126:0x02be, B:128:0x02c6, B:130:0x02d1, B:132:0x02d9, B:135:0x02e7, B:134:0x02e4, B:129:0x02cf, B:125:0x02bc, B:121:0x02a9, B:117:0x0296, B:113:0x0283, B:109:0x0270, B:105:0x025d, B:49:0x0135, B:46:0x0123, B:52:0x0141, B:54:0x014f, B:56:0x0155, B:37:0x00f6, B:39:0x00fc, B:40:0x0103, B:33:0x00dd, B:137:0x0309, B:21:0x0092, B:18:0x008a), top: B:145:0x0064, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(int r32, int r33) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.b(int, int):boolean");
    }

    private void c() {
        this.f8885G = false;
        this.f8891M = Property.DEFAULT_FLOAT_VALUE;
        this.f8889K = -1.0f;
        this.f8890L = -1.0f;
    }

    public void d(int i4, int i5) {
        if (a()) {
            this.f8928v.MoveToScrPoint(i4, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0198 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x027c A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x028d A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x029d A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ad A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02bd A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02cd A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02dd A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ef A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ff A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x030f A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x031d A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x032b A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033b A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034b A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0366 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0381 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0391 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03a1 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03b1 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03c1 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03cc A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03d7 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03e0 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03eb A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03f4 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03ff A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0408 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0412 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x041b A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0425 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x042e A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0439 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0442 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x044d A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x045d A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0466 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0470 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0479 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0483 A[Catch: JSONException -> 0x0102, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0497 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04a1 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04ac A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04b5 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04bf A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04c8 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04d2 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04de A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0701 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0761 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x076f A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x077e A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:51:0x00ef, B:101:0x0192, B:103:0x0198, B:385:0x067e, B:106:0x01ba, B:108:0x01c7, B:112:0x01d4, B:115:0x01dc, B:117:0x01e5, B:119:0x01f3, B:126:0x020e, B:128:0x0216, B:135:0x0242, B:142:0x0274, B:144:0x027c, B:145:0x0285, B:147:0x028d, B:148:0x0295, B:150:0x029d, B:151:0x02a5, B:153:0x02ad, B:154:0x02b5, B:156:0x02bd, B:157:0x02c5, B:159:0x02cd, B:160:0x02d5, B:162:0x02dd, B:163:0x02e5, B:165:0x02ef, B:166:0x02f7, B:168:0x02ff, B:169:0x0307, B:171:0x030f, B:172:0x0317, B:174:0x031d, B:175:0x0323, B:177:0x032b, B:178:0x0333, B:180:0x033b, B:181:0x0343, B:183:0x034b, B:184:0x035e, B:186:0x0366, B:187:0x0379, B:189:0x0381, B:190:0x0389, B:192:0x0391, B:193:0x0399, B:195:0x03a1, B:196:0x03a9, B:198:0x03b1, B:199:0x03b9, B:201:0x03c1, B:203:0x03cf, B:205:0x03d7, B:207:0x03e3, B:209:0x03eb, B:211:0x03f7, B:213:0x03ff, B:215:0x040a, B:217:0x0412, B:219:0x041d, B:221:0x0425, B:223:0x0431, B:225:0x0439, B:227:0x0445, B:229:0x044d, B:230:0x0455, B:232:0x045d, B:234:0x0468, B:236:0x0470, B:238:0x047b, B:240:0x0483, B:244:0x048f, B:246:0x0497, B:248:0x04a4, B:250:0x04ac, B:252:0x04b7, B:254:0x04bf, B:256:0x04ca, B:258:0x04d2, B:261:0x04de, B:263:0x04ff, B:384:0x067b, B:306:0x056d, B:312:0x057f, B:325:0x05a5, B:327:0x05ab, B:423:0x06ec, B:425:0x06f2, B:427:0x06f8, B:428:0x0701, B:430:0x0707, B:431:0x070f, B:433:0x0715, B:434:0x071d, B:436:0x0723, B:437:0x072b, B:439:0x0731, B:440:0x0739, B:442:0x073f, B:443:0x0747, B:447:0x0751, B:448:0x0759, B:449:0x0761, B:451:0x0767, B:452:0x076f, B:454:0x0775, B:455:0x077e, B:457:0x0784, B:332:0x05be, B:334:0x05c4, B:339:0x05d4, B:340:0x05d7, B:342:0x05dd, B:345:0x05eb, B:347:0x05f1, B:352:0x0602, B:356:0x060f, B:358:0x0615, B:372:0x0644, B:374:0x064c, B:376:0x0652, B:377:0x065a, B:381:0x0669, B:255:0x04c8, B:251:0x04b5, B:247:0x04a1, B:237:0x0479, B:233:0x0466, B:226:0x0442, B:222:0x042e, B:218:0x041b, B:214:0x0408, B:210:0x03f4, B:206:0x03e0, B:202:0x03cc, B:134:0x023c, B:131:0x022d, B:137:0x0249, B:139:0x0254, B:141:0x025c, B:120:0x01fa, B:122:0x0202, B:116:0x01e3, B:86:0x0138, B:89:0x0149, B:92:0x015c, B:96:0x016b, B:98:0x017f, B:99:0x0185), top: B:461:0x00ed }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(int r30, int r31) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.a(int, int):boolean");
    }

    private void d() {
        MessageProxy.unRegisterMessageHandler(4000, this.f8930x);
        MessageProxy.unRegisterMessageHandler(519, this.f8930x);
        MessageProxy.unRegisterMessageHandler(39, this.f8930x);
        MessageProxy.unRegisterMessageHandler(512, this.f8930x);
        MessageProxy.unRegisterMessageHandler(65297, this.f8930x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.f8930x);
        MessageProxy.unRegisterMessageHandler(50, this.f8930x);
        MessageProxy.unRegisterMessageHandler(51, this.f8930x);
        MessageProxy.unRegisterMessageHandler(65301, this.f8930x);
        MessageProxy.unRegisterMessageHandler(41, this.f8930x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.f8930x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.f8930x);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c(int r9, int r10) throws org.json.JSONException {
        /*
            r8 = this;
            boolean r0 = r8.a()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.ref.SoftReference<com.baidu.platform.comapi.map.MapViewInterface> r0 = r8.f8907d0
            if (r0 == 0) goto Lc0
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L14
            goto Lc0
        L14:
            com.baidu.platform.comjni.map.basemap.AppBaseMap r2 = r8.f8928v
            int r7 = r8.nearlyRadius
            r3 = -1
            r5 = r9
            r6 = r10
            java.lang.String r0 = r2.GetNearlyObjID(r3, r5, r6, r7)
            if (r0 == 0) goto L81
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L81
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3c
            r2.<init>(r0)     // Catch: org.json.JSONException -> L3c
            java.lang.String r0 = "px"
            r2.put(r0, r9)     // Catch: org.json.JSONException -> L3a
            java.lang.String r9 = "py"
            r2.put(r9, r10)     // Catch: org.json.JSONException -> L3a
            goto L41
        L3a:
            r9 = move-exception
            goto L3e
        L3c:
            r9 = move-exception
            r2 = 0
        L3e:
            r9.printStackTrace()
        L41:
            java.util.List<com.baidu.platform.comapi.map.v> r9 = r8.mListeners
            if (r9 == 0) goto Lc0
            r9 = r1
            r10 = r9
        L47:
            java.util.List<com.baidu.platform.comapi.map.v> r0 = r8.mListeners
            int r0 = r0.size()
            if (r9 >= r0) goto L7f
            java.util.List<com.baidu.platform.comapi.map.v> r0 = r8.mListeners
            java.lang.Object r0 = r0.get(r9)
            com.baidu.platform.comapi.map.v r0 = (com.baidu.platform.comapi.map.v) r0
            if (r2 == 0) goto L7c
            if (r0 == 0) goto L7c
            java.lang.String r3 = r2.toString()
            r0.b(r3)
            java.lang.String r0 = "dataset"
            org.json.JSONArray r0 = r2.optJSONArray(r0)
            if (r0 == 0) goto L7c
            org.json.JSONObject r0 = r0.optJSONObject(r1)
            if (r0 == 0) goto L7c
            java.lang.String r3 = "ty"
            int r0 = r0.optInt(r3)
            r3 = 90909(0x1631d, float:1.2739E-40)
            if (r0 < r3) goto L7c
            r10 = 1
        L7c:
            int r9 = r9 + 1
            goto L47
        L7f:
            r1 = r10
            goto Lc0
        L81:
            boolean r0 = r8.f8926t
            if (r0 != 0) goto Lc0
            java.util.List<com.baidu.platform.comapi.map.v> r0 = r8.mListeners
            if (r0 == 0) goto Lc0
            com.baidu.platform.comapi.map.MapViewInterface r0 = r8.getMapView()
            if (r0 == 0) goto Lc0
            com.baidu.platform.comapi.map.MapViewInterface r0 = r8.getMapView()
            com.baidu.platform.comapi.map.Projection r0 = r0.getProjection()
            if (r0 != 0) goto L9a
            goto Lc0
        L9a:
            com.baidu.platform.comapi.map.MapViewInterface r0 = r8.getMapView()
            com.baidu.platform.comapi.map.Projection r0 = r0.getProjection()
            com.baidu.platform.comapi.basestruct.GeoPoint r9 = r0.fromPixels(r9, r10)
            r10 = r1
        La7:
            java.util.List<com.baidu.platform.comapi.map.v> r0 = r8.mListeners
            int r0 = r0.size()
            if (r10 >= r0) goto Lc0
            java.util.List<com.baidu.platform.comapi.map.v> r0 = r8.mListeners
            java.lang.Object r0 = r0.get(r10)
            com.baidu.platform.comapi.map.v r0 = (com.baidu.platform.comapi.map.v) r0
            if (r0 != 0) goto Lba
            goto Lbd
        Lba:
            r0.b(r9)
        Lbd:
            int r10 = r10 + 1
            goto La7
        Lc0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.c(int, int):boolean");
    }

    public void saveScreenToLocal(String str) throws JSONException {
        saveScreenToLocal(str, 0, 0, 0, 0);
    }

    public void setMapStatus(Bundle bundle) {
        if (a()) {
            this.f8928v.SetMapStatus(bundle);
        }
    }

    public void setMapStatus(MapStatus mapStatus) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt(ViewTweenItem.LEFT, mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(ViewTweenItem.TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animatime", mapStatus.animationTime);
        bundle.putInt("animation", mapStatus.hasAnimation);
        bundle.putInt("animationType", mapStatus.animationType);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        mapStatusChangeStart();
        this.f8928v.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i4) {
        if (!a() || this.f8928v == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble("rotation", mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        if (!isCompass && !this.f8888J) {
            if (this.f8923q != null && this.f8925s) {
                Projection projection = this.f8907d0.get().getProjection();
                Point point = this.f8923q;
                GeoPoint geoPointFromPixels = projection.fromPixels(point.x, point.y);
                bundle.putDouble("centerptx", geoPointFromPixels.getLongitudeE6());
                bundle.putDouble("centerpty", geoPointFromPixels.getLatitudeE6());
            } else {
                LatLng latLng = this.f8924r;
                if (latLng != null && this.f8925s) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
                    bundle.putDouble("centerptx", geoPointLl2mc.getLongitudeE6());
                    bundle.putDouble("centerpty", geoPointLl2mc.getLatitudeE6());
                } else {
                    bundle.putDouble("centerptx", mapStatus.centerPtX);
                    bundle.putDouble("centerpty", mapStatus.centerPtY);
                }
            }
        } else {
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
        }
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt(ViewTweenItem.LEFT, mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(ViewTweenItem.TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i4);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        mapStatusChangeStart();
        this.mIsAnimating = true;
        this.f8928v.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i4, int i5) {
        if (!a() || this.f8928v == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("animationType", i4);
        bundle.putInt("animatime", i5);
        bundle.putInt(ViewTweenItem.LEFT, mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(ViewTweenItem.TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        if (i4 != 4) {
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble("rotation", mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        }
        this.f8928v.SetNewMapStatus(bundle);
    }

    private void b() {
        MessageProxy.registerMessageHandler(4000, this.f8930x);
        MessageProxy.registerMessageHandler(519, this.f8930x);
        MessageProxy.registerMessageHandler(39, this.f8930x);
        MessageProxy.registerMessageHandler(512, this.f8930x);
        MessageProxy.registerMessageHandler(65297, this.f8930x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.f8930x);
        MessageProxy.registerMessageHandler(50, this.f8930x);
        MessageProxy.registerMessageHandler(51, this.f8930x);
        MessageProxy.registerMessageHandler(65301, this.f8930x);
        MessageProxy.registerMessageHandler(41, this.f8930x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.f8930x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.f8930x);
    }

    private void a(MotionEvent motionEvent) {
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        f8874c = x4;
        f8875d = y4;
        MapMsgProc(4, 0, x4 | (y4 << 16));
        f8876e = true;
        this.f8909f0 = motionEvent.getDownTime();
    }

    private boolean a(int i4, int i5, boolean z4) {
        SoftReference<MapViewInterface> softReference = this.f8907d0;
        if (softReference != null && softReference.get() != null) {
            int zoomUnitsInMeter = (int) (getZoomUnitsInMeter() * this.nearlyRadius);
            MapViewInterface mapViewInterface = this.f8907d0.get();
            for (int size = mapViewInterface.getBmlayers().size() - 1; size >= 0; size--) {
                if (mapViewInterface.getBmlayers().get(size).a(i4, i5, zoomUnitsInMeter, z4, this.f8899V)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(int r18, int r19, int r20) throws org.json.JSONException {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r17.a()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            java.lang.ref.SoftReference<com.baidu.platform.comapi.map.MapViewInterface> r1 = r0.f8907d0
            if (r1 == 0) goto Lc6
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L16
            goto Lc6
        L16:
            java.lang.ref.SoftReference<com.baidu.platform.comapi.map.MapViewInterface> r1 = r0.f8907d0
            java.lang.Object r1 = r1.get()
            com.baidu.platform.comapi.map.MapViewInterface r1 = (com.baidu.platform.comapi.map.MapViewInterface) r1
            r3 = 1
            r4 = -1
            r5 = 0
            java.util.List r7 = r1.getOverlays()     // Catch: org.json.JSONException -> L89
            int r7 = r7.size()     // Catch: org.json.JSONException -> L89
            int r7 = r7 - r3
        L2b:
            if (r7 < 0) goto L8b
            java.util.List r8 = r1.getOverlays()     // Catch: org.json.JSONException -> L89
            java.lang.Object r8 = r8.get(r7)     // Catch: org.json.JSONException -> L89
            com.baidu.platform.comapi.map.Overlay r8 = (com.baidu.platform.comapi.map.Overlay) r8     // Catch: org.json.JSONException -> L89
            int r9 = r8.mType     // Catch: org.json.JSONException -> L89
            r10 = 27
            if (r9 == r10) goto L3e
            goto L86
        L3e:
            long r5 = r8.mLayerID     // Catch: org.json.JSONException -> L89
            int r8 = r0.nearlyRadius     // Catch: org.json.JSONException -> L89
            double r8 = (double) r8     // Catch: org.json.JSONException -> L89
            double r10 = r17.getZoomUnitsInMeter()     // Catch: org.json.JSONException -> L89
            double r8 = r8 * r10
            int r8 = (int) r8     // Catch: org.json.JSONException -> L89
            com.baidu.platform.comjni.map.basemap.AppBaseMap r11 = r0.f8928v     // Catch: org.json.JSONException -> L89
            if (r11 == 0) goto L86
            r12 = r5
            r14 = r19
            r15 = r20
            r16 = r8
            java.lang.String r8 = r11.GetNearlyObjID(r12, r14, r15, r16)     // Catch: org.json.JSONException -> L89
            if (r8 == 0) goto L86
            java.lang.String r9 = ""
            boolean r9 = r8.equals(r9)     // Catch: org.json.JSONException -> L89
            if (r9 != 0) goto L86
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L89
            r7.<init>(r8)     // Catch: org.json.JSONException -> L89
            java.lang.String r8 = "dataset"
            org.json.JSONArray r7 = r7.getJSONArray(r8)     // Catch: org.json.JSONException -> L89
            java.lang.Object r7 = r7.get(r2)     // Catch: org.json.JSONException -> L89
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch: org.json.JSONException -> L89
            java.lang.String r8 = "itemindex"
            int r8 = r7.getInt(r8)     // Catch: org.json.JSONException -> L89
            java.lang.String r9 = "clickindex"
            int r2 = r7.optInt(r9, r4)     // Catch: org.json.JSONException -> L8f
            r11 = r2
            r2 = r3
        L81:
            r13 = r5
            r10 = r8
        L83:
            r5 = r18
            goto L91
        L86:
            int r7 = r7 + (-1)
            goto L2b
        L89:
            r8 = r4
            goto L8f
        L8b:
            r10 = r4
            r11 = r10
            r13 = r5
            goto L83
        L8f:
            r11 = r4
            goto L81
        L91:
            if (r5 != r3) goto Lc6
            com.baidu.platform.comapi.map.MapViewListener r3 = r17.getMapViewListener()
            if (r3 == 0) goto Lc6
            com.baidu.platform.comapi.map.MapViewInterface r3 = r17.getMapView()
            if (r3 == 0) goto Lc6
            com.baidu.platform.comapi.map.MapViewInterface r3 = r17.getMapView()
            com.baidu.platform.comapi.map.Projection r3 = r3.getProjection()
            if (r3 == 0) goto Lc6
            com.baidu.platform.comapi.map.Projection r1 = r1.getProjection()
            r3 = r19
            r5 = r20
            com.baidu.platform.comapi.basestruct.GeoPoint r12 = r1.fromPixels(r3, r5)
            if (r11 == r4) goto Lbf
            com.baidu.platform.comapi.map.MapViewListener r9 = r17.getMapViewListener()
            r9.onClickedItem(r10, r11, r12, r13)
            goto Lc6
        Lbf:
            com.baidu.platform.comapi.map.MapViewListener r0 = r17.getMapViewListener()
            r0.onClickedItem(r10, r12, r13)
        Lc6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapController.a(int, int, int):boolean");
    }

    private MapStatus a(boolean z4) {
        if (!a()) {
            return new MapStatus();
        }
        Bundle bundleGetMapStatus = this.f8928v.GetMapStatus(z4);
        if (bundleGetMapStatus == null) {
            return new MapStatus();
        }
        MapStatus mapStatus = new MapStatus();
        mapStatus.level = (float) bundleGetMapStatus.getDouble("level");
        mapStatus.rotation = (int) bundleGetMapStatus.getDouble("rotation");
        mapStatus.overlooking = (int) bundleGetMapStatus.getDouble("overlooking");
        mapStatus.centerPtX = bundleGetMapStatus.getDouble("centerptx");
        mapStatus.centerPtY = bundleGetMapStatus.getDouble("centerpty");
        mapStatus.centerPtZ = bundleGetMapStatus.getDouble("centerptz");
        mapStatus.winRound.left = bundleGetMapStatus.getInt(ViewTweenItem.LEFT);
        mapStatus.winRound.right = bundleGetMapStatus.getInt("right");
        mapStatus.winRound.top = bundleGetMapStatus.getInt(ViewTweenItem.TOP);
        mapStatus.winRound.bottom = bundleGetMapStatus.getInt("bottom");
        mapStatus.geoRound.left = bundleGetMapStatus.getLong("gleft");
        mapStatus.geoRound.right = bundleGetMapStatus.getLong("gright");
        mapStatus.geoRound.top = bundleGetMapStatus.getLong("gtop");
        mapStatus.geoRound.bottom = bundleGetMapStatus.getLong("gbottom");
        mapStatus.xOffset = bundleGetMapStatus.getFloat("xoffset");
        mapStatus.yOffset = bundleGetMapStatus.getFloat("yoffset");
        mapStatus.bfpp = bundleGetMapStatus.getInt("bfpp") == 1;
        mapStatus.panoId = bundleGetMapStatus.getString("panoid");
        mapStatus.streetIndicateAngle = bundleGetMapStatus.getFloat("siangle");
        mapStatus.isBirdEye = bundleGetMapStatus.getInt("isbirdeye") == 1;
        mapStatus.streetExt = bundleGetMapStatus.getInt("ssext");
        mapStatus.roadOffsetX = bundleGetMapStatus.getFloat("roadOffsetX");
        mapStatus.roadOffsetY = bundleGetMapStatus.getFloat("roadOffsetY");
        mapStatus.bOverlookSpringback = bundleGetMapStatus.getInt("boverlookback") == 1;
        mapStatus.minOverlooking = (int) bundleGetMapStatus.getFloat("minoverlook");
        mapStatus.xScreenOffset = bundleGetMapStatus.getFloat("xScreenOffset");
        mapStatus.yScreenOffset = bundleGetMapStatus.getFloat("yScreenOffset");
        mapStatus.adapterZoomUnits = bundleGetMapStatus.getFloat("adapterZoomUnits");
        MapStatus.GeoBound geoBound = mapStatus.geoRound;
        if (geoBound.left <= -20037508) {
            geoBound.left = -20037508L;
        }
        if (geoBound.right >= 20037508) {
            geoBound.right = 20037508L;
        }
        if (geoBound.top >= 20037508) {
            geoBound.top = 20037508L;
        }
        if (geoBound.bottom <= -20037508) {
            geoBound.bottom = -20037508L;
        }
        return mapStatus;
    }
}
