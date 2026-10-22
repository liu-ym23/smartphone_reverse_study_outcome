package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private double f7280f;

    /* renamed from: g, reason: collision with root package name */
    private String f7281g;

    /* renamed from: h, reason: collision with root package name */
    private double f7282h;

    /* renamed from: i, reason: collision with root package name */
    private String f7283i;

    public static class a implements Parcelable.Creator<PlaneInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaneInfo createFromParcel(Parcel parcel) {
            return new PlaneInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaneInfo[] newArray(int i4) {
            return new PlaneInfo[i4];
        }
    }

    public PlaneInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7281g;
    }

    public String getBooking() {
        return this.f7283i;
    }

    public double getDiscount() {
        return this.f7280f;
    }

    public double getPrice() {
        return this.f7282h;
    }

    public void setAirlines(String str) {
        this.f7281g = str;
    }

    public void setBooking(String str) {
        this.f7283i = str;
    }

    public void setDiscount(double d4) {
        this.f7280f = d4;
    }

    public void setPrice(double d4) {
        this.f7282h = d4;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeDouble(this.f7280f);
        parcel.writeString(this.f7281g);
        parcel.writeDouble(this.f7282h);
        parcel.writeString(this.f7283i);
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7280f = parcel.readDouble();
        this.f7281g = parcel.readString();
        this.f7282h = parcel.readDouble();
        this.f7283i = parcel.readString();
    }
}
