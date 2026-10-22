package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ConfigString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.typesafe.config.impl.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3899e extends AbstractConfigValue implements T, x {

    /* renamed from: b, reason: collision with root package name */
    public final List<AbstractConfigValue> f31853b;

    public C3899e(b8.k kVar, List<AbstractConfigValue> list) {
        super(kVar);
        this.f31853b = list;
        if (list.size() < 2) {
            throw new ConfigException.BugOrBroken("Created concatenation with less than 2 items: " + this);
        }
        boolean z10 = false;
        for (AbstractConfigValue abstractConfigValue : list) {
            if (abstractConfigValue instanceof C3899e) {
                throw new ConfigException.BugOrBroken("ConfigConcatenation should never be nested: " + this);
            }
            if (abstractConfigValue instanceof T) {
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        throw new ConfigException.BugOrBroken("Created concatenation without an unmergeable in it: " + this);
    }

    public static AbstractConfigValue q0(List<AbstractConfigValue> list) {
        List<AbstractConfigValue> listR0 = r0(list);
        if (listR0.isEmpty()) {
            return null;
        }
        return listR0.size() == 1 ? listR0.get(0) : new C3899e(M.k(listR0), listR0);
    }

    public static List<AbstractConfigValue> r0(List<AbstractConfigValue> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList<AbstractConfigValue> arrayList = new ArrayList(list.size());
        for (AbstractConfigValue abstractConfigValue : list) {
            if (abstractConfigValue instanceof C3899e) {
                arrayList.addAll(((C3899e) abstractConfigValue).f31853b);
            } else {
                arrayList.add(abstractConfigValue);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (AbstractConfigValue abstractConfigValue2 : arrayList) {
            if (arrayList2.isEmpty()) {
                arrayList2.add(abstractConfigValue2);
            } else {
                t0(arrayList2, abstractConfigValue2);
            }
        }
        return arrayList2;
    }

    public static boolean s0(AbstractConfigValue abstractConfigValue) {
        return (abstractConfigValue instanceof ConfigString) && !((ConfigString) abstractConfigValue).r0();
    }

    public static void t0(ArrayList<AbstractConfigValue> arrayList, AbstractConfigValue abstractConfigValue) {
        AbstractConfigValue quoted = arrayList.get(arrayList.size() - 1);
        if ((quoted instanceof b8.j) && (abstractConfigValue instanceof SimpleConfigList)) {
            quoted = y.a(quoted, ConfigValueType.LIST);
        } else if ((quoted instanceof SimpleConfigList) && (abstractConfigValue instanceof b8.j)) {
            abstractConfigValue = y.a(abstractConfigValue, ConfigValueType.LIST);
        }
        boolean z10 = quoted instanceof b8.j;
        if (z10 && (abstractConfigValue instanceof b8.j)) {
            quoted = abstractConfigValue.n0(quoted);
        } else {
            boolean z11 = quoted instanceof SimpleConfigList;
            if (z11 && (abstractConfigValue instanceof SimpleConfigList)) {
                quoted = ((SimpleConfigList) quoted).t0((SimpleConfigList) abstractConfigValue);
            } else if ((!z11 && !z10) || !s0(abstractConfigValue)) {
                if ((quoted instanceof C3899e) || (abstractConfigValue instanceof C3899e)) {
                    throw new ConfigException.BugOrBroken("unflattened ConfigConcatenation");
                }
                if ((quoted instanceof T) || (abstractConfigValue instanceof T)) {
                    quoted = null;
                } else {
                    String strM0 = quoted.m0();
                    String strM02 = abstractConfigValue.m0();
                    if (strM0 == null || strM02 == null) {
                        throw new ConfigException.WrongType(quoted.e(), "Cannot concatenate object or list with a non-object-or-list, " + quoted + " and " + abstractConfigValue + " are not compatible");
                    }
                    quoted = new ConfigString.Quoted(M.i(quoted.e(), abstractConfigValue.e()), strM0 + strM02);
                }
            }
        }
        if (quoted == null) {
            arrayList.add(abstractConfigValue);
        } else {
            arrayList.remove(arrayList.size() - 1);
            arrayList.add(quoted);
        }
    }

    @Override // com.typesafe.config.impl.T
    public Collection<C3899e> G() {
        return Collections.singleton(this);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof C3899e;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean U() {
        return false;
    }

    @Override // b8.p
    public Object a() {
        throw v0();
    }

    @Override // b8.p
    public ConfigValueType c() {
        throw v0();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        return (obj instanceof C3899e) && P(obj) && this.f31853b.equals(((C3899e) obj).f31853b);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        Iterator<AbstractConfigValue> it = this.f31853b.iterator();
        while (it.hasNext()) {
            it.next().f0(sb2, i10, z10, nVar);
        }
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return this.f31853b.hashCode();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public ResolveStatus j0() {
        return ResolveStatus.UNRESOLVED;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public K<? extends AbstractConfigValue> k0(I i10, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        if (C3903i.C()) {
            int iB = i10.b();
            int i11 = iB + 2;
            C3903i.z(iB + 1, "concatenation has " + this.f31853b.size() + " pieces:");
            Iterator<AbstractConfigValue> it = this.f31853b.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                C3903i.z(i11, i12 + ": " + it.next());
                i12++;
            }
        }
        ArrayList arrayList = new ArrayList(this.f31853b.size());
        I iM = i10;
        for (AbstractConfigValue abstractConfigValue : this.f31853b) {
            D dN = iM.n();
            K<? extends AbstractConfigValue> kL = iM.p().l(abstractConfigValue, l10);
            Object obj = kL.f31759b;
            iM = kL.f31758a.m(dN);
            if (C3903i.C()) {
                C3903i.z(i10.b(), "resolved concat piece to " + obj);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        List<AbstractConfigValue> listR0 = r0(arrayList);
        if (listR0.size() > 1 && i10.f().b()) {
            return K.b(iM, new C3899e(e(), listR0));
        }
        if (listR0.isEmpty()) {
            return K.b(iM, null);
        }
        if (listR0.size() == 1) {
            return K.b(iM, listR0.get(0));
        }
        throw new ConfigException.BugOrBroken("Bug in the library; resolved list was joined to too many values: " + listR0);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public C3899e c0(b8.k kVar) {
        return new C3899e(kVar, this.f31853b);
    }

    public final ConfigException.NotResolved v0() {
        return new ConfigException.NotResolved("need to Config#resolve(), see the API docs for Config#resolve(); substitution not resolved: " + this);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public C3899e e0(D d10) {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractConfigValue> it = this.f31853b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().e0(d10));
        }
        return new C3899e(e(), arrayList);
    }

    @Override // com.typesafe.config.impl.x
    public boolean x(AbstractConfigValue abstractConfigValue) {
        return AbstractConfigValue.S(this.f31853b, abstractConfigValue);
    }

    @Override // com.typesafe.config.impl.x
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public C3899e L(AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        List<AbstractConfigValue> listH0 = AbstractConfigValue.h0(this.f31853b, abstractConfigValue, abstractConfigValue2);
        if (listH0 == null) {
            return null;
        }
        return new C3899e(e(), listH0);
    }
}
