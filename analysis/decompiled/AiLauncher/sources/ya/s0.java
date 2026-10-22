package ya;

import Z8.C1172u;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

/* loaded from: classes5.dex */
public final class s0 extends Fa.e<q0<?>, q0<?>> implements Iterable<q0<?>>, InterfaceC5162a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f44124b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final s0 f44125c = new s0((List<? extends q0<?>>) C1173v.m());

    public static final class a extends Fa.z<q0<?>, q0<?>> {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        @Override // Fa.z
        public int c(ConcurrentHashMap<String, Integer> concurrentHashMap, String key, InterfaceC5074l<? super String, Integer> compute) {
            int iIntValue;
            kotlin.jvm.internal.p.i(concurrentHashMap, "<this>");
            kotlin.jvm.internal.p.i(key, "key");
            kotlin.jvm.internal.p.i(compute, "compute");
            Integer num = concurrentHashMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                try {
                    Integer num2 = concurrentHashMap.get(key);
                    if (num2 != null) {
                        iIntValue = num2.intValue();
                    } else {
                        Integer numInvoke = compute.invoke(key);
                        concurrentHashMap.putIfAbsent(key, Integer.valueOf(numInvoke.intValue()));
                        iIntValue = numInvoke.intValue();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iIntValue;
        }

        public final s0 j(List<? extends q0<?>> attributes) {
            kotlin.jvm.internal.p.i(attributes, "attributes");
            return attributes.isEmpty() ? k() : new s0(attributes, null);
        }

        public final s0 k() {
            return s0.f44125c;
        }

        public a() {
        }
    }

    public /* synthetic */ s0(List list, kotlin.jvm.internal.i iVar) {
        this((List<? extends q0<?>>) list);
    }

    @Override // Fa.AbstractC0821a
    public Fa.z<q0<?>, q0<?>> c() {
        return f44124b;
    }

    public final s0 k(s0 other) {
        kotlin.jvm.internal.p.i(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f44124b.h().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            q0<?> q0Var = b().get(iIntValue);
            q0<?> q0Var2 = other.b().get(iIntValue);
            Ia.a.a(arrayList, q0Var == null ? q0Var2 != null ? q0Var2.a(q0Var) : null : q0Var.a(q0Var2));
        }
        return f44124b.j(arrayList);
    }

    public final boolean l(q0<?> attribute) {
        kotlin.jvm.internal.p.i(attribute, "attribute");
        return b().get(f44124b.f(attribute.b())) != null;
    }

    public final s0 m(s0 other) {
        kotlin.jvm.internal.p.i(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f44124b.h().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            q0<?> q0Var = b().get(iIntValue);
            q0<?> q0Var2 = other.b().get(iIntValue);
            Ia.a.a(arrayList, q0Var == null ? q0Var2 != null ? q0Var2.c(q0Var) : null : q0Var.c(q0Var2));
        }
        return f44124b.j(arrayList);
    }

    public final s0 n(q0<?> attribute) {
        kotlin.jvm.internal.p.i(attribute, "attribute");
        if (l(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new s0(attribute);
        }
        return f44124b.j(Z8.F.T0(Z8.F.m1(this), attribute));
    }

    public final s0 o(q0<?> attribute) {
        kotlin.jvm.internal.p.i(attribute, "attribute");
        if (!isEmpty()) {
            Fa.c<q0<?>> cVarB = b();
            ArrayList arrayList = new ArrayList();
            for (q0<?> q0Var : cVarB) {
                if (!kotlin.jvm.internal.p.d(q0Var, attribute)) {
                    arrayList.add(q0Var);
                }
            }
            if (arrayList.size() != b().b()) {
                return f44124b.j(arrayList);
            }
        }
        return this;
    }

    public s0(List<? extends q0<?>> list) {
        for (q0<?> q0Var : list) {
            f(q0Var.b(), q0Var);
        }
    }

    public s0(q0<?> q0Var) {
        this((List<? extends q0<?>>) C1172u.e(q0Var));
    }
}
