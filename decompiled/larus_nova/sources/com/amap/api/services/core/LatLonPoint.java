package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f28836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f28837b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f28836a, this.f28837b);
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.f28836a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) + 31;
        long r102 = Double.doubleToLongBits(this.f28837b);
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return this.f28836a + "," + this.f28837b;
    }

    public double getLatitude() {
        return this.f28836a;
    }

    public double getLongitude() {
        return this.f28837b;
    }

    public LatLonPoint(Parcel r100) {
        this.f28836a = r100.readDouble();
        this.f28837b = r100.readDouble();
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
        LatLonPoint r101 = (LatLonPoint) r100;
        if (Double.doubleToLongBits(this.f28836a) == Double.doubleToLongBits(r101.f28836a)) goto L15;
        return false;
    L15:
        if (Double.doubleToLongBits(this.f28837b) == Double.doubleToLongBits(r101.f28837b)) goto L17;
        return false;
    L17:
        return true;
    }

    public void setLatitude(double r100) {
        this.f28836a = r100;
    }

    public void setLongitude(double r100) {
        this.f28837b = r100;
    }

    public LatLonPoint(double r100, double r101) {
        this.f28836a = r100;
        this.f28837b = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeDouble(this.f28836a);
        r100.writeDouble(this.f28837b);
    }
}
