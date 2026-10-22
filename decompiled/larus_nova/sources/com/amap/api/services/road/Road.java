package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LatLonPoint f29042f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Road() {
    }

    public LatLonPoint getCenterPoint() {
        return this.f29042f;
    }

    public String getCityCode() {
        return this.f29039c;
    }

    public String getId() {
        return this.f29037a;
    }

    public String getName() {
        return this.f29038b;
    }

    public float getRoadWidth() {
        return this.f29040d;
    }

    public String getType() {
        return this.f29041e;
    }

    public Road(Parcel r100) {
        this.f29037a = r100.readString();
        this.f29038b = r100.readString();
        this.f29039c = r100.readString();
        this.f29040d = r100.readFloat();
        this.f29041e = r100.readString();
        this.f29042f = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
    }

    public void setCenterPoint(LatLonPoint r100) {
        this.f29042f = r100;
    }

    public void setCityCode(String r100) {
        this.f29039c = r100;
    }

    public void setId(String r100) {
        this.f29037a = r100;
    }

    public void setName(String r100) {
        this.f29038b = r100;
    }

    public void setRoadWidth(float r100) {
        this.f29040d = r100;
    }

    public void setType(String r100) {
        this.f29041e = r100;
    }

    public Road(String r100, String r101) {
        this.f29037a = r100;
        this.f29038b = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29037a);
        r100.writeString(this.f29038b);
        r100.writeString(this.f29039c);
        r100.writeFloat(this.f29040d);
        r100.writeString(this.f29041e);
        r100.writeValue(this.f29042f);
    }
}
