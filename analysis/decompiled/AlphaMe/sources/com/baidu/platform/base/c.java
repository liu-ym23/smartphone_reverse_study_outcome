package com.baidu.platform.base;

import B0.g;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.room.AbstractC0351g;
import ch.qos.logback.classic.spi.CallerData;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: c, reason: collision with root package name */
    protected String f8579c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8577a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8578b = true;

    /* renamed from: d, reason: collision with root package name */
    protected com.baidu.platform.util.a f8580d = new com.baidu.platform.util.a();

    public abstract String a(com.baidu.platform.domain.b bVar);

    public void a(boolean z4) {
        this.f8578b = z4;
    }

    public void b(boolean z4) {
        this.f8577a = z4;
    }

    public String a() {
        return this.f8579c;
    }

    public String b(SearchType searchType) {
        String strA = a(com.baidu.platform.domain.c.a());
        SDKInitializer.getDebugMode();
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            Log.e("SearchRequest", "toUrlString get authtoken failed");
            int iPermissionCheck = PermissionCheck.permissionCheck();
            if (iPermissionCheck != 0) {
                Log.e("SearchRequest", "try permissionCheck result is: " + iPermissionCheck);
                return null;
            }
            authToken = HttpClient.getAuthToken();
        }
        if (this.f8577a) {
            this.f8580d.a("token", authToken);
        }
        String strA2 = this.f8580d.a();
        if (a(searchType)) {
            strA2 = a(searchType, strA2);
        }
        StringBuilder sbS = g.s(strA2);
        sbS.append(HttpClient.getPhoneInfo());
        String string = sbS.toString();
        if (this.f8578b) {
            StringBuilder sbV = g.v(string, "&sign=");
            sbV.append(AppMD5.getSignMD5String(string));
            string = sbV.toString();
        }
        return AbstractC0351g.q(strA, CallerData.NA, string);
    }

    private String a(SearchType searchType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SearchType.REVERSE_GEO_CODER == searchType ? a(str) : str;
    }

    private String a(String str) {
        String strSubstring = str.substring(str.indexOf("location=") + 9, str.indexOf("&", str.indexOf("location=")));
        if (TextUtils.isEmpty(strSubstring)) {
            return str;
        }
        byte[] urlNeedInfo = {0};
        try {
            urlNeedInfo = AlgorithmUtil.setUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), strSubstring.getBytes());
        } catch (Exception e4) {
            Log.e("BaseSearch", "get location failed", e4);
        }
        return str.replace(strSubstring, Base64.encodeToString(urlNeedInfo, 0).trim());
    }

    public final String a(PlanNode planNode) {
        if (planNode == null) {
            return null;
        }
        String str = new String("{");
        LatLng location = planNode.getLocation();
        if (location != null) {
            String strConcat = str.concat("\"type\":1,");
            Point pointLl2point = CoordUtil.ll2point(location);
            if (!TextUtils.isEmpty(planNode.getPoiId())) {
                StringBuilder sbV = g.v(strConcat, "\"uid\":\"");
                sbV.append(planNode.getPoiId());
                sbV.append("\",");
                strConcat = sbV.toString();
            }
            if (!TextUtils.isEmpty(planNode.getBid()) && !TextUtils.isEmpty(planNode.getFloor())) {
                StringBuilder sbV2 = g.v(strConcat, "\"building\":\"");
                sbV2.append(planNode.getBid());
                sbV2.append("\",");
                StringBuilder sbV3 = g.v(sbV2.toString(), "\"floor\":\"");
                sbV3.append(planNode.getFloor());
                sbV3.append("\",");
                strConcat = sbV3.toString();
            }
            if (!TextUtils.isEmpty(planNode.getCityCode())) {
                StringBuilder sbV4 = g.v(strConcat, "\"city\":\"");
                sbV4.append(planNode.getCityCode());
                sbV4.append("\",");
                strConcat = sbV4.toString();
            }
            StringBuilder sbV5 = g.v(strConcat, "\"xy\":\"");
            sbV5.append(pointLl2point.f8600x);
            sbV5.append(",");
            return AbstractC0831a.d(sbV5, pointLl2point.f8601y, "\"}");
        }
        if (planNode.getName() == null) {
            return str;
        }
        String strConcat2 = str.concat("\"type\":2,");
        if (!TextUtils.isEmpty(planNode.getPoiId())) {
            StringBuilder sbV6 = g.v(strConcat2, "\"uid\":\"");
            sbV6.append(planNode.getPoiId());
            sbV6.append("\",");
            strConcat2 = sbV6.toString();
        }
        StringBuilder sbV7 = g.v(strConcat2, "\"keyword\":\"");
        sbV7.append(planNode.getName());
        sbV7.append("\"}");
        return sbV7.toString();
    }

    private boolean a(SearchType searchType) {
        return SearchType.REVERSE_GEO_CODER == searchType;
    }
}
