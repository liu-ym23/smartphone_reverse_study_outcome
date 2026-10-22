package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFirstWithSignal;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
        qd.c[] cVarArr = this.array;
        if (cVarArr == null) {
            cVarArr = new qd.c[8];
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
                            if (length == cVarArr.length) {
                                qd.c[] cVarArr2 = new qd.c[(length >> 2) + length];
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                cVarArr = cVarArr2;
                            }
                            cVarArr[length] = mono;
                            length++;
                        } catch (Throwable th) {
                            k0.a.B(coreSubscriber, th, coreSubscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        k0.a.B(coreSubscriber, th2, coreSubscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                k0.a.B(coreSubscriber, th3, coreSubscriber);
                return;
            }
        } else {
            length = cVarArr.length;
        }
        if (length == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (length != 1) {
            Operators.toFluxOrMono(cVarArr);
            new FluxFirstWithSignal.RaceCoordinator(length).subscribe(cVarArr, length, coreSubscriber);
            return;
        }
        qd.c cVar = cVarArr[0];
        if (cVar == null) {
            Operators.error(coreSubscriber, Operators.onOperatorError(new NullPointerException("The single source Publisher is null"), coreSubscriber.currentContext()));
        } else {
            Operators.toFluxOrMono(cVar).subscribe((qd.d) coreSubscriber);
        }
    }

    public MonoFirstWithSignal(Iterable<? extends Mono<? extends T>> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}
