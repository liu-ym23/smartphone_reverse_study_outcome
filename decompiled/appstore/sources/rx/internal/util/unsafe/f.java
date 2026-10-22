package rx.internal.util.unsafe;

import java.util.Iterator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24436c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f24437d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24438e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f24440b;

    static {
        int r10 = Integer.getInteger("sparse.shift", 0).intValue();
        f24436c = r10;
        Unsafe r11 = e0.f24434a;
        int r12 = r11.arrayIndexScale(Object[].class);
        if (4 != r12) goto L6;
        f24438e = r10 + 2;
    L8:
        f24437d = r11.arrayBaseOffset(Object[].class) + (32 << (f24438e - r10));
        return;
    L6:
        if (8 != r12) goto L11;
        f24438e = r10 + 3;
        goto L8
    L11:
        throw new IllegalStateException("Unknown pointer size");
    }

    public f(int r10) {
        int r11 = h.a(r10);
        this.f24439a = r11 - 1;
        this.f24440b = new Object[(r11 << f24436c) + 64];
    }

    public final long a(long r10) {
        return b(r10, this.f24439a);
    }

    public final long b(long r10, long r11) {
        return f24437d + ((r10 & r11) << f24438e);
    }

    public final Object c(Object[] r10, long r11) {
        return e0.f24434a.getObject(r10, r11);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    public final Object d(long r10) {
        return e(this.f24440b, r10);
    }

    public final Object e(Object[] r10, long r11) {
        return e0.f24434a.getObjectVolatile(r10, r11);
    }

    public final void f(Object[] r10, long r11, Object r12) {
        e0.f24434a.putOrderedObject(r10, r11, r12);
    }

    public final void g(Object[] r10, long r11, Object r12) {
        e0.f24434a.putObject(r10, r11, r12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
