package t0;

import ad.o;
import k0.a2;
import k0.y0;
import p5.m;
import u0.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements a2 {

    /* renamed from: c, reason: collision with root package name */
    public k f13106c;

    /* renamed from: f, reason: collision with root package name */
    public g f13107f;

    /* renamed from: g, reason: collision with root package name */
    public String f13108g;

    /* renamed from: h, reason: collision with root package name */
    public Object f13109h;
    public Object[] i;

    /* renamed from: j, reason: collision with root package name */
    public f f13110j;

    /* renamed from: k, reason: collision with root package name */
    public ab.e f13111k;

    @Override // k0.a2
    public final void a() {
        f fVar = this.f13110j;
        if (fVar != null) {
            ((m) fVar).V();
        }
    }

    @Override // k0.a2
    public final void b() {
        f fVar = this.f13110j;
        if (fVar != null) {
            ((m) fVar).V();
        }
    }

    @Override // k0.a2
    public final void c() throws Exception {
        d();
    }

    public final void d() throws Exception {
        String strE;
        ab.e eVar = this.f13111k;
        g gVar = this.f13107f;
        if (this.f13110j != null) {
            o.l("entry(", this.f13110j, ") is not null");
            return;
        }
        if (gVar != null) {
            Object objInvoke = eVar.invoke();
            if (objInvoke == null || gVar.a(objInvoke)) {
                this.f13110j = gVar.d(this.f13108g, eVar);
                return;
            }
            if (objInvoke instanceof n) {
                n nVar = (n) objInvoke;
                if (nVar.b() == y0.f7137g || nVar.b() == y0.f7139j || nVar.b() == y0.f7138h) {
                    strE = "MutableState containing " + nVar.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    strE = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                strE = a.e(objInvoke);
            }
            throw new IllegalArgumentException(strE);
        }
    }
}
