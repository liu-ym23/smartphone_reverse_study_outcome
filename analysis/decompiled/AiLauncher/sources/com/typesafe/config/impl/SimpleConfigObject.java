package com.typesafe.config.impl;

import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class SimpleConfigObject extends AbstractC3897c implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final SimpleConfigObject f31824f = K0(M.r("empty config"));

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, AbstractConfigValue> f31825c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f31826d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31827e;

    public static final class RenderComparator implements Comparator<String>, Serializable {
        private RenderComparator() {
        }

        public static boolean b(String str) {
            int length = str.length();
            if (length == 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isDigit(str.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            boolean zB = b(str);
            boolean zB2 = b(str2);
            if (zB && zB2) {
                return new BigInteger(str).compareTo(new BigInteger(str2));
            }
            if (zB) {
                return -1;
            }
            if (zB2) {
                return 1;
            }
            return str.compareTo(str2);
        }

        public /* synthetic */ RenderComparator(a aVar) {
            this();
        }
    }

    public class a extends AbstractConfigValue.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ D f31828b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(D d10) {
            super();
            this.f31828b = d10;
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue.b
        public AbstractConfigValue b(String str, AbstractConfigValue abstractConfigValue) {
            return abstractConfigValue.e0(this.f31828b);
        }
    }

    public static final class b implements AbstractConfigValue.a {

        /* renamed from: a, reason: collision with root package name */
        public final D f31830a;

        /* renamed from: b, reason: collision with root package name */
        public I f31831b;

        /* renamed from: c, reason: collision with root package name */
        public final L f31832c;

        public b(I i10, L l10) {
            this.f31831b = i10;
            this.f31832c = l10;
            this.f31830a = i10.n();
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue.a
        public AbstractConfigValue a(String str, AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
            D dJ;
            if (!this.f31831b.c()) {
                K<? extends AbstractConfigValue> kL = this.f31831b.p().l(abstractConfigValue, this.f31832c);
                this.f31831b = kL.f31758a.p().m(this.f31830a);
                return kL.f31759b;
            }
            if (!str.equals(this.f31831b.n().b()) || (dJ = this.f31831b.n().j()) == null) {
                return abstractConfigValue;
            }
            K<? extends AbstractConfigValue> kL2 = this.f31831b.m(dJ).l(abstractConfigValue, this.f31832c);
            this.f31831b = kL2.f31758a.p().m(this.f31830a);
            return kL2.f31759b;
        }
    }

    public SimpleConfigObject(b8.k kVar, Map<String, AbstractConfigValue> map, ResolveStatus resolveStatus, boolean z10) {
        super(kVar);
        if (map == null) {
            throw new ConfigException.BugOrBroken("creating config object with null map");
        }
        this.f31825c = map;
        this.f31826d = resolveStatus == ResolveStatus.RESOLVED;
        this.f31827e = z10;
        if (resolveStatus == ResolveStatus.fromValues(map.values())) {
            return;
        }
        throw new ConfigException.BugOrBroken("Wrong resolved status on " + this);
    }

    public static final SimpleConfigObject J0() {
        return f31824f;
    }

    public static final SimpleConfigObject K0(b8.k kVar) {
        return kVar == null ? J0() : new SimpleConfigObject(kVar, Collections.EMPTY_MAP);
    }

    public static final SimpleConfigObject L0(b8.k kVar) {
        return new SimpleConfigObject(M.r(kVar.description() + " (not found)"), Collections.EMPTY_MAP);
    }

    public static boolean M0(Map<String, b8.p> map, Map<String, b8.p> map2) {
        if (map == map2) {
            return true;
        }
        Set<String> setKeySet = map.keySet();
        if (!setKeySet.equals(map2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!map.get(str).equals(map2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public static int N0(Map<String, b8.p> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += map.get((String) it.next()).hashCode();
        }
        return ((arrayList.hashCode() + 41) * 41) + iHashCode;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // com.typesafe.config.impl.AbstractC3897c
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigObject Y(AbstractC3897c abstractC3897c) {
        i0();
        if (!(abstractC3897c instanceof SimpleConfigObject)) {
            throw new ConfigException.BugOrBroken("should not be reached (merging non-SimpleConfigObject)");
        }
        SimpleConfigObject simpleConfigObject = (SimpleConfigObject) abstractC3897c;
        HashMap map = new HashMap();
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(keySet());
        hashSet.addAll(simpleConfigObject.keySet());
        boolean z10 = true;
        boolean z11 = false;
        for (String str : hashSet) {
            AbstractConfigValue abstractConfigValue = this.f31825c.get(str);
            AbstractConfigValue abstractConfigValueN0 = simpleConfigObject.f31825c.get(str);
            if (abstractConfigValue != null) {
                abstractConfigValueN0 = abstractConfigValueN0 == null ? abstractConfigValue : abstractConfigValue.n0(abstractConfigValueN0);
            }
            map.put(str, abstractConfigValueN0);
            if (abstractConfigValue != abstractConfigValueN0) {
                z11 = true;
            }
            if (abstractConfigValueN0.j0() == ResolveStatus.UNRESOLVED) {
                z10 = false;
            }
        }
        ResolveStatus resolveStatusFromBoolean = ResolveStatus.fromBoolean(z10);
        boolean zU = simpleConfigObject.U();
        return z11 ? new SimpleConfigObject(AbstractC3897c.u0(this, simpleConfigObject), map, resolveStatusFromBoolean, zU) : (resolveStatusFromBoolean == j0() && zU == U()) ? this : S0(resolveStatusFromBoolean, e(), zU);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof b8.j;
    }

    public final SimpleConfigObject P0(AbstractConfigValue.b bVar) {
        try {
            return Q0(bVar);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e11);
        }
    }

    public final SimpleConfigObject Q0(AbstractConfigValue.a aVar) throws Exception {
        HashMap map = null;
        for (String str : keySet()) {
            AbstractConfigValue abstractConfigValue = this.f31825c.get(str);
            AbstractConfigValue abstractConfigValueA = aVar.a(str, abstractConfigValue);
            if (abstractConfigValueA != abstractConfigValue) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, abstractConfigValueA);
            }
        }
        if (map == null) {
            return this;
        }
        HashMap map2 = new HashMap();
        boolean z10 = false;
        for (String str2 : keySet()) {
            if (map.containsKey(str2)) {
                AbstractConfigValue abstractConfigValue2 = (AbstractConfigValue) map.get(str2);
                if (abstractConfigValue2 != null) {
                    map2.put(str2, abstractConfigValue2);
                    if (abstractConfigValue2.j0() == ResolveStatus.UNRESOLVED) {
                        z10 = true;
                    }
                }
            } else {
                AbstractConfigValue abstractConfigValue3 = this.f31825c.get(str2);
                map2.put(str2, abstractConfigValue3);
                if (abstractConfigValue3.j0() == ResolveStatus.UNRESOLVED) {
                    z10 = true;
                }
            }
        }
        return new SimpleConfigObject(e(), map2, z10 ? ResolveStatus.UNRESOLVED : ResolveStatus.RESOLVED, U());
    }

    @Override // com.typesafe.config.impl.AbstractC3897c
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigObject x0(ResolveStatus resolveStatus, b8.k kVar) {
        return S0(resolveStatus, kVar, this.f31827e);
    }

    public final SimpleConfigObject S0(ResolveStatus resolveStatus, b8.k kVar, boolean z10) {
        return new SimpleConfigObject(kVar, this.f31825c, resolveStatus, z10);
    }

    @Override // com.typesafe.config.impl.AbstractC3897c, com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigObject e0(D d10) {
        return P0(new a(d10));
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean U() {
        return this.f31827e;
    }

    @Override // com.typesafe.config.impl.x
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigObject L(AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        HashMap map = new HashMap(this.f31825c);
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == abstractConfigValue) {
                if (abstractConfigValue2 != null) {
                    entry.setValue(abstractConfigValue2);
                } else {
                    map.remove(entry.getKey());
                }
                return new SimpleConfigObject(e(), map, ResolveStatus.fromValues(map.values()), this.f31827e);
            }
        }
        throw new ConfigException.BugOrBroken("SimpleConfigObject.replaceChild did not find " + abstractConfigValue + " in " + this);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigObject o0() {
        return this.f31827e ? this : S0(j0(), e(), true);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f31825c.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f31825c.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, b8.p>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, AbstractConfigValue> entry : this.f31825c.entrySet()) {
            hashSet.add(new AbstractMap.SimpleImmutableEntry(entry.getKey(), entry.getValue()));
        }
        return hashSet;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        return (obj instanceof b8.j) && P(obj) && M0(this, (b8.j) obj);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        int i11;
        if (isEmpty()) {
            sb2.append("{}");
        } else {
            boolean z11 = nVar.d() || !z10;
            if (z11) {
                int i12 = i10 + 1;
                sb2.append(Const.STR_MART_JSON_BEGIN);
                if (nVar.c()) {
                    sb2.append('\n');
                }
                i11 = i12;
            } else {
                i11 = i10;
            }
            String[] strArr = (String[]) keySet().toArray(new String[size()]);
            Arrays.sort(strArr, new RenderComparator(null));
            int i13 = 0;
            for (String str : strArr) {
                AbstractConfigValue abstractConfigValue = this.f31825c.get(str);
                if (nVar.e()) {
                    String[] strArrSplit = abstractConfigValue.e().description().split("\n");
                    int length = strArrSplit.length;
                    int i14 = 0;
                    while (i14 < length) {
                        String str2 = strArrSplit[i14];
                        AbstractConfigValue abstractConfigValue2 = abstractConfigValue;
                        AbstractConfigValue.V(sb2, i10 + 1, nVar);
                        sb2.append('#');
                        if (!str2.isEmpty()) {
                            sb2.append(' ');
                        }
                        sb2.append(str2);
                        sb2.append("\n");
                        i14++;
                        abstractConfigValue = abstractConfigValue2;
                    }
                }
                AbstractConfigValue abstractConfigValue3 = abstractConfigValue;
                if (nVar.b()) {
                    for (String str3 : abstractConfigValue3.e().e()) {
                        AbstractConfigValue.V(sb2, i11, nVar);
                        sb2.append(Const.STR_MART_WELL);
                        if (!str3.startsWith(" ")) {
                            sb2.append(' ');
                        }
                        sb2.append(str3);
                        sb2.append("\n");
                    }
                }
                AbstractConfigValue.V(sb2, i11, nVar);
                abstractConfigValue3.g0(sb2, i11, false, str, nVar);
                if (nVar.c()) {
                    if (nVar.d()) {
                        sb2.append(Const.STR_MART_COMMA);
                        i13 = 2;
                    } else {
                        i13 = 1;
                    }
                    sb2.append('\n');
                } else {
                    sb2.append(Const.STR_MART_COMMA);
                    i13 = 1;
                }
            }
            sb2.setLength(sb2.length() - i13);
            if (z11) {
                if (nVar.c()) {
                    sb2.append('\n');
                    if (z11) {
                        AbstractConfigValue.V(sb2, i10, nVar);
                    }
                }
                sb2.append("}");
            }
        }
        if (z10 && nVar.c()) {
            sb2.append('\n');
        }
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return N0(this);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f31825c.isEmpty();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public ResolveStatus j0() {
        return ResolveStatus.fromBoolean(this.f31826d);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public K<? extends AbstractC3897c> k0(I i10, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        if (j0() == ResolveStatus.RESOLVED) {
            return K.b(i10, this);
        }
        try {
            b bVar = new b(i10, l10.e(this));
            return K.b(bVar.f31831b, Q0(bVar)).a();
        } catch (AbstractConfigValue.NotPossibleToResolve e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e12);
        }
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f31825c.keySet();
    }

    @Override // com.typesafe.config.impl.AbstractC3897c
    public AbstractConfigValue q0(String str) {
        return this.f31825c.get(str);
    }

    @Override // com.typesafe.config.impl.AbstractC3897c, b8.j, java.util.Map
    /* renamed from: s0 */
    public AbstractConfigValue get(Object obj) {
        return this.f31825c.get(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f31825c.size();
    }

    @Override // java.util.Map
    public Collection<b8.p> values() {
        return new HashSet(this.f31825c.values());
    }

    @Override // com.typesafe.config.impl.x
    public boolean x(AbstractConfigValue abstractConfigValue) {
        Iterator<AbstractConfigValue> it = this.f31825c.values().iterator();
        while (it.hasNext()) {
            if (it.next() == abstractConfigValue) {
                return true;
            }
        }
        for (b8.p pVar : this.f31825c.values()) {
            if ((pVar instanceof x) && ((x) pVar).x(abstractConfigValue)) {
                return true;
            }
        }
        return false;
    }

    @Override // b8.p
    public Map<String, Object> a() {
        HashMap map = new HashMap();
        for (Map.Entry<String, AbstractConfigValue> entry : this.f31825c.entrySet()) {
            map.put(entry.getKey(), entry.getValue().a());
        }
        return map;
    }

    public SimpleConfigObject(b8.k kVar, Map<String, AbstractConfigValue> map) {
        this(kVar, map, ResolveStatus.fromValues(map.values()), false);
    }
}
