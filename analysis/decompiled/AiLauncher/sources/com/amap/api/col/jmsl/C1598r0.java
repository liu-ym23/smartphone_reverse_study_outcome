package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.O2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.poisearch.VisualSearchResult;
import com.autonavi.aps.amapapi.config.Const;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1598r0 extends AbstractC1560h1<PoiSearchV2.VisualQuery, VisualSearchResult> {
    public C1598r0(Context context, PoiSearchV2.VisualQuery visualQuery) {
        super(context, visualQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        VisualSearchResult visualSearchResult = new VisualSearchResult();
        if (str != null) {
            try {
                return C1531a0.m0(new JSONObject(str));
            } catch (JSONException e10) {
                C1631z1.o(e10, "VisualSearchHandlerV2", "paseJSONJSONException");
            } catch (Exception e11) {
                C1631z1.o(e11, "VisualSearchHandlerV2", "paseJSONException");
            }
        }
        return visualSearchResult;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return "https://restapi.amap.com/v5/visual/place?";
    }

    @Override // com.amap.api.col.jmsl.I1
    public O2.b j() {
        O2.b bVar = new O2.b();
        bVar.f16252a = "https://restapi.amap.com/v5/visual/place?" + n() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        String picUrl = ((PoiSearchV2.VisualQuery) this.f16103z).getPicUrl();
        if (!p(picUrl)) {
            sb2.append("&pic=");
            sb2.append(m(picUrl));
        }
        LatLonPoint location = ((PoiSearchV2.VisualQuery) this.f16103z).getLocation();
        if (location != null) {
            double dA = C1631z1.a(location.getLongitude());
            double dA2 = C1631z1.a(location.getLatitude());
            sb2.append("&location=");
            sb2.append(dA);
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(dA2);
        }
        sb2.append("&angle=");
        sb2.append(((PoiSearchV2.VisualQuery) this.f16103z).getAngle());
        String adiu = ((PoiSearchV2.VisualQuery) this.f16103z).getAdiu();
        if (p(adiu)) {
            adiu = S0.q(this.f16099B);
        }
        if (!p(adiu)) {
            sb2.append("&adiu=");
            sb2.append(m(adiu));
        }
        sb2.append("&key=");
        sb2.append(C1567j0.n(this.f16099B));
        return sb2.toString();
    }
}
