package com.amap.api.services.weather;

import com.amap.api.col.s.i;

/* JADX INFO: loaded from: classes28.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29316b;

    public WeatherSearchQuery() {
        this.f29316b = 1;
    }

    public WeatherSearchQuery clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L7:
        return new WeatherSearchQuery(this.f29315a, this.f29316b);
    L4:
        e = move-exception;
        i.a(e, "WeatherSearchQuery", "clone");
        goto L7
    }

    public String getCity() {
        return this.f29315a;
    }

    public int getType() {
        return this.f29316b;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8048clone() throws CloneNotSupportedException {
        return clone();
    }

    public WeatherSearchQuery(String r100, int r101) {
        this.f29315a = r100;
        this.f29316b = r101;
    }
}
