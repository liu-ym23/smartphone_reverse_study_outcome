package rx.internal.util.unsafe;

import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class a extends b {

    /* renamed from: c, reason: collision with root package name */
    public static final int f14107c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f14108d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f14109e;

    /* renamed from: a, reason: collision with root package name */
    public final long f14110a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f14111b;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        f14107c = iIntValue;
        int iArrayIndexScale = v.f14123a.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            f14109e = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f14109e = iIntValue + 3;
        }
        f14108d = r1.arrayBaseOffset(Object[].class) + (32 << (f14109e - iIntValue));
    }

    public a(int i4) {
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
        this.f14110a = iNumberOfLeadingZeros - 1;
        this.f14111b = new Object[(iNumberOfLeadingZeros << f14107c) + 64];
    }

    public static Object c(Object[] objArr, long j4) {
        return v.f14123a.getObject(objArr, j4);
    }

    public static Object d(Object[] objArr, long j4) {
        return v.f14123a.getObjectVolatile(objArr, j4);
    }

    public static void e(Object[] objArr, long j4, Object obj) {
        v.f14123a.putOrderedObject(objArr, j4, obj);
    }

    public static void f(Object[] objArr, long j4, Object obj) {
        v.f14123a.putObject(objArr, j4, obj);
    }

    public final long a(long j4) {
        return f14108d + ((j4 & this.f14110a) << f14109e);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
