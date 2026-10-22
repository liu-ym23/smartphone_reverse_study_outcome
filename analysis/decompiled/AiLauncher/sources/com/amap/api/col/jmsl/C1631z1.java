package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.Classify;
import com.amap.api.services.auto.ListData;
import com.amap.api.services.auto.Lqii;
import com.amap.api.services.auto.Meta;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.speech.model.ErrorModel;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.z1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1631z1 {

    /* renamed from: a, reason: collision with root package name */
    public static C1558h f17070a;

    public static double a(double d10) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d10));
    }

    public static float b(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint != null && latLonPoint2 != null) {
            try {
                double longitude = latLonPoint.getLongitude();
                double d10 = longitude * 0.01745329251994329d;
                double latitude = latLonPoint.getLatitude() * 0.01745329251994329d;
                double longitude2 = latLonPoint2.getLongitude() * 0.01745329251994329d;
                double latitude2 = latLonPoint2.getLatitude() * 0.01745329251994329d;
                double dSin = Math.sin(d10);
                double dSin2 = Math.sin(latitude);
                double dCos = Math.cos(d10);
                double dCos2 = Math.cos(latitude);
                double dSin3 = Math.sin(longitude2);
                double dSin4 = Math.sin(latitude2);
                double dCos3 = Math.cos(longitude2);
                double dCos4 = Math.cos(latitude2);
                double[] dArr = {dCos * dCos2, dCos2 * dSin, dSin2};
                double[] dArr2 = {dCos3 * dCos4, dCos4 * dSin3, dSin4};
                double d11 = dArr[0];
                double d12 = dArr2[0];
                double d13 = (d11 - d12) * (d11 - d12);
                double d14 = dArr[1];
                double d15 = dArr2[1];
                double d16 = d13 + ((d14 - d15) * (d14 - d15));
                double d17 = dArr[2];
                double d18 = dArr2[2];
                return (float) (Math.asin(Math.sqrt(d16 + ((d17 - d18) * (d17 - d18))) / 2.0d) * 1.27420015798544E7d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0.0f;
    }

    public static Classify c(JSONObject jSONObject) {
        Classify.ItermData itermData;
        Classify.CheckedValue checkedValue;
        Classify.RetainState retainState = null;
        if (jSONObject == null) {
            return null;
        }
        Classify classify = new Classify();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("item_data");
        if (jSONObjectOptJSONObject == null) {
            itermData = null;
        } else {
            itermData = new Classify.ItermData();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("checked_nodes");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(0);
                    if (jSONObjectOptJSONObject2 != null) {
                        Classify.CheckedNode checkedNode = new Classify.CheckedNode();
                        checkedNode.id = jSONObjectOptJSONObject2.optString("id");
                        checkedNode.value = jSONObjectOptJSONObject2.optString(UxipConstants.f30680s);
                        checkedNode.name = jSONObjectOptJSONObject2.optString("name");
                        arrayList.add(checkedNode);
                    }
                }
            }
            itermData.checkedNodes = arrayList;
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("checked_value");
            if (jSONObjectOptJSONObject3 == null) {
                checkedValue = null;
            } else {
                checkedValue = new Classify.CheckedValue();
                checkedValue.classifyV2Data = jSONObjectOptJSONObject3.optString("classify_v2_data");
                checkedValue.classifyV2Level2Data = jSONObjectOptJSONObject3.optString("classify_v2_level2_data");
                checkedValue.classifyV2Level3Data = jSONObjectOptJSONObject3.optString("classify_v2_level3_data");
            }
            itermData.checkedValue = checkedValue;
            itermData.datas = j(jSONObjectOptJSONObject.optJSONArray("data"));
            itermData.defaultPositionDatas = j(jSONObjectOptJSONObject.optJSONArray("default_position_data"));
            itermData.level2Datas = j(jSONObjectOptJSONObject.optJSONArray("level2_data"));
        }
        classify.itermData = itermData;
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("retain_state");
        if (jSONObjectOptJSONObject4 != null) {
            retainState = new Classify.RetainState();
            retainState.classifyBusinessType = jSONObjectOptJSONObject4.optString("classify_business_type");
            retainState.classifyConf = jSONObjectOptJSONObject4.optString("classify_conf");
            retainState.classifyRetainLevel2 = jSONObjectOptJSONObject4.optString("classify_retain_level2");
            retainState.level2All = jSONObjectOptJSONObject4.optString("level2_all");
            retainState.newClassifyCityadcode = jSONObjectOptJSONObject4.optString("new_classify_cityadcode");
            retainState.newClassifyFlag = jSONObjectOptJSONObject4.optString("new_classify_flag");
        }
        classify.retainState = retainState;
        return classify;
    }

    public static String d(int i10) {
        StringBuilder sb2 = new StringBuilder();
        if ((i10 & 1) != 0) {
            sb2.append("cost,");
        }
        if ((i10 & 2) != 0) {
            sb2.append("tmcs,");
        }
        if ((i10 & 4) != 0) {
            sb2.append("navi,");
        }
        if ((i10 & 8) != 0) {
            sb2.append("cities,");
        }
        if ((i10 & 16) != 0) {
            sb2.append("polyline,");
        }
        if ((i10 & 32) != 0) {
            sb2.append("elec_consume_info,");
        }
        if ((i10 & 64) != 0) {
            sb2.append("charge_station_info,");
        }
        sb2.replace(sb2.length() - 1, sb2.length(), "");
        return sb2.toString();
    }

    public static String e(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        return a(latLonPoint.getLongitude()) + Const.STR_MART_COMMA + a(latLonPoint.getLatitude());
    }

    public static String f(String str, long j10, boolean z10) {
        try {
            return Const.STR_MART_JSON_BEGIN + "\"RequestPath\":\"" + str + "\"" + Const.STR_MART_COMMA + "\"ResponseTime\":" + j10 + Const.STR_MART_COMMA + "\"Success\":" + z10 + "}";
        } catch (Throwable th) {
            o(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static String g(String str, boolean z10) {
        String strSubstring;
        try {
            int iIndexOf = str.indexOf("?");
            int length = str.length();
            strSubstring = "";
            if (iIndexOf > 0) {
                String strSubstring2 = str.substring(0, iIndexOf);
                int i10 = iIndexOf + 1;
                strSubstring = i10 < length ? str.substring(i10) : "";
                str = strSubstring2;
            }
            return Const.STR_MART_JSON_BEGIN + "\"RequestPath\":\"" + str + "\"" + Const.STR_MART_COMMA + "\"RequestParm\":\"" + strSubstring + "\"" + Const.STR_MART_COMMA + "\"IsCacheRequest\":" + z10 + "}";
        } catch (Throwable th) {
            o(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static String h(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static String i(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < list.size(); i10++) {
            LatLonPoint latLonPoint = list.get(i10);
            if (latLonPoint != null) {
                double dA = a(latLonPoint.getLongitude());
                double dA2 = a(latLonPoint.getLatitude());
                stringBuffer.append(dA);
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(dA2);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static List<Classify.Data> j(JSONArray jSONArray) {
        int i10;
        ArrayList arrayList;
        int i11;
        String str;
        JSONArray jSONArray2;
        int i12;
        ArrayList arrayList2;
        JSONObject jSONObject;
        Classify.Data data;
        ArrayList arrayList3;
        JSONArray jSONArray3;
        int i13;
        JSONArray jSONArray4 = jSONArray;
        ArrayList arrayList4 = new ArrayList();
        if (jSONArray4 != null) {
            int i14 = 0;
            while (i14 < jSONArray4.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArray4.optJSONObject(i14);
                if (jSONObjectOptJSONObject == null) {
                    arrayList = arrayList4;
                    i10 = i14;
                } else {
                    Classify.Data data2 = new Classify.Data();
                    String str2 = QueryAlgorithmBundle.KEY_CATEGORY;
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(QueryAlgorithmBundle.KEY_CATEGORY);
                    ArrayList arrayList5 = new ArrayList();
                    if (jSONArrayOptJSONArray != null) {
                        int i15 = 0;
                        while (i15 < jSONArrayOptJSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i15);
                            if (jSONObjectOptJSONObject2 == null) {
                                arrayList2 = arrayList4;
                                i11 = i14;
                                jSONObject = jSONObjectOptJSONObject;
                                data = data2;
                                str = str2;
                                jSONArray2 = jSONArrayOptJSONArray;
                                arrayList3 = arrayList5;
                                i12 = i15;
                            } else {
                                Classify.DataCategory dataCategory = new Classify.DataCategory();
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray(str2);
                                i11 = i14;
                                ArrayList arrayList6 = new ArrayList();
                                str = str2;
                                jSONArray2 = jSONArrayOptJSONArray;
                                i12 = i15;
                                arrayList2 = arrayList4;
                                jSONObject = jSONObjectOptJSONObject;
                                data = data2;
                                ArrayList arrayList7 = arrayList5;
                                if (jSONArrayOptJSONArray2 != null) {
                                    int i16 = 0;
                                    while (i16 < jSONArrayOptJSONArray2.length()) {
                                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i16);
                                        if (jSONObjectOptJSONObject3 == null) {
                                            jSONArray3 = jSONArrayOptJSONArray2;
                                            i13 = i16;
                                        } else {
                                            jSONArray3 = jSONArrayOptJSONArray2;
                                            Classify.Category category = new Classify.Category();
                                            i13 = i16;
                                            category.checked = jSONObjectOptJSONObject3.optInt("checked");
                                            category.componentType = jSONObjectOptJSONObject3.optString("component_type");
                                            category.defaultValue = jSONObjectOptJSONObject3.optInt("default");
                                            category.name = jSONObjectOptJSONObject3.optString("name");
                                            category.value = jSONObjectOptJSONObject3.optString(UxipConstants.f30680s);
                                            category.classifyItemType = jSONObjectOptJSONObject3.optString("classify_item_type");
                                            category.img = jSONObjectOptJSONObject3.optString("img");
                                            category.showType = jSONObjectOptJSONObject3.optString("show_type");
                                            category.params = jSONObjectOptJSONObject3.optString("params");
                                            arrayList6.add(category);
                                        }
                                        i16 = i13 + 1;
                                        jSONArrayOptJSONArray2 = jSONArray3;
                                    }
                                }
                                dataCategory.categories = arrayList6;
                                dataCategory.checked = jSONObjectOptJSONObject2.optInt("checked");
                                dataCategory.defaultValue = jSONObjectOptJSONObject2.optInt("default");
                                dataCategory.componentType = jSONObjectOptJSONObject2.optString("component_type");
                                dataCategory.name = jSONObjectOptJSONObject2.optString("name");
                                dataCategory.params = jSONObjectOptJSONObject2.optString("params");
                                dataCategory.areaSubwayMark = jSONObjectOptJSONObject2.optInt("area_subway_mark");
                                dataCategory.hideTitle = jSONObjectOptJSONObject2.optInt("hide_title");
                                dataCategory.maxShowNum = jSONObjectOptJSONObject2.optInt("max_show_num");
                                dataCategory.maxShowNumRow = jSONObjectOptJSONObject2.optInt("max_show_num_row");
                                dataCategory.multiSelect = jSONObjectOptJSONObject2.optInt("multi_select");
                                dataCategory.img = jSONObjectOptJSONObject2.optString("img");
                                dataCategory.showType = jSONObjectOptJSONObject2.optString("show_type");
                                dataCategory.value = jSONObjectOptJSONObject2.optString(UxipConstants.f30680s);
                                dataCategory.classifyItemType = jSONObjectOptJSONObject2.optString("classify_item_type");
                                arrayList3 = arrayList7;
                                arrayList3.add(dataCategory);
                            }
                            i15 = i12 + 1;
                            arrayList5 = arrayList3;
                            i14 = i11;
                            str2 = str;
                            jSONArrayOptJSONArray = jSONArray2;
                            arrayList4 = arrayList2;
                            jSONObjectOptJSONObject = jSONObject;
                            data2 = data;
                        }
                    }
                    ArrayList arrayList8 = arrayList4;
                    i10 = i14;
                    JSONObject jSONObject2 = jSONObjectOptJSONObject;
                    Classify.Data data3 = data2;
                    data3.categories = arrayList5;
                    data3.checked = jSONObject2.optInt("checked");
                    data3.classifyItemType = jSONObject2.optString("classify_item_type");
                    data3.isCancelDefaultSelect = jSONObject2.optInt("is_cancel_default_select");
                    data3.isNoBtn = jSONObject2.optInt("is_no_btn");
                    data3.name = jSONObject2.optString("name");
                    data3.params = jSONObject2.optString("params");
                    data3.separator = jSONObject2.optString("separator");
                    data3.type = jSONObject2.optString("type");
                    data3.useCommonlyUsedConfig = jSONObject2.optInt("use_commonly_used_config");
                    data3.useLocalConfig = jSONObject2.optInt("use_local_config");
                    data3.useRemoteConfig = jSONObject2.optInt("use_remote_config");
                    data3.multiSelect = jSONObject2.optInt("multi_select");
                    arrayList = arrayList8;
                    arrayList.add(data3);
                }
                i14 = i10 + 1;
                arrayList4 = arrayList;
                jSONArray4 = jSONArray;
            }
        }
        return arrayList4;
    }

    public static void k(int i10, String str) throws JSONException, AMapException {
        if (i10 != 0) {
            if (i10 == 22000) {
                throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, str);
            }
            if (i10 == 32200) {
                throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, str);
            }
            if (i10 == 32201) {
                throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, str);
            }
            switch (i10) {
                case 10000:
                    return;
                case 10001:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, str);
                case 10002:
                    throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, str);
                case 10003:
                    throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, str);
                case 10004:
                    throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, str);
                case 10005:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, str);
                case 10006:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, str);
                case 10007:
                    throw new AMapException("用户签名未通过", 2, str);
                case 10008:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, str);
                case 10009:
                    throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, str);
                case 10010:
                    throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, str);
                case 10011:
                    throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, str);
                case 10012:
                    throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, str);
                case 10013:
                    throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, str);
                default:
                    switch (i10) {
                        case 20000:
                            throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, str);
                        case ErrorModel.Err_ASR /* 20001 */:
                            throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, str);
                        case ErrorModel.Err_ASR_EMPTY /* 20002 */:
                            throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, str);
                        case ErrorModel.Err_ASR_COMMIT_FAIL /* 20003 */:
                            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, str);
                        default:
                            switch (i10) {
                                case 20800:
                                    throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, str);
                                case 20801:
                                    throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, str);
                                case 20802:
                                    throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, str);
                                case 20803:
                                    throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, str);
                                default:
                                    switch (i10) {
                                        case Const.I_LOC_JUMP_DELAY /* 30000 */:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, str);
                                        case ErrorModel.Err_VAD /* 30001 */:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, str);
                                        case 30002:
                                            throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, str);
                                        case 30003:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, str);
                                        default:
                                            switch (i10) {
                                                case 32000:
                                                    throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, str);
                                                case 32001:
                                                    throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, str);
                                                case 32002:
                                                    throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, str);
                                                default:
                                                    if (!TextUtils.isEmpty(str) && i10 > 0) {
                                                        throw new AMapException(str, 2, str, i10);
                                                    }
                                                    throw new AMapException(str, 2, str);
                                            }
                                    }
                            }
                    }
            }
        }
    }

    public static void l(Context context, String str) {
        try {
            C1558h c1558h = new C1558h(context, "sea", "9.8.1", "Search-Init-Android");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adiu", S0.q(context));
            jSONObject.put("isOverSea", C1567j0.o() ? "1" : "0");
            jSONObject.put("type", "common");
            jSONObject.put("version", "9.8.1");
            jSONObject.put("className", str);
            c1558h.a(jSONObject.toString());
            C1594q.d(c1558h, context);
        } catch (Throwable th) {
            o(th, "StatisticsUtil", "recordInitAction");
        }
    }

    public static void m(Context context, String str, long j10, boolean z10) {
        try {
            String strF = f(str, j10, z10);
            if (strF != null && strF.length() >= 1) {
                if (f17070a == null) {
                    f17070a = new C1558h(context, "sea", "9.8.1", "O002");
                }
                f17070a.a(strF);
                C1594q.d(f17070a, context);
            }
        } catch (Throwable th) {
            o(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void n(Context context, String str, boolean z10) {
        try {
            String strG = g(str, z10);
            if (strG != null && strG.length() >= 1) {
                C1558h c1558h = new C1558h(context, "sea", "9.8.1", "O006");
                c1558h.a(strG);
                C1594q.d(c1558h, context);
            }
        } catch (Throwable th) {
            o(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void o(Throwable th, String str, String str2) {
        try {
            C1541c2 c1541c2D = C1541c2.d();
            if (c1541c2D != null) {
                c1541c2D.h(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean p(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static AutoTChargeStationResult q(JSONObject jSONObject) {
        Meta meta;
        AutoTChargeStationResult autoTChargeStationResult = new AutoTChargeStationResult();
        try {
            autoTChargeStationResult.code = jSONObject.optInt("code");
            autoTChargeStationResult.message = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                return autoTChargeStationResult;
            }
            autoTChargeStationResult.classify = c(jSONObjectOptJSONObject.optJSONObject("classify"));
            autoTChargeStationResult.listData = s(jSONObjectOptJSONObject.optJSONObject("list_data"));
            autoTChargeStationResult.lqii = u(jSONObjectOptJSONObject.optJSONObject("lqii"));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("meta");
            if (jSONObjectOptJSONObject2 == null) {
                meta = null;
            } else {
                Meta meta2 = new Meta();
                meta2.listBizType = jSONObjectOptJSONObject2.optString("list_biz_type");
                meta = meta2;
            }
            autoTChargeStationResult.meta = meta;
            autoTChargeStationResult.originJson = jSONObjectOptJSONObject.toString();
            return autoTChargeStationResult;
        } catch (Exception e10) {
            e10.printStackTrace();
            return autoTChargeStationResult;
        }
    }

    public static Date r(String str) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat("HHmm").parse(str);
            } catch (ParseException e10) {
                o(e10, "CoreUtil", "parseString2Time");
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ListData s(JSONObject jSONObject) {
        JSONArray jSONArray;
        ListData listData;
        int i10;
        ListData.BasicInfo basicInfo;
        JSONArray jSONArray2;
        int i11;
        int i12;
        ListData listData2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        int i13;
        ListData.PriceChargingPark priceChargingPark;
        JSONArray jSONArray5;
        int i14;
        int i15;
        JSONArray jSONArray6;
        ListData.ChargingInfo chargingInfo;
        ListData.BasicInfo basicInfo2 = null;
        if (jSONObject == null) {
            return null;
        }
        ListData listData3 = new ListData();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        while (i16 < jSONArrayOptJSONArray.length()) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i16);
            if (jSONObjectOptJSONObject == null) {
                jSONArray = jSONArrayOptJSONArray;
                listData = listData3;
                i10 = i16;
            } else {
                ListData.Content content = new ListData.Content();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject2 != null) {
                    ListData.Data data = new ListData.Data();
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("basic_info");
                    if (jSONObjectOptJSONObject3 == null) {
                        basicInfo = basicInfo2;
                    } else {
                        basicInfo = new ListData.BasicInfo();
                        basicInfo.adcode = jSONObjectOptJSONObject3.optString(Const.JSON_KEY_ADCODE);
                        basicInfo.address = jSONObjectOptJSONObject3.optString(Const.JSON_KEY_ADDRESS);
                        basicInfo.averagecost = jSONObjectOptJSONObject3.optString("averagecost");
                        basicInfo.buildingStatus = jSONObjectOptJSONObject3.optString("building_status");
                        basicInfo.businessArea = jSONObjectOptJSONObject3.optString("business_area");
                        basicInfo.childShortname = jSONObjectOptJSONObject3.optString("child_shortname");
                        basicInfo.childShortnameEn = jSONObjectOptJSONObject3.optString("child_shortname_en");
                        basicInfo.childtype = jSONObjectOptJSONObject3.optString("childtype");
                        basicInfo.citycode = jSONObjectOptJSONObject3.optString(Const.JSON_KEY_CITYCODE);
                        basicInfo.cname = jSONObjectOptJSONObject3.optString("cname");
                        basicInfo.dispName = jSONObjectOptJSONObject3.optString("disp_name");
                        basicInfo.distance = jSONObjectOptJSONObject3.optString("distance");
                        basicInfo.dname = jSONObjectOptJSONObject3.optString("dname");
                        basicInfo.eaddress = jSONObjectOptJSONObject3.optString("eaddress");
                        basicInfo.endPoiExtension = jSONObjectOptJSONObject3.optString("end_poi_extension");
                        basicInfo.fNona = jSONObjectOptJSONObject3.optString("f_nona");
                        basicInfo.hisMark = jSONObjectOptJSONObject3.optString("his_mark");
                        basicInfo.hotText = jSONObjectOptJSONObject3.optString("hot_text");
                        basicInfo.id = jSONObjectOptJSONObject3.optString("id");
                        basicInfo.industry = jSONObjectOptJSONObject3.optString("industry");
                        basicInfo.latitude = jSONObjectOptJSONObject3.optString(Parameters.LATITUDE);
                        basicInfo.longitude = jSONObjectOptJSONObject3.optString(Parameters.LONGITUDE);
                        basicInfo.name = jSONObjectOptJSONObject3.optString("name");
                        basicInfo.category = jSONObjectOptJSONObject3.optString(QueryAlgorithmBundle.KEY_CATEGORY);
                        ListData.NaviVisited naviVisited = new ListData.NaviVisited();
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("navi_visited");
                        if (jSONObjectOptJSONObject4 != null) {
                            naviVisited.randUnionMonthUv = jSONObjectOptJSONObject4.optString("rand_union_month_uv");
                        }
                        basicInfo.naviVisited = naviVisited;
                        basicInfo.numSpaceW = jSONObjectOptJSONObject3.optString("num_space_w");
                        basicInfo.numSpaceWF = jSONObjectOptJSONObject3.optString("num_space_w_f");
                        basicInfo.opentime2 = jSONObjectOptJSONObject3.optString("opentime2");
                        basicInfo.opentimeText = jSONObjectOptJSONObject3.optString("opentime_text");
                        basicInfo.parent = jSONObjectOptJSONObject3.optString("parent");
                        basicInfo.parentName = jSONObjectOptJSONObject3.optString("parent_name");
                        basicInfo.picInfo = jSONObjectOptJSONObject3.optString("pic_info");
                        basicInfo.rating = jSONObjectOptJSONObject3.optString("rating");
                        basicInfo.recommendFlag = jSONObjectOptJSONObject3.optString("recommend_flag");
                        basicInfo.reviewTotal = jSONObjectOptJSONObject3.optString("review_total");
                        basicInfo.sell = jSONObjectOptJSONObject3.optString("sell");
                        ListData.ShortReview shortReview = new ListData.ShortReview();
                        if (jSONObjectOptJSONObject3.optJSONObject("short_review") != null) {
                            basicInfo.shortReview = shortReview;
                        }
                        basicInfo.tel = jSONObjectOptJSONObject3.optString("tel");
                        basicInfo.towardsAngle = jSONObjectOptJSONObject3.optString("towards_angle");
                        basicInfo.typeCode = jSONObjectOptJSONObject3.optString("typecode");
                        basicInfo.updateFlag = jSONObjectOptJSONObject3.optString("update_flag");
                        basicInfo.xEntr = jSONObjectOptJSONObject3.optString("x_entr");
                        basicInfo.yEntr = jSONObjectOptJSONObject3.optString("y_entr");
                    }
                    data.basicInfo = basicInfo;
                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("charging_info");
                    if (jSONObjectOptJSONObject5 == null) {
                        jSONArray = jSONArrayOptJSONArray;
                        chargingInfo = basicInfo2;
                        listData = listData3;
                        i10 = i16;
                    } else {
                        ListData.ChargingInfo chargingInfo2 = new ListData.ChargingInfo();
                        chargingInfo2.brandDesc = jSONObjectOptJSONObject5.optString("brand_desc");
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject5.optJSONArray("charge_info");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            int i17 = 0;
                            while (i17 < jSONArrayOptJSONArray2.length()) {
                                JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray2.optJSONObject(i17);
                                if (jSONObjectOptJSONObject6 == null) {
                                    jSONArray2 = jSONArrayOptJSONArray;
                                    i11 = i17;
                                } else {
                                    jSONArray2 = jSONArrayOptJSONArray;
                                    ListData.ChargeInfo chargeInfo = new ListData.ChargeInfo();
                                    i11 = i17;
                                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject6.optJSONArray("plugs_info");
                                    if (jSONArrayOptJSONArray3 != null) {
                                        i12 = i16;
                                        ArrayList arrayList3 = new ArrayList();
                                        listData2 = listData3;
                                        jSONArray3 = jSONArrayOptJSONArray2;
                                        int i18 = 0;
                                        while (i18 < jSONArrayOptJSONArray3.length()) {
                                            JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i18);
                                            if (jSONObjectOptJSONObject7 == null) {
                                                jSONArray4 = jSONArrayOptJSONArray3;
                                                i13 = i18;
                                            } else {
                                                jSONArray4 = jSONArrayOptJSONArray3;
                                                ListData.PlugsInfo plugsInfo = new ListData.PlugsInfo();
                                                i13 = i18;
                                                plugsInfo.brandDesc = jSONObjectOptJSONObject7.optString("brand_desc");
                                                plugsInfo.fastcur = jSONObjectOptJSONObject7.optString("fastcur");
                                                plugsInfo.fastpower = jSONObjectOptJSONObject7.optString("fastpower");
                                                plugsInfo.fastvol = jSONObjectOptJSONObject7.optString("fastvol");
                                                arrayList3.add(plugsInfo);
                                            }
                                            i18 = i13 + 1;
                                            jSONArrayOptJSONArray3 = jSONArray4;
                                        }
                                        chargeInfo.plugsInfos = arrayList3;
                                        chargeInfo.plugsType = jSONObjectOptJSONObject6.optString("plugstype");
                                        arrayList2.add(chargeInfo);
                                    }
                                    i17 = i11 + 1;
                                    jSONArrayOptJSONArray = jSONArray2;
                                    i16 = i12;
                                    jSONArrayOptJSONArray2 = jSONArray3;
                                    listData3 = listData2;
                                }
                                listData2 = listData3;
                                i12 = i16;
                                jSONArray3 = jSONArrayOptJSONArray2;
                                i17 = i11 + 1;
                                jSONArrayOptJSONArray = jSONArray2;
                                i16 = i12;
                                jSONArrayOptJSONArray2 = jSONArray3;
                                listData3 = listData2;
                            }
                        }
                        jSONArray = jSONArrayOptJSONArray;
                        listData = listData3;
                        i10 = i16;
                        chargingInfo2.chargeInfo = arrayList2;
                        chargingInfo2.chargingRatingFlagTerm = jSONObjectOptJSONObject5.optString("charging_rating_flag_term");
                        chargingInfo2.creditZhima = jSONObjectOptJSONObject5.optString("credit_zhima");
                        chargingInfo2.cscf = jSONObjectOptJSONObject5.optString("cscf");
                        chargingInfo2.currentElePrice = jSONObjectOptJSONObject5.optString("current_ele_price");
                        chargingInfo2.currentSerPrice = jSONObjectOptJSONObject5.optString("current_ser_price");
                        chargingInfo2.deepRightsTag = jSONObjectOptJSONObject5.optString("deep_rights_tag");
                        chargingInfo2.latestCharge = jSONObjectOptJSONObject5.optString("latest_charge");
                        chargingInfo2.numFast = jSONObjectOptJSONObject5.optString("num_fast");
                        chargingInfo2.fastFree = jSONObjectOptJSONObject5.optString("fast_free");
                        chargingInfo2.numSlow = jSONObjectOptJSONObject5.optString("num_slow");
                        chargingInfo2.slowFree = jSONObjectOptJSONObject5.optString("slow_free");
                        chargingInfo2.superTotal = jSONObjectOptJSONObject5.optString("super_total");
                        chargingInfo2.superFree = jSONObjectOptJSONObject5.optString("super_free");
                        chargingInfo2.parkCategory = jSONObjectOptJSONObject5.optString("park_category");
                        chargingInfo2.parkingPriceSummary = jSONObjectOptJSONObject5.optString("parkingPriceSummary");
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject5.optJSONArray("price_charging_pack");
                        if (jSONArrayOptJSONArray4 == null) {
                            priceChargingPark = null;
                        } else {
                            priceChargingPark = new ListData.PriceChargingPark();
                            ArrayList arrayList4 = new ArrayList();
                            int i19 = 0;
                            while (i19 < jSONArrayOptJSONArray4.length()) {
                                JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray4.optJSONObject(i19);
                                if (jSONObjectOptJSONObject8 == null) {
                                    jSONArray5 = jSONArrayOptJSONArray4;
                                    i14 = i19;
                                } else {
                                    ListData.Park park = new ListData.Park();
                                    park.srcType = jSONObjectOptJSONObject8.optString("src_type");
                                    JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject8.optJSONArray("price_charging");
                                    if (jSONArrayOptJSONArray5 != null) {
                                        ArrayList arrayList5 = new ArrayList();
                                        jSONArray5 = jSONArrayOptJSONArray4;
                                        int i20 = 0;
                                        while (i20 < jSONArrayOptJSONArray5.length()) {
                                            JSONObject jSONObjectOptJSONObject9 = jSONArrayOptJSONArray5.optJSONObject(i20);
                                            if (jSONObjectOptJSONObject9 == null) {
                                                i15 = i19;
                                                jSONArray6 = jSONArrayOptJSONArray5;
                                            } else {
                                                i15 = i19;
                                                ListData.PriceCharging priceCharging = new ListData.PriceCharging();
                                                jSONArray6 = jSONArrayOptJSONArray5;
                                                priceCharging.elePrice = jSONObjectOptJSONObject9.optString("ele_price");
                                                priceCharging.serPrice = jSONObjectOptJSONObject9.optString("ser_price");
                                                priceCharging.time = jSONObjectOptJSONObject9.optString("time");
                                                priceCharging.updatetime = jSONObjectOptJSONObject9.optInt("updatetime");
                                                arrayList5.add(priceCharging);
                                            }
                                            i20++;
                                            i19 = i15;
                                            jSONArrayOptJSONArray5 = jSONArray6;
                                        }
                                        i14 = i19;
                                        park.priceChargings = arrayList5;
                                    } else {
                                        jSONArray5 = jSONArrayOptJSONArray4;
                                        i14 = i19;
                                    }
                                    arrayList4.add(park);
                                }
                                i19 = i14 + 1;
                                jSONArrayOptJSONArray4 = jSONArray5;
                            }
                            priceChargingPark.parks = arrayList4;
                        }
                        chargingInfo2.priceChargingPark = priceChargingPark;
                        chargingInfo2.priceParkingStd = jSONObjectOptJSONObject5.optString("price_parking_std");
                        JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject5.optJSONObject("iddictionary");
                        chargingInfo = chargingInfo2;
                        if (jSONObjectOptJSONObject10 != null) {
                            HashMap<String, String> map = new HashMap<>();
                            Iterator<String> itKeys = jSONObjectOptJSONObject10.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                map.put(next, jSONObjectOptJSONObject10.optString(next));
                            }
                            chargingInfo2.idDictionary = map;
                            chargingInfo = chargingInfo2;
                        }
                    }
                    data.chargingInfo = chargingInfo;
                    JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject2.optJSONArray("labelInfos");
                    ArrayList arrayList6 = new ArrayList();
                    if (jSONArrayOptJSONArray6 != null) {
                        for (int i21 = 0; i21 < jSONArrayOptJSONArray6.length(); i21++) {
                            JSONObject jSONObjectOptJSONObject11 = jSONArrayOptJSONArray6.optJSONObject(i21);
                            if (jSONObjectOptJSONObject11 != null) {
                                ListData.LabelInfo labelInfo = new ListData.LabelInfo();
                                labelInfo.content = jSONObjectOptJSONObject11.optString(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
                                labelInfo.type = jSONObjectOptJSONObject11.optInt("type");
                                labelInfo.subType = jSONObjectOptJSONObject11.optInt("subType");
                                arrayList6.add(labelInfo);
                            }
                        }
                    }
                    data.labelInfos = arrayList6;
                    content.data = data;
                } else {
                    jSONArray = jSONArrayOptJSONArray;
                    listData = listData3;
                    i10 = i16;
                }
                content.itemType = jSONObjectOptJSONObject.optString("item_type");
                arrayList.add(content);
            }
            i16 = i10 + 1;
            jSONArrayOptJSONArray = jSONArray;
            listData3 = listData;
            basicInfo2 = null;
        }
        ListData listData4 = listData3;
        listData4.content = arrayList;
        return listData4;
    }

    public static Date t(String str) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat("HH:mm").parse(str);
            } catch (ParseException e10) {
                o(e10, "CoreUtil", "parseTime");
            }
        }
        return null;
    }

    public static Lqii u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Lqii lqii = new Lqii();
        lqii.categoryBrandRecognitionResult = jSONObject.optString("category_brand_recognition_result");
        lqii.changeQueryTip = jSONObject.optString("change_query_tip");
        lqii.expandRangeTip = jSONObject.optString("change_query_tip");
        lqii.isCurrentCity = jSONObject.optString("is_current_city");
        lqii.isUserCity = jSONObject.optString("is_user_city");
        lqii.queryCateResult = jSONObject.optString("query_cate_result");
        lqii.suggestContent = jSONObject.optString("suggestcontent");
        lqii.targetViewCity = jSONObject.optString("target_view_city");
        lqii.totalhits = jSONObject.optString("totalhits");
        lqii.viewRegion = jSONObject.optString("view_region");
        return lqii;
    }

    public static void v(String str) throws JSONException, AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                k(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (string.equals("1")) {
                    return;
                }
                if (string.equals("0") && !jSONObject.has("infocode")) {
                    throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                }
                int i10 = jSONObject.getInt("infocode");
                if (string.equals("0")) {
                    k(i10, jSONObject.getString("info"));
                }
            }
        } catch (JSONException e10) {
            o(e10, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void w(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                k(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status")) {
                if (jSONObject.optInt("status") == 0) {
                    if (!jSONObject.has("infocode")) {
                        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                    }
                    k(jSONObject.getInt("infocode"), jSONObject.getString("info"));
                }
                int iOptInt = jSONObject.optInt("code");
                if (iOptInt == 0) {
                    return;
                }
                String strOptString = jSONObject.optString("message");
                throw new AMapException(strOptString, 2, strOptString, Integer.parseInt("1" + iOptInt));
            }
        } catch (JSONException e10) {
            o(e10, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }
}
