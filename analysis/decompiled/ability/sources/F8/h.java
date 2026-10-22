package F8;

import D7.D;
import D7.E;
import D7.s;
import D7.v;
import D7.w;
import H4.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public abstract class h implements D8.f {
    public static final List d;

    /* renamed from: a, reason: collision with root package name */
    public final String[] f595a;
    public final Set b;
    public final ArrayList c;

    static {
        String strI0 = v.I0(o.N('k', 'o', 't', 'l', 'i', 'n'), "", null, null, null, 62);
        List listN = o.N(androidx.appfunctions.metadata.a.l(strI0, "/Any"), androidx.appfunctions.metadata.a.l(strI0, "/Nothing"), androidx.appfunctions.metadata.a.l(strI0, "/Unit"), androidx.appfunctions.metadata.a.l(strI0, "/Throwable"), androidx.appfunctions.metadata.a.l(strI0, "/Number"), androidx.appfunctions.metadata.a.l(strI0, "/Byte"), androidx.appfunctions.metadata.a.l(strI0, "/Double"), androidx.appfunctions.metadata.a.l(strI0, "/Float"), androidx.appfunctions.metadata.a.l(strI0, "/Int"), androidx.appfunctions.metadata.a.l(strI0, "/Long"), androidx.appfunctions.metadata.a.l(strI0, "/Short"), androidx.appfunctions.metadata.a.l(strI0, "/Boolean"), androidx.appfunctions.metadata.a.l(strI0, "/Char"), androidx.appfunctions.metadata.a.l(strI0, "/CharSequence"), androidx.appfunctions.metadata.a.l(strI0, "/String"), androidx.appfunctions.metadata.a.l(strI0, "/Comparable"), androidx.appfunctions.metadata.a.l(strI0, "/Enum"), androidx.appfunctions.metadata.a.l(strI0, "/Array"), androidx.appfunctions.metadata.a.l(strI0, "/ByteArray"), androidx.appfunctions.metadata.a.l(strI0, "/DoubleArray"), androidx.appfunctions.metadata.a.l(strI0, "/FloatArray"), androidx.appfunctions.metadata.a.l(strI0, "/IntArray"), androidx.appfunctions.metadata.a.l(strI0, "/LongArray"), androidx.appfunctions.metadata.a.l(strI0, "/ShortArray"), androidx.appfunctions.metadata.a.l(strI0, "/BooleanArray"), androidx.appfunctions.metadata.a.l(strI0, "/CharArray"), androidx.appfunctions.metadata.a.l(strI0, "/Cloneable"), androidx.appfunctions.metadata.a.l(strI0, "/Annotation"), androidx.appfunctions.metadata.a.l(strI0, "/collections/Iterable"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableIterable"), androidx.appfunctions.metadata.a.l(strI0, "/collections/Collection"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableCollection"), androidx.appfunctions.metadata.a.l(strI0, "/collections/List"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableList"), androidx.appfunctions.metadata.a.l(strI0, "/collections/Set"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableSet"), androidx.appfunctions.metadata.a.l(strI0, "/collections/Map"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableMap"), androidx.appfunctions.metadata.a.l(strI0, "/collections/Map.Entry"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableMap.MutableEntry"), androidx.appfunctions.metadata.a.l(strI0, "/collections/Iterator"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableIterator"), androidx.appfunctions.metadata.a.l(strI0, "/collections/ListIterator"), androidx.appfunctions.metadata.a.l(strI0, "/collections/MutableListIterator"));
        d = listN;
        s sVarL1 = v.l1(listN);
        int iP = kotlin.collections.a.P(w.c0(sVarL1, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        Iterator it = sVarL1.iterator();
        while (true) {
            E e = (E) it;
            if (!e.b.hasNext()) {
                return;
            }
            D d6 = (D) e.next();
            linkedHashMap.put((String) d6.b, Integer.valueOf(d6.f393a));
        }
    }

    public h(String[] strings, Set localNameIndices, ArrayList arrayList) {
        k.f(strings, "strings");
        k.f(localNameIndices, "localNameIndices");
        this.f595a = strings;
        this.b = localNameIndices;
        this.c = arrayList;
    }

    @Override // D8.f
    public final boolean a(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    @Override // D8.f
    public final String b(int i) {
        return getString(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @Override // D8.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getString(int r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = r8.c
            java.lang.Object r0 = r0.get(r9)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes.Record) r0
            int r1 = r0.b
            r2 = r1 & 4
            r3 = 2
            r4 = 4
            if (r2 != r4) goto L29
            java.lang.Object r8 = r0.e
            boolean r9 = r8 instanceof java.lang.String
            if (r9 == 0) goto L19
            java.lang.String r8 = (java.lang.String) r8
            goto L46
        L19:
            H8.e r8 = (H8.AbstractC0244e) r8
            java.lang.String r9 = r8.q()
            boolean r8 = r8.i()
            if (r8 == 0) goto L27
            r0.e = r9
        L27:
            r8 = r9
            goto L46
        L29:
            r1 = r1 & r3
            if (r1 != r3) goto L42
            java.util.List r1 = F8.h.d
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            int r4 = r0.d
            if (r4 < 0) goto L42
            if (r4 >= r2) goto L42
            java.lang.Object r8 = r1.get(r4)
            java.lang.String r8 = (java.lang.String) r8
            goto L46
        L42:
            java.lang.String[] r8 = r8.f595a
            r8 = r8[r9]
        L46:
            java.util.List r9 = r0.g
            int r9 = r9.size()
            java.lang.String r1 = "substring(...)"
            r2 = 0
            r4 = 1
            if (r9 < r3) goto L8c
            java.util.List r9 = r0.g
            kotlin.jvm.internal.k.c(r9)
            java.lang.Object r5 = r9.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r9 = r9.get(r4)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r6 = r5.intValue()
            if (r6 < 0) goto L8c
            int r6 = r5.intValue()
            int r7 = r9.intValue()
            if (r6 > r7) goto L8c
            int r6 = r9.intValue()
            int r7 = r8.length()
            if (r6 > r7) goto L8c
            int r5 = r5.intValue()
            int r9 = r9.intValue()
            java.lang.String r8 = r8.substring(r5, r9)
            kotlin.jvm.internal.k.e(r8, r1)
        L8c:
            java.util.List r9 = r0.i
            int r9 = r9.size()
            if (r9 < r3) goto Lb6
            java.util.List r9 = r0.i
            kotlin.jvm.internal.k.c(r9)
            java.lang.Object r2 = r9.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r9 = r9.get(r4)
            java.lang.Integer r9 = (java.lang.Integer) r9
            kotlin.jvm.internal.k.c(r8)
            int r2 = r2.intValue()
            char r2 = (char) r2
            int r9 = r9.intValue()
            char r9 = (char) r9
            java.lang.String r8 = j9.t.b0(r8, r2, r9)
        Lb6:
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$Operation r9 = r0.f
            if (r9 != 0) goto Lbc
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$Operation r9 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.NONE
        Lbc:
            int r9 = r9.ordinal()
            if (r9 == 0) goto Lee
            r0 = 46
            r2 = 36
            if (r9 == r4) goto Le7
            if (r9 != r3) goto Le1
            int r9 = r8.length()
            if (r9 < r3) goto Ldc
            int r9 = r8.length()
            int r9 = r9 - r4
            java.lang.String r8 = r8.substring(r4, r9)
            kotlin.jvm.internal.k.e(r8, r1)
        Ldc:
            java.lang.String r8 = j9.t.b0(r8, r2, r0)
            goto Lee
        Le1:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        Le7:
            kotlin.jvm.internal.k.c(r8)
            java.lang.String r8 = j9.t.b0(r8, r2, r0)
        Lee:
            kotlin.jvm.internal.k.c(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: F8.h.getString(int):java.lang.String");
    }
}
