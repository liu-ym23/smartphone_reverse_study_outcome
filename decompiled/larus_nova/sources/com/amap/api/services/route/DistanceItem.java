package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = null;
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29062f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f29057a = 1;
        this.f29058b = 1;
        this.f29059c = 0.0f;
        this.f29060d = 0.0f;
    }

    public int getDestId() {
        return this.f29058b;
    }

    public float getDistance() {
        return this.f29059c;
    }

    public float getDuration() {
        return this.f29060d;
    }

    public int getErrorCode() {
        return this.f29062f;
    }

    public String getErrorInfo() {
        return this.f29061e;
    }

    public int getOriginId() {
        return this.f29057a;
    }

    public DistanceItem(Parcel r100) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f29057a = 1;
        this.f29058b = 1;
        this.f29059c = 0.0f;
        this.f29060d = 0.0f;
        this.f29057a = r100.readInt();
        this.f29058b = r100.readInt();
        this.f29059c = r100.readFloat();
        this.f29060d = r100.readFloat();
        this.f29061e = r100.readString();
        this.f29062f = r100.readInt();
    }

    public void setDestId(int r100) {
        this.f29058b = r100;
    }

    public void setDistance(float r100) {
        this.f29059c = r100;
    }

    public void setDuration(float r100) {
        this.f29060d = r100;
    }

    public void setErrorCode(int r100) {
        this.f29062f = r100;
    }

    public void setErrorInfo(String r100) {
        this.f29061e = r100;
    }

    public void setOriginId(int r100) {
        this.f29057a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f29057a);
        r100.writeInt(this.f29058b);
        r100.writeFloat(this.f29059c);
        r100.writeFloat(this.f29060d);
        r100.writeString(this.f29061e);
        r100.writeInt(this.f29062f);
    }
}
