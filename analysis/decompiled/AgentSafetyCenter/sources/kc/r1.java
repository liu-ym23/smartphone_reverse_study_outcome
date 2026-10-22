package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r1 extends pc.q {
    public ThreadLocal i;
    private volatile boolean threadLocalIsSet;

    public final boolean d0() {
        boolean z10 = this.threadLocalIsSet && this.i.get() == null;
        this.i.remove();
        return !z10;
    }

    public final void e0(nb.g gVar, Object obj) {
        this.threadLocalIsSet = true;
        this.i.set(new jb.g(gVar, obj));
    }

    @Override // pc.q, kc.e1
    public final void q(Object obj) {
        if (this.threadLocalIsSet) {
            jb.g gVar = (jb.g) this.i.get();
            if (gVar != null) {
                pc.a.g((nb.g) gVar.f6759c, gVar.f6760f);
            }
            this.i.remove();
        }
        Object objW = w.w(obj);
        nb.c cVar = this.f9980h;
        nb.g context = cVar.getContext();
        Object objL = pc.a.l(context, null);
        r1 r1VarD = objL != pc.a.f9946d ? w.D(cVar, context, objL) : null;
        try {
            this.f9980h.resumeWith(objW);
            if (r1VarD == null || r1VarD.d0()) {
                pc.a.g(context, objL);
            }
        } catch (Throwable th) {
            if (r1VarD == null || r1VarD.d0()) {
                pc.a.g(context, objL);
            }
            throw th;
        }
    }
}
