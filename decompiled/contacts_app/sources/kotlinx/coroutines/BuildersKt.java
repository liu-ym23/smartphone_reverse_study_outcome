package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class BuildersKt {
    public static final <T> Deferred<T> async(CoroutineScope r0, CoroutineContext r1, CoroutineStart r2, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r3) {
        return BuildersKt__Builders_commonKt.async(r0, r1, r2, r3);
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope r0, CoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        return BuildersKt__Builders_commonKt.async$default(r0, r1, r2, r3, r4, r5);
    }

    public static final <T> Object invoke(CoroutineDispatcher r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r1, Continuation<? super T> r2) {
        return BuildersKt__Builders_commonKt.invoke(r0, r1, r2);
    }

    public static final Job launch(CoroutineScope r0, CoroutineContext r1, CoroutineStart r2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return BuildersKt__Builders_commonKt.launch(r0, r1, r2, r3);
    }

    public static /* synthetic */ Job launch$default(CoroutineScope r0, CoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        return BuildersKt__Builders_commonKt.launch$default(r0, r1, r2, r3, r4, r5);
    }

    public static final <T> T runBlocking(CoroutineContext r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r1) throws InterruptedException {
        return (T) BuildersKt__BuildersKt.runBlocking(r0, r1);
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext r0, Function2 r1, int r2, Object r3) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking$default(r0, r1, r2, r3);
    }

    public static final <T> Object withContext(CoroutineContext r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r1, Continuation<? super T> r2) {
        return BuildersKt__Builders_commonKt.withContext(r0, r1, r2);
    }
}
