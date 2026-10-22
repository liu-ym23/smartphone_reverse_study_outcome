package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONException;

/* loaded from: classes.dex */
public class MapTextureView extends GLTextureView implements MapRenderModeChangeListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, MapViewInterface, u {

    /* renamed from: A, reason: collision with root package name */
    private boolean f8996A;

    /* renamed from: B, reason: collision with root package name */
    private d f8997B;

    /* renamed from: C, reason: collision with root package name */
    private float f8998C;

    /* renamed from: D, reason: collision with root package name */
    private float f8999D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f9000E;

    /* renamed from: o, reason: collision with root package name */
    protected com.baidu.mapsdkplatform.comapi.map.b f9001o;

    /* renamed from: p, reason: collision with root package name */
    protected MapController f9002p;

    /* renamed from: q, reason: collision with root package name */
    protected p f9003q;

    /* renamed from: r, reason: collision with root package name */
    protected h f9004r;

    /* renamed from: s, reason: collision with root package name */
    protected j f9005s;

    /* renamed from: t, reason: collision with root package name */
    int f9006t;

    /* renamed from: u, reason: collision with root package name */
    int f9007u;

    /* renamed from: v, reason: collision with root package name */
    private List<BmLayer> f9008v;

    /* renamed from: w, reason: collision with root package name */
    protected List<Overlay> f9009w;

    /* renamed from: x, reason: collision with root package name */
    protected n f9010x;

    /* renamed from: y, reason: collision with root package name */
    protected x f9011y;

    /* renamed from: z, reason: collision with root package name */
    protected GestureDetector f9012z;

