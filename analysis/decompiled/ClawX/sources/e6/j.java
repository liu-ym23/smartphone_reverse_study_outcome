package e6;

import a6.i0;
import a6.y;
import b5.a0;
import kotlin.jvm.internal.p;
import p5.q;
import x5.o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends h5.c implements d6.c {

    /* renamed from: a, reason: collision with root package name */
    public final d6.c f2387a;

    /* renamed from: b, reason: collision with root package name */
    public final f5.h f2388b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2389c;
    public f5.h d;

    /* renamed from: e, reason: collision with root package name */
    public f5.c f2390e;

    public j(d6.c cVar, f5.h hVar) {
        super(h.f2385a, f5.i.f2626a);
        this.f2387a = cVar;
        this.f2388b = hVar;
        this.f2389c = ((Number) hVar.z(0, new y(5))).intValue();
    }

    public final Object c(f5.c cVar, Object obj) {
        f5.h context = cVar.getContext();
        i0.h(context);
        f5.h hVar = this.d;
        if (hVar != context) {
            if (hVar instanceof f) {
                throw new IllegalStateException(o.Q0("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((f) hVar).f2384b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.z(0, new com.stepos.stepclaw.c(3, this))).intValue() != this.f2389c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f2388b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.d = context;
        }
        this.f2390e = cVar;
        q qVar = l.f2392a;
        d6.c cVar2 = this.f2387a;
        p.c(cVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objInvoke = qVar.invoke(cVar2, obj, this);
        if (!p.a(objInvoke, g5.a.f2984a)) {
            this.f2390e = null;
        }
        return objInvoke;
    }

    @Override // d6.c
    public final Object emit(Object obj, f5.c cVar) {
        try {
            Object objC = c(cVar, obj);
            return objC == g5.a.f2984a ? objC : a0.f883a;
        } catch (Throwable th) {
            this.d = new f(cVar.getContext(), th);
            throw th;
        }
    }

    @Override // h5.a, h5.d
    public final h5.d getCallerFrame() {
        f5.c cVar = this.f2390e;
        if (cVar instanceof h5.d) {
            return (h5.d) cVar;
        }
        return null;
    }

    @Override // h5.c, f5.c
    public final f5.h getContext() {
        f5.h hVar = this.d;
        return hVar == null ? f5.i.f2626a : hVar;
    }

    @Override // h5.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        Throwable thA = b5.i.a(obj);
        if (thA != null) {
            this.d = new f(getContext(), thA);
        }
        f5.c cVar = this.f2390e;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return g5.a.f2984a;
    }
}
