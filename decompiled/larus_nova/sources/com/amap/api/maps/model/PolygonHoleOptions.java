package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class PolygonHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<PolygonHoleOptions> CREATOR = null;
    private final List<LatLng> points;

    public static class a implements Parcelable.Creator<PolygonHoleOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public PolygonHoleOptions createFromParcel(Parcel r100) {
            return new PolygonHoleOptions(r100);
        }

        @Override // android.os.Parcelable.Creator
        public PolygonHoleOptions[] newArray(int r100) {
            return new PolygonHoleOptions[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PolygonHoleOptions() {
        this.points = new ArrayList();
        this.isPolygonHoleOptions = true;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public PolygonHoleOptions(Parcel r100) {
        this.points = r100.createTypedArrayList(LatLng.CREATOR);
        this.isPolygonHoleOptions = true;
    }

    public PolygonHoleOptions addAll(Iterable<LatLng> r100) {
        if (r100 != null) goto L12;
        return this;
    L12:
        Iterator<LatLng> r101 = r100.iterator();     // Catch: Throwable -> L9
    L6:
        if (r101.hasNext() == false) goto L11;
        LatLng r102 = r101.next();     // Catch: Throwable -> L9
        this.points.add(r102);     // Catch: Throwable -> L9
    L11:
        return this;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.points);
    }
}
