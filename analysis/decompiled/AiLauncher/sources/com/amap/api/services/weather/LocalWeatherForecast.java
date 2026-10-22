package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f18032a;

    /* renamed from: b, reason: collision with root package name */
    private String f18033b;

    /* renamed from: c, reason: collision with root package name */
    private String f18034c;

    /* renamed from: d, reason: collision with root package name */
    private String f18035d;

    /* renamed from: e, reason: collision with root package name */
    private List<LocalDayWeatherForecast> f18036e;

    public static class a implements Parcelable.Creator<LocalWeatherForecast> {
        @Override // android.os.Parcelable.Creator
        public LocalWeatherForecast createFromParcel(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i10) {
            return null;
        }
    }

    public LocalWeatherForecast() {
        this.f18036e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f18034c;
    }

    public String getCity() {
        return this.f18033b;
    }

    public String getProvince() {
        return this.f18032a;
    }

    public String getReportTime() {
        return this.f18035d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.f18036e;
    }

    public void setAdCode(String str) {
        this.f18034c = str;
    }

    public void setCity(String str) {
        this.f18033b = str;
    }

    public void setProvince(String str) {
        this.f18032a = str;
    }

    public void setReportTime(String str) {
        this.f18035d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.f18036e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f18032a);
        parcel.writeString(this.f18033b);
        parcel.writeString(this.f18034c);
        parcel.writeString(this.f18035d);
        parcel.writeList(this.f18036e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.f18036e = new ArrayList();
        this.f18032a = parcel.readString();
        this.f18033b = parcel.readString();
        this.f18034c = parcel.readString();
        this.f18035d = parcel.readString();
        this.f18036e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