    public class c extends GestureDetector.SimpleOnGestureListener {
        private c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            GeoPoint geoPointFromPixels;
            super.onLongPress(motionEvent);
            MapController mapController = MapTextureView.this.f9002p;
            if (mapController == null || mapController.getBaseMap() == null) {
                return;
            }
            MapController mapController2 = MapTextureView.this.f9002p;
            if (mapController2.mIsMapLoadFinish) {
                String strGetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapTextureView.this.f9002p.nearlyRadius);
                if (strGetNearlyObjID == null || strGetNearlyObjID.equals("")) {
                    MapTextureView mapTextureView = MapTextureView.this;
                    if (mapTextureView.f9002p.mListeners != null) {
                        geoPointFromPixels = mapTextureView.getProjection() != null ? MapTextureView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                        if (geoPointFromPixels == null) {
                            return;
                        }
                        for (v vVar : MapTextureView.this.f9002p.mListeners) {
                            if (vVar != null) {
                                vVar.d(geoPointFromPixels);
                            }
                        }
                        return;
                    }
                    return;
                }
                MapTextureView mapTextureView2 = MapTextureView.this;
                if (mapTextureView2.f9002p.mListeners != null) {
                    geoPointFromPixels = mapTextureView2.getProjection() != null ? MapTextureView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                    for (v vVar2 : MapTextureView.this.f9002p.mListeners) {
                        if (vVar2 != null) {
                            if (vVar2.a(strGetNearlyObjID)) {
                                MapTextureView.this.f9002p.mHasMapObjDraging = true;
                            } else if (geoPointFromPixels != null) {
                                vVar2.d(geoPointFromPixels);
                            }
                        }
                    }
                }
            }
        }
    }

    public interface d {
        void a(int i4);
    }

    public MapTextureView(Context context) {
        super(context);
        this.f9002p = null;
        this.f9003q = null;
        this.f9004r = null;
        this.f9005s = null;
        this.f9008v = new ArrayList();
        this.f9009w = new ArrayList();
        this.f8996A = true;
        this.f9000E = false;
        a(context);
    }

    private void a(Context context) {
        setEGLContextClientVersion(3);
        this.f9011y = new x();
        this.f9012z = new GestureDetector(context, this.f9011y);
        this.f9011y.a(new c());
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView initView");
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        return a(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        return overlay != null ? a(overlay.mLayerID, bmLayer) : a(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addOverlay(Overlay overlay) throws JSONException {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || (mapController = this.f9002p) == null || (baseMap = mapController.getBaseMap()) == null) {
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
            this.f9009w.add(overlay);
            this.f9003q.a(innerOverlay);
            return true;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            long jAddLayer = baseMap.AddLayer(itemizedOverlay.getUpdateType(), 0, MapController.ITEM_LAYER_TAG);
            overlay.mLayerID = jAddLayer;
            if (jAddLayer == 0) {
                return false;
            }
            this.f9009w.add(overlay);
            itemizedOverlay.c();
            baseMap.SetLayersClickable(overlay.mLayerID, true);
            baseMap.ShowLayers(overlay.mLayerID, true);
            baseMap.UpdateLayers(overlay.mLayerID);
            return true;
        }
        return false;
    }

    public void animateTo(MapStatus mapStatus, int i4) {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i4);
        }
    }

    public void attachBaseMapController(MapController mapController) {
        j jVar = new j(this, this);
        this.f9005s = jVar;
        this.f9002p = mapController;
        jVar.a(mapController.getBaseMap());
        setEGLContextFactory(new b());
        setRenderer(this.f9005s);
        setRenderMode(0);
        this.f9005s.a(true);
        setPreserveEGLContextOnPause(true);
        p pVar = new p(this.f9002p.getBaseMap());
        this.f9003q = pVar;
        this.f9002p.setOverlayMapCallBack(pVar);
        this.f9002p.setMapViewInterface(this);
        e();
        this.f9002p.setMapRenderModeChangeListener(this);
        this.f9004r = new h(this.f9002p);
        this.f9011y.a(this.f9002p);
    }

    public void d() {
        MapController mapController = this.f9002p;
        if (mapController == null || mapController.getBaseMap() == null || this.f9003q == null) {
            return;
        }
        this.f9009w.clear();
        this.f9003q.a();
    }

    public void destroyForMultiViews() {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            mapController.unInitForMultiTextureView();
            this.f9002p = null;
        }
        p pVar = this.f9003q;
        if (pVar != null) {
            pVar.a();
            this.f9003q = null;
        }
        this.f9004r = null;
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int i4, int i5, Bitmap.Config config) {
        this.f9005s.a(captureMapViewListener, i4, i5, config);
    }

    public void e() {
        MapController mapController = this.f9002p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        d();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return false;
    }

    public com.baidu.mapsdkplatform.comapi.map.b getBaseMap() {
        return this.f9001o;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.f9008v;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.f9002p;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            return mapController.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController mapController = this.f9002p;
        return mapController != null ? mapController.getCurrentZoomLevel() : Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController mapController = this.f9002p;
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
        MapController mapController = this.f9002p;
        if (mapController == null) {
            return null;
        }
        MapStatus mapStatus = mapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController mapController = this.f9002p;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            return mapController.getMapStatus();
        }
        return null;
    }

    public synchronized Overlay getOverlay(int i4) {
        for (Overlay overlay : this.f9009w) {
            if (overlay.mType == i4) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.f9009w;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public double getOverlooking() {
        MapController mapController = this.f9002p;
        if (mapController == null) {
            return 0.0d;
        }
        return mapController.getMapStatus().overlooking;
    }

    public Overlay getPopupOverlay() {
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.f9004r;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController mapController = this.f9002p;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController mapController = this.f9002p;
        return mapController != null ? mapController.getZoomLevel() : Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        return getZoomToBound(mapBound, this.f9006t, this.f9007u);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i4, int i5) {
        if (this.f9002p == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ViewTweenItem.LEFT, mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(ViewTweenItem.TOP, mapBound.rightTopPt.getIntY());
        return this.f9002p.getZoomToBoundF(bundle);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return false;
    }

    public boolean isSetBackgroundDraw() {
        MapController mapController = this.f9002p;
        if (mapController == null) {
            return false;
        }
        return mapController.isSetBackgroundDraw();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return false;
    }

    public void listenMapRenderMessage(d dVar) {
        this.f8997B = dVar;
    }

    public void onBackground() {
        onBackground(false);
    }

    public void onDestroy() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f9001o;
        if (bVar != null) {
            List<v> list = bVar.f8020v;
            if (list != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a();
                    }
                }
            }
            this.f9001o.h();
            this.f9001o = null;
        }
        this.f9002p.unInit();
        this.f9002p = null;
        this.f9003q.a();
        this.f9003q = null;
        this.f9004r = null;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    public void onForeground() {
        onForeground(false);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        GeoPoint geoPointFromPixels;
        MapController mapController = this.f9002p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        MapController mapController2 = this.f9002p;
        if (mapController2.mIsMapLoadFinish) {
            String strGetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f9002p.nearlyRadius);
            if (strGetNearlyObjID == null || strGetNearlyObjID.equals("")) {
                if (this.f9002p.mListeners != null) {
                    geoPointFromPixels = getProjection() != null ? getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                    if (geoPointFromPixels == null) {
                        return;
                    }
                    for (v vVar : this.f9002p.mListeners) {
                        if (vVar != null) {
                            vVar.d(geoPointFromPixels);
                        }
                    }
                    return;
                }
                return;
            }
            if (this.f9002p.mListeners != null) {
                geoPointFromPixels = getProjection() != null ? getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                for (v vVar2 : this.f9002p.mListeners) {
                    if (vVar2 != null) {
                        if (vVar2.a(strGetNearlyObjID)) {
                            this.f9002p.mHasMapObjDraging = true;
                        } else if (geoPointFromPixels != null) {
                            vVar2.d(geoPointFromPixels);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i4) {
        n nVar;
        d dVar = this.f8997B;
        if (dVar != null) {
            dVar.a(i4);
        }
        if (i4 == 1) {
            requestRender();
            return;
        }
        if (i4 == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else {
            if (i4 != 2 || (nVar = this.f9010x) == null) {
                return;
            }
            nVar.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onPause() {
        MapController mapController = this.f9002p;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.f9002p.getBaseMap().OnPause();
        }
        super.onPause();
    }

    public void onRecycle() {
        MapController mapController = this.f9002p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.f9002p.getBaseMap().ResetImageRes();
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onResume() {
        MapController mapController = this.f9002p;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.f9002p.getBaseMap().OnResume();
        }
        super.onResume();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f8998C = i4;
        this.f8999D = i5;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        super.onSurfaceTextureAvailable(surfaceTexture, i4, i5);
        this.f9006t = i4;
        this.f9007u = i5;
        MapController mapController = this.f9002p;
        if (mapController != null) {
            if (mapController.getMapViewSurfaceListener() != null) {
                this.f9002p.getMapViewSurfaceListener().onSurfaceChanged(i4, i5);
            }
            MapStatus mapStatus = getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            this.f9006t = Math.abs(winRound.right - winRound.left);
            MapStatus.WinRound winRound2 = mapStatus.winRound;
            this.f9007u = Math.abs(winRound2.bottom - winRound2.top);
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f9001o;
        if (bVar != null) {
            bVar.b(this.f9006t, this.f9007u);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i4, i5);
        this.f9006t = i4;
        this.f9007u = i5;
        j jVar = this.f9005s;
        jVar.f9234v = i4;
        jVar.f9235w = i5;
        jVar.f9236x = 0;
        if (this.f9002p != null) {
            MapStatus mapStatus = getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            winRound.left = 0;
            winRound.top = 0;
            winRound.bottom = i5;
            winRound.right = i4;
            this.f9002p.setMapStatusWithAnimation(mapStatus, 4, 0);
            if (this.f9002p.getMapViewSurfaceListener() != null) {
                this.f9002p.getMapViewSurfaceListener().onSurfaceChanged(i4, i5);
            }
            MapStatus mapStatus2 = getMapStatus();
            MapStatus.WinRound winRound2 = mapStatus2.winRound;
            int iAbs = Math.abs(winRound2.right - winRound2.left);
            MapStatus.WinRound winRound3 = mapStatus2.winRound;
            int iAbs2 = Math.abs(winRound3.bottom - winRound3.top);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a aVarA = com.baidu.mapsdkplatform.comapi.commonutils.a.a();
                StringBuilder sbU = B0.g.u("MapTextureView winRoundWidth = ", iAbs, ";winRoundHeight = ", iAbs2, ";mWidth = ");
                sbU.append(this.f9006t);
                sbU.append(";mHeight = ");
                sbU.append(this.f9007u);
                aVarA.a(sbU.toString());
            }
            if (iAbs > 0 && iAbs2 > 0) {
                this.f9006t = iAbs;
                this.f9007u = iAbs2;
            }
            this.f9002p.setScreenSize(this.f9006t, this.f9007u);
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.f9001o;
        if (bVar != null) {
            bVar.b(this.f9006t, this.f9007u);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        List<v> list;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9000E = false;
        } else if (action == 2) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            if ((x4 < Property.DEFAULT_FLOAT_VALUE || x4 > this.f8998C || y4 < Property.DEFAULT_FLOAT_VALUE || y4 > this.f8999D) && !this.f9000E && (bVar = this.f9001o) != null && (list = bVar.f8020v) != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a(this.f9001o.y());
                        this.f9000E = true;
                    }
                }
            }
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus == null) {
            return false;
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i4 = 0; i4 < pointerCount; i4++) {
            int x5 = (int) motionEvent.getX(i4);
            int y5 = (int) motionEvent.getY(i4);
            MapStatus.WinRound winRound = mapStatus.winRound;
            if (x5 < winRound.left || x5 > winRound.right || y5 < winRound.top || y5 > winRound.bottom) {
                return false;
            }
        }
        try {
            GestureDetector gestureDetector = this.f9012z;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            MapController mapController = this.f9002p;
            if (mapController != null) {
                if (mapController.handleTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay == null || this.f9002p == null) {
            return;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            if (itemizedOverlay.b()) {
                if (itemizedOverlay.getAllItem().size() <= 0) {
                    this.f9002p.getBaseMap().ClearLayer(overlay.mLayerID);
                    this.f9002p.getBaseMap().ShowLayers(overlay.mLayerID, false);
                    this.f9002p.getBaseMap().UpdateLayers(overlay.mLayerID);
                } else {
                    this.f9002p.getBaseMap().ShowLayers(overlay.mLayerID, true);
                    this.f9002p.getBaseMap().UpdateLayers(overlay.mLayerID);
                }
                itemizedOverlay.b(false);
            }
        }
        MapController mapController = this.f9002p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.f9002p.getBaseMap().UpdateLayers(overlay.mLayerID);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.f9002p;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.removeBmLayer(bmLayer.getNativeInstance());
                synchronized (this) {
                    this.f9008v.remove(bmLayer);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean removeOverlay(Overlay overlay) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || (mapController = this.f9002p) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        baseMap.ClearLayer(overlay.mLayerID);
        baseMap.ShowLayers(overlay.mLayerID, false);
        baseMap.UpdateLayers(overlay.mLayerID);
        baseMap.RemoveLayer(overlay.mLayerID);
        if (overlay instanceof ItemizedOverlay) {
            this.f9009w.remove(overlay);
        } else if (overlay instanceof InnerOverlay) {
            this.f9009w.remove(overlay);
            this.f9003q.a(overlay);
        }
        overlay.mLayerID = 0L;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z4) {
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.f9001o = bVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.f9002p.setMapStatus(mapStatus);
        }
    }

    public void setMapRenderStableListener(n nVar) {
        this.f9010x = nVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z4) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i4) {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i4;
            this.f9002p.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i4) {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i4;
            this.f9002p.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z4) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z4) {
    }

    public void setSupBackgroundDraw(boolean z4) {
        MapController mapController = this.f9002p;
        if (mapController == null) {
            return;
        }
        mapController.setSupBackgroundDraw(z4);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z4) {
        AppBaseMap baseMap;
        MapController mapController = this.f9002p;
        if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowTrafficMap(z4);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController = this.f9002p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.f9002p.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f4) {
        if (this.f9002p == null) {
            return;
        }
        getController().getFocusedBaseIndoorMapInfo();
        if (f4 < 4.0f) {
            f4 = 4.0f;
        } else if (f4 > 22) {
            f4 = 22.0f;
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f4;
            animateTo(mapStatus, UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || (mapController = this.f9002p) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unListenMapRenderMessage() {
        this.f8997B = null;
    }

    public class b implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f9013a;

        private b() {
            this.f9013a = 12440;
        }

        public String a(String str, int i4) {
            StringBuilder sbV = B0.g.v(str, " failed: ");
            sbV.append(a(i4));
            return sbV.toString();
        }

        public void b(String str, int i4) {
            throw new RuntimeException(a(str, i4));
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f9013a, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext == null || eGLDisplay == null) {
                return;
            }
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                b("eglDestroyContex", egl10.eglGetError());
            }
            MapTextureView.this.onRecycle();
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

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i4 = rect.left;
            int i5 = this.f9007u;
            int i6 = rect.bottom;
            int i7 = i5 < i6 ? 0 : i5 - i6;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i4 < 0 || i7 < 0 || iWidth <= 0 || iHeight <= 0) {
                return;
            }
            if (iWidth > this.f9006t) {
                iWidth = Math.abs(rect.width()) - (rect.right - this.f9006t);
            }
            int i8 = iWidth;
            int iAbs = iHeight > this.f9007u ? Math.abs(rect.height()) - (rect.bottom - this.f9007u) : iHeight;
            if (i4 > SysOSUtil.getScreenSizeX() || i7 > SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.f9005s.a(captureMapViewListener, i4, i7, i8, iAbs, config);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i4, int i5) {
        if (this.f9002p == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ViewTweenItem.LEFT, mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(ViewTweenItem.TOP, mapBound.rightTopPt.getIntY());
        return this.f9002p.getZoomToBound(bundle, i4, i5);
    }

    public void onBackground(boolean z4) {
        if (z4 || !this.f8996A) {
            MapController mapController = this.f9002p;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.f9002p.getBaseMap().OnBackground();
            }
            this.f8996A = true;
        }
    }

    public void onForeground(boolean z4) {
        if (z4 || this.f8996A) {
            MapController mapController = this.f9002p;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.f9002p.getBaseMap().OnForeground();
            }
            this.f8996A = false;
        }
    }

    public boolean addBmLayerBelow(long j4, BmLayer bmLayer) {
        return a(j4, bmLayer);
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        for (Overlay overlay : this.f9009w) {
            if (overlay.getClass() == cls) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i4) {
        setZoomLevel(i4);
    }

    private synchronized boolean a(long j4, BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.f9002p;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                synchronized (this) {
                    if (this.f9008v.contains(bmLayer)) {
                        return false;
                    }
                    this.f9008v.add(bmLayer);
                    return baseMap.addBmLayerBelow(j4, bmLayer.getNativeInstance(), 1, 0);
                }
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        return getZoomToBoundF(mapBound, this.f9006t, this.f9007u);
    }

    public MapTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9002p = null;
        this.f9003q = null;
        this.f9004r = null;
        this.f9005s = null;
        this.f9008v = new ArrayList();
        this.f9009w = new ArrayList();
        this.f8996A = true;
        this.f9000E = false;
        a(context);
    }

    public MapTextureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f9002p = null;
        this.f9003q = null;
        this.f9004r = null;
        this.f9005s = null;
        this.f9008v = new ArrayList();
        this.f9009w = new ArrayList();
        this.f8996A = true;
        this.f9000E = false;
        a(context);
    }
}
