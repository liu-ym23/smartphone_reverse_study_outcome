package reactor.core.publisher;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import java.util.Iterator;
import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFirstWithValue;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoFirstWithValue<T> extends Mono<T> implements SourceProducer<T> {
    final Mono<? extends T>[] array;
    final Iterable<? extends Mono<? extends T>> iterable;

    private MonoFirstWithValue(Mono<? extends T>[] monoArr) {
        Objects.requireNonNull(monoArr, "array");
        this.array = monoArr;
        this.iterable = null;
    }

    @SafeVarargs
    @Nullable
    public final MonoFirstWithValue<T> firstValuedAdditionalSources(Mono<? extends T>... monoArr) {
        Objects.requireNonNull(monoArr, "others");
        if (monoArr.length == 0) {
            return this;
        }
        Mono<? extends T>[] monoArr2 = this.array;
        if (monoArr2 == null) {
            return null;
        }
        int length = monoArr2.length;
        int length2 = monoArr.length;
        Mono[] monoArr3 = new Mono[length + length2];
        System.arraycopy(monoArr2, 0, monoArr3, 0, length);
        System.arraycopy(monoArr, 0, monoArr3, length, length2);
        return new MonoFirstWithValue<>(monoArr3);
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
            new FluxFirstWithValue.RaceValuesCoordinator(length).subscribe(bVarArr, length, coreSubscriber);
            return;
        }
        Mono monoFrom = Mono.from(bVarArr[0]);
        if (monoFrom == null) {
            Operators.error(coreSubscriber, Operators.onOperatorError(new NullPointerException("The single source Publisher is null"), coreSubscriber.currentContext()));
        } else {
            monoFrom.subscribe((qc.c) coreSubscriber);
        }
    }

    @SafeVarargs
    public MonoFirstWithValue(Mono<? extends T> mono, Mono<? extends T>... monoArr) {
        Objects.requireNonNull(mono, AMapLocationStaticsEntity.FIRST_LOCATE);
        Objects.requireNonNull(monoArr, "others");
        Mono<? extends T>[] monoArr2 = new Mono[monoArr.length + 1];
        monoArr2[0] = mono;
        System.arraycopy(monoArr, 0, monoArr2, 1, monoArr.length);
        this.array = monoArr2;
        this.iterable = null;
    }

    public MonoFirstWithValue(Iterable<? extends Mono<? extends T>> iterable) {
        this.array = null;
        Objects.requireNonNull(iterable);
        this.iterable = iterable;
    }
}
