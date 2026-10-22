package reactor.core.publisher;

import java.util.function.Function;

/* loaded from: classes5.dex */
final class MonoBridges {
    public static Mono<Void> when(qc.b<?>[] bVarArr) {
        return Mono.when(bVarArr);
    }

    public static <R> Mono<R> zip(Function<? super Object[], ? extends R> function, Mono<?>[] monoArr) {
        return Mono.zip(function, monoArr);
    }
}
