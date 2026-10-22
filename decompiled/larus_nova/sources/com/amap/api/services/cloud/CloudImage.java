package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28800c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getId() {
        return this.f28798a;
    }

    public String getPreurl() {
        return this.f28799b;
    }

    public String getUrl() {
        return this.f28800c;
    }

    public CloudImage(Parcel r100) {
        this.f28798a = r100.readString();
        this.f28799b = r100.readString();
        this.f28800c = r100.readString();
    }

    public void setId(String r100) {
        this.f28798a = r100;
    }

    public void setPreurl(String r100) {
        this.f28799b = r100;
    }

    public void setUrl(String r100) {
        this.f28800c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28798a);
        r100.writeString(this.f28799b);
        r100.writeString(this.f28800c);
    }

    public CloudImage(String r100, String r101, String r102) {
        this.f28798a = r100;
        this.f28799b = r101;
        this.f28800c = r102;
    }
}
