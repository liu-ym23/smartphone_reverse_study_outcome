package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeek;
import reactor.core.publisher.FluxPeekFuseable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelDoOnEach<T> extends ParallelFlux<T> implements Scannable {
    final Consumer<Context> onComplete;
    final BiConsumer<Context, ? super Throwable> onError;
    final BiConsumer<Context, ? super T> onNext;
    final ParallelFlux<T> source;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class DoOnEachSignalPeek implements SignalPeek<T> {
        Runnable onCompleteCall;
        Consumer<? super Throwable> onErrorCall;
        Consumer<? super T> onNextCall;

        public DoOnEachSignalPeek(Context context) {
            f1 f1Var;
            f1 f1Var2;
            l0 l0Var = null;
            if (ParallelDoOnEach.this.onNext != null) {
                f1Var = new f1(0);
                f1Var.f10790f = this;
                f1Var.f10791g = context;
                VarHandle.storeStoreFence();
            } else {
                f1Var = null;
            }
            this.onNextCall = f1Var;
            int i = 1;
            if (ParallelDoOnEach.this.onError != null) {
                f1Var2 = new f1(i);
                f1Var2.f10790f = this;
                f1Var2.f10791g = context;
                VarHandle.storeStoreFence();
            } else {
                f1Var2 = null;
            }
            this.onErrorCall = f1Var2;
            if (ParallelDoOnEach.this.onComplete != null) {
                l0Var = new l0(i);
                l0Var.f10817f = this;
                l0Var.f10818g = context;
                VarHandle.storeStoreFence();
            }
            this.onCompleteCall = l0Var;
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
        public Consumer<? super qd.e> onSubscribeCall() {
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
