package y;

import android.os.CancellationSignal;
import java.lang.invoke.VarHandle;
import u1.z1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15720c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f15721f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, int i) {
        super(1);
        this.f15720c = i;
        this.f15721f = obj;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f15720c;
        Object obj2 = this.f15721f;
        switch (i) {
            case 0:
                b.c cVar = new b.c(7);
                cVar.f1687b = (z) obj2;
                VarHandle.storeStoreFence();
                return cVar;
            case 1:
                z0.d dVar = (z0.d) obj;
                if (!dVar.f15114c.f15126r) {
                    return z1.f13978f;
                }
                z0.d dVar2 = dVar.f16144u;
                if (dVar2 != null) {
                    a0 a0Var = new a0((sa.c) obj2, 1);
                    if (a0Var.invoke(dVar2) == z1.f13977c) {
                        u1.f.y(dVar2, a0Var);
                    }
                }
                dVar.f16144u = null;
                dVar.f16143t = null;
                return z1.f13977c;
            default:
                if (((Throwable) obj) != null) {
                    ((CancellationSignal) obj2).cancel();
                }
                return jb.v.f6774a;
        }
    }
}
