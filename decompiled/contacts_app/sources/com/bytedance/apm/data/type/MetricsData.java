package com.bytedance.apm.data.type;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MetricsData implements ITypeData {
    public String key;
    public String type;
    public float value;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "timer";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "timer";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return false;
    }

    public MetricsData(String r1, String r2, float r3) {
        this.type = r1;
        this.key = r2;
        this.value = r3;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);     // Catch: JSONException -> L5
        r0.put("key", this.key);     // Catch: JSONException -> L5
        r0.put("value", this.value);     // Catch: JSONException -> L5
        return r0;
    L5:
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r1) {
        return SamplerHelper.getMetricSwitch(this.type);
    }
}
