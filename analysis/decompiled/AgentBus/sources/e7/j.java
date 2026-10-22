package e7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import q7.k;

/* loaded from: classes.dex */
public final class j extends d7.j implements Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final j f3116g;

    /* renamed from: f, reason: collision with root package name */
    public final g f3117f;

    static {
        g gVar = g.f3098s;
        f3116g = new j(g.f3098s);
    }

    public j(g gVar) {
        k.e(gVar, "backing");
        this.f3117f = gVar;
    }

    @Override // d7.j
    public final int a() {
        return this.f3117f.f3107n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f3117f.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        k.e(collection, "elements");
        this.f3117f.d();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f3117f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f3117f.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f3117f.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        g gVar = this.f3117f;
        gVar.getClass();
        return new d(gVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        g gVar = this.f3117f;
        gVar.d();
        int iJ = gVar.j(obj);
        if (iJ < 0) {
            return false;
        }
        gVar.n(iJ);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        this.f3117f.d();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        this.f3117f.d();
        return super.retainAll(collection);
    }

    public j() {
        this(new g());
    }
}
