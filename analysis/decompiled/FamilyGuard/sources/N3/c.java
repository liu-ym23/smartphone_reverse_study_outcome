package N3;

import G3.e;
import R3.i;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class c<T> implements e<T> {

    /* renamed from: i, reason: collision with root package name */
    static final int f4253i = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT).intValue();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f4254j = new Object();

    /* renamed from: b, reason: collision with root package name */
    int f4256b;

    /* renamed from: c, reason: collision with root package name */
    long f4257c;

    /* renamed from: d, reason: collision with root package name */
    final int f4258d;

    /* renamed from: e, reason: collision with root package name */
    AtomicReferenceArray<Object> f4259e;

    /* renamed from: f, reason: collision with root package name */
    final int f4260f;

    /* renamed from: g, reason: collision with root package name */
    AtomicReferenceArray<Object> f4261g;

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f4255a = new AtomicLong();

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f4262h = new AtomicLong();

    public c(int i5) {
        int iA = i.a(Math.max(8, i5));
        int i6 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.f4259e = atomicReferenceArray;
        this.f4258d = i6;
        a(iA);
        this.f4261g = atomicReferenceArray;
        this.f4260f = i6;
        this.f4257c = iA - 2;
        p(0L);
    }

    private void a(int i5) {
        this.f4256b = Math.min(i5 / 4, f4253i);
    }

    private static int c(int i5) {
        return i5;
    }

    private static int d(long j5, int i5) {
        return c(((int) j5) & i5);
    }

    private long e() {
        return this.f4262h.get();
    }

    private long f() {
        return this.f4255a.get();
    }

    private long g() {
        return this.f4262h.get();
    }

    private static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int i5) {
        return atomicReferenceArray.get(i5);
    }

    private AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> atomicReferenceArray, int i5) {
        int iC = c(i5);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, iC);
        n(atomicReferenceArray, iC, null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f4255a.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j5, int i5) {
        this.f4261g = atomicReferenceArray;
        int iD = d(j5, i5);
        T t5 = (T) h(atomicReferenceArray, iD);
        if (t5 != null) {
            n(atomicReferenceArray, iD, null);
            m(j5 + 1);
        }
        return t5;
    }

    private void l(AtomicReferenceArray<Object> atomicReferenceArray, long j5, int i5, T t5, long j6) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f4259e = atomicReferenceArray2;
        this.f4257c = (j6 + j5) - 1;
        n(atomicReferenceArray2, i5, t5);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i5, f4254j);
        p(j5 + 1);
    }

    private void m(long j5) {
        this.f4262h.lazySet(j5);
    }

    private static void n(AtomicReferenceArray<Object> atomicReferenceArray, int i5, Object obj) {
        atomicReferenceArray.lazySet(i5, obj);
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        n(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void p(long j5) {
        this.f4255a.lazySet(j5);
    }

    private boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t5, long j5, int i5) {
        n(atomicReferenceArray, i5, t5);
        p(j5 + 1);
        return true;
    }

    @Override // G3.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // G3.f
    public boolean isEmpty() {
        return j() == g();
    }

    @Override // G3.f
    public boolean offer(T t5) {
        if (t5 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f4259e;
        long jF = f();
        int i5 = this.f4258d;
        int iD = d(jF, i5);
        if (jF < this.f4257c) {
            return q(atomicReferenceArray, t5, jF, iD);
        }
        long j5 = this.f4256b + jF;
        if (h(atomicReferenceArray, d(j5, i5)) == null) {
            this.f4257c = j5 - 1;
            return q(atomicReferenceArray, t5, jF, iD);
        }
        if (h(atomicReferenceArray, d(jF + 1, i5)) == null) {
            return q(atomicReferenceArray, t5, jF, iD);
        }
        l(atomicReferenceArray, jF, iD, t5, i5);
        return true;
    }

    @Override // G3.e, G3.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f4261g;
        long jE = e();
        int i5 = this.f4260f;
        int iD = d(jE, i5);
        T t5 = (T) h(atomicReferenceArray, iD);
        boolean z5 = t5 == f4254j;
        if (t5 == null || z5) {
            if (z5) {
                return k(i(atomicReferenceArray, i5 + 1), jE, i5);
            }
            return null;
        }
        n(atomicReferenceArray, iD, null);
        m(jE + 1);
        return t5;
    }
}
