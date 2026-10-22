package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements SimplePlainQueue {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f20708i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f20709j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f20710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray f20714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f20716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f20717h;

    static {
        f20708i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f20709j = new Object();
    }

    public a(int r10) {
        this.f20710a = new AtomicLong();
        this.f20717h = new AtomicLong();
        int r11 = f.a(Math.max(8, r10));
        int r12 = r11 - 1;
        AtomicReferenceArray r13 = new AtomicReferenceArray(r11 + 1);
        this.f20714e = r13;
        this.f20713d = r12;
        a(r11);
        this.f20716g = r13;
        this.f20715f = r12;
        this.f20712c = r11 - 2;
        q(0);
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

    private void n(long r10) {
        this.f20717h.lazySet(r10);
    }

    public static void o(AtomicReferenceArray r10, int r11, Object r12) {
        r10.lazySet(r11, r12);
    }

    private void q(long r10) {
        this.f20710a.lazySet(r10);
    }

    public final void a(int r10) {
        this.f20711b = Math.min(r10 / 4, f20708i);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    public final long d() {
        return this.f20717h.get();
    }

    public final long e() {
        return this.f20710a.get();
    }

    public final long f() {
        return this.f20717h.get();
    }

    public final AtomicReferenceArray h(AtomicReferenceArray r10, int r11) {
        int r12 = b(r11);
        AtomicReferenceArray r13 = (AtomicReferenceArray) g(r10, r12);
        o(r10, r12, null);
        return r13;
    }

    public final long i() {
        return this.f20710a.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (i() != f()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object j(AtomicReferenceArray r10, long r11, int r12) {
        this.f20716g = r10;
        return g(r10, c(r11, r12));
    }

    public final Object k(AtomicReferenceArray r10, long r11, int r12) {
        this.f20716g = r10;
        int r13 = c(r11, r12);
        Object r14 = g(r10, r13);
        if (r14 == null) goto L5;
        o(r10, r13, null);
        n(r11 + 1);
    L5:
        return r14;
    }

    public final void l(AtomicReferenceArray r10, long r11, int r12, Object r13, long r14) {
        AtomicReferenceArray r15 = new AtomicReferenceArray(r10.length());
        this.f20714e = r15;
        this.f20712c = (r14 + r11) - 1;
        o(r15, r12, r13);
        p(r10, r15);
        o(r10, r12, f20709j);
        q(r11 + 1);
    }

    public int m() {
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

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r11) {
        if (r11 == null) goto L18;
        AtomicReferenceArray r10 = this.f20714e;
        long r12 = e();
        int r13 = this.f20713d;
        int r14 = c(r12, r13);
        if (r12 < this.f20712c) goto L6;
        long r15 = ((long) this.f20711b) + r12;
        if (g(r10, c(r15, r13)) != null) goto L12;
        this.f20712c = r15 - 1;
        return r(r10, r11, r12, r14);
    L12:
        if (g(r10, c(1 + r12, r13)) == null) goto L14;
        l(r10, r12, r14, r11, r13);
        return true;
    L14:
        return r(r10, r11, r12, r14);
    L6:
        return r(r10, r11, r12, r14);
    L18:
        throw new NullPointerException("Null is not a valid element");
    }

    public final void p(AtomicReferenceArray r10, AtomicReferenceArray r11) {
        o(r10, b(r10.length() - 1), r11);
    }

    public Object peek() {
        AtomicReferenceArray r10 = this.f20716g;
        long r11 = d();
        int r12 = this.f20715f;
        Object r13 = g(r10, c(r11, r12));
        if (r13 == f20709j) goto L5;
        return r13;
    L5:
        return j(h(r10, r12 + 1), r11, r12);
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        AtomicReferenceArray r10 = this.f20716g;
        long r11 = d();
        int r12 = this.f20715f;
        int r13 = c(r11, r12);
        Object r14 = g(r10, r13);
        if (r14 != f20709j) goto L5;
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
        return k(h(r10, r12 + 1), r11, r12);
    L5:
        r15 = false;
        goto L7
    }

    public final boolean r(AtomicReferenceArray r10, Object r11, long r12, int r13) {
        o(r10, r13, r11);
        q(r12 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10, Object r11) {
        AtomicReferenceArray r12 = this.f20714e;
        long r13 = i();
        int r14 = this.f20713d;
        long r15 = 2 + r13;
        if (g(r12, c(r15, r14)) != null) goto L5;
        int r16 = c(r13, r14);
        o(r12, r16 + 1, r11);
        o(r12, r16, r10);
        q(r15);
        return true;
    L5:
        AtomicReferenceArray r17 = new AtomicReferenceArray(r12.length());
        this.f20714e = r17;
        int r18 = c(r13, r14);
        o(r17, r18 + 1, r11);
        o(r17, r18, r10);
        p(r12, r17);
        o(r12, r18, f20709j);
        q(r15);
        return true;
    }
}
