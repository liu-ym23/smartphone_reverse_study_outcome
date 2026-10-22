package d9;

import c9.j;
import c9.k;
import d7.b0;
import d7.c0;
import d7.d0;
import d7.e0;
import d7.p;
import d7.r;
import d7.s;
import d7.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class g implements b9.f {

    /* renamed from: i, reason: collision with root package name */
    public static final List f3011i;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f3012f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f3013g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3014h;

    static {
        String strU0 = r.U0(s.u0('k', 'o', 't', 'l', 'i', 'n'), "", null, null, null, 62);
        List listU0 = s.u0(a1.a.i(strU0, "/Any"), a1.a.i(strU0, "/Nothing"), a1.a.i(strU0, "/Unit"), a1.a.i(strU0, "/Throwable"), a1.a.i(strU0, "/Number"), a1.a.i(strU0, "/Byte"), a1.a.i(strU0, "/Double"), a1.a.i(strU0, "/Float"), a1.a.i(strU0, "/Int"), a1.a.i(strU0, "/Long"), a1.a.i(strU0, "/Short"), a1.a.i(strU0, "/Boolean"), a1.a.i(strU0, "/Char"), a1.a.i(strU0, "/CharSequence"), a1.a.i(strU0, "/String"), a1.a.i(strU0, "/Comparable"), a1.a.i(strU0, "/Enum"), a1.a.i(strU0, "/Array"), a1.a.i(strU0, "/ByteArray"), a1.a.i(strU0, "/DoubleArray"), a1.a.i(strU0, "/FloatArray"), a1.a.i(strU0, "/IntArray"), a1.a.i(strU0, "/LongArray"), a1.a.i(strU0, "/ShortArray"), a1.a.i(strU0, "/BooleanArray"), a1.a.i(strU0, "/CharArray"), a1.a.i(strU0, "/Cloneable"), a1.a.i(strU0, "/Annotation"), a1.a.i(strU0, "/collections/Iterable"), a1.a.i(strU0, "/collections/MutableIterable"), a1.a.i(strU0, "/collections/Collection"), a1.a.i(strU0, "/collections/MutableCollection"), a1.a.i(strU0, "/collections/List"), a1.a.i(strU0, "/collections/MutableList"), a1.a.i(strU0, "/collections/Set"), a1.a.i(strU0, "/collections/MutableSet"), a1.a.i(strU0, "/collections/Map"), a1.a.i(strU0, "/collections/MutableMap"), a1.a.i(strU0, "/collections/Map.Entry"), a1.a.i(strU0, "/collections/MutableMap.MutableEntry"), a1.a.i(strU0, "/collections/Iterator"), a1.a.i(strU0, "/collections/MutableIterator"), a1.a.i(strU0, "/collections/ListIterator"), a1.a.i(strU0, "/collections/MutableListIterator"));
        f3011i = listU0;
        p pVarR1 = r.r1(listU0);
        int iS = e0.S(t.A0(pVarR1, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
        Iterator it = pVarR1.iterator();
        while (true) {
            d0 d0Var = (d0) it;
            if (!d0Var.f2955g.hasNext()) {
                return;
            }
            c0 c0Var = (c0) d0Var.next();
            linkedHashMap.put((String) c0Var.f2952b, Integer.valueOf(c0Var.f2951a));
        }
    }

    public g(k kVar, String[] strArr) {
        q7.k.e(strArr, "strings");
        List list = kVar.f2158h;
        Set setQ1 = list.isEmpty() ? b0.f2947f : r.q1(list);
        List<j> list2 = kVar.f2157g;
        q7.k.d(list2, "types.recordList");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list2.size());
        for (j jVar : list2) {
            int i2 = jVar.f2144h;
            for (int i10 = 0; i10 < i2; i10++) {
                arrayList.add(jVar);
            }
        }
        arrayList.trimToSize();
        this.f3012f = strArr;
        this.f3013g = setQ1;
        this.f3014h = arrayList;
    }

    @Override // b9.f
    public final boolean a0(int i2) {
        return this.f3013g.contains(Integer.valueOf(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // b9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getString(int r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = r8.f3014h
            java.lang.Object r0 = r0.get(r9)
            c9.j r0 = (c9.j) r0
            int r1 = r0.f2143g
            r2 = r1 & 4
            r3 = 2
            r4 = 4
            if (r2 != r4) goto L29
            java.lang.Object r8 = r0.f2146j
            boolean r9 = r8 instanceof java.lang.String
            if (r9 == 0) goto L19
            java.lang.String r8 = (java.lang.String) r8
            goto L43
        L19:
            f9.d r8 = (f9.d) r8
            java.lang.String r9 = r8.r()
            boolean r8 = r8.l()
            if (r8 == 0) goto L27
            r0.f2146j = r9
        L27:
            r8 = r9
            goto L43
        L29:
            r1 = r1 & r3
            if (r1 != r3) goto L3f
            java.util.List r1 = d9.g.f3011i
            int r2 = r1.size()
            int r4 = r0.f2145i
            if (r4 < 0) goto L3f
            if (r4 >= r2) goto L3f
            java.lang.Object r8 = r1.get(r4)
            java.lang.String r8 = (java.lang.String) r8
            goto L43
        L3f:
            java.lang.String[] r8 = r8.f3012f
            r8 = r8[r9]
        L43:
            java.util.List r9 = r0.f2148l
            int r9 = r9.size()
            java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
            r2 = 0
            r4 = 1
            if (r9 < r3) goto L95
            java.util.List r9 = r0.f2148l
            java.lang.String r5 = "substringIndexList"
            q7.k.d(r9, r5)
            java.lang.Object r5 = r9.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r9 = r9.get(r4)
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.String r6 = "begin"
            q7.k.d(r5, r6)
            int r6 = r5.intValue()
            if (r6 < 0) goto L95
            int r6 = r5.intValue()
            java.lang.String r7 = "end"
            q7.k.d(r9, r7)
            int r7 = r9.intValue()
            if (r6 > r7) goto L95
            int r6 = r9.intValue()
            int r7 = r8.length()
            if (r6 > r7) goto L95
            int r5 = r5.intValue()
            int r9 = r9.intValue()
            java.lang.String r8 = r8.substring(r5, r9)
            q7.k.d(r8, r1)
        L95:
            java.util.List r9 = r0.f2150n
            int r9 = r9.size()
            java.lang.String r5 = "string"
            if (r9 < r3) goto Lc3
            java.util.List r9 = r0.f2150n
            java.lang.String r6 = "replaceCharList"
            q7.k.d(r9, r6)
            java.lang.Object r2 = r9.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r9 = r9.get(r4)
            java.lang.Integer r9 = (java.lang.Integer) r9
            q7.k.d(r8, r5)
            int r2 = r2.intValue()
            char r2 = (char) r2
            int r9 = r9.intValue()
            char r9 = (char) r9
            java.lang.String r8 = ga.r.d0(r8, r2, r9)
        Lc3:
            c9.i r9 = r0.f2147k
            if (r9 != 0) goto Lc9
            c9.i r9 = c9.i.NONE
        Lc9:
            int r9 = r9.ordinal()
            r0 = 46
            r2 = 36
            if (r9 == r4) goto Led
            if (r9 == r3) goto Ld6
            goto Lf4
        Ld6:
            int r9 = r8.length()
            if (r9 < r3) goto Le8
            int r9 = r8.length()
            int r9 = r9 - r4
            java.lang.String r8 = r8.substring(r4, r9)
            q7.k.d(r8, r1)
        Le8:
            java.lang.String r8 = ga.r.d0(r8, r2, r0)
            goto Lf4
        Led:
            q7.k.d(r8, r5)
            java.lang.String r8 = ga.r.d0(r8, r2, r0)
        Lf4:
            q7.k.d(r8, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.g.getString(int):java.lang.String");
    }

    @Override // b9.f
    public final String r0(int i2) {
        return getString(i2);
    }
}
