package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.o;
import androidx.exifinterface.media.ExifInterface;
import j9.n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Lp9/d;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "LJ7/b;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SafeCollector<T> extends ContinuationImpl implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final p9.d f5241a;
    public final H7.h b;
    public final int c;
    public H7.h d;
    public H7.c e;

    public SafeCollector(p9.d dVar, H7.h hVar) {
        super(EmptyCoroutineContext.f4908a, q9.h.f5625a);
        this.f5241a = dVar;
        this.b = hVar;
        this.c = ((Number) hVar.fold(0, new com.stepos.core.a(14))).intValue();
    }

    public final Object c(H7.c cVar, Object obj) {
        H7.h context = cVar.getContext();
        kotlinx.coroutines.a.g(context);
        H7.h hVar = this.d;
        if (hVar != context) {
            if (hVar instanceof q9.e) {
                throw new IllegalStateException(n.R("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((q9.e) hVar).b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new G6.e(this, 7))).intValue() != this.c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.d = context;
        }
        this.e = cVar;
        o oVar = i.f5248a;
        p9.d dVar = this.f5241a;
        k.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objInvoke = oVar.invoke(dVar, obj, this);
        if (!k.b(objInvoke, CoroutineSingletons.f4909a)) {
            this.e = null;
        }
        return objInvoke;
    }

    @Override // p9.d
    public final Object emit(Object obj, H7.c cVar) {
        try {
            Object objC = c(cVar, obj);
            return objC == CoroutineSingletons.f4909a ? objC : r.f317a;
        } catch (Throwable th) {
            this.d = new q9.e(cVar.getContext(), th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, J7.b
    public final J7.b getCallerFrame() {
        H7.c cVar = this.e;
        if (cVar instanceof J7.b) {
            return (J7.b) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, H7.c
    public final H7.h getContext() {
        H7.h hVar = this.d;
        return hVar == null ? EmptyCoroutineContext.f4908a : hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable thA = Result.a(obj);
        if (thA != null) {
            this.d = new q9.e(getContext(), thA);
        }
        H7.c cVar = this.e;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return CoroutineSingletons.f4909a;
    }
}
