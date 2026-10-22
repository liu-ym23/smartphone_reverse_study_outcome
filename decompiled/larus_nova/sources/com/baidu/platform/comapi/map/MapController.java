package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import androidx.core.text.util.LocalePreferences;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f33011a = "MapController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f33012b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static float f33013c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static float f33014d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f33015e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f33016f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static List<AppBaseMap> f33017g = null;
    public static boolean isCompass = false;
    public static boolean mLocIconOnScreen = true;
    public static boolean m_registered_SENSOR_ORIENTATION;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private a E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f33018J;
    private float K;
    private float L;
    private float M;
    private long N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    MapViewListener W;
    CaptureMapListener X;
    g Y;
    y Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    MapRenderModeChangeListener f33019a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    EngineMsgListener f33020b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    MapViewSurfaceListener f33021c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    SoftReference<MapViewInterface> f33022d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    NaviMapViewListener f33023e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private long f33024f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f33025g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.c f33026h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f33027h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f33028i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.b f33029i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f33030j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private MapControlMode f33031j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f33032k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f33033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f33034m;
    public boolean mHasBmDrawItemDraging;
    public boolean mHasMapObjDraging;
    public boolean mIsAnimating;
    public boolean mIsInertialAnimation;
    public boolean mIsMapLoadFinish;
    public boolean mIsMapLoadStart;
    public boolean mIsMoving;
    public List<v> mListeners;
    public float mMaxZoomLevel;
    public float mMinZoomLevel;
    public w mOverlayListener;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f33035n;
    public int nearlyRadius;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MapFirstFrameCallback f33036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f33037p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Point f33038q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LatLng f33039r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f33040s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f33041t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f33042u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AppBaseMap f33043v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f33044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Handler f33045x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f33046y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f33047z;

    public static final enum HeatMapType extends Enum<HeatMapType> {
        public static final HeatMapType CEMETERY = null;
        public static final HeatMapType CITY = null;
        public static final HeatMapType SCENERY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ HeatMapType[] f33048a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33049b;

        static {
            HeatMapType r100 = new HeatMapType("CITY", 0, 0);
            CITY = r100;
            HeatMapType r101 = new HeatMapType("SCENERY", 1, 1);
            SCENERY = r101;
            HeatMapType r102 = new HeatMapType("CEMETERY", 2, 2);
            CEMETERY = r102;
            f33048a = new HeatMapType[]{r100, r101, r102};
        }

        public static HeatMapType[] values() {
            return (HeatMapType[]) f33048a.clone();
        }

        public int getId() {
            return this.f33049b;
        }

        public static HeatMapType valueOf(String r100) {
            return (HeatMapType) r27.a.a(HeatMapType.class, r100);
        }

        private HeatMapType(String r100, int r101, int r102) {
            super(r100, r101);
            this.f33049b = r102;
        }
    }

    public static final enum MapControlMode extends Enum<MapControlMode> {
        public static final MapControlMode DEFAULT = null;
        public static final MapControlMode INDOOR = null;
        public static final MapControlMode STREET = null;
        public static final MapControlMode STREET_WAITING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ MapControlMode[] f33050a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33051b;

        static {
            MapControlMode r100 = new MapControlMode("DEFAULT", 0, 1);
            DEFAULT = r100;
            MapControlMode r101 = new MapControlMode("INDOOR", 1, 2);
            INDOOR = r101;
            MapControlMode r102 = new MapControlMode("STREET", 2, 3);
            STREET = r102;
            MapControlMode r103 = new MapControlMode("STREET_WAITING", 3, 4);
            STREET_WAITING = r103;
            f33050a = new MapControlMode[]{r100, r101, r102, r103};
        }

        public static MapControlMode[] values() {
            return (MapControlMode[]) f33050a.clone();
        }

        public static /* synthetic */ int a(MapControlMode r100) {
            return r100.f33051b;
        }

        public static MapControlMode valueOf(String r100) {
            return (MapControlMode) r27.a.a(MapControlMode.class, r100);
        }

        private MapControlMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.f33051b = r102;
        }
    }

    public interface MapFirstFrameCallback {
        void onFirstFrameDrawing(MapController r100);
    }

    public static final enum MapLayerType extends Enum<MapLayerType> {
        public static final MapLayerType DEFAULT = null;
        public static final MapLayerType INDOOR = null;
        public static final MapLayerType SATELLITE = null;
        public static final MapLayerType STREET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ MapLayerType[] f33052a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33053b;

        static {
            MapLayerType r100 = new MapLayerType("DEFAULT", 0, 1);
            DEFAULT = r100;
            MapLayerType r101 = new MapLayerType("SATELLITE", 1, 2);
            SATELLITE = r101;
            MapLayerType r102 = new MapLayerType("INDOOR", 2, 3);
            INDOOR = r102;
            MapLayerType r103 = new MapLayerType("STREET", 3, 5);
            STREET = r103;
            f33052a = new MapLayerType[]{r100, r101, r102, r103};
        }

        public static MapLayerType[] values() {
            return (MapLayerType[]) f33052a.clone();
        }

        public static /* synthetic */ int a(MapLayerType r100) {
            return r100.f33053b;
        }

        public static MapLayerType valueOf(String r100) {
            return (MapLayerType) r27.a.a(MapLayerType.class, r100);
        }

        private MapLayerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.f33053b = r102;
        }
    }

    public static final enum MapSceneMode extends Enum<MapSceneMode> {
        public static final MapSceneMode DEFAULT = null;
        public static final MapSceneMode INDOOR = null;
        public static final MapSceneMode INTERNAL = null;
        public static final MapSceneMode POI = null;
        public static final MapSceneMode ROUTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ MapSceneMode[] f33054a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33055b;

        static {
            MapSceneMode r100 = new MapSceneMode("DEFAULT", 0, 0);
            DEFAULT = r100;
            MapSceneMode r101 = new MapSceneMode("POI", 1, 1);
            POI = r101;
            MapSceneMode r102 = new MapSceneMode("ROUTE", 2, 2);
            ROUTE = r102;
            MapSceneMode r103 = new MapSceneMode("INTERNAL", 3, 3);
            INTERNAL = r103;
            MapSceneMode r104 = new MapSceneMode("INDOOR", 4, 7);
            INDOOR = r104;
            f33054a = new MapSceneMode[]{r100, r101, r102, r103, r104};
        }

        public static MapSceneMode[] values() {
            return (MapSceneMode[]) f33054a.clone();
        }

        public int getMode() {
            return this.f33055b;
        }

        public static MapSceneMode valueOf(String r100) {
            return (MapSceneMode) r27.a.a(MapSceneMode.class, r100);
        }

        private MapSceneMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.f33055b = r102;
        }
    }

    public static final enum MapStyleMode extends Enum<MapStyleMode> {
        public static final MapStyleMode DEFAULT = null;
        public static final MapStyleMode FOOT_PRINT = null;
        public static final MapStyleMode INTERNAL = null;
        public static final MapStyleMode INTERNAL_SPECIAL = null;
        public static final MapStyleMode NAV_DAY = null;
        public static final MapStyleMode NAV_NIGHT = null;
        public static final MapStyleMode SEARCH_POI = null;
        public static final MapStyleMode SEARCH_ROUTE = null;
        public static final MapStyleMode WALK_DAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ MapStyleMode[] f33056a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33057b;

        static {
            MapStyleMode r100 = new MapStyleMode("DEFAULT", 0, 1);
            DEFAULT = r100;
            MapStyleMode r101 = new MapStyleMode("SEARCH_POI", 1, 2);
            SEARCH_POI = r101;
            MapStyleMode r102 = new MapStyleMode("SEARCH_ROUTE", 2, 3);
            SEARCH_ROUTE = r102;
            MapStyleMode r103 = new MapStyleMode("NAV_DAY", 3, 4);
            NAV_DAY = r103;
            MapStyleMode r104 = new MapStyleMode("NAV_NIGHT", 4, 5);
            NAV_NIGHT = r104;
            MapStyleMode r110 = new MapStyleMode("WALK_DAY", 5, 6);
            WALK_DAY = r110;
            MapStyleMode r111 = new MapStyleMode("INTERNAL", 6, 7);
            INTERNAL = r111;
            MapStyleMode r112 = new MapStyleMode("INTERNAL_SPECIAL", 7, 8);
            INTERNAL_SPECIAL = r112;
            MapStyleMode r113 = new MapStyleMode("FOOT_PRINT", 8, 9);
            FOOT_PRINT = r113;
            f33056a = new MapStyleMode[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
        }

        public static MapStyleMode[] values() {
            return (MapStyleMode[]) f33056a.clone();
        }

        public int getMode() {
            return this.f33057b;
        }

        public static MapStyleMode valueOf(String r100) {
            return (MapStyleMode) r27.a.a(MapStyleMode.class, r100);
        }

        private MapStyleMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.f33057b = r102;
        }
    }

    public static final enum RecommendPoiScene extends Enum<RecommendPoiScene> {
        public static final RecommendPoiScene BASE = null;
        public static final RecommendPoiScene INTERNATIONAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ RecommendPoiScene[] f33058a = null;
        public int value;

        static {
            RecommendPoiScene r100 = new RecommendPoiScene("BASE", 0, 0);
            BASE = r100;
            RecommendPoiScene r101 = new RecommendPoiScene("INTERNATIONAL", 1, 1);
            INTERNATIONAL = r101;
            f33058a = new RecommendPoiScene[]{r100, r101};
        }

        public static RecommendPoiScene[] values() {
            return (RecommendPoiScene[]) f33058a.clone();
        }

        public static RecommendPoiScene valueOf(String r100) {
            return (RecommendPoiScene) r27.a.a(RecommendPoiScene.class, r100);
        }

        private RecommendPoiScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum RecycleMemoryLevel extends Enum<RecycleMemoryLevel> {
        public static final RecycleMemoryLevel FULL = null;
        public static final RecycleMemoryLevel NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ RecycleMemoryLevel[] f33059a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33060b;

        static {
            RecycleMemoryLevel r100 = new RecycleMemoryLevel(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            RecycleMemoryLevel r101 = new RecycleMemoryLevel("FULL", 1, 1);
            FULL = r101;
            f33059a = new RecycleMemoryLevel[]{r100, r101};
        }

        public static RecycleMemoryLevel[] values() {
            return (RecycleMemoryLevel[]) f33059a.clone();
        }

        public int getLevel() {
            return this.f33060b;
        }

        public static RecycleMemoryLevel valueOf(String r100) {
            return (RecycleMemoryLevel) r27.a.a(RecycleMemoryLevel.class, r100);
        }

        private RecycleMemoryLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.f33060b = r102;
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f33062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        GeoPoint f33063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.baidu.platform.comapi.basestruct.Point f33064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MapController f33065e;

        public void a() {
            this.f33061a = false;
            this.f33062b = 0.0f;
            this.f33063c = null;
            this.f33064d = null;
        }

        public a(MapController r100) {
            this.f33065e = r100;
            this.f33061a = false;
            this.f33062b = 0.0f;
        }
    }

    public class b extends com.baidu.platform.comapi.util.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapController f33066a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MapStatus f33067a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f33068b;

            @Override // java.lang.Runnable
            public void run() {
                com_baidu_platform_comapi_map_MapController$b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_baidu_platform_comapi_map_MapController$b$a__run$___twin___() {
                if (this.f33068b.f33066a.getMapView() != null) goto L5;
            L7:
                GeoPoint r100 = null;
            L8:
                if (r100 == null) goto L10;
                float r101 = (float) r100.getLongitudeE6();
                float r102 = (float) r100.getLatitudeE6();
                MapController.CleanAfterDBClick(MapController.a(this.f33068b.f33066a), r101, r102);
            L10:
                MapController.a(this.f33068b.f33066a, false);
                return;
            L5:
                if (this.f33068b.f33066a.getMapView().getProjection() == null) goto L7;
                r100 = this.f33068b.f33066a.f33022d0.get().getProjection().fromPixels(this.f33067a.winRound.left + (this.f33068b.f33066a.getScreenWidth() / 2), this.f33067a.winRound.top + (this.f33068b.f33066a.getScreenHeight() / 2));
                goto L8
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_platform_comapi_map_MapController$b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
                r100.com_baidu_platform_comapi_map_MapController$b$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100, MapStatus r101) {
                this.f33068b = r100;
                this.f33067a = r101;
            }
        }

        /* JADX INFO: renamed from: com.baidu.platform.comapi.map.MapController$b$b, reason: collision with other inner class name */
        public class RunnableC0663b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f33069a;

            @Override // java.lang.Runnable
            public void run() {
                com_baidu_platform_comapi_map_MapController$b$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_baidu_platform_comapi_map_MapController$b$b__run$___twin___() {
                com.baidu.mapsdkplatform.comapi.map.s r100 = this.f33069a.f33066a.getMapStatusInner();
                if (this.f33069a.f33066a.mListeners == null) goto L11;
                int r101 = 0;
            L6:
                if (r101 >= this.f33069a.f33066a.mListeners.size()) goto L15;
                v r102 = (v) ListProtector.get(this.f33069a.f33066a.mListeners, r101);
                if (r102 == null) goto L10;
                r102.d();
                MapController.d(this.f33069a.f33066a, true);
                r102.a(r100);
            L10:
                r101 = r101 + 1;
                goto L6
            L15:
                return;
            }

            public RunnableC0663b(b r100) {
                this.f33069a = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_platform_comapi_map_MapController$b$b_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0663b r100) {
                r100.com_baidu_platform_comapi_map_MapController$b$b__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(MapController r100) {
            this.f33066a = r100;
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message r100) {
            if (r100.what != 4000) goto L12;
            CaptureMapListener r101 = this.f33066a.X;
            if (r101 == null) goto L12;
            if (r100.arg2 != 1) goto L9;
            boolean r102 = true;
        L10:
            r101.onGetCaptureMap(r102);
            goto L12
        L9:
            r102 = false;
        L12:
            if (r100.what != 519) goto L17;
            g r103 = this.f33066a.Y;
            if (r103 == null) goto L17;
            r103.a();
        L17:
            if (r100.what != 65304) goto L21;
            w r104 = this.f33066a.mOverlayListener;
            if (r104 == null) goto L21;
            r104.a(r100.arg2);
        L21:
            int r105 = r100.what;
            if (r105 != 39) goto L120;
            if (((Long) r100.obj).longValue() == MapController.a(this.f33066a)) goto L26;
            return;
        L26:
            int r106 = r100.arg1;
            if (r106 == 2) goto L87;
            if (r106 == 100) goto L56;
            if (r106 != 200) goto L33;
            this.f33066a.mIsMoving = false;
        L97:
            MapController r107 = this.f33066a;
            if (r107.mIsMapLoadFinish == true) goto L111;
            if (MapController.f(r107) <= 0) goto L111;
            if (MapController.g(this.f33066a) <= 0) goto L111;
            if (this.f33066a.getMapView() == null) goto L111;
            if (this.f33066a.getMapView().getProjection() == null) goto L111;
            if (this.f33066a.getMapView().getProjection().fromPixels(0, 0) == null) goto L111;
            this.f33066a.mIsMapLoadFinish = true;
            MapTaskManager.postToMainThread(new RunnableC0663b(this), 0);
        L111:
            if (this.f33066a.mListeners == null) goto L159;
            int r108 = 0;
        L114:
            if (r108 >= this.f33066a.mListeners.size()) goto L159;
            v r109 = (v) ListProtector.get(this.f33066a.mListeners, r108);
            if (r109 == null) goto L118;
            r109.c();
        L118:
            r108 = r108 + 1;
        L159:
            if (r100.what != 512) goto L164;
            int r110 = r100.arg1;
            if (this.f33066a.getMapViewListener() == null) goto L164;
            this.f33066a.getMapViewListener().onClickedPopup(r110);
        L164:
            if (r100.what != 50) goto L195;
            if (OpenLogUtil.isMapLogEnable() == false) goto L168;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("EngineMeassage IndoorMap msg.what = " + r100.what + "; msg.arg1 = " + r100.arg1);
        L168:
            MapController r111 = this.f33066a;
            EngineMsgListener r112 = r111.f33020b0;
            if (r112 == null) goto L175;
            int r113 = r100.arg1;
            if (r113 != 1) goto L173;
            this.f33066a.f33020b0.onEnterIndoorMapMode(r111.getFocusedBaseIndoorMapInfo());
            goto L175
        L173:
            if (r113 != 0) goto L175;
            r112.onExitIndoorMapMode();
        L175:
            MapController r114 = this.f33066a;
            if (r114.mListeners != null) goto L178;
            return;
        L178:
            IndoorMapInfo r115 = r114.getFocusedBaseIndoorMapInfo();
            int r116 = 0;
        L180:
            if (r116 >= this.f33066a.mListeners.size()) goto L195;
            v r117 = (v) ListProtector.get(this.f33066a.mListeners, r116);
            if (r117 == null) goto L193;
            int r118 = r100.arg1;
            if (r118 != 0) goto L187;
            r117.a(false);
            this.f33066a.mMaxZoomLevel = 22.0f;
            goto L193
        L187:
            if (r118 != 1) goto L193;
            if (this.f33066a.getMapStatus().level < 18.0f) goto L192;
            if (r115 == null) goto L192;
            r117.a(true);
            this.f33066a.mMaxZoomLevel = 22.0f;
        L192:
            r117.a(false);
            this.f33066a.mMaxZoomLevel = 22.0f;
        L193:
            r116 = r116 + 1;
        L195:
            if (r100.what != 51) goto L198;
            this.f33066a.setNetStatus(r100.arg1);
        L198:
            if (r100.what != 65301) goto L232;
            MapController r119 = this.f33066a;
            if (r119.f33020b0 == null) goto L233;
            int r120 = r100.arg1;
            if (r120 != 1) goto L204;
            r119.getMapBarData();
            return;
        L204:
            if (r120 != 0) goto L235;
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a());
            return;
        L235:
            return;
        L233:
            return;
        L232:
            return;
        L33:
            if (r106 == 300) goto L52;
            if (r106 == 400) goto L44;
            MapRenderModeChangeListener r121 = this.f33066a.f33019a0;
            if (r121 == null) goto L40;
            r121.onMapRenderModeChange(r106);
        L40:
            if (this.f33066a.isNaviMode() == false) goto L97;
            NaviMapViewListener r122 = this.f33066a.f33023e0;
            if (r122 == null) goto L97;
            r122.onMapRenderModeChange(r100.arg1);
            goto L97
        L44:
            int r123 = 0;
        L46:
            if (r123 >= this.f33066a.mListeners.size()) goto L97;
            v r124 = (v) ListProtector.get(this.f33066a.mListeners, r123);
            if (r124 == null) goto L50;
            r124.onFirstMapTileLoaded();
        L50:
            r123 = r123 + 1;
            goto L46
        L52:
            if (MapController.e(this.f33066a) == null) goto L97;
            MapController.e(this.f33066a).onFirstFrameDrawing(this.f33066a);
            goto L97
        L56:
            if (MapController.b(this.f33066a) == false) goto L65;
            SoftReference<MapViewInterface> r125 = this.f33066a.f33022d0;
            if (r125 != null) goto L60;
            return;
        L60:
            if (r125.get() == null) goto L231;
            MapTaskManager.getDefaultThreadPool().execute(new a(this, this.f33066a.getMapStatus()));
            goto L65
        L231:
            return;
        L65:
            if (MapController.c(this.f33066a) == false) goto L67;
            MapController.b(this.f33066a, false);
        L67:
            MapController.c(this.f33066a, false);
            MapController r126 = this.f33066a;
            r126.mIsMoving = false;
            r126.mIsAnimating = false;
            if (r126.getMapViewListener() == null) goto L71;
            this.f33066a.getMapViewListener().onMapAnimationFinish();
        L71:
            if (this.f33066a.isNaviMode() == false) goto L75;
            NaviMapViewListener r127 = this.f33066a.f33023e0;
            if (r127 == null) goto L75;
            r127.onMapAnimationFinish();
        L75:
            MapController r128 = this.f33066a;
            if (r128.mListeners == null) goto L97;
            if (MapController.d(r128) == false) goto L97;
            com.baidu.mapsdkplatform.comapi.map.s r129 = this.f33066a.getMapStatusInner();
            int r130 = 0;
        L81:
            if (r130 >= this.f33066a.mListeners.size()) goto L97;
            v r131 = (v) ListProtector.get(this.f33066a.mListeners, r130);
            if (r131 == null) goto L85;
            r131.a(r129);
        L85:
            r130 = r130 + 1;
            goto L81
        L87:
            if (this.f33066a.mListeners != null) goto L89;
            return;
        L89:
            int r132 = 0;
        L91:
            if (r132 >= this.f33066a.mListeners.size()) goto L96;
            v r133 = (v) ListProtector.get(this.f33066a.mListeners, r132);
            if (r133 == null) goto L95;
            r133.b();
        L95:
            r132 = r132 + 1;
            goto L91
        L96:
            MapController r134 = this.f33066a;
            r134.mIsMoving = false;
            r134.mIsAnimating = false;
            goto L97
        L120:
            if (r105 != 41) goto L140;
            if (((Long) r100.obj).longValue() == MapController.a(this.f33066a)) goto L124;
            return;
        L124:
            MapController r135 = this.f33066a;
            if (r135.mListeners != null) goto L128;
            return;
        L128:
            if (r135.mIsMoving == false) goto L130;
        L131:
            com.baidu.mapsdkplatform.comapi.map.s r136 = r135.getMapStatusInner();
            int r137 = 0;
        L133:
            if (r137 >= this.f33066a.mListeners.size()) goto L159;
            v r138 = (v) ListProtector.get(this.f33066a.mListeners, r137);
            if (r138 == null) goto L138;
            r138.b(r136);
        L138:
            r137 = r137 + 1;
            goto L133
        L130:
            if (r135.mIsAnimating == false) goto L159;
        L140:
            if (r105 != 2082) goto L159;
            int r139 = r100.arg1;
            if (r139 != 1003) goto L144;
            r139 = 0;
            boolean r140 = true;
        L146:
            if (OpenLogUtil.isMapLogEnable() == false) goto L149;
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("onMapRenderValidFrame isValid = " + r140 + "; errorCode = " + r139);
        L149:
            if (this.f33066a.mListeners == null) goto L159;
            int r141 = 0;
        L152:
            if (r141 >= this.f33066a.mListeners.size()) goto L159;
            v r142 = (v) ListProtector.get(this.f33066a.mListeners, r141);
            if (r142 == null) goto L157;
            r142.a(r140, r139);
        L157:
            r141 = r141 + 1;
            goto L152
        L144:
            r140 = false;
            goto L146
        }
    }

    public static native int CleanAfterDBClick(long r100, float r101, float r102);

    public static int GetAdaptKeyCode(int r100) {
        switch(r100) {
            case 19: goto L7;
            case 20: goto L6;
            case 21: goto L5;
            case 22: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 18;
    L5:
        return 16;
    L6:
        return 19;
    L7:
        return 17;
    }

    public static native int MapProc(long r100, int r101, int r102, int r103, int r104, int r105, double r106, double r107, double r110, double r111);

    private void c() {
        this.G = false;
        this.M = 0.0f;
        this.K = -1.0f;
        this.L = -1.0f;
    }

    public static int getScaleDis(int r100) {
        switch(r100) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L8;
            case 19: goto L7;
            case 20: goto L6;
            case 21: goto L5;
            case 22: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 2;
    L5:
        return 5;
    L6:
        return 10;
    L7:
        return 20;
    L8:
        return 50;
    L9:
        return 100;
    L10:
        return 200;
    L11:
        return 500;
    L12:
        return 1000;
    L13:
        return 2000;
    L14:
        return 5000;
    L15:
        return 10000;
    L16:
        return 20000;
    L17:
        return 25000;
    L18:
        return 50000;
    L19:
        return 100000;
    L20:
        return 200000;
    L21:
        return 500000;
    L22:
        return 1000000;
    L23:
        return 2000000;
    L24:
        return 5000000;
    L25:
        return 10000000;
    }

    public MapStatus getCurrentMapStatus() {
        return a(false);
    }

    public MapStatus getMapStatus() {
        return a(true);
    }

    public boolean handlePopupClick(int r100, int r101) {
        return false;
    }

    public boolean isPressedOnPopup(int r100, int r101) {
        return false;
    }

    static {
        f33017g = new ArrayList();
    }

    private boolean a() {
        if (this.C == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f33043v == null) goto L7;
        return true;
    }

    private void b() {
        MessageProxy.registerMessageHandler(4000, this.f33045x);
        MessageProxy.registerMessageHandler(519, this.f33045x);
        MessageProxy.registerMessageHandler(39, this.f33045x);
        MessageProxy.registerMessageHandler(512, this.f33045x);
        MessageProxy.registerMessageHandler(65297, this.f33045x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.f33045x);
        MessageProxy.registerMessageHandler(50, this.f33045x);
        MessageProxy.registerMessageHandler(51, this.f33045x);
        MessageProxy.registerMessageHandler(65301, this.f33045x);
        MessageProxy.registerMessageHandler(41, this.f33045x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.f33045x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.f33045x);
    }

    private void d() {
        MessageProxy.unRegisterMessageHandler(4000, this.f33045x);
        MessageProxy.unRegisterMessageHandler(519, this.f33045x);
        MessageProxy.unRegisterMessageHandler(39, this.f33045x);
        MessageProxy.unRegisterMessageHandler(512, this.f33045x);
        MessageProxy.unRegisterMessageHandler(65297, this.f33045x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.f33045x);
        MessageProxy.unRegisterMessageHandler(50, this.f33045x);
        MessageProxy.unRegisterMessageHandler(51, this.f33045x);
        MessageProxy.unRegisterMessageHandler(65301, this.f33045x);
        MessageProxy.unRegisterMessageHandler(41, this.f33045x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.f33045x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.f33045x);
    }

    public float getCurrentZoomLevel() {
        AppBaseMap r100 = this.f33043v;
        if (r100 != null) goto L5;
        return 4.0f;
    L5:
        Bundle r101 = r100.GetMapStatus(false);
        if (r101 != null) goto L9;
        return 4.0f;
    L9:
        return (float) r101.getDouble("level");
    }

    public com.baidu.platform.comapi.map.c0.c getGestureMonitor() {
        if (this.f33026h != null) goto L6;
        this.f33026h = new com.baidu.platform.comapi.map.c0.c(this);
    L6:
        return this.f33026h;
    }

    public Bundle getGestureOptInfoForLog() {
        Bundle r100 = null;
        if (this.E.f33061a == true) goto L5;
        return null;
    L5:
        MapStatus r101 = getMapStatus();
        int r102 = this.E.f33064d.getIntX();
        int r103 = this.E.f33064d.getIntY();
        boolean r104 = true;
        if (Math.sqrt((r102 * r102) + (r103 * r103)) <= 100.0d) goto L8;
        boolean r105 = true;
    L9:
        float r106 = this.E.f33062b;
        if (r106 > 0.0f) goto L12;
    L14:
        r104 = false;
    L15:
        if (r105 == true) goto L17;
        if (r104 == true) goto L17;
    L18:
        this.E.a();
        return r100;
    L17:
        r100 = new Bundle();
        r100.putDouble("pre_x", this.E.f33063c.getLongitude());
        r100.putDouble("pre_y", this.E.f33063c.getLatitude());
        r100.putFloat("pre_level", this.E.f33062b);
        goto L18
    L12:
        if (Math.abs(r101.level - r106) < 0.5d) goto L14;
    L8:
        r105 = false;
        goto L9
    }

    public MapViewInterface getMapView() {
        SoftReference<MapViewInterface> r100 = this.f33022d0;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    public int getVMPMapCityCode() {
        if (this.f33043v == null) goto L6;
        Bundle r100 = new Bundle();
        r100.putString("querytype", "map");
        this.f33043v.GetVMPMapCityInfo(r100);
        return r100.getInt("code");
    L6:
        return 0;
    }

    public int getVMPMapCityItsInfo() {
        if (this.f33043v == null) goto L6;
        Bundle r100 = new Bundle();
        r100.putString("querytype", "its");
        this.f33043v.GetVMPMapCityInfo(r100);
        return r100.getInt("rst");
    L6:
        return 0;
    }

    public int getVMPMapCityLevel() {
        if (this.f33043v == null) goto L6;
        Bundle r100 = new Bundle();
        r100.putString("querytype", "map");
        this.f33043v.GetVMPMapCityInfo(r100);
        return r100.getInt("level");
    L6:
        return 0;
    }

    public int getVMPMapCitySatInfo() {
        if (this.f33043v == null) goto L6;
        Bundle r100 = new Bundle();
        r100.putString("querytype", LocalePreferences.FirstDayOfWeek.SATURDAY);
        this.f33043v.GetVMPMapCityInfo(r100);
        return r100.getInt("rst");
    L6:
        return 0;
    }

    public float getZoomLevel() {
        AppBaseMap r100 = this.f33043v;
        if (r100 != null) goto L5;
        return 4.0f;
    L5:
        Bundle r101 = r100.GetMapStatus();
        if (r101 != null) goto L9;
        return 4.0f;
    L9:
        return (float) r101.getDouble("level");
    }

    public int handleMapModeGet() {
        return MapMsgProc(4113, 0, 0);
    }

    public void handleRightClick() {
        MapMsgProc(UIMsg.KEvent.V_WM_RBUTTONCLICK, 0, 0);
    }

    public void initAppBaseMap() {
        if (f33017g.size() != 0) goto L5;
        initBaseMap();
        return;
    L5:
        createByDuplicateAppBaseMap(((AppBaseMap) ListProtector.get(f33017g, 0)).GetId());
    }

    public void initBaseMap() {
        AppBaseMap r100 = new AppBaseMap();
        this.f33043v = r100;
        r100.Create();
        this.f33044w = this.f33043v.GetId();
        List<AppBaseMap> r101 = f33017g;
        if (r101 == null) goto L6;
        r101.add(this.f33043v);
        return;
    }

    public boolean isSetBackgroundDraw() {
        AppBaseMap r100 = this.f33043v;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSupBackgroundDraw();
    }

    public void mapStatusChangeStart() {
        if (this.mIsMoving == false) goto L5;
        return;
    L5:
        this.mIsMoving = true;
        int r100 = 0;
        this.mIsAnimating = false;
        if (this.mListeners == null) goto L14;
        com.baidu.mapsdkplatform.comapi.map.s r101 = getMapStatusInner();
    L9:
        if (r100 >= this.mListeners.size()) goto L18;
        v r102 = (v) ListProtector.get(this.mListeners, r100);
        if (r102 == null) goto L13;
        r102.c(r101);
    L13:
        r100 = r100 + 1;
        goto L9
    L18:
        return;
    }

    public void unInitForMultiTextureView() {
        if (this.C == false) goto L8;
        AppBaseMap r100 = this.f33043v;
        if (r100 == null) goto L9;
        r100.Release();
        this.f33043v = null;
        this.C = false;
        return;
    L9:
        return;
    }

    public MapController() {
        this.f33028i = true;
        this.f33030j = true;
        this.f33032k = 0;
        this.f33033l = 1;
        this.f33034m = 1;
        this.f33035n = false;
        this.f33037p = false;
        this.f33040s = false;
        this.f33041t = false;
        this.f33042u = false;
        this.f33043v = null;
        this.f33044w = 0;
        this.f33045x = null;
        this.nearlyRadius = 20;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = new a(this);
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.f33018J = false;
        this.K = -1.0f;
        this.L = -1.0f;
        this.M = 0.0f;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = true;
        this.mIsInertialAnimation = true;
        this.V = false;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f33019a0 = null;
        this.f33020b0 = null;
        this.f33021c0 = null;
        this.mMaxZoomLevel = 22.0f;
        this.mMinZoomLevel = 4.0f;
        this.mIsMoving = false;
        this.mIsAnimating = false;
        this.f33025g0 = false;
        this.f33027h0 = false;
        this.f33029i0 = new com.baidu.platform.comapi.map.c0.b(this);
        this.f33031j0 = MapControlMode.DEFAULT;
        this.mListeners = new CopyOnWriteArrayList();
        this.f33046y = SysOSUtil.getInstance().getScreenWidth();
        this.f33047z = SysOSUtil.getInstance().getScreenHeight();
        this.f33045x = new b(this);
        b();
    }

    public void clearUniversalLayer() {
        if (a() == false) goto L6;
        this.f33043v.clearUniversalLayer();
        return;
    }

    public float getAdapterZoomUnitsEx() {
        if (a() == true) goto L7;
        return 0.0f;
    L7:
        return this.f33043v.GetAdapterZoomUnitsEx();
    }

    public IndoorMapInfo getFocusedBaseIndoorMapInfo() {
        if (a() == true) goto L5;
        return null;
    L5:
        String r100 = this.f33043v.GetFocusedBaseIndoorMapInfo();
        if (TextUtils.isEmpty(r100) == false) goto L26;
    L24:
        return null;
    L26:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L25
        String r102 = r101.optString("focusindoorid");     // Catch: JSONException -> L25
        String r103 = r101.optString("curfloor");     // Catch: JSONException -> L25
        int r104 = r101.optInt("idrtype");     // Catch: JSONException -> L25
        JSONArray r105 = r101.optJSONArray("floorlist");     // Catch: JSONException -> L25
        int r106 = 0;
        if (r105 == null) goto L14;
        String[] r107 = new String[r105.length()];     // Catch: JSONException -> L25
        ArrayList r108 = new ArrayList();     // Catch: JSONException -> L25
        int r109 = 0;
    L11:
        if (r109 >= r105.length()) goto L13;
        r108.add(JSONArrayProtectorUtils.getString(r105, r109));     // Catch: JSONException -> L25
        r109 = r109 + 1;     // Catch: JSONException -> L25
        goto L11
    L13:
        r108.toArray(r107);     // Catch: JSONException -> L25
    L15:
        JSONArray r110 = r101.optJSONArray("floorattribute");     // Catch: JSONException -> L25
        if (r110 == null) goto L21;
        int[] r111 = new int[r110.length()];     // Catch: JSONException -> L25
    L19:
        if (r106 >= r110.length()) goto L22;
        r111[r106] = r110.optInt(r106);     // Catch: JSONException -> L25
        r106 = r106 + 1;     // Catch: JSONException -> L25
    L22:
        return new IndoorMapInfo(r102, r103, r107, r111, r104, r101.optInt("idrguide"), r101.optString("idrsearch"));
    L21:
        r111 = null;
        goto L22
    L14:
        r107 = null;
        goto L15
    }

    public boolean getMapBarData() {
        if (a() == true) goto L5;
        return false;
    L5:
        Bundle r100 = new Bundle();
        this.f33043v.getMapBarData(r100);
        byte[] r101 = new byte[0];
        String r102 = null;
        if (r100.containsKey("uid") == false) goto L8;
        String r103 = r100.getString("uid");
    L10:
        if (r100.containsKey("searchbound") == false) goto L12;
        String r104 = r100.getString("searchbound");
    L14:
        if (r100.containsKey("curfloor") == false) goto L17;
        r102 = r100.getString("curfloor");
    L17:
        if (r100.containsKey("barinfo") == false) goto L19;
        r101 = r100.getByteArray("barinfo");
    L19:
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b(r103, r104, r102, r101));
        return true;
    L12:
        r104 = null;
        goto L14
    L8:
        r103 = null;
        goto L10
    }

    public boolean getMapBarShowData() {
        if (a() == true) goto L6;
        return false;
    L6:
        Bundle r100 = new Bundle();
        return this.f33043v.getMapBarData(r100);
    }

    public int getMapScene() {
        if (a() == true) goto L7;
        return 0;
    L7:
        return this.f33043v.getMapScene();
    }

    public com.baidu.mapsdkplatform.comapi.map.s getMapStatusInner() {
        if (a() == true) goto L6;
        return null;
    L6:
        Bundle r100 = this.f33043v.GetMapStatus();
        com.baidu.mapsdkplatform.comapi.map.s r101 = new com.baidu.mapsdkplatform.comapi.map.s();
        r101.a(r100);
        return r101;
    }

    public int getMapTheme() {
        if (a() == true) goto L7;
        return 0;
    L7:
        return this.f33043v.getMapTheme();
    }

    public int getScreenHeight() {
        MapStatus.WinRound r100 = getMapStatus().winRound;
        int r101 = r100.bottom - r100.top;
        this.f33047z = r101;
        return r101;
    }

    public int getScreenWidth() {
        MapStatus.WinRound r100 = getMapStatus().winRound;
        int r101 = r100.right - r100.left;
        this.f33046y = r101;
        return r101;
    }

    public double getZoomUnitsInMeter() {
        AppBaseMap r100 = getBaseMap();
        if (r100 == null) goto L10;
        Bundle r101 = r100.GetMapStatus();
        if (r101 == null) goto L10;
        double r102 = r101.getFloat("adapterZoomUnits");
        if (r102 <= 1.0E-4d) goto L10;
        return r102;
    L10:
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public boolean isBaseIndoorMapMode() {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.IsBaseIndoorMapMode();
    }

    public boolean isEnableIndoor3D() {
        if (a() == true) goto L5;
        return true;
    L5:
        return this.f33043v.isEnableIndoor3D();
    }

    public boolean isMapAnimationRunning() {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.isAnimationRunning();
    }

    public boolean isNaviMode() {
        if (a() == true) goto L5;
        return false;
    L5:
        return this.f33043v.isNaviMode();
    }

    public boolean isStreetArrowShown() {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.IsStreetArrowShown();
    }

    public boolean isStreetCustomMarkerShown() {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.IsStreetCustomMarkerShown();
    }

    public boolean isStreetPOIMarkerShown() {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.IsStreetPOIMarkerShown();
    }

    public boolean isStreetRoadClickable() {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.IsStreetRoadClickable();
    }

    public void onPause() {
        if (a() == false) goto L6;
        this.f33043v.OnPause();
        return;
    }

    public void onResume() {
        if (a() == false) goto L6;
        this.f33043v.OnResume();
        return;
    }

    public void removeStreetAllCustomMarker() {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.RemoveStreetAllCustomMarker();
    }

    public void startIndoorAnimation() {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.StartIndoorAnimation();
    }

    public void unInit() {
        d();
        Handler r100 = this.f33045x;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
        this.f33045x = null;
    L5:
        List<AppBaseMap> r101 = f33017g;
        if (r101 == null) goto L8;
        r101.remove(this.f33043v);
    L8:
        List<v> r102 = this.mListeners;
        if (r102 == null) goto L12;
        r102.clear();
    L12:
        if (this.C == false) goto L17;
        AppBaseMap r103 = this.f33043v;
        if (r103 == null) goto L17;
        r103.Release();
        this.f33043v = null;
        this.C = false;
    L17:
        if (this.f33019a0 == null) goto L20;
        this.f33019a0 = null;
        return;
    }

    public void updateDrawFPS() {
        if (a() == false) goto L6;
        this.f33043v.updateDrawFPS();
        return;
    }

    public AppBaseMap getBaseMap() {
        return this.f33043v;
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.X;
    }

    public g getHideIndoorPopupListener() {
        return this.Y;
    }

    public EngineMsgListener getIndoorMapListener() {
        return this.f33020b0;
    }

    public LatLng getLatLngGesturesCenter() {
        return this.f33039r;
    }

    public List<v> getListeners() {
        return this.mListeners;
    }

    public boolean getMapClickEnable() {
        return this.A;
    }

    public MapControlMode getMapControlMode() {
        return this.f33031j0;
    }

    public long getMapId() {
        return this.f33044w;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        return this.f33019a0;
    }

    public MapViewListener getMapViewListener() {
        return this.W;
    }

    public MapViewSurfaceListener getMapViewSurfaceListener() {
        return this.f33021c0;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        return this.f33023e0;
    }

    public Point getPointGesturesCenter() {
        return this.f33038q;
    }

    public int getSceneLayerScene() {
        return this.f33033l;
    }

    public int getSceneLayerTheme() {
        return this.f33034m;
    }

    public y getStreetArrowClickListener() {
        return this.Z;
    }

    public boolean is3DGestureEnable() {
        return this.R;
    }

    public boolean isCanTouchMove() {
        return this.U;
    }

    public boolean isDoubleClickMoveZoom() {
        return this.H;
    }

    public boolean isDoubleClickZoom() {
        return this.F;
    }

    public boolean isDuplicate() {
        return this.f33027h0;
    }

    public boolean isEnableDMoveZoom() {
        return this.G;
    }

    public boolean isEnableZoom() {
        return this.T;
    }

    public boolean isEnlargeCenterWithDoubleClickEnabled() {
        return this.f33018J;
    }

    public boolean isFlingEnabled() {
        return this.f33030j;
    }

    public boolean isMovedMap() {
        return this.f33037p;
    }

    public boolean isOverlookGestureEnable() {
        return this.S;
    }

    public boolean isTwoTouchClickZoomEnabled() {
        return this.I;
    }

    private MapStatus a(boolean r100) {
        if (a() == false) goto L5;
        Bundle r101 = this.f33043v.GetMapStatus(r100);
        if (r101 == null) goto L9;
        MapStatus r102 = new MapStatus();
        r102.level = (float) r101.getDouble("level");
        r102.rotation = (int) r101.getDouble("rotation");
        r102.overlooking = (int) r101.getDouble("overlooking");
        r102.centerPtX = r101.getDouble("centerptx");
        r102.centerPtY = r101.getDouble("centerpty");
        r102.centerPtZ = r101.getDouble("centerptz");
        r102.winRound.left = r101.getInt("left");
        r102.winRound.right = r101.getInt("right");
        r102.winRound.top = r101.getInt("top");
        r102.winRound.bottom = r101.getInt("bottom");
        r102.geoRound.left = r101.getLong("gleft");
        r102.geoRound.right = r101.getLong("gright");
        r102.geoRound.top = r101.getLong("gtop");
        r102.geoRound.bottom = r101.getLong("gbottom");
        r102.xOffset = r101.getFloat("xoffset");
        r102.yOffset = r101.getFloat("yoffset");
        boolean r103 = false;
        if (r101.getInt("bfpp") != 1) goto L13;
        boolean r104 = true;
    L14:
        r102.bfpp = r104;
        r102.panoId = r101.getString("panoid");
        r102.streetIndicateAngle = r101.getFloat("siangle");
        if (r101.getInt("isbirdeye") != 1) goto L17;
        boolean r105 = true;
    L18:
        r102.isBirdEye = r105;
        r102.streetExt = r101.getInt("ssext");
        r102.roadOffsetX = r101.getFloat("roadOffsetX");
        r102.roadOffsetY = r101.getFloat("roadOffsetY");
        if (r101.getInt("boverlookback") != 1) goto L21;
        r103 = true;
    L21:
        r102.bOverlookSpringback = r103;
        r102.minOverlooking = (int) r101.getFloat("minoverlook");
        r102.xScreenOffset = r101.getFloat("xScreenOffset");
        r102.yScreenOffset = r101.getFloat("yScreenOffset");
        r102.adapterZoomUnits = r101.getFloat("adapterZoomUnits");
        MapStatus.GeoBound r106 = r102.geoRound;
        if (r106.left > (-20037508)) goto L25;
        r106.left = -20037508;
    L25:
        if (r106.right < 20037508) goto L28;
        r106.right = 20037508;
    L28:
        if (r106.top < 20037508) goto L31;
        r106.top = 20037508;
    L31:
        if (r106.bottom > (-20037508)) goto L33;
        r106.bottom = -20037508;
    L33:
        return r102;
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        return new MapStatus();
    L5:
        return new MapStatus();
    }

    public static /* synthetic */ boolean b(MapController r100) {
        return r100.P;
    }

    public static /* synthetic */ boolean c(MapController r100) {
        return r100.Q;
    }

    public static /* synthetic */ boolean d(MapController r100) {
        return r100.O;
    }

    public static /* synthetic */ MapFirstFrameCallback e(MapController r100) {
        return r100.f33036o;
    }

    public static /* synthetic */ int f(MapController r100) {
        return r100.f33047z;
    }

    public static /* synthetic */ int g(MapController r100) {
        return r100.f33046y;
    }

    public void SetStyleMode(int r100) {
        setMapScene(r100);
    }

    public void addOneOverlayItem(Bundle r100) {
        this.f33043v.addOneOverlayItem(r100);
    }

    public boolean cleanCache(MapLayerType r100) {
        AppBaseMap r101 = this.f33043v;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.cleanCache(MapLayerType.a(r100), false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean createByDuplicateAppBaseMap(long r100) {
        AppBaseMap r101 = new AppBaseMap();
        this.f33043v = r101;
        if (r101.CreateByDuplicate(r100) == false) goto L8;
        this.f33027h0 = true;
        this.f33044w = this.f33043v.GetId();
        List<AppBaseMap> r102 = f33017g;
        if (r102 == null) goto L7;
        r102.add(this.f33043v);
    L7:
        return true;
    L8:
        this.f33043v = null;
        this.f33044w = 0;
        return false;
    }

    public void enablePOIAnimation(boolean r100) {
        if (a() == false) goto L6;
        this.f33043v.enablePOIAnimation(r100);
        return;
    }

    public void forceSetMapScene(int r100) {
        this.f33033l = r100;
        if (a() == false) goto L6;
        this.f33043v.setMapScene(this.f33033l);
        return;
    }

    public int getCacheSize(MapLayerType r100) {
        AppBaseMap r101 = this.f33043v;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.GetCacheSize(MapLayerType.a(r100));
    }

    public String getCityInfoByID(int r100) {
        AppBaseMap r101 = this.f33043v;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.GetCityInfoByID(r100);
    }

    public String getProjectionPt(String r100) {
        if (a() == true) goto L7;
        return null;
    L7:
        return this.f33043v.getProjectionPt(r100);
    }

    public float getZoomToBoundF(Bundle r100) {
        if (a() == true) goto L7;
        return 0.0f;
    L7:
        return this.f33043v.GetZoomToBoundF(r100);
    }

    public void handleClick(MotionEvent r100) {
        int r101 = ((int) r100.getY()) << 16;
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONCLICK, 0, ((int) r100.getX()) | r101);
    }

    public void handleDoubleClickZoom(MotionEvent r100) {
        if (this.H == true) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.N) >= 100) goto L8;
        return;
    L8:
        mapStatusChangeStart();
        this.mIsAnimating = true;
        float r101 = r100.getY();
        float r102 = this.L - r101;
        MapMsgProc(8193, 3, (int) ((r102 / (getScreenHeight() / 9.0f)) * 10000.0f));
        this.M = r102;
        this.L = r101;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
        if (isNaviMode() == true) goto L11;
        return;
    L11:
        if (getNaviMapViewListener() == null) goto L15;
        getNaviMapViewListener().onAction(521, null);
        return;
    }

    public void handleDoubleDownClick(MotionEvent r100) {
        this.G = true;
        this.K = r100.getX();
        this.L = r100.getY();
        this.N = System.currentTimeMillis();
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
    }

    public void handleDoubleTouch(MotionEvent r210) {
        if ((System.currentTimeMillis() - this.N) <= 150) goto L6;
        return;
    L6:
        if (isNaviMode() == false) goto L12;
        NaviMapViewListener r100 = this.f33023e0;
        if (r100 == null) goto L12;
        r100.onAction(513, r210);
        return;
    L12:
        if (this.F == false) goto L59;
        SoftReference<MapViewInterface> r101 = this.f33022d0;
        if (r101 != null) goto L16;
        return;
    L16:
        if (r101.get() != null) goto L18;
        return;
    L18:
        if (this.f33022d0.get().getProjection() == null) goto L62;
        MapStatus r102 = getMapStatus();
        float r103 = r210.getX() - (r102.winRound.left + (getScreenWidth() / 2));
        float r104 = (r210.getY() - (r102.winRound.top + (getScreenHeight() / 2))) * (-1.0f);
        float r105 = 0.0f;
        if (isCompass == false) goto L23;
    L36:
        GeoPoint r106 = this.f33022d0.get().getProjection().fromPixels(r102.winRound.left + (getScreenWidth() / 2), r102.winRound.top + (getScreenHeight() / 2));
        r103 = 0.0f;
        r104 = 0.0f;
    L37:
        if (r106 == null) goto L39;
        r105 = (float) r106.getLongitudeE6();
        float r107 = (float) r106.getLatitudeE6();
    L40:
        this.P = true;
        Point r108 = new Point((int) r210.getRawX(), (int) r210.getRawY());
        if (r106 != null) goto L43;
    L53:
        getGestureMonitor().a(this.f33022d0.get().getZoomLevel() + 1.0f);
        mapStatusChangeStart();
        MapMsgProc(8195, ((int) r210.getX()) | (((int) r210.getY()) << 16), (this.f33046y / 2) | ((this.f33047z / 2) << 16), 0, 0, r105, r107, r103, r104);
        f33016f = System.currentTimeMillis();
        procGestureForLog(false, null);
        return;
    L43:
        if (this.mListeners == null) goto L53;
        int r109 = 0;
    L46:
        if (r109 >= this.mListeners.size()) goto L53;
        v r110 = (v) ListProtector.get(this.mListeners, r109);
        if (r110 == null) goto L52;
        r110.a(r106);
        if (r110.a(r108, getMapStatusInner()) == false) goto L52;
        return;
    L52:
        r109 = r109 + 1;
        goto L46
    L39:
        r107 = 0.0f;
        goto L40
    L23:
        if (this.f33018J == true) goto L36;
        if (this.f33038q != null) goto L28;
    L30:
        LatLng r111 = this.f33039r;
        if (r111 != null) goto L33;
    L35:
        r106 = this.f33022d0.get().getProjection().fromPixels((int) r210.getX(), (int) r210.getY());
        goto L37
    L33:
        if (this.f33040s == false) goto L35;
        r106 = CoordUtil.ll2mc(r111);
        goto L37
    L28:
        if (this.f33040s == false) goto L30;
        Projection r112 = this.f33022d0.get().getProjection();
        Point r113 = this.f33038q;
        r106 = r112.fromPixels(r113.x, r113.y);
        goto L37
    L62:
        return;
    }

    public void handleLongClick(MotionEvent r100) {
        int r101 = ((int) r100.getY()) << 16;
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONLONGCLICK, 0, ((int) r100.getX()) | r101);
    }

    public void handleStreetscapeDoubleTouch(MotionEvent r110) {
        SoftReference<MapViewInterface> r100 = this.f33022d0;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() != null) goto L7;
        return;
    L7:
        if (this.f33022d0.get().getProjection() == null) goto L17;
        MapStatus r101 = getMapStatus();
        Projection r102 = this.f33022d0.get().getProjection();
        MapStatus.WinRound r103 = r101.winRound;
        GeoPoint r104 = r102.fromPixels(r103.left + (this.f33046y / 2), r103.top + (this.f33047z / 2));
        if (r104 == null) goto L12;
        float r105 = (float) r104.getLongitudeE6();
        float r106 = (float) r104.getLatitudeE6();
    L13:
        MapMsgProc(8195, (((int) r110.getY()) << 16) | ((int) r110.getX()), ((this.f33047z / 2) << 16) | (this.f33046y / 2), 0, 0, r105, r106, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        return;
    L12:
        r105 = 0.0f;
        r106 = 0.0f;
        goto L13
    }

    public boolean handleTouchEvent(MotionEvent r100) {
        int r101 = 0;
        if (a() == true) goto L6;
        return false;
    L6:
        if (this.B == true) goto L9;
        this.f33029i0.a(r100);
    L9:
        if (r100.getPointerCount() != 2) goto L12;
        this.f33028i = true;
        f33012b = false;
        c();
        procGestureForLog(false, null);
    L12:
        if (r100.getAction() != 2) goto L14;
    L16:
        int r102 = r100.getAction();
        if (r102 == 0) goto L28;
        if (r102 == 1) goto L27;
        if (r102 == 2) goto L22;
        return false;
    L22:
        if (this.G == false) goto L25;
        handleDoubleClickZoom(r100);
    L30:
        if (this.mListeners != null) goto L32;
    L37:
        return true;
    L32:
        if (r101 >= this.mListeners.size()) goto L37;
        v r103 = (v) ListProtector.get(this.mListeners, r101);
        if (r103 == null) goto L36;
        r103.a(r100);
    L36:
        r101 = r101 + 1;
        goto L32
    L25:
        if (this.U == false) goto L30;
        handleTouchMove(r100);
        goto L30
    L27:
        f33012b = true;
        this.f33028i = true;
        handleTouchUp(r100);
        goto L30
    L28:
        this.f33028i = true;
        a(r100);
        goto L30
    L14:
        if (this.G == false) goto L16;
        this.f33028i = true;
        c();
        goto L16
    }

    public boolean handleTouchMove(MotionEvent r110) {
        if (f33012b == true) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - f33016f) >= 300) goto L8;
        return true;
    L8:
        int r100 = 0;
        if (this.mHasMapObjDraging == false) goto L25;
        if (getMapView() != null) goto L13;
    L23:
        return true;
    L13:
        if (getMapView().getProjection() == null) goto L23;
        GeoPoint r111 = getMapView().getProjection().fromPixels((int) r110.getX(), (int) r110.getY());
        if (this.mListeners == null) goto L23;
    L17:
        if (r100 >= this.mListeners.size()) goto L23;
        v r101 = (v) ListProtector.get(this.mListeners, r100);
        if (r101 == null) goto L22;
        if (r111 == null) goto L22;
        r101.g(r111);
    L22:
        r100 = r100 + 1;
        goto L17
    L25:
        if (this.mHasBmDrawItemDraging == true) goto L27;
        float r102 = Math.abs(r110.getX() - f33013c);
        float r103 = Math.abs(r110.getY() - f33014d);
        double r104 = SysOSUtil.getInstance().getDensity();
        if (r104 <= 1.5d) goto L43;
        r104 = r104 * 1.5d;
    L43:
        float r105 = (float) r104;
        if (f33015e == true) goto L46;
    L50:
        f33015e = false;
        if (isCompass == false) goto L53;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
    L53:
        procGestureForLog(true, new com.baidu.platform.comapi.basestruct.Point(r102, r103));
        int r106 = (int) r110.getX();
        int r107 = (int) r110.getY();
        float r108 = f33013c - r110.getX();
        float r109 = f33014d - r110.getY();
        Point r112 = new Point((int) r110.getRawX(), (int) r110.getRawY());
        Point r113 = new Point((int) (r110.getRawX() + r108), (int) (r110.getRawY() + r109));
        if (r106 >= 0) goto L56;
        r106 = 0;
    L56:
        if (r107 >= 0) goto L59;
        r107 = 0;
    L59:
        if (this.mListeners == null) goto L71;
        com.baidu.mapsdkplatform.comapi.map.s r114 = getMapStatusInner();
        int r115 = 0;
    L62:
        if (r115 >= this.mListeners.size()) goto L71;
        v r116 = (v) ListProtector.get(this.mListeners, r115);
        if (r116 == null) goto L69;
        if (r116.c(r113, r112, r114) == false) goto L69;
        this.B = false;
        this.f33037p = true;
        this.f33025g0 = true;
        return false;
    L69:
        r115 = r115 + 1;
    L71:
        if (this.f33028i == false) goto L73;
        getGestureMonitor().d();
        this.f33028i = false;
    L73:
        mapStatusChangeStart();
        MapMsgProc(3, 0, (r107 << 16) | r106);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.b(false, true));
        this.B = false;
        this.f33037p = true;
        this.f33025g0 = true;
        return false;
    L46:
        if ((r102 / r105) > 3.0f) goto L50;
        if ((r103 / r105) > 3.0f) goto L50;
        return true;
    L27:
        if (getMapView() != null) goto L29;
    L39:
        return true;
    L29:
        if (getMapView().getProjection() == null) goto L39;
        GeoPoint r117 = getMapView().getProjection().fromPixels((int) r110.getX(), (int) r110.getY());
        if (this.mListeners == null) goto L39;
    L33:
        if (r100 >= this.mListeners.size()) goto L39;
        v r118 = (v) ListProtector.get(this.mListeners, r100);
        if (r118 == null) goto L38;
        if (r117 == null) goto L38;
        r118.c(r117);
    L38:
        r100 = r100 + 1;
        goto L33
    }

    public boolean handleTouchSingleClick(MotionEvent r100) {
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        if (b(r101, r102) == false) goto L6;
        return true;
    L6:
        if (handlePopupClick(r101, r102) == false) goto L9;
        return true;
    L9:
        if (OverlayUtil.isOverlayUpgrade() == true) goto L11;
    L13:
        this.f33042u = c(r101, r102);
        if (a(1, r101, r102) == false) goto L17;
        return true;
    L17:
        if (this.A == false) goto L22;
        if (a(r101, r102) == false) goto L22;
        return true;
    L22:
        if (isNaviMode() == false) goto L27;
        NaviMapViewListener r103 = this.f33023e0;
        if (r103 == null) goto L27;
        r103.onAction(514, r100);
    L27:
        if (getMapViewListener() == null) goto L31;
        getMapViewListener().onClickedBackground((int) r100.getX(), (int) r100.getY());
        return false;
    L31:
        return false;
    L11:
        if (a(r101, r102, this.f33042u) == false) goto L13;
        return true;
    }

    public boolean handleTouchUp(MotionEvent r100) {
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        if (r102 >= 0) goto L8;
        r102 = 0;
    L8:
        if (this.mHasMapObjDraging == false) goto L26;
        if (this.mListeners != null) goto L12;
    L23:
        this.mHasMapObjDraging = false;
        return true;
    L12:
        if (getMapView() == null) goto L23;
        if (getMapView().getProjection() == null) goto L23;
        GeoPoint r103 = getMapView().getProjection().fromPixels(r101, r102);
        int r104 = 0;
    L17:
        if (r104 >= this.mListeners.size()) goto L23;
        v r105 = (v) ListProtector.get(this.mListeners, r104);
        if (r105 == null) goto L22;
        if (r103 == null) goto L22;
        r105.e(r103);
    L22:
        r104 = r104 + 1;
        goto L17
    L26:
        if (this.mHasBmDrawItemDraging == false) goto L44;
        if (this.mListeners != null) goto L30;
    L41:
        this.mHasBmDrawItemDraging = false;
        return true;
    L30:
        if (getMapView() == null) goto L41;
        if (getMapView().getProjection() == null) goto L41;
        GeoPoint r106 = getMapView().getProjection().fromPixels(r101, r102);
        int r107 = 0;
    L35:
        if (r107 >= this.mListeners.size()) goto L41;
        v r108 = (v) ListProtector.get(this.mListeners, r107);
        if (r108 == null) goto L40;
        if (r106 == null) goto L40;
        r108.f(r106);
    L40:
        r107 = r107 + 1;
        goto L35
    L44:
        if (f33012b == false) goto L47;
        MapMsgProc(5, 0, r101 | (r102 << 16));
    L47:
        if (this.B == true) goto L52;
        if (getMapViewListener() == null) goto L52;
        getMapViewListener().onMapAnimationFinish();
    L52:
        if (this.B == true) goto L59;
        if (isNaviMode() == false) goto L59;
        if (getNaviMapViewListener() == null) goto L59;
        getNaviMapViewListener().onMapAnimationFinish();
    L59:
        if ((r100.getEventTime() - this.f33024f0) < 300) goto L61;
    L65:
        boolean r109 = false;
    L66:
        com.baidu.mapsdkplatform.comapi.map.s r110 = getMapStatusInner();
        if (this.B == true) goto L91;
        if (r109 == true) goto L74;
        float r111 = r110.f32200a;
        if (r111 >= this.mMaxZoomLevel) goto L74;
        if (r111 < this.mMinZoomLevel) goto L74;
    L76:
        if (this.P == true) goto L91;
        if (this.Q == true) goto L91;
        if (this.mIsAnimating == true) goto L91;
        if (this.mListeners == null) goto L91;
        int r112 = 0;
    L85:
        if (r112 >= this.mListeners.size()) goto L90;
        v r113 = (v) ListProtector.get(this.mListeners, r112);
        if (r113 == null) goto L89;
        r113.a(r110);
    L89:
        r112 = r112 + 1;
        goto L85
    L90:
        this.mIsMoving = false;
    L74:
        if (this.f33025g0 == true) goto L76;
    L91:
        this.f33025g0 = false;
        this.B = false;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.b(true, false));
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.c());
        return true;
    L61:
        if (Math.abs(r100.getX() - f33013c) >= 10.0f) goto L65;
        if (Math.abs(r100.getY() - f33014d) >= 10.0f) goto L65;
        r109 = true;
        goto L66
    }

    public boolean handleTrackballEvent(MotionEvent r100) {
        if (a() == true) goto L6;
        return false;
    L6:
        if (r100.getAction() != 2) goto L24;
        float r101 = r100.getRawX();
        float r102 = r100.getRawY();
        if (r101 <= 0.0f) goto L12;
        int r103 = 18;
    L16:
        if (r102 <= 0.0f) goto L19;
        r103 = 19;
    L21:
        if (r103 != 0) goto L23;
        return false;
    L23:
        MapMsgProc(1, r103, 0);
        goto L24
    L19:
        if (r102 >= 0.0f) goto L21;
        r103 = 17;
        goto L21
    L12:
        if (r101 >= 0.0f) goto L14;
        r103 = 16;
        goto L16
    L14:
        r103 = 0;
    L24:
        return true;
    }

    public boolean handleZoomTo(int r100) {
        if (r100 != 0) goto L5;
        MapMsgProc(4097, -1, 0);
    L9:
        return false;
    L5:
        if (r100 != 1) goto L9;
        MapMsgProc(4096, -1, 0);
        goto L9
    }

    public boolean importMapTheme(int r100) {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.importMapTheme(r100);
    }

    public void initMapResources(Bundle r110) {
        if (this.C == false) goto L5;
        return;
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        if (this.f33043v != null) goto L10;
        return;
    L10:
        if (SysOSUtil.getInstance().getDensityDPI() < 180) goto L12;
        boolean r100 = true;
    L13:
        this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25) / 240;
        String r101 = r110.getString("modulePath");
        String r102 = r110.getString("appSdcardPath");
        String r103 = r110.getString("appCachePath");
        String r104 = r110.getString("appSecondCachePath");
        String r105 = r110.getString("engineErrorPath");
        int r111 = r110.getInt("mapTmpMax");
        int r112 = r110.getInt("domTmpMax");
        int r113 = r110.getInt("itsTmpMax");
        int r114 = r110.getInt("ssgTmpMax");
        if (r100 == false) goto L16;
        String r106 = "/h/";
    L17:
        String r107 = r101 + "/cfg";
        String r115 = r107 + "/a/";
        String r108 = r102 + "/BaiduMapSDKNew/vmp" + r106;
        String r109 = r102 + "/vmp" + r106;
        String r116 = r103 + "/tmp/";
        String r117 = r104 + "/tmp/";
        Bundle r118 = new Bundle();
        r118.putString("cfgdataroot", r115);
        r118.putString("vmpdataroot", r108);
        r118.putString("tmpdataroot", r116);
        r118.putString("tmpdatapast", r117);
        r118.putString("importroot", r109);
        r118.putString("stylerespath", r107 + "/a/");
        if (r105 == null) goto L23;
        if (r105.length() <= 0) goto L23;
        r118.putString("engineerrorpath", r105);
    L23:
        if (this.f33046y > 0) goto L25;
    L26:
        this.f33046y = SysOSUtil.getInstance().getScreenWidth();
        this.f33047z = SysOSUtil.getInstance().getScreenWidth();
    L28:
        if (OpenLogUtil.isMapLogEnable() == false) goto L30;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapControl init screenWidth: " + this.f33046y + "; screenHeight: " + this.f33047z);
    L30:
        r118.putInt("cx", this.f33046y);
        r118.putInt("cy", this.f33047z);
        r118.putInt("ndpi", SysOSUtil.getInstance().getDensityDPI());
        r118.putFloat("fdpi", SysOSUtil.getInstance().getDensityDPI());
        r118.putInt("maptmpmax", r111);
        r118.putInt("domtmpmax", r112);
        r118.putInt("itstmpmax", r113);
        r118.putInt("ssgtmpmax", r114);
        r118.putInt("pathchange", 0);
        if (r110.containsKey("maptheme") == false) goto L34;
        r118.putInt("maptheme", r110.getInt("maptheme"));
    L34:
        if (r110.containsKey("mapscene") == false) goto L37;
        r118.putInt("mapscene", r110.getInt("mapscene"));
    L37:
        if (r110.containsKey("fontsizelevel") == false) goto L40;
        r118.putInt("fontsizelevel", r110.getInt("fontsizelevel"));
    L40:
        if (JNIInitializer.isUserTest() == true) goto L43;
        JNIInitializer.isDebug();
    L43:
        if (this.f33043v.initWithOptions(r118, false) == false) goto L45;
        this.f33043v.SetMapStatus(r110);
        this.C = true;
        return;
    L45:
        if (OpenLogUtil.isMapLogEnable() == false) goto L47;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapControl init fail");
    L47:
        HashMap r119 = new HashMap();
        r119.put(ExifInterface.LONGITUDE_EAST, "0");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0.2", r119);
        return;
    L25:
        if (this.f33047z > 0) goto L28;
    L16:
        r106 = "/l/";
        goto L17
    L12:
        r100 = false;
        goto L13
    }

    public boolean isInFocusIndoorBuilding(GeoPoint r100) {
        if (a() == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (this.f33043v.IsPointInFocusIDRBorder(r100.getLongitude(), r100.getLatitude()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public void recycleMemory(RecycleMemoryLevel r100) {
        if (a() == false) goto L6;
        this.f33043v.recycleMemory(r100.getLevel());
        return;
    }

    public void registMapViewListener(v r100) {
        if (r100 == null) goto L8;
        List<v> r101 = this.mListeners;
        if (r101 == null) goto L9;
        r101.add(r100);
        return;
    L9:
        return;
    }

    public void removeOneOverlayItem(Bundle r100) {
        this.f33043v.removeOneOverlayItem(r100);
    }

    public void removeStreetCustomMarker(String r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.RemoveStreetCustomMaker(r100);
    }

    public void saveScreenToLocal(String r100) {
        saveScreenToLocal(r100, 0, 0, 0, 0);
    }

    public void set3DGestureEnable(boolean r100) {
        this.R = r100;
    }

    public void setActingTwoClickZoom(boolean r100) {
        this.Q = r100;
    }

    public void setAllStreetCustomMarkerVisibility(boolean r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.SetAllStreetCustomMarkerVisibility(r100);
    }

    public void setCanTouchMove(boolean r100) {
        this.U = r100;
    }

    public void setCaptureMapListener(CaptureMapListener r100) {
        this.X = r100;
    }

    public void setDoubleClickGesturesCenter(boolean r100) {
        this.f33040s = r100;
    }

    public void setDoubleClickMoveZoomEnable(boolean r100) {
        this.H = r100;
    }

    public void setDoubleClickZoom(boolean r100) {
        this.F = r100;
    }

    public void setEnableIndoor3D(boolean r100) {
        if (a() == false) goto L6;
        this.f33043v.setEnableIndoor3D(r100);
        return;
    }

    public void setEnableZoom(boolean r100) {
        this.T = r100;
    }

    public void setEngineMsgListener(EngineMsgListener r100) {
        this.f33020b0 = r100;
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean r100) {
        this.f33018J = r100;
    }

    public void setFlingEnable(boolean r100) {
        this.f33030j = r100;
    }

    public void setHideIndoorPopupListener(g r100) {
        this.Y = r100;
    }

    public void setInertialAnimation(boolean r100) {
        this.mIsInertialAnimation = r100;
        this.P = r100;
        this.Q = r100;
    }

    public void setLatLngGesturesCenter(LatLng r100) {
        this.f33039r = r100;
    }

    public void setMapClickEnable(boolean r100) {
        this.A = r100;
    }

    public int setMapControlMode(MapControlMode r100) {
        if (a() == true) goto L6;
        return -1;
    L6:
        this.f33031j0 = r100;
        return this.f33043v.SetMapControlMode(MapControlMode.a(r100));
    }

    public void setMapFirstFrameCallback(MapFirstFrameCallback r100) {
        this.f33036o = r100;
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener r100) {
        this.f33019a0 = r100;
    }

    public void setMapScene(int r100) {
        if (r100 != getMapScene()) goto L5;
        return;
    L5:
        this.f33033l = r100;
        if (a() == false) goto L9;
        this.f33043v.setMapScene(this.f33033l);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setMapStatus(MapStatus r100) {
        if (a() == false) goto L8;
        if (r100 == null) goto L9;
        Bundle r101 = new Bundle();
        r101.putDouble("level", r100.level);
        r101.putDouble("rotation", r100.rotation);
        r101.putDouble("overlooking", r100.overlooking);
        r101.putDouble("centerptx", r100.centerPtX);
        r101.putDouble("centerpty", r100.centerPtY);
        r101.putDouble("centerptz", r100.centerPtZ);
        r101.putInt("left", r100.winRound.left);
        r101.putInt("right", r100.winRound.right);
        r101.putInt("top", r100.winRound.top);
        r101.putInt("bottom", r100.winRound.bottom);
        r101.putLong("gleft", r100.geoRound.left);
        r101.putLong("gbottom", r100.geoRound.bottom);
        r101.putLong("gtop", r100.geoRound.top);
        r101.putLong("gright", r100.geoRound.right);
        r101.putFloat("yoffset", r100.yOffset);
        r101.putFloat("xoffset", r100.xOffset);
        r101.putInt("animatime", r100.animationTime);
        r101.putInt(GXTemplateKey.GAIAX_ANIMATION, r100.hasAnimation);
        r101.putInt("animationType", r100.animationType);
        r101.putInt("bfpp", r100.bfpp ? 1 : 0);
        r101.putString("panoid", r100.panoId);
        r101.putInt("autolink", 0);
        r101.putFloat("siangle", r100.streetIndicateAngle);
        r101.putInt("isbirdeye", r100.isBirdEye ? 1 : 0);
        r101.putInt("ssext", r100.streetExt);
        r101.putFloat("roadOffsetX", r100.roadOffsetX);
        r101.putFloat("roadOffsetY", r100.roadOffsetY);
        r101.putFloat("adapterZoomUnits", r100.adapterZoomUnits);
        mapStatusChangeStart();
        this.f33043v.SetMapStatus(r101);
        return;
    L9:
        return;
    }

    public void setMapViewInterface(MapViewInterface r100) {
        this.f33022d0 = new SoftReference(r100);
    }

    public void setMapViewListener(MapViewListener r100) {
        this.W = r100;
    }

    public void setMapViewSurfaceListener(MapViewSurfaceListener r100) {
        this.f33021c0 = r100;
    }

    public void setNaviMapViewListener(NaviMapViewListener r100) {
        this.f33023e0 = r100;
    }

    public void setNetStatus(int r100) {
        EngineMsgListener r101 = this.f33020b0;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 != 1) goto L9;
        r101.onLongLinkConnect();
    L13:
        this.f33032k = r100;
        return;
    L9:
        if (r100 != 2) goto L13;
        if (this.f33032k == r100) goto L13;
        r101.onLongLinkDisConnect();
        goto L13
    }

    public void setOverlayListener(w r100) {
        this.mOverlayListener = r100;
    }

    public void setOverlayMapCallBack(p r100) {
        if (r100 == null) goto L7;
        AppBaseMap r101 = this.f33043v;
        if (r101 == null) goto L8;
        r101.SetCallback(r100);
        return;
    L8:
        return;
    }

    public void setOverlookGestureEnable(boolean r100) {
        this.S = r100;
    }

    public void setPointGesturesCenter(Point r100) {
        this.f33038q = r100;
    }

    public void setRecommendPOIScene(RecommendPoiScene r100) {
        if (a() == false) goto L6;
        this.f33043v.setRecommendPOIScene(r100.value);
        return;
    }

    public void setSDKLayerBelowBmLayer(boolean r100) {
        this.V = r100;
    }

    public void setStreetArrowClickListener(y r100) {
        this.Z = r100;
    }

    public void setStreetArrowShow(boolean r100) {
        if (a() == false) goto L6;
        this.f33043v.SetStreetArrowShow(r100);
        return;
    }

    public void setStreetRoadClickable(boolean r100) {
        if (a() == false) goto L6;
        this.f33043v.SetStreetRoadClickable(r100);
        return;
    }

    public void setStyleMode(MapStyleMode r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.SetStyleMode(r100.getMode());
    }

    public void setSupBackgroundDraw(boolean r100) {
        AppBaseMap r101 = this.f33043v;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setSupBackgroundDraw(r100);
    }

    public void setTravelMode(boolean r100) {
        this.f33035n = r100;
    }

    public void setTwoTouchClickZoomEnabled(boolean r100) {
        this.I = r100;
    }

    public void setUniversalFilter(String r100) {
        if (a() == false) goto L6;
        this.f33043v.setUniversalFilter(r100);
        return;
    }

    public void showBaseIndoorMap(boolean r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.ShowBaseIndoorMap(r100);
    }

    public void showStreetPOIMarker(boolean r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.ShowStreetPOIMarker(r100);
    }

    public void showUniversalLayer(Bundle r100) {
        if (a() == false) goto L6;
        this.f33043v.showUniversalLayer(r100);
        return;
    }

    public void updateOneOverlayItem(Bundle r100) {
        this.f33043v.updateOneOverlayItem(r100);
    }

    private void a(MotionEvent r100) {
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        f33013c = r101;
        f33014d = r102;
        MapMsgProc(4, 0, r101 | (r102 << 16));
        f33015e = true;
        this.f33024f0 = r100.getDownTime();
    }

    public void setMapStatus(Bundle r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.SetMapStatus(r100);
    }

    public static /* synthetic */ long a(MapController r100) {
        return r100.f33044w;
    }

    private boolean a(int r210, int r211) {
        if (a() == true) goto L6;
        return false;
    L6:
        if (getMapViewListener() == null) goto L8;
    L10:
        int r110 = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
        int r100 = r210;
        com.baidu.platform.comapi.basestruct.Point r101 = new com.baidu.platform.comapi.basestruct.Point(r100, r211);
        if (isNaviMode() == false) goto L15;
        NaviMapViewListener r102 = this.f33023e0;
        if (r102 == null) goto L15;
        com.baidu.platform.comapi.basestruct.Point r103 = r102.onTapInterception(r101);
    L16:
        if (r103 == null) goto L18;
        r100 = r103.getIntX();
        int r104 = r103.getIntY();
    L19:
        String r105 = this.f33043v.GetNearlyObjID(-1, r100, r104, r110);
        if (r105 != null) goto L23;
        return false;
    L23:
        if (isNaviMode() == false) goto L454;
        NaviMapViewListener r106 = this.f33023e0;
        if (r106 == null) goto L454;
        if (r106.onItemClick(r105, r100, r104) == false) goto L454;
        return true;
    L454:
        JSONObject r107 = new JSONObject(r105);     // Catch: JSONException -> L451
        ArrayList r108 = new ArrayList();     // Catch: JSONException -> L451
        if (r107.has(MapBundleKey.MapObjKey.OBJ_MCAR) == false) goto L47;
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(r107, MapBundleKey.MapObjKey.OBJ_MCAR);     // Catch: JSONException -> L451
        if (r109 == null) goto L47;
        ArrayList r111 = new ArrayList();     // Catch: JSONException -> L451
        MapObj r112 = new MapObj();     // Catch: JSONException -> L451
        r112.routeType = MapBundleKey.MapObjKey.OBJ_MCAR;     // Catch: JSONException -> L451
        if (r109.has("id") == false) goto L38;
        r112.routeId = JSONObjectProtectorUtils.getInt(r109, "id");     // Catch: JSONException -> L451
    L38:
        if (r109.has("status") == false) goto L41;
        r112.status = JSONObjectProtectorUtils.getInt(r109, "status");     // Catch: JSONException -> L451
    L41:
        if (r109.has("in") == false) goto L43;
        r112.index = JSONObjectProtectorUtils.getInt(r109, "in");     // Catch: JSONException -> L451
    L43:
        r111.add(r112);     // Catch: JSONException -> L451
        if (getMapViewListener() == null) goto L46;
        getMapViewListener().onClickedRouteObj(r111);     // Catch: JSONException -> L451
    L46:
        return true;
    L47:
        JSONArray r113 = JSONObjectProtectorUtils.getJSONArray(r107, "dataset");     // Catch: JSONException -> L451
        int r114 = JSONObjectProtectorUtils.getInt((JSONObject) r113.get(0), "ty");     // Catch: JSONException -> L451
        if (r114 != 22) goto L51;
        ArrayList r115 = new ArrayList();     // Catch: JSONException -> L451
    L50:
        ArrayList r116 = null;
    L93:
        ArrayList r117 = null;
    L94:
        ArrayList r118 = null;
    L95:
        ArrayList r212 = null;
    L96:
        ArrayList r213 = null;
    L97:
        int r119 = 0;
        int r214 = -1;
    L99:
        if (r119 >= r113.length()) goto L377;
        JSONObject r120 = (JSONObject) r113.get(r119);     // Catch: JSONException -> L451
        int r121 = JSONObjectProtectorUtils.getInt(r120, "ty");     // Catch: JSONException -> L451
        if (r121 != 26) goto L103;
        r113 = r113;
        r116 = r116;
        r117 = r117;
        r118 = r118;
        r212 = r212;
        r213 = r213;
    L376:
        r119 = r119 + 1;     // Catch: JSONException -> L451
        r118 = r118;
        r212 = r212;
        r117 = r117;
        r213 = r213;
        r116 = r116;
        r113 = r113;
        goto L99
    L103:
        MapObj r122 = new MapObj();     // Catch: JSONException -> L451
        if (r120.has(MapBundleKey.MapObjKey.OBJ_LAYER_ID) == false) goto L106;
        r122.layer_id = (int) JSONObjectProtectorUtils.getLong(r120, MapBundleKey.MapObjKey.OBJ_LAYER_ID);     // Catch: JSONException -> L451
    L109:
        if (r120.has("ud") == false) goto L111;
        r122.strUid = JSONObjectProtectorUtils.getString(r120, "ud");     // Catch: JSONException -> L451
    L112:
        r122.strText = r120.optString(MapBundleKey.MapObjKey.OBJ_TEXT);     // Catch: JSONException -> L451
        if (r120.has("in") == false) goto L116;
        r122.nIndex = JSONObjectProtectorUtils.getInt(r120, "in");     // Catch: JSONException -> L451
    L120:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_GEO) == false) goto L129;
        com.baidu.platform.comapi.basestruct.Point r123 = CoordinateUtil.complexPtToPoint(JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_GEO));     // Catch: JSONException -> L451
        com.baidu.platform.comapi.basestruct.Point r124 = r122.geoPt;     // Catch: JSONException -> L451
        if (r123 != null) goto L124;
        double r125 = 0.0d;
    L125:
        if (r123 != null) goto L127;
        double r126 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L128:
        r124.setTo(r125, r126);     // Catch: JSONException -> L451
    L134:
        MapObj r127 = r122;
    L136:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_GEO_Z) == false) goto L139;
        r127.geoZ = (float) JSONObjectProtectorUtils.getDouble(r120, MapBundleKey.MapObjKey.OBJ_GEO_Z);     // Catch: JSONException -> L451
    L139:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_INDOOR_POI) == false) goto L142;
        r127.indoorpoi = JSONObjectProtectorUtils.getBoolean(r120, MapBundleKey.MapObjKey.OBJ_INDOOR_POI);     // Catch: JSONException -> L451
    L142:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE) == false) goto L145;
        r127.poiOnlineType = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE);     // Catch: JSONException -> L451
    L145:
        if (r120.has("bid") == false) goto L148;
        r127.bid = JSONObjectProtectorUtils.getString(r120, "bid");     // Catch: JSONException -> L451
    L148:
        if (r120.has("ts") == false) goto L151;
        r127.sltime = JSONObjectProtectorUtils.getInt(r120, "ts");     // Catch: JSONException -> L451
    L151:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ) == false) goto L154;
        r127.slobj = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_SL_OBJ);     // Catch: JSONException -> L451
    L154:
        if (r120.has("visible") == false) goto L156;
        r127.slvisi = JSONObjectProtectorUtils.getInt(r120, "visible");     // Catch: JSONException -> L451
    L156:
        r127.nType = r121;     // Catch: JSONException -> L451
        if (r120.has(MapBundleKey.MapObjKey.OBJ_OFFSET) == false) goto L160;
        r127.offset = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_OFFSET);     // Catch: JSONException -> L451
    L160:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME) == false) goto L163;
        r127.ssName = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_SS_POINAME);     // Catch: JSONException -> L451
    L163:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID) == false) goto L166;
        r127.ssIndoorId = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID);     // Catch: JSONException -> L451
    L166:
        if (r120.has("ud") == false) goto L169;
        r127.ssPoiUid = JSONObjectProtectorUtils.getString(r120, "ud");     // Catch: JSONException -> L451
    L169:
        if (r120.has(MapBundleKey.MapObjKey.STREET_TYPE) == false) goto L172;
        r127.ssType = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.STREET_TYPE);     // Catch: JSONException -> L451
    L172:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_DIS) == false) goto L175;
        r127.offset = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_DIS);     // Catch: JSONException -> L451
    L175:
        if (r120.has("x") == false) goto L178;
        r127.geoPt.setIntX(JSONObjectProtectorUtils.getInt(r120, "x"));     // Catch: JSONException -> L451
        r127.streetArrowCenterX = JSONObjectProtectorUtils.getDouble(r120, "x");     // Catch: JSONException -> L451
    L178:
        if (r120.has("y") == false) goto L181;
        r127.geoPt.setIntY(JSONObjectProtectorUtils.getInt(r120, "y"));     // Catch: JSONException -> L451
        r127.streetArrowCenterY = JSONObjectProtectorUtils.getDouble(r120, "y");     // Catch: JSONException -> L451
    L181:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z) == false) goto L184;
        r127.ssZ = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z);     // Catch: JSONException -> L451
    L184:
        if (r120.has("rotation") == false) goto L187;
        r127.ssRotation = JSONObjectProtectorUtils.getDouble(r120, "rotation");     // Catch: JSONException -> L451
    L187:
        if (r120.has("pid") == false) goto L190;
        r127.ssPanoId = JSONObjectProtectorUtils.getString(r120, "pid");     // Catch: JSONException -> L451
    L190:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SS_DATA) == false) goto L193;
        r127.ssData = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_SS_DATA);     // Catch: JSONException -> L451
    L193:
        if (r120.has("src") == false) goto L195;
        int r128 = JSONObjectProtectorUtils.getInt(r120, "src");     // Catch: JSONException -> L451
        r127.dynamicSrc = r128;     // Catch: JSONException -> L451
        r214 = r128;
    L197:
        if (r120.has("ad") == false) goto L199;
        r127.f33070ad = JSONObjectProtectorUtils.getInt(r120, "ad");     // Catch: JSONException -> L451
    L201:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE) == false) goto L203;
        r127.adstyle = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_AD_STYLE);     // Catch: JSONException -> L451
    L205:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_QID) == false) goto L207;
        r127.qid = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_QID);     // Catch: JSONException -> L451
    L209:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_PUID) == false) goto L211;
        r127.puid = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_PUID);     // Catch: JSONException -> L451
    L213:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_DY_SRC) == false) goto L215;
        r127.dysrc = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_DY_SRC);     // Catch: JSONException -> L451
    L217:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_DY_STGE) == false) goto L219;
        r127.dystge = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_DY_STGE);     // Catch: JSONException -> L451
    L221:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_DY_ISAGG) == false) goto L224;
        r127.isAgg = JSONObjectProtectorUtils.getBoolean(r120, MapBundleKey.MapObjKey.OBJ_DY_ISAGG);     // Catch: JSONException -> L451
    L224:
        if (r120.has(MapBundleKey.MapObjKey.AD_LOG) == false) goto L226;
        r127.adLog = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.AD_LOG);     // Catch: JSONException -> L451
    L228:
        if (r120.has("url") == false) goto L230;
        r127.url = JSONObjectProtectorUtils.getString(r120, "url");     // Catch: JSONException -> L451
    L232:
        if (r120.has("style_id") == false) goto L455;
        r127.style_id = JSONObjectProtectorUtils.getInt(r120, "style_id");     // Catch: JSONException -> L451
    L238:
        if (r120.has("level") == false) goto L240;
        r127.level = JSONObjectProtectorUtils.getInt(r120, "level");     // Catch: JSONException -> L451
    L242:
        if (r120.has(MapBundleKey.MapObjKey.CLICK_ACTION) == false) goto L244;
        r127.clickAction = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.CLICK_ACTION);     // Catch: JSONException -> L451
    L246:
        if (r120.has(MapBundleKey.MapObjKey.EX_JSON) == false) goto L248;
        r127.exJson = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.EX_JSON);     // Catch: JSONException -> L451
    L250:
        if (r120.has(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE) == false) goto L253;
        r127.statisticValue = JSONObjectProtectorUtils.getInt(r120, MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE);     // Catch: JSONException -> L451
    L253:
        if (r114 != 22) goto L261;
        ItsMapObj r129 = new ItsMapObj();     // Catch: JSONException -> L451
        r129.baseMapObj = r127;     // Catch: JSONException -> L451
        r129.tTrafficStart = JSONObjectProtectorUtils.getLong(r120, MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_START);     // Catch: JSONException -> L451
        r129.tTrafficEnd = JSONObjectProtectorUtils.getLong(r120, MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_END);     // Catch: JSONException -> L451
        r129.strTrafficDetail = JSONObjectProtectorUtils.getString(r120, MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_DETAIL);     // Catch: JSONException -> L451
        if (r115 == null) goto L257;
        r115.add(r129);     // Catch: JSONException -> L451
    L257:
        r118 = r118;
    L258:
        r212 = r212;
    L259:
        r213 = r213;
        goto L376
    L261:
        if (r114 == 3) goto L374;
        if (r114 == 13) goto L374;
        if (r114 == 14) goto L374;
        if (r114 == 16) goto L374;
        if (r114 == 15) goto L374;
        if (r114 == 4) goto L374;
        if (r114 == 103) goto L374;
        if (r114 == 25) goto L374;
        if (r114 == 31) goto L374;
        if (r114 == 104) goto L374;
        if (r114 == 5000) goto L374;
        if (r114 == 6018) goto L374;
        if (r114 == 6019) goto L374;
        if (r114 != 8) goto L290;
    L369:
        r117 = r117;
        r118 = r118;
        r212 = r212;
        r213 = r213;
        if (r117 == null) goto L372;
        r117.add(r127);     // Catch: JSONException -> L451
    L372:
        r116 = r116;
        goto L376
    L290:
        if (r114 == 1) goto L369;
        if (r114 == 2) goto L369;
        if (r114 != 6) goto L300;
        r118 = r118;
        if (r118 == null) goto L258;
        r118.add(r127);     // Catch: JSONException -> L451
        goto L258
    L300:
        r118 = r118;
        if (r114 != 24) goto L306;
        r212 = r212;
        if (r212 == null) goto L305;
        r212.add(r127);     // Catch: JSONException -> L451
    L305:
        r116 = r116;
        r117 = r117;
        goto L259
    L306:
        r212 = r212;
        if (r114 == 1234) goto L367;
        if (r114 == 1236) goto L367;
        if (r114 == 2000) goto L367;
        if (r114 == 2001) goto L367;
        if (r114 == 1235) goto L318;
        if (r114 == 2002) goto L325;
        if (r114 == 1239) goto L329;
        r117 = r117;
        if (r114 == 6000) goto L338;
        if (r114 != 7000) goto L345;
        r213 = r213;
        if (r213 == null) goto L372;
        r213.add(r127);     // Catch: JSONException -> L451
        goto L372
    L345:
        r213 = r213;
        if (r114 != 6002) goto L351;
        if (getMapViewListener() == null) goto L372;
        getMapViewListener().onClickedTrafficUgcEventMapObj(r127, r120.optBoolean("bchecked"));     // Catch: JSONException -> L451
        goto L372
    L351:
        if (r114 == 90909) goto L365;
        if (r114 == 90910) goto L365;
        if (r114 == 90914) goto L365;
        if (r114 == 90912) goto L365;
        if (r114 == 90915) goto L365;
        if (r114 == 90916) goto L365;
        r108.add(r127);     // Catch: JSONException -> L451
    L365:
        if (getMapViewListener() == null) goto L372;
        getMapViewListener().onClickSdkMapObj(r114, r120);     // Catch: JSONException -> L451
        goto L372
    L338:
        if (getMapViewListener() == null) goto L378;
        getMapViewListener().onClickedTrafficUgcEventMapObj(r127, true);     // Catch: JSONException -> L451
    L378:
        int r130 = r214;
        if (r114 == 6) goto L447;
        if (r114 == 8) goto L444;
        if (r114 == 25) goto L441;
        if (r114 == 31) goto L441;
        if (r114 == 5000) goto L435;
        if (r114 == 7000) goto L432;
        if (r114 == 22) goto L429;
        if (r114 == 23) goto L426;
        if (r114 == 103) goto L441;
        if (r114 == 104) goto L441;
        if (r114 == 6018) goto L423;
        if (r114 == 6019) goto L423;
        if (r114 == 6060) goto L420;
        if (r114 == 6061) goto L420;
        if (r114 == 1) goto L444;
        if (r114 == 2) goto L444;
        if (r114 == 3) goto L441;
        if (r114 == 4) goto L441;
        switch(r114) {
            case 13: goto L441;
            case 14: goto L441;
            case 15: goto L441;
            case 16: goto L441;
            case 17: goto L420;
            case 18: goto L420;
            case 19: goto L420;
            case 20: goto L417;
            default: goto L472;
        };     // Catch: JSONException -> L451
    L472:
        return true;
    L417:
        if (getMapViewListener() == null) goto L473;
        getMapViewListener().onClickedStreetPopup(r105);     // Catch: JSONException -> L451
        return true;
    L473:
        return true;
    L420:
        if (getMapViewListener() == null) goto L475;
        getMapViewListener().onClickedMapObj(r108);     // Catch: JSONException -> L451
        return true;
    L475:
        return true;
    L423:
        if (getMapViewListener() == null) goto L477;
        getMapViewListener().onClickedUniversalLayerPoiEventMapObj(r116);     // Catch: JSONException -> L451
        return true;
    L477:
        return true;
    L426:
        if (getMapViewListener() == null) goto L479;
        getMapViewListener().onClickedMapObj(r108);     // Catch: JSONException -> L451
        return true;
    L479:
        return true;
    L429:
        if (getMapViewListener() == null) goto L481;
        getMapViewListener().onClickedItsMapObj(r115);     // Catch: JSONException -> L451
        return true;
    L481:
        return true;
    L432:
        if (getMapViewListener() == null) goto L483;
        getMapViewListener().onClickedParticleEventMapObj(r213);     // Catch: JSONException -> L451
        return true;
    L483:
        return true;
    L435:
        if (getMapViewListener() != null) goto L437;
        return true;
    L437:
        if (r130 != 27) goto L439;
        getMapViewListener().onClickPolymericMapObj(r116);     // Catch: JSONException -> L451
        return true;
    L439:
        getMapViewListener().onClickedPoiObj(r116);     // Catch: JSONException -> L451
        return true;
    L441:
        if (getMapViewListener() == null) goto L488;
        getMapViewListener().onClickedPoiObj(r116);     // Catch: JSONException -> L451
        return true;
    L488:
        return true;
    L444:
        if (getMapViewListener() == null) goto L490;
        getMapViewListener().onClickedRouteObj(r117);     // Catch: JSONException -> L451
        return true;
    L490:
        return true;
    L447:
        if (getMapViewListener() == null) goto L492;
        getMapViewListener().onClickedMapObj(r118);     // Catch: JSONException -> L451
        return true;
    L492:
        return true;
    L329:
        r117 = r117;
        if (r117 == null) goto L333;
        r117.add(r127);     // Catch: JSONException -> L451
    L333:
        if (getMapViewListener() == null) goto L378;
        getMapViewListener().onClickedRouteLabelObj(r117);     // Catch: JSONException -> L451
        goto L378
    L325:
        if (getMapViewListener() != null) goto L326;
    L320:
        r117 = r117;
        goto L378
    L326:
        getMapViewListener().onClickStreetSurface(r127);     // Catch: JSONException -> L451
        goto L320
    L318:
        if (getMapViewListener() == null) goto L320;
        getMapViewListener().onClickStreetArrow(r127);     // Catch: JSONException -> L451
    L367:
        r117 = r117;
        getMapViewListener().onClickedStreetIndoorPoi(r127);     // Catch: JSONException -> L451
    L374:
        if (r116 == 0) goto L376;
        r116.add(r127);     // Catch: JSONException -> L451
        goto L376
    L248:
        r127.exJson = "";     // Catch: JSONException -> L451
        goto L250
    L244:
        r127.clickAction = "";     // Catch: JSONException -> L451
        goto L246
    L240:
        r127.level = -1;     // Catch: JSONException -> L451
        goto L242
    L455:
        r127.style_id = 0;     // Catch: JSONException -> L453
    L471:
        return false;
    L230:
        r127.url = "";     // Catch: JSONException -> L451
        goto L232
    L226:
        r127.adLog = "";     // Catch: JSONException -> L451
        goto L228
    L219:
        r127.dystge = -1;     // Catch: JSONException -> L451
        goto L221
    L215:
        r127.dysrc = -1;     // Catch: JSONException -> L451
        goto L217
    L211:
        r127.puid = "";     // Catch: JSONException -> L451
        goto L213
    L207:
        r127.qid = "";     // Catch: JSONException -> L451
        goto L209
    L203:
        r127.adstyle = -1;     // Catch: JSONException -> L451
        goto L205
    L199:
        r127.f33070ad = -1;     // Catch: JSONException -> L451
        goto L201
    L195:
        r127.dynamicSrc = -1;     // Catch: JSONException -> L451
        goto L197
    L127:
        r126 = r123.getIntY();     // Catch: JSONException -> L451
        goto L128
    L124:
        r125 = r123.getIntX();     // Catch: JSONException -> L451
        goto L125
    L129:
        r122 = r122;
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) == false) goto L134;
        if (r120.has(MapBundleKey.MapObjKey.OBJ_SL_PTY) == false) goto L134;
        r127 = r122;
        r127.geoPt.setTo((int) JSONObjectProtectorUtils.getDouble(r120, MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) JSONObjectProtectorUtils.getDouble(r120, MapBundleKey.MapObjKey.OBJ_SL_PTY));     // Catch: JSONException -> L451
        goto L136
    L116:
        if (r120.has("index") == false) goto L118;
        r122.nIndex = JSONObjectProtectorUtils.getInt(r120, "index");     // Catch: JSONException -> L451
        goto L120
    L118:
        r122.nIndex = 0;     // Catch: JSONException -> L451
        goto L120
    L111:
        r122.strUid = "";     // Catch: JSONException -> L451
        goto L112
    L106:
        r122.layer_id = 0;     // Catch: JSONException -> L451
        goto L109
    L377:
        r117 = r117;
        r118 = r118;
        r213 = r213;
        goto L378
    L51:
        if (r114 != 3) goto L53;
    L92:
        r116 = new ArrayList();     // Catch: JSONException -> L451
        r115 = null;
        goto L93
    L53:
        if (r114 == 13) goto L92;
        if (r114 == 14) goto L92;
        if (r114 == 16) goto L92;
        if (r114 == 15) goto L92;
        if (r114 == 4) goto L92;
        if (r114 == 103) goto L92;
        if (r114 == 25) goto L92;
        if (r114 == 31) goto L92;
        if (r114 == 104) goto L92;
        if (r114 == 5000) goto L92;
        if (r114 == 6018) goto L92;
        if (r114 == 6019) goto L92;
        if (r114 != 8) goto L73;
    L90:
        ArrayList r131 = new ArrayList();     // Catch: JSONException -> L451
    L91:
        r117 = r131;
        r115 = null;
        r116 = null;
        goto L94
    L73:
        if (r114 == 1) goto L90;
        if (r114 == 2) goto L90;
        if (r114 != 6) goto L81;
        r118 = new ArrayList();     // Catch: JSONException -> L451
        r115 = null;
        r116 = null;
        r117 = null;
        goto L95
    L81:
        if (r114 != 24) goto L84;
        r212 = new ArrayList();     // Catch: JSONException -> L451
        r115 = null;
        r116 = null;
        r117 = null;
        r118 = null;
        goto L96
    L84:
        if (r114 != 1239) goto L87;
        r131 = new ArrayList();     // Catch: JSONException -> L451
        goto L91
    L87:
        if (r114 != 7000) goto L89;
        r213 = new ArrayList();     // Catch: JSONException -> L451
        r115 = null;
        r116 = null;
        r117 = null;
        r118 = null;
        r212 = null;
        goto L97
    L89:
        r115 = null;
    L451:
        return false;
    L18:
        r104 = r211;
    L15:
        r103 = null;
        goto L16
    L8:
        if (this.f33023e0 != null) goto L10;
        return false;
    }

    private boolean b(int r310, int r311) {
        String r100 = MapBundleKey.MapObjKey.OBJ_SS_POINAME;
        String r110 = MapBundleKey.MapObjKey.OBJ_GEO;
        String r111 = "index";
        String r112 = "in";
        String r113 = "ty";
        String r114 = MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z;
        String r115 = "y";
        String r116 = "x";
        String r101 = "ud";
        boolean r102 = a();
        String r117 = MapBundleKey.MapObjKey.OBJ_DIS;
        if (r102 == true) goto L6;
        return false;
    L6:
        if (getMapViewListener() != null) goto L8;
        return false;
    L8:
        int r103 = this.nearlyRadius;
        String r210 = MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID;
        String r104 = this.f33043v.GetNearlyObjID(-1, r310, r311, (int) (((double) r103) * getZoomUnitsInMeter()));
        if (r104 != null) goto L12;
        return false;
    L12:
        new ArrayList();
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r104), "dataset");     // Catch: JSONException -> L139
        if (JSONObjectProtectorUtils.getInt((JSONObject) r105.get(0), "ty") != 7000) goto L137;
        ArrayList r106 = new ArrayList();     // Catch: JSONException -> L139
        int r107 = 0;
    L17:
        if (r107 >= r105.length()) goto L134;
        JSONObject r108 = (JSONObject) r105.get(r107);     // Catch: JSONException -> L20
    L22:
        if (r108 != null) goto L25;
        JSONArray r312 = r105;
        String r211 = r113;
    L24:
        r100 = r100;
        String r109 = r116;
    L133:
        r101 = r101;
        r117 = r117;
        r116 = r109;
        r115 = r115;
        r100 = r100;
        r113 = r211;
        r110 = r110;
        r112 = r112;
        r105 = r312;
        r106 = r106;
        r114 = r114;
        r111 = r111;
        r107 = r107 + 1;     // Catch: JSONException -> L139
        goto L17
    L25:
        r312 = r105;
        int r118 = JSONObjectProtectorUtils.getInt(r108, r113);     // Catch: JSONException -> L139
        r211 = r113;
        if (r118 == 26) goto L24;
        MapObj r119 = new MapObj();     // Catch: JSONException -> L139
        r107 = r107;
        String r120 = "";
        if (r108.has(r101) == true) goto L32;
        r119.strUid = "";     // Catch: JSONException -> L139
    L34:
        r119.strText = r108.optString(MapBundleKey.MapObjKey.OBJ_TEXT);     // Catch: JSONException -> L139
        if (r108.has(r112) == false) goto L38;
        r119.nIndex = JSONObjectProtectorUtils.getInt(r108, r112);     // Catch: JSONException -> L139
    L42:
        if (r108.has(r110) == false) goto L51;
        com.baidu.platform.comapi.basestruct.Point r121 = CoordinateUtil.complexPtToPoint(JSONObjectProtectorUtils.getString(r108, r110));     // Catch: JSONException -> L139
        r110 = r110;
        com.baidu.platform.comapi.basestruct.Point r122 = r119.geoPt;     // Catch: JSONException -> L139
        if (r121 != null) goto L46;
        double r123 = 0.0d;
    L47:
        if (r121 != null) goto L49;
        double r124 = 0.0d;
    L50:
        r122.setTo(r123, r124);     // Catch: JSONException -> L139
    L58:
        if (r108.has("ts") == false) goto L61;
        r119.sltime = JSONObjectProtectorUtils.getInt(r108, "ts");     // Catch: JSONException -> L139
    L61:
        if (r108.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ) == false) goto L64;
        r119.slobj = JSONObjectProtectorUtils.getInt(r108, MapBundleKey.MapObjKey.OBJ_SL_OBJ);     // Catch: JSONException -> L139
    L64:
        if (r108.has("visible") == false) goto L66;
        r119.slvisi = JSONObjectProtectorUtils.getInt(r108, "visible");     // Catch: JSONException -> L139
    L66:
        r119.nType = r118;     // Catch: JSONException -> L139
        if (r108.has(MapBundleKey.MapObjKey.OBJ_OFFSET) == false) goto L70;
        r119.offset = JSONObjectProtectorUtils.getInt(r108, MapBundleKey.MapObjKey.OBJ_OFFSET);     // Catch: JSONException -> L139
    L70:
        if (r108.has(r100) == false) goto L72;
        r119.ssName = JSONObjectProtectorUtils.getString(r108, r100);     // Catch: JSONException -> L139
    L72:
        r210 = r210;
        if (r108.has(r210) == false) goto L75;
        r119.ssIndoorId = JSONObjectProtectorUtils.getString(r108, r210);     // Catch: JSONException -> L139
    L75:
        r101 = r101;
        if (r108.has(r101) == false) goto L78;
        r119.ssPoiUid = JSONObjectProtectorUtils.getString(r108, r101);     // Catch: JSONException -> L139
    L78:
        r117 = r117;
        if (r108.has(r117) == false) goto L81;
        r119.offset = JSONObjectProtectorUtils.getInt(r108, r117);     // Catch: JSONException -> L139
    L81:
        r109 = r116;
        if (r108.has(r109) == false) goto L84;
        r119.geoPt.setIntX(JSONObjectProtectorUtils.getInt(r108, r109));     // Catch: JSONException -> L139
        r119.streetArrowCenterX = JSONObjectProtectorUtils.getDouble(r108, r109);     // Catch: JSONException -> L139
    L84:
        r115 = r115;
        if (r108.has(r115) == false) goto L87;
        r119.geoPt.setIntY(JSONObjectProtectorUtils.getInt(r108, r115));     // Catch: JSONException -> L139
        r119.streetArrowCenterY = JSONObjectProtectorUtils.getDouble(r108, r115);     // Catch: JSONException -> L139
    L87:
        r114 = r114;
        if (r108.has(r114) == false) goto L91;
        r119.ssZ = JSONObjectProtectorUtils.getInt(r108, r114);     // Catch: JSONException -> L139
    L91:
        if (r108.has("rotation") == false) goto L95;
        r119.ssRotation = JSONObjectProtectorUtils.getDouble(r108, "rotation");     // Catch: JSONException -> L139
    L95:
        if (r108.has("pid") == false) goto L98;
        r119.ssPanoId = JSONObjectProtectorUtils.getString(r108, "pid");     // Catch: JSONException -> L139
    L98:
        if (r108.has(MapBundleKey.MapObjKey.OBJ_SS_DATA) == false) goto L101;
        r119.ssData = JSONObjectProtectorUtils.getString(r108, MapBundleKey.MapObjKey.OBJ_SS_DATA);     // Catch: JSONException -> L139
    L101:
        if (r108.has("src") == false) goto L103;
        r119.dynamicSrc = JSONObjectProtectorUtils.getInt(r108, "src");     // Catch: JSONException -> L139
    L105:
        if (r108.has("ad") == false) goto L107;
        r119.f33070ad = JSONObjectProtectorUtils.getInt(r108, "ad");     // Catch: JSONException -> L139
    L109:
        if (r108.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE) == false) goto L111;
        r119.adstyle = JSONObjectProtectorUtils.getInt(r108, MapBundleKey.MapObjKey.OBJ_AD_STYLE);     // Catch: JSONException -> L139
    L113:
        if (r108.has(MapBundleKey.MapObjKey.OBJ_QID) == false) goto L115;
        r119.qid = JSONObjectProtectorUtils.getString(r108, MapBundleKey.MapObjKey.OBJ_QID);     // Catch: JSONException -> L139
        String r125 = r120;
    L117:
        if (r108.has(MapBundleKey.MapObjKey.OBJ_PUID) == false) goto L119;
        r119.puid = JSONObjectProtectorUtils.getString(r108, MapBundleKey.MapObjKey.OBJ_PUID);     // Catch: JSONException -> L139
    L121:
        if (r108.has(MapBundleKey.MapObjKey.AD_LOG) == false) goto L123;
        r119.adLog = JSONObjectProtectorUtils.getString(r108, MapBundleKey.MapObjKey.AD_LOG);     // Catch: JSONException -> L139
    L125:
        if (r108.has("url") == false) goto L127;
        r119.url = JSONObjectProtectorUtils.getString(r108, "url");     // Catch: JSONException -> L139
    L129:
        if (r108.has("level") == false) goto L131;
        r119.level = JSONObjectProtectorUtils.getInt(r108, "level");     // Catch: JSONException -> L139
    L132:
        r106 = r106;
        r106.add(r119);     // Catch: JSONException -> L139
        goto L133
    L131:
        r119.level = -1;     // Catch: JSONException -> L139
        goto L132
    L127:
        r119.url = r125;     // Catch: JSONException -> L139
        goto L129
    L123:
        r119.adLog = r125;     // Catch: JSONException -> L139
        goto L125
    L119:
        r119.puid = r125;     // Catch: JSONException -> L139
        goto L121
    L115:
        r125 = r120;
        r119.qid = r125;     // Catch: JSONException -> L139
        goto L117
    L111:
        r119.adstyle = -1;     // Catch: JSONException -> L139
        goto L113
    L107:
        r119.f33070ad = -1;     // Catch: JSONException -> L139
        goto L109
    L103:
        r119.dynamicSrc = -1;     // Catch: JSONException -> L139
        goto L105
    L49:
        r124 = r121.getIntY();     // Catch: JSONException -> L139
        goto L50
    L46:
        r123 = r121.getIntX();     // Catch: JSONException -> L139
        goto L47
    L51:
        r120 = "";
        r101 = r101;
        r110 = r110;
        r111 = r111;
        r112 = r112;
        if (r108.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) == false) goto L58;
        if (r108.has(MapBundleKey.MapObjKey.OBJ_SL_PTY) == false) goto L58;
        r119.geoPt.setTo((int) JSONObjectProtectorUtils.getDouble(r108, MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) JSONObjectProtectorUtils.getDouble(r108, MapBundleKey.MapObjKey.OBJ_SL_PTY));     // Catch: JSONException -> L139
        goto L58
    L38:
        if (r108.has(r111) == false) goto L40;
        r119.nIndex = JSONObjectProtectorUtils.getInt(r108, r111);     // Catch: JSONException -> L139
        goto L42
    L40:
        r119.nIndex = 0;     // Catch: JSONException -> L139
        goto L42
    L32:
        r119.strUid = JSONObjectProtectorUtils.getString(r108, r101);     // Catch: JSONException -> L139
        goto L34
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L139
        r108 = null;
        goto L22
    L134:
        getMapViewListener().onClickedParticleEventMapObj(r106);     // Catch: JSONException -> L139
        return true;
    L137:
        return false;
    L147:
        return false;
    }

    private boolean c(int r100, int r110) {
        if (a() == true) goto L5;
        return false;
    L5:
        SoftReference<MapViewInterface> r101 = this.f33022d0;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.get() == null) goto L76;
        String r102 = this.f33043v.GetNearlyObjID(-1, r100, r110, this.nearlyRadius);
        if (r102 == null) goto L40;
        if (r102.equals("") == true) goto L40;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L19
        r103.put(GXTemplateKey.GAIAX_PX, r100);     // Catch: JSONException -> L17
        r103.put("py", r110);     // Catch: JSONException -> L17
    L23:
        if (this.mListeners == null) goto L71;
        int r104 = 0;
        boolean r111 = false;
    L26:
        if (r104 >= this.mListeners.size()) goto L72;
        v r105 = (v) ListProtector.get(this.mListeners, r104);
        if (r103 == null) goto L37;
        if (r105 == null) goto L37;
        r105.b(r103.toString());
        JSONArray r106 = r103.optJSONArray("dataset");
        if (r106 == null) goto L37;
        JSONObject r107 = r106.optJSONObject(0);
        if (r107 == null) goto L37;
        if (r107.optInt("ty") < 90909) goto L37;
        r111 = true;
    L37:
        r104 = r104 + 1;
        goto L26
    L72:
        return r111;
    L71:
        return false;
    L17:
        e = e;
    L21:
        e.printStackTrace();
    L19:
        e = e;
        r103 = null;
    L40:
        if (this.f33041t == false) goto L42;
        return false;
    L42:
        if (this.mListeners != null) goto L44;
        return false;
    L44:
        if (getMapView() != null) goto L46;
        return false;
    L46:
        if (getMapView().getProjection() == null) goto L77;
        GeoPoint r108 = getMapView().getProjection().fromPixels(r100, r110);
        int r112 = 0;
    L50:
        if (r112 >= this.mListeners.size()) goto L78;
        v r109 = (v) ListProtector.get(this.mListeners, r112);
        if (r109 == null) goto L55;
        r109.b(r108);
    L55:
        r112 = r112 + 1;
        goto L50
    L78:
        return false;
    L77:
        return false;
    L76:
        return false;
    }

    public float GetFZoomToBoundF(Bundle r100, Bundle r101) {
        if (a() == true) goto L7;
        return 0.0f;
    L7:
        return this.f33043v.GetFZoomToBoundF(r100, r101);
    }

    public void addStreetCustomMarker(Bundle r100, Bitmap r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.AddStreetCustomMarker(r100, r101);
    }

    public void animateTo(GeoPoint r100, int r101) {
        if (a() == true) goto L5;
        return;
    L5:
        MapStatus r102 = getMapStatus();
        r102.centerPtX = r100.getLongitude();
        r102.centerPtY = r100.getLatitude();
        setMapStatusWithAnimation(r102, r101);
    }

    public void d(int r100, int r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.MoveToScrPoint(r100, r101);
    }

    public int getScaleLevel(int r100, int r101) {
        if (a() == true) goto L7;
        return 0;
    L7:
        return this.f33043v.getScaleLevel(r100, r101);
    }

    public boolean handleKeyEvent(int r100, KeyEvent r101) {
        int r102 = GetAdaptKeyCode(r100);
        if (r102 != 0) goto L5;
        return false;
    L5:
        MapMsgProc(1, r102, 0);
        return true;
    }

    public boolean isInFocusBarBorder(GeoPoint r110, double r111) {
        if (a() == true) goto L5;
        return false;
    L5:
        if (r110 != null) goto L7;
        return false;
    L7:
        if (this.f33043v.IsPointInFocusBarBorder(r110.getLongitude(), r110.getLatitude(), r111) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public void procGestureForLog(boolean r100, com.baidu.platform.comapi.basestruct.Point r101) {
        if (this.E.f33061a == true) goto L5;
        MapStatus r102 = getMapStatus();
        a r103 = this.E;
        r103.f33061a = true;
        r103.f33062b = r102.level;
        r103.f33063c = new GeoPoint(r102.centerPtX, r102.centerPtY);
        a r104 = this.E;
        r104.f33064d = new com.baidu.platform.comapi.basestruct.Point(0, 0);
    L5:
        if (r100 == false) goto L8;
        int r105 = Math.abs(r101.getIntX());
        int r106 = Math.abs(r101.getIntY());
        com.baidu.platform.comapi.basestruct.Point r107 = this.E.f33064d;
        r107.setIntX(r107.getIntX() + r105);
        com.baidu.platform.comapi.basestruct.Point r108 = this.E.f33064d;
        r108.setIntY(r108.getIntY() + r106);
        return;
    }

    public void scrollBy(int r100, int r101) {
        if (r100 != 0) goto L5;
        if (r101 != 0) goto L5;
        return;
    L5:
        MapStatus.WinRound r102 = getMapStatus().winRound;
        d((r102.left + (this.f33046y / 2)) + r100, (r102.top + (this.f33047z / 2)) + r101);
    }

    public boolean setLayerSceneMode(long r100, MapSceneMode r101) {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.SetLayerSceneMode(r100, r101.getMode());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setMapStatus(MapStatus r100, boolean r101) {
        if (a() == false) goto L8;
        if (r100 == null) goto L9;
        Bundle r102 = new Bundle();
        r102.putDouble("level", r100.level);
        r102.putDouble("rotation", r100.rotation);
        r102.putDouble("overlooking", r100.overlooking);
        r102.putDouble("centerptx", r100.centerPtX);
        r102.putDouble("centerpty", r100.centerPtY);
        r102.putDouble("centerptz", r100.centerPtZ);
        r102.putInt("left", r100.winRound.left);
        r102.putInt("right", r100.winRound.right);
        r102.putInt("top", r100.winRound.top);
        r102.putInt("bottom", r100.winRound.bottom);
        r102.putLong("gleft", r100.geoRound.left);
        r102.putLong("gbottom", r100.geoRound.bottom);
        r102.putLong("gtop", r100.geoRound.top);
        r102.putLong("gright", r100.geoRound.right);
        r102.putFloat("yoffset", r100.yOffset);
        r102.putFloat("xoffset", r100.xOffset);
        r102.putInt(GXTemplateKey.GAIAX_ANIMATION, 0);
        r102.putInt("animatime", 0);
        r102.putInt("bfpp", r100.bfpp ? 1 : 0);
        r102.putString("panoid", r100.panoId);
        r102.putInt("autolink", r101 ? 1 : 0);
        r102.putFloat("siangle", r100.streetIndicateAngle);
        r102.putInt("isbirdeye", r100.isBirdEye ? 1 : 0);
        r102.putInt("ssext", r100.streetExt);
        r102.putFloat("adapterZoomUnits", r100.adapterZoomUnits);
        this.f33043v.SetMapStatus(r102);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setMapStatusWithAnimation(MapStatus r100, int r101) {
        if (a() == true) goto L6;
        return;
    L6:
        if (this.f33043v == null) goto L28;
        if (r100 == null) goto L29;
        Bundle r102 = new Bundle();
        r102.putDouble("level", r100.level);
        r102.putDouble("rotation", r100.rotation);
        r102.putDouble("overlooking", r100.overlooking);
        if (isCompass == false) goto L12;
    L25:
        r102.putDouble("centerptx", r100.centerPtX);
        r102.putDouble("centerpty", r100.centerPtY);
    L26:
        r102.putDouble("centerptz", r100.centerPtZ);
        r102.putInt("left", r100.winRound.left);
        r102.putInt("right", r100.winRound.right);
        r102.putInt("top", r100.winRound.top);
        r102.putInt("bottom", r100.winRound.bottom);
        r102.putLong("gleft", r100.geoRound.left);
        r102.putLong("gright", r100.geoRound.right);
        r102.putLong("gbottom", r100.geoRound.bottom);
        r102.putLong("gtop", r100.geoRound.top);
        r102.putFloat("xoffset", r100.xOffset);
        r102.putFloat("yoffset", r100.yOffset);
        r102.putInt(GXTemplateKey.GAIAX_ANIMATION, 1);
        r102.putInt("animatime", r101);
        r102.putInt("bfpp", r100.bfpp ? 1 : 0);
        r102.putString("panoid", r100.panoId);
        r102.putInt("autolink", 0);
        r102.putFloat("siangle", r100.streetIndicateAngle);
        r102.putInt("isbirdeye", r100.isBirdEye ? 1 : 0);
        r102.putInt("ssext", r100.streetExt);
        r102.putFloat("roadOffsetX", r100.roadOffsetX);
        r102.putFloat("roadOffsetY", r100.roadOffsetY);
        r102.putFloat("adapterZoomUnits", r100.adapterZoomUnits);
        mapStatusChangeStart();
        this.mIsAnimating = true;
        this.f33043v.SetMapStatus(r102);
        return;
    L12:
        if (this.f33018J == true) goto L25;
        if (this.f33038q != null) goto L17;
    L19:
        LatLng r103 = this.f33039r;
        if (r103 != null) goto L22;
    L24:
        r102.putDouble("centerptx", r100.centerPtX);
        r102.putDouble("centerpty", r100.centerPtY);
        goto L26
    L22:
        if (this.f33040s == false) goto L24;
        GeoPoint r104 = CoordUtil.ll2mc(r103);
        r102.putDouble("centerptx", r104.getLongitudeE6());
        r102.putDouble("centerpty", r104.getLatitudeE6());
        goto L26
    L17:
        if (this.f33040s == false) goto L19;
        Projection r105 = this.f33022d0.get().getProjection();
        Point r106 = this.f33038q;
        GeoPoint r107 = r105.fromPixels(r106.x, r106.y);
        r102.putDouble("centerptx", r107.getLongitudeE6());
        r102.putDouble("centerpty", r107.getLatitudeE6());
        goto L26
    L29:
        return;
    }

    public boolean setMapTheme(int r100, Bundle r101) {
        if (a() == true) goto L7;
        return false;
    L7:
        if (this.f33043v.getMapTheme() != r100) goto L10;
        return true;
    L10:
        this.f33034m = r100;
        return this.f33043v.setMapTheme(r100, r101);
    }

    public void setMaxAndMinZoomLevel(float r100, float r101) {
        this.mMaxZoomLevel = r100;
        this.mMinZoomLevel = r101;
    }

    public void setScreenSize(int r100, int r101) {
        this.f33046y = r100;
        this.f33047z = r101;
    }

    public void setStreetMarkerClickable(String r100, boolean r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.SetStreetMarkerClickable(r100, r101);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean r100, String r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33043v.SetTargetStreetCustomMarkerVisibility(r100, r101);
    }

    public boolean switchBaseIndoorMapFloor(String r100, String r101) {
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.SwitchBaseIndoorMapFloor(r100, r101);
    }

    public static /* synthetic */ boolean a(MapController r100, boolean r101) {
        r100.P = r101;
        return r101;
    }

    public static /* synthetic */ boolean b(MapController r100, boolean r101) {
        r100.Q = r101;
        return r101;
    }

    public static /* synthetic */ boolean c(MapController r100, boolean r101) {
        r100.B = r101;
        return r101;
    }

    public static /* synthetic */ boolean d(MapController r100, boolean r101) {
        r100.O = r101;
        return r101;
    }

    private boolean a(int r110, int r111, int r210) {
        boolean r100 = false;
        if (a() == true) goto L5;
        return false;
    L5:
        SoftReference<MapViewInterface> r101 = this.f33022d0;
        if (r101 != null) goto L8;
    L43:
        return r100;
    L8:
        if (r101.get() == null) goto L43;
        MapViewInterface r102 = this.f33022d0.get();
        long r103 = 0;
        int r104 = r102.getOverlays().size() - 1;     // Catch: JSONException -> L28
    L12:
        if (r104 < 0) goto L27;
        Overlay r105 = (Overlay) ListProtector.get(r102.getOverlays(), r104);     // Catch: JSONException -> L28
        if (r105.mType != 27) goto L26;
        r103 = r105.mLayerID;     // Catch: JSONException -> L28
        int r106 = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());     // Catch: JSONException -> L28
        AppBaseMap r112 = this.f33043v;     // Catch: JSONException -> L28
        if (r112 == null) goto L26;
        String r107 = r112.GetNearlyObjID(r103, r111, r210, r106);     // Catch: JSONException -> L28
        if (r107 == null) goto L26;
        if (r107.equals("") == true) goto L26;
        JSONObject r108 = (JSONObject) JSONObjectProtectorUtils.getJSONArray(new JSONObject(r107), "dataset").get(0);     // Catch: JSONException -> L28
        int r109 = JSONObjectProtectorUtils.getInt(r108, "itemindex");     // Catch: JSONException -> L28
        int r113 = r108.optInt("clickindex", -1);     // Catch: JSONException -> L25
        long r114 = r103;
        int r115 = r109;
        r100 = true;
    L32:
        if (r110 != 1) goto L43;
        if (getMapViewListener() == null) goto L43;
        if (getMapView() == null) goto L43;
        if (getMapView().getProjection() == null) goto L43;
        GeoPoint r116 = r102.getProjection().fromPixels(r111, r210);
        if (r113 == (-1)) goto L42;
        getMapViewListener().onClickedItem(r115, r113, r116, r114);
        goto L43
    L42:
        getMapViewListener().onClickedItem(r115, r116, r114);
    L29:
        r114 = r103;
        r115 = r109;
    L30:
        r113 = -1;
    L26:
        r104 = r104 - 1;
        goto L12
    L27:
        r114 = r103;
        r115 = -1;
    L28:
        r109 = -1;
        goto L29
    }

    public int MapMsgProc(int r110, int r111, int r112) {
        return MapMsgProc(r110, r111, r112, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public boolean forceSetMapThemeScene(int r100, int r101, Bundle r102) {
        this.f33034m = r100;
        this.f33033l = r101;
        if (a() == true) goto L7;
        return false;
    L7:
        return this.f33043v.setMapThemeScene(r100, r101, r102);
    }

    public float getZoomToBound(Bundle r100, int r101, int r102) {
        if (a() == true) goto L7;
        return 0.0f;
    L7:
        return this.f33043v.GetZoomToBound(r100, r101, r102);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setMapStatusWithAnimation(MapStatus r100, int r101, int r102) {
        if (a() == true) goto L6;
        return;
    L6:
        if (this.f33043v == null) goto L14;
        if (r100 == null) goto L15;
        Bundle r103 = new Bundle();
        r103.putInt("animationType", r101);
        r103.putInt("animatime", r102);
        r103.putInt("left", r100.winRound.left);
        r103.putInt("right", r100.winRound.right);
        r103.putInt("top", r100.winRound.top);
        r103.putInt("bottom", r100.winRound.bottom);
        if (r101 == 4) goto L12;
        r103.putDouble("level", r100.level);
        r103.putDouble("rotation", r100.rotation);
        r103.putDouble("overlooking", r100.overlooking);
        r103.putDouble("centerptx", r100.centerPtX);
        r103.putDouble("centerpty", r100.centerPtY);
        r103.putDouble("centerptz", r100.centerPtZ);
        r103.putLong("gleft", r100.geoRound.left);
        r103.putLong("gright", r100.geoRound.right);
        r103.putLong("gbottom", r100.geoRound.bottom);
        r103.putLong("gtop", r100.geoRound.top);
        r103.putFloat("xoffset", r100.xOffset);
        r103.putFloat("yoffset", r100.yOffset);
        r103.putInt("bfpp", r100.bfpp ? 1 : 0);
        r103.putString("panoid", r100.panoId);
        r103.putInt("autolink", 0);
        r103.putFloat("siangle", r100.streetIndicateAngle);
        r103.putInt("isbirdeye", r100.isBirdEye ? 1 : 0);
        r103.putInt("ssext", r100.streetExt);
        r103.putFloat("roadOffsetX", r100.roadOffsetX);
        r103.putFloat("roadOffsetY", r100.roadOffsetY);
        r103.putFloat("adapterZoomUnits", r100.adapterZoomUnits);
    L12:
        this.f33043v.SetNewMapStatus(r103);
        return;
    L15:
        return;
    }

    public boolean setMapThemeScene(int r100, int r101, Bundle r102) {
        if (a() == true) goto L7;
        return false;
    L7:
        if (this.f33043v.getMapTheme() == r100) goto L9;
    L12:
        this.f33034m = r100;
        this.f33033l = r101;
        return this.f33043v.setMapThemeScene(r100, r101, r102);
    L9:
        if (this.f33043v.getMapScene() != r101) goto L12;
        return true;
    }

    private boolean a(int r110, int r111, boolean r112) {
        SoftReference<MapViewInterface> r100 = this.f33022d0;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.get() == null) goto L13;
        int r101 = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
        MapViewInterface r102 = this.f33022d0.get();
        int r103 = r102.getBmlayers().size() - 1;
    L8:
        if (r103 < 0) goto L13;
        if (((BmLayer) ListProtector.get(r102.getBmlayers(), r103)).a(r110, r111, r101, r112, this.V) == true) goto L11;
        r103 = r103 - 1;
        goto L8
    L11:
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setMapStatusWithAnimation(MapStatus r100, int r101, boolean r102) {
        if (a() == true) goto L6;
        return;
    L6:
        if (this.f33043v == null) goto L11;
        if (r100 == null) goto L12;
        Bundle r103 = new Bundle();
        r103.putDouble("level", r100.level);
        r103.putDouble("rotation", r100.rotation);
        r103.putDouble("overlooking", r100.overlooking);
        r103.putDouble("centerptx", r100.centerPtX);
        r103.putDouble("centerpty", r100.centerPtY);
        r103.putDouble("centerptz", r100.centerPtZ);
        r103.putInt("left", r100.winRound.left);
        r103.putInt("right", r100.winRound.right);
        r103.putInt("top", r100.winRound.top);
        r103.putInt("bottom", r100.winRound.bottom);
        r103.putLong("gleft", r100.geoRound.left);
        r103.putLong("gright", r100.geoRound.right);
        r103.putLong("gbottom", r100.geoRound.bottom);
        r103.putLong("gtop", r100.geoRound.top);
        r103.putFloat("xoffset", r100.xOffset);
        r103.putFloat("yoffset", r100.yOffset);
        r103.putInt(GXTemplateKey.GAIAX_ANIMATION, 1);
        r103.putInt("animatime", r101);
        r103.putInt("bfpp", r100.bfpp ? 1 : 0);
        r103.putString("panoid", r100.panoId);
        r103.putInt("autolink", r102 ? 1 : 0);
        r103.putFloat("siangle", r100.streetIndicateAngle);
        r103.putInt("isbirdeye", r100.isBirdEye ? 1 : 0);
        r103.putInt("ssext", r100.streetExt);
        r103.putFloat("roadOffsetX", r100.roadOffsetX);
        r103.putFloat("roadOffsetY", r100.roadOffsetY);
        r103.putFloat("adapterZoomUnits", r100.adapterZoomUnits);
        this.f33043v.SetMapStatus(r103);
        return;
    L12:
        return;
    }

    public boolean handleFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        int r104 = 0;
        if (f33012b == true) goto L6;
        return false;
    L6:
        if (this.U == true) goto L9;
        return false;
    L9:
        if (this.f33030j == true) goto L11;
        return false;
    L11:
        float r105 = (float) (((double) (((float) Math.sqrt((r102 * r102) + (r103 * r103))) / (SysOSUtil.getInstance().getDensityDPI() / 310.0f))) * 1.3d);
        if (getMapControlMode() != MapControlMode.STREET) goto L14;
    L17:
        this.B = true;
        if (this.mListeners == null) goto L29;
        com.baidu.mapsdkplatform.comapi.map.s r106 = getMapStatusInner();
        int r107 = 0;
    L21:
        if (r107 >= this.mListeners.size()) goto L29;
        v r108 = (v) ListProtector.get(this.mListeners, r107);
        if (r108 == null) goto L28;
        if (r108.a(r101, r102, r103, r106) == false) goto L28;
        this.f33025g0 = false;
        return false;
    L28:
        r107 = r107 + 1;
    L29:
        getGestureMonitor().a();
        mapStatusChangeStart();
        MapMsgProc(34, (int) r105, (((int) r101.getY()) << 16) | ((int) r101.getX()));
        if (getMapViewListener() == null) goto L32;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.c());
    L32:
        this.f33025g0 = false;
        if (this.mListeners != null) goto L35;
    L40:
        return true;
    L35:
        if (r104 >= this.mListeners.size()) goto L40;
        v r109 = (v) ListProtector.get(this.mListeners, r104);
        if (r109 == null) goto L39;
        r109.a(r101);
    L39:
        r104 = r104 + 1;
        goto L35
    L14:
        if (r105 >= 300.0f) goto L17;
        this.B = false;
        return false;
    }

    public void saveScreenToLocal(String r100, int r101, int r102, int r103, int r104) {
        if (a() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        String r105 = null;
        if (r103 == 0) goto L12;
        if (r104 == 0) goto L12;
        JSONObject r106 = new JSONObject();
        r106.put("x", r101);     // Catch: Exception -> L14
        r106.put("y", r102);     // Catch: Exception -> L14
        r106.put("width", r103);     // Catch: Exception -> L14
        r106.put("height", r104);     // Catch: Exception -> L14
        r105 = r106.toString();     // Catch: Exception -> L14
    L12:
        this.f33043v.SaveScreenToLocal(r100, r105);
        return;
    }

    public int MapMsgProc(int r110, int r111, int r112, int r210, int r211, double r212, double r213, double r214, double r215) {
        if (a() == true) goto L7;
        return -1;
    L7:
        return MapProc(this.f33044w, r110, r111, r112, r210, r211, r212, r213, r214, r215);
    }
}
