package v2;

import android.text.TextUtils;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static void a(int r10, List r11, double r12, Map r13) {
        b(r10, r11, new LinkedList(), r12, r13);
    }

    public static void b(int r19, List r20, List r21, double r22, Map r24) {
        String r10 = "/proc/" + r19 + "/task/";
        s3.a.d("APM-CPU", "size: " + r20.size());
        long r11 = t3.a.a();
        Iterator r12 = r20.iterator();
        BufferedReader r13 = null;
    L4:
        if (r12.hasNext() == false) goto L46;
        g r14 = (g) r12.next();
        if (r14 != null) goto L61;
        x3.a.a(r13);
        String r110 = r10;
        Iterator r17 = r12;
    L39:
        r10 = r110;
        r12 = r17;
        goto L4
    L61:
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L36
        r15.append(r10);     // Catch: Throwable -> L36
        r110 = r10;
        r15.append(r14.f());     // Catch: Throwable -> L48
        r15.append("/stat");     // Catch: Throwable -> L48
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream(r15.toString())), 1000);     // Catch: Throwable -> L48
        String r18 = r16.readLine();     // Catch: Throwable -> L33
        String[] r23 = r18.substring(r18.lastIndexOf(41) + 4).split(" ");     // Catch: Throwable -> L33
        long r111 = Long.parseLong(r23[10]) + Long.parseLong(r23[11]);     // Catch: Throwable -> L33
        r17 = r12;
        BufferedReader r112 = r16;
        float r113 = (r111 - r14.e()) / (r11 - r14.c());
        s3.a.d("APM-CPU", r14.g() + " judge: " + r111 + " " + r14.e() + " " + r113 + " " + r22);     // Catch: Throwable -> L22
        if (r24 != null) goto L18;
    L25:
        double r114 = r113;
        if (r114 < r22) goto L28;
        r14.i(r114);     // Catch: Throwable -> L22
        r14.j(Integer.parseInt(r23[18]));     // Catch: Throwable -> L22
    L29:
        s3.a.d("APM-CPU", "after item: " + r14);     // Catch: Throwable -> L22
        x3.a.a(r112);
        r13 = r112;
        goto L39
    L28:
        r21.add(r14);     // Catch: Throwable -> L22
        goto L29
    L18:
        if (r24.containsKey(r14.g()) == false) goto L25;
        double r115 = r113;
        if (r115 < ((Double) r24.get(r14.g())).doubleValue()) goto L24;
        r14.i(r115);     // Catch: Throwable -> L22
        r14.j(Integer.parseInt(r23[18]));     // Catch: Throwable -> L22
        goto L29
    L24:
        r21.add(r14);     // Catch: Throwable -> L22
    L22:
        th = th;
    L23:
        r13 = r112;
    L51:
        s3.a.d("APM-CPU", "error: " + th.getLocalizedMessage());     // Catch: Throwable -> L43
    L38:
        x3.a.a(r13);
    L43:
        th = move-exception;
        x3.a.a(r13);
        throw th;
    L31:
        th = th;
    L32:
        r112 = r16;
    L33:
        th = th;
        r17 = r12;
    L35:
        r17 = r12;
        r21.add(r14);     // Catch: Throwable -> L40
    L40:
        th = th;
    L36:
        r110 = r10;
        goto L35
    L46:
        r20.removeAll(r21);
        s3.a.d("APM-CPU", "after size: " + r20.size());
    }

    public static void c(int r14, List r15) {
        File[] r16 = new File("/proc/" + r14 + "/task/").listFiles();
        long r10 = t3.a.a();
        int r11 = r16.length;
        BufferedReader r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L22;
        BufferedReader r17 = new BufferedReader(new InputStreamReader(new FileInputStream(r16[r13].getPath() + "/stat")), 1000);     // Catch: Throwable -> L23
        String r18 = r17.readLine();     // Catch: Throwable -> L18
        int r19 = r18.lastIndexOf(41);     // Catch: Throwable -> L18
        String r20 = r18.substring(0, r19);     // Catch: Throwable -> L18
        String r21 = r18.substring(r19 + 4);     // Catch: Throwable -> L18
        int r22 = r20.indexOf(40);     // Catch: Throwable -> L18
        int r23 = Integer.valueOf(r20.substring(0, r22 - 1)).intValue();     // Catch: Throwable -> L18
        String r24 = r20.substring(r22 + 1);     // Catch: Throwable -> L18
        String[] r25 = r21.split(" ");     // Catch: Throwable -> L18
        long r110 = Long.parseLong(r25[10]) + Long.parseLong(r25[11]);     // Catch: Throwable -> L18
        if (r23 != 0) goto L9;
    L15:
        i5.d.b(r17);
        r12 = r17;
    L21:
        r13 = r13 + 1;
        goto L3
    L9:
        if (r24.isEmpty() == true) goto L15;
        if (r110 == 0) goto L15;
        if (Thread.currentThread().getName().contains(r24) == true) goto L15;
        g r26 = new g();     // Catch: Throwable -> L18
        r26.o(r24);     // Catch: Throwable -> L18
        r26.n(r23);     // Catch: Throwable -> L18
        r26.m(r110);     // Catch: Throwable -> L18
        r26.k(r10);     // Catch: Throwable -> L18
        r26.j(Integer.parseInt(r25[14]));     // Catch: Throwable -> L18
        r15.add(r26);     // Catch: Throwable -> L18
    L18:
        r12 = r17;
    L20:
        i5.d.b(r12);
        goto L21
    }

    public static void d(int r10, Map r11) {
        File[] r12 = new File("/proc/" + r10 + "/task/").listFiles();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L15;
        int r15 = Integer.parseInt(r12[r14].getName());     // Catch: NumberFormatException -> L16
        ThreadStatInfo r16 = PerfMonitorManager.o().k(r10, r15);     // Catch: NumberFormatException -> L16
        if (r15 == 0) goto L14;
        if (r16 == null) goto L14;
        if (TextUtils.isEmpty(r16.threadName) == true) goto L14;
        if (r16.threadCpuTime == 0) goto L14;
        g r17 = new g();     // Catch: NumberFormatException -> L16
        r17.n(r15);     // Catch: NumberFormatException -> L16
        r17.o(r16.threadName);     // Catch: NumberFormatException -> L16
        r17.m(r16.threadCpuTime);     // Catch: NumberFormatException -> L16
        r11.put(Integer.valueOf(r15), r17);     // Catch: NumberFormatException -> L16
    L14:
        r14 = r14 + 1;
        goto L3
    }
}
