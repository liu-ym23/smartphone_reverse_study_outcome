package Z2;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class O extends f3.h {

    /* renamed from: c, reason: collision with root package name */
    public int f2188c;

    public O(int i4) {
        super(0L, f3.j.f12579g);
        this.f2188c = i4;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract Continuation c();

    public Throwable d(Object obj) {
        r rVar = obj instanceof r ? (r) obj : null;
        if (rVar != null) {
            return rVar.f2238a;
        }
        return null;
    }

    public Object e(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.checkNotNull(th);
        C.a(c().get$context(), new H("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object k();

    @Override // java.lang.Runnable
    public final void run() {
        Object objM22constructorimpl;
        Object objM22constructorimpl2;
        E3.b bVar = this.f12571b;
        try {
            Continuation continuationC = c();
            Intrinsics.checkNotNull(continuationC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            d3.i iVar = (d3.i) continuationC;
            Continuation continuation = iVar.f12456e;
            Object obj = iVar.f12458g;
            CoroutineContext context = continuation.get$context();
            Object objB = d3.B.b(context, obj);
            I0 i0B = objB != d3.B.f12433a ? AbstractC0149x.b(continuation, context, objB) : null;
            try {
                CoroutineContext context2 = continuation.get$context();
                Object objK = k();
                Throwable thD = d(objK);
                o0 o0Var = (thD == null && P.a(this.f2188c)) ? (o0) context2.get(n0.f2230a) : null;
                if (o0Var != null && !o0Var.a()) {
                    CancellationException cancellationExceptionC = ((x0) o0Var).C();
                    b(objK, cancellationExceptionC);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(cancellationExceptionC)));
                } else if (thD != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(thD)));
                } else {
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation.resumeWith(Result.m22constructorimpl(e(objK)));
                }
                Unit unit = Unit.INSTANCE;
                if (i0B == null || i0B.a0()) {
                    d3.B.a(context, objB);
                }
                try {
                    bVar.getClass();
                    objM22constructorimpl2 = Result.m22constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM22constructorimpl2 = Result.m22constructorimpl(ResultKt.createFailure(th));
                }
                f(null, Result.m25exceptionOrNullimpl(objM22constructorimpl2));
            } catch (Throwable th2) {
                if (i0B == null || i0B.a0()) {
                    d3.B.a(context, objB);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                bVar.getClass();
                objM22constructorimpl = Result.m22constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion6 = Result.INSTANCE;
                objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th4));
            }
            f(th3, Result.m25exceptionOrNullimpl(objM22constructorimpl));
        }
    }
}
