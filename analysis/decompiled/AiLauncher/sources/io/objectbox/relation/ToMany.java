package io.objectbox.relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class ToMany<TARGET> implements List<TARGET>, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final Integer f34376e = 1;

    /* renamed from: a, reason: collision with root package name */
    public List<TARGET> f34377a;

    /* renamed from: b, reason: collision with root package name */
    public Map<TARGET, Integer> f34378b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Map<TARGET, Boolean> f34379c;

    /* renamed from: d, reason: collision with root package name */
    public Map<TARGET, Boolean> f34380d;

    @Override // java.util.List, java.util.Collection
    public synchronized boolean add(TARGET target) {
        e(target);
        return this.f34377a.add(target);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean addAll(Collection<? extends TARGET> collection) {
        f(collection);
        return this.f34377a.addAll(collection);
    }

    public final void b() {
        this.f34377a.getClass();
    }

    public final void c() {
        b();
        if (this.f34379c == null) {
            synchronized (this) {
                try {
                    if (this.f34379c == null) {
                        this.f34379c = new LinkedHashMap();
                        this.f34380d = new LinkedHashMap();
                        this.f34378b = new HashMap();
                        for (TARGET target : this.f34377a) {
                            Integer numPut = this.f34378b.put(target, f34376e);
                            if (numPut != null) {
                                this.f34378b.put(target, Integer.valueOf(numPut.intValue() + 1));
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public synchronized void clear() {
        try {
            c();
            List<TARGET> list = this.f34377a;
            if (list != null) {
                Iterator<TARGET> it = list.iterator();
                while (it.hasNext()) {
                    this.f34380d.put(it.next(), Boolean.TRUE);
                }
                list.clear();
            }
            Map<TARGET, Boolean> map = this.f34379c;
            if (map != null) {
                map.clear();
            }
            Map<TARGET, Integer> map2 = this.f34378b;
            if (map2 != null) {
                map2.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        b();
        return this.f34377a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        b();
        return this.f34377a.containsAll(collection);
    }

    public final void e(TARGET target) {
        c();
        Integer numPut = this.f34378b.put(target, f34376e);
        if (numPut != null) {
            this.f34378b.put(target, Integer.valueOf(numPut.intValue() + 1));
        }
        this.f34379c.put(target, Boolean.TRUE);
        this.f34380d.remove(target);
    }

    public final void f(Collection<? extends TARGET> collection) {
        c();
        Iterator<? extends TARGET> it = collection.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
    }

    @Override // java.util.List
    public TARGET get(int i10) {
        b();
        return this.f34377a.get(i10);
    }

    public final void i(TARGET target) {
        c();
        Integer numRemove = this.f34378b.remove(target);
        if (numRemove != null) {
            if (numRemove.intValue() == 1) {
                this.f34378b.remove(target);
                this.f34379c.remove(target);
                this.f34380d.put(target, Boolean.TRUE);
            } else {
                if (numRemove.intValue() > 1) {
                    this.f34378b.put(target, Integer.valueOf(numRemove.intValue() - 1));
                    return;
                }
                throw new IllegalStateException("Illegal count: " + numRemove);
            }
        }
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        b();
        return this.f34377a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        b();
        return this.f34377a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<TARGET> iterator() {
        b();
        return this.f34377a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        b();
        return this.f34377a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<TARGET> listIterator() {
        b();
        return this.f34377a.listIterator();
    }

    @Override // java.util.List
    public synchronized TARGET remove(int i10) {
        TARGET targetRemove;
        c();
        targetRemove = this.f34377a.remove(i10);
        i(targetRemove);
        return targetRemove;
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean zRemove;
        Iterator<?> it = collection.iterator();
        zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean z10;
        try {
            c();
            z10 = false;
            ArrayList arrayList = null;
            for (TARGET target : this.f34377a) {
                if (!collection.contains(target)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(target);
                    z10 = true;
                }
            }
            if (arrayList != null) {
                removeAll(arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return z10;
    }

    @Override // java.util.List
    public synchronized TARGET set(int i10, TARGET target) {
        TARGET target2;
        c();
        target2 = this.f34377a.set(i10, target);
        i(target2);
        e(target);
        return target2;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        b();
        return this.f34377a.size();
    }

    @Override // java.util.List
    public List<TARGET> subList(int i10, int i11) {
        b();
        return this.f34377a.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        b();
        return this.f34377a.toArray();
    }

    @Override // java.util.List
    public synchronized void add(int i10, TARGET target) {
        e(target);
        this.f34377a.add(i10, target);
    }

    @Override // java.util.List
    public synchronized boolean addAll(int i10, Collection<? extends TARGET> collection) {
        f(collection);
        return this.f34377a.addAll(i10, collection);
    }

    @Override // java.util.List
    public ListIterator<TARGET> listIterator(int i10) {
        b();
        return this.f34377a.listIterator(i10);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        b();
        return (T[]) this.f34377a.toArray(tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public synchronized boolean remove(Object obj) {
        boolean zRemove;
        c();
        zRemove = this.f34377a.remove(obj);
        if (zRemove) {
            i(obj);
        }
        return zRemove;
    }
}
