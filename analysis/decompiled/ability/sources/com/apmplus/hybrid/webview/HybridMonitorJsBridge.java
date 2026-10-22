package com.apmplus.hybrid.webview;

import H.h;
import O.a;
import P.b;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* loaded from: classes2.dex */
public class HybridMonitorJsBridge {
    public HybridMonitorJsBridge(WebView webView) {
    }

    @JavascriptInterface
    public int getAid() {
        try {
            return Integer.parseInt(h.a());
        } catch (Exception unused) {
            return 0;
        }
    }

    @JavascriptInterface
    public void request(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("list");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            a.g().c(new b(0, "hybrid_v2", jSONObjectOptJSONObject));
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"Receive:HybridData_V2"}));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Log.d("ApmInsight", U7.a.e(new String[]{B7.a.k("Receive:", str)}));
        }
    }
}
