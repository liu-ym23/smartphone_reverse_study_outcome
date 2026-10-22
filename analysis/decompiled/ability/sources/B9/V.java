package B9;

import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public class V implements z9.g, InterfaceC0184k {

    /* renamed from: a, reason: collision with root package name */
    public final String f232a;
    public final A b;
    public final int c;
    public int d = -1;
    public final String[] e;
    public final List[] f;
    public final boolean[] g;
    public Object h;
    public final Object i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f233j;
    public final Object k;

    public V(String str, A a3, int i) {
        this.f232a = str;
        this.b = a3;
        this.c = i;
        String[] strArr = new String[i];
        for (int i6 = 0; i6 < i; i6++) {
            strArr[i6] = "[UNINITIALIZED]";
        }
        this.e = strArr;
        int i10 = this.c;
        this.f = new List[i10];
        this.g = new boolean[i10];
        this.h = kotlin.collections.a.M();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        final int i11 = 0;
        this.i = kotlin.a.b(lazyThreadSafetyMode, new S7.a(this) { // from class: B9.U
            public final /* synthetic */ V b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [C7.f, java.lang.Object] */
            @Override // S7.a
            public final Object invoke() {
                x9.b[] bVarArrChildSerializers;
                ArrayList arrayList;
                x9.b[] bVarArrTypeParametersSerializers;
                switch (i11) {
                    case 0:
                        A a4 = this.b.b;
                        return (a4 == null || (bVarArrChildSerializers = a4.childSerializers()) == null) ? T.b : bVarArrChildSerializers;
                    case 1:
                        A a8 = this.b.b;
                        if (a8 == null || (bVarArrTypeParametersSerializers = a8.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                            for (x9.b bVar : bVarArrTypeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return T.c(arrayList);
                    default:
                        V v10 = this.b;
                        return Integer.valueOf(T.e(v10, (z9.g[]) v10.f233j.getF4884a()));
                }
            }
        });
        final int i12 = 1;
        this.f233j = kotlin.a.b(lazyThreadSafetyMode, new S7.a(this) { // from class: B9.U
            public final /* synthetic */ V b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [C7.f, java.lang.Object] */
            @Override // S7.a
            public final Object invoke() {
                x9.b[] bVarArrChildSerializers;
                ArrayList arrayList;
                x9.b[] bVarArrTypeParametersSerializers;
                switch (i12) {
                    case 0:
                        A a4 = this.b.b;
                        return (a4 == null || (bVarArrChildSerializers = a4.childSerializers()) == null) ? T.b : bVarArrChildSerializers;
                    case 1:
                        A a8 = this.b.b;
                        if (a8 == null || (bVarArrTypeParametersSerializers = a8.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                            for (x9.b bVar : bVarArrTypeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return T.c(arrayList);
                    default:
                        V v10 = this.b;
                        return Integer.valueOf(T.e(v10, (z9.g[]) v10.f233j.getF4884a()));
                }
            }
        });
        final int i13 = 2;
        this.k = kotlin.a.b(lazyThreadSafetyMode, new S7.a(this) { // from class: B9.U
            public final /* synthetic */ V b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [C7.f, java.lang.Object] */
            @Override // S7.a
            public final Object invoke() {
                x9.b[] bVarArrChildSerializers;
                ArrayList arrayList;
                x9.b[] bVarArrTypeParametersSerializers;
                switch (i13) {
                    case 0:
                        A a4 = this.b.b;
                        return (a4 == null || (bVarArrChildSerializers = a4.childSerializers()) == null) ? T.b : bVarArrChildSerializers;
                    case 1:
                        A a8 = this.b.b;
                        if (a8 == null || (bVarArrTypeParametersSerializers = a8.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                            for (x9.b bVar : bVarArrTypeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return T.c(arrayList);
                    default:
                        V v10 = this.b;
                        return Integer.valueOf(T.e(v10, (z9.g[]) v10.f233j.getF4884a()));
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // B9.InterfaceC0184k
    public final Set a() {
        return this.h.keySet();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Map] */
    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        Integer num = (Integer) this.h.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // z9.g
    public final int d() {
        return this.c;
    }

    @Override // z9.g
    public final String e(int i) {
        return this.e[i];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [C7.f, java.lang.Object] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof V) {
            z9.g gVar = (z9.g) obj;
            if (this.f232a.equals(gVar.h()) && Arrays.equals((z9.g[]) this.f233j.getF4884a(), (z9.g[]) ((V) obj).f233j.getF4884a())) {
                int iD = gVar.d();
                int i = this.c;
                if (i == iD) {
                    for (int i6 = 0; i6 < i; i6++) {
                        if (kotlin.jvm.internal.k.b(g(i6).h(), gVar.g(i6).h()) && kotlin.jvm.internal.k.b(g(i6).getKind(), gVar.g(i6).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // z9.g
    public final List f(int i) {
        List list = this.f[i];
        return list == null ? EmptyList.f4893a : list;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // z9.g
    public z9.g g(int i) {
        return ((x9.b[]) this.i.getF4884a())[i].getDescriptor();
    }

    @Override // z9.g
    public final List getAnnotations() {
        return EmptyList.f4893a;
    }

    @Override // z9.g
    public H4.o getKind() {
        return z9.k.c;
    }

    @Override // z9.g
    public final String h() {
        return this.f232a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    public int hashCode() {
        return ((Number) this.k.getF4884a()).intValue();
    }

    @Override // z9.g
    public final boolean i(int i) {
        return this.g[i];
    }

    public final void j(String name, boolean z10) {
        kotlin.jvm.internal.k.f(name, "name");
        int i = this.d + 1;
        this.d = i;
        String[] strArr = this.e;
        strArr[i] = name;
        this.g[i] = z10;
        this.f[i] = null;
        if (i == this.c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                map.put(strArr[i6], Integer.valueOf(i6));
            }
            this.h = map;
        }
    }

    public String toString() {
        return D7.v.I0(AbstractC1451a.X(0, this.c), ", ", this.f232a.concat("("), ")", new Q(this, 1), 24);
    }
}
