package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private double f7338f;

    /* renamed from: g, reason: collision with root package name */
    private String f7339g;

    public static class a implements Parcelable.Creator<TrainInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrainInfo createFromParcel(Parcel parcel) {
            return new TrainInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrainInfo[] newArray(int i4) {
            return new TrainInfo[i4];
        }
    }

    public TrainInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7339g;
    }

    public double getPrice() {
        return this.f7338f;
    }

    public void setBooking(String str) {
        this.f7339g = str;
    }

    public void setPrice(double d4) {
        this.f7338f = d4;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeDouble(this.f7338f);
        parcel.writeString(this.f7339g);
    }

    public TrainInfo(Parcel parcel) {
        super(parcel);
        this.f7338f = parcel.readDouble();
        this.f7339g = parcel.readString();
    }
}
