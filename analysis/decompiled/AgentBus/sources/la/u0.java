package la;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class u0 extends ma.b implements d0, j, ma.o {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6013k = AtomicReferenceFieldUpdater.newUpdater(u0.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: j, reason: collision with root package name */
    public int f6014j;

    public u0(Object obj) {
        this._state$volatile = obj;
    }

    @Override // ma.o
    public final j E(g7.l lVar, int i2, ka.a aVar) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || aVar != ka.a.f5662g) ? k0.m(this, lVar, i2, aVar) : this;
    }

    @Override // la.c0
    public final void I() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // la.c0
    public final boolean M(Object obj) {
        g(null, obj);
        return true;
    }

    @Override // ma.b
    public final ma.d b() {
        return new v0();
    }

    @Override // ma.b
    public final ma.d[] c() {
        return new v0[2];
    }

    @Override // la.k
    public final Object emit(Object obj, g7.d dVar) {
        f(obj);
        return c7.r.f1986a;
    }

    public final void f(Object obj) {
        if (obj == null) {
            obj = ma.c.f6481b;
        }
        g(null, obj);
    }

    public final boolean g(Object obj, Object obj2) {
        int i2;
        ma.d[] dVarArr;
        f8.x xVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6013k;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !q7.k.a(obj3, obj)) {
                return false;
            }
            if (q7.k.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i10 = this.f6014j;
            if ((i10 & 1) != 0) {
                this.f6014j = i10 + 2;
                return true;
            }
            int i11 = i10 + 1;
            this.f6014j = i11;
            ma.d[] dVarArr2 = this.f6476f;
            while (true) {
                v0[] v0VarArr = (v0[]) dVarArr2;
                if (v0VarArr != null) {
                    for (v0 v0Var : v0VarArr) {
                        if (v0Var != null) {
                            AtomicReference atomicReference = v0Var.f6017a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (xVar = k0.f5946c)) {
                                    f8.x xVar2 = k0.f5945b;
                                    if (obj4 != xVar2) {
                                        while (!atomicReference.compareAndSet(obj4, xVar2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((ia.m) obj4).resumeWith(c7.r.f1986a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, xVar)) {
                                        if (atomicReference.get() != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i2 = this.f6014j;
                    if (i2 == i11) {
                        this.f6014j = i11 + 1;
                        return true;
                    }
                    dVarArr = this.f6476f;
                }
                dVarArr2 = dVarArr;
                i11 = i2;
            }
        }
    }

    @Override // la.s0
    public final Object getValue() {
        f8.x xVar = ma.c.f6481b;
        Object obj = f6013k.get(this);
        if (obj == xVar) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r13.equals(r15) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x007b, code lost:
    
        if (r15 != r1) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:39:0x0091, B:41:0x0097], limit reached: 70 */
    /* JADX WARN: Path cross not found for [B:41:0x0097, B:39:0x0091], limit reached: 70 */
    /* JADX WARN: Path cross not found for [B:41:0x0097, B:49:0x00b2], limit reached: 70 */
    /* JADX WARN: Path cross not found for [B:61:0x00f6, B:62:0x00f7], limit reached: 70 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007b, B:33:0x0083, B:36:0x008a, B:37:0x008e, B:39:0x0091, B:49:0x00b2, B:52:0x00c2, B:53:0x00de, B:59:0x00ee, B:56:0x00e5, B:58:0x00eb, B:41:0x0097, B:45:0x009e, B:21:0x004d), top: B:66:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007b, B:33:0x0083, B:36:0x008a, B:37:0x008e, B:39:0x0091, B:49:0x00b2, B:52:0x00c2, B:53:0x00de, B:59:0x00ee, B:56:0x00e5, B:58:0x00eb, B:41:0x0097, B:45:0x009e, B:21:0x004d), top: B:66:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007b, B:33:0x0083, B:36:0x008a, B:37:0x008e, B:39:0x0091, B:49:0x00b2, B:52:0x00c2, B:53:0x00de, B:59:0x00ee, B:56:0x00e5, B:58:0x00eb, B:41:0x0097, B:45:0x009e, B:21:0x004d), top: B:66:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [la.v0] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [ma.d] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [la.v0] */
    /* JADX WARN: Type inference failed for: r2v7, types: [la.v0] */
    /* JADX WARN: Type inference failed for: r2v8, types: [la.v0] */
    /* JADX WARN: Type inference failed for: r8v1, types: [ma.b] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [la.u0] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, la.u0] */
    /* JADX WARN: Type inference failed for: r8v7, types: [la.u0] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00c1 -> B:31:0x007b). Please report as a decompilation issue!!! */
    @Override // la.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(la.k r14, g7.d r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.u0.x(la.k, g7.d):java.lang.Object");
    }
}
