package g0;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.l0;
import java.lang.invoke.VarHandle;
import k0.c1;
import k0.z;
import t.n0;
import t.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4136a;

    /* renamed from: b, reason: collision with root package name */
    public float f4137b;

    /* renamed from: c, reason: collision with root package name */
    public c1 f4138c;

    @Override // t.n0
    public final o0 b(v.k kVar, k0.s sVar) {
        long jA;
        sVar.X(988743187);
        r rVar = (r) sVar.j(t.f4187a);
        c1 c1Var = this.f4138c;
        if (((d1.p) c1Var.getValue()).f3026a != d1.p.f3024g) {
            sVar.X(-303571590);
            sVar.q(false);
            jA = ((d1.p) c1Var.getValue()).f3026a;
        } else {
            sVar.X(-303521246);
            jA = rVar.a(sVar);
            sVar.q(false);
        }
        c1 c1VarZ = z.z(d1.p.a(jA), sVar);
        c1 c1VarZ2 = z.z(rVar.b(sVar), sVar);
        boolean z10 = this.f4136a;
        float f5 = this.f4137b;
        sVar.X(331259447);
        ViewGroup viewGroupB = u.b((View) sVar.j(AndroidCompositionLocals_androidKt.f986f));
        boolean zF = sVar.f(this) | sVar.f(kVar) | sVar.f(viewGroupB);
        Object objM = sVar.M();
        Object obj = k0.m.f6974a;
        Object obj2 = objM;
        if (zF || objM == obj) {
            a aVar = new a();
            aVar.f4123c = z10;
            aVar.f4124f = new ed.e(z10, new b0.j(c1VarZ2, 1));
            aVar.f4125g = z10;
            aVar.f4126h = f5;
            aVar.i = c1VarZ;
            aVar.f4127j = c1VarZ2;
            aVar.f4128k = viewGroupB;
            aVar.f4130m = z.v(null);
            aVar.f4131n = z.v(Boolean.TRUE);
            aVar.f4132o = 0L;
            aVar.f4133p = -1;
            aVar.f4134q = new ad.l(aVar, 8);
            VarHandle.storeStoreFence();
            sVar.i0(aVar);
            obj2 = aVar;
        }
        a aVar2 = (a) obj2;
        sVar.q(false);
        boolean zF2 = sVar.f(kVar) | sVar.h(aVar2);
        Object objM2 = sVar.M();
        if (zF2 || objM2 == obj) {
            objM2 = new l0(kVar, aVar2, (nb.c) null, 4);
            sVar.i0(objM2);
        }
        z.g(aVar2, kVar, (xb.p) objM2, sVar);
        sVar.q(false);
        return aVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f4136a == eVar.f4136a && o2.f.b(this.f4137b, eVar.f4137b) && yb.k.a(this.f4138c, eVar.f4138c);
    }

    public final int hashCode() {
        return this.f4138c.hashCode() + k0.a.g(Boolean.hashCode(this.f4136a) * 31, this.f4137b, 31);
    }
}
