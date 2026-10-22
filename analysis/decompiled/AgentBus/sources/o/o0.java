package o;

import b0.f2;
import ia.g1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class o0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public ra.b f7098f;

    /* renamed from: g, reason: collision with root package name */
    public Object f7099g;

    /* renamed from: h, reason: collision with root package name */
    public p.l f7100h;

    /* renamed from: i, reason: collision with root package name */
    public p0 f7101i;

    /* renamed from: j, reason: collision with root package name */
    public int f7102j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f7103k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f7104l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ p0 f7105m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f2 f7106n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ p.l f7107o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(int i2, p0 p0Var, f2 f2Var, p.l lVar, g7.d dVar) {
        super(2, dVar);
        this.f7104l = i2;
        this.f7105m = p0Var;
        this.f7106n = f2Var;
        this.f7107o = lVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        o0 o0Var = new o0(this.f7104l, this.f7105m, this.f7106n, this.f7107o, dVar);
        o0Var.f7103k = obj;
        return o0Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((o0) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7, types: [p7.n] */
    /* JADX WARN: Type inference failed for: r6v5, types: [ra.b] */
    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        p0 p0Var;
        ra.d dVar;
        f2 f2Var;
        p.l lVar;
        p0 p0Var2;
        Throwable th;
        n0 n0Var2;
        ra.b bVar;
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        h7.a aVar = h7.a.f4212f;
        ?? r12 = this.f7102j;
        try {
            try {
                if (r12 == 0) {
                    w7.e0.N(obj);
                    g7.j jVarO = ((ia.b0) this.f7103k).k().o(ia.z.f5027g);
                    q7.k.b(jVarO);
                    n0Var = new n0(this.f7104l, (g1) jVarO);
                    p0Var = this.f7105m;
                    AtomicReference atomicReference3 = p0Var.f7110a;
                    while (true) {
                        n0 n0Var3 = (n0) atomicReference3.get();
                        if (n0Var3 != null && n.f.a(n0Var.f7095a, n0Var3.f7095a) < 0) {
                            throw new CancellationException("Current mutation had a higher priority");
                        }
                        while (!atomicReference3.compareAndSet(n0Var3, n0Var)) {
                            if (atomicReference3.get() != n0Var3) {
                                break;
                            }
                        }
                        if (n0Var3 != null) {
                            n0Var3.f7096b.d(new ma.l("Mutation interrupted", 2));
                        }
                        dVar = p0Var.f7111b;
                        this.f7103k = n0Var;
                        this.f7098f = dVar;
                        f2Var = this.f7106n;
                        this.f7099g = f2Var;
                        p.l lVar2 = this.f7107o;
                        this.f7100h = lVar2;
                        this.f7101i = p0Var;
                        this.f7102j = 1;
                        if (dVar.c(this, null) != aVar) {
                            lVar = lVar2;
                        }
                    }
                    return aVar;
                }
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p0Var2 = (p0) this.f7099g;
                    bVar = this.f7098f;
                    n0Var2 = (n0) this.f7103k;
                    try {
                        w7.e0.N(obj);
                        atomicReference2 = p0Var2.f7110a;
                        while (!atomicReference2.compareAndSet(n0Var2, null) && atomicReference2.get() == n0Var2) {
                        }
                        ((ra.d) bVar).e(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        atomicReference = p0Var2.f7110a;
                        while (!atomicReference.compareAndSet(n0Var2, null)) {
                        }
                        throw th;
                    }
                }
                p0 p0Var3 = this.f7101i;
                lVar = this.f7100h;
                ?? r52 = (p7.n) this.f7099g;
                ?? r62 = this.f7098f;
                n0 n0Var4 = (n0) this.f7103k;
                w7.e0.N(obj);
                f2Var = r52;
                dVar = r62;
                p0Var = p0Var3;
                n0Var = n0Var4;
                this.f7103k = n0Var;
                this.f7098f = dVar;
                this.f7099g = p0Var;
                this.f7100h = null;
                this.f7101i = null;
                this.f7102j = 2;
                Object objInvoke = f2Var.invoke(lVar, this);
                if (objInvoke != aVar) {
                    p0Var2 = p0Var;
                    obj = objInvoke;
                    n0Var2 = n0Var;
                    bVar = dVar;
                    atomicReference2 = p0Var2.f7110a;
                    while (!atomicReference2.compareAndSet(n0Var2, null)) {
                    }
                    ((ra.d) bVar).e(null);
                    return obj;
                }
                return aVar;
            } catch (Throwable th3) {
                p0Var2 = p0Var;
                th = th3;
                n0Var2 = n0Var;
                atomicReference = p0Var2.f7110a;
                while (!atomicReference.compareAndSet(n0Var2, null) && atomicReference.get() == n0Var2) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            ((ra.d) r12).e(null);
            throw th4;
        }
    }
}
