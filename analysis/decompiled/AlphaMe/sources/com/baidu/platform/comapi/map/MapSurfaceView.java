package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.s;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
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
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MapSurfaceView extends t implements View.OnKeyListener, MapViewInterface, MapRenderModeChangeListener, u {

    /* renamed from: b, reason: collision with root package name */
    private static int f8955b;

    /* renamed from: c, reason: collision with root package name */
    private static final ExecutorService f8956c = Executors.newSingleThreadExecutor();

    /* renamed from: A, reason: collision with root package name */
    protected com.baidu.mapsdkplatform.comapi.map.b f8957A;

    /* renamed from: B, reason: collision with root package name */
    private float f8958B;

    /* renamed from: C, reason: collision with root package name */
    private float f8959C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f8960D;

    /* renamed from: E, reason: collision with root package name */
    private int f8961E;

    /* renamed from: F, reason: collision with root package name */
    private int f8962F;

    /* renamed from: G, reason: collision with root package name */
    private int f8963G;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f8964d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f8965e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f8966f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f8967g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8968h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8969i;

    /* renamed from: j, reason: collision with root package name */
    protected MapController f8970j;

    /* renamed from: k, reason: collision with root package name */
    protected p f8971k;

    /* renamed from: l, reason: collision with root package name */
    protected h f8972l;

    /* renamed from: m, reason: collision with root package name */
    protected j f8973m;

    /* renamed from: n, reason: collision with root package name */
    private LocationOverlay f8974n;

    /* renamed from: o, reason: collision with root package name */
    protected volatile boolean f8975o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8976p;

    /* renamed from: q, reason: collision with root package name */
    private List<BmLayer> f8977q;

    /* renamed from: r, reason: collision with root package name */
    private List<Overlay> f8978r;

    /* renamed from: s, reason: collision with root package name */
    private int f8979s;

    /* renamed from: t, reason: collision with root package name */
    private int f8980t;

    /* renamed from: u, reason: collision with root package name */
    private HashSet<m> f8981u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f8982v;

    /* renamed from: w, reason: collision with root package name */
    protected x f8983w;

    /* renamed from: x, reason: collision with root package name */
    protected GestureDetector f8984x;

    /* renamed from: y, reason: collision with root package name */
    protected n f8985y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f8986z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.f8970j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowSatelliteMap(MapSurfaceView.this.f8965e);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.f8970j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowTrafficMap(MapSurfaceView.this.f8964d);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.f8970j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowTrafficMap(MapSurfaceView.this.f8964d);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.f8970j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowStreetRoadMap(MapSurfaceView.this.f8966f);
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8991a;

        public e(boolean z4) {
            this.f8991a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.f8970j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowBaseIndoorMap(this.f8991a);
        }
    }

    public class g extends GestureDetector.SimpleOnGestureListener {
        private g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            GeoPoint geoPointFromPixels;
            BmDrawItem bmDrawItemA;
            List<v> list;
            super.onLongPress(motionEvent);
            MapController mapController = MapSurfaceView.this.f8970j;
            if (mapController == null || mapController.getBaseMap() == null) {
                return;
            }
            MapController mapController2 = MapSurfaceView.this.f8970j;
            if (mapController2.mIsMapLoadFinish) {
                String strGetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapSurfaceView.this.f8970j.nearlyRadius);
                if (strGetNearlyObjID != null && !strGetNearlyObjID.equals("")) {
                    MapSurfaceView mapSurfaceView = MapSurfaceView.this;
                    if (mapSurfaceView.f8970j.mListeners != null) {
                        geoPointFromPixels = mapSurfaceView.getProjection() != null ? MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                        for (v vVar : MapSurfaceView.this.f8970j.mListeners) {
                            if (vVar != null) {
                                if (vVar.a(strGetNearlyObjID)) {
                                    MapSurfaceView.this.f8970j.mHasMapObjDraging = true;
                                } else if (geoPointFromPixels != null) {
                                    vVar.d(geoPointFromPixels);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                if (OverlayUtil.isOverlayUpgrade() && MapSurfaceView.this.f8977q != null && !MapSurfaceView.this.f8977q.isEmpty() && (bmDrawItemA = ((BmLayer) MapSurfaceView.this.f8977q.get(0)).a((int) motionEvent.getX(), (int) motionEvent.getY(), MapSurfaceView.this.f8970j.nearlyRadius)) != null && (list = MapSurfaceView.this.f8970j.mListeners) != null) {
                    for (v vVar2 : list) {
                        if (vVar2 != null && vVar2.a(bmDrawItemA)) {
                            MapSurfaceView.this.f8970j.mHasBmDrawItemDraging = true;
                        }
                    }
                }
                MapSurfaceView mapSurfaceView2 = MapSurfaceView.this;
                if (mapSurfaceView2.f8970j.mListeners != null) {
                    geoPointFromPixels = mapSurfaceView2.getProjection() != null ? MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                    if (geoPointFromPixels == null) {
                        return;
                    }
                    for (v vVar3 : MapSurfaceView.this.f8970j.mListeners) {
                        if (vVar3 != null) {
                            vVar3.d(geoPointFromPixels);
                        }
                    }
                }
            }
        }

        public /* synthetic */ g(MapSurfaceView mapSurfaceView, a aVar) {
            this();
        }
    }

    public MapSurfaceView(Context context) {
        super(context);
        this.f8964d = false;
        this.f8965e = false;
        this.f8966f = false;
        this.f8967g = true;
        this.f8968h = true;
        this.f8969i = true;
        this.f8970j = null;
        this.f8971k = null;
        this.f8972l = null;
        this.f8975o = false;
        this.f8976p = true;
        this.f8977q = new ArrayList();
        this.f8978r = new ArrayList();
        this.f8979s = 0;
        this.f8980t = 0;
        this.f8981u = new HashSet<>();
        this.f8982v = true;
        this.f8986z = true;
        this.f8960D = false;
        this.f8961E = 0;
        this.f8962F = 0;
        this.f8963G = 0;
        f8955b++;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        return addBmLayerBelow(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        return overlay != null ? addBmLayerBelow(overlay.mLayerID, bmLayer) : addBmLayerBelow(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean addOverlay(Overlay overlay) {
        MapController mapController;
        if (overlay != null) {
            try {
                mapController = this.f8970j;
            } catch (Throwable th) {
                throw th;
            }
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                if (overlay instanceof InnerOverlay) {
                    InnerOverlay innerOverlay = (InnerOverlay) overlay;
                    if (innerOverlay.mBaseMap == null) {
                        innerOverlay.mBaseMap = getController().getBaseMap();
                    }
                    if (!innerOverlay.addedToMapView()) {
                        return false;
                    }
                    synchronized (this) {
                        this.f8978r.add(overlay);
                        this.f8971k.a((InnerOverlay) overlay);
                    }
                    return true;
                }
                if (!(overlay instanceof ItemizedOverlay)) {
                    return false;
                }
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                long jAddLayer = baseMap.AddLayer(itemizedOverlay.getUpdateType(), 0, MapController.ITEM_LAYER_TAG);
                overlay.mLayerID = jAddLayer;
                if (jAddLayer == 0) {
                    return false;
                }
                synchronized (this) {
                    this.f8978r.add(overlay);
                    itemizedOverlay.c();
                    baseMap.SetLayersClickable(overlay.mLayerID, true);
                    baseMap.ShowLayers(overlay.mLayerID, true);
                    baseMap.UpdateLayers(overlay.mLayerID);
                }
                return true;
                throw th;
            }
        }
        return false;
    }

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.f8983w.a(simpleOnGestureListener);
    }

    public void addStateListener(m mVar) {
        if (mVar != null) {
            this.f8981u.add(mVar);
        }
    }

    public void animateTo(MapStatus mapStatus, int i4) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i4);
        }
    }

    public void beginLocationLayerAnimation() {
        LocationOverlay locationOverlay = this.f8974n;
        if (locationOverlay != null) {
            locationOverlay.beginLocationLayerAnimation();
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ Bitmap captureImageFromSurface(int i4, int i5, int i6, int i7, Object obj, Bitmap.Config config) {
        return super.captureImageFromSurface(i4, i5, i6, i7, obj, config);
    }

    public void clearDefaultLocationLayerData(Bundle bundle) {
        this.f8974n.clearLocationLayerData(bundle);
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int i4, int i5) {
        this.f8973m.a(captureMapViewListener, i4, i5);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return true;
    }

    public void forceSetTraffic(boolean z4) {
        if (this.f8970j != null) {
            this.f8964d = z4;
        }
        f8956c.submit(new b());
    }

    public com.baidu.mapsdkplatform.comapi.map.b getBaseMap() {
        return this.f8957A;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.f8977q;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.f8970j;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            return mapController.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController mapController = this.f8970j;
        return mapController != null ? mapController.getCurrentZoomLevel() : Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    public LocationOverlay getDefaultLocationLay() {
        return this.f8974n;
    }

    public int getFPS() {
        return this.f9253a.getFPS();
    }

    public float getFZoomToBoundF(MapBound mapBound, MapBound mapBound2) {
        if (this.f8970j == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ViewTweenItem.LEFT, mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(ViewTweenItem.TOP, mapBound.rightTopPt.getIntY());
        Bundle bundle2 = new Bundle();
        bundle2.putInt(ViewTweenItem.LEFT, mapBound2.leftBottomPt.getIntX());
        bundle2.putInt("bottom", mapBound2.leftBottomPt.getIntY());
        bundle2.putInt("right", mapBound2.rightTopPt.getIntX());
        bundle2.putInt(ViewTweenItem.TOP, mapBound2.rightTopPt.getIntY());
        return this.f8970j.GetFZoomToBoundF(bundle, bundle2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().geoRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        MapStatus mapStatus = getMapStatus();
        h hVar = (h) getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint geoPointFromPixels = hVar.fromPixels(winRound.left, winRound.top);
        MapStatus.WinRound winRound2 = mapStatus.winRound;
        return (int) Math.abs(geoPointFromPixels.getLatitude() - hVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLatitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        MapStatus mapStatus = getMapStatus();
        h hVar = (h) getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint geoPointFromPixels = hVar.fromPixels(winRound.left, winRound.top);
        MapStatus.WinRound winRound2 = mapStatus.winRound;
        return (int) Math.abs(hVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLongitude() - geoPointFromPixels.getLongitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return null;
        }
        MapStatus mapStatus = mapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            return mapController.getMapStatus();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            return mapController.getMapViewListener();
        }
        return null;
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.f8983w.a();
    }

    public synchronized Overlay getOverlay(int i4) {
        if (i4 == 21) {
            return null;
        }
        for (Overlay overlay : this.f8978r) {
            if (overlay.mType == i4) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.f8978r;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public double getOverlooking() {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return 0.0d;
        }
        return mapController.getMapStatus().overlooking;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.f8972l;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ r getRenderControl() {
        return super.getRenderControl();
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    public ExecutorService getSingleThreadPool() {
        return f8956c;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ s.a getViewType() {
        return super.getViewType();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController mapController = this.f8970j;
        return mapController != null ? mapController.getZoomLevel() : Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        SysOSUtil sysOSUtil = SysOSUtil.getInstance();
        return getZoomToBound(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i4, int i5) {
        if (this.f8970j == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ViewTweenItem.LEFT, mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(ViewTweenItem.TOP, mapBound.rightTopPt.getIntY());
        return this.f8970j.getZoomToBoundF(bundle);
    }

    public double getZoomUnitsInMeter() {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            return mapController.getZoomUnitsInMeter();
        }
        return 0.0d;
    }

    public boolean inRangeOfView(float f4, float f5) {
        float f6 = 0;
        return f4 >= f6 && f4 <= ((float) this.f8979s) && f5 >= f6 && f5 <= ((float) this.f8980t);
    }

    public synchronized boolean insertOverlay(Overlay overlay, int i4) {
        MapController mapController;
        try {
            if ((overlay instanceof InnerOverlay) && (mapController = this.f8970j) != null) {
                InnerOverlay innerOverlay = (InnerOverlay) overlay;
                if (innerOverlay.mBaseMap == null) {
                    innerOverlay.mBaseMap = mapController.getBaseMap();
                }
                this.f8978r.add(overlay);
                this.f8971k.a(innerOverlay);
            }
        } catch (Throwable th) {
            throw th;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return this.f8967g;
    }

    public boolean isPredictTraffic() {
        return this.f8961E > 0 || this.f8962F > 0 || this.f8963G > 0;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return this.f8965e;
    }

    public boolean isSetBackgroundDraw() {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return false;
        }
        return mapController.isSetBackgroundDraw();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return this.f8966f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return this.f8964d;
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
    }

    public void onBackground() {
        onBackground(false);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.onDetachedFromWindow();
    }

    public void onForeground() {
        onForeground(false);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (this != view || keyEvent.getAction() != 0) {
            return false;
        }
        switch (i4) {
            case 19:
                this.f8970j.scrollBy(0, -50);
                break;
            case 20:
                this.f8970j.scrollBy(0, 50);
                break;
            case 21:
                this.f8970j.scrollBy(-50, 0);
                break;
            case 22:
                this.f8970j.scrollBy(50, 0);
                break;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i4) {
        n nVar;
        if (i4 == 1) {
            requestRender();
            return;
        }
        if (i4 == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else {
            if (i4 != 2 || (nVar = this.f8985y) == null) {
                return;
            }
            nVar.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public void onPause() {
        if (this.f8968h) {
            return;
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onPause");
        }
        j jVar = this.f8973m;
        if (jVar != null) {
            jVar.b();
        }
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.onPause();
        }
        Iterator<m> it = this.f8981u.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        super.onPause();
        this.f8968h = true;
    }

    public void onRecycle() {
        MapController mapController = this.f8970j;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.f8970j.getBaseMap().ResetImageRes();
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        requestRender();
    }

    @Override // com.baidu.platform.comapi.map.t
    public void onResume() {
        if (this.f8968h) {
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onResume isInited = " + this.f8975o);
            }
            if (this.f8975o) {
                j jVar = this.f8973m;
                if (jVar != null) {
                    jVar.c();
                }
                MapController mapController = this.f8970j;
                if (mapController != null) {
                    mapController.onResume();
                }
                Iterator<m> it = this.f8981u.iterator();
                while (it.hasNext()) {
                    it.next().a(this);
                }
                setRenderMode(1);
                super.onResume();
                this.f8968h = false;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f8958B = i4;
        this.f8959C = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L54
            r3 = 2
            if (r0 == r3) goto Lc
            goto L56
        Lc:
            float r0 = r10.getX()
            float r3 = r10.getY()
            r4 = 0
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 < 0) goto L2a
            float r5 = r9.f8958B
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L2a
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 < 0) goto L2a
            float r0 = r9.f8959C
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L2a
            goto L56
        L2a:
            boolean r0 = r9.f8960D
            if (r0 != 0) goto L56
            com.baidu.mapsdkplatform.comapi.map.b r0 = r9.f8957A
            if (r0 == 0) goto L56
            java.util.List<com.baidu.platform.comapi.map.v> r0 = r0.f8020v
            if (r0 == 0) goto L56
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L56
            java.lang.Object r3 = r0.next()
            com.baidu.platform.comapi.map.v r3 = (com.baidu.platform.comapi.map.v) r3
            if (r3 == 0) goto L3a
            com.baidu.mapsdkplatform.comapi.map.b r4 = r9.f8957A
            com.baidu.mapsdkplatform.comapi.map.s r4 = r4.y()
            r3.a(r4)
            r9.f8960D = r2
            goto L3a
        L54:
            r9.f8960D = r1
        L56:
            com.baidu.platform.comapi.map.MapStatus r0 = r9.getMapStatus()
            int r3 = r10.getPointerCount()
            r4 = r1
        L5f:
            if (r4 >= r3) goto L92
            float r5 = r10.getX(r4)
            int r5 = (int) r5
            float r6 = r10.getY(r4)
            int r6 = (int) r6
            if (r0 == 0) goto L7f
            com.baidu.platform.comapi.map.MapStatus$WinRound r7 = r0.winRound
            int r8 = r7.left
            if (r5 < r8) goto L7f
            int r8 = r7.right
            if (r5 > r8) goto L7f
            int r5 = r7.top
            if (r6 < r5) goto L7f
            int r5 = r7.bottom
            if (r6 <= r5) goto L8f
        L7f:
            int r5 = r10.getAction()
            r6 = 262(0x106, float:3.67E-43)
            if (r5 == r6) goto L8f
            int r5 = r10.getAction()
            r6 = 6
            if (r5 == r6) goto L8f
            return r1
        L8f:
            int r4 = r4 + 1
            goto L5f
        L92:
            android.view.GestureDetector r0 = r9.f8984x     // Catch: java.lang.Exception -> Lad
            if (r0 == 0) goto L9d
            boolean r0 = r0.onTouchEvent(r10)     // Catch: java.lang.Exception -> Lad
            if (r0 == 0) goto L9d
            return r2
        L9d:
            com.baidu.platform.comapi.map.MapController r0 = r9.f8970j     // Catch: java.lang.Exception -> Lad
            if (r0 == 0) goto La8
            boolean r0 = r0.handleTouchEvent(r10)     // Catch: java.lang.Exception -> Lad
            if (r0 == 0) goto La8
            return r2
        La8:
            boolean r9 = super.onTouchEvent(r10)
            return r9
        Lad:
            boolean r9 = super.onTouchEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapSurfaceView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void queueEvent(Runnable runnable) {
        super.queueEvent(runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay == null || this.f8970j == null) {
            return;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            if (itemizedOverlay.b()) {
                if (itemizedOverlay.getAllItem().size() <= 0) {
                    this.f8970j.getBaseMap().ClearLayer(overlay.mLayerID);
                    this.f8970j.getBaseMap().ShowLayers(overlay.mLayerID, false);
                    this.f8970j.getBaseMap().UpdateLayers(overlay.mLayerID);
                } else {
                    this.f8970j.getBaseMap().ShowLayers(overlay.mLayerID, true);
                    this.f8970j.getBaseMap().UpdateLayers(overlay.mLayerID);
                }
                itemizedOverlay.b(false);
            }
        }
        MapController mapController = this.f8970j;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.f8970j.getBaseMap().UpdateLayers(overlay.mLayerID);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.f8970j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.removeBmLayer(bmLayer.getNativeInstance());
                synchronized (this) {
                    this.f8977q.remove(bmLayer);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeOverlay(Overlay overlay) {
        if (overlay != null) {
            MapController mapController = this.f8970j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.ClearLayer(overlay.mLayerID);
                baseMap.ShowLayers(overlay.mLayerID, false);
                baseMap.UpdateLayers(overlay.mLayerID);
                baseMap.RemoveLayer(overlay.mLayerID);
                synchronized (this) {
                    try {
                        if (overlay instanceof ItemizedOverlay) {
                            this.f8978r.remove(overlay);
                        } else if (overlay instanceof InnerOverlay) {
                            this.f8978r.remove(overlay);
                            this.f8971k.a(overlay);
                        }
                        overlay.mLayerID = 0L;
                    } finally {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.f8983w.b(simpleOnGestureListener);
    }

    public void removeStateListener(m mVar) {
        if (mVar != null) {
            this.f8981u.remove(mVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void requestRender() {
        super.requestRender();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) throws JSONException {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.saveScreenToLocal(str);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z4) {
        if (this.f8970j != null) {
            this.f8967g = z4;
        }
        f8956c.submit(new e(z4));
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.f8957A = bVar;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setDebugFlags(int i4) {
        super.setDebugFlags(i4);
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> list) {
        this.f8974n.setLocationLayerData(list);
    }

    public void setFPS(int i4) {
        this.f9253a.setFPS(i4);
    }

    public void setFirstFrameListener(com.baidu.platform.comapi.map.d dVar) {
        j jVar = this.f8973m;
        if (jVar != null) {
            jVar.a(dVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.f8984x = gestureDetector;
    }

    public boolean setItsPreTime(int i4, int i5, int i6) {
        AppBaseMap baseMap;
        if (this.f8961E == i4 && this.f8962F == i5 && this.f8963G == i6) {
            return true;
        }
        MapController mapController = this.f8970j;
        if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        this.f8961E = i4;
        this.f8962F = i5;
        this.f8963G = i6;
        return baseMap.SetItsPreTime(i4, i5, i6);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.f8970j.setMapStatus(mapStatus);
        }
    }

    public void setMapController(MapController mapController) {
        if (this.f8970j != null) {
            return;
        }
        this.f8970j = mapController;
        this.f8973m.a(mapController.getBaseMap());
        this.f8973m.a(true);
        p pVar = new p(this.f8970j.getBaseMap());
        this.f8971k = pVar;
        this.f8970j.setOverlayMapCallBack(pVar);
        this.f8970j.setMapViewInterface(this);
        b();
        this.f8970j.setMapRenderModeChangeListener(this);
        this.f8975o = true;
        this.f8972l = new h(this.f8970j);
        this.f8983w.a(this.f8970j);
    }

    public void setMapRenderStableListener(n nVar) {
        this.f8985y = nVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z4) {
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.f8983w.a(onLongPressListener);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i4) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i4;
            this.f8970j.setMapStatus(mapStatus);
        }
    }

    public void setPixelFormatTransparent(boolean z4) {
        if (z4) {
            getHolder().setFormat(-3);
        } else {
            getHolder().setFormat(-1);
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setRenderMode(int i4) {
        super.setRenderMode(i4);
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setRenderer(SurfaceRenderer surfaceRenderer) {
        super.setRenderer(surfaceRenderer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i4) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i4;
            this.f8970j.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z4) {
        if (this.f8970j != null) {
            this.f8965e = z4;
        }
        f8956c.submit(new a());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z4) {
        if (this.f8970j != null) {
            this.f8966f = z4;
        }
        f8956c.submit(new d());
    }

    public void setSupBackgroundDraw(boolean z4) {
        MapController mapController = this.f8970j;
        if (mapController == null) {
            return;
        }
        mapController.setSupBackgroundDraw(z4);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z4) {
        if (this.f8964d == z4) {
            return;
        }
        if (this.f8970j != null) {
            this.f8964d = z4;
        }
        f8956c.submit(new c());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.f8970j.setMapStatus(mapStatus);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[PHI: r0
      0x0012: PHI (r0v6 float) = (r0v2 float), (r0v4 float) binds: [B:6:0x0010, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.baidu.platform.comapi.map.MapViewInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setZoomLevel(float r3) {
        /*
            r2 = this;
            com.baidu.platform.comapi.map.MapController r0 = r2.f8970j
            if (r0 != 0) goto L5
            return
        L5:
            com.baidu.platform.comapi.map.MapController r0 = r2.getController()
            r0.getFocusedBaseIndoorMapInfo()
            r0 = 1082130432(0x40800000, float:4.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L14
        L12:
            r3 = r0
            goto L1c
        L14:
            r0 = 22
            float r0 = (float) r0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L1c
            goto L12
        L1c:
            com.baidu.platform.comapi.map.MapStatus r0 = r2.getMapStatus()
            if (r0 == 0) goto L29
            r0.level = r3
            r3 = 300(0x12c, float:4.2E-43)
            r2.animateTo(r0, r3)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.MapSurfaceView.setZoomLevel(float):void");
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        j jVar = this.f8973m;
        if (jVar != null) {
            jVar.f9234v = i5;
            jVar.f9235w = i6;
            jVar.f9236x = 0;
        }
        this.f8979s = i5;
        this.f8980t = i6;
        super.surfaceChanged(surfaceHolder, i4, i5, i6);
        if (this.f8970j != null) {
            MapStatus mapStatus = getMapStatus();
            if (mapStatus != null) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                winRound.left = 0;
                winRound.top = 0;
                winRound.bottom = i6;
                winRound.right = i5;
                if (this.f8976p) {
                    this.f8976p = false;
                    this.f8970j.setMapStatusWithAnimation(mapStatus, 4, 0);
                } else {
                    this.f8970j.setMapStatus(mapStatus, false);
                }
                if (this.f8970j.getMapViewSurfaceListener() != null) {
                    this.f8970j.getMapViewSurfaceListener().onSurfaceChanged(i5, i6);
                }
            }
            MapStatus mapStatus2 = getMapStatus();
            MapStatus.WinRound winRound2 = mapStatus2.winRound;
            int iAbs = Math.abs(winRound2.right - winRound2.left);
            MapStatus.WinRound winRound3 = mapStatus2.winRound;
            int iAbs2 = Math.abs(winRound3.bottom - winRound3.top);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a aVarA = com.baidu.mapsdkplatform.comapi.commonutils.a.a();
                StringBuilder sbU = B0.g.u("MapSurfaceView winRoundWidth = ", iAbs, ";winRoundHeight = ", iAbs2, ";mWidth = ");
                sbU.append(this.f8979s);
                sbU.append(";mHeight = ");
                sbU.append(this.f8980t);
                aVarA.a(sbU.toString());
            }
            if (iAbs > 0 && iAbs2 > 0) {
                this.f8979s = iAbs;
                this.f8980t = iAbs2;
            }
            this.f8970j.setScreenSize(this.f8979s, this.f8980t);
            if (this.f8970j.isNaviMode() && this.f8970j.getNaviMapViewListener() != null) {
                this.f8970j.getNaviMapViewListener().resizeScreen(i5, i6);
            }
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f8957A;
        if (bVar != null) {
            bVar.b(this.f8979s, this.f8980t);
        }
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder == null || surfaceHolder.getSurface().isValid()) {
            return;
        }
        surfaceDestroyed(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.surfaceDestroyed(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback2
    @Deprecated
    public /* bridge */ /* synthetic */ void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        super.surfaceRedrawNeeded(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback2
    @TargetApi(26)
    public /* bridge */ /* synthetic */ void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        super.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || (mapController = this.f8970j) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unInit() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f8957A;
        if (bVar != null) {
            List<v> list = bVar.f8020v;
            if (list != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a();
                    }
                }
            }
            this.f8957A.h();
            this.f8957A = null;
        }
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.unInit();
        }
        this.f8970j = null;
        p pVar = this.f8971k;
        if (pVar != null) {
            pVar.a();
        }
        this.f8971k = null;
        this.f8972l = null;
        this.f8973m = null;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView unInit");
        }
    }

    public class f implements e.g {

        /* renamed from: a, reason: collision with root package name */
        private int f8993a;

        private f() {
            this.f8993a = 12440;
        }

        public String a(String str, int i4) {
            StringBuilder sbV = B0.g.v(str, " failed: ");
            sbV.append(a(i4));
            return sbV.toString();
        }

        public void b(String str, int i4) {
            throw new RuntimeException(a(str, i4));
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f8993a, 2, 12344});
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext != null && eGLDisplay != null) {
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    Log.e("MapContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                    b("eglDestroyContex", egl10.eglGetError());
                }
            }
            MapSurfaceView.this.onRecycle();
        }

        public /* synthetic */ f(MapSurfaceView mapSurfaceView, a aVar) {
            this();
        }

        private String b(int i4) {
            return "0x" + Integer.toHexString(i4);
        }

        private String a(int i4) {
            switch (i4) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i4);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public r a(s.a aVar, boolean z4, Context context) {
        r rVarA = super.a(aVar, z4, context);
        if (rVarA instanceof com.baidu.platform.comapi.map.e) {
            com.baidu.platform.comapi.map.e eVar = (com.baidu.platform.comapi.map.e) rVarA;
            if (this.f8986z) {
                eVar.a(new f(this, null));
            }
        }
        return rVarA;
    }

    public void b() {
        MapController mapController = this.f8970j;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        a();
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int i4, int i5, Bitmap.Config config) {
        this.f8973m.a(captureMapViewListener, i4, i5, config);
    }

    public void onBackground(boolean z4) {
        if (z4 || !this.f8969i) {
            MapController mapController = this.f8970j;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.f8970j.getBaseMap().OnBackground();
            }
            this.f8969i = true;
        }
    }

    public void onForeground(boolean z4) {
        if (z4 || this.f8969i) {
            MapController mapController = this.f8970j;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.f8970j.getBaseMap().OnForeground();
            }
            this.f8969i = false;
            if (this.f9253a.getViewType() == s.a.VULKAN) {
                j jVar = this.f8973m;
                if (jVar != null) {
                    jVar.c();
                }
                super.onResume();
            }
        }
    }

    public synchronized boolean addBmLayerBelow(long j4, BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.f8970j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                synchronized (this) {
                    if (this.f8977q.contains(bmLayer)) {
                        return false;
                    }
                    this.f8977q.add(bmLayer);
                    return baseMap.addBmLayerBelow(j4, bmLayer.getNativeInstance(), 1, 0);
                }
            }
        }
        return false;
    }

    public void animateTo(MapStatus mapStatus, int i4, int i5) {
        MapController mapController = this.f8970j;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i4, i5);
        }
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i4 = rect.left;
            int i5 = this.f8980t;
            int i6 = rect.bottom;
            int i7 = i5 < i6 ? 0 : i5 - i6;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i4 < 0 || i7 < 0 || iWidth <= 0 || iHeight <= 0) {
                return;
            }
            if (iWidth > this.f8979s) {
                iWidth = Math.abs(rect.width()) - (rect.right - this.f8979s);
            }
            int i8 = iWidth;
            int iAbs = iHeight > this.f8980t ? Math.abs(rect.height()) - (rect.bottom - this.f8980t) : iHeight;
            if (i4 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeX() || i7 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.f8973m.a(captureMapViewListener, i4, i7, i8, iAbs, config);
            requestRender();
        }
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        for (Overlay overlay : this.f8978r) {
            if (overlay.getClass() == cls) {
                return overlay;
            }
        }
        return null;
    }

    public void saveScreenToLocal(String str, Rect rect) throws JSONException {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f8957A;
        if (bVar == null || bVar.i() == null) {
            return;
        }
        String string = null;
        if (rect != null) {
            int i4 = rect.left;
            int i5 = this.f8980t;
            int i6 = rect.bottom;
            int i7 = i5 < i6 ? 0 : i5 - i6;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i4 < 0 || i7 < 0 || iWidth <= 0 || iHeight <= 0) {
                return;
            }
            if (iWidth > this.f8979s) {
                iWidth = Math.abs(rect.width()) - (rect.right - this.f8979s);
            }
            if (iHeight > this.f8980t) {
                iHeight = Math.abs(rect.height()) - (rect.bottom - this.f8980t);
            }
            if (i4 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX() && i7 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
                if (iWidth != 0 && iHeight != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", i4);
                        jSONObject.put("y", i7);
                        jSONObject.put("width", iWidth);
                        jSONObject.put("height", iHeight);
                        string = jSONObject.toString();
                    } catch (Exception unused) {
                    }
                }
                this.f8957A.i().SaveScreenToLocal(str, string);
                return;
            }
            this.f8957A.i().SaveScreenToLocal(str, null);
            return;
        }
        this.f8957A.i().SaveScreenToLocal(str, null);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i4, int i5) {
        if (this.f8970j == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ViewTweenItem.LEFT, mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(ViewTweenItem.TOP, mapBound.rightTopPt.getIntY());
        return this.f8970j.getZoomToBound(bundle, i4, i5);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i4) {
        setZoomLevel(i4);
    }

    @Override // com.baidu.platform.comapi.map.t
    public void a(Context context, s.a aVar, boolean z4) {
        super.a(context, aVar, z4);
        setBackgroundColor(Color.rgb(244, 242, 240));
        setPixelFormatTransparent(false);
        this.f8983w = new x();
        this.f8984x = new GestureDetector(context, this.f8983w);
        j jVar = new j((WeakReference<MapSurfaceView>) new WeakReference(this), this);
        this.f8973m = jVar;
        setRenderer(jVar);
        setRenderMode(1);
        this.f8983w.a(new g(this, null));
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView initView");
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        SysOSUtil sysOSUtil = SysOSUtil.getInstance();
        return getZoomToBoundF(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    public void a() {
        MapController mapController = this.f8970j;
        if (mapController == null || mapController.getBaseMap() == null || this.f8971k == null) {
            return;
        }
        this.f8978r.clear();
        this.f8971k.a();
    }

    public MapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8964d = false;
        this.f8965e = false;
        this.f8966f = false;
        this.f8967g = true;
        this.f8968h = true;
        this.f8969i = true;
        this.f8970j = null;
        this.f8971k = null;
        this.f8972l = null;
        this.f8975o = false;
        this.f8976p = true;
        this.f8977q = new ArrayList();
        this.f8978r = new ArrayList();
        this.f8979s = 0;
        this.f8980t = 0;
        this.f8981u = new HashSet<>();
        this.f8982v = true;
        this.f8986z = true;
        this.f8960D = false;
        this.f8961E = 0;
        this.f8962F = 0;
        this.f8963G = 0;
        f8955b++;
    }

    public MapSurfaceView(Context context, s.a aVar) {
        super(context, aVar);
        this.f8964d = false;
        this.f8965e = false;
        this.f8966f = false;
        this.f8967g = true;
        this.f8968h = true;
        this.f8969i = true;
        this.f8970j = null;
        this.f8971k = null;
        this.f8972l = null;
        this.f8975o = false;
        this.f8976p = true;
        this.f8977q = new ArrayList();
        this.f8978r = new ArrayList();
        this.f8979s = 0;
        this.f8980t = 0;
        this.f8981u = new HashSet<>();
        this.f8982v = true;
        this.f8986z = true;
        this.f8960D = false;
        this.f8961E = 0;
        this.f8962F = 0;
        this.f8963G = 0;
        f8955b++;
    }

    public MapSurfaceView(Context context, s.a aVar, boolean z4) {
        super(context, aVar, z4);
        this.f8964d = false;
        this.f8965e = false;
        this.f8966f = false;
        this.f8967g = true;
        this.f8968h = true;
        this.f8969i = true;
        this.f8970j = null;
        this.f8971k = null;
        this.f8972l = null;
        this.f8975o = false;
        this.f8976p = true;
        this.f8977q = new ArrayList();
        this.f8978r = new ArrayList();
        this.f8979s = 0;
        this.f8980t = 0;
        this.f8981u = new HashSet<>();
        this.f8982v = true;
        this.f8986z = true;
        this.f8960D = false;
        this.f8961E = 0;
        this.f8962F = 0;
        this.f8963G = 0;
        f8955b++;
    }

    public MapSurfaceView(Context context, boolean z4) {
        super(context, z4);
        this.f8964d = false;
        this.f8965e = false;
        this.f8966f = false;
        this.f8967g = true;
        this.f8968h = true;
        this.f8969i = true;
        this.f8970j = null;
        this.f8971k = null;
        this.f8972l = null;
        this.f8975o = false;
        this.f8976p = true;
        this.f8977q = new ArrayList();
        this.f8978r = new ArrayList();
        this.f8979s = 0;
        this.f8980t = 0;
        this.f8981u = new HashSet<>();
        this.f8982v = true;
        this.f8986z = true;
        this.f8960D = false;
        this.f8961E = 0;
        this.f8962F = 0;
        this.f8963G = 0;
        f8955b++;
    }
}
