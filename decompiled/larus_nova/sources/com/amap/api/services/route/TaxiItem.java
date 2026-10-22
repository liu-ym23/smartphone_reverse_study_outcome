package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f29209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f29210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29214f;

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public LatLonPoint getDestination() {
        return this.f29210b;
    }

    public float getDistance() {
        return this.f29211c;
    }

    public float getDuration() {
        return this.f29212d;
    }

    public LatLonPoint getOrigin() {
        return this.f29209a;
    }

    public String getmSname() {
        return this.f29213e;
    }

    public String getmTname() {
        return this.f29214f;
    }

    public TaxiItem(Parcel r100) {
        this.f29209a = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29210b = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29211c = r100.readFloat();
        this.f29212d = r100.readFloat();
        this.f29213e = r100.readString();
        this.f29214f = r100.readString();
    }

    public void setDestination(LatLonPoint r100) {
        this.f29210b = r100;
    }

    public void setDistance(float r100) {
        this.f29211c = r100;
    }

    public void setDuration(float r100) {
        this.f29212d = r100;
    }

    public void setOrigin(LatLonPoint r100) {
        this.f29209a = r100;
    }

    public void setSname(String r100) {
        this.f29213e = r100;
    }

    public void setTname(String r100) {
        this.f29214f = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f29209a, r101);
        r100.writeParcelable(this.f29210b, r101);
        r100.writeFloat(this.f29211c);
        r100.writeFloat(this.f29212d);
        r100.writeString(this.f29213e);
        r100.writeString(this.f29214f);
    }
}
