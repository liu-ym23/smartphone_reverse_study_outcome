package kotlinx.coroutines.flow;

import C7.r;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.C1718k;
import p9.j;
import p9.u;

/* loaded from: classes4.dex */
public final class i extends q9.a implements j, p9.c, q9.g {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int e;

    public i(Object obj) {
        this._state$volatile = obj;
    }

    @Override // p9.i
    public final boolean a(Object obj) {
        i(obj);
        return true;
    }

    @Override // p9.i
    public final void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // q9.g
    public final p9.c c(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return (((i < 0 || i >= 2) && i != -2) || bufferOverflow != BufferOverflow.b) ? p9.e.e(this, hVar, i, bufferOverflow) : this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r12.equals(r14) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x007b, code lost:
    
        if (r14 != r1) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:39:0x0091, B:41:0x0097], limit reached: 63 */
    /* JADX WARN: Path cross not found for [B:41:0x0097, B:39:0x0091], limit reached: 63 */
    /* JADX WARN: Path cross not found for [B:41:0x0097, B:49:0x00b2], limit reached: 63 */
    /* JADX WARN: Path cross not found for [B:57:0x00ef, B:58:0x00f0], limit reached: 63 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007b, B:33:0x0083, B:36:0x008a, B:37:0x008e, B:39:0x0091, B:49:0x00b2, B:52:0x00c2, B:54:0x00e4, B:55:0x00e7, B:41:0x0097, B:45:0x009e, B:21:0x004d), top: B:62:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007b, B:33:0x0083, B:36:0x008a, B:37:0x008e, B:39:0x0091, B:49:0x00b2, B:52:0x00c2, B:54:0x00e4, B:55:0x00e7, B:41:0x0097, B:45:0x009e, B:21:0x004d), top: B:62:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:14:0x0034, B:31:0x007b, B:33:0x0083, B:36:0x008a, B:37:0x008e, B:39:0x0091, B:49:0x00b2, B:52:0x00c2, B:54:0x00e4, B:55:0x00e7, B:41:0x0097, B:45:0x009e, B:21:0x004d), top: B:62:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [p9.u] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [q9.c] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [p9.u] */
    /* JADX WARN: Type inference failed for: r2v7, types: [p9.u] */
    /* JADX WARN: Type inference failed for: r2v8, types: [p9.u] */
    /* JADX WARN: Type inference failed for: r8v1, types: [q9.a] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [kotlinx.coroutines.flow.i] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlinx.coroutines.flow.i] */
    /* JADX WARN: Type inference failed for: r8v7, types: [kotlinx.coroutines.flow.i] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00c1 -> B:31:0x007b). Please report as a decompilation issue!!! */
    @Override // p9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(p9.d r13, H7.c r14) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.i.collect(p9.d, H7.c):java.lang.Object");
    }

    @Override // q9.a
    public final q9.c e() {
        return new u();
    }

    @Override // p9.i, p9.d
    public final Object emit(Object obj, H7.c cVar) {
        i(obj);
        return r.f317a;
    }

    @Override // q9.a
    public final q9.c[] f() {
        return new u[2];
    }

    @Override // p9.t
    public final Object getValue() {
        a5.d dVar = q9.b.b;
        Object obj = f.get(this);
        if (obj == dVar) {
            return null;
        }
        return obj;
    }

    public final void i(Object obj) {
        if (obj == null) {
            obj = q9.b.b;
        }
        j(null, obj);
    }

    public final boolean j(Object obj, Object obj2) {
        int i;
        q9.c[] cVarArr;
        a5.d dVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !k.b(obj3, obj)) {
                return false;
            }
            if (k.b(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i6 = this.e;
            if ((i6 & 1) != 0) {
                this.e = i6 + 2;
                return true;
            }
            int i10 = i6 + 1;
            this.e = i10;
            q9.c[] cVarArr2 = this.f5622a;
            while (true) {
                u[] uVarArr = (u[]) cVarArr2;
                if (uVarArr != null) {
                    for (u uVar : uVarArr) {
                        if (uVar != null) {
                            AtomicReference atomicReference = uVar.f5568a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (dVar = p9.e.d)) {
                                    a5.d dVar2 = p9.e.c;
                                    if (obj4 != dVar2) {
                                        if (atomicReference.compareAndSet(obj4, dVar2)) {
                                            ((C1718k) obj4).resumeWith(r.f317a);
                                            break;
                                        }
                                    } else {
                                        if (atomicReference.compareAndSet(obj4, dVar)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.e;
                    if (i == i10) {
                        this.e = i10 + 1;
                        return true;
                    }
                    cVarArr = this.f5622a;
                }
                cVarArr2 = cVarArr;
                i10 = i;
            }
        }
    }
}
