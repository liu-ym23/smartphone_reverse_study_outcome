package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.a implements IWeatherSearch {

    /* renamed from: g, reason: collision with root package name */
    private OnGetWeatherResultListener f9401g;

    @Override // com.baidu.platform.core.weather.IWeatherSearch
    public void destroy() {
        this.f8564c.lock();
        this.f9401g = null;
        this.f8564c.unlock();
    }

    @Override // com.baidu.platform.core.weather.IWeatherSearch
    public boolean searchWeather(WeatherSearchOption weatherSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.WEATHER_SEARCH);
        return a(new b(weatherSearchOption), this.f9401g, aVar);
    }

    @Override // com.baidu.platform.core.weather.IWeatherSearch
    public void setOnGetWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener) {
        this.f8564c.lock();
        this.f9401g = onGetWeatherResultListener;
        this.f8564c.unlock();
    }
}
