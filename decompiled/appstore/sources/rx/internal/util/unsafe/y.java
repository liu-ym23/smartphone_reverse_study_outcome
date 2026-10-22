package rx.internal.util.unsafe;

import java.util.Iterator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
public class y extends a0 implements QueueProgressIndicators {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24448g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f24449h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f24450i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f24451j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f24452k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f24453l = null;

    static {
        f24448g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f24453l = new Object();
        Unsafe r10 = e0.f24434a;
        int r11 = r10.arrayIndexScale(Object[].class);
        if (4 != r11) goto L6;
        f24452k = 2;
    L8:
        f24451j = r10.arrayBaseOffset(Object[].class);
        f24449h = r10.objectFieldOffset(d0.class.getDeclaredField("producerIndex"));     // Catch: NoSuchFieldException -> L15
        f24450i = r10.objectFieldOffset(a0.class.getDeclaredField("consumerIndex"));     // Catch: NoSuchFieldException -> L12
        return;
    L12:
        e = move-exception;
        InternalError r12 = new InternalError();
        r12.initCause(e);
        throw r12;
    L15:
        e = move-exception;
        InternalError r13 = new InternalError();
        r13.initCause(e);
        throw r13;
    L6:
        if (8 != r11) goto L19;
        f24452k = 3;
        goto L8
    L19:
        throw new IllegalStateException("Unknown pointer size");
    }

    public y(int r10) {
        int r11 = h.a(r10);
        long r12 = r11 - 1;
        Object[] r13 = new Object[r11 + 1];
        this.f24432d = r13;
        this.f24431c = r12;
        a(r11);
        this.f24455f = r13;
        this.f24454e = r12;
        this.f24430b = r12 - 1;
        n(0);
    }

    public static long b(long r10) {
        return f24451j + (r10 << f24452k);
    }

    public static long c(long r10, long r11) {
        return b(r10 & r11);
    }

    public static Object e(Object[] r10, long r11) {
        return e0.f24434a.getObjectVolatile(r10, r11);
    }

    public static void l(Object[] r10, long r11, Object r12) {
        e0.f24434a.putOrderedObject(r10, r11, r12);
    }

    public final void a(int r10) {
        this.f24429a = Math.min(r10 / 4, f24448g);
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentConsumerIndex() {
        return d();
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentProducerIndex() {
        return g();
    }

    public final long d() {
        return e0.f24434a.getLongVolatile(this, f24450i);
    }

    public final Object[] f(Object[] r10) {
        return (Object[]) e(r10, b(r10.length - 1));
    }

    public final long g() {
        return e0.f24434a.getLongVolatile(this, f24449h);
    }

    public final Object h(Object[] r10, long r11, long r12) {
        this.f24455f = r10;
        return e(r10, c(r11, r12));
    }

    public final Object i(Object[] r10, long r11, long r12) {
        this.f24455f = r10;
        long r13 = c(r11, r12);
        Object r14 = e(r10, r13);
        if (r14 != null) goto L5;
        return null;
    L5:
        l(r10, r13, null);
        k(r11 + 1);
        return r14;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public final void j(Object[] r10, long r11, long r12, Object r13, long r14) {
        Object[] r15 = new Object[r10.length];
        this.f24432d = r15;
        this.f24430b = (r14 + r11) - 1;
        l(r15, r12, r13);
        m(r10, r15);
        l(r10, r12, f24453l);
        n(r11 + 1);
    }

    public final void k(long r10) {
        e0.f24434a.putOrderedLong(this, f24450i, r10);
    }

    public final void m(Object[] r10, Object[] r11) {
        l(r10, b(r10.length - 1), r11);
    }

    public final void n(long r10) {
        e0.f24434a.putOrderedLong(this, f24449h, r10);
    }

    public final boolean o(Object[] r10, Object r11, long r12, long r13) {
        l(r10, r13, r11);
        n(r12 + 1);
        return true;
    }

    @Override // java.util.Queue
    public final boolean offer(Object r14) {
        if (r14 == null) goto L18;
        Object[] r10 = this.f24432d;
        long r11 = this.producerIndex;
        long r12 = this.f24431c;
        long r13 = c(r11, r12);
        if (r11 < this.f24430b) goto L6;
        long r15 = ((long) this.f24429a) + r11;
        if (e(r10, c(r15, r12)) != null) goto L12;
        this.f24430b = r15 - 1;
        return o(r10, r14, r11, r13);
    L12:
        if (e(r10, c(1 + r11, r12)) != null) goto L14;
        j(r10, r11, r13, r14, r12);
        return true;
    L14:
        return o(r10, r14, r11, r13);
    L6:
        return o(r10, r14, r11, r13);
    L18:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public final Object peek() {
        Object[] r10 = this.f24455f;
        long r11 = this.consumerIndex;
        long r12 = this.f24454e;
        Object r13 = e(r10, c(r11, r12));
        if (r13 == f24453l) goto L5;
        return r13;
    L5:
        return h(f(r10), r11, r12);
    }

    @Override // java.util.Queue
    public final Object poll() {
        Object[] r10 = this.f24455f;
        long r11 = this.consumerIndex;
        long r12 = this.f24454e;
        long r13 = c(r11, r12);
        Object r14 = e(r10, r13);
        if (r14 != f24453l) goto L5;
        boolean r15 = true;
    L7:
        if (r14 == null) goto L11;
        if (r15 == true) goto L11;
        l(r10, r13, null);
        k(r11 + 1);
        return r14;
    L11:
        if (r15 == true) goto L13;
        return null;
    L13:
        return i(f(r10), r11, r12);
    L5:
        r15 = false;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long r10 = d();
    L3:
        long r11 = g();
        long r12 = d();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
    }
}
