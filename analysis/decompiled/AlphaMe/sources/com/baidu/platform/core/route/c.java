package com.baidu.platform.core.route;

import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends l {
    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        boolean z4 = false;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("result");
            if (jSONObjectOptJSONObject == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("error");
            if (iOptInt != 0) {
                if (iOptInt != 4) {
                    return false;
                }
                drivingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                return true;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("cars");
            if (jSONObjectOptJSONObject2 == null) {
                return false;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("option");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("content");
            if (jSONObjectOptJSONObject3 == null || jSONObjectOptJSONObject4 == null) {
                return false;
            }
            RouteNode routeNodeB = b(jSONObjectOptJSONObject3.optJSONObject("start"));
            ArrayList arrayList = new ArrayList();
            RouteNode routeNodeA = a(jSONObjectOptJSONObject3.optJSONArray("end"), arrayList);
            List<DrivingRouteLine.DrivingStep> listA = a(jSONObjectOptJSONObject4.optJSONArray("steps"), jSONObjectOptJSONObject4.optJSONArray("stepts"));
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("routes");
            if (jSONArrayOptJSONArray == null) {
                return false;
            }
            int i4 = 0;
            while (i4 < jSONArrayOptJSONArray.length()) {
                DrivingRouteLine drivingRouteLine = new DrivingRouteLine();
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject5 == null) {
                    jSONObject = jSONObjectOptJSONObject4;
                    jSONArray = jSONArrayOptJSONArray;
                } else {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject5.optJSONArray("legs");
                    if (jSONArrayOptJSONArray2 == null) {
                        return z4;
                    }
                    int length = jSONArrayOptJSONArray2.length();
                    ArrayList arrayList3 = new ArrayList();
                    jSONObject = jSONObjectOptJSONObject4;
                    jSONArray = jSONArrayOptJSONArray;
                    int iOptInt2 = 0;
                    int i5 = 0;
                    int iOptInt3 = 0;
                    while (i5 < length) {
                        int i6 = length;
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray2.optJSONObject(i5);
                        JSONArray jSONArray2 = jSONArrayOptJSONArray2;
                        if (jSONObjectOptJSONObject6 != null) {
                            iOptInt2 += jSONObjectOptJSONObject6.optInt("distance");
                            iOptInt3 += jSONObjectOptJSONObject6.optInt("duration");
                            List<DrivingRouteLine.DrivingStep> listB = b(jSONObjectOptJSONObject6.optJSONArray("stepis"), listA);
                            if (listB != null) {
                                arrayList3.addAll(listB);
                            }
                        }
                        i5++;
                        length = i6;
                        jSONArrayOptJSONArray2 = jSONArray2;
                    }
                    drivingRouteLine.setStarting(routeNodeB);
                    drivingRouteLine.setTerminal(routeNodeA);
                    if (arrayList.size() == 0) {
                        drivingRouteLine.setWayPoints(null);
                    } else {
                        drivingRouteLine.setWayPoints(arrayList);
                    }
                    drivingRouteLine.setDistance(iOptInt2);
                    drivingRouteLine.setDuration(iOptInt3);
                    drivingRouteLine.setCongestionDistance(jSONObjectOptJSONObject5.optInt("congestion_length"));
                    drivingRouteLine.setLightNum(jSONObjectOptJSONObject5.optInt("light_num"));
                    drivingRouteLine.setToll(jSONObjectOptJSONObject5.optInt("toll"));
                    if (arrayList3.size() == 0) {
                        drivingRouteLine.setSteps(null);
                    } else {
                        drivingRouteLine.setSteps(arrayList3);
                    }
                    arrayList2.add(drivingRouteLine);
                }
                i4++;
                jSONArrayOptJSONArray = jSONArray;
                jSONObjectOptJSONObject4 = jSONObject;
                z4 = false;
            }
            drivingRouteResult.setRouteLines(arrayList2);
            drivingRouteResult.setTaxiInfos(c(jSONObjectOptJSONObject4.optString("taxis")));
            return true;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private List<TaxiInfo> c(String str) throws JSONException {
        if (str != null && str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    if (jSONObject != null) {
                        TaxiInfo taxiInfo = new TaxiInfo();
                        String strOptString = jSONObject.optString("total_price");
                        if (strOptString == null || strOptString.equals("")) {
                            taxiInfo.setTotalPrice(Property.DEFAULT_FLOAT_VALUE);
                        } else {
                            taxiInfo.setTotalPrice(Float.parseFloat(strOptString));
                        }
                        arrayList.add(taxiInfo);
                    }
                }
                return arrayList;
            } catch (JSONException e4) {
                if (Logger.debugEnable()) {
                    e4.printStackTrace();
                }
            }
        }
        return null;
    }

    public void a(String str, DrivingRouteResult drivingRouteResult) {
        if (str == null || str.equals("")) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    drivingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        return;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        return;
                    } else {
                        drivingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
            }
            if (a(str, drivingRouteResult, false) || b(str, drivingRouteResult)) {
                return;
            }
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } catch (Exception unused) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }

    private int[] c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("end");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("status");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        int length2 = jSONArrayOptJSONArray2.length();
        int i4 = 0;
        while (i4 < length) {
            int iOptInt = jSONArrayOptJSONArray.optInt(i4);
            int iOptInt2 = i4 < length2 ? jSONArrayOptJSONArray2.optInt(i4) : 0;
            for (int i5 = 0; i5 < iOptInt; i5++) {
                arrayList.add(Integer.valueOf(iOptInt2));
            }
            i4++;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr;
    }

    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject != null) {
                    RouteNode routeNodeB = b(jSONObjectOptJSONObject);
                    if (i4 == length - 1) {
                        return routeNodeB;
                    }
                    list.add(routeNodeB);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep> a(org.json.JSONArray r20, org.json.JSONArray r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.route.c.a(org.json.JSONArray, org.json.JSONArray):java.util.List");
    }

    private RouteNode b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString("wd"));
        routeNode.setUid(jSONObject.optString("uid"));
        GeoPoint geoPoint = new GeoPoint(0, 0);
        if (jSONObject.optJSONArray("spt") != null) {
            geoPoint.setLongitudeE6(r4.optInt(0));
            geoPoint.setLatitudeE6(r4.optInt(1));
        }
        routeNode.setLocation(CoordUtil.mc2ll(geoPoint));
        return routeNode;
    }

    private List<LatLng> b(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) < 6) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        double dOptInt = 0.0d;
        double dOptInt2 = 0.0d;
        for (int i4 = 5; i4 < length; i4++) {
            if (i4 % 2 != 0) {
                dOptInt2 += jSONArray.optInt(i4);
            } else {
                dOptInt += jSONArray.optInt(i4);
                arrayList.add(CoordUtil.mc2ll(new GeoPoint(dOptInt, dOptInt2)));
            }
        }
        return arrayList;
    }

    private List<DrivingRouteLine.DrivingStep> b(JSONArray jSONArray, List<DrivingRouteLine.DrivingStep> list) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0 || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("n");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("s");
                for (int i5 = 0; i5 < iOptInt; i5++) {
                    int i6 = iOptInt2 + i5;
                    if (i6 < list.size()) {
                        arrayList.add(list.get(i6));
                    }
                }
            }
        }
        return arrayList;
    }
}
