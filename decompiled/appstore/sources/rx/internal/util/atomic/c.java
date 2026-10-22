package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer f24391g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f24392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f24393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f24394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f24395f;

    static {
        f24391g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public c(int r10) {
        super(r10);
        this.f24392c = new AtomicLong();
        this.f24394e = new AtomicLong();
        this.f24395f = Math.min(r10 / 4, f24391g.intValue());
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final long f() {
        return this.f24394e.get();
    }

    public final long g() {
        return this.f24392c.get();
    }

    public final void h(long r10) {
        this.f24394e.lazySet(r10);
    }

    public final void i(long r10) {
        this.f24392c.lazySet(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (g() != f()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(Object r10) {
        if (r10 == null) goto L15;
        AtomicReferenceArray r11 = this.f24387a;
        int r12 = this.f24388b;
        long r13 = this.f24392c.get();
        int r14 = b(r13, r12);
        if (r13 < this.f24393d) goto L12;
        long r15 = ((long) this.f24395f) + r13;
        if (d(r11, b(r15, r12)) != null) goto L9;
        this.f24393d = r15;
        goto L12
    L9:
        if (d(r11, r14) == null) goto L12;
        return false;
    L12:
        e(r11, r14, r10);
        i(r13 + 1);
        return true;
    L15:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public Object peek() {
        return c(a(this.f24394e.get()));
    }

    @Override // java.util.Queue
    public Object poll() {
        long r10 = this.f24394e.get();
        int r11 = a(r10);
        AtomicReferenceArray r12 = this.f24387a;
        Object r13 = d(r12, r11);
        if (r13 != null) goto L5;
        return null;
    L5:
        e(r12, r11, null);
        h(r10 + 1);
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long r10 = f();
    L3:
        long r11 = g();
        long r12 = f();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
    }
}
