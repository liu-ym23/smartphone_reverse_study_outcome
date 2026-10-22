package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f31664a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f31665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f31666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f31667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private double f31668d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private double f31669e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private double f31670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f31671g;

        private void a() {
            if ((Math.abs(this.f31668d) + Math.abs(this.f31670f)) <= 180.0d) goto L5;
            c();
            return;
        L5:
            c();
            b();
        }

        private void b() {
            double r100 = this.f31668d;
            if (r100 <= 180.0d) goto L8;
            double r101 = r100 - 360.0d;
            this.f31668d = r101;
            double r102 = this.f31667c;
            if (r101 >= r102) goto L9;
            this.f31668d = r102;
            this.f31667c = r101;
            return;
        L9:
            return;
        }

        private void c() {
            double r100 = this.f31670f + 360.0d;
            this.f31667c = r100;
            double r101 = this.f31668d;
            if (r100 <= r101) goto L6;
            this.f31668d = r100;
            this.f31667c = r101;
            return;
        }

        public LatLngBounds build() {
            double r100 = this.f31669e;
            if (r100 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        L6:
            double r101 = this.f31668d;
            if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            if (this.f31667c != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            this.f31668d = r100;
            this.f31667c = this.f31670f;
        L24:
            return new LatLngBounds(new LatLng(this.f31666b, this.f31668d), new LatLng(this.f31665a, this.f31667c));
        L13:
            if (Math.abs(r101) <= 90.0d) goto L18;
            if (Math.abs(this.f31670f) <= 90.0d) goto L18;
            c();
        L18:
            if (Math.abs(this.f31668d) < 90.0d) goto L20;
        L22:
            a();
            goto L24
        L20:
            if (Math.abs(this.f31670f) >= 90.0d) goto L22;
            c();
            b();
            goto L24
        L5:
            if (this.f31670f == AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
            goto L6
        }

        public Builder() {
            this.f31671g = true;
        }

        private void a(LatLng r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            double r101 = r100.latitude;
            double r102 = r100.longitude;
            if (r101 >= this.f31665a) goto L8;
            this.f31665a = r101;
        L8:
            if (r101 <= this.f31666b) goto L11;
            this.f31666b = r101;
        L11:
            if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L23;
            if (r102 >= this.f31667c) goto L16;
            this.f31667c = r102;
        L16:
            if (r102 <= this.f31668d) goto L20;
            this.f31668d = r102;
            if (this.f31667c != AudioStats.AUDIO_AMPLITUDE_NONE) goto L20;
            this.f31667c = r102;
        L20:
            if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
            this.f31669e = r102;
            return;
        L29:
            return;
        L23:
            if (r102 >= this.f31670f) goto L26;
            this.f31670f = r102;
        L26:
            if (r102 <= this.f31669e) goto L31;
            this.f31669e = r102;
            return;
        }

        public Builder include(List<LatLng> r100) {
            if (r100 != null) goto L4;
        L19:
            return this;
        L4:
            if (r100.size() == 0) goto L19;
            if (ListProtector.get(r100, 0) != null) goto L9;
        L15:
            Iterator<LatLng> r101 = r100.iterator();
        L17:
            if (r101.hasNext() == false) goto L19;
            a(r101.next());
            goto L17
        L9:
            if (this.f31671g == false) goto L15;
            this.f31671g = false;
            if (((LatLng) ListProtector.get(r100, 0)).longitude < AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            double r102 = ((LatLng) ListProtector.get(r100, 0)).longitude;
            this.f31667c = r102;
            this.f31668d = r102;
        L14:
            double r103 = ((LatLng) ListProtector.get(r100, 0)).latitude;
            this.f31665a = r103;
            this.f31666b = r103;
            goto L15
        L13:
            double r104 = ((LatLng) ListProtector.get(r100, 0)).longitude;
            this.f31670f = r104;
            this.f31669e = r104;
            goto L14
        }

        public Builder include(LatLng r100) {
            if (r100 != null) goto L5;
            return this;
        L5:
            if (this.f31671g == false) goto L11;
            this.f31671g = false;
            double r101 = r100.longitude;
            if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            this.f31667c = r101;
            this.f31668d = r101;
        L10:
            double r102 = r100.latitude;
            this.f31665a = r102;
            this.f31666b = r102;
            goto L11
        L9:
            this.f31670f = r101;
            this.f31669e = r101;
        L11:
            a(r100);
            return this;
        }
    }

    public static class a implements Parcelable.Creator<LatLngBounds> {
        public a() {
        }

        public LatLngBounds a(Parcel r100) {
            return new LatLngBounds(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LatLngBounds createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LatLngBounds[] newArray(int r100) {
            return a(r100);
        }

        public LatLngBounds[] a(int r100) {
            return new LatLngBounds[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public LatLng getCenter() {
        LatLng r100 = this.f31664a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        GeoPoint r101 = CoordUtil.ll2mc(this.northeast);
        GeoPoint r102 = CoordUtil.ll2mc(this.southwest);
        LatLng r103 = CoordUtil.mc2ll(new GeoPoint(((r101.getLatitudeE6() - r102.getLatitudeE6()) / 2.0d) + r102.getLatitudeE6(), ((r101.getLongitudeE6() - r102.getLongitudeE6()) / 2.0d) + r102.getLongitudeE6()));
        this.f31664a = r103;
        return r103;
    }

    public String toString() {
        return "southwest: " + this.southwest.latitude + ", " + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + ", " + this.northeast.longitude;
    }

    public LatLngBounds(Parcel r100) {
        this.northeast = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());
    }

    public boolean contains(LatLng r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        LatLng r100 = this.southwest;
        double r101 = r100.latitude;
        LatLng r102 = this.northeast;
        double r103 = r102.latitude;
        double r104 = r100.longitude;
        double r111 = r102.longitude;
        double r112 = r110.latitude;
        double r105 = r110.longitude;
        if (r112 >= r101) goto L8;
        return false;
    L8:
        if (r112 <= r103) goto L10;
        return false;
    L10:
        if (r105 >= r104) goto L12;
        return false;
    L12:
        if (r105 > r111) goto L19;
        return true;
    L19:
        return false;
    }

    public void setCenter(LatLng r100) {
        this.f31664a = r100;
    }

    public LatLngBounds(LatLng r100, LatLng r101) {
        this.northeast = r100;
        this.southwest = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.northeast, r101);
        r100.writeParcelable(this.southwest, r101);
    }
}
