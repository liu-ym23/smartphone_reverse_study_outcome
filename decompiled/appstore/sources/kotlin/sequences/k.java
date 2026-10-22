package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f21232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21233b;

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f21234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f21236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f21237d;

        public a(k r10) {
            this.f21237d = r10;
            this.f21234a = k.b(r10).iterator();
            this.f21235b = -1;
        }

        private final void a() {
            if (this.f21234a.hasNext() == false) goto L8;
            Object r10 = this.f21234a.next();
            if (((Boolean) k.a(this.f21237d).invoke(r10)).booleanValue() == false) goto L8;
            this.f21235b = 1;
            this.f21236c = r10;
            return;
        L8:
            this.f21235b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21235b != (-1)) goto L6;
            a();
        L6:
            if (this.f21235b == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f21235b != (-1)) goto L6;
            a();
        L6:
            if (this.f21235b == 0) goto L10;
            Object r10 = this.f21236c;
            this.f21236c = null;
            this.f21235b = -1;
            return r10;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k(Sequence r10, Function1 r11) {
        q.g(r10, "sequence");
        q.g(r11, "predicate");
        this.f21232a = r10;
        this.f21233b = r11;
    }

    public static final /* synthetic */ Function1 a(k r10) {
        return r10.f21233b;
    }

    public static final /* synthetic */ Sequence b(k r10) {
        return r10.f21232a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new a(this);
    }
}
