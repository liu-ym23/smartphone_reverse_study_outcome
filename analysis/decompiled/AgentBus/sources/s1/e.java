package s1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements CharSequence {

    /* renamed from: f, reason: collision with root package name */
    public final List f9245f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9246g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f9247h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f9248i;

    static {
        q6.b bVar = y.f9312a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
    
        r10.a(r2.f9231c);
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.util.List r9, java.lang.String r10) {
        /*
            r8 = this;
            r8.<init>()
            r8.f9245f = r9
            r8.f9246g = r10
            r10 = 0
            r0 = 0
            if (r9 == 0) goto L3c
            int r1 = r9.size()
            r2 = r10
            r3 = r0
            r4 = r3
        L12:
            if (r2 >= r1) goto L3e
            java.lang.Object r5 = r9.get(r2)
            s1.c r5 = (s1.c) r5
            java.lang.Object r6 = r5.f9229a
            boolean r7 = r6 instanceof s1.a0
            if (r7 == 0) goto L2b
            if (r3 != 0) goto L27
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L27:
            r3.add(r5)
            goto L39
        L2b:
            boolean r6 = r6 instanceof s1.p
            if (r6 == 0) goto L39
            if (r4 != 0) goto L36
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L36:
            r4.add(r5)
        L39:
            int r2 = r2 + 1
            goto L12
        L3c:
            r3 = r0
            r4 = r3
        L3e:
            r8.f9247h = r3
            r8.f9248i = r4
            if (r4 == 0) goto L4e
            s1.d r8 = new s1.d
            r8.<init>(r10)
            java.util.List r8 = d7.r.j1(r4, r8)
            goto L4f
        L4e:
            r8 = r0
        L4f:
            if (r8 == 0) goto Lba
            boolean r9 = r8.isEmpty()
            if (r9 == 0) goto L58
            goto Lba
        L58:
            java.lang.Object r9 = d7.r.N0(r8)
            s1.c r9 = (s1.c) r9
            int r9 = r9.f9231c
            int r10 = k.i.f5494a
            k.s r10 = new k.s
            r1 = 1
            r10.<init>(r1)
            r10.a(r9)
            int r9 = r8.size()
        L6f:
            if (r1 >= r9) goto Lba
            java.lang.Object r2 = r8.get(r1)
            s1.c r2 = (s1.c) r2
        L77:
            int r3 = r10.f5530b
            if (r3 == 0) goto Lb2
            if (r3 == 0) goto Lac
            int[] r4 = r10.f5529a
            int r5 = r3 + (-1)
            r4 = r4[r5]
            int r5 = r2.f9230b
            int r6 = r2.f9231c
            if (r5 < r4) goto L8f
            int r3 = r3 + (-1)
            r10.d(r3)
            goto L77
        L8f:
            if (r6 > r4) goto L92
            goto Lb2
        L92:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Paragraph overlap not allowed, end "
            r3.<init>(r5)
            r3.append(r6)
            java.lang.String r5 = " should be less than or equal to "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            x1.a.a(r3)
            goto Lb2
        Lac:
            java.lang.String r8 = "IntList is empty."
            l.a.e(r8)
            throw r0
        Lb2:
            int r2 = r2.f9231c
            r10.a(r2)
            int r1 = r1 + 1
            goto L6f
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.e.<init>(java.util.List, java.lang.String):void");
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f9246g.charAt(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return q7.k.a(this.f9246g, eVar.f9246g) && q7.k.a(this.f9245f, eVar.f9245f);
    }

    public final int hashCode() {
        int iHashCode = this.f9246g.hashCode() * 31;
        List list = this.f9245f;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f9246g.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    @Override // java.lang.CharSequence
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence subSequence(int r10, int r11) {
        /*
            r9 = this;
            r0 = 41
            java.lang.String r1 = "start ("
            if (r10 > r11) goto L7
            goto L21
        L7:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r10)
            java.lang.String r3 = ") should be less or equal to end ("
            r2.append(r3)
            r2.append(r11)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            x1.a.a(r2)
        L21:
            java.lang.String r2 = r9.f9246g
            if (r10 != 0) goto L2c
            int r3 = r2.length()
            if (r11 != r3) goto L2c
            return r9
        L2c:
            java.lang.String r2 = r2.substring(r10, r11)
            java.lang.String r3 = "substring(...)"
            q7.k.d(r2, r3)
            int r3 = s1.f.f9255a
            if (r10 > r11) goto L3a
            goto L54
        L3a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r3.append(r10)
            java.lang.String r1 = ") should be less than or equal to end ("
            r3.append(r1)
            r3.append(r11)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            x1.a.a(r0)
        L54:
            java.util.List r9 = r9.f9245f
            if (r9 != 0) goto L59
            goto L9a
        L59:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.size()
            r0.<init>(r1)
            int r1 = r9.size()
            r3 = 0
        L67:
            if (r3 >= r1) goto L94
            java.lang.Object r4 = r9.get(r3)
            s1.c r4 = (s1.c) r4
            int r5 = r4.f9230b
            int r6 = r4.f9231c
            boolean r5 = s1.f.a(r10, r11, r5, r6)
            if (r5 == 0) goto L91
            s1.c r5 = new s1.c
            java.lang.Object r7 = r4.f9229a
            int r8 = r4.f9230b
            int r8 = java.lang.Math.max(r10, r8)
            int r8 = r8 - r10
            int r6 = java.lang.Math.min(r11, r6)
            int r6 = r6 - r10
            java.lang.String r4 = r4.f9232d
            r5.<init>(r7, r8, r6, r4)
            r0.add(r5)
        L91:
            int r3 = r3 + 1
            goto L67
        L94:
            boolean r9 = r0.isEmpty()
            if (r9 == 0) goto L9b
        L9a:
            r0 = 0
        L9b:
            s1.e r9 = new s1.e
            r9.<init>(r0, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.e.subSequence(int, int):java.lang.CharSequence");
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f9246g;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(String str) {
        this((List) null, str);
        int i2 = f.f9255a;
    }

    public /* synthetic */ e(String str, int i2) {
        this(str, d7.z.f2978f);
    }

    public e(String str, List list) {
        this(list.isEmpty() ? null : list, str);
    }
}
