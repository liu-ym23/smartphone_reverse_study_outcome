package z9;

import B9.InterfaceC0184k;
import B9.T;
import D7.D;
import D7.E;
import D7.s;
import D7.v;
import D7.w;
import H4.o;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* loaded from: classes4.dex */
public final class h implements g, InterfaceC0184k {

    /* renamed from: a, reason: collision with root package name */
    public final String f6995a;
    public final o b;
    public final int c;
    public final List d;
    public final HashSet e;
    public final String[] f;
    public final g[] g;
    public final List[] h;
    public final boolean[] i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f6996j;
    public final g[] k;
    public final C7.f l;

    public h(String serialName, o oVar, int i, List typeParameters, C2199a c2199a) {
        kotlin.jvm.internal.k.f(serialName, "serialName");
        kotlin.jvm.internal.k.f(typeParameters, "typeParameters");
        this.f6995a = serialName;
        this.b = oVar;
        this.c = i;
        this.d = c2199a.b;
        ArrayList arrayList = c2199a.c;
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        HashSet hashSet = new HashSet(kotlin.collections.a.P(w.c0(arrayList, 12)));
        v.c1(arrayList, hashSet);
        this.e = hashSet;
        int i6 = 0;
        this.f = (String[]) arrayList.toArray(new String[0]);
        this.g = T.c(c2199a.e);
        this.h = (List[]) c2199a.f.toArray(new List[0]);
        ArrayList arrayList2 = c2199a.g;
        kotlin.jvm.internal.k.f(arrayList2, "<this>");
        boolean[] zArr = new boolean[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            zArr[i6] = ((Boolean) it.next()).booleanValue();
            i6++;
        }
        this.i = zArr;
        String[] strArr = this.f;
        kotlin.jvm.internal.k.f(strArr, "<this>");
        s sVar = new s(new D6.i(strArr, 1), 5);
        ArrayList arrayList3 = new ArrayList(w.c0(sVar, 10));
        Iterator it2 = sVar.iterator();
        while (true) {
            E e = (E) it2;
            if (!e.b.hasNext()) {
                this.f6996j = kotlin.collections.a.X(arrayList3);
                this.k = T.c(typeParameters);
                this.l = kotlin.a.a(new i9.l(this, 8));
                return;
            }
            D d = (D) e.next();
            arrayList3.add(new Pair(d.b, Integer.valueOf(d.f393a)));
        }
    }

    @Override // B9.InterfaceC0184k
    public final Set a() {
        return this.e;
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        Integer num = (Integer) this.f6996j.get(name);
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
        return this.f[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            g gVar = (g) obj;
            if (kotlin.jvm.internal.k.b(this.f6995a, gVar.h()) && Arrays.equals(this.k, ((h) obj).k)) {
                int iD = gVar.d();
                int i = this.c;
                if (i == iD) {
                    for (int i6 = 0; i6 < i; i6++) {
                        g[] gVarArr = this.g;
                        if (kotlin.jvm.internal.k.b(gVarArr[i6].h(), gVar.g(i6).h()) && kotlin.jvm.internal.k.b(gVarArr[i6].getKind(), gVar.g(i6).getKind())) {
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
        return this.h[i];
    }

    @Override // z9.g
    public final g g(int i) {
        return this.g[i];
    }

    @Override // z9.g
    public final List getAnnotations() {
        return this.d;
    }

    @Override // z9.g
    public final o getKind() {
        return this.b;
    }

    @Override // z9.g
    public final String h() {
        return this.f6995a;
    }

    public final int hashCode() {
        return ((Number) this.l.getF4884a()).intValue();
    }

    @Override // z9.g
    public final boolean i(int i) {
        return this.i[i];
    }

    public final String toString() {
        return v.I0(AbstractC1451a.X(0, this.c), ", ", B7.a.g('(', this.f6995a, new StringBuilder()), ")", new com.stepos.taskrobot.llmapi.stepfun.g(this, 17), 24);
    }
}
