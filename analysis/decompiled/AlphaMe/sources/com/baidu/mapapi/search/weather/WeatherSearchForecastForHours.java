package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherSearchForecastForHours implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchForecastForHours> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f7589a;

    /* renamed from: b, reason: collision with root package name */
    private String f7590b;

    /* renamed from: c, reason: collision with root package name */
    private String f7591c;

    /* renamed from: d, reason: collision with root package name */
    private String f7592d;

    /* renamed from: e, reason: collision with root package name */
    private int f7593e;

    /* renamed from: f, reason: collision with root package name */
    private int f7594f;

    /* renamed from: g, reason: collision with root package name */
    private String f7595g;

    /* renamed from: h, reason: collision with root package name */
    private int f7596h;

    public static class a implements Parcelable.Creator<WeatherSearchForecastForHours> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchForecastForHours createFromParcel(Parcel parcel) {
            return new WeatherSearchForecastForHours(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchForecastForHours[] newArray(int i4) {
            return new WeatherSearchForecastForHours[i4];
        }
    }

    public WeatherSearchForecastForHours() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getClouds() {
        return this.f7594f;
    }

    public String getDataTime() {
        return this.f7590b;
    }

    public int getHourlyPrecipitation() {
        return this.f7596h;
    }

    public String getPhenomenon() {
        return this.f7595g;
    }

    public int getRelativeHumidity() {
        return this.f7589a;
    }

    public int getTemperature() {
        return this.f7593e;
    }

    public String getWindDirection() {
        return this.f7591c;
    }

    public String getWindPower() {
        return this.f7592d;
    }

    public void setClouds(int i4) {
        this.f7594f = i4;
    }

    public void setDataTime(String str) {
        this.f7590b = str;
    }

    public void setHourlyPrecipitation(int i4) {
        this.f7596h = i4;
    }

    public void setPhenomenon(String str) {
        this.f7595g = str;
    }

    public void setRelativeHumidity(int i4) {
        this.f7589a = i4;
    }

    public void setTemperature(int i4) {
        this.f7593e = i4;
    }

    public void setWindDirection(String str) {
        this.f7591c = str;
    }

    public void setWindPower(String str) {
        this.f7592d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f7589a);
        parcel.writeString(this.f7590b);
        parcel.writeString(this.f7591c);
        parcel.writeString(this.f7592d);
        parcel.writeInt(this.f7593e);
        parcel.writeInt(this.f7594f);
        parcel.writeString(this.f7595g);
        parcel.writeInt(this.f7596h);
    }

    public WeatherSearchForecastForHours(Parcel parcel) {
        this.f7589a = parcel.readInt();
        this.f7590b = parcel.readString();
        this.f7591c = parcel.readString();
        this.f7592d = parcel.readString();
        this.f7593e = parcel.readInt();
        this.f7594f = parcel.readInt();
        this.f7595g = parcel.readString();
        this.f7596h = parcel.readInt();
    }
}
