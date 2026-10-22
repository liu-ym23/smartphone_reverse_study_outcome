package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TopListItem implements Parcelable {
    public static final Parcelable.Creator<TopListItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17612a;

    /* renamed from: b, reason: collision with root package name */
    private String f17613b;

    public static class a implements Parcelable.Creator<TopListItem> {
        @Override // android.os.Parcelable.Creator
        public TopListItem createFromParcel(Parcel parcel) {
            return new TopListItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TopListItem[] newArray(int i10) {
            return new TopListItem[i10];
        }
    }

    public TopListItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.f17613b;
    }

    public String getType() {
        return this.f17612a;
    }

    public void setName(String str) {
        this.f17613b = str;
    }

    public void setType(String str) {
        this.f17612a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17612a);
        parcel.writeString(this.f17613b);
    }

    public TopListItem(String str, String str2) {
        this.f17612a = str;
        this.f17613b = str2;
    }

    public TopListItem(Parcel parcel) {
        this.f17612a = parcel.readString();
        this.f17613b = parcel.readString();
    }
}
