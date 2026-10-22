package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class LatLng implements Parcelable, Cloneable {
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d10, double d11) {
        this(d10, d11, true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i10 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i10 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public String toString() {
        return "[" + this.longitude + Const.STR_MART_COMMA + this.latitude + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }

    public LatLng(double d10, double d11, boolean z10) throws AMapException {
        if (!z10) {
            this.latitude = d10;
            this.longitude = d11;
            return;
        }
        if (-180.0d > d11 || d11 >= 180.0d) {
            this.longitude = ((((d11 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.longitude = d11;
        }
        if (d10 < -90.0d || d10 > 90.0d) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e10) {
                e10.printStackTrace();
            }
        }
        this.latitude = Math.max(-90.0d, Math.min(90.0d, d10));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LatLng m13clone() {
        return new LatLng(this.latitude, this.longitude);
    }
}
