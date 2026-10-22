package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f21258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2 f21261d;

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bg.c f21265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f21266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d f21267f;

        public a(d r10) {
            this.f21267f = r10;
            this.f21262a = -1;
            int r11 = bg.h.k(d.d(r10), 0, d.b(r10).length());
            this.f21263b = r11;
            this.f21264c = r11;
        }

        private final void a() {
            int r10 = 0;
            if (this.f21264c >= 0) goto L6;
            this.f21262a = 0;
            this.f21265d = null;
            return;
        L6:
            if (d.c(this.f21267f) <= 0) goto L10;
            int r11 = this.f21266e + 1;
            this.f21266e = r11;
            if (r11 < d.c(this.f21267f)) goto L10;
        L11:
            this.f21265d = new bg.c(this.f21263b, StringsKt__StringsKt.K(d.b(this.f21267f)));
            this.f21264c = -1;
        L19:
            this.f21262a = 1;
            return;
        L10:
            if (this.f21264c > d.b(this.f21267f).length()) goto L11;
            Pair r12 = (Pair) d.a(this.f21267f).mo0invoke(d.b(this.f21267f), Integer.valueOf(this.f21264c));
            if (r12 != null) goto L15;
            this.f21265d = new bg.c(this.f21263b, StringsKt__StringsKt.K(d.b(this.f21267f)));
            this.f21264c = -1;
            goto L19
        L15:
            int r13 = ((Number) r12.component1()).intValue();
            int r14 = ((Number) r12.component2()).intValue();
            this.f21265d = bg.h.p(this.f21263b, r13);
            int r15 = r13 + r14;
            this.f21263b = r15;
            if (r14 != 0) goto L18;
            r10 = 1;
        L18:
            this.f21264c = r15 + r10;
            goto L19
        }

        public bg.c b() {
            if (this.f21262a != (-1)) goto L6;
            a();
        L6:
            if (this.f21262a == 0) goto L10;
            bg.c r10 = this.f21265d;
            kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f21265d = null;
            this.f21262a = -1;
            return r10;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21262a != (-1)) goto L6;
            a();
        L6:
            if (this.f21262a == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence r10, int r11, int r12, Function2 r13) {
        kotlin.jvm.internal.q.g(r10, "input");
        kotlin.jvm.internal.q.g(r13, "getNextMatch");
        this.f21258a = r10;
        this.f21259b = r11;
        this.f21260c = r12;
        this.f21261d = r13;
    }

    public static final /* synthetic */ Function2 a(d r10) {
        return r10.f21261d;
    }

    public static final /* synthetic */ CharSequence b(d r10) {
        return r10.f21258a;
    }

    public static final /* synthetic */ int c(d r10) {
        return r10.f21260c;
    }

    public static final /* synthetic */ int d(d r10) {
        return r10.f21259b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new a(this);
    }
}
