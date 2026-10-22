package d2;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements CharSequence {

    /* renamed from: c, reason: collision with root package name */
    public final List f3100c;

    /* renamed from: f, reason: collision with root package name */
    public final String f3101f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f3102g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3103h;

    static {
        p5.u uVar = c0.f3049a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
    
        r10.a(r2.f3079c);
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(java.util.List r9, java.lang.String r10) {
        /*
            r8 = this;
            r8.<init>()
            r8.f3100c = r9
            r8.f3101f = r10
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
            d2.e r5 = (d2.e) r5
            java.lang.Object r6 = r5.f3077a
            boolean r7 = r6 instanceof d2.e0
            if (r7 == 0) goto L2b
            if (r3 != 0) goto L27
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L27:
            r3.add(r5)
            goto L39
        L2b:
            boolean r6 = r6 instanceof d2.t
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
            r8.f3102g = r3
            r8.f3103h = r4
            if (r4 == 0) goto L4e
            d2.f r8 = new d2.f
            r8.<init>(r10)
            java.util.List r8 = kb.l.I0(r4, r8)
            goto L4f
        L4e:
            r8 = r0
        L4f:
            if (r8 == 0) goto Lba
            boolean r9 = r8.isEmpty()
            if (r9 == 0) goto L58
            goto Lba
        L58:
            java.lang.Object r9 = kb.l.w0(r8)
            d2.e r9 = (d2.e) r9
            int r9 = r9.f3079c
            int r10 = p.i.f9577a
            p.t r10 = new p.t
            r1 = 1
            r10.<init>(r1)
            r10.a(r9)
            int r9 = r8.size()
        L6f:
            if (r1 >= r9) goto Lba
            java.lang.Object r2 = r8.get(r1)
            d2.e r2 = (d2.e) r2
        L77:
            int r3 = r10.f9630b
            if (r3 == 0) goto Lb2
            if (r3 == 0) goto Lac
            int[] r4 = r10.f9629a
            int r5 = r3 + (-1)
            r4 = r4[r5]
            int r5 = r2.f3078b
            int r6 = r2.f3079c
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
            i2.a.a(r3)
            goto Lb2
        Lac:
            java.lang.String r8 = "IntList is empty."
            g5.f.m(r8)
            throw r0
        Lb2:
            int r2 = r2.f3079c
            r10.a(r2)
            int r1 = r1 + 1
            goto L6f
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.g.<init>(java.util.List, java.lang.String):void");
    }

    public final List a(int i) {
        List list = this.f3100c;
        if (list == null) {
            return kb.s.f7404c;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            e eVar = (e) obj;
            if ((eVar.f3077a instanceof m) && h.b(0, i, eVar.f3078b, eVar.f3079c)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List b(int i, int i3, String str) {
        List list = this.f3100c;
        if (list == null) {
            return kb.s.f7404c;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) list.get(i10);
            Object obj = eVar.f3077a;
            int i11 = eVar.f3079c;
            int i12 = eVar.f3078b;
            String str2 = eVar.f3080d;
            if ((obj instanceof g0) && str.equals(str2) && h.b(i, i3, i12, i11)) {
                Object obj2 = eVar.f3077a;
                obj2.getClass();
                arrayList.add(new e(i12, i11, ((g0) obj2).f3104a, str2));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    @Override // java.lang.CharSequence
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d2.g subSequence(int r10, int r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 > r11) goto L5
            r1 = 1
            goto L6
        L5:
            r1 = r0
        L6:
            r2 = 41
            java.lang.String r3 = "start ("
            if (r1 != 0) goto L26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r10)
            java.lang.String r4 = ") should be less or equal to end ("
            r1.append(r4)
            r1.append(r11)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            i2.a.a(r1)
        L26:
            java.lang.String r1 = r9.f3101f
            if (r10 != 0) goto L31
            int r4 = r1.length()
            if (r11 != r4) goto L31
            return r9
        L31:
            java.lang.String r1 = r1.substring(r10, r11)
            int r4 = d2.h.f3105a
            if (r10 > r11) goto L3a
            goto L54
        L3a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r10)
            java.lang.String r3 = ") should be less than or equal to end ("
            r4.append(r3)
            r4.append(r11)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            i2.a.a(r2)
        L54:
            java.util.List r9 = r9.f3100c
            if (r9 != 0) goto L59
            goto L99
        L59:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r9.size()
            r2.<init>(r3)
            int r3 = r9.size()
        L66:
            if (r0 >= r3) goto L93
            java.lang.Object r4 = r9.get(r0)
            d2.e r4 = (d2.e) r4
            int r5 = r4.f3078b
            int r6 = r4.f3079c
            boolean r5 = d2.h.b(r10, r11, r5, r6)
            if (r5 == 0) goto L90
            d2.e r5 = new d2.e
            java.lang.Object r7 = r4.f3077a
            int r8 = r4.f3078b
            int r8 = java.lang.Math.max(r10, r8)
            int r8 = r8 - r10
            int r6 = java.lang.Math.min(r11, r6)
            int r6 = r6 - r10
            java.lang.String r4 = r4.f3080d
            r5.<init>(r8, r6, r7, r4)
            r2.add(r5)
        L90:
            int r0 = r0 + 1
            goto L66
        L93:
            boolean r9 = r2.isEmpty()
            if (r9 == 0) goto L9a
        L99:
            r2 = 0
        L9a:
            d2.g r9 = new d2.g
            r9.<init>(r2, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.g.subSequence(int, int):d2.g");
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f3101f.charAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return yb.k.a(this.f3101f, gVar.f3101f) && yb.k.a(this.f3100c, gVar.f3100c);
    }

    public final int hashCode() {
        int iHashCode = this.f3101f.hashCode() * 31;
        List list = this.f3100c;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3101f.length();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f3101f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        this((List) null, str);
        int i = h.f3105a;
    }

    public /* synthetic */ g(String str, int i) {
        this(str, kb.s.f7404c);
    }

    public g(String str, List list) {
        this(list.isEmpty() ? null : list, str);
    }
}
