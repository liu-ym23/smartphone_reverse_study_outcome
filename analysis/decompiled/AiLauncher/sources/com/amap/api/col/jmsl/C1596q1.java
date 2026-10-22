package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.O2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.q1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1596q1 extends AbstractC1560h1<String, PoiItem> {

    /* renamed from: E, reason: collision with root package name */
    public PoiSearch.Query f16806E;

    public C1596q1(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.f16806E = query;
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("pois");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
                return C1531a0.C(jSONObjectOptJSONObject);
            }
            return null;
        } catch (JSONException e10) {
            C1631z1.o(e10, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e11) {
            C1631z1.o(e11, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/place/detail?";
    }

    @Override // com.amap.api.col.jmsl.I1
    public O2.b j() {
        O2.b bVar = new O2.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getURL());
        sb2.append(n());
        if (C1567j0.o() || C1567j0.j() != 0) {
            sb2.append("langCode=");
            sb2.append(ServiceSettings.getInstance().getLanguage());
        }
        bVar.f16252a = sb2.toString();
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append((String) this.f16103z);
        sb2.append("&output=json");
        PoiSearch.Query query = this.f16806E;
        if (query == null || p(query.getExtensions())) {
            sb2.append("&extensions=base");
        } else {
            sb2.append("&extensions=");
            sb2.append(this.f16806E.getExtensions());
        }
        sb2.append("&children=1");
        sb2.append("&key=" + C1567j0.n(this.f16099B));
        PoiSearch.Query query2 = this.f16806E;
        if (query2 != null) {
            Map<String, String> customParams = query2.getCustomParams();
            if (!customParams.isEmpty()) {
                for (Map.Entry<String, String> entry : customParams.entrySet()) {
                    sb2.append(Const.STR_MART_ADD);
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(entry.getValue());
                }
            }
        }
        return sb2.toString();
    }
}
