package Z2;

import e3.AbstractC0553a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* renamed from: Z2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0114a extends x0 implements Continuation, F {

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineContext f2203c;

    public AbstractC0114a(CoroutineContext coroutineContext, boolean z4) {
        super(z4);
        J((o0) coroutineContext.get(n0.f2230a));
        this.f2203c = coroutineContext.plus(this);
    }

    @Override // Z2.x0
    public final void I(androidx.fragment.app.A a4) {
        C.a(this.f2203c, a4);
    }

    @Override // Z2.x0
    public final String O() {
        return super.O();
    }

    @Override // Z2.x0
    public final void R(Object obj) {
        if (!(obj instanceof r)) {
            Y(obj);
            return;
        }
        r rVar = (r) obj;
        Throwable th = rVar.f2238a;
        rVar.getClass();
        X(th, r.f2237b.get(rVar) != 0);
    }

    public void X(Throwable th, boolean z4) {
    }

    public void Y(Object obj) {
    }

    public final void Z(int i4, AbstractC0114a abstractC0114a, Function2 function2) {
        int iA = t.h.a(i4);
        if (iA == 0) {
            AbstractC0553a.a(function2, abstractC0114a, this);
            return;
        }
        if (iA != 1) {
            if (iA == 2) {
                ContinuationKt.startCoroutine(function2, abstractC0114a, this);
                return;
            }
            if (iA != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Continuation continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(this);
            try {
                CoroutineContext coroutineContext = this.f2203c;
                Object objB = d3.B.b(coroutineContext, null);
                try {
                    Object objInvoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(abstractC0114a, continuationProbeCoroutineCreated);
                    if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        continuationProbeCoroutineCreated.resumeWith(Result.m22constructorimpl(objInvoke));
                    }
                } finally {
                    d3.B.a(coroutineContext, objB);
                }
            } catch (Throwable th) {
                Result.Companion companion = Result.INSTANCE;
                continuationProbeCoroutineCreated.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(th)));
            }
        }
    }

    @Override // Z2.x0, Z2.o0
    public boolean a() {
        return super.a();
    }

    @Override // Z2.F
    public final CoroutineContext e() {
        return this.f2203c;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.f2203c;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(obj);
        if (thM25exceptionOrNullimpl != null) {
            obj = new r(thM25exceptionOrNullimpl, false);
        }
        Object objN = N(obj);
        if (objN == I.f2174g) {
            return;
        }
        t(objN);
    }

    @Override // Z2.x0
    public final String x() {
        return getClass().getSimpleName().concat(" was cancelled");
    }
}
