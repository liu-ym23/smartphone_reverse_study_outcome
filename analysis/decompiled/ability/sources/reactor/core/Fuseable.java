package reactor.core;

import Z9.e;
import androidx.constraintlayout.core.dsl.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Callable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public interface Fuseable {
    public static final int ANY = 3;
    public static final int ASYNC = 2;
    public static final int NONE = 0;
    public static final int SYNC = 1;
    public static final int THREAD_BARRIER = 4;

    public interface ConditionalSubscriber<T> extends CoreSubscriber<T> {
        @Override // reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onComplete();

        @Override // reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onNext(Object obj);

        boolean tryOnNext(T t9);
    }

    public interface QueueSubscription<T> extends Queue<T>, e {
        public static final String NOT_SUPPORTED_MESSAGE = "Although QueueSubscription extends Queue it is purely internal and only guarantees support for poll/clear/size/isEmpty. Instances shouldn't be used/exposed as Queue outside of Reactor operators.";

        @Override // java.util.Queue, java.util.Collection
        default boolean add(@Nullable T t9) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection
        default boolean addAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // Z9.e
        /* synthetic */ void cancel();

        @Override // java.util.Collection
        default boolean contains(@Nullable Object obj) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection
        default boolean containsAll(Collection<?> collection) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Queue
        default T element() {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection, java.lang.Iterable
        default Iterator<T> iterator() {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Queue
        default boolean offer(@Nullable T t9) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Queue
        @Nullable
        default T peek() {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Queue
        default T remove() {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection
        default boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // Z9.e
        /* synthetic */ void request(long j5);

        int requestFusion(int i);

        @Override // java.util.Collection
        default boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection
        default Object[] toArray() {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection
        default boolean remove(@Nullable Object obj) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }

        @Override // java.util.Collection
        default <T1> T1[] toArray(T1[] t1Arr) {
            throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
        }
    }

    public interface ScalarCallable<T> extends Callable<T> {
    }

    public interface SynchronousSubscription<T> extends QueueSubscription<T> {
        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        /* synthetic */ void cancel();

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        /* synthetic */ void request(long j5);

        @Override // reactor.core.Fuseable.QueueSubscription
        default int requestFusion(int i) {
            return (i & 1) != 0 ? 1 : 0;
        }
    }

    static String fusionModeName(int i) {
        return fusionModeName(i, false);
    }

    static String fusionModeName(int i, boolean z10) {
        String str = "";
        if (i >= 0) {
            int i6 = i & (-5);
            if (!z10 && (i & 4) == 4) {
                str = "+THREAD_BARRIER";
            }
            i = i6;
        }
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? a.c(i, "Unknown(", ")", str) : "ASYNC".concat(str) : "SYNC".concat(str) : "NONE".concat(str) : "Disabled";
    }
}
