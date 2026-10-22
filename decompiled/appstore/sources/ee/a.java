package ee;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.slardaros.client.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f19412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f19413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f19414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f19415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f19416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f19417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f19418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f19419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f19420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f19421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f19422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f19423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f19424m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f19425n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f19426o;

    /* JADX INFO: renamed from: ee.a$a, reason: collision with other inner class name */
    public class RunnableC0247a implements Runnable {
        public RunnableC0247a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.i();
        }
    }

    public static void a(long r10, long r11, long r12, long r13, long r14, long r15) {
        f19412a = r10;
        f19413b = r11;
        f19414c = r12;
        f19415d = r13;
        f19416e = r14;
        f19417f = r15;
    }

    public static void b() {
        Log.d("monitor plugin", "launcherActivityOnCreateEnd");
        if (f19419h == 0) goto L5;
        return;
    L5:
        if (f19425n == false) goto L9;
        f19419h = System.currentTimeMillis();
        return;
    }

    public static void c(String r10) {
        Log.d("monitor plugin", "launcherActivityOnCreateStart");
        if (f19418g != 0) goto L8;
        long r11 = System.currentTimeMillis();
        f19418g = r11;
        if ((r11 - f19417f) >= 800) goto L9;
        f19425n = true;
        f19426o = r10;
        return;
    L9:
        return;
    }

    public static void d() {
        if (f19423l == 0) goto L5;
        return;
    L5:
        if (f19425n == false) goto L9;
        f19423l = System.currentTimeMillis();
        return;
    }

    public static void e(String r10) {
        if (f19422k == 0) goto L5;
        return;
    L5:
        if (f19425n == false) goto L9;
        f19422k = System.currentTimeMillis();
        return;
    }

    public static void f(String r10) {
        Log.d("monitor plugin", "launcherActivityOnStartStart");
        if (f19421j == 0) goto L5;
        return;
    L5:
        if (f19425n == false) goto L9;
        f19421j = System.currentTimeMillis();
        return;
    }

    public static void g(String r10) {
        Log.d("monitor plugin", "launcherActivityOnStartStart");
        if (f19420i == 0) goto L5;
        return;
    L5:
        if (f19425n == false) goto L9;
        f19420i = System.currentTimeMillis();
        return;
    }

    public static void h(String r10) {
        if (f19424m == 0) goto L5;
    L9:
        new Thread(new RunnableC0247a()).start();
        return;
    L5:
        if (f19416e <= 0) goto L9;
        if (f19425n == false) goto L9;
        f19424m = System.currentTimeMillis();
        f19426o = r10;
        f19425n = false;
        goto L9
    }

    public static void i() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put("is_first_start", d.d());     // Catch: JSONException -> L4
        r10.put("activity_name", f19426o);     // Catch: JSONException -> L4
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L4
        r11.put("app_construct_time", f19413b - f19412a);     // Catch: JSONException -> L4
        r11.put("app_attach_base_context_time", f19415d - f19414c);     // Catch: JSONException -> L4
        r11.put("app_create_time", f19417f - f19416e);     // Catch: JSONException -> L4
        r11.put("activity_create_time", f19419h - f19418g);     // Catch: JSONException -> L4
        r11.put("activity_start_time", f19421j - f19420i);     // Catch: JSONException -> L4
        r11.put("activity_resume_time", f19423l - f19422k);     // Catch: JSONException -> L4
        r11.put("activity_window_focus_changed", f19424m - f19423l);     // Catch: JSONException -> L4
        r11.put(ICronetClient.KEY_TOTAL_TIME, f19424m - f19412a);     // Catch: JSONException -> L4
        de.a.c("app_startup_event", r10, r11, null);     // Catch: JSONException -> L4
        return;
    }
}
