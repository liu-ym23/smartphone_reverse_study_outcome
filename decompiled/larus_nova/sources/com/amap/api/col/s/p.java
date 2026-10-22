package com.amap.api.col.s;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DrivePlanStep;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TimeInfo;
import com.amap.api.services.route.TimeInfosElement;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f26604a;

    static {
        f26604a = new String[]{"010", "021", "022", "023", "1852", "1853"};
    }

    private static List<BusPath> a(JSONArray r110) throws JSONException {
        JSONArray r100 = r110;
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r110.length()) goto L67;
        BusPath r103 = new BusPath();
        JSONObject r104 = r100.optJSONObject(r102);
        if (r104 == null) goto L66;
        r103.setCost(o(a(r104, ChameleonOpenTracker.ParamKey.COST)));
        r103.setDuration(q(a(r104, "duration")));
        r103.setNightBus(r(a(r104, "nightflag")));
        r103.setWalkDistance(o(a(r104, "walking_distance")));
        r103.setDistance(o(a(r104, "distance")));
        JSONArray r105 = r104.optJSONArray(DBDefinition.SEGMENT_TABLE_NAME);
        if (r105 == null) goto L66;
        ArrayList r106 = new ArrayList();
        float r107 = 0.0f;
        float r111 = 0.0f;
        int r112 = 0;
    L14:
        if (r112 >= r105.length()) goto L64;
        JSONObject r113 = r105.optJSONObject(r112);
        if (r113 == null) goto L63;
        BusStep r114 = new BusStep();
        JSONObject r115 = r113.optJSONObject(AppletNaviType.WALKING);
        if (r115 == null) goto L20;
        r114.setWalk(o(r115));
    L20:
        JSONObject r116 = r113.optJSONObject("bus");
        if (r116 == null) goto L23;
        r114.setBusLines(p(r116));
    L23:
        JSONObject r117 = r113.optJSONObject(SoloKtvContext.SOLO_PAGE_ENTRANCE);
        if (r117 == null) goto L26;
        r114.setEntrance(q(r117));
    L26:
        JSONObject r118 = r113.optJSONObject("exit");
        if (r118 == null) goto L29;
        r114.setExit(q(r118));
    L29:
        JSONObject r119 = r113.optJSONObject("railway");
        if (r119 != null) goto L32;
    L39:
        JSONObject r108 = r113.optJSONObject("taxi");
        if (r108 == null) goto L43;
        TaxiItem r109 = new TaxiItem();
        r109.setOrigin(b(r108, PlayerResolution.SDKKEY.ORIGIN));
        r109.setDestination(b(r108, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));
        r109.setDistance(o(a(r108, "distance")));
        r109.setDuration(o(a(r108, "duration")));
        r109.setSname(a(r108, "sname"));
        r109.setTname(a(r108, "tname"));
        r114.setTaxi(r109);
    L43:
        if (r114.getWalk() == null) goto L47;
        if (r114.getWalk().getSteps().size() == 0) goto L47;
    L53:
        if (r114 == null) goto L63;
        r106.add(r114);
        if (r114.getWalk() == null) goto L58;
        r111 = r111 + r114.getWalk().getDistance();
    L58:
        if (r114.getBusLines() == null) goto L63;
        if (r114.getBusLines().size() <= 0) goto L63;
        r107 = r107 + ((RouteBusLineItem) ListProtector.get(r114.getBusLines(), 0)).getDistance();
    L47:
        if (r114.getBusLines().size() != 0) goto L53;
        if (r114.getRailway() != null) goto L53;
        if (r114.getTaxi() != null) goto L53;
        r114 = null;
        goto L53
    L32:
        if (r119.has("id") == true) goto L34;
    L37:
        RouteRailwayItem r120 = null;
    L38:
        r114.setRailway(r120);
        goto L39
    L34:
        if (r119.has("name") == false) goto L37;
        r120 = new RouteRailwayItem();
        r120.setID(a(r119, "id"));
        r120.setName(a(r119, "name"));
        r120.setTime(a(r119, "time"));
        r120.setTrip(a(r119, "trip"));
        r120.setDistance(o(a(r119, "distance")));
        r120.setType(a(r119, "type"));
        r120.setDeparturestop(t(r119.optJSONObject("departure_stop")));
        r120.setArrivalstop(t(r119.optJSONObject("arrival_stop")));
        r120.setViastops(u(r119));
        r120.setAlters(v(r119));
        r120.setSpaces(w(r119));
    L63:
        r112 = r112 + 1;
        goto L14
    L64:
        r103.setSteps(r106);
        r103.setBusDistance(r107);
        r103.setWalkDistance(r111);
        r101.add(r103);
    L66:
        r102 = r102 + 1;
        r100 = r110;
        goto L7
    L67:
        return r101;
    }

    public static DriveRouteResult b(String r110) throws AMapException {
        JSONObject r100 = new JSONObject(r110);     // Catch: Throwable -> L36 JSONException -> L39
        if (r100.has(CloudControlInf.ROUTE) == true) goto L7;
        return null;
    L7:
        DriveRouteResult r101 = new DriveRouteResult();     // Catch: Throwable -> L36 JSONException -> L39
        JSONObject r102 = r100.optJSONObject(CloudControlInf.ROUTE);     // Catch: Throwable -> L36 JSONException -> L39
        if (r102 != null) goto L10;
        return r101;
    L10:
        r101.setStartPos(b(r102, PlayerResolution.SDKKEY.ORIGIN));     // Catch: Throwable -> L36 JSONException -> L39
        r101.setTargetPos(b(r102, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));     // Catch: Throwable -> L36 JSONException -> L39
        r101.setTaxiCost(o(a(r102, "taxi_cost")));     // Catch: Throwable -> L36 JSONException -> L39
        if (r102.has("paths") == true) goto L13;
        return r101;
    L13:
        JSONArray r103 = r102.optJSONArray("paths");     // Catch: Throwable -> L36 JSONException -> L39
        if (r103 != null) goto L16;
        return r101;
    L16:
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L36 JSONException -> L39
        int r111 = 0;
    L18:
        if (r111 >= r103.length()) goto L34;
        DrivePath r112 = new DrivePath();     // Catch: Throwable -> L36 JSONException -> L39
        JSONObject r113 = r103.optJSONObject(r111);     // Catch: Throwable -> L36 JSONException -> L39
        if (r113 == null) goto L32;
        r112.setDistance(o(a(r113, "distance")));     // Catch: Throwable -> L36 JSONException -> L39
        r112.setDuration(q(a(r113, "duration")));     // Catch: Throwable -> L36 JSONException -> L39
        r112.setStrategy(a(r113, BdpAppEventConstant.PARAMS_STRATEGY_NAME));     // Catch: Throwable -> L36 JSONException -> L39
        r112.setTolls(o(a(r113, "tolls")));     // Catch: Throwable -> L36 JSONException -> L39
        r112.setTollDistance(o(a(r113, "toll_distance")));     // Catch: Throwable -> L36 JSONException -> L39
        r112.setTotalTrafficlights(n(a(r113, "traffic_lights")));     // Catch: Throwable -> L36 JSONException -> L39
        r112.setRestriction(n(a(r113, "restriction")));     // Catch: Throwable -> L36 JSONException -> L39
        JSONArray r114 = r113.optJSONArray("steps");     // Catch: Throwable -> L36 JSONException -> L39
        if (r114 == null) goto L32;
        ArrayList r115 = new ArrayList();     // Catch: Throwable -> L36 JSONException -> L39
        int r116 = 0;
    L25:
        if (r116 >= r114.length()) goto L31;
        DriveStep r117 = new DriveStep();     // Catch: Throwable -> L36 JSONException -> L39
        JSONObject r105 = r114.optJSONObject(r116);     // Catch: Throwable -> L36 JSONException -> L39
        if (r105 == null) goto L30;
        r117.setInstruction(a(r105, "instruction"));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setOrientation(a(r105, "orientation"));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setRoad(a(r105, "road"));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setDistance(o(a(r105, "distance")));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setTolls(o(a(r105, "tolls")));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setTollDistance(o(a(r105, "toll_distance")));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setTollRoad(a(r105, "toll_road"));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setDuration(o(a(r105, "duration")));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setPolyline(c(r105, SVGRenderEngine.POLYLINE));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setAction(a(r105, "action"));     // Catch: Throwable -> L36 JSONException -> L39
        r117.setAssistantAction(a(r105, "assistant_action"));     // Catch: Throwable -> L36 JSONException -> L39
        b(r117, r105);     // Catch: Throwable -> L36 JSONException -> L39
        a(r117, r105);     // Catch: Throwable -> L36 JSONException -> L39
        r115.add(r117);     // Catch: Throwable -> L36 JSONException -> L39
    L30:
        r116 = r116 + 1;     // Catch: Throwable -> L36 JSONException -> L39
        r103 = r103;
        goto L25
    L31:
        JSONArray r118 = r103;
        r112.setSteps(r115);     // Catch: Throwable -> L36 JSONException -> L39
        b(r112, r115);     // Catch: Throwable -> L36 JSONException -> L39
        r104.add(r112);     // Catch: Throwable -> L36 JSONException -> L39
    L33:
        r111 = r111 + 1;     // Catch: Throwable -> L36 JSONException -> L39
        r103 = r118;
    L32:
        r118 = r103;
        goto L33
    L34:
        r101.setPaths(r104);     // Catch: Throwable -> L36 JSONException -> L39
        return r101;
    L39:
        e = move-exception;
        i.a(e, "JSONHelper", "parseDriveRoute");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    L36:
        th = move-exception;
        i.a(th, "JSONHelper", "parseDriveRouteThrowable");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static WalkRouteResult c(String r110) throws AMapException {
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L35
        if (r100.has(CloudControlInf.ROUTE) == true) goto L7;
        return null;
    L7:
        WalkRouteResult r111 = new WalkRouteResult();     // Catch: JSONException -> L35
        JSONObject r101 = r100.optJSONObject(CloudControlInf.ROUTE);     // Catch: JSONException -> L35
        r111.setStartPos(b(r101, PlayerResolution.SDKKEY.ORIGIN));     // Catch: JSONException -> L35
        r111.setTargetPos(b(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));     // Catch: JSONException -> L35
        if (r101.has("paths") == true) goto L10;
        return r111;
    L10:
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L35
        JSONArray r103 = r101.optJSONArray("paths");     // Catch: JSONException -> L35
        if (r103 != null) goto L14;
        r111.setPaths(r102);     // Catch: JSONException -> L35
        return r111;
    L14:
        int r104 = 0;
    L16:
        if (r104 >= r103.length()) goto L33;
        WalkPath r105 = new WalkPath();     // Catch: JSONException -> L35
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: JSONException -> L35
        if (r106 == null) goto L32;
        r105.setDistance(o(a(r106, "distance")));     // Catch: JSONException -> L35
        r105.setDuration(q(a(r106, "duration")));     // Catch: JSONException -> L35
        if (r106.has("steps") == false) goto L31;
        JSONArray r107 = r106.optJSONArray("steps");     // Catch: JSONException -> L35
        ArrayList r108 = new ArrayList();     // Catch: JSONException -> L35
        if (r107 == null) goto L32;
        int r112 = 0;
    L25:
        if (r112 >= r107.length()) goto L30;
        WalkStep r113 = new WalkStep();     // Catch: JSONException -> L35
        JSONObject r114 = r107.optJSONObject(r112);     // Catch: JSONException -> L35
        if (r114 == null) goto L29;
        r113.setInstruction(a(r114, "instruction"));     // Catch: JSONException -> L35
        r113.setOrientation(a(r114, "orientation"));     // Catch: JSONException -> L35
        r113.setRoad(a(r114, "road"));     // Catch: JSONException -> L35
        r113.setDistance(o(a(r114, "distance")));     // Catch: JSONException -> L35
        r113.setDuration(o(a(r114, "duration")));     // Catch: JSONException -> L35
        r113.setPolyline(c(r114, SVGRenderEngine.POLYLINE));     // Catch: JSONException -> L35
        r113.setAction(a(r114, "action"));     // Catch: JSONException -> L35
        r113.setAssistantAction(a(r114, "assistant_action"));     // Catch: JSONException -> L35
        r108.add(r113);     // Catch: JSONException -> L35
    L29:
        r112 = r112 + 1;     // Catch: JSONException -> L35
        goto L25
    L30:
        r105.setSteps(r108);     // Catch: JSONException -> L35
        a(r105, r108);     // Catch: JSONException -> L35
    L31:
        r102.add(r105);     // Catch: JSONException -> L35
    L32:
        r104 = r104 + 1;     // Catch: JSONException -> L35
        goto L16
    L33:
        r111.setPaths(r102);     // Catch: JSONException -> L35
        return r111;
    L35:
        e = move-exception;
        i.a(e, "JSONHelper", "parseWalkRoute");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static PoiItem d(JSONObject r100) throws JSONException {
        PoiItem r101 = new PoiItem(a(r100, "id"), b(r100, "location"), a(r100, "name"), a(r100, "address"));
        r101.setAdCode(a(r100, "adcode"));
        r101.setProvinceName(a(r100, "pname"));
        r101.setCityName(a(r100, "cityname"));
        r101.setAdName(a(r100, "adname"));
        r101.setCityCode(a(r100, "citycode"));
        r101.setProvinceCode(a(r100, "pcode"));
        r101.setDirection(a(r100, "direction"));
        if (r100.has("distance") == false) goto L12;
        String r102 = a(r100, "distance");
        if (f(r102) == true) goto L12;
        r101.setDistance((int) CastFloatProtector.parseFloat(r102));     // Catch: Exception -> L8 NumberFormatException -> L10
    L10:
        e = move-exception;
        i.a(e, "JSONHelper", "parseBasePoi");
    L8:
        e = move-exception;
        i.a(e, "JSONHelper", "parseBasePoi");
    L12:
        r101.setTel(a(r100, "tel"));
        r101.setTypeDes(a(r100, "type"));
        r101.setEnter(b(r100, "entr_location"));
        r101.setExit(b(r100, "exit_location"));
        r101.setWebsite(a(r100, "website"));
        r101.setPostcode(a(r100, "postcode"));
        String r103 = a(r100, "business_area");
        if (f(r103) == false) goto L15;
        r103 = a(r100, "businessarea");
    L15:
        r101.setBusinessArea(r103);
        r101.setEmail(a(r100, "email"));
        String r104 = a(r100, "indoor_map");
        int r105 = 0;
        String r106 = "";
        if (r104 != null) goto L18;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L26;
        r101.setIndoorMap(false);
    L27:
        r101.setParkingType(a(r100, "parking_type"));
        ArrayList r108 = new ArrayList();
        if (r100.has("children") == false) goto L40;
        JSONArray r109 = r100.optJSONArray("children");
        if (r109 == null) goto L38;
        int r110 = 0;
    L33:
        if (r110 >= r109.length()) goto L38;
        JSONObject r111 = r109.optJSONObject(r110);
        if (r111 == null) goto L37;
        r108.add(j(r111));
    L37:
        r110 = r110 + 1;
    L38:
        r101.setSubPois(r108);
    L40:
        if (r100.has("indoor_data") == false) goto L48;
        JSONObject r112 = r100.optJSONObject("indoor_data");
        if (r112 == null) goto L48;
        if (r112.has("cpid") == false) goto L48;
        if (r112.has("floor") == false) goto L48;
        String r113 = a(r112, "cpid");
        r105 = n(a(r112, "floor"));
        String r114 = a(r112, "truefloor");
    L49:
        r101.setIndoorDate(new IndoorData(r113, r105, r114));
        if (r100.has("biz_ext") == false) goto L54;
        JSONObject r115 = r100.optJSONObject("biz_ext");
        if (r115 == null) goto L54;
        r106 = a(r115, "open_time");
        String r116 = a(r115, "rating");
    L55:
        r101.setPoiExtension(new PoiItemExtension(r106, r116));
        r101.setTypeCode(a(r100, "typecode"));
        r101.setShopID(a(r100, "shopid"));
        List<Photo> r117 = x(r100.optJSONObject("deep_info"));
        if (r117.size() != 0) goto L58;
        r117 = x(r100);
    L58:
        r101.setPhotos(r117);
        return r101;
    L54:
        r116 = "";
    L48:
        r114 = "";
        r113 = r114;
        goto L49
    L26:
        r101.setIndoorMap(true);
        goto L27
    L18:
        if (r104.equals("") == true) goto L23;
        if (r104.equals("0") == true) goto L23;
        r107 = false;
        goto L24
    }

    public static LocalWeatherForecast e(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L33
        if (r101.has("forecasts") == true) goto L7;
        return null;
    L7:
        LocalWeatherForecast r102 = new LocalWeatherForecast();     // Catch: JSONException -> L33
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r101, "forecasts");     // Catch: JSONException -> L33
        if (r103 != null) goto L10;
    L32:
        return r102;
    L10:
        if (r103.length() <= 0) goto L32;
        int r104 = 0;
        JSONObject r105 = r103.optJSONObject(0);     // Catch: JSONException -> L33
        if (r105 != null) goto L15;
        return r102;
    L15:
        r102.setCity(a(r105, "city"));     // Catch: JSONException -> L33
        r102.setAdCode(a(r105, "adcode"));     // Catch: JSONException -> L33
        r102.setProvince(a(r105, "province"));     // Catch: JSONException -> L33
        r102.setReportTime(a(r105, "reporttime"));     // Catch: JSONException -> L33
        if (r105.has("casts") == true) goto L18;
        return r102;
    L18:
        ArrayList r106 = new ArrayList();     // Catch: JSONException -> L33
        JSONArray r107 = r105.optJSONArray("casts");     // Catch: JSONException -> L33
        if (r107 != null) goto L21;
    L31:
        r102.setWeatherForecast(r106);     // Catch: JSONException -> L33
        goto L32
    L21:
        if (r107.length() <= 0) goto L31;
    L24:
        if (r104 >= r107.length()) goto L29;
        LocalDayWeatherForecast r108 = new LocalDayWeatherForecast();     // Catch: JSONException -> L33
        JSONObject r109 = r107.optJSONObject(r104);     // Catch: JSONException -> L33
        if (r109 == null) goto L28;
        r108.setDate(a(r109, "date"));     // Catch: JSONException -> L33
        r108.setWeek(a(r109, "week"));     // Catch: JSONException -> L33
        r108.setDayWeather(a(r109, "dayweather"));     // Catch: JSONException -> L33
        r108.setNightWeather(a(r109, "nightweather"));     // Catch: JSONException -> L33
        r108.setDayTemp(a(r109, "daytemp"));     // Catch: JSONException -> L33
        r108.setNightTemp(a(r109, "nighttemp"));     // Catch: JSONException -> L33
        r108.setDayWindDirection(a(r109, "daywind"));     // Catch: JSONException -> L33
        r108.setNightWindDirection(a(r109, "nightwind"));     // Catch: JSONException -> L33
        r108.setDayWindPower(a(r109, "daypower"));     // Catch: JSONException -> L33
        r108.setNightWindPower(a(r109, "nightpower"));     // Catch: JSONException -> L33
        r106.add(r108);     // Catch: JSONException -> L33
    L28:
        r104 = r104 + 1;     // Catch: JSONException -> L33
        goto L24
    L29:
        r102.setWeatherForecast(r106);     // Catch: JSONException -> L33
        return r102;
    L33:
        e = move-exception;
        i.a(e, "JSONHelper", "WeatherForecastResult");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static ArrayList<BusLineItem> f(JSONObject r100) throws JSONException {
        ArrayList<BusLineItem> r101 = new ArrayList();
        JSONArray r102 = r100.optJSONArray("buslines");
        if (r102 != null) goto L5;
        return r101;
    L5:
        int r103 = 0;
    L7:
        if (r103 >= r102.length()) goto L12;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L11;
        r101.add(n(r104));
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        return r101;
    }

    public static ArrayList<GeocodeAddress> g(JSONObject r100) throws JSONException {
        ArrayList<GeocodeAddress> r101 = new ArrayList();
        JSONArray r102 = r100.optJSONArray("geocodes");
        if (r102 != null) goto L5;
    L14:
        return r101;
    L5:
        if (r102.length() == 0) goto L14;
        int r103 = 0;
    L9:
        if (r103 >= r102.length()) goto L14;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L13;
        GeocodeAddress r105 = new GeocodeAddress();
        r105.setFormatAddress(a(r104, "formatted_address"));
        r105.setProvince(a(r104, "province"));
        r105.setCity(a(r104, "city"));
        r105.setDistrict(a(r104, DistrictSearchQuery.KEYWORDS_DISTRICT));
        r105.setTownship(a(r104, "township"));
        r105.setNeighborhood(a(r104.optJSONObject("neighborhood"), "name"));
        r105.setBuilding(a(r104.optJSONObject(LocationConstants$NameType.BUILDING), "name"));
        r105.setAdcode(a(r104, "adcode"));
        r105.setLatLonPoint(b(r104, "location"));
        r105.setLevel(a(r104, "level"));
        r105.setCountry(a(r104, DistrictSearchQuery.KEYWORDS_COUNTRY));
        r105.setPostcode(a(r104, "postcode"));
        r101.add(r105);
    L13:
        r103 = r103 + 1;
        goto L9
    }

    public static DistanceResult h(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L15
        if (r101.has("results") == true) goto L7;
        return null;
    L7:
        DistanceResult r102 = new DistanceResult();     // Catch: JSONException -> L15
        JSONArray r103 = r101.optJSONArray("results");     // Catch: JSONException -> L15
        ArrayList r104 = new ArrayList();     // Catch: JSONException -> L15
        int r105 = r103.length();     // Catch: JSONException -> L15
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L13;
        DistanceItem r107 = new DistanceItem();     // Catch: JSONException -> L15
        JSONObject r108 = JSONArrayProtectorUtils.getJSONObject(r103, r106);     // Catch: JSONException -> L15
        r107.setOriginId(n(a(r108, com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)));     // Catch: JSONException -> L15
        r107.setDestId(n(a(r108, "dest_id")));     // Catch: JSONException -> L15
        r107.setDistance(o(a(r108, "distance")));     // Catch: JSONException -> L15
        r107.setDuration(o(a(r108, "duration")));     // Catch: JSONException -> L15
        String r109 = a(r108, "info");     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r109) == true) goto L12;
        r107.setErrorInfo(r109);     // Catch: JSONException -> L15
        r107.setErrorCode(n(a(r108, "code")));     // Catch: JSONException -> L15
    L12:
        r104.add(r107);     // Catch: JSONException -> L15
        r106 = r106 + 1;     // Catch: JSONException -> L15
        goto L8
    L13:
        r102.setDistanceResults(r104);     // Catch: JSONException -> L15
        return r102;
    L15:
        e = move-exception;
        i.a(e, "JSONHelper", "parseRouteDistance");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static TruckRouteRestult i(String r110) throws AMapException {
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L28
        if (r100.has("data") == true) goto L7;
        return null;
    L7:
        TruckRouteRestult r101 = new TruckRouteRestult();     // Catch: JSONException -> L28
        JSONObject r102 = r100.optJSONObject("data").optJSONObject(CloudControlInf.ROUTE);     // Catch: JSONException -> L28
        r101.setStartPos(b(r102, PlayerResolution.SDKKEY.ORIGIN));     // Catch: JSONException -> L28
        r101.setTargetPos(b(r102, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));     // Catch: JSONException -> L28
        if (r102.has("paths") == true) goto L10;
        return r101;
    L10:
        JSONArray r103 = r102.optJSONArray("paths");     // Catch: JSONException -> L28
        if (r103 != null) goto L13;
        return r101;
    L13:
        ArrayList r104 = new ArrayList();     // Catch: JSONException -> L28
        int r105 = r103.length();     // Catch: JSONException -> L28
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L26;
        TruckPath r111 = new TruckPath();     // Catch: JSONException -> L28
        JSONObject r112 = JSONArrayProtectorUtils.getJSONObject(r103, r106);     // Catch: JSONException -> L28
        r111.setDistance(o(a(r112, "distance")));     // Catch: JSONException -> L28
        r111.setDuration(q(a(r112, "duration")));     // Catch: JSONException -> L28
        r111.setStrategy(a(r112, BdpAppEventConstant.PARAMS_STRATEGY_NAME));     // Catch: JSONException -> L28
        r111.setTolls(o(a(r112, "tolls")));     // Catch: JSONException -> L28
        r111.setTollDistance(o(a(r112, "toll_distance")));     // Catch: JSONException -> L28
        r111.setTotalTrafficlights(n(a(r112, "traffic_lights")));     // Catch: JSONException -> L28
        r111.setRestriction(n(a(r112, "restriction")));     // Catch: JSONException -> L28
        JSONArray r113 = r112.optJSONArray("steps");     // Catch: JSONException -> L28
        if (r113 == null) goto L25;
        ArrayList r114 = new ArrayList();     // Catch: JSONException -> L28
        int r115 = 0;
    L19:
        if (r115 >= r113.length()) goto L24;
        TruckStep r116 = new TruckStep();     // Catch: JSONException -> L28
        JSONObject r117 = r113.optJSONObject(r115);     // Catch: JSONException -> L28
        if (r117 == null) goto L23;
        r116.setInstruction(a(r117, "instruction"));     // Catch: JSONException -> L28
        r116.setOrientation(a(r117, "orientation"));     // Catch: JSONException -> L28
        r116.setRoad(a(r117, "road"));     // Catch: JSONException -> L28
        r116.setDistance(o(a(r117, "distance")));     // Catch: JSONException -> L28
        r116.setTolls(o(a(r117, "tolls")));     // Catch: JSONException -> L28
        r116.setTollDistance(o(a(r117, "toll_distance")));     // Catch: JSONException -> L28
        r116.setTollRoad(a(r117, "toll_road"));     // Catch: JSONException -> L28
        r116.setDuration(o(a(r117, "duration")));     // Catch: JSONException -> L28
        r116.setPolyline(c(r117, SVGRenderEngine.POLYLINE));     // Catch: JSONException -> L28
        r116.setAction(a(r117, "action"));     // Catch: JSONException -> L28
        r116.setAssistantAction(a(r117, "assistant_action"));     // Catch: JSONException -> L28
        a(r116, r117);     // Catch: JSONException -> L28
        b(r116, r117);     // Catch: JSONException -> L28
        r114.add(r116);     // Catch: JSONException -> L28
    L23:
        r115 = r115 + 1;     // Catch: JSONException -> L28
        goto L19
    L24:
        r111.setSteps(r114);     // Catch: JSONException -> L28
        r104.add(r111);     // Catch: JSONException -> L28
    L25:
        r106 = r106 + 1;     // Catch: JSONException -> L28
        goto L14
    L26:
        r101.setPaths(r104);     // Catch: JSONException -> L28
        return r101;
    L28:
        e = move-exception;
        i.a(e, "JSONHelper", "parseTruckRoute");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static DriveRoutePlanResult j(String r210) throws AMapException {
        String r100 = "starttime";
        String r101 = AMapException.AMAP_CLIENT_ERROR_PROTOCOL;
        JSONObject r102 = new JSONObject(r210);     // Catch: Throwable -> L93 JSONException -> L97
        if (r102.has("errcode") == false) goto L7;
        r102.optInt("errcode");     // Catch: Throwable -> L93 JSONException -> L97
        r102.optString(ITTReaderViewWrapper.ERROR_MSG_KEY);     // Catch: Throwable -> L93 JSONException -> L97
        r102.optString("errdetail");     // Catch: Throwable -> L93 JSONException -> L97
    L7:
        if (r102.has("data") == true) goto L10;
        return null;
    L10:
        DriveRoutePlanResult r103 = new DriveRoutePlanResult();     // Catch: Throwable -> L93 JSONException -> L97
        JSONObject r104 = r102.optJSONObject("data");     // Catch: Throwable -> L93 JSONException -> L97
        if (r104 != null) goto L14;
        return r103;
    L14:
        if (r104.has("paths") == true) goto L16;
        return r103;
    L16:
        JSONArray r105 = r104.optJSONArray("paths");     // Catch: Throwable -> L93 JSONException -> L97
        if (r105 != null) goto L19;
        return r103;
    L19:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L93 JSONException -> L97
        int r107 = 0;
    L20:
    L22:
        if (r107 >= r105.length()) goto L43;
        DrivePlanPath r110 = new DrivePlanPath();     // Catch: Throwable -> L93 JSONException -> L97
        JSONObject r111 = r105.optJSONObject(r107);     // Catch: Throwable -> L93 JSONException -> L97
        if (r111 == null) goto L41;
        r110.setDistance(o(a(r111, "distance")));     // Catch: Throwable -> L93 JSONException -> L97
        r110.setTrafficLights(n(a(r111, "traffic_lights")));     // Catch: Throwable -> L93 JSONException -> L97
        JSONArray r112 = r111.optJSONArray("steps");     // Catch: Throwable -> L93 JSONException -> L97
        if (r112 == null) goto L41;
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L93 JSONException -> L97
        int r108 = 0;
    L29:
        if (r108 >= r112.length()) goto L40;
        DrivePlanStep r114 = new DrivePlanStep();     // Catch: Throwable -> L93 JSONException -> L97
        JSONArray r115 = r105;
        JSONObject r109 = r112.optJSONObject(r108);     // Catch: Throwable -> L93 JSONException -> L97
        if (r109 == null) goto L38;
        r114.setAdCode(a(r109, "adcode"));     // Catch: Throwable -> L93 JSONException -> L97
        r114.setRoad(a(r109, "road"));     // Catch: Throwable -> L93 JSONException -> L97
        r114.setDistance(o(a(r109, "distance")));     // Catch: Throwable -> L93 JSONException -> L97
        String r116 = r101;
        if (n(a(r109, RouteSearch.DRIVING_EXCLUDE_TOLL)) != 1) goto L36;
        boolean r117 = true;
    L101:
        r114.setToll(r117);     // Catch: Throwable -> L89 JSONException -> L91
        r114.setPolyline(c(r109, SVGRenderEngine.POLYLINE));     // Catch: Throwable -> L89 JSONException -> L91
        r113.add(r114);     // Catch: Throwable -> L89 JSONException -> L91
    L39:
        r108 = r108 + 1;     // Catch: Throwable -> L89 JSONException -> L91
        r105 = r115;
        r112 = r112;
        r101 = r116;
    L91:
        e = e;
        String r118 = r116;
    L99:
        i.a(e, "JSONHelper", "parseDriveRoute");
        throw new AMapException(r118);
    L89:
        th = th;
    L95:
        i.a(th, "JSONHelper", "parseDriveRouteThrowable");
        throw new AMapException(r116);
    L36:
        r117 = false;
        goto L101
    L38:
        r116 = r101;
        goto L39
    L40:
        JSONArray r119 = r105;
        String r120 = r101;
        r110.setSteps(r113);     // Catch: Throwable -> L89 JSONException -> L91
        r106.add(r110);     // Catch: Throwable -> L89 JSONException -> L91
    L42:
        r107 = r107 + 1;     // Catch: Throwable -> L89 JSONException -> L91
        r105 = r119;
        r101 = r120;
    L41:
        r119 = r105;
        r120 = r101;
        goto L42
    L43:
        r116 = r101;
        r103.setPaths(r106);     // Catch: Throwable -> L89 JSONException -> L91
        if (r104.has("time_infos") == true) goto L46;
        return r103;
    L46:
        JSONArray r121 = r104.optJSONArray("time_infos");     // Catch: Throwable -> L89 JSONException -> L91
        if (r121 != null) goto L49;
        return r103;
    L49:
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L89 JSONException -> L91
        int r123 = 0;
    L51:
        if (r123 >= r121.length()) goto L87;
        TimeInfo r124 = new TimeInfo();     // Catch: Throwable -> L89 JSONException -> L91
        JSONObject r125 = r121.optJSONObject(r123);     // Catch: Throwable -> L89 JSONException -> L91
        if (r125 != null) goto L55;
    L85:
        String r126 = r100;
        JSONArray r127 = r121;
    L86:
        r123 = r123 + 1;     // Catch: Throwable -> L89 JSONException -> L91
        r100 = r126;
        r121 = r127;
        goto L51
    L55:
        if (r125.has(r100) == false) goto L56;
        r124.setStartTime(q(a(r125, r100)));     // Catch: Throwable -> L89 JSONException -> L91
        JSONArray r128 = r125.optJSONArray(SlcElement.KEY_ELEMENTS);     // Catch: Throwable -> L89 JSONException -> L91
        if (r128 == null) goto L85;
        ArrayList r129 = new ArrayList();     // Catch: Throwable -> L89 JSONException -> L91
        int r130 = 0;
    L61:
        if (r130 >= r128.length()) goto L84;
        TimeInfosElement r131 = new TimeInfosElement();     // Catch: Throwable -> L89 JSONException -> L91
        JSONObject r132 = r128.optJSONObject(r130);     // Catch: Throwable -> L89 JSONException -> L91
        if (r132 == null) goto L82;
        r131.setPathindex(n(a(r132, "pathindex")));     // Catch: Throwable -> L89 JSONException -> L91
        r131.setDuration(o(a(r132, "duration")));     // Catch: Throwable -> L89 JSONException -> L91
        r131.setTolls(o(a(r132, "tolls")));     // Catch: Throwable -> L89 JSONException -> L91
        int r133 = n(a(r132, "restriction"));     // Catch: Throwable -> L89 JSONException -> L91
        if (r133 != 2) goto L67;
    L70:
        int r134 = 0;
    L71:
        r131.setRestriction(r134);     // Catch: Throwable -> L89 JSONException -> L91
        JSONArray r135 = r132.optJSONArray("tmcs");     // Catch: Throwable -> L89 JSONException -> L91
        if (r135 == null) goto L82;
        ArrayList r136 = new ArrayList();     // Catch: Throwable -> L89 JSONException -> L91
        int r137 = 0;
    L75:
        if (r137 >= r135.length()) goto L81;
        TMC r138 = new TMC();     // Catch: Throwable -> L89 JSONException -> L91
        JSONArray r139 = r121;
        JSONObject r140 = r135.optJSONObject(r137);     // Catch: Throwable -> L89 JSONException -> L91
        if (r140 == null) goto L80;
        r138.setStatus(a(r140, "status"));     // Catch: Throwable -> L89 JSONException -> L91
        r138.setDistance(n(a(r140, "distance")));     // Catch: Throwable -> L89 JSONException -> L91
        r138.setPolyline(c(r140, SVGRenderEngine.POLYLINE));     // Catch: Throwable -> L89 JSONException -> L91
        r136.add(r138);     // Catch: Throwable -> L89 JSONException -> L91
    L80:
        r137 = r137 + 1;     // Catch: Throwable -> L89 JSONException -> L91
        r121 = r139;
        r135 = r135;
        goto L75
    L81:
        JSONArray r141 = r121;
        r131.setTMCs(r136);     // Catch: Throwable -> L89 JSONException -> L91
        r129.add(r131);     // Catch: Throwable -> L89 JSONException -> L91
    L83:
        r130 = r130 + 1;     // Catch: Throwable -> L89 JSONException -> L91
        r100 = r100;
        r121 = r141;
        goto L61
    L67:
        if (r133 == (-1)) goto L70;
        r134 = 1;
    L82:
        r141 = r121;
        goto L83
    L84:
        r126 = r100;
        r127 = r121;
        r124.setElements(r129);     // Catch: Throwable -> L89 JSONException -> L91
        r122.add(r124);     // Catch: Throwable -> L89 JSONException -> L91
        goto L86
    L56:
        return r103;
    L87:
        r103.setTimeInfos(r122);     // Catch: Throwable -> L89 JSONException -> L91
        return r103;
    L97:
        e = e;
        r118 = r101;
    L93:
        th = th;
        r116 = r101;
        goto L95
    }

    private static BusStationItem k(JSONObject r100) throws JSONException {
        BusStationItem r101 = l(r100);
        r101.setAdCode(a(r100, "adcode"));
        r101.setCityCode(a(r100, "citycode"));
        JSONArray r102 = r100.optJSONArray("buslines");
        ArrayList r103 = new ArrayList();
        if (r102 != null) goto L6;
        r101.setBusLineItems(r103);
        return r101;
    L6:
        int r104 = 0;
    L8:
        if (r104 >= r102.length()) goto L13;
        JSONObject r105 = r102.optJSONObject(r104);
        if (r105 == null) goto L12;
        r103.add(m(r105));
    L12:
        r104 = r104 + 1;
        goto L8
    L13:
        r101.setBusLineItems(r103);
        return r101;
    }

    private static BusStationItem l(JSONObject r100) throws JSONException {
        BusStationItem r101 = new BusStationItem();
        r101.setBusStationId(a(r100, "id"));
        r101.setLatLonPoint(b(r100, "location"));
        r101.setBusStationName(a(r100, "name"));
        return r101;
    }

    private static BusLineItem m(JSONObject r100) throws JSONException {
        BusLineItem r101 = new BusLineItem();
        r101.setBusLineId(a(r100, "id"));
        r101.setBusLineType(a(r100, "type"));
        r101.setBusLineName(a(r100, "name"));
        r101.setDirectionsCoordinates(c(r100, SVGRenderEngine.POLYLINE));
        r101.setCityCode(a(r100, "citycode"));
        r101.setOriginatingStation(a(r100, "start_stop"));
        r101.setTerminalStation(a(r100, "end_stop"));
        return r101;
    }

    private static BusLineItem n(JSONObject r100) throws JSONException {
        BusLineItem r101 = m(r100);
        r101.setFirstBusTime(i.d(a(r100, ILoadStallMonitor.START_TIME)));
        r101.setLastBusTime(i.d(a(r100, "end_time")));
        r101.setBusCompany(a(r100, "company"));
        r101.setDistance(o(a(r100, "distance")));
        r101.setBasicPrice(o(a(r100, "basic_price")));
        r101.setTotalPrice(o(a(r100, "total_price")));
        r101.setBounds(c(r100, "bounds"));
        ArrayList r102 = new ArrayList();
        JSONArray r103 = r100.optJSONArray("busstops");
        if (r103 != null) goto L6;
        r101.setBusStations(r102);
        return r101;
    L6:
        int r104 = 0;
    L8:
        if (r104 >= r103.length()) goto L13;
        JSONObject r105 = r103.optJSONObject(r104);
        if (r105 == null) goto L12;
        r102.add(l(r105));
    L12:
        r104 = r104 + 1;
        goto L8
    L13:
        r101.setBusStations(r102);
        return r101;
    }

    private static RouteBusWalkItem o(JSONObject r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        RouteBusWalkItem r101 = new RouteBusWalkItem();
        r101.setOrigin(b(r100, PlayerResolution.SDKKEY.ORIGIN));
        r101.setDestination(b(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));
        r101.setDistance(o(a(r100, "distance")));
        r101.setDuration(q(a(r100, "duration")));
        if (r100.has("steps") == true) goto L8;
        return r101;
    L8:
        JSONArray r102 = r100.optJSONArray("steps");
        if (r102 != null) goto L11;
        return r101;
    L11:
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L13:
        if (r104 >= r102.length()) goto L18;
        JSONObject r105 = r102.optJSONObject(r104);
        if (r105 == null) goto L17;
        WalkStep r106 = new WalkStep();
        r106.setInstruction(a(r105, "instruction"));
        r106.setOrientation(a(r105, "orientation"));
        r106.setRoad(a(r105, "road"));
        r106.setDistance(o(a(r105, "distance")));
        r106.setDuration(o(a(r105, "duration")));
        r106.setPolyline(c(r105, SVGRenderEngine.POLYLINE));
        r106.setAction(a(r105, "action"));
        r106.setAssistantAction(a(r105, "assistant_action"));
        r103.add(r106);
    L17:
        r104 = r104 + 1;
        goto L13
    L18:
        r101.setSteps(r103);
        a(r101, r103);
        return r101;
    }

    private static List<RouteBusLineItem> p(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("buslines");
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L15;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L14;
        RouteBusLineItem r105 = new RouteBusLineItem();
        r105.setDepartureBusStation(s(r104.optJSONObject("departure_stop")));
        r105.setArrivalBusStation(s(r104.optJSONObject("arrival_stop")));
        r105.setBusLineName(a(r104, "name"));
        r105.setBusLineId(a(r104, "id"));
        r105.setBusLineType(a(r104, "type"));
        r105.setDistance(o(a(r104, "distance")));
        r105.setDuration(o(a(r104, "duration")));
        r105.setPolyline(c(r104, SVGRenderEngine.POLYLINE));
        r105.setFirstBusTime(i.d(a(r104, ILoadStallMonitor.START_TIME)));
        r105.setLastBusTime(i.d(a(r104, "end_time")));
        r105.setPassStationNum(n(a(r104, "via_num")));
        r105.setPassStations(r(r104));
        r101.add(r105);
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r101;
    }

    private static long q(String r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.equals("") == false) goto L7;
        return 0;
    L7:
        if (r100.equals("[]") == true) goto L18;
        return CastLongProtector.parseLong(r100);
    L11:
        e = move-exception;
        i.a(e, "JSONHelper", "str2long");
        return 0;
    L18:
        return 0;
    }

    private static List<BusStationItem> r(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("via_stops");
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L15;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L14;
        r101.add(s(r104));
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r101;
    }

    private static BusStationItem s(JSONObject r100) throws JSONException {
        BusStationItem r101 = new BusStationItem();
        r101.setBusStationName(a(r100, "name"));
        r101.setBusStationId(a(r100, "id"));
        r101.setLatLonPoint(b(r100, "location"));
        return r101;
    }

    private static RailwayStationItem t(JSONObject r100) throws JSONException {
        RailwayStationItem r101 = new RailwayStationItem();
        r101.setID(a(r100, "id"));
        r101.setName(a(r100, "name"));
        r101.setLocation(b(r100, "location"));
        r101.setAdcode(a(r100, "adcode"));
        r101.setTime(a(r100, "time"));
        r101.setisStart(r(a(r100, "start")));
        r101.setisEnd(r(a(r100, "end")));
        r101.setWait(o(a(r100, "wait")));
        return r101;
    }

    private static List<RailwayStationItem> u(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("via_stops");
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L15;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L14;
        r101.add(t(r104));
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r101;
    }

    private static List<Railway> v(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("alters");
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L15;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L14;
        Railway r105 = new Railway();
        r105.setID(a(r104, "id"));
        r105.setName(a(r104, "name"));
        r101.add(r105);
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r101;
    }

    private static List<RailwaySpace> w(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("spaces");
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L15;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L14;
        r101.add(new RailwaySpace(a(r104, "code"), o(a(r104, ChameleonOpenTracker.ParamKey.COST))));
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r101;
    }

    private static List<Photo> x(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L6;
        return r101;
    L6:
        if (r100.has("photos") == true) goto L8;
        return r101;
    L8:
        JSONArray r102 = r100.optJSONArray("photos");
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L12;
        JSONObject r104 = r102.optJSONObject(r103);
        Photo r105 = new Photo();
        r105.setTitle(a(r104, "title"));
        r105.setUrl(a(r104, "url"));
        r101.add(r105);
        r103 = r103 + 1;
        goto L10
    L12:
        return r101;
    }

    private static RoutePOIItem y(JSONObject r100) throws JSONException {
        RoutePOIItem r101 = new RoutePOIItem();
        r101.setID(a(r100, "id"));
        r101.setTitle(a(r100, "name"));
        r101.setPoint(b(r100, "location"));
        r101.setDistance(o(a(r100, "distance")));
        r101.setDuration(o(a(r100, "duration")));
        return r101;
    }

    private static RidePath z(JSONObject r100) throws AMapException {
        RidePath r101 = new RidePath();
        if (r100 != null) goto L22;
        return null;
    L22:
        r101.setDistance(o(a(r100, "distance")));     // Catch: JSONException -> L19
        r101.setDuration(q(a(r100, "duration")));     // Catch: JSONException -> L19
        if (r100.has("steps") == false) goto L18;
        JSONArray r102 = r100.optJSONArray("steps");     // Catch: JSONException -> L19
        ArrayList r103 = new ArrayList();     // Catch: JSONException -> L19
        if (r102 != null) goto L10;
        return null;
    L10:
        int r104 = 0;
    L12:
        if (r104 >= r102.length()) goto L17;
        RideStep r105 = new RideStep();     // Catch: JSONException -> L19
        JSONObject r106 = r102.optJSONObject(r104);     // Catch: JSONException -> L19
        if (r106 == null) goto L16;
        r105.setInstruction(a(r106, "instruction"));     // Catch: JSONException -> L19
        r105.setOrientation(a(r106, "orientation"));     // Catch: JSONException -> L19
        r105.setRoad(a(r106, "road"));     // Catch: JSONException -> L19
        r105.setDistance(o(a(r106, "distance")));     // Catch: JSONException -> L19
        r105.setDuration(o(a(r106, "duration")));     // Catch: JSONException -> L19
        r105.setPolyline(c(r106, SVGRenderEngine.POLYLINE));     // Catch: JSONException -> L19
        r105.setAction(a(r106, "action"));     // Catch: JSONException -> L19
        r105.setAssistantAction(a(r106, "assistant_action"));     // Catch: JSONException -> L19
        r103.add(r105);     // Catch: JSONException -> L19
    L16:
        r104 = r104 + 1;     // Catch: JSONException -> L19
        goto L12
    L17:
        r101.setSteps(r103);     // Catch: JSONException -> L19
        c(r101, r103);     // Catch: JSONException -> L19
    L18:
        return r101;
    L19:
        e = move-exception;
        i.a(e, "JSONHelper", "parseRidePath");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static BusRouteResult a(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L18
        if (r101.has(CloudControlInf.ROUTE) == true) goto L7;
        return null;
    L7:
        BusRouteResult r102 = new BusRouteResult();     // Catch: JSONException -> L18
        JSONObject r103 = r101.optJSONObject(CloudControlInf.ROUTE);     // Catch: JSONException -> L18
        if (r103 != null) goto L10;
        return r102;
    L10:
        r102.setStartPos(b(r103, PlayerResolution.SDKKEY.ORIGIN));     // Catch: JSONException -> L18
        r102.setTargetPos(b(r103, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));     // Catch: JSONException -> L18
        r102.setTaxiCost(o(a(r103, "taxi_cost")));     // Catch: JSONException -> L18
        if (r103.has("transits") == true) goto L13;
        return r102;
    L13:
        JSONArray r104 = r103.optJSONArray("transits");     // Catch: JSONException -> L18
        if (r104 != null) goto L16;
        return r102;
    L16:
        r102.setPaths(a(r104));     // Catch: JSONException -> L18
        return r102;
    L19:
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static ArrayList<String> b(JSONObject r100) throws JSONException {
        ArrayList<String> r101 = new ArrayList();
        JSONArray r102 = r100.optJSONArray("keywords");
        if (r102 != null) goto L5;
        return r101;
    L5:
        int r103 = 0;
    L7:
        if (r103 >= r102.length()) goto L9;
        r101.add(r102.optString(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r101;
    }

    public static ArrayList<PoiItem> c(JSONObject r100) throws JSONException {
        ArrayList<PoiItem> r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("pois");
        if (r102 != null) goto L8;
    L17:
        return r101;
    L8:
        if (r102.length() == 0) goto L17;
        int r103 = 0;
    L12:
        if (r103 >= r102.length()) goto L17;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L16;
        r101.add(d(r104));
    L16:
        r103 = r103 + 1;
        goto L12
    }

    public static LocalWeatherLive d(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L17
        if (r101.has("lives") == true) goto L7;
        return null;
    L7:
        LocalWeatherLive r102 = new LocalWeatherLive();     // Catch: JSONException -> L17
        JSONArray r103 = r101.optJSONArray("lives");     // Catch: JSONException -> L17
        if (r103 != null) goto L10;
    L16:
        return r102;
    L10:
        if (r103.length() <= 0) goto L16;
        JSONObject r104 = r103.optJSONObject(0);     // Catch: JSONException -> L17
        if (r104 != null) goto L15;
        return r102;
    L15:
        r102.setAdCode(a(r104, "adcode"));     // Catch: JSONException -> L17
        r102.setProvince(a(r104, "province"));     // Catch: JSONException -> L17
        r102.setCity(a(r104, "city"));     // Catch: JSONException -> L17
        r102.setWeather(a(r104, "weather"));     // Catch: JSONException -> L17
        r102.setTemperature(a(r104, IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE));     // Catch: JSONException -> L17
        r102.setWindDirection(a(r104, "winddirection"));     // Catch: JSONException -> L17
        r102.setWindPower(a(r104, "windpower"));     // Catch: JSONException -> L17
        r102.setHumidity(a(r104, "humidity"));     // Catch: JSONException -> L17
        r102.setReportTime(a(r104, "reporttime"));     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        i.a(e, "JSONHelper", "WeatherForecastResult");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static ArrayList<BusStationItem> e(JSONObject r100) throws JSONException {
        ArrayList<BusStationItem> r101 = new ArrayList();
        JSONArray r102 = r100.optJSONArray("busstops");
        if (r102 != null) goto L5;
    L14:
        return r101;
    L5:
        if (r102.length() == 0) goto L14;
        int r103 = 0;
    L9:
        if (r103 >= r102.length()) goto L14;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L13;
        r101.add(k(r104));
    L13:
        r103 = r103 + 1;
        goto L9
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.equals("") == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static RideRouteResult g(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L31
        if (r101.has("data") == true) goto L7;
        return null;
    L7:
        RideRouteResult r102 = new RideRouteResult();     // Catch: JSONException -> L31
        JSONObject r103 = r101.optJSONObject("data");     // Catch: JSONException -> L31
        r102.setStartPos(b(r103, PlayerResolution.SDKKEY.ORIGIN));     // Catch: JSONException -> L31
        r102.setTargetPos(b(r103, com.bytedance.android.ec.core.event.a.KEY_DESTINATION));     // Catch: JSONException -> L31
        ArrayList r104 = new ArrayList();     // Catch: JSONException -> L31
        Object r105 = r103.opt("paths");     // Catch: JSONException -> L31
        if (r105 != null) goto L12;
        r102.setPaths(r104);     // Catch: JSONException -> L31
        return r102;
    L12:
        if ((r105 instanceof JSONArray) == false) goto L21;
        JSONArray r106 = r103.optJSONArray("paths");     // Catch: JSONException -> L31
        int r107 = 0;
    L15:
        if (r107 >= r106.length()) goto L29;
        RidePath r108 = z(r106.optJSONObject(r107));     // Catch: JSONException -> L31
        if (r108 == null) goto L19;
        r104.add(r108);     // Catch: JSONException -> L31
    L19:
        r107 = r107 + 1;     // Catch: JSONException -> L31
    L29:
        r102.setPaths(r104);     // Catch: JSONException -> L31
        return r102;
    L21:
        if ((r105 instanceof JSONObject) == false) goto L29;
        JSONObject r109 = r103.optJSONObject("paths");     // Catch: JSONException -> L31
        if (r109.has("path") == true) goto L26;
        r102.setPaths(r104);     // Catch: JSONException -> L31
        return r102;
    L26:
        RidePath r110 = z(r109.optJSONObject("path"));     // Catch: JSONException -> L31
        if (r110 == null) goto L29;
        r104.add(r110);     // Catch: JSONException -> L31
    L31:
        e = move-exception;
        i.a(e, "JSONHelper", "parseRideRoute");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static ArrayList<Tip> h(JSONObject r110) throws JSONException {
        ArrayList<Tip> r100 = new ArrayList();
        JSONArray r111 = r110.optJSONArray("tips");
        if (r111 != null) goto L5;
        return r100;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r111.length()) goto L17;
        Tip r102 = new Tip();
        JSONObject r103 = r111.optJSONObject(r101);
        if (r103 == null) goto L16;
        r102.setName(a(r103, "name"));
        r102.setDistrict(a(r103, DistrictSearchQuery.KEYWORDS_DISTRICT));
        r102.setAdcode(a(r103, "adcode"));
        r102.setID(a(r103, "id"));
        r102.setAddress(a(r103, "address"));
        r102.setTypeCode(a(r103, "typecode"));
        String r104 = a(r103, "location");
        if (TextUtils.isEmpty(r104) == true) goto L15;
        String[] r105 = r104.split(",");
        if (r105.length != 2) goto L15;
        r102.setPostion(new LatLonPoint(CastDoubleProtector.parseDouble(r105[1]), CastDoubleProtector.parseDouble(r105[0])));
    L15:
        r100.add(r102);
    L16:
        r101 = r101 + 1;
        goto L7
    L17:
        return r100;
    }

    public static ArrayList<RoutePOIItem> i(JSONObject r100) throws JSONException {
        ArrayList<RoutePOIItem> r101 = new ArrayList();
        Object r102 = r100.opt("pois");
        if ((r102 instanceof JSONArray) == false) goto L18;
        JSONArray r103 = r100.optJSONArray("pois");
        if (r103 != null) goto L7;
    L16:
        return r101;
    L7:
        if (r103.length() == 0) goto L16;
        int r104 = 0;
    L11:
        if (r104 >= r103.length()) goto L20;
        JSONObject r105 = r103.optJSONObject(r104);
        if (r105 == null) goto L15;
        r101.add(y(r105));
    L15:
        r104 = r104 + 1;
    L20:
        return r101;
    L18:
        if ((r102 instanceof JSONObject) == false) goto L20;
        r101.add(y(((JSONObject) r102).optJSONObject(AppletNaviType.POI)));
        goto L20
    }

    private static SubPoiItem j(JSONObject r100) throws JSONException {
        SubPoiItem r101 = new SubPoiItem(a(r100, "id"), b(r100, "location"), a(r100, "name"), a(r100, "address"));
        r101.setSubName(a(r100, "sname"));
        r101.setSubTypeDes(a(r100, PushAction$ESubType.KEY_NAME));
        if (r100.has("distance") == false) goto L12;
        String r102 = a(r100, "distance");
        if (f(r102) == true) goto L12;
        r101.setDistance((int) CastFloatProtector.parseFloat(r102));     // Catch: Exception -> L8 NumberFormatException -> L10
    L10:
        e = move-exception;
        i.a(e, "JSONHelper", "parseSubPoiItem");
    L8:
        e = move-exception;
        i.a(e, "JSONHelper", "parseSubPoiItem");
    L12:
        return r101;
    }

    private static boolean k(String r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.length() <= 0) goto L14;
        String[] r101 = f26604a;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        String r104 = r101[r103];
        if (r100.trim().equals(r104.trim()) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    }

    private static ArrayList<LatLonPoint> l(String r100) {
        ArrayList<LatLonPoint> r101 = new ArrayList();
        String[] r102 = r100.split(com.alipay.sdk.m.u.i.f25853b);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L6;
        r101.add(m(r102[r103]));
        r103 = r103 + 1;
        goto L4
    L6:
        return r101;
    }

    private static LatLonPoint m(String r100) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (r100.equals("") == true) goto L14;
        if (r100.equals("[]") == true) goto L14;
        String[] r101 = r100.split(",| ");
        if (r101.length == 2) goto L12;
        return null;
    L12:
        double r102 = CastDoubleProtector.parseDouble(r101[0]);
        return new LatLonPoint(CastDoubleProtector.parseDouble(r101[1]), r102);
    }

    private static int n(String r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.equals("") == false) goto L7;
        return 0;
    L7:
        if (r100.equals("[]") == true) goto L18;
        return CastIntegerProtector.parseInt(r100);
    L11:
        e = move-exception;
        i.a(e, "JSONHelper", "str2int");
        return 0;
    L18:
        return 0;
    }

    private static float o(String r100) {
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        if (r100.equals("") == false) goto L7;
        return 0.0f;
    L7:
        if (r100.equals("[]") == true) goto L18;
        return CastFloatProtector.parseFloat(r100);
    L11:
        e = move-exception;
        i.a(e, "JSONHelper", "str2float");
        return 0.0f;
    L18:
        return 0.0f;
    }

    private static double p(String r100) {
        if (r100 != null) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (r100.equals("") == false) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        if (r100.equals("[]") == true) goto L18;
        return CastDoubleProtector.parseDouble(r100);
    L11:
        e = move-exception;
        i.a(e, "JSONHelper", "str2float");
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L18:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private static Doorway q(JSONObject r100) throws JSONException {
        Doorway r101 = new Doorway();
        r101.setName(a(r100, "name"));
        r101.setLatLonPoint(b(r100, "location"));
        return r101;
    }

    private static boolean r(String r100) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if (r100.equals("") == true) goto L15;
        if (r100.equals("[]") == true) goto L15;
        if (r100.equals("0") == true) goto L15;
        if (r100.equals("1") == false) goto L15;
        return true;
    }

    public static ArrayList<SuggestionCity> a(JSONObject r100) throws JSONException, NumberFormatException {
        ArrayList<SuggestionCity> r101 = new ArrayList();
        if (r100.has("cities") == true) goto L5;
        return r101;
    L5:
        JSONArray r102 = r100.optJSONArray("cities");
        if (r102 != null) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L15;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L14;
        r101.add(new SuggestionCity(a(r104, "name"), a(r104, "citycode"), a(r104, "adcode"), n(a(r104, "num"))));
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r101;
    }

    public static void a(JSONObject r100, RegeocodeAddress r101) throws JSONException {
        r101.setCountry(a(r100, DistrictSearchQuery.KEYWORDS_COUNTRY));
        r101.setCountryCode(a(r100, "countrycode"));
        r101.setProvince(a(r100, "province"));
        r101.setCity(a(r100, "city"));
        r101.setCityCode(a(r100, "citycode"));
        r101.setAdCode(a(r100, "adcode"));
        r101.setDistrict(a(r100, DistrictSearchQuery.KEYWORDS_DISTRICT));
        r101.setTownship(a(r100, "township"));
        r101.setNeighborhood(a(r100.optJSONObject("neighborhood"), "name"));
        r101.setBuilding(a(r100.optJSONObject(LocationConstants$NameType.BUILDING), "name"));
        StreetNumber r102 = new StreetNumber();
        JSONObject r103 = r100.optJSONObject("streetNumber");
        r102.setStreet(a(r103, "street"));
        r102.setNumber(a(r103, "number"));
        r102.setLatLonPoint(b(r103, "location"));
        r102.setDirection(a(r103, "direction"));
        r102.setDistance(o(a(r103, "distance")));
        r101.setStreetNumber(r102);
        ArrayList r104 = new ArrayList();
        JSONArray r105 = r100.optJSONArray("businessAreas");
        if (r105 != null) goto L5;
    L14:
        r101.setBusinessAreas(r104);
        r101.setTowncode(a(r100, "towncode"));
        if (r101.getCity() == null) goto L19;
        if (r101.getCity().length() <= 0) goto L19;
        return;
    L19:
        if (k(r101.getCityCode()) == false) goto L26;
        r101.setCity(r101.getProvince());
        return;
    L26:
        return;
    L5:
        if (r105.length() == 0) goto L14;
        int r106 = 0;
    L9:
        if (r106 >= r105.length()) goto L14;
        BusinessArea r107 = new BusinessArea();
        JSONObject r108 = r105.optJSONObject(r106);
        if (r108 == null) goto L13;
        r107.setCenterPoint(b(r108, "location"));
        r107.setName(a(r108, "name"));
        r104.add(r107);
    L13:
        r106 = r106 + 1;
        goto L9
    }

    private static void b(TruckStep r100, JSONObject r101) throws AMapException {
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L14
        JSONArray r103 = r101.optJSONArray("tmcs");     // Catch: JSONException -> L14
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = 0;
    L7:
        if (r104 >= r103.length()) goto L12;
        TMC r105 = new TMC();     // Catch: JSONException -> L14
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: JSONException -> L14
        if (r106 == null) goto L11;
        r105.setDistance(n(a(r106, "distance")));     // Catch: JSONException -> L14
        r105.setStatus(a(r106, "status"));     // Catch: JSONException -> L14
        r105.setPolyline(c(r106, SVGRenderEngine.POLYLINE));     // Catch: JSONException -> L14
        r102.add(r105);     // Catch: JSONException -> L14
    L11:
        r104 = r104 + 1;     // Catch: JSONException -> L14
        goto L7
    L12:
        r100.setTMCs(r102);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        i.a(e, "JSONHelper", "parseTMCs");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    public static void c(JSONArray r100, RegeocodeAddress r101) throws JSONException {
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L9;
        AoiItem r104 = new AoiItem();
        JSONObject r105 = r100.optJSONObject(r103);
        if (r105 == null) goto L8;
        r104.setId(a(r105, "id"));
        r104.setName(a(r105, "name"));
        r104.setAdcode(a(r105, "adcode"));
        r104.setLocation(b(r105, "location"));
        r104.setArea(Float.valueOf(o(a(r105, "area"))));
        r102.add(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        r101.setAois(r102);
    }

    public static ArrayList<NearbyInfo> a(JSONObject r110, boolean r111) throws JSONException {
        JSONArray r112 = r110.optJSONArray("datas");
        if (r112 == null) goto L22;
        if (r112.length() == 0) goto L22;
        ArrayList<NearbyInfo> r100 = new ArrayList();
        int r101 = r112.length();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L20;
        JSONObject r103 = r112.optJSONObject(r102);
        String r104 = a(r103, "userid");
        String r105 = a(r103, "location");
        if (r105 == null) goto L14;
        String[] r106 = r105.split(",");
        if (r106.length != 2) goto L14;
        double r107 = p(r106[0]);
        double r108 = p(r106[1]);
    L15:
        String r109 = a(r103, "distance");
        long r113 = q(a(r103, EffectConstants.KEY_EFFECT_UPDATE_TIME));
        int r114 = n(r109);
        LatLonPoint r115 = new LatLonPoint(r108, r107);
        NearbyInfo r116 = new NearbyInfo();
        r116.setUserID(r104);
        r116.setTimeStamp(r113);
        r116.setPoint(r115);
        if (r111 == false) goto L18;
        r116.setDrivingDistance(r114);
    L19:
        r100.add(r116);
        r102 = r102 + 1;
        goto L8
    L18:
        r116.setDistance(r114);
    L14:
        r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
        r108 = 0.0d;
        goto L15
    L20:
        return r100;
    L22:
        return new ArrayList();
    }

    private static void b(DriveStep r100, JSONObject r101) throws AMapException {
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L14
        JSONArray r103 = r101.optJSONArray("cities");     // Catch: JSONException -> L14
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = 0;
    L7:
        if (r104 >= r103.length()) goto L12;
        RouteSearchCity r105 = new RouteSearchCity();     // Catch: JSONException -> L14
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: JSONException -> L14
        if (r106 == null) goto L11;
        r105.setSearchCityName(a(r106, "name"));     // Catch: JSONException -> L14
        r105.setSearchCitycode(a(r106, "citycode"));     // Catch: JSONException -> L14
        r105.setSearchCityhAdCode(a(r106, "adcode"));     // Catch: JSONException -> L14
        a(r105, r106);     // Catch: JSONException -> L14
        r102.add(r105);     // Catch: JSONException -> L14
    L11:
        r104 = r104 + 1;     // Catch: JSONException -> L14
        goto L7
    L12:
        r100.setRouteSearchCityList(r102);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        i.a(e, "JSONHelper", "parseCrossCity");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    private static void c(Path r100, List<RideStep> r101) {
        List<LatLonPoint> r102 = r100.getPolyline();
        if (r102 != null) goto L5;
        r102 = new ArrayList();
    L5:
        Iterator<RideStep> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        RideStep r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.getPolyline() == null) goto L7;
        r102.addAll(r104.getPolyline());
        goto L7
    L13:
        r100.setPolyline(r102);
    }

    public static void a(JSONArray r100, RegeocodeAddress r101) throws JSONException {
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L9;
        Crossroad r104 = new Crossroad();
        JSONObject r105 = r100.optJSONObject(r103);
        if (r105 == null) goto L8;
        r104.setId(a(r105, "id"));
        r104.setDirection(a(r105, "direction"));
        r104.setDistance(o(a(r105, "distance")));
        r104.setCenterPoint(b(r105, "location"));
        r104.setFirstRoadId(a(r105, "first_id"));
        r104.setFirstRoadName(a(r105, "first_name"));
        r104.setSecondRoadId(a(r105, "second_id"));
        r104.setSecondRoadName(a(r105, "second_name"));
        r102.add(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        r101.setCrossroads(r102);
    }

    public static void b(JSONArray r100, RegeocodeAddress r101) throws JSONException {
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L9;
        RegeocodeRoad r104 = new RegeocodeRoad();
        JSONObject r105 = r100.optJSONObject(r103);
        if (r105 == null) goto L8;
        r104.setId(a(r105, "id"));
        r104.setName(a(r105, "name"));
        r104.setLatLngPoint(b(r105, "location"));
        r104.setDirection(a(r105, "direction"));
        r104.setDistance(o(a(r105, "distance")));
        r102.add(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        r101.setRoads(r102);
    }

    private static ArrayList<LatLonPoint> c(JSONObject r100, String r101) throws JSONException {
        if (r100.has(r101) == true) goto L5;
        return null;
    L5:
        return l(r100.optString(r101));
    }

    private static void a(DriveStep r100, JSONObject r101) throws AMapException {
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L14
        JSONArray r103 = r101.optJSONArray("tmcs");     // Catch: JSONException -> L14
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = 0;
    L7:
        if (r104 >= r103.length()) goto L12;
        TMC r105 = new TMC();     // Catch: JSONException -> L14
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: JSONException -> L14
        if (r106 == null) goto L11;
        r105.setDistance(n(a(r106, "distance")));     // Catch: JSONException -> L14
        r105.setStatus(a(r106, "status"));     // Catch: JSONException -> L14
        r105.setPolyline(c(r106, SVGRenderEngine.POLYLINE));     // Catch: JSONException -> L14
        r102.add(r105);     // Catch: JSONException -> L14
    L11:
        r104 = r104 + 1;     // Catch: JSONException -> L14
        goto L7
    L12:
        r100.setTMCs(r102);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        i.a(e, "JSONHelper", "parseTMCs");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    private static void b(Path r100, List<DriveStep> r101) {
        List<LatLonPoint> r102 = r100.getPolyline();
        if (r102 != null) goto L5;
        r102 = new ArrayList();
    L5:
        Iterator<DriveStep> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        DriveStep r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.getPolyline() == null) goto L7;
        r102.addAll(r104.getPolyline());
        goto L7
    L13:
        r100.setPolyline(r102);
    }

    private static void a(TruckStep r100, JSONObject r101) throws AMapException {
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L14
        JSONArray r103 = r101.optJSONArray("cities");     // Catch: JSONException -> L14
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = 0;
    L7:
        if (r104 >= r103.length()) goto L12;
        RouteSearchCity r105 = new RouteSearchCity();     // Catch: JSONException -> L14
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: JSONException -> L14
        if (r106 == null) goto L11;
        r105.setSearchCityName(a(r106, "name"));     // Catch: JSONException -> L14
        r105.setSearchCitycode(a(r106, "citycode"));     // Catch: JSONException -> L14
        r105.setSearchCityhAdCode(a(r106, "adcode"));     // Catch: JSONException -> L14
        a(r105, r106);     // Catch: JSONException -> L14
        r102.add(r105);     // Catch: JSONException -> L14
    L11:
        r104 = r104 + 1;     // Catch: JSONException -> L14
        goto L7
    L12:
        r100.setRouteSearchCityList(r102);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        i.a(e, "JSONHelper", "parseCrossCity");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    private static LatLonPoint b(JSONObject r100, String r101) throws JSONException {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.has(r101) == true) goto L8;
        return null;
    L8:
        return m(r100.optString(r101));
    }

    private static void a(RouteSearchCity r100, JSONObject r101) throws AMapException {
        if (r101.has("districts") == true) goto L21;
        return;
    L21:
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L18
        JSONArray r103 = r101.optJSONArray("districts");     // Catch: JSONException -> L18
        if (r103 != null) goto L9;
        r100.setDistricts(r102);     // Catch: JSONException -> L18
        return;
    L9:
        int r104 = 0;
    L11:
        if (r104 >= r103.length()) goto L16;
        District r105 = new District();     // Catch: JSONException -> L18
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: JSONException -> L18
        if (r106 == null) goto L15;
        r105.setDistrictName(a(r106, "name"));     // Catch: JSONException -> L18
        r105.setDistrictAdcode(a(r106, "adcode"));     // Catch: JSONException -> L18
        r102.add(r105);     // Catch: JSONException -> L18
    L15:
        r104 = r104 + 1;     // Catch: JSONException -> L18
        goto L11
    L16:
        r100.setDistricts(r102);     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        i.a(e, "JSONHelper", "parseCrossDistricts");
        throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
    }

    private static void a(Path r100, List<WalkStep> r101) {
        List<LatLonPoint> r102 = r100.getPolyline();
        if (r102 != null) goto L5;
        r102 = new ArrayList();
    L5:
        Iterator<WalkStep> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        WalkStep r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.getPolyline() == null) goto L7;
        r102.addAll(r104.getPolyline());
        goto L7
    L13:
        r100.setPolyline(r102);
    }

    public static String a(JSONObject r100, String r101) throws JSONException {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.has(r101) == true) goto L8;
        return "";
    L8:
        if (r100.optString(r101).equals("[]") == false) goto L10;
        return "";
    L10:
        return r100.optString(r101).trim();
    }

    public static void a(JSONArray r100, ArrayList<DistrictItem> r101, DistrictItem r102) throws JSONException {
        if (r100 != null) goto L4;
        return;
    L4:
        int r103 = 0;
    L6:
        if (r103 >= r100.length()) goto L18;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 == null) goto L17;
        DistrictItem r105 = new DistrictItem();
        r105.setCitycode(a(r104, "citycode"));
        r105.setAdcode(a(r104, "adcode"));
        r105.setName(a(r104, "name"));
        r105.setLevel(a(r104, "level"));
        r105.setCenter(b(r104, "center"));
        if (r104.has(SVGRenderEngine.POLYLINE) == false) goto L16;
        String r106 = r104.optString(SVGRenderEngine.POLYLINE);
        if (r106 == null) goto L16;
        if (r106.length() <= 0) goto L16;
        r105.setDistrictBoundary(r106.split("\\|"));
    L16:
        a(r104.optJSONArray("districts"), new ArrayList(), r105);
        r101.add(r105);
    L17:
        r103 = r103 + 1;
        goto L6
    L18:
        if (r102 == null) goto L24;
        r102.setSubDistrict(r101);
        return;
    }
}
