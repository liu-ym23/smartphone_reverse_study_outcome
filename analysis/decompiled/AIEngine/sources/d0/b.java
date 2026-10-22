package d0;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.d;
import java.util.concurrent.ExecutionException;
import kotlin.KotlinNullPointerException;
import kotlin.c;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mb.y;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8255a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8256b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f8257c;

    public b(c5.a aVar, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f8256b = aVar;
        this.f8257c = cancellableContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar;
        switch (this.f8255a) {
            case 0:
                CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.f8257c;
                c5.a aVar = (c5.a) this.f8256b;
                if (aVar.isCancelled()) {
                    CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuationImpl, null, 1, null);
                    return;
                }
                try {
                    cancellableContinuationImpl.resumeWith(AbstractResolvableFuture.f(aVar));
                    return;
                } catch (ExecutionException e10) {
                    Throwable cause = e10.getCause();
                    if (cause != null) {
                        cancellableContinuationImpl.resumeWith(c.a(cause));
                        return;
                    } else {
                        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
                        g.j(kotlinNullPointerException, g.class.getName());
                        throw kotlinNullPointerException;
                    }
                }
            default:
                androidx.work.impl.a aVar2 = ((p2.a) this.f8257c).f11395a.f2882f;
                String str = (String) this.f8256b;
                synchronized (aVar2.f2873k) {
                    try {
                        d dVarC = aVar2.c(str);
                        pVar = dVarC != null ? dVarC.f2941a : null;
                    } finally {
                    }
                }
                if (pVar == null || !pVar.b()) {
                    return;
                }
                synchronized (((p2.a) this.f8257c).f11397c) {
                    ((p2.a) this.f8257c).h.put(y.t(pVar), pVar);
                    p2.a aVar3 = (p2.a) this.f8257c;
                    ((p2.a) this.f8257c).f11400j.put(y.t(pVar), WorkConstraintsTrackerKt.a(aVar3.f11401k, pVar, aVar3.f11396b.b(), (p2.a) this.f8257c));
                }
                return;
        }
    }

    public b(p2.a aVar, String str) {
        this.f8257c = aVar;
        this.f8256b = str;
    }
}
