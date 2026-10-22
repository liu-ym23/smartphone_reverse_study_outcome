package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.L;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class w extends AbstractConfigValue implements T {

    /* renamed from: b, reason: collision with root package name */
    public final P f31903b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31904c;

    public w(b8.k kVar, P p10) {
        this(kVar, p10, 0);
    }

    private ConfigException.NotResolved s0() {
        return new ConfigException.NotResolved("need to Config#resolve(), see the API docs for Config#resolve(); substitution not resolved: " + this);
    }

    @Override // com.typesafe.config.impl.T
    public Collection<w> G() {
        return Collections.singleton(this);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof w;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean U() {
        return false;
    }

    @Override // b8.p
    public Object a() {
        throw s0();
    }

    @Override // b8.p
    public ConfigValueType c() {
        throw s0();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        return (obj instanceof w) && P(obj) && this.f31903b.equals(((w) obj).f31903b);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        sb2.append(this.f31903b.toString());
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return this.f31903b.hashCode();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public ResolveStatus j0() {
        return ResolveStatus.UNRESOLVED;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public K<? extends AbstractConfigValue> k0(I i10, L l10) {
        AbstractConfigValue abstractConfigValue;
        I iA = i10.a(this);
        try {
            L.b bVarD = l10.d(iA, this.f31903b, this.f31904c);
            K<? extends AbstractConfigValue> k10 = bVarD.f31764a;
            iA = k10.f31758a;
            if (k10.f31759b != 0) {
                if (C3903i.C()) {
                    C3903i.z(iA.b(), "recursively resolving " + bVarD + " which was the resolution of " + this.f31903b + " against " + l10);
                }
                L l11 = new L((AbstractC3897c) bVarD.f31765b.b(), bVarD.f31765b);
                if (C3903i.C()) {
                    C3903i.z(iA.b(), "will recursively resolve against " + l11);
                }
                K<? extends AbstractConfigValue> kL = iA.l(bVarD.f31764a.f31759b, l11);
                abstractConfigValue = kL.f31759b;
                iA = kL.f31758a;
            } else {
                abstractConfigValue = (V) i10.f().c().a(this.f31903b.c().k());
            }
        } catch (AbstractConfigValue.NotPossibleToResolve e10) {
            if (C3903i.C()) {
                C3903i.z(iA.b(), "not possible to resolve " + this.f31903b + ", cycle involved: " + e10.a());
            }
            if (!this.f31903b.b()) {
                throw new ConfigException.UnresolvedSubstitution(e(), this.f31903b + " was part of a cycle of substitutions involving " + e10.a(), e10);
            }
            abstractConfigValue = null;
        }
        if (abstractConfigValue != null || this.f31903b.b()) {
            return K.b(iA.j(this), abstractConfigValue);
        }
        if (iA.f().b()) {
            return K.b(iA.j(this), this);
        }
        throw new ConfigException.UnresolvedSubstitution(e(), this.f31903b.toString());
    }

    public P q0() {
        return this.f31903b;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public w c0(b8.k kVar) {
        return new w(kVar, this.f31903b, this.f31904c);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public w e0(D d10) {
        P p10 = this.f31903b;
        return new w(e(), p10.a(p10.c().i(d10)), this.f31904c + d10.e());
    }

    public w(b8.k kVar, P p10, int i10) {
        super(kVar);
        this.f31903b = p10;
        this.f31904c = i10;
    }
}
