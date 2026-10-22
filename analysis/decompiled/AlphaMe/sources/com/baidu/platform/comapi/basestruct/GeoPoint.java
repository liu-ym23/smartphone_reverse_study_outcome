package com.baidu.platform.comapi.basestruct;

/* loaded from: classes.dex */
public class GeoPoint {

    /* renamed from: a, reason: collision with root package name */
    private double f8598a;

    /* renamed from: b, reason: collision with root package name */
    private double f8599b;

    public GeoPoint(int i4, int i5) {
        this.f8598a = i4;
        this.f8599b = i5;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        return Math.abs(this.f8598a - geoPoint.f8598a) <= 1.0E-6d && Math.abs(this.f8599b - geoPoint.f8599b) <= 1.0E-6d;
    }

    public double getLatitude() {
        return this.f8598a;
    }

    public double getLatitudeE6() {
        return this.f8598a;
    }

    public double getLongitude() {
        return this.f8599b;
    }

    public double getLongitudeE6() {
        return this.f8599b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitude(double d4) {
        this.f8598a = d4;
    }

    public void setLatitudeE6(double d4) {
        this.f8598a = d4;
    }

    public void setLongitude(double d4) {
        this.f8599b = d4;
    }

    public void setLongitudeE6(double d4) {
        this.f8599b = d4;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f8598a + ", Longitude: " + this.f8599b;
    }

    public void setLatitude(int i4) {
        this.f8598a = i4;
    }

    public void setLongitude(int i4) {
        this.f8599b = i4;
    }

    public GeoPoint(double d4, double d5) {
        this.f8598a = d4;
        this.f8599b = d5;
    }
}
