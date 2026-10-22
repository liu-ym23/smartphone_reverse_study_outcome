package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLonPoint f29260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f29262e;

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public float getDistance() {
        return this.f29261d;
    }

    public float getDuration() {
        return this.f29262e;
    }

    public String getID() {
        return this.f29258a;
    }

    public LatLonPoint getPoint() {
        return this.f29260c;
    }

    public String getTitle() {
        return this.f29259b;
    }

    public RoutePOIItem(Parcel r100) {
        this.f29258a = r100.readString();
        this.f29259b = r100.readString();
        this.f29260c = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29261d = r100.readFloat();
        this.f29262e = r100.readFloat();
    }

    public void setDistance(float r100) {
        this.f29261d = r100;
    }

    public void setDuration(float r100) {
        this.f29262e = r100;
    }

    public void setID(String r100) {
        this.f29258a = r100;
    }

    public void setPoint(LatLonPoint r100) {
        this.f29260c = r100;
    }

    public void setTitle(String r100) {
        this.f29259b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29258a);
        r100.writeString(this.f29259b);
        r100.writeParcelable(this.f29260c, r101);
        r100.writeFloat(this.f29261d);
        r100.writeFloat(this.f29262e);
    }
}
