package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 extends b implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f21107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21110d;

    public static final class a extends kotlin.collections.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ p0 f21113e;

        public a(p0 r10) {
            this.f21113e = r10;
            this.f21111c = r10.size();
            this.f21112d = p0.c(r10);
        }

        @Override // kotlin.collections.a
        public void a() {
            if (this.f21111c != 0) goto L5;
            b();
            return;
        L5:
            c(p0.a(this.f21113e)[this.f21112d]);
            this.f21112d = (this.f21112d + 1) % p0.b(this.f21113e);
            this.f21111c--;
        }
    }

    public p0(Object[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "buffer");
        this.f21107a = r10;
        if (r11 < 0) goto L11;
        if (r11 > r10.length) goto L9;
        this.f21108b = r10.length;
        this.f21110d = r11;
        return;
    L9:
        throw new IllegalArgumentException(("ring buffer filled size: " + r11 + " cannot be larger than the buffer size: " + r10.length).toString());
    L11:
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + r11).toString());
    }

    public static final /* synthetic */ Object[] a(p0 r10) {
        return r10.f21107a;
    }

    public static final /* synthetic */ int b(p0 r10) {
        return r10.f21108b;
    }

    public static final /* synthetic */ int c(p0 r10) {
        return r10.f21109c;
    }

    public final void d(Object r10) {
        if (f() == true) goto L7;
        this.f21107a[(this.f21109c + size()) % b(this)] = r10;
        this.f21110d = size() + 1;
        return;
    L7:
        throw new IllegalStateException("ring buffer is full");
    }

    public final p0 e(int r10) {
        int r11 = this.f21108b;
        int r12 = bg.h.g((r11 + (r11 >> 1)) + 1, r10);
        if (this.f21109c != 0) goto L5;
        Object[] r13 = Arrays.copyOf(this.f21107a, r12);
        kotlin.jvm.internal.q.f(r13, "copyOf(...)");
    L7:
        return new p0(r13, size());
    L5:
        r13 = toArray(new Object[r12]);
        goto L7
    }

    public final boolean f() {
        if (size() != this.f21108b) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g(int r10) {
        if (r10 < 0) goto L15;
        if (r10 > size()) goto L13;
        if (r10 <= 0) goto L16;
        int r11 = this.f21109c;
        int r12 = (r11 + r10) % b(this);
        if (r11 <= r12) goto L9;
        m.i(this.f21107a, null, r11, this.f21108b);
        m.i(this.f21107a, null, 0, r12);
    L10:
        this.f21109c = r12;
        this.f21110d = size() - r10;
        return;
    L9:
        m.i(this.f21107a, null, r11, r12);
        goto L10
    L16:
        return;
    L13:
        throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + r10 + ", size = " + size()).toString());
    L15:
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + r10).toString());
    }

    @Override // kotlin.collections.b, java.util.List
    public Object get(int r10) {
        b.Companion.a(r10, size());
        return this.f21107a[(this.f21109c + r10) % b(this)];
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f21110d;
    }

    @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "array");
        if (r10.length >= size()) goto L5;
        r10 = Arrays.copyOf(r10, size());
        kotlin.jvm.internal.q.f(r10, "copyOf(...)");
    L5:
        int r11 = size();
        int r12 = this.f21109c;
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L10;
        if (r12 >= this.f21108b) goto L10;
        r10[r14] = this.f21107a[r12];
        r14 = r14 + 1;
        r12 = r12 + 1;
    L10:
        if (r14 >= r11) goto L13;
        r10[r14] = this.f21107a[r13];
        r14 = r14 + 1;
        r13 = r13 + 1;
        goto L10
    L13:
        return s.f(r11, r10);
    }

    public p0(int r10) {
        this(new Object[r10], 0);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
