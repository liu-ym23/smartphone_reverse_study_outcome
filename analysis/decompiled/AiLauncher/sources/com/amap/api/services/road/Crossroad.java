package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new a();

    /* renamed from: g, reason: collision with root package name */
    private float f17623g;

    /* renamed from: h, reason: collision with root package name */
    private String f17624h;

    /* renamed from: i, reason: collision with root package name */
    private String f17625i;

    /* renamed from: j, reason: collision with root package name */
    private String f17626j;

    /* renamed from: k, reason: collision with root package name */
    private String f17627k;

    /* renamed from: l, reason: collision with root package name */
    private String f17628l;

    public static class a implements Parcelable.Creator<Crossroad> {
        @Override // android.os.Parcelable.Creator
        public Crossroad createFromParcel(Parcel parcel) {
            return new Crossroad(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Crossroad[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ Crossroad(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f17624h;
    }

    public float getDistance() {
        return this.f17623g;
    }

    public String getFirstRoadId() {
        return this.f17625i;
    }

    public String getFirstRoadName() {
        return this.f17626j;
    }

    public String getSecondRoadId() {
        return this.f17627k;
    }

    public String getSecondRoadName() {
        return this.f17628l;
    }

    public void setDirection(String str) {
        this.f17624h = str;
    }

    public void setDistance(float f10) {
        this.f17623g = f10;
    }

    public void setFirstRoadId(String str) {
        this.f17625i = str;
    }

    public void setFirstRoadName(String str) {
        this.f17626j = str;
    }

    public void setSecondRoadId(String str) {
        this.f17627k = str;
    }

    public void setSecondRoadName(String str) {
        this.f17628l = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17623g);
        parcel.writeString(this.f17624h);
        parcel.writeString(this.f17625i);
        parcel.writeString(this.f17626j);
        parcel.writeString(this.f17627k);
        parcel.writeString(this.f17628l);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f17623g = parcel.readFloat();
        this.f17624h = parcel.readString();
        this.f17625i = parcel.readString();
        this.f17626j = parcel.readString();
        this.f17627k = parcel.readString();
        this.f17628l = parcel.readString();
    }
}
