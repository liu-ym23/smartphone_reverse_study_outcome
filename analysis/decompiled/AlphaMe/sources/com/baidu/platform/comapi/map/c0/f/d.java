package com.baidu.platform.comapi.map.c0.f;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private GeoPoint f9110b;

    /* renamed from: c, reason: collision with root package name */
    private int f9111c;

    /* renamed from: d, reason: collision with root package name */
    private float f9112d;

    /* renamed from: e, reason: collision with root package name */
    private Queue<a.c> f9113e;

    /* renamed from: f, reason: collision with root package name */
    private a.c f9114f;

    /* renamed from: g, reason: collision with root package name */
    private a.c f9115g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9116h;

    /* renamed from: i, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.e.b f9117i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9118j;

    /* renamed from: k, reason: collision with root package name */
    private double f9119k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9120l;

    /* renamed from: m, reason: collision with root package name */
    private long f9121m;

    public d(MapController mapController) {
        super(mapController);
        this.f9113e = new LinkedList();
        this.f9116h = false;
        this.f9118j = false;
        this.f9119k = 0.0d;
        this.f9120l = false;
        this.f9121m = 0L;
    }

    private void b(MapStatus mapStatus) {
        com.baidu.platform.comapi.map.c0.e.b bVar = this.f9117i;
        double dAbs = Math.abs(new a.c(new a.C0046a(bVar.f9094b.f9057a, bVar.f9095c.f9057a), this.f9117i.f9094b).f9061a);
        com.baidu.platform.comapi.map.c0.e.b bVar2 = this.f9117i;
        double dAbs2 = Math.abs(new a.c(new a.C0046a(bVar2.f9094b.f9058b, bVar2.f9095c.f9058b), this.f9117i.f9094b).f9061a);
        double d4 = this.f9119k;
        if (d4 == 0.0d || d4 * this.f9115g.f9062b >= 0.0d) {
            if (this.f9118j) {
                mapStatus.rotation = (int) ((this.f9111c + this.f9114f.f9061a) % 360.0d);
            } else {
                double d5 = this.f9115g.f9062b;
                boolean z4 = false;
                boolean z5 = (d5 < 1.0d && dAbs > 60.0d) || (d5 > 1.0d && Math.abs(dAbs - 180.0d) > 60.0d);
                double d6 = this.f9115g.f9062b;
                if ((d6 > 1.0d && dAbs2 > 60.0d) || (d6 < 1.0d && Math.abs(dAbs2 - 180.0d) > 60.0d)) {
                    z4 = true;
                }
                if (z5 || z4) {
                    if (Math.abs(this.f9114f.f9061a) > (MapController.isCompass ? 30 : 10)) {
                        this.f9118j = true;
                        this.f9100a.getGestureMonitor().c();
                        this.f9111c = (int) (this.f9111c - this.f9114f.f9061a);
                        if (MapController.isCompass) {
                            this.f9120l = true;
                            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
                        }
                    }
                }
            }
            this.f9119k = this.f9115g.f9062b;
        }
    }

    private void c(MapStatus mapStatus) {
        float fLog = this.f9112d + ((float) (Math.log(this.f9114f.f9062b) / Math.log(2.0d)));
        mapStatus.level = fLog;
        if (fLog < 4.0f) {
            fLog = 4.0f;
        }
        mapStatus.level = fLog;
        if (fLog > 22.0f) {
            fLog = 22.0f;
        }
        mapStatus.level = fLog;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar) {
        MapViewInterface mapView = this.f9100a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f9100a.getMapStatus();
        a.b bVarA = bVar.f9093a.a();
        this.f9110b = mapView.getProjection().fromPixels((int) bVarA.f9059a, (int) bVarA.f9060b);
        this.f9112d = this.f9100a.getZoomLevel();
        this.f9111c = mapStatus.rotation;
        this.f9119k = 0.0d;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent) {
        this.f9117i = bVar;
        this.f9114f = new a.c(bVar.f9093a, bVar.f9095c);
        this.f9115g = new a.c(bVar.f9094b, bVar.f9095c);
        List<v> listeners = this.f9100a.getListeners();
        if (listeners != null) {
            s mapStatusInner = this.f9100a.getMapStatusInner();
            float x4 = motionEvent.getX(1) - motionEvent.getX(0);
            float y4 = motionEvent.getY(1) - motionEvent.getY(0);
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            Point point2 = new Point((int) (motionEvent.getRawX() + x4), (int) (motionEvent.getRawY() + y4));
            for (int i4 = 0; i4 < listeners.size(); i4++) {
                v vVar = listeners.get(i4);
                if (vVar != null && vVar.d(point, point2, mapStatusInner)) {
                    return;
                }
            }
        }
        MapStatus mapStatus = this.f9100a.getMapStatus();
        if (this.f9100a.isEnableZoom()) {
            c(mapStatus);
        }
        if (this.f9100a.is3DGestureEnable() && this.f9100a.getMapControlMode() != MapController.MapControlMode.STREET) {
            b(mapStatus);
        }
        if (mapStatus.overlooking == 0.0d && this.f9100a.isCanTouchMove()) {
            a(mapStatus);
        }
        this.f9100a.setMapStatus(mapStatus);
        if (this.f9100a.isNaviMode() && this.f9100a.getNaviMapViewListener() != null) {
            this.f9100a.getNaviMapViewListener().onAction(520, null);
        }
        this.f9100a.mapStatusChangeStart();
        if (this.f9113e.size() >= 10) {
            this.f9113e.poll();
        }
        this.f9113e.offer(this.f9115g);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
        this.f9121m = System.currentTimeMillis();
    }

    private void a(MapStatus mapStatus) {
        MapViewInterface mapView;
        a.b bVarA;
        com.baidu.platform.comapi.basestruct.Point pixels;
        a.b bVarA2;
        com.baidu.platform.comapi.basestruct.Point pixels2;
        if (this.f9110b != null) {
            if (Math.abs(this.f9115g.f9063c.f9064a) > 0.0d || Math.abs(this.f9115g.f9063c.f9065b) > 0.0d) {
                a.b bVarA3 = this.f9117i.f9093a.a();
                a.b bVarA4 = this.f9117i.f9095c.a();
                double d4 = bVarA4.f9059a - bVarA3.f9059a;
                double d5 = bVarA4.f9060b - bVarA3.f9060b;
                double dSqrt = Math.sqrt((d5 * d5) + (d4 * d4));
                if ((!MapController.isCompass || dSqrt >= 100.0d) && (mapView = this.f9100a.getMapView()) != null) {
                    if (!MapController.isCompass && !this.f9120l) {
                        MapController mapController = this.f9100a;
                        if (mapController != null && mapController.getPointGesturesCenter() != null) {
                            Point pointGesturesCenter = this.f9100a.getPointGesturesCenter();
                            if (pointGesturesCenter == null) {
                                return;
                            }
                            this.f9110b = mapView.getProjection().fromPixels(pointGesturesCenter.x, pointGesturesCenter.y);
                            bVarA2 = new a.b(pointGesturesCenter.x, pointGesturesCenter.y);
                        } else {
                            MapController mapController2 = this.f9100a;
                            if (mapController2 != null && mapController2.getLatLngGesturesCenter() != null) {
                                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f9100a.getLatLngGesturesCenter());
                                if (geoPointLl2mc == null || (pixels2 = this.f9100a.getMapView().getProjection().toPixels(geoPointLl2mc, null)) == null) {
                                    return;
                                }
                                Point point = new Point(pixels2.getIntX(), pixels2.getIntY());
                                this.f9110b = geoPointLl2mc;
                                bVarA2 = new a.b(point.x, point.y);
                            } else {
                                bVarA2 = this.f9117i.f9095c.a();
                            }
                        }
                        if (bVarA2 == null) {
                            return;
                        }
                        mapStatus.centerPtX = this.f9110b.getLongitude();
                        mapStatus.centerPtY = this.f9110b.getLatitude();
                        mapStatus.xOffset = (float) (bVarA2.f9059a - (((this.f9100a.getScreenWidth() / 2) + mapStatus.winRound.left) + mapStatus.xScreenOffset));
                        mapStatus.yOffset = ((float) (bVarA2.f9060b - (((this.f9100a.getScreenHeight() / 2) + mapStatus.winRound.top) + mapStatus.yScreenOffset))) * (-1.0f);
                        return;
                    }
                    this.f9120l = false;
                    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
                    MapController mapController3 = this.f9100a;
                    if (mapController3 != null && mapController3.getPointGesturesCenter() != null) {
                        if (this.f9100a.getPointGesturesCenter() == null) {
                            return;
                        } else {
                            bVarA = new a.b(r8.x, r8.y);
                        }
                    } else {
                        MapController mapController4 = this.f9100a;
                        if (mapController4 != null && mapController4.getLatLngGesturesCenter() != null) {
                            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f9100a.getLatLngGesturesCenter());
                            if (geoPointLl2mc2 == null || (pixels = this.f9100a.getMapView().getProjection().toPixels(geoPointLl2mc2, null)) == null) {
                                return;
                            }
                            Point point2 = new Point(pixels.getIntX(), pixels.getIntY());
                            this.f9110b = geoPointLl2mc2;
                            bVarA = new a.b(point2.x, point2.y);
                        } else {
                            bVarA = this.f9117i.f9095c.a();
                        }
                    }
                    if (bVarA == null) {
                        return;
                    }
                    this.f9110b = mapView.getProjection().fromPixels((int) bVarA.f9059a, (int) bVarA.f9060b);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair) {
        double d4;
        double latitude;
        MapViewInterface mapView = this.f9100a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f9100a.getMapStatus();
        int x4 = (int) bVar.f9096d.getX();
        int y4 = (int) bVar.f9096d.getY();
        if (x4 < 0) {
            x4 = 0;
        }
        if (y4 < 0) {
            y4 = 0;
        }
        GeoPoint geoPointFromPixels = mapView.getProjection().fromPixels((int) ((this.f9100a.getScreenWidth() / 2) + mapStatus.winRound.left + mapStatus.xScreenOffset), (int) ((this.f9100a.getScreenHeight() / 2) + mapStatus.winRound.top + mapStatus.yScreenOffset));
        if (geoPointFromPixels != null) {
            double longitude = geoPointFromPixels.getLongitude();
            latitude = geoPointFromPixels.getLatitude();
            d4 = longitude;
        } else {
            d4 = 0.0d;
            latitude = 0.0d;
        }
        this.f9100a.MapMsgProc(5, 1, (y4 << 16) | x4, 0, 0, d4, latitude, 0.0d, 0.0d);
        this.f9100a.getGestureMonitor().c(this.f9100a.getZoomLevel());
        if (System.currentTimeMillis() - this.f9121m <= 100) {
            MapController mapController = this.f9100a;
            if (mapController.mIsInertialAnimation && mapController.isEnableZoom()) {
                a(this.f9100a.getMapStatus(), bVar, pair);
            }
        }
    }

    private int a() {
        if (!this.f9118j) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f9113e);
        if (linkedList.size() < 2) {
            return 0;
        }
        int i4 = (int) (((a.c) linkedList.get(linkedList.size() - 2)).f9061a * 8.0d);
        if (i4 >= 180) {
            return 179;
        }
        if (i4 <= -180) {
            return -179;
        }
        return i4;
    }

    private void a(MapStatus mapStatus, int i4) {
        if (i4 != 0) {
            mapStatus.rotation = (mapStatus.rotation + i4) % 360;
            this.f9100a.setMapStatusWithAnimation(mapStatus, UIMsg.MSG_MAP_PANO_DATA);
        }
    }

    public void a(MapStatus mapStatus, com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair) {
        double d4;
        double d5;
        a.c cVar;
        double d6;
        if (pair != null) {
            int iA = a();
            a.d dVar = (a.d) pair.first;
            double d7 = dVar.f9064a;
            a.d dVar2 = (a.d) pair.second;
            double d8 = dVar2.f9064a;
            if (d7 * d8 > 0.0d && dVar.f9065b * dVar2.f9065b > 0.0d) {
                a(mapStatus, iA);
                return;
            }
            if (Math.abs(d7 - d8) >= 1.0d && Math.abs(((a.d) pair.first).f9065b - ((a.d) pair.second).f9065b) >= 1.0d) {
                double dAbs = Math.abs(new a.c(new a.C0046a(bVar.f9094b.f9057a, bVar.f9095c.f9057a), bVar.f9094b).f9061a);
                double dAbs2 = Math.abs(new a.c(new a.C0046a(bVar.f9094b.f9058b, bVar.f9095c.f9058b), bVar.f9094b).f9061a);
                double d9 = this.f9119k;
                if (d9 != 0.0d) {
                    d4 = dAbs2;
                    if (d9 * this.f9115g.f9062b < 0.0d) {
                        a(mapStatus, iA);
                        return;
                    }
                } else {
                    d4 = dAbs2;
                }
                a.d dVar3 = (a.d) pair.first;
                double d10 = dVar3.f9064a;
                a.d dVar4 = (a.d) pair.second;
                double d11 = dVar4.f9064a;
                double d12 = (d11 * d11) + (d10 * d10);
                double d13 = dVar3.f9065b;
                double d14 = dVar4.f9065b;
                float fSqrt = ((float) Math.sqrt((d14 * d14) + (d13 * d13) + d12)) * 2.0f;
                if (fSqrt > (SysOSUtil.getInstance().getDensityDPI() * 100) / 320) {
                    mapStatus.hasAnimation = 1;
                    mapStatus.animationTime = UIMsg.MSG_MAP_PANO_DATA;
                    a.c cVar2 = null;
                    a.c cVar3 = null;
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < this.f9113e.size(); i6++) {
                        a.c cVarPoll = this.f9113e.poll();
                        if (cVarPoll != null) {
                            if (this.f9113e.isEmpty()) {
                                cVar = cVar2;
                                d6 = 1.0d;
                                if (Math.abs(cVarPoll.f9062b - 1.0d) < 0.01d) {
                                    a(mapStatus, iA);
                                    return;
                                }
                            } else {
                                cVar = cVar2;
                                d6 = 1.0d;
                            }
                            if (cVarPoll.f9062b > d6) {
                                i4++;
                                cVar2 = cVarPoll;
                            } else {
                                i5++;
                                cVar2 = cVar;
                                cVar3 = cVarPoll;
                            }
                        }
                    }
                    a.c cVar4 = i4 >= i5 ? cVar2 : cVar3;
                    if (cVar4 != null) {
                        d5 = 1.0d;
                        if (Math.abs(cVar4.f9062b - 1.0d) < 0.01d) {
                            a(mapStatus, iA);
                            return;
                        }
                    } else {
                        d5 = 1.0d;
                    }
                    double d15 = cVar4.f9062b;
                    boolean z4 = (d15 < d5 && dAbs > 60.0d) || (d15 > d5 && Math.abs(dAbs - 180.0d) > 60.0d);
                    double d16 = cVar4.f9062b;
                    boolean z5 = (d16 > 1.0d && d4 > 60.0d) || (d16 < 1.0d && Math.abs(d4 - 180.0d) > 60.0d);
                    if (z4 || z5) {
                        if (Math.abs(this.f9114f.f9061a) > (MapController.isCompass ? 30 : 15)) {
                            a(mapStatus, iA);
                            return;
                        }
                    }
                    this.f9116h = cVar4.f9062b > 1.0d;
                    float densityDPI = fSqrt / (800000 / SysOSUtil.getInstance().getDensityDPI());
                    float f4 = densityDPI <= 2.0f ? densityDPI : 2.0f;
                    if (this.f9116h) {
                        mapStatus.level += f4;
                    } else {
                        mapStatus.level -= f4;
                    }
                    float f5 = mapStatus.level;
                    if (f5 < 4.0f) {
                        f5 = 4.0f;
                    }
                    mapStatus.level = f5;
                    if (f5 > 22.0f) {
                        f5 = 22.0f;
                    }
                    mapStatus.level = f5;
                    if (iA != 0) {
                        mapStatus.rotation = (mapStatus.rotation + iA) % 360;
                    }
                    this.f9100a.setMapStatus(mapStatus);
                    this.f9100a.mIsAnimating = true;
                    return;
                }
                return;
            }
            a(mapStatus, iA);
        }
    }
}
