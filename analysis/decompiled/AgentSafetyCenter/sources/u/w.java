package u;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13599c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t0 f13600f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(t0 t0Var, int i) {
        super(2);
        this.f13599c = i;
        this.f13600f = t0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f13599c;
        t0 t0Var = this.f13600f;
        switch (i) {
            case 0:
                o1.s sVar = (o1.s) obj;
                long j10 = ((c1.b) obj2).f2165a;
                if (((Boolean) t0Var.f13587v.invoke(sVar)).booleanValue()) {
                    if (!t0Var.A) {
                        if (t0Var.f13590y == null) {
                            t0Var.f13590y = h5.t.c(Reader.READ_DONE, 6, null);
                        }
                        t0Var.A = true;
                        kc.w.u(t0Var.p0(), null, null, new a0(t0Var, null), 3);
                    }
                    long j11 = sVar.f9073c;
                    long jG = c1.b.g(j11, id.k.d(c1.b.e(j10) * Math.signum(c1.b.e(j11)), c1.b.f(j10) * Math.signum(c1.b.f(j11))));
                    mc.e eVar = t0Var.f13590y;
                    if (eVar != null) {
                        o oVar = new o();
                        oVar.f13535a = jG;
                        VarHandle.storeStoreFence();
                        mc.l.a(eVar.h(oVar));
                    }
                }
                return jb.v.f6774a;
            default:
                kc.w.u(t0Var.p0(), null, null, new s0(t0Var, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), null), 3);
                return Boolean.TRUE;
        }
    }
}
