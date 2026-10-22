package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private double f17341a;

    /* renamed from: b, reason: collision with root package name */
    private double f17342b;

    public static class a implements Parcelable.Creator<LatLonPoint> {
        @Override // android.os.Parcelable.Creator
        public LatLonPoint createFromParcel(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LatLonPoint[] newArray(int i10) {
            return new LatLonPoint[i10];
        }
    }

    public LatLonPoint(double d10, double d11) {
        this.f17341a = d10;
        this.f17342b = d11;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f17341a, this.f17342b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f17341a) == Double.doubleToLongBits(latLonPoint.f17341a) && Double.doubleToLongBits(this.f17342b) == Double.doubleToLongBits(latLonPoint.f17342b);
    }

    public double getLatitude() {
        return this.f17341a;
    }

    public double getLongitude() {
        return this.f17342b;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f17341a);
        int i10 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f17342b);
        return (i10 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public void setLatitude(double d10) {
        this.f17341a = d10;
    }

    public void setLongitude(double d10) {
        this.f17342b = d10;
    }

    public String toString() {
        return "" + this.f17341a + Const.STR_MART_COMMA + this.f17342b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f17341a);
        parcel.writeDouble(this.f17342b);
    }

    public LatLonPoint(Parcel parcel) {
        this.f17341a = parcel.readDouble();
        this.f17342b = parcel.readDouble();
    }
}
