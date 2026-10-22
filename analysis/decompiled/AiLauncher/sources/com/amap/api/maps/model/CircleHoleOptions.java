package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1570k;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new a();
    private LatLng point;
    private final List<LatLng> points;
    private double radius;

    public static class a implements Parcelable.Creator<CircleHoleOptions> {
        @Override // android.os.Parcelable.Creator
        public CircleHoleOptions createFromParcel(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CircleHoleOptions[] newArray(int i10) {
            return new CircleHoleOptions[i10];
        }
    }

    public CircleHoleOptions() {
        this.point = null;
        this.radius = 0.0d;
        this.points = new ArrayList();
        this.isPolygonHoleOptions = false;
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    @Override // com.amap.api.maps.model.BaseHoleOptions
    public List<LatLng> getPoints() {
        return this.points;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d10) {
        this.radius = d10;
        if (this.point != null && d10 != 0.0d) {
            this.points.clear();
            C1570k.k(this.points, this.point, this.radius);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(Const.JSON_KEY_LAT, latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeTypedList(this.points);
    }

    public CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        Bundle bundle = parcel.readBundle();
        this.point = new LatLng(bundle.getDouble(Const.JSON_KEY_LAT), bundle.getDouble("lng"));
        this.radius = parcel.readDouble();
        this.points = parcel.createTypedArrayList(LatLng.CREATOR);
    }
}
