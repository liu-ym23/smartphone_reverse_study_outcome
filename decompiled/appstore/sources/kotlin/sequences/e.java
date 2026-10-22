package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f21222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21223b;

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f21224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f21226c;

        public a(e r10) {
            this.f21226c = r10;
            this.f21225b = -2;
        }

        private final void a() {
            if (this.f21225b != (-2)) goto L5;
            Object r10 = e.a(this.f21226c).invoke();
        L6:
            this.f21224a = r10;
            if (r10 != null) goto L9;
            int r11 = 0;
        L10:
            this.f21225b = r11;
            return;
        L9:
            r11 = 1;
            goto L10
        L5:
            Function1 r12 = e.b(this.f21226c);
            Object r13 = this.f21224a;
            q.d(r13);
            r10 = r12.invoke(r13);
            goto L6
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21225b >= 0) goto L6;
            a();
        L6:
            if (this.f21225b == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f21225b >= 0) goto L6;
            a();
        L6:
            if (this.f21225b == 0) goto L10;
            Object r10 = this.f21224a;
            q.e(r10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f21225b = -1;
            return r10;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(Function0 r10, Function1 r11) {
        q.g(r10, "getInitialValue");
        q.g(r11, "getNextValue");
        this.f21222a = r10;
        this.f21223b = r11;
    }

    public static final /* synthetic */ Function0 a(e r10) {
        return r10.f21222a;
    }

    public static final /* synthetic */ Function1 b(e r10) {
        return r10.f21223b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new a(this);
    }
}
