package oc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends pb.c implements nc.h {

    /* renamed from: c, reason: collision with root package name */
    public final nc.h f9403c;

    /* renamed from: f, reason: collision with root package name */
    public final nb.g f9404f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9405g;

    /* renamed from: h, reason: collision with root package name */
    public nb.g f9406h;
    public nb.c i;

    public u(nc.h hVar, nb.g gVar) {
        super(s.f9401c, nb.h.f8811c);
        this.f9403c = hVar;
        this.f9404f = gVar;
        this.f9405g = ((Number) gVar.fold(0, new k8.d(9))).intValue();
    }

    public final Object a(nb.c cVar, Object obj) {
        nb.g context = cVar.getContext();
        kc.w.i(context);
        nb.g gVar = this.f9406h;
        if (gVar != context) {
            if (gVar instanceof p) {
                throw new IllegalStateException(hc.i.N("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((p) gVar).f9400f + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            e9.m mVar = new e9.m(9);
            mVar.f3688f = this;
            VarHandle.storeStoreFence();
            if (((Number) context.fold(0, mVar)).intValue() != this.f9405g) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f9404f + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f9406h = context;
        }
        this.i = cVar;
        xb.q qVar = w.f9408a;
        nc.h hVar = this.f9403c;
        hVar.getClass();
        Object objInvoke = qVar.invoke(hVar, obj, this);
        if (!yb.k.a(objInvoke, ob.a.f9351c)) {
            this.i = null;
        }
        return objInvoke;
    }

    @Override // nc.h
    public final Object emit(Object obj, nb.c cVar) {
        try {
            Object objA = a(cVar, obj);
            return objA == ob.a.f9351c ? objA : jb.v.f6774a;
        } catch (Throwable th) {
            this.f9406h = new p(cVar.getContext(), th);
            throw th;
        }
    }

    @Override // pb.a, pb.d
    public final pb.d getCallerFrame() {
        nb.c cVar = this.i;
        if (cVar instanceof pb.d) {
            return (pb.d) cVar;
        }
        return null;
    }

    @Override // pb.c, nb.c
    public final nb.g getContext() {
        nb.g gVar = this.f9406h;
        return gVar == null ? nb.h.f8811c : gVar;
    }

    @Override // pb.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        Throwable thB = jb.i.b(obj);
        if (thB != null) {
            this.f9406h = new p(getContext(), thB);
        }
        nb.c cVar = this.i;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return ob.a.f9351c;
    }
}
