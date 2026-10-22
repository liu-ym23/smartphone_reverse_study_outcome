package w0;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import x0.C2112a;

/* renamed from: w0.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2082c extends AbstractC2080a {
    public long g;
    public long h;
    public double i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f6807j;

    public static void m(boolean z10, Debug.MemoryInfo memoryInfo, JSONObject jSONObject) throws JSONException, NumberFormatException {
        long j5;
        if (!TextUtils.isEmpty(memoryInfo.getMemoryStat("summary.graphics"))) {
            jSONObject.put(z10 ? "graphics_background" : "graphics_foreground", Integer.parseInt(r8) * 1024);
        }
        String str = z10 ? "vm_size_background" : "vm_size_foreground";
        try {
            String[] strArrSplit = M.a.e(androidx.appfunctions.metadata.a.i(Process.myPid(), "/proc/", "/status")).trim().split("\n");
            int length = strArrSplit.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str2 = strArrSplit[i];
                    if (str2.startsWith("VmSize")) {
                        Matcher matcher = Pattern.compile("\\d+").matcher(str2);
                        if (matcher.find()) {
                            j5 = Long.parseLong(matcher.group());
                            break;
                        }
                    }
                    i++;
                } else if (strArrSplit.length > 12) {
                    Matcher matcher2 = Pattern.compile("\\d+").matcher(strArrSplit[12]);
                    if (matcher2.find()) {
                        j5 = Long.parseLong(matcher2.group());
                    }
                }
            }
        } catch (Exception unused) {
        }
        j5 = -1;
        jSONObject.put(str, j5 * 1024);
    }

    @Override // w0.AbstractC2080a
    public final void b(JSONObject jSONObject) {
        long jOptLong = jSONObject.optLong("collect_interval", 120L);
        if (jOptLong > 0) {
            this.h = jOptLong;
        }
        jSONObject.optBoolean("enable_clear_memory");
        jSONObject.optInt("enable_reach_top_check", 0);
        jSONObject.optDouble("reach_top");
        this.i = jSONObject.optDouble("reach_top_memory_rate", 0.8d);
        Math.max(30L, jSONObject.optLong("memory_reachtop_check_interval", 30L));
        if (this.f6807j) {
            return;
        }
        this.f6807j = true;
    }

    @Override // w0.AbstractC2080a, B.c
    /* renamed from: c */
    public final void mo0c() {
        this.b = false;
        Application application = H.h.f711a;
    }

    @Override // w0.AbstractC2080a, B.c
    public final void f(Activity activity) {
        this.b = true;
        Application application = H.h.f711a;
    }

    @Override // w0.AbstractC2080a
    public final boolean h() {
        return true;
    }

    @Override // w0.AbstractC2080a
    public final void i() {
        this.g = M.a.B();
    }

    @Override // w0.AbstractC2080a
    public final void j() {
        ActivityManager activityManager;
        Debug.MemoryInfo memoryInfo;
        int i;
        try {
            int iMyPid = Process.myPid();
            Application application = H.h.f711a;
            if (application != null) {
                try {
                    activityManager = (ActivityManager) application.getSystemService("activity");
                } catch (Exception unused) {
                }
                memoryInfo = activityManager == null ? null : activityManager.getProcessMemoryInfo(new int[]{iMyPid})[0];
            }
            if (memoryInfo != null && (i = memoryInfo.dalvikPss) > 0) {
                boolean zIsV2Foreground = ActivityLifeObserver.getInstance().isV2Foreground();
                boolean z10 = !zIsV2Foreground;
                int i6 = memoryInfo.nativePss;
                int totalPss = memoryInfo.getTotalPss();
                JSONObject jSONObject = new JSONObject();
                long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                jSONObject.put(!zIsV2Foreground ? "dalvik_pss_background" : "dalvik_pss_foreground", i * 1024);
                jSONObject.put(!zIsV2Foreground ? "native_pss_background" : "native_pss_foreground", i6 * 1024);
                jSONObject.put(!zIsV2Foreground ? "total_pss_background" : "total_pss_foreground", totalPss * 1024);
                jSONObject.put(!zIsV2Foreground ? "java_heap_background" : "java_heap_foreground", jFreeMemory);
                l(z10, jFreeMemory, jSONObject);
                m(z10, memoryInfo, jSONObject);
                JSONObject jSONObjectA = C2086g.b().a("memory");
                jSONObjectA.put("process_name", H.h.c());
                jSONObjectA.put("is_main_process", H.h.g());
                jSONObjectA.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
                P.e eVar = new P.e("memory", "mem_monitor", "", jSONObject, jSONObjectA, null);
                a(eVar);
                if (H.h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"Receive:MemoryData"}));
                }
                JSONObject jSONObjectA2 = eVar.a();
                if (jSONObjectA2 != null) {
                    C2112a.c.a(jSONObjectA2.toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // w0.AbstractC2080a
    public final long k() {
        return this.h * 1000;
    }

    public final void l(boolean z10, long j5, JSONObject jSONObject) throws JSONException {
        if (j5 > 0) {
            double dDoubleValue = new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()).divide(new BigDecimal(this.g), 4, 4).doubleValue();
            jSONObject.put(z10 ? "java_heap_background_used_rate" : "java_heap_foreground_used_rate", dDoubleValue);
            double d = this.i;
            if (d <= 0.5d) {
                d = 0.8d;
            }
            if (dDoubleValue > d) {
                jSONObject.put("reach_top_java", 1);
            }
        }
    }
}
