package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherSearchForecasts implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchForecasts> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7597a;

    /* renamed from: b, reason: collision with root package name */
    private String f7598b;

    /* renamed from: c, reason: collision with root package name */
    private int f7599c;

    /* renamed from: d, reason: collision with root package name */
    private int f7600d;

    /* renamed from: e, reason: collision with root package name */
    private String f7601e;

    /* renamed from: f, reason: collision with root package name */
    private String f7602f;

    /* renamed from: g, reason: collision with root package name */
    private String f7603g;

    /* renamed from: h, reason: collision with root package name */
    private String f7604h;

    /* renamed from: i, reason: collision with root package name */
    private String f7605i;

    /* renamed from: j, reason: collision with root package name */
    private String f7606j;

    /* renamed from: k, reason: collision with root package name */
    private int f7607k;

    public static class a implements Parcelable.Creator<WeatherSearchForecasts> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchForecasts createFromParcel(Parcel parcel) {
            return new WeatherSearchForecasts(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchForecasts[] newArray(int i4) {
            return new WeatherSearchForecasts[i4];
        }
    }

    public WeatherSearchForecasts() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAirQualityIndex() {
        return this.f7607k;
    }

    public String getDate() {
        return this.f7597a;
    }

    public int getHighestTemp() {
        return this.f7600d;
    }

    public int getLowestTemp() {
        return this.f7599c;
    }

    public String getPhenomenonDay() {
        return this.f7605i;
    }

    public String getPhenomenonNight() {
        return this.f7606j;
    }

    public String getWeek() {
        return this.f7598b;
    }

    public String getWindDirectionDay() {
        return this.f7603g;
    }

    public String getWindDirectionNight() {
        return this.f7604h;
    }

    public String getWindPowerDay() {
        return this.f7601e;
    }

    public String getWindPowerNight() {
        return this.f7602f;
    }

    public void setAirQualityIndex(int i4) {
        this.f7607k = i4;
    }

    public void setDate(String str) {
        this.f7597a = str;
    }

    public void setHighestTemp(int i4) {
        this.f7600d = i4;
    }

    public void setLowestTemp(int i4) {
        this.f7599c = i4;
    }

    public void setPhenomenonDay(String str) {
        this.f7605i = str;
    }

    public void setPhenomenonNight(String str) {
        this.f7606j = str;
    }

    public void setWeek(String str) {
        this.f7598b = str;
    }

    public void setWindDirectionDay(String str) {
        this.f7603g = str;
    }

    public void setWindDirectionNight(String str) {
        this.f7604h = str;
    }

    public void setWindPowerDay(String str) {
        this.f7601e = str;
    }

    public void setWindPowerNight(String str) {
        this.f7602f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7597a);
        parcel.writeString(this.f7598b);
        parcel.writeInt(this.f7599c);
        parcel.writeInt(this.f7600d);
        parcel.writeString(this.f7601e);
        parcel.writeString(this.f7602f);
        parcel.writeString(this.f7603g);
        parcel.writeString(this.f7604h);
        parcel.writeString(this.f7605i);
        parcel.writeString(this.f7606j);
    }

    public WeatherSearchForecasts(Parcel parcel) {
        this.f7597a = parcel.readString();
        this.f7598b = parcel.readString();
        this.f7599c = parcel.readInt();
        this.f7600d = parcel.readInt();
        this.f7601e = parcel.readString();
        this.f7602f = parcel.readString();
        this.f7603g = parcel.readString();
        this.f7604h = parcel.readString();
        this.f7605i = parcel.readString();
        this.f7606j = parcel.readString();
    }
}
