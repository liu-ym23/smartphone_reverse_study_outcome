package com.amap.api.services.interfaces;

import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* JADX INFO: loaded from: classes28.dex */
public interface IWeatherSearch {
    WeatherSearchQuery getQuery();

    void searchWeatherAsyn();

    void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener r100);

    void setQuery(WeatherSearchQuery r100);
}
