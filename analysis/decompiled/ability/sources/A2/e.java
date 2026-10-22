package A2;

import android.app.Application;
import androidx.autofill.HintConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
import z2.l;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: t, reason: collision with root package name */
    public static boolean f79t = true;
    public static boolean u = false;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f80v = false;

    /* renamed from: w, reason: collision with root package name */
    public static int f81w = 1;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f82x = false;
    public static long y = -1;

    /* renamed from: z, reason: collision with root package name */
    public static volatile e f83z;
    public String f;
    public long g;
    public String h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public String f85j;
    public long k;
    public String l;
    public long m;
    public String n;
    public long o;

    /* renamed from: s, reason: collision with root package name */
    public int f88s;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f84a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final LinkedList e = new LinkedList();
    public boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    public long f86q = -1;

    /* renamed from: r, reason: collision with root package name */
    public final int f87r = 50;

    public e(Application application) {
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(new c(this));
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject a(long j5, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, str);
            jSONObject.put("time", j5);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void b(long j5, e eVar, String str, String str2) {
        l.i().a(new b(j5, eVar, str, str2));
    }

    public static e c() {
        if (f83z == null) {
            synchronized (e.class) {
                try {
                    if (f83z == null) {
                        f83z = new e(com.apm.insight.g.b);
                    }
                } finally {
                }
            }
        }
        return f83z;
    }
}
