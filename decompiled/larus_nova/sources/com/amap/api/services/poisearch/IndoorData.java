package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28991c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getFloor() {
        return this.f28990b;
    }

    public String getFloorName() {
        return this.f28991c;
    }

    public String getPoiId() {
        return this.f28989a;
    }

    public IndoorData(Parcel r100) {
        this.f28989a = r100.readString();
        this.f28990b = r100.readInt();
        this.f28991c = r100.readString();
    }

    public void setFloor(int r100) {
        this.f28990b = r100;
    }

    public void setFloorName(String r100) {
        this.f28991c = r100;
    }

    public void setPoiId(String r100) {
        this.f28989a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28989a);
        r100.writeInt(this.f28990b);
        r100.writeString(this.f28991c);
    }

    public IndoorData(String r100, int r101, String r102) {
        this.f28989a = r100;
        this.f28990b = r101;
        this.f28991c = r102;
    }
}
