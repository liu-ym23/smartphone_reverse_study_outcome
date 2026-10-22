package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class AbstractConfigValue implements b8.p, B {

    /* renamed from: a, reason: collision with root package name */
    public final M f31722a;

    public static class NotPossibleToResolve extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final String f31723a;

        public NotPossibleToResolve(I i10) {
            super("was not possible to resolve");
            this.f31723a = i10.o();
        }

        public String a() {
            return this.f31723a;
        }
    }

    public interface a {
        AbstractConfigValue a(String str, AbstractConfigValue abstractConfigValue) throws Exception;
    }

    public abstract class b implements a {
        public b() {
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue.a
        public final AbstractConfigValue a(String str, AbstractConfigValue abstractConfigValue) throws Exception {
            try {
                return b(str, abstractConfigValue);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new ConfigException.BugOrBroken("Unexpected exception", e11);
            }
        }

        public abstract AbstractConfigValue b(String str, AbstractConfigValue abstractConfigValue);
    }

    public AbstractConfigValue(b8.k kVar) {
        this.f31722a = (M) kVar;
    }

    public static boolean S(List<AbstractConfigValue> list, AbstractConfigValue abstractConfigValue) {
        Iterator<AbstractConfigValue> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == abstractConfigValue) {
                return true;
            }
        }
        for (b8.p pVar : list) {
            if ((pVar instanceof x) && ((x) pVar).x(abstractConfigValue)) {
                return true;
            }
        }
        return false;
    }

    public static void V(StringBuilder sb2, int i10, b8.n nVar) {
        if (nVar.c()) {
            while (i10 > 0) {
                sb2.append("    ");
                i10--;
            }
        }
    }

    public static List<AbstractConfigValue> h0(List<AbstractConfigValue> list, AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        int i10 = 0;
        while (i10 < list.size() && list.get(i10) != abstractConfigValue) {
            i10++;
        }
        if (i10 == list.size()) {
            throw new ConfigException.BugOrBroken("tried to replace " + abstractConfigValue + " which is not in " + list);
        }
        ArrayList arrayList = new ArrayList(list);
        if (abstractConfigValue2 != null) {
            arrayList.set(i10, abstractConfigValue2);
        } else {
            arrayList.remove(i10);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public void O(StringBuilder sb2) {
        sb2.append("\"<env variable>\"");
    }

    public boolean P(Object obj) {
        return obj instanceof b8.p;
    }

    public AbstractConfigValue Q(b8.k kVar, List<AbstractConfigValue> list) {
        return new C3900f(kVar, list);
    }

    public final AbstractConfigValue R(Collection<AbstractConfigValue> collection, AbstractConfigValue abstractConfigValue) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        arrayList.add(abstractConfigValue);
        return Q(AbstractC3897c.t0(arrayList), arrayList);
    }

    public boolean T(b8.n nVar) {
        return !nVar.f() && this.f31722a.t() == OriginType.ENV_VARIABLE;
    }

    public boolean U() {
        return j0() == ResolveStatus.RESOLVED;
    }

    public AbstractConfigValue W(AbstractConfigValue abstractConfigValue) {
        i0();
        return X(Collections.singletonList(this), abstractConfigValue);
    }

    public final AbstractConfigValue X(Collection<AbstractConfigValue> collection, AbstractConfigValue abstractConfigValue) {
        i0();
        return j0() == ResolveStatus.RESOLVED ? o0() : R(collection, abstractConfigValue);
    }

    public AbstractConfigValue Y(AbstractC3897c abstractC3897c) {
        i0();
        return Z(Collections.singletonList(this), abstractC3897c);
    }

    public final AbstractConfigValue Z(Collection<AbstractConfigValue> collection, AbstractC3897c abstractC3897c) {
        i0();
        if (this instanceof AbstractC3897c) {
            throw new ConfigException.BugOrBroken("Objects must reimplement mergedWithObject");
        }
        return X(collection, abstractC3897c);
    }

    public AbstractConfigValue a0(T t10) {
        i0();
        return b0(Collections.singletonList(this), t10);
    }

    public final AbstractConfigValue b0(Collection<AbstractConfigValue> collection, T t10) {
        i0();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        arrayList.addAll(t10.G());
        return Q(AbstractC3897c.t0(arrayList), arrayList);
    }

    public abstract AbstractConfigValue c0(b8.k kVar);

    @Override // b8.p
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public M e() {
        return this.f31722a;
    }

    public AbstractConfigValue e0(D d10) {
        return this;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof b8.p) && P(obj)) {
            b8.p pVar = (b8.p) obj;
            if (c() == pVar.c() && C3904j.b(a(), pVar.a())) {
                return true;
            }
        }
        return false;
    }

    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        if (T(nVar)) {
            sb2.append("<env variable>");
        } else {
            sb2.append(a().toString());
        }
    }

    public void g0(StringBuilder sb2, int i10, boolean z10, String str, b8.n nVar) {
        if (str != null) {
            sb2.append(nVar.d() ? C3904j.g(str) : C3904j.h(str));
            if (nVar.d()) {
                if (nVar.c()) {
                    sb2.append(" : ");
                } else {
                    sb2.append(ServerSentEventKt.COLON);
                }
            } else if (!(this instanceof b8.j)) {
                sb2.append("=");
            } else if (nVar.c()) {
                sb2.append(' ');
            }
        }
        f0(sb2, i10, z10, nVar);
    }

    public int hashCode() {
        Object objA = a();
        if (objA == null) {
            return 0;
        }
        return objA.hashCode();
    }

    public final void i0() {
        if (U()) {
            throw new ConfigException.BugOrBroken("method should not have been called with ignoresFallbacks=true " + getClass().getSimpleName());
        }
    }

    public ResolveStatus j0() {
        return ResolveStatus.RESOLVED;
    }

    public K<? extends AbstractConfigValue> k0(I i10, L l10) throws NotPossibleToResolve {
        return K.b(i10, this);
    }

    @Override // com.typesafe.config.impl.B
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public AbstractConfigValue v() {
        return this;
    }

    public String m0() {
        return null;
    }

    public AbstractConfigValue n0(b8.i iVar) {
        if (U()) {
            return this;
        }
        b8.p pVarV = ((B) iVar).v();
        return pVarV instanceof T ? a0((T) pVarV) : pVarV instanceof AbstractC3897c ? Y((AbstractC3897c) pVarV) : W((AbstractConfigValue) pVarV);
    }

    public AbstractConfigValue o0() {
        if (U()) {
            return this;
        }
        throw new ConfigException.BugOrBroken("value class doesn't implement forced fallback-ignoring " + this);
    }

    public AbstractConfigValue p0(b8.k kVar) {
        return this.f31722a == kVar ? this : c0(kVar);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        g0(sb2, 0, true, null, b8.n.a());
        return getClass().getSimpleName() + "(" + sb2.toString() + ")";
    }
}
