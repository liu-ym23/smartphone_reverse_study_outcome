package c6;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k extends f6.q {

    /* renamed from: e, reason: collision with root package name */
    public final c f1141e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f1142f;

    public k(long j4, k kVar, c cVar, int i8) {
        super(j4, kVar, i8);
        this.f1141e = cVar;
        this.f1142f = new AtomicReferenceArray(e.f1119b * 2);
    }

    @Override // f6.q
    public final int g() {
        return e.f1119b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        kotlin.jvm.internal.p.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // f6.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r5, f5.h r6) {
        /*
            r4 = this;
            int r6 = c6.e.f1119b
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
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f1142f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof a6.g2
            c6.c r2 = r4.f1141e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof c6.s
            if (r1 == 0) goto L21
            goto L62
        L21:
            androidx.emoji2.text.r r1 = c6.e.f1126j
            if (r6 == r1) goto L59
            androidx.emoji2.text.r r1 = c6.e.f1127k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            androidx.emoji2.text.r r1 = c6.e.f1123g
            if (r6 == r1) goto L11
            androidx.emoji2.text.r r1 = c6.e.f1122f
            if (r6 != r1) goto L33
            goto L11
        L33:
            androidx.emoji2.text.r r4 = c6.e.f1125i
            if (r6 == r4) goto L7c
            androidx.emoji2.text.r r4 = c6.e.d
            if (r6 != r4) goto L3c
            goto L7c
        L3c:
            androidx.emoji2.text.r r4 = c6.e.f1128l
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
            kotlin.jvm.internal.p.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            androidx.emoji2.text.r r1 = c6.e.f1126j
            goto L69
        L67:
            androidx.emoji2.text.r r1 = c6.e.f1127k
        L69:
            boolean r6 = r4.k(r6, r5, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.p.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.k.h(int, f5.h):void");
    }

    public final boolean k(Object obj, int i8, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i9 = (i8 * 2) + 1;
        do {
            atomicReferenceArray = this.f1142f;
            if (atomicReferenceArray.compareAndSet(i9, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i9) == obj);
        return false;
    }

    public final Object l(int i8) {
        return this.f1142f.get((i8 * 2) + 1);
    }

    public final void m(int i8, boolean z) {
        if (z) {
            c cVar = this.f1141e;
            kotlin.jvm.internal.p.b(cVar);
            cVar.F((this.f2659c * e.f1119b) + i8);
        }
        i();
    }

    public final void n(int i8, Object obj) {
        this.f1142f.set(i8 * 2, obj);
    }

    public final void o(int i8, Object obj) {
        this.f1142f.set((i8 * 2) + 1, obj);
    }
}
