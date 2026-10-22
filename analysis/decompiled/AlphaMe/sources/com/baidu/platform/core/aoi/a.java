package com.baidu.platform.core.aoi;

import android.util.Log;
import com.baidu.mapapi.search.aoi.AoiResult;
import com.baidu.mapapi.search.aoi.OnGetAoiSearchResultListener;
import com.baidu.mapapi.search.core.AoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f9369b = "a";

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        AoiResult aoiResult = new AoiResult();
        if (str == null || str.isEmpty()) {
            aoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return aoiResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                aoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return aoiResult;
            }
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    aoiResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return aoiResult;
                }
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    strOptString.getClass();
                    if (strOptString.equals("NETWORK_ERROR")) {
                        aoiResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        aoiResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        aoiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return aoiResult;
                }
            }
            if (!a(str, aoiResult, true)) {
                a(str, aoiResult);
            }
            return aoiResult;
        } catch (JSONException e4) {
            Log.e(f9369b, "ParseAoiResult: ", e4);
            aoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return aoiResult;
        }
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj instanceof OnGetAoiSearchResultListener) {
            ((OnGetAoiSearchResultListener) obj).onGetAoiResult((AoiResult) searchResult);
        }
    }

    private boolean a(String str, AoiResult aoiResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                aoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            int iOptInt = jSONObject.optInt("status");
            if (iOptInt == 0) {
                return a(jSONObject, aoiResult);
            }
            if (iOptInt == 1) {
                aoiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            } else if (iOptInt != 2) {
                aoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            } else {
                aoiResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
            }
            return false;
        } catch (JSONException e4) {
            Log.e(f9369b, "ParseAoiResult error: ", e4);
            aoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, AoiResult aoiResult) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("aoi_array");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i4);
            if (jSONObject2 != null) {
                AoiInfo aoiInfo = new AoiInfo();
                aoiInfo.setUid(jSONObject2.optString("uid"));
                aoiInfo.setPolygon(jSONObject2.optString("polygon"));
                aoiInfo.setAoiName(jSONObject2.optString("name"));
                aoiInfo.setAoiType(AoiInfo.AoiType.valueOf(jSONObject2.optInt("aoi_type")));
                aoiInfo.setOrder(jSONObject2.optInt("point_order"));
                aoiInfo.setNearestDistance(jSONObject2.optInt("distance"));
                aoiInfo.setRelation(jSONObject2.optInt("relation"));
                arrayList.add(aoiInfo);
            }
        }
        aoiResult.setAoiList(arrayList);
        return true;
    }
}
