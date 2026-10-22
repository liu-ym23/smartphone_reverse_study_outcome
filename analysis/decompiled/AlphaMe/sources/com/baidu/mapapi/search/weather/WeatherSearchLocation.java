package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherSearchLocation implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchLocation> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7608a;

    /* renamed from: b, reason: collision with root package name */
    private String f7609b;

    /* renamed from: c, reason: collision with root package name */
    private String f7610c;

    /* renamed from: d, reason: collision with root package name */
    private String f7611d;

    /* renamed from: e, reason: collision with root package name */
    private String f7612e;

    public static class a implements Parcelable.Creator<WeatherSearchLocation> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchLocation createFromParcel(Parcel parcel) {
            return new WeatherSearchLocation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchLocation[] newArray(int i4) {
            return new WeatherSearchLocation[i4];
        }
    }

    public WeatherSearchLocation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.f7610c;
    }

    public String getCountry() {
        return this.f7608a;
    }

    public String getDistrictID() {
        return this.f7612e;
    }

    public String getDistrictName() {
        return this.f7611d;
    }

    public String getProvince() {
        return this.f7609b;
    }

    public void setCity(String str) {
        this.f7610c = str;
    }

    public void setCountry(String str) {
        this.f7608a = str;
    }

    public void setDistrictID(String str) {
        this.f7612e = str;
    }

    public void setDistrictName(String str) {
        this.f7611d = str;
    }

    public void setProvince(String str) {
        this.f7609b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7608a);
        parcel.writeString(this.f7609b);
        parcel.writeString(this.f7610c);
        parcel.writeString(this.f7611d);
        parcel.writeString(this.f7612e);
    }

    public WeatherSearchLocation(Parcel parcel) {
        this.f7608a = parcel.readString();
        this.f7609b = parcel.readString();
        this.f7610c = parcel.readString();
        this.f7611d = parcel.readString();
        this.f7612e = parcel.readString();
    }
}
