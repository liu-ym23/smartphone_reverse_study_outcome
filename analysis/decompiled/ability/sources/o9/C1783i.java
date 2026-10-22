package o9;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: o9.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1783i extends s9.p {
    public final kotlinx.coroutines.channels.a e;
    public final /* synthetic */ AtomicReferenceArray f;

    public C1783i(long j5, C1783i c1783i, kotlinx.coroutines.channels.a aVar, int i) {
        super(j5, c1783i, i);
        this.e = aVar;
        this.f = new AtomicReferenceArray(AbstractC1777c.b * 2);
    }

    @Override // s9.p
    public final int g() {
        return AbstractC1777c.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0050, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0052, code lost:
    
        kotlin.jvm.internal.k.c(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // s9.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r5, H7.h r6) {
        /*
            r4 = this;
            int r6 = o9.AbstractC1777c.b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof m9.y0
            kotlinx.coroutines.channels.a r2 = r4.e
            r3 = 0
            if (r1 != 0) goto L56
            boolean r1 = r6 instanceof o9.p
            if (r1 == 0) goto L21
            goto L56
        L21:
            a5.d r1 = o9.AbstractC1777c.f5450j
            if (r6 == r1) goto L4d
            a5.d r1 = o9.AbstractC1777c.k
            if (r6 != r1) goto L2a
            goto L4d
        L2a:
            a5.d r1 = o9.AbstractC1777c.g
            if (r6 == r1) goto L11
            a5.d r1 = o9.AbstractC1777c.f
            if (r6 != r1) goto L33
            goto L11
        L33:
            a5.d r4 = o9.AbstractC1777c.i
            if (r6 == r4) goto L70
            a5.d r4 = o9.AbstractC1777c.d
            if (r6 != r4) goto L3c
            goto L70
        L3c:
            a5.d r4 = o9.AbstractC1777c.l
            if (r6 != r4) goto L41
            goto L70
        L41:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "unexpected state: "
            java.lang.String r5 = androidx.compose.foundation.b.r(r6, r5)
            r4.<init>(r5)
            throw r4
        L4d:
            r4.n(r5, r3)
            if (r0 == 0) goto L70
            kotlin.jvm.internal.k.c(r2)
            return
        L56:
            if (r0 == 0) goto L5b
            a5.d r1 = o9.AbstractC1777c.f5450j
            goto L5d
        L5b:
            a5.d r1 = o9.AbstractC1777c.k
        L5d:
            boolean r6 = r4.k(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L70
            kotlin.jvm.internal.k.c(r2)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.C1783i.h(int, H7.h):void");
    }

    public final boolean k(int i, Object obj, Object obj2) {
        return this.f.compareAndSet((i * 2) + 1, obj, obj2);
    }

    public final Object l(int i) {
        return this.f.get((i * 2) + 1);
    }

    public final void m(int i, boolean z10) {
        if (z10) {
            kotlinx.coroutines.channels.a aVar = this.e;
            kotlin.jvm.internal.k.c(aVar);
            aVar.L((this.c * AbstractC1777c.b) + i);
        }
        i();
    }

    public final void n(int i, Object obj) {
        this.f.set(i * 2, obj);
    }

    public final void o(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }
}
