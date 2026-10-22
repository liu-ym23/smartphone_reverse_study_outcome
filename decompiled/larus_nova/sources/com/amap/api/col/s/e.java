package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public abstract class e<T, V> extends b<T, V> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.cy
    public final byte[] g() {
        return null;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> f() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", "application/x-www-form-urlencoded");
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        r100.put("User-Agent", "AMAP SDK Android Search 7.7.0");
        r100.put("X-INFO", bl.a(this.f25994e));
        r100.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"7.7.0", "cloud"}));
        r100.put("logversion", "2.1");
        return r100;
    }

    public static CloudItemDetail b(JSONObject r100) throws JSONException {
        CloudItemDetail r101 = new CloudItemDetail(p.a(r100, "id"), new LatLonPoint(r100.optDouble("point_y"), r100.optDouble("point_x")), p.a(r100, "title"), p.a(r100, "address"));
        r101.setCreatetime(p.a(r100, "gmt_create"));
        r101.setUpdatetime(p.a(r100, "gmt_modified"));
        if (r100.has("_distance") == false) goto L15;
        String r102 = r100.optString("_distance");
        if (r102 != null) goto L7;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        r101.setDistance(CastIntegerProtector.parseInt(r102));
        goto L15
    L7:
        if (r102.equals("") == true) goto L12;
        if (r102.equals("[]") == true) goto L12;
        r103 = false;
    L15:
        return r101;
    }

    @Override // com.amap.api.col.s.a
    public final V a(byte[] r100) throws AMapException {
        String r101 = new String(r100, XML.CHARSET_UTF8);     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L9;
    L13:
        return null;
    L9:
        if (r101.equals("") == true) goto L13;
        i.c(r101);
        return a(r101);
    L5:
        e = move-exception;
        i.a(e, "ProtocalHandler", "loadData");
        r101 = null;
        goto L7
    }

    public static JSONArray a(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("data");
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.optJSONArray("list");
    }

    public e(Context r100, T r101) {
        super(r100, r101);
        this.f25990a = false;
    }

    public static void a(CloudItem r100, JSONObject r101) {
        Iterator<String> r102 = r101.keys();
        HashMap<String, String> r103 = new HashMap();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.hasNext() == false) goto L10;
        String r104 = r102.next();
        if (r104 == null) goto L6;
        String r105 = r101.optString(r104.toString());
        r103.put(r104.toString(), r105);
        goto L6
    L10:
        r100.setCustomfield(r103);
    }
}
