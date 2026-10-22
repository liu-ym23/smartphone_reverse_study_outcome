package Q8;

import D7.v;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class f {
    public static final m c = new m();
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f1121j;
    public static final int k;
    public static final int l;
    public static final f m;
    public static final f n;
    public static final f o;
    public static final f p;

    /* renamed from: q, reason: collision with root package name */
    public static final f f1122q;

    /* renamed from: r, reason: collision with root package name */
    public static final ArrayList f1123r;

    /* renamed from: s, reason: collision with root package name */
    public static final ArrayList f1124s;

    /* renamed from: a, reason: collision with root package name */
    public final List f1125a;
    public final int b;

    static {
        e eVar;
        int i6 = d;
        int i10 = i6 << 1;
        e = i6;
        int i11 = i6 << 2;
        f = i10;
        int i12 = i6 << 3;
        g = i11;
        int i13 = i6 << 4;
        h = i12;
        int i14 = i6 << 5;
        i = i13;
        f1121j = i14;
        d = i6 << 7;
        int i15 = (i6 << 6) - 1;
        k = i15;
        int i16 = i6 | i10 | i11;
        l = i16;
        m = new f(i15);
        n = new f(i13 | i14);
        new f(i6);
        new f(i10);
        new f(i11);
        o = new f(i16);
        new f(i12);
        p = new f(i13);
        f1122q = new f(i14);
        new f(i10 | i13 | i14);
        Field[] fields = f.class.getFields();
        kotlin.jvm.internal.k.e(fields, "getFields(...)");
        ArrayList arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            e eVar2 = null;
            if (!it.hasNext()) {
                break;
            }
            Field field2 = (Field) it.next();
            Object obj = field2.get(null);
            f fVar = obj instanceof f ? (f) obj : null;
            if (fVar != null) {
                int i17 = fVar.b;
                String name = field2.getName();
                kotlin.jvm.internal.k.e(name, "getName(...)");
                eVar2 = new e(i17, name);
            }
            if (eVar2 != null) {
                arrayList2.add(eVar2);
            }
        }
        f1123r = arrayList2;
        Field[] fields2 = f.class.getFields();
        kotlin.jvm.internal.k.e(fields2, "getFields(...)");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (kotlin.jvm.internal.k.b(((Field) next).getType(), Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            Field field4 = (Field) it3.next();
            Object obj2 = field4.get(null);
            kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj2).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                kotlin.jvm.internal.k.e(name2, "getName(...)");
                eVar = new e(iIntValue, name2);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                arrayList5.add(eVar);
            }
        }
        f1124s = arrayList5;
    }

    public f(int i6) {
        this(i6, EmptyList.f4893a);
    }

    public final boolean a(int i6) {
        return (this.b & i6) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        f fVar = (f) obj;
        return kotlin.jvm.internal.k.b(this.f1125a, fVar.f1125a) && this.b == fVar.b;
    }

    public final int hashCode() {
        return (this.f1125a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        Object next;
        Iterator it = f1123r.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((e) next).f1120a == this.b) {
                break;
            }
        }
        e eVar = (e) next;
        String strI0 = eVar != null ? eVar.b : null;
        if (strI0 == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = f1124s.iterator();
            while (it2.hasNext()) {
                e eVar2 = (e) it2.next();
                String str = a(eVar2.f1120a) ? eVar2.b : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            strI0 = v.I0(arrayList, " | ", null, null, null, 62);
        }
        return B7.a.r(B7.a.v("DescriptorKindFilter(", strI0, ", "), this.f1125a, ')');
    }

    public f(int i6, List excludes) {
        kotlin.jvm.internal.k.f(excludes, "excludes");
        this.f1125a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i6 &= ~((d) it.next()).a();
        }
        this.b = i6;
    }
}
