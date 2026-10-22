package kotlinx.coroutines.android;

import a0.a;
import android.os.Handler;
import android.os.Looper;
import com.stepos.ability.sdk.client.b;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.android.HandlerContext;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HandlerContext extends HandlerDispatcher implements Delay {
    private final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this.immediate = z ? this : new HandlerContext(handler, str, true);
    }

    private final void cancelOnRejection(d dVar, Runnable runnable) {
        JobKt.cancel(dVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.getIO().dispatch(dVar, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeOnTimeout$lambda$3(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n scheduleResumeAfterDelay$lambda$2(HandlerContext handlerContext, Runnable runnable, Throwable th) {
        handlerContext.handler.removeCallbacks(runnable);
        return n.f10413a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(d dVar, Runnable runnable) {
        if (this.handler.post(runnable)) {
            return;
        }
        cancelOnRejection(dVar, runnable);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HandlerContext)) {
            return false;
        }
        HandlerContext handlerContext = (HandlerContext) obj;
        return handlerContext.handler == this.handler && handlerContext.invokeImmediately == this.invokeImmediately;
    }

    public int hashCode() {
        return (this.invokeImmediately ? 1231 : 1237) ^ System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long j10, final Runnable runnable, d dVar) {
        Handler handler = this.handler;
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (handler.postDelayed(runnable, j10)) {
            return new DisposableHandle() { // from class: kc.a
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.invokeOnTimeout$lambda$3(this.f9960a, runnable);
                }
            };
        }
        cancelOnRejection(dVar, runnable);
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(d dVar) {
        return (this.invokeImmediately && g.b(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j10, final CancellableContinuation<? super n> cancellableContinuation) {
        Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                cancellableContinuation.resumeUndispatched(this, n.f10413a);
            }
        };
        Handler handler = this.handler;
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (handler.postDelayed(runnable, j10)) {
            cancellableContinuation.invokeOnCancellation(new b(5, this, runnable));
        } else {
            cancelOnRejection(cancellableContinuation.getContext(), runnable);
        }
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl == null) {
            stringInternalImpl = this.name;
            if (stringInternalImpl == null) {
                stringInternalImpl = this.handler.toString();
            }
            if (this.invokeImmediately) {
                return a.j(stringInternalImpl, ".immediate");
            }
        }
        return stringInternalImpl;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i10, e eVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
