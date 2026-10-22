package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.w3;
import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = null;
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double mEast;
        private double mNorth;
        private double mSouth;
        private double mWest;

        public LatLngBounds build() {
            if (Double.isNaN(this.mWest) == false) goto L6;
            return null;
        L6:
            double r100 = this.mWest;
            double r101 = this.mEast;
            if (r100 <= r101) goto L9;
            this.mWest = r101;
            this.mEast = r100;
        L9:
            double r102 = this.mSouth;
            double r103 = this.mNorth;
            if (r102 <= r103) goto L13;
            this.mSouth = r103;
            this.mNorth = r102;
        L13:
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public Builder() {
            this.mSouth = Double.POSITIVE_INFINITY;
            this.mNorth = Double.NEGATIVE_INFINITY;
            this.mWest = Double.NaN;
            this.mEast = Double.NaN;
        }

        public Builder include(LatLng r100) {
            if (r100 != null) goto L4;
            return this;
        L4:
            this.mSouth = Math.min(this.mSouth, r100.latitude);
            this.mNorth = Math.max(this.mNorth, r100.latitude);
            double r101 = r100.longitude;
            if (Double.isNaN(this.mWest) == false) goto L7;
            this.mWest = r101;
            this.mEast = r101;
        L26:
            return this;
        L7:
            double r102 = this.mWest;
            double r103 = this.mEast;
            if (r102 > r103) goto L15;
            if (r102 <= r101) goto L12;
        L19:
            boolean r104 = false;
        L21:
            if (r104 == true) goto L26;
            LatLngBoundsCreator r105 = LatLngBounds.CREATOR;
            if ((((r102 - r101) + 360.0d) % 360.0d) >= (((r101 - r103) + 360.0d) % 360.0d)) goto L25;
            this.mWest = r101;
            goto L26
        L25:
            this.mEast = r101;
            goto L26
        L12:
            if (r101 > r103) goto L19;
        L20:
            r104 = true;
            goto L21
        L15:
            if (r102 <= r101) goto L20;
            if (r101 > r103) goto L19;
            goto L19
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        Object[] r100 = {this.southwest, this.northeast};
        int r101 = w3.f28280b;
        return Arrays.hashCode(r100);
    }

    public String toString() {
        return w3.a(new String[]{w3.a("southwest", this.southwest), w3.a("northeast", this.northeast)});
    }

    static {
        CREATOR = new LatLngBoundsCreator();
    }

    public static Builder builder() {
        return new Builder();
    }

    public int a() {
        return this.mVersionCode;
    }

    private boolean a(LatLngBounds r110) {
        LatLng r100 = r110.northeast;
        if (r100 == null) goto L14;
        LatLng r101 = r110.southwest;
        if (r101 == null) goto L17;
        double r102 = r100.longitude;
        double r103 = r101.longitude;
        LatLng r111 = this.northeast;
        double r112 = r111.longitude;
        LatLng r113 = this.southwest;
        double r114 = r113.longitude;
        double r104 = ((r102 + r103) - r112) - r114;
        double r115 = ((r112 - r114) + r102) - r103;
        double r105 = r100.latitude;
        double r106 = r101.latitude;
        double r116 = r111.latitude;
        double r107 = r113.latitude;
        double r108 = ((r105 + r106) - r116) - r107;
        double r117 = ((r116 - r107) + r105) - r106;
        if (Math.abs(r104) < r115) goto L10;
    L12:
        return false;
    L10:
        if (Math.abs(r108) >= r117) goto L12;
        return true;
    L17:
        return false;
    L14:
        return false;
    }

    public boolean contains(LatLng r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        LatLng r101 = this.northeast;
        if (r101 == null) goto L21;
        LatLng r102 = this.southwest;
        if (r102 == null) goto L24;
        double r103 = r100.latitude;
        if (r102.latitude <= r103) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L18;
        return false;
    L18:
        if (a(r100.longitude) == false) goto L23;
        return true;
    L23:
        return false;
    L13:
        if (r103 > r101.latitude) goto L15;
        r104 = true;
        goto L16
    L24:
        return false;
    L21:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LatLngBounds) == true) goto L8;
        return false;
    L8:
        LatLngBounds r101 = (LatLngBounds) r100;
        if (this.southwest.equals(r101.southwest) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.northeast.equals(r101.northeast) == false) goto L13;
        return true;
    }

    public LatLngBounds including(LatLng r210) {
        if (r210 != null) goto L6;
        return this;
    L6:
        if (this.northeast == null) goto L21;
        LatLng r100 = this.southwest;
        if (r100 == null) goto L21;
        double r101 = Math.min(r100.latitude, r210.latitude);
        double r102 = Math.max(this.northeast.latitude, r210.latitude);
        double r103 = this.northeast.longitude;
        double r104 = this.southwest.longitude;
        double r110 = r210.longitude;
        if (a(r110) == false) goto L13;
    L16:
        double r111 = r103;
    L22:
        return new LatLngBounds(new LatLng(r101, r104, false), new LatLng(r102, r111, false));
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    L13:
        if ((((r104 - r110) + 360.0d) % 360.0d) >= (((r110 - r103) + 360.0d) % 360.0d)) goto L15;
        r104 = r110;
        goto L16
    L15:
        r111 = r110;
    L21:
        return this;
    }

    public boolean intersects(LatLngBounds r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.northeast != null) goto L8;
        return false;
    L8:
        if (this.southwest != null) goto L11;
        return false;
    L11:
        if (a(r100) == false) goto L13;
    L14:
        return true;
    L13:
        if (r100.a(this) == true) goto L14;
        return false;
    }

    private boolean a(double r100) {
        double r101 = this.southwest.longitude;
        double r102 = this.northeast.longitude;
        if (r101 > r102) goto L11;
        if (r101 <= r100) goto L7;
        return false;
    L7:
        if (r100 > r102) goto L17;
        return true;
    L17:
        return false;
    L11:
        if (r101 > r100) goto L13;
    L14:
        return true;
    L13:
        if (r100 <= r102) goto L14;
        return false;
    }

    public boolean contains(LatLngBounds r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (contains(r100.southwest) == true) goto L8;
        return false;
    L8:
        if (contains(r100.northeast) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public LatLngBounds(LatLng r100, LatLng r101) {
        this(1, r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(a());
        r100.writeParcelable(this.southwest, r101);
        r100.writeParcelable(this.northeast, r101);
    }

    public LatLngBounds(int r100, LatLng r101, LatLng r110) {
        if (r101 == null) goto L13;
        if (r110 == null) goto L11;
        if (r110.latitude < r101.latitude) goto L9;
        boolean r102 = true;
    L16:
        if (r102 == true) goto L19;
        r100 = 0;
    L19:
        this.mVersionCode = r100;
        if (r102 == true) goto L23;
        r101 = null;
    L23:
        this.southwest = r101;
        if (r102 == true) goto L27;
        r110 = null;
    L27:
        this.northeast = r110;
        return;
    L9:
        throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + r101.latitude + " > " + r110.latitude + ")");     // Catch: Throwable -> L14
    L11:
        throw new RuntimeRemoteException("null northeast");     // Catch: Throwable -> L14
    L13:
        throw new RuntimeRemoteException("null southwest");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        r102 = false;
        goto L16
    }
}
