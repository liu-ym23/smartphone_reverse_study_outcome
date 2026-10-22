package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DrivePlanStep;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TimeInfo;
import com.amap.api.services.route.TimeInfosElement;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1574l extends Q1<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public C1574l(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        String str2;
        JSONArray jSONArray;
        int i10;
        String str3;
        JSONArray jSONArray2;
        int i11;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        int i12;
        int i13;
        int i14;
        String str4 = "starttime";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                jSONObject.optInt("errcode");
                jSONObject.optString("errmsg");
                jSONObject.optString("errdetail");
            }
            if (!jSONObject.has("data")) {
                return null;
            }
            DriveRoutePlanResult driveRoutePlanResult = new DriveRoutePlanResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("paths") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) != null) {
                ArrayList arrayList = new ArrayList();
                int i15 = 0;
                while (i15 < jSONArrayOptJSONArray.length()) {
                    DrivePlanPath drivePlanPath = new DrivePlanPath();
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i15);
                    if (jSONObjectOptJSONObject2 == null) {
                        jSONArray4 = jSONArrayOptJSONArray;
                        i12 = i15;
                    } else {
                        drivePlanPath.setDistance(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject2, "distance")));
                        drivePlanPath.setTrafficLights(C1531a0.Y(C1531a0.D(jSONObjectOptJSONObject2, "traffic_lights")));
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("steps");
                        if (jSONArrayOptJSONArray3 == null) {
                            jSONArray4 = jSONArrayOptJSONArray;
                            i12 = i15;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            int i16 = 0;
                            while (i16 < jSONArrayOptJSONArray3.length()) {
                                DrivePlanStep drivePlanStep = new DrivePlanStep();
                                JSONArray jSONArray5 = jSONArrayOptJSONArray;
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i16);
                                if (jSONObjectOptJSONObject3 == null) {
                                    i13 = i16;
                                    i14 = i15;
                                } else {
                                    i13 = i16;
                                    drivePlanStep.setAdCode(C1531a0.D(jSONObjectOptJSONObject3, Const.JSON_KEY_ADCODE));
                                    drivePlanStep.setRoad(C1531a0.D(jSONObjectOptJSONObject3, Const.JSON_KEY_ROAD));
                                    drivePlanStep.setDistance(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject3, "distance")));
                                    i14 = i15;
                                    drivePlanStep.setToll(C1531a0.Y(C1531a0.D(jSONObjectOptJSONObject3, RouteSearch.DRIVING_EXCLUDE_TOLL)) == 1);
                                    drivePlanStep.setPolyline(C1531a0.x(jSONObjectOptJSONObject3, "polyline"));
                                    arrayList2.add(drivePlanStep);
                                }
                                i16 = i13 + 1;
                                jSONArrayOptJSONArray = jSONArray5;
                                i15 = i14;
                            }
                            jSONArray4 = jSONArrayOptJSONArray;
                            i12 = i15;
                            drivePlanPath.setSteps(arrayList2);
                            arrayList.add(drivePlanPath);
                        }
                    }
                    i15 = i12 + 1;
                    jSONArrayOptJSONArray = jSONArray4;
                }
                driveRoutePlanResult.setPaths(arrayList);
                if (jSONObjectOptJSONObject.has("time_infos") && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("time_infos")) != null) {
                    ArrayList arrayList3 = new ArrayList();
                    int i17 = 0;
                    while (i17 < jSONArrayOptJSONArray2.length()) {
                        TimeInfo timeInfo = new TimeInfo();
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i17);
                        if (jSONObjectOptJSONObject4 == null) {
                            str2 = str4;
                            jSONArray = jSONArrayOptJSONArray2;
                            i10 = i17;
                        } else if (jSONObjectOptJSONObject4.has(str4)) {
                            timeInfo.setStartTime(C1531a0.a0(C1531a0.D(jSONObjectOptJSONObject4, str4)));
                            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.optJSONArray("elements");
                            if (jSONArrayOptJSONArray4 == null) {
                                str2 = str4;
                                jSONArray = jSONArrayOptJSONArray2;
                                i10 = i17;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                int i18 = 0;
                                while (i18 < jSONArrayOptJSONArray4.length()) {
                                    TimeInfosElement timeInfosElement = new TimeInfosElement();
                                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(i18);
                                    if (jSONObjectOptJSONObject5 == null) {
                                        str3 = str4;
                                    } else {
                                        timeInfosElement.setPathindex(C1531a0.Y(C1531a0.D(jSONObjectOptJSONObject5, "pathindex")));
                                        timeInfosElement.setDuration(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject5, "duration")));
                                        timeInfosElement.setTolls(C1531a0.W(C1531a0.D(jSONObjectOptJSONObject5, "tolls")));
                                        int iY = C1531a0.Y(C1531a0.D(jSONObjectOptJSONObject5, "restriction"));
                                        str3 = str4;
                                        timeInfosElement.setRestriction((iY == 2 || iY == -1) ? 0 : 1);
                                        JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray("tmcs");
                                        if (jSONArrayOptJSONArray5 != null) {
                                            ArrayList arrayList5 = new ArrayList();
                                            jSONArray2 = jSONArrayOptJSONArray2;
                                            int i19 = 0;
                                            while (i19 < jSONArrayOptJSONArray5.length()) {
                                                TMC tmc = new TMC();
                                                int i20 = i17;
                                                JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray5.optJSONObject(i19);
                                                if (jSONObjectOptJSONObject6 == null) {
                                                    jSONArray3 = jSONArrayOptJSONArray5;
                                                } else {
                                                    jSONArray3 = jSONArrayOptJSONArray5;
                                                    tmc.setStatus(C1531a0.D(jSONObjectOptJSONObject6, "status"));
                                                    tmc.setDistance(C1531a0.Y(C1531a0.D(jSONObjectOptJSONObject6, "distance")));
                                                    tmc.setPolyline(C1531a0.x(jSONObjectOptJSONObject6, "polyline"));
                                                    arrayList5.add(tmc);
                                                }
                                                i19++;
                                                i17 = i20;
                                                jSONArrayOptJSONArray5 = jSONArray3;
                                            }
                                            i11 = i17;
                                            timeInfosElement.setTMCs(arrayList5);
                                            arrayList4.add(timeInfosElement);
                                            i18++;
                                            str4 = str3;
                                            jSONArrayOptJSONArray2 = jSONArray2;
                                            i17 = i11;
                                        }
                                    }
                                    jSONArray2 = jSONArrayOptJSONArray2;
                                    i11 = i17;
                                    i18++;
                                    str4 = str3;
                                    jSONArrayOptJSONArray2 = jSONArray2;
                                    i17 = i11;
                                }
                                str2 = str4;
                                jSONArray = jSONArrayOptJSONArray2;
                                i10 = i17;
                                timeInfo.setElements(arrayList4);
                                arrayList3.add(timeInfo);
                            }
                        }
                        i17 = i10 + 1;
                        str4 = str2;
                        jSONArrayOptJSONArray2 = jSONArray;
                    }
                    driveRoutePlanResult.setTimeInfos(arrayList3);
                    return driveRoutePlanResult;
                }
            }
            return driveRoutePlanResult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            C1631z1.o(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.d(this.f16099B) + "/etd/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        if (((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C1631z1.e(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getFrom()));
            if (!C1531a0.m(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C1631z1.e(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getTo()));
            if (!C1531a0.m(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getDestinationPoiID());
            }
            if (!C1531a0.m(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getOriginType());
            }
            if (!C1531a0.m(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getDestinationType());
            }
            if (!C1531a0.m(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getPlateProvince());
            }
            if (!C1531a0.m(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f16103z).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) this.f16103z).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f16103z).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f16103z).getMode());
        stringBuffer.append("&cartype=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f16103z).getCarType());
        stringBuffer.append("&firsttime=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f16103z).getFirstTime());
        stringBuffer.append("&interval=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f16103z).getInterval());
        stringBuffer.append("&count=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f16103z).getCount());
        return stringBuffer.toString();
    }
}
