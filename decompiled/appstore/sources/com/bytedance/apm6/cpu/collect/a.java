package com.bytedance.apm6.cpu.collect;

import com.bytedance.watson.assist.api.IAssistStat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a extends q3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f6759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u2.a f6760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IAssistStat f6761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f6762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f6763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f6764f;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0082a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6765a = null;

        static {
            int[] r10 = new int[CpuCacheItem.CpuDataType.values().length];
            f6765a = r10;
            r10[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f6765a[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f6765a[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public a(IAssistStat r10) {
        this.f6759a = new AtomicBoolean(false);
        this.f6761c = r10;
    }

    public static CpuCacheItem g(CpuCacheItem.CpuDataType r10, CpuCacheItem r11, double r12, double r13) {
        if (r11 != null) goto L5;
        r11 = new CpuCacheItem(r10, System.currentTimeMillis());
        r11.k(m3.c.a().getSceneString());
    L5:
        if (r12 < 0.0d) goto L7;
    L8:
        r11.c();
    L9:
        r11.b(r13);
        r11.a(r12);
        r11.l(r12);
        r11.m(r13);
        return r11;
    L7:
        if (r13 < 0.0d) goto L9;
        goto L8
    }

    public void a(double r10, double r12) {
        if (this.f6759a.get() == true) goto L5;
        return;
    L5:
        String r11 = m3.c.a().getSceneString();
        if (r3.a.c() == false) goto L9;
        s3.a.a("APM-CPU", r11);
    L9:
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (t2.a.e().g() == false) goto L15;
        CpuCacheItem.CpuDataType r13 = CpuCacheItem.CpuDataType.FRONT;     // Catch: Throwable -> L13
    L16:
        CpuCacheItem r14 = g(r13, e(r13, r11), r10, r12);     // Catch: Throwable -> L13
        b(r13, r11, r14);     // Catch: Throwable -> L13
        if (r3.a.c() == false) goto L19;
        s3.a.a("APM-CPU", "after add cache data: " + r14);     // Catch: Throwable -> L13
    L19:
        CpuCacheItem.CpuDataType r15 = CpuCacheItem.CpuDataType.MIX;     // Catch: Throwable -> L13
        b(r15, r11, g(r15, e(r15, r11), r10, r12));     // Catch: Throwable -> L13
        monitor-exit(a.class);     // Catch: Throwable -> L13
        return;
    L15:
        r13 = CpuCacheItem.CpuDataType.BACK;     // Catch: Throwable -> L13
        goto L16
    }

    public final void b(CpuCacheItem.CpuDataType r10, String r11, CpuCacheItem r12) {
        int r13 = C0082a.f6765a[r10.ordinal()];
        if (r13 != 1) goto L5;
        this.f6762d.put(r11, r12);
        return;
    L5:
        if (r13 != 2) goto L7;
        this.f6764f.put(r11, r12);
        return;
    L7:
        if (r13 != 3) goto L15;
        this.f6763e.put(r11, r12);
        return;
    }

    public final void c(CpuCacheItem.CpuDataType r17, IAssistStat.b r18) {
        long r13 = System.currentTimeMillis();
        int r10 = C0082a.f6765a[r17.ordinal()];
        if (r10 != 1) goto L5;
        Iterator r11 = this.f6762d.entrySet().iterator();
    L9:
        Iterator r15 = r11;
        if (r15 != null) goto L16;
        return;
    L16:
        if (r15.hasNext() == false) goto L24;
        CpuCacheItem r12 = (CpuCacheItem) ((Map.Entry) r15.next()).getValue();
        if ((r13 - r12.d()) <= this.f6760b.e()) goto L16;
        r15.remove();
        double r14 = r12.h() / ((double) r12.j());
        double r16 = r12.g();
        double r19 = r12.e() / ((double) r12.j());
        double r20 = r12.f();
        if (r3.a.c() == false) goto L23;
        s3.a.a("APM-CPU", "cpu cache item: " + r12);
        s3.a.a("APM-CPU", "assemble cpu data, type: " + r17 + " rate: " + r14 + " maxRate: " + r16 + " speed: " + r19 + " maxSpeed: " + r20);
    L23:
        d(r17, r12.i(), r14, r16, r19, r20, r18);
        goto L16
    L24:
        return;
    L5:
        if (r10 != 2) goto L7;
        r11 = this.f6764f.entrySet().iterator();
        goto L9
    L7:
        if (r10 == 3) goto L10;
        r11 = null;
        goto L9
    L10:
        r11 = this.f6763e.entrySet().iterator();
        goto L9
    }

    public final void d(CpuCacheItem.CpuDataType r14, String r15, double r16, double r18, double r20, double r22, IAssistStat.b r24) {
        c r12 = new c(r14, r15, r16, r18, r20, r22, r24);
        r12.g(ff.b.b(r3.a.b()));
        r12.h(this.f6761c.isCpuSampleEnvironment());     // Catch: Throwable -> L6
    L4:
        l3.a.d(r12);
    }

    public final CpuCacheItem e(CpuCacheItem.CpuDataType r10, String r11) {
        int r12 = C0082a.f6765a[r10.ordinal()];
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L13;
        if (r12 == 3) goto L11;
        return null;
    L11:
        return (CpuCacheItem) this.f6763e.get(r11);
    L13:
        return (CpuCacheItem) this.f6764f.get(r11);
    L15:
        return (CpuCacheItem) this.f6762d.get(r11);
    }

    public boolean f() {
        return this.f6759a.get();
    }

    public void h() {
        if (this.f6759a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f6762d = new HashMap();
        this.f6763e = new HashMap();
        this.f6764f = new HashMap();
    }

    public void i(u2.a r10) {
        if (this.f6759a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f6762d = new HashMap();
        this.f6763e = new HashMap();
        this.f6764f = new HashMap();
        this.f6760b = r10;
    }

    public void j() {
        if (this.f6759a.compareAndSet(true, false) == true) goto L6;
        return;
    L6:
        monitor-enter(a.class);
        this.f6763e.clear();     // Catch: Throwable -> L10
        this.f6764f.clear();     // Catch: Throwable -> L10
        this.f6762d.clear();     // Catch: Throwable -> L10
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void k(IAssistStat.b r10) {
        if (this.f6759a.get() == true) goto L6;
        return;
    L6:
        monitor-enter(a.class);
        c(CpuCacheItem.CpuDataType.FRONT, r10);     // Catch: Throwable -> L10
        c(CpuCacheItem.CpuDataType.BACK, r10);     // Catch: Throwable -> L10
        c(CpuCacheItem.CpuDataType.MIX, r10);     // Catch: Throwable -> L10
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
