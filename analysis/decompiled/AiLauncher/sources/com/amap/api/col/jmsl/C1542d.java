package com.amap.api.col.jmsl;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1542d {

    /* renamed from: r, reason: collision with root package name */
    public static volatile C1542d f16564r;

    /* renamed from: a, reason: collision with root package name */
    public boolean f16565a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16566b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16567c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16568d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16569e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16570f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16571g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f16572h = 25;

    /* renamed from: i, reason: collision with root package name */
    public int f16573i = 100;

    /* renamed from: j, reason: collision with root package name */
    public int f16574j = 100;

    /* renamed from: k, reason: collision with root package name */
    public int f16575k = 100;

    /* renamed from: l, reason: collision with root package name */
    public int f16576l = 6;

    /* renamed from: m, reason: collision with root package name */
    public int f16577m = 100;

    /* renamed from: n, reason: collision with root package name */
    public int f16578n = s7.DEFAULT_RETRY_TIMEOUT;

    /* renamed from: o, reason: collision with root package name */
    public int f16579o = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;

    /* renamed from: p, reason: collision with root package name */
    public int f16580p = 100000000;

    /* renamed from: q, reason: collision with root package name */
    public int f16581q = 16;

    public static C1542d b() {
        if (f16564r == null) {
            synchronized (C1542d.class) {
                try {
                    if (f16564r == null) {
                        f16564r = new C1542d();
                    }
                } finally {
                }
            }
        }
        return f16564r;
    }

    public int a(int i10) {
        int i11;
        return (this.f16568d && (i11 = this.f16577m) < i10) ? i11 : i10;
    }

    public void c(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f16569e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f16579o < C1631z1.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void d(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double dB;
        if (!this.f16567c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            dB = C1631z1.b(fromAndTo.getFrom(), fromAndTo.getTo());
        } else {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            Iterator<LatLonPoint> it = list.iterator();
            double dB2 = 0.0d;
            while (it.hasNext()) {
                dB2 += C1631z1.b(from, r3);
                from = it.next();
            }
            dB = dB2 + C1631z1.b(from, to);
        }
        if (this.f16578n < dB / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void e(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f16569e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f16579o < C1631z1.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void f(String str) throws AMapException {
        if (str != null && this.f16566b && str.length() > this.f16573i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }

    public void g(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f16565a && list != null) {
            if (this.f16574j < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
            }
            for (List<LatLonPoint> list2 : list) {
                double dAbs = 0.0d;
                if (list2 != null && list2.size() >= 3) {
                    int size = list2.size();
                    int i10 = 0;
                    while (i10 < size) {
                        LatLonPoint latLonPoint = list2.get(i10);
                        i10++;
                        LatLonPoint latLonPoint2 = list2.get(i10 % size);
                        dAbs += (((latLonPoint.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d)) * (latLonPoint2.getLatitude() * 111319.49079327357d)) - (((latLonPoint2.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d)) * (latLonPoint.getLatitude() * 111319.49079327357d));
                    }
                    dAbs = Math.abs(dAbs / 2.0d);
                }
                if (this.f16581q < list2.size()) {
                    throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                }
                if (this.f16580p < dAbs) {
                    throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                }
            }
        }
    }

    public int h(int i10) {
        int i11;
        return (this.f16568d && (i11 = this.f16572h) < i10) ? i11 : i10;
    }

    public void i(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f16570f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f16575k < C1631z1.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void j(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f16570f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f16575k < C1631z1.b(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void k(List<LatLonPoint> list) throws AMapException {
        if (this.f16571g && list != null) {
            if (this.f16576l < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
        }
    }
}
