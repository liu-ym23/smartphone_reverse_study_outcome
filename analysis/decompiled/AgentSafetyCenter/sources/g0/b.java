package g0;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.LinkedHashMap;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends q implements n {
    public m C;
    public o D;

    @Override // g0.q
    public final void B0(v.m mVar, long j10, float f5) {
        m mVarA = this.C;
        if (mVarA == null) {
            mVarA = u.a(u.b((View) u1.f.h(this, AndroidCompositionLocals_androidKt.f986f)));
            this.C = mVarA;
        }
        o oVarA = mVarA.a(this);
        int iQ = ac.a.Q(f5);
        long jE = this.f4181v.e();
        this.f4182w.invoke();
        oVarA.b(mVar, this.f4179t, j10, iQ, jE, 0.1f, new ad.l(this, 9));
        this.D = oVarA;
        u1.f.l(this);
    }

    @Override // g0.q
    public final void C0(i0 i0Var) {
        d1.o oVarY = i0Var.f13838c.f3859f.y();
        o oVar = this.D;
        if (oVar != null) {
            long j10 = this.f4185z;
            long jE = this.f4181v.e();
            this.f4182w.invoke();
            oVar.e(j10, jE, 0.1f);
            oVar.draw(d1.b.a(oVarY));
        }
    }

    @Override // g0.n
    public final void D() {
        this.D = null;
        u1.f.l(this);
    }

    @Override // g0.q
    public final void E0(v.m mVar) {
        o oVar = this.D;
        if (oVar != null) {
            oVar.d();
        }
    }

    @Override // w0.l
    public final void u0() {
        m mVar = this.C;
        if (mVar != null) {
            D();
            p5.l lVar = mVar.f4170h;
            o oVar = (o) ((LinkedHashMap) lVar.f9738c).get(this);
            if (oVar != null) {
                oVar.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) lVar.f9738c;
                o oVar2 = (o) linkedHashMap.get(this);
                if (oVar2 != null) {
                }
                linkedHashMap.remove(this);
                mVar.f4169g.add(oVar);
            }
        }
    }
}
