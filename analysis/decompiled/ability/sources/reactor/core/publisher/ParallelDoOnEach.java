package reactor.core.publisher;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeek;
import reactor.core.publisher.FluxPeekFuseable;
import reactor.core.publisher.ParallelDoOnEach;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class ParallelDoOnEach<T> extends ParallelFlux<T> implements Scannable {
    final Consumer<Context> onComplete;
    final BiConsumer<Context, ? super Throwable> onError;
    final BiConsumer<Context, ? super T> onNext;
    final ParallelFlux<T> source;

    public class DoOnEachSignalPeek implements SignalPeek<T> {
        Runnable onCompleteCall;
        Consumer<? super Throwable> onErrorCall;
        Consumer<? super T> onNextCall;

        public DoOnEachSignalPeek(final Context context) {
            Consumer<? super T> consumer;
            Consumer<? super Throwable> consumer2;
            if (ParallelDoOnEach.this.onNext != null) {
                final int i = 0;
                consumer = new Consumer(this) { // from class: reactor.core.publisher.g0
                    public final /* synthetic */ ParallelDoOnEach.DoOnEachSignalPeek b;

                    {
                        this.b = this;
                    }

                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        switch (i) {
                            case 0:
                                this.b.lambda$new$0(context, obj);
                                break;
                            default:
                                this.b.lambda$new$1(context, (Throwable) obj);
                                break;
                        }
                    }
                };
            } else {
                consumer = null;
            }
            this.onNextCall = consumer;
            if (ParallelDoOnEach.this.onError != null) {
                final int i6 = 1;
                consumer2 = new Consumer(this) { // from class: reactor.core.publisher.g0
                    public final /* synthetic */ ParallelDoOnEach.DoOnEachSignalPeek b;

                    {
                        this.b = this;
                    }

                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        switch (i6) {
                            case 0:
                                this.b.lambda$new$0(context, obj);
                                break;
                            default:
                                this.b.lambda$new$1(context, (Throwable) obj);
                                break;
                        }
                    }
                };
            } else {
                consumer2 = null;
            }
            this.onErrorCall = consumer2;
            this.onCompleteCall = ParallelDoOnEach.this.onComplete != null ? new K(this, context, 1) : null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(Context context, Object obj) {
            ParallelDoOnEach.this.onNext.accept(context, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(Context context, Throwable th) {
            ParallelDoOnEach.this.onError.accept(context, th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(Context context) {
            ParallelDoOnEach.this.onComplete.accept(context);
        }

        @Override // reactor.core.publisher.SignalPeek
        public Runnable onAfterTerminateCall() {
            return null;
        }

        @Override // reactor.core.publisher.SignalPeek
        public Runnable onCancelCall() {
            return null;
        }

        @Override // reactor.core.publisher.SignalPeek
        public Runnable onCompleteCall() {
            return this.onCompleteCall;
        }

        @Override // reactor.core.publisher.SignalPeek
        public Consumer<? super Throwable> onErrorCall() {
            return this.onErrorCall;
        }

        @Override // reactor.core.publisher.SignalPeek
        public Consumer<? super T> onNextCall() {
            return this.onNextCall;
        }

        @Override // reactor.core.publisher.SignalPeek
        public LongConsumer onRequestCall() {
            return null;
        }

        @Override // reactor.core.publisher.SignalPeek
        public Consumer<? super Z9.e> onSubscribeCall() {
            return null;
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return null;
        }
    }

    public ParallelDoOnEach(ParallelFlux<T> parallelFlux, @Nullable BiConsumer<Context, ? super T> biConsumer, @Nullable BiConsumer<Context, ? super Throwable> biConsumer2, @Nullable Consumer<Context> consumer) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.onNext = biConsumer;
        this.onError = biConsumer2;
        this.onComplete = consumer;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return this.source.getPrefetch();
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super T>[] coreSubscriberArr2 = new CoreSubscriber[length];
            boolean z10 = coreSubscriberArr[0] instanceof Fuseable.ConditionalSubscriber;
            for (int i = 0; i < length; i++) {
                CoreSubscriber<? super T> coreSubscriber = coreSubscriberArr[i];
                DoOnEachSignalPeek doOnEachSignalPeek = new DoOnEachSignalPeek(coreSubscriber.currentContext());
                if (z10) {
                    coreSubscriberArr2[i] = new FluxPeekFuseable.PeekConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, doOnEachSignalPeek);
                } else {
                    coreSubscriberArr2[i] = new FluxPeek.PeekSubscriber(coreSubscriber, doOnEachSignalPeek);
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}
