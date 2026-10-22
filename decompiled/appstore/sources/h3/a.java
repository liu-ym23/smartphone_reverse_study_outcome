package h3;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20322d;

    /* JADX INFO: renamed from: h3.a$a, reason: collision with other inner class name */
    public static class C0263a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20323a = null;

        static {
            f20323a = new a();
        }

        public static /* synthetic */ a a() {
            return f20323a;
        }
    }

    public a() {
    }

    public static a h() {
        return C0263a.a();
    }

    public static Debug.MemoryInfo j() {
        if (r3.a.b() != null) goto L11;
        return null;
    L11:
        ActivityManager r10 = (ActivityManager) r3.a.b().getSystemService("activity");     // Catch: Exception -> L10
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    L10:
        return null;
    }

    public k3.a a(j3.a r33) {
        Debug.MemoryInfo r10 = j();
        if (r10 != null) goto L5;
        return null;
    L5:
        long r19 = d(r10);
        if (r19 >= 0) goto L8;
        return null;
    L8:
        ActivityLifecycleService r11 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
        long r13 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double r25 = i(r13);
        long r12 = e();
        long r14 = f();
        long r15 = b();
        long r16 = c();
        boolean r17 = !r11.isForeground();
        long r21 = ((long) r10.nativePss) * 1024;
        long r18 = 1024 * ((long) r10.getTotalPss());
        long r20 = g(r10);
        long r23 = k();
        if (r25 <= r33.f()) goto L11;
        boolean r27 = true;
    L13:
        return new k3.a(r12, r14, r15, r16, r17, r21, r18, r13, r19, r20, r23, r25, r27, r33.b());
    L11:
        r27 = false;
        goto L13
    }

    public final long b() {
        long r10 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT));
        long r11 = r10 - this.f20321c;
        this.f20321c = r10;
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-Memory", "blockingGcCount:" + this.f20321c);
    L5:
        return r11;
    }

    public final long c() {
        long r10 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME));
        long r11 = r10 - this.f20322d;
        this.f20322d = r10;
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-Memory", "blockingGcTime:" + this.f20322d);
    L5:
        return r11;
    }

    public final long d(Debug.MemoryInfo r10) {
        return ((long) r10.dalvikPss) * 1024;
    }

    public final long e() {
        long r10 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT));
        long r11 = r10 - this.f20319a;
        this.f20319a = r10;
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-Memory", "gcCount:" + r10);
    L5:
        return r11;
    }

    public final long f() {
        long r10 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME));
        long r11 = r10 - this.f20320b;
        this.f20320b = r10;
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-Memory", "gcTime:" + this.f20320b);
    L5:
        return r11;
    }

    public final long g(Debug.MemoryInfo r10) {
        String r11 = r10.getMemoryStat(PerfConsts.GRAPHICS_MEM);
        if (TextUtils.isEmpty(r11) == true) goto L13;
        return ((long) Integer.parseInt(r11)) * 1024;
    L7:
        e = move-exception;
        s3.a.c("APM-Memory", "getGraphics", e);
        e.printStackTrace();
        return -1;
    L13:
        return -1;
    }

    public final double i(long r10) {
        if (r10 > 0) goto L5;
        return -1.0d;
    L5:
        return new BigDecimal(r10).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    }

    public final long k() {
        long r10 = b.c() * 1024;
        if (r10 <= 0) goto L5;
        return r10;
    L5:
        return -1;
    }

    public void l() {
        e();
        f();
        b();
        c();
    }
}
