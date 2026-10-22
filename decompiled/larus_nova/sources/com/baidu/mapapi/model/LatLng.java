package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes39.dex */
public final class LatLng implements Parcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31663a = null;
    public final double latitude;
    public final double latitudeE6;
    public final double longitude;
    public final double longitudeE6;

    public static class a implements Parcelable.Creator<LatLng> {
        public a() {
        }

        public LatLng a(Parcel r100) {
            return new LatLng(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LatLng createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LatLng[] newArray(int r100) {
            return a(r100);
        }

        public LatLng[] a(int r100) {
            return new LatLng[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        f31663a = "LatLng";
        CREATOR = new a();
    }

    public String toString() {
        return ((new String("latitude: ") + this.latitude) + ", longitude: ") + this.longitude;
    }

    public LatLng(Parcel r100) {
        this.latitude = r100.readDouble();
        this.longitude = r100.readDouble();
        this.latitudeE6 = r100.readDouble();
        this.longitudeE6 = r100.readDouble();
    }

    public LatLng(double r100, double r101) {
        if (Double.isNaN(r100) == false) goto L5;
    L13:
        this.latitudeE6 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.longitudeE6 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        return;
    L5:
        if (Double.isNaN(r101) == true) goto L13;
        if (Double.isInfinite(r100) == true) goto L13;
        if (Double.isInfinite(r101) == true) goto L13;
        double r102 = r100 * 1000000.0d;
        double r103 = r101 * 1000000.0d;
        this.latitudeE6 = r102;
        this.longitudeE6 = r103;
        this.latitude = r102 / 1000000.0d;
        this.longitude = r103 / 1000000.0d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeDouble(this.latitude);
        r100.writeDouble(this.longitude);
        r100.writeDouble(this.latitudeE6);
        r100.writeDouble(this.longitudeE6);
    }
}
