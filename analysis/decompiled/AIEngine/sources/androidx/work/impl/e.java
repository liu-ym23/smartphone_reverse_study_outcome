package androidx.work.impl;

import androidx.work.DirectExecutor;
import h2.j;
import i2.l;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuationImpl;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2965a;

    static {
        String strF = j.f("WorkerWrapper");
        g.e(strF, "tagWithPrefix(\"WorkerWrapper\")");
        f2965a = strF;
    }

    public static final Object a(final c5.a aVar, final androidx.work.c cVar, SuspendLambda suspendLambda) {
        V v3;
        try {
            if (!aVar.isDone()) {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(suspendLambda), 1);
                cancellableContinuationImpl.initCancellability();
                aVar.a(new l(aVar, cancellableContinuationImpl), DirectExecutor.f2772a);
                cancellableContinuationImpl.invokeOnCancellation(new zb.l<Throwable, n>() { // from class: androidx.work.impl.WorkerWrapperKt$awaitWithin$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // zb.l
                    public final n invoke(Throwable th) {
                        Throwable th2 = th;
                        if (th2 instanceof WorkerStoppedException) {
                            cVar.stop(((WorkerStoppedException) th2).f2844a);
                        }
                        aVar.cancel(false);
                        return n.f10413a;
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                return result;
            }
            boolean z = false;
            while (true) {
                try {
                    v3 = aVar.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return v3;
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            g.c(cause);
            throw cause;
        }
    }
}
