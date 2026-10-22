package com.google.common.collect;

import B7.a;
import D7.N;
import D9.l;
import com.google.common.collect.RegularImmutableMap;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import m3.AbstractC1677d;
import m3.C1675b;

/* loaded from: classes3.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient ImmutableSet f2748a;
    public transient ImmutableSet b;
    public transient ImmutableCollection c;

    public static class SerializedForm<K, V> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f2749a;
        public final Object[] b;

        public SerializedForm(ImmutableMap immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            AbstractC1677d it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                objArr[i] = entry.getKey();
                objArr2[i] = entry.getValue();
                i++;
            }
            this.f2749a = objArr;
            this.b = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Serializable, java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Serializable, java.lang.Object[]] */
        public final Object readResolve() {
            Object[] objArr = this.f2749a;
            boolean z10 = objArr instanceof ImmutableSet;
            Object[] objArr2 = this.b;
            if (!z10) {
                int length = objArr.length;
                l lVar = new l(2, (byte) 0);
                lVar.c = new Object[length * 2];
                lVar.b = 0;
                for (int i = 0; i < objArr.length; i++) {
                    lVar.c(objArr[i], objArr2[i]);
                }
                C1675b c1675b = (C1675b) lVar.d;
                if (c1675b != null) {
                    throw c1675b.a();
                }
                RegularImmutableMap regularImmutableMapE = RegularImmutableMap.e(lVar.b, (Object[]) lVar.c, lVar);
                C1675b c1675b2 = (C1675b) lVar.d;
                if (c1675b2 == null) {
                    return regularImmutableMapE;
                }
                throw c1675b2.a();
            }
            ImmutableSet immutableSet = (ImmutableSet) objArr;
            int size = immutableSet.size();
            l lVar2 = new l(2, (byte) 0);
            lVar2.c = new Object[size * 2];
            lVar2.b = 0;
            AbstractC1677d it = immutableSet.iterator();
            AbstractC1677d it2 = ((ImmutableCollection) objArr2).iterator();
            while (it.hasNext()) {
                lVar2.c(it.next(), it2.next());
            }
            C1675b c1675b3 = (C1675b) lVar2.d;
            if (c1675b3 != null) {
                throw c1675b3.a();
            }
            RegularImmutableMap regularImmutableMapE2 = RegularImmutableMap.e(lVar2.b, (Object[]) lVar2.c, lVar2);
            C1675b c1675b4 = (C1675b) lVar2.d;
            if (c1675b4 == null) {
                return regularImmutableMapE2;
            }
            throw c1675b4.a();
        }
    }

    public static ImmutableMap b() {
        return RegularImmutableMap.g;
    }

    public static ImmutableMap d(ITaskExecutor iTaskExecutor, ITaskExecutor iTaskExecutor2) {
        N.r(0, iTaskExecutor);
        N.r(1, iTaskExecutor2);
        return RegularImmutableMap.e(2, new Object[]{0, iTaskExecutor, 1, iTaskExecutor2}, null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet entrySet() {
        ImmutableSet immutableSet = this.f2748a;
        if (immutableSet != null) {
            return immutableSet;
        }
        RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
        RegularImmutableMap.EntrySet entrySet = new RegularImmutableMap.EntrySet(regularImmutableMap, regularImmutableMap.e, regularImmutableMap.f);
        this.f2748a = entrySet;
        return entrySet;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        ImmutableCollection immutableCollection = this.c;
        if (immutableCollection == null) {
            RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
            RegularImmutableMap.KeysOrValuesAsList keysOrValuesAsList = new RegularImmutableMap.KeysOrValuesAsList(regularImmutableMap.e, 1, regularImmutableMap.f);
            this.c = keysOrValuesAsList;
            immutableCollection = keysOrValuesAsList;
        }
        return immutableCollection.contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        Iterator<E> it = entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        ImmutableSet immutableSet = this.b;
        if (immutableSet != null) {
            return immutableSet;
        }
        RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
        RegularImmutableMap.KeySet keySet = new RegularImmutableMap.KeySet(regularImmutableMap, new RegularImmutableMap.KeysOrValuesAsList(regularImmutableMap.e, 0, regularImmutableMap.f));
        this.b = keySet;
        return keySet;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException(a.h(size, "size cannot be negative but was: "));
        }
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z10 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z10) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z10 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        ImmutableCollection immutableCollection = this.c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        RegularImmutableMap regularImmutableMap = (RegularImmutableMap) this;
        RegularImmutableMap.KeysOrValuesAsList keysOrValuesAsList = new RegularImmutableMap.KeysOrValuesAsList(regularImmutableMap.e, 1, regularImmutableMap.f);
        this.c = keysOrValuesAsList;
        return keysOrValuesAsList;
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
