package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;

/* JADX INFO: loaded from: classes4.dex */
public class i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21598b = null;

    @Volatile
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadSafeHeapNode[] f21599a;

    static {
        f21598b = AtomicIntegerFieldUpdater.newUpdater(i0.class, "_size");
    }

    public i0() {
    }

    public final void a(ThreadSafeHeapNode r10) {
        r10.setHeap(this);
        ThreadSafeHeapNode[] r11 = f();
        int r12 = c();
        j(r12 + 1);
        r11[r12] = r10;
        r10.setIndex(r12);
        l(r12);
    }

    public final ThreadSafeHeapNode b() {
        ThreadSafeHeapNode[] r10 = this.f21599a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10[0];
    }

    public final int c() {
        return f21598b.get(this);
    }

    public final boolean d() {
        if (c() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final ThreadSafeHeapNode e() {
        monitor-enter(this);
        ThreadSafeHeapNode r10 = b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final ThreadSafeHeapNode[] f() {
        ThreadSafeHeapNode[] r10 = this.f21599a;
        if (r10 != null) goto L6;
        ThreadSafeHeapNode[] r11 = new ThreadSafeHeapNode[4];
        this.f21599a = r11;
        return r11;
    L6:
        if (c() < r10.length) goto L10;
        Object[] r12 = Arrays.copyOf(r10, c() * 2);
        kotlin.jvm.internal.q.f(r12, "copyOf(this, newSize)");
        ThreadSafeHeapNode[] r13 = (ThreadSafeHeapNode[]) r12;
        this.f21599a = r13;
        return r13;
    L10:
        return r10;
    }

    public final boolean g(ThreadSafeHeapNode r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r10.getHeap() != null) goto L6;
        boolean r11 = false;
    L8:
        monitor-exit(this);
        return r11;
    L6:
        h(r10.getIndex());     // Catch: Throwable -> L10
        r11 = true;
        goto L8
    }

    public final ThreadSafeHeapNode h(int r10) {
        ThreadSafeHeapNode[] r11 = this.f21599a;
        kotlin.jvm.internal.q.d(r11);
        j(c() - 1);
        if (r10 >= c()) goto L10;
        m(r10, c());
        int r12 = (r10 - 1) / 2;
        if (r10 <= 0) goto L9;
        ThreadSafeHeapNode r13 = r11[r10];
        kotlin.jvm.internal.q.d(r13);
        ThreadSafeHeapNode r14 = r11[r12];
        kotlin.jvm.internal.q.d(r14);
        if (((Comparable) r13).compareTo(r14) >= 0) goto L9;
        m(r10, r12);
        l(r12);
    L9:
        k(r10);
    L10:
        ThreadSafeHeapNode r15 = r11[c()];
        kotlin.jvm.internal.q.d(r15);
        r15.setHeap(null);
        r15.setIndex(-1);
        r11[c()] = null;
        return r15;
    }

    public final ThreadSafeHeapNode i() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (c() <= 0) goto L9;
        ThreadSafeHeapNode r10 = h(0);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r10;
    L9:
        r10 = null;
        goto L10
    }

    public final void j(int r10) {
        f21598b.set(this, r10);
    }

    public final void k(int r10) {
    L2:
        int r11 = r10 * 2;
        int r12 = r11 + 1;
        if (r12 >= c()) goto L4;
        ThreadSafeHeapNode[] r13 = this.f21599a;
        kotlin.jvm.internal.q.d(r13);
        int r14 = r11 + 2;
        if (r14 >= c()) goto L10;
        ThreadSafeHeapNode r15 = r13[r14];
        kotlin.jvm.internal.q.d(r15);
        ThreadSafeHeapNode r16 = r13[r12];
        kotlin.jvm.internal.q.d(r16);
        if (((Comparable) r15).compareTo(r16) >= 0) goto L10;
    L11:
        ThreadSafeHeapNode r17 = r13[r10];
        kotlin.jvm.internal.q.d(r17);
        ThreadSafeHeapNode r18 = r13[r14];
        kotlin.jvm.internal.q.d(r18);
        if (((Comparable) r17).compareTo(r18) <= 0) goto L13;
        m(r10, r14);
        r10 = r14;
        goto L2
    L13:
        return;
    L10:
        r14 = r12;
        goto L11
    }

    public final void l(int r10) {
    L2:
        if (r10 <= 0) goto L3;
        ThreadSafeHeapNode[] r11 = this.f21599a;
        kotlin.jvm.internal.q.d(r11);
        int r12 = (r10 - 1) / 2;
        ThreadSafeHeapNode r13 = r11[r12];
        kotlin.jvm.internal.q.d(r13);
        ThreadSafeHeapNode r14 = r11[r10];
        kotlin.jvm.internal.q.d(r14);
        if (((Comparable) r13).compareTo(r14) <= 0) goto L6;
        m(r10, r12);
        r10 = r12;
        goto L2
    L6:
        return;
    }

    public final void m(int r10, int r11) {
        ThreadSafeHeapNode[] r12 = this.f21599a;
        kotlin.jvm.internal.q.d(r12);
        ThreadSafeHeapNode r13 = r12[r11];
        kotlin.jvm.internal.q.d(r13);
        ThreadSafeHeapNode r14 = r12[r10];
        kotlin.jvm.internal.q.d(r14);
        r12[r10] = r13;
        r12[r11] = r14;
        r13.setIndex(r10);
        r14.setIndex(r11);
    }
}
