package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherLifeIndexes;
import com.baidu.mapapi.search.weather.WeatherResult;
import com.baidu.mapapi.search.weather.WeatherSearchAlerts;
import com.baidu.mapapi.search.weather.WeatherSearchForecastForHours;
import com.baidu.mapapi.search.weather.WeatherSearchLocation;
import com.baidu.mapapi.search.weather.WeatherSearchRealTime;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.b {
    private boolean b(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("forecast_hours")) == null) {
            return false;
        }
        if (weatherResult.getForecastHours() == null) {
            weatherResult.setForecastHours(new ArrayList());
        }
        JSONObject jSONObject2 = null;
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (jSONObject2 != null) {
                WeatherSearchForecastForHours weatherSearchForecastForHours = new WeatherSearchForecastForHours();
                weatherSearchForecastForHours.setClouds(jSONObject2.optInt("clouds"));
                weatherSearchForecastForHours.setDataTime(jSONObject2.optString("data_time"));
                weatherSearchForecastForHours.setHourlyPrecipitation(jSONObject2.optInt("prec_1h"));
                weatherSearchForecastForHours.setRelativeHumidity(jSONObject2.optInt("rh"));
                weatherSearchForecastForHours.setTemperature(jSONObject2.optInt("temp_fc"));
                weatherSearchForecastForHours.setPhenomenon(jSONObject2.optString("text"));
                weatherSearchForecastForHours.setWindDirection(jSONObject2.optString("wind_dir"));
                weatherSearchForecastForHours.setWindPower(jSONObject2.optString("wind_class"));
                weatherResult.getForecastHours().add(weatherSearchForecastForHours);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c(org.json.JSONObject r5, com.baidu.mapapi.search.weather.WeatherResult r6) {
        /*
            r4 = this;
            r4 = 0
            if (r5 == 0) goto Lb3
            if (r6 != 0) goto L7
            goto Lb3
        L7:
            java.lang.String r0 = "forecasts"
            org.json.JSONArray r5 = r5.optJSONArray(r0)
            if (r5 != 0) goto L10
            return r4
        L10:
            java.util.List r0 = r6.getForecasts()
            if (r0 != 0) goto L1e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.setForecasts(r0)
        L1e:
            r0 = 0
        L1f:
            int r1 = r5.length()
            if (r4 >= r1) goto Lb2
            java.lang.Object r1 = r5.get(r4)     // Catch: org.json.JSONException -> L34
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: org.json.JSONException -> L34
            com.baidu.mapapi.search.weather.WeatherSearchForecasts r0 = new com.baidu.mapapi.search.weather.WeatherSearchForecasts     // Catch: org.json.JSONException -> L32
            r0.<init>()     // Catch: org.json.JSONException -> L32
        L30:
            r0 = r1
            goto L3c
        L32:
            r0 = move-exception
            goto L38
        L34:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L38:
            r0.printStackTrace()
            goto L30
        L3c:
            if (r0 != 0) goto L3f
            goto Lae
        L3f:
            com.baidu.mapapi.search.weather.WeatherSearchForecasts r1 = new com.baidu.mapapi.search.weather.WeatherSearchForecasts
            r1.<init>()
            java.lang.String r2 = "date"
            java.lang.String r2 = r0.optString(r2)
            r1.setDate(r2)
            java.lang.String r2 = "high"
            int r2 = r0.optInt(r2)
            r1.setHighestTemp(r2)
            java.lang.String r2 = "low"
            int r2 = r0.optInt(r2)
            r1.setLowestTemp(r2)
            java.lang.String r2 = "text_day"
            java.lang.String r2 = r0.optString(r2)
            r1.setPhenomenonDay(r2)
            java.lang.String r2 = "text_night"
            java.lang.String r2 = r0.optString(r2)
            r1.setPhenomenonNight(r2)
            java.lang.String r2 = "week"
            java.lang.String r2 = r0.optString(r2)
            r1.setWeek(r2)
            java.lang.String r2 = "wd_day"
            java.lang.String r2 = r0.optString(r2)
            r1.setWindDirectionDay(r2)
            java.lang.String r2 = "wc_day"
            java.lang.String r2 = r0.optString(r2)
            r1.setWindPowerDay(r2)
            java.lang.String r2 = "wd_night"
            java.lang.String r2 = r0.optString(r2)
            r1.setWindDirectionNight(r2)
            java.lang.String r2 = "wc_night"
            java.lang.String r2 = r0.optString(r2)
            r1.setWindPowerNight(r2)
            java.lang.String r2 = "aqi"
            int r2 = r0.optInt(r2)
            r1.setAirQualityIndex(r2)
            java.util.List r2 = r6.getForecasts()
            r2.add(r1)
        Lae:
            int r4 = r4 + 1
            goto L1f
        Lb2:
            r4 = 1
        Lb3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.weather.a.c(org.json.JSONObject, com.baidu.mapapi.search.weather.WeatherResult):boolean");
    }

    private boolean d(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("indexes")) == null) {
            return false;
        }
        if (weatherResult.getLifeIndexes() == null) {
            weatherResult.setLifeIndexes(new ArrayList());
        }
        JSONObject jSONObject2 = null;
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (jSONObject2 != null) {
                WeatherLifeIndexes weatherLifeIndexes = new WeatherLifeIndexes();
                weatherLifeIndexes.setBrief(jSONObject2.optString("brief"));
                weatherLifeIndexes.setDetail(jSONObject2.optString("detail"));
                weatherLifeIndexes.setName(jSONObject2.optString("name"));
                weatherResult.getLifeIndexes().add(weatherLifeIndexes);
            }
        }
        return true;
    }

    private boolean e(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || weatherResult == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(MapController.LOCATION_LAYER_TAG)) == null) {
            return false;
        }
        if (weatherResult.getLocation() != null) {
            a(weatherResult.getLocation(), jSONObjectOptJSONObject);
            return true;
        }
        WeatherSearchLocation weatherSearchLocation = new WeatherSearchLocation();
        a(weatherSearchLocation, jSONObjectOptJSONObject);
        weatherResult.setLocation(weatherSearchLocation);
        return true;
    }

    private boolean f(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || weatherResult == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("now")) == null) {
            return false;
        }
        if (weatherResult.getRealTimeWeather() != null) {
            a(weatherResult.getRealTimeWeather(), jSONObjectOptJSONObject);
            return true;
        }
        WeatherSearchRealTime weatherSearchRealTime = new WeatherSearchRealTime();
        a(weatherSearchRealTime, jSONObjectOptJSONObject);
        weatherResult.setRealTimeWeather(weatherSearchRealTime);
        return true;
    }

    private boolean g(JSONObject jSONObject, WeatherResult weatherResult) {
        weatherResult.status = jSONObject.optInt("status");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
        if (jSONObjectOptJSONObject == null) {
            return false;
        }
        e(jSONObjectOptJSONObject, weatherResult);
        f(jSONObjectOptJSONObject, weatherResult);
        a(jSONObjectOptJSONObject, weatherResult);
        b(jSONObjectOptJSONObject, weatherResult);
        c(jSONObjectOptJSONObject, weatherResult);
        d(jSONObjectOptJSONObject, weatherResult);
        return true;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        JSONObject jSONObject;
        WeatherResult weatherResult = new WeatherResult();
        if (str == null) {
            weatherResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return weatherResult;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            weatherResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return weatherResult;
        }
        if (jSONObject.has("SDK_InnerError")) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
            if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                weatherResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                return weatherResult;
            }
            if (jSONObjectOptJSONObject.has("httpStateError")) {
                String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                strOptString.getClass();
                if (strOptString.equals("NETWORK_ERROR")) {
                    weatherResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                } else if (strOptString.equals("REQUEST_ERROR")) {
                    weatherResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                } else {
                    weatherResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
                return weatherResult;
            }
        }
        if (!a(str, weatherResult, true)) {
            g(jSONObject, weatherResult);
        }
        return weatherResult;
    }

    private void a(WeatherSearchLocation weatherSearchLocation, JSONObject jSONObject) {
        weatherSearchLocation.setCountry(jSONObject.optString("country"));
        weatherSearchLocation.setProvince(jSONObject.optString("province"));
        weatherSearchLocation.setCity(jSONObject.optString("city"));
        weatherSearchLocation.setDistrictName(jSONObject.optString("name"));
        weatherSearchLocation.setDistrictID(jSONObject.optString("id"));
    }

    private void a(WeatherSearchRealTime weatherSearchRealTime, JSONObject jSONObject) {
        weatherSearchRealTime.setPhenomenon(jSONObject.optString("text"));
        weatherSearchRealTime.setTemperature(jSONObject.optInt("temp"));
        weatherSearchRealTime.setSensoryTemp(jSONObject.optInt("feels_like"));
        weatherSearchRealTime.setRelativeHumidity(jSONObject.optInt("rh"));
        weatherSearchRealTime.setWindPower(jSONObject.optString("wind_class"));
        weatherSearchRealTime.setWindDirection(jSONObject.optString("wind_dir"));
        weatherSearchRealTime.setUpdateTime(jSONObject.optString("uptime"));
        weatherSearchRealTime.setCO((float) jSONObject.optDouble("co"));
        weatherSearchRealTime.setNO2(jSONObject.optInt("no2"));
        weatherSearchRealTime.setPM10(jSONObject.optInt("pm10"));
        weatherSearchRealTime.setPM2_5(jSONObject.optInt("pm25"));
        weatherSearchRealTime.setClouds(jSONObject.optInt("clouds"));
        weatherSearchRealTime.setAirQualityIndex(jSONObject.optInt("aqi"));
        weatherSearchRealTime.setSO2(jSONObject.optInt("so2"));
        weatherSearchRealTime.setVisibility(jSONObject.optInt("vis"));
        weatherSearchRealTime.setO3(jSONObject.optInt("o3"));
        weatherSearchRealTime.setHourlyPrecipitation(jSONObject.optInt("prec_1h"));
    }

    private boolean a(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("alerts")) == null) {
            return false;
        }
        if (weatherResult.getWeatherAlerts() == null) {
            weatherResult.setWeatherAlerts(new ArrayList());
        }
        JSONObject jSONObject2 = null;
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (jSONObject2 != null) {
                WeatherSearchAlerts weatherSearchAlerts = new WeatherSearchAlerts();
                weatherSearchAlerts.setDesc(jSONObject2.optString("desc"));
                weatherSearchAlerts.setLevel(jSONObject2.optString("level"));
                weatherSearchAlerts.setTitle(jSONObject2.optString("title"));
                weatherSearchAlerts.setType(jSONObject2.optString("type"));
                weatherResult.getWeatherAlerts().add(weatherSearchAlerts);
            }
        }
        return true;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetWeatherResultListener)) {
            return;
        }
        ((OnGetWeatherResultListener) obj).onGetWeatherResultListener((WeatherResult) searchResult);
    }
}
