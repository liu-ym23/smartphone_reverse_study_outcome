package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class R0 extends AbstractC1564i1<WeatherSearchQuery, LocalWeatherForecast> {

    /* renamed from: E, reason: collision with root package name */
    public LocalWeatherForecast f16297E;

    public R0(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f16297E = new LocalWeatherForecast();
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws JSONException, AMapException {
        LocalWeatherForecast localWeatherForecast;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("forecasts")) {
                localWeatherForecast = new LocalWeatherForecast();
                JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
                if (jSONArray != null && jSONArray.length() > 0) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                    if (jSONObjectOptJSONObject != null) {
                        localWeatherForecast.setCity(C1531a0.D(jSONObjectOptJSONObject, "city"));
                        localWeatherForecast.setAdCode(C1531a0.D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                        localWeatherForecast.setProvince(C1531a0.D(jSONObjectOptJSONObject, "province"));
                        localWeatherForecast.setReportTime(C1531a0.D(jSONObjectOptJSONObject, "reporttime"));
                        if (jSONObjectOptJSONObject.has("casts")) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("casts");
                            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                                localWeatherForecast.setWeatherForecast(arrayList);
                            } else {
                                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                                    LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                                    if (jSONObjectOptJSONObject2 != null) {
                                        localDayWeatherForecast.setDate(C1531a0.D(jSONObjectOptJSONObject2, "date"));
                                        localDayWeatherForecast.setWeek(C1531a0.D(jSONObjectOptJSONObject2, "week"));
                                        localDayWeatherForecast.setDayWeather(C1531a0.D(jSONObjectOptJSONObject2, "dayweather"));
                                        localDayWeatherForecast.setNightWeather(C1531a0.D(jSONObjectOptJSONObject2, "nightweather"));
                                        localDayWeatherForecast.setDayTemp(C1531a0.D(jSONObjectOptJSONObject2, "daytemp"));
                                        localDayWeatherForecast.setNightTemp(C1531a0.D(jSONObjectOptJSONObject2, "nighttemp"));
                                        localDayWeatherForecast.setDayWindDirection(C1531a0.D(jSONObjectOptJSONObject2, "daywind"));
                                        localDayWeatherForecast.setNightWindDirection(C1531a0.D(jSONObjectOptJSONObject2, "nightwind"));
                                        localDayWeatherForecast.setDayWindPower(C1531a0.D(jSONObjectOptJSONObject2, "daypower"));
                                        localDayWeatherForecast.setNightWindPower(C1531a0.D(jSONObjectOptJSONObject2, "nightpower"));
                                        arrayList.add(localDayWeatherForecast);
                                    }
                                }
                                localWeatherForecast.setWeatherForecast(arrayList);
                            }
                        }
                    }
                }
            } else {
                localWeatherForecast = null;
            }
            this.f16297E = localWeatherForecast;
            return localWeatherForecast;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/weather/weatherInfo?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.f16103z).getCity();
        if (!C1531a0.m(city)) {
            String strM = m(city);
            stringBuffer.append("&city=");
            stringBuffer.append(strM);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + C1567j0.n(this.f16099B));
        return stringBuffer.toString();
    }

    public Object o() {
        return this.f16103z;
    }
}
