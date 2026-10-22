package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class RegeocodeQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f28938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f28939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f28943f;

    public int hashCode() {
        String r100 = this.f28940c;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        LatLonPoint r104 = this.f28938a;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + Float.floatToIntBits(this.f28939b);
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String getExtensions() {
        return this.f28943f;
    }

    public String getLatLonType() {
        return this.f28940c;
    }

    public String getMode() {
        return this.f28942e;
    }

    public String getPoiType() {
        return this.f28941d;
    }

    public LatLonPoint getPoint() {
        return this.f28938a;
    }

    public float getRadius() {
        return this.f28939b;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        RegeocodeQuery r101 = (RegeocodeQuery) r100;
        String r102 = this.f28940c;
        if (r102 != null) goto L17;
        if (r101.f28940c == null) goto L19;
        return false;
    L19:
        LatLonPoint r103 = this.f28938a;
        if (r103 != null) goto L25;
        if (r101.f28938a == null) goto L28;
        return false;
    L28:
        if (Float.floatToIntBits(this.f28939b) == Float.floatToIntBits(r101.f28939b)) goto L31;
        return false;
    L31:
        if (this.f28942e.equals(r101.f28942e) == true) goto L33;
        return false;
    L33:
        String r104 = this.f28943f;
        if (r104 != null) goto L39;
        if (r101.f28943f == null) goto L41;
        return false;
    L41:
        return true;
    L39:
        if (r104.equals(r101.f28943f) == true) goto L41;
        return false;
    L25:
        if (r103.equals(r101.f28938a) == true) goto L28;
        return false;
    L17:
        if (r102.equals(r101.f28940c) == true) goto L19;
        return false;
    }

    public void setExtensions(String r100) {
        this.f28943f = r100;
    }

    public void setLatLonType(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(GeocodeSearch.AMAP) == false) goto L6;
    L7:
        this.f28940c = r100;
        return;
    L6:
        if (r100.equals(GeocodeSearch.GPS) == true) goto L7;
    }

    public void setMode(String r100) {
        this.f28942e = r100;
    }

    public void setPoiType(String r100) {
        this.f28941d = r100;
    }

    public void setPoint(LatLonPoint r100) {
        this.f28938a = r100;
    }

    public void setRadius(float r100) {
        this.f28939b = r100;
    }

    public RegeocodeQuery(LatLonPoint r100, float r101, String r102) {
        this.f28940c = GeocodeSearch.AMAP;
        this.f28941d = "";
        this.f28942e = "distance";
        this.f28943f = "base";
        this.f28938a = r100;
        this.f28939b = r101;
        setLatLonType(r102);
    }
}
