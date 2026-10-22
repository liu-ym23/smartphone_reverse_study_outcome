package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f17525a;

    /* renamed from: b, reason: collision with root package name */
    private String f17526b;

    /* renamed from: c, reason: collision with root package name */
    private int f17527c;

    /* renamed from: d, reason: collision with root package name */
    private String f17528d;

    public static class a implements Parcelable.Creator<IndoorDataV2> {
        @Override // android.os.Parcelable.Creator
        public IndoorDataV2 createFromParcel(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IndoorDataV2[] newArray(int i10) {
            return new IndoorDataV2[i10];
        }
    }

    public IndoorDataV2(boolean z10, String str, int i10, String str2) {
        this.f17525a = z10;
        this.f17526b = str;
        this.f17527c = i10;
        this.f17528d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f17527c;
    }

    public String getFloorName() {
        return this.f17528d;
    }

    public String getPoiId() {
        return this.f17526b;
    }

    public boolean isIndoorMap() {
        return this.f17525a;
    }

    public void setFloor(int i10) {
        this.f17527c = i10;
    }

    public void setFloorName(String str) {
        this.f17528d = str;
    }

    public void setIndoorMap(boolean z10) {
        this.f17525a = z10;
    }

    public void setPoiId(String str) {
        this.f17526b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBooleanArray(new boolean[]{this.f17525a});
        parcel.writeString(this.f17526b);
        parcel.writeInt(this.f17527c);
        parcel.writeString(this.f17528d);
    }

    public IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f17525a = zArr[0];
        this.f17526b = parcel.readString();
        this.f17527c = parcel.readInt();
        this.f17528d = parcel.readString();
    }
}
