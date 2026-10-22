package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.b {
    private SuggestAddrInfo b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("origin");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("destination");
        if (jSONObjectOptJSONObject != null) {
            int iOptInt = jSONObjectOptJSONObject.optInt("listType");
            String strOptString = jSONObjectOptJSONObject.optString("cityName");
            if (iOptInt == 1) {
                suggestAddrInfo.setSuggestStartCity(a(jSONObjectOptJSONObject, "content"));
            } else if (iOptInt == 0) {
                suggestAddrInfo.setSuggestStartNode(a(jSONObjectOptJSONObject, "content", strOptString));
            }
        }
        if (jSONObjectOptJSONObject2 != null) {
            int iOptInt2 = jSONObjectOptJSONObject2.optInt("listType");
            String strOptString2 = jSONObjectOptJSONObject2.optString("cityName");
            if (iOptInt2 == 1) {
                suggestAddrInfo.setSuggestEndCity(a(jSONObjectOptJSONObject2, "content"));
            } else if (iOptInt2 == 0) {
                suggestAddrInfo.setSuggestEndNode(a(jSONObjectOptJSONObject2, "content", strOptString2));
            }
        }
        return suggestAddrInfo;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        BikingRouteResult bikingRouteResult = new BikingRouteResult();
        if (str == null || str.equals("")) {
            bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return bikingRouteResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    bikingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return bikingRouteResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        bikingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        bikingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return bikingRouteResult;
                }
            }
            if (!a(str, (SearchResult) bikingRouteResult, false) && !a(str, bikingRouteResult)) {
                bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return bikingRouteResult;
        } catch (Exception unused) {
            bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return bikingRouteResult;
        }
    }

    private RouteNode b(JSONObject jSONObject, String str, String str2) {
        RouteNode routeNode = null;
        if (jSONObject != null && str != null && !"".equals(str)) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            routeNode = new RouteNode();
            routeNode.setTitle(jSONObjectOptJSONObject.optString("wd"));
            routeNode.setUid(jSONObjectOptJSONObject.optString("uid"));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2);
            if (jSONObjectOptJSONObject2 != null) {
                LatLng latLng = new LatLng(jSONObjectOptJSONObject2.optDouble("lat"), jSONObjectOptJSONObject2.optDouble("lng"));
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng = CoordTrans.baiduToGcj(latLng);
                }
                routeNode.setLocation(latLng);
            }
        }
        return routeNode;
    }

    private boolean a(String str, BikingRouteResult bikingRouteResult) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("status_sdk");
                if (iOptInt != 0) {
                    if (iOptInt == 1) {
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return true;
                    }
                    if (iOptInt == 2) {
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                        bikingRouteResult.setMessage(jSONObject.optString("message"));
                    }
                    return false;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject2 == null) {
                    return false;
                }
                int iOptInt2 = jSONObject.optInt("type");
                if (iOptInt2 == 1) {
                    bikingRouteResult.setSuggestAddrInfo(b(jSONObjectOptJSONObject2));
                    bikingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                } else {
                    if (iOptInt2 != 2 || (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("routes")) == null || jSONArrayOptJSONArray.length() <= 0) {
                        return false;
                    }
                    RouteNode routeNodeB = b(jSONObjectOptJSONObject2, "origin", "originPt");
                    RouteNode routeNodeB2 = b(jSONObjectOptJSONObject2, "destination", "destinationPt");
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        BikingRouteLine bikingRouteLine = new BikingRouteLine();
                        try {
                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                        } catch (Exception unused) {
                        }
                        if (jSONObjectOptJSONObject == null) {
                            return false;
                        }
                        bikingRouteLine.setStarting(routeNodeB);
                        bikingRouteLine.setTerminal(routeNodeB2);
                        bikingRouteLine.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                        bikingRouteLine.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                        bikingRouteLine.setSteps(a(jSONObjectOptJSONObject.optJSONArray("steps")));
                        arrayList.add(bikingRouteLine);
                    }
                    bikingRouteResult.setRouteLines(arrayList);
                }
                return true;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    private List<BikingRouteLine.BikingStep> a(JSONArray jSONArray) {
        boolean z4 = jSONArray == null;
        int length = jSONArray.length();
        if ((length <= 0) || z4) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
            if (jSONObjectOptJSONObject != null) {
                BikingRouteLine.BikingStep bikingStep = new BikingRouteLine.BikingStep();
                bikingStep.setDirection(jSONObjectOptJSONObject.optInt("direction") * 30);
                bikingStep.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                bikingStep.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                bikingStep.setName(jSONObjectOptJSONObject.optString("name"));
                bikingStep.setTurnType(jSONObjectOptJSONObject.optString("turn_type"));
                bikingStep.setRestrictionsInfo(jSONObjectOptJSONObject.optString("restrictions_info"));
                bikingStep.setRestrictionsStatus(jSONObjectOptJSONObject.optInt("restrictions_status"));
                bikingStep.setEntrance(RouteNode.location(a(jSONObjectOptJSONObject.optJSONObject("stepOriginLocation"))));
                bikingStep.setExit(RouteNode.location(a(jSONObjectOptJSONObject.optJSONObject("stepDestinationLocation"))));
                String strOptString = jSONObjectOptJSONObject.optString("instructions");
                if (strOptString != null && strOptString.length() >= 4) {
                    strOptString = strOptString.replaceAll("</?[a-z]>", "");
                }
                bikingStep.setInstructions(strOptString);
                bikingStep.setEntranceInstructions(jSONObjectOptJSONObject.optString("stepOriginInstruction"));
                bikingStep.setExitInstructions(jSONObjectOptJSONObject.optString("stepDestinationInstruction"));
                bikingStep.setPathString(jSONObjectOptJSONObject.optString("path"));
                arrayList.add(bikingStep);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LatLng latLng = new LatLng(jSONObject.optDouble("lat"), jSONObject.optDouble("lng"));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    public List<CityInfo> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = null;
        if (jSONObject != null && str != null && !str.equals("") && (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) != null && jSONArrayOptJSONArray.length() > 0) {
            arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i4);
                if (jSONObject2 != null) {
                    CityInfo cityInfo = new CityInfo();
                    cityInfo.num = jSONObject2.optInt("number");
                    cityInfo.city = jSONObject2.optString("name");
                    arrayList.add(cityInfo);
                }
            }
            arrayList.trimToSize();
        }
        return arrayList;
    }

    private List<PoiInfo> a(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && str != null && !"".equals(str) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i4);
                if (jSONObject2 != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    if (jSONObject2.has("address")) {
                        poiInfo.address = jSONObject2.optString("address");
                    }
                    poiInfo.uid = jSONObject2.optString("uid");
                    poiInfo.name = jSONObject2.optString("name");
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(MapController.LOCATION_LAYER_TAG);
                    if (jSONObjectOptJSONObject != null) {
                        poiInfo.location = new LatLng(jSONObjectOptJSONObject.optDouble("lat"), jSONObjectOptJSONObject.optDouble("lng"));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            poiInfo.location = CoordTrans.baiduToGcj(poiInfo.location);
                        }
                    }
                    poiInfo.city = str2;
                    arrayList.add(poiInfo);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetBikingRouteResult((BikingRouteResult) searchResult);
    }
}
