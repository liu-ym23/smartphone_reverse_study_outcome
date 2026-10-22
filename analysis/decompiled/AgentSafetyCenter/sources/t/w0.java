package t;

import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public sc.a f13077c;

    /* renamed from: f, reason: collision with root package name */
    public Object f13078f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13079g;

    /* renamed from: h, reason: collision with root package name */
    public x0 f13080h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f13081j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u0 f13082k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x0 f13083l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ androidx.lifecycle.l0 f13084m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f13085n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(u0 u0Var, x0 x0Var, androidx.lifecycle.l0 l0Var, Object obj, nb.c cVar) {
        super(2, cVar);
        this.f13082k = u0Var;
        this.f13083l = x0Var;
        this.f13084m = l0Var;
        this.f13085n = obj;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        w0 w0Var = new w0(this.f13082k, this.f13083l, this.f13084m, this.f13085n, cVar);
        w0Var.f13081j = obj;
        return w0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((w0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, sc.a] */
    /* JADX WARN: Type inference failed for: r5v7, types: [xb.p] */
    /* JADX WARN: Type inference failed for: r6v5, types: [sc.a] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        v0 v0Var;
        x0 x0Var;
        v0 v0Var2;
        sc.c cVar;
        androidx.lifecycle.l0 l0Var;
        Object obj2;
        x0 x0Var2;
        Throwable th;
        v0 v0Var3;
        sc.a aVar;
        ob.a aVar2 = ob.a.f9351c;
        ?? r12 = this.i;
        try {
            try {
                if (r12 == 0) {
                    id.c.I(obj);
                    nb.e eVar = ((kc.t) this.f13081j).n().get(kc.w0.f7498c);
                    eVar.getClass();
                    v0Var = new v0();
                    v0Var.f13071a = this.f13082k;
                    v0Var.f13072b = (kc.x0) eVar;
                    VarHandle.storeStoreFence();
                    x0Var = this.f13083l;
                    AtomicReference atomicReference = x0Var.f13087a;
                    do {
                        v0Var2 = (v0) atomicReference.get();
                        if (v0Var2 != null && v0Var.f13071a.compareTo(v0Var2.f13071a) < 0) {
                            throw new CancellationException("Current mutation had a higher priority");
                        }
                    } while (!atomicReference.compareAndSet(v0Var2, v0Var));
                    if (v0Var2 != null) {
                        v0Var2.f13072b.e(new s.i0("Mutation interrupted", 1));
                    }
                    cVar = x0Var.f13088b;
                    this.f13081j = v0Var;
                    this.f13077c = cVar;
                    l0Var = this.f13084m;
                    this.f13078f = l0Var;
                    Object obj3 = this.f13085n;
                    this.f13079g = obj3;
                    this.f13080h = x0Var;
                    this.i = 1;
                    if (cVar.d(this) != aVar2) {
                        obj2 = obj3;
                    }
                    return aVar2;
                }
                if (r12 != 1) {
                    if (r12 != 2) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    x0Var2 = (x0) this.f13078f;
                    aVar = this.f13077c;
                    v0Var3 = (v0) this.f13081j;
                    try {
                        id.c.I(obj);
                        x0Var2.f13087a.compareAndSet(v0Var3, null);
                        aVar.e(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        x0Var2.f13087a.compareAndSet(v0Var3, null);
                        throw th;
                    }
                }
                x0 x0Var3 = this.f13080h;
                obj2 = this.f13079g;
                ?? r52 = (xb.p) this.f13078f;
                ?? r62 = this.f13077c;
                v0 v0Var4 = (v0) this.f13081j;
                id.c.I(obj);
                l0Var = r52;
                cVar = r62;
                x0Var = x0Var3;
                v0Var = v0Var4;
                this.f13081j = v0Var;
                this.f13077c = cVar;
                this.f13078f = x0Var;
                this.f13079g = null;
                this.f13080h = null;
                this.i = 2;
                Object objInvoke = l0Var.invoke(obj2, this);
                if (objInvoke != aVar2) {
                    x0Var2 = x0Var;
                    obj = objInvoke;
                    v0Var3 = v0Var;
                    aVar = cVar;
                    x0Var2.f13087a.compareAndSet(v0Var3, null);
                    aVar.e(null);
                    return obj;
                }
                return aVar2;
            } catch (Throwable th3) {
                x0Var2 = x0Var;
                th = th3;
                v0Var3 = v0Var;
                x0Var2.f13087a.compareAndSet(v0Var3, null);
                throw th;
            }
        } catch (Throwable th4) {
            r12.e(null);
            throw th4;
        }
    }
}
