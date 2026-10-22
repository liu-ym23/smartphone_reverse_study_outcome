package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17529a;

    /* renamed from: b, reason: collision with root package name */
    private String f17530b;

    public static class a implements Parcelable.Creator<Photo> {
        @Override // android.os.Parcelable.Creator
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Photo[] newArray(int i10) {
            return null;
        }
    }

    public Photo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.f17529a;
    }

    public String getUrl() {
        return this.f17530b;
    }

    public void setTitle(String str) {
        this.f17529a = str;
    }

    public void setUrl(String str) {
        this.f17530b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17529a);
        parcel.writeString(this.f17530b);
    }

    public Photo(String str, String str2) {
        this.f17529a = str;
        this.f17530b = str2;
    }

    public Photo(Parcel parcel) {
        this.f17529a = parcel.readString();
        this.f17530b = parcel.readString();
    }
}
