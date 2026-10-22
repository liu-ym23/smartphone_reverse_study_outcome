package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.j;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* JADX INFO: compiled from: AnrHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AnrInfoMonitor f7182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final File f7183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final long f7184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.bytedance.crash.anr.b f7185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONArray f7186e;

    /* JADX INFO: compiled from: AnrHandler.java */
    private static class a extends c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Runnable f7187e;
        private final AtomicInteger f;
        private long g;
        private long h;
        private volatile boolean i;

        static /* synthetic */ void a(a r0) {
            r0.a();
        }

        a(AnrInfoMonitor r1, File r2, long r3, boolean r5) {
            super(r1, r2, r3, r5);
            this.f = new AtomicInteger(0);
            this.f7187e = new AnonymousClass1(this);
        }

        @Override // com.bytedance.crash.anr.c
        boolean a(boolean r5) {
            if (r5 == false) goto L8;
            if (this.g == 0) goto L11;
            return true;
        L11:
            return false;
        L8:
            if (this.h == 0) goto L11;
            return true;
        }

        @Override // com.bytedance.crash.anr.c
        void a(long r1, boolean r3, File r4, int r5, int r6) {
            if (a(r1, r3, r4) == true) goto L5;
            return;
        L5:
            a(r5, r6);
            if (r4 == null) goto L8;
            a(r4);
        L8:
            b();
        }

        private boolean a(long r3, boolean r5, File r6) {
            if (this.f.incrementAndGet() > 0) goto L7;
            return false;
        L7:
            if (r5 == false) goto L18;
            monitor-enter(this);
            this.g = r3;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            if (this.h != 0) goto L32;
            DefaultWorkThread.postDelayed(this.f7187e, 35000);
            return true;
        L32:
            return true;
        L14:
            th = move-exception;
            throw th;
        L18:
            if (this.g == 0) goto L20;
            DefaultWorkThread.removeCallbacks(this.f7187e);
        L20:
            monitor-enter(this);
            this.h = b(r6);     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
            return true;
        L25:
            th = move-exception;
            throw th;
        }

        private void a() {
            this.i = true;
            this.f.incrementAndGet();
            b();
        }

        private void b() {
            if (this.f.decrementAndGet() <= 0) goto L6;
            return;
        L6:
            if (this.h != 0) goto L16;
            File r0 = this.f7182a.a(Process.myPid(), this.f7184c);
            monitor-enter(this);
            this.h = b(r0);     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L16:
            if (this.h == 0) goto L19;
            DefaultWorkThread.postDelayed(new AnonymousClass2(this), 120000);
            return;
        L19:
            if (this.i == false) goto L27;
            e.a(this);
            if (this.f.decrementAndGet() >= 0) goto L28;
            com.bytedance.crash.o.i.c(this.f7183b);
            return;
        L28:
            return;
        }
    }

    /* JADX INFO: compiled from: AnrHandler.java */
    private static class b extends c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Runnable f7190e;
        private final AtomicInteger f;

        @Override // com.bytedance.crash.anr.c
        boolean a(boolean r1) {
            return false;
        }

        static /* synthetic */ AtomicInteger a(b r0) {
            return r0.f;
        }

        static /* synthetic */ void b(b r0) {
            r0.a();
        }

        b(AnrInfoMonitor r1, File r2, long r3, boolean r5) {
            super(r1, r2, r3, r5);
            this.f = new AtomicInteger(2);
        }

        @Override // com.bytedance.crash.anr.c
        void a(long r1, boolean r3, File r4, int r5, int r6) {
            if (b() == true) goto L5;
            return;
        L5:
            if (r4 != null) goto L7;
        L9:
            a(r5, r6);
            if (new File(this.f7183b, d.a()).exists() == true) goto L12;
            com.bytedance.crash.o.i.c(new File(this.f7183b, d.a()), "silent anr no anr info");
        L12:
            a();
            return;
        L7:
            if (r4.exists() == false) goto L9;
            b(r4);
            goto L9
        }

        private void a() {
            if (this.f.get() > 0) goto L6;
            a(new File(this.f7183b, d.a()));
            DefaultWorkThread.removeCallbacks(this.f7190e);
            this.f7190e = null;
            e.a(this);
            return;
        }

        private boolean b() {
            if (this.f.decrementAndGet() >= 0) goto L7;
            return false;
        L7:
            if (this.f7190e != null) goto L11;
            Runnable r0 = new AnonymousClass1(this);
            this.f7190e = r0;
            DefaultWorkThread.postDelayed(r0, 120000);
            return true;
        L11:
            return true;
        }
    }

    abstract void a(long r1, boolean r3, File r4, int r5, int r6);

    abstract boolean a(boolean r1);

    c(AnrInfoMonitor r1, File r2, long r3, boolean r5) {
        this.f7182a = r1;
        this.f7184c = r3;
        File r4 = a(r2, r3);
        this.f7183b = r4;
        this.f7185d = com.bytedance.crash.anr.b.a(r4, r3, r5);
    }

    public static c a(AnrInfoMonitor r7, File r8, long r9, boolean r11) {
        if (j.b() == false) goto L7;
        return new b(r7, r8, r9, r11);
    L7:
        return new a(r7, r8, r9, r11);
    }

    static boolean a(long r0, long r2) {
        if (Math.abs(r0 - r2) > 35000) goto L5;
        return true;
    L5:
        return false;
    }

    void a(File r5) {
        String r6 = com.bytedance.crash.o.i.d(r5);
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        Iterator<com.bytedance.crash.monitor.d> r0 = com.bytedance.crash.monitor.h.d().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        a((com.bytedance.crash.monitor.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.crash.monitor.d.class, "com.obric.aiagent.plugin"), r6);
        goto L7
    }

    void a(com.bytedance.crash.monitor.d r3, String r4) {
        Iterator<ICrashCallback> r2 = r3.n().c(CrashType.ANR).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.preCheckCast(r2.next(), ICrashCallback.class, "com.obric.aiagent.plugin");
        r5.onCrash(CrashType.ANR, r4, null);     // Catch: Throwable -> L9
        goto L4
    }

    private File a(File r1, long r2) {
        return com.bytedance.crash.o.i.a(com.bytedance.crash.o.i.a(r1, com.bytedance.crash.crash.b.b()), String.valueOf(r2));
    }

    public long b(File r5) {
        if (r5 != null) goto L4;
    L6:
        return 0;
    L4:
        if (r5.exists() == false) goto L6;
        long r0 = AnrInfoMonitor.a(r5.getName());
        r5.renameTo(new File(this.f7183b, d.a()));
        return r0;
    }

    final void a(int r2, int r3) {
        this.f7186e = this.f7185d.a(r2, r3);
    }
}
