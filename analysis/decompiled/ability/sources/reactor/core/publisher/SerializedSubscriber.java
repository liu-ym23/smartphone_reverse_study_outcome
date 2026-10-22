package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class SerializedSubscriber<T> implements InnerOperator<T, T> {
    final CoreSubscriber<? super T> actual;
    volatile boolean cancelled;
    boolean concurrentlyAddedContent;
    volatile boolean done;
    boolean drainLoopInProgress;
    Throwable error;
    LinkedArrayNode<T> head;

    /* renamed from: s, reason: collision with root package name */
    Z9.e f5891s;
    LinkedArrayNode<T> tail;

    public static final class LinkedArrayNode<T> {
        static final int DEFAULT_CAPACITY = 16;
        final T[] array;
        int count;
        LinkedArrayNode<T> next;

        public LinkedArrayNode(T t9) {
            T[] tArr = (T[]) new Object[16];
            this.array = tArr;
            tArr[0] = t9;
            this.count = 1;
        }
    }

    public SerializedSubscriber(CoreSubscriber<? super T> coreSubscriber) {
        this.actual = coreSubscriber;
    }

    private void discardMultiple(LinkedArrayNode<T> linkedArrayNode) {
        LinkedArrayNode<T> linkedArrayNode2;
        while (true) {
            LinkedArrayNode<T> linkedArrayNode3 = linkedArrayNode;
            while (linkedArrayNode != null) {
                for (int i = 0; i < linkedArrayNode.count; i++) {
                    Operators.onDiscard(linkedArrayNode.array[i], this.actual.currentContext());
                }
                linkedArrayNode = linkedArrayNode.next;
                if (linkedArrayNode != null || (linkedArrayNode2 = this.head) == linkedArrayNode3) {
                }
            }
            return;
            linkedArrayNode = linkedArrayNode2;
        }
    }

    @Override // reactor.core.publisher.InnerProducer
    public CoreSubscriber<? super T> actual() {
        return this.actual;
    }

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
    public void cancel() {
        this.cancelled = true;
        this.f5891s.cancel();
    }

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onComplete() {
        if (this.cancelled || this.done) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.cancelled && !this.done) {
                    this.done = true;
                    if (this.drainLoopInProgress) {
                        this.concurrentlyAddedContent = true;
                    } else {
                        this.actual.onComplete();
                    }
                }
            } finally {
            }
        }
    }

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onError(Throwable th) {
        if (this.cancelled || this.done) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.cancelled && !this.done) {
                    this.done = true;
                    this.error = th;
                    if (this.drainLoopInProgress) {
                        this.concurrentlyAddedContent = true;
                    } else {
                        this.actual.onError(th);
                    }
                }
            } finally {
            }
        }
    }

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
    public void onNext(T t9) {
        if (this.cancelled) {
            Operators.onDiscard(t9, this.actual.currentContext());
            return;
        }
        if (this.done) {
            Operators.onNextDropped(t9, this.actual.currentContext());
            return;
        }
        synchronized (this) {
            try {
                if (this.cancelled) {
                    Operators.onDiscard(t9, this.actual.currentContext());
                    return;
                }
                if (this.done) {
                    Operators.onNextDropped(t9, this.actual.currentContext());
                    return;
                }
                if (this.drainLoopInProgress) {
                    serAdd(t9);
                    this.concurrentlyAddedContent = true;
                } else {
                    this.drainLoopInProgress = true;
                    this.actual.onNext(t9);
                    serDrainLoop(this.actual);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, Z9.d
    public void onSubscribe(Z9.e eVar) {
        if (Operators.validate(this.f5891s, eVar)) {
            this.f5891s = eVar;
            this.actual.onSubscribe(this);
        }
    }

    public int producerCapacity() {
        LinkedArrayNode<T> linkedArrayNode = this.tail;
        if (linkedArrayNode != null) {
            return linkedArrayNode.count;
        }
        return 0;
    }

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
    public void request(long j5) {
        this.f5891s.request(j5);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.f5891s;
        }
        if (attr == Scannable.Attr.ERROR) {
            return this.error;
        }
        if (attr == Scannable.Attr.BUFFERED) {
            return Integer.valueOf(producerCapacity());
        }
        if (attr == Scannable.Attr.CAPACITY) {
            return 16;
        }
        return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
    }

    public void serAdd(T t9) {
        if (this.cancelled) {
            Operators.onDiscard(t9, this.actual.currentContext());
            return;
        }
        LinkedArrayNode<T> linkedArrayNode = this.tail;
        if (linkedArrayNode == null) {
            LinkedArrayNode<T> linkedArrayNode2 = new LinkedArrayNode<>(t9);
            this.head = linkedArrayNode2;
            this.tail = linkedArrayNode2;
        } else {
            int i = linkedArrayNode.count;
            if (i == 16) {
                LinkedArrayNode<T> linkedArrayNode3 = new LinkedArrayNode<>(t9);
                linkedArrayNode.next = linkedArrayNode3;
                this.tail = linkedArrayNode3;
            } else {
                T[] tArr = linkedArrayNode.array;
                linkedArrayNode.count = i + 1;
                tArr[i] = t9;
            }
        }
        if (this.cancelled) {
            Operators.onDiscard(t9, this.actual.currentContext());
        }
    }

    public void serDrainLoop(CoreSubscriber<? super T> coreSubscriber) {
        while (!this.cancelled) {
            synchronized (this) {
                try {
                    if (this.cancelled) {
                        discardMultiple(this.head);
                        return;
                    }
                    if (!this.concurrentlyAddedContent) {
                        this.drainLoopInProgress = false;
                        return;
                    }
                    this.concurrentlyAddedContent = false;
                    boolean z10 = this.done;
                    Throwable th = this.error;
                    this.head = null;
                    this.tail = null;
                    for (LinkedArrayNode<T> linkedArrayNode = this.head; linkedArrayNode != null; linkedArrayNode = linkedArrayNode.next) {
                        T[] tArr = linkedArrayNode.array;
                        int i = linkedArrayNode.count;
                        for (int i6 = 0; i6 < i; i6++) {
                            if (this.cancelled) {
                                synchronized (this) {
                                    discardMultiple(linkedArrayNode);
                                }
                                return;
                            }
                            coreSubscriber.onNext(tArr[i6]);
                        }
                    }
                    if (this.cancelled) {
                        synchronized (this) {
                            discardMultiple(this.head);
                        }
                        return;
                    } else if (th != null) {
                        coreSubscriber.onError(th);
                        return;
                    } else if (z10) {
                        coreSubscriber.onComplete();
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        synchronized (this) {
            discardMultiple(this.head);
        }
    }
}
