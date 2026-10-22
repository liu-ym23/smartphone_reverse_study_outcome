package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public final class q extends v {
    public q(int r10) {
        super(r10);
    }

    private long h() {
        return e0.f24434a.getLongVolatile(this, s.f24446i);
    }

    private long i() {
        return e0.f24434a.getLongVolatile(this, w.f24447h);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        if (i() != h()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j(long r10) {
        e0.f24434a.putOrderedLong(this, s.f24446i, r10);
    }

    public final void k(long r10) {
        e0.f24434a.putOrderedLong(this, w.f24447h, r10);
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(Object r10) {
        if (r10 == null) goto L10;
        Object[] r11 = this.f24440b;
        long r12 = this.producerIndex;
        long r13 = a(r12);
        if (e(r11, r13) == null) goto L7;
        return false;
    L7:
        f(r11, r13, r10);
        k(r12 + 1);
        return true;
    L10:
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public Object peek() {
        return d(a(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public Object poll() {
        long r10 = this.consumerIndex;
        long r11 = a(r10);
        Object[] r12 = this.f24440b;
        Object r13 = e(r12, r11);
        if (r13 != null) goto L5;
        return null;
    L5:
        f(r12, r11, null);
        j(r10 + 1);
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long r10 = h();
    L3:
        long r11 = i();
        long r12 = h();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
    }
}
