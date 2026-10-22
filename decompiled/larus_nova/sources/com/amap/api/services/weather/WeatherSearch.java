package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.s.bg;
import com.amap.api.services.interfaces.IWeatherSearch;

/* JADX INFO: loaded from: classes28.dex */
public class WeatherSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IWeatherSearch f29314a;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult r100, int r101);

        void onWeatherLiveSearched(LocalWeatherLiveResult r100, int r101);
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch r100 = this.f29314a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getQuery();
    }

    public void searchWeatherAsyn() {
        IWeatherSearch r100 = this.f29314a;
        if (r100 == null) goto L6;
        r100.searchWeatherAsyn();
        return;
    }

    public WeatherSearch(Context r100) {
        this.f29314a = null;
        this.f29314a = new bg(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener r100) {
        IWeatherSearch r101 = this.f29314a;
        if (r101 == null) goto L6;
        r101.setOnWeatherSearchListener(r100);
        return;
    }

    public void setQuery(WeatherSearchQuery r100) {
        IWeatherSearch r101 = this.f29314a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }
}
