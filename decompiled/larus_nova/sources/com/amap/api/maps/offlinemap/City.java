package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28697e;

    public static class a implements Parcelable.Creator<City> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public City createFromParcel(Parcel r100) {
            return new City(r100);
        }

        @Override // android.os.Parcelable.Creator
        public City[] newArray(int r100) {
            return new City[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public City() {
        this.f28693a = "";
        this.f28694b = "";
        this.f28695c = "";
        this.f28696d = "";
        this.f28697e = "";
    }

    public String getAdcode() {
        return this.f28697e;
    }

    public String getCity() {
        return this.f28693a;
    }

    public String getCode() {
        return this.f28694b;
    }

    public String getJianpin() {
        return this.f28695c;
    }

    public String getPinyin() {
        return this.f28696d;
    }

    public City(Parcel r100) {
        this.f28693a = "";
        this.f28694b = "";
        this.f28695c = "";
        this.f28696d = "";
        this.f28697e = "";
        this.f28693a = r100.readString();
        this.f28694b = r100.readString();
        this.f28695c = r100.readString();
        this.f28696d = r100.readString();
        this.f28697e = r100.readString();
    }

    public void setAdcode(String r100) {
        this.f28697e = r100;
    }

    public void setCity(String r100) {
        this.f28693a = r100;
    }

    public void setCode(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ("[]".equals(r100) == true) goto L8;
        this.f28694b = r100;
        return;
    }

    public void setJianpin(String r100) {
        this.f28695c = r100;
    }

    public void setPinyin(String r100) {
        this.f28696d = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28693a);
        r100.writeString(this.f28694b);
        r100.writeString(this.f28695c);
        r100.writeString(this.f28696d);
        r100.writeString(this.f28697e);
    }
}
