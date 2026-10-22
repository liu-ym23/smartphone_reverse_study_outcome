package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.utils.Property;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m extends l {
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(java.lang.String r19, com.baidu.mapapi.search.route.TransitRouteResult r20) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.route.m.a(java.lang.String, com.baidu.mapapi.search.route.TransitRouteResult):boolean");
    }

    private RouteNode c(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null || "".equals(str)) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObjectOptJSONObject.optString("wd"));
        routeNode.setUid(jSONObjectOptJSONObject.optString("uid"));
        routeNode.setLocation(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString("pt")));
        return routeNode;
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z4 = false;
        for (char c4 : str.toCharArray()) {
            if (c4 == '<') {
                z4 = true;
            } else if (c4 == '>') {
                z4 = false;
            } else if (!z4) {
                sb.append(c4);
            }
        }
        return sb.toString();
    }

    public void b(String str, TransitRouteResult transitRouteResult) {
        if (str == null || str.equals("")) {
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    transitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        transitRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        return;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        transitRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        return;
                    } else {
                        transitRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
            }
            if (a(str, transitRouteResult, false) || a(str, transitRouteResult)) {
                return;
            }
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } catch (Exception unused) {
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }

    private VehicleInfo c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setZonePrice(jSONObject.optInt("zone_price"));
        vehicleInfo.setTotalPrice(jSONObject.optInt("total_price"));
        vehicleInfo.setTitle(jSONObject.optString("name"));
        vehicleInfo.setPassStationNum(jSONObject.optInt("stop_num"));
        vehicleInfo.setUid(jSONObject.optString("uid"));
        vehicleInfo.setStartTime(jSONObject.optString(DataContractKt.EXTRA_START_TIME));
        vehicleInfo.setEndTime(jSONObject.optString(DataContractKt.EXTRA_END_TIME));
        vehicleInfo.setHeadWay(jSONObject.optString("headway"));
        vehicleInfo.setDirectText(jSONObject.optString("direct_text"));
        return vehicleInfo;
    }

    private TaxiInfo b(JSONObject jSONObject) {
        float fOptDouble;
        float fOptDouble2;
        float fOptDouble3;
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("detail");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                fOptDouble = Property.DEFAULT_FLOAT_VALUE;
                fOptDouble2 = 0.0f;
                fOptDouble3 = 0.0f;
                break;
            }
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i4);
            if (jSONObject2 != null && jSONObject2.optString("desc").contains("白天")) {
                fOptDouble = (float) jSONObject2.optDouble("km_price");
                fOptDouble2 = (float) jSONObject2.optDouble("start_price");
                fOptDouble3 = (float) jSONObject2.optDouble("total_price");
                break;
            }
            i4++;
        }
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt("distance"));
        taxiInfo.setDuration(jSONObject.optInt("duration"));
        taxiInfo.setTotalPrice(fOptDouble3);
        taxiInfo.setStartPrice(fOptDouble2);
        taxiInfo.setPerKMPrice(fOptDouble);
        return taxiInfo;
    }
}
