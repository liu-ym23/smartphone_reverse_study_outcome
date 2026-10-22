package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f7332a;

    /* renamed from: b, reason: collision with root package name */
    private String f7333b;

    /* renamed from: c, reason: collision with root package name */
    private int f7334c;

    /* renamed from: d, reason: collision with root package name */
    private int f7335d;

    /* renamed from: e, reason: collision with root package name */
    private float f7336e;

    /* renamed from: f, reason: collision with root package name */
    private float f7337f;

    public static class a implements Parcelable.Creator<TaxiInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TaxiInfo[] newArray(int i4) {
            return new TaxiInfo[i4];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TaxiInfo createFromParcel(Parcel parcel) {
            return new TaxiInfo(parcel);
        }
    }

    public TaxiInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7333b;
    }

    public int getDistance() {
        return this.f7334c;
    }

    public int getDuration() {
        return this.f7335d;
    }

    public float getPerKMPrice() {
        return this.f7336e;
    }

    public float getStartPrice() {
        return this.f7337f;
    }

    public float getTotalPrice() {
        return this.f7332a;
    }

    public void setDesc(String str) {
        this.f7333b = str;
    }

    public void setDistance(int i4) {
        this.f7334c = i4;
    }

    public void setDuration(int i4) {
        this.f7335d = i4;
    }

    public void setPerKMPrice(float f4) {
        this.f7336e = f4;
    }

    public void setStartPrice(float f4) {
        this.f7337f = f4;
    }

    public void setTotalPrice(float f4) {
        this.f7332a = f4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f7332a);
        parcel.writeString(this.f7333b);
        parcel.writeInt(this.f7334c);
        parcel.writeInt(this.f7335d);
        parcel.writeFloat(this.f7336e);
        parcel.writeFloat(this.f7337f);
    }

    public TaxiInfo(Parcel parcel) {
        this.f7332a = parcel.readFloat();
        this.f7333b = parcel.readString();
        this.f7334c = parcel.readInt();
        this.f7335d = parcel.readInt();
        this.f7336e = parcel.readFloat();
        this.f7337f = parcel.readFloat();
    }
}
