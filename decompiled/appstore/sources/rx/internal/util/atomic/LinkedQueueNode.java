package rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public LinkedQueueNode() {
    }

    public E getAndNullValue() {
        E r10 = lpValue();
        spValue(null);
        return r10;
    }

    public E lpValue() {
        return this.value;
    }

    public LinkedQueueNode<E> lvNext() {
        return get();
    }

    public void soNext(LinkedQueueNode<E> r10) {
        lazySet(r10);
    }

    public void spValue(E r10) {
        this.value = r10;
    }

    public LinkedQueueNode(E r10) {
        spValue(r10);
    }
}
