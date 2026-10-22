package F;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Map f507a;
    public Map b;
    public Map c;
    public JSONObject d;
    public JSONArray e;
    public String f;
    public LinkedHashMap g;
    public LinkedHashMap h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public long f508j;
    public Map k;
    public Map l;
    public Set m;
    public String n;
    public String o;
    public long p;

    /* renamed from: q, reason: collision with root package name */
    public long f509q;

    /* renamed from: r, reason: collision with root package name */
    public long f510r;

    /* renamed from: s, reason: collision with root package name */
    public long f511s;

    /* renamed from: t, reason: collision with root package name */
    public long f512t;
    public long u;

    /* renamed from: v, reason: collision with root package name */
    public JSONObject f513v;

    public static void c(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObjectOptJSONObject.put(next, jSONObjectOptJSONObject2.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        try {
            jSONObject.put(str, jSONObjectOptJSONObject);
        } catch (JSONException unused2) {
        }
    }

    public static String f(String str) {
        int iIndexOf;
        return (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf("?")) >= 0) ? str.substring(0, iIndexOf) : str;
    }

    public final void a(WebView webView, String str, JSONObject jSONObject) {
        Object host;
        JSONObject jSONObjectS0;
        Object obj;
        Object path = "";
        String strH1 = S0.b.h1(BffConstant.Type.Url, jSONObject);
        if (TextUtils.isEmpty(strH1) || strH1.contains("about:blank")) {
            return;
        }
        String strMapService = WebViewMonitorHelper.b.mapService(webView, str);
        if (!TextUtils.equals(str, strMapService) && !TextUtils.isEmpty(strMapService)) {
            try {
                jSONObject.put(NotificationCompat.CATEGORY_SERVICE, strMapService);
            } catch (Exception unused) {
            }
        }
        String strH12 = S0.b.h1(BffConstant.Type.Url, jSONObject);
        try {
            host = new URL(strH12).getHost();
        } catch (Exception unused2) {
            host = "";
        }
        try {
            jSONObject.put("host", host);
        } catch (Exception unused3) {
        }
        try {
            path = new URL(strH12).getPath();
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put(SingleFileBundle.KEY_PATH, path);
        } catch (Exception unused5) {
        }
        d(jSONObject);
        JSONObject jSONObjectS02 = S0.b.S0("nativeInfo", jSONObject);
        String strH13 = S0.b.h1("event_type", jSONObjectS02);
        Map linkedHashMap = this.k;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        Map linkedHashMap2 = this.l;
        if (linkedHashMap2 == null) {
            linkedHashMap2 = new LinkedHashMap();
        }
        if ("performance".equals(strH13)) {
            String strH14 = S0.b.h1(BffConstant.Type.Url, jSONObject);
            try {
                jSONObjectS02.put("offline", (linkedHashMap.containsKey(f(strH14)) || linkedHashMap2.containsKey(f(strH14))) ? 1 : 0);
            } catch (JSONException | Exception unused6) {
            }
        } else if ("static_performance".equals(strH13) && (jSONObjectS0 = S0.b.S0(NotificationCompat.CATEGORY_EVENT, jSONObject)) != null) {
            Object objOpt = jSONObjectS0.opt("resources");
            if (objOpt instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) objOpt;
                while (i < jSONArray.length()) {
                    try {
                        obj = jSONArray.opt(i);
                    } catch (Exception unused7) {
                        obj = new Object();
                    }
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String strH15 = S0.b.h1(HintConstants.AUTOFILL_HINT_NAME, jSONObject2);
                        boolean zContainsKey = linkedHashMap.containsKey(f(strH15));
                        boolean zContainsKey2 = linkedHashMap2.containsKey(f(strH15));
                        try {
                            jSONObject2.put("offline", zContainsKey ? 1 : 0);
                        } catch (Exception unused8) {
                        }
                        try {
                            jSONObject2.put("clientOffline", zContainsKey2 ? 1 : 0);
                        } catch (Exception unused9) {
                        }
                    }
                    i++;
                }
                try {
                    jSONObjectS0.put("resources", jSONArray);
                } catch (JSONException unused10) {
                }
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, jSONObjectS0);
            }
        }
        WebViewMonitorHelper.b.getMonitor(webView).c(jSONObject);
    }

    public final void b(String str) {
        JSONObject jSONObject = this.f513v;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, (jSONObject != null ? jSONObject.optInt(str, 0) : 0) + 1);
        } catch (Exception unused) {
        }
    }

    public final void d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("navigation_id", this.f);
        } catch (Exception unused) {
        }
        try {
            jSONObject2.put(BffConstant.Type.Url, this.i);
        } catch (Exception unused2) {
        }
        try {
            jSONObject2.put("container_type", this.o);
        } catch (Exception unused3) {
        }
        try {
            jSONObject2.put("click_start", this.f508j);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("nativeBase", jSONObject2);
        } catch (JSONException unused5) {
        }
    }

    public final void e(String str) {
        String str2 = this.i;
        JSONObject jSONObjectL0 = S0.b.l0(str);
        String str3 = this.f;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.g.put(f(str2), str3);
        this.h.put(str3, f(str2));
        Map linkedHashMap = this.f507a;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        JSONObject jSONObject = (JSONObject) linkedHashMap.get(str3);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectL0.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject.put(next, jSONObjectL0.opt(next));
            } catch (JSONException unused) {
            }
        }
        linkedHashMap.put(str3, jSONObject);
        this.f507a = linkedHashMap;
    }
}
