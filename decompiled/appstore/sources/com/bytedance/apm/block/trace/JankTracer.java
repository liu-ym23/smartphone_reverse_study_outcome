package com.bytedance.apm.block.trace;

import g1.d;

/* JADX INFO: loaded from: classes.dex */
public class JankTracer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile JankTracer f6442b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f6443c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile IJankCalculator f6444a;

    public interface IJankCalculator {
        void collectEnd();

        void doFrame(long r10, long[] r11);

        boolean needFilter();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f6446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JankTracer f6447c;

        public a(JankTracer r10, long r11, long[] r12) {
            this.f6447c = r10;
            this.f6445a = r11;
            this.f6446b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JankTracer.a(this.f6447c).doFrame(this.f6445a, this.f6446b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JankTracer f6448a;

        public b(JankTracer r10) {
            this.f6448a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            JankTracer.a(this.f6448a).collectEnd();
        }
    }

    static {
    }

    public JankTracer() {
    }

    public static /* synthetic */ IJankCalculator a(JankTracer r10) {
        return r10.f6444a;
    }

    public static JankTracer c() {
        if (f6442b != null) goto L16;
        monitor-enter(JankTracer.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6442b != null) goto L11;
        f6442b = new JankTracer();     // Catch: Throwable -> L9
    L11:
        monitor-exit(JankTracer.class);     // Catch: Throwable -> L9
    L16:
        return f6442b;
    }

    public void b(long[] r10, long r11) {
        if (this.f6444a != null) goto L6;
        return;
    L6:
        if (this.f6444a.needFilter() == true) goto L9;
        d.A().f19824o.b(new a(this, r11, r10));
        f6443c = true;
        return;
    L9:
        if (f6443c == false) goto L13;
        d.A().f19824o.b(new b(this));
        f6443c = false;
        return;
    }
}
