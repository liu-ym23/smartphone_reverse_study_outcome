package H;

import android.app.Application;
import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.services.apm.api.IHttpService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static Application f711a;
    public static boolean b;
    public static long k;
    public static long l;
    public static long m;
    public static String n;
    public static boolean o;

    /* renamed from: q, reason: collision with root package name */
    public static String f713q;

    /* renamed from: r, reason: collision with root package name */
    public static j f714r;

    /* renamed from: s, reason: collision with root package name */
    public static String f715s;

    /* renamed from: t, reason: collision with root package name */
    public static String f716t;
    public static boolean u;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f717v;

    /* renamed from: w, reason: collision with root package name */
    public static String f718w;
    public static MonitorCrash y;
    public static JSONObject c = new JSONObject();
    public static JSONObject d = new JSONObject();
    public static L.a e = new F1.a();
    public static HashMap f = new HashMap();
    public static IHttpService g = new DefaultHttpServiceImpl();
    public static long h = -1;
    public static volatile int i = -1;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f712j = true;
    public static String p = "";

    /* renamed from: x, reason: collision with root package name */
    public static boolean f719x = true;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f720z = false;

    public static String a() {
        JSONObject jSONObject = c;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("aid"))) ? "" : c.optString("aid");
    }

    public static void b(String str, String str2) {
        JSONObject jSONObject = c;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(str, str2);
            JSONObject jSONObject2 = d;
            if (jSONObject2 != null) {
                jSONObject2.put(str, str2);
            }
        } catch (JSONException unused) {
        }
    }

    public static String c() {
        if (TextUtils.isEmpty(n)) {
            n = D2.b.a();
        }
        return n;
    }

    public static JSONObject d() {
        JSONObject jSONObject = c;
        if (jSONObject != null) {
            try {
                jSONObject.put("user_id", e.getUserId());
                c.put("device_id", e.getDid());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return c;
    }

    public static synchronized Map e() {
        HashMap map = f;
        if (map == null) {
            return null;
        }
        map.put("device_id", e.getDid());
        f.put("uid", e.getUserId());
        return f;
    }

    public static long f() {
        if (h == -1) {
            h = System.currentTimeMillis();
        }
        return h;
    }

    public static boolean g() {
        Application application;
        if (o) {
            return true;
        }
        String strC = c();
        if (strC == null || !strC.contains(":")) {
            o = (strC == null || (application = f711a) == null || !strC.equals(application.getPackageName())) ? false : true;
        } else {
            o = false;
        }
        return o;
    }
}
