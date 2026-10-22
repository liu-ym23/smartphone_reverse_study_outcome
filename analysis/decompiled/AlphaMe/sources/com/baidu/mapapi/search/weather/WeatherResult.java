package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class WeatherResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WeatherResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchRealTime f7578a;

    /* renamed from: b, reason: collision with root package name */
    private WeatherSearchLocation f7579b;

    /* renamed from: c, reason: collision with root package name */
    private List<WeatherSearchForecasts> f7580c;

    /* renamed from: d, reason: collision with root package name */
    private List<WeatherSearchForecastForHours> f7581d;

    /* renamed from: e, reason: collision with root package name */
    private List<WeatherLifeIndexes> f7582e;

    /* renamed from: f, reason: collision with root package name */
    private List<WeatherSearchAlerts> f7583f;

    public static class a implements Parcelable.Creator<WeatherResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherResult createFromParcel(Parcel parcel) {
            return new WeatherResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherResult[] newArray(int i4) {
            return new WeatherResult[i4];
        }
    }

    public WeatherResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WeatherSearchForecastForHours> getForecastHours() {
        return this.f7581d;
    }

    public List<WeatherSearchForecasts> getForecasts() {
        return this.f7580c;
    }

    public List<WeatherLifeIndexes> getLifeIndexes() {
        return this.f7582e;
    }

    public WeatherSearchLocation getLocation() {
        return this.f7579b;
    }

    public WeatherSearchRealTime getRealTimeWeather() {
        return this.f7578a;
    }

    public List<WeatherSearchAlerts> getWeatherAlerts() {
        return this.f7583f;
    }

    public void setForecastHours(List<WeatherSearchForecastForHours> list) {
        this.f7581d = list;
    }

    public void setForecasts(List<WeatherSearchForecasts> list) {
        this.f7580c = list;
    }

    public void setLifeIndexes(List<WeatherLifeIndexes> list) {
        this.f7582e = list;
    }

    public void setLocation(WeatherSearchLocation weatherSearchLocation) {
        this.f7579b = weatherSearchLocation;
    }

    public void setRealTimeWeather(WeatherSearchRealTime weatherSearchRealTime) {
        this.f7578a = weatherSearchRealTime;
    }

    public void setWeatherAlerts(List<WeatherSearchAlerts> list) {
        this.f7583f = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.f7578a, i4);
        parcel.writeParcelable(this.f7579b, i4);
        parcel.writeTypedList(this.f7580c);
        parcel.writeTypedList(this.f7581d);
        parcel.writeTypedList(this.f7582e);
        parcel.writeTypedList(this.f7583f);
    }

    public WeatherResult(Parcel parcel) {
        super(parcel);
        this.f7578a = (WeatherSearchRealTime) parcel.readParcelable(WeatherSearchRealTime.class.getClassLoader());
        this.f7579b = (WeatherSearchLocation) parcel.readParcelable(WeatherSearchLocation.class.getClassLoader());
        this.f7580c = parcel.createTypedArrayList(WeatherSearchForecasts.CREATOR);
        this.f7581d = parcel.createTypedArrayList(WeatherSearchForecastForHours.CREATOR);
        this.f7582e = parcel.createTypedArrayList(WeatherLifeIndexes.CREATOR);
        this.f7583f = parcel.createTypedArrayList(WeatherSearchAlerts.CREATOR);
    }
}
