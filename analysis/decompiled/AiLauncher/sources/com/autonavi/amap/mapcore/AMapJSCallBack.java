package com.autonavi.amap.mapcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.col.jmsl.C1623x1;
import com.amap.api.col.jmsl.P1;
import com.amap.api.col.jmsl.V0;
import com.amap.api.col.jmsl.W1;
import com.amap.api.col.jmsl.Z2;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.IAMapJsCallback;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.stepos.statsapp.v3.lib.plugin.events.b;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;

@SuppressLint({"JavascriptInterface"})
/* loaded from: classes.dex */
public class AMapJSCallBack implements IAMapJsCallback {
    private final V0 aMapJsCall;
    private final P1 glMapState;
    private final W1 glOverlayLayer;
    private final AmapDelegateListenerManager listenerManager;
    private final Context mContext;

    public AMapJSCallBack(Context context, AmapDelegateListenerManager amapDelegateListenerManager, W1 w12, P1 p12, V0 v02) {
        this.listenerManager = amapDelegateListenerManager;
        this.glOverlayLayer = w12;
        this.glMapState = p12;
        this.mContext = context;
        this.aMapJsCall = v02;
    }

    private void onMarkerDrag(Marker marker, double d10, double d11) {
        try {
            marker.setPosition(new LatLng(d10, d11));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMarkerTap(Marker marker) {
        marker.showInfoWindow();
        try {
            this.glOverlayLayer.b().H(CameraUpdateFactory.changeLatLng(marker.getPosition()));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public void initWorker() {
        this.aMapJsCall.u();
        if (C1623x1.f17030a) {
            C1570k.i("JAVA-JS代码加载完成");
        }
    }

    @JavascriptInterface
    public void log(String str) {
        if (C1623x1.f17030a) {
            if (str.contains(ServerSentEventKt.COLON)) {
                str = str.split(ServerSentEventKt.COLON)[0].trim();
            }
            C1570k.i(str);
        }
    }

    @Override // com.amap.api.maps.IAMapJsCallback
    @JavascriptInterface
    public void nativeCall(String str, Object[] objArr) {
        if (str == null) {
            return;
        }
        if (b.f30786f.equals(str)) {
            if (objArr != null) {
                log(objArr[0].toString());
                return;
            }
            return;
        }
        if ("onMapRenderComplete".equals(str)) {
            onMapRenderComplete();
            return;
        }
        if ("initWorker".equals(str)) {
            initWorker();
            return;
        }
        if ("onMapLoadComplete".equals(str)) {
            onMapLoadComplete();
            return;
        }
        if ("onMapClick".equals(str)) {
            if (objArr != null) {
                onMapClick(((Double) objArr[0]).doubleValue(), ((Double) objArr[1]).doubleValue());
                return;
            }
            return;
        }
        if ("onPolylineClick".equals(str)) {
            if (objArr != null) {
                onPolylineClick((String) objArr[0]);
                return;
            }
            return;
        }
        if ("onMarkerClick".equals(str)) {
            if (objArr != null) {
                onMarkerClick((String) objArr[0]);
                return;
            }
            return;
        }
        if ("onMarkerDragstart".equals(str)) {
            if (objArr != null) {
                onMarkerDragstart((String) objArr[0], ((Double) objArr[1]).doubleValue(), ((Double) objArr[2]).doubleValue());
                return;
            }
            return;
        }
        if ("onMarkerDragging".equals(str)) {
            if (objArr != null) {
                onMarkerDragging((String) objArr[0], ((Double) objArr[1]).doubleValue(), ((Double) objArr[2]).doubleValue());
                return;
            }
            return;
        }
        if ("onMarkerDragend".equals(str)) {
            if (objArr != null) {
                onMarkerDragend((String) objArr[0], ((Double) objArr[1]).doubleValue(), ((Double) objArr[2]).doubleValue());
                return;
            }
            return;
        }
        if ("onMapChange".equals(str)) {
            if (objArr != null) {
                onMapChange(((Double) objArr[0]).doubleValue(), ((Double) objArr[1]).doubleValue(), ((Float) objArr[2]).floatValue(), ((Float) objArr[3]).floatValue(), ((Float) objArr[4]).floatValue());
            }
        } else if ("onMapChangeFinish".equals(str)) {
            if (objArr != null) {
                onMapChangeFinish(((Double) objArr[0]).doubleValue(), ((Double) objArr[1]).doubleValue(), ((Float) objArr[2]).floatValue(), ((Float) objArr[3]).floatValue(), ((Float) objArr[4]).floatValue());
            }
        } else if ("onMapBoundsChange".equals(str)) {
            if (objArr != null) {
                onMapBoundsChange(((Double) objArr[0]).doubleValue(), ((Double) objArr[1]).doubleValue(), ((Double) objArr[2]).doubleValue(), ((Double) objArr[3]).doubleValue());
            }
        } else {
            log(str + " not found!!! ");
        }
    }

    @JavascriptInterface
    public void onMapBoundsChange(double d10, double d11, double d12, double d13) {
    }

    @JavascriptInterface
    public void onMapChange(final double d10, final double d11, final float f10, final float f11, final float f12) {
        P1 p12 = this.glMapState;
        if (p12 != null) {
            p12.b(d10, d11, f10, f11, f12);
        }
        final List listenerList = this.listenerManager.getListenerList(AMap.OnCameraChangeListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CameraPosition cameraPositionBuild = CameraPosition.builder().target(new LatLng(d10, d11)).zoom(f10).bearing(f11).tilt(f12).build();
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnCameraChangeListener) listenerList.get(i10)).onCameraChange(cameraPositionBuild);
                            } finally {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    C1570k.j(th);
                }
            }
        });
    }

    @JavascriptInterface
    public void onMapChangeFinish(final double d10, final double d11, final float f10, final float f11, final float f12) {
        final List listenerList = this.listenerManager.getListenerList(AMap.OnCameraChangeListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CameraPosition cameraPositionBuild = CameraPosition.builder().target(new LatLng(d10, d11)).zoom(f10).bearing(f11).tilt(f12).build();
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnCameraChangeListener) listenerList.get(i10)).onCameraChangeFinish(cameraPositionBuild);
                            } finally {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    C1570k.j(th);
                }
            }
        });
    }

    @JavascriptInterface
    public void onMapClick(final double d10, final double d11) {
        final List listenerList = this.listenerManager.getListenerList(AMap.OnMapClickListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnMapClickListener) listenerList.get(i10)).onMapClick(new LatLng(d10, d11));
                            } finally {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    C1570k.j(th);
                }
            }
        });
    }

    @JavascriptInterface
    public void onMapLoadComplete() {
        Z2.g(this.mContext, C1570k.t("amap_3dmap_launchtime"));
        final List listenerList = this.listenerManager.getListenerList(AMap.OnMapReadyListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnMapReadyListener) listenerList.get(i10)).onMapReady(null);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C1570k.j(th2);
                }
            }
        });
    }

    @JavascriptInterface
    public void onMapRenderComplete() {
        Z2.c(this.mContext, C1570k.t("amap_3dmap_rendertime"));
        if (C1623x1.f17030a) {
            C1570k.i("JAVA-JS首屏渲染完成");
        }
    }

    @JavascriptInterface
    public void onMarkerClick(String str) {
        final BaseOverlay baseOverlayN = this.glOverlayLayer.n(str);
        if (baseOverlayN == null) {
            return;
        }
        final List listenerList = this.listenerManager.getListenerList(AMap.OnMarkerClickListener.class.hashCode());
        if (listenerList == null) {
            onMarkerTap((Marker) baseOverlayN);
        } else {
            this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (listenerList) {
                            boolean zOnMarkerClick = false;
                            for (int i10 = 0; i10 < listenerList.size(); i10++) {
                                try {
                                    zOnMarkerClick |= ((AMap.OnMarkerClickListener) listenerList.get(i10)).onMarkerClick((Marker) baseOverlayN);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (zOnMarkerClick) {
                                return;
                            }
                            AMapJSCallBack.this.onMarkerTap((Marker) baseOverlayN);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        C1570k.j(th2);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void onMarkerDragend(String str, double d10, double d11) {
        final BaseOverlay baseOverlayN = this.glOverlayLayer.n(str);
        if (baseOverlayN == null) {
            return;
        }
        onMarkerDrag((Marker) baseOverlayN, d10, d11);
        final List listenerList = this.listenerManager.getListenerList(AMap.OnMarkerDragListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnMarkerDragListener) listenerList.get(i10)).onMarkerDragEnd((Marker) baseOverlayN);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C1570k.j(th2);
                }
            }
        });
    }

    @JavascriptInterface
    public void onMarkerDragging(String str, double d10, double d11) {
        final BaseOverlay baseOverlayN = this.glOverlayLayer.n(str);
        if (baseOverlayN == null) {
            return;
        }
        onMarkerDrag((Marker) baseOverlayN, d10, d11);
        final List listenerList = this.listenerManager.getListenerList(AMap.OnMarkerDragListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnMarkerDragListener) listenerList.get(i10)).onMarkerDrag((Marker) baseOverlayN);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C1570k.j(th2);
                }
            }
        });
    }

    @JavascriptInterface
    public void onMarkerDragstart(String str, double d10, double d11) {
        final BaseOverlay baseOverlayN = this.glOverlayLayer.n(str);
        if (baseOverlayN == null) {
            return;
        }
        onMarkerDrag((Marker) baseOverlayN, d10, d11);
        final List listenerList = this.listenerManager.getListenerList(AMap.OnMarkerDragListener.class.hashCode());
        if (listenerList == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnMarkerDragListener) listenerList.get(i10)).onMarkerDragStart((Marker) baseOverlayN);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C1570k.j(th2);
                }
            }
        });
    }

    @JavascriptInterface
    public void onPolylineClick(String str) {
        final List listenerList;
        final BaseOverlay baseOverlayN = this.glOverlayLayer.n(str);
        if (baseOverlayN == null || (listenerList = this.listenerManager.getListenerList(AMap.OnPolylineClickListener.class.hashCode())) == null) {
            return;
        }
        this.glOverlayLayer.b().m(new Runnable() { // from class: com.autonavi.amap.mapcore.AMapJSCallBack.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (listenerList) {
                        for (int i10 = 0; i10 < listenerList.size(); i10++) {
                            try {
                                ((AMap.OnPolylineClickListener) listenerList.get(i10)).onPolylineClick((Polyline) baseOverlayN);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C1570k.j(th2);
                }
            }
        });
    }
}
