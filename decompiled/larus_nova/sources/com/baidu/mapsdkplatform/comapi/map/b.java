package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapLanguage;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.ParticleEffectType;
import com.baidu.mapapi.map.PoiTagType;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b implements MapSDKLayerDataInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f32099a = 1096.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f32100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f32101c;
    private BmLayer A;
    private com.baidu.mapsdkplatform.comapi.map.z.a B;
    private boolean C;
    private g D;
    private i E;
    private h F;
    private int G;
    private int H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f32102J;
    private long K;
    private long L;
    private boolean M;
    private Queue<C0645b> N;
    public MapStatusUpdate O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private MapController S;
    private LocationOverlay T;
    private com.baidu.platform.comapi.map.c U;
    private boolean V;
    public Point W;
    public Point X;
    private boolean Y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f32103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f32104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f32105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f32106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f32107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f32108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f32109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f32110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f32111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f32112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f32113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f32114o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f32115p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f32116q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f32117r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f32118s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private x f32119t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private w f32120u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<com.baidu.platform.comapi.map.v> f32121v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    AppBaseMap f32122w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<com.baidu.mapsdkplatform.comapi.map.a> f32123x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private HashMap<MapLayer, com.baidu.mapsdkplatform.comapi.map.a> f32124y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private v f32125z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32126a = null;

        static {
            int[] r100 = new int[MapLayer.values().length];
            f32126a = r100;
            r100[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f32126a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f32126a[MapLayer.BM_LAYER_OVERLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f32126a[MapLayer.MAP_LAYER_HEATMAP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f32126a[MapLayer.MAP_LAYER_HEXAGONMAP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f32126a[MapLayer.MAP_LAYER_TRACE_OVERLAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.map.b$b, reason: collision with other inner class name */
    public static class C0645b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f32127a;

        public C0645b(Bundle r100) {
            this.f32127a = r100;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public synchronized void h() {
        monitor-enter(this);
        this.Y = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean j() {
        return false;
    }

    public String l() {
        return null;
    }

    private void J() {
        this.f32123x = new CopyOnWriteArrayList();
        this.f32124y = new HashMap();
        v r100 = new v();
        this.f32125z = r100;
        a(r100);
        this.f32124y.put(MapLayer.MAP_LAYER_OVERLAY, this.f32125z);
        E(false);
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.setDEMEnable(false);
        return;
    }

    private void U() {
        MapController r100 = this.S;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.mIsMoving == true) goto L16;
        r100.mIsMoving = true;
        int r101 = 0;
        r100.mIsAnimating = false;
        if (this.f32121v == null) goto L20;
        s r102 = z();
    L11:
        if (r101 >= this.f32121v.size()) goto L21;
        com.baidu.platform.comapi.map.v r103 = (com.baidu.platform.comapi.map.v) ListProtector.get(this.f32121v, r101);
        if (r103 == null) goto L15;
        r103.c(r102);
    L15:
        r101 = r101 + 1;
        goto L11
    L21:
        return;
    L20:
        return;
    }

    private void a() {
        if (this.f32110k == true) goto L15;
        if (this.f32107h == true) goto L15;
        if (this.f32106g == true) goto L15;
        if (this.f32112m == true) goto L15;
        float r100 = this.f32105f;
        this.f32103d = r100;
        MapController r101 = this.S;
        if (r101 == null) goto L23;
        r101.mMaxZoomLevel = r100;
        return;
    L23:
        return;
    L15:
        if (this.f32103d <= 20.0f) goto L20;
        this.f32103d = 20.0f;
        MapController r102 = this.S;
        if (r102 == null) goto L20;
        r102.mMaxZoomLevel = 20.0f;
    L20:
        if (z().f32200a <= 20.0f) goto L25;
        s r103 = z();
        r103.f32200a = 20.0f;
        a(r103);
        return;
    }

    public LatLngBounds A() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L6;
        return null;
    L6:
        Bundle r101 = r100.getMapStatusLimits();
        LatLngBounds.Builder r102 = new LatLngBounds.Builder();
        int r103 = r101.getInt("maxCoorx");
        int r104 = r101.getInt("minCoorx");
        int r105 = r101.getInt("maxCoory");
        r102.include(CoordUtil.mc2ll(new GeoPoint(r101.getInt("minCoory"), r103))).include(CoordUtil.mc2ll(new GeoPoint(r105, r104)));
        return r102.build();
    }

    public float B() {
        MapController r100 = this.S;
        if (r100 == null) goto L7;
        return r100.mMaxZoomLevel;
    L7:
        return this.f32103d;
    }

    public float[] C() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getProjectionMatrix();
    }

    public float[] D() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getViewMatrix();
    }

    public void G() {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        List<com.baidu.mapsdkplatform.comapi.map.a> r100 = this.f32123x;
        monitor-enter(r100);
        Iterator<com.baidu.mapsdkplatform.comapi.map.a> r101 = this.f32123x.iterator();     // Catch: Throwable -> L13
    L9:
        if (r101.hasNext() == false) goto L11;
        com.baidu.mapsdkplatform.comapi.map.a r102 = r101.next();     // Catch: Throwable -> L13
        this.f32122w.ShowLayers(r102.f32095a, false);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean H() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.LayersIsShow(r100.getLayerIDByTag("poiindoormarklayer"));
    }

    public boolean L() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.IsBaseIndoorMapMode();
    }

    public boolean M() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.LayersIsShow(r100.getLayerIDByTag("basemap"));
    }

    public boolean N() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getDrawHouseHeightEnable();
    }

    public boolean V() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.LayersIsShow(r100.getLayerIDByTag("basepoi"));
    }

    public void W() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L9;
        x r101 = this.f32119t;
        if (r101 == null) goto L10;
        r100.RemoveLayer(r101.f32095a);
        this.f32123x.remove(this.f32119t);
        return;
    L10:
        return;
    }

    public void X() {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        List<com.baidu.mapsdkplatform.comapi.map.a> r100 = this.f32123x;
        monitor-enter(r100);
        Iterator<com.baidu.mapsdkplatform.comapi.map.a> r101 = this.f32123x.iterator();     // Catch: Throwable -> L17
    L9:
        if (r101.hasNext() == false) goto L14;
        com.baidu.mapsdkplatform.comapi.map.a r102 = r101.next();     // Catch: Throwable -> L17
        if ((r102 instanceof g) == true) goto L12;
        this.f32122w.ShowLayers(r102.f32095a, true);     // Catch: Throwable -> L17
        goto L9
    L12:
        this.f32122w.ShowLayers(r102.f32095a, false);     // Catch: Throwable -> L17
        goto L9
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L17
        this.f32122w.ShowTrafficMap(false);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void Y() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L9;
        g r101 = this.D;
        if (r101 == null) goto L10;
        r100.startHeatMapFrameAnimation(r101.f32095a);
        return;
    L10:
        return;
    }

    public void Z() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L9;
        g r101 = this.D;
        if (r101 == null) goto L10;
        r100.stopHeatMapFrameAnimation(r101.f32095a);
        return;
    L10:
        return;
    }

    public void a0() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L6;
        r100.updateBaseLayers();
        return;
    }

    public void b() {
        MapController r100 = this.S;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.mIsMoving == false) goto L8;
        return;
    L8:
        if (r100.mIsAnimating == true) goto L23;
        r100.mIsAnimating = true;
        if (this.f32121v != null) goto L12;
        return;
    L12:
        s r101 = z();
        int r102 = 0;
    L14:
        if (r102 >= this.f32121v.size()) goto L24;
        com.baidu.platform.comapi.map.v r103 = (com.baidu.platform.comapi.map.v) ListProtector.get(this.f32121v, r102);
        if (r103 == null) goto L18;
        r103.c(r101);
    L18:
        r102 = r102 + 1;
        goto L14
    L24:
        return;
    }

    public boolean c() {
        x r100 = this.f32119t;
        if (r100 == null) goto L8;
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.cleanSDKTileDataCache(r100.f32095a);
    L8:
        return false;
    }

    public void d() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.ClearSDKLayer(this.f32125z.f32095a);
    }

    public void e() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L9;
        g r101 = this.D;
        if (r101 == null) goto L10;
        r100.clearHeatMapLayerCache(r101.f32095a);
        this.f32122w.UpdateLayers(this.D.f32095a);
        return;
    L10:
        return;
    }

    public void f() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L9;
        i r101 = this.E;
        if (r101 == null) goto L10;
        r100.clearHexagonLayerCache(r101.f32095a);
        this.f32122w.UpdateLayers(this.E.f32095a);
        return;
    L10:
        return;
    }

    public void g() {
        LocationOverlay r100 = this.T;
        if (r100 == null) goto L6;
        r100.clearLocationLayerData(null);
        return;
    }

    public boolean m() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getCustomTrafficColorEnable();
    }

    public s n() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L6;
        return null;
    L6:
        Bundle r101 = r100.GetMapStatus(false);
        s r102 = new s();
        r102.a(r101);
        return r102;
    }

    public String o() {
        if (this.V == false) goto L5;
        return "";
    L5:
        return "GS（2024）2196号";
    }

    public MapBaseIndoorMapInfo p() {
        String r100 = "";
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.GetFocusedBaseIndoorMapInfo();
        if (r102 != null) goto L8;
        return null;
    L8:
        ArrayList r103 = new ArrayList(1);
        JSONObject r104 = new JSONObject(r102);     // Catch: JSONException -> L19
        String r105 = r104.optString("focusindoorid");     // Catch: JSONException -> L19
        r100 = r104.optString("curfloor");     // Catch: JSONException -> L17
        JSONArray r106 = r104.optJSONArray("floorlist");     // Catch: JSONException -> L17
        if (r106 == null) goto L23;
        int r107 = 0;
    L14:
        if (r107 >= r106.length()) goto L23;
        r103.add(r106.get(r107).toString());     // Catch: JSONException -> L17
        r107 = r107 + 1;
    L23:
        return new MapBaseIndoorMapInfo(r105, r100, r103);
    L17:
        e = e;
        String r108 = r100;
        r100 = r105;
    L21:
        e.printStackTrace();
        String r109 = r108;
        r105 = r100;
        r100 = r109;
    L19:
        e = e;
        r108 = "";
        goto L21
    }

    public int q() {
        AppBaseMap r100 = this.f32122w;
        if (r100 == null) goto L7;
        r100.getFontSizeLevel();
        return 1;
    L7:
        return 1;
    }

    public String u() {
        if (this.V == false) goto L5;
        return "";
    L5:
        return "GS（2024）2196号";
    }

    public String v() {
        if (this.V == false) goto L5;
        return "";
    L5:
        return "百度智图\nMapbox\nMapKin\n樂客LocalKing PalmCit\nESO DigitalGlobal spaceview\nOSRM Copyright ©2017, Project OSRMcontributors, all rights reserved\nHERE© 2019 HERE, all rights reserved\nOpenStreetMap© OpenStreetMapContributor;(OSMF)";
    }

    public int x() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMapLanguage();
    }

    public String y() {
        if (this.V == false) goto L5;
        return "";
    L5:
        return "甲测资字11111342";
    }

    public s z() {
        AppBaseMap r100 = this.f32122w;
        if (r100 != null) goto L6;
        return null;
    L6:
        Bundle r101 = r100.GetMapStatus();
        s r102 = new s();
        r102.a(r101);
        return r102;
    }

    private void I() {
        f32100b = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);     // Catch: JSONException -> L10
        f32101c = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);     // Catch: JSONException -> L10
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L10
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L10
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L10
        r102.put("x", f32100b);     // Catch: JSONException -> L10
        r102.put("y", f32100b);     // Catch: JSONException -> L10
        r102.put("hidetime", 1000);     // Catch: JSONException -> L10
        r101.put(r102);     // Catch: JSONException -> L10
        r100.put("dataset", r101);     // Catch: JSONException -> L10
        com.baidu.platform.comapi.map.c r103 = this.U;     // Catch: JSONException -> L10
        if (r103 == null) goto L15;
        r103.setData(r100.toString());     // Catch: JSONException -> L10
        this.U.UpdateOverlay();     // Catch: JSONException -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public double F() {
        return z().f32212m;
    }

    public int E() {
        return this.G;
    }

    public boolean K() {
        return this.f32112m;
    }

    public boolean O() {
        return this.f32113n;
    }

    public boolean P() {
        return this.f32117r;
    }

    public boolean Q() {
        return this.f32107h;
    }

    public boolean R() {
        return this.f32114o;
    }

    public boolean S() {
        return this.f32106g;
    }

    public boolean T() {
        return this.f32115p;
    }

    public AppBaseMap i() {
        return this.f32122w;
    }

    public boolean k() {
        return this.f32108i;
    }

    public int r() {
        return this.H;
    }

    public MapStatusUpdate s() {
        return this.O;
    }

    public boolean t() {
        return this.f32109j;
    }

    public boolean w() {
        return this.V;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mapsdkplatform_comapi_map_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private boolean h(Bundle r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.addSDKTileData(r100);
    }

    private boolean m(Bundle r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L8;
        return false;
    L8:
        boolean r102 = r101.updateSDKTile(r100);
        if (r102 == false) goto L11;
        D(r102);
        this.f32122w.UpdateLayers(this.f32119t.f32095a);
    L11:
        return r102;
    }

    public void A(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f32106g = r100;
        r101.ShowTrafficMap(r100);
    }

    public void B(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTwoTouchClickZoomEnabled(r100);
    }

    public void C(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setEnableZoom(r100);
        this.f32115p = r100;
    }

    public void D(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L9;
        x r102 = this.f32119t;
        if (r102 == null) goto L10;
        r101.ShowLayers(r102.f32095a, r100);
        return;
    L10:
        return;
    }

    public void E(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 == false) goto L10;
        this.f32103d = 22.0f;
        this.f32105f = 22.0f;
        MapController r102 = this.S;
        if (r102 == null) goto L13;
        r102.mMaxZoomLevel = 22.0f;
    L13:
        r101.ShowBaseIndoorMap(r100);
        return;
    L10:
        this.f32103d = 22.0f;
        this.f32105f = 22.0f;
        MapController r103 = this.S;
        if (r103 == null) goto L13;
        r103.mMaxZoomLevel = 22.0f;
        goto L13
    }

    public void F(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.ShowLayers(r101.getLayerIDByTag("poiindoormarklayer"), r100);
        return;
    }

    public void G(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.ShowLayers(10, r100);
    }

    public void H(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.ShowLayers(6, r100);
    }

    public void I(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.ShowLayers(r101.getLayerIDByTag("basepoi"), r100);
        return;
    }

    public void J(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.showTrafficUGCMap(r100);
        return;
    }

    public boolean K(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return false;
    L5:
        long r102 = r101.getLayerIDByTag("carnavinode");
        long r103 = this.f32122w.getLayerIDByTag(MapController.ANDROID_SDK_LAYER_TAG);
        if (r102 != 0) goto L8;
        return false;
    L8:
        if (r103 == 0) goto L22;
        if (r100 == false) goto L15;
        if (this.R == true) goto L19;
        boolean r104 = this.f32122w.SwitchLayer(r102, r103);
        this.R = true;
        return r104;
    L19:
        return false;
    L15:
        if (this.R == false) goto L21;
        boolean r105 = this.f32122w.SwitchLayer(r103, r102);
        this.R = false;
        return r105;
    L21:
        return false;
    L22:
        return false;
    }

    public void a(Bitmap r100) {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        JSONArray r102 = new JSONArray();
        JSONObject r103 = new JSONObject();
        r101.put("type", 0);     // Catch: JSONException -> L12
        r103.put("x", f32100b);     // Catch: JSONException -> L12
        r103.put("y", f32101c);     // Catch: JSONException -> L12
        r103.put("hidetime", 1000);     // Catch: JSONException -> L12
        r102.put(r103);     // Catch: JSONException -> L12
        r101.put("dataset", r102);     // Catch: JSONException -> L12
    L14:
        if (r100 != null) goto L16;
        Bundle r104 = null;
    L18:
        if (this.U != null) goto L20;
        return;
    L20:
        if (TextUtils.isEmpty(r101.toString()) == true) goto L22;
        this.U.setData(r101.toString());
    L22:
        if (r104 == null) goto L24;
        this.U.setParam(r104);
    L24:
        this.U.UpdateOverlay();
        return;
    L16:
        Bundle r105 = new Bundle();
        Bundle r106 = new Bundle();
        ByteBuffer r107 = ByteBuffer.allocate((r100.getWidth() * r100.getHeight()) * 4);
        r100.copyPixelsToBuffer(r107);
        r106.putByteArray("imgData", r107.array());
        r106.putString("imgKey", r100.hashCode() + "_" + System.currentTimeMillis());
        r106.putInt("imgH", r100.getHeight());
        r106.putInt("imgW", r100.getWidth());
        r106.putInt("hasIcon", 1);
        r105.putBundle("iconData", r106);
        r104 = r105;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public void b(Bundle r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L9;
        i r102 = this.E;
        if (r102 == null) goto L10;
        r101.addHexagonMapData(r102.f32095a, r100);
        return;
    L10:
        return;
    }

    public void c(Bundle r100) {
        if (r100.get("param") == null) goto L14;
        Bundle r101 = (Bundle) r100.get("param");
        int r102 = r101.getInt("type");
        if (r102 != d.f32144d.ordinal()) goto L8;
        r101.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L8:
        if (r102 < d.f32146f.ordinal()) goto L11;
        r101.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L11:
        if (r102 != d.f32142b.ordinal()) goto L13;
        r101.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L13:
        r101.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L14:
        int r103 = r100.getInt("type");
        if (r103 != d.f32144d.ordinal()) goto L18;
        r100.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L18:
        if (r103 < d.f32146f.ordinal()) goto L21;
        r100.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L21:
        if (r103 != d.f32142b.ordinal()) goto L23;
        r100.putLong("layer_addr", this.f32125z.f32095a);
        return;
    L23:
        r100.putLong("layer_addr", this.f32125z.f32095a);
    }

    public void d(Bundle r100) {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        c(r100);
        a(r100);
        this.f32122w.addOneOverlayItem(r100);
    }

    public boolean e(Bundle r100) {
        if (this.f32122w != null) goto L5;
        return false;
    L5:
        x r101 = new x();
        this.f32119t = r101;
        long r102 = this.f32122w.AddLayer(r101.f32097c, r101.f32098d, r101.f32096b);
        if (r102 == 0) goto L20;
        this.f32119t.f32095a = r102;
        List<com.baidu.mapsdkplatform.comapi.map.a> r103 = this.f32123x;
        monitor-enter(r103);
        this.f32123x.add(this.f32119t);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        r100.putLong("sdktileaddr", r102);
        if (h(r100) == false) goto L20;
        if (m(r100) == false) goto L20;
        return true;
    L17:
        th = move-exception;
        throw th;
    L20:
        return false;
    }

    public LatLngBounds f(Bundle r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = r110.getInt("type");
        String r101 = r110.getString("encodedPoints");
        LatLngBounds r102 = new LatLngBounds.Builder().build();
        int r111 = r110.getInt("encodePointType");
        if (r101 != null) goto L8;
        return r102;
    L8:
        if (r101.length() > 0) goto L10;
        return r102;
    L10:
        if (r100 != d.f32152l.ordinal()) goto L12;
    L13:
        ArrayList<LatLng> r112 = com.baidu.platform.comapi.util.g.a().a(r101, r111);
        if (r112 != null) goto L16;
    L25:
        return null;
    L16:
        if (r112.size() <= 0) goto L25;
        int r103 = r112.size();
        double[] r104 = new double[r103];
        double[] r105 = new double[r103];
        int r106 = 0;
    L19:
        if (r106 >= r103) goto L21;
        GeoPoint r107 = CoordUtil.ll2mcDirect((LatLng) ListProtector.get(r112, r106));
        r104[r106] = r107.getLongitudeE6();
        r105[r106] = r107.getLatitudeE6();
        r106 = r106 + 1;
        goto L19
    L21:
        Point r108 = new Point();
        GeoPoint r113 = CoordUtil.ll2mc((LatLng) ListProtector.get(r112, 0));
        Rect r109 = new Rect((int) r113.getLongitudeE6(), (int) r113.getLatitudeE6(), (int) r113.getLongitudeE6(), (int) r113.getLatitudeE6());
        int r114 = 1;
    L22:
        if (r114 >= r103) goto L24;
        int r115 = (int) r104[r114];
        r108.x = r115;
        r108.y = (int) r105[r114];
        r109.set(Math.min(r109.left, r115), Math.max(r109.top, r108.y), Math.max(r109.right, r108.x), Math.min(r109.bottom, r108.y));
        r114 = r114 + 1;
        goto L22
    L24:
        GeoPoint r116 = new GeoPoint(r109.bottom, r109.left);
        GeoPoint r117 = new GeoPoint(r109.top, r109.right);
        LatLng r118 = CoordUtil.mc2ll(r116);
        LatLng r119 = CoordUtil.mc2ll(r117);
        return new LatLngBounds.Builder().include(r118).include(r119).build();
    L12:
        if (r100 == d.f32150j.ordinal()) goto L13;
        return r102;
    }

    public void g(Bundle r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L9;
        g r102 = this.D;
        if (r102 == null) goto L10;
        r101.initHeatMapData(r102.f32095a, r100);
        return;
    L10:
        return;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface, com.baidu.platform.comjni.map.basemap.a
    public boolean hasLayer(long r100) {
        List<com.baidu.mapsdkplatform.comapi.map.a> r101 = this.f32123x;
        monitor-enter(r101);
        Iterator<com.baidu.mapsdkplatform.comapi.map.a> r102 = this.f32123x.iterator();     // Catch: Throwable -> L15
    L6:
        if (r102.hasNext() == false) goto L12;
        if (r102.next().f32095a != r100) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public void i(Bundle r100) {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        c(r100);
        this.f32122w.removeOneOverlayItem(r100);
    }

    public void j(Bundle r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMapBackgroundImage(r100);
    }

    public void k(Bundle r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L9;
        g r102 = this.D;
        if (r102 == null) goto L10;
        r101.updateHeatMapData(r102.f32095a, r100);
        return;
    L10:
        return;
    }

    public void l(Bundle r100) {
        if (this.f32122w == null) goto L8;
        if (r100 == null) goto L9;
        c(r100);
        a(r100);
        this.f32122w.updateOneOverlayItem(r100);
        return;
    L9:
        return;
    }

    public void n(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setFlingEnable(r100);
    }

    public void o(boolean r100) {
        if (this.f32122w != null) goto L6;
        return;
    L6:
        if (this.D != null) goto L8;
        g r101 = new g();
        this.D = r101;
        a(r101);
    L8:
        this.f32110k = r100;
        this.f32122w.ShowLayers(this.D.f32095a, r100);
    }

    public void p(boolean r100) {
        if (this.f32122w != null) goto L6;
        return;
    L6:
        if (this.E != null) goto L8;
        i r101 = new i();
        this.E = r101;
        a(r101);
    L8:
        this.f32111l = r100;
        this.f32122w.ShowLayers(this.E.f32095a, r100);
    }

    public void q(boolean r100) {
        this.S.setInertialAnimation(r100);
    }

    public void r(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f32109j = r100;
        LocationOverlay r102 = this.T;
        if (r102 != null) goto L10;
        MapViewInterface r103 = this.S.getMapView();
        if (r103 == null) goto L12;
        LocationOverlay r104 = new LocationOverlay(this.f32122w);
        this.T = r104;
        r103.addOverlay(r104);
        return;
    L12:
        return;
    L10:
        r101.ShowLayers(r102.mLayerID, r100);
    }

    public synchronized void s(boolean r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f32122w != null) goto L7;
    L16:
        monitor-exit(this);
        return;
    L7:
        if (x() == MapLanguage.ENGLISH.ordinal()) goto L16;
        if (this.Y == true) goto L16;
        this.V = r100;     // Catch: Throwable -> L18
        this.f32122w.setCustomStyleEnable(r100);     // Catch: Throwable -> L18
        if (OpenLogUtil.isMapLogEnable() == false) goto L14;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap setMapCustomEnable enable = " + r100);     // Catch: Throwable -> L18
    L14:
        monitor-exit(this);
    }

    public void t(boolean r100) {
        this.f32118s = r100;
    }

    public void u(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L10;
        if (this.P == true) goto L13;
        r101.SwitchLayer(r101.getLayerIDByTag("traffic"), this.f32125z.f32095a);
        this.P = true;
        return;
    L13:
        return;
    L10:
        if (this.P == false) goto L15;
        r101.SwitchLayer(this.f32125z.f32095a, r101.getLayerIDByTag("indoorlayer"));
        this.P = false;
        return;
    }

    public void v(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setOverlookGestureEnable(r100);
        this.f32113n = r100;
    }

    public void w(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.set3DGestureEnable(r100);
        this.f32117r = r100;
    }

    public void x(boolean r100) {
        MapController r101 = this.S;
        if (r101 == null) goto L6;
        r101.setSDKLayerBelowBmLayer(r100);
        return;
    }

    public void y(boolean r100) {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        this.f32107h = r100;
        a();
        this.f32122w.ShowSatelliteMap(this.f32107h);
        MapController r101 = this.S;
        if (r101 == null) goto L11;
        if (r100 == false) goto L9;
        r101.setMapTheme(2, new Bundle());
        return;
    L9:
        r101.setMapTheme(1, new Bundle());
        return;
    }

    public void z(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setCanTouchMove(r100);
        this.f32114o = r100;
    }

    private void a(MapController r100) {
        if (JNIInitializer.isResourceInited() == false) goto L5;
    L11:
        Bundle r101 = new Bundle();
        r101.putInt(GXTemplateKey.GAIAX_ANIMATION, 1);
        r101.putDouble("level", 12.0d);
        r101.putDouble("centerptx", 1.295815798E7d);
        r101.putDouble("centerpty", 4825999.74d);
        r101.putDouble("centerptz", AudioStats.AUDIO_AMPLITUDE_NONE);
        r101.putInt("left", 0);
        r101.putInt("top", 0);
        int r102 = SysOSUtil.getInstance().getScreenHeight();
        r101.putInt("right", SysOSUtil.getInstance().getScreenWidth());
        r101.putInt("bottom", r102);
        r101.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
        r101.putString("appSdcardPath", SysOSUtil.getInstance().getExternalFilesDir());
        r101.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
        r101.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
        r101.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
        r101.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
        r101.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
        r101.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
        r100.initMapResources(r101);
        return;
    L5:
        monitor-enter(JNIInitializer.class);
        monitor-exit(JNIInitializer.class);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public boolean b(ParticleEffectType r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.showParticleEffectByType(r100.getType());
    }

    public void c(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.U != null) goto L10;
        this.U = new com.baidu.platform.comapi.map.c(r101);
        MapViewInterface r102 = this.S.getMapView();
        if (r102 == null) goto L10;
        r102.addOverlay(this.U);
        I();
    L10:
        this.f32122w.ShowLayers(this.U.mLayerID, r100);
    }

    public void d(int r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L9;
        g r102 = this.D;
        if (r102 == null) goto L10;
        r101.setHeatMapFrameAnimationIndex(r102.f32095a, r100);
        return;
    L10:
        return;
    }

    public void e(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.ShowLayers(r101.getLayerIDByTag("basemap"), r100);
    }

    public void f(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f32108i = r100;
        if (this.U != null) goto L10;
        this.U = new com.baidu.platform.comapi.map.c(r101);
        MapViewInterface r102 = this.S.getMapView();
        if (r102 == null) goto L10;
        r102.addOverlay(this.U);
        I();
    L10:
        this.f32122w.ShowLayers(this.U.mLayerID, r100);
    }

    public void g(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.setCustomTrafficColorEnable(r100);
        return;
    }

    public void h(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.setDEMEnable(r100);
        return;
    }

    public void i(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDotPoiShowEnable(r100);
    }

    public void j(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDoubleClickGesturesCenter(r100);
    }

    public void k(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDoubleClickMoveZoomEnable(r100);
    }

    public void l(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDoubleClickZoom(r100);
    }

    public void m(boolean r100) {
        MapController r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setEnlargeCenterWithDoubleClickEnable(r100);
    }

    private void a(q r100) {
        if (r100 != null) goto L4;
        r100 = new q();
    L4:
        s r101 = r100.f32189a;
        boolean r102 = r100.f32194f;
        this.f32113n = r102;
        this.f32117r = r100.f32192d;
        this.f32114o = r100.f32193e;
        this.f32115p = r100.f32195g;
        v(r102);
        w(this.f32117r);
        z(this.f32114o);
        C(this.f32115p);
        this.f32122w.SetMapStatus(r101.a(this));
        AppBaseMap r103 = this.f32122w;
        if (r103 != null) goto L7;
        return;
    L7:
        r103.SetMapControlMode(p.f32184a.ordinal());
        boolean r104 = r100.f32190b;
        this.f32108i = r104;
        if (r104 == true) goto L10;
    L15:
        int r105 = r100.f32191c;
        if (r105 != 2) goto L19;
        y(true);
    L19:
        if (r105 == 3) goto L21;
        return;
    L21:
        if (V() == false) goto L24;
        I(false);
    L24:
        if (H() == false) goto L26;
        F(false);
    L26:
        e(false);
        E(false);
        return;
    L10:
        if (this.U != null) goto L14;
        this.U = new com.baidu.platform.comapi.map.c(this.f32122w);
        MapViewInterface r106 = this.S.getMapView();
        if (r106 == null) goto L14;
        r106.addOverlay(this.U);
        I();
    L14:
        this.f32122w.ShowLayers(this.U.mLayerID, true);
        this.f32122w.ResetImageRes();
        goto L15
    }

    public void b(Point r100) {
        MapController r101 = this.S;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setPointGesturesCenter(r100);
        return;
    L9:
        return;
    }

    public void c(int r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.setFontSizeLevel(r100);
        return;
    }

    public void d(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f32112m = r100;
        r101.ShowHotMap(r100, 0);
    }

    public boolean a(Point r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f32122w != null) goto L8;
        return false;
    L8:
        int r101 = r100.x;
        if (r101 < 0) goto L26;
        int r102 = r100.y;
        if (r102 < 0) goto L26;
        f32100b = r101;
        f32101c = r102;
        JSONObject r103 = new JSONObject();
        JSONArray r104 = new JSONArray();
        JSONObject r105 = new JSONObject();
        r105.put("x", f32100b);     // Catch: JSONException -> L17
        r105.put("y", f32101c);     // Catch: JSONException -> L17
        r105.put("hidetime", 1000);     // Catch: JSONException -> L17
        r104.put(r105);     // Catch: JSONException -> L17
        r103.put("dataset", r104);     // Catch: JSONException -> L17
    L20:
        if (this.U == null) goto L26;
        if (TextUtils.isEmpty(r103.toString()) == true) goto L24;
        this.U.setData(r103.toString());
    L24:
        this.U.UpdateOverlay();
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
    L26:
        return false;
    }

    public void b(int r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setBackgroundColor(r100);
    }

    private long a(MapLayer r100) {
        if (this.f32122w != null) goto L6;
        return -1;
    L6:
        switch(a.f32126a[r100.ordinal()]) {
            case 1: goto L23;
            case 2: goto L20;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L12;
            case 6: goto L8;
            default: goto L38;
        };
    L8:
        com.baidu.mapsdkplatform.comapi.map.z.a r101 = this.B;
        if (r101 != null) goto L28;
        return -1;
    L28:
        return r101.mLayerID;
    L17:
        BmLayer r102 = this.A;
        if (r102 != null) goto L34;
        return -1;
    L34:
        return r102.c();
    L20:
        v r103 = this.f32125z;
        if (r103 != null) goto L36;
        return -1;
    L36:
        return r103.f32095a;
    L23:
        LocationOverlay r104 = this.T;
        if (r104 != null) goto L26;
        return -1;
    L26:
        return r104.mLayerID;
    L38:
        return -1;
    L12:
        if (this.f32125z != null) goto L30;
        return -1;
    L30:
        return this.E.f32095a;
    L15:
        if (this.f32125z != null) goto L32;
        return -1;
    L32:
        return this.D.f32095a;
    }

    public void b(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDrawHouseHeightEnable(r100);
    }

    public void a(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.containsKey("encodedPoints") == true) goto L6;
        return;
    L6:
        if (r100.containsKey("encodePointType") == false) goto L19;
        int r101 = r100.getInt("encodePointType");
        if (r101 != EncodePointType.BUILDINGINFO.ordinal()) goto L11;
    L14:
        a(r100, r100.getString("encodedPoints"));
        return;
    L11:
        if (r101 == EncodePointType.AOI.ordinal()) goto L14;
        if (r101 == EncodePointType.RECOGNIZE_AOI.ordinal()) goto L14;
        return;
    }

    public void b(Bundle[] r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeOverlayItems(r100);
    }

    public void a(boolean r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L12;
        if (this.Q == true) goto L17;
        LocationOverlay r102 = this.T;
        if (r102 == null) goto L18;
        r101.SwitchLayer(this.f32125z.f32095a, r102.mLayerID);
        this.Q = true;
        return;
    L18:
        return;
    L17:
        return;
    L12:
        if (this.Q == false) goto L20;
        LocationOverlay r103 = this.T;
        if (r103 == null) goto L21;
        r101.SwitchLayer(r103.mLayerID, this.f32125z.f32095a);
        this.Q = false;
        return;
    L21:
        return;
    }

    public Point a(GeoPoint r100) {
        com.baidu.platform.comapi.basestruct.Point r101 = this.S.getMapView().getProjection().toPixels(r100, null);
        if (r101 == null) goto L7;
        return new Point(r101.getIntX(), r101.getIntY());
    L7:
        return new Point();
    }

    public void a(s r100) {
        if (this.f32122w == null) goto L8;
        if (r100 == null) goto L9;
        Bundle r101 = r100.a(this);
        r101.putInt(GXTemplateKey.GAIAX_ANIMATION, 0);
        r101.putInt("animatime", 0);
        U();
        this.f32122w.SetMapStatus(r101);
        return;
    L9:
        return;
    }

    private void a(com.baidu.mapsdkplatform.comapi.map.a r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r100.f32095a = r101.AddLayer(r100.f32097c, r100.f32098d, r100.f32096b);
        List<com.baidu.mapsdkplatform.comapi.map.a> r102 = this.f32123x;
        monitor-enter(r102);
        this.f32123x.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void a(com.baidu.platform.comapi.map.v r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f32121v == null) goto L9;
        this.S.registMapViewListener(r100);
        this.f32121v.add(r100);
        return;
    }

    public boolean a(PoiTagType r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.getPoiTagEnable(r100.ordinal());
    }

    public void a(List<OverlayLocationData> r100) {
        LocationOverlay r101 = this.T;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLocationLayerData(r100);
        this.T.UpdateOverlay();
    }

    public void a(ParticleEffectType r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L6;
        r101.closeParticleEffectByType(r100.getType());
        return;
    }

    public void a(Bundle[] r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.addOverlayItems(r100, r100.length);
        return;
    L9:
        return;
    }

    public void a(LatLng r100) {
        MapController r101 = this.S;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setLatLngGesturesCenter(r100);
        return;
    L9:
        return;
    }

    public void a(int r100) {
        AppBaseMap r101 = this.f32122w;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.cleanCache(r100, true);
    }

    public void a(com.baidu.platform.comapi.map.w r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.S.setOverlayListener(r100);
    }

    public boolean a(String r100) {
        return this.f32122w.downloadMapStyle(r100);
    }

    public void a(MapStatusUpdate r100) {
        this.O = r100;
    }

    public void a(h r100) {
        this.F = r100;
    }

    public void a(w r100) {
        this.f32120u = r100;
    }

    public void a(com.baidu.mapsdkplatform.comapi.map.z.a r100) {
        this.B = r100;
    }

    public void a(BmLayer r100) {
        this.A = r100;
    }

    public void a(Bundle r100, String r110) {
        if (r100 == null) goto L20;
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.length() <= 0) goto L24;
        int r101 = r100.getInt("encodePointType");
        ArrayList<LatLng> r111 = com.baidu.platform.comapi.util.g.a().a(r110, r101);
        if (r111 != null) goto L10;
        return;
    L10:
        if (r111.size() <= 0) goto L25;
        int r102 = r111.size();
        double[] r103 = new double[r102];
        double[] r104 = new double[r102];
        int r105 = 0;
    L13:
        if (r105 >= r102) goto L15;
        GeoPoint r106 = CoordUtil.ll2mcDirect((LatLng) ListProtector.get(r111, r105));
        r103[r105] = r106.getLongitudeE6();
        r104[r105] = r106.getLatitudeE6();
        r105 = r105 + 1;
        goto L13
    L15:
        r100.putDoubleArray("x_array", r103);
        r100.putDoubleArray("y_array", r104);
        GeoPoint r112 = CoordUtil.ll2mcDirect((LatLng) ListProtector.get(r111, 0));
        r100.putDouble("location_x", r112.getLongitudeE6());
        r100.putDouble("location_y", r112.getLatitudeE6());
        if (r100.getInt("has_dotted_stroke") != 1) goto L23;
        r100.putDouble("dotted_stroke_location_x", r112.getLongitudeE6());
        r100.putDouble("dotted_stroke_location_y", r112.getLatitudeE6());
        return;
    L23:
        return;
    L25:
        return;
    L24:
        return;
    }

    public boolean b(String r100, String r101) {
        AppBaseMap r102 = this.f32122w;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.SwitchBaseIndoorMapFloor(r100, r101);
    }

    public void a(LatLngBounds r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f32122w == null) goto L9;
        LatLng r102 = r100.northeast;
        LatLng r103 = r100.southwest;
        GeoPoint r104 = CoordUtil.ll2mc(r102);
        GeoPoint r105 = CoordUtil.ll2mc(r103);
        int r106 = (int) r104.getLongitudeE6();
        int r107 = (int) r105.getLatitudeE6();
        int r108 = (int) r105.getLongitudeE6();
        int r109 = (int) r104.getLatitudeE6();
        Bundle r110 = new Bundle();
        r110.putInt("maxCoorx", r106);
        r110.putInt("minCoory", r107);
        r110.putInt("minCoorx", r108);
        r110.putInt("maxCoory", r109);
        r110.putBoolean("isValid", r101);
        this.f32122w.setMapStatusLimits(r110);
        return;
    }

    public void b(int r100, int r101) {
        this.G = r100;
        this.H = r101;
    }

    public void a(s r100, int r101) {
        if (this.f32122w == null) goto L11;
        if (r100 == null) goto L13;
        Bundle r102 = r100.a(this);
        r102.putInt(GXTemplateKey.GAIAX_ANIMATION, 1);
        r102.putInt("animatime", r101);
        if (this.M == false) goto L9;
        C0645b r103 = new C0645b(r102);
        this.N.add(r103);
        return;
    L9:
        b();
        this.f32122w.SetMapStatus(r102);
        return;
    L13:
        return;
    }

    public void a(float r100, float r101) {
        this.f32103d = r100;
        this.f32105f = r100;
        this.f32104e = r101;
        MapController r102 = this.S;
        if (r102 == null) goto L6;
        r102.setMaxAndMinZoomLevel(r100, r101);
    L6:
        if (this.f32122w == null) goto L9;
        Bundle r103 = new Bundle();
        r103.putInt("maxLevel", (int) r100);
        r103.putInt("minLevel", (int) r101);
        this.f32122w.setMaxAndMinZoomLevel(r103);
        return;
    }

    public boolean a(MapLayer r100, MapLayer r101) {
        if (this.f32122w != null) goto L5;
        return false;
    L5:
        long r102 = a(r100);
        long r103 = a(r101);
        if (r102 != (-1)) goto L8;
    L12:
        return false;
    L8:
        if (r103 == (-1)) goto L12;
        boolean r104 = this.f32122w.SwitchLayer(r102, r103);
        this.f32122w.UpdateLayers(r103);
        return r104;
    }

    public Point a(GeoPoint r100, int r101) {
        com.baidu.platform.comapi.basestruct.Point r102 = this.S.getMapView().getProjection().toPixels(r100, r101, null);
        if (r102 == null) goto L7;
        return new Point(r102.getIntX(), r102.getIntY());
    L7:
        return new Point();
    }

    public void a(int r100, boolean r101) {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        if (this.V == true) goto L7;
    L9:
        this.f32122w.setMapLanguage(r100, r101);
        return;
    L7:
        if (r100 != MapLanguage.ENGLISH.ordinal()) goto L9;
    }

    public void a(MapLayer r100, boolean r101) {
        if (this.f32122w != null) goto L5;
        return;
    L5:
        long r102 = a(r100);
        if (r102 != (-1)) goto L8;
        return;
    L8:
        this.f32122w.SetLayersClickable(r102, r101);
    }

    public synchronized void a(String r100, String r101) {
        monitor-enter(this);
        AppBaseMap r102 = this.f32122w;     // Catch: Throwable -> L13
        if (r102 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.Y == true) goto L11;
        r102.initCustomStyle(r100, r101);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void a(String r100, Bundle r101) {
        LocationOverlay r102 = this.T;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setData(r100);
        this.T.setParam(r101);
        this.T.UpdateOverlay();
    }

    public GeoPoint a(int r100, int r101) {
        return this.S.getMapView().getProjection().fromPixels(r100, r101);
    }

    public boolean a(ParticleEffectType r100, Bundle r101) {
        AppBaseMap r102 = this.f32122w;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.customParticleEffectByType(r100.getType(), r101);
    }

    public void a(PoiTagType r100, boolean r101) {
        AppBaseMap r102 = this.f32122w;
        if (r102 == null) goto L6;
        r102.setPoiTagEnable(r100.ordinal(), r101);
        return;
    }

    private void a(String r100, String r101, long r102) {
        Class r103 = INVOKESTATIC_com_baidu_mapsdkplatform_comapi_map_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Exception -> L4
        Object r104 = r103.newInstance();     // Catch: Exception -> L4
        r103.getMethod(r101, new Class[]{Long.TYPE}).invoke(r104, new Object[]{Long.valueOf(r102)});     // Catch: Exception -> L4
        return;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface, com.baidu.platform.comjni.map.basemap.a
    public int mapLayerDataReq(Bundle r100, long r101, int r102) {
        g r103 = this.D;
        if (r103 != null) goto L5;
    L10:
        x r104 = this.f32119t;
        if (r104 != null) goto L13;
        return 0;
    L13:
        if (r101 != r104.f32095a) goto L18;
        int r105 = r100.getInt("x");
        int r106 = r100.getInt("y");
        int r107 = r100.getInt(GestureAction.zoom);
        r100.putBundle("param", this.f32120u.a(r105, r106, r107, null));
        return this.f32119t.f32228e;
    L18:
        return 0;
    L5:
        if (r101 != r103.f32095a) goto L10;
        if (this.F == null) goto L10;
        int r108 = r100.getInt(GestureAction.zoom);
        int r109 = r100.getInt("index");
        r100.putBundle("param", this.F.a(r109, r108));
        return this.D.f32228e;
    }

    public void a(int r100, int r101, int r102, int r103) {
        AppBaseMap r104 = this.f32122w;
        if (r104 == null) goto L6;
        r104.setCustomTrafficColor(r100, r101, r102, r103);
        return;
    }

    public b(Context r100, MapSurfaceView r101, q r102, String r103, int r104) {
        this.f32103d = 22.0f;
        this.f32104e = 4.0f;
        this.f32105f = 22.0f;
        this.f32108i = true;
        this.f32109j = false;
        this.f32110k = false;
        this.f32111l = false;
        this.f32112m = false;
        this.f32113n = true;
        this.f32114o = true;
        this.f32115p = true;
        this.f32116q = false;
        this.f32117r = true;
        this.f32118s = false;
        this.C = false;
        this.I = false;
        this.f32102J = false;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.N = new LinkedList();
        this.O = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.V = false;
        this.Y = false;
        this.f32121v = new CopyOnWriteArrayList();
        MapController r105 = new MapController();
        this.S = r105;
        r105.initAppBaseMap();
        a(this.S);
        r101.setMapController(this.S);
        this.f32122w = this.S.getBaseMap();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.S.getMapId());
        J();
        a(r102);
        AppBaseMap r106 = this.f32122w;
        if (r106 == null) goto L5;
        r106.SetSDKLayerCallback(this);
    L5:
        this.S.onResume();
    }

    public void a(int r100, int r101, int r102, int r110, boolean r111) {
        AppBaseMap r103 = this.f32122w;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setCustomTrafficColor(r100, r101, r102, r110, r111);
    }

    public b(Context r100, MapTextureView r101, q r102, String r103, int r104) {
        this.f32103d = 22.0f;
        this.f32104e = 4.0f;
        this.f32105f = 22.0f;
        this.f32108i = true;
        this.f32109j = false;
        this.f32110k = false;
        this.f32111l = false;
        this.f32112m = false;
        this.f32113n = true;
        this.f32114o = true;
        this.f32115p = true;
        this.f32116q = false;
        this.f32117r = true;
        this.f32118s = false;
        this.C = false;
        this.I = false;
        this.f32102J = false;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.N = new LinkedList();
        this.O = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.V = false;
        this.Y = false;
        this.f32121v = new CopyOnWriteArrayList();
        MapController r105 = new MapController();
        this.S = r105;
        r105.initAppBaseMap();
        a(this.S);
        r101.attachBaseMapController(this.S);
        this.f32122w = this.S.getBaseMap();
        J();
        a(r102);
        AppBaseMap r106 = this.f32122w;
        if (r106 == null) goto L5;
        r106.SetSDKLayerCallback(this);
    L5:
        this.S.onResume();
    }

    public float a(int r100, int r101, int r102, int r103, int r104, int r105) {
        if (this.S.mIsMapLoadFinish == true) goto L7;
        return 12.0f;
    L7:
        if (this.f32122w != null) goto L10;
        return 0.0f;
    L10:
        Bundle r106 = new Bundle();
        r106.putInt("left", r100);
        r106.putInt("right", r102);
        r106.putInt("bottom", r103);
        r106.putInt("top", r101);
        r106.putInt("hasHW", 1);
        r106.putInt("width", r104);
        r106.putInt("height", r105);
        Bundle r107 = new Bundle();
        r107.putInt("left", 0);
        r107.putInt("bottom", r105);
        r107.putInt("right", r104);
        r107.putInt("top", 0);
        return this.f32122w.GetFZoomToBoundF(r106, r107);
    }
}
