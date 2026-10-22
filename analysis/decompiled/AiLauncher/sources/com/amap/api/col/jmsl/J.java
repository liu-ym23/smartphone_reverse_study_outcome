package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.O2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class J extends Q1<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public J(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                return C1531a0.R(jSONObject);
            }
        } catch (JSONException e10) {
            C1631z1.o(e10, "GeocodingHandler", "paseJSONJSONException");
        } catch (Exception e11) {
            C1631z1.o(e11, "GeocodingHandler", "paseJSONException");
        }
        return arrayList;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/geocode/geo?";
    }

    @Override // com.amap.api.col.jmsl.I1
    public O2.b j() {
        O2.b bVar = new O2.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getURL());
        sb2.append(n());
        String language = ServiceSettings.getInstance().getLanguage();
        sb2.append("language=");
        sb2.append(language);
        bVar.f16252a = sb2.toString();
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&address=");
        stringBuffer.append(m(((GeocodeQuery) this.f16103z).getLocationName()));
        String city = ((GeocodeQuery) this.f16103z).getCity();
        if (!C1531a0.m(city)) {
            String strM = m(city);
            stringBuffer.append("&city=");
            stringBuffer.append(strM);
        }
        if (!C1531a0.m(((GeocodeQuery) this.f16103z).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(m(((GeocodeQuery) this.f16103z).getCountry()));
        }
        stringBuffer.append("&key=" + C1567j0.n(this.f16099B));
        return stringBuffer.toString();
    }
}
