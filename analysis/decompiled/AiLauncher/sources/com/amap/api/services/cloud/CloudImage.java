package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17303a;

    /* renamed from: b, reason: collision with root package name */
    private String f17304b;

    /* renamed from: c, reason: collision with root package name */
    private String f17305c;

    public static class a implements Parcelable.Creator<CloudImage> {
        @Override // android.os.Parcelable.Creator
        public CloudImage createFromParcel(Parcel parcel) {
            return new CloudImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CloudImage[] newArray(int i10) {
            return new CloudImage[i10];
        }
    }

    public CloudImage(String str, String str2, String str3) {
        this.f17303a = str;
        this.f17304b = str2;
        this.f17305c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f17303a;
    }

    public String getPreurl() {
        return this.f17304b;
    }

    public String getUrl() {
        return this.f17305c;
    }

    public void setId(String str) {
        this.f17303a = str;
    }

    public void setPreurl(String str) {
        this.f17304b = str;
    }

    public void setUrl(String str) {
        this.f17305c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17303a);
        parcel.writeString(this.f17304b);
        parcel.writeString(this.f17305c);
    }

    public CloudImage(Parcel parcel) {
        this.f17303a = parcel.readString();
        this.f17304b = parcel.readString();
        this.f17305c = parcel.readString();
    }
}
