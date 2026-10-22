package p;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 implements zb.d, Set, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public c0 f9547c;

    /* renamed from: f, reason: collision with root package name */
    public c0 f9548f;

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f9548f.a(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        collection.getClass();
        c0 c0Var = this.f9548f;
        int i = c0Var.f9535g;
        for (Object obj : collection) {
            int iD = c0Var.d(obj);
            c0Var.f9530b[iD] = obj;
            long[] jArr = c0Var.f9531c;
            int i3 = c0Var.f9532d;
            jArr[iD] = (i3 & 2147483647L) | 4611686016279904256L;
            if (i3 != Integer.MAX_VALUE) {
                jArr[i3] = ((iD & 2147483647L) << 31) | (jArr[i3] & (-4611686016279904257L));
            }
            c0Var.f9532d = iD;
            if (c0Var.f9533e == Integer.MAX_VALUE) {
                c0Var.f9533e = iD;
            }
        }
        return i != c0Var.f9535g;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f9548f.b();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9547c.c(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f9547c.c(it.next())) {
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
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        return this.f9547c.equals(((e0) obj).f9547c);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f9547c.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f9547c.f9535g == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        gc.j jVar = new gc.j(1);
        jVar.f4699h = this;
        jVar.f4697f = -1;
        jVar.f4698g = td.h.A(new d0(this, jVar, null));
        VarHandle.storeStoreFence();
        return jVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f9548f.g(obj);
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
            p.c0 r0 = r0.f9548f
            r1 = r19
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            int r2 = r0.f9535g
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
            int r8 = r0.f9534f
            int r6 = r6 >>> 7
            r6 = r6 & r8
        L33:
            long[] r9 = r0.f9529a
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
            java.lang.Object[] r4 = r0.f9530b
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
            r0.h(r15)
            goto L11
        L93:
            int r5 = r5 + 8
            int r6 = r6 + r5
            r6 = r6 & r8
            r4 = r18
            goto L33
        L9a:
            r18 = r4
            int r0 = r0.f9535g
            if (r2 == r0) goto La1
            return r18
        La1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e0.removeAll(java.util.Collection):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        return this.f9548f.i(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f9547c.f9535g;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        return yb.j.b(this, objArr);
    }

    public final String toString() {
        return this.f9547c.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return yb.j.a(this);
    }
}
