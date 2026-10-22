package kb;

import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends b implements ListIterator {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f7387h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i) {
        super(eVar);
        this.f7387h = eVar;
        int iA = eVar.a();
        if (i < 0 || i > iA) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", iA));
            throw null;
        }
        this.f7385f = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7385f > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7385f;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            g5.f.k();
            return null;
        }
        int i = this.f7385f - 1;
        this.f7385f = i;
        return this.f7387h.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7385f - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
