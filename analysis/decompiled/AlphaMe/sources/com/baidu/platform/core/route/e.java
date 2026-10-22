package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends com.baidu.platform.base.b {
    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        IndoorRouteResult indoorRouteResult = new IndoorRouteResult();
        if (str == null || str.equals("")) {
            indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return indoorRouteResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    indoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return indoorRouteResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        indoorRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return indoorRouteResult;
                }
            }
            if (!a(str, indoorRouteResult)) {
                indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return indoorRouteResult;
        } catch (Exception unused) {
            indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return indoorRouteResult;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(java.lang.String r27, com.baidu.mapapi.search.route.IndoorRouteResult r28) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.route.e.a(java.lang.String, com.baidu.mapapi.search.route.IndoorRouteResult):boolean");
    }

    private LatLng a(JSONObject jSONObject, String str) {
        if (jSONObject.optJSONArray(str) == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(0, 0);
        geoPoint.setLatitudeE6((int) r2.optDouble(1));
        geoPoint.setLongitudeE6((int) r2.optDouble(0));
        return CoordUtil.mc2ll(geoPoint);
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetIndoorRouteResult((IndoorRouteResult) searchResult);
    }
}
