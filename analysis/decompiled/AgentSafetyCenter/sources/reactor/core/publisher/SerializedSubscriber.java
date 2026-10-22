package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class SerializedSubscriber<T> implements InnerOperator<T, T> {
    final CoreSubscriber<? super T> actual;
    volatile boolean cancelled;
    boolean concurrentlyAddedContent;
    volatile boolean done;
    boolean drainLoopInProgress;
    Throwable error;
    LinkedArrayNode<T> head;

    /* renamed from: s, reason: collision with root package name */
    qd.e f10751s;
    LinkedArrayNode<T> tail;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class LinkedArrayNode<T> {
        static final int DEFAULT_CAPACITY = 16;
        final T[] array;
        int count;
        LinkedArrayNode<T> next;

        public LinkedArrayNode(T t10) {
            T[] tArr = (T[]) new Object[16];
            this.array = tArr;
            tArr[0] = t10;
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

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
    public void cancel() {
        this.cancelled = true;
        this.f10751s.cancel();
    }

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
    public void onNext(T t10) {
        if (this.cancelled) {
            Operators.onDiscard(t10, this.actual.currentContext());
            return;
        }
        if (this.done) {
            Operators.onNextDropped(t10, this.actual.currentContext());
            return;
        }
        synchronized (this) {
            try {
                if (this.cancelled) {
                    Operators.onDiscard(t10, this.actual.currentContext());
                    return;
                }
                if (this.done) {
                    Operators.onNextDropped(t10, this.actual.currentContext());
                    return;
                }
                if (this.drainLoopInProgress) {
                    serAdd(t10);
                    this.concurrentlyAddedContent = true;
                } else {
                    this.drainLoopInProgress = true;
                    this.actual.onNext(t10);
                    serDrainLoop(this.actual);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // reactor.core.CoreSubscriber, qd.d
    public void onSubscribe(qd.e eVar) {
        if (Operators.validate(this.f10751s, eVar)) {
            this.f10751s = eVar;
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

    @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
    public void request(long j10) {
        this.f10751s.request(j10);
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.f10751s;
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

    public void serAdd(T t10) {
        if (this.cancelled) {
            Operators.onDiscard(t10, this.actual.currentContext());
            return;
        }
        LinkedArrayNode<T> linkedArrayNode = this.tail;
        if (linkedArrayNode == null) {
            LinkedArrayNode<T> linkedArrayNode2 = new LinkedArrayNode<>(t10);
            this.head = linkedArrayNode2;
            this.tail = linkedArrayNode2;
        } else {
            int i = linkedArrayNode.count;
            if (i == 16) {
                LinkedArrayNode<T> linkedArrayNode3 = new LinkedArrayNode<>(t10);
                linkedArrayNode.next = linkedArrayNode3;
                this.tail = linkedArrayNode3;
            } else {
                T[] tArr = linkedArrayNode.array;
                linkedArrayNode.count = i + 1;
                tArr[i] = t10;
            }
        }
        if (this.cancelled) {
            Operators.onDiscard(t10, this.actual.currentContext());
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
                        for (int i3 = 0; i3 < i; i3++) {
                            if (this.cancelled) {
                                synchronized (this) {
                                    discardMultiple(linkedArrayNode);
                                }
                                return;
                            }
                            coreSubscriber.onNext(tArr[i3]);
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
