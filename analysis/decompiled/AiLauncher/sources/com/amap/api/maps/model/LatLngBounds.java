package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.jmsl.C1570k;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        public LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d10 = this.mWest;
            double d11 = this.mEast;
            if (d10 > d11) {
                this.mWest = d11;
                this.mEast = d10;
            }
            double d12 = this.mSouth;
            double d13 = this.mNorth;
            if (d12 > d13) {
                this.mSouth = d13;
                this.mNorth = d12;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d10 = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d10;
                this.mEast = d10;
                return this;
            }
            double d11 = this.mWest;
            double d12 = this.mEast;
            if (d11 > d12 ? !(d11 <= d10 || d10 <= d12) : !(d11 <= d10 && d10 <= d12)) {
                LatLngBoundsCreator latLngBoundsCreator = LatLngBounds.CREATOR;
                if (((d11 - d10) + 360.0d) % 360.0d < ((d10 - d12) + 360.0d) % 360.0d) {
                    this.mWest = d10;
                    return this;
                }
                this.mEast = d10;
            }
            return this;
        }
    }

    public LatLngBounds(int i10, LatLng latLng, LatLng latLng2) {
        boolean z10;
        try {
        } catch (Throwable th) {
            Log.e(CLASSNAME, "the structure parameters are illegal!");
            th.printStackTrace();
            z10 = false;
        }
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        }
        if (latLng2 == null) {
            throw new RuntimeRemoteException("null northeast");
        }
        if (latLng2.latitude >= latLng.latitude) {
            z10 = true;
            this.mVersionCode = z10 ? i10 : 0;
            this.southwest = z10 ? latLng : null;
            this.northeast = z10 ? latLng2 : null;
            return;
        }
        throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
    }

    public static Builder builder() {
        return new Builder();
    }

    public int a() {
        return this.mVersionCode;
    }

    public boolean contains(LatLng latLng) {
        LatLng latLng2;
        if (latLng == null) {
            return false;
        }
        LatLng latLng3 = this.northeast;
        if (latLng3 == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return false;
        }
        double d10 = latLng.latitude;
        return latLng2.latitude <= d10 && d10 <= latLng3.latitude && a(latLng.longitude);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public int hashCode() {
        Object[] objArr = {this.southwest, this.northeast};
        HashMap<String, Long> map = C1570k.f16700b;
        return Arrays.hashCode(objArr);
    }

    public LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d10;
        if (latLng == null) {
            return this;
        }
        if (this.northeast == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
        double dMin = Math.min(latLng2.latitude, latLng.latitude);
        double dMax = Math.max(this.northeast.latitude, latLng.latitude);
        double d11 = this.northeast.longitude;
        double d12 = this.southwest.longitude;
        double d13 = latLng.longitude;
        if (a(d13)) {
            d10 = d11;
        } else if (((d12 - d13) + 360.0d) % 360.0d < ((d13 - d11) + 360.0d) % 360.0d) {
            d12 = d13;
            d10 = d11;
        } else {
            d10 = d13;
        }
        try {
            return new LatLngBounds(new LatLng(dMin, d12, false), new LatLng(dMax, d10, false));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLngBounds) || latLngBounds.a(this);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public String toString() {
        return C1570k.e(C1570k.d("southwest", this.southwest), C1570k.d("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(a());
        parcel.writeParcelable(this.southwest, i10);
        parcel.writeParcelable(this.northeast, i10);
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2 = latLngBounds.northeast;
        if (latLng2 == null || (latLng = latLngBounds.southwest) == null) {
            return false;
        }
        double d10 = latLng2.longitude;
        double d11 = latLng.longitude + d10;
        LatLng latLng3 = this.northeast;
        double d12 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d13 = latLng4.longitude;
        double d14 = (d11 - d12) - d13;
        double d15 = ((d12 - d13) + d10) - d13;
        double d16 = latLng2.latitude;
        double d17 = latLng.latitude;
        double d18 = latLng3.latitude;
        double d19 = latLng4.latitude;
        return Math.abs(d14) < d15 && Math.abs(((d16 + d17) - d18) - d19) < ((d18 - d19) + d16) - d17;
    }

    private boolean a(double d10) {
        double d11 = this.southwest.longitude;
        double d12 = this.northeast.longitude;
        return d11 <= d12 ? d11 <= d10 && d10 <= d12 : d11 <= d10 || d10 <= d12;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
