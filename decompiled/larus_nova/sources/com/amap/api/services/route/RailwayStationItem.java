package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLonPoint f29117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f29120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f29121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f29122h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RailwayStationItem() {
        this.f29120f = false;
        this.f29121g = false;
    }

    public String getAdcode() {
        return this.f29118d;
    }

    public String getID() {
        return this.f29115a;
    }

    public LatLonPoint getLocation() {
        return this.f29117c;
    }

    public String getName() {
        return this.f29116b;
    }

    public String getTime() {
        return this.f29119e;
    }

    public float getWait() {
        return this.f29122h;
    }

    public boolean isEnd() {
        return this.f29121g;
    }

    public boolean isStart() {
        return this.f29120f;
    }

    public RailwayStationItem(Parcel r100) {
        this.f29120f = false;
        this.f29121g = false;
        this.f29115a = r100.readString();
        this.f29116b = r100.readString();
        this.f29117c = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29118d = r100.readString();
        this.f29119e = r100.readString();
        boolean[] r101 = new boolean[2];
        r100.readBooleanArray(r101);
        this.f29120f = r101[0];
        this.f29121g = r101[1];
        this.f29122h = r100.readFloat();
    }

    public void setAdcode(String r100) {
        this.f29118d = r100;
    }

    public void setID(String r100) {
        this.f29115a = r100;
    }

    public void setLocation(LatLonPoint r100) {
        this.f29117c = r100;
    }

    public void setName(String r100) {
        this.f29116b = r100;
    }

    public void setTime(String r100) {
        this.f29119e = r100;
    }

    public void setWait(float r100) {
        this.f29122h = r100;
    }

    public void setisEnd(boolean r100) {
        this.f29121g = r100;
    }

    public void setisStart(boolean r100) {
        this.f29120f = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29115a);
        r100.writeString(this.f29116b);
        r100.writeParcelable(this.f29117c, r101);
        r100.writeString(this.f29118d);
        r100.writeString(this.f29119e);
        r100.writeBooleanArray(new boolean[]{this.f29120f, this.f29121g});
        r100.writeFloat(this.f29122h);
    }
}
