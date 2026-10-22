package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Z0 extends AbstractC1564i1<WeatherSearchQuery, LocalWeatherLive> {

    /* renamed from: E, reason: collision with root package name */
    public LocalWeatherLive f16498E;

    public Z0(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f16498E = new LocalWeatherLive();
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        LocalWeatherLive localWeatherLive;
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lives")) {
                localWeatherLive = new LocalWeatherLive();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lives");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
                    localWeatherLive.setAdCode(C1531a0.D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    localWeatherLive.setProvince(C1531a0.D(jSONObjectOptJSONObject, "province"));
                    localWeatherLive.setCity(C1531a0.D(jSONObjectOptJSONObject, "city"));
                    localWeatherLive.setWeather(C1531a0.D(jSONObjectOptJSONObject, O5.c.WEATHER));
                    localWeatherLive.setTemperature(C1531a0.D(jSONObjectOptJSONObject, LlmRuntimeArgsBundle.KEY_TEMPERATURE));
                    localWeatherLive.setWindDirection(C1531a0.D(jSONObjectOptJSONObject, "winddirection"));
                    localWeatherLive.setWindPower(C1531a0.D(jSONObjectOptJSONObject, "windpower"));
                    localWeatherLive.setHumidity(C1531a0.D(jSONObjectOptJSONObject, "humidity"));
                    localWeatherLive.setReportTime(C1531a0.D(jSONObjectOptJSONObject, "reporttime"));
                }
            } else {
                localWeatherLive = null;
            }
            this.f16498E = localWeatherLive;
            return localWeatherLive;
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
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + C1567j0.n(this.f16099B));
        return stringBuffer.toString();
    }

    public Object o() {
        return this.f16103z;
    }
}
