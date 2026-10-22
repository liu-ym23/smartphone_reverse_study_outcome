package e8;

import a4.t;
import androidx.lifecycle.l0;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import kc.u;
import kc.w;
import kc.w0;
import kc.x0;
import nb.g;
import pb.i;
import t2.j;
import t2.k;
import t2.n;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3602a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3603b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Serializable f3604c;

    /* JADX WARN: Type inference failed for: r5v2, types: [pb.i, xb.p] */
    @Override // t2.k
    public Object a(j jVar) {
        g gVar = (g) this.f3602a;
        u uVar = (u) this.f3603b;
        ?? r52 = (i) this.f3604c;
        x0 x0Var = (x0) gVar.get(w0.f7498c);
        t tVar = new t(14);
        tVar.f200f = x0Var;
        VarHandle.storeStoreFence();
        n nVar = jVar.f13161c;
        if (nVar != null) {
            nVar.b(tVar, g5.k.f4325c);
        }
        return w.u(w.a(gVar), null, uVar, new l0((p) r52, jVar, (nb.c) null), 1);
    }
}
