package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f7306a;

    /* renamed from: b, reason: collision with root package name */
    private double f7307b;

    public static class a implements Parcelable.Creator<PriceInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PriceInfo createFromParcel(Parcel parcel) {
            return new PriceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PriceInfo[] newArray(int i4) {
            return new PriceInfo[i4];
        }
    }

    public PriceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f7307b;
    }

    public int getTicketType() {
        return this.f7306a;
    }

    public void setTicketPrice(double d4) {
        this.f7307b = d4;
    }

    public void setTicketType(int i4) {
        this.f7306a = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f7306a);
        parcel.writeDouble(this.f7307b);
    }

    public PriceInfo(Parcel parcel) {
        this.f7306a = parcel.readInt();
        this.f7307b = parcel.readDouble();
    }
}
