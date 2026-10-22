package com.amap.api.services.weather;

/* loaded from: classes.dex */
public class LocalWeatherForecastResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f18037a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherForecast f18038b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f18037a = weatherSearchQuery;
        this.f18038b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.f18038b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f18037a;
    }
}
