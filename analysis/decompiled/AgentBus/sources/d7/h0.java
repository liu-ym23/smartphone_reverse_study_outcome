package d7;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class h0 extends f {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2964f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Object f2965g;

    public h0(ga.h hVar) {
        this.f2965g = hVar;
    }

    @Override // d7.a
    public final int a() {
        switch (this.f2964f) {
            case 0:
                return ((List) this.f2965g).size();
            default:
                return ((ga.h) this.f2965g).f4023a.groupCount() + 1;
        }
    }

    @Override // d7.a, java.util.Collection
    public /* bridge */ boolean contains(Object obj) {
        switch (this.f2964f) {
            case 1:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i2) {
        switch (this.f2964f) {
            case 0:
                return ((List) this.f2965g).get(r.F0(i2, this));
            default:
                String strGroup = ((ga.h) this.f2965g).f4023a.group(i2);
                return strGroup == null ? "" : strGroup;
        }
    }

    @Override // d7.f, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.f2964f) {
            case 1:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // d7.f, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.f2964f) {
            case 0:
                return new f0(this, 0);
            default:
                return super.iterator();
        }
    }

    @Override // d7.f, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.f2964f) {
            case 1:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // d7.f, java.util.List
    public ListIterator listIterator() {
        switch (this.f2964f) {
            case 0:
                return new f0(this, 0);
            default:
                return super.listIterator();
        }
    }

    @Override // d7.f, java.util.List
    public ListIterator listIterator(int i2) {
        switch (this.f2964f) {
            case 0:
                return new f0(this, i2);
            default:
                return super.listIterator(i2);
        }
    }

    public h0(List list) {
        q7.k.e(list, "delegate");
        this.f2965g = list;
    }
}
