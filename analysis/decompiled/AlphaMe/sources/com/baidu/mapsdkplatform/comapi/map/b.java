package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class b implements MapSDKLayerDataInterface {

    /* renamed from: a, reason: collision with root package name */
    public static float f7975a = 1096.0f;

    /* renamed from: b, reason: collision with root package name */
    private static int f7976b;

    /* renamed from: c, reason: collision with root package name */
    private static int f7977c;

    /* renamed from: A, reason: collision with root package name */
    private BmLayer f7978A;

    /* renamed from: B, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.z.a f7979B;

    /* renamed from: D, reason: collision with root package name */
    private g f7981D;

    /* renamed from: E, reason: collision with root package name */
    private i f7982E;

    /* renamed from: F, reason: collision with root package name */
    private h f7983F;

    /* renamed from: G, reason: collision with root package name */
    private int f7984G;

    /* renamed from: H, reason: collision with root package name */
    private int f7985H;

    /* renamed from: S, reason: collision with root package name */
    private MapController f7996S;
    private LocationOverlay T;

    /* renamed from: U, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c f7997U;

    /* renamed from: W, reason: collision with root package name */
    public Point f7999W;

    /* renamed from: X, reason: collision with root package name */
    public Point f8000X;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8005g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8006h;

    /* renamed from: t, reason: collision with root package name */
    private x f8018t;

    /* renamed from: u, reason: collision with root package name */
    private w f8019u;

    /* renamed from: w, reason: collision with root package name */
    AppBaseMap f8021w;

    /* renamed from: x, reason: collision with root package name */
    private List<com.baidu.mapsdkplatform.comapi.map.a> f8022x;

    /* renamed from: y, reason: collision with root package name */
    private HashMap<MapLayer, com.baidu.mapsdkplatform.comapi.map.a> f8023y;

    /* renamed from: z, reason: collision with root package name */
    private v f8024z;

    /* renamed from: d, reason: collision with root package name */
    public float f8002d = 22.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f8003e = 4.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f8004f = 22.0f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8007i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8008j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8009k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8010l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8011m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8012n = true;

    /* renamed from: o, reason: collision with root package name */
    boolean f8013o = true;

    /* renamed from: p, reason: collision with root package name */
    boolean f8014p = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f8015q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8016r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8017s = false;

    /* renamed from: C, reason: collision with root package name */
    private boolean f7980C = false;

    /* renamed from: I, reason: collision with root package name */
    private boolean f7986I = false;

    /* renamed from: J, reason: collision with root package name */
    private boolean f7987J = false;

    /* renamed from: K, reason: collision with root package name */
    private long f7988K = 0;

    /* renamed from: L, reason: collision with root package name */
    private long f7989L = 0;

    /* renamed from: M, reason: collision with root package name */
    private boolean f7990M = false;

    /* renamed from: N, reason: collision with root package name */
    private Queue<C0028b> f7991N = new LinkedList();

    /* renamed from: O, reason: collision with root package name */
    public MapStatusUpdate f7992O = null;

    /* renamed from: P, reason: collision with root package name */
    private boolean f7993P = false;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f7994Q = false;

    /* renamed from: R, reason: collision with root package name */
    private boolean f7995R = false;

    /* renamed from: V, reason: collision with root package name */
    private boolean f7998V = false;

    /* renamed from: Y, reason: collision with root package name */
    private boolean f8001Y = false;

    /* renamed from: v, reason: collision with root package name */
    public List<com.baidu.platform.comapi.map.v> f8020v = new CopyOnWriteArrayList();

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8025a;

        static {
            int[] iArr = new int[MapLayer.values().length];
            f8025a = iArr;
            try {
                iArr[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8025a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8025a[MapLayer.BM_LAYER_OVERLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8025a[MapLayer.MAP_LAYER_HEATMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8025a[MapLayer.MAP_LAYER_HEXAGONMAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8025a[MapLayer.MAP_LAYER_TRACE_OVERLAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.b$b, reason: collision with other inner class name */
    public static class C0028b {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f8026a;

        public C0028b(Bundle bundle) {
            this.f8026a = bundle;
        }
    }

    public b(Context context, MapTextureView mapTextureView, q qVar, String str, int i4) throws JSONException {
        MapController mapController = new MapController();
        this.f7996S = mapController;
        mapController.initAppBaseMap();
        a(this.f7996S);
        mapTextureView.attachBaseMapController(this.f7996S);
        this.f8021w = this.f7996S.getBaseMap();
        I();
        a(qVar);
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.SetSDKLayerCallback(this);
        }
        this.f7996S.onResume();
    }

    private void H() throws JSONException {
        try {
            f7976b = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            f7977c = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", f7976b);
            jSONObject2.put("y", f7976b);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
            com.baidu.platform.comapi.map.c cVar = this.f7997U;
            if (cVar != null) {
                cVar.setData(jSONObject.toString());
                this.f7997U.UpdateOverlay();
            }
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    private void I() {
        this.f8022x = new CopyOnWriteArrayList();
        this.f8023y = new HashMap<>();
        v vVar = new v();
        this.f8024z = vVar;
        a(vVar);
        this.f8023y.put(MapLayer.MAP_LAYER_OVERLAY, this.f8024z);
        D(false);
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.setDEMEnable(false);
        }
    }

    private void T() {
        MapController mapController = this.f7996S;
        if (mapController == null || mapController.mIsMoving) {
            return;
        }
        mapController.mIsMoving = true;
        mapController.mIsAnimating = false;
        if (this.f8020v != null) {
            s sVarY = y();
            for (int i4 = 0; i4 < this.f8020v.size(); i4++) {
                com.baidu.platform.comapi.map.v vVar = this.f8020v.get(i4);
                if (vVar != null) {
                    vVar.c(sVarY);
                }
            }
        }
    }

    public float A() {
        MapController mapController = this.f7996S;
        return mapController != null ? mapController.mMaxZoomLevel : this.f8002d;
    }

    public void B(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setEnableZoom(z4);
        this.f8014p = z4;
    }

    public void C(boolean z4) {
        x xVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (xVar = this.f8018t) == null) {
            return;
        }
        appBaseMap.ShowLayers(xVar.f7971a, z4);
    }

    public void D(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        if (z4) {
            this.f8002d = 22.0f;
            this.f8004f = 22.0f;
            MapController mapController = this.f7996S;
            if (mapController != null) {
                mapController.mMaxZoomLevel = 22.0f;
            }
        } else {
            this.f8002d = 22.0f;
            this.f8004f = 22.0f;
            MapController mapController2 = this.f7996S;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 22.0f;
            }
        }
        appBaseMap.ShowBaseIndoorMap(z4);
    }

    public void E(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("poiindoormarklayer"), z4);
        }
    }

    public void F() {
        if (this.f8021w == null) {
            return;
        }
        synchronized (this.f8022x) {
            try {
                Iterator<com.baidu.mapsdkplatform.comapi.map.a> it = this.f8022x.iterator();
                while (it.hasNext()) {
                    this.f8021w.ShowLayers(it.next().f7971a, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void G(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(6L, z4);
    }

    public boolean J(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return false;
        }
        long layerIDByTag = appBaseMap.getLayerIDByTag("carnavinode");
        long layerIDByTag2 = this.f8021w.getLayerIDByTag(MapController.ANDROID_SDK_LAYER_TAG);
        if (layerIDByTag == 0 || layerIDByTag2 == 0) {
            return false;
        }
        if (z4) {
            if (this.f7995R) {
                return false;
            }
            boolean zSwitchLayer = this.f8021w.SwitchLayer(layerIDByTag, layerIDByTag2);
            this.f7995R = true;
            return zSwitchLayer;
        }
        if (!this.f7995R) {
            return false;
        }
        boolean zSwitchLayer2 = this.f8021w.SwitchLayer(layerIDByTag2, layerIDByTag);
        this.f7995R = false;
        return zSwitchLayer2;
    }

    public boolean K() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.IsBaseIndoorMapMode();
    }

    public boolean L() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basemap"));
    }

    public boolean M() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.getDrawHouseHeightEnable();
    }

    public boolean N() {
        return this.f8012n;
    }

    public boolean O() {
        return this.f8016r;
    }

    public boolean P() {
        return this.f8006h;
    }

    public boolean Q() {
        return this.f8013o;
    }

    public boolean R() {
        return this.f8005g;
    }

    public boolean S() {
        return this.f8014p;
    }

    public boolean U() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basepoi"));
        }
        return false;
    }

    public void V() {
        x xVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (xVar = this.f8018t) == null) {
            return;
        }
        appBaseMap.RemoveLayer(xVar.f7971a);
        this.f8022x.remove(this.f8018t);
    }

    public void W() {
        if (this.f8021w == null) {
            return;
        }
        synchronized (this.f8022x) {
            try {
                for (com.baidu.mapsdkplatform.comapi.map.a aVar : this.f8022x) {
                    if (aVar instanceof g) {
                        this.f8021w.ShowLayers(aVar.f7971a, false);
                    } else {
                        this.f8021w.ShowLayers(aVar.f7971a, true);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f8021w.ShowTrafficMap(false);
    }

    public void X() {
        g gVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (gVar = this.f7981D) == null) {
            return;
        }
        appBaseMap.startHeatMapFrameAnimation(gVar.f7971a);
    }

    public void Y() {
        g gVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (gVar = this.f7981D) == null) {
            return;
        }
        appBaseMap.stopHeatMapFrameAnimation(gVar.f7971a);
    }

    public void Z() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.updateBaseLayers();
        }
    }

    public void a(BmLayer bmLayer) {
        this.f7978A = bmLayer;
    }

    public void b(int i4, int i5) {
        this.f7984G = i4;
        this.f7985H = i5;
    }

    public void c(boolean z4) throws JSONException {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        if (this.f7997U == null) {
            this.f7997U = new com.baidu.platform.comapi.map.c(appBaseMap);
            MapViewInterface mapView = this.f7996S.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.f7997U);
                H();
            }
        }
        this.f8021w.ShowLayers(this.f7997U.mLayerID, z4);
    }

    public void d(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        this.f8011m = z4;
        appBaseMap.ShowHotMap(z4, 0);
    }

    public boolean e(Bundle bundle) {
        if (this.f8021w == null) {
            return false;
        }
        x xVar = new x();
        this.f8018t = xVar;
        long jAddLayer = this.f8021w.AddLayer(xVar.f7973c, xVar.f7974d, xVar.f7972b);
        if (jAddLayer != 0) {
            this.f8018t.f7971a = jAddLayer;
            synchronized (this.f8022x) {
                this.f8022x.add(this.f8018t);
            }
            bundle.putLong("sdktileaddr", jAddLayer);
            if (h(bundle) && m(bundle)) {
                return true;
            }
        }
        return false;
    }

    public void f(boolean z4) throws JSONException {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        this.f8007i = z4;
        if (this.f7997U == null) {
            this.f7997U = new com.baidu.platform.comapi.map.c(appBaseMap);
            MapViewInterface mapView = this.f7996S.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.f7997U);
                H();
            }
        }
        this.f8021w.ShowLayers(this.f7997U.mLayerID, z4);
    }

    public void g(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.setCustomTrafficColorEnable(z4);
        }
    }

    public void h(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.setDEMEnable(z4);
        }
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface, com.baidu.platform.comjni.map.basemap.a
    public boolean hasLayer(long j4) {
        synchronized (this.f8022x) {
            try {
                Iterator<com.baidu.mapsdkplatform.comapi.map.a> it = this.f8022x.iterator();
                while (it.hasNext()) {
                    if (it.next().f7971a == j4) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AppBaseMap i() {
        return this.f8021w;
    }

    public boolean j() {
        return false;
    }

    public void k(Bundle bundle) {
        g gVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (gVar = this.f7981D) == null) {
            return;
        }
        appBaseMap.updateHeatMapData(gVar.f7971a, bundle);
    }

    public String l() {
        return null;
    }

    public boolean m() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            return appBaseMap.getCustomTrafficColorEnable();
        }
        return false;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface, com.baidu.platform.comjni.map.basemap.a
    public int mapLayerDataReq(Bundle bundle, long j4, int i4) {
        g gVar = this.f7981D;
        if (gVar != null && j4 == gVar.f7971a && this.f7983F != null) {
            int i5 = bundle.getInt("zoom");
            bundle.putBundle("param", this.f7983F.a(bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX), i5));
            return this.f7981D.f8127e;
        }
        x xVar = this.f8018t;
        if (xVar == null || j4 != xVar.f7971a) {
            return 0;
        }
        bundle.putBundle("param", this.f8019u.a(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("zoom"), null));
        return this.f8018t.f8127e;
    }

    public void n(boolean z4) {
        if (this.f8021w == null) {
            return;
        }
        if (this.f7981D == null) {
            g gVar = new g();
            this.f7981D = gVar;
            a(gVar);
        }
        this.f8009k = z4;
        this.f8021w.ShowLayers(this.f7981D.f7971a, z4);
    }

    public MapBaseIndoorMapInfo o() {
        String strGetFocusedBaseIndoorMapInfo;
        String str;
        String strOptString;
        String strOptString2 = "";
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (strGetFocusedBaseIndoorMapInfo = appBaseMap.GetFocusedBaseIndoorMapInfo()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(strGetFocusedBaseIndoorMapInfo);
            strOptString = jSONObject.optString("focusindoorid");
            try {
                strOptString2 = jSONObject.optString("curfloor");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("floorlist");
                if (jSONArrayOptJSONArray != null) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        arrayList.add(jSONArrayOptJSONArray.get(i4).toString());
                    }
                }
            } catch (JSONException e4) {
                e = e4;
                String str2 = strOptString2;
                strOptString2 = strOptString;
                str = str2;
                e.printStackTrace();
                String str3 = strOptString2;
                strOptString2 = str;
                strOptString = str3;
                return new MapBaseIndoorMapInfo(strOptString, strOptString2, arrayList);
            }
        } catch (JSONException e5) {
            e = e5;
            str = "";
        }
        return new MapBaseIndoorMapInfo(strOptString, strOptString2, arrayList);
    }

    public void p(boolean z4) {
        this.f7996S.setInertialAnimation(z4);
    }

    public void q(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        this.f8008j = z4;
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay != null) {
            appBaseMap.ShowLayers(locationOverlay.mLayerID, z4);
            return;
        }
        MapViewInterface mapView = this.f7996S.getMapView();
        if (mapView != null) {
            LocationOverlay locationOverlay2 = new LocationOverlay(this.f8021w);
            this.T = locationOverlay2;
            mapView.addOverlay(locationOverlay2);
        }
    }

    public synchronized void r(boolean z4) {
        if (this.f8021w != null && w() != MapLanguage.ENGLISH.ordinal() && !this.f8001Y) {
            this.f7998V = z4;
            this.f8021w.setCustomStyleEnable(z4);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap setMapCustomEnable enable = " + z4);
            }
            return;
        }
        Log.e("baidumapsdk", "Opening custom map is not support after setting English map , or map has been destroyed");
    }

    public void s(boolean z4) {
        this.f8017s = z4;
    }

    public void t(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        if (z4) {
            if (this.f7993P) {
                return;
            }
            appBaseMap.SwitchLayer(appBaseMap.getLayerIDByTag("traffic"), this.f8024z.f7971a);
            this.f7993P = true;
            return;
        }
        if (this.f7993P) {
            appBaseMap.SwitchLayer(this.f8024z.f7971a, appBaseMap.getLayerIDByTag("indoorlayer"));
            this.f7993P = false;
        }
    }

    public void u(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setOverlookGestureEnable(z4);
        this.f8012n = z4;
    }

    public boolean v() {
        return this.f7998V;
    }

    public void w(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController != null) {
            mapController.setSDKLayerBelowBmLayer(z4);
        }
    }

    public void x(boolean z4) {
        if (this.f8021w == null) {
            return;
        }
        this.f8006h = z4;
        a();
        this.f8021w.ShowSatelliteMap(this.f8006h);
        MapController mapController = this.f7996S;
        if (mapController != null) {
            if (z4) {
                mapController.setMapTheme(2, new Bundle());
            } else {
                mapController.setMapTheme(1, new Bundle());
            }
        }
    }

    public void y(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setCanTouchMove(z4);
        this.f8013o = z4;
    }

    public void z(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        this.f8005g = z4;
        appBaseMap.ShowTrafficMap(z4);
    }

    public void a(com.baidu.mapsdkplatform.comapi.map.z.a aVar) {
        this.f7979B = aVar;
    }

    public void i(Bundle bundle) {
        if (this.f8021w == null) {
            return;
        }
        c(bundle);
        this.f8021w.removeOneOverlayItem(bundle);
    }

    public void j(Bundle bundle) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setMapBackgroundImage(bundle);
    }

    public void l(Bundle bundle) {
        if (this.f8021w == null || bundle == null) {
            return;
        }
        c(bundle);
        a(bundle);
        this.f8021w.updateOneOverlayItem(bundle);
    }

    public int p() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return 1;
        }
        appBaseMap.getFontSizeLevel();
        return 1;
    }

    public boolean s() {
        return this.f8008j;
    }

    public void v(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.set3DGestureEnable(z4);
        this.f8016r = z4;
    }

    private void a(MapController mapController) {
        if (!JNIInitializer.isResourceInited()) {
            synchronized (JNIInitializer.class) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("animation", 1);
        bundle.putDouble("level", 12.0d);
        bundle.putDouble("centerptx", 1.295815798E7d);
        bundle.putDouble("centerpty", 4825999.74d);
        bundle.putDouble("centerptz", 0.0d);
        bundle.putInt(ViewTweenItem.LEFT, 0);
        bundle.putInt(ViewTweenItem.TOP, 0);
        int screenHeight = SysOSUtil.getInstance().getScreenHeight();
        bundle.putInt("right", SysOSUtil.getInstance().getScreenWidth());
        bundle.putInt("bottom", screenHeight);
        bundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
        bundle.putString("appSdcardPath", SysOSUtil.getInstance().getExternalFilesDir());
        bundle.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
        bundle.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
        bundle.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
        bundle.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
        mapController.initMapResources(bundle);
    }

    private boolean h(Bundle bundle) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.addSDKTileData(bundle);
    }

    private boolean m(Bundle bundle) {
        AppBaseMap appBaseMap;
        if (bundle == null || (appBaseMap = this.f8021w) == null) {
            return false;
        }
        boolean zUpdateSDKTile = appBaseMap.updateSDKTile(bundle);
        if (zUpdateSDKTile) {
            C(zUpdateSDKTile);
            this.f8021w.UpdateLayers(this.f8018t.f7971a);
        }
        return zUpdateSDKTile;
    }

    public float[] C() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return null;
        }
        return appBaseMap.getViewMatrix();
    }

    public double E() {
        return y().f8111m;
    }

    public boolean G() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("poiindoormarklayer"));
        }
        return false;
    }

    public boolean b(ParticleEffectType particleEffectType) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            return appBaseMap.showParticleEffectByType(particleEffectType.getType());
        }
        return false;
    }

    public void g(Bundle bundle) {
        g gVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (gVar = this.f7981D) == null) {
            return;
        }
        appBaseMap.initHeatMapData(gVar.f7971a, bundle);
    }

    public boolean k() {
        return this.f8007i;
    }

    public int w() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.getMapLanguage();
    }

    public void A(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setTwoTouchClickZoomEnabled(z4);
    }

    public float[] B() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return null;
        }
        return appBaseMap.getProjectionMatrix();
    }

    public void d() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ClearSDKLayer(this.f8024z.f7971a);
    }

    public void j(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickMoveZoomEnable(z4);
    }

    public void k(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickZoom(z4);
    }

    public String u() {
        return this.f7998V ? "" : "长地万方\nMapbox\nMapKin\n樂客LocalKing PalmCit\nESO DigitalGlobal spaceview\nOSRM Copyright ©2017, Project OSRMcontributors, all rights reserved\nHERE© 2019 HERE, all rights reserved\nOpenStreetMap© OpenStreetMapContributor;(OSMF)";
    }

    public s y() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return null;
        }
        Bundle bundleGetMapStatus = appBaseMap.GetMapStatus();
        s sVar = new s();
        sVar.a(bundleGetMapStatus);
        return sVar;
    }

    public LatLngBounds z() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return null;
        }
        Bundle mapStatusLimits = appBaseMap.getMapStatusLimits();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i4 = mapStatusLimits.getInt("maxCoorx");
        int i5 = mapStatusLimits.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("minCoory"), i4))).include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("maxCoory"), i5)));
        return builder.build();
    }

    public void b(int i4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setBackgroundColor(i4);
    }

    public void g() {
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay != null) {
            locationOverlay.clearLocationLayerData(null);
        }
    }

    public synchronized void h() {
        this.f8001Y = true;
    }

    public void i(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickGesturesCenter(z4);
    }

    public void F(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(10L, z4);
    }

    public void d(Bundle bundle) {
        if (this.f8021w == null) {
            return;
        }
        c(bundle);
        a(bundle);
        this.f8021w.addOneOverlayItem(bundle);
    }

    public void l(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setEnlargeCenterWithDoubleClickEnable(z4);
    }

    public void b(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setDrawHouseHeightEnable(z4);
    }

    public void m(boolean z4) {
        MapController mapController = this.f7996S;
        if (mapController == null) {
            return;
        }
        mapController.setFlingEnable(z4);
    }

    public s n() {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return null;
        }
        Bundle bundleGetMapStatus = appBaseMap.GetMapStatus(false);
        s sVar = new s();
        sVar.a(bundleGetMapStatus);
        return sVar;
    }

    public boolean c() {
        AppBaseMap appBaseMap;
        x xVar = this.f8018t;
        if (xVar == null || (appBaseMap = this.f8021w) == null) {
            return false;
        }
        return appBaseMap.cleanSDKTileDataCache(xVar.f7971a);
    }

    public int q() {
        return this.f7985H;
    }

    public MapStatusUpdate r() {
        return this.f7992O;
    }

    public String t() {
        return this.f7998V ? "" : "GS(2022)460号";
    }

    public String x() {
        return this.f7998V ? "" : "甲测资字11111342";
    }

    public void I(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.showTrafficUGCMap(z4);
        }
    }

    public void b(Bundle[] bundleArr) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.removeOverlayItems(bundleArr);
    }

    public LatLngBounds f(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i4 = bundle.getInt("type");
        String string = bundle.getString("encodedPoints");
        LatLngBounds latLngBoundsBuild = new LatLngBounds.Builder().build();
        int i5 = bundle.getInt("encodePointType");
        if (string == null || string.length() <= 0) {
            return latLngBoundsBuild;
        }
        if (i4 != d.prism.ordinal() && i4 != d.polygon.ordinal()) {
            return latLngBoundsBuild;
        }
        ArrayList<LatLng> arrayListA = com.baidu.platform.comapi.util.g.a().a(string, i5);
        if (arrayListA == null || arrayListA.size() <= 0) {
            return null;
        }
        int size = arrayListA.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i6 = 0; i6 < size; i6++) {
            GeoPoint geoPointLl2mcDirect = CoordUtil.ll2mcDirect(arrayListA.get(i6));
            dArr[i6] = geoPointLl2mcDirect.getLongitudeE6();
            dArr2[i6] = geoPointLl2mcDirect.getLatitudeE6();
        }
        Point point = new Point();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(arrayListA.get(0));
        Rect rect = new Rect((int) geoPointLl2mc.getLongitudeE6(), (int) geoPointLl2mc.getLatitudeE6(), (int) geoPointLl2mc.getLongitudeE6(), (int) geoPointLl2mc.getLatitudeE6());
        for (int i7 = 1; i7 < size; i7++) {
            int i8 = (int) dArr[i7];
            point.x = i8;
            point.y = (int) dArr2[i7];
            rect.set(Math.min(rect.left, i8), Math.max(rect.top, point.y), Math.max(rect.right, point.x), Math.min(rect.bottom, point.y));
        }
        GeoPoint geoPoint = new GeoPoint(rect.bottom, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.top, rect.right);
        return new LatLngBounds.Builder().include(CoordUtil.mc2ll(geoPoint)).include(CoordUtil.mc2ll(geoPoint2)).build();
    }

    public boolean J() {
        return this.f8011m;
    }

    public void c(Bundle bundle) {
        if (bundle.get("param") != null) {
            Bundle bundle2 = (Bundle) bundle.get("param");
            int i4 = bundle2.getInt("type");
            if (i4 == d.ground.ordinal()) {
                bundle2.putLong("layer_addr", this.f8024z.f7971a);
                return;
            }
            if (i4 >= d.arc.ordinal()) {
                bundle2.putLong("layer_addr", this.f8024z.f7971a);
                return;
            } else if (i4 == d.popup.ordinal()) {
                bundle2.putLong("layer_addr", this.f8024z.f7971a);
                return;
            } else {
                bundle2.putLong("layer_addr", this.f8024z.f7971a);
                return;
            }
        }
        int i5 = bundle.getInt("type");
        if (i5 == d.ground.ordinal()) {
            bundle.putLong("layer_addr", this.f8024z.f7971a);
            return;
        }
        if (i5 >= d.arc.ordinal()) {
            bundle.putLong("layer_addr", this.f8024z.f7971a);
        } else if (i5 == d.popup.ordinal()) {
            bundle.putLong("layer_addr", this.f8024z.f7971a);
        } else {
            bundle.putLong("layer_addr", this.f8024z.f7971a);
        }
    }

    public void d(int i4) {
        g gVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (gVar = this.f7981D) == null) {
            return;
        }
        appBaseMap.setHeatMapFrameAnimationIndex(gVar.f7971a, i4);
    }

    public int D() {
        return this.f7984G;
    }

    public boolean b(String str, String str2) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.SwitchBaseIndoorMapFloor(str, str2);
    }

    public void e(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basemap"), z4);
    }

    public void b(Bundle bundle) {
        i iVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (iVar = this.f7982E) == null) {
            return;
        }
        appBaseMap.addHexagonMapData(iVar.f7971a, bundle);
    }

    public void o(boolean z4) {
        if (this.f8021w == null) {
            return;
        }
        if (this.f7982E == null) {
            i iVar = new i();
            this.f7982E = iVar;
            a(iVar);
        }
        this.f8010l = z4;
        this.f8021w.ShowLayers(this.f7982E.f7971a, z4);
    }

    public void e() {
        g gVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (gVar = this.f7981D) == null) {
            return;
        }
        appBaseMap.clearHeatMapLayerCache(gVar.f7971a);
        this.f8021w.UpdateLayers(this.f7981D.f7971a);
    }

    public void H(boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basepoi"), z4);
        }
    }

    public void b(Point point) {
        MapController mapController = this.f7996S;
        if (mapController == null || point == null) {
            return;
        }
        mapController.setPointGesturesCenter(point);
    }

    public void b() {
        MapController mapController = this.f7996S;
        if (mapController == null || mapController.mIsMoving || mapController.mIsAnimating) {
            return;
        }
        mapController.mIsAnimating = true;
        if (this.f8020v == null) {
            return;
        }
        s sVarY = y();
        for (int i4 = 0; i4 < this.f8020v.size(); i4++) {
            com.baidu.platform.comapi.map.v vVar = this.f8020v.get(i4);
            if (vVar != null) {
                vVar.c(sVarY);
            }
        }
    }

    private void a(String str, String str2, long j4) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j4));
        } catch (Exception unused) {
        }
    }

    public void c(int i4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.setFontSizeLevel(i4);
        }
    }

    private void a(q qVar) throws JSONException {
        if (qVar == null) {
            qVar = new q();
        }
        boolean z4 = qVar.f8093f;
        this.f8012n = z4;
        this.f8016r = qVar.f8091d;
        this.f8013o = qVar.f8092e;
        this.f8014p = qVar.f8094g;
        u(z4);
        v(this.f8016r);
        y(this.f8013o);
        B(this.f8014p);
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.SetMapControlMode(p.DEFAULT.ordinal());
        boolean z5 = qVar.f8089b;
        this.f8007i = z5;
        if (z5) {
            if (this.f7997U == null) {
                this.f7997U = new com.baidu.platform.comapi.map.c(this.f8021w);
                MapViewInterface mapView = this.f7996S.getMapView();
                if (mapView != null) {
                    mapView.addOverlay(this.f7997U);
                    H();
                }
            }
            this.f8021w.ShowLayers(this.f7997U.mLayerID, true);
            this.f8021w.ResetImageRes();
        }
        int i4 = qVar.f8090c;
        if (i4 == 2) {
            x(true);
        }
        if (i4 == 3) {
            if (U()) {
                H(false);
            }
            if (G()) {
                E(false);
            }
            e(false);
            D(false);
        }
    }

    public b(Context context, MapSurfaceView mapSurfaceView, q qVar, String str, int i4) throws IllegalAccessException, JSONException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        MapController mapController = new MapController();
        this.f7996S = mapController;
        mapController.initAppBaseMap();
        a(this.f7996S);
        mapSurfaceView.setMapController(this.f7996S);
        this.f8021w = this.f7996S.getBaseMap();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.f7996S.getMapId());
        I();
        a(qVar);
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.SetSDKLayerCallback(this);
        }
        this.f7996S.onResume();
    }

    public void f() {
        i iVar;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || (iVar = this.f7982E) == null) {
            return;
        }
        appBaseMap.clearHexagonLayerCache(iVar.f7971a);
        this.f8021w.UpdateLayers(this.f7982E.f7971a);
    }

    public boolean a(Point point) throws JSONException {
        int i4;
        int i5;
        if (point != null && this.f8021w != null && (i4 = point.x) >= 0 && (i5 = point.y) >= 0) {
            f7976b = i4;
            f7977c = i5;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", f7976b);
                jSONObject2.put("y", f7977c);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("dataset", jSONArray);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (this.f7997U != null) {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    this.f7997U.setData(jSONObject.toString());
                }
                this.f7997U.UpdateOverlay();
                return true;
            }
        }
        return false;
    }

    public void a(Bitmap bitmap) throws JSONException {
        Bundle bundle;
        if (this.f8021w == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", f7976b);
            jSONObject2.put("y", f7977c);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getWidth() * 4);
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            bundle3.putByteArray("imgData", byteBufferAllocate.array());
            bundle3.putString("imgKey", bitmap.hashCode() + "_" + System.currentTimeMillis());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            bundle2.putBundle("iconData", bundle3);
            bundle = bundle2;
        }
        if (this.f7997U != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                this.f7997U.setData(jSONObject.toString());
            }
            if (bundle != null) {
                this.f7997U.setParam(bundle);
            }
            this.f7997U.UpdateOverlay();
        }
    }

    public void a(float f4, float f5) {
        this.f8002d = f4;
        this.f8004f = f4;
        this.f8003e = f5;
        MapController mapController = this.f7996S;
        if (mapController != null) {
            mapController.setMaxAndMinZoomLevel(f4, f5);
        }
        if (this.f8021w != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("maxLevel", (int) f4);
            bundle.putInt("minLevel", (int) f5);
            this.f8021w.setMaxAndMinZoomLevel(bundle);
        }
    }

    private void a() {
        if (!this.f8009k && !this.f8006h && !this.f8005g && !this.f8011m) {
            float f4 = this.f8004f;
            this.f8002d = f4;
            MapController mapController = this.f7996S;
            if (mapController != null) {
                mapController.mMaxZoomLevel = f4;
                return;
            }
            return;
        }
        if (this.f8002d > 20.0f) {
            this.f8002d = 20.0f;
            MapController mapController2 = this.f7996S;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 20.0f;
            }
        }
        if (y().f8099a > 20.0f) {
            s sVarY = y();
            sVarY.f8099a = 20.0f;
            a(sVarY);
        }
    }

    public void a(int i4, int i5, int i6, int i7) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.setCustomTrafficColor(i4, i5, i6, i7);
        }
    }

    public void a(PoiTagType poiTagType, boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.setPoiTagEnable(poiTagType.ordinal(), z4);
        }
    }

    public boolean a(PoiTagType poiTagType) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            return appBaseMap.getPoiTagEnable(poiTagType.ordinal());
        }
        return false;
    }

    public void a(ParticleEffectType particleEffectType) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            appBaseMap.closeParticleEffectByType(particleEffectType.getType());
        }
    }

    public boolean a(ParticleEffectType particleEffectType, Bundle bundle) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null) {
            return appBaseMap.customParticleEffectByType(particleEffectType.getType(), bundle);
        }
        return false;
    }

    private void a(com.baidu.mapsdkplatform.comapi.map.a aVar) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        aVar.f7971a = appBaseMap.AddLayer(aVar.f7973c, aVar.f7974d, aVar.f7972b);
        synchronized (this.f8022x) {
            this.f8022x.add(aVar);
        }
    }

    public void a(boolean z4) {
        LocationOverlay locationOverlay;
        LocationOverlay locationOverlay2;
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        if (z4) {
            if (this.f7994Q || (locationOverlay2 = this.T) == null) {
                return;
            }
            appBaseMap.SwitchLayer(this.f8024z.f7971a, locationOverlay2.mLayerID);
            this.f7994Q = true;
            return;
        }
        if (!this.f7994Q || (locationOverlay = this.T) == null) {
            return;
        }
        appBaseMap.SwitchLayer(locationOverlay.mLayerID, this.f8024z.f7971a);
        this.f7994Q = false;
    }

    public boolean a(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.f8021w == null) {
            return false;
        }
        long jA = a(mapLayer);
        long jA2 = a(mapLayer2);
        if (jA == -1 || jA2 == -1) {
            return false;
        }
        boolean zSwitchLayer = this.f8021w.SwitchLayer(jA, jA2);
        this.f8021w.UpdateLayers(jA2);
        return zSwitchLayer;
    }

    public void a(MapLayer mapLayer, boolean z4) {
        if (this.f8021w == null) {
            return;
        }
        long jA = a(mapLayer);
        if (jA == -1) {
            return;
        }
        this.f8021w.SetLayersClickable(jA, z4);
    }

    private long a(MapLayer mapLayer) {
        if (this.f8021w == null) {
            return -1L;
        }
        switch (a.f8025a[mapLayer.ordinal()]) {
            case 1:
                LocationOverlay locationOverlay = this.T;
                if (locationOverlay != null) {
                    return locationOverlay.mLayerID;
                }
                return -1L;
            case 2:
                v vVar = this.f8024z;
                if (vVar != null) {
                    return vVar.f7971a;
                }
                return -1L;
            case 3:
                BmLayer bmLayer = this.f7978A;
                if (bmLayer != null) {
                    return bmLayer.c();
                }
                return -1L;
            case 4:
                if (this.f8024z != null) {
                    return this.f7981D.f7971a;
                }
                return -1L;
            case 5:
                if (this.f8024z != null) {
                    return this.f7982E.f7971a;
                }
                return -1L;
            case 6:
                com.baidu.mapsdkplatform.comapi.map.z.a aVar = this.f7979B;
                if (aVar != null) {
                    return aVar.mLayerID;
                }
                return -1L;
            default:
                return -1L;
        }
    }

    public void a(int i4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.cleanCache(i4, true);
    }

    public void a(w wVar) {
        this.f8019u = wVar;
    }

    public GeoPoint a(int i4, int i5) {
        return this.f7996S.getMapView().getProjection().fromPixels(i4, i5);
    }

    public Point a(GeoPoint geoPoint) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.f7996S.getMapView().getProjection().toPixels(geoPoint, null);
        if (pixels != null) {
            return new Point(pixels.getIntX(), pixels.getIntY());
        }
        return new Point();
    }

    public Point a(GeoPoint geoPoint, int i4) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.f7996S.getMapView().getProjection().toPixels(geoPoint, i4, null);
        if (pixels != null) {
            return new Point(pixels.getIntX(), pixels.getIntY());
        }
        return new Point();
    }

    public void a(Bundle bundle) {
        if (bundle != null && bundle.containsKey("encodedPoints") && bundle.containsKey("encodePointType")) {
            int i4 = bundle.getInt("encodePointType");
            if (i4 == EncodePointType.BUILDINGINFO.ordinal() || i4 == EncodePointType.AOI.ordinal() || i4 == EncodePointType.RECOGNIZE_AOI.ordinal()) {
                a(bundle, bundle.getString("encodedPoints"));
            }
        }
    }

    public void a(Bundle bundle, String str) {
        if (bundle == null || str == null || str.length() <= 0) {
            return;
        }
        ArrayList<LatLng> arrayListA = com.baidu.platform.comapi.util.g.a().a(str, bundle.getInt("encodePointType"));
        if (arrayListA == null || arrayListA.size() <= 0) {
            return;
        }
        int size = arrayListA.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i4 = 0; i4 < size; i4++) {
            GeoPoint geoPointLl2mcDirect = CoordUtil.ll2mcDirect(arrayListA.get(i4));
            dArr[i4] = geoPointLl2mcDirect.getLongitudeE6();
            dArr2[i4] = geoPointLl2mcDirect.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
        GeoPoint geoPointLl2mcDirect2 = CoordUtil.ll2mcDirect(arrayListA.get(0));
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mcDirect2.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mcDirect2.getLatitudeE6());
        if (bundle.getInt("has_dotted_stroke") == 1) {
            bundle.putDouble("dotted_stroke_location_x", geoPointLl2mcDirect2.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", geoPointLl2mcDirect2.getLatitudeE6());
        }
    }

    public void a(Bundle[] bundleArr) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null || bundleArr == null) {
            return;
        }
        appBaseMap.addOverlayItems(bundleArr, bundleArr.length);
    }

    public synchronized void a(String str, String str2) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap != null && !this.f8001Y) {
            appBaseMap.initCustomStyle(str, str2);
        }
    }

    public void a(int i4, int i5, int i6, int i7, boolean z4) {
        AppBaseMap appBaseMap = this.f8021w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setCustomTrafficColor(i4, i5, i6, i7, z4);
    }

    public float a(int i4, int i5, int i6, int i7, int i8, int i9) {
        if (!this.f7996S.mIsMapLoadFinish) {
            return 12.0f;
        }
        if (this.f8021w == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ViewTweenItem.LEFT, i4);
        bundle.putInt("right", i6);
        bundle.putInt("bottom", i7);
        bundle.putInt(ViewTweenItem.TOP, i5);
        bundle.putInt("hasHW", 1);
        bundle.putInt("width", i8);
        bundle.putInt("height", i9);
        Bundle bundle2 = new Bundle();
        bundle2.putInt(ViewTweenItem.LEFT, 0);
        bundle2.putInt("bottom", i9);
        bundle2.putInt("right", i8);
        bundle2.putInt(ViewTweenItem.TOP, 0);
        return this.f8021w.GetFZoomToBoundF(bundle, bundle2);
    }

    public void a(List<OverlayLocationData> list) {
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay == null) {
            return;
        }
        locationOverlay.setLocationLayerData(list);
        this.T.UpdateOverlay();
    }

    public void a(String str, Bundle bundle) {
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay == null) {
            return;
        }
        locationOverlay.setData(str);
        this.T.setParam(bundle);
        this.T.UpdateOverlay();
    }

    public void a(LatLng latLng) {
        MapController mapController = this.f7996S;
        if (mapController == null || latLng == null) {
            return;
        }
        mapController.setLatLngGesturesCenter(latLng);
    }

    public void a(com.baidu.platform.comapi.map.v vVar) {
        if (vVar == null || this.f8020v == null) {
            return;
        }
        this.f7996S.registMapViewListener(vVar);
        this.f8020v.add(vVar);
    }

    public void a(com.baidu.platform.comapi.map.w wVar) {
        if (wVar == null) {
            return;
        }
        this.f7996S.setOverlayListener(wVar);
    }

    public void a(h hVar) {
        this.f7983F = hVar;
    }

    public void a(s sVar) {
        if (this.f8021w == null || sVar == null) {
            return;
        }
        Bundle bundleA = sVar.a(this);
        bundleA.putInt("animation", 0);
        bundleA.putInt("animatime", 0);
        T();
        this.f8021w.SetMapStatus(bundleA);
    }

    public void a(s sVar, int i4) {
        if (this.f8021w == null || sVar == null) {
            return;
        }
        Bundle bundleA = sVar.a(this);
        bundleA.putInt("animation", 1);
        bundleA.putInt("animatime", i4);
        if (this.f7990M) {
            this.f7991N.add(new C0028b(bundleA));
        } else {
            b();
            this.f8021w.SetMapStatus(bundleA);
        }
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.f8021w == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLng2);
        int longitudeE6 = (int) geoPointLl2mc.getLongitudeE6();
        int latitudeE6 = (int) geoPointLl2mc2.getLatitudeE6();
        int longitudeE62 = (int) geoPointLl2mc2.getLongitudeE6();
        int latitudeE62 = (int) geoPointLl2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", longitudeE6);
        bundle.putInt("minCoory", latitudeE6);
        bundle.putInt("minCoorx", longitudeE62);
        bundle.putInt("maxCoory", latitudeE62);
        this.f8021w.setMapStatusLimits(bundle);
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.f7992O = mapStatusUpdate;
    }

    public void a(int i4, boolean z4) {
        if (this.f8021w != null && (!this.f7998V || i4 != MapLanguage.ENGLISH.ordinal())) {
            this.f8021w.setMapLanguage(i4, z4);
        } else {
            Log.e("baidumapsdk", "Opening English map is not supported after setting custom map");
        }
    }
}
