package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<LocalDayWeatherForecast> f29300e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public LocalWeatherForecast() {
        this.f29300e = new ArrayList();
    }

    public String getAdCode() {
        return this.f29298c;
    }

    public String getCity() {
        return this.f29297b;
    }

    public String getProvince() {
        return this.f29296a;
    }

    public String getReportTime() {
        return this.f29299d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.f29300e;
    }

    public LocalWeatherForecast(Parcel r100) {
        this.f29300e = new ArrayList();
        this.f29296a = r100.readString();
        this.f29297b = r100.readString();
        this.f29298c = r100.readString();
        this.f29299d = r100.readString();
        this.f29300e = r100.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }

    public void setAdCode(String r100) {
        this.f29298c = r100;
    }

    public void setCity(String r100) {
        this.f29297b = r100;
    }

    public void setProvince(String r100) {
        this.f29296a = r100;
    }

    public void setReportTime(String r100) {
        this.f29299d = r100;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> r100) {
        this.f29300e = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29296a);
        r100.writeString(this.f29297b);
        r100.writeString(this.f29298c);
        r100.writeString(this.f29299d);
        r100.writeList(this.f29300e);
    }
}
