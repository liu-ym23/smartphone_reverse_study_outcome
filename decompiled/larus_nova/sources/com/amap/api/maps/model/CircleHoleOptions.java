package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes28.dex */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = null;
    private LatLng point;
    private double radius;

    public static class a implements Parcelable.Creator<CircleHoleOptions> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public CircleHoleOptions createFromParcel(Parcel r100) {
            return new CircleHoleOptions(r100);
        }

        @Override // android.os.Parcelable.Creator
        public CircleHoleOptions[] newArray(int r100) {
            return new CircleHoleOptions[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public CircleHoleOptions() {
        this.point = null;
        this.radius = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.isPolygonHoleOptions = false;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions(Parcel r100) {
        this.point = null;
        this.radius = AudioStats.AUDIO_AMPLITUDE_NONE;
        Bundle r101 = r100.readBundle();
        this.point = new LatLng(r101.getDouble("lat"), r101.getDouble("lng"));
        this.radius = r100.readDouble();
    }

    public CircleHoleOptions center(LatLng r100) {
        this.point = r100;
        return this;
    }

    public CircleHoleOptions radius(double r100) {
        this.radius = r100;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Bundle r102 = new Bundle();
        LatLng r103 = this.point;
        if (r103 == null) goto L5;
        r102.putDouble("lat", r103.latitude);
        r102.putDouble("lng", this.point.longitude);
    L5:
        r100.writeBundle(r102);
        r100.writeDouble(this.radius);
    }
}
