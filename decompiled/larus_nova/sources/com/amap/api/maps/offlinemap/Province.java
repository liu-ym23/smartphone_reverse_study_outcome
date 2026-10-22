package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28739d;

    public static class a implements Parcelable.Creator<Province> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public Province createFromParcel(Parcel r100) {
            return new Province(r100);
        }

        @Override // android.os.Parcelable.Creator
        public Province[] newArray(int r100) {
            return new Province[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public Province() {
        this.f28736a = "";
        this.f28739d = "";
    }

    public String getJianpin() {
        return this.f28737b;
    }

    public String getPinyin() {
        return this.f28738c;
    }

    public String getProvinceCode() {
        return this.f28739d;
    }

    public String getProvinceName() {
        return this.f28736a;
    }

    public Province(Parcel r100) {
        this.f28736a = "";
        this.f28739d = "";
        this.f28736a = r100.readString();
        this.f28737b = r100.readString();
        this.f28738c = r100.readString();
        this.f28739d = r100.readString();
    }

    public void setJianpin(String r100) {
        this.f28737b = r100;
    }

    public void setPinyin(String r100) {
        this.f28738c = r100;
    }

    public void setProvinceCode(String r100) {
        this.f28739d = r100;
    }

    public void setProvinceName(String r100) {
        this.f28736a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28736a);
        r100.writeString(this.f28737b);
        r100.writeString(this.f28738c);
        r100.writeString(this.f28739d);
    }
}
