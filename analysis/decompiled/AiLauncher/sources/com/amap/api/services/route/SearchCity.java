package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17926a;

    /* renamed from: b, reason: collision with root package name */
    private String f17927b;

    /* renamed from: c, reason: collision with root package name */
    private String f17928c;

    public static class a implements Parcelable.Creator<SearchCity> {
        @Override // android.os.Parcelable.Creator
        public SearchCity createFromParcel(Parcel parcel) {
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchCity[] newArray(int i10) {
            return null;
        }
    }

    public SearchCity(Parcel parcel) {
        this.f17926a = parcel.readString();
        this.f17927b = parcel.readString();
        this.f17928c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f17928c;
    }

    public String getSearchCityName() {
        return this.f17926a;
    }

    public String getSearchCitycode() {
        return this.f17927b;
    }

    public void setSearchCityName(String str) {
        this.f17926a = str;
    }

    public void setSearchCitycode(String str) {
        this.f17927b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f17928c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17926a);
        parcel.writeString(this.f17927b);
        parcel.writeString(this.f17928c);
    }

    public SearchCity() {
    }
}
