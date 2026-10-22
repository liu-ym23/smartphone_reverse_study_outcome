package ka;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class o extends na.s {

    /* renamed from: e, reason: collision with root package name */
    public final g f5713e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f5714f;

    public o(long j2, o oVar, g gVar, int i2) {
        super(j2, oVar, i2);
        this.f5713e = gVar;
        this.f5714f = new AtomicReferenceArray(i.f5689b * 2);
    }

    @Override // na.s
    public final int g() {
        return i.f5689b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        q7.k.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // na.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r5, g7.l r6) {
        /*
            r4 = this;
            int r6 = ka.i.f5689b
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
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f5714f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof ia.g2
            ka.g r2 = r4.f5713e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof ka.a0
            if (r1 == 0) goto L21
            goto L62
        L21:
            f8.x r1 = ka.i.f5697j
            if (r6 == r1) goto L59
            f8.x r1 = ka.i.f5698k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            f8.x r1 = ka.i.f5694g
            if (r6 == r1) goto L11
            f8.x r1 = ka.i.f5693f
            if (r6 != r1) goto L33
            goto L11
        L33:
            f8.x r4 = ka.i.f5696i
            if (r6 == r4) goto L7c
            f8.x r4 = ka.i.f5691d
            if (r6 != r4) goto L3c
            goto L7c
        L3c:
            f8.x r4 = ka.i.f5699l
            if (r6 != r4) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "unexpected state: "
            r5.<init>(r0)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L59:
            r4.n(r5, r3)
            if (r0 == 0) goto L7c
            q7.k.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            f8.x r1 = ka.i.f5697j
            goto L69
        L67:
            f8.x r1 = ka.i.f5698k
        L69:
            boolean r6 = r4.k(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L7c
            q7.k.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.o.h(int, g7.l):void");
    }

    public final boolean k(int i2, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i10 = (i2 * 2) + 1;
        do {
            atomicReferenceArray = this.f5714f;
            if (atomicReferenceArray.compareAndSet(i10, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i10) == obj);
        return false;
    }

    public final Object l(int i2) {
        return this.f5714f.get((i2 * 2) + 1);
    }

    public final void m(int i2, boolean z4) {
        if (z4) {
            g gVar = this.f5713e;
            q7.k.b(gVar);
            gVar.K((this.f6927c * i.f5689b) + i2);
        }
        i();
    }

    public final void n(int i2, Object obj) {
        this.f5714f.set(i2 * 2, obj);
    }

    public final void o(int i2, Object obj) {
        this.f5714f.set((i2 * 2) + 1, obj);
    }
}
