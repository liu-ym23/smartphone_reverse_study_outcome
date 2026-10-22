package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f29311i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public LocalWeatherLive() {
    }

    public String getAdCode() {
        return this.f29305c;
    }

    public String getCity() {
        return this.f29304b;
    }

    public String getHumidity() {
        return this.f29310h;
    }

    public String getProvince() {
        return this.f29303a;
    }

    public String getReportTime() {
        return this.f29311i;
    }

    public String getTemperature() {
        return this.f29307e;
    }

    public String getWeather() {
        return this.f29306d;
    }

    public String getWindDirection() {
        return this.f29308f;
    }

    public String getWindPower() {
        return this.f29309g;
    }

    public LocalWeatherLive(Parcel r100) {
        this.f29303a = r100.readString();
        this.f29304b = r100.readString();
        this.f29305c = r100.readString();
        this.f29306d = r100.readString();
        this.f29307e = r100.readString();
        this.f29308f = r100.readString();
        this.f29309g = r100.readString();
        this.f29310h = r100.readString();
        this.f29311i = r100.readString();
    }

    public void setAdCode(String r100) {
        this.f29305c = r100;
    }

    public void setCity(String r100) {
        this.f29304b = r100;
    }

    public void setHumidity(String r100) {
        this.f29310h = r100;
    }

    public void setProvince(String r100) {
        this.f29303a = r100;
    }

    public void setReportTime(String r100) {
        this.f29311i = r100;
    }

    public void setTemperature(String r100) {
        this.f29307e = r100;
    }

    public void setWeather(String r100) {
        this.f29306d = r100;
    }

    public void setWindDirection(String r100) {
        this.f29308f = r100;
    }

    public void setWindPower(String r100) {
        this.f29309g = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29303a);
        r100.writeString(this.f29304b);
        r100.writeString(this.f29305c);
        r100.writeString(this.f29306d);
        r100.writeString(this.f29307e);
        r100.writeString(this.f29308f);
        r100.writeString(this.f29309g);
        r100.writeString(this.f29310h);
        r100.writeString(this.f29311i);
    }
}
