package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> consumerNode;
    private final AtomicReference<LinkedQueueNode<T>> producerNode;

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E r1) {
            spValue(r1);
        }

        public E getAndNullValue() {
            E r0 = lpValue();
            spValue(null);
            return r0;
        }

        public E lpValue() {
            return this.value;
        }

        public void spValue(E r1) {
            this.value = r1;
        }

        public void soNext(LinkedQueueNode<E> r1) {
            lazySet(r1);
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }
    }

    public MpscLinkedQueue() {
        this.producerNode = new AtomicReference();
        this.consumerNode = new AtomicReference();
        LinkedQueueNode<T> r0 = new LinkedQueueNode();
        spConsumerNode(r0);
        xchgProducerNode(r0);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r2) {
        if (r2 == null) goto L6;
        LinkedQueueNode<T> r0 = new LinkedQueueNode(r2);
        xchgProducerNode(r0).soNext(r0);
        return true;
    L6:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        LinkedQueueNode<T> r0 = lpConsumerNode();
        LinkedQueueNode<T> r1 = r0.lvNext();
        if (r1 == null) goto L7;
        T r2 = r1.getAndNullValue();
        spConsumerNode(r1);
        return r2;
    L7:
        if (r0 == lvProducerNode()) goto L13;
    L8:
        LinkedQueueNode<T> r3 = r0.lvNext();
        if (r3 == null) goto L8;
        T r4 = r3.getAndNullValue();
        spConsumerNode(r3);
        return r4;
    L13:
        return null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r1, T r2) {
        offer(r1);
        offer(r2);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    LinkedQueueNode<T> lvProducerNode() {
        return this.producerNode.get();
    }

    LinkedQueueNode<T> xchgProducerNode(LinkedQueueNode<T> r1) {
        return this.producerNode.getAndSet(r1);
    }

    LinkedQueueNode<T> lvConsumerNode() {
        return this.consumerNode.get();
    }

    LinkedQueueNode<T> lpConsumerNode() {
        return this.consumerNode.get();
    }

    void spConsumerNode(LinkedQueueNode<T> r1) {
        this.consumerNode.lazySet(r1);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (lvConsumerNode() != lvProducerNode()) goto L5;
        return true;
    L5:
        return false;
    }
}
