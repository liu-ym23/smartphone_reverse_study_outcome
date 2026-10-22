package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1538c extends Q1<DistrictSearchQuery, DistrictResult> {
    public C1538c(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f16103z, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            jSONArrayOptJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e10) {
            C1631z1.o(e10, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e11) {
            C1631z1.o(e11, "DistrictServerHandler", "paseJSONException");
        }
        if (jSONArrayOptJSONArray == null) {
            return districtResult;
        }
        C1531a0.k(jSONArrayOptJSONArray, arrayList, null);
        return districtResult;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/config/district?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.f16103z).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.f16103z).getPageSize());
        if (((DistrictSearchQuery) this.f16103z).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f16103z).checkKeyWords()) {
            String strM = m(((DistrictSearchQuery) this.f16103z).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(strM);
        }
        stringBuffer.append("&key=" + C1567j0.n(this.f16099B));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) this.f16103z).getSubDistrict()));
        return stringBuffer.toString();
    }
}
