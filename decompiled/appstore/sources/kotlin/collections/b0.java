package kotlin.collections;

import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b0 extends a0 {

    public static final class a implements Sequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f21075a;

        public a(Iterable r10) {
            this.f21075a = r10;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator iterator() {
            return this.f21075a.iterator();
        }
    }

    public static Set A0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L6;
        return new LinkedHashSet((Collection) r10);
    L6:
        return (Set) v0(r10, new LinkedHashSet());
    }

    public static Set B0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L17;
        Collection r11 = (Collection) r10;
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L10;
        return (Set) v0(r10, new LinkedHashSet(j0.e(r11.size())));
    L10:
        if ((r10 instanceof List) == false) goto L12;
        Object r13 = ((List) r10).get(0);
    L19:
        return q0.d(r13);
    L12:
        r13 = r10.iterator().next();
        goto L19
    L15:
        return r0.e();
    L17:
        return r0.h((Set) v0(r10, new LinkedHashSet()));
    }

    public static final List C0(Iterable r10, int r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        SlidingWindowKt.a(r11, r12);
        if ((r10 instanceof RandomAccess) == true) goto L5;
    L21:
        ArrayList r14 = new ArrayList();
        Iterator r15 = SlidingWindowKt.b(r10.iterator(), r11, r12, r13, false);
    L23:
        if (r15.hasNext() == false) goto L25;
        r14.add((List) r15.next());
        goto L23
    L25:
        return r14;
    L5:
        if ((r10 instanceof List) == false) goto L21;
        List r16 = (List) r10;
        int r17 = r16.size();
        int r18 = r17 / r12;
        if ((r17 % r12) != 0) goto L9;
        int r19 = 0;
    L10:
        ArrayList r20 = new ArrayList(r18 + r19);
        int r21 = 0;
    L11:
        if (r21 < 0) goto L20;
        if (r21 >= r17) goto L20;
        int r22 = bg.h.g(r11, r17 - r21);
        if (r22 >= r11) goto L16;
        if (r13 == false) goto L20;
    L16:
        ArrayList r23 = new ArrayList(r22);
        int r24 = 0;
    L17:
        if (r24 >= r22) goto L19;
        r23.add(r16.get(r24 + r21));
        r24 = r24 + 1;
        goto L17
    L19:
        r20.add(r23);
        r21 = r21 + r12;
    L20:
        return r20;
    L9:
        r19 = 1;
        goto L10
    }

    public static /* synthetic */ List D0(Iterable r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return C0(r10, r11, r12, r13);
    }

    public static List E0(Iterable r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        Iterator r12 = r10.iterator();
        Iterator r13 = r11.iterator();
        ArrayList r14 = new ArrayList(Math.min(u.r(r10, 10), u.r(r11, 10)));
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r13.hasNext() == false) goto L8;
        r14.add(kotlin.d.a(r12.next(), r13.next()));
    L8:
        return r14;
    }

    public static Sequence Q(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new a(r10);
    }

    public static List R(Iterable r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return C0(r10, r11, r11, true);
    }

    public static boolean S(Iterable r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L7;
        return ((Collection) r10).contains(r11);
    L7:
        if (b0(r10, r11) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static List T(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return x0(A0(r10));
    }

    public static List U(List r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L7;
        return u0(r10, bg.h.d(r10.size() - r11, 0));
    L7:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    }

    public static List V(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return (List) W(r10, new ArrayList());
    }

    public static final Collection W(Iterable r10, Collection r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (r13 == null) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static Object X(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == false) goto L11;
        return r11.next();
    L11:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return Y((List) r10);
    }

    public static Object Y(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.get(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static Object Z(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.get(0);
    }

    public static Object a0(List r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > t.k(r10)) goto L7;
        return r10.get(r11);
    }

    public static final int b0(Iterable r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L8:
        if (r12.hasNext() == false) goto L16;
        Object r14 = r12.next();
        if (r13 >= 0) goto L13;
        t.q();
    L13:
        if (kotlin.jvm.internal.q.b(r11, r14) == true) goto L14;
        r13 = r13 + 1;
        goto L8
    L14:
        return r13;
    L16:
        return -1;
    L5:
        return ((List) r10).indexOf(r11);
    }

    public static int c0(List r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.indexOf(r11);
    }

    public static Set d0(Iterable r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        Set r12 = A0(r10);
        y.F(r12, r11);
        return r12;
    }

    public static final Appendable e0(Iterable r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "buffer");
        kotlin.jvm.internal.q.g(r12, "separator");
        kotlin.jvm.internal.q.g(r13, "prefix");
        kotlin.jvm.internal.q.g(r14, "postfix");
        kotlin.jvm.internal.q.g(r16, "truncated");
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

    public static /* synthetic */ Appendable f0(Iterable r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17, int r18, Object r19) {
        if ((r18 & 2) == 0) goto L5;
        CharSequence r20 = ", ";
    L6:
        CharSequence r21 = "";
        if ((r18 & 4) == 0) goto L9;
        CharSequence r22 = "";
    L11:
        if ((r18 & 8) != 0) goto L15;
        r21 = r14;
    L15:
        if ((r18 & 16) == 0) goto L17;
        int r23 = -1;
    L19:
        if ((r18 & 32) == 0) goto L21;
        CharSequence r24 = "...";
    L23:
        if ((r18 & 64) == 0) goto L25;
        Function1 r25 = null;
    L27:
        return e0(r10, r11, r20, r22, r21, r23, r24, r25);
    L25:
        r25 = r17;
        goto L27
    L21:
        r24 = r16;
        goto L23
    L17:
        r23 = r15;
        goto L19
    L9:
        r22 = r13;
        goto L11
    L5:
        r20 = r12;
        goto L6
    }

    public static final String g0(Iterable r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "separator");
        kotlin.jvm.internal.q.g(r12, "prefix");
        kotlin.jvm.internal.q.g(r13, "postfix");
        kotlin.jvm.internal.q.g(r15, "truncated");
        String r17 = ((StringBuilder) e0(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
        kotlin.jvm.internal.q.f(r17, "toString(...)");
        return r17;
    }

    public static /* synthetic */ String h0(Iterable r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
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
        return g0(r10, r22, r23, r24, r20, r21, r16);
    L8:
        r110 = r12;
        goto L10
    }

    public static Object i0(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.get(t.k(r10));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static Object j0(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.get(r10.size() - 1);
    }

    public static Comparable k0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        Comparable r12 = (Comparable) r11.next();
    L8:
        if (r11.hasNext() == false) goto L12;
        Comparable r13 = (Comparable) r11.next();
        if (r12.compareTo(r13) >= 0) goto L8;
        r12 = r13;
        goto L8
    L12:
        return r12;
    }

    public static Comparable l0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        Comparable r12 = (Comparable) r11.next();
    L8:
        if (r11.hasNext() == false) goto L12;
        Comparable r13 = (Comparable) r11.next();
        if (r12.compareTo(r13) <= 0) goto L8;
        r12 = r13;
        goto L8
    L12:
        return r12;
    }

    public static List m0(Iterable r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r12 = new ArrayList(u.r(r10, 10));
        Iterator r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L12;
        Object r15 = r13.next();
        boolean r16 = true;
        if (r14 == false) goto L8;
    L10:
        if (r16 == false) goto L4;
        r12.add(r15);
        goto L4
    L8:
        if (kotlin.jvm.internal.q.b(r15, r11) == false) goto L10;
        r14 = true;
        r16 = false;
        goto L10
    L12:
        return r12;
    }

    public static List n0(Collection r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "elements");
        if ((r11 instanceof Collection) == false) goto L6;
        Collection r12 = (Collection) r11;
        ArrayList r13 = new ArrayList(r10.size() + r12.size());
        r13.addAll(r10);
        r13.addAll(r12);
        return r13;
    L6:
        ArrayList r14 = new ArrayList(r10);
        y.v(r14, r11);
        return r14;
    }

    public static List o0(Collection r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r12 = new ArrayList(r10.size() + 1);
        r12.addAll(r10);
        r12.add(r11);
        return r12;
    }

    public static List p0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L5;
    L8:
        List r11 = y0(r10);
        a0.O(r11);
        return r11;
    L5:
        if (((Collection) r10).size() > 1) goto L8;
        return x0(r10);
    }

    public static Object q0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == false) goto L14;
        Object r12 = r11.next();
        if (r11.hasNext() == true) goto L12;
        return r12;
    L12:
        throw new IllegalArgumentException("Collection has more than one element.");
    L14:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return r0((List) r10);
    }

    public static final Object r0(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L9;
        return r10.get(0);
    L9:
        throw new IllegalArgumentException("List has more than one element.");
    L11:
        throw new NoSuchElementException("List is empty.");
    }

    public static List s0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L10;
        Collection r11 = (Collection) r10;
        if (r11.size() <= 1) goto L7;
        Object[] r12 = r11.toArray(new Comparable[0]);
        m.k((Comparable[]) r12);
        return m.d(r12);
    L7:
        return x0(r10);
    L10:
        List r13 = y0(r10);
        x.t(r13);
        return r13;
    }

    public static List t0(Iterable r10, Comparator r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "comparator");
        if ((r10 instanceof Collection) == false) goto L10;
        Collection r12 = (Collection) r10;
        if (r12.size() <= 1) goto L7;
        Object[] r13 = r12.toArray(new Object[0]);
        m.l(r13, r11);
        return m.d(r13);
    L7:
        return x0(r10);
    L10:
        List r14 = y0(r10);
        x.u(r14, r11);
        return r14;
    }

    public static List u0(Iterable r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L24;
        if (r11 != 0) goto L8;
        return t.i();
    L8:
        if ((r10 instanceof Collection) == true) goto L10;
    L16:
        ArrayList r12 = new ArrayList(r11);
        Iterator r13 = r10.iterator();
        int r14 = 0;
    L18:
        if (r13.hasNext() == false) goto L22;
        r12.add(r13.next());
        r14 = r14 + 1;
        if (r14 != r11) goto L18;
    L22:
        return t.o(r12);
    L10:
        if (r11 >= ((Collection) r10).size()) goto L12;
        if (r11 != 1) goto L16;
        return s.e(X(r10));
    L12:
        return x0(r10);
    L24:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    }

    public static final Collection v0(Iterable r10, Collection r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r12.next());
        goto L4
    L6:
        return r11;
    }

    public static int[] w0(Collection r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int[] r11 = new int[r10.size()];
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = ((Number) r12.next()).intValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static List x0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L17;
        Collection r11 = (Collection) r10;
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L10;
        return z0(r11);
    L10:
        if ((r10 instanceof List) == false) goto L12;
        Object r13 = ((List) r10).get(0);
    L19:
        return s.e(r13);
    L12:
        r13 = r10.iterator().next();
        goto L19
    L15:
        return t.i();
    L17:
        return t.o(y0(r10));
    }

    public static final List y0(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L7;
        return z0((Collection) r10);
    L7:
        return (List) v0(r10, new ArrayList());
    }

    public static List z0(Collection r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new ArrayList(r10);
    }
}
