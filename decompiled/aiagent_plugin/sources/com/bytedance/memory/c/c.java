package com.bytedance.memory.c;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.util.f;
import com.bytedance.crash.Npth;
import com.bytedance.memory.b.e;
import com.bytedance.memory.b.h;
import com.bytedance.memory.heap.HeapDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: HeapDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final File f8784a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f8785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f8786d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f8787b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8788e;

    static {
    }

    static /* synthetic */ void a(c r0, int r1) {
        r0.a(r1);
    }

    private c() {
        this.f8788e = System.currentTimeMillis();
        this.f8787b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.memory.a.a.c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public static c a() {
        if (f8785c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8785c != null) goto L9;
        f8785c = new c();     // Catch: Throwable -> L11
        f8786d = b.i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f8785c;
    }

    public void a(long r3) {
        int r1 = 2;
        if (com.bytedance.memory.a.a.c().e().a() == 2) goto L6;
        r1 = 1;
    L6:
        a(r3, r1);
    }

    public void a(long r1, final int r3) {
        this.f8788e = r1;
        com.bytedance.memory.heap.a.a().k();
        if (com.bytedance.memory.a.a.c().e().a() != 2) goto L5;
        com.bytedance.memory.b.b.f8771b.a(new AnonymousClass1(this, r3), "HeapDumper-dumpHeap");
        return;
    L5:
        a(r3);
    }

    private void a(int r2) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (b() == false) goto L11;
        b(r2);     // Catch: Exception -> L6
        com.bytedance.memory.i.a.a().c();     // Catch: Exception -> L6
        return;
    }

    public boolean b() {
        long r0 = c();     // Catch: Exception -> L11
        long r2 = com.bytedance.apm.util.b.e();     // Catch: Exception -> L11
        if (r0 > 0) goto L6;
        return false;
    L6:
        if (r2 > 0) goto L8;
        return false;
    L8:
        if (r0 <= (r2 * 1.5f)) goto L19;
        return true;
    L19:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private long c() {
        if (TextUtils.isEmpty(com.bytedance.memory.a.a.c().a()) == true) goto L8;
        return a(new File(com.bytedance.memory.a.a.c().a()));
    L8:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L10;
        return 0;
    L10:
        return a(f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    L15:
        return 0;
    }

    public static long a(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getAvailableBytes();
    L8:
        return ((long) r0.getBlockCount()) * r0.getBlockSize();
    L9:
        return 0;
    }

    private void b(int r12) {
        long r0 = System.nanoTime();
        File r2 = f8786d.j();
        File r3 = f8784a;
        if (r2 != r3) goto L5;
        return;
    L5:
        File r4 = r2.getParentFile();
        if (r4.exists() == true) goto L8;
        r4.mkdirs();
    L8:
        long r5 = System.currentTimeMillis();
        com.bytedance.memory.d.a.b("dump_begin");
        com.bytedance.memory.f.a.b r6 = com.bytedance.memory.a.a.c().e().h();
        if (r6 != null) goto L11;
    L16:
        File r13 = a(r2, r12);
        com.bytedance.memory.heap.a.a().a(false);
    L17:
        com.bytedance.memory.d.a.b("dump_end");
        com.bytedance.memory.d.a.a("dump_time", System.currentTimeMillis() - r5);
        if (r13 != r3) goto L20;
        return;
    L20:
        a(r13, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r0));
        com.bytedance.memory.heap.a.a().a(System.currentTimeMillis());
        return;
    L11:
        if (com.bytedance.memory.d.a.e("close_native_dump_and_shrink") == true) goto L16;
        File r9 = new File(b.i().a(), ".mini.hprof");
        if (r6.a(r9) == false) goto L15;
        r13 = b(r9);
        goto L17
    L15:
        r13 = a(r2, r12);
        com.bytedance.memory.heap.a.a().a(false);
        goto L17
    }

    private HeapDump a(File r4, long r5) {
        HeapDump r3 = HeapDump.newBuilder().a(r4).d(0).a(this.f8788e).b(r4.length()).a(e.f8775a).e(r5).a();
        com.bytedance.memory.b.c.a(r3.toString(), new Object[0]);
        com.bytedance.memory.heap.a.a().a(r3);
        return r3;
    }

    private File a(File r3, int r4) {
        if (r4 != 2) goto L5;
        com.bytedance.memory.b.c.a("Native dump", new Object[0]);     // Catch: Exception -> L8
        Npth.dumpHprof(r3.getAbsolutePath());     // Catch: Exception -> L8
        com.bytedance.memory.b.c.a("Native dump exist ? " + new File(r3.getAbsolutePath()).exists(), new Object[0]);     // Catch: Exception -> L8
    L6:
        com.bytedance.memory.heap.a.a().b(com.bytedance.apm.c.q().optString("update_version_code"));     // Catch: Exception -> L8
        return r3;
    L5:
        Debug.dumpHprofData(r3.getAbsolutePath());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.memory.b.c.a(e, "Could not realDump heap", new Object[0]);
        return f8784a;
    }

    private File b(File r5) {
        String r4 = com.bytedance.apm.c.q().optString("device_id");
        String r0 = com.bytedance.apm.c.q().optString("update_version_code");
        com.bytedance.memory.heap.a.a().b(r0);
        File r1 = new File(r5.getParent(), r4 + "_" + r0 + "_shrink.zip");
        h.a(r5, r1);
        if (r5.exists() == false) goto L5;
        r5.delete();
    L5:
        com.bytedance.memory.heap.a.a().a(true);
        com.bytedance.memory.heap.a.a().a(r1.getAbsolutePath());
        com.bytedance.memory.heap.a.a().a(4);
        return r1;
    }
}
