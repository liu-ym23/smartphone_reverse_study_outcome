package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.C1607t1;
import com.autonavi.aps.amapapi.config.Const;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.t2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1608t2 extends C1 {

    /* renamed from: y, reason: collision with root package name */
    public JSONObject f16966y = null;

    /* renamed from: z, reason: collision with root package name */
    public Context f16967z = null;

    @Override // com.amap.api.col.jmsl.s7
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f16966y;
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    stringBuffer.append(next + "=" + URLEncoder.encode(this.f16966y.get(next).toString(), "utf-8") + Const.STR_MART_ADD);
                }
            }
            stringBuffer.append("output=json");
            String strN = C1567j0.n(this.f16967z);
            stringBuffer.append("&key=".concat(String.valueOf(strN)));
            String strB = J0.b();
            stringBuffer.append("&ts=".concat(String.valueOf(strB)));
            StringBuilder sb2 = new StringBuilder("&scode=");
            sb2.append(J0.d(this.f16967z, strB, "key=".concat(String.valueOf(strN))));
            stringBuffer.append(sb2.toString());
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.jmsl.s7
    public final Map<String, String> getRequestHead() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Accept-Encoding", "gzip");
        map.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, "AMAP SDK Android core 4.4.2.38");
        map.put("X-INFO", J0.c(this.f16967z));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.4.2.38", "core"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.jmsl.s7
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.jmsl.s7
    public final String getURL() {
        return C1607t1.a.f16962a.f() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
