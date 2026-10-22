package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new a();
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* renamed from: a, reason: collision with root package name */
    private int f17681a;

    /* renamed from: b, reason: collision with root package name */
    private int f17682b;

    /* renamed from: c, reason: collision with root package name */
    private float f17683c;

    /* renamed from: d, reason: collision with root package name */
    private float f17684d;

    /* renamed from: e, reason: collision with root package name */
    private String f17685e;

    /* renamed from: f, reason: collision with root package name */
    private int f17686f;

    public static class a implements Parcelable.Creator<DistanceItem> {
        @Override // android.os.Parcelable.Creator
        public DistanceItem createFromParcel(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistanceItem[] newArray(int i10) {
            return new DistanceItem[i10];
        }
    }

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f17681a = 1;
        this.f17682b = 1;
        this.f17683c = 0.0f;
        this.f17684d = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.f17682b;
    }

    public float getDistance() {
        return this.f17683c;
    }

    public float getDuration() {
        return this.f17684d;
    }

    public int getErrorCode() {
        return this.f17686f;
    }

    public String getErrorInfo() {
        return this.f17685e;
    }

    public int getOriginId() {
        return this.f17681a;
    }

    public void setDestId(int i10) {
        this.f17682b = i10;
    }

    public void setDistance(float f10) {
        this.f17683c = f10;
    }

    public void setDuration(float f10) {
        this.f17684d = f10;
    }

    public void setErrorCode(int i10) {
        this.f17686f = i10;
    }

    public void setErrorInfo(String str) {
        this.f17685e = str;
    }

    public void setOriginId(int i10) {
        this.f17681a = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17681a);
        parcel.writeInt(this.f17682b);
        parcel.writeFloat(this.f17683c);
        parcel.writeFloat(this.f17684d);
        parcel.writeString(this.f17685e);
        parcel.writeInt(this.f17686f);
    }

    public DistanceItem(Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f17681a = 1;
        this.f17682b = 1;
        this.f17683c = 0.0f;
        this.f17684d = 0.0f;
        this.f17681a = parcel.readInt();
        this.f17682b = parcel.readInt();
        this.f17683c = parcel.readFloat();
        this.f17684d = parcel.readFloat();
        this.f17685e = parcel.readString();
        this.f17686f = parcel.readInt();
    }
}
