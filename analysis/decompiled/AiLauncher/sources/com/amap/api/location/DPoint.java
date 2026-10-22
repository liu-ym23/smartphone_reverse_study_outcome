package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private double f17202a;

    /* renamed from: b, reason: collision with root package name */
    private double f17203b;

    public static class a implements Parcelable.Creator<DPoint> {
        @Override // android.os.Parcelable.Creator
        public DPoint createFromParcel(Parcel parcel) {
            return new DPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DPoint[] newArray(int i10) {
            return new DPoint[i10];
        }
    }

    public DPoint() {
        this.f17202a = 0.0d;
        this.f17203b = 0.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return this.f17203b == dPoint.f17203b && this.f17202a == dPoint.f17202a;
    }

    public double getLatitude() {
        return this.f17203b;
    }

    public double getLongitude() {
        return this.f17202a;
    }

    public int hashCode() {
        return Double.valueOf((this.f17203b + this.f17202a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d10) {
        if (d10 > 90.0d) {
            d10 = 90.0d;
        }
        if (d10 < -90.0d) {
            d10 = -90.0d;
        }
        this.f17203b = d10;
    }

    public void setLongitude(double d10) {
        if (d10 > 180.0d) {
            d10 = 180.0d;
        }
        if (d10 < -180.0d) {
            d10 = -180.0d;
        }
        this.f17202a = d10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f17202a);
        parcel.writeDouble(this.f17203b);
    }

    public DPoint(double d10, double d11) {
        this.f17202a = 0.0d;
        this.f17203b = 0.0d;
        d11 = d11 > 180.0d ? 180.0d : d11;
        d11 = d11 < -180.0d ? -180.0d : d11;
        d10 = d10 > 90.0d ? 90.0d : d10;
        d10 = d10 < -90.0d ? -90.0d : d10;
        this.f17202a = d11;
        this.f17203b = d10;
    }

    public DPoint(Parcel parcel) {
        this.f17202a = 0.0d;
        this.f17203b = 0.0d;
        this.f17202a = parcel.readDouble();
        this.f17203b = parcel.readDouble();
    }
}
