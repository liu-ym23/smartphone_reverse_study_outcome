package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.SearchType;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l extends com.baidu.platform.base.b {

    /* renamed from: b, reason: collision with root package name */
    SuggestAddrInfo f9390b = null;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f9391c;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9392a;

        static {
            int[] iArr = new int[SearchType.values().length];
            f9392a = iArr;
            try {
                iArr[SearchType.TRANSIT_ROUTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9392a[SearchType.DRIVE_ROUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9392a[SearchType.WALK_ROUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean b(String str) throws NumberFormatException {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.optInt("type") != 23 || jSONObjectOptJSONObject.optInt("error") != 0) {
                    return false;
                }
                SuggestAddrInfo suggestAddrInfoA = a(jSONObject);
                this.f9390b = suggestAddrInfoA;
                return suggestAddrInfoA != null;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        TransitRouteResult transitRouteResult;
        SearchType searchTypeA = a();
        if (b(str)) {
            this.f9391c = true;
        } else {
            this.f9391c = false;
        }
        int i4 = a.f9392a[searchTypeA.ordinal()];
        if (i4 == 1) {
            TransitRouteResult transitRouteResult2 = new TransitRouteResult();
            if (this.f9391c) {
                transitRouteResult2.setSuggestAddrInfo(this.f9390b);
                transitRouteResult2.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                transitRouteResult = transitRouteResult2;
            } else {
                ((m) this).b(str, transitRouteResult2);
                transitRouteResult = transitRouteResult2;
            }
        } else if (i4 == 2) {
            DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
            if (this.f9391c) {
                drivingRouteResult.setSuggestAddrInfo(this.f9390b);
                drivingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                transitRouteResult = drivingRouteResult;
            } else {
                ((c) this).a(str, drivingRouteResult);
                transitRouteResult = drivingRouteResult;
            }
        } else {
            if (i4 != 3) {
                return null;
            }
            WalkingRouteResult walkingRouteResult = new WalkingRouteResult();
            if (this.f9391c) {
                walkingRouteResult.setSuggestAddrInfo(this.f9390b);
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                transitRouteResult = walkingRouteResult;
            } else {
                ((o) this).b(str, walkingRouteResult);
                transitRouteResult = walkingRouteResult;
            }
        }
        return transitRouteResult;
    }

    private List<List<CityInfo>> b(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            List<CityInfo> listA = a((JSONArray) jSONArrayOptJSONArray.opt(i4));
            if (listA != null) {
                arrayList.add(listA);
            }
        }
        return arrayList;
    }

    private SuggestAddrInfo a(JSONObject jSONObject) throws NumberFormatException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("traffic_pois")) == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("option");
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject3 != null) {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("start_city");
            String strOptString = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("cname") : null;
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("end_city");
            String strOptString2 = (jSONArrayOptJSONArray == null || (jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(0)) == null) ? null : jSONObject2.optString("cname");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("city_list");
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("prio_flag");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray3 != null) {
                int length = jSONArrayOptJSONArray2.length();
                boolean[] zArr = new boolean[length];
                boolean[] zArr2 = new boolean[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = Integer.parseInt(jSONArrayOptJSONArray2.optString(i4));
                    int i6 = Integer.parseInt(jSONArrayOptJSONArray3.optString(i4));
                    boolean z4 = true;
                    zArr[i4] = i5 == 1;
                    if (i6 != 1) {
                        z4 = false;
                    }
                    zArr2[i4] = z4;
                }
                SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
                for (int i7 = 0; i7 < length; i7++) {
                    if (!zArr2[i7]) {
                        if (zArr[i7]) {
                            if (i7 == 0) {
                                suggestAddrInfo.setSuggestStartCity(a(jSONObjectOptJSONObject3.optJSONArray("start")));
                            } else if (i7 == length - 1 && i7 > 0) {
                                suggestAddrInfo.setSuggestEndCity(a(jSONObjectOptJSONObject3.optJSONArray("end")));
                            } else {
                                suggestAddrInfo.setSuggestWpCity(b(jSONObjectOptJSONObject3, "multi_waypoints"));
                            }
                        } else if (i7 == 0) {
                            suggestAddrInfo.setSuggestStartNode(a(jSONObjectOptJSONObject3.optJSONArray("start"), strOptString));
                        } else if (i7 == length - 1 && i7 > 0) {
                            suggestAddrInfo.setSuggestEndNode(a(jSONObjectOptJSONObject3.optJSONArray("end"), strOptString2));
                        } else {
                            suggestAddrInfo.setSuggestWpNode(a(jSONObjectOptJSONObject3, "multi_waypoints"));
                        }
                    }
                }
                return suggestAddrInfo;
            }
        }
        return null;
    }

    private List<CityInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject.optInt("num");
                cityInfo.city = jSONObject.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    private List<PoiInfo> a(JSONArray jSONArray, String str) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.address = jSONObject.optString("addr");
                poiInfo.uid = jSONObject.optString("uid");
                poiInfo.name = jSONObject.optString("name");
                poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO));
                poiInfo.city = str;
                arrayList.add(poiInfo);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private List<List<PoiInfo>> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
            List<PoiInfo> listA = a(((JSONObject) jSONArrayOptJSONArray.opt(i4)).optJSONArray("way_ponits"), "");
            if (listA != null) {
                arrayList.add(listA);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
        int i4 = a.f9392a[a().ordinal()];
        if (i4 == 1) {
            onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
        } else if (i4 == 2) {
            onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
        } else {
            if (i4 != 3) {
                return;
            }
            onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
        }
    }
}
