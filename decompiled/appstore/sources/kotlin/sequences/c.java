package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f21209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1 f21211c;

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f21212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f21214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f21215d;

        public a(c r10) {
            this.f21215d = r10;
            this.f21212a = c.c(r10).iterator();
            this.f21213b = -1;
        }

        public final void a() {
        L3:
            if (this.f21212a.hasNext() == false) goto L8;
            Object r10 = this.f21212a.next();
            if (((Boolean) c.a(this.f21215d).invoke(r10)).booleanValue() != c.b(this.f21215d)) goto L3;
            this.f21214c = r10;
            this.f21213b = 1;
            return;
        L8:
            this.f21213b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21213b != (-1)) goto L6;
            a();
        L6:
            if (this.f21213b == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f21213b != (-1)) goto L6;
            a();
        L6:
            if (this.f21213b == 0) goto L10;
            Object r10 = this.f21214c;
            this.f21214c = null;
            this.f21213b = -1;
            return r10;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(Sequence r10, boolean r11, Function1 r12) {
        q.g(r10, "sequence");
        q.g(r12, "predicate");
        this.f21209a = r10;
        this.f21210b = r11;
        this.f21211c = r12;
    }

    public static final /* synthetic */ Function1 a(c r10) {
        return r10.f21211c;
    }

    public static final /* synthetic */ boolean b(c r10) {
        return r10.f21210b;
    }

    public static final /* synthetic */ Sequence c(c r10) {
        return r10.f21209a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new a(this);
    }
}
