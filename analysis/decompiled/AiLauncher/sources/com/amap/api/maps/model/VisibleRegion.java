package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1570k;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class VisibleRegion implements Parcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    private final int mVersionCode;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(int i10, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.mVersionCode = i10;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public int a() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    public int hashCode() {
        Object[] objArr = {this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds};
        HashMap<String, Long> map = C1570k.f16700b;
        return Arrays.hashCode(objArr);
    }

    public String toString() {
        return C1570k.e(C1570k.d("nearLeft", this.nearLeft), C1570k.d("nearRight", this.nearRight), C1570k.d("farLeft", this.farLeft), C1570k.d("farRight", this.farRight), C1570k.d("latLngBounds", this.latLngBounds));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(a());
        parcel.writeParcelable(this.nearLeft, i10);
        parcel.writeParcelable(this.nearRight, i10);
        parcel.writeParcelable(this.farLeft, i10);
        parcel.writeParcelable(this.farRight, i10);
        parcel.writeParcelable(this.latLngBounds, i10);
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }
}
