package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29072b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public District() {
    }

    public String getDistrictAdcode() {
        return this.f29072b;
    }

    public String getDistrictName() {
        return this.f29071a;
    }

    public District(Parcel r100) {
        this.f29071a = r100.readString();
        this.f29072b = r100.readString();
    }

    public void setDistrictAdcode(String r100) {
        this.f29072b = r100;
    }

    public void setDistrictName(String r100) {
        this.f29071a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29071a);
        r100.writeString(this.f29072b);
    }
}
