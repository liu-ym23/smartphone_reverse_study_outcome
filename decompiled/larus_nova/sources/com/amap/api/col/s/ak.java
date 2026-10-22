package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class ak extends a<String, String> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f26043j;

    @Override // com.amap.api.col.s.a
    public final String a() {
        return null;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> e() {
        StringBuilder r100 = new StringBuilder("channel=open_api&flag=1");
        r100.append("&address=" + URLEncoder.encode(this.f26043j));
        StringBuffer r101 = new StringBuffer("open_api1");
        r101.append(this.f26043j);
        r101.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String r102 = bq.a(r101.toString());
        r100.append("&sign=");
        r100.append(r102.toUpperCase(Locale.US));
        r100.append("&output=json");
        byte[] r103 = at.a(r100.toString().getBytes(XML.CHARSET_UTF8), "Yaynpa84IKOfasFx".getBytes(XML.CHARSET_UTF8));     // Catch: UnsupportedEncodingException -> L5
    L7:
        HashMap r104 = new HashMap();
        r104.put("ent", "2");
        r104.put("in", bn.b(r103));
        r104.put("keyt", "openapi");
        return r104;
    L5:
        e = move-exception;
        i.a(e, "ShareUrlSearchHandler", "getParams");
        r103 = null;
        goto L7
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.e();
    }

    private static String b(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L27
        String r102 = p.a(r101, "code");     // Catch: JSONException -> L27
        String r103 = p.a(r101, "message");     // Catch: JSONException -> L27
        if ("1".equals(r102) == false) goto L7;
        return p.a(r101, "transfer_url");
    L7:
        if ("0".equals(r102) == true) goto L26;
        if ("2".equals(r102) == true) goto L24;
        if ("3".equals(r102) == true) goto L22;
        if ("4".equals(r102) == true) goto L20;
        if ("5".equals(r102) == true) goto L18;
        return null;
    L18:
        throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, r103);     // Catch: JSONException -> L27
    L20:
        throw new AMapException("用户签名未通过", 0, r103);     // Catch: JSONException -> L27
    L22:
        throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, r103);     // Catch: JSONException -> L27
    L24:
        throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, r103);     // Catch: JSONException -> L27
    L26:
        throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, r103);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        i.a(e, "ShareUrlSearchHandler", "paseJSON");
        return null;
    }

    @Override // com.amap.api.col.s.a
    public final /* synthetic */ String a(String r100) throws AMapException {
        return b(r100);
    }

    public ak(Context r100, String r101) {
        super(r100, r101);
        this.f26043j = r101;
    }
}
