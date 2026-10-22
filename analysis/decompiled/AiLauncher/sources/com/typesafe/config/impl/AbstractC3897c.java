package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.typesafe.config.impl.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3897c extends AbstractConfigValue implements b8.j, x {

    /* renamed from: b, reason: collision with root package name */
    public final SimpleConfig f31844b;

    public AbstractC3897c(b8.k kVar) {
        super(kVar);
        this.f31844b = new SimpleConfig(this);
    }

    private static UnsupportedOperationException G0(String str) {
        return new UnsupportedOperationException("ConfigObject is immutable, you can't call Map." + str);
    }

    public static b8.k t0(Collection<? extends AbstractConfigValue> collection) {
        if (collection.isEmpty()) {
            throw new ConfigException.BugOrBroken("can't merge origins on empty list");
        }
        ArrayList arrayList = new ArrayList();
        M mE = null;
        int i10 = 0;
        for (b8.p pVar : collection) {
            if (mE == null) {
                mE = pVar.e();
            }
            if (!(pVar instanceof AbstractC3897c) || ((AbstractC3897c) pVar).j0() != ResolveStatus.RESOLVED || !((b8.j) pVar).isEmpty()) {
                arrayList.add(pVar.e());
                i10++;
            }
        }
        if (i10 == 0) {
            arrayList.add(mE);
        }
        return M.j(arrayList);
    }

    public static b8.k u0(AbstractC3897c... abstractC3897cArr) {
        return t0(Arrays.asList(abstractC3897cArr));
    }

    public static AbstractConfigValue z0(AbstractC3897c abstractC3897c, D d10) {
        try {
            D dJ = d10.j();
            AbstractConfigValue abstractConfigValueQ0 = abstractC3897c.q0(d10.b());
            if (dJ == null) {
                return abstractConfigValueQ0;
            }
            if (abstractConfigValueQ0 instanceof AbstractC3897c) {
                return z0((AbstractC3897c) abstractConfigValueQ0, dJ);
            }
            return null;
        } catch (ConfigException.NotResolved e10) {
            throw C3903i.p(d10, e10);
        }
    }

    public AbstractConfigValue A0(D d10) {
        return z0(this, d10);
    }

    @Override // java.util.Map
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public b8.p put(String str, b8.p pVar) {
        throw G0("put");
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public abstract AbstractC3897c e0(D d10);

    @Override // java.util.Map
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b8.p remove(Object obj) {
        throw G0("remove");
    }

    @Override // b8.j
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public SimpleConfig k() {
        return this.f31844b;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue, com.typesafe.config.impl.B
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c v() {
        return this;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: H0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AbstractC3897c n0(b8.i iVar) {
        return (AbstractC3897c) super.n0(iVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c p0(b8.k kVar) {
        return (AbstractC3897c) super.p0(kVar);
    }

    @Override // b8.p
    public ConfigValueType c() {
        return ConfigValueType.OBJECT;
    }

    @Override // java.util.Map
    public void clear() {
        throw G0("clear");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends b8.p> map) {
        throw G0("putAll");
    }

    public abstract AbstractConfigValue q0(String str);

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c Q(b8.k kVar, List<AbstractConfigValue> list) {
        return new C3901g(kVar, list);
    }

    @Override // b8.j, java.util.Map
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public abstract AbstractConfigValue get(Object obj);

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public abstract AbstractC3897c Y(AbstractC3897c abstractC3897c);

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c c0(b8.k kVar) {
        return x0(j0(), kVar);
    }

    public abstract AbstractC3897c x0(ResolveStatus resolveStatus, b8.k kVar);

    public final AbstractConfigValue y0(String str, D d10) {
        try {
            return q0(str);
        } catch (ConfigException.NotResolved e10) {
            throw C3903i.p(d10, e10);
        }
    }
}
