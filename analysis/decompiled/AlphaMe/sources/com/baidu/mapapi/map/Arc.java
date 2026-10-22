package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmArc;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.stepos.alphame.sleep.SleepModeData;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Arc extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    int f6035g;

    /* renamed from: h, reason: collision with root package name */
    int f6036h;

    /* renamed from: i, reason: collision with root package name */
    LatLng f6037i;

    /* renamed from: j, reason: collision with root package name */
    LatLng f6038j;

    /* renamed from: k, reason: collision with root package name */
    LatLng f6039k;

    /* renamed from: l, reason: collision with root package name */
    boolean f6040l = true;

    /* renamed from: m, reason: collision with root package name */
    double f6041m;

    /* renamed from: n, reason: collision with root package name */
    double f6042n;

    /* renamed from: o, reason: collision with root package name */
    double f6043o;

    /* renamed from: p, reason: collision with root package name */
    boolean f6044p;

    /* renamed from: q, reason: collision with root package name */
    com.baidu.platform.comapi.bmsdk.b f6045q;

    /* renamed from: r, reason: collision with root package name */
    LatLng f6046r;

    /* renamed from: s, reason: collision with root package name */
    private BmArc f6047s;

    /* renamed from: t, reason: collision with root package name */
    BmLineStyle f6048t;

    public Arc() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.arc;
    }

    private void a(double d4, double d5, double d6) {
        if (d4 < d5) {
            if (d4 >= d6) {
                if (d4 <= d6 || d5 < d6 || d5 <= d6) {
                    return;
                }
                this.f6042n = d4;
                this.f6043o = d6 + 6.283185307179586d;
                this.f6044p = false;
                return;
            }
            if (d5 < d6) {
                this.f6042n = d4;
                this.f6043o = d6;
                this.f6044p = false;
                return;
            } else {
                if (d5 > d6) {
                    this.f6042n = d6;
                    this.f6043o = d4 + 6.283185307179586d;
                    this.f6044p = false;
                    return;
                }
                return;
            }
        }
        if (d4 > d5) {
            if (d4 < d6) {
                if (d5 < d6) {
                    this.f6042n = d6;
                    this.f6043o = d4 + 6.283185307179586d;
                    this.f6044p = false;
                    return;
                }
                return;
            }
            if (d4 > d6) {
                if (d5 < d6) {
                    this.f6042n = d4;
                    this.f6043o = d6 + 6.283185307179586d;
                    this.f6044p = false;
                } else if (d5 > d6) {
                    this.f6042n = d6;
                    this.f6043o = d4;
                    this.f6044p = false;
                }
            }
        }
    }

    private double b(GeoPoint geoPoint, GeoPoint geoPoint2) {
        double longitudeE6 = geoPoint.getLongitudeE6();
        double latitudeE6 = geoPoint.getLatitudeE6();
        double longitudeE62 = longitudeE6 - geoPoint2.getLongitudeE6();
        double latitudeE62 = latitudeE6 - geoPoint2.getLatitudeE6();
        return Math.sqrt((latitudeE62 * latitudeE62) + (longitudeE62 * longitudeE62));
    }

    private void c() {
        LatLng latLng = this.f6037i;
        if (latLng == null && this.f6038j == null && this.f6039k == null) {
            return;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.f6038j);
        GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(this.f6039k);
        GeoPoint geoPointA = a(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6(), geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6(), geoPointLl2mc3.getLongitudeE6(), geoPointLl2mc3.getLatitudeE6());
        this.f6045q = new com.baidu.platform.comapi.bmsdk.b(geoPointA.getLongitudeE6(), geoPointA.getLatitudeE6());
        this.f6041m = b(geoPointLl2mc, geoPointA);
        a(a(geoPointLl2mc, geoPointA), a(geoPointLl2mc2, geoPointA), a(geoPointLl2mc3, geoPointA));
    }

    public BmArc getBmArc() {
        return this.f6047s;
    }

    public int getColor() {
        return this.f6035g;
    }

    public LatLng getEndPoint() {
        return this.f6039k;
    }

    public LatLng getMiddlePoint() {
        return this.f6038j;
    }

    public LatLng getStartPoint() {
        return this.f6037i;
    }

    public int getWidth() {
        return this.f6036h;
    }

    public boolean isClickable() {
        return this.f6040l;
    }

    public void setClickable(boolean z4) {
        this.f6040l = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmArc bmArc = this.f6047s;
        if (bmArc == null || this.f6723f == null || this.f6048t == null) {
            return;
        }
        bmArc.a(z4);
        this.f6723f.b();
    }

    public void setColor(int i4) {
        BmLineStyle bmLineStyle;
        this.f6035g = i4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6047s == null || this.f6723f == null || (bmLineStyle = this.f6048t) == null) {
            return;
        }
        bmLineStyle.a(this.f6035g);
        this.f6047s.a(this.f6048t);
        this.f6723f.b();
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        BmLineStyle bmLineStyle;
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.f6037i = latLng;
        this.f6038j = latLng2;
        this.f6039k = latLng3;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.f6047s == null || this.f6723f == null || (bmLineStyle = this.f6048t) == null) {
            return;
        }
        bmLineStyle.a(this.f6035g);
        c();
        this.f6047s.a(this.f6045q);
        this.f6047s.c(this.f6044p);
        this.f6047s.a(this.f6043o);
        this.f6047s.c(this.f6042n);
        this.f6047s.b(this.f6041m);
        this.f6723f.b();
    }

    public void setWidth(int i4) {
        BmLineStyle bmLineStyle;
        if (i4 > 0) {
            this.f6036h = i4;
            if (!OverlayUtil.isOverlayUpgrade()) {
                this.listener.c(this);
                return;
            }
            if (this.f6047s == null || this.f6723f == null || (bmLineStyle = this.f6048t) == null) {
                return;
            }
            bmLineStyle.d(i4);
            this.f6047s.a(this.f6048t);
            this.f6723f.b();
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmArc bmArc = new BmArc();
        this.f6047s = bmArc;
        bmArc.a(this);
        setDrawItem(this.f6047s);
        super.toDrawItem();
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.f6048t = bmLineStyle;
        bmLineStyle.d(this.f6036h);
        this.f6048t.a(this.f6035g);
        this.f6047s.a(this.f6048t);
        if (this.f6037i == null || this.f6038j == null || this.f6039k == null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6046r);
            if (geoPointLl2mc != null) {
                this.f6045q = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6());
            }
        } else {
            c();
        }
        this.f6047s.a(this.f6045q);
        this.f6047s.c(this.f6044p);
        this.f6047s.a(this.f6043o);
        this.f6047s.c(this.f6042n);
        this.f6047s.b(this.f6041m);
        this.f6047s.a(this.f6040l);
        return this.f6047s;
    }

    private double a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        double latitudeE6 = geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6();
        double longitudeE6 = geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6();
        if (longitudeE6 == 0.0d) {
            longitudeE6 = 1.0E-5d;
        }
        if (latitudeE6 == 0.0d) {
            latitudeE6 = 1.0E-5d;
        }
        double dAtan = Math.atan(latitudeE6 / longitudeE6);
        if (longitudeE6 <= 0.0d || latitudeE6 <= 0.0d) {
            return dAtan + (((longitudeE6 >= 0.0d || latitudeE6 <= 0.0d) && (longitudeE6 >= 0.0d || latitudeE6 >= 0.0d)) ? 6.283185307179586d : 3.141592653589793d);
        }
        return dAtan * 1.0d;
    }

    private GeoPoint a(double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11 = (d4 + d6) / 2.0d;
        double d12 = (d5 + d7) / 2.0d;
        double d13 = (d6 + d8) / 2.0d;
        double d14 = (d7 + d9) / 2.0d;
        double d15 = d7 - d5;
        if (d15 == 0.0d) {
            double d16 = d9 - d7;
            if (d16 == 0.0d) {
                return null;
            }
            d10 = ((d11 - d13) * (((d8 - d6) * (-1.0d)) / d16)) + d14;
        } else {
            double d17 = ((d6 - d4) * (-1.0d)) / d15;
            double d18 = d9 - d7;
            if (d18 == 0.0d) {
                d10 = ((d13 - d11) * d17) + d12;
                d11 = d13;
            } else {
                double d19 = ((d8 - d6) * (-1.0d)) / d18;
                if (d17 == d19) {
                    return null;
                }
                double d20 = (((d17 * d11) + (d14 - d12)) - (d13 * d19)) / (d17 - d19);
                double d21 = ((d20 - d11) * d17) + d12;
                d11 = d20;
                d10 = d21;
            }
        }
        return new GeoPoint(d10, d11);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.f6037i);
        arrayList.add(this.f6038j);
        arrayList.add(this.f6039k);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        bundle.putInt("width", this.f6036h);
        Overlay.c(arrayList, bundle);
        Overlay.d(this.f6035g, bundle);
        bundle.putInt("isClickable", this.f6040l ? 1 : 0);
        return bundle;
    }
}
