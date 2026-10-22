package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.h;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Queue {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f24396i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f24397j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f24398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f24400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray f24402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f24404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f24405h;

    static {
        f24396i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f24397j = new Object();
    }

    public d(int r10) {
        int r11 = h.a(r10);
        int r12 = r11 - 1;
        AtomicReferenceArray r13 = new AtomicReferenceArray(r11 + 1);
        this.f24402e = r13;
        this.f24401d = r12;
        a(r11);
        this.f24404g = r13;
        this.f24403f = r12;
        this.f24400c = r11 - 2;
        this.f24398a = new AtomicLong();
        this.f24405h = new AtomicLong();
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

    public static void o(AtomicReferenceArray r10, int r11, Object r12) {
        r10.lazySet(r11, r12);
    }

    public final void a(int r10) {
        this.f24399b = Math.min(r10 / 4, f24396i);
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
        return this.f24405h.get();
    }

    public final long e() {
        return this.f24398a.get();
    }

    @Override // java.util.Queue
    public Object element() {
        throw new UnsupportedOperationException();
    }

    public final long f() {
        return this.f24405h.get();
    }

    public final AtomicReferenceArray h(AtomicReferenceArray r10) {
        return (AtomicReferenceArray) g(r10, b(r10.length() - 1));
    }

    public final long i() {
        return this.f24398a.get();
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
        this.f24404g = r10;
        return g(r10, c(r11, r12));
    }

    public final Object k(AtomicReferenceArray r10, long r11, int r12) {
        this.f24404g = r10;
        int r13 = c(r11, r12);
        Object r14 = g(r10, r13);
        if (r14 != null) goto L5;
        return null;
    L5:
        o(r10, r13, null);
        n(r11 + 1);
        return r14;
    }

    public boolean l(Object r10, Object r11) {
        AtomicReferenceArray r12 = this.f24402e;
        long r13 = i();
        int r14 = this.f24401d;
        long r15 = 2 + r13;
        if (g(r12, c(r15, r14)) != null) goto L5;
        int r16 = c(r13, r14);
        o(r12, r16 + 1, r11);
        o(r12, r16, r10);
        q(r15);
        return true;
    L5:
        AtomicReferenceArray r17 = new AtomicReferenceArray(r12.length());
        this.f24402e = r17;
        int r18 = c(r13, r14);
        o(r17, r18 + 1, r11);
        o(r17, r18, r10);
        p(r12, r17);
        o(r12, r18, f24397j);
        q(r15);
        return true;
    }

    public final void m(AtomicReferenceArray r10, long r11, int r12, Object r13, long r14) {
        AtomicReferenceArray r15 = new AtomicReferenceArray(r10.length());
        this.f24402e = r15;
        this.f24400c = (r14 + r11) - 1;
        o(r15, r12, r13);
        p(r10, r15);
        o(r10, r12, f24397j);
        q(r11 + 1);
    }

    public final void n(long r10) {
        this.f24405h.lazySet(r10);
    }

    @Override // java.util.Queue
    public boolean offer(Object r11) {
        AtomicReferenceArray r10 = this.f24402e;
        long r12 = e();
        int r13 = this.f24401d;
        int r14 = c(r12, r13);
        if (r12 < this.f24400c) goto L5;
        long r15 = ((long) this.f24399b) + r12;
        if (g(r10, c(r15, r13)) != null) goto L11;
        this.f24400c = r15 - 1;
        return r(r10, r11, r12, r14);
    L11:
        if (g(r10, c(1 + r12, r13)) == null) goto L13;
        m(r10, r12, r14, r11, r13);
        return true;
    L13:
        return r(r10, r11, r12, r14);
    L5:
        return r(r10, r11, r12, r14);
    }

    public final void p(AtomicReferenceArray r10, AtomicReferenceArray r11) {
        o(r10, b(r10.length() - 1), r11);
    }

    @Override // java.util.Queue
    public Object peek() {
        AtomicReferenceArray r10 = this.f24404g;
        long r11 = d();
        int r12 = this.f24403f;
        Object r13 = g(r10, c(r11, r12));
        if (r13 == f24397j) goto L5;
        return r13;
    L5:
        return j(h(r10), r11, r12);
    }

    @Override // java.util.Queue
    public Object poll() {
        AtomicReferenceArray r10 = this.f24404g;
        long r11 = d();
        int r12 = this.f24403f;
        int r13 = c(r11, r12);
        Object r14 = g(r10, r13);
        if (r14 != f24397j) goto L5;
        boolean r15 = true;
    L7:
        if (r14 == null) goto L11;
        if (r15 == true) goto L11;
        o(r10, r13, null);
        n(r11 + 1);
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

    public final void q(long r10) {
        this.f24398a.lazySet(r10);
    }

    public final boolean r(AtomicReferenceArray r10, Object r11, long r12, int r13) {
        o(r10, r13, r11);
        q(r12 + 1);
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
