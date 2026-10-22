package reactor.core.publisher;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import reactor.core.Exceptions;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
interface OnNextFailureStrategy extends BiFunction<Throwable, Object, Throwable>, BiPredicate<Throwable, Object> {
    public static final String KEY_ON_NEXT_ERROR_STRATEGY = "reactor.onNextError.localStrategy";
    public static final OnNextFailureStrategy STOP = new OnNextFailureStrategy() { // from class: reactor.core.publisher.OnNextFailureStrategy.1
        @Override // reactor.core.publisher.OnNextFailureStrategy
        public Throwable process(Throwable th, @Nullable Object obj, Context context) {
            Exceptions.throwIfFatal(th);
            IllegalStateException illegalStateException = new IllegalStateException("STOP strategy cannot process errors");
            illegalStateException.addSuppressed(th);
            return illegalStateException;
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy, java.util.function.BiPredicate
        public boolean test(Throwable th, @Nullable Object obj) {
            return false;
        }
    };
    public static final OnNextFailureStrategy RESUME_DROP = new ResumeDropStrategy(null);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ResumeDropStrategy implements OnNextFailureStrategy {
        final Predicate<Throwable> errorPredicate;

        public ResumeDropStrategy(@Nullable Predicate<Throwable> predicate) {
            this.errorPredicate = predicate;
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy
        @Nullable
        public Throwable process(Throwable th, @Nullable Object obj, Context context) {
            Predicate<Throwable> predicate = this.errorPredicate;
            if (predicate == null) {
                Exceptions.throwIfFatal(th);
            } else if (!predicate.test(th)) {
                Exceptions.throwIfFatal(th);
                return th;
            }
            if (obj != null) {
                try {
                    Operators.onNextDropped(obj, context);
                } catch (Throwable th2) {
                    return Exceptions.addSuppressed(th2, th);
                }
            }
            Operators.onErrorDropped(th, context);
            return null;
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy, java.util.function.BiPredicate
        public boolean test(Throwable th, @Nullable Object obj) {
            Predicate<Throwable> predicate = this.errorPredicate;
            return predicate == null || predicate.test(th);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ResumeStrategy implements OnNextFailureStrategy {
        final BiConsumer<Throwable, Object> errorConsumer;
        final Predicate<Throwable> errorPredicate;

        public ResumeStrategy(@Nullable Predicate<Throwable> predicate, BiConsumer<Throwable, Object> biConsumer) {
            this.errorPredicate = predicate;
            this.errorConsumer = biConsumer;
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy
        @Nullable
        public Throwable process(Throwable th, @Nullable Object obj, Context context) {
            Predicate<Throwable> predicate = this.errorPredicate;
            if (predicate == null) {
                Exceptions.throwIfFatal(th);
            } else if (!predicate.test(th)) {
                Exceptions.throwIfFatal(th);
                return th;
            }
            try {
                this.errorConsumer.accept(th, obj);
                return null;
            } catch (Throwable th2) {
                return Exceptions.addSuppressed(th2, th);
            }
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy, java.util.function.BiPredicate
        public boolean test(Throwable th, @Nullable Object obj) {
            Predicate<Throwable> predicate = this.errorPredicate;
            return predicate == null || predicate.test(th);
        }
    }

    static OnNextFailureStrategy resume(BiConsumer<Throwable, Object> biConsumer) {
        return new ResumeStrategy(null, biConsumer);
    }

    static OnNextFailureStrategy resumeDrop() {
        return RESUME_DROP;
    }

    static OnNextFailureStrategy resumeDropIf(Predicate<Throwable> predicate) {
        return new ResumeDropStrategy(predicate);
    }

    static OnNextFailureStrategy resumeIf(Predicate<Throwable> predicate, BiConsumer<Throwable, Object> biConsumer) {
        return new ResumeStrategy(predicate, biConsumer);
    }

    static OnNextFailureStrategy stop() {
        return STOP;
    }

    @Override // java.util.function.BiFunction
    @Nullable
    default Throwable apply(Throwable th, @Nullable Object obj) {
        return process(th, obj, Context.empty());
    }

    @Nullable
    Throwable process(Throwable th, @Nullable Object obj, Context context);

    @Override // java.util.function.BiPredicate
    boolean test(Throwable th, @Nullable Object obj);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class LambdaOnNextErrorStrategy implements OnNextFailureStrategy {
        private final BiPredicate<? super Throwable, Object> delegatePredicate;
        private final BiFunction<? super Throwable, Object, ? extends Throwable> delegateProcessor;

        public LambdaOnNextErrorStrategy(BiFunction<? super Throwable, Object, ? extends Throwable> biFunction) {
            this.delegateProcessor = biFunction;
            if (biFunction instanceof BiPredicate) {
                this.delegatePredicate = (BiPredicate) biFunction;
            } else {
                this.delegatePredicate = new k(2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(Throwable th, Object obj) {
            return true;
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy
        @Nullable
        public Throwable process(Throwable th, @Nullable Object obj, Context context) {
            return this.delegateProcessor.apply(th, obj);
        }

        @Override // reactor.core.publisher.OnNextFailureStrategy, java.util.function.BiPredicate
        public boolean test(Throwable th, @Nullable Object obj) {
            return this.delegatePredicate.test(th, obj);
        }
    }
}
