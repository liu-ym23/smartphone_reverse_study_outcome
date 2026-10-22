package rc;

import androidx.lifecycle.j0;
import fc.n;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import mb.m;
import mb.s;
import tc.k;
import tc.p0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements e, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f11786a;

    /* renamed from: b, reason: collision with root package name */
    public final i f11787b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11788c;

    /* renamed from: d, reason: collision with root package name */
    public final List<Annotation> f11789d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f11790e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f11791f;

    /* renamed from: g, reason: collision with root package name */
    public final e[] f11792g;
    public final List<Annotation>[] h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean[] f11793i;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, Integer> f11794j;

    /* renamed from: k, reason: collision with root package name */
    public final e[] f11795k;

    /* renamed from: l, reason: collision with root package name */
    public final lb.d f11796l;

    public f(String str, i kind, int i10, List<? extends e> typeParameters, a aVar) {
        kotlin.jvm.internal.g.f(kind, "kind");
        kotlin.jvm.internal.g.f(typeParameters, "typeParameters");
        this.f11786a = str;
        this.f11787b = kind;
        this.f11788c = i10;
        this.f11789d = aVar.f11770b;
        ArrayList arrayList = aVar.f11771c;
        this.f11790e = kotlin.collections.a.M0(arrayList);
        int i11 = 0;
        this.f11791f = (String[]) arrayList.toArray(new String[0]);
        this.f11792g = p0.c(aVar.f11773e);
        this.h = (List[]) aVar.f11774f.toArray(new List[0]);
        ArrayList arrayList2 = aVar.f11775g;
        kotlin.jvm.internal.g.f(arrayList2, "<this>");
        boolean[] zArr = new boolean[arrayList2.size()];
        int size = arrayList2.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList2.get(i12);
            i12++;
            zArr[i11] = ((Boolean) obj).booleanValue();
            i11++;
        }
        this.f11793i = zArr;
        String[] strArr = this.f11791f;
        kotlin.jvm.internal.g.f(strArr, "<this>");
        n nVar = new n(new b6.g(strArr, 15), 1);
        ArrayList arrayList3 = new ArrayList(m.Z(nVar, 10));
        Iterator it = nVar.iterator();
        while (true) {
            kotlin.jvm.internal.a aVar2 = (kotlin.jvm.internal.a) it;
            if (!((Iterator) aVar2.f10079c).hasNext()) {
                this.f11794j = kotlin.collections.b.m0(arrayList3);
                this.f11795k = p0.c(typeParameters);
                this.f11796l = kotlin.b.b(new j0(this, 11));
                return;
            }
            s sVar = (s) aVar2.next();
            arrayList3.add(new Pair(sVar.f10563b, Integer.valueOf(sVar.f10562a)));
        }
    }

    @Override // tc.k
    public final Set<String> a() {
        return this.f11790e;
    }

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        Integer num = this.f11794j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // rc.e
    public final i d() {
        return this.f11787b;
    }

    @Override // rc.e
    public final int e() {
        return this.f11788c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            e eVar = (e) obj;
            if (this.f11786a.equals(eVar.i()) && Arrays.equals(this.f11795k, ((f) obj).f11795k)) {
                int iE = eVar.e();
                int i10 = this.f11788c;
                if (i10 == iE) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        e[] eVarArr = this.f11792g;
                        if (kotlin.jvm.internal.g.b(eVarArr[i11].i(), eVar.h(i11).i()) && kotlin.jvm.internal.g.b(eVarArr[i11].d(), eVar.h(i11).d())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // rc.e
    public final String f(int i10) {
        return this.f11791f[i10];
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        return this.h[i10];
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return this.f11789d;
    }

    @Override // rc.e
    public final e h(int i10) {
        return this.f11792g[i10];
    }

    public final int hashCode() {
        return ((Number) this.f11796l.getValue()).intValue();
    }

    @Override // rc.e
    public final String i() {
        return this.f11786a;
    }

    @Override // rc.e
    public final boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        return this.f11793i[i10];
    }

    public final String toString() {
        return kotlin.collections.a.z0(dc.h.e0(0, this.f11788c), ", ", this.f11786a.concat("("), ")", new androidx.compose.runtime.i(this, 12), 24);
    }
}
