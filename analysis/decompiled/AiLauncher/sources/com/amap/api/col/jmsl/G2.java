package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class G2 extends AbstractC1628y2<C1561h2, CloudItemDetail> {
    public G2(Context context, C1561h2 c1561h2) {
        super(context, c1561h2);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws JSONException, AMapException {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("data");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray("list") : null;
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(0);
                    CloudItemDetail cloudItemDetailO = o(jSONObject);
                    p(cloudItemDetailO, jSONObject);
                    return cloudItemDetailO;
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1, com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", C1567j0.n(this.f16099B));
        hashtable.put("layerId", ((C1561h2) this.f16103z).f16656a);
        hashtable.put("output", "json");
        hashtable.put("id", ((C1561h2) this.f16103z).f16657b);
        String strB = J0.b();
        String strD = J0.d(this.f16099B, strB, C1604s2.c(hashtable));
        hashtable.put("ts", strB);
        hashtable.put("scode", strD);
        return hashtable;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.f(this.f16099B) + "/datasearch/id";
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        return null;
    }
}
