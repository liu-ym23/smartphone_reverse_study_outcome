package com.amap.api.services.weather;

/* JADX INFO: loaded from: classes28.dex */
public class LocalWeatherLiveResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f29312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocalWeatherLive f29313b;

    public LocalWeatherLive getLiveResult() {
        return this.f29313b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f29312a;
    }

    private LocalWeatherLiveResult(WeatherSearchQuery r100, LocalWeatherLive r101) {
        this.f29312a = r100;
        this.f29313b = r101;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery r100, LocalWeatherLive r101) {
        return new LocalWeatherLiveResult(r100, r101);
    }
}
