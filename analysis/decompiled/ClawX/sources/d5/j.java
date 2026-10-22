package d5;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends c5.h implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final j f1849b;

    /* renamed from: a, reason: collision with root package name */
    public final g f1850a;

    static {
        g gVar = g.f1833o;
        f1849b = new j(g.f1833o);
    }

    public j(g backing) {
        p.e(backing, "backing");
        this.f1850a = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f1850a.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        p.e(elements, "elements");
        this.f1850a.c();
        return super.addAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f1850a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f1850a.containsKey(obj);
    }

    @Override // c5.h
    public final int f() {
        return this.f1850a.f1841j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f1850a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        g gVar = this.f1850a;
        gVar.getClass();
        return new d(gVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        g gVar = this.f1850a;
        gVar.c();
        int iH = gVar.h(obj);
        if (iH < 0) {
            return false;
        }
        gVar.l(iH);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        p.e(elements, "elements");
        this.f1850a.c();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        p.e(elements, "elements");
        this.f1850a.c();
        return super.retainAll(elements);
    }
}
