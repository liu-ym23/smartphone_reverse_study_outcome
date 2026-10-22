package com.baidu.mapapi.model;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.AbstractC0351g;

/* loaded from: classes.dex */
public final class LatLng implements Parcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private static final String f7228a = "LatLng";
    public final double latitude;
    public final double latitudeE6;
    public final double longitude;
    public final double longitudeE6;

    public static class a implements Parcelable.Creator<LatLng> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLng createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLng[] newArray(int i4) {
            return new LatLng[i4];
        }
    }

    public LatLng(double d4, double d5) {
        if (Double.isNaN(d4) || Double.isNaN(d5) || Double.isInfinite(d4) || Double.isInfinite(d5)) {
            this.latitudeE6 = 0.0d;
            this.longitudeE6 = 0.0d;
            this.latitude = 0.0d;
            this.longitude = 0.0d;
            return;
        }
        double d6 = d4 * 1000000.0d;
        double d7 = d5 * 1000000.0d;
        this.latitudeE6 = d6;
        this.longitudeE6 = d7;
        this.latitude = d6 / 1000000.0d;
        this.longitude = d7 / 1000000.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbS = g.s(new String("latitude: "));
        sbS.append(this.latitude);
        StringBuilder sbS2 = g.s(AbstractC0351g.p(sbS.toString(), ", longitude: "));
        sbS2.append(this.longitude);
        return sbS2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitudeE6);
        parcel.writeDouble(this.longitudeE6);
    }

    public LatLng(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.latitudeE6 = parcel.readDouble();
        this.longitudeE6 = parcel.readDouble();
    }
}
