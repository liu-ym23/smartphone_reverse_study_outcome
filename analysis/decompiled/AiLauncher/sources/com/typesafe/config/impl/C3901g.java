package com.typesafe.config.impl;

import b8.InterfaceC1461g;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.typesafe.config.impl.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3901g extends AbstractC3897c implements T, H {

    /* renamed from: c, reason: collision with root package name */
    public final List<AbstractConfigValue> f31855c;

    public C3901g(b8.k kVar, List<AbstractConfigValue> list) {
        super(kVar);
        this.f31855c = list;
        if (list.isEmpty()) {
            throw new ConfigException.BugOrBroken("creating empty delayed merge object");
        }
        if (!(list.get(0) instanceof AbstractC3897c)) {
            throw new ConfigException.BugOrBroken("created a delayed merge object not guaranteed to be an object");
        }
        for (AbstractConfigValue abstractConfigValue : list) {
            if ((abstractConfigValue instanceof C3900f) || (abstractConfigValue instanceof C3901g)) {
                throw new ConfigException.BugOrBroken("placed nested DelayedMerge in a ConfigDelayedMergeObject, should have consolidated stack");
            }
        }
    }

    public static ConfigException N0() {
        return new ConfigException.NotResolved("need to Config#resolve() before using this object, see the API docs for Config#resolve()");
    }

    @Override // com.typesafe.config.impl.T
    public Collection<AbstractConfigValue> G() {
        return this.f31855c;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public final C3901g W(AbstractConfigValue abstractConfigValue) {
        i0();
        return (C3901g) X(this.f31855c, abstractConfigValue);
    }

    @Override // com.typesafe.config.impl.AbstractC3897c
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public final C3901g Y(AbstractC3897c abstractC3897c) {
        return W(abstractC3897c);
    }

    @Override // com.typesafe.config.impl.x
    public AbstractConfigValue L(AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        List<AbstractConfigValue> listH0 = AbstractConfigValue.h0(this.f31855c, abstractConfigValue, abstractConfigValue2);
        if (listH0 == null) {
            return null;
        }
        return new C3901g(e(), listH0);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public final C3901g a0(T t10) {
        i0();
        return (C3901g) b0(this.f31855c, t10);
    }

    @Override // com.typesafe.config.impl.AbstractC3897c
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public C3901g x0(ResolveStatus resolveStatus, b8.k kVar) {
        if (resolveStatus == j0()) {
            return new C3901g(kVar, this.f31855c);
        }
        throw new ConfigException.BugOrBroken("attempt to create resolved ConfigDelayedMergeObject");
    }

    @Override // com.typesafe.config.impl.H
    public AbstractConfigValue N(I i10, int i11) {
        return C3900f.q0(i10, this.f31855c, i11);
    }

    @Override // com.typesafe.config.impl.AbstractC3897c, com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public C3901g e0(D d10) {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractConfigValue> it = this.f31855c.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().e0(d10));
        }
        return new C3901g(e(), arrayList);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof C3901g;
    }

    @Override // com.typesafe.config.impl.AbstractC3897c, com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: P0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C3901g n0(b8.i iVar) {
        return (C3901g) super.n0(iVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean U() {
        return C3900f.x0(this.f31855c);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        throw N0();
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw N0();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, b8.p>> entrySet() {
        throw N0();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        List<AbstractConfigValue> list;
        List<AbstractConfigValue> list2;
        return (obj instanceof C3901g) && P(obj) && ((list = this.f31855c) == (list2 = ((C3901g) obj).f31855c) || list.equals(list2));
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        g0(sb2, i10, z10, null, nVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void g0(StringBuilder sb2, int i10, boolean z10, String str, b8.n nVar) {
        C3900f.v0(this.f31855c, sb2, i10, z10, str, nVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return this.f31855c.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        throw N0();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public ResolveStatus j0() {
        return ResolveStatus.UNRESOLVED;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public K<? extends AbstractC3897c> k0(I i10, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        return C3900f.w0(this, this.f31855c, i10, l10).a();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        throw N0();
    }

    @Override // com.typesafe.config.impl.AbstractC3897c
    public AbstractConfigValue q0(String str) {
        for (AbstractConfigValue abstractConfigValue : this.f31855c) {
            if (!(abstractConfigValue instanceof AbstractC3897c)) {
                if (!(abstractConfigValue instanceof T)) {
                    if (abstractConfigValue.j0() != ResolveStatus.UNRESOLVED) {
                        if (abstractConfigValue.U()) {
                            return null;
                        }
                        throw new ConfigException.BugOrBroken("resolved non-object should ignore fallbacks");
                    }
                    if (abstractConfigValue instanceof InterfaceC1461g) {
                        return null;
                    }
                    throw new ConfigException.BugOrBroken("Expecting a list here, not " + abstractConfigValue);
                }
                throw new ConfigException.NotResolved("Key '" + str + "' is not available at '" + e().description() + "' because value at '" + abstractConfigValue.e().description() + "' has not been resolved and may turn out to contain or hide '" + str + "'. Be sure to Config#resolve() before using a config object.");
            }
            AbstractConfigValue abstractConfigValueQ0 = ((AbstractC3897c) abstractConfigValue).q0(str);
            if (abstractConfigValueQ0 != null) {
                if (abstractConfigValueQ0.U()) {
                    return abstractConfigValueQ0;
                }
            } else if (abstractConfigValue instanceof T) {
                throw new ConfigException.BugOrBroken("should not be reached: unmergeable object returned null value");
            }
        }
        throw new ConfigException.BugOrBroken("Delayed merge stack does not contain any unmergeable values");
    }

    @Override // com.typesafe.config.impl.AbstractC3897c, b8.j, java.util.Map
    /* renamed from: s0 */
    public AbstractConfigValue get(Object obj) {
        throw N0();
    }

    @Override // java.util.Map
    public int size() {
        throw N0();
    }

    @Override // java.util.Map
    public Collection<b8.p> values() {
        throw N0();
    }

    @Override // com.typesafe.config.impl.x
    public boolean x(AbstractConfigValue abstractConfigValue) {
        return AbstractConfigValue.S(this.f31855c, abstractConfigValue);
    }

    @Override // b8.p
    public Map<String, Object> a() {
        throw N0();
    }
}
