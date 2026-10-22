package nc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends oc.b implements g, oc.r, r0, g0, h {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8929j = AtomicReferenceFieldUpdater.newUpdater(t0.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int i;

    public t0(Object obj) {
        this._state$volatile = obj;
    }

    @Override // oc.r
    public final g a(nb.g gVar, int i, mc.a aVar) {
        return (((i < 0 || i >= 2) && i != -2) || aVar != mc.a.f8551f) ? k0.l(this, gVar, i, aVar) : this;
    }

    @Override // oc.b
    public final oc.d c() {
        u0 u0Var = new u0();
        u0Var.f8934a = new AtomicReference(null);
        VarHandle.storeStoreFence();
        return u0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
    
        if (r12.equals(r14) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x007a, code lost:
    
        if (r14 != r1) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:39:0x0090, B:41:0x0096], limit reached: 63 */
    /* JADX WARN: Path cross not found for [B:41:0x0096, B:39:0x0090], limit reached: 63 */
    /* JADX WARN: Path cross not found for [B:41:0x0096, B:49:0x00b1], limit reached: 63 */
    /* JADX WARN: Path cross not found for [B:57:0x00ee, B:58:0x00ef], limit reached: 63 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007a, B:33:0x0082, B:36:0x0089, B:37:0x008d, B:39:0x0090, B:49:0x00b1, B:52:0x00c1, B:54:0x00e3, B:55:0x00e6, B:41:0x0096, B:45:0x009d, B:21:0x004c), top: B:62:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007a, B:33:0x0082, B:36:0x0089, B:37:0x008d, B:39:0x0090, B:49:0x00b1, B:52:0x00c1, B:54:0x00e3, B:55:0x00e6, B:41:0x0096, B:45:0x009d, B:21:0x004c), top: B:62:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007a, B:33:0x0082, B:36:0x0089, B:37:0x008d, B:39:0x0090, B:49:0x00b1, B:52:0x00c1, B:54:0x00e3, B:55:0x00e6, B:41:0x0096, B:45:0x009d, B:21:0x004c), top: B:62:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [nc.u0] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [oc.d] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [nc.u0] */
    /* JADX WARN: Type inference failed for: r2v7, types: [nc.u0] */
    /* JADX WARN: Type inference failed for: r2v8, types: [nc.u0] */
    /* JADX WARN: Type inference failed for: r8v1, types: [oc.b] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [nc.t0] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, nc.t0] */
    /* JADX WARN: Type inference failed for: r8v7, types: [nc.t0] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00c0 -> B:31:0x007a). Please report as a decompilation issue!!! */
    @Override // nc.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(nc.h r13, nb.c r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.t0.collect(nc.h, nb.c):java.lang.Object");
    }

    @Override // oc.b
    public final oc.d[] d() {
        return new u0[2];
    }

    @Override // nc.h
    public final Object emit(Object obj, nb.c cVar) {
        if (obj == null) {
            obj = oc.c.f9367b;
        }
        g(null, obj);
        return jb.v.f6774a;
    }

    public final boolean g(Object obj, Object obj2) {
        int i;
        oc.d[] dVarArr;
        pc.t tVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8929j;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !yb.k.a(obj3, obj)) {
                return false;
            }
            if (yb.k.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i3 = this.i;
            if ((i3 & 1) != 0) {
                this.i = i3 + 2;
                return true;
            }
            int i10 = i3 + 1;
            this.i = i10;
            oc.d[] dVarArr2 = this.f9362c;
            while (true) {
                u0[] u0VarArr = (u0[]) dVarArr2;
                if (u0VarArr != null) {
                    for (u0 u0Var : u0VarArr) {
                        if (u0Var != null) {
                            AtomicReference atomicReference = u0Var.f8934a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (tVar = k0.f8873c)) {
                                    pc.t tVar2 = k0.f8872b;
                                    if (obj4 != tVar2) {
                                        if (atomicReference.compareAndSet(obj4, tVar2)) {
                                            ((kc.g) obj4).resumeWith(jb.v.f6774a);
                                            break;
                                        }
                                    } else {
                                        if (atomicReference.compareAndSet(obj4, tVar)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.i;
                    if (i == i10) {
                        this.i = i10 + 1;
                        return true;
                    }
                    dVarArr = this.f9362c;
                }
                dVarArr2 = dVarArr;
                i10 = i;
            }
        }
    }

    @Override // nc.r0
    public final Object getValue() {
        pc.t tVar = oc.c.f9367b;
        Object obj = f8929j.get(this);
        if (obj == tVar) {
            return null;
        }
        return obj;
    }
}
