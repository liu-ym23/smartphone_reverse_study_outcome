package com.stepos.stepclaw.provider.handlers;

import android.os.Bundle;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"bundleToJsonObject", "Lorg/json/JSONObject;", ExtensionCallContract.KEY_EXTRAS, "Landroid/os/Bundle;", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtensionBundleJsonKt {
    public static final JSONObject bundleToJsonObject(Bundle bundle) throws JSONException {
        if (bundle == null || bundle.keySet().isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                jSONObject.put(str, JSONObject.NULL);
            } else if (obj instanceof Bundle) {
                JSONObject jSONObjectBundleToJsonObject = bundleToJsonObject((Bundle) obj);
                if (jSONObjectBundleToJsonObject != null) {
                    jSONObject.put(str, jSONObjectBundleToJsonObject);
                }
            } else if (obj instanceof Boolean) {
                jSONObject.put(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                jSONObject.put(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                jSONObject.put(str, ((Number) obj).longValue());
            } else if (obj instanceof Double) {
                jSONObject.put(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                jSONObject.put(str, ((Number) obj).floatValue());
            } else if (obj instanceof String) {
                jSONObject.put(str, obj);
            } else {
                jSONObject.put(str, obj.toString());
            }
        }
        return jSONObject;
    }
}
