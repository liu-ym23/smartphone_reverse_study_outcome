package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.w3;
import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public final class VisibleRegion implements Parcelable {
    public static final VisibleRegionCreator CREATOR = null;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    private final int mVersionCode;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        Object[] r100 = {this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds};
        int r101 = w3.f28280b;
        return Arrays.hashCode(r100);
    }

    public String toString() {
        return w3.a(new String[]{w3.a("nearLeft", this.nearLeft), w3.a("nearRight", this.nearRight), w3.a("farLeft", this.farLeft), w3.a("farRight", this.farRight), w3.a("latLngBounds", this.latLngBounds)});
    }

    static {
        CREATOR = new VisibleRegionCreator();
    }

    public int a() {
        return this.mVersionCode;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VisibleRegion) == true) goto L8;
        return false;
    L8:
        VisibleRegion r101 = (VisibleRegion) r100;
        if (this.nearLeft.equals(r101.nearLeft) == true) goto L11;
    L19:
        return false;
    L11:
        if (this.nearRight.equals(r101.nearRight) == false) goto L19;
        if (this.farLeft.equals(r101.farLeft) == false) goto L19;
        if (this.farRight.equals(r101.farRight) == false) goto L19;
        if (this.latLngBounds.equals(r101.latLngBounds) == false) goto L19;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(a());
        r100.writeParcelable(this.nearLeft, r101);
        r100.writeParcelable(this.nearRight, r101);
        r100.writeParcelable(this.farLeft, r101);
        r100.writeParcelable(this.farRight, r101);
        r100.writeParcelable(this.latLngBounds, r101);
    }

    public VisibleRegion(LatLng r100, LatLng r101, LatLng r110, LatLng r111, LatLngBounds r112) {
        this(1, r100, r101, r110, r111, r112);
    }

    public VisibleRegion(int r100, LatLng r101, LatLng r102, LatLng r103, LatLng r104, LatLngBounds r105) {
        this.mVersionCode = r100;
        this.nearLeft = r101;
        this.nearRight = r102;
        this.farLeft = r103;
        this.farRight = r104;
        this.latLngBounds = r105;
    }
}
