package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7340a;

    /* renamed from: b, reason: collision with root package name */
    private String f7341b;

    /* renamed from: c, reason: collision with root package name */
    private String f7342c;

    /* renamed from: d, reason: collision with root package name */
    private String f7343d;

    /* renamed from: e, reason: collision with root package name */
    private String f7344e;

    public static class a implements Parcelable.Creator<TransitBaseInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitBaseInfo createFromParcel(Parcel parcel) {
            return new TransitBaseInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitBaseInfo[] newArray(int i4) {
            return new TransitBaseInfo[i4];
        }
    }

    public TransitBaseInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7342c;
    }

    public String getArriveTime() {
        return this.f7344e;
    }

    public String getDepartureStation() {
        return this.f7341b;
    }

    public String getDepartureTime() {
        return this.f7343d;
    }

    public String getName() {
        return this.f7340a;
    }

    public void setArriveStation(String str) {
        this.f7342c = str;
    }

    public void setArriveTime(String str) {
        this.f7344e = str;
    }

    public void setDepartureStation(String str) {
        this.f7341b = str;
    }

    public void setDepartureTime(String str) {
        this.f7343d = str;
    }

    public void setName(String str) {
        this.f7340a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7340a);
        parcel.writeString(this.f7341b);
        parcel.writeString(this.f7342c);
        parcel.writeString(this.f7343d);
        parcel.writeString(this.f7344e);
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7340a = parcel.readString();
        this.f7341b = parcel.readString();
        this.f7342c = parcel.readString();
        this.f7343d = parcel.readString();
        this.f7344e = parcel.readString();
    }
}
