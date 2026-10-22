package com.baidu.platform.core.district;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.b {

    /* renamed from: b, reason: collision with root package name */
    boolean f9374b = false;

    /* renamed from: c, reason: collision with root package name */
    String f9375c = null;

    private boolean b(String str, DistrictResult districtResult) {
        List<List<LatLng>> listDecodeLocationList2D;
        if (str != null && !str.equals("") && districtResult != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("content");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject.optInt("error") != 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (this.f9375c != null) {
                    try {
                        listDecodeLocationList2D = CoordUtil.decodeLocationList2D(jSONObjectOptJSONObject2.optString(MapBundleKey.MapObjKey.OBJ_GEO));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } else {
                    listDecodeLocationList2D = null;
                }
                if (listDecodeLocationList2D != null) {
                    for (List<LatLng> list : listDecodeLocationList2D) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<LatLng> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(it.next());
                        }
                        arrayList.add(arrayList2);
                    }
                }
                if (arrayList.size() > 0) {
                    districtResult.setPolylines(arrayList);
                }
                districtResult.setCityName(this.f9375c);
                districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                this.f9375c = null;
                return true;
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        DistrictResult districtResult = new DistrictResult();
        if (str == null || str.equals("")) {
            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return districtResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    districtResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return districtResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        districtResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        districtResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        districtResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return districtResult;
                }
            }
            if (!a(str, districtResult, false)) {
                if (this.f9374b) {
                    b(str, districtResult);
                } else if (!a(str, districtResult)) {
                    districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            }
            return districtResult;
        } catch (Exception unused) {
            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return districtResult;
        }
    }

    public void a(boolean z4) {
        this.f9374b = z4;
    }

    private boolean a(String str, DistrictResult districtResult) {
        JSONObject jSONObjectOptJSONObject;
        if (str != null && !"".equals(str) && districtResult != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("city_result");
                if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject3 == null || jSONObjectOptJSONObject2.optInt("error") != 0 || (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("content")) == null) {
                    return false;
                }
                if (jSONObjectOptJSONObject.optJSONObject("sgeo") != null) {
                    districtResult.setCenterPt(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO)));
                    districtResult.setCityCode(jSONObjectOptJSONObject.optInt("code"));
                    districtResult.setCityName(jSONObjectOptJSONObject.optString("cname"));
                    districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                }
                districtResult.setCityName(jSONObjectOptJSONObject.optString("uid"));
                this.f9375c = jSONObjectOptJSONObject.optString("cname");
                districtResult.setCenterPt(CoordUtil.decodeLocation(jSONObjectOptJSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO)));
                districtResult.setCityCode(jSONObjectOptJSONObject.optInt("code"));
                return false;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetDistricSearchResultListener)) {
            return;
        }
        ((OnGetDistricSearchResultListener) obj).onGetDistrictResult((DistrictResult) searchResult);
    }
}
