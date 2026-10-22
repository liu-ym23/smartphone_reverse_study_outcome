package a3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a3.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0169n extends d3.v {

    /* renamed from: e, reason: collision with root package name */
    public final C0160e f2316e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f2317f;

    public C0169n(long j4, C0169n c0169n, C0160e c0160e, int i4) {
        super(j4, c0169n, i4);
        this.f2316e = c0160e;
        this.f2317f = new AtomicReferenceArray(AbstractC0162g.f2291b * 2);
    }

    @Override // d3.v
    public final int f() {
        return AbstractC0162g.f2291b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
    
        m(r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        if (r1 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r6 = r5.f2288b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0065, code lost:
    
        if (r6 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
    
        r6 = com.stepos.statsrpk.c.i(r6, r0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        if (r6 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006d, code lost:
    
        Z2.C.a(r8, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
    
        return;
     */
    @Override // d3.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r7, kotlin.coroutines.CoroutineContext r8) {
        /*
            r6 = this;
            int r0 = a3.AbstractC0162g.f2291b
            if (r7 < r0) goto L6
            r1 = 1
            goto L7
        L6:
            r1 = 0
        L7:
            if (r1 == 0) goto La
            int r7 = r7 - r0
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r6.f2317f
            int r2 = r7 * 2
            java.lang.Object r0 = r0.get(r2)
        L12:
            java.lang.Object r2 = r6.k(r7)
            boolean r3 = r2 instanceof Z2.K0
            r4 = 0
            a3.e r5 = r6.f2316e
            if (r3 != 0) goto L71
            boolean r3 = r2 instanceof a3.x
            if (r3 == 0) goto L22
            goto L71
        L22:
            X.r r3 = a3.AbstractC0162g.f2299j
            if (r2 == r3) goto L5b
            X.r r3 = a3.AbstractC0162g.f2300k
            if (r2 != r3) goto L2b
            goto L5b
        L2b:
            X.r r3 = a3.AbstractC0162g.f2296g
            if (r2 == r3) goto L12
            X.r r3 = a3.AbstractC0162g.f2295f
            if (r2 != r3) goto L34
            goto L12
        L34:
            X.r r6 = a3.AbstractC0162g.f2298i
            if (r2 == r6) goto L5a
            X.r r6 = a3.AbstractC0162g.f2293d
            if (r2 != r6) goto L3d
            goto L5a
        L3d:
            X.r r6 = a3.AbstractC0162g.f2301l
            if (r2 != r6) goto L42
            return
        L42:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "unexpected state: "
            r7.<init>(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L5a:
            return
        L5b:
            r6.m(r7, r4)
            if (r1 == 0) goto L70
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlin.jvm.functions.Function1 r6 = r5.f2288b
            if (r6 == 0) goto L70
            androidx.fragment.app.A r6 = com.stepos.statsrpk.c.i(r6, r0, r4)
            if (r6 == 0) goto L70
            Z2.C.a(r8, r6)
        L70:
            return
        L71:
            if (r1 == 0) goto L76
            X.r r3 = a3.AbstractC0162g.f2299j
            goto L78
        L76:
            X.r r3 = a3.AbstractC0162g.f2300k
        L78:
            boolean r2 = r6.j(r7, r2, r3)
            if (r2 == 0) goto L12
            r6.m(r7, r4)
            r2 = r1 ^ 1
            r6.l(r7, r2)
            if (r1 == 0) goto L98
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlin.jvm.functions.Function1 r6 = r5.f2288b
            if (r6 == 0) goto L98
            androidx.fragment.app.A r6 = com.stepos.statsrpk.c.i(r6, r0, r4)
            if (r6 == 0) goto L98
            Z2.C.a(r8, r6)
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0169n.g(int, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean j(int i4, Object obj, Object obj2) {
        return this.f2317f.compareAndSet((i4 * 2) + 1, obj, obj2);
    }

    public final Object k(int i4) {
        return this.f2317f.get((i4 * 2) + 1);
    }

    public final void l(int i4, boolean z4) {
        if (z4) {
            C0160e c0160e = this.f2316e;
            Intrinsics.checkNotNull(c0160e);
            c0160e.K((this.f12481c * AbstractC0162g.f2291b) + i4);
        }
        h();
    }

    public final void m(int i4, Object obj) {
        this.f2317f.lazySet(i4 * 2, obj);
    }

    public final void n(int i4, X.r rVar) {
        this.f2317f.set((i4 * 2) + 1, rVar);
    }
}
