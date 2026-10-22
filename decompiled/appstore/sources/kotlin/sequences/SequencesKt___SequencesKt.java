package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SequencesKt___SequencesKt extends j {

    public static final class a implements Iterable, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Sequence f21206a;

        public a(Sequence r10) {
            this.f21206a = r10;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f21206a.iterator();
        }
    }

    public static Iterable h(Sequence r10) {
        q.g(r10, "<this>");
        return new a(r10);
    }

    public static int i(Sequence r10) {
        q.g(r10, "<this>");
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r11.next();
        r12 = r12 + 1;
        if (r12 >= 0) goto L4;
        t.p();
        goto L4
    L8:
        return r12;
    }

    public static Sequence j(Sequence r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "predicate");
        return new c(r10, true, r11);
    }

    public static final Sequence k(Sequence r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "predicate");
        return new c(r10, false, r11);
    }

    public static Sequence l(Sequence r10) {
        q.g(r10, "<this>");
        Sequence r11 = k(r10, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
        q.e(r11, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return r11;
    }

    public static Object m(Sequence r10) {
        q.g(r10, "<this>");
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L7;
        return null;
    L7:
        return r11.next();
    }

    public static Sequence n(Sequence r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "transform");
        return new d(r10, r11, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static final Appendable o(Sequence r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17) {
        q.g(r10, "<this>");
        q.g(r11, "buffer");
        q.g(r12, "separator");
        q.g(r13, "prefix");
        q.g(r14, "postfix");
        q.g(r16, "truncated");
        r11.append(r13);
        Iterator r18 = r10.iterator();
        int r19 = 0;
    L4:
        if (r18.hasNext() == false) goto L11;
        Object r20 = r18.next();
        r19 = r19 + 1;
        if (r19 <= 1) goto L8;
        r11.append(r12);
    L8:
        if (r15 < 0) goto L10;
        if (r19 > r15) goto L11;
    L10:
        kotlin.text.h.a(r11, r20, r17);
    L11:
        if (r15 < 0) goto L14;
        if (r19 <= r15) goto L14;
        r11.append(r16);
    L14:
        r11.append(r14);
        return r11;
    }

    public static final String p(Sequence r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16) {
        q.g(r10, "<this>");
        q.g(r11, "separator");
        q.g(r12, "prefix");
        q.g(r13, "postfix");
        q.g(r15, "truncated");
        String r17 = ((StringBuilder) o(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
        q.f(r17, "toString(...)");
        return r17;
    }

    public static /* synthetic */ String q(Sequence r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L5;
        r11 = ", ";
    L5:
        CharSequence r19 = "";
        if ((r17 & 2) == 0) goto L8;
        CharSequence r110 = "";
    L10:
        if ((r17 & 4) != 0) goto L14;
        r19 = r13;
    L14:
        if ((r17 & 8) == 0) goto L16;
        r14 = -1;
    L16:
        int r20 = r14;
        if ((r17 & 16) == 0) goto L19;
        r15 = "...";
    L19:
        CharSequence r21 = r15;
        if ((r17 & 32) == 0) goto L22;
        r16 = null;
    L22:
        CharSequence r22 = r11;
        CharSequence r23 = r110;
        CharSequence r24 = r19;
        return p(r10, r22, r23, r24, r20, r21, r16);
    L8:
        r110 = r12;
        goto L10
    }

    public static Object r(Sequence r10) {
        q.g(r10, "<this>");
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = r11.next();
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static Sequence s(Sequence r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "transform");
        return new l(r10, r11);
    }

    public static Sequence t(Sequence r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "transform");
        return l(new l(r10, r11));
    }

    public static Sequence u(Sequence r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "predicate");
        return new k(r10, r11);
    }

    public static final Collection v(Sequence r10, Collection r11) {
        q.g(r10, "<this>");
        q.g(r11, "destination");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r12.next());
        goto L4
    L6:
        return r11;
    }

    public static List w(Sequence r10) {
        q.g(r10, "<this>");
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == false) goto L5;
        Object r12 = r11.next();
        if (r11.hasNext() == false) goto L9;
        ArrayList r13 = new ArrayList();
        r13.add(r12);
    L12:
        if (r11.hasNext() == false) goto L14;
        r13.add(r11.next());
        goto L12
    L14:
        return r13;
    L9:
        return s.e(r12);
    L5:
        return t.i();
    }

    public static List x(Sequence r10) {
        q.g(r10, "<this>");
        return (List) v(r10, new ArrayList());
    }
}
