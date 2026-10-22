package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;

/* loaded from: classes4.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC3897c f31760a;

    /* renamed from: b, reason: collision with root package name */
    public final a<x> f31761b;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final K<? extends AbstractConfigValue> f31764a;

        /* renamed from: b, reason: collision with root package name */
        public final a<x> f31765b;

        public b(K<? extends AbstractConfigValue> k10, a<x> aVar) {
            this.f31764a = k10;
            this.f31765b = aVar;
        }

        public String toString() {
            return "ResultWithPath(result=" + this.f31764a + ", pathFromRoot=" + this.f31765b + ")";
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractConfigValue f31766a;

        /* renamed from: b, reason: collision with root package name */
        public final a<x> f31767b;

        public c(AbstractConfigValue abstractConfigValue, a<x> aVar) {
            this.f31766a = abstractConfigValue;
            this.f31767b = aVar;
        }

        public String toString() {
            return "ValueWithPath(value=" + this.f31766a + ", pathFromRoot=" + this.f31767b + ")";
        }
    }

    public L(AbstractC3897c abstractC3897c, a<x> aVar) {
        this.f31760a = abstractC3897c;
        this.f31761b = aVar;
    }

    public static b a(AbstractC3897c abstractC3897c, I i10, D d10) throws AbstractConfigValue.NotPossibleToResolve {
        if (C3903i.C()) {
            C3903i.A("*** finding '" + d10 + "' in " + abstractC3897c);
        }
        D dN = i10.n();
        K<? extends AbstractConfigValue> kL = i10.m(d10).l(abstractC3897c, new L(abstractC3897c));
        I iM = kL.f31758a.m(dN);
        V v10 = kL.f31759b;
        if (v10 instanceof AbstractC3897c) {
            c cVarB = b((AbstractC3897c) v10, d10);
            return new b(K.b(iM, cVarB.f31766a), cVarB.f31767b);
        }
        throw new ConfigException.BugOrBroken("resolved object to non-object " + abstractC3897c + " to " + kL);
    }

    public static c b(AbstractC3897c abstractC3897c, D d10) {
        try {
            return c(abstractC3897c, d10, null);
        } catch (ConfigException.NotResolved e10) {
            throw C3903i.p(d10, e10);
        }
    }

    public static c c(AbstractC3897c abstractC3897c, D d10, a<x> aVar) {
        String strB = d10.b();
        D dJ = d10.j();
        if (C3903i.C()) {
            C3903i.A("*** looking up '" + strB + "' in " + abstractC3897c);
        }
        AbstractConfigValue abstractConfigValueQ0 = abstractC3897c.q0(strB);
        a<x> aVar2 = aVar == null ? new a<>(abstractC3897c) : aVar.c(abstractC3897c);
        return dJ == null ? new c(abstractConfigValueQ0, aVar2) : abstractConfigValueQ0 instanceof AbstractC3897c ? c((AbstractC3897c) abstractConfigValueQ0, dJ, aVar2) : new c(null, aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a<x> f(a<x> aVar, x xVar, AbstractConfigValue abstractConfigValue) {
        x xVarA = aVar.a();
        if (xVarA != xVar) {
            throw new ConfigException.BugOrBroken("Can only replace() the top node we're resolving; had " + xVarA + " on top and tried to replace " + xVar + " overall list was " + aVar);
        }
        x xVarA2 = aVar.e() == null ? null : aVar.e().a();
        if (abstractConfigValue == 0 || !(abstractConfigValue instanceof x)) {
            if (xVarA2 == null) {
                return null;
            }
            return f(aVar.e(), xVarA2, xVarA2.L((AbstractConfigValue) xVar, null));
        }
        if (xVarA2 == null) {
            return new a<>((x) abstractConfigValue);
        }
        a<x> aVarF = f(aVar.e(), xVarA2, xVarA2.L((AbstractConfigValue) xVar, abstractConfigValue));
        return aVarF != null ? aVarF.c((x) abstractConfigValue) : new a<>((x) abstractConfigValue);
    }

    public b d(I i10, P p10, int i11) throws AbstractConfigValue.NotPossibleToResolve {
        if (C3903i.C()) {
            C3903i.z(i10.b(), "searching for " + p10);
        }
        if (C3903i.C()) {
            C3903i.z(i10.b(), p10 + " - looking up relative to file it occurred in");
        }
        b bVarA = a(this.f31760a, i10, p10.c());
        if (bVarA.f31764a.f31759b == 0) {
            D dL = p10.c().l(i11);
            if (i11 > 0) {
                if (C3903i.C()) {
                    C3903i.z(bVarA.f31764a.f31758a.b(), dL + " - looking up relative to parent file");
                }
                bVarA = a(this.f31760a, bVarA.f31764a.f31758a, dL);
            }
            K<? extends AbstractConfigValue> k10 = bVarA.f31764a;
            if (k10.f31759b == 0 && k10.f31758a.f().d()) {
                if (C3903i.C()) {
                    C3903i.z(bVarA.f31764a.f31758a.b(), dL + " - looking up in system environment");
                }
                bVarA = a(C3903i.k(), i10, dL);
            }
        }
        if (C3903i.C()) {
            C3903i.z(bVarA.f31764a.f31758a.b(), "resolved to " + bVarA);
        }
        return bVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public L e(x xVar) {
        if (xVar == 0) {
            throw new ConfigException.BugOrBroken("can't push null parent");
        }
        if (C3903i.C()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("pushing parent ");
            sb2.append(xVar);
            sb2.append(" ==root ");
            sb2.append(xVar == this.f31760a);
            sb2.append(" onto ");
            sb2.append(this);
            C3903i.A(sb2.toString());
        }
        a<x> aVar = this.f31761b;
        if (aVar != null) {
            x xVarA = aVar.a();
            if (C3903i.C() && xVarA != null && !xVarA.x((AbstractConfigValue) xVar)) {
                C3903i.A("***** BUG ***** trying to push non-child of " + xVarA + ", non-child was " + xVar);
            }
            return new L(this.f31760a, this.f31761b.c(xVar));
        }
        AbstractC3897c abstractC3897c = this.f31760a;
        if (xVar == abstractC3897c) {
            return new L(abstractC3897c, new a(xVar));
        }
        if (C3903i.C() && this.f31760a.x((AbstractConfigValue) xVar)) {
            C3903i.A("***** BUG ***** tried to push parent " + xVar + " without having a path to it in " + this);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public L g(x xVar, x xVar2) {
        if (C3903i.C()) {
            C3903i.A("replaceCurrentParent old " + xVar + "@" + System.identityHashCode(xVar) + " replacement " + xVar2 + "@" + System.identityHashCode(xVar) + " in " + this);
        }
        if (xVar == xVar2) {
            return this;
        }
        a<x> aVar = this.f31761b;
        if (aVar == null) {
            if (xVar == this.f31760a) {
                return new L(j(xVar2));
            }
            throw new ConfigException.BugOrBroken("attempt to replace root " + this.f31760a + " with " + xVar2);
        }
        a<x> aVarF = f(aVar, xVar, (AbstractConfigValue) xVar2);
        if (C3903i.C()) {
            C3903i.A("replaced " + xVar + " with " + xVar2 + " in " + this);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("path was: ");
            sb2.append(this.f31761b);
            sb2.append(" is now ");
            sb2.append(aVarF);
            C3903i.A(sb2.toString());
        }
        return aVarF != null ? new L((AbstractC3897c) aVarF.b(), aVarF) : new L(SimpleConfigObject.J0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public L h(AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        if (C3903i.C()) {
            C3903i.A("replaceWithinCurrentParent old " + abstractConfigValue + "@" + System.identityHashCode(abstractConfigValue) + " replacement " + abstractConfigValue2 + "@" + System.identityHashCode(abstractConfigValue) + " in " + this);
        }
        if (abstractConfigValue == abstractConfigValue2) {
            return this;
        }
        a<x> aVar = this.f31761b;
        if (aVar != null) {
            x xVarA = aVar.a();
            b8.p pVarL = xVarA.L(abstractConfigValue, abstractConfigValue2);
            return g(xVarA, pVarL instanceof x ? (x) pVarL : null);
        }
        if (abstractConfigValue == this.f31760a && (abstractConfigValue2 instanceof x)) {
            return new L(j((x) abstractConfigValue2));
        }
        throw new ConfigException.BugOrBroken("replace in parent not possible " + abstractConfigValue + " with " + abstractConfigValue2 + " in " + this);
    }

    public L i() {
        return this.f31761b == null ? this : new L(this.f31760a);
    }

    public final AbstractC3897c j(x xVar) {
        return xVar instanceof AbstractC3897c ? (AbstractC3897c) xVar : SimpleConfigObject.J0();
    }

    public String toString() {
        return "ResolveSource(root=" + this.f31760a + ", pathFromRoot=" + this.f31761b + ")";
    }

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f31762a;

        /* renamed from: b, reason: collision with root package name */
        public final a<T> f31763b;

        public a(T t10, a<T> aVar) {
            this.f31762a = t10;
            this.f31763b = aVar;
        }

        public T a() {
            return this.f31762a;
        }

        public T b() {
            while (true) {
                a<T> aVar = this.f31763b;
                if (aVar == null) {
                    return this.f31762a;
                }
                this = aVar;
            }
        }

        public a<T> c(T t10) {
            return new a<>(t10, this);
        }

        public a<T> d() {
            if (this.f31763b == null) {
                return this;
            }
            a<T> aVar = new a<>(this.f31762a);
            for (a<T> aVar2 = this.f31763b; aVar2 != null; aVar2 = aVar2.f31763b) {
                aVar = aVar.c(aVar2.f31762a);
            }
            return aVar;
        }

        public a<T> e() {
            return this.f31763b;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            for (a<T> aVarD = d(); aVarD != null; aVarD = aVarD.f31763b) {
                stringBuffer.append(aVarD.f31762a.toString());
                if (aVarD.f31763b != null) {
                    stringBuffer.append(" <= ");
                }
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        }

        public a(T t10) {
            this(t10, null);
        }
    }

    public L(AbstractC3897c abstractC3897c) {
        this.f31760a = abstractC3897c;
        this.f31761b = null;
    }
}
