package mc;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pc.r {

    /* renamed from: e, reason: collision with root package name */
    public final e f8597e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f8598f;

    public m(long j10, m mVar, e eVar, int i) {
        super(j10, mVar, i);
        this.f8597e = eVar;
        this.f8598f = new AtomicReferenceArray(g.f8574b * 2);
    }

    @Override // pc.r
    public final int f() {
        return g.f8574b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0047, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004c, code lost:
    
        r2.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // pc.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, nb.g r6) {
        /*
            r4 = this;
            int r6 = mc.g.f8574b
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
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f8598f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof kc.t1
            mc.e r2 = r4.f8597e
            r3 = 0
            if (r1 != 0) goto L50
            boolean r1 = r6 instanceof mc.u
            if (r1 == 0) goto L21
            goto L50
        L21:
            pc.t r1 = mc.g.f8581j
            if (r6 == r1) goto L47
            pc.t r1 = mc.g.f8582k
            if (r6 != r1) goto L2a
            goto L47
        L2a:
            pc.t r1 = mc.g.f8579g
            if (r6 == r1) goto L11
            pc.t r1 = mc.g.f8578f
            if (r6 != r1) goto L33
            goto L11
        L33:
            pc.t r4 = mc.g.i
            if (r6 == r4) goto L6a
            pc.t r4 = mc.g.f8576d
            if (r6 != r4) goto L3c
            goto L6a
        L3c:
            pc.t r4 = mc.g.f8583l
            if (r6 != r4) goto L41
            goto L6a
        L41:
            java.lang.String r4 = "unexpected state: "
            g5.f.n(r6, r4)
            return
        L47:
            r4.m(r5, r3)
            if (r0 == 0) goto L6a
            r2.getClass()
            return
        L50:
            if (r0 == 0) goto L55
            pc.t r1 = mc.g.f8581j
            goto L57
        L55:
            pc.t r1 = mc.g.f8582k
        L57:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L6a
            r2.getClass()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.m.g(int, nb.g):void");
    }

    public final boolean j(int i, Object obj, Object obj2) {
        return this.f8598f.compareAndSet((i * 2) + 1, obj, obj2);
    }

    public final Object k(int i) {
        return this.f8598f.get((i * 2) + 1);
    }

    public final void l(int i, boolean z10) {
        if (z10) {
            e eVar = this.f8597e;
            eVar.getClass();
            eVar.J((this.f9982c * g.f8574b) + i);
        }
        h();
    }

    public final void m(int i, Object obj) {
        this.f8598f.set(i * 2, obj);
    }

    public final void n(int i, Object obj) {
        this.f8598f.set((i * 2) + 1, obj);
    }
}
