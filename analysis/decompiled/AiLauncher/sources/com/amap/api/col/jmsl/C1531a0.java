package com.amap.api.col.jmsl;

import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.poisearch.SubPoiItemV2;
import com.amap.api.services.poisearch.TopListItem;
import com.amap.api.services.poisearch.VisualPoiItem;
import com.amap.api.services.poisearch.VisualSearchResult;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1531a0 {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f16512a = {Const.STR_CITY_CODE_BJ, Const.STR_CITY_CODE_SH, Const.STR_CITY_CODE_TJ, Const.STR_CITY_CODE_CQ, "1852", "1853"};

    public static void A(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Crossroad crossroad = new Crossroad();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                crossroad.setId(D(jSONObjectOptJSONObject, "id"));
                crossroad.setDirection(D(jSONObjectOptJSONObject, "direction"));
                crossroad.setDistance(W(D(jSONObjectOptJSONObject, "distance")));
                crossroad.setCenterPoint(n(jSONObjectOptJSONObject, "location"));
                crossroad.setFirstRoadId(D(jSONObjectOptJSONObject, "first_id"));
                crossroad.setFirstRoadName(D(jSONObjectOptJSONObject, "first_name"));
                crossroad.setSecondRoadId(D(jSONObjectOptJSONObject, "second_id"));
                crossroad.setSecondRoadName(D(jSONObjectOptJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static LatLonPoint B(String str) throws NumberFormatException {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] strArrSplit = str.split(",| ");
        if (strArrSplit.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
    }

    public static PoiItem C(JSONObject jSONObject) throws JSONException {
        String strD;
        String strD2;
        int iY;
        String strD3;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String str;
        String str2;
        String str3;
        String str4 = "id";
        String str5 = "location";
        String str6 = "name";
        PoiItem poiItem = new PoiItem(D(jSONObject, "id"), n(jSONObject, "location"), D(jSONObject, "name"), D(jSONObject, Const.JSON_KEY_ADDRESS));
        poiItem.setAdCode(D(jSONObject, Const.JSON_KEY_ADCODE));
        poiItem.setProvinceName(D(jSONObject, "pname"));
        poiItem.setCityName(D(jSONObject, "cityname"));
        poiItem.setAdName(D(jSONObject, "adname"));
        poiItem.setCityCode(D(jSONObject, Const.JSON_KEY_CITYCODE));
        poiItem.setProvinceCode(D(jSONObject, "pcode"));
        poiItem.setDirection(D(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String strD4 = D(jSONObject, "distance");
            if (!m(strD4)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(strD4));
                } catch (NumberFormatException e10) {
                    C1631z1.o(e10, "JSONHelper", "parseBasePoi");
                } catch (Exception e11) {
                    C1631z1.o(e11, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(D(jSONObject, "tel"));
        poiItem.setTypeDes(D(jSONObject, "type"));
        poiItem.setEnter(n(jSONObject, "entr_location"));
        poiItem.setExit(n(jSONObject, "exit_location"));
        poiItem.setWebsite(D(jSONObject, "website"));
        poiItem.setPostcode(D(jSONObject, "postcode"));
        String strD5 = D(jSONObject, "business_area");
        if (m(strD5)) {
            strD5 = D(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(strD5);
        poiItem.setEmail(D(jSONObject, "email"));
        String strD6 = D(jSONObject, "indoor_map");
        String strD7 = "";
        if (strD6 == null || strD6.equals("") || strD6.equals("0")) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(D(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
            if (jSONArrayOptJSONArray == null) {
                poiItem.setSubPois(arrayList);
            } else {
                int i10 = 0;
                while (i10 < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject3 == null) {
                        str = str4;
                        str2 = str5;
                        str3 = str6;
                    } else {
                        str = str4;
                        str2 = str5;
                        str3 = str6;
                        SubPoiItem subPoiItem = new SubPoiItem(D(jSONObjectOptJSONObject3, str4), n(jSONObjectOptJSONObject3, str5), D(jSONObjectOptJSONObject3, str6), D(jSONObjectOptJSONObject3, Const.JSON_KEY_ADDRESS));
                        subPoiItem.setSubName(D(jSONObjectOptJSONObject3, "sname"));
                        subPoiItem.setSubTypeDes(D(jSONObjectOptJSONObject3, "subtype"));
                        if (jSONObjectOptJSONObject3.has("distance")) {
                            String strD8 = D(jSONObjectOptJSONObject3, "distance");
                            if (!m(strD8)) {
                                try {
                                    subPoiItem.setDistance((int) Float.parseFloat(strD8));
                                } catch (NumberFormatException e12) {
                                    C1631z1.o(e12, "JSONHelper", "parseSubPoiItem");
                                } catch (Exception e13) {
                                    C1631z1.o(e13, "JSONHelper", "parseSubPoiItem");
                                }
                            }
                        }
                        arrayList.add(subPoiItem);
                    }
                    i10++;
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                }
                poiItem.setSubPois(arrayList);
            }
        }
        if (jSONObject.has("indoor_data") && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("indoor_data")) != null && jSONObjectOptJSONObject2.has("cpid") && jSONObjectOptJSONObject2.has(Const.JSON_KEY_FLOOR)) {
            strD2 = D(jSONObjectOptJSONObject2, "cpid");
            iY = Y(D(jSONObjectOptJSONObject2, Const.JSON_KEY_FLOOR));
            strD = D(jSONObjectOptJSONObject2, "truefloor");
        } else {
            strD = "";
            strD2 = strD;
            iY = 0;
        }
        poiItem.setIndoorDate(new IndoorData(strD2, iY, strD));
        if (!jSONObject.has("biz_ext") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("biz_ext")) == null) {
            strD3 = "";
        } else {
            strD7 = D(jSONObjectOptJSONObject, "open_time");
            strD3 = D(jSONObjectOptJSONObject, "rating");
        }
        poiItem.setPoiExtension(new PoiItemExtension(strD7, strD3));
        poiItem.setTypeCode(D(jSONObject, "typecode"));
        poiItem.setShopID(D(jSONObject, "shopid"));
        List<Photo> listD = d(jSONObject.optJSONObject("deep_info"));
        if (((ArrayList) listD).size() == 0) {
            listD = d(jSONObject);
        }
        poiItem.setPhotos(listD);
        return poiItem;
    }

    public static String D(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals("[]")) ? "" : jSONObject.optString(str).trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.amap.api.services.route.BusPathV2> E(org.json.JSONArray r21) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 851
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1531a0.E(org.json.JSONArray):java.util.List");
    }

    public static void F(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static PoiItemV2 G(JSONObject jSONObject) throws JSONException {
        String strD;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String strD2;
        String strD3;
        int iY;
        boolean z10;
        LatLonPoint latLonPointN;
        LatLonPoint latLonPointN2;
        String strD4;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        PoiItemV2 poiItemV2 = new PoiItemV2(D(jSONObject, "id"), n(jSONObject, "location"), D(jSONObject, "name"), D(jSONObject, Const.JSON_KEY_ADDRESS));
        poiItemV2.setTypeDes(D(jSONObject, "type"));
        poiItemV2.setTypeCode(D(jSONObject, "typecode"));
        poiItemV2.setProvinceName(D(jSONObject, "pname"));
        poiItemV2.setCityName(D(jSONObject, "cityname"));
        poiItemV2.setAdName(D(jSONObject, "adname"));
        poiItemV2.setProvinceCode(D(jSONObject, "pcode"));
        poiItemV2.setAdCode(D(jSONObject, Const.JSON_KEY_ADCODE));
        poiItemV2.setCityCode(D(jSONObject, Const.JSON_KEY_CITYCODE));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
            if (jSONArrayOptJSONArray == null) {
                poiItemV2.setSubPois(arrayList);
            } else {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject4 != null) {
                        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(D(jSONObjectOptJSONObject4, "id"), n(jSONObjectOptJSONObject4, "location"), D(jSONObjectOptJSONObject4, "name"), D(jSONObjectOptJSONObject4, Const.JSON_KEY_ADDRESS));
                        subPoiItemV2.setSubTypeDes(D(jSONObjectOptJSONObject4, "subtype"));
                        subPoiItemV2.setTypeCode(D(jSONObjectOptJSONObject4, "typecode"));
                        arrayList.add(subPoiItemV2);
                    }
                }
                poiItemV2.setSubPois(arrayList);
            }
        }
        String strD5 = "";
        if (!jSONObject.has("business") || (jSONObjectOptJSONObject3 = jSONObject.optJSONObject("business")) == null) {
            strD = "";
            str = strD;
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
        } else {
            String strD6 = D(jSONObjectOptJSONObject3, "business_area");
            String strD7 = D(jSONObjectOptJSONObject3, "opentime_today");
            String strD8 = D(jSONObjectOptJSONObject3, "opentime_week");
            String strD9 = D(jSONObjectOptJSONObject3, "tel");
            String strD10 = D(jSONObjectOptJSONObject3, "tag");
            String strD11 = D(jSONObjectOptJSONObject3, "rating");
            String strD12 = D(jSONObjectOptJSONObject3, "cost");
            String strD13 = D(jSONObjectOptJSONObject3, "parking_type");
            String strD14 = D(jSONObjectOptJSONObject3, "alias");
            strD = D(jSONObjectOptJSONObject3, "cpid");
            str = strD6;
            str2 = strD7;
            str3 = strD8;
            str4 = strD9;
            str5 = strD10;
            str6 = strD11;
            str7 = strD12;
            str8 = strD13;
            str9 = strD14;
        }
        Business business = new Business(str, str2, str3, str4, str5, str6, str7, str8, str9);
        business.setCPID(strD);
        poiItemV2.setBusiness(business);
        if (!jSONObject.has(Const.PROVIDER_INDOOR) || (jSONObjectOptJSONObject2 = jSONObject.optJSONObject(Const.PROVIDER_INDOOR)) == null) {
            strD2 = "";
            strD3 = strD2;
            iY = 0;
            z10 = false;
        } else {
            z10 = Y(D(jSONObjectOptJSONObject2, "indoor_map")) == 1;
            strD3 = D(jSONObjectOptJSONObject2, "cpid");
            iY = Y(D(jSONObjectOptJSONObject2, Const.JSON_KEY_FLOOR));
            strD2 = D(jSONObjectOptJSONObject2, "truefloor");
        }
        poiItemV2.setIndoorData(new IndoorDataV2(z10, strD3, iY, strD2));
        if (!jSONObject.has("navi") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("navi")) == null) {
            latLonPointN = null;
            latLonPointN2 = null;
            strD4 = "";
        } else {
            strD5 = D(jSONObjectOptJSONObject, "navi_poiid");
            latLonPointN = n(jSONObjectOptJSONObject, "entr_location");
            latLonPointN2 = n(jSONObjectOptJSONObject, "exit_location");
            strD4 = D(jSONObjectOptJSONObject, "gridcode");
        }
        poiItemV2.setPoiNavi(new PoiNavi(strD5, latLonPointN, latLonPointN2, strD4));
        poiItemV2.setPhotos(d(jSONObject));
        return poiItemV2;
    }

    public static Doorway H(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return M(jSONObjectOptJSONObject);
    }

    public static RideRouteResult I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(n(jSONObjectOptJSONObject, "origin"));
            rideRouteResult.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object objOpt = jSONObjectOptJSONObject.opt("paths");
            if (objOpt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (objOpt instanceof JSONArray) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    RidePath ridePathC0 = c0(jSONArrayOptJSONArray.optJSONObject(i10));
                    if (ridePathC0 != null) {
                        arrayList.add(ridePathC0);
                    }
                }
            } else if (objOpt instanceof JSONObject) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("paths");
                if (!jSONObjectOptJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath ridePathC02 = c0(jSONObjectOptJSONObject2.optJSONObject("path"));
                if (ridePathC02 != null) {
                    arrayList.add(ridePathC02);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static List<TMC> J(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                TMC tmc = new TMC();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    tmc.setDistance(Y(D(jSONObjectOptJSONObject, "tmc_distance")));
                    tmc.setStatus(D(jSONObjectOptJSONObject, "tmc_status"));
                    tmc.setPolyline(x(jSONObjectOptJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e10) {
                C1631z1.o(e10, "JSONHelper", "parseTMCsV5");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    public static BusStationItem K(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(D(jSONObject, "name"));
        busStationItem.setBusStationId(D(jSONObject, "id"));
        busStationItem.setLatLonPoint(n(jSONObject, "location"));
        busStationItem.setEntrance(H(jSONObject, "entrance"));
        busStationItem.setExit(H(jSONObject, "exit"));
        return busStationItem;
    }

    public static RideRouteResultV2 L(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(M5.a.CARD_TYPE_ROUTE)) {
                return null;
            }
            RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            rideRouteResultV2.setStartPos(n(jSONObjectOptJSONObject, "origin"));
            rideRouteResultV2.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object objOpt = jSONObjectOptJSONObject.opt("paths");
            if (objOpt == null) {
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            if (objOpt instanceof JSONArray) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    RidePath ridePathD0 = d0(jSONArrayOptJSONArray.optJSONObject(i10));
                    if (ridePathD0 != null) {
                        arrayList.add(ridePathD0);
                    }
                }
            }
            rideRouteResultV2.setPaths(arrayList);
            return rideRouteResultV2;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseRideRouteV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static Doorway M(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(D(jSONObject, "name"));
        doorway.setLatLonPoint(n(jSONObject, "location"));
        return doorway;
    }

    public static TruckRouteRestult N(String str) throws JSONException, AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data").optJSONObject(M5.a.CARD_TYPE_ROUTE);
            truckRouteRestult.setStartPos(n(jSONObjectOptJSONObject, "origin"));
            truckRouteRestult.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
            if (jSONObjectOptJSONObject.has("paths") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) != null) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    TruckPath truckPath = new TruckPath();
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i10);
                    truckPath.setDistance(W(D(jSONObject2, "distance")));
                    truckPath.setDuration(a0(D(jSONObject2, "duration")));
                    truckPath.setStrategy(D(jSONObject2, "strategy"));
                    truckPath.setTolls(W(D(jSONObject2, "tolls")));
                    truckPath.setTollDistance(W(D(jSONObject2, "toll_distance")));
                    truckPath.setTotalTrafficlights(Y(D(jSONObject2, "traffic_lights")));
                    truckPath.setRestriction(Y(D(jSONObject2, "restriction")));
                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("steps");
                    if (jSONArrayOptJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                            TruckStep truckStep = new TruckStep();
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                            if (jSONObjectOptJSONObject2 != null) {
                                truckStep.setInstruction(D(jSONObjectOptJSONObject2, M5.c.REEDIT_INSTRUCTION));
                                truckStep.setOrientation(D(jSONObjectOptJSONObject2, "orientation"));
                                truckStep.setRoad(D(jSONObjectOptJSONObject2, Const.JSON_KEY_ROAD));
                                truckStep.setDistance(W(D(jSONObjectOptJSONObject2, "distance")));
                                truckStep.setTolls(W(D(jSONObjectOptJSONObject2, "tolls")));
                                truckStep.setTollDistance(W(D(jSONObjectOptJSONObject2, "toll_distance")));
                                truckStep.setTollRoad(D(jSONObjectOptJSONObject2, "toll_road"));
                                truckStep.setDuration(W(D(jSONObjectOptJSONObject2, "duration")));
                                truckStep.setPolyline(x(jSONObjectOptJSONObject2, "polyline"));
                                truckStep.setAction(D(jSONObjectOptJSONObject2, "action"));
                                truckStep.setAssistantAction(D(jSONObjectOptJSONObject2, "assistant_action"));
                                i(truckStep, jSONObjectOptJSONObject2);
                                t(truckStep, jSONObjectOptJSONObject2);
                                arrayList2.add(truckStep);
                            }
                        }
                        truckPath.setSteps(arrayList2);
                        arrayList.add(truckPath);
                    }
                }
                truckRouteRestult.setPaths(arrayList);
                return truckRouteRestult;
            }
            return truckRouteRestult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ElecConsumeInfo O(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(n(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(a(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(a(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("left_energy");
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i10)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static WalkRouteResult P(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(M5.a.CARD_TYPE_ROUTE)) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            walkRouteResult.setStartPos(n(jSONObjectOptJSONObject, "origin"));
            walkRouteResult.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
            if (!jSONObjectOptJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                WalkPath walkPath = new WalkPath();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject2 != null) {
                    walkPath.setDistance(W(D(jSONObjectOptJSONObject2, "distance")));
                    walkPath.setDuration(a0(D(jSONObjectOptJSONObject2, "duration")));
                    if (jSONObjectOptJSONObject2.has("steps")) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i11);
                                if (jSONObjectOptJSONObject3 != null) {
                                    walkStep.setInstruction(D(jSONObjectOptJSONObject3, M5.c.REEDIT_INSTRUCTION));
                                    walkStep.setOrientation(D(jSONObjectOptJSONObject3, "orientation"));
                                    walkStep.setRoad(D(jSONObjectOptJSONObject3, Const.JSON_KEY_ROAD));
                                    walkStep.setDistance(W(D(jSONObjectOptJSONObject3, "distance")));
                                    walkStep.setDuration(W(D(jSONObjectOptJSONObject3, "duration")));
                                    walkStep.setPolyline(x(jSONObjectOptJSONObject3, "polyline"));
                                    walkStep.setAction(D(jSONObjectOptJSONObject3, "action"));
                                    walkStep.setAssistantAction(D(jSONObjectOptJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            F(walkPath, arrayList2);
                            arrayList.add(walkPath);
                        }
                    } else {
                        arrayList.add(walkPath);
                    }
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static WalkRouteResultV2 Q(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(M5.a.CARD_TYPE_ROUTE)) {
                return null;
            }
            WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            walkRouteResultV2.setStartPos(n(jSONObjectOptJSONObject, "origin"));
            walkRouteResultV2.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
            if (!jSONObjectOptJSONObject.has("paths")) {
                return walkRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray == null) {
                walkRouteResultV2.setPaths(arrayList);
                return walkRouteResultV2;
            }
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                WalkPath walkPath = new WalkPath();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject2 != null) {
                    walkPath.setDistance(W(D(jSONObjectOptJSONObject2, "distance")));
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("cost");
                    if (jSONObjectOptJSONObject3 != null) {
                        walkPath.setDuration(a0(D(jSONObjectOptJSONObject3, "duration")));
                    }
                    if (jSONObjectOptJSONObject2.has("steps")) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i11);
                                if (jSONObjectOptJSONObject4 != null) {
                                    walkStep.setInstruction(D(jSONObjectOptJSONObject4, M5.c.REEDIT_INSTRUCTION));
                                    walkStep.setOrientation(D(jSONObjectOptJSONObject4, "orientation"));
                                    walkStep.setRoad(D(jSONObjectOptJSONObject4, "road_name"));
                                    walkStep.setDistance(W(D(jSONObjectOptJSONObject4, "step_distance")));
                                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("cost");
                                    if (jSONObjectOptJSONObject5 != null) {
                                        walkStep.setDuration(W(D(jSONObjectOptJSONObject5, "duration")));
                                    }
                                    JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("navi");
                                    if (jSONObjectOptJSONObject6 != null) {
                                        walkStep.setAction(D(jSONObjectOptJSONObject6, "action"));
                                        walkStep.setAssistantAction(D(jSONObjectOptJSONObject6, "assistant_action"));
                                        walkStep.setRoadType(Y(D(jSONObjectOptJSONObject6, "work_type")));
                                    }
                                    walkStep.setPolyline(x(jSONObjectOptJSONObject4, "polyline"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            F(walkPath, arrayList2);
                            arrayList.add(walkPath);
                        }
                    } else {
                        arrayList.add(walkPath);
                    }
                }
            }
            walkRouteResultV2.setPaths(arrayList);
            return walkRouteResultV2;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<GeocodeAddress> R(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("geocodes");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(D(jSONObjectOptJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(D(jSONObjectOptJSONObject, "province"));
                    geocodeAddress.setCity(D(jSONObjectOptJSONObject, "city"));
                    geocodeAddress.setDistrict(D(jSONObjectOptJSONObject, "district"));
                    geocodeAddress.setTownship(D(jSONObjectOptJSONObject, "township"));
                    geocodeAddress.setNeighborhood(D(jSONObjectOptJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(D(jSONObjectOptJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    geocodeAddress.setLatLonPoint(n(jSONObjectOptJSONObject, "location"));
                    geocodeAddress.setLevel(D(jSONObjectOptJSONObject, "level"));
                    geocodeAddress.setCountry(D(jSONObjectOptJSONObject, "country"));
                    geocodeAddress.setPostcode(D(jSONObjectOptJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    public static Navi S(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(D(jSONObject, "action"));
            navi.setAssistantAction(D(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseNavi");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static boolean T(String str) {
        return (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) ? false : true;
    }

    public static double U(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e10) {
                C1631z1.o(e10, "JSONHelper", "str2float");
            }
        }
        return 0.0d;
    }

    public static ArrayList<PoiItem> V(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(C(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static float W(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e10) {
                C1631z1.o(e10, "JSONHelper", "str2float");
            }
        }
        return 0.0f;
    }

    public static ArrayList<PoiItemV2> X(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(G(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static int Y(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e10) {
                C1631z1.o(e10, "JSONHelper", "str2int");
            }
        }
        return 0;
    }

    public static RouteRailwayItem Z(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(D(jSONObject, "id"));
        routeRailwayItem.setName(D(jSONObject, "name"));
        routeRailwayItem.setTime(D(jSONObject, "time"));
        routeRailwayItem.setTrip(D(jSONObject, "trip"));
        routeRailwayItem.setDistance(W(D(jSONObject, "distance")));
        routeRailwayItem.setType(D(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(b0(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(b0(jSONObject.optJSONObject("arrival_stop")));
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("via_stops");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(b0(jSONObjectOptJSONObject));
                }
            }
        }
        routeRailwayItem.setViastops(arrayList);
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("alters");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                if (jSONObjectOptJSONObject2 != null) {
                    Railway railway = new Railway();
                    railway.setID(D(jSONObjectOptJSONObject2, "id"));
                    railway.setName(D(jSONObjectOptJSONObject2, "name"));
                    arrayList2.add(railway);
                }
            }
        }
        routeRailwayItem.setAlters(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("spaces");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i12 = 0; i12 < jSONArrayOptJSONArray3.length(); i12++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i12);
                if (jSONObjectOptJSONObject3 != null) {
                    arrayList3.add(new RailwaySpace(D(jSONObjectOptJSONObject3, "code"), W(D(jSONObjectOptJSONObject3, "cost"))));
                }
            }
        }
        routeRailwayItem.setSpaces(arrayList3);
        return routeRailwayItem;
    }

    public static int a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    public static long a0(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e10) {
                C1631z1.o(e10, "JSONHelper", "str2long");
            }
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> b(org.json.JSONObject r13, boolean r14) throws org.json.JSONException {
        /*
            java.lang.String r0 = "datas"
            org.json.JSONArray r13 = r13.optJSONArray(r0)
            if (r13 == 0) goto L81
            int r0 = r13.length()
            if (r0 != 0) goto L10
            goto L81
        L10:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r13.length()
            r2 = 0
            r3 = r2
        L1b:
            if (r3 >= r1) goto L80
            org.json.JSONObject r4 = r13.optJSONObject(r3)
            java.lang.String r5 = "userid"
            java.lang.String r5 = D(r4, r5)
            java.lang.String r6 = "location"
            java.lang.String r6 = D(r4, r6)
            if (r6 == 0) goto L47
            java.lang.String r7 = ","
            java.lang.String[] r6 = r6.split(r7)
            int r7 = r6.length
            r8 = 2
            if (r7 != r8) goto L47
            r7 = r6[r2]
            double r7 = U(r7)
            r9 = 1
            r6 = r6[r9]
            double r9 = U(r6)
            goto L4a
        L47:
            r7 = 0
            r9 = r7
        L4a:
            java.lang.String r6 = "distance"
            java.lang.String r6 = D(r4, r6)
            java.lang.String r11 = "updatetime"
            java.lang.String r4 = D(r4, r11)
            long r11 = a0(r4)
            int r4 = Y(r6)
            com.amap.api.services.core.LatLonPoint r6 = new com.amap.api.services.core.LatLonPoint
            r6.<init>(r9, r7)
            com.amap.api.services.nearby.NearbyInfo r7 = new com.amap.api.services.nearby.NearbyInfo
            r7.<init>()
            r7.setUserID(r5)
            r7.setTimeStamp(r11)
            r7.setPoint(r6)
            if (r14 == 0) goto L77
            r7.setDrivingDistance(r4)
            goto L7a
        L77:
            r7.setDistance(r4)
        L7a:
            r0.add(r7)
            int r3 = r3 + 1
            goto L1b
        L80:
            return r0
        L81:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1531a0.b(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    public static RailwayStationItem b0(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(D(jSONObject, "id"));
        railwayStationItem.setName(D(jSONObject, "name"));
        railwayStationItem.setLocation(n(jSONObject, "location"));
        railwayStationItem.setAdcode(D(jSONObject, Const.JSON_KEY_ADCODE));
        railwayStationItem.setTime(D(jSONObject, "time"));
        railwayStationItem.setisStart(T(D(jSONObject, "start")));
        railwayStationItem.setisEnd(T(D(jSONObject, com.stepos.ailauncher.container.wallpaper.a.PHASE_END)));
        railwayStationItem.setWait(W(D(jSONObject, "wait")));
        return railwayStationItem;
    }

    public static List<ChargeStationInfo> c(JSONArray jSONArray) throws JSONException, AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(D(jSONObject, "name"));
                chargeStationInfo.setPoiId(D(jSONObject, Const.JSON_KEY_POIID));
                chargeStationInfo.setBrandName(D(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(n(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(n(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(a(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(a(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(a(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(a(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(a(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(a(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(a(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static RidePath c0(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(W(D(jSONObject, "distance")));
            ridePath.setDuration(a0(D(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray == null) {
                    return null;
                }
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    RideStep rideStep = new RideStep();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        rideStep.setInstruction(D(jSONObjectOptJSONObject, M5.c.REEDIT_INSTRUCTION));
                        rideStep.setOrientation(D(jSONObjectOptJSONObject, "orientation"));
                        rideStep.setRoad(D(jSONObjectOptJSONObject, Const.JSON_KEY_ROAD));
                        rideStep.setDistance(W(D(jSONObjectOptJSONObject, "distance")));
                        rideStep.setDuration(W(D(jSONObjectOptJSONObject, "duration")));
                        rideStep.setPolyline(x(jSONObjectOptJSONObject, "polyline"));
                        rideStep.setAction(D(jSONObjectOptJSONObject, "action"));
                        rideStep.setAssistantAction(D(jSONObjectOptJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                z(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static List<Photo> d(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("photos");
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                Photo photo = new Photo();
                photo.setTitle(D(jSONObjectOptJSONObject, "title"));
                photo.setUrl(D(jSONObjectOptJSONObject, "url"));
                arrayList.add(photo);
            }
        }
        return arrayList;
    }

    public static RidePath d0(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(W(D(jSONObject, "distance")));
            ridePath.setDuration(a0(D(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray == null) {
                    return null;
                }
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    RideStep rideStep = new RideStep();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        rideStep.setInstruction(D(jSONObjectOptJSONObject, M5.c.REEDIT_INSTRUCTION));
                        rideStep.setOrientation(D(jSONObjectOptJSONObject, "orientation"));
                        rideStep.setRoad(D(jSONObjectOptJSONObject, "road_name"));
                        rideStep.setDistance(W(D(jSONObjectOptJSONObject, "step_distance")));
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cost");
                        if (jSONObjectOptJSONObject2 != null) {
                            rideStep.setDuration(W(D(jSONObjectOptJSONObject2, "duration")));
                        }
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("navi");
                        if (jSONObjectOptJSONObject3 != null) {
                            rideStep.setAction(D(jSONObjectOptJSONObject3, "action"));
                            rideStep.setAssistantAction(D(jSONObjectOptJSONObject3, "assistant_action"));
                            rideStep.setRoadType(Y(D(jSONObjectOptJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(x(jSONObjectOptJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                z(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseRidePathV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void e(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(W(D(jSONObject, "tolls")));
            cost.setTollDistance(W(D(jSONObject, "toll_distance")));
            cost.setTollRoad(D(jSONObject, "toll_road"));
            cost.setDuration(W(D(jSONObject, "duration")));
            cost.setTrafficLights(Y(D(jSONObject, "traffic_lights")));
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseCostDetail");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static RoutePOIItem e0(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(D(jSONObject, "id"));
        routePOIItem.setTitle(D(jSONObject, "name"));
        routePOIItem.setPoint(n(jSONObject, "location"));
        routePOIItem.setDistance(W(D(jSONObject, "distance")));
        routePOIItem.setDuration(W(D(jSONObject, "duration")));
        routePOIItem.setCPID(D(jSONObject, "cpid"));
        return routePOIItem;
    }

    public static void f(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cities");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    routeSearchCity.setSearchCityName(D(jSONObjectOptJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE));
                    routeSearchCity.setSearchCityhAdCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    h(routeSearchCity, jSONObjectOptJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<RoutePOIItem> f0(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object objOpt = jSONObject.opt("pois");
        if (objOpt instanceof JSONArray) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(e0(jSONObjectOptJSONObject));
                    }
                }
            }
        } else if (objOpt instanceof JSONObject) {
            arrayList.add(e0(((JSONObject) objOpt).optJSONObject("poi")));
        }
        return arrayList;
    }

    public static void g(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static ArrayList<Tip> g0(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tips");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                Tip tip = new Tip();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    tip.setName(D(jSONObjectOptJSONObject, "name"));
                    tip.setDistrict(D(jSONObjectOptJSONObject, "district"));
                    tip.setAdcode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    tip.setID(D(jSONObjectOptJSONObject, "id"));
                    tip.setAddress(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADDRESS));
                    tip.setTypeCode(D(jSONObjectOptJSONObject, "typecode"));
                    String strD = D(jSONObjectOptJSONObject, "location");
                    if (!TextUtils.isEmpty(strD)) {
                        String[] strArrSplit = strD.split(Const.STR_MART_COMMA);
                        if (strArrSplit.length == 2) {
                            tip.setPostion(new LatLonPoint(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0])));
                        }
                    }
                    arrayList.add(tip);
                }
            }
        }
        return arrayList;
    }

    public static void h(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("districts");
                if (jSONArrayOptJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    District district = new District();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        district.setDistrictName(D(jSONObjectOptJSONObject, "name"));
                        district.setDistrictAdcode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e10) {
                C1631z1.o(e10, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static BusLineItem h0(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(D(jSONObject, "id"));
        busLineItem.setBusLineType(D(jSONObject, "type"));
        busLineItem.setBusLineName(D(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(x(jSONObject, "polyline"));
        busLineItem.setCityCode(D(jSONObject, Const.JSON_KEY_CITYCODE));
        busLineItem.setOriginatingStation(D(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(D(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static void i(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cities");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    routeSearchCity.setSearchCityName(D(jSONObjectOptJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE));
                    routeSearchCity.setSearchCityhAdCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    h(routeSearchCity, jSONObjectOptJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<BusLineItem> i0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buslines");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    BusLineItem busLineItemH0 = h0(jSONObjectOptJSONObject);
                    busLineItemH0.setFirstBusTime(C1631z1.r(D(jSONObjectOptJSONObject, "start_time")));
                    busLineItemH0.setLastBusTime(C1631z1.r(D(jSONObjectOptJSONObject, "end_time")));
                    busLineItemH0.setBusCompany(D(jSONObjectOptJSONObject, "company"));
                    busLineItemH0.setDistance(W(D(jSONObjectOptJSONObject, "distance")));
                    busLineItemH0.setBasicPrice(W(D(jSONObjectOptJSONObject, "basic_price")));
                    busLineItemH0.setTotalPrice(W(D(jSONObjectOptJSONObject, "total_price")));
                    busLineItemH0.setBounds(x(jSONObjectOptJSONObject, "bounds"));
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("busstops");
                    if (jSONArrayOptJSONArray2 == null) {
                        busLineItemH0.setBusStations(arrayList2);
                    } else {
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                            if (jSONObjectOptJSONObject2 != null) {
                                arrayList2.add(j0(jSONObjectOptJSONObject2));
                            }
                        }
                        busLineItemH0.setBusStations(arrayList2);
                    }
                    arrayList.add(busLineItemH0);
                }
            }
        }
        return arrayList;
    }

    public static void j(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                regeocodeRoad.setId(D(jSONObjectOptJSONObject, "id"));
                regeocodeRoad.setName(D(jSONObjectOptJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(n(jSONObjectOptJSONObject, "location"));
                regeocodeRoad.setDirection(D(jSONObjectOptJSONObject, "direction"));
                regeocodeRoad.setDistance(W(D(jSONObjectOptJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static BusStationItem j0(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(D(jSONObject, "id"));
        busStationItem.setLatLonPoint(n(jSONObject, "location"));
        busStationItem.setBusStationName(D(jSONObject, "name"));
        busStationItem.setEntrance(H(jSONObject, "entrance"));
        busStationItem.setExit(H(jSONObject, "exit"));
        return busStationItem;
    }

    public static void k(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        String strOptString;
        if (jSONArray == null) {
            return;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                DistrictItem districtItem2 = new DistrictItem();
                districtItem2.setCitycode(D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE));
                districtItem2.setAdcode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                districtItem2.setName(D(jSONObjectOptJSONObject, "name"));
                districtItem2.setLevel(D(jSONObjectOptJSONObject, "level"));
                districtItem2.setCenter(n(jSONObjectOptJSONObject, "center"));
                if (jSONObjectOptJSONObject.has("polyline") && (strOptString = jSONObjectOptJSONObject.optString("polyline")) != null && strOptString.length() > 0) {
                    districtItem2.setDistrictBoundary(strOptString.split("\\|"));
                }
                k(jSONObjectOptJSONObject.optJSONArray("districts"), new ArrayList(), districtItem2);
                arrayList.add(districtItem2);
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    public static ArrayList<BusStationItem> k0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("busstops");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    BusStationItem busStationItemJ0 = j0(jSONObjectOptJSONObject);
                    busStationItemJ0.setAdCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    busStationItemJ0.setCityCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("buslines");
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 == null) {
                        busStationItemJ0.setBusLineItems(arrayList2);
                    } else {
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                            if (jSONObjectOptJSONObject2 != null) {
                                arrayList2.add(h0(jSONObjectOptJSONObject2));
                            }
                        }
                        busStationItemJ0.setBusLineItems(arrayList2);
                    }
                    arrayList.add(busStationItemJ0);
                }
            }
        }
        return arrayList;
    }

    public static void l(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        String cityCode;
        regeocodeAddress.setCountry(D(jSONObject, "country"));
        regeocodeAddress.setCountryCode(D(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(D(jSONObject, "province"));
        regeocodeAddress.setCity(D(jSONObject, "city"));
        regeocodeAddress.setCityCode(D(jSONObject, Const.JSON_KEY_CITYCODE));
        regeocodeAddress.setAdCode(D(jSONObject, Const.JSON_KEY_ADCODE));
        regeocodeAddress.setDistrict(D(jSONObject, "district"));
        regeocodeAddress.setTownship(D(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(D(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(D(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(D(jSONObjectOptJSONObject, Const.JSON_KEY_STREET));
        streetNumber.setNumber(D(jSONObjectOptJSONObject, Const.JSON_KEY_NUMBER));
        streetNumber.setLatLonPoint(n(jSONObjectOptJSONObject, "location"));
        streetNumber.setDirection(D(jSONObjectOptJSONObject, "direction"));
        streetNumber.setDistance(W(D(jSONObjectOptJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("businessAreas");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject2 != null) {
                    businessArea.setCenterPoint(n(jSONObjectOptJSONObject2, "location"));
                    businessArea.setName(D(jSONObjectOptJSONObject2, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        regeocodeAddress.setBusinessAreas(arrayList);
        regeocodeAddress.setTowncode(D(jSONObject, "towncode"));
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() < 1) && (cityCode = regeocodeAddress.getCityCode()) != null && cityCode.length() >= 1) {
            for (String str : f16512a) {
                if (cityCode.trim().equals(str.trim())) {
                    regeocodeAddress.setCity(regeocodeAddress.getProvince());
                    return;
                }
            }
        }
    }

    public static List<BusStationItem> l0(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("via_stops");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(K(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static boolean m(String str) {
        return str == null || str.equals("");
    }

    public static VisualSearchResult m0(JSONObject jSONObject) throws JSONException {
        VisualSearchResult visualSearchResult = new VisualSearchResult();
        visualSearchResult.setCategory(D(jSONObject, QueryAlgorithmBundle.KEY_CATEGORY));
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            visualSearchResult.setPois(arrayList);
            return visualSearchResult;
        }
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                VisualPoiItem visualPoiItem = new VisualPoiItem(D(jSONObjectOptJSONObject, "id"), n(jSONObjectOptJSONObject, "location"), D(jSONObjectOptJSONObject, "name"), D(jSONObjectOptJSONObject, Const.JSON_KEY_ADDRESS));
                visualPoiItem.setTypeDes(D(jSONObjectOptJSONObject, "type"));
                visualPoiItem.setTypeCode(D(jSONObjectOptJSONObject, "typecode"));
                visualPoiItem.setProvinceName(D(jSONObjectOptJSONObject, "pname"));
                visualPoiItem.setCityName(D(jSONObjectOptJSONObject, "cityname"));
                visualPoiItem.setAdName(D(jSONObjectOptJSONObject, "adname"));
                visualPoiItem.setProvinceCode(D(jSONObjectOptJSONObject, "pcode"));
                visualPoiItem.setAdCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                visualPoiItem.setCityCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE));
                visualPoiItem.setBizType(D(jSONObjectOptJSONObject, "biz_type"));
                visualPoiItem.setPostcode(D(jSONObjectOptJSONObject, "postcode"));
                visualPoiItem.setWebsite(D(jSONObjectOptJSONObject, "website"));
                visualPoiItem.setEmail(D(jSONObjectOptJSONObject, "email"));
                visualPoiItem.setDistance(D(jSONObjectOptJSONObject, "distance"));
                visualPoiItem.setFeaturedReviews(D(jSONObjectOptJSONObject, "featured_reviews"));
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("top_list");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                        if (jSONObjectOptJSONObject2 != null) {
                            TopListItem topListItem = new TopListItem();
                            topListItem.setType(D(jSONObjectOptJSONObject2, "type"));
                            topListItem.setName(D(jSONObjectOptJSONObject2, "name"));
                            arrayList2.add(topListItem);
                        }
                    }
                    visualPoiItem.setTopList(arrayList2);
                }
                arrayList.add(visualPoiItem);
            }
        }
        visualSearchResult.setPois(arrayList);
        return visualSearchResult;
    }

    public static LatLonPoint n(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return B(jSONObject.optString(str));
        }
        return null;
    }

    public static DriveRouteResult o(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(M5.a.CARD_TYPE_ROUTE)) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            if (jSONObjectOptJSONObject != null) {
                driveRouteResult.setStartPos(n(jSONObjectOptJSONObject, "origin"));
                driveRouteResult.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
                driveRouteResult.setTaxiCost(W(D(jSONObjectOptJSONObject, "taxi_cost")));
                if (jSONObjectOptJSONObject.has("paths") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    while (i10 < jSONArrayOptJSONArray.length()) {
                        DrivePath drivePath = new DrivePath();
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                        if (jSONObjectOptJSONObject2 == null) {
                            jSONArray = jSONArrayOptJSONArray;
                        } else {
                            drivePath.setDistance(W(D(jSONObjectOptJSONObject2, "distance")));
                            drivePath.setDuration(a0(D(jSONObjectOptJSONObject2, "duration")));
                            drivePath.setStrategy(D(jSONObjectOptJSONObject2, "strategy"));
                            drivePath.setTolls(W(D(jSONObjectOptJSONObject2, "tolls")));
                            drivePath.setTollDistance(W(D(jSONObjectOptJSONObject2, "toll_distance")));
                            drivePath.setTotalTrafficlights(Y(D(jSONObjectOptJSONObject2, "traffic_lights")));
                            drivePath.setRestriction(Y(D(jSONObjectOptJSONObject2, "restriction")));
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                            if (jSONArrayOptJSONArray2 == null) {
                                jSONArray = jSONArrayOptJSONArray;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                int i11 = 0;
                                while (i11 < jSONArrayOptJSONArray2.length()) {
                                    DriveStep driveStep = new DriveStep();
                                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i11);
                                    if (jSONObjectOptJSONObject3 == null) {
                                        jSONArray2 = jSONArrayOptJSONArray;
                                    } else {
                                        jSONArray2 = jSONArrayOptJSONArray;
                                        driveStep.setInstruction(D(jSONObjectOptJSONObject3, M5.c.REEDIT_INSTRUCTION));
                                        driveStep.setOrientation(D(jSONObjectOptJSONObject3, "orientation"));
                                        driveStep.setRoad(D(jSONObjectOptJSONObject3, Const.JSON_KEY_ROAD));
                                        driveStep.setDistance(W(D(jSONObjectOptJSONObject3, "distance")));
                                        driveStep.setTolls(W(D(jSONObjectOptJSONObject3, "tolls")));
                                        driveStep.setTollDistance(W(D(jSONObjectOptJSONObject3, "toll_distance")));
                                        driveStep.setTollRoad(D(jSONObjectOptJSONObject3, "toll_road"));
                                        driveStep.setDuration(W(D(jSONObjectOptJSONObject3, "duration")));
                                        driveStep.setPolyline(x(jSONObjectOptJSONObject3, "polyline"));
                                        driveStep.setAction(D(jSONObjectOptJSONObject3, "action"));
                                        driveStep.setAssistantAction(D(jSONObjectOptJSONObject3, "assistant_action"));
                                        f(driveStep, jSONObjectOptJSONObject3);
                                        r(driveStep, jSONObjectOptJSONObject3);
                                        arrayList2.add(driveStep);
                                    }
                                    i11++;
                                    jSONArrayOptJSONArray = jSONArray2;
                                }
                                jSONArray = jSONArrayOptJSONArray;
                                drivePath.setSteps(arrayList2);
                                g(drivePath, arrayList2);
                                arrayList.add(drivePath);
                            }
                        }
                        i10++;
                        jSONArrayOptJSONArray = jSONArray;
                    }
                    driveRouteResult.setPaths(arrayList);
                    return driveRouteResult;
                }
            }
            return driveRouteResult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            C1631z1.o(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<SuggestionCity> p(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("cities")) != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new SuggestionCity(D(jSONObjectOptJSONObject, "name"), D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE), D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE), Y(D(jSONObjectOptJSONObject, "num"))));
                }
            }
        }
        return arrayList;
    }

    public static List<RouteSearchCity> q(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    routeSearchCity.setSearchCityName(D(jSONObjectOptJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(D(jSONObjectOptJSONObject, Const.JSON_KEY_CITYCODE));
                    routeSearchCity.setSearchCityhAdCode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                    h(routeSearchCity, jSONObjectOptJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e10) {
                C1631z1.o(e10, "JSONHelper", "parseCrossCity");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    public static void r(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tmcs");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                TMC tmc = new TMC();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    tmc.setDistance(Y(D(jSONObjectOptJSONObject, "distance")));
                    tmc.setStatus(D(jSONObjectOptJSONObject, "status"));
                    tmc.setPolyline(x(jSONObjectOptJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void s(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                polyline.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static void t(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tmcs");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                TMC tmc = new TMC();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    tmc.setDistance(Y(D(jSONObjectOptJSONObject, "distance")));
                    tmc.setStatus(D(jSONObjectOptJSONObject, "status"));
                    tmc.setPolyline(x(jSONObjectOptJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void u(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                aoiItem.setId(D(jSONObjectOptJSONObject, "id"));
                aoiItem.setName(D(jSONObjectOptJSONObject, "name"));
                aoiItem.setAdcode(D(jSONObjectOptJSONObject, Const.JSON_KEY_ADCODE));
                aoiItem.setLocation(n(jSONObjectOptJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(W(D(jSONObjectOptJSONObject, "area"))));
                aoiItem.setDistance(W(D(jSONObjectOptJSONObject, "distance")));
                aoiItem.setType(D(jSONObjectOptJSONObject, "type"));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    public static DriveRouteResultV2 v(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(M5.a.CARD_TYPE_ROUTE)) {
                return null;
            }
            DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(M5.a.CARD_TYPE_ROUTE);
            if (jSONObjectOptJSONObject != null) {
                driveRouteResultV2.setStartPos(n(jSONObjectOptJSONObject, "origin"));
                driveRouteResultV2.setTargetPos(n(jSONObjectOptJSONObject, "destination"));
                driveRouteResultV2.setTaxiCost(W(D(jSONObjectOptJSONObject, "taxi_cost")));
                if (jSONObjectOptJSONObject.has("paths") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                        DrivePathV2 drivePathV2 = new DrivePathV2();
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                        if (jSONObjectOptJSONObject2 != null) {
                            drivePathV2.setDistance(W(D(jSONObjectOptJSONObject2, "distance")));
                            drivePathV2.setStrategy(D(jSONObjectOptJSONObject2, "strategy"));
                            drivePathV2.setRestriction(Y(D(jSONObjectOptJSONObject2, "restriction")));
                            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("cost");
                            if (jSONObjectOptJSONObject3 != null) {
                                Cost cost = new Cost();
                                e(cost, jSONObjectOptJSONObject3);
                                drivePathV2.setCost(cost);
                            }
                            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("elec_consume_info");
                            if (jSONObjectOptJSONObject4 != null) {
                                drivePathV2.setElecConsumeInfo(O(jSONObjectOptJSONObject4));
                            }
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("charge_station_info");
                            if (jSONArrayOptJSONArray2 != null) {
                                drivePathV2.setChargeStationInfo(c(jSONArrayOptJSONArray2));
                            }
                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("steps");
                            if (jSONArrayOptJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i11 = 0; i11 < jSONArrayOptJSONArray3.length(); i11++) {
                                    DriveStepV2 driveStepV2 = new DriveStepV2();
                                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i11);
                                    if (jSONObjectOptJSONObject5 != null) {
                                        driveStepV2.setInstruction(D(jSONObjectOptJSONObject5, M5.c.REEDIT_INSTRUCTION));
                                        driveStepV2.setOrientation(D(jSONObjectOptJSONObject5, "orientation"));
                                        driveStepV2.setStepDistance(Y(D(jSONObjectOptJSONObject5, "step_distance")));
                                        driveStepV2.setRoad(D(jSONObjectOptJSONObject5, "road_name"));
                                        driveStepV2.setPolyline(x(jSONObjectOptJSONObject5, "polyline"));
                                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("cost");
                                        if (jSONObjectOptJSONObject6 != null) {
                                            Cost cost2 = new Cost();
                                            e(cost2, jSONObjectOptJSONObject6);
                                            driveStepV2.setCostDetail(cost2);
                                        }
                                        JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject("navi");
                                        if (jSONObjectOptJSONObject7 != null) {
                                            driveStepV2.setNavi(S(jSONObjectOptJSONObject7));
                                        }
                                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject5.optJSONArray("cities");
                                        if (jSONArrayOptJSONArray4 != null) {
                                            driveStepV2.setRouteSearchCityList(q(jSONArrayOptJSONArray4));
                                        }
                                        JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray("tmcs");
                                        if (jSONArrayOptJSONArray5 != null) {
                                            driveStepV2.setTMCs(J(jSONArrayOptJSONArray5));
                                        }
                                        arrayList2.add(driveStepV2);
                                    }
                                }
                                drivePathV2.setSteps(arrayList2);
                                s(drivePathV2, arrayList2);
                                arrayList.add(drivePathV2);
                            }
                        }
                    }
                    driveRouteResultV2.setPaths(arrayList);
                    return driveRouteResultV2;
                }
            }
            return driveRouteResultV2;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            C1631z1.o(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<String> w(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keywords");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i10));
            }
        }
        return arrayList;
    }

    public static ArrayList<LatLonPoint> x(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str)) {
            return null;
        }
        String strOptString = jSONObject.optString(str);
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : strOptString.split(Const.STR_MART_SEMICOLON)) {
            arrayList.add(B(str2));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.amap.api.services.route.BusPath> y(org.json.JSONArray r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1531a0.y(org.json.JSONArray):java.util.List");
    }

    public static void z(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }
}
