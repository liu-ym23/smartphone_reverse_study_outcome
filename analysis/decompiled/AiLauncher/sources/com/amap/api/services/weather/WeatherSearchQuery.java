package com.amap.api.services.weather;

import com.amap.api.col.jmsl.C1631z1;

/* loaded from: classes.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f18051a;

    /* renamed from: b, reason: collision with root package name */
    private int f18052b;

    public WeatherSearchQuery(String str, int i10) {
        this.f18051a = str;
        this.f18052b = i10;
    }

    public String getCity() {
        return this.f18051a;
    }

    public int getType() {
        return this.f18052b;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WeatherSearchQuery m42clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            C1631z1.o(e10, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f18051a, this.f18052b);
    }

    public WeatherSearchQuery() {
        this.f18052b = 1;
    }
}
