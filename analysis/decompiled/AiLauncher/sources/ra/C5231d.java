package ra;

import Z8.C1173v;
import Z8.F;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ra.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5231d {

    /* renamed from: c, reason: collision with root package name */
    public static final a f38857c;

    /* renamed from: d, reason: collision with root package name */
    public static int f38858d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f38859e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f38860f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f38861g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f38862h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f38863i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f38864j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f38865k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f38866l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f38867m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f38868n;

    /* renamed from: o, reason: collision with root package name */
    public static final C5231d f38869o;

    /* renamed from: p, reason: collision with root package name */
    public static final C5231d f38870p;

    /* renamed from: q, reason: collision with root package name */
    public static final C5231d f38871q;

    /* renamed from: r, reason: collision with root package name */
    public static final C5231d f38872r;

    /* renamed from: s, reason: collision with root package name */
    public static final C5231d f38873s;

    /* renamed from: t, reason: collision with root package name */
    public static final C5231d f38874t;

    /* renamed from: u, reason: collision with root package name */
    public static final C5231d f38875u;

    /* renamed from: v, reason: collision with root package name */
    public static final C5231d f38876v;

    /* renamed from: w, reason: collision with root package name */
    public static final C5231d f38877w;

    /* renamed from: x, reason: collision with root package name */
    public static final C5231d f38878x;

    /* renamed from: y, reason: collision with root package name */
    public static final List<a.C0517a> f38879y;

    /* renamed from: z, reason: collision with root package name */
    public static final List<a.C0517a> f38880z;

    /* renamed from: a, reason: collision with root package name */
    public final List<AbstractC5230c> f38881a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38882b;

    /* renamed from: ra.d$a */
    public static final class a {

        /* renamed from: ra.d$a$a, reason: collision with other inner class name */
        public static final class C0517a {

            /* renamed from: a, reason: collision with root package name */
            public final int f38883a;

            /* renamed from: b, reason: collision with root package name */
            public final String f38884b;

            public C0517a(int i10, String name) {
                kotlin.jvm.internal.p.i(name, "name");
                this.f38883a = i10;
                this.f38884b = name;
            }

            public final int a() {
                return this.f38883a;
            }

            public final String b() {
                return this.f38884b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int b() {
            return C5231d.f38865k;
        }

        public final int c() {
            return C5231d.f38866l;
        }

        public final int d() {
            return C5231d.f38863i;
        }

        public final int e() {
            return C5231d.f38859e;
        }

        public final int f() {
            return C5231d.f38862h;
        }

        public final int g() {
            return C5231d.f38860f;
        }

        public final int h() {
            return C5231d.f38861g;
        }

        public final int i() {
            return C5231d.f38864j;
        }

        public final int j() {
            int i10 = C5231d.f38858d;
            C5231d.f38858d <<= 1;
            return i10;
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0517a c0517a;
        a.C0517a c0517a2;
        a aVar = new a(null);
        f38857c = aVar;
        f38858d = 1;
        int iJ = aVar.j();
        f38859e = iJ;
        int iJ2 = aVar.j();
        f38860f = iJ2;
        int iJ3 = aVar.j();
        f38861g = iJ3;
        int iJ4 = aVar.j();
        f38862h = iJ4;
        int iJ5 = aVar.j();
        f38863i = iJ5;
        int iJ6 = aVar.j();
        f38864j = iJ6;
        int iJ7 = aVar.j() - 1;
        f38865k = iJ7;
        int i10 = iJ | iJ2 | iJ3;
        f38866l = i10;
        int i11 = iJ2 | iJ5 | iJ6;
        f38867m = i11;
        int i12 = iJ5 | iJ6;
        f38868n = i12;
        int i13 = 2;
        f38869o = new C5231d(iJ7, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38870p = new C5231d(i12, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38871q = new C5231d(iJ, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38872r = new C5231d(iJ2, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38873s = new C5231d(iJ3, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38874t = new C5231d(i10, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38875u = new C5231d(iJ4, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38876v = new C5231d(iJ5, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38877w = new C5231d(iJ6, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f38878x = new C5231d(i11, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        Field[] fields = C5231d.class.getFields();
        kotlin.jvm.internal.p.h(fields, "getFields(...)");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            C5231d c5231d = obj instanceof C5231d ? (C5231d) obj : null;
            if (c5231d != null) {
                int i14 = c5231d.f38882b;
                String name = field2.getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                c0517a2 = new a.C0517a(i14, name);
            } else {
                c0517a2 = null;
            }
            if (c0517a2 != null) {
                arrayList2.add(c0517a2);
            }
        }
        f38879y = arrayList2;
        Field[] fields2 = C5231d.class.getFields();
        kotlin.jvm.internal.p.h(fields2, "getFields(...)");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (kotlin.jvm.internal.p.d(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            kotlin.jvm.internal.p.g(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                kotlin.jvm.internal.p.h(name2, "getName(...)");
                c0517a = new a.C0517a(iIntValue, name2);
            } else {
                c0517a = null;
            }
            if (c0517a != null) {
                arrayList5.add(c0517a);
            }
        }
        f38880z = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5231d(int i10, List<? extends AbstractC5230c> excludes) {
        kotlin.jvm.internal.p.i(excludes, "excludes");
        this.f38881a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i10 &= ~((AbstractC5230c) it.next()).a();
        }
        this.f38882b = i10;
    }

    public final boolean a(int i10) {
        return (this.f38882b & i10) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.p.d(C5231d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        C5231d c5231d = (C5231d) obj;
        return kotlin.jvm.internal.p.d(this.f38881a, c5231d.f38881a) && this.f38882b == c5231d.f38882b;
    }

    public int hashCode() {
        return (this.f38881a.hashCode() * 31) + this.f38882b;
    }

    public final List<AbstractC5230c> l() {
        return this.f38881a;
    }

    public final int m() {
        return this.f38882b;
    }

    public final C5231d n(int i10) {
        int i11 = i10 & this.f38882b;
        if (i11 == 0) {
            return null;
        }
        return new C5231d(i11, this.f38881a);
    }

    public String toString() {
        Object next;
        Iterator<T> it = f38879y.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C0517a) next).a() == this.f38882b) {
                break;
            }
        }
        a.C0517a c0517a = (a.C0517a) next;
        String strB = c0517a != null ? c0517a.b() : null;
        if (strB == null) {
            List<a.C0517a> list = f38880z;
            ArrayList arrayList = new ArrayList();
            for (a.C0517a c0517a2 : list) {
                String strB2 = a(c0517a2.a()) ? c0517a2.b() : null;
                if (strB2 != null) {
                    arrayList.add(strB2);
                }
            }
            strB = F.A0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + strB + ", " + this.f38881a + ')';
    }

    public /* synthetic */ C5231d(int i10, List list, int i11, kotlin.jvm.internal.i iVar) {
        this(i10, (i11 & 2) != 0 ? C1173v.m() : list);
    }
}
