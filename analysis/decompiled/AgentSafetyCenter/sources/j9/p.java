package j9;

import android.content.Context;
import com.stepos.agentsafetycenter.MainActivity;
import i9.d0;
import java.lang.invoke.VarHandle;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.c1;
import k0.l0;
import m8.k0;
import s8.f2;
import s8.j3;
import s8.r0;
import s8.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6700c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6701f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6702g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6703h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6704j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f6705k;

    public /* synthetic */ p(int i) {
        this.f6700c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f6700c;
        jb.v vVar = jb.v.f6774a;
        int i3 = 0;
        switch (i) {
            case 0:
                kc.t tVar = (kc.t) this.i;
                i9.b0 b0Var = (i9.b0) this.f6704j;
                c1 c1Var = (c1) this.f6702g;
                xb.a aVar = (xb.a) this.f6705k;
                Context context = (Context) this.f6701f;
                c1 c1Var2 = (c1) this.f6703h;
                x.f fVar = (x.f) obj;
                fVar.getClass();
                j jVar = new j(1);
                jVar.f6674f = tVar;
                jVar.f6675g = b0Var;
                jVar.f6676h = c1Var;
                VarHandle.storeStoreFence();
                x.f.a(fVar, new s0.c(13823928, true, jVar));
                j jVar2 = new j(i3);
                jVar2.f6674f = tVar;
                jVar2.f6675g = b0Var;
                jVar2.f6676h = c1Var;
                VarHandle.storeStoreFence();
                x.f.a(fVar, new s0.c(769439649, true, jVar2));
                if (((d0) c1Var.getValue()).f5850a) {
                    k kVar = new k();
                    kVar.f6677c = c1Var;
                    kVar.f6678f = aVar;
                    kVar.f6679g = context;
                    kVar.f6680h = c1Var2;
                    VarHandle.storeStoreFence();
                    x.f.a(fVar, new s0.c(-2137972483, true, kVar));
                }
                x.f.a(fVar, a.f6622a);
                return vVar;
            case 1:
                androidx.lifecycle.x xVar = (androidx.lifecycle.x) this.i;
                Context context2 = (Context) this.f6701f;
                k0 k0Var = (k0) this.f6704j;
                c1 c1Var3 = (c1) this.f6702g;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f6705k;
                c1 c1Var4 = (c1) this.f6703h;
                int i10 = MainActivity.f2491h;
                ((l0) obj).getClass();
                k8.n nVar = new k8.n();
                nVar.f7323c = context2;
                nVar.f7324f = k0Var;
                nVar.f7325g = c1Var3;
                nVar.f7326h = atomicBoolean;
                nVar.i = c1Var4;
                VarHandle.storeStoreFence();
                xVar.getLifecycle().a(nVar);
                b0.t tVar2 = new b0.t(3);
                tVar2.f1786b = xVar;
                tVar2.f1787c = nVar;
                VarHandle.storeStoreFence();
                return tVar2;
            default:
                xb.l lVar = (xb.l) this.f6704j;
                s8.t tVar3 = (s8.t) this.f6702g;
                xb.p pVar = (xb.p) this.f6703h;
                kc.t tVar4 = (kc.t) this.i;
                xb.l lVar2 = (xb.l) this.f6705k;
                xb.l lVar3 = (xb.l) this.f6701f;
                f2 f2Var = (f2) obj;
                f2Var.getClass();
                DateTimeFormatter dateTimeFormatter = x0.f12068a;
                String str = f2Var.f11599a;
                tVar3.getClass();
                List list = tVar3.f11967e;
                j3 j3VarM = x0.m(f2Var, list);
                lVar.invoke(j3VarM != null ? kb.l.O0(kb.l.G0(x0.g(j3VarM, tVar3), str)) : h5.t.P(str));
                j3 j3VarM2 = x0.m(f2Var, list);
                if (j3VarM2 != null) {
                    pVar.invoke(j3VarM2, str);
                } else {
                    kc.w.u(tVar4, null, null, new r0(lVar2, lVar3, null, 0), 3);
                }
                return vVar;
        }
    }
}
