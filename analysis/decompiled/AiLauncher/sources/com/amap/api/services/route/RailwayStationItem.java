package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17764a;

    /* renamed from: b, reason: collision with root package name */
    private String f17765b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17766c;

    /* renamed from: d, reason: collision with root package name */
    private String f17767d;

    /* renamed from: e, reason: collision with root package name */
    private String f17768e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f17769f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17770g;

    /* renamed from: h, reason: collision with root package name */
    private float f17771h;

    public static class a implements Parcelable.Creator<RailwayStationItem> {
        @Override // android.os.Parcelable.Creator
        public RailwayStationItem createFromParcel(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RailwayStationItem[] newArray(int i10) {
            return new RailwayStationItem[i10];
        }
    }

    public RailwayStationItem() {
        this.f17769f = false;
        this.f17770g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f17767d;
    }

    public String getID() {
        return this.f17764a;
    }

    public LatLonPoint getLocation() {
        return this.f17766c;
    }

    public String getName() {
        return this.f17765b;
    }

    public String getTime() {
        return this.f17768e;
    }

    public float getWait() {
        return this.f17771h;
    }

    public boolean isEnd() {
        return this.f17770g;
    }

    public boolean isStart() {
        return this.f17769f;
    }

    public void setAdcode(String str) {
        this.f17767d = str;
    }

    public void setID(String str) {
        this.f17764a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f17766c = latLonPoint;
    }

    public void setName(String str) {
        this.f17765b = str;
    }

    public void setTime(String str) {
        this.f17768e = str;
    }

    public void setWait(float f10) {
        this.f17771h = f10;
    }

    public void setisEnd(boolean z10) {
        this.f17770g = z10;
    }

    public void setisStart(boolean z10) {
        this.f17769f = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17764a);
        parcel.writeString(this.f17765b);
        parcel.writeParcelable(this.f17766c, i10);
        parcel.writeString(this.f17767d);
        parcel.writeString(this.f17768e);
        parcel.writeBooleanArray(new boolean[]{this.f17769f, this.f17770g});
        parcel.writeFloat(this.f17771h);
    }

    public RailwayStationItem(Parcel parcel) {
        this.f17769f = false;
        this.f17770g = false;
        this.f17764a = parcel.readString();
        this.f17765b = parcel.readString();
        this.f17766c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17767d = parcel.readString();
        this.f17768e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f17769f = zArr[0];
        this.f17770g = zArr[1];
        this.f17771h = parcel.readFloat();
    }
}
