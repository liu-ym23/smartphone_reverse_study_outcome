package i2;

import java.util.concurrent.ExecutionException;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final c5.a<T> f9471a;

    /* renamed from: b, reason: collision with root package name */
    public final CancellableContinuationImpl f9472b;

    public l(c5.a aVar, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f9471a = aVar;
        this.f9472b = cancellableContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        T t8;
        c5.a<T> aVar = this.f9471a;
        boolean zIsCancelled = aVar.isCancelled();
        CancellableContinuationImpl cancellableContinuationImpl = this.f9472b;
        if (zIsCancelled) {
            CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuationImpl, null, 1, null);
            return;
        }
        boolean z = false;
        while (true) {
            try {
                try {
                    t8 = aVar.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                kotlin.jvm.internal.g.c(cause);
                cancellableContinuationImpl.resumeWith(kotlin.c.a(cause));
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        cancellableContinuationImpl.resumeWith(t8);
    }
}
