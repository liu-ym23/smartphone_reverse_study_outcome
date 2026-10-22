package kotlinx.coroutines.flow;

import C7.r;
import java.util.Arrays;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.C1718k;
import p9.o;
import p9.p;

/* loaded from: classes4.dex */
public class h extends q9.a implements p9.i, p9.c, q9.g {
    public final int e;
    public final int f;
    public final BufferOverflow g;
    public Object[] h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public long f5228j;
    public int k;
    public int l;

    public h(int i, int i6, BufferOverflow bufferOverflow) {
        this.e = i;
        this.f = i6;
        this.g = bufferOverflow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:15:0x0031, B:32:0x0079, B:34:0x0081, B:38:0x0094, B:41:0x009b, B:42:0x009f, B:43:0x00a0, B:22:0x004b), top: B:52:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [q9.a] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.flow.h] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [p9.d] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [q9.c] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [p9.p] */
    /* JADX WARN: Type inference failed for: r9v8, types: [p9.p] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:16:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(kotlinx.coroutines.flow.h r8, p9.d r9, H7.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.g
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L5e
            r8 = 1
            if (r2 == r8) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            m9.c0 r8 = r0.d
            p9.p r9 = r0.c
            p9.d r2 = r0.b
            kotlinx.coroutines.flow.h r5 = r0.f5219a
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L38
        L34:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L76
        L38:
            r8 = move-exception
            goto Lb4
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            m9.c0 r8 = r0.d
            p9.p r9 = r0.c
            p9.d r2 = r0.b
            kotlinx.coroutines.flow.h r5 = r0.f5219a
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L38
            goto L79
        L4f:
            p9.p r9 = r0.c
            p9.d r8 = r0.b
            kotlinx.coroutines.flow.h r2 = r0.f5219a
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L5b
            r10 = r8
            r8 = r2
            goto L6a
        L5b:
            r8 = move-exception
            r5 = r2
            goto Lb4
        L5e:
            kotlin.b.b(r10)
            q9.c r10 = r8.d()
            p9.p r10 = (p9.p) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L6a:
            H7.h r2 = r0.getContext()     // Catch: java.lang.Throwable -> Lb1
            m9.b0 r5 = m9.b0.f5325a     // Catch: java.lang.Throwable -> Lb1
            H7.f r2 = r2.get(r5)     // Catch: java.lang.Throwable -> Lb1
            m9.c0 r2 = (m9.c0) r2     // Catch: java.lang.Throwable -> Lb1
        L76:
            r5 = r8
            r8 = r2
            r2 = r10
        L79:
            java.lang.Object r10 = r5.s(r9)     // Catch: java.lang.Throwable -> L38
            a5.d r6 = p9.e.b     // Catch: java.lang.Throwable -> L38
            if (r10 != r6) goto L92
            r0.f5219a = r5     // Catch: java.lang.Throwable -> L38
            r0.b = r2     // Catch: java.lang.Throwable -> L38
            r0.c = r9     // Catch: java.lang.Throwable -> L38
            r0.d = r8     // Catch: java.lang.Throwable -> L38
            r0.g = r4     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r5.i(r9, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L79
            goto Lb0
        L92:
            if (r8 == 0) goto La0
            boolean r6 = r8.isActive()     // Catch: java.lang.Throwable -> L38
            if (r6 == 0) goto L9b
            goto La0
        L9b:
            java.util.concurrent.CancellationException r8 = r8.i()     // Catch: java.lang.Throwable -> L38
            throw r8     // Catch: java.lang.Throwable -> L38
        La0:
            r0.f5219a = r5     // Catch: java.lang.Throwable -> L38
            r0.b = r2     // Catch: java.lang.Throwable -> L38
            r0.c = r9     // Catch: java.lang.Throwable -> L38
            r0.d = r8     // Catch: java.lang.Throwable -> L38
            r0.g = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L34
        Lb0:
            return
        Lb1:
            r10 = move-exception
            r5 = r8
            r8 = r10
        Lb4:
            r5.g(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.h.k(kotlinx.coroutines.flow.h, p9.d, H7.c):void");
    }

    @Override // p9.i
    public final boolean a(Object obj) {
        int i;
        boolean z10;
        H7.c[] cVarArrN = q9.b.f5623a;
        synchronized (this) {
            if (q(obj)) {
                cVarArrN = n(cVarArrN);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (H7.c cVar : cVarArrN) {
            if (cVar != null) {
                cVar.resumeWith(r.f317a);
            }
        }
        return z10;
    }

    @Override // p9.i
    public final void b() throws Throwable {
        h hVar;
        synchronized (this) {
            try {
                hVar = this;
                try {
                    hVar.t(o() + this.k, this.f5228j, o() + this.k, o() + this.k + this.l);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                hVar = this;
            }
        }
    }

    @Override // q9.g
    public final p9.c c(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return p9.e.e(this, hVar, i, bufferOverflow);
    }

    @Override // p9.c
    public final Object collect(p9.d dVar, H7.c cVar) {
        k(this, dVar, cVar);
        return CoroutineSingletons.f4909a;
    }

    @Override // q9.a
    public final q9.c e() {
        p pVar = new p();
        pVar.f5565a = -1L;
        return pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    @Override // p9.i, p9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, H7.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r7.a(r8)
            if (r0 == 0) goto L9
            C7.r r7 = C7.r.f317a
            return r7
        L9:
            m9.k r5 = new m9.k
            H7.c r9 = U7.a.I(r9)
            r6 = 1
            r5.<init>(r6, r9)
            r5.y()
            H7.c[] r9 = q9.b.f5623a
            monitor-enter(r7)
            boolean r0 = r7.q(r8)     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L30
            C7.r r8 = C7.r.f317a     // Catch: java.lang.Throwable -> L2b
            r5.resumeWith(r8)     // Catch: java.lang.Throwable -> L2b
            H7.c[] r8 = r7.n(r9)     // Catch: java.lang.Throwable -> L2b
            r9 = 0
            r1 = r7
            goto L59
        L2b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L8e
        L30:
            p9.o r0 = new p9.o     // Catch: java.lang.Throwable -> L8b
            long r1 = r7.o()     // Catch: java.lang.Throwable -> L8b
            int r3 = r7.k     // Catch: java.lang.Throwable -> L86
            int r4 = r7.l     // Catch: java.lang.Throwable -> L86
            int r3 = r3 + r4
            long r3 = (long) r3
            long r2 = r1 + r3
            r1 = r7
            r4 = r8
            r0.<init>(r1, r2, r4, r5)     // Catch: java.lang.Throwable -> L54
            r1.m(r0)     // Catch: java.lang.Throwable -> L54
            int r7 = r1.l     // Catch: java.lang.Throwable -> L54
            int r7 = r7 + r6
            r1.l = r7     // Catch: java.lang.Throwable -> L54
            int r7 = r1.f     // Catch: java.lang.Throwable -> L54
            if (r7 != 0) goto L57
            H7.c[] r9 = r1.n(r9)     // Catch: java.lang.Throwable -> L54
            goto L57
        L54:
            r0 = move-exception
        L55:
            r8 = r0
            goto L8e
        L57:
            r8 = r9
            r9 = r0
        L59:
            monitor-exit(r1)
            if (r9 == 0) goto L65
            m9.h r7 = new m9.h
            r0 = 2
            r7.<init>(r9, r0)
            r5.A(r7)
        L65:
            int r7 = r8.length
            r9 = 0
        L67:
            if (r9 >= r7) goto L75
            r0 = r8[r9]
            if (r0 == 0) goto L72
            C7.r r1 = C7.r.f317a
            r0.resumeWith(r1)
        L72:
            int r9 = r9 + 1
            goto L67
        L75:
            java.lang.Object r7 = r5.x()
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r7 != r8) goto L7e
            goto L80
        L7e:
            C7.r r7 = C7.r.f317a
        L80:
            if (r7 != r8) goto L83
            return r7
        L83:
            C7.r r7 = C7.r.f317a
            return r7
        L86:
            r0 = move-exception
            r1 = r7
            r7 = r0
            r8 = r7
            goto L8e
        L8b:
            r0 = move-exception
            r1 = r7
            goto L55
        L8e:
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.h.emit(java.lang.Object, H7.c):java.lang.Object");
    }

    @Override // q9.a
    public final q9.c[] f() {
        return new p[2];
    }

    public final Object i(p pVar, H7.c cVar) {
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        synchronized (this) {
            try {
                if (r(pVar) < 0) {
                    pVar.b = c1718k;
                } else {
                    c1718k.resumeWith(r.f317a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objX = c1718k.x();
        return objX == CoroutineSingletons.f4909a ? objX : r.f317a;
    }

    public final void j() {
        if (this.f != 0 || this.l > 1) {
            Object[] objArr = this.h;
            k.c(objArr);
            while (this.l > 0) {
                long jO = o();
                int i = this.k;
                int i6 = this.l;
                if (objArr[((int) ((jO + (i + i6)) - 1)) & (objArr.length - 1)] != p9.e.b) {
                    return;
                }
                this.l = i6 - 1;
                p9.e.d(objArr, o() + this.k + this.l, null);
            }
        }
    }

    public final void l() {
        q9.c[] cVarArr;
        Object[] objArr = this.h;
        k.c(objArr);
        p9.e.d(objArr, o(), null);
        this.k--;
        long jO = o() + 1;
        if (this.i < jO) {
            this.i = jO;
        }
        if (this.f5228j < jO) {
            if (this.b != 0 && (cVarArr = this.f5622a) != null) {
                for (q9.c cVar : cVarArr) {
                    if (cVar != null) {
                        p pVar = (p) cVar;
                        long j5 = pVar.f5565a;
                        if (j5 >= 0 && j5 < jO) {
                            pVar.f5565a = jO;
                        }
                    }
                }
            }
            this.f5228j = jO;
        }
    }

    public final void m(Object obj) {
        int i = this.k + this.l;
        Object[] objArrP = this.h;
        if (objArrP == null) {
            objArrP = p(null, 0, 2);
        } else if (i >= objArrP.length) {
            objArrP = p(objArrP, i, objArrP.length * 2);
        }
        p9.e.d(objArrP, o() + i, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final H7.c[] n(H7.c[] cVarArr) {
        q9.c[] cVarArr2;
        p pVar;
        C1718k c1718k;
        int length = cVarArr.length;
        if (this.b != 0 && (cVarArr2 = this.f5622a) != null) {
            int length2 = cVarArr2.length;
            int i = 0;
            cVarArr = cVarArr;
            while (i < length2) {
                q9.c cVar = cVarArr2[i];
                if (cVar != null && (c1718k = (pVar = (p) cVar).b) != null && r(pVar) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                        k.e(CopyOf, "copyOf(...)");
                        cVarArr = CopyOf;
                    }
                    cVarArr[length] = c1718k;
                    pVar.b = null;
                    length++;
                }
                i++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    public final long o() {
        return Math.min(this.f5228j, this.i);
    }

    public final Object[] p(Object[] objArr, int i, int i6) {
        if (i6 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i6];
        this.h = objArr2;
        if (objArr != null) {
            long jO = o();
            for (int i10 = 0; i10 < i; i10++) {
                long j5 = i10 + jO;
                p9.e.d(objArr2, j5, objArr[((int) j5) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(java.lang.Object r13) {
        /*
            r12 = this;
            int r1 = r12.b
            int r2 = r12.e
            r9 = 1
            if (r1 != 0) goto L23
            if (r2 != 0) goto Lb
            goto L7f
        Lb:
            r12.m(r13)
            int r1 = r12.k
            int r1 = r1 + r9
            r12.k = r1
            if (r1 <= r2) goto L18
            r12.l()
        L18:
            long r1 = r12.o()
            int r3 = r12.k
            long r3 = (long) r3
            long r1 = r1 + r3
            r12.f5228j = r1
            return r9
        L23:
            int r1 = r12.k
            int r3 = r12.f
            if (r1 < r3) goto L47
            long r4 = r12.f5228j
            long r6 = r12.i
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L47
            kotlinx.coroutines.channels.BufferOverflow r1 = r12.g
            int r1 = r1.ordinal()
            if (r1 == 0) goto L45
            if (r1 == r9) goto L47
            r0 = 2
            if (r1 != r0) goto L3f
            goto L7f
        L3f:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L45:
            r0 = 0
            return r0
        L47:
            r12.m(r13)
            int r1 = r12.k
            int r1 = r1 + r9
            r12.k = r1
            if (r1 <= r3) goto L54
            r12.l()
        L54:
            long r3 = r12.o()
            int r1 = r12.k
            long r5 = (long) r1
            long r3 = r3 + r5
            long r5 = r12.i
            long r3 = r3 - r5
            int r1 = (int) r3
            if (r1 <= r2) goto L7f
            r1 = 1
            long r1 = r1 + r5
            long r3 = r12.f5228j
            long r5 = r12.o()
            int r7 = r12.k
            long r7 = (long) r7
            long r5 = r5 + r7
            long r7 = r12.o()
            int r10 = r12.k
            long r10 = (long) r10
            long r7 = r7 + r10
            int r10 = r12.l
            long r10 = (long) r10
            long r7 = r7 + r10
            r0 = r12
            r0.t(r1, r3, r5, r7)
        L7f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.h.q(java.lang.Object):boolean");
    }

    public final long r(p pVar) {
        long j5 = pVar.f5565a;
        if (j5 >= o() + this.k && (this.f > 0 || j5 > o() || this.l == 0)) {
            return -1L;
        }
        return j5;
    }

    public final Object s(p pVar) {
        Object obj;
        H7.c[] cVarArrU = q9.b.f5623a;
        synchronized (this) {
            try {
                long jR = r(pVar);
                if (jR < 0) {
                    obj = p9.e.b;
                } else {
                    long j5 = pVar.f5565a;
                    Object[] objArr = this.h;
                    k.c(objArr);
                    Object obj2 = objArr[((int) jR) & (objArr.length - 1)];
                    if (obj2 instanceof o) {
                        obj2 = ((o) obj2).c;
                    }
                    pVar.f5565a = jR + 1;
                    Object obj3 = obj2;
                    cVarArrU = u(j5);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (H7.c cVar : cVarArrU) {
            if (cVar != null) {
                cVar.resumeWith(r.f317a);
            }
        }
        return obj;
    }

    public final void t(long j5, long j6, long j10, long j11) {
        long jMin = Math.min(j6, j5);
        for (long jO = o(); jO < jMin; jO++) {
            Object[] objArr = this.h;
            k.c(objArr);
            p9.e.d(objArr, jO, null);
        }
        this.i = j5;
        this.f5228j = j6;
        this.k = (int) (j10 - jMin);
        this.l = (int) (j11 - j10);
    }

    public final H7.c[] u(long j5) {
        long j6;
        long j10;
        long j11;
        H7.c[] cVarArr;
        H7.c[] cVarArr2;
        q9.c[] cVarArr3;
        a5.d dVar = p9.e.b;
        H7.c[] cVarArr4 = q9.b.f5623a;
        if (j5 <= this.f5228j) {
            long jO = o();
            long j12 = this.k + jO;
            int i = this.f;
            if (i == 0 && this.l > 0) {
                j12++;
            }
            int i6 = 0;
            if (this.b != 0 && (cVarArr3 = this.f5622a) != null) {
                for (q9.c cVar : cVarArr3) {
                    if (cVar != null) {
                        long j13 = ((p) cVar).f5565a;
                        if (j13 >= 0 && j13 < j12) {
                            j12 = j13;
                        }
                    }
                }
            }
            if (j12 > this.f5228j) {
                long jO2 = o() + this.k;
                int iMin = this.b > 0 ? Math.min(this.l, i - ((int) (jO2 - j12))) : this.l;
                long j14 = this.l + jO2;
                if (iMin > 0) {
                    j11 = 1;
                    Object[] objArr = this.h;
                    k.c(objArr);
                    j6 = jO;
                    H7.c[] cVarArr5 = new H7.c[iMin];
                    long j15 = jO2;
                    while (true) {
                        if (jO2 >= j14) {
                            cVarArr2 = cVarArr5;
                            j10 = j12;
                            break;
                        }
                        cVarArr2 = cVarArr5;
                        Object obj = objArr[(objArr.length - 1) & ((int) jO2)];
                        if (obj != dVar) {
                            k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                            o oVar = (o) obj;
                            int i10 = i6 + 1;
                            j10 = j12;
                            cVarArr2[i6] = oVar.d;
                            p9.e.d(objArr, jO2, dVar);
                            p9.e.d(objArr, j15, oVar.c);
                            j15++;
                            if (i10 >= iMin) {
                                break;
                            }
                            i6 = i10;
                        } else {
                            j10 = j12;
                        }
                        jO2++;
                        cVarArr5 = cVarArr2;
                        j12 = j10;
                    }
                    jO2 = j15;
                    cVarArr = cVarArr2;
                } else {
                    j6 = jO;
                    j10 = j12;
                    j11 = 1;
                    cVarArr = cVarArr4;
                }
                int i11 = (int) (jO2 - j6);
                long j16 = this.b == 0 ? jO2 : j10;
                long jMax = Math.max(this.i, jO2 - Math.min(this.e, i11));
                if (i == 0 && jMax < j14) {
                    Object[] objArr2 = this.h;
                    k.c(objArr2);
                    if (k.b(objArr2[((int) jMax) & (objArr2.length - 1)], dVar)) {
                        jO2 += j11;
                        jMax += j11;
                    }
                }
                t(jMax, j16, jO2, j14);
                j();
                return cVarArr.length == 0 ? cVarArr : n(cVarArr);
            }
        }
        return cVarArr4;
    }
}
