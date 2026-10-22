package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.jmsl.O2;
import com.amap.api.col.jmsl.b3;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class R1 extends AbstractC1560h1<C1632z2, PoiResultV2> {

    /* renamed from: E, reason: collision with root package name */
    public int f16298E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f16299F;

    public R1(Context context, C1632z2 c1632z2) {
        super(context, c1632z2);
        this.f16298E = 0;
        this.f16299F = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String q(boolean z10) {
        String str;
        String str2;
        String str3;
        List<LatLonPoint> polyGonList;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        PoiSearchV2.SearchBound searchBound = ((C1632z2) this.f16103z).f17072b;
        if (searchBound == null) {
            str = "weight";
            str2 = "distance";
            str3 = "&sortrule=";
        } else if (searchBound.getShape().equals("Bound")) {
            if (z10) {
                double dA = C1631z1.a(((C1632z2) this.f16103z).f17072b.getCenter().getLongitude());
                double dA2 = C1631z1.a(((C1632z2) this.f16103z).f17072b.getCenter().getLatitude());
                sb2.append("&location=");
                sb2.append(dA + Const.STR_MART_COMMA + dA2);
            }
            sb2.append("&radius=");
            sb2.append(((C1632z2) this.f16103z).f17072b.getRange());
            sb2.append("&sortrule=");
            sb2.append(((C1632z2) this.f16103z).f17072b.isDistanceSort() ? "distance" : "weight");
            str = "weight";
            str2 = "distance";
            str3 = "&sortrule=";
        } else if (((C1632z2) this.f16103z).f17072b.getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = ((C1632z2) this.f16103z).f17072b.getLowerLeft();
            LatLonPoint upperRight = ((C1632z2) this.f16103z).f17072b.getUpperRight();
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
            if (((C1632z2) this.f16103z).f17072b.getShape().equals("Polygon") && (polyGonList = ((C1632z2) this.f16103z).f17072b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb2.append("&polygon=" + C1631z1.i(polyGonList, Const.STR_MART_SEMICOLON));
            }
        }
        String city = ((C1632z2) this.f16103z).f17071a.getCity();
        if (!p(city)) {
            String strM = m(city);
            sb2.append("&region=");
            sb2.append(strM);
        }
        String strM2 = m(((C1632z2) this.f16103z).f17071a.getQueryString());
        if (!p(strM2)) {
            sb2.append("&keywords=");
            sb2.append(strM2);
        }
        sb2.append("&page_size=");
        sb2.append(((C1632z2) this.f16103z).f17071a.getPageSize());
        sb2.append("&page_num=");
        sb2.append(((C1632z2) this.f16103z).f17071a.getPageNum());
        String building = ((C1632z2) this.f16103z).f17071a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb2.append("&building=");
            sb2.append(((C1632z2) this.f16103z).f17071a.getBuilding());
        }
        String strM3 = m(((C1632z2) this.f16103z).f17071a.getCategory());
        if (!p(strM3)) {
            sb2.append("&types=");
            sb2.append(strM3);
        }
        String strO = o(((C1632z2) this.f16103z).f17071a.getShowFields());
        if (strO != null) {
            sb2.append("&show_fields=");
            sb2.append(strO);
        }
        sb2.append("&key=");
        sb2.append(C1567j0.n(this.f16099B));
        if (((C1632z2) this.f16103z).f17071a.getCityLimit()) {
            sb2.append("&citylimit=true");
        } else {
            sb2.append("&citylimit=false");
        }
        if (this.f16299F) {
            if (((C1632z2) this.f16103z).f17071a.isSpecial()) {
                sb2.append("&special=1");
            } else {
                sb2.append("&special=0");
            }
        }
        String channel = ((C1632z2) this.f16103z).f17071a.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb2.append("&channel=");
            sb2.append(channel);
        }
        String premium = ((C1632z2) this.f16103z).f17071a.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb2.append("&permium=");
            sb2.append(premium);
        }
        C1632z2 c1632z2 = (C1632z2) this.f16103z;
        if (c1632z2.f17072b == null && c1632z2.f17071a.getLocation() != null) {
            sb2.append(str3);
            sb2.append(((C1632z2) this.f16103z).f17071a.isDistanceSort() ? str2 : str);
            double dA6 = C1631z1.a(((C1632z2) this.f16103z).f17071a.getLocation().getLongitude());
            double dA7 = C1631z1.a(((C1632z2) this.f16103z).f17071a.getLocation().getLatitude());
            sb2.append("&location=");
            sb2.append(dA6 + Const.STR_MART_COMMA + dA7);
        }
        Map<String, String> customParams = ((C1632z2) this.f16103z).f17071a.getCustomParams();
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
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            C1632z2 c1632z2 = (C1632z2) this.f16103z;
            return PoiResultV2.createPagedResult(c1632z2.f17071a, c1632z2.f17072b, this.f16298E, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f16298E = jSONObject.optInt("count");
            arrayList = C1531a0.X(jSONObject);
        } catch (JSONException e10) {
            C1631z1.o(e10, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e11) {
            C1631z1.o(e11, "PoiSearchKeywordHandler", "paseJSONException");
        }
        C1632z2 c1632z22 = (C1632z2) this.f16103z;
        return PoiResultV2.createPagedResult(c1632z22.f17071a, c1632z22.f17072b, this.f16298E, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        String str = T2.e(this.f16099B) + "/place";
        PoiSearchV2.SearchBound searchBound = ((C1632z2) this.f16103z).f17072b;
        if (searchBound == null) {
            return str + "/text?";
        }
        if (searchBound.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f16299F = true;
            return str2;
        }
        if (!((C1632z2) this.f16103z).f17072b.getShape().equals("Rectangle") && !((C1632z2) this.f16103z).f17072b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public O2.b j() {
        O2.b bVar = new O2.b();
        if (!this.f16299F) {
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
        if (((C1632z2) this.f16103z).f17072b.getShape().equals("Bound")) {
            bVar.f16253b = new b3.a(C1631z1.a(((C1632z2) this.f16103z).f17072b.getCenter().getLatitude()), C1631z1.a(((C1632z2) this.f16103z).f17072b.getCenter().getLongitude()), dJ);
        }
        return bVar;
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        return q(true);
    }
}
