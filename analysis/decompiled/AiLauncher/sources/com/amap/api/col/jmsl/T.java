package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class T extends I1<String, String> {

    /* renamed from: E, reason: collision with root package name */
    public String f16353E;

    public T(Context context, String str) {
        super(context, str);
        this.f16353E = str;
    }

    @Override // com.amap.api.col.jmsl.I1
    public String f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strD = C1531a0.D(jSONObject, "code");
            String strD2 = C1531a0.D(jSONObject, "message");
            if ("1".equals(strD)) {
                return C1531a0.D(jSONObject, "transfer_url");
            }
            if ("0".equals(strD)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, strD2);
            }
            if ("2".equals(strD)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, strD2);
            }
            if ("3".equals(strD)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, strD2);
            }
            if (UxipConstants.f30661Y.equals(strD)) {
                throw new AMapException("用户签名未通过", 0, strD2);
            }
            if (UxipConstants.EVENT_UPLOAD_MIN_VERSION.equals(strD)) {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, strD2);
            }
            return null;
        } catch (JSONException e10) {
            C1631z1.o(e10, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() throws UnsupportedEncodingException {
        byte[] bArrA;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("channel=open_api");
        sb2.append("&flag=1");
        sb2.append("&address=" + URLEncoder.encode(this.f16353E));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api");
        stringBuffer.append("1");
        stringBuffer.append(this.f16353E);
        stringBuffer.append("@");
        stringBuffer.append("8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String strC = L1.c(stringBuffer.toString());
        sb2.append("&sign=");
        sb2.append(strC.toUpperCase(Locale.US));
        sb2.append("&output=json");
        try {
            bArrA = C1603s1.a(sb2.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e10) {
            C1631z1.o(e10, "ShareUrlSearchHandler", "getParams");
            bArrA = null;
        }
        HashMap map = new HashMap();
        map.put("ent", "2");
        map.put("in", C1568j1.g(bArrA));
        map.put("keyt", "openapi");
        return map;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        C1532a1 c1532a1C = C1532a1.c(this.f16099B);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + c1532a1C.a(23) + "/ws/mapapi/shortaddress/transform";
        }
        return "https://" + c1532a1C.a(23) + "/ws/mapapi/shortaddress/transform";
    }
}
