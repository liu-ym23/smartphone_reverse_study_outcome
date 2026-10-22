package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17762a;

    /* renamed from: b, reason: collision with root package name */
    private float f17763b;

    public static class a implements Parcelable.Creator<RailwaySpace> {
        @Override // android.os.Parcelable.Creator
        public RailwaySpace createFromParcel(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RailwaySpace[] newArray(int i10) {
            return new RailwaySpace[i10];
        }
    }

    public RailwaySpace(String str, float f10) {
        this.f17762a = str;
        this.f17763b = f10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.f17762a;
    }

    public float getCost() {
        return this.f17763b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17762a);
        parcel.writeFloat(this.f17763b);
    }

    public RailwaySpace(Parcel parcel) {
        this.f17762a = parcel.readString();
        this.f17763b = parcel.readFloat();
    }
}
