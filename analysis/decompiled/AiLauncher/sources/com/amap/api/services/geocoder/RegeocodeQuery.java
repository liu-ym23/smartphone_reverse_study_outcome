package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RegeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f17462a;

    /* renamed from: b, reason: collision with root package name */
    private float f17463b;

    /* renamed from: c, reason: collision with root package name */
    private String f17464c = GeocodeSearch.AMAP;

    /* renamed from: d, reason: collision with root package name */
    private String f17465d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f17466e = "distance";

    /* renamed from: f, reason: collision with root package name */
    private String f17467f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f10, String str) {
        this.f17462a = latLonPoint;
        this.f17463b = f10;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        String str = this.f17464c;
        if (str == null) {
            if (regeocodeQuery.f17464c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.f17464c)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f17462a;
        if (latLonPoint == null) {
            if (regeocodeQuery.f17462a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.f17462a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f17463b) != Float.floatToIntBits(regeocodeQuery.f17463b) || !this.f17466e.equals(regeocodeQuery.f17466e)) {
            return false;
        }
        String str2 = this.f17467f;
        if (str2 == null) {
            if (regeocodeQuery.f17467f != null) {
                return false;
            }
        } else if (!str2.equals(regeocodeQuery.f17467f)) {
            return false;
        }
        return true;
    }

    public String getExtensions() {
        return this.f17467f;
    }

    public String getLatLonType() {
        return this.f17464c;
    }

    public String getMode() {
        return this.f17466e;
    }

    public String getPoiType() {
        return this.f17465d;
    }

    public LatLonPoint getPoint() {
        return this.f17462a;
    }

    public float getRadius() {
        return this.f17463b;
    }

    public int hashCode() {
        String str = this.f17464c;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f17462a;
        return ((iHashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f17463b);
    }

    public void setExtensions(String str) {
        this.f17467f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals(GeocodeSearch.AMAP) || str.equals("gps")) {
                this.f17464c = str;
            }
        }
    }

    public void setMode(String str) {
        this.f17466e = str;
    }

    public void setPoiType(String str) {
        this.f17465d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f17462a = latLonPoint;
    }

    public void setRadius(float f10) {
        this.f17463b = f10;
    }
}
