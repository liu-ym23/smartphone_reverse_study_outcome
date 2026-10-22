package d5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends c5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1846a;

    /* renamed from: b, reason: collision with root package name */
    public final g f1847b;

    public /* synthetic */ h(g gVar, int i8) {
        this.f1846a = i8;
        this.f1847b = gVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f1846a) {
            case 0:
                Map.Entry element = (Map.Entry) obj;
                p.e(element, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        switch (this.f1846a) {
            case 0:
                p.e(elements, "elements");
                throw new UnsupportedOperationException();
            default:
                p.e(elements, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f1846a) {
            case 0:
                this.f1847b.clear();
                break;
            default:
                this.f1847b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f1846a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.f1847b.f((Map.Entry) obj);
            default:
                return this.f1847b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        switch (this.f1846a) {
            case 0:
                p.e(elements, "elements");
                return this.f1847b.e(elements);
            default:
                return super.containsAll(elements);
        }
    }

    @Override // c5.h
    public final int f() {
        switch (this.f1846a) {
        }
        return this.f1847b.f1841j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f1846a) {
        }
        return this.f1847b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f1846a) {
            case 0:
                g gVar = this.f1847b;
                gVar.getClass();
                return new d(gVar, 0);
            default:
                g gVar2 = this.f1847b;
                gVar2.getClass();
                return new d(gVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f1846a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    g gVar = this.f1847b;
                    gVar.getClass();
                    gVar.c();
                    int iH = gVar.h(entry.getKey());
                    if (iH >= 0) {
                        Object[] objArr = gVar.f1835b;
                        p.b(objArr);
                        if (p.a(objArr[iH], entry.getValue())) {
                            gVar.l(iH);
                            break;
                        }
                    }
                }
                break;
            default:
                g gVar2 = this.f1847b;
                gVar2.c();
                int iH2 = gVar2.h(obj);
                if (iH2 >= 0) {
                    gVar2.l(iH2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        switch (this.f1846a) {
            case 0:
                p.e(elements, "elements");
                this.f1847b.c();
                break;
            default:
                p.e(elements, "elements");
                this.f1847b.c();
                break;
        }
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        switch (this.f1846a) {
            case 0:
                p.e(elements, "elements");
                this.f1847b.c();
                break;
            default:
                p.e(elements, "elements");
                this.f1847b.c();
                break;
        }
        return super.retainAll(elements);
    }
}
