package reactor.core.publisher;

import java.time.Duration;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.core.publisher.SinkEmptyMulticast;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class SinkOneMulticast<O> extends SinkEmptyMulticast<O> implements InternalOneSink<O> {
    static final int STATE_VALUE = 1;
    static final SinkEmptyMulticast.Inner[] TERMINATED_VALUE = new SinkEmptyMulticast.Inner[0];

    @Nullable
    O value;

    public static final class NextInner<T> extends Operators.MonoInnerProducerBase<T> implements SinkEmptyMulticast.Inner<T> {
        final SinkOneMulticast<T> parent;

        public NextInner(CoreSubscriber<? super T> coreSubscriber, SinkOneMulticast<T> sinkOneMulticast) {
            super(coreSubscriber);
            this.parent = sinkOneMulticast;
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase
        public void doOnCancel() {
            this.parent.remove(this);
        }

        @Override // reactor.core.publisher.SinkEmptyMulticast.Inner
        public void error(Throwable th) {
            if (isCancelled()) {
                return;
            }
            actual().onError(th);
        }

        @Override // reactor.core.publisher.Operators.MonoInnerProducerBase, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    @Override // reactor.core.publisher.SinkEmptyMulticast
    public int add(SinkEmptyMulticast.Inner<O> inner) {
        SinkEmptyMulticast.Inner[] innerArr;
        SinkEmptyMulticast.Inner[] innerArr2;
        do {
            innerArr = this.subscribers;
            if (innerArr == SinkEmptyMulticast.TERMINATED_EMPTY) {
                return -2;
            }
            if (innerArr == SinkEmptyMulticast.TERMINATED_ERROR) {
                return -1;
            }
            if (innerArr == TERMINATED_VALUE) {
                return 1;
            }
            int length = innerArr.length;
            innerArr2 = new SinkEmptyMulticast.Inner[length + 1];
            System.arraycopy(innerArr, 0, innerArr2, 0, length);
            innerArr2[length] = inner;
        } while (!SinkEmptyMulticast.SUBSCRIBERS.compareAndSet(this, innerArr, innerArr2));
        return 0;
    }

    @Override // reactor.core.publisher.Mono
    @Nullable
    public O block(Duration duration) {
        return duration.isNegative() ? (O) super.block(Duration.ZERO) : (O) super.block(duration);
    }

    @Override // reactor.core.publisher.SinkEmptyMulticast
    public boolean isTerminated(SinkEmptyMulticast.Inner<?>[] innerArr) {
        return innerArr == TERMINATED_VALUE || super.isTerminated(innerArr);
    }

    @Override // reactor.core.publisher.SinkEmptyMulticast, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(isTerminated(this.subscribers));
        }
        if (attr == Scannable.Attr.ERROR) {
            if (this.subscribers == SinkEmptyMulticast.TERMINATED_ERROR) {
                return this.error;
            }
            return null;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.SinkEmptyMulticast, reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super O> coreSubscriber) {
        CoreSubscriber coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        NextInner nextInner = new NextInner(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled, this);
        coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(nextInner);
        int iAdd = add(nextInner);
        if (iAdd == 0) {
            if (nextInner.isCancelled()) {
                remove(nextInner);
            }
        } else if (iAdd == -1) {
            coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onError(this.error);
        } else if (iAdd == -2) {
            nextInner.complete();
        } else {
            nextInner.complete(this.value);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // reactor.core.publisher.Sinks.One
    public Sinks.EmitResult tryEmitValue(@Nullable O o10) {
        SinkEmptyMulticast.Inner[] innerArr = this.subscribers;
        if (isTerminated(innerArr)) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (o10 == null) {
            return tryEmitEmpty();
        }
        this.value = o10;
        while (!SinkEmptyMulticast.SUBSCRIBERS.compareAndSet(this, innerArr, TERMINATED_VALUE)) {
            innerArr = this.subscribers;
            if (isTerminated(innerArr)) {
                return Sinks.EmitResult.FAIL_TERMINATED;
            }
        }
        for (SinkEmptyMulticast.Inner inner : innerArr) {
            inner.complete(o10);
        }
        return Sinks.EmitResult.OK;
    }
}
