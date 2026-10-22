package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Y1 extends Q1<RouteSearch.BusRouteQuery, BusRouteResult> {
    public Y1(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(M5.a.CARD_TYPE_ROUTE)) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            if (jSONObjectOptJSONObject != null) {
                busRouteResult.setStartPos(C1531a0.n(jSONObjectOptJSONObject, "origin"));
                busRouteResult.setTargetPos(C1531a0.n(jSONObjectOptJSONObject, "destination"));
                busRouteResult.setTaxiCost(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject, "taxi_cost")));
                if (jSONObjectOptJSONObject.has("transits") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("transits")) != null) {
                    busRouteResult.setPaths(C1531a0.y(jSONArrayOptJSONArray));
                    return busRouteResult;
                }
            }
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/direction/transit/integrated?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        stringBuffer.append("&origin=");
        stringBuffer.append(C1631z1.e(((RouteSearch.BusRouteQuery) this.f16103z).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C1631z1.e(((RouteSearch.BusRouteQuery) this.f16103z).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f16103z).getCity();
        if (!C1531a0.m(city)) {
            city = m(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!C1531a0.m(((RouteSearch.BusRouteQuery) this.f16103z).getCity())) {
            String strM = m(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(strM);
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.BusRouteQuery) this.f16103z).getMode());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.f16103z).getNightFlag());
        if (TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.f16103z).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.f16103z).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}
