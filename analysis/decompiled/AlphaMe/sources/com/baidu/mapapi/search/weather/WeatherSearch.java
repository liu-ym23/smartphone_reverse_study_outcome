package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.weather.IWeatherSearch;
import com.baidu.platform.core.weather.c;

/* loaded from: classes.dex */
public class WeatherSearch extends b {

    /* renamed from: a, reason: collision with root package name */
    IWeatherSearch f7584a = new c();

    public static WeatherSearch newInstance() {
        BMapManager.init();
        return new WeatherSearch();
    }

    public void destroy() {
        IWeatherSearch iWeatherSearch = this.f7584a;
        if (iWeatherSearch != null) {
            iWeatherSearch.destroy();
        }
        BMapManager.destroy();
    }

    public boolean request(WeatherSearchOption weatherSearchOption) {
        IWeatherSearch iWeatherSearch = this.f7584a;
        if (iWeatherSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (weatherSearchOption != null) {
            return iWeatherSearch.searchWeather(weatherSearchOption);
        }
        throw new IllegalArgumentException("BDMapSDKException: option can not be null");
    }

    public void setWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener) {
        IWeatherSearch iWeatherSearch = this.f7584a;
        if (iWeatherSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetWeatherResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iWeatherSearch.setOnGetWeatherSearchResultListener(onGetWeatherResultListener);
    }
}
