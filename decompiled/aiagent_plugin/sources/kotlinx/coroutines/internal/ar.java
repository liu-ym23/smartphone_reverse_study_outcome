package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.as;

/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ar<T extends as & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39378b = null;
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T[] f39379a;

    static {
        f39378b = AtomicIntegerFieldUpdater.newUpdater(ar.class, "_size$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater g() {
        return f39378b;
    }

    public ar() {
    }

    public final int a() {
        return g().get(this);
    }

    private final void b(int r2) {
        g().set(this, r2);
    }

    public final boolean b() {
        if (a() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T e() {
        T[] r1 = this.f39379a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1[0];
    }

    public final T a(int r9) {
        boolean r1 = false;
        if (kotlinx.coroutines.aq.a() == true) goto L5;
    L12:
        T[] r0 = this.f39379a;
        d.h.b.o.a(r0);
        b(a() - 1);
        if (r9 >= a()) goto L20;
        a(r9, a());
        int r3 = (r9 - 1) / 2;
        if (r9 <= 0) goto L19;
        T r5 = r0[r9];
        d.h.b.o.a(r5);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.aiagent.plugin");
        T r7 = r0[r3];
        d.h.b.o.a(r7);
        if (r6.compareTo(r7) >= 0) goto L19;
        a(r9, r3);
        c(r3);
    L19:
        d(r9);
    L20:
        T r10 = r0[a()];
        d.h.b.o.a(r10);
        if (kotlinx.coroutines.aq.a() == true) goto L23;
    L29:
        r10.a(null);
        r10.a(-1);
        r0[a()] = null;
        return r10;
    L23:
        if (r10.a() != this) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L29;
        throw new AssertionError();
    L5:
        if (a() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final void b(T r4) {
        as r5 = (as) ZeusTransformUtils.wrapperContextForParams(r4, as.class, "com.obric.aiagent.plugin");
        if (kotlinx.coroutines.aq.a() == true) goto L5;
    L12:
        r5.a(this);
        as[] r0 = f();
        int r1 = a();
        b(r1 + 1);
        r0[r1] = r5;
        r5.a(r1);
        c(r1);
        return;
    L5:
        if (r5.a() != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    private final void c(int r6) {
    L2:
        if (r6 <= 0) goto L3;
        T[] r0 = this.f39379a;
        d.h.b.o.a(r0);
        int r1 = (r6 - 1) / 2;
        T r2 = r0[r1];
        d.h.b.o.a(r2);
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.aiagent.plugin");
        T r4 = r0[r6];
        d.h.b.o.a(r4);
        if (r3.compareTo(r4) <= 0) goto L6;
        a(r6, r1);
        r6 = r1;
        goto L2
    L6:
        return;
    }

    private final void d(int r7) {
    L2:
        int r0 = (r7 * 2) + 1;
        if (r0 >= a()) goto L4;
        T[] r1 = this.f39379a;
        d.h.b.o.a(r1);
        int r2 = r0 + 1;
        if (r2 >= a()) goto L10;
        T r3 = r1[r2];
        d.h.b.o.a(r3);
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin");
        T r5 = r1[r0];
        d.h.b.o.a(r5);
        if (r4.compareTo(r5) >= 0) goto L10;
        r0 = r2;
    L10:
        T r6 = r1[r7];
        d.h.b.o.a(r6);
        Comparable r8 = (Comparable) ZeusTransformUtils.preCheckCast(r6, Comparable.class, "com.obric.aiagent.plugin");
        T r9 = r1[r0];
        d.h.b.o.a(r9);
        if (r8.compareTo(r9) <= 0) goto L12;
        a(r7, r0);
        r7 = r0;
        goto L2
    L12:
        return;
    }

    private final T[] f() {
        T[] r0 = this.f39379a;
        if (r0 != null) goto L6;
        T[] r1 = (T[]) new as[4];
        this.f39379a = r1;
        return r1;
    L6:
        if (a() < r0.length) goto L10;
        Object[] r2 = Arrays.copyOf(r0, a() * 2);
        d.h.b.o.c(r2, "copyOf(...)");
        this.f39379a = (T[]) ((as[]) ZeusTransformUtils.preCheckCast(r2, as[].class, "com.obric.aiagent.plugin"));
        return (T[]) ((as[]) ZeusTransformUtils.preCheckCast(r2, as[].class, "com.obric.aiagent.plugin"));
    L10:
        return r0;
    }

    private final void a(int r3, int r4) {
        T[] r2 = this.f39379a;
        d.h.b.o.a(r2);
        T r0 = r2[r4];
        d.h.b.o.a(r0);
        T r1 = r2[r3];
        d.h.b.o.a(r1);
        r2[r3] = r0;
        r2[r4] = r1;
        r0.a(r3);
        r1.a(r4);
    }

    public final T c() {
        monitor-enter(this);
        T r0 = (T) e();
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final T d() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (a() <= 0) goto L7;
        T r0 = (T) a(0);
    L8:
        monitor-exit(this);
        return r0;
    L7:
        r0 = null;
        goto L8
    }

    public final boolean a(T r4) {
        as r5 = (as) ZeusTransformUtils.wrapperContextForParams(r4, as.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        boolean r1 = true;
        boolean r2 = false;
        if (r5.a() != null) goto L7;
        r1 = false;
    L16:
        monitor-exit(this);
        return r1;
    L7:
        int r6 = r5.b();     // Catch: Throwable -> L18
        if (kotlinx.coroutines.aq.a() == false) goto L15;
        if (r6 < 0) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L15;
        throw new AssertionError();     // Catch: Throwable -> L18
    L15:
        a(r6);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
