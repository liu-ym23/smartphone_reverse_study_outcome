package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7349a;

    /* renamed from: b, reason: collision with root package name */
    private int f7350b;

    /* renamed from: c, reason: collision with root package name */
    private String f7351c;

    /* renamed from: d, reason: collision with root package name */
    private int f7352d;

    /* renamed from: e, reason: collision with root package name */
    private int f7353e;

    /* renamed from: f, reason: collision with root package name */
    private String f7354f;

    /* renamed from: g, reason: collision with root package name */
    private String f7355g;

    /* renamed from: h, reason: collision with root package name */
    private String f7356h;

    /* renamed from: i, reason: collision with root package name */
    private String f7357i;

    public static class a implements Parcelable.Creator<VehicleInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VehicleInfo createFromParcel(Parcel parcel) {
            return new VehicleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VehicleInfo[] newArray(int i4) {
            return new VehicleInfo[i4];
        }
    }

    public VehicleInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirectText() {
        return this.f7357i;
    }

    public String getEndTime() {
        return this.f7355g;
    }

    public String getHeadWay() {
        return this.f7356h;
    }

    public int getPassStationNum() {
        return this.f7350b;
    }

    public String getStartTime() {
        return this.f7354f;
    }

    public String getTitle() {
        return this.f7351c;
    }

    public int getTotalPrice() {
        return this.f7353e;
    }

    public String getUid() {
        return this.f7349a;
    }

    public int getZonePrice() {
        return this.f7352d;
    }

    public void setDirectText(String str) {
        this.f7357i = str;
    }

    public void setEndTime(String str) {
        this.f7355g = str;
    }

    public void setHeadWay(String str) {
        this.f7356h = str;
    }

    public void setPassStationNum(int i4) {
        this.f7350b = i4;
    }

    public void setStartTime(String str) {
        this.f7354f = str;
    }

    public void setTitle(String str) {
        this.f7351c = str;
    }

    public void setTotalPrice(int i4) {
        this.f7353e = i4;
    }

    public void setUid(String str) {
        this.f7349a = str;
    }

    public void setZonePrice(int i4) {
        this.f7352d = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7349a);
        parcel.writeInt(this.f7350b);
        parcel.writeString(this.f7351c);
        parcel.writeInt(this.f7352d);
        parcel.writeInt(this.f7353e);
        parcel.writeString(this.f7354f);
        parcel.writeString(this.f7355g);
        parcel.writeString(this.f7356h);
        parcel.writeString(this.f7357i);
    }

    public VehicleInfo(Parcel parcel) {
        this.f7349a = parcel.readString();
        this.f7350b = parcel.readInt();
        this.f7351c = parcel.readString();
        this.f7352d = parcel.readInt();
        this.f7353e = parcel.readInt();
        this.f7354f = parcel.readString();
        this.f7355g = parcel.readString();
        this.f7356h = parcel.readString();
        this.f7357i = parcel.readString();
    }
}
