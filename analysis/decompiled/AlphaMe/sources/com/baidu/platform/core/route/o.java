package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o extends l {
    private boolean a(String str, WalkingRouteResult walkingRouteResult) {
        JSONArray jSONArrayOptJSONArray;
        if (str != null && !"".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (walkingRouteResult == null) {
                    return false;
                }
                if (jSONObject.has("taxi")) {
                    walkingRouteResult.setTaxiInfo(c(jSONObject.optString("taxi")));
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject == null) {
                    return false;
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("error");
                if (iOptInt != 0) {
                    if (iOptInt != 4) {
                        return false;
                    }
                    walkingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                    return true;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("walk");
                if (jSONObjectOptJSONObject2 == null) {
                    return false;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("routes");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("option");
                if (jSONObjectOptJSONObject3 == null || jSONArrayOptJSONArray2 == null) {
                    return false;
                }
                RouteNode routeNodeB = b(jSONObjectOptJSONObject3.optJSONObject("start"));
                RouteNode routeNodeA = a(jSONObjectOptJSONObject3.optJSONArray("end"), (List<RouteNode>) null);
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i4);
                    if (jSONObjectOptJSONObject4 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("legs")) != null && jSONArrayOptJSONArray.length() > 0) {
                        for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i4);
                            if (jSONObjectOptJSONObject5 != null) {
                                WalkingRouteLine walkingRouteLine = new WalkingRouteLine();
                                walkingRouteLine.setStarting(routeNodeB);
                                walkingRouteLine.setTerminal(routeNodeA);
                                walkingRouteLine.setDistance(jSONObjectOptJSONObject5.optInt("distance"));
                                walkingRouteLine.setDuration(jSONObjectOptJSONObject5.optInt("duration"));
                                walkingRouteLine.setSteps(b(jSONObjectOptJSONObject5.optJSONArray("steps")));
                                arrayList.add(walkingRouteLine);
                            }
                        }
                    }
                }
                walkingRouteResult.setRouteLines(arrayList);
                return true;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    private TaxiInfo c(String str) {
        JSONObject jSONObject;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt("distance"));
        taxiInfo.setDuration(jSONObject.optInt("duration"));
        taxiInfo.setTotalPrice((float) jSONObject.optDouble("total_price"));
        taxiInfo.setStartPrice((float) jSONObject.optDouble("start_price"));
        taxiInfo.setPerKMPrice((float) jSONObject.optDouble("km_price"));
        return taxiInfo;
    }

    public void b(String str, WalkingRouteResult walkingRouteResult) {
        if (str == null || str.equals("")) {
            walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    walkingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        walkingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        return;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        walkingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        return;
                    } else {
                        walkingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
            }
            if (a(str, walkingRouteResult, false) || a(str, walkingRouteResult)) {
                return;
            }
            walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } catch (Exception unused) {
            walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }

    private RouteNode b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString("wd"));
        routeNode.setUid(jSONObject.optString("uid"));
        routeNode.setLocation(CoordUtil.decodeLocation(jSONObject.optString("pt")));
        return routeNode;
    }

    private List<WalkingRouteLine.WalkingStep> b(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
            if (jSONObjectOptJSONObject != null) {
                WalkingRouteLine.WalkingStep walkingStep = new WalkingRouteLine.WalkingStep();
                walkingStep.setDirection(jSONObjectOptJSONObject.optInt("direction") * 30);
                walkingStep.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                walkingStep.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                walkingStep.setEntrance(RouteNode.location(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString("start_location"))));
                walkingStep.setExit(RouteNode.location(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString("end_location"))));
                String strOptString = jSONObjectOptJSONObject.optString("instructions");
                if (strOptString != null && strOptString.length() >= 4) {
                    strOptString = strOptString.replaceAll("</?[a-z]>", "");
                }
                walkingStep.setInstructions(strOptString);
                walkingStep.setEntranceInstructions(jSONObjectOptJSONObject.optString("start_instructions"));
                walkingStep.setExitInstructions(jSONObjectOptJSONObject.optString("end_instructions"));
                walkingStep.setPathString(jSONObjectOptJSONObject.optString("path"));
                arrayList.add(walkingStep);
            }
        }
        return arrayList;
    }

    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i4 = 0; i4 < length; i4++) {
                RouteNode routeNodeB = b(jSONArray.optJSONObject(i4));
                if (i4 == length - 1) {
                    return routeNodeB;
                }
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(routeNodeB);
            }
        }
        return null;
    }
}
