package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;

/* JADX INFO: loaded from: classes28.dex */
public final class LatLng implements Parcelable, Cloneable {
    public static final LatLngCreator CREATOR = null;
    public final double latitude;
    public final double longitude;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new LatLngCreator();
    }

    public LatLng clone() {
        return new LatLng(this.latitude, this.longitude);
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.latitude);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) + 31;
        long r102 = Double.doubleToLongBits(this.longitude);
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8026clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LatLng) == true) goto L8;
        return false;
    L8:
        LatLng r101 = (LatLng) r100;
        if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(r101.latitude)) goto L11;
    L13:
        return false;
    L11:
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(r101.longitude)) goto L13;
        return true;
    }

    public LatLng(double r100, double r101) {
        this(r100, r101, true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeDouble(this.longitude);
        r100.writeDouble(this.latitude);
    }

    public LatLng(double r100, double r101, boolean r102) {
        if (r102 == true) goto L5;
        this.latitude = r100;
        this.longitude = r101;
        return;
    L5:
        if ((-180.0d) <= r101) goto L7;
    L9:
        this.longitude = ((((r101 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
    L11:
        if (r100 >= (-90.0d)) goto L13;
    L22:
    L17:
        e = move-exception;
        e.printStackTrace();
    L19:
        this.latitude = Math.max(-90.0d, Math.min(90.0d, r100));
        return;
    L16:
        throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);     // Catch: AMapException -> L17
    L13:
        if (r100 > 90.0d) goto L22;
    L7:
        if (r101 >= 180.0d) goto L9;
        this.longitude = r101;
        goto L11
    }
}
