package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ANRUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7173a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ActivityManager.ProcessErrorStateInfo f7175c;

    static {
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 34) goto L9;
        if (j.a() == false) goto L9;
        return b();
    L9:
        return c();
    }

    private static boolean b() {
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L12;
        r1 = r1 + 1;
        if (c() == true) goto L8;
        Thread.sleep(20);     // Catch: Throwable -> L13
        goto L4
    L8:
        return true;
    L12:
        return false;
    }

    private static boolean c() {
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        int r3 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r4 = r0.getRunningAppProcesses();
        if (r4 == null) goto L15;
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r6 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r5.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        if (r6.pid != r3) goto L9;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        return false;
    L18:
        List<ActivityManager.ProcessErrorStateInfo> r1 = r0.getProcessesInErrorState();
        if (r1 == null) goto L30;
        Iterator<ActivityManager.ProcessErrorStateInfo> r2 = r1.iterator();
    L22:
        if (r2.hasNext() == false) goto L30;
        ActivityManager.ProcessErrorStateInfo r8 = (ActivityManager.ProcessErrorStateInfo) ZeusTransformUtils.preCheckCast(r2.next(), ActivityManager.ProcessErrorStateInfo.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L22;
        if (r8.pid != r3) goto L22;
        if (r8.condition != 1) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L33;
        return false;
    L33:
        return true;
    L30:
        r9 = false;
    L15:
        r7 = false;
        goto L16
    }

    public static String a(Context r2, int r3) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, null);
    }

    public static String a(Context r4, int r5, int[] r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if ((SystemClock.uptimeMillis() - f7173a) >= 5000) goto L33;
        System.out.println("get_anr_info_is_time_out");
        return null;
    L33:
        ActivityManager.ProcessErrorStateInfo r8 = b(r7, r5);     // Catch: Throwable -> L32
        if (r8 == null) goto L25;
        if (Process.myPid() == r8.pid) goto L14;
        if (r6 == null) goto L25;
        if (r8.processName.contains(r7.getPackageName()) == false) goto L25;
    L14:
        ActivityManager.ProcessErrorStateInfo r9 = f7175c;     // Catch: Throwable -> L32
        if (r9 != null) goto L17;
    L20:
        f7175c = r8;     // Catch: Throwable -> L32
        f7174b = null;     // Catch: Throwable -> L32
        f7173a = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        if (r6 == null) goto L24;
        r6[0] = r8.pid;     // Catch: Throwable -> L32
    L24:
        return d.a(r8);
    L17:
        if (d.a(r9, r8) == false) goto L20;
        f7173a = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        return null;
    L25:
        String r10 = f7174b;
        if (r10 == null) goto L31;
        if (r6 == null) goto L29;
        r6[0] = Process.myPid();
    L29:
        f7174b = null;
        f7173a = SystemClock.uptimeMillis();
        return r10;
    L31:
        return null;
    }

    private static ActivityManager.ProcessErrorStateInfo b(Context r7, int r8) {
        ActivityManager r9 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        return null;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r8) goto L20;
        List<ActivityManager.ProcessErrorStateInfo> r3 = r9.getProcessesInErrorState();
        if (r3 == null) goto L16;
        Iterator<ActivityManager.ProcessErrorStateInfo> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        ActivityManager.ProcessErrorStateInfo r5 = (ActivityManager.ProcessErrorStateInfo) ZeusTransformUtils.preCheckCast(r4.next(), ActivityManager.ProcessErrorStateInfo.class, "com.obric.aiagent.plugin");
        if (r5.condition != 2) goto L11;
        return r5;
    L16:
        r2 = r2 + 1;
        if (r8 == r2) goto L20;
        SystemClock.sleep(600);
    L20:
        System.out.println("get_anr_info_times_out");
        return null;
    }

    static void a(Throwable r1) {
        com.bytedance.crash.c.b.a("NPTH_ANR_ERROR", r1);
    }
}
