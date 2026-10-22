package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f21238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21239b;

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f21240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f21241b;

        public a(l r10) {
            this.f21241b = r10;
            this.f21240a = l.a(r10).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21240a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return l.b(this.f21241b).invoke(this.f21240a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public l(Sequence r10, Function1 r11) {
        q.g(r10, "sequence");
        q.g(r11, "transformer");
        this.f21238a = r10;
        this.f21239b = r11;
    }

    public static final /* synthetic */ Sequence a(l r10) {
        return r10.f21238a;
    }

    public static final /* synthetic */ Function1 b(l r10) {
        return r10.f21239b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new a(this);
    }
}
