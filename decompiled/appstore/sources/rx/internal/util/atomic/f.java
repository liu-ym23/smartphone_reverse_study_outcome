package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.h;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements Queue {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f24406i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f24407j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f24408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f24410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray f24412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f24414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f24415h;

    static {
        f24406i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f24407j = new Object();
    }

    public f(int r10) {
        int r11 = h.a(Math.max(8, r10));
        int r12 = r11 - 1;
        this.f24408a = new AtomicLong();
        this.f24415h = new AtomicLong();
        AtomicReferenceArray r13 = new AtomicReferenceArray(r11 + 1);
        this.f24412e = r13;
        this.f24411d = r12;
        a(r11);
        this.f24414g = r13;
        this.f24413f = r12;
        this.f24410c = r11 - 2;
        p(0);
    }

    public static int b(int r10) {
        return r10;
    }

    public static int c(long r10, int r11) {
        return b(((int) r10) & r11);
    }

    public static Object g(AtomicReferenceArray r10, int r11) {
        return r10.get(r11);
    }

    public static void n(AtomicReferenceArray r10, int r11, Object r12) {
        r10.lazySet(r11, r12);
    }

    public final void a(int r10) {
        this.f24409b = Math.min(r10 / 4, f24406i);
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // java.util.Collection
    public boolean contains(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection r10) {
        throw new UnsupportedOperationException();
    }

    public final long d() {
        return this.f24415h.get();
    }

    public final long e() {
        return this.f24408a.get();
    }

    @Override // java.util.Queue
    public Object element() {
        throw new UnsupportedOperationException();
    }

    public final long f() {
        return this.f24415h.get();
    }

    public final AtomicReferenceArray h(AtomicReferenceArray r10) {
        return (AtomicReferenceArray) g(r10, b(r10.length() - 1));
    }

    public final long i() {
        return this.f24408a.get();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (i() != f()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public final Object j(AtomicReferenceArray r10, long r11, int r12) {
        this.f24414g = r10;
        return g(r10, c(r11, r12));
    }

    public final Object k(AtomicReferenceArray r10, long r11, int r12) {
        this.f24414g = r10;
        int r13 = c(r11, r12);
        Object r14 = g(r10, r13);
        if (r14 != null) goto L5;
        return null;
    L5:
        m(r11 + 1);
        n(r10, r13, null);
        return r14;
    }

    public final void l(AtomicReferenceArray r10, long r11, int r12, Object r13, long r14) {
        AtomicReferenceArray r15 = new AtomicReferenceArray(r10.length());
        this.f24412e = r15;
        this.f24410c = (r14 + r11) - 1;
        p(r11 + 1);
        n(r15, r12, r13);
        o(r10, r15);
        n(r10, r12, f24407j);
    }

    public final void m(long r10) {
        this.f24415h.lazySet(r10);
    }

    public final void o(AtomicReferenceArray r10, AtomicReferenceArray r11) {
        n(r10, b(r10.length() - 1), r11);
    }

    @Override // java.util.Queue
    public boolean offer(Object r11) {
        if (r11 == null) goto L18;
        AtomicReferenceArray r10 = this.f24412e;
        long r12 = e();
        int r13 = this.f24411d;
        int r14 = c(r12, r13);
        if (r12 < this.f24410c) goto L6;
        long r15 = ((long) this.f24409b) + r12;
        if (g(r10, c(r15, r13)) != null) goto L12;
        this.f24410c = r15 - 1;
        return q(r10, r11, r12, r14);
    L12:
        if (g(r10, c(1 + r12, r13)) != null) goto L14;
        l(r10, r12, r14, r11, r13);
        return true;
    L14:
        return q(r10, r11, r12, r14);
    L6:
        return q(r10, r11, r12, r14);
    L18:
        throw null;
    }

    public final void p(long r10) {
        this.f24408a.lazySet(r10);
    }

    @Override // java.util.Queue
    public Object peek() {
        AtomicReferenceArray r10 = this.f24414g;
        long r11 = d();
        int r12 = this.f24413f;
        Object r13 = g(r10, c(r11, r12));
        if (r13 == f24407j) goto L5;
        return r13;
    L5:
        return j(h(r10), r11, r12);
    }

    @Override // java.util.Queue
    public Object poll() {
        AtomicReferenceArray r10 = this.f24414g;
        long r11 = d();
        int r12 = this.f24413f;
        int r13 = c(r11, r12);
        Object r14 = g(r10, r13);
        if (r14 != f24407j) goto L5;
        boolean r15 = true;
    L7:
        if (r14 == null) goto L11;
        if (r15 == true) goto L11;
        m(r11 + 1);
        n(r10, r13, null);
        return r14;
    L11:
        if (r15 == true) goto L13;
        return null;
    L13:
        return k(h(r10), r11, r12);
    L5:
        r15 = false;
        goto L7
    }

    public final boolean q(AtomicReferenceArray r10, Object r11, long r12, int r13) {
        p(r12 + 1);
        n(r10, r13, r11);
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long r10 = f();
    L3:
        long r11 = i();
        long r12 = f();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public Object remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] r10) {
        throw new UnsupportedOperationException();
    }
}
