package androidx.concurrent.futures;

import c5.a;
import java.util.concurrent.ExecutionException;
import kotlin.KotlinNullPointerException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuationImpl;
import lb.n;
import qb.b;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ListenableFutureKt {
    public static final <T> Object a(final a<T> aVar, b<? super T> bVar) throws Throwable {
        try {
            if (aVar.isDone()) {
                return AbstractResolvableFuture.f(aVar);
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
            aVar.a(new d0.b(aVar, cancellableContinuationImpl), DirectExecutor.f1029a);
            cancellableContinuationImpl.invokeOnCancellation(new l<Throwable, n>() { // from class: androidx.concurrent.futures.ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1
                {
                    super(1);
                }

                @Override // zb.l
                public final n invoke(Throwable th) {
                    aVar.cancel(false);
                    return n.f10413a;
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            return result;
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause != null) {
                throw cause;
            }
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
            g.j(kotlinNullPointerException, g.class.getName());
            throw kotlinNullPointerException;
        }
    }
}
