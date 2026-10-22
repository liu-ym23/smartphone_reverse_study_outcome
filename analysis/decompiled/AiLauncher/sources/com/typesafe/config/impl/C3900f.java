package com.typesafe.config.impl;

import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.typesafe.config.impl.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3900f extends AbstractConfigValue implements T, H {

    /* renamed from: b, reason: collision with root package name */
    public final List<AbstractConfigValue> f31854b;

    public C3900f(b8.k kVar, List<AbstractConfigValue> list) {
        super(kVar);
        this.f31854b = list;
        if (list.isEmpty()) {
            throw new ConfigException.BugOrBroken("creating empty delayed merge value");
        }
        for (AbstractConfigValue abstractConfigValue : list) {
            if ((abstractConfigValue instanceof C3900f) || (abstractConfigValue instanceof C3901g)) {
                throw new ConfigException.BugOrBroken("placed nested DelayedMerge in a ConfigDelayedMerge, should have consolidated stack");
            }
        }
    }

    public static AbstractConfigValue q0(I i10, List<AbstractConfigValue> list, int i11) {
        List<AbstractConfigValue> listSubList = list.subList(i11, list.size());
        AbstractConfigValue abstractConfigValue = null;
        if (listSubList.isEmpty()) {
            if (C3903i.C()) {
                C3903i.z(i10.b(), "Nothing else in the merge stack, replacing with null");
            }
            return null;
        }
        for (AbstractConfigValue abstractConfigValueN0 : listSubList) {
            if (abstractConfigValue != null) {
                abstractConfigValueN0 = abstractConfigValue.n0(abstractConfigValueN0);
            }
            abstractConfigValue = abstractConfigValueN0;
        }
        return abstractConfigValue;
    }

    public static void v0(List<AbstractConfigValue> list, StringBuilder sb2, int i10, boolean z10, String str, b8.n nVar) {
        boolean zB = nVar.b();
        if (zB) {
            sb2.append("# unresolved merge of " + list.size() + " values follows (\n");
            if (str == null) {
                AbstractConfigValue.V(sb2, i10, nVar);
                sb2.append("# this unresolved merge will not be parseable because it's at the root of the object\n");
                AbstractConfigValue.V(sb2, i10, nVar);
                sb2.append("# the HOCON format has no way to list multiple root objects in a single file\n");
            }
        }
        ArrayList<AbstractConfigValue> arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.reverse(arrayList);
        int i11 = 0;
        for (AbstractConfigValue abstractConfigValue : arrayList) {
            if (zB) {
                AbstractConfigValue.V(sb2, i10, nVar);
                if (str != null) {
                    sb2.append("#     unmerged value " + i11 + " for key " + C3904j.g(str) + " from ");
                } else {
                    sb2.append("#     unmerged value " + i11 + " from ");
                }
                i11++;
                sb2.append(abstractConfigValue.e().description());
                sb2.append("\n");
                for (String str2 : abstractConfigValue.e().e()) {
                    AbstractConfigValue.V(sb2, i10, nVar);
                    sb2.append("# ");
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }
            AbstractConfigValue.V(sb2, i10, nVar);
            if (str != null) {
                sb2.append(C3904j.g(str));
                if (nVar.c()) {
                    sb2.append(" : ");
                } else {
                    sb2.append(ServerSentEventKt.COLON);
                }
            }
            abstractConfigValue.f0(sb2, i10, z10, nVar);
            sb2.append(Const.STR_MART_COMMA);
            if (nVar.c()) {
                sb2.append('\n');
            }
        }
        sb2.setLength(sb2.length() - 1);
        if (nVar.c()) {
            sb2.setLength(sb2.length() - 1);
            sb2.append("\n");
        }
        if (zB) {
            AbstractConfigValue.V(sb2, i10, nVar);
            sb2.append("# ) end of unresolved merge\n");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static K<? extends AbstractConfigValue> w0(H h10, List<AbstractConfigValue> list, I i10, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        L lE;
        if (C3903i.C()) {
            C3903i.z(i10.b(), "delayed merge stack has " + list.size() + " items:");
            int i11 = 0;
            for (AbstractConfigValue abstractConfigValue : list) {
                C3903i.z(i10.b() + 1, i11 + ": " + abstractConfigValue);
                i11++;
            }
        }
        AbstractConfigValue abstractConfigValueN0 = null;
        I i12 = i10;
        int i13 = 0;
        for (AbstractConfigValue abstractConfigValue2 : list) {
            if (abstractConfigValue2 instanceof H) {
                throw new ConfigException.BugOrBroken("A delayed merge should not contain another one: " + h10);
            }
            if (abstractConfigValue2 instanceof T) {
                AbstractConfigValue abstractConfigValueN = h10.N(i10, i13 + 1);
                if (C3903i.C()) {
                    C3903i.z(i12.b(), "remainder portion: " + abstractConfigValueN);
                }
                if (C3903i.C()) {
                    C3903i.z(i12.b(), "building sourceForEnd");
                }
                L lH = l10.h((AbstractConfigValue) h10, abstractConfigValueN);
                if (C3903i.C()) {
                    C3903i.z(i12.b(), "  sourceForEnd before reset parents but after replace: " + lH);
                }
                lE = lH.i();
            } else {
                if (C3903i.C()) {
                    C3903i.z(i12.b(), "will resolve end against the original source with parent pushed");
                }
                lE = l10.e(h10);
            }
            if (C3903i.C()) {
                C3903i.z(i12.b(), "sourceForEnd      =" + lE);
            }
            if (C3903i.C()) {
                int iB = i12.b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resolving highest-priority item in delayed merge ");
                sb2.append(abstractConfigValue2);
                sb2.append(" against ");
                sb2.append(lE);
                sb2.append(" endWasRemoved=");
                sb2.append(l10 != lE);
                C3903i.z(iB, sb2.toString());
            }
            K<? extends AbstractConfigValue> kL = i12.l(abstractConfigValue2, lE);
            b8.i iVar = kL.f31759b;
            i12 = kL.f31758a;
            if (iVar != null) {
                if (abstractConfigValueN0 == null) {
                    abstractConfigValueN0 = iVar;
                } else {
                    if (C3903i.C()) {
                        C3903i.z(i12.b() + 1, "merging " + abstractConfigValueN0 + " with fallback " + iVar);
                    }
                    abstractConfigValueN0 = abstractConfigValueN0.n0(iVar);
                }
            }
            i13++;
            if (C3903i.C()) {
                C3903i.z(i12.b(), "stack merged, yielding: " + abstractConfigValueN0);
            }
        }
        return K.b(i12, abstractConfigValueN0);
    }

    public static boolean x0(List<AbstractConfigValue> list) {
        return list.get(list.size() - 1).U();
    }

    @Override // com.typesafe.config.impl.T
    public Collection<AbstractConfigValue> G() {
        return this.f31854b;
    }

    @Override // com.typesafe.config.impl.x
    public AbstractConfigValue L(AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        List<AbstractConfigValue> listH0 = AbstractConfigValue.h0(this.f31854b, abstractConfigValue, abstractConfigValue2);
        if (listH0 == null) {
            return null;
        }
        return new C3900f(e(), listH0);
    }

    @Override // com.typesafe.config.impl.H
    public AbstractConfigValue N(I i10, int i11) {
        return q0(i10, this.f31854b, i11);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof C3900f;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean U() {
        return x0(this.f31854b);
    }

    @Override // b8.p
    public Object a() {
        throw new ConfigException.NotResolved("called unwrapped() on value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    @Override // b8.p
    public ConfigValueType c() {
        throw new ConfigException.NotResolved("called valueType() on value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public AbstractConfigValue c0(b8.k kVar) {
        return new C3900f(kVar, this.f31854b);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        List<AbstractConfigValue> list;
        List<AbstractConfigValue> list2;
        return (obj instanceof C3900f) && P(obj) && ((list = this.f31854b) == (list2 = ((C3900f) obj).f31854b) || list.equals(list2));
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        g0(sb2, i10, z10, null, nVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void g0(StringBuilder sb2, int i10, boolean z10, String str, b8.n nVar) {
        v0(this.f31854b, sb2, i10, z10, str, nVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return this.f31854b.hashCode();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public ResolveStatus j0() {
        return ResolveStatus.UNRESOLVED;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public K<? extends AbstractConfigValue> k0(I i10, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        return w0(this, this.f31854b, i10, l10);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public C3900f W(AbstractConfigValue abstractConfigValue) {
        return (C3900f) X(this.f31854b, abstractConfigValue);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public final C3900f Y(AbstractC3897c abstractC3897c) {
        return (C3900f) Z(this.f31854b, abstractC3897c);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public final C3900f a0(T t10) {
        return (C3900f) b0(this.f31854b, t10);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public C3900f e0(D d10) {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractConfigValue> it = this.f31854b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().e0(d10));
        }
        return new C3900f(e(), arrayList);
    }

    @Override // com.typesafe.config.impl.x
    public boolean x(AbstractConfigValue abstractConfigValue) {
        return AbstractConfigValue.S(this.f31854b, abstractConfigValue);
    }
}
