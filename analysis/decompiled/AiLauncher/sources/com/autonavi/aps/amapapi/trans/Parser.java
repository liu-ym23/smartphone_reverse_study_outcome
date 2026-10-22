package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.C1577l2;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Parser {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f18404a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private AMapLocationClientOption f18405b = new AMapLocationClientOption();

    private void a(AMapLocationServer aMapLocationServer, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            if (this.f18405b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                if (!str2.equals(str)) {
                    sb2.append(str2);
                    sb2.append(" ");
                }
            } else if (!str.contains(Const.STR_KEY_WORD_CITY) || !str.equals(str2)) {
                sb2.append(str2);
                sb2.append(" ");
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append(str4);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb2.append(str5);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            if (TextUtils.isEmpty(str7) || this.f18405b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                sb2.append("Near " + str6);
                aMapLocationServer.setDescription("Near " + str6);
            } else {
                sb2.append("靠近");
                sb2.append(str6);
                sb2.append(" ");
                aMapLocationServer.setDescription("在" + str6 + "附近");
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(Const.JSON_KEY_CITYCODE, aMapLocationServer.getCityCode());
        bundle.putString(Const.JSON_KEY_DESC, sb2.toString());
        bundle.putString(Const.JSON_KEY_ADCODE, aMapLocationServer.getAdCode());
        aMapLocationServer.setExtras(bundle);
        aMapLocationServer.setDesc(sb2.toString());
        String adCode = aMapLocationServer.getAdCode();
        if (adCode == null || adCode.trim().length() <= 0 || this.f18405b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            aMapLocationServer.setAddress(sb2.toString());
        } else {
            aMapLocationServer.setAddress(sb2.toString().replace(" ", ""));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0292  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer parseBinaryResult(com.autonavi.aps.amapapi.model.AMapLocationServer r17, byte[] r18, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r19) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Parser.parseBinaryResult(com.autonavi.aps.amapapi.model.AMapLocationServer, byte[], com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public AMapLocationServer parseGeoJsonResult(String str) {
        String str2;
        String str3;
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("regeocode");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("addressComponent");
            aMapLocationServer.setCountry(a(jSONObjectOptJSONObject2.optString("country")));
            String strA = a(jSONObjectOptJSONObject2.optString("province"));
            aMapLocationServer.setProvince(strA);
            String strA2 = a(jSONObjectOptJSONObject2.optString(Const.JSON_KEY_CITYCODE));
            aMapLocationServer.setCityCode(strA2);
            String strOptString = jSONObjectOptJSONObject2.optString("city");
            if (!strA2.endsWith(Const.STR_CITY_CODE_BJ) && !strA2.endsWith(Const.STR_CITY_CODE_SH) && !strA2.endsWith(Const.STR_CITY_CODE_TJ) && !strA2.endsWith(Const.STR_CITY_CODE_CQ)) {
                strOptString = a(strOptString);
                aMapLocationServer.setCity(strOptString);
            } else if (strA != null && strA.length() > 0) {
                aMapLocationServer.setCity(strA);
                strOptString = strA;
            }
            if (TextUtils.isEmpty(strOptString)) {
                aMapLocationServer.setCity(strA);
                str2 = strA;
            } else {
                str2 = strOptString;
            }
            String strA3 = a(jSONObjectOptJSONObject2.optString("district"));
            aMapLocationServer.setDistrict(strA3);
            String strA4 = a(jSONObjectOptJSONObject2.optString(Const.JSON_KEY_ADCODE));
            aMapLocationServer.setAdCode(strA4);
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("streetNumber");
            String strA5 = a(jSONObjectOptJSONObject3.optString(Const.JSON_KEY_STREET));
            aMapLocationServer.setStreet(strA5);
            aMapLocationServer.setRoad(strA5);
            String strA6 = a(jSONObjectOptJSONObject3.optString(Const.JSON_KEY_NUMBER));
            aMapLocationServer.setNumber(strA6);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("pois");
            if (jSONArrayOptJSONArray.length() > 0) {
                String strA7 = a(jSONArrayOptJSONArray.getJSONObject(0).optString("name"));
                aMapLocationServer.setPoiName(strA7);
                str3 = strA7;
            } else {
                str3 = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("aois");
            if (jSONArrayOptJSONArray2.length() > 0) {
                aMapLocationServer.setAoiName(a(jSONArrayOptJSONArray2.getJSONObject(0).optString("name")));
            }
            a(aMapLocationServer, strA, str2, strA3, strA5, strA6, str3, strA4);
            return aMapLocationServer;
        } catch (Throwable unused) {
            return null;
        }
    }

    public AMapLocationServer paseAuthFailurJson(String str, Context context, C1577l2 c1577l2, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("#SHA1AndPackage#");
            stringBuffer.append(C1567j0.q(context));
            String str2 = c1577l2.f16720b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("#gsid#");
                stringBuffer.append(str2);
            }
            String str3 = c1577l2.f16721c;
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("#csid#" + str3);
            }
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                aMapLocationStaticsEntity.setReason("#0702");
                StringBuilder sb2 = this.f18404a;
                sb2.append("json is error:");
                sb2.append(str);
                sb2.append(stringBuffer);
                sb2.append("#0702");
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                aMapLocationStaticsEntity.setReason("#0701");
                StringBuilder sb3 = this.f18404a;
                sb3.append("auth fail:");
                sb3.append(string2);
                sb3.append(stringBuffer);
                sb3.append("#0701");
                ReportUtil.reportLocError(c1577l2.f16722d, string3, string2);
            }
        } catch (Throwable th) {
            aMapLocationStaticsEntity.setReason("#0703");
            StringBuilder sb4 = this.f18404a;
            sb4.append("json exception error:");
            sb4.append(th.getMessage());
            sb4.append(stringBuffer);
            sb4.append("#0703");
            CoreUtil.reportError(th, "parser", "paseAuthFailurJson");
        }
        aMapLocationServer.setLocationDetail(this.f18404a.toString());
        if (this.f18404a.length() > 0) {
            StringBuilder sb5 = this.f18404a;
            sb5.delete(0, sb5.length());
        }
        return aMapLocationServer;
    }

    public void setOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.f18405b = new AMapLocationClientOption();
        } else {
            this.f18405b = aMapLocationClientOption;
        }
    }

    private String a(String str) {
        return "[]".equals(str) ? "" : str;
    }
}
