package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostLog implements IHostLog {
    private static final String TAG = "LiveHostLog";

    @Override // com.bytedance.android.livehostapi.platform.IHostLog
    public void flush() {
    }

    public LiveHostLog() {
        k.l(IHostLog.class, this);
    }

    private JSONObject mapToJSONObject(Map<String, String> r100) {
        if (r100 == null) goto L16;
        if (r100.isEmpty() == true) goto L16;
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
        JSONObject r102 = new JSONObject();
    L8:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r101.next();
        r102.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L14:
        return r102;
    L16:
        return new JSONObject();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostLog
    public void logV3(String r100, Map<String, String> r101) {
        boolean r102 = "1".equals(r101.get("no_prefix"));
        if (r102 == true) goto L8;
        if (r100.startsWith("tobsdk_") == true) goto L8;
        r100 = "tobsdk_".concat(r100);
    L8:
        if (v.a() == false) goto L10;
        mapToJSONObject(r101).toString();
    L10:
        if (r102 == false) goto L16;
    L14:
        BDLiveSdk.appLog().log(r100, r101);
        return;
    L16:
        r101.put("params_for_special", "livesdk");     // Catch: UnsupportedOperationException -> L13
    L13:
        HashMap r103 = new HashMap(r101);
        r101.put("params_for_special", "livesdk");
        r101 = r103;
        goto L14
    }
}
