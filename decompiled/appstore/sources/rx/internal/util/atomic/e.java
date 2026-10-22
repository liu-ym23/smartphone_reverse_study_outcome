package rx.internal.util.atomic;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends b {
    public e() {
        LinkedQueueNode r10 = new LinkedQueueNode();
        f(r10);
        e(r10);
        r10.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(Object r10) {
        if (r10 == null) goto L6;
        LinkedQueueNode r11 = new LinkedQueueNode(r10);
        b().soNext(r11);
        f(r11);
        return true;
    L6:
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public Object peek() {
        LinkedQueueNode r10 = a().lvNext();
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.lpValue();
    }

    @Override // java.util.Queue
    public Object poll() {
        LinkedQueueNode r10 = a().lvNext();
        if (r10 == null) goto L6;
        Object r11 = r10.getAndNullValue();
        e(r10);
        return r11;
    L6:
        return null;
    }
}
