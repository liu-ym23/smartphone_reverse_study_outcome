package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a3 extends Q1<DistanceSearch.DistanceQuery, DistanceResult> {
    public a3(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws JSONException, AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i10);
                distanceItem.setOriginId(C1531a0.Y(C1531a0.D(jSONObject2, "origin_id")));
                distanceItem.setDestId(C1531a0.Y(C1531a0.D(jSONObject2, "dest_id")));
                distanceItem.setDistance(C1531a0.W(C1531a0.D(jSONObject2, "distance")));
                distanceItem.setDuration(C1531a0.W(C1531a0.D(jSONObject2, "duration")));
                String strD = C1531a0.D(jSONObject2, "info");
                if (!TextUtils.isEmpty(strD)) {
                    distanceItem.setErrorInfo(strD);
                    distanceItem.setErrorCode(C1531a0.Y(C1531a0.D(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/distance?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.f16103z).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i10 = 0; i10 < size; i10++) {
                LatLonPoint latLonPoint = origins.get(i10);
                if (latLonPoint != null) {
                    double dA = C1631z1.a(latLonPoint.getLatitude());
                    stringBuffer.append(C1631z1.a(latLonPoint.getLongitude()));
                    stringBuffer.append(Const.STR_MART_COMMA);
                    stringBuffer.append(dA);
                    if (i10 < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.f16103z).getDestination();
        if (destination != null) {
            double dA2 = C1631z1.a(destination.getLatitude());
            double dA3 = C1631z1.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(dA3);
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(dA2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.f16103z).getType());
        if (TextUtils.isEmpty(((DistanceSearch.DistanceQuery) this.f16103z).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f16103z).getExtensions());
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) this.f16103z).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f16103z).getMode());
        }
        return stringBuffer.toString();
    }
}
