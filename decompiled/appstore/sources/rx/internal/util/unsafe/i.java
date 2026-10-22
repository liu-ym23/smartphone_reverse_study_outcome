package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends m {
    public i(int r10) {
        super(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        if (k() != h()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(Object r10) {
        if (r10 == null) goto L15;
        Object[] r11 = this.f24440b;
        long r12 = this.f24439a;
        long r13 = h();
        long r14 = a(r13);
        if (e(r11, r14) != null) goto L6;
    L12:
        g(r11, r14, r10);
        i(r13 + 1);
        return true;
    L6:
        if ((r13 - k()) <= r12) goto L10;
        return false;
    L10:
        if (e(r11, r14) == null) goto L12;
    L15:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public Object peek() {
        long r10 = l();
    L3:
        long r11 = k();
        if (r11 < r10) goto L10;
        long r12 = h();
        if (r11 >= r12) goto L7;
        m(r12);
        goto L10
    L7:
        return null;
    L10:
        Object r13 = d(a(r11));
        if (r13 == null) goto L3;
        return r13;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public Object poll() {
        long r10 = l();
    L3:
        long r11 = k();
        if (r11 < r10) goto L10;
        long r12 = h();
        if (r11 >= r12) goto L7;
        m(r12);
        goto L10
    L7:
        return null;
    L10:
        if (j(r11, 1 + r11) == false) goto L3;
        long r13 = a(r11);
        Object[] r14 = this.f24440b;
        Object r15 = c(r14, r13);
        f(r14, r13, null);
        return r15;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long r10 = k();
    L3:
        long r11 = h();
        long r12 = k();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
    }
}
