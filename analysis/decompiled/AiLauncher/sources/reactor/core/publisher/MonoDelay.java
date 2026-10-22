package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoDelay extends Mono<Long> implements Scannable, SourceProducer<Long> {
    static final String CONTEXT_OPT_OUT_NOBACKPRESSURE = "reactor.core.publisher.MonoDelay.failOnBackpressure";
    final long delay;
    final Scheduler timedScheduler;
    final TimeUnit unit;

    public static final class MonoDelayRunnable implements Runnable, InnerProducer<Long> {
        static final byte FLAG_CANCELLED = 64;
        static final byte FLAG_CANCEL_SET = 1;
        static final byte FLAG_DELAY_DONE = 2;
        static final byte FLAG_PROPAGATED = 4;
        static final byte FLAG_REQUESTED = 32;
        static final byte FLAG_REQUESTED_EARLY = 16;
        static final AtomicIntegerFieldUpdater<MonoDelayRunnable> STATE = AtomicIntegerFieldUpdater.newUpdater(MonoDelayRunnable.class, VoiceWakeupReceiver.EXTRA_STATE);
        final CoreSubscriber<? super Long> actual;
        Disposable cancel;
        final boolean failOnBackpressure;
        volatile int state;

        public MonoDelayRunnable(CoreSubscriber<? super Long> coreSubscriber, boolean z10) {
            this.actual = coreSubscriber;
            this.failOnBackpressure = z10;
        }

        public static int markCancelFutureSet(MonoDelayRunnable monoDelayRunnable) {
            int i10;
            do {
                i10 = monoDelayRunnable.state;
                if (wasCancelled(i10) || wasCancelFutureSet(i10)) {
                    break;
                }
            } while (!STATE.compareAndSet(monoDelayRunnable, i10, i10 | 1));
            return i10;
        }

        public static int markCancelled(MonoDelayRunnable monoDelayRunnable) {
            int i10;
            do {
                i10 = monoDelayRunnable.state;
                if (wasCancelled(i10) || wasPropagated(i10)) {
                    break;
                }
            } while (!STATE.compareAndSet(monoDelayRunnable, i10, i10 | 64));
            return i10;
        }

        public static int markDelayDone(MonoDelayRunnable monoDelayRunnable) {
            int i10;
            do {
                i10 = monoDelayRunnable.state;
                if (wasCancelled(i10) || wasDelayDone(i10)) {
                    break;
                }
            } while (!STATE.compareAndSet(monoDelayRunnable, i10, i10 | 2));
            return i10;
        }

        public static int markPropagated(MonoDelayRunnable monoDelayRunnable) {
            int i10;
            do {
                i10 = monoDelayRunnable.state;
                if (wasCancelled(i10)) {
                    break;
                }
            } while (!STATE.compareAndSet(monoDelayRunnable, i10, i10 | 4));
            return i10;
        }

        public static int markRequested(MonoDelayRunnable monoDelayRunnable) {
            int i10;
            do {
                i10 = monoDelayRunnable.state;
                if (wasCancelled(i10) || wasRequested(i10)) {
                    break;
                }
            } while (!STATE.compareAndSet(monoDelayRunnable, i10, (!wasDelayDone(i10) ? 48 : 32) | i10));
            return i10;
        }

        private void propagateDelay() {
            if (wasCancelled(markPropagated(this))) {
                return;
            }
            try {
                this.actual.onNext(0L);
                this.actual.onComplete();
            } catch (Throwable th) {
                CoreSubscriber<? super Long> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
            }
        }

        public static boolean wasCancelFutureSet(int i10) {
            return (i10 & 1) == 1;
        }

        public static boolean wasCancelled(int i10) {
            return (i10 & 64) == 64;
        }

        public static boolean wasDelayDone(int i10) {
            return (i10 & 2) == 2;
        }

        public static boolean wasPropagated(int i10) {
            return (i10 & 4) == 4;
        }

        public static boolean wasRequested(int i10) {
            return (i10 & 32) == 32;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Long> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            int iMarkCancelled = markCancelled(this);
            if (wasCancelled(iMarkCancelled) || wasPropagated(iMarkCancelled) || !wasCancelFutureSet(iMarkCancelled)) {
                return;
            }
            this.cancel.dispose();
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                int iMarkRequested = markRequested(this);
                if (wasCancelled(iMarkRequested) || wasRequested(iMarkRequested) || !wasDelayDone(iMarkRequested) || this.failOnBackpressure) {
                    return;
                }
                propagateDelay();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int iMarkDelayDone = markDelayDone(this);
            if (wasCancelled(iMarkDelayDone) || wasDelayDone(iMarkDelayDone)) {
                return;
            }
            if (wasRequested(iMarkDelayDone)) {
                propagateDelay();
            } else if (this.failOnBackpressure) {
                this.actual.onError(Exceptions.failWithOverflow("Could not emit value due to lack of requests"));
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(wasDelayDone(this.state) && wasRequested(this.state));
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(wasRequested(this.state) ? 1L : 0L);
            }
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(wasCancelled(this.state)) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void setCancel(Disposable disposable) {
            Disposable disposable2 = this.cancel;
            this.cancel = disposable;
            int iMarkCancelFutureSet = markCancelFutureSet(this);
            if (wasCancelFutureSet(iMarkCancelFutureSet)) {
                if (disposable2 != null) {
                    disposable2.dispose();
                }
            } else if (wasCancelled(iMarkCancelFutureSet)) {
                disposable.dispose();
            }
        }
    }

    public MonoDelay(long j10, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = j10;
        Objects.requireNonNull(timeUnit, "unit");
        this.unit = timeUnit;
        Objects.requireNonNull(scheduler, "timedScheduler");
        this.timedScheduler = scheduler;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.timedScheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super Long> coreSubscriber) {
        MonoDelayRunnable monoDelayRunnable = new MonoDelayRunnable(coreSubscriber, coreSubscriber.currentContext().getOrDefault(CONTEXT_OPT_OUT_NOBACKPRESSURE, Boolean.FALSE) == Boolean.TRUE);
        coreSubscriber.onSubscribe(monoDelayRunnable);
        try {
            monoDelayRunnable.setCancel(this.timedScheduler.schedule(monoDelayRunnable, this.delay, this.unit));
        } catch (RejectedExecutionException e10) {
            if (MonoDelayRunnable.wasCancelled(monoDelayRunnable.state)) {
                return;
            }
            coreSubscriber.onError(Operators.onRejectedExecution(e10, monoDelayRunnable, null, null, coreSubscriber.currentContext()));
        }
    }
}
