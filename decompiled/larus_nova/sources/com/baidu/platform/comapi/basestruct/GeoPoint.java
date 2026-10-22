package com.baidu.platform.comapi.basestruct;

/* JADX INFO: loaded from: classes39.dex */
public class GeoPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f32735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f32736b;

    public String toString() {
        return "GeoPoint: Latitude: " + this.f32735a + ", Longitude: " + this.f32736b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public double getLatitude() {
        return this.f32735a;
    }

    public double getLatitudeE6() {
        return this.f32735a;
    }

    public double getLongitude() {
        return this.f32736b;
    }

    public double getLongitudeE6() {
        return this.f32736b;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getClass() != getClass()) goto L13;
        GeoPoint r101 = (GeoPoint) r100;
        if (Math.abs(this.f32735a - r101.f32735a) <= 1.0E-6d) goto L10;
        return false;
    L10:
        if (Math.abs(this.f32736b - r101.f32736b) > 1.0E-6d) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public void setLatitude(int r100) {
        this.f32735a = r100;
    }

    public void setLatitudeE6(double r100) {
        this.f32735a = r100;
    }

    public void setLongitude(int r100) {
        this.f32736b = r100;
    }

    public void setLongitudeE6(double r100) {
        this.f32736b = r100;
    }

    public void setLatitude(double r100) {
        this.f32735a = r100;
    }

    public void setLongitude(double r100) {
        this.f32736b = r100;
    }

    public GeoPoint(int r100, int r101) {
        this.f32735a = r100;
        this.f32736b = r101;
    }

    public GeoPoint(double r100, double r101) {
        this.f32735a = r100;
        this.f32736b = r101;
    }
}
