package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
class j implements SurfaceRenderer {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9213a = false;

    /* renamed from: d, reason: collision with root package name */
    private u f9216d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<MapSurfaceView> f9217e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<MapTextureView> f9218f;

    /* renamed from: g, reason: collision with root package name */
    private CaptureMapViewListener f9219g;

    /* renamed from: i, reason: collision with root package name */
    private int f9221i;

    /* renamed from: j, reason: collision with root package name */
    private int f9222j;

    /* renamed from: k, reason: collision with root package name */
    private int f9223k;

    /* renamed from: l, reason: collision with root package name */
    private int f9224l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap.Config f9225m;

    /* renamed from: n, reason: collision with root package name */
    private d f9226n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9227o;

    /* renamed from: p, reason: collision with root package name */
    private int f9228p;

    /* renamed from: q, reason: collision with root package name */
    private int f9229q;

    /* renamed from: r, reason: collision with root package name */
    private int f9230r;

    /* renamed from: v, reason: collision with root package name */
    public int f9234v;

    /* renamed from: w, reason: collision with root package name */
    public int f9235w;

    /* renamed from: b, reason: collision with root package name */
    private AppBaseMap f9214b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9215c = false;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f9220h = false;

    /* renamed from: s, reason: collision with root package name */
    private long f9231s = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f9232t = false;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f9233u = false;

    /* renamed from: x, reason: collision with root package name */
    public int f9236x = 0;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f9237a;

