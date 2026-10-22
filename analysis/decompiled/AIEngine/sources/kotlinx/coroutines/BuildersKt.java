package kotlinx.coroutines;

import kotlin.coroutines.d;
import lb.n;
import qb.b;
import zb.p;

/* loaded from: classes.dex */
public final class BuildersKt {
    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar) {
        return BuildersKt__Builders_commonKt.async(coroutineScope, dVar, coroutineStart, pVar);
    }

    public static final Job launch(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, p<? super CoroutineScope, ? super b<? super n>, ? extends Object> pVar) {
        return BuildersKt__Builders_commonKt.launch(coroutineScope, dVar, coroutineStart, pVar);
    }

    public static final <T> T runBlocking(d dVar, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar) {
        return (T) BuildersKt__BuildersKt.runBlocking(dVar, pVar);
    }

    public static final <T> Object withContext(d dVar, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar, b<? super T> bVar) {
        return BuildersKt__Builders_commonKt.withContext(dVar, pVar, bVar);
    }
}
