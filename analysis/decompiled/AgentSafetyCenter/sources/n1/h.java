package n1;

import b1.q;
import java.util.List;
import o1.m;
import u1.a2;
import u1.z1;
import y.e0;
import y.p0;
import yb.l;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8642c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f8643f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(u uVar, int i) {
        super(1);
        this.f8642c = i;
        this.f8643f = uVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        boolean z10;
        switch (this.f8642c) {
            case 0:
                Object obj2 = (a2) obj;
                if (((w0.l) obj2).f15114c.f15126r) {
                    this.f8643f.f16098c = obj2;
                    z10 = false;
                } else {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            case 1:
                m mVar = (m) obj;
                u uVar = this.f8643f;
                Object obj3 = uVar.f16098c;
                if (obj3 == null && mVar.f9064t) {
                    uVar.f16098c = mVar;
                } else if (obj3 != null) {
                    mVar.getClass();
                }
                return Boolean.TRUE;
            case 2:
                this.f8643f.f16098c = (q) obj;
                return Boolean.TRUE;
            default:
                a2 a2Var = (a2) obj;
                a2Var.getClass();
                e0 e0Var = ((p0) a2Var).f15814s;
                u uVar2 = this.f8643f;
                List listI = (List) uVar2.f16098c;
                if (listI != null) {
                    listI.add(e0Var);
                } else {
                    listI = ac.a.I(e0Var);
                }
                uVar2.f16098c = listI;
                return z1.f13978f;
        }
    }
}
