package com.amap.api.services.weather;

/* loaded from: classes.dex */
public class LocalWeatherLiveResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f18048a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherLive f18049b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f18048a = weatherSearchQuery;
        this.f18049b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.f18049b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f18048a;
    }
}
