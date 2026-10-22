package D7;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public final class K extends AbstractC0214f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f397a = 1;
    public final Object b;

    public K(j9.l lVar) {
        this.b = lVar;
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.f397a) {
            case 1:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final Object get(int i) {
        switch (this.f397a) {
            case 0:
                return ((List) this.b).get(v.p0(i, this));
            default:
                String strGroup = ((j9.l) this.b).f4788a.group(i);
                return strGroup == null ? "" : strGroup;
        }
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    public final int getSize() {
        switch (this.f397a) {
            case 0:
                return ((List) this.b).size();
            default:
                return ((j9.l) this.b).f4788a.groupCount() + 1;
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.f397a) {
            case 1:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // D7.AbstractC0214f, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.f397a) {
            case 0:
                return new I(this, 0);
            default:
                return super.iterator();
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.f397a) {
            case 1:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public ListIterator listIterator() {
        switch (this.f397a) {
            case 0:
                return new I(this, 0);
            default:
                return super.listIterator();
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public ListIterator listIterator(int i) {
        switch (this.f397a) {
            case 0:
                return new I(this, i);
            default:
                return super.listIterator(i);
        }
    }

    public K(List delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.b = delegate;
    }
}
