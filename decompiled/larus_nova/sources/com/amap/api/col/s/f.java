package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class f extends e<aa, CloudItemDetail> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> e() {
        Hashtable r100 = new Hashtable(16);
        r100.put("key", bi.f(this.f25994e));
        r100.put("layerId", ((aa) this.f25991b).f25997a);
        r100.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
        r100.put("id", ((aa) this.f25991b).f25998b);
        String r101 = bl.a();
        String r102 = bl.a(this.f25994e, r101, bs.b(r100));
        r100.put("ts", r101);
        r100.put("scode", r102);
        return r100;
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.d() + "/datasearch/id";
    }

    private static CloudItemDetail c(String r100) throws AMapException {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.equals("") == true) goto L26;
        JSONArray r101 = e.a(new JSONObject(r100));     // Catch: Exception -> L14 JSONException -> L16
        if (r101 != null) goto L10;
        return null;
    L10:
        if (r101.length() <= 0) goto L23;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r101, 0);     // Catch: Exception -> L14 JSONException -> L16
        CloudItemDetail r103 = e.b(r102);     // Catch: Exception -> L14 JSONException -> L16
        e.a(r103, r102);     // Catch: Exception -> L14 JSONException -> L16
    L24:
        return r103;
    L23:
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L26:
        return null;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        return c(r100);
    }

    public f(Context r100, aa r101) {
        super(r100, r101);
    }
}
