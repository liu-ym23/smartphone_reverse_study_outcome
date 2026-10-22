package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class MapSurfaceView extends t implements View.OnKeyListener, MapViewInterface, MapRenderModeChangeListener, u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f33071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ExecutorService f33072c = null;
    protected com.baidu.mapsdkplatform.comapi.map.b A;
    private float B;
    private float C;
    private boolean D;
    private int E;
    private int F;
    private int G;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f33073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f33074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f33075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f33076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f33077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f33078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected MapController f33079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected p f33080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected h f33081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected j f33082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LocationOverlay f33083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected volatile boolean f33084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f33085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<BmLayer> f33086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<Overlay> f33087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f33088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f33089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private HashSet<m> f33090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f33091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected x f33092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected GestureDetector f33093x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected n f33094y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f33095z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33096a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_MapSurfaceView$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_map_MapSurfaceView$a__run$___twin___() {
            MapController r100 = this.f33096a.f33079j;
            if (r100 == null) goto L8;
            AppBaseMap r101 = r100.getBaseMap();
            if (r101 == null) goto L9;
            r101.ShowSatelliteMap(MapSurfaceView.a(this.f33096a));
            return;
        L9:
            return;
        }

        public a(MapSurfaceView r100) {
            this.f33096a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_MapSurfaceView$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_platform_comapi_map_MapSurfaceView$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33097a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_MapSurfaceView$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_map_MapSurfaceView$b__run$___twin___() {
            MapController r100 = this.f33097a.f33079j;
            if (r100 == null) goto L8;
            AppBaseMap r101 = r100.getBaseMap();
            if (r101 == null) goto L9;
            r101.ShowTrafficMap(MapSurfaceView.b(this.f33097a));
            return;
        L9:
            return;
        }

        public b(MapSurfaceView r100) {
            this.f33097a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_MapSurfaceView$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_baidu_platform_comapi_map_MapSurfaceView$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33098a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_MapSurfaceView$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_map_MapSurfaceView$c__run$___twin___() {
            MapController r100 = this.f33098a.f33079j;
            if (r100 == null) goto L8;
            AppBaseMap r101 = r100.getBaseMap();
            if (r101 == null) goto L9;
            r101.ShowTrafficMap(MapSurfaceView.b(this.f33098a));
            return;
        L9:
            return;
        }

        public c(MapSurfaceView r100) {
            this.f33098a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_MapSurfaceView$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_baidu_platform_comapi_map_MapSurfaceView$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33099a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_MapSurfaceView$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_map_MapSurfaceView$d__run$___twin___() {
            MapController r100 = this.f33099a.f33079j;
            if (r100 == null) goto L8;
            AppBaseMap r101 = r100.getBaseMap();
            if (r101 == null) goto L9;
            r101.ShowStreetRoadMap(MapSurfaceView.c(this.f33099a));
            return;
        L9:
            return;
        }

        public d(MapSurfaceView r100) {
            this.f33099a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_MapSurfaceView$d_com_larus_apm_impl_protector_RunnableLancet_run(d r100) {
            r100.com_baidu_platform_comapi_map_MapSurfaceView$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f33100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33101b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_MapSurfaceView$e_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_map_MapSurfaceView$e__run$___twin___() {
            MapController r100 = this.f33101b.f33079j;
            if (r100 == null) goto L8;
            AppBaseMap r101 = r100.getBaseMap();
            if (r101 == null) goto L9;
            r101.ShowBaseIndoorMap(this.f33100a);
            return;
        L9:
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_MapSurfaceView$e_com_larus_apm_impl_protector_RunnableLancet_run(e r100) {
            r100.com_baidu_platform_comapi_map_MapSurfaceView$e__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(MapSurfaceView r100, boolean r101) {
            this.f33101b = r100;
            this.f33100a = r101;
        }
    }

    public class f implements com.baidu.platform.comapi.map.e.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f33102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33103b;

        private f(MapSurfaceView r100) {
            this.f33103b = r100;
            this.f33102a = 12440;
        }

        private String a(int r100) {
            switch(r100) {
                case 12288: goto L33;
                case 12289: goto L31;
                case 12290: goto L29;
                case 12291: goto L27;
                case 12292: goto L25;
                case 12293: goto L23;
                case 12294: goto L21;
                case 12295: goto L19;
                case 12296: goto L17;
                case 12297: goto L15;
                case 12298: goto L13;
                case 12299: goto L11;
                case 12300: goto L9;
                case 12301: goto L7;
                case 12302: goto L5;
                default: goto L4;
            };
        L5:
            return "EGL_CONTEXT_LOST";
        L7:
            return "EGL_BAD_SURFACE";
        L9:
            return "EGL_BAD_PARAMETER";
        L11:
            return "EGL_BAD_NATIVE_WINDOW";
        L13:
            return "EGL_BAD_NATIVE_PIXMAP";
        L15:
            return "EGL_BAD_MATCH";
        L17:
            return "EGL_BAD_DISPLAY";
        L19:
            return "EGL_BAD_CURRENT_SURFACE";
        L21:
            return "EGL_BAD_CONTEXT";
        L23:
            return "EGL_BAD_CONFIG";
        L25:
            return "EGL_BAD_ATTRIBUTE";
        L27:
            return "EGL_BAD_ALLOC";
        L29:
            return "EGL_BAD_ACCESS";
        L31:
            return "EGL_NOT_INITIALIZED";
        L33:
            return "EGL_SUCCESS";
        L4:
            return b(r100);
        }

        private String b(int r100) {
            return "0x" + Integer.toHexString(r100);
        }

        public /* synthetic */ f(MapSurfaceView r100, a r101) {
            this(r100);
        }

        public String a(String r100, int r101) {
            return r100 + " failed: " + a(r101);
        }

        public void b(String r100, int r101) {
            throw new RuntimeException(a(r100, r101));
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            return r100.eglCreateContext(r101, r102, EGL10.EGL_NO_CONTEXT, new int[]{this.f33102a, 2, 12344});
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            if (r102 == null) goto L7;
            if (r101 == null) goto L7;
            EGLSurface r103 = EGL10.EGL_NO_SURFACE;
            r100.eglMakeCurrent(r101, r103, r103, r102);
            if (r100.eglDestroyContext(r101, r102) == true) goto L7;
            r101.toString();
            r102.toString();
            b("eglDestroyContex", r100.eglGetError());
        L7:
            this.f33103b.onRecycle();
        }
    }

    public class g extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f33104a;

        private g(MapSurfaceView r100) {
            this.f33104a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r100) {
            super.onLongPress(r100);
            MapController r101 = this.f33104a.f33079j;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getBaseMap() == null) goto L94;
            MapController r102 = this.f33104a.f33079j;
            if (r102.mIsMapLoadFinish == false) goto L98;
            String r103 = r102.getBaseMap().GetNearlyObjID(-1, (int) r100.getX(), (int) r100.getY(), this.f33104a.f33079j.nearlyRadius);
            GeoPoint r104 = null;
            if (r103 != null) goto L12;
        L29:
            MapSurfaceView r105 = this.f33104a;
            if (r105.f33079j.mListeners != null) goto L32;
        L43:
            if (OverlayUtil.isOverlayUpgrade() == true) goto L45;
            return;
        L45:
            if (MapSurfaceView.d(this.f33104a) != null) goto L47;
            return;
        L47:
            if (MapSurfaceView.d(this.f33104a).isEmpty() == true) goto L97;
            int r106 = 0;
        L50:
            if (r106 >= MapSurfaceView.d(this.f33104a).size()) goto L99;
            BmLayer r107 = (BmLayer) ListProtector.get(MapSurfaceView.d(this.f33104a), r106);
            if (r107 == null) goto L66;
            BmDrawItem r108 = r107.a((int) r100.getX(), (int) r100.getY(), this.f33104a.f33079j.nearlyRadius);
            if (r108 == null) goto L66;
            List<v> r109 = this.f33104a.f33079j.mListeners;
            if (r109 == null) goto L66;
            Iterator<v> r110 = r109.iterator();
        L59:
            if (r110.hasNext() == false) goto L66;
            v r111 = r110.next();
            if (r111 == null) goto L59;
            if (r111.a(r108) == false) goto L59;
            this.f33104a.f33079j.mHasBmDrawItemDraging = true;
        L66:
            r106 = r106 + 1;
            goto L50
        L99:
            return;
        L97:
            return;
        L32:
            if (r105.getProjection() == null) goto L34;
            r104 = this.f33104a.getProjection().fromPixels((int) r100.getX(), (int) r100.getY());
        L34:
            if (r104 != null) goto L36;
            return;
        L36:
            Iterator<v> r112 = this.f33104a.f33079j.mListeners.iterator();
        L38:
            if (r112.hasNext() == false) goto L43;
            v r113 = r112.next();
            if (r113 == null) goto L38;
            r113.d(r104);
            goto L38
        L12:
            if (r103.equals("") == true) goto L29;
            MapSurfaceView r114 = this.f33104a;
            if (r114.f33079j.mListeners == null) goto L43;
            if (r114.getProjection() == null) goto L18;
            r104 = this.f33104a.getProjection().fromPixels((int) r100.getX(), (int) r100.getY());
        L18:
            Iterator<v> r115 = this.f33104a.f33079j.mListeners.iterator();
        L20:
            if (r115.hasNext() == false) goto L43;
            v r116 = r115.next();
            if (r116 == null) goto L20;
            if (r116.a(r103) == true) goto L26;
            if (r104 == null) goto L20;
            r116.d(r104);
            goto L20
        L26:
            this.f33104a.f33079j.mHasMapObjDraging = true;
            goto L20
        L98:
            return;
        }

        public /* synthetic */ g(MapSurfaceView r100, a r101) {
            this(r100);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return true;
    }

    public void onBackground() {
        onBackground(false);
    }

    public void onForeground() {
        onForeground(false);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound r100) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean r100) {
    }

    public void a() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getBaseMap() != null) goto L9;
        return;
    L9:
        if (this.f33080k != null) goto L11;
        return;
    L11:
        this.f33087r.clear();
        this.f33080k.a();
    }

    public void b() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getBaseMap() != null) goto L8;
        return;
    L8:
        a();
    }

    public void beginLocationLayerAnimation() {
        LocationOverlay r100 = this.f33083n;
        if (r100 == null) goto L6;
        r100.beginLocationLayerAnimation();
        return;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentMapStatus();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getCurrentZoomLevel();
    }

    public int getFPS() {
        return this.f33361a.getFPS();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMapStatus().geoRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L6;
        return null;
    L6:
        MapStatus r101 = r100.getMapStatus();
        return new GeoPoint(r101.centerPtY, r101.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMapStatus();
    }

    public MapViewListener getMapViewListener() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMapViewListener();
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.f33092w.a();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public double getOverlooking() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.getMapStatus().overlooking;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getZoomLevel();
    }

    public double getZoomUnitsInMeter() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.getZoomUnitsInMeter();
    }

    public boolean isPredictTraffic() {
        if (this.E <= 0) goto L5;
        return true;
    L5:
        if (this.F <= 0) goto L7;
        return true;
    L7:
        if (this.G > 0) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean isSetBackgroundDraw() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSetBackgroundDraw();
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        MapController r100 = this.f33079j;
        if (r100 == null) goto L5;
        r100.updateDrawFPS();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.platform.comapi.map.t
    public void onPause() {
        if (this.f33077h == false) goto L6;
        return;
    L6:
        if (OpenLogUtil.isMapLogEnable() == false) goto L8;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onPause");
    L8:
        j r100 = this.f33082m;
        if (r100 == null) goto L11;
        r100.b();
    L11:
        MapController r101 = this.f33079j;
        if (r101 == null) goto L14;
        r101.onPause();
    L14:
        Iterator<m> r102 = this.f33090u.iterator();
    L16:
        if (r102.hasNext() == false) goto L18;
        r102.next().b(this);
        goto L16
    L18:
        super.onPause();
        this.f33077h = true;
    }

    public void onRecycle() {
        MapController r100 = this.f33079j;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getBaseMap() == null) goto L9;
        this.f33079j.getBaseMap().ResetImageRes();
        return;
    }

    @Override // com.baidu.platform.comapi.map.t
    public void onResume() {
        if (this.f33077h == true) goto L5;
        return;
    L5:
        if (OpenLogUtil.isMapLogEnable() == false) goto L8;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onResume isInited = " + this.f33084o);
    L8:
        if (this.f33084o == true) goto L10;
        return;
    L10:
        j r100 = this.f33082m;
        if (r100 == null) goto L13;
        r100.c();
    L13:
        MapController r101 = this.f33079j;
        if (r101 == null) goto L16;
        r101.onResume();
    L16:
        Iterator<m> r102 = this.f33090u.iterator();
    L18:
        if (r102.hasNext() == false) goto L20;
        r102.next().a(this);
        goto L18
    L20:
        setRenderMode(1);
        super.onResume();
        this.f33077h = false;
    }

    public void unInit() {
        com.baidu.mapsdkplatform.comapi.map.b r100 = this.A;
        if (r100 == null) goto L13;
        List<v> r101 = r100.f32121v;
        if (r101 == null) goto L12;
        Iterator<v> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        v r103 = r102.next();
        if (r103 == null) goto L8;
        r103.a();
    L12:
        this.A.h();
        this.A = null;
    L13:
        MapController r104 = this.f33079j;
        if (r104 == null) goto L16;
        r104.unInit();
    L16:
        this.f33079j = null;
        p r105 = this.f33080k;
        if (r105 == null) goto L19;
        r105.a();
    L19:
        this.f33080k = null;
        this.f33081l = null;
        this.f33082m = null;
        if (OpenLogUtil.isMapLogEnable() == false) goto L28;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView unInit");
        return;
    }

    static {
        f33072c = Executors.newSingleThreadExecutor();
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        MapStatus r100 = getMapStatus();
        h r101 = (h) getProjection();
        MapStatus.WinRound r102 = r100.winRound;
        GeoPoint r103 = r101.fromPixels(r102.left, r102.top);
        MapStatus.WinRound r104 = r100.winRound;
        return (int) Math.abs(r103.getLatitude() - r101.fromPixels(r104.right - 1, r104.bottom - 1).getLatitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        MapStatus r100 = getMapStatus();
        h r101 = (h) getProjection();
        MapStatus.WinRound r102 = r100.winRound;
        GeoPoint r103 = r101.fromPixels(r102.left, r102.top);
        MapStatus.WinRound r104 = r100.winRound;
        return (int) Math.abs(r101.fromPixels(r104.right - 1, r104.bottom - 1).getLongitude() - r103.getLongitude());
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ r getRenderControl() {
        return super.getRenderControl();
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ s.a getViewType() {
        return super.getViewType();
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MapController r100 = this.f33079j;
        if (r100 == null) goto L6;
        r100.updateDrawFPS();
        return;
    }

    public com.baidu.mapsdkplatform.comapi.map.b getBaseMap() {
        return this.A;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.f33086q;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.f33079j;
    }

    public LocationOverlay getDefaultLocationLay() {
        return this.f33083n;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.f33087r;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.f33081l;
    }

    public ExecutorService getSingleThreadPool() {
        return f33072c;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return this.f33076g;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return this.f33074e;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return this.f33075f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return this.f33073d;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        requestRender();
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void requestRender() {
        super.requestRender();
    }

    public MapSurfaceView(Context r100) {
        super(r100);
        this.f33073d = false;
        this.f33074e = false;
        this.f33075f = false;
        this.f33076g = true;
        this.f33077h = true;
        this.f33078i = true;
        this.f33079j = null;
        this.f33080k = null;
        this.f33081l = null;
        this.f33084o = false;
        this.f33085p = true;
        this.f33086q = new ArrayList();
        this.f33087r = new ArrayList();
        this.f33088s = 0;
        this.f33089t = 0;
        this.f33090u = new HashSet();
        this.f33091v = true;
        this.f33095z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        f33071b++;
    }

    public static /* synthetic */ boolean a(MapSurfaceView r100) {
        return r100.f33074e;
    }

    public static /* synthetic */ boolean b(MapSurfaceView r100) {
        return r100.f33073d;
    }

    public static /* synthetic */ boolean c(MapSurfaceView r100) {
        return r100.f33075f;
    }

    public static /* synthetic */ List d(MapSurfaceView r100) {
        return r100.f33086q;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer r100) {
        return addBmLayerBelow(0, r100);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean addOverlay(Overlay r110) {
        monitor-enter(this);
        if (r110 != null) goto L56;
    L50:
        monitor-exit(this);
        return false;
    L56:
        MapController r100 = this.f33079j;     // Catch: Throwable -> L47
        if (r100 == null) goto L50;
        AppBaseMap r101 = r100.getBaseMap();     // Catch: Throwable -> L47
        if (r101 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if ((r110 instanceof InnerOverlay) == false) goto L30;
        InnerOverlay r102 = (InnerOverlay) r110;     // Catch: Throwable -> L47
        if (r102.mBaseMap != null) goto L18;
        r102.mBaseMap = getController().getBaseMap();     // Catch: Throwable -> L47
    L18:
        if (r102.addedToMapView() == false) goto L27;
        monitor-enter(this);     // Catch: Throwable -> L47
        this.f33087r.add(r110);     // Catch: Throwable -> L24
        this.f33080k.a((InnerOverlay) r110);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        monitor-exit(this);
        return true;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L27:
        monitor-exit(this);
        return false;
    L30:
        if ((r110 instanceof ItemizedOverlay) == false) goto L45;
        ItemizedOverlay r103 = (ItemizedOverlay) r110;     // Catch: Throwable -> L47
        long r104 = r101.AddLayer(r103.getUpdateType(), 0, MapController.ITEM_LAYER_TAG);     // Catch: Throwable -> L47
        r110.mLayerID = r104;     // Catch: Throwable -> L47
        if (r104 != 0) goto L36;
        monitor-exit(this);
        return false;
    L36:
        monitor-enter(this);     // Catch: Throwable -> L47
        this.f33087r.add(r110);     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L42
        r103.c();     // Catch: Throwable -> L47
        r101.SetLayersClickable(r110.mLayerID, true);     // Catch: Throwable -> L47
        r101.ShowLayers(r110.mLayerID, true);     // Catch: Throwable -> L47
        r101.UpdateLayers(r110.mLayerID);     // Catch: Throwable -> L47
        monitor-exit(this);
        return true;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);
        return false;
    L47:
        th = move-exception;
        throw th;
    }

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener r100) {
        this.f33092w.a(r100);
    }

    public void addStateListener(m r100) {
        if (r100 == null) goto L5;
        this.f33090u.add(r100);
        return;
    }

    public void clearDefaultLocationLayerData(Bundle r100) {
        this.f33083n.clearLocationLayerData(r100);
    }

    public void forceSetTraffic(boolean r100) {
        if (this.f33079j == null) goto L5;
        this.f33073d = r100;
    L5:
        f33072c.submit(new b(this));
    }

    public synchronized Overlay getOverlay(int r100) {
        monitor-enter(this);
        if (r100 != 21) goto L19;
        monitor-exit(this);
        return null;
    L19:
        Iterator<Overlay> r101 = this.f33087r.iterator();     // Catch: Throwable -> L16
    L9:
        if (r101.hasNext() == false) goto L14;
        Overlay r102 = r101.next();     // Catch: Throwable -> L16
        if (r102.mType != r100) goto L9;
        monitor-exit(this);
        return r102;
    L14:
        monitor-exit(this);
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound r100) {
        SysOSUtil r101 = SysOSUtil.getInstance();
        return getZoomToBound(r100, r101.getScreenWidth(), r101.getScreenHeight());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound r100) {
        SysOSUtil r101 = SysOSUtil.getInstance();
        return getZoomToBoundF(r100, r101.getScreenWidth(), r101.getScreenHeight());
    }

    public void onBackground(boolean r100) {
        if (r100 == false) goto L4;
    L6:
        MapController r101 = this.f33079j;
        if (r101 != null) goto L9;
    L11:
        this.f33078i = true;
        return;
    L9:
        if (r101.getBaseMap() == null) goto L11;
        this.f33079j.getBaseMap().OnBackground();
        goto L11
    L4:
        if (this.f33078i == false) goto L6;
    }

    public void onForeground(boolean r100) {
        if (r100 == false) goto L4;
    L5:
        MapController r101 = this.f33079j;
        if (r101 != null) goto L8;
    L10:
        this.f33078i = false;
        if (this.f33361a.getViewType() != s.a.f33358b) goto L18;
        j r102 = this.f33082m;
        if (r102 == null) goto L15;
        r102.c();
    L15:
        super.onResume();
        return;
    L18:
        return;
    L8:
        if (r101.getBaseMap() == null) goto L10;
        this.f33079j.getBaseMap().OnForeground();
        goto L10
    L4:
        if (this.f33078i == true) goto L5;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int r100) {
        if (r100 != 1) goto L5;
        requestRender();
        return;
    L5:
        if (r100 != 0) goto L10;
        if (getRenderMode() == 0) goto L16;
        setRenderMode(0);
        return;
    L16:
        return;
    L10:
        if (r100 != 2) goto L18;
        n r101 = this.f33094y;
        if (r101 == null) goto L19;
        r101.a();
        return;
    L19:
        return;
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        if (r100 != 0) goto L5;
        this.D = false;
    L31:
        MapStatus r101 = getMapStatus();
        int r102 = r110.getPointerCount();
        int r103 = 0;
    L32:
        if (r103 >= r102) goto L63;
        int r104 = (int) r110.getX(r103);
        int r105 = (int) r110.getY(r103);
        if (r101 == null) goto L44;
        MapStatus.WinRound r106 = r101.winRound;
        if (r104 < r106.left) goto L44;
        if (r104 > r106.right) goto L44;
        if (r105 < r106.top) goto L44;
        if (r105 > r106.bottom) goto L44;
    L48:
        r103 = r103 + 1;
    L44:
        if (r110.getAction() == 262) goto L48;
        if (r110.getAction() == 6) goto L48;
        return false;
    L63:
        GestureDetector r107 = this.f33093x;     // Catch: Exception -> L61
        if (r107 != null) goto L52;
    L54:
        MapController r108 = this.f33079j;     // Catch: Exception -> L61
        if (r108 == null) goto L60;
        if (r108.handleTouchEvent(r110) == false) goto L60;
        return true;
    L60:
        return super.onTouchEvent(r110);
    L52:
        if (r107.onTouchEvent(r110) == false) goto L54;
        return true;
    L62:
        return super.onTouchEvent(r110);
    L5:
        if (r100 != 2) goto L31;
        float r109 = r110.getX();
        float r111 = r110.getY();
        if (r109 >= 0.0f) goto L10;
    L16:
        boolean r112 = false;
    L17:
        if (r112 == true) goto L31;
        if (this.D == true) goto L31;
        com.baidu.mapsdkplatform.comapi.map.b r113 = this.A;
        if (r113 == null) goto L31;
        List<v> r114 = r113.f32121v;
        if (r114 == null) goto L31;
        Iterator<v> r115 = r114.iterator();
    L26:
        if (r115.hasNext() == false) goto L31;
        v r116 = r115.next();
        if (r116 == null) goto L26;
        r116.a(this.A.z());
        this.D = true;
        goto L26
    L10:
        if (r109 > this.B) goto L16;
        if (r111 < 0.0f) goto L16;
        if (r111 > this.C) goto L16;
        r112 = true;
        goto L17
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void queueEvent(Runnable r100) {
        super.queueEvent(r100);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f33079j != null) goto L7;
        return;
    L7:
        if ((r100 instanceof ItemizedOverlay) == false) goto L15;
        ItemizedOverlay r101 = (ItemizedOverlay) r100;
        if (r101.b() == false) goto L15;
        if (r101.getAllItem().size() > 0) goto L13;
        this.f33079j.getBaseMap().ClearLayer(r100.mLayerID);
        this.f33079j.getBaseMap().ShowLayers(r100.mLayerID, false);
        this.f33079j.getBaseMap().UpdateLayers(r100.mLayerID);
    L14:
        r101.b(false);
        goto L15
    L13:
        this.f33079j.getBaseMap().ShowLayers(r100.mLayerID, true);
        this.f33079j.getBaseMap().UpdateLayers(r100.mLayerID);
    L15:
        MapController r102 = this.f33079j;
        if (r102 != null) goto L18;
        return;
    L18:
        if (r102.getBaseMap() == null) goto L23;
        this.f33079j.getBaseMap().UpdateLayers(r100.mLayerID);
        return;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer r100) {
        monitor-enter(this);
        if (r100 != null) goto L29;
    L25:
        monitor-exit(this);
        return false;
    L29:
        MapController r101 = this.f33079j;     // Catch: Throwable -> L22
        if (r101 == null) goto L25;
        AppBaseMap r102 = r101.getBaseMap();     // Catch: Throwable -> L22
        if (r102 != null) goto L12;
        monitor-exit(this);
        return false;
    L12:
        r102.removeBmLayer(r100.getNativeInstance());     // Catch: Throwable -> L22
        monitor-enter(this);     // Catch: Throwable -> L22
        this.f33086q.remove(r100);     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeOverlay(Overlay r100) {
        monitor-enter(this);
        if (r100 != null) goto L36;
    L32:
        monitor-exit(this);
        return false;
    L36:
        MapController r101 = this.f33079j;     // Catch: Throwable -> L29
        if (r101 == null) goto L32;
        AppBaseMap r102 = r101.getBaseMap();     // Catch: Throwable -> L29
        if (r102 != null) goto L12;
        monitor-exit(this);
        return false;
    L12:
        r102.ClearLayer(r100.mLayerID);     // Catch: Throwable -> L29
        r102.ShowLayers(r100.mLayerID, false);     // Catch: Throwable -> L29
        r102.UpdateLayers(r100.mLayerID);     // Catch: Throwable -> L29
        r102.RemoveLayer(r100.mLayerID);     // Catch: Throwable -> L29
        monitor-enter(this);     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L15:
        if ((r100 instanceof ItemizedOverlay) == false) goto L18;
        this.f33087r.remove(r100);     // Catch: Throwable -> L26
    L20:
        monitor-exit(this);     // Catch: Throwable -> L26
    L22:
        r100.mLayerID = 0;     // Catch: Throwable -> L29
        monitor-exit(this);
        return true;
    L18:
        if ((r100 instanceof InnerOverlay) == false) goto L20;
        this.f33087r.remove(r100);     // Catch: Throwable -> L26
        this.f33080k.a(r100);     // Catch: Throwable -> L26
    L29:
        th = move-exception;
        throw th;
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener r100) {
        this.f33092w.b(r100);
    }

    public void removeStateListener(m r100) {
        if (r100 == null) goto L5;
        this.f33090u.remove(r100);
        return;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L6;
        r101.saveScreenToLocal(r100);
        return;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean r100) {
        if (this.f33079j == null) goto L5;
        this.f33076g = r100;
    L5:
        f33072c.submit(new e(this, r100));
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.b r100) {
        this.A = r100;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setDebugFlags(int r100) {
        super.setDebugFlags(r100);
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> r100) {
        this.f33083n.setLocationLayerData(r100);
    }

    public void setFPS(int r100) {
        this.f33361a.setFPS(r100);
    }

    public void setFirstFrameDrawListener(com.baidu.platform.comapi.map.d r100) {
        j r101 = this.f33082m;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void setFirstFrameListener(com.baidu.platform.comapi.map.d r100) {
        j r101 = this.f33082m;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void setGestureDetector(GestureDetector r100) {
        this.f33093x = r100;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L6;
        MapStatus r102 = r101.getMapStatus();
        r102.centerPtX = r100.getLongitude();
        r102.centerPtY = r100.getLatitude();
        this.f33079j.setMapStatus(r102);
        return;
    }

    public void setMapController(MapController r100) {
        if (this.f33079j == null) goto L5;
        return;
    L5:
        this.f33079j = r100;
        this.f33082m.a(r100.getBaseMap());
        this.f33082m.a(true);
        p r101 = new p(this.f33079j.getBaseMap());
        this.f33080k = r101;
        this.f33079j.setOverlayMapCallBack(r101);
        this.f33079j.setMapViewInterface(this);
        b();
        this.f33079j.setMapRenderModeChangeListener(this);
        this.f33084o = true;
        this.f33081l = new h(this.f33079j);
        this.f33092w.a(this.f33079j);
    }

    public void setMapRenderStableListener(n r100) {
        this.f33094y = r100;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L6;
        r101.setMapStatus(r100);
        return;
    }

    public void setOnLongPressListener(OnLongPressListener r100) {
        this.f33092w.a(r100);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L6;
        MapStatus r102 = r101.getMapStatus();
        r102.overlooking = r100;
        this.f33079j.setMapStatus(r102);
        return;
    }

    public void setPixelFormatTransparent(boolean r100) {
        if (r100 == false) goto L4;
        getHolder().setFormat(-3);
        return;
    L4:
        getHolder().setFormat(-1);
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setRenderMode(int r100) {
        super.setRenderMode(r100);
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setRenderer(SurfaceRenderer r100) {
        super.setRenderer(r100);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L6;
        MapStatus r102 = r101.getMapStatus();
        r102.rotation = r100;
        this.f33079j.setMapStatus(r102);
        return;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean r100) {
        if (this.f33079j == null) goto L5;
        this.f33074e = r100;
    L5:
        f33072c.submit(new a(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean r100) {
        if (this.f33079j == null) goto L5;
        this.f33075f = r100;
    L5:
        f33072c.submit(new d(this));
    }

    public void setSupBackgroundDraw(boolean r100) {
        MapController r101 = this.f33079j;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setSupBackgroundDraw(r100);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean r100) {
        if (this.f33073d != r100) goto L6;
        return;
    L6:
        if (this.f33079j == null) goto L8;
        this.f33073d = r100;
    L8:
        f33072c.submit(new c(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L6;
        MapStatus r102 = r101.getMapStatus();
        r102.winRound = r100;
        this.f33079j.setMapStatus(r102);
        return;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float r100) {
        if (this.f33079j != null) goto L5;
        return;
    L5:
        getController().getFocusedBaseIndoorMapInfo();
        if (r100 >= 4.0f) goto L8;
        r100 = 4.0f;
    L11:
        MapStatus r101 = getMapStatus();
        if (r101 == null) goto L15;
        r101.level = r100;
        animateTo(r101, 300);
        return;
    L15:
        return;
    L8:
        float r102 = 22;
        if (r100 <= r102) goto L11;
        r100 = r102;
        goto L11
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L5;
        r101.updateDrawFPS();
    L5:
        super.surfaceCreated(r100);
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getSurface().isValid() == true) goto L12;
        surfaceDestroyed(r100);
        return;
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        MapController r101 = this.f33079j;
        if (r101 == null) goto L5;
        r101.updateDrawFPS();
    L5:
        super.surfaceDestroyed(r100);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback2
    public /* bridge */ /* synthetic */ void surfaceRedrawNeeded(SurfaceHolder r100) {
        super.surfaceRedrawNeeded(r100);
    }

    public synchronized Overlay getOverlay(Class<?> r100) {
        monitor-enter(this);
        Iterator<Overlay> r101 = this.f33087r.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L10;
        Overlay r102 = r101.next();     // Catch: Throwable -> L13
        if (r102.getClass() != r100) goto L5;
        monitor-exit(this);
        return r102;
    L10:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int r100) {
        setZoomLevel(r100);
    }

    public MapSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f33073d = false;
        this.f33074e = false;
        this.f33075f = false;
        this.f33076g = true;
        this.f33077h = true;
        this.f33078i = true;
        this.f33079j = null;
        this.f33080k = null;
        this.f33081l = null;
        this.f33084o = false;
        this.f33085p = true;
        this.f33086q = new ArrayList();
        this.f33087r = new ArrayList();
        this.f33088s = 0;
        this.f33089t = 0;
        this.f33090u = new HashSet();
        this.f33091v = true;
        this.f33095z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        f33071b++;
    }

    public synchronized boolean addBmLayerBelow(long r110, BmLayer r111) {
        monitor-enter(this);
        if (r111 != null) goto L32;
    L29:
        monitor-exit(this);
        return false;
    L32:
        MapController r100 = this.f33079j;     // Catch: Throwable -> L26
        if (r100 == null) goto L29;
        AppBaseMap r101 = r100.getBaseMap();     // Catch: Throwable -> L26
        if (r101 != null) goto L12;
        monitor-exit(this);
        return false;
    L12:
        monitor-enter(this);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L14:
        if (this.f33086q.contains(r111) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L23
        monitor-exit(this);
        return false;
    L18:
        this.f33086q.add(r111);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        boolean r112 = r101.addBmLayerBelow(r110, r111.getNativeInstance(), 1, 0);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r112;
    L26:
        th = move-exception;
        throw th;
    }

    public void animateTo(MapStatus r100, int r101) {
        MapController r102 = this.f33079j;
        if (r102 == null) goto L6;
        r102.setMapStatusWithAnimation(r100, r101);
        return;
    }

    public float getFZoomToBoundF(MapBound r100, MapBound r101) {
        if (this.f33079j != null) goto L6;
        return 0.0f;
    L6:
        Bundle r102 = new Bundle();
        r102.putInt("left", r100.leftBottomPt.getIntX());
        r102.putInt("bottom", r100.leftBottomPt.getIntY());
        r102.putInt("right", r100.rightTopPt.getIntX());
        r102.putInt("top", r100.rightTopPt.getIntY());
        Bundle r103 = new Bundle();
        r103.putInt("left", r101.leftBottomPt.getIntX());
        r103.putInt("bottom", r101.leftBottomPt.getIntY());
        r103.putInt("right", r101.rightTopPt.getIntX());
        r103.putInt("top", r101.rightTopPt.getIntY());
        return this.f33079j.GetFZoomToBoundF(r102, r103);
    }

    public boolean inRangeOfView(float r100, float r101) {
        float r102 = 0;
        if (r100 >= r102) goto L5;
    L13:
        return false;
    L5:
        if (r100 > (this.f33088s + 0)) goto L13;
        if (r101 < r102) goto L13;
        if (r101 > (this.f33089t + 0)) goto L13;
        return true;
    }

    public synchronized boolean insertOverlay(Overlay r100, int r101) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if ((r100 instanceof InnerOverlay) == false) goto L11;
        MapController r102 = this.f33079j;     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        InnerOverlay r103 = (InnerOverlay) r100;     // Catch: Throwable -> L14
        if (r103.mBaseMap != null) goto L10;
        r103.mBaseMap = r102.getBaseMap();     // Catch: Throwable -> L14
    L10:
        this.f33087r.add(r100);     // Catch: Throwable -> L14
        this.f33080k.a(r103);     // Catch: Throwable -> L14
    L11:
        monitor-exit(this);
        return false;
    }

    public void saveScreenToLocal(String r100, Rect r101) {
        com.baidu.mapsdkplatform.comapi.map.b r102 = this.A;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.i() == null) goto L48;
        String r103 = null;
        if (r101 == null) goto L37;
        int r104 = r101.left;
        int r105 = this.f33089t;
        int r106 = r101.bottom;
        if (r105 >= r106) goto L12;
        int r107 = 0;
    L13:
        int r108 = r101.width();
        int r109 = r101.height();
        if (r104 < 0) goto L42;
        if (r107 < 0) goto L43;
        if (r108 <= 0) goto L44;
        if (r109 > 0) goto L20;
        return;
    L20:
        if (r108 <= this.f33088s) goto L23;
        r108 = Math.abs(r101.width()) - (r101.right - this.f33088s);
    L23:
        if (r109 <= this.f33089t) goto L26;
        r109 = Math.abs(r101.height()) - (r101.bottom - this.f33089t);
    L26:
        if (r104 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX()) goto L28;
    L35:
        this.A.i().SaveScreenToLocal(r100, null);
        return;
    L28:
        if (r107 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) goto L35;
        if (r108 == 0) goto L34;
        if (r109 == 0) goto L34;
        JSONObject r110 = new JSONObject();
        r110.put("x", r104);     // Catch: Exception -> L39
        r110.put("y", r107);     // Catch: Exception -> L39
        r110.put("width", r108);     // Catch: Exception -> L39
        r110.put("height", r109);     // Catch: Exception -> L39
        r103 = r110.toString();     // Catch: Exception -> L39
    L34:
        this.A.i().SaveScreenToLocal(r100, r103);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L12:
        r107 = r105 - r106;
        goto L13
    L37:
        this.A.i().SaveScreenToLocal(r100, null);
        return;
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback2
    public /* bridge */ /* synthetic */ void surfaceRedrawNeededAsync(SurfaceHolder r100, Runnable r101) {
        super.surfaceRedrawNeededAsync(r100, r101);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay r100, Overlay r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        MapController r102 = this.f33079j;
        if (r102 == null) goto L13;
        AppBaseMap r103 = r102.getBaseMap();
        if (r103 != null) goto L12;
        return false;
    L12:
        return r103.SwitchLayer(r100.mLayerID, r101.mLayerID);
    L13:
        return false;
    }

    public MapSurfaceView(Context r100, s.a r101) {
        super(r100, r101);
        this.f33073d = false;
        this.f33074e = false;
        this.f33075f = false;
        this.f33076g = true;
        this.f33077h = true;
        this.f33078i = true;
        this.f33079j = null;
        this.f33080k = null;
        this.f33081l = null;
        this.f33084o = false;
        this.f33085p = true;
        this.f33086q = new ArrayList();
        this.f33087r = new ArrayList();
        this.f33088s = 0;
        this.f33089t = 0;
        this.f33090u = new HashSet();
        this.f33091v = true;
        this.f33095z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        f33071b++;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay r100, BmLayer r101) {
        if (r100 == null) goto L6;
        return addBmLayerBelow(r100.mLayerID, r101);
    L6:
        return addBmLayerBelow(0, r101);
    }

    public MapSurfaceView(Context r100, boolean r101) {
        super(r100, r101);
        this.f33073d = false;
        this.f33074e = false;
        this.f33075f = false;
        this.f33076g = true;
        this.f33077h = true;
        this.f33078i = true;
        this.f33079j = null;
        this.f33080k = null;
        this.f33081l = null;
        this.f33084o = false;
        this.f33085p = true;
        this.f33086q = new ArrayList();
        this.f33087r = new ArrayList();
        this.f33088s = 0;
        this.f33089t = 0;
        this.f33090u = new HashSet();
        this.f33091v = true;
        this.f33095z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        f33071b++;
    }

    public MapSurfaceView(Context r100, s.a r101, boolean r102) {
        super(r100, r101, r102);
        this.f33073d = false;
        this.f33074e = false;
        this.f33075f = false;
        this.f33076g = true;
        this.f33077h = true;
        this.f33078i = true;
        this.f33079j = null;
        this.f33080k = null;
        this.f33081l = null;
        this.f33084o = false;
        this.f33085p = true;
        this.f33086q = new ArrayList();
        this.f33087r = new ArrayList();
        this.f33088s = 0;
        this.f33089t = 0;
        this.f33090u = new HashSet();
        this.f33091v = true;
        this.f33095z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        f33071b++;
    }

    @Override // com.baidu.platform.comapi.map.t
    public void a(Context r100, s.a r101, boolean r102) {
        super.a(r100, r101, r102);
        setBackgroundColor(Color.rgb(244, 242, 240));
        setPixelFormatTransparent(false);
        this.f33092w = new x();
        this.f33093x = new GestureDetector(r100, this.f33092w);
        j r103 = new j(new WeakReference(this), this);
        this.f33082m = r103;
        setRenderer(r103);
        setRenderMode(1);
        this.f33092w.a(new g(this, null));
        if (OpenLogUtil.isMapLogEnable() == false) goto L6;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView initView");
        return;
    }

    public void animateTo(MapStatus r100, int r101, int r102) {
        MapController r103 = this.f33079j;
        if (r103 == null) goto L6;
        r103.setMapStatusWithAnimation(r100, r101, r102);
        return;
    }

    public void doCaptureMapView(CaptureMapViewListener r100, Rect r101, Bitmap.Config r110) {
        if (r101 == null) goto L27;
        int r102 = r101.left;
        int r103 = this.f33089t;
        int r104 = r101.bottom;
        if (r103 >= r104) goto L6;
        int r105 = 0;
    L7:
        int r106 = r101.width();
        int r107 = r101.height();
        if (r102 < 0) goto L28;
        if (r105 < 0) goto L29;
        if (r106 <= 0) goto L30;
        if (r107 > 0) goto L14;
        return;
    L14:
        if (r106 <= this.f33088s) goto L16;
        r106 = Math.abs(r101.width()) - (r101.right - this.f33088s);
    L16:
        int r108 = r106;
        if (r107 <= this.f33089t) goto L19;
        int r109 = Math.abs(r101.height()) - (r101.bottom - this.f33089t);
    L21:
        if (r102 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX()) goto L23;
        return;
    L23:
        if (r105 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) goto L33;
        this.f33082m.a(r100, r102, r105, r108, r109, r110);
        requestRender();
        return;
    L33:
        return;
    L19:
        r109 = r107;
        goto L21
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L6:
        r105 = r103 - r104;
        goto L7
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound r100, int r101, int r102) {
        if (this.f33079j != null) goto L6;
        return 0.0f;
    L6:
        Bundle r103 = new Bundle();
        r103.putInt("left", r100.leftBottomPt.getIntX());
        r103.putInt("bottom", r100.leftBottomPt.getIntY());
        r103.putInt("right", r100.rightTopPt.getIntX());
        r103.putInt("top", r100.rightTopPt.getIntY());
        return this.f33079j.getZoomToBound(r103, r101, r102);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound r100, int r101, int r102) {
        if (this.f33079j != null) goto L6;
        return 0.0f;
    L6:
        Bundle r103 = new Bundle();
        r103.putInt("left", r100.leftBottomPt.getIntX());
        r103.putInt("bottom", r100.leftBottomPt.getIntY());
        r103.putInt("right", r100.rightTopPt.getIntX());
        r103.putInt("top", r100.rightTopPt.getIntY());
        return this.f33079j.getZoomToBoundF(r103);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r100, int r101, KeyEvent r102) {
        if (this == r100) goto L5;
        return false;
    L5:
        if (r102.getAction() == 0) goto L8;
        return false;
    L8:
        switch(r101) {
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            default: goto L9;
        };
    L9:
        return false;
    L10:
        this.f33079j.scrollBy(50, 0);
        return true;
    L11:
        this.f33079j.scrollBy(-50, 0);
        return true;
    L12:
        this.f33079j.scrollBy(0, 50);
        return true;
    L13:
        this.f33079j.scrollBy(0, -50);
        return true;
    }

    public boolean setItsPreTime(int r100, int r101, int r102) {
        if (this.E == r100) goto L5;
    L10:
        MapController r103 = this.f33079j;
        if (r103 == null) goto L16;
        AppBaseMap r104 = r103.getBaseMap();
        if (r104 == null) goto L18;
        this.E = r100;
        this.F = r101;
        this.G = r102;
        return r104.SetItsPreTime(r100, r101, r102);
    L18:
        return false;
    L16:
        return false;
    L5:
        if (this.F != r101) goto L10;
        if (this.G != r102) goto L10;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.t
    public r a(s.a r100, boolean r101, Context r102) {
        r r103 = super.a(r100, r101, r102);
        if ((r103 instanceof com.baidu.platform.comapi.map.e) == false) goto L7;
        com.baidu.platform.comapi.map.e r104 = (com.baidu.platform.comapi.map.e) r103;
        if (this.f33095z == false) goto L7;
        r104.a(new f(this, null));
    L7:
        return r103;
    }

    public void doCaptureMapView(CaptureMapViewListener r100, int r101, int r102) {
        this.f33082m.a(r100, r101, r102);
    }

    public void doCaptureMapView(CaptureMapViewListener r100, int r101, int r102, Bitmap.Config r103) {
        this.f33082m.a(r100, r101, r102, r103);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.B = r100;
        this.C = r101;
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        MapController r104 = this.f33079j;
        if (r104 == null) goto L5;
        r104.updateDrawFPS();
    L5:
        j r105 = this.f33082m;
        if (r105 == null) goto L8;
        r105.f33339v = r102;
        r105.f33340w = r103;
        r105.f33341x = 0;
    L8:
        this.f33088s = r102;
        this.f33089t = r103;
        super.surfaceChanged(r100, r101, r102, r103);
        if (this.f33079j == null) goto L30;
        MapStatus r106 = getMapStatus();
        if (r106 == null) goto L19;
        MapStatus.WinRound r107 = r106.winRound;
        r107.left = 0;
        r107.top = 0;
        r107.bottom = r103;
        r107.right = r102;
        if (this.f33085p == true) goto L15;
        this.f33079j.setMapStatus(r106, false);
    L17:
        if (this.f33079j.getMapViewSurfaceListener() == null) goto L19;
        this.f33079j.getMapViewSurfaceListener().onSurfaceChanged(r102, r103);
        goto L19
    L15:
        this.f33085p = false;
        this.f33079j.setMapStatusWithAnimation(r106, 4, 0);
    L19:
        MapStatus r108 = getMapStatus();
        MapStatus.WinRound r109 = r108.winRound;
        int r110 = Math.abs(r109.right - r109.left);
        MapStatus.WinRound r111 = r108.winRound;
        int r112 = Math.abs(r111.bottom - r111.top);
        if (OpenLogUtil.isMapLogEnable() == false) goto L22;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapSurfaceView winRoundWidth = " + r110 + ";winRoundHeight = " + r112 + ";mWidth = " + this.f33088s + ";mHeight = " + this.f33089t);
    L22:
        if (r110 <= 0) goto L25;
        if (r112 <= 0) goto L25;
        this.f33088s = r110;
        this.f33089t = r112;
    L25:
        this.f33079j.setScreenSize(this.f33088s, this.f33089t);
        if (this.f33079j.isNaviMode() == false) goto L30;
        if (this.f33079j.getNaviMapViewListener() == null) goto L30;
        this.f33079j.getNaviMapViewListener().resizeScreen(r102, r103);
    L30:
        com.baidu.mapsdkplatform.comapi.map.b r113 = this.A;
        if (r113 == null) goto L34;
        r113.b(this.f33088s, this.f33089t);
        return;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ Bitmap captureImageFromSurface(int r100, int r101, int r102, int r103, Object r104, Bitmap.Config r105) {
        return super.captureImageFromSurface(r100, r101, r102, r103, r104, r105);
    }
}
