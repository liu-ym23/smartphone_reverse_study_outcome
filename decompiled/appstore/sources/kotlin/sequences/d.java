package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f21216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1 f21218c;

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f21219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f21220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f21221c;

        public a(d r10) {
            this.f21221c = r10;
            this.f21219a = d.b(r10).iterator();
        }

        public final boolean a() {
            Iterator r10 = this.f21220b;
            if (r10 == null) goto L8;
            if (r10.hasNext() == true) goto L8;
            this.f21220b = null;
        L8:
            if (this.f21220b != null) goto L16;
            if (this.f21219a.hasNext() == false) goto L11;
            Object r11 = this.f21219a.next();
            Iterator r12 = (Iterator) d.a(this.f21221c).invoke(d.c(this.f21221c).invoke(r11));
            if (r12.hasNext() == false) goto L8;
            this.f21220b = r12;
            goto L16
        L11:
            return false;
        L16:
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (a() == false) goto L7;
            Iterator r10 = this.f21220b;
            q.d(r10);
            return r10.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(Sequence r10, Function1 r11, Function1 r12) {
        q.g(r10, "sequence");
        q.g(r11, "transformer");
        q.g(r12, "iterator");
        this.f21216a = r10;
        this.f21217b = r11;
        this.f21218c = r12;
    }

    public static final /* synthetic */ Function1 a(d r10) {
        return r10.f21218c;
    }

    public static final /* synthetic */ Sequence b(d r10) {
        return r10.f21216a;
    }

    public static final /* synthetic */ Function1 c(d r10) {
        return r10.f21217b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new a(this);
    }
}
