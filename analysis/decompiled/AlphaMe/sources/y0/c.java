package y0;

import a3.r;
import a3.t;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import z0.AbstractC0998f;
import z0.AbstractC0999g;

/* loaded from: classes.dex */
public final class c extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f16167a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16168b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f16169c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, Continuation continuation) {
        super(2, continuation);
        this.f16169c = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        c cVar = new c(this.f16169c, continuation);
        cVar.f16168b = obj;
        return cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((t) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f16167a;
        int i5 = 1;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            t tVar = (t) this.f16168b;
            d dVar = this.f16169c;
            b listener = new b(dVar, tVar);
            AbstractC0998f abstractC0998f = dVar.f16170a;
            abstractC0998f.getClass();
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (abstractC0998f.f16399c) {
                try {
                    if (abstractC0998f.f16400d.add(listener)) {
                        if (abstractC0998f.f16400d.size() == 1) {
                            abstractC0998f.f16401e = abstractC0998f.a();
                            s0.t.d().a(AbstractC0999g.f16402a, abstractC0998f.getClass().getSimpleName() + ": initial state = " + abstractC0998f.f16401e);
                            abstractC0998f.c();
                        }
                        listener.a(abstractC0998f.f16401e);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            U.b bVar = new U.b(i5, this.f16169c, listener);
            this.f16167a = 1;
            if (r.a(tVar, bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
