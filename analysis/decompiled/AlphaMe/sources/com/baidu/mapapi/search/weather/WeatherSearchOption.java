package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes.dex */
public class WeatherSearchOption {

    /* renamed from: b, reason: collision with root package name */
    private String f7614b;

    /* renamed from: c, reason: collision with root package name */
    private LatLng f7615c;

    /* renamed from: a, reason: collision with root package name */
    private WeatherServerType f7613a = WeatherServerType.WEATHER_SERVER_TYPE_DEFAULT;

    /* renamed from: d, reason: collision with root package name */
    private WeatherDataType f7616d = WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME;

    /* renamed from: e, reason: collision with root package name */
    private LanguageType f7617e = LanguageType.LanguageTypeChinese;

    public WeatherSearchOption districtID(String str) {
        this.f7614b = str;
        return this;
    }

    public WeatherDataType getDataType() {
        return this.f7616d;
    }

    public String getDistrictID() {
        return this.f7614b;
    }

    public LanguageType getLanguageType() {
        return this.f7617e;
    }

    public LatLng getLocation() {
        return this.f7615c;
    }

    public WeatherServerType getServerType() {
        return this.f7613a;
    }

    public WeatherSearchOption languageType(LanguageType languageType) {
        this.f7617e = languageType;
        return this;
    }

    public WeatherSearchOption location(LatLng latLng) {
        this.f7615c = latLng;
        return this;
    }

    public WeatherSearchOption serverType(WeatherServerType weatherServerType) {
        this.f7613a = weatherServerType;
        return this;
    }

    public WeatherSearchOption weatherDataType(WeatherDataType weatherDataType) {
        this.f7616d = weatherDataType;
        return this;
    }
}
