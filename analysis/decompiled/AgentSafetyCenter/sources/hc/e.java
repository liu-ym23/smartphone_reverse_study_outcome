package hc;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kb.y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends kb.e {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5459f;

    /* renamed from: g, reason: collision with root package name */
    public Object f5460g;

    @Override // jb.n
    public final int a() {
        switch (this.f5459f) {
            case 0:
                return ((f) this.f5460g).f5461a.groupCount() + 1;
            default:
                return ((List) this.f5460g).size();
        }
    }

    @Override // jb.n, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.f5459f) {
            case 0:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        switch (this.f5459f) {
            case 0:
                String strGroup = ((f) this.f5460g).f5461a.group(i);
                return strGroup == null ? "" : strGroup;
            default:
                List list = (List) this.f5460g;
                if (i >= 0 && i <= ac.a.x(this)) {
                    return list.get(ac.a.x(this) - i);
                }
                StringBuilder sbT = k0.a.t(i, "Element index ", " must be in range [");
                sbT.append(new ec.g(0, ac.a.x(this), 1));
                sbT.append("].");
                throw new IndexOutOfBoundsException(sbT.toString());
        }
    }

    @Override // kb.e, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.f5459f) {
            case 0:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // kb.e, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.f5459f) {
            case 1:
                return listIterator(0);
            default:
                return super.iterator();
        }
    }

    @Override // kb.e, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.f5459f) {
            case 0:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // kb.e, java.util.List
    public ListIterator listIterator(int i) {
        switch (this.f5459f) {
            case 1:
                y yVar = new y(0);
                yVar.f7411g = this;
                List list = (List) this.f5460g;
                if (i >= 0 && i <= a()) {
                    yVar.f7410f = list.listIterator(a() - i);
                    VarHandle.storeStoreFence();
                    return yVar;
                }
                StringBuilder sbT = k0.a.t(i, "Position index ", " must be in range [");
                sbT.append(new ec.g(0, a(), 1));
                sbT.append("].");
                throw new IndexOutOfBoundsException(sbT.toString());
            default:
                return super.listIterator(i);
        }
    }

    @Override // kb.e, java.util.List
    public ListIterator listIterator() {
        switch (this.f5459f) {
            case 1:
                return listIterator(0);
            default:
                return super.listIterator();
        }
    }
}
