package reactor.core.publisher;

import java.util.function.Function;

/* loaded from: classes4.dex */
final class MonoBridges {
    public static Mono<Void> when(Z9.c[] cVarArr) {
        return Mono.when(cVarArr);
    }

    public static <R> Mono<R> zip(Function<? super Object[], ? extends R> function, Mono<?>[] monoArr) {
        return Mono.zip(function, monoArr);
    }
}
