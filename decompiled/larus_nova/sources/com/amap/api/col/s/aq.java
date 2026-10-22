package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* JADX INFO: loaded from: classes28.dex */
public final class aq extends as<WeatherSearchQuery, LocalWeatherForecast> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LocalWeatherForecast f26051j;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        StringBuffer r100 = new StringBuffer("output=json");
        String r101 = ((WeatherSearchQuery) this.f25991b).getCity();
        if (p.f(r101) == true) goto L5;
        String r102 = b.b(r101);
        r100.append("&city=");
        r100.append(r102);
    L5:
        r100.append("&extensions=all");
        r100.append("&key=" + bi.f(this.f25994e));
        return r100.toString();
    }

    @Override // com.amap.api.col.s.as, com.amap.api.col.s.cy
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        LocalWeatherForecast r101 = p.e(r100);
        this.f26051j = r101;
        return r101;
    }

    public aq(Context r100, WeatherSearchQuery r101) {
        super(r100, r101);
        this.f26051j = new LocalWeatherForecast();
    }
}
