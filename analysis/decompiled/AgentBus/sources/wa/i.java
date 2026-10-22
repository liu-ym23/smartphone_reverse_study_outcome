package wa;

import d7.a0;
import d7.r;
import d7.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import n7.o;

/* loaded from: classes.dex */
public class i implements ua.d, a {

    /* renamed from: a, reason: collision with root package name */
    public final String f10974a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10975b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10976c;

    /* renamed from: d, reason: collision with root package name */
    public int f10977d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f10978e;

    /* renamed from: f, reason: collision with root package name */
    public final List[] f10979f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f10980g;

    /* renamed from: h, reason: collision with root package name */
    public Object f10981h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f10982i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f10983j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f10984k;

    public i(String str, c cVar, int i2) {
        this.f10974a = str;
        this.f10975b = cVar;
        this.f10976c = i2;
        String[] strArr = new String[i2];
        for (int i10 = 0; i10 < i2; i10++) {
            strArr[i10] = "[UNINITIALIZED]";
        }
        this.f10978e = strArr;
        int i11 = this.f10976c;
        this.f10979f = new List[i11];
        this.f10980g = new boolean[i11];
        this.f10981h = a0.f2944f;
        c7.h hVar = c7.h.f1970f;
        final int i12 = 0;
        this.f10982i = s7.a.G(hVar, new p7.a(this) { // from class: wa.h

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ i f10973g;

            {
                this.f10973g = this;
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [c7.f, java.lang.Object] */
            @Override // p7.a
            public final Object c() {
                ua.d[] dVarArr;
                switch (i12) {
                    case 0:
                        return this.f10973g.f10975b.b();
                    case 1:
                        ArrayList arrayList = this.f10973g.f10975b != null ? new ArrayList(0) : null;
                        if (arrayList == null || arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        return (arrayList == null || (dVarArr = (ua.d[]) arrayList.toArray(new ua.d[0])) == null) ? g.f10971a : dVarArr;
                    default:
                        i iVar = this.f10973g;
                        ua.d[] dVarArr2 = (ua.d[]) iVar.f10983j.getValue();
                        q7.k.e(dVarArr2, "typeParams");
                        int iHashCode = (iVar.b().hashCode() * 31) + Arrays.hashCode(dVarArr2);
                        int iC = iVar.c();
                        int i13 = 1;
                        while (true) {
                            int iHashCode2 = 0;
                            if (iC > 0) {
                                int i14 = iC - 1;
                                int i15 = i13 * 31;
                                String strB = iVar.i(iVar.c() - iC).b();
                                if (strB != null) {
                                    iHashCode2 = strB.hashCode();
                                }
                                i13 = i15 + iHashCode2;
                                iC = i14;
                            } else {
                                int iC2 = iVar.c();
                                int iHashCode3 = 1;
                                while (true) {
                                    if (!(iC2 > 0)) {
                                        return Integer.valueOf((((iHashCode * 31) + i13) * 31) + iHashCode3);
                                    }
                                    int i16 = iC2 - 1;
                                    int i17 = iHashCode3 * 31;
                                    o kind = iVar.i(iVar.c() - iC2).getKind();
                                    iHashCode3 = i17 + (kind != null ? kind.hashCode() : 0);
                                    iC2 = i16;
                                }
                            }
                        }
                }
            }
        });
        final int i13 = 1;
        this.f10983j = s7.a.G(hVar, new p7.a(this) { // from class: wa.h

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ i f10973g;

            {
                this.f10973g = this;
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [c7.f, java.lang.Object] */
            @Override // p7.a
            public final Object c() {
                ua.d[] dVarArr;
                switch (i13) {
                    case 0:
                        return this.f10973g.f10975b.b();
                    case 1:
                        ArrayList arrayList = this.f10973g.f10975b != null ? new ArrayList(0) : null;
                        if (arrayList == null || arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        return (arrayList == null || (dVarArr = (ua.d[]) arrayList.toArray(new ua.d[0])) == null) ? g.f10971a : dVarArr;
                    default:
                        i iVar = this.f10973g;
                        ua.d[] dVarArr2 = (ua.d[]) iVar.f10983j.getValue();
                        q7.k.e(dVarArr2, "typeParams");
                        int iHashCode = (iVar.b().hashCode() * 31) + Arrays.hashCode(dVarArr2);
                        int iC = iVar.c();
                        int i132 = 1;
                        while (true) {
                            int iHashCode2 = 0;
                            if (iC > 0) {
                                int i14 = iC - 1;
                                int i15 = i132 * 31;
                                String strB = iVar.i(iVar.c() - iC).b();
                                if (strB != null) {
                                    iHashCode2 = strB.hashCode();
                                }
                                i132 = i15 + iHashCode2;
                                iC = i14;
                            } else {
                                int iC2 = iVar.c();
                                int iHashCode3 = 1;
                                while (true) {
                                    if (!(iC2 > 0)) {
                                        return Integer.valueOf((((iHashCode * 31) + i132) * 31) + iHashCode3);
                                    }
                                    int i16 = iC2 - 1;
                                    int i17 = iHashCode3 * 31;
                                    o kind = iVar.i(iVar.c() - iC2).getKind();
                                    iHashCode3 = i17 + (kind != null ? kind.hashCode() : 0);
                                    iC2 = i16;
                                }
                            }
                        }
                }
            }
        });
        final int i14 = 2;
        this.f10984k = s7.a.G(hVar, new p7.a(this) { // from class: wa.h

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ i f10973g;

            {
                this.f10973g = this;
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [c7.f, java.lang.Object] */
            @Override // p7.a
            public final Object c() {
                ua.d[] dVarArr;
                switch (i14) {
                    case 0:
                        return this.f10973g.f10975b.b();
                    case 1:
                        ArrayList arrayList = this.f10973g.f10975b != null ? new ArrayList(0) : null;
                        if (arrayList == null || arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        return (arrayList == null || (dVarArr = (ua.d[]) arrayList.toArray(new ua.d[0])) == null) ? g.f10971a : dVarArr;
                    default:
                        i iVar = this.f10973g;
                        ua.d[] dVarArr2 = (ua.d[]) iVar.f10983j.getValue();
                        q7.k.e(dVarArr2, "typeParams");
                        int iHashCode = (iVar.b().hashCode() * 31) + Arrays.hashCode(dVarArr2);
                        int iC = iVar.c();
                        int i132 = 1;
                        while (true) {
                            int iHashCode2 = 0;
                            if (iC > 0) {
                                int i142 = iC - 1;
                                int i15 = i132 * 31;
                                String strB = iVar.i(iVar.c() - iC).b();
                                if (strB != null) {
                                    iHashCode2 = strB.hashCode();
                                }
                                i132 = i15 + iHashCode2;
                                iC = i142;
                            } else {
                                int iC2 = iVar.c();
                                int iHashCode3 = 1;
                                while (true) {
                                    if (!(iC2 > 0)) {
                                        return Integer.valueOf((((iHashCode * 31) + i132) * 31) + iHashCode3);
                                    }
                                    int i16 = iC2 - 1;
                                    int i17 = iHashCode3 * 31;
                                    o kind = iVar.i(iVar.c() - iC2).getKind();
                                    iHashCode3 = i17 + (kind != null ? kind.hashCode() : 0);
                                    iC2 = i16;
                                }
                            }
                        }
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Map] */
    @Override // ua.d
    public final int a(String str) {
        q7.k.e(str, "name");
        Integer num = (Integer) this.f10981h.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // ua.d
    public final String b() {
        return this.f10974a;
    }

    @Override // ua.d
    public final int c() {
        return this.f10976c;
    }

    @Override // ua.d
    public final String d(int i2) {
        return this.f10978e[i2];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [c7.f, java.lang.Object] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            ua.d dVar = (ua.d) obj;
            if (this.f10974a.equals(dVar.b()) && Arrays.equals((ua.d[]) this.f10983j.getValue(), (ua.d[]) ((i) obj).f10983j.getValue())) {
                int iC = dVar.c();
                int i2 = this.f10976c;
                if (i2 == iC) {
                    for (int i10 = 0; i10 < i2; i10++) {
                        if (q7.k.a(i(i10).b(), dVar.i(i10).b()) && q7.k.a(i(i10).getKind(), dVar.i(i10).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // wa.a
    public final Set f() {
        return this.f10981h.keySet();
    }

    @Override // ua.d
    public final List getAnnotations() {
        return z.f2978f;
    }

    @Override // ua.d
    public final o getKind() {
        return ua.f.f10216b;
    }

    @Override // ua.d
    public final List h(int i2) {
        List list = this.f10979f[i2];
        return list == null ? z.f2978f : list;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    public int hashCode() {
        return ((Number) this.f10984k.getValue()).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // ua.d
    public final ua.d i(int i2) {
        return ((sa.a[]) this.f10982i.getValue())[i2].a();
    }

    @Override // ua.d
    public final boolean j(int i2) {
        return this.f10980g[i2];
    }

    public final void k(String str, boolean z4) {
        int i2 = this.f10977d + 1;
        this.f10977d = i2;
        String[] strArr = this.f10978e;
        strArr[i2] = str;
        this.f10980g[i2] = z4;
        this.f10979f[i2] = null;
        if (i2 == this.f10976c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                map.put(strArr[i10], Integer.valueOf(i10));
            }
            this.f10981h = map;
        }
    }

    public final String toString() {
        return r.U0(nb.i.N(0, this.f10976c), ", ", this.f10974a.concat("("), ")", new a5.a(23, this), 24);
    }
}
