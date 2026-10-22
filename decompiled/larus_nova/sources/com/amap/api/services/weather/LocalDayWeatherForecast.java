package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f29294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f29295j;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public LocalDayWeatherForecast() {
    }

    public String getDate() {
        return this.f29286a;
    }

    public String getDayTemp() {
        return this.f29290e;
    }

    public String getDayWeather() {
        return this.f29288c;
    }

    public String getDayWindDirection() {
        return this.f29292g;
    }

    public String getDayWindPower() {
        return this.f29294i;
    }

    public String getNightTemp() {
        return this.f29291f;
    }

    public String getNightWeather() {
        return this.f29289d;
    }

    public String getNightWindDirection() {
        return this.f29293h;
    }

    public String getNightWindPower() {
        return this.f29295j;
    }

    public String getWeek() {
        return this.f29287b;
    }

    public LocalDayWeatherForecast(Parcel r100) {
        this.f29286a = r100.readString();
        this.f29287b = r100.readString();
        this.f29288c = r100.readString();
        this.f29289d = r100.readString();
        this.f29290e = r100.readString();
        this.f29291f = r100.readString();
        this.f29292g = r100.readString();
        this.f29293h = r100.readString();
        this.f29294i = r100.readString();
        this.f29295j = r100.readString();
    }

    public void setDate(String r100) {
        this.f29286a = r100;
    }

    public void setDayTemp(String r100) {
        this.f29290e = r100;
    }

    public void setDayWeather(String r100) {
        this.f29288c = r100;
    }

    public void setDayWindDirection(String r100) {
        this.f29292g = r100;
    }

    public void setDayWindPower(String r100) {
        this.f29294i = r100;
    }

    public void setNightTemp(String r100) {
        this.f29291f = r100;
    }

    public void setNightWeather(String r100) {
        this.f29289d = r100;
    }

    public void setNightWindDirection(String r100) {
        this.f29293h = r100;
    }

    public void setNightWindPower(String r100) {
        this.f29295j = r100;
    }

    public void setWeek(String r100) {
        this.f29287b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29286a);
        r100.writeString(this.f29287b);
        r100.writeString(this.f29288c);
        r100.writeString(this.f29289d);
        r100.writeString(this.f29290e);
        r100.writeString(this.f29291f);
        r100.writeString(this.f29292g);
        r100.writeString(this.f29293h);
        r100.writeString(this.f29294i);
        r100.writeString(this.f29295j);
    }
}
