package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WeatherSearchRealTime implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchRealTime> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f7618a;

    /* renamed from: b, reason: collision with root package name */
    private int f7619b;

    /* renamed from: c, reason: collision with root package name */
    private String f7620c;

    /* renamed from: d, reason: collision with root package name */
    private String f7621d;

    /* renamed from: e, reason: collision with root package name */
    private String f7622e;

    /* renamed from: f, reason: collision with root package name */
    private int f7623f;

    /* renamed from: g, reason: collision with root package name */
    private String f7624g;

    /* renamed from: h, reason: collision with root package name */
    private int f7625h;

    /* renamed from: i, reason: collision with root package name */
    private float f7626i;

    /* renamed from: j, reason: collision with root package name */
    private int f7627j;

    /* renamed from: k, reason: collision with root package name */
    private int f7628k;

    /* renamed from: l, reason: collision with root package name */
    private int f7629l;

    /* renamed from: m, reason: collision with root package name */
    private int f7630m;

    /* renamed from: n, reason: collision with root package name */
    private int f7631n;

    /* renamed from: o, reason: collision with root package name */
    private int f7632o;

    /* renamed from: p, reason: collision with root package name */
    private int f7633p;

    /* renamed from: q, reason: collision with root package name */
    private float f7634q;

    public static class a implements Parcelable.Creator<WeatherSearchRealTime> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchRealTime createFromParcel(Parcel parcel) {
            return new WeatherSearchRealTime(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchRealTime[] newArray(int i4) {
            return new WeatherSearchRealTime[i4];
        }
    }

    public WeatherSearchRealTime() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAirQualityIndex() {
        return this.f7632o;
    }

    public float getCO() {
        return this.f7634q;
    }

    public int getClouds() {
        return this.f7625h;
    }

    public float getHourlyPrecipitation() {
        return this.f7626i;
    }

    public int getNO2() {
        return this.f7630m;
    }

    public int getO3() {
        return this.f7628k;
    }

    public int getPM10() {
        return this.f7633p;
    }

    public int getPM2_5() {
        return this.f7629l;
    }

    public String getPhenomenon() {
        return this.f7620c;
    }

    public int getRelativeHumidity() {
        return this.f7618a;
    }

    public int getSO2() {
        return this.f7631n;
    }

    public int getSensoryTemp() {
        return this.f7619b;
    }

    public int getTemperature() {
        return this.f7623f;
    }

    public String getUpdateTime() {
        return this.f7622e;
    }

    public int getVisibility() {
        return this.f7627j;
    }

    public String getWindDirection() {
        return this.f7621d;
    }

    public String getWindPower() {
        return this.f7624g;
    }

    public void setAirQualityIndex(int i4) {
        this.f7632o = i4;
    }

    public void setCO(float f4) {
        this.f7634q = f4;
    }

    public void setClouds(int i4) {
        this.f7625h = i4;
    }

    public void setHourlyPrecipitation(float f4) {
        this.f7626i = f4;
    }

    public void setNO2(int i4) {
        this.f7630m = i4;
    }

    public void setO3(int i4) {
        this.f7628k = i4;
    }

    public void setPM10(int i4) {
        this.f7633p = i4;
    }

    public void setPM2_5(int i4) {
        this.f7629l = i4;
    }

    public void setPhenomenon(String str) {
        this.f7620c = str;
    }

    public void setRelativeHumidity(int i4) {
        this.f7618a = i4;
    }

    public void setSO2(int i4) {
        this.f7631n = i4;
    }

    public void setSensoryTemp(int i4) {
        this.f7619b = i4;
    }

    public void setTemperature(int i4) {
        this.f7623f = i4;
    }

    public void setUpdateTime(String str) {
        this.f7622e = str;
    }

    public void setVisibility(int i4) {
        this.f7627j = i4;
    }

    public void setWindDirection(String str) {
        this.f7621d = str;
    }

    public void setWindPower(String str) {
        this.f7624g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f7618a);
        parcel.writeInt(this.f7619b);
        parcel.writeString(this.f7620c);
        parcel.writeString(this.f7621d);
        parcel.writeString(this.f7622e);
        parcel.writeInt(this.f7623f);
        parcel.writeString(this.f7624g);
    }

    public WeatherSearchRealTime(Parcel parcel) {
        this.f7618a = parcel.readInt();
        this.f7619b = parcel.readInt();
        this.f7620c = parcel.readString();
        this.f7621d = parcel.readString();
        this.f7622e = parcel.readString();
        this.f7623f = parcel.readInt();
        this.f7624g = parcel.readString();
    }
}
