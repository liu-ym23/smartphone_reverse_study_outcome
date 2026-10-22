package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.ExecutionBundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.y2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1628y2<T, V> extends Q1<T, V> {
    public AbstractC1628y2(Context context, T t10) {
        super(context, t10);
        this.f16102y = false;
    }

    @Override // com.amap.api.col.jmsl.I1
    public V c(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e10) {
            C1631z1.o(e10, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        C1631z1.w(str);
        return f(str);
    }

    @Override // com.amap.api.col.jmsl.Q1, com.amap.api.col.jmsl.s7
    public byte[] getEntityBytes() {
        return null;
    }

    @Override // com.amap.api.col.jmsl.Q1, com.amap.api.col.jmsl.I1, com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Accept-Encoding", "gzip");
        map.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, "AMAP SDK Android Search 9.8.1");
        map.put("X-INFO", J0.c(this.f16099B));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.8.1", ExecutionBundle.PREF_CLOUD));
        map.put("logversion", "2.1");
        return map;
    }

    public CloudItemDetail o(JSONObject jSONObject) throws JSONException {
        String strOptString;
        CloudItemDetail cloudItemDetail = new CloudItemDetail(C1531a0.D(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), C1531a0.D(jSONObject, "title"), C1531a0.D(jSONObject, Const.JSON_KEY_ADDRESS));
        cloudItemDetail.setCreatetime(C1531a0.D(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(C1531a0.D(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance") && (strOptString = jSONObject.optString("_distance")) != null && !strOptString.equals("") && !strOptString.equals("[]")) {
            cloudItemDetail.setDistance(Integer.parseInt(strOptString));
        }
        return cloudItemDetail;
    }

    public void p(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        HashMap<String, String> map = new HashMap<>();
        if (itKeys == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next != null) {
                map.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(map);
    }
}
