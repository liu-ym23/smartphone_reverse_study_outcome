package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private double f7276f;

    /* renamed from: g, reason: collision with root package name */
    private String f7277g;

    /* renamed from: h, reason: collision with root package name */
    private String f7278h;

    /* renamed from: i, reason: collision with root package name */
    private String f7279i;

    public static class a implements Parcelable.Creator<CoachInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoachInfo createFromParcel(Parcel parcel) {
            return new CoachInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoachInfo[] newArray(int i4) {
            return new CoachInfo[i4];
        }
    }

    public CoachInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7277g;
    }

    public double getPrice() {
        return this.f7276f;
    }

    public String getProviderName() {
        return this.f7278h;
    }

    public String getProviderUrl() {
        return this.f7279i;
    }

    public void setBooking(String str) {
        this.f7277g = str;
    }

    public void setPrice(double d4) {
        this.f7276f = d4;
    }

    public void setProviderName(String str) {
        this.f7278h = str;
    }

    public void setProviderUrl(String str) {
        this.f7279i = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeDouble(this.f7276f);
        parcel.writeString(this.f7277g);
        parcel.writeString(this.f7278h);
        parcel.writeString(this.f7279i);
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7276f = parcel.readDouble();
        this.f7277g = parcel.readString();
        this.f7278h = parcel.readString();
        this.f7279i = parcel.readString();
    }
}
