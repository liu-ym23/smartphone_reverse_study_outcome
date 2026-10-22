package o9;

import d7.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final l f7900c = new l();

    /* renamed from: d, reason: collision with root package name */
    public static final int f7901d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f7902e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f7903f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f7904g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f7905h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f7906i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f7907j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f7908k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f7909l;

    /* renamed from: m, reason: collision with root package name */
    public static final f f7910m;

    /* renamed from: n, reason: collision with root package name */
    public static final f f7911n;

    /* renamed from: o, reason: collision with root package name */
    public static final f f7912o;

    /* renamed from: p, reason: collision with root package name */
    public static final f f7913p;

    /* renamed from: q, reason: collision with root package name */
    public static final f f7914q;

    /* renamed from: r, reason: collision with root package name */
    public static final ArrayList f7915r;

    /* renamed from: s, reason: collision with root package name */
    public static final ArrayList f7916s;

    /* renamed from: a, reason: collision with root package name */
    public final List f7917a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7918b;

    static {
        e eVar;
        int i2 = f7901d;
        int i10 = i2 << 1;
        f7902e = i2;
        int i11 = i2 << 2;
        f7903f = i10;
        int i12 = i2 << 3;
        f7904g = i11;
        int i13 = i2 << 4;
        f7905h = i12;
        int i14 = i2 << 5;
        f7906i = i13;
        f7907j = i14;
        f7901d = i2 << 7;
        int i15 = (i2 << 6) - 1;
        f7908k = i15;
        int i16 = i2 | i10 | i11;
        f7909l = i16;
        f7910m = new f(i15);
        f7911n = new f(i13 | i14);
        new f(i2);
        new f(i10);
        new f(i11);
        f7912o = new f(i16);
        new f(i12);
        f7913p = new f(i13);
        f7914q = new f(i14);
        new f(i10 | i13 | i14);
        Field[] fields = f.class.getFields();
        q7.k.d(fields, "T::class.java.fields");
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
                int i17 = fVar.f7918b;
                String name = field2.getName();
                q7.k.d(name, "field.name");
                eVar2 = new e(i17, name);
            }
            if (eVar2 != null) {
                arrayList2.add(eVar2);
            }
        }
        f7915r = arrayList2;
        Field[] fields2 = f.class.getFields();
        q7.k.d(fields2, "T::class.java.fields");
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
            if (q7.k.a(((Field) next).getType(), Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            Field field4 = (Field) it3.next();
            Object obj2 = field4.get(null);
            q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj2).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                q7.k.d(name2, "field.name");
                eVar = new e(iIntValue, name2);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                arrayList5.add(eVar);
            }
        }
        f7916s = arrayList5;
    }

    public f(int i2, List list) {
        q7.k.e(list, "excludes");
        this.f7917a = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((d) it.next()).a();
        }
        this.f7918b = i2;
    }

    public final boolean a(int i2) {
        return (this.f7918b & i2) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        q7.k.c(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        f fVar = (f) obj;
        return q7.k.a(this.f7917a, fVar.f7917a) && this.f7918b == fVar.f7918b;
    }

    public final int hashCode() {
        return (this.f7917a.hashCode() * 31) + this.f7918b;
    }

    public final String toString() throws IOException {
        Object next;
        Iterator it = f7915r.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((e) next).f7898a == this.f7918b) {
                break;
            }
        }
        e eVar = (e) next;
        String strU0 = eVar != null ? eVar.f7899b : null;
        if (strU0 == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = f7916s.iterator();
            while (it2.hasNext()) {
                e eVar2 = (e) it2.next();
                String str = a(eVar2.f7898a) ? eVar2.f7899b : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            strU0 = d7.r.U0(arrayList, " | ", null, null, null, 62);
        }
        return "DescriptorKindFilter(" + strU0 + ", " + this.f7917a + ')';
    }

    public /* synthetic */ f(int i2) {
        this(i2, z.f2978f);
    }
}
