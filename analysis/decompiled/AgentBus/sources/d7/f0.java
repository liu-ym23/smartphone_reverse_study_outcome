package d7;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class f0 implements ListIterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2960f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final Object f2961g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f2962h;

    public f0(h0 h0Var, int i2) {
        this.f2962h = h0Var;
        this.f2961g = ((List) h0Var.f2965g).listIterator(r.G0(i2, h0Var));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f2960f) {
            case 0:
                ListIterator listIterator = (ListIterator) this.f2961g;
                listIterator.add(obj);
                listIterator.previous();
                return;
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2960f) {
            case 0:
                break;
            case 1:
                break;
            default:
                if (((q7.t) this.f2961g).f8818f < ((l0.y) this.f2962h).f5818i - 1) {
                }
                break;
        }
        return ((ListIterator) this.f2961g).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f2960f) {
            case 0:
                break;
            case 1:
                break;
            default:
                if (((q7.t) this.f2961g).f8818f >= 0) {
                }
                break;
        }
        return ((ListIterator) this.f2961g).hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f2960f) {
            case 0:
                return ((ListIterator) this.f2961g).previous();
            case 1:
                return ((ListIterator) this.f2961g).previous();
            default:
                q7.t tVar = (q7.t) this.f2961g;
                int i2 = tVar.f8818f + 1;
                l0.y yVar = (l0.y) this.f2962h;
                l0.r.a(i2, yVar.f5818i);
                tVar.f8818f = i2;
                return yVar.get(i2);
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        int iPreviousIndex;
        int iT0;
        switch (this.f2960f) {
            case 0:
                g0 g0Var = (g0) this.f2962h;
                iPreviousIndex = ((ListIterator) this.f2961g).previousIndex();
                iT0 = s.t0(g0Var);
                break;
            case 1:
                h0 h0Var = (h0) this.f2962h;
                iPreviousIndex = ((ListIterator) this.f2961g).previousIndex();
                iT0 = s.t0(h0Var);
                break;
            default:
                return ((q7.t) this.f2961g).f8818f + 1;
        }
        return iT0 - iPreviousIndex;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f2960f) {
            case 0:
                return ((ListIterator) this.f2961g).next();
            case 1:
                return ((ListIterator) this.f2961g).next();
            default:
                q7.t tVar = (q7.t) this.f2961g;
                int i2 = tVar.f8818f;
                l0.y yVar = (l0.y) this.f2962h;
                l0.r.a(i2, yVar.f5818i);
                tVar.f8818f = i2 - 1;
                return yVar.get(i2);
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int iNextIndex;
        int iT0;
        switch (this.f2960f) {
            case 0:
                g0 g0Var = (g0) this.f2962h;
                iNextIndex = ((ListIterator) this.f2961g).nextIndex();
                iT0 = s.t0(g0Var);
                break;
            case 1:
                h0 h0Var = (h0) this.f2962h;
                iNextIndex = ((ListIterator) this.f2961g).nextIndex();
                iT0 = s.t0(h0Var);
                break;
            default:
                return ((q7.t) this.f2961g).f8818f;
        }
        return iT0 - iNextIndex;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f2960f) {
            case 0:
                ((ListIterator) this.f2961g).remove();
                return;
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f2960f) {
            case 0:
                ((ListIterator) this.f2961g).set(obj);
                return;
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    public f0(g0 g0Var, int i2) {
        this.f2962h = g0Var;
        this.f2961g = g0Var.f2963f.listIterator(r.G0(i2, g0Var));
    }

    public f0(q7.t tVar, l0.y yVar) {
        this.f2961g = tVar;
        this.f2962h = yVar;
    }
}
