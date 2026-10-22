package m0;

import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements ListIterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final Object f8156c;

    /* renamed from: f, reason: collision with root package name */
    public int f8157f;

    public d(int i, List list) {
        this.f8156c = list;
        this.f8157f = i;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator
    public final void add(Object obj) {
        this.f8156c.add(this.f8157f, obj);
        this.f8157f++;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f8157f < this.f8156c.size();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f8157f > 0;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.f8157f;
        this.f8157f = i + 1;
        return this.f8156c.get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f8157f;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.f8157f - 1;
        this.f8157f = i;
        return this.f8156c.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f8157f - 1;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.f8157f - 1;
        this.f8157f = i;
        this.f8156c.remove(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator
    public final void set(Object obj) {
        this.f8156c.set(this.f8157f, obj);
    }
}
