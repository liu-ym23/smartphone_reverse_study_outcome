package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f18022a;

    /* renamed from: b, reason: collision with root package name */
    private String f18023b;

    /* renamed from: c, reason: collision with root package name */
    private String f18024c;

    /* renamed from: d, reason: collision with root package name */
    private String f18025d;

    /* renamed from: e, reason: collision with root package name */
    private String f18026e;

    /* renamed from: f, reason: collision with root package name */
    private String f18027f;

    /* renamed from: g, reason: collision with root package name */
    private String f18028g;

    /* renamed from: h, reason: collision with root package name */
    private String f18029h;

    /* renamed from: i, reason: collision with root package name */
    private String f18030i;

    /* renamed from: j, reason: collision with root package name */
    private String f18031j;

    public static class a implements Parcelable.Creator<LocalDayWeatherForecast> {
        @Override // android.os.Parcelable.Creator
        public LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i10) {
            return null;
        }
    }

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return this.f18022a;
    }

    public String getDayTemp() {
        return this.f18026e;
    }

    public String getDayWeather() {
        return this.f18024c;
    }

    public String getDayWindDirection() {
        return this.f18028g;
    }

    public String getDayWindPower() {
        return this.f18030i;
    }

    public String getNightTemp() {
        return this.f18027f;
    }

    public String getNightWeather() {
        return this.f18025d;
    }

    public String getNightWindDirection() {
        return this.f18029h;
    }

    public String getNightWindPower() {
        return this.f18031j;
    }

    public String getWeek() {
        return this.f18023b;
    }

    public void setDate(String str) {
        this.f18022a = str;
    }

    public void setDayTemp(String str) {
        this.f18026e = str;
    }

    public void setDayWeather(String str) {
        this.f18024c = str;
    }

    public void setDayWindDirection(String str) {
        this.f18028g = str;
    }

    public void setDayWindPower(String str) {
        this.f18030i = str;
    }

    public void setNightTemp(String str) {
        this.f18027f = str;
    }

    public void setNightWeather(String str) {
        this.f18025d = str;
    }

    public void setNightWindDirection(String str) {
        this.f18029h = str;
    }

    public void setNightWindPower(String str) {
        this.f18031j = str;
    }

    public void setWeek(String str) {
        this.f18023b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f18022a);
        parcel.writeString(this.f18023b);
        parcel.writeString(this.f18024c);
        parcel.writeString(this.f18025d);
        parcel.writeString(this.f18026e);
        parcel.writeString(this.f18027f);
        parcel.writeString(this.f18028g);
        parcel.writeString(this.f18029h);
        parcel.writeString(this.f18030i);
        parcel.writeString(this.f18031j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f18022a = parcel.readString();
        this.f18023b = parcel.readString();
        this.f18024c = parcel.readString();
        this.f18025d = parcel.readString();
        this.f18026e = parcel.readString();
        this.f18027f = parcel.readString();
        this.f18028g = parcel.readString();
        this.f18029h = parcel.readString();
        this.f18030i = parcel.readString();
        this.f18031j = parcel.readString();
    }
}
