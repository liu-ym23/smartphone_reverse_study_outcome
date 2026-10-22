package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.jmsl.L;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;

/* loaded from: classes.dex */
public class WeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private IWeatherSearch f18050a;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i10);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i10);
    }

    public WeatherSearch(Context context) throws AMapException {
        this.f18050a = null;
        try {
            this.f18050a = new L(context);
        } catch (Exception e10) {
            e10.printStackTrace();
            if (e10 instanceof AMapException) {
                throw ((AMapException) e10);
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.f18050a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.f18050a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.f18050a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.f18050a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }
}
