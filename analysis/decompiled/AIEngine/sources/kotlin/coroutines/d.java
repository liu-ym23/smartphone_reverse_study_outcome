package kotlin.coroutines;

import kotlin.jvm.internal.g;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface d {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a extends d {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: kotlin.coroutines.d$a$a, reason: collision with other inner class name */
        public static final class C0103a {
            public static <R> R a(a aVar, R r, p<? super R, ? super a, ? extends R> operation) {
                g.f(operation, "operation");
                return operation.invoke(r, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends a> E b(a aVar, b<E> key) {
                g.f(key, "key");
                if (g.b(aVar.getKey(), key)) {
                    return aVar;
                }
                return null;
            }

            public static d c(a aVar, b<?> key) {
                g.f(key, "key");
                return g.b(aVar.getKey(), key) ? EmptyCoroutineContext.f10057a : aVar;
            }

            public static d d(d context, a aVar) {
                g.f(context, "context");
                return context == EmptyCoroutineContext.f10057a ? aVar : (d) context.fold(aVar, new com.stepos.core.common.log.c(4));
            }
        }

        b<?> getKey();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b<E extends a> {
    }

    <R> R fold(R r, p<? super R, ? super a, ? extends R> pVar);

    <E extends a> E get(b<E> bVar);

    d minusKey(b<?> bVar);

    d plus(d dVar);
}
