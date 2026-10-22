package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = null;
    private final LatLng coordinate;
    private final String name;
    private final String poiid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new PoiCreator();
    }

    public String toString() {
        return "poiid " + this.poiid + " name:" + this.name + "  coordinate:" + this.coordinate.toString();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public LatLng getCoordinate() {
        return this.coordinate;
    }

    public String getName() {
        return this.name;
    }

    public String getPoiId() {
        return this.poiid;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if ((r100 instanceof Poi) == false) goto L19;
        Poi r101 = (Poi) r100;
        if (r101.getName().equals(this.name) == true) goto L13;
    L17:
        return false;
    L13:
        if (r101.getCoordinate().equals(this.coordinate) == false) goto L17;
        if (r101.getPoiId().equals(this.poiid) == false) goto L17;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.name);
        r100.writeParcelable(this.coordinate, r101);
        r100.writeString(this.poiid);
    }

    public Poi(String r100, LatLng r101, String r102) {
        this.name = r100;
        this.coordinate = r101;
        this.poiid = r102;
    }
}
