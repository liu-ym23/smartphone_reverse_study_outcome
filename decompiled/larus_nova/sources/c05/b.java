package c05;

import android.app.ActivityManager;
import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.ThreadExceptionItem;
import com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.LarkContext;
import eu5.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vt3.h;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f21941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f21942b = 0;

    public static final class a {
        public static ISandboxProcessServer b() {
            ArrayList<String> r100 = g.g(LarkContext.getApplication());     // Catch: Throwable -> L13
            boolean r101 = true;
            if (r100.size() != 1) goto L15;
            String r102 = (String) ListProtector.get(r100, 0);     // Catch: Throwable -> L13
            if (r102 != null) goto L8;
        L10:
            r101 = false;
        L11:
            if (r101 == false) goto L15;
            jrc.b r103 = jrc.b.a.f500175a;     // Catch: Throwable -> L13
            Application r104 = LarkContext.getApplication();     // Catch: Throwable -> L13
            r103.getClass();     // Catch: Throwable -> L13
            ISandboxProcessServer r105 = (ISandboxProcessServer) jrc.b.a(r104, ISandboxProcessServer.class);     // Catch: Throwable -> L13
        L16:
            if (r105 != null) goto L18;
            tt5.a.d("ProcessMonitor_CpuUtils", "sandboxServer is null");     // Catch: Throwable -> L13
        L18:
            return r105;
        L8:
            if (StringsKt.contains$default(r102, "sandboxed_process0", false, 2, null) != true) goto L10;
        L15:
            tt5.a.k("ProcessMonitor_CpuUtils", "sandBoxProcessNames is " + r100);     // Catch: Throwable -> L13
            r105 = null;
        L13:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuUtils", th, false);
            return null;
        }

        public static CpuInfo c(int r110) {
            long r100 = System.currentTimeMillis();
            if ((r100 - b.f21941a) >= 3000) goto L6;
            tt5.a.k("ProcessMonitor_CpuUtils", "getPidCpuRate(" + r110 + "), too frequently");
            return null;
        L6:
            b.f21941a = r100;
            int r101 = com.bytedance.apm.util.b.b();
            if (r101 > 0) goto L9;
            tt5.a.k("ProcessMonitor_CpuUtils", "CommonMonitorUtil.getCpuCoreNum() is null");
            r101 = Runtime.getRuntime().availableProcessors();
        L9:
            if (r101 > 0) goto L12;
            tt5.a.k("ProcessMonitor_CpuUtils", "cpuNum is null");
            return null;
        L12:
            long r102 = com.bytedance.apm.util.b.d(r110);
            long r103 = com.bytedance.monitor.collector.c.e().d(r101);
            Thread.sleep(360);     // Catch: Throwable -> L24 InterruptedException -> L15
        L15:
            boolean r111 = true;
        L16:
            if (r111 == false) goto L18;
            return null;
        L18:
            long r112 = com.bytedance.apm.util.b.d(r110);
            long r113 = com.bytedance.monitor.collector.c.e().d(r101);
            long r114 = r113 - r103;
            if (r114 <= 0) goto L21;
            double r104 = ((r112 - r102) * 1.0f) / r114;
        L22:
            tt5.a.h("ProcessMonitor_CpuUtils", "pidCpuRate -> appCpuRate=" + r104 + ". appCpuStat2=" + r112 + " appCpuStat=" + r102 + " totalCpuStat2=" + r113 + " totalCpuStat=" + r103);
            double r115 = (((((double) r112) - ((double) r102)) * ((double) 1000)) / ((double) (System.currentTimeMillis() - r100))) / ((double) com.bytedance.apm.util.b.f());
            StringBuilder r105 = new StringBuilder("pidCpuSpeed -> ");
            r105.append(r115);
            tt5.a.h("ProcessMonitor_CpuUtils", r105.toString());
            return new CpuInfo(Integer.valueOf(r110), Double.valueOf(r104), Double.valueOf(r115), null);
        L21:
            r104 = -1.0d;
        L14:
            r111 = false;
            goto L16
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static CpuInfo a(String r110, boolean r111) {
            if (TextUtils.isEmpty(r110) == false) goto L31;
            return null;
        L31:
            Object r100 = LarkContext.getApplication().getSystemService("activity");     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L26
            Iterator<ActivityManager.RunningAppProcessInfo> r101 = ((ActivityManager) r100).getRunningAppProcesses().iterator();     // Catch: Throwable -> L26
        L8:
            if (r101.hasNext() == false) goto L28;
            ActivityManager.RunningAppProcessInfo r102 = r101.next();     // Catch: Throwable -> L26
            String r103 = r102.processName;     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L26
            if (StringsKt.contains$default(r103, r110, false, 2, null) == false) goto L8;
            int r112 = r102.pid;     // Catch: Throwable -> L26
            CpuInfo r104 = c(r112);     // Catch: Throwable -> L26
            if (r111 == false) goto L25;
            HashMap r113 = new HashMap();     // Catch: Throwable -> L26
            long r105 = SystemClock.uptimeMillis();     // Catch: Throwable -> L26
            vt3.g.a(r112, r113);     // Catch: Throwable -> L16
        L18:
            HashMap r114 = new HashMap();     // Catch: Throwable -> L26
            Iterator r106 = r113.entrySet().iterator();     // Catch: Throwable -> L26
        L20:
            if (r106.hasNext() == false) goto L22;
            Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L26
            r114.put(r107.getKey(), new ThreadExceptionItem(Long.valueOf(((h) r107.getValue()).f557215c), ((h) r107.getValue()).f557214b, Integer.valueOf(((h) r107.getValue()).f557213a)));     // Catch: Throwable -> L26
            goto L20
        L22:
            if (r104 == 0) goto L24;
            r104.setThreadMap(r114);     // Catch: Throwable -> L26
        L24:
            tt5.a.h("ProcessMonitor_CpuUtils", "thread cost=" + (SystemClock.uptimeMillis() - r105) + " size=" + r113.size() + " val=" + r113);     // Catch: Throwable -> L26
            goto L25
        L16:
            th = move-exception;
            tt5.a.d("ProcessMonitor_CpuUtils", "getThreadInfo error-> " + th.getMessage());     // Catch: Throwable -> L26
        L25:
            return r104;
        L28:
            return null;
        L26:
            th = move-exception;
            tt5.a.f("ProcessMonitor_CpuUtils", th, false);
            goto L28
        }
    }

    static {
    }
}
