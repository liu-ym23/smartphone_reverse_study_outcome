package com.amap.api.services.weather;

/* JADX INFO: loaded from: classes28.dex */
public class LocalWeatherForecastResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f29301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocalWeatherForecast f29302b;

    public LocalWeatherForecast getForecastResult() {
        return this.f29302b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f29301a;
    }

    private LocalWeatherForecastResult(WeatherSearchQuery r100, LocalWeatherForecast r101) {
        this.f29301a = r100;
        this.f29302b = r101;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery r100, LocalWeatherForecast r101) {
        return new LocalWeatherForecastResult(r100, r101);
    }
}
