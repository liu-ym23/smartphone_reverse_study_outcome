package kb;

import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements ListIterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7409c;

    /* renamed from: f, reason: collision with root package name */
    public Object f7410f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7411g;

    public /* synthetic */ y(int i) {
        this.f7409c = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f7409c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f7409c) {
            case 0:
                return ((ListIterator) this.f7410f).hasPrevious();
            default:
                return ((yb.s) this.f7410f).f16096c < ((u0.y) this.f7411g).f13718h - 1;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f7409c) {
            case 0:
                return ((ListIterator) this.f7410f).hasNext();
            default:
                return ((yb.s) this.f7410f).f16096c >= 0;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f7409c) {
            case 0:
                return ((ListIterator) this.f7410f).previous();
            default:
                yb.s sVar = (yb.s) this.f7410f;
                int i = sVar.f16096c + 1;
                u0.y yVar = (u0.y) this.f7411g;
                u0.r.a(i, yVar.f13718h);
                sVar.f16096c = i;
                return yVar.get(i);
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f7409c) {
            case 0:
                hc.e eVar = (hc.e) this.f7411g;
                return (eVar.size() - 1) - ((ListIterator) this.f7410f).previousIndex();
            default:
                return ((yb.s) this.f7410f).f16096c + 1;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f7409c) {
            case 0:
                return ((ListIterator) this.f7410f).next();
            default:
                yb.s sVar = (yb.s) this.f7410f;
                int i = sVar.f16096c;
                u0.y yVar = (u0.y) this.f7411g;
                u0.r.a(i, yVar.f13718h);
                sVar.f16096c = i - 1;
                return yVar.get(i);
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        switch (this.f7409c) {
            case 0:
                hc.e eVar = (hc.e) this.f7411g;
                return (eVar.size() - 1) - ((ListIterator) this.f7410f).nextIndex();
            default:
                return ((yb.s) this.f7410f).f16096c;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f7409c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f7409c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }
}
