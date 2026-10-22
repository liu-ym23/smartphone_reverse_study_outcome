package l3;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class l extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.common.cache.e f5276a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.google.common.cache.e c;

    public l(com.google.common.cache.e eVar, int i) {
        this.b = i;
        this.c = eVar;
        this.f5276a = eVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f5276a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        com.google.common.cache.e eVar;
        Object obj2;
        switch (this.b) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (eVar = this.c).get(key)) != null && eVar.f.d(entry.getValue(), obj2);
            default:
                return this.c.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f5276a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.b) {
            case 0:
                return new k(this.c, 0);
            default:
                return new k(this.c, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.b) {
            case 0:
                if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.c.remove(key, entry.getValue())) {
                }
                break;
            default:
                if (this.c.remove(obj) != null) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5276a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return com.google.common.cache.e.a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return com.google.common.cache.e.a(this).toArray(objArr);
    }
}
