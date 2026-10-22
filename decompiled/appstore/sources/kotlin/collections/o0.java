package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public class o0 extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f21104a;

    public static final class a implements ListIterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListIterator f21105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0 f21106b;

        public a(o0 r10, int r11) {
            this.f21106b = r10;
            this.f21105a = o0.a(r10).listIterator(z.I(r10, r11));
        }

        @Override // java.util.ListIterator
        public void add(Object r10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f21105a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f21105a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.f21105a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return z.H(this.f21106b, this.f21105a.previousIndex());
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.f21105a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return z.H(this.f21106b, this.f21105a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(Object r10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public o0(List r10) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        this.f21104a = r10;
    }

    public static final /* synthetic */ List a(o0 r10) {
        return r10.f21104a;
    }

    @Override // kotlin.collections.b, java.util.List
    public Object get(int r10) {
        return this.f21104a.get(z.G(this, r10));
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f21104a.size();
    }

    @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.b, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.b, java.util.List
    public ListIterator listIterator(int r10) {
        return new a(this, r10);
    }
}
