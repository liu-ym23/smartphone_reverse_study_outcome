package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17522a;

    /* renamed from: b, reason: collision with root package name */
    private int f17523b;

    /* renamed from: c, reason: collision with root package name */
    private String f17524c;

    public static class a implements Parcelable.Creator<IndoorData> {
        @Override // android.os.Parcelable.Creator
        public IndoorData createFromParcel(Parcel parcel) {
            return new IndoorData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IndoorData[] newArray(int i10) {
            return new IndoorData[i10];
        }
    }

    public IndoorData(String str, int i10, String str2) {
        this.f17522a = str;
        this.f17523b = i10;
        this.f17524c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f17523b;
    }

    public String getFloorName() {
        return this.f17524c;
    }

    public String getPoiId() {
        return this.f17522a;
    }

    public void setFloor(int i10) {
        this.f17523b = i10;
    }

    public void setFloorName(String str) {
        this.f17524c = str;
    }

    public void setPoiId(String str) {
        this.f17522a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17522a);
        parcel.writeInt(this.f17523b);
        parcel.writeString(this.f17524c);
    }

    public IndoorData(Parcel parcel) {
        this.f17522a = parcel.readString();
        this.f17523b = parcel.readInt();
        this.f17524c = parcel.readString();
    }
}
