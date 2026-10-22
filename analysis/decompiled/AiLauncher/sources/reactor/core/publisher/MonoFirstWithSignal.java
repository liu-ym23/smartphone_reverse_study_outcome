package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFirstWithSignal;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoFirstWithSignal<T> extends Mono<T> implements SourceProducer<T> {
    final Mono<? extends T>[] array;
    final Iterable<? extends Mono<? extends T>> iterable;

    @SafeVarargs
    public MonoFirstWithSignal(Mono<? extends T>... monoArr) {
        Objects.requireNonNull(monoArr, "array");
        this.array = monoArr;
        this.iterable = null;
    }

    @Nullable
    public Mono<T> orAdditionalSource(Mono<? extends T> mono) {
        Mono<? extends T>[] monoArr = this.array;
        if (monoArr == null) {
            return null;
        }
        int length = monoArr.length;
        Mono[] monoArr2 = new Mono[length + 1];
        System.arraycopy(monoArr, 0, monoArr2, 0, length);
        monoArr2[length] = mono;
        return new MonoFirstWithSignal(monoArr2);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        int length;
        qc.b<? extends T>[] bVarArr = this.array;
        if (bVarArr == null) {
            bVarArr = new qc.b[8];
            try {
                Iterator<? extends Mono<? extends T>> it = this.iterable.iterator();
                Objects.requireNonNull(it, "The iterator returned is null");
                Iterator<? extends Mono<? extends T>> it2 = it;
                length = 0;
                while (it2.hasNext()) {
                    try {
                        try {
                            Mono<? extends T> next = it2.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            Mono<? extends T> mono = next;
                            if (length == bVarArr.length) {
                                qc.b<? extends T>[] bVarArr2 = new qc.b[(length >> 2) + length];
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                bVarArr = bVarArr2;
                            }
                            bVarArr[length] = mono;
                            length++;
                        } catch (Throwable th) {
                            Operators.error(coreSubscriber, Operators.onOperatorError(th, coreSubscriber.currentContext()));
                            return;
                        }
                    } catch (Throwable th2) {
                        Operators.error(coreSubscriber, Operators.onOperatorError(th2, coreSubscriber.currentContext()));
                        return;
                    }
                }
            } catch (Throwable th3) {
                Operators.error(coreSubscriber, Operators.onOperatorError(th3, coreSubscriber.currentContext()));
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (length != 1) {
            Operators.toFluxOrMono(bVarArr);
            new FluxFirstWithSignal.RaceCoordinator(length).subscribe(bVarArr, length, coreSubscriber);
            return;
        }
        qc.b<? extends T> bVar = bVarArr[0];
        if (bVar == null) {
            Operators.error(coreSubscriber, Operators.onOperatorError(new NullPointerException("The single source Publisher is null"), coreSubscriber.currentContext()));
        } else {
            Operators.toFluxOrMono(bVar).subscribe((qc.c) coreSubscriber);
        }
    }

    public MonoFirstWithSignal(Iterable<? extends Mono<? extends T>> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}
