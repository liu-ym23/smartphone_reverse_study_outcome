package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes28.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f26775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f26776b;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DPoint() {
        this.f26775a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26776b = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public DPoint(double r100, double r101) {
        this.f26775a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26776b = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 <= 180.0d) goto L6;
        r101 = 180.0d;
    L6:
        if (r101 >= (-180.0d)) goto L9;
        r101 = -180.0d;
    L9:
        if (r100 <= 90.0d) goto L12;
        r100 = 90.0d;
    L12:
        if (r100 >= (-90.0d)) goto L14;
        r100 = -90.0d;
    L14:
        this.f26775a = r101;
        this.f26776b = r100;
    }

    public DPoint(Parcel r100) {
        this.f26775a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26776b = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f26775a = r100.readDouble();
        this.f26776b = r100.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DPoint) == true) goto L5;
        return false;
    L5:
        DPoint r101 = (DPoint) r100;
        if (this.f26776b == r101.f26776b) goto L9;
        return false;
    L9:
        if (this.f26775a == r101.f26775a) goto L11;
        return false;
    L11:
        return true;
    }

    public double getLatitude() {
        return this.f26776b;
    }

    public double getLongitude() {
        return this.f26775a;
    }

    public int hashCode() {
        return Double.valueOf((this.f26776b + this.f26775a) * 1000000.0d).intValue();
    }

    public void setLatitude(double r100) {
        if (r100 <= 90.0d) goto L6;
        r100 = 90.0d;
    L6:
        if (r100 >= (-90.0d)) goto L8;
        r100 = -90.0d;
    L8:
        this.f26776b = r100;
    }

    public void setLongitude(double r100) {
        if (r100 <= 180.0d) goto L6;
        r100 = 180.0d;
    L6:
        if (r100 >= (-180.0d)) goto L8;
        r100 = -180.0d;
    L8:
        this.f26775a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeDouble(this.f26775a);
        r100.writeDouble(this.f26776b);
    }
}
