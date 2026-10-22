package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class h extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19950a;

    /* renamed from: b, reason: collision with root package name */
    public Collection f19951b;

    /* renamed from: c, reason: collision with root package name */
    public final h f19952c;

    /* renamed from: d, reason: collision with root package name */
    public final Collection f19953d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbr f19954e;

    public h(zzbr zzbrVar, Object obj, Collection collection, h hVar) {
        this.f19954e = zzbrVar;
        this.f19950a = obj;
        this.f19951b = collection;
        this.f19952c = hVar;
        this.f19953d = hVar == null ? null : hVar.f19951b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zzb();
        boolean zIsEmpty = this.f19951b.isEmpty();
        boolean zAdd = this.f19951b.add(obj);
        if (zAdd) {
            this.f19954e.f19971d++;
            if (zIsEmpty) {
                b();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f19951b.addAll(collection);
        if (zAddAll) {
            int size2 = this.f19951b.size();
            this.f19954e.f19971d += size2 - size;
            if (size == 0) {
                b();
                return true;
            }
        }
        return zAddAll;
    }

    public final void b() {
        h hVar = this.f19952c;
        if (hVar != null) {
            hVar.b();
            return;
        }
        zzbr zzbrVar = this.f19954e;
        zzbrVar.f19970c.put(this.f19950a, this.f19951b);
    }

    public final void c() {
        h hVar = this.f19952c;
        if (hVar != null) {
            hVar.c();
        } else if (this.f19951b.isEmpty()) {
            zzbr zzbrVar = this.f19954e;
            zzbrVar.f19970c.remove(this.f19950a);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f19951b.clear();
        this.f19954e.f19971d -= size;
        c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        zzb();
        return this.f19951b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.f19951b.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.f19951b.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.f19951b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new g(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        zzb();
        boolean zRemove = this.f19951b.remove(obj);
        if (zRemove) {
            zzbr zzbrVar = this.f19954e;
            zzbrVar.f19971d--;
            c();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f19951b.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.f19951b.size();
            this.f19954e.f19971d += size2 - size;
            c();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f19951b.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.f19951b.size();
            this.f19954e.f19971d += size2 - size;
            c();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.f19951b.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.f19951b.toString();
    }

    public final void zzb() {
        h hVar = this.f19952c;
        if (hVar != null) {
            hVar.zzb();
            h hVar2 = this.f19952c;
            if (hVar2.f19951b != this.f19953d) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.f19951b.isEmpty()) {
            zzbr zzbrVar = this.f19954e;
            Collection collection = (Collection) zzbrVar.f19970c.get(this.f19950a);
            if (collection != null) {
                this.f19951b = collection;
            }
        }
    }
}
