package com.typesafe.config.impl;

import b8.InterfaceC1455a;
import b8.InterfaceC1461g;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class SimpleConfig implements InterfaceC1455a, B, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC3897c f31814a;

    public SimpleConfig(AbstractC3897c abstractC3897c) {
        this.f31814a = abstractC3897c;
    }

    public static void E(Set<Map.Entry<String, b8.p>> set, D d10, AbstractC3897c abstractC3897c) {
        for (Map.Entry<String, b8.p> entry : abstractC3897c.entrySet()) {
            String key = entry.getKey();
            b8.p value = entry.getValue();
            D dF = D.f(key);
            if (d10 != null) {
                dF = dF.i(d10);
            }
            if (value instanceof AbstractC3897c) {
                E(set, dF, (AbstractC3897c) value);
            } else if (!(value instanceof ConfigNull)) {
                set.add(new AbstractMap.SimpleImmutableEntry(dF.k(), value));
            }
        }
    }

    public static AbstractConfigValue Y(AbstractConfigValue abstractConfigValue, ConfigValueType configValueType, D d10) {
        if (abstractConfigValue.c() == ConfigValueType.NULL) {
            throw new ConfigException.Null(abstractConfigValue.e(), d10.k(), configValueType != null ? configValueType.name() : null);
        }
        return abstractConfigValue;
    }

    public static AbstractConfigValue h(AbstractC3897c abstractC3897c, String str, ConfigValueType configValueType, D d10) {
        return Y(q(abstractC3897c, str, configValueType, d10), configValueType, d10);
    }

    public static AbstractConfigValue q(AbstractC3897c abstractC3897c, String str, ConfigValueType configValueType, D d10) {
        AbstractConfigValue abstractConfigValueY0 = abstractC3897c.y0(str, d10);
        if (abstractConfigValueY0 == null) {
            throw new ConfigException.Missing(abstractC3897c.e(), d10.k());
        }
        if (configValueType != null) {
            abstractConfigValueY0 = y.a(abstractConfigValueY0, configValueType);
        }
        if (configValueType == null || abstractConfigValueY0.c() == configValueType || abstractConfigValueY0.c() == ConfigValueType.NULL) {
            return abstractConfigValueY0;
        }
        throw new ConfigException.WrongType(abstractConfigValueY0.e(), d10.k(), configValueType.name(), abstractConfigValueY0.c().name());
    }

    public static AbstractConfigValue s(AbstractC3897c abstractC3897c, D d10, ConfigValueType configValueType, D d11) {
        try {
            String strB = d10.b();
            D dJ = d10.j();
            return dJ == null ? q(abstractC3897c, strB, configValueType, d11) : s((AbstractC3897c) h(abstractC3897c, strB, ConfigValueType.OBJECT, d11.m(0, d11.e() - dJ.e())), dJ, configValueType, d11);
        } catch (ConfigException.NotResolved e10) {
            throw C3903i.p(d10, e10);
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // b8.InterfaceC1455a
    public boolean A(String str) {
        return C(str, null).c() == ConfigValueType.NULL;
    }

    public final AbstractConfigValue C(String str, ConfigValueType configValueType) {
        D dG = D.g(str);
        return w(dG, configValueType, dG);
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public SimpleConfig l(String str) {
        return z(str).k();
    }

    public final ConfigNumber G(String str) {
        return (ConfigNumber) g(str, ConfigValueType.NUMBER);
    }

    @Override // b8.InterfaceC1455a
    public boolean H(String str) {
        b8.p pVarT = T(str);
        return (pVarT == null || pVarT.c() == ConfigValueType.NULL) ? false : true;
    }

    @Override // b8.InterfaceC1455a
    public double J(String str) {
        return P(str).doubleValue();
    }

    public final <T> List<T> M(String str, ConfigValueType configValueType) {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue abstractConfigValueA : u(str)) {
            if (configValueType != null) {
                abstractConfigValueA = y.a(abstractConfigValueA, configValueType);
            }
            if (abstractConfigValueA.c() != configValueType) {
                throw new ConfigException.WrongType(abstractConfigValueA.e(), str, "list of " + configValueType.name(), "list of " + abstractConfigValueA.c().name());
            }
            arrayList.add(abstractConfigValueA.a());
        }
        return arrayList;
    }

    public final <T extends b8.p> List<T> O(String str, ConfigValueType configValueType) {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue abstractConfigValueA : u(str)) {
            if (configValueType != null) {
                abstractConfigValueA = y.a(abstractConfigValueA, configValueType);
            }
            if (abstractConfigValueA.c() != configValueType) {
                throw new ConfigException.WrongType(abstractConfigValueA.e(), str, "list of " + configValueType.name(), "list of " + abstractConfigValueA.c().name());
            }
            arrayList.add(abstractConfigValueA);
        }
        return arrayList;
    }

    public Number P(String str) {
        return G(str).a();
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c z(String str) {
        return (AbstractC3897c) g(str, ConfigValueType.OBJECT);
    }

    public List<b8.j> R(String str) {
        return O(str, ConfigValueType.OBJECT);
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public AbstractConfigValue getValue(String str) {
        return g(str, null);
    }

    public final b8.p T(String str) {
        D dG = D.g(str);
        try {
            return this.f31814a.A0(dG);
        } catch (ConfigException.NotResolved e10) {
            throw C3903i.p(dG, e10);
        }
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public SimpleConfig b() {
        return D(com.typesafe.config.b.a());
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public SimpleConfig D(com.typesafe.config.b bVar) {
        return W(this, bVar);
    }

    public SimpleConfig W(InterfaceC1455a interfaceC1455a, com.typesafe.config.b bVar) {
        AbstractConfigValue abstractConfigValueK = I.k(this.f31814a, ((SimpleConfig) interfaceC1455a).f31814a, bVar);
        return abstractConfigValueK == this.f31814a ? this : new SimpleConfig((AbstractC3897c) abstractConfigValueK);
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c K() {
        return this.f31814a;
    }

    @Override // com.typesafe.config.impl.B
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public AbstractC3897c v() {
        return this.f31814a;
    }

    @Override // b8.InterfaceC1455a
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public SimpleConfig f(b8.i iVar) {
        return this.f31814a.n0(iVar).k();
    }

    public AbstractConfigValue d(D d10, ConfigValueType configValueType, D d11) {
        return Y(s(this.f31814a, d10, configValueType, d11), configValueType, d11);
    }

    @Override // b8.InterfaceC1455a
    public Set<Map.Entry<String, b8.p>> entrySet() {
        HashSet hashSet = new HashSet();
        E(hashSet, null, this.f31814a);
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SimpleConfig) {
            return this.f31814a.equals(((SimpleConfig) obj).f31814a);
        }
        return false;
    }

    public AbstractConfigValue g(String str, ConfigValueType configValueType) {
        D dG = D.g(str);
        return d(dG, configValueType, dG);
    }

    public final int hashCode() {
        return this.f31814a.hashCode() * 41;
    }

    @Override // b8.InterfaceC1455a
    public boolean i(String str) {
        return ((Boolean) g(str, ConfigValueType.BOOLEAN).a()).booleanValue();
    }

    @Override // b8.InterfaceC1455a
    public long j(String str) {
        return P(str).longValue();
    }

    @Override // b8.InterfaceC1455a
    public List<String> m(String str) {
        return M(str, ConfigValueType.STRING);
    }

    @Override // b8.InterfaceC1455a
    public int n(String str) {
        return G(str).r0(str);
    }

    @Override // b8.InterfaceC1455a
    public String t(String str) {
        return (String) g(str, ConfigValueType.STRING).a();
    }

    public String toString() {
        return "Config(" + this.f31814a.toString() + ")";
    }

    @Override // b8.InterfaceC1455a
    public InterfaceC1461g u(String str) {
        return (InterfaceC1461g) g(str, ConfigValueType.LIST);
    }

    public final AbstractConfigValue w(D d10, ConfigValueType configValueType, D d11) {
        return s(this.f31814a, d10, configValueType, d11);
    }

    @Override // b8.InterfaceC1455a
    public List<? extends InterfaceC1455a> y(String str) {
        List<b8.j> listR = R(str);
        ArrayList arrayList = new ArrayList();
        Iterator<b8.j> it = listR.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().k());
        }
        return arrayList;
    }
}
