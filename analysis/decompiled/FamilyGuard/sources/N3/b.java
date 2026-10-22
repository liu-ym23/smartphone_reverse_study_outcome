package N3;

import G3.e;
import R3.i;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class b<E> extends AtomicReferenceArray<E> implements e<E> {

    /* renamed from: f, reason: collision with root package name */
    private static final Integer f4247f = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);

    /* renamed from: a, reason: collision with root package name */
    final int f4248a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicLong f4249b;

    /* renamed from: c, reason: collision with root package name */
    long f4250c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicLong f4251d;

    /* renamed from: e, reason: collision with root package name */
    final int f4252e;

    public b(int i5) {
        super(i.a(i5));
        this.f4248a = length() - 1;
        this.f4249b = new AtomicLong();
        this.f4251d = new AtomicLong();
        this.f4252e = Math.min(i5 / 4, f4247f.intValue());
    }

    int a(long j5) {
        return this.f4248a & ((int) j5);
    }

    int c(long j5, int i5) {
        return ((int) j5) & i5;
    }

    @Override // G3.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    E d(int i5) {
        return get(i5);
    }

    void e(long j5) {
        this.f4251d.lazySet(j5);
    }

    void f(int i5, E e6) {
        lazySet(i5, e6);
    }

    void g(long j5) {
        this.f4249b.lazySet(j5);
    }

    @Override // G3.f
    public boolean isEmpty() {
        return this.f4249b.get() == this.f4251d.get();
    }

    @Override // G3.f
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i5 = this.f4248a;
        long j5 = this.f4249b.get();
        int iC = c(j5, i5);
        if (j5 >= this.f4250c) {
            long j6 = this.f4252e + j5;
            if (d(c(j6, i5)) == null) {
                this.f4250c = j6;
            } else if (d(iC) != null) {
                return false;
            }
        }
        f(iC, e6);
        g(j5 + 1);
        return true;
    }

    @Override // G3.e, G3.f
    public E poll() {
        long j5 = this.f4251d.get();
        int iA = a(j5);
        E eD = d(iA);
        if (eD == null) {
            return null;
        }
        e(j5 + 1);
        f(iA, null);
        return eD;
    }
}
