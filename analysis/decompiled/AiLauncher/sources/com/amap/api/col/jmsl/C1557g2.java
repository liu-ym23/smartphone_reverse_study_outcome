package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.g2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1557g2 extends Q1<RouteSearchV2.BusRouteQuery, BusRouteResultV2> {
    public C1557g2(Context context, RouteSearchV2.BusRouteQuery busRouteQuery) {
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
            BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            if (jSONObjectOptJSONObject != null) {
                busRouteResultV2.setStartPos(C1531a0.n(jSONObjectOptJSONObject, "origin"));
                busRouteResultV2.setTargetPos(C1531a0.n(jSONObjectOptJSONObject, "destination"));
                busRouteResultV2.setDistance(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject, "distance")));
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cost");
                if (jSONObjectOptJSONObject2 != null) {
                    busRouteResultV2.setTaxiCost(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject2, "taxi_fee")));
                }
                if (jSONObjectOptJSONObject.has("transits") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("transits")) != null) {
                    busRouteResultV2.setPaths(C1531a0.E(jSONArrayOptJSONArray));
                    return busRouteResultV2;
                }
            }
            return busRouteResultV2;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.e(this.f16099B) + "/direction/transit/integrated?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        stringBuffer.append("&origin=");
        stringBuffer.append(C1631z1.e(((RouteSearchV2.BusRouteQuery) this.f16103z).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C1631z1.e(((RouteSearchV2.BusRouteQuery) this.f16103z).getFromAndTo().getTo()));
        String city = ((RouteSearchV2.BusRouteQuery) this.f16103z).getCity();
        if (!C1531a0.m(city)) {
            city = m(city);
            stringBuffer.append("&city1=");
            stringBuffer.append(city);
        }
        if (!C1531a0.m(((RouteSearchV2.BusRouteQuery) this.f16103z).getCity())) {
            String strM = m(city);
            stringBuffer.append("&city2=");
            stringBuffer.append(strM);
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearchV2.BusRouteQuery) this.f16103z).getMode());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f16103z).getNightFlag());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(C1631z1.d(((RouteSearchV2.BusRouteQuery) this.f16103z).getShowFields()));
        String originPoiId = ((RouteSearchV2.BusRouteQuery) this.f16103z).getOriginPoiId();
        if (!TextUtils.isEmpty(originPoiId)) {
            stringBuffer.append("&originpoi=");
            stringBuffer.append(originPoiId);
        }
        String destinationPoiId = ((RouteSearchV2.BusRouteQuery) this.f16103z).getDestinationPoiId();
        if (!TextUtils.isEmpty(destinationPoiId)) {
            stringBuffer.append("&destinationpoi=");
            stringBuffer.append(destinationPoiId);
        }
        String ad1 = ((RouteSearchV2.BusRouteQuery) this.f16103z).getAd1();
        if (!TextUtils.isEmpty(ad1)) {
            stringBuffer.append("&ad1=");
            stringBuffer.append(ad1);
        }
        String ad2 = ((RouteSearchV2.BusRouteQuery) this.f16103z).getAd2();
        if (!TextUtils.isEmpty(ad2)) {
            stringBuffer.append("&ad2=");
            stringBuffer.append(ad2);
        }
        String date = ((RouteSearchV2.BusRouteQuery) this.f16103z).getDate();
        if (!TextUtils.isEmpty(date)) {
            stringBuffer.append("&date=");
            stringBuffer.append(date);
        }
        String time = ((RouteSearchV2.BusRouteQuery) this.f16103z).getTime();
        if (!TextUtils.isEmpty(time)) {
            stringBuffer.append("&time=");
            stringBuffer.append(time);
        }
        stringBuffer.append("&AlternativeRoute=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f16103z).getAlternativeRoute());
        stringBuffer.append("&multiexport=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f16103z).getMultiExport());
        stringBuffer.append("&max_trans=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f16103z).getMaxTrans());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}
