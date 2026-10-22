package W9;

import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5685n;

/* renamed from: W9.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1093b implements InterfaceC1094c {

    /* renamed from: a, reason: collision with root package name */
    public final Z9.g f6720a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5074l<Z9.q, Boolean> f6721b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5074l<Z9.r, Boolean> f6722c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<ga.e, List<Z9.r>> f6723d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<ga.e, Z9.n> f6724e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<ga.e, Z9.w> f6725f;

    /* JADX WARN: Multi-variable type inference failed */
    public C1093b(Z9.g jClass, InterfaceC5074l<? super Z9.q, Boolean> memberFilter) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        kotlin.jvm.internal.p.i(memberFilter, "memberFilter");
        this.f6720a = jClass;
        this.f6721b = memberFilter;
        C1092a c1092a = new C1092a(this);
        this.f6722c = c1092a;
        Ka.j jVarF = SequencesKt___SequencesKt.F(Z8.F.d0(jClass.z()), c1092a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : jVarF) {
            ga.e name = ((Z9.r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f6723d = linkedHashMap;
        Ka.j jVarF2 = SequencesKt___SequencesKt.F(Z8.F.d0(this.f6720a.getFields()), this.f6721b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : jVarF2) {
            linkedHashMap2.put(((Z9.n) obj2).getName(), obj2);
        }
        this.f6724e = linkedHashMap2;
        Collection<Z9.w> collectionM = this.f6720a.m();
        InterfaceC5074l<Z9.q, Boolean> interfaceC5074l = this.f6721b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionM) {
            if (((Boolean) interfaceC5074l.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((Z9.w) obj4).getName(), obj4);
        }
        this.f6725f = linkedHashMap3;
    }

    public static final boolean h(C1093b c1093b, Z9.r m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        return c1093b.f6721b.invoke(m10).booleanValue() && !Z9.p.c(m10);
    }

    @Override // W9.InterfaceC1094c
    public Z9.w a(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return this.f6725f.get(name);
    }

    @Override // W9.InterfaceC1094c
    public Set<ga.e> b() {
        Ka.j jVarF = SequencesKt___SequencesKt.F(Z8.F.d0(this.f6720a.z()), this.f6722c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = jVarF.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((Z9.r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // W9.InterfaceC1094c
    public Set<ga.e> c() {
        return this.f6725f.keySet();
    }

    @Override // W9.InterfaceC1094c
    public Set<ga.e> d() {
        Ka.j jVarF = SequencesKt___SequencesKt.F(Z8.F.d0(this.f6720a.getFields()), this.f6721b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = jVarF.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((Z9.n) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // W9.InterfaceC1094c
    public Z9.n e(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return this.f6724e.get(name);
    }

    @Override // W9.InterfaceC1094c
    public Collection<Z9.r> f(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        List<Z9.r> list = this.f6723d.get(name);
        return list != null ? list : C1173v.m();
    }
}
