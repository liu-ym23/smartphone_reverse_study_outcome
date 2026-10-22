package x4;

import c7.r;
import ia.b0;
import ia.f1;
import ia.g1;
import ia.w1;
import java.util.List;
import java.util.concurrent.CancellationException;
import k5.s;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class e extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11165f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f11166g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, g7.d dVar, i iVar) {
        super(2, dVar);
        this.f11165f = i2;
        this.f11166g = iVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f11165f) {
            case 0:
                return new e(0, dVar, this.f11166g);
            case 1:
                return new e(1, dVar, this.f11166g);
            default:
                return new e(2, dVar, this.f11166g);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f11165f) {
            case 0:
                e eVar = (e) create(b0Var, dVar);
                r rVar = r.f1986a;
                eVar.invokeSuspend(rVar);
                return rVar;
            case 1:
                e eVar2 = (e) create(b0Var, dVar);
                r rVar2 = r.f1986a;
                eVar2.invokeSuspend(rVar2);
                return rVar2;
            default:
                e eVar3 = (e) create(b0Var, dVar);
                r rVar3 = r.f1986a;
                eVar3.invokeSuspend(rVar3);
                return rVar3;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        k kVar;
        switch (this.f11165f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                this.f11166g.f11199s = false;
                w1 w1Var = this.f11166g.f11191k;
                if (w1Var != null) {
                    f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
                }
                i iVar = this.f11166g;
                iVar.f11191k = null;
                s.info$default(iVar.f11186f, "BffBridge", "screen off → cancel reconnect + arm screen-off idle timer", null, 4, null);
                this.f11166g.f();
                break;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                this.f11166g.f11199s = true;
                s.info$default(this.f11166g.f11186f, "BffBridge", "screen on → cancel screen-off idle timer", null, 4, null);
                w1 w1Var2 = this.f11166g.f11194n;
                if (w1Var2 != null) {
                    f1.cancel$default((g1) w1Var2, (CancellationException) null, 1, (Object) null);
                }
                i iVar2 = this.f11166g;
                iVar2.f11194n = null;
                List list = iVar2.f11201u;
                q7.k.d(list, "access$getPendingQueue$p(...)");
                if (!list.isEmpty() && ((kVar = this.f11166g.f11190j) == null || !kVar.f11211g.get())) {
                    i iVar3 = this.f11166g;
                    s.info$default(iVar3.f11186f, "BffBridge", a1.a.f(iVar3.f11201u.size(), "screen on with pending=", ", reconnecting"), null, 4, null);
                    this.f11166g.d(true);
                }
                break;
            default:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                w1 w1Var3 = this.f11166g.f11191k;
                if (w1Var3 != null) {
                    f1.cancel$default((g1) w1Var3, (CancellationException) null, 1, (Object) null);
                }
                this.f11166g.f11198r = 0;
                k kVar2 = this.f11166g.f11190j;
                if (kVar2 == null || !kVar2.f11211g.get()) {
                    s.info$default(this.f11166g.f11186f, "BffBridge", "wake: link down, reconnecting now", null, 4, null);
                    this.f11166g.d(true);
                } else {
                    s.info$default(this.f11166g.f11186f, "BffBridge", "wake: link already open, no-op", null, 4, null);
                }
                break;
        }
        return r.f1986a;
    }
}
