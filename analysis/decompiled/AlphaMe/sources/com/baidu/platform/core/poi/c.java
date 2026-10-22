package com.baidu.platform.core.poi;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f9380b = "c";

    /* renamed from: c, reason: collision with root package name */
    private boolean f9381c = false;

    public void a(boolean z4) {
        this.f9381c = z4;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        SearchResult poiDetailSearchResult = this.f9381c ? new PoiDetailSearchResult() : new PoiDetailResult();
        if (str == null || str.isEmpty()) {
            poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiDetailSearchResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailSearchResult;
            }
            if (!jSONObject.has("SDK_InnerError")) {
                if (!a(str, poiDetailSearchResult)) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return poiDetailSearchResult;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() == 0) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailSearchResult;
            }
            if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                return poiDetailSearchResult;
            }
            if (jSONObjectOptJSONObject.has("httpStateError")) {
                String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                strOptString.getClass();
                if (strOptString.equals("NETWORK_ERROR")) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                } else if (strOptString.equals("REQUEST_ERROR")) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                } else {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
            }
            return poiDetailSearchResult;
        } catch (JSONException e4) {
            Log.e(f9380b, "Parse detail search result failed", e4);
            poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiDetailSearchResult;
        }
    }

    private boolean a(String str, SearchResult searchResult) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0 || jSONObject.optInt("status") != 0 || (jSONArrayOptJSONArray = jSONObject.optJSONArray("result")) == null || jSONArrayOptJSONArray.length() == 0) {
                return false;
            }
            if (this.f9381c) {
                return a(jSONArrayOptJSONArray, (PoiDetailSearchResult) searchResult);
            }
            return a(jSONArrayOptJSONArray, (PoiDetailResult) searchResult);
        } catch (JSONException e4) {
            Log.e(f9380b, "Parse detail search result error", e4);
            return false;
        }
    }

    private boolean a(JSONArray jSONArray, PoiDetailSearchResult poiDetailSearchResult) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null && jSONObject.length() != 0) {
                PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
                poiDetailInfo.setName(jSONObject.optString("name"));
                poiDetailInfo.setLocation(a(jSONObject.optJSONObject(MapController.LOCATION_LAYER_TAG)));
                poiDetailInfo.setAddress(jSONObject.optString("address"));
                poiDetailInfo.setAdCode(jSONObject.optInt("adcode"));
                poiDetailInfo.setProvince(jSONObject.optString("province"));
                poiDetailInfo.setCity(jSONObject.optString("city"));
                poiDetailInfo.setArea(jSONObject.optString("area"));
                poiDetailInfo.setTelephone(jSONObject.optString("telephone"));
                poiDetailInfo.setUid(jSONObject.optString("uid"));
                poiDetailInfo.setStreetId(jSONObject.optString("setStreetId"));
                poiDetailInfo.setDetail(jSONObject.optString("detail"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("detail_info");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                    poiDetailInfo.setDistance(jSONObjectOptJSONObject.optInt("distance", 0));
                    poiDetailInfo.setType(jSONObjectOptJSONObject.optString("type"));
                    poiDetailInfo.setTag(jSONObjectOptJSONObject.optString("tag"));
                    poiDetailInfo.setDetailUrl(jSONObjectOptJSONObject.optString("detail_url"));
                    poiDetailInfo.setPrice(jSONObjectOptJSONObject.optDouble("price", 0.0d));
                    poiDetailInfo.setShopHours(jSONObjectOptJSONObject.optString("shop_hours"));
                    poiDetailInfo.setOverallRating(jSONObjectOptJSONObject.optDouble("overall_rating", 0.0d));
                    poiDetailInfo.setTasteRating(jSONObjectOptJSONObject.optDouble("taste_rating", 0.0d));
                    poiDetailInfo.setServiceRating(jSONObjectOptJSONObject.optDouble("service_rating", 0.0d));
                    poiDetailInfo.setEnvironmentRating(jSONObjectOptJSONObject.optDouble("environment_rating", 0.0d));
                    poiDetailInfo.setFacilityRating(jSONObjectOptJSONObject.optDouble("facility_rating", 0.0d));
                    poiDetailInfo.setHygieneRating(jSONObjectOptJSONObject.optDouble("hygiene_rating", 0.0d));
                    poiDetailInfo.setTechnologyRating(jSONObjectOptJSONObject.optDouble("technology_rating", 0.0d));
                    poiDetailInfo.setImageNum(jSONObjectOptJSONObject.optInt("image_num"));
                    poiDetailInfo.setBrand(jSONObjectOptJSONObject.optString("brand"));
                    poiDetailInfo.setLabel(jSONObjectOptJSONObject.optString("label"));
                    poiDetailInfo.setGrouponNum(jSONObjectOptJSONObject.optInt("groupon_num", 0));
                    poiDetailInfo.setCommentNum(jSONObjectOptJSONObject.optInt("comment_num", 0));
                    poiDetailInfo.setDiscountNum(jSONObjectOptJSONObject.optInt("discount_num", 0));
                    poiDetailInfo.setFavoriteNum(jSONObjectOptJSONObject.optInt("favorite_num", 0));
                    poiDetailInfo.setCheckinNum(jSONObjectOptJSONObject.optInt("checkin_num", 0));
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("photos");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                            if (!TextUtils.isEmpty(jSONArrayOptJSONArray.optString(i5))) {
                                arrayList2.add(jSONArrayOptJSONArray.optString(i5));
                            }
                        }
                        poiDetailInfo.setPhotos(arrayList2);
                    }
                }
                arrayList.add(poiDetailInfo);
            }
        }
        poiDetailSearchResult.setPoiDetailInfoList(arrayList);
        poiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private boolean a(JSONArray jSONArray, PoiDetailResult poiDetailResult) {
        JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        poiDetailResult.setName(jSONObject.optString("name"));
        poiDetailResult.setLocation(a(jSONObject.optJSONObject(MapController.LOCATION_LAYER_TAG)));
        poiDetailResult.setAddress(jSONObject.optString("address"));
        poiDetailResult.setTelephone(jSONObject.optString("telephone"));
        poiDetailResult.setUid(jSONObject.optString("uid"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("detail_info");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
            poiDetailResult.setTag(jSONObjectOptJSONObject.optString("tag"));
            poiDetailResult.setDetailUrl(jSONObjectOptJSONObject.optString("detail_url"));
            poiDetailResult.setType(jSONObjectOptJSONObject.optString("type"));
            poiDetailResult.setPrice(jSONObjectOptJSONObject.optDouble("price", 0.0d));
            poiDetailResult.setOverallRating(jSONObjectOptJSONObject.optDouble("overall_rating", 0.0d));
            poiDetailResult.setTasteRating(jSONObjectOptJSONObject.optDouble("taste_rating", 0.0d));
            poiDetailResult.setServiceRating(jSONObjectOptJSONObject.optDouble("service_rating", 0.0d));
            poiDetailResult.setEnvironmentRating(jSONObjectOptJSONObject.optDouble("environment_rating", 0.0d));
            poiDetailResult.setFacilityRating(jSONObjectOptJSONObject.optDouble("facility_rating", 0.0d));
            poiDetailResult.setHygieneRating(jSONObjectOptJSONObject.optDouble("hygiene_rating", 0.0d));
            poiDetailResult.setTechnologyRating(jSONObjectOptJSONObject.optDouble("technology_rating", 0.0d));
            poiDetailResult.setImageNum(jSONObjectOptJSONObject.optInt("image_num"));
            poiDetailResult.setGrouponNum(jSONObjectOptJSONObject.optInt("groupon_num", 0));
            poiDetailResult.setCommentNum(jSONObjectOptJSONObject.optInt("comment_num", 0));
            poiDetailResult.setDiscountNum(jSONObjectOptJSONObject.optInt("discount_num", 0));
            poiDetailResult.setFavoriteNum(jSONObjectOptJSONObject.optInt("favorite_num", 0));
            poiDetailResult.setCheckinNum(jSONObjectOptJSONObject.optInt("checkin_num", 0));
            poiDetailResult.setShopHours(jSONObjectOptJSONObject.optString("shop_hours"));
        }
        poiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double dOptDouble = jSONObject.optDouble("lat");
        double dOptDouble2 = jSONObject.optDouble("lng");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(new LatLng(dOptDouble, dOptDouble2));
        }
        return new LatLng(dOptDouble, dOptDouble2);
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        if (this.f9381c) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailSearchResult) searchResult);
        } else {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailResult) searchResult);
        }
    }
}
