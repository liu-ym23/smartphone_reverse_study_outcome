package g0;

import L0.h;
import android.app.ActivityManager;
import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.ConcurrentModificationException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public h f4462a;
    public c h;
    public volatile boolean b = false;
    public long c = 2500;
    public long d = 5000;
    public final StringBuilder f = new StringBuilder(1200);
    public final StringBuilder g = new StringBuilder(1200);
    public final f i = new f(this, 0);

    /* renamed from: j, reason: collision with root package name */
    public final f f4463j = new f(this, 1);
    public final String e = g.class.getName();

    public static JSONObject a(g gVar) {
        gVar.getClass();
        try {
            JSONObject jSONObject = new JSONObject();
            Application application = H.h.f711a;
            if (application != null) {
                ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                jSONObject.put("availMem", memoryInfo.availMem);
                jSONObject.put("lowMemory", memoryInfo.lowMemory);
                jSONObject.put("threshold", memoryInfo.threshold);
                jSONObject.put("totalMem", memoryInfo.totalMem);
            }
            Runtime runtime = Runtime.getRuntime();
            jSONObject.put("max_memory", runtime.maxMemory());
            jSONObject.put("free_memory", runtime.freeMemory());
            jSONObject.put("total_memory", runtime.totalMemory());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject b(g gVar, c cVar) {
        gVar.getClass();
        long j5 = cVar.c;
        String str = cVar.f4457a;
        long j6 = j5 - cVar.b;
        JSONObject jSONObject = new JSONObject();
        try {
            String[] strArrSplit = str.split(" ");
            jSONObject.put("looper_msg", str);
            jSONObject.put("handler", strArrSplit[4]);
            jSONObject.put("message", strArrSplit[6]);
        } catch (Exception unused) {
        }
        jSONObject.put("timestamp", cVar.d);
        jSONObject.put("crash_time", cVar.d);
        jSONObject.put("is_main_process", H.h.g());
        jSONObject.put("process_name", H.h.c());
        jSONObject.put("block_duration", j6);
        jSONObject.put("last_scene", cVar.k);
        return jSONObject;
    }

    public static void c(c cVar) {
        if (J.e.c) {
            try {
                J.e.b = S0.b.o(",", J.e.f861a);
                J.e.c = false;
            } catch (ConcurrentModificationException unused) {
            }
        }
        String str = J.e.b;
        if (TextUtils.isEmpty(str)) {
            cVar.k = ActivityLifeObserver.getInstance().getTopActivityClassName();
            return;
        }
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, ",");
        sbX.append(ActivityLifeObserver.getInstance().getTopActivityClassName());
        cVar.k = sbX.toString();
    }

    public final void d(boolean z10) {
        c cVar;
        try {
            if (this.f4462a.d != null && (cVar = this.h) != null && cVar.b >= 0 && cVar.c == -1) {
                cVar.c = SystemClock.uptimeMillis();
                this.f4462a.a(this.i);
                this.f4462a.a(this.f4463j);
                c cVar2 = this.h;
                if (cVar2.c - cVar2.b > this.c) {
                    c(cVar2);
                    this.h.d = System.currentTimeMillis();
                    L0.d.f925a.b(new C0.c(2, this, z10, this.h.a()));
                }
            }
        } catch (Exception unused) {
        }
    }
}
