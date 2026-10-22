package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LatLonPoint f29028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29030g;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getDistance() {
        return this.f29027d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f29028e;
    }

    public String getPoiId() {
        return this.f29024a;
    }

    public String getSnippet() {
        return this.f29029f;
    }

    public String getSubName() {
        return this.f29026c;
    }

    public String getSubTypeDes() {
        return this.f29030g;
    }

    public String getTitle() {
        return this.f29025b;
    }

    public SubPoiItem(Parcel r100) {
        this.f29024a = r100.readString();
        this.f29025b = r100.readString();
        this.f29026c = r100.readString();
        this.f29027d = r100.readInt();
        this.f29028e = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f29029f = r100.readString();
        this.f29030g = r100.readString();
    }

    public void setDistance(int r100) {
        this.f29027d = r100;
    }

    public void setLatLonPoint(LatLonPoint r100) {
        this.f29028e = r100;
    }

    public void setPoiId(String r100) {
        this.f29024a = r100;
    }

    public void setSnippet(String r100) {
        this.f29029f = r100;
    }

    public void setSubName(String r100) {
        this.f29026c = r100;
    }

    public void setSubTypeDes(String r100) {
        this.f29030g = r100;
    }

    public void setTitle(String r100) {
        this.f29025b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29024a);
        r100.writeString(this.f29025b);
        r100.writeString(this.f29026c);
        r100.writeInt(this.f29027d);
        r100.writeValue(this.f29028e);
        r100.writeString(this.f29029f);
        r100.writeString(this.f29030g);
    }

    public SubPoiItem(String r100, LatLonPoint r101, String r102, String r103) {
        this.f29024a = r100;
        this.f29028e = r101;
        this.f29025b = r102;
        this.f29029f = r103;
    }
}
