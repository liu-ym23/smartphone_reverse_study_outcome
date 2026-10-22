package k;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class d0 implements r7.e, Set, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final b0 f5475f;

    /* renamed from: g, reason: collision with root package name */
    public final b0 f5476g;

    public d0(b0 b0Var) {
        this.f5475f = b0Var;
        this.f5476g = b0Var;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f5476g.a(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        q7.k.e(collection, "elements");
        b0 b0Var = this.f5476g;
        int i2 = b0Var.f5456d;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b0Var.i(it.next());
        }
        return i2 != b0Var.f5456d;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f5476g.b();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5475f.c(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        q7.k.e(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f5475f.c(it.next())) {
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
        if (obj == null || d0.class != obj.getClass()) {
            return false;
        }
        return q7.k.a(this.f5475f, ((d0) obj).f5475f);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f5475f.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f5475f.g();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new fa.h(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f5476g.k(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
    
        r18 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
    
        if (((r9 & ((~r9) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
    
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
            r0 = r19
            java.lang.String r1 = "elements"
            q7.k.e(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = r18
            k.b0 r1 = r1.f5476g
            r1.getClass()
            int r2 = r1.f5456d
            java.util.Iterator r0 = r0.iterator()
        L16:
            boolean r3 = r0.hasNext()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L9f
            java.lang.Object r3 = r0.next()
            if (r3 == 0) goto L29
            int r6 = r3.hashCode()
            goto L2a
        L29:
            r6 = r5
        L2a:
            r7 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r6 = r6 * r7
            int r7 = r6 << 16
            r6 = r6 ^ r7
            r7 = r6 & 127(0x7f, float:1.78E-43)
            int r8 = r1.f5455c
            int r6 = r6 >>> 7
            r6 = r6 & r8
        L38:
            long[] r9 = r1.f5453a
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
        L62:
            r15 = 0
            int r17 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r17 == 0) goto L85
            int r15 = java.lang.Long.numberOfTrailingZeros(r11)
            int r15 = r15 >> 3
            int r15 = r15 + r6
            r15 = r15 & r8
            r18 = r4
            java.lang.Object[] r4 = r1.f5454b
            r4 = r4[r15]
            boolean r4 = q7.k.a(r4, r3)
            if (r4 == 0) goto L7d
            goto L91
        L7d:
            r15 = 1
            long r15 = r11 - r15
            long r11 = r11 & r15
            r4 = r18
            goto L62
        L85:
            r18 = r4
            long r11 = ~r9
            r4 = 6
            long r11 = r11 << r4
            long r9 = r9 & r11
            long r9 = r9 & r13
            int r4 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r4 == 0) goto L98
            r15 = -1
        L91:
            if (r15 < 0) goto L16
            r1.l(r15)
            goto L16
        L98:
            int r5 = r5 + 8
            int r6 = r6 + r5
            r6 = r6 & r8
            r4 = r18
            goto L38
        L9f:
            r18 = r4
            int r0 = r1.f5456d
            if (r2 == r0) goto La6
            return r18
        La6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d0.removeAll(java.util.Collection):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    @Override // java.util.Set, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(java.util.Collection r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "elements"
            q7.k.e(r0, r1)
            r1 = r17
            k.b0 r1 = r1.f5476g
            r1.getClass()
            java.lang.Object[] r2 = r1.f5454b
            int r3 = r1.f5456d
            long[] r4 = r1.f5453a
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L5c
            r7 = r6
        L1b:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L57
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L35:
            if (r12 >= r10) goto L55
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L51
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r0
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            r15 = r2[r13]
            boolean r14 = d7.r.I0(r14, r15)
            if (r14 != 0) goto L51
            r1.l(r13)
        L51:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L35
        L55:
            if (r10 != r11) goto L5c
        L57:
            if (r7 == r5) goto L5c
            int r7 = r7 + 1
            goto L1b
        L5c:
            int r0 = r1.f5456d
            if (r3 == r0) goto L62
            r0 = 1
            return r0
        L62:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d0.retainAll(java.util.Collection):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f5475f.f5456d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return q7.j.a(this);
    }

    public final String toString() {
        return this.f5475f.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        q7.k.e(objArr, "array");
        return q7.j.b(this, objArr);
    }
}
