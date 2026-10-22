package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public final J f31752a;

    /* renamed from: b, reason: collision with root package name */
    public final com.typesafe.config.b f31753b;

    /* renamed from: c, reason: collision with root package name */
    public final D f31754c;

    /* renamed from: d, reason: collision with root package name */
    public final List<AbstractConfigValue> f31755d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<AbstractConfigValue> f31756e;

    public I(J j10, com.typesafe.config.b bVar, D d10, List<AbstractConfigValue> list, Set<AbstractConfigValue> set) {
        this.f31752a = j10;
        this.f31753b = bVar;
        this.f31754c = d10;
        this.f31755d = list;
        this.f31756e = set;
    }

    public static Set<AbstractConfigValue> e() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static AbstractConfigValue k(AbstractConfigValue abstractConfigValue, AbstractC3897c abstractC3897c, com.typesafe.config.b bVar) {
        try {
            return new I(bVar, null).l(abstractConfigValue, new L(abstractC3897c)).f31759b;
        } catch (AbstractConfigValue.NotPossibleToResolve e10) {
            throw new ConfigException.BugOrBroken("NotPossibleToResolve was thrown from an outermost resolve", e10);
        }
    }

    public I a(AbstractConfigValue abstractConfigValue) {
        if (C3903i.C()) {
            C3903i.z(b(), "++ Cycle marker " + abstractConfigValue + "@" + System.identityHashCode(abstractConfigValue));
        }
        if (this.f31756e.contains(abstractConfigValue)) {
            throw new ConfigException.BugOrBroken("Added cycle marker twice " + abstractConfigValue);
        }
        Set<AbstractConfigValue> setE = e();
        setE.addAll(this.f31756e);
        setE.add(abstractConfigValue);
        return new I(this.f31752a, this.f31753b, this.f31754c, this.f31755d, setE);
    }

    public int b() {
        if (this.f31755d.size() <= 30) {
            return this.f31755d.size();
        }
        throw new ConfigException.BugOrBroken("resolve getting too deep");
    }

    public boolean c() {
        return this.f31754c != null;
    }

    public final I d(A a10, AbstractConfigValue abstractConfigValue) {
        return new I(this.f31752a.b(a10, abstractConfigValue), this.f31753b, this.f31754c, this.f31755d, this.f31756e);
    }

    public com.typesafe.config.b f() {
        return this.f31753b;
    }

    public I g() {
        ArrayList arrayList = new ArrayList(this.f31755d);
        AbstractConfigValue abstractConfigValue = (AbstractConfigValue) arrayList.remove(this.f31755d.size() - 1);
        if (C3903i.C()) {
            C3903i.z(b() - 1, "popped trace " + abstractConfigValue);
        }
        return new I(this.f31752a, this.f31753b, this.f31754c, arrayList, this.f31756e);
    }

    public final I h(AbstractConfigValue abstractConfigValue) {
        if (C3903i.C()) {
            C3903i.z(b(), "pushing trace " + abstractConfigValue);
        }
        ArrayList arrayList = new ArrayList(this.f31755d);
        arrayList.add(abstractConfigValue);
        return new I(this.f31752a, this.f31753b, this.f31754c, arrayList, this.f31756e);
    }

    public final K<? extends AbstractConfigValue> i(AbstractConfigValue abstractConfigValue, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        I iD;
        A a10 = null;
        A a11 = new A(abstractConfigValue, null);
        AbstractConfigValue abstractConfigValueA = this.f31752a.a(a11);
        if (abstractConfigValueA == null && c()) {
            a10 = new A(abstractConfigValue, n());
            abstractConfigValueA = this.f31752a.a(a10);
        }
        if (abstractConfigValueA != null) {
            if (C3903i.C()) {
                C3903i.z(b(), "using cached resolution " + abstractConfigValueA + " for " + abstractConfigValue + " restrictToChild " + n());
            }
            return K.b(this, abstractConfigValueA);
        }
        if (C3903i.C()) {
            C3903i.z(b(), "not found in cache, resolving " + abstractConfigValue + "@" + System.identityHashCode(abstractConfigValue));
        }
        if (this.f31756e.contains(abstractConfigValue)) {
            if (C3903i.C()) {
                C3903i.z(b(), "Cycle detected, can't resolve; " + abstractConfigValue + "@" + System.identityHashCode(abstractConfigValue));
            }
            throw new AbstractConfigValue.NotPossibleToResolve(this);
        }
        K<? extends AbstractConfigValue> kK0 = abstractConfigValue.k0(this, l10);
        AbstractConfigValue abstractConfigValue2 = kK0.f31759b;
        if (C3903i.C()) {
            C3903i.z(b(), "resolved to " + abstractConfigValue2 + "@" + System.identityHashCode(abstractConfigValue2) + " from " + abstractConfigValue + "@" + System.identityHashCode(abstractConfigValue2));
        }
        I i10 = kK0.f31758a;
        if (abstractConfigValue2 == null || abstractConfigValue2.j0() == ResolveStatus.RESOLVED) {
            if (C3903i.C()) {
                C3903i.z(b(), "caching " + a11 + " result " + abstractConfigValue2);
            }
            iD = i10.d(a11, abstractConfigValue2);
        } else if (c()) {
            if (a10 == null) {
                throw new ConfigException.BugOrBroken("restrictedKey should not be null here");
            }
            if (C3903i.C()) {
                C3903i.z(b(), "caching " + a10 + " result " + abstractConfigValue2);
            }
            iD = i10.d(a10, abstractConfigValue2);
        } else {
            if (!f().b()) {
                throw new ConfigException.BugOrBroken("resolveSubstitutions() did not give us a resolved object");
            }
            if (C3903i.C()) {
                C3903i.z(b(), "caching " + a11 + " result " + abstractConfigValue2);
            }
            iD = i10.d(a11, abstractConfigValue2);
        }
        return K.b(iD, abstractConfigValue2);
    }

    public I j(AbstractConfigValue abstractConfigValue) {
        if (C3903i.C()) {
            C3903i.z(b(), "-- Cycle marker " + abstractConfigValue + "@" + System.identityHashCode(abstractConfigValue));
        }
        Set<AbstractConfigValue> setE = e();
        setE.addAll(this.f31756e);
        setE.remove(abstractConfigValue);
        return new I(this.f31752a, this.f31753b, this.f31754c, this.f31755d, setE);
    }

    public K<? extends AbstractConfigValue> l(AbstractConfigValue abstractConfigValue, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        if (C3903i.C()) {
            C3903i.z(b(), "resolving " + abstractConfigValue + " restrictToChild=" + this.f31754c + " in " + l10);
        }
        return h(abstractConfigValue).i(abstractConfigValue, l10).c();
    }

    public I m(D d10) {
        return d10 == this.f31754c ? this : new I(this.f31752a, this.f31753b, d10, this.f31755d, this.f31756e);
    }

    public D n() {
        return this.f31754c;
    }

    public String o() {
        StringBuilder sb2 = new StringBuilder();
        for (AbstractConfigValue abstractConfigValue : this.f31755d) {
            if (abstractConfigValue instanceof w) {
                sb2.append(((w) abstractConfigValue).q0().toString());
                sb2.append(", ");
            }
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 2);
        }
        return sb2.toString();
    }

    public I p() {
        return m(null);
    }

    public I(com.typesafe.config.b bVar, D d10) {
        this(new J(), bVar, d10, new ArrayList(), e());
        if (C3903i.C()) {
            C3903i.z(b(), "ResolveContext restrict to child " + d10);
        }
    }
}
