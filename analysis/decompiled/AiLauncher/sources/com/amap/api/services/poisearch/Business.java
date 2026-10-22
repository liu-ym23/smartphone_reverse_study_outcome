package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Business implements Parcelable {
    public static final Parcelable.Creator<Business> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17512a;

    /* renamed from: b, reason: collision with root package name */
    private String f17513b;

    /* renamed from: c, reason: collision with root package name */
    private String f17514c;

    /* renamed from: d, reason: collision with root package name */
    private String f17515d;

    /* renamed from: e, reason: collision with root package name */
    private String f17516e;

    /* renamed from: f, reason: collision with root package name */
    private String f17517f;

    /* renamed from: g, reason: collision with root package name */
    private String f17518g;

    /* renamed from: h, reason: collision with root package name */
    private String f17519h;

    /* renamed from: i, reason: collision with root package name */
    private String f17520i;

    /* renamed from: j, reason: collision with root package name */
    private String f17521j;

    public static class a implements Parcelable.Creator<Business> {
        @Override // android.os.Parcelable.Creator
        public Business createFromParcel(Parcel parcel) {
            return new Business(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Business[] newArray(int i10) {
            return new Business[i10];
        }
    }

    public Business(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f17512a = str;
        this.f17513b = str2;
        this.f17514c = str3;
        this.f17515d = str4;
        this.f17516e = str5;
        this.f17517f = str6;
        this.f17518g = str7;
        this.f17519h = str8;
        this.f17520i = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.f17520i;
    }

    public String getBusinessArea() {
        return this.f17512a;
    }

    public String getCPID() {
        return this.f17521j;
    }

    public String getCost() {
        return this.f17518g;
    }

    public String getOpentimeToday() {
        return this.f17513b;
    }

    public String getOpentimeWeek() {
        return this.f17514c;
    }

    public String getParkingType() {
        return this.f17519h;
    }

    public String getTag() {
        return this.f17516e;
    }

    public String getTel() {
        return this.f17515d;
    }

    public String getmRating() {
        return this.f17517f;
    }

    public void setCPID(String str) {
        this.f17521j = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17512a);
        parcel.writeString(this.f17513b);
        parcel.writeString(this.f17514c);
        parcel.writeString(this.f17515d);
        parcel.writeString(this.f17516e);
        parcel.writeString(this.f17517f);
        parcel.writeString(this.f17518g);
        parcel.writeString(this.f17519h);
        parcel.writeString(this.f17520i);
        parcel.writeString(this.f17521j);
    }

    public Business(Parcel parcel) {
        this.f17512a = parcel.readString();
        this.f17513b = parcel.readString();
        this.f17514c = parcel.readString();
        this.f17515d = parcel.readString();
        this.f17516e = parcel.readString();
        this.f17517f = parcel.readString();
        this.f17518g = parcel.readString();
        this.f17519h = parcel.readString();
        this.f17520i = parcel.readString();
        this.f17521j = parcel.readString();
    }
}
