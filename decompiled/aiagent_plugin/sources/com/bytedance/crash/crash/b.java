package com.bytedance.crash.crash;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.h;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.i;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f7309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f7310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f7311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f7312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f7313e;
    private final File f;

    static /* synthetic */ void a(b r0, CrashSummary r1, com.bytedance.crash.monitor.a r2, File r3) {
        r0.a(r1, r2, r3);
    }

    public static boolean a(File r2) {
        if (new File(r2, "crash").exists() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static synchronized void a(Context r3, File r4) {
        monitor-enter(b.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        r.b("CrashManager startMonitor");     // Catch: Throwable -> L9
        if (f7309a != null) goto L7;
        f7309a = new b(r5, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(b.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    b(Context r4, File r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        File r0 = i.a(r5, "crash");
        this.f7310b = r0;
        i.a(r5, "protector");
        File r1 = new File(r0, b());
        this.f = r1;
        a r2 = new a(r1);
        this.f7313e = new c(r5);
        this.f7311c = new d(r2);
        com.bytedance.crash.c.a.a("JavaCrash_Init");
        this.f7312d = new f(r6, r2);
        com.bytedance.crash.c.a.a("NativeCrash_Init");
    }

    public static File a() {
        b r0 = f7309a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f7310b;
    }

    public static String b() {
        return a(com.bytedance.crash.i.f(), Process.myPid());
    }

    public static String a(long r1, int r3) {
        return r1 + "-" + r3;
    }

    public static void c() {
        NativeBridge.c();
    }

    public static void d() {
        NativeBridge.d();
    }

    public static void b(long r1, int r3) {
        com.bytedance.crash.i.a(true);
        b r0 = f7309a;
        if (r0 == null) goto L6;
        r0.f7312d.a(r1, r3);
        return;
    }

    public static List<CrashSummary> a(Context r5) {
        File[] r6 = new File(com.bytedance.crash.i.a((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")), "crash").listFiles();
        if (r6 != null) goto L6;
        return null;
    L6:
        NativeBridge.a();
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        CrashSummary r3 = CrashSummary.loadFromDirectory(r6[r2], true);
        if (r3 == null) goto L12;
        r0.add(r3);
    L12:
        r2 = r2 + 1;
        goto L7
    L13:
        return r0;
    }

    private void a(com.bytedance.crash.monitor.a r10, File[] r11) {
        int r0 = r11.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        File r2 = r11[r1];
        if (r2.getName().equals(this.f.getName()) == true) goto L11;
        r.b("uploadAll " + r2.getAbsolutePath());
        CrashSummary r3 = CrashSummary.loadFromDirectory(r2);
        if (r3 == null) goto L10;
        com.bytedance.crash.n.d.a(r3.mCrashType, r3.getProcessName(), r3.getPid(), r3.getCrashTime());
        r.b("uploadAll create summary");
        JSONObject r4 = new JSONObject();
        com.bytedance.crash.a.b.a(r10, r3, r2, r4);
        r3.upload(r10, r4);
        goto L11
    L10:
        r.b("uploadAll delete dir" + r2.getAbsolutePath());
        i.c(r2);
        com.bytedance.crash.c.b.a("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r2.getAbsolutePath()));
    L11:
        r1 = r1 + 1;
        goto L3
    }

    private void a(final com.bytedance.crash.monitor.a r12, File[] r13, long r14) {
        final ArrayList r0 = new ArrayList();
        final ArrayList r1 = new ArrayList();
        int r2 = r13.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L16;
        File r4 = r13[r3];
        if (r4.getName().equals(this.f.getName()) == true) goto L14;
        r.b("uploadAll " + r4.getAbsolutePath());
        CrashSummary r5 = CrashSummary.loadFromDirectory(r4);
        if (r5 == null) goto L13;
        com.bytedance.crash.n.d.a(r5.mCrashType, r5.getProcessName(), r5.getPid(), r5.getCrashTime());
        if ((r5.getCrashTime() - r5.getStartTime()) <= h.b()) goto L12;
        r0.add(r5);
        r1.add(r4);
        goto L14
    L12:
        a(r5, r12, r4);
        goto L14
    L13:
        r.b("uploadAll delete dir" + r4.getAbsolutePath());
        i.c(r4);
        com.bytedance.crash.c.b.a("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r4.getAbsolutePath()));
    L14:
        r3 = r3 + 1;
        goto L3
    L16:
        if (r0.isEmpty() == true) goto L24;
        DefaultWorkThread.postDelayed(new AnonymousClass1(this, r0, r12, r1), r14);
        return;
    }

    private void a(CrashSummary r2, com.bytedance.crash.monitor.a r3, File r4) {
        r.b("uploadAll create summary");
        JSONObject r1 = new JSONObject();
        com.bytedance.crash.a.b.a(r3, r2, r4, r1);
        if (r2.mCrashType != CrashType.JAVA) goto L5;
    L6:
        l.a(r1, "from_custom", false);
    L7:
        r2.upload(r3, r1);
        return;
    L5:
        if (r2.mCrashType != CrashType.LAUNCH) goto L7;
        goto L6
    }

    private void b(final com.bytedance.crash.monitor.a r4, long r5) {
        File[] r0 = this.f7310b.listFiles();
        if (r0 == null) goto L8;
        r.b("uploadAll:crashDumpDir:" + this.f.getName());
        if (r5 <= 0) goto L7;
        a(r4, r0, r5);
        goto L8
    L7:
        a(r4, r0);
    L8:
        DefaultWorkThread.postDelayed(new AnonymousClass2(this, r4), r5);
    }

    public static void a(com.bytedance.crash.monitor.a r1, long r2) {
    L6:
        e = move-exception;
        com.bytedance.crash.c.b.b("NPTH_ANR_ERROR_AppMonitor", e);
        return;
    L3:
        if (f7309a == null) goto L11;
        r.b("uploadAll");     // Catch: Exception -> L6
        f7309a.b(r1, r2);     // Catch: Exception -> L6
        return;
    }
}
