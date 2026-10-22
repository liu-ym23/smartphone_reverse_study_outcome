package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.O2;
import com.amap.api.col.jmsl.b3;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class J1 extends AbstractC1560h1<C1597q2, PoiResult> {

    /* renamed from: E, reason: collision with root package name */
    public int f16138E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f16139F;

    /* renamed from: G, reason: collision with root package name */
    public List<String> f16140G;

    /* renamed from: H, reason: collision with root package name */
    public List<SuggestionCity> f16141H;

    public J1(Context context, C1597q2 c1597q2) {
        super(context, c1597q2);
        this.f16138E = 0;
        this.f16139F = false;
        this.f16140G = new ArrayList();
        this.f16141H = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String q(boolean z10) {
        String str;
        String str2;
        String str3;
        List<LatLonPoint> polyGonList;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        PoiSearch.SearchBound searchBound = ((C1597q2) this.f16103z).f16808b;
        if (searchBound == null) {
            str = "weight";
            str2 = "distance";
            str3 = "&sortrule=";
        } else if (searchBound.getShape().equals("Bound")) {
            if (z10) {
                double dA = C1631z1.a(((C1597q2) this.f16103z).f16808b.getCenter().getLongitude());
                double dA2 = C1631z1.a(((C1597q2) this.f16103z).f16808b.getCenter().getLatitude());
                sb2.append("&location=");
                sb2.append(dA + Const.STR_MART_COMMA + dA2);
            }
            sb2.append("&radius=");
            sb2.append(((C1597q2) this.f16103z).f16808b.getRange());
            sb2.append("&sortrule=");
            sb2.append(((C1597q2) this.f16103z).f16808b.isDistanceSort() ? "distance" : "weight");
            str = "weight";
            str2 = "distance";
            str3 = "&sortrule=";
        } else if (((C1597q2) this.f16103z).f16808b.getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = ((C1597q2) this.f16103z).f16808b.getLowerLeft();
            LatLonPoint upperRight = ((C1597q2) this.f16103z).f16808b.getUpperRight();
            double dA3 = C1631z1.a(lowerLeft.getLatitude());
            double dA4 = C1631z1.a(lowerLeft.getLongitude());
            str = "weight";
            double dA5 = C1631z1.a(upperRight.getLatitude());
            double longitude = upperRight.getLongitude();
            str2 = "distance";
            str3 = "&sortrule=";
            sb2.append("&polygon=" + dA4 + Const.STR_MART_COMMA + dA3 + Const.STR_MART_SEMICOLON + C1631z1.a(longitude) + Const.STR_MART_COMMA + dA5);
        } else {
            str = "weight";
            str2 = "distance";
            str3 = "&sortrule=";
            if (((C1597q2) this.f16103z).f16808b.getShape().equals("Polygon") && (polyGonList = ((C1597q2) this.f16103z).f16808b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb2.append("&polygon=" + C1631z1.i(polyGonList, Const.STR_MART_SEMICOLON));
            }
        }
        String city = ((C1597q2) this.f16103z).f16807a.getCity();
        if (!p(city)) {
            String strM = m(city);
            sb2.append("&city=");
            sb2.append(strM);
        }
        String strM2 = m(((C1597q2) this.f16103z).f16807a.getQueryString());
        if (!p(strM2)) {
            sb2.append("&keywords=");
            sb2.append(strM2);
        }
        sb2.append("&offset=");
        sb2.append(((C1597q2) this.f16103z).f16807a.getPageSize());
        sb2.append("&page=");
        sb2.append(((C1597q2) this.f16103z).f16807a.getPageNum());
        String building = ((C1597q2) this.f16103z).f16807a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb2.append("&building=");
            sb2.append(((C1597q2) this.f16103z).f16807a.getBuilding());
        }
        String strM3 = m(((C1597q2) this.f16103z).f16807a.getCategory());
        if (!p(strM3)) {
            sb2.append("&types=");
            sb2.append(strM3);
        }
        if (p(((C1597q2) this.f16103z).f16807a.getExtensions())) {
            sb2.append("&extensions=base");
        } else {
            sb2.append("&extensions=");
            sb2.append(((C1597q2) this.f16103z).f16807a.getExtensions());
        }
        sb2.append("&key=");
        sb2.append(C1567j0.n(this.f16099B));
        if (((C1597q2) this.f16103z).f16807a.getCityLimit()) {
            sb2.append("&citylimit=true");
        } else {
            sb2.append("&citylimit=false");
        }
        if (((C1597q2) this.f16103z).f16807a.isRequireSubPois()) {
            sb2.append("&children=1");
        } else {
            sb2.append("&children=0");
        }
        if (this.f16139F) {
            if (((C1597q2) this.f16103z).f16807a.isSpecial()) {
                sb2.append("&special=1");
            } else {
                sb2.append("&special=0");
            }
        }
        C1597q2 c1597q2 = (C1597q2) this.f16103z;
        if (c1597q2.f16808b == null && c1597q2.f16807a.getLocation() != null) {
            sb2.append(str3);
            sb2.append(((C1597q2) this.f16103z).f16807a.isDistanceSort() ? str2 : str);
            double dA6 = C1631z1.a(((C1597q2) this.f16103z).f16807a.getLocation().getLongitude());
            double dA7 = C1631z1.a(((C1597q2) this.f16103z).f16807a.getLocation().getLatitude());
            sb2.append("&location=");
            sb2.append(dA6 + Const.STR_MART_COMMA + dA7);
        }
        Map<String, String> customParams = ((C1597q2) this.f16103z).f16807a.getCustomParams();
        if (!customParams.isEmpty()) {
            for (Map.Entry<String, String> entry : customParams.entrySet()) {
                sb2.append(Const.STR_MART_ADD);
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(entry.getValue());
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        ArrayList<PoiItem> arrayListV;
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            C1597q2 c1597q2 = (C1597q2) this.f16103z;
            PoiSearch.Query query = c1597q2.f16807a;
            return PoiResult.createPagedResult(query, c1597q2.f16808b, this.f16140G, this.f16141H, query.getPageSize(), this.f16138E, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.f16138E = jSONObject.optInt("count");
            arrayListV = C1531a0.V(jSONObject);
            try {
            } catch (JSONException e10) {
                e = e10;
                arrayList = arrayListV;
                C1631z1.o(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
                arrayListV = arrayList;
                C1597q2 c1597q22 = (C1597q2) this.f16103z;
                PoiSearch.Query query2 = c1597q22.f16807a;
                return PoiResult.createPagedResult(query2, c1597q22.f16808b, this.f16140G, this.f16141H, query2.getPageSize(), this.f16138E, arrayListV);
            } catch (Exception e11) {
                e = e11;
                arrayList = arrayListV;
                C1631z1.o(e, "PoiSearchKeywordHandler", "paseJSONException");
                arrayListV = arrayList;
                C1597q2 c1597q222 = (C1597q2) this.f16103z;
                PoiSearch.Query query22 = c1597q222.f16807a;
                return PoiResult.createPagedResult(query22, c1597q222.f16808b, this.f16140G, this.f16141H, query22.getPageSize(), this.f16138E, arrayListV);
            }
        } catch (JSONException e12) {
            e = e12;
        } catch (Exception e13) {
            e = e13;
        }
        if (!jSONObject.has("suggestion")) {
            T t10 = this.f16103z;
            return PoiResult.createPagedResult(((C1597q2) t10).f16807a, ((C1597q2) t10).f16808b, this.f16140G, this.f16141H, ((C1597q2) t10).f16807a.getPageSize(), this.f16138E, arrayListV);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("suggestion");
        if (jSONObjectOptJSONObject == null) {
            T t11 = this.f16103z;
            return PoiResult.createPagedResult(((C1597q2) t11).f16807a, ((C1597q2) t11).f16808b, this.f16140G, this.f16141H, ((C1597q2) t11).f16807a.getPageSize(), this.f16138E, arrayListV);
        }
        this.f16141H = C1531a0.p(jSONObjectOptJSONObject);
        this.f16140G = C1531a0.w(jSONObjectOptJSONObject);
        C1597q2 c1597q2222 = (C1597q2) this.f16103z;
        PoiSearch.Query query222 = c1597q2222.f16807a;
        return PoiResult.createPagedResult(query222, c1597q2222.f16808b, this.f16140G, this.f16141H, query222.getPageSize(), this.f16138E, arrayListV);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        String str = T2.c(this.f16099B) + "/place";
        PoiSearch.SearchBound searchBound = ((C1597q2) this.f16103z).f16808b;
        if (searchBound == null) {
            return str + "/text?";
        }
        if (searchBound.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f16139F = true;
            return str2;
        }
        if (!((C1597q2) this.f16103z).f16808b.getShape().equals("Rectangle") && !((C1597q2) this.f16103z).f16808b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public O2.b j() {
        O2.b bVar = new O2.b();
        if (!this.f16139F) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getURL());
            sb2.append(q(true));
            if (C1567j0.o() || C1567j0.j() != 0) {
                sb2.append("langCode=");
                sb2.append(ServiceSettings.getInstance().getLanguage());
            }
            bVar.f16252a = sb2.toString();
            return bVar;
        }
        U2 u2C = O2.b().c("regeo");
        b3 b3Var = u2C == null ? null : (b3) u2C;
        double dJ = b3Var != null ? b3Var.j() : 0.0d;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getURL());
        sb3.append(q(false));
        if (C1567j0.o() || C1567j0.j() != 0) {
            sb3.append("langCode=");
            sb3.append(ServiceSettings.getInstance().getLanguage());
        }
        bVar.f16252a = sb3.toString();
        if (((C1597q2) this.f16103z).f16808b.getShape().equals("Bound")) {
            bVar.f16253b = new b3.a(C1631z1.a(((C1597q2) this.f16103z).f16808b.getCenter().getLatitude()), C1631z1.a(((C1597q2) this.f16103z).f16808b.getCenter().getLongitude()), dJ);
        }
        return bVar;
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        return q(true);
    }
}
