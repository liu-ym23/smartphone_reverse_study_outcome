package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f18039a;

    /* renamed from: b, reason: collision with root package name */
    private String f18040b;

    /* renamed from: c, reason: collision with root package name */
    private String f18041c;

    /* renamed from: d, reason: collision with root package name */
    private String f18042d;

    /* renamed from: e, reason: collision with root package name */
    private String f18043e;

    /* renamed from: f, reason: collision with root package name */
    private String f18044f;

    /* renamed from: g, reason: collision with root package name */
    private String f18045g;

    /* renamed from: h, reason: collision with root package name */
    private String f18046h;

    /* renamed from: i, reason: collision with root package name */
    private String f18047i;

    public static class a implements Parcelable.Creator<LocalWeatherLive> {
        @Override // android.os.Parcelable.Creator
        public LocalWeatherLive createFromParcel(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i10) {
            return null;
        }
    }

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f18041c;
    }

    public String getCity() {
        return this.f18040b;
    }

    public String getHumidity() {
        return this.f18046h;
    }

    public String getProvince() {
        return this.f18039a;
    }

    public String getReportTime() {
        return this.f18047i;
    }

    public String getTemperature() {
        return this.f18043e;
    }

    public String getWeather() {
        return this.f18042d;
    }

    public String getWindDirection() {
        return this.f18044f;
    }

    public String getWindPower() {
        return this.f18045g;
    }

    public void setAdCode(String str) {
        this.f18041c = str;
    }

    public void setCity(String str) {
        this.f18040b = str;
    }

    public void setHumidity(String str) {
        this.f18046h = str;
    }

    public void setProvince(String str) {
        this.f18039a = str;
    }

    public void setReportTime(String str) {
        this.f18047i = str;
    }

    public void setTemperature(String str) {
        this.f18043e = str;
    }

    public void setWeather(String str) {
        this.f18042d = str;
    }

    public void setWindDirection(String str) {
        this.f18044f = str;
    }

    public void setWindPower(String str) {
        this.f18045g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f18039a);
        parcel.writeString(this.f18040b);
        parcel.writeString(this.f18041c);
        parcel.writeString(this.f18042d);
        parcel.writeString(this.f18043e);
        parcel.writeString(this.f18044f);
        parcel.writeString(this.f18045g);
        parcel.writeString(this.f18046h);
        parcel.writeString(this.f18047i);
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f18039a = parcel.readString();
        this.f18040b = parcel.readString();
        this.f18041c = parcel.readString();
        this.f18042d = parcel.readString();
        this.f18043e = parcel.readString();
        this.f18044f = parcel.readString();
        this.f18045g = parcel.readString();
        this.f18046h = parcel.readString();
        this.f18047i = parcel.readString();
    }
}
