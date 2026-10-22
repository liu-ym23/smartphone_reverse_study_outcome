package kotlin.coroutines;

import kotlin.coroutines.d;
import kotlin.coroutines.d.a;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b<B extends d.a, E extends B> implements d.b<E> {
    private final l<d.a, E> safeCast;
    private final d.b<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.d$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, zb.l<? super kotlin.coroutines.d$a, ? extends E extends B>, zb.l<kotlin.coroutines.d$a, E extends B>] */
    public b(d.b<B> baseKey, l<? super d.a, ? extends E> safeCast) {
        g.f(baseKey, "baseKey");
        g.f(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof b ? (d.b<B>) ((b) baseKey).topmostKey : baseKey;
    }

    public final boolean isSubKey$kotlin_stdlib(d.b<?> key) {
        g.f(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/d$a;)TE; */
    public final d.a tryCast$kotlin_stdlib(d.a element) {
        g.f(element, "element");
        return (d.a) this.safeCast.invoke(element);
    }
}