        public a(MapSurfaceView mapSurfaceView) {
            this.f9237a = mapSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MapSurfaceView mapSurfaceView = this.f9237a;
            if (mapSurfaceView != null) {
                mapSurfaceView.setBackgroundResource(0);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f9239a;

        public b(Bitmap bitmap) {
            this.f9239a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f9219g.onCompleted(this.f9239a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f9241a;

        public c(Bitmap bitmap) {
            this.f9241a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f9219g.onCompleted(this.f9241a);
        }
    }

    public j(WeakReference<MapSurfaceView> weakReference, u uVar) {
        this.f9216d = uVar;
        this.f9217e = weakReference;
    }

    public void b() {
        this.f9233u = true;
    }

    public void c() {
        this.f9233u = false;
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onDrawFrame(Object obj) {
        List<v> list;
        List<v> list2;
        d dVar;
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        if (a()) {
            if (!this.f9232t) {
                this.f9232t = true;
                WeakReference<MapSurfaceView> weakReference = this.f9217e;
                if (weakReference != null && (mapSurfaceView2 = weakReference.get()) != null) {
                    try {
                        mapSurfaceView2.post(new a(mapSurfaceView2));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f9213a) {
                f9213a = false;
                return;
            }
            if (this.f9233u) {
                return;
            }
            int iDraw = this.f9214b.Draw();
            WeakReference<MapSurfaceView> weakReference2 = this.f9217e;
            if (weakReference2 != null && (mapSurfaceView = weakReference2.get()) != null) {
                if (iDraw == 1) {
                    mapSurfaceView.requestRender();
                } else if (mapSurfaceView.getRenderMode() != 0) {
                    mapSurfaceView.setRenderMode(0);
                }
            }
            WeakReference<MapTextureView> weakReference3 = this.f9218f;
            if (weakReference3 != null && (mapTextureView = weakReference3.get()) != null) {
                if (iDraw == 1) {
                    mapTextureView.requestRender();
                } else if (mapTextureView.getRenderMode() != 0) {
                    mapTextureView.setRenderMode(0);
                }
            }
            if (this.f9220h) {
                this.f9220h = false;
                if (this.f9219g != null) {
                    a(obj);
                }
            }
            if (!this.f9227o) {
                int i4 = this.f9228p + 1;
                this.f9228p = i4;
                if (i4 == 2 && (dVar = this.f9226n) != null) {
                    dVar.a();
                    if (OpenLogUtil.isMapLogEnable()) {
                        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onDrawFirstFrame");
                    }
                }
                this.f9227o = this.f9228p == 2;
            }
            WeakReference<MapSurfaceView> weakReference4 = this.f9217e;
            com.baidu.mapsdkplatform.comapi.map.b baseMap = (weakReference4 == null || weakReference4.get() == null) ? null : this.f9217e.get().getBaseMap();
            if (baseMap != null && (list2 = baseMap.f8020v) != null) {
                for (v vVar : list2) {
                    com.baidu.mapsdkplatform.comapi.map.s sVarN = baseMap.n();
                    if (vVar != null) {
                        vVar.a((GL10) null, sVarN);
                    }
                }
            }
            WeakReference<MapTextureView> weakReference5 = this.f9218f;
            com.baidu.mapsdkplatform.comapi.map.b baseMap2 = (weakReference5 == null || weakReference5.get() == null) ? null : this.f9218f.get().getBaseMap();
            if (baseMap2 == null || (list = baseMap2.f8020v) == null) {
                return;
            }
            for (v vVar2 : list) {
                com.baidu.mapsdkplatform.comapi.map.s sVarN2 = baseMap2.n();
                if (vVar2 != null) {
                    vVar2.a((GL10) null, sVarN2);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceChanged(int i4, int i5) {
        AppBaseMap appBaseMap = this.f9214b;
        if (appBaseMap != null) {
            appBaseMap.renderResize(i4, i5);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onSurfaceChanged width = " + i4 + "; height = " + i5);
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceCreated(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        this.f9227o = false;
        this.f9228p = 0;
        this.f9230r = 0;
        this.f9229q = 0;
        if (a()) {
            this.f9214b.renderInit(i4, i5, surfaceHolder != null ? surfaceHolder.getSurface() : null, i6);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onSurfaceCreated ok");
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder != null ? surfaceHolder.getSurface() : null;
        AppBaseMap appBaseMap = this.f9214b;
        if (appBaseMap != null) {
            appBaseMap.surfaceDestroyed(surface);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onSurfaceDestroyed");
        }
    }

    public void a(AppBaseMap appBaseMap) {
        this.f9214b = appBaseMap;
    }

    public void a(boolean z4) {
        this.f9215c = z4;
    }

    private boolean a() {
        return this.f9214b != null && this.f9215c;
    }

    private void a(Object obj) {
        MapTextureView mapTextureView;
        int i4;
        int i5;
        MapSurfaceView mapSurfaceView;
        int i6;
        int i7;
        if (this.f9219g == null) {
            return;
        }
        WeakReference<MapSurfaceView> weakReference = this.f9217e;
        if (weakReference != null && (mapSurfaceView = weakReference.get()) != null && (i6 = this.f9221i) > 0 && (i7 = this.f9222j) > 0) {
            MapTaskManager.postToMainThread(new b(mapSurfaceView.captureImageFromSurface(this.f9223k, this.f9224l, i6, i7, obj, this.f9225m)), 0L);
        }
        WeakReference<MapTextureView> weakReference2 = this.f9218f;
        if (weakReference2 == null || (mapTextureView = weakReference2.get()) == null || (i4 = this.f9221i) <= 0 || (i5 = this.f9222j) <= 0) {
            return;
        }
        MapTaskManager.postToMainThread(new c(mapTextureView.captureImageFromSurface(this.f9223k, this.f9224l, i4, i5, obj, this.f9225m)), 0L);
    }

    public j(MapTextureView mapTextureView, u uVar) {
        this.f9218f = new WeakReference<>(mapTextureView);
        this.f9216d = uVar;
    }

    public void a(CaptureMapViewListener captureMapViewListener, int i4, int i5) {
        this.f9220h = true;
        this.f9219g = captureMapViewListener;
        this.f9221i = i4;
        this.f9222j = i5;
        this.f9225m = null;
    }

    public void a(CaptureMapViewListener captureMapViewListener, int i4, int i5, Bitmap.Config config) {
        this.f9220h = true;
        this.f9219g = captureMapViewListener;
        this.f9221i = i4;
        this.f9222j = i5;
        this.f9225m = config;
    }

    public void a(CaptureMapViewListener captureMapViewListener, int i4, int i5, int i6, int i7, Bitmap.Config config) {
        this.f9220h = true;
        this.f9219g = captureMapViewListener;
        this.f9223k = i4;
        this.f9224l = i5;
        this.f9221i = i6;
        this.f9222j = i7;
        this.f9225m = config;
    }

    public void a(d dVar) {
        this.f9226n = dVar;
    }
}
