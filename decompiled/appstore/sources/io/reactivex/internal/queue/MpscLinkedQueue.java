package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MpscLinkedQueue implements SimplePlainQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f20707b;

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
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

    public MpscLinkedQueue() {
        this.f20706a = new AtomicReference();
        this.f20707b = new AtomicReference();
        LinkedQueueNode r10 = new LinkedQueueNode();
        d(r10);
        e(r10);
    }

    public LinkedQueueNode a() {
        return (LinkedQueueNode) this.f20707b.get();
    }

    public LinkedQueueNode b() {
        return (LinkedQueueNode) this.f20707b.get();
    }

    public LinkedQueueNode c() {
        return (LinkedQueueNode) this.f20706a.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    public void d(LinkedQueueNode r10) {
        this.f20707b.lazySet(r10);
    }

    public LinkedQueueNode e(LinkedQueueNode r10) {
        return (LinkedQueueNode) this.f20706a.getAndSet(r10);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (b() != c()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10) {
        if (r10 == null) goto L6;
        LinkedQueueNode r11 = new LinkedQueueNode(r10);
        e(r11).soNext(r11);
        return true;
    L6:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        LinkedQueueNode r10 = a();
        LinkedQueueNode r11 = r10.lvNext();
        if (r11 == null) goto L7;
        Object r12 = r11.getAndNullValue();
        d(r11);
        return r12;
    L7:
        if (r10 == c()) goto L13;
    L8:
        LinkedQueueNode r13 = r10.lvNext();
        if (r13 == null) goto L8;
        Object r14 = r13.getAndNullValue();
        d(r13);
        return r14;
    L13:
        return null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10, Object r11) {
        offer(r10);
        offer(r11);
        return true;
    }
}
