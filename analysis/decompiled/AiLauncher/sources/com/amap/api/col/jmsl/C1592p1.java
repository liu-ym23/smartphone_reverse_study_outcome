package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.p1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1592p1 extends Q1<AutoTSearch.Query, AutoTChargeStationResult> {

    /* renamed from: E, reason: collision with root package name */
    public C1556g1 f16795E;

    public C1592p1(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.f16795E = null;
        this.f16795E = new C1556g1(context);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        try {
            return C1631z1.q(new JSONObject(str));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        try {
            String strD = r.d(new HashMap(), ((AutoTSearch.Query) this.f16103z).getAccessKey());
            return T2.b(this.f16099B) + "/ws/mapapi/poi/infolite/auto?" + strD + "&Signature=" + r.c("POST", strD, ((AutoTSearch.Query) this.f16103z).getSecretKey());
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuilder sb2 = new StringBuilder(this.f16795E.a());
        String adCode = ((AutoTSearch.Query) this.f16103z).getAdCode();
        if (!TextUtils.isEmpty(adCode)) {
            sb2.append("&adcode=");
            sb2.append(m(adCode));
        }
        String city = ((AutoTSearch.Query) this.f16103z).getCity();
        if (!TextUtils.isEmpty(city)) {
            sb2.append("&city=");
            sb2.append(m(city));
        }
        String dataType = ((AutoTSearch.Query) this.f16103z).getDataType();
        if (!TextUtils.isEmpty(dataType)) {
            sb2.append("&data_type=");
            sb2.append(m(dataType));
        }
        String geoObj = ((AutoTSearch.Query) this.f16103z).getGeoObj();
        if (!TextUtils.isEmpty(geoObj)) {
            sb2.append("&geoobj=");
            sb2.append(m(geoObj));
        }
        String keywords = ((AutoTSearch.Query) this.f16103z).getKeywords();
        if (!TextUtils.isEmpty(keywords)) {
            sb2.append("&keywords=");
            sb2.append(m(keywords));
        }
        sb2.append("&pagenum=");
        sb2.append(((AutoTSearch.Query) this.f16103z).getPageNum());
        sb2.append("&pagesize=");
        sb2.append(((AutoTSearch.Query) this.f16103z).getPageSize());
        sb2.append("&qii=");
        sb2.append(((AutoTSearch.Query) this.f16103z).isQii());
        String queryType = ((AutoTSearch.Query) this.f16103z).getQueryType();
        if (!TextUtils.isEmpty(queryType)) {
            sb2.append("&query_type=");
            sb2.append(m(queryType));
        }
        sb2.append("&range=");
        sb2.append(((AutoTSearch.Query) this.f16103z).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) this.f16103z).getLatLonPoint();
        if (latLonPoint != null) {
            sb2.append("&longitude=");
            sb2.append(latLonPoint.getLongitude());
            sb2.append("&latitude=");
            sb2.append(latLonPoint.getLatitude());
        }
        String userLoc = ((AutoTSearch.Query) this.f16103z).getUserLoc();
        if (!TextUtils.isEmpty(userLoc)) {
            sb2.append("&user_loc=");
            sb2.append(m(userLoc));
        }
        String userCity = ((AutoTSearch.Query) this.f16103z).getUserCity();
        if (!TextUtils.isEmpty(userCity)) {
            sb2.append("&user_city=");
            sb2.append(m(userCity));
        }
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) this.f16103z).getFilterBox();
        if (filterBox != null) {
            String retainState = filterBox.getRetainState();
            if (!TextUtils.isEmpty(retainState)) {
                sb2.append("&retain_state=");
                sb2.append(m(retainState));
            }
            String checkedLevel = filterBox.getCheckedLevel();
            if (!TextUtils.isEmpty(checkedLevel)) {
                sb2.append("&checked_level=");
                sb2.append(m(checkedLevel));
            }
            String classifyV2Data = filterBox.getClassifyV2Data();
            if (!TextUtils.isEmpty(classifyV2Data)) {
                sb2.append("&classify_v2_data=");
                sb2.append(m(classifyV2Data));
            }
            String classifyV2Level2Data = filterBox.getClassifyV2Level2Data();
            if (!TextUtils.isEmpty(classifyV2Level2Data)) {
                sb2.append("&classify_v2_level2_data=");
                sb2.append(m(classifyV2Level2Data));
            }
            String classifyV2Level3Data = filterBox.getClassifyV2Level3Data();
            if (!TextUtils.isEmpty(classifyV2Level3Data)) {
                sb2.append("&classify_v2_level3_data=");
                sb2.append(m(classifyV2Level3Data));
            }
        }
        return sb2.toString();
    }
}
