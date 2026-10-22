package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;

/* loaded from: classes.dex */
public interface IWeatherSearch {
    void destroy();

    boolean searchWeather(WeatherSearchOption weatherSearchOption);

    void setOnGetWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener);
}
