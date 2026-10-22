package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.jmsl.O2;
import com.amap.api.col.jmsl.b3;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.autonavi.aps.amapapi.config.Const;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1578m extends Q1<RegeocodeQuery, RegeocodeAddress> {
    public C1578m(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (jSONObjectOptJSONObject != null) {
                regeocodeAddress.setFormatAddress(C1531a0.D(jSONObjectOptJSONObject, "formatted_address"));
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("addressComponent");
                if (jSONObjectOptJSONObject2 != null) {
                    C1531a0.l(jSONObjectOptJSONObject2, regeocodeAddress);
                }
                regeocodeAddress.setPois(C1531a0.V(jSONObjectOptJSONObject));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("roads");
                if (jSONArrayOptJSONArray != null) {
                    C1531a0.j(jSONArrayOptJSONArray, regeocodeAddress);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("roadinters");
                if (jSONArrayOptJSONArray2 != null) {
                    C1531a0.A(jSONArrayOptJSONArray2, regeocodeAddress);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("aois");
                if (jSONArrayOptJSONArray3 != null) {
                    C1531a0.u(jSONArrayOptJSONArray3, regeocodeAddress);
                }
            }
            return regeocodeAddress;
        } catch (JSONException e10) {
            C1631z1.o(e10, "ReverseGeocodingHandler", "paseJSON");
            return regeocodeAddress;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/geocode/regeo?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public O2.b j() {
        U2 u2C = O2.b().c("regeo");
        b3 b3Var = u2C == null ? null : (b3) u2C;
        double dJ = b3Var != null ? b3Var.j() : 0.0d;
        O2.b bVar = new O2.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getURL());
        sb2.append(o(false));
        String language = ServiceSettings.getInstance().getLanguage();
        sb2.append("language=");
        sb2.append(language);
        bVar.f16252a = sb2.toString();
        T t10 = this.f16103z;
        if (t10 != 0 && ((RegeocodeQuery) t10).getPoint() != null) {
            bVar.f16253b = new b3.a(((RegeocodeQuery) this.f16103z).getPoint().getLatitude(), ((RegeocodeQuery) this.f16103z).getPoint().getLongitude(), dJ);
        }
        return bVar;
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        return o(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String o(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        sb2.append("&location=");
        if (z10) {
            sb2.append(C1631z1.a(((RegeocodeQuery) this.f16103z).getPoint().getLongitude()));
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(C1631z1.a(((RegeocodeQuery) this.f16103z).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f16103z).getPoiType())) {
            sb2.append("&poitype=");
            sb2.append(((RegeocodeQuery) this.f16103z).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f16103z).getMode())) {
            sb2.append("&mode=");
            sb2.append(((RegeocodeQuery) this.f16103z).getMode());
        }
        if (TextUtils.isEmpty(((RegeocodeQuery) this.f16103z).getExtensions())) {
            sb2.append("&extensions=base");
        } else {
            sb2.append("&extensions=");
            sb2.append(((RegeocodeQuery) this.f16103z).getExtensions());
        }
        sb2.append("&radius=");
        sb2.append((int) ((RegeocodeQuery) this.f16103z).getRadius());
        sb2.append("&coordsys=");
        sb2.append(((RegeocodeQuery) this.f16103z).getLatLonType());
        sb2.append("&key=");
        sb2.append(C1567j0.n(this.f16099B));
        return sb2.toString();
    }
}
