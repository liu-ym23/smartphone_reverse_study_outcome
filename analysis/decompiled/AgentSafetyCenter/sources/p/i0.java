package p;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 implements zb.d, Set, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public g0 f9578c;

    /* renamed from: f, reason: collision with root package name */
    public g0 f9579f;

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f9579f.a(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        collection.getClass();
        g0 g0Var = this.f9579f;
        int i = g0Var.f9563d;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g0Var.i(it.next());
        }
        return i != g0Var.f9563d;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f9579f.b();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9578c.c(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f9578c.c(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i0.class != obj.getClass()) {
            return false;
        }
        return this.f9578c.equals(((i0) obj).f9578c);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f9578c.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f9578c.g();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        gc.j jVar = new gc.j(2);
        jVar.f4699h = this;
        jVar.f4697f = -1;
        jVar.f4698g = td.h.A(new h0(this, jVar, null));
        VarHandle.storeStoreFence();
        return jVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f9579f.k(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0080, code lost:
    
        r18 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0089, code lost:
    
        if (((r9 & ((~r9) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        r15 = -1;
     */
    @Override // java.util.Set, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean removeAll(java.util.Collection r19) {
        /*
            r18 = this;
            r19.getClass()
            r0 = r18
            p.g0 r0 = r0.f9579f
            r1 = r19
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            int r2 = r0.f9563d
            java.util.Iterator r1 = r1.iterator()
        L11:
            boolean r3 = r1.hasNext()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L9a
            java.lang.Object r3 = r1.next()
            if (r3 == 0) goto L24
            int r6 = r3.hashCode()
            goto L25
        L24:
            r6 = r5
        L25:
            r7 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r6 = r6 * r7
            int r7 = r6 << 16
            r6 = r6 ^ r7
            r7 = r6 & 127(0x7f, float:1.78E-43)
            int r8 = r0.f9562c
            int r6 = r6 >>> 7
            r6 = r6 & r8
        L33:
            long[] r9 = r0.f9560a
            int r10 = r6 >> 3
            r11 = r6 & 7
            int r11 = r11 << 3
            r12 = r9[r10]
            long r12 = r12 >>> r11
            int r10 = r10 + r4
            r9 = r9[r10]
            int r14 = 64 - r11
            long r9 = r9 << r14
            long r14 = (long) r11
            long r14 = -r14
            r11 = 63
            long r14 = r14 >> r11
            long r9 = r9 & r14
            long r9 = r9 | r12
            long r11 = (long) r7
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r11 = r11 * r13
            long r11 = r11 ^ r9
            long r13 = r11 - r13
            long r11 = ~r11
            long r11 = r11 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
        L5d:
            r15 = 0
            int r17 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r17 == 0) goto L80
            int r15 = java.lang.Long.numberOfTrailingZeros(r11)
            int r15 = r15 >> 3
            int r15 = r15 + r6
            r15 = r15 & r8
            r18 = r4
            java.lang.Object[] r4 = r0.f9561b
            r4 = r4[r15]
            boolean r4 = yb.k.a(r4, r3)
            if (r4 == 0) goto L78
            goto L8c
        L78:
            r15 = 1
            long r15 = r11 - r15
            long r11 = r11 & r15
            r4 = r18
            goto L5d
        L80:
            r18 = r4
            long r11 = ~r9
            r4 = 6
            long r11 = r11 << r4
            long r9 = r9 & r11
            long r9 = r9 & r13
            int r4 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r4 == 0) goto L93
            r15 = -1
        L8c:
            if (r15 < 0) goto L11
            r0.l(r15)
            goto L11
        L93:
            int r5 = r5 + 8
            int r6 = r6 + r5
            r6 = r6 & r8
            r4 = r18
            goto L33
        L9a:
            r18 = r4
            int r0 = r0.f9563d
            if (r2 == r0) goto La1
            return r18
        La1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.i0.removeAll(java.util.Collection):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    @Override // java.util.Set, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(java.util.Collection r17) {
        /*
            r16 = this;
            r17.getClass()
            r0 = r16
            p.g0 r0 = r0.f9579f
            java.lang.Object[] r1 = r0.f9561b
            int r2 = r0.f9563d
            long[] r3 = r0.f9560a
            int r4 = r3.length
            int r4 = r4 + (-2)
            r5 = 0
            if (r4 < 0) goto L56
            r6 = r5
        L14:
            r7 = r3[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L51
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = r5
        L2e:
            if (r11 >= r9) goto L4f
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L4b
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r17
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r14 = r1[r12]
            boolean r13 = kb.l.s0(r13, r14)
            if (r13 != 0) goto L4b
            r0.l(r12)
        L4b:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L2e
        L4f:
            if (r9 != r10) goto L56
        L51:
            if (r6 == r4) goto L56
            int r6 = r6 + 1
            goto L14
        L56:
            int r0 = r0.f9563d
            if (r2 == r0) goto L5c
            r0 = 1
            return r0
        L5c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.i0.retainAll(java.util.Collection):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f9578c.f9563d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        return yb.j.b(this, objArr);
    }

    public final String toString() {
        return this.f9578c.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return yb.j.a(this);
    }
}
