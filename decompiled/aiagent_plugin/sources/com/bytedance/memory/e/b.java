package com.bytedance.memory.e;

import android.os.Debug;
import com.bytedance.crash.Npth;
import com.bytedance.memory.b.c;
import java.io.File;

/* JADX INFO: compiled from: NpthHprofManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8792b;

    /* JADX INFO: compiled from: NpthHprofManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f8796a = null;

        static /* synthetic */ b a() {
            return f8796a;
        }

        static {
            f8796a = new b(null);
        }
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void a(b r0) {
        r0.e();
    }

    static /* synthetic */ void b(b r0) {
        r0.d();
    }

    private b() {
    }

    public static b a() {
        return a.a();
    }

    public void b() {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.f8792b == true) goto L11;
        this.f8792b = true;     // Catch: Throwable -> L6
        c();     // Catch: Throwable -> L6
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this), 10000);     // Catch: Throwable -> L6
        c.a("registerCrashCallBack", new Object[0]);     // Catch: Throwable -> L6
        return;
    }

    private void c() {
        Npth.registerHprofCallback(new AnonymousClass2(this));
    }

    private void d() {
    L26:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if ((System.currentTimeMillis() - this.f8791a) >= 60000) goto L5;
        return;
    L5:
        this.f8791a = System.currentTimeMillis();     // Catch: Throwable -> L26
        com.bytedance.memory.d.a.b("npth_dump_begin");     // Catch: Throwable -> L26
        com.bytedance.memory.f.a.b r4 = com.bytedance.memory.a.a.c().e().h();     // Catch: Throwable -> L26
        File r0 = com.bytedance.memory.c.b.i().b();     // Catch: Throwable -> L26
        if (r4 != null) goto L9;
    L20:
        File r2 = new File(r0, "npth.jpg");     // Catch: Throwable -> L26
        if (r2.exists() == false) goto L23;
        r2.delete();     // Catch: Throwable -> L26
    L23:
        Debug.dumpHprofData(r2.getAbsolutePath());     // Catch: Throwable -> L26
    L24:
        com.bytedance.memory.d.a.b("npth_dump_end");     // Catch: Throwable -> L26
        c.a("onCrash dump finish:" + r2.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L26
        return;
    L9:
        if (com.bytedance.memory.d.a.e("close_native_dump_and_shrink") == true) goto L20;
        r2 = new File(r0, "npth_mini.jpg");     // Catch: Throwable -> L26
        if (r2.exists() == false) goto L14;
        r2.delete();     // Catch: Throwable -> L26
    L14:
        if (r4.a(r2) == true) goto L24;
        r2 = new File(r0, "npth.jpg");     // Catch: Throwable -> L26
        if (r2.exists() == false) goto L19;
        r2.delete();     // Catch: Throwable -> L26
    L19:
        Debug.dumpHprofData(r2.getAbsolutePath());     // Catch: Throwable -> L26
        goto L24
    }

    private void e() {
        if (com.bytedance.memory.d.a.d("npth_hprof_close_expired") == false) goto L5;
        return;
    L5:
        com.bytedance.memory.b.b.f8771b.a(new AnonymousClass3(this), "checkFileExpired");
    }
}
