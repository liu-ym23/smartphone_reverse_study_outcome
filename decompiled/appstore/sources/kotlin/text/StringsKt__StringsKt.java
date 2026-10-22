package kotlin.text;

import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.g0;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StringsKt__StringsKt extends o {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f21250b;

        public a(CharSequence r10) {
            this.f21250b = r10;
        }

        @Override // kotlin.collections.r
        public char a() {
            CharSequence r10 = this.f21250b;
            int r11 = this.f21249a;
            this.f21249a = r11 + 1;
            return r10.charAt(r11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21249a >= this.f21250b.length()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static CharSequence A0(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (kotlin.text.a.c(r10.charAt(r12)) == false) goto L12;
        r12 = r12 + 1;
        goto L3
    L12:
        return r10.subSequence(r12, r10.length());
    L8:
        return "";
    }

    public static String B0(String r10, char... r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "chars");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (kotlin.collections.n.n(r11, r10.charAt(r13)) == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        CharSequence r14 = r10.subSequence(r13, r10.length());
    L10:
        return r14.toString();
    L8:
        r14 = "";
        goto L10
    }

    public static final /* synthetic */ Pair C(CharSequence r10, Collection r11, int r12, boolean r13, boolean r14) {
        return I(r10, r11, r12, r13, r14);
    }

    public static boolean D(CharSequence r11, CharSequence r12, boolean r13) {
        kotlin.jvm.internal.q.g(r11, "<this>");
        kotlin.jvm.internal.q.g(r12, AppInfo.SEARCH_SOURCE_EXTENAL);
        if ((r12 instanceof String) == false) goto L8;
        if (Q(r11, (String) r12, 0, r13, 2, null) >= 0) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (O(r11, r12, 0, r11.length(), r13, false, 16, null) >= 0) goto L11;
        return false;
    }

    public static /* synthetic */ boolean E(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return D(r10, r11, r12);
    }

    public static final boolean F(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == false) goto L9;
        if ((r11 instanceof String) == false) goto L9;
        return kotlin.jvm.internal.q.b(r10, r11);
    L9:
        if (r10 != r11) goto L12;
        return true;
    L12:
        if (r10 == null) goto L24;
        if (r11 == null) goto L24;
        if (r10.length() != r11.length()) goto L24;
        int r12 = r10.length();
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L23;
        if (r10.charAt(r13) != r11.charAt(r13)) goto L21;
        r13 = r13 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean G(CharSequence r10, CharSequence r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "suffix");
        if (r12 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return o.o((String) r10, (String) r11, false, 2, null);
    L11:
        return e0(r10, r10.length() - r11.length(), r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean H(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return G(r10, r11, r12);
    }

    public static final Pair I(CharSequence r10, Collection r11, int r12, boolean r13, boolean r14) {
        if (r13 == true) goto L15;
        if (r11.size() != 1) goto L15;
        String r15 = (String) b0.q0(r11);
        if (r14 == true) goto L9;
        int r16 = Q(r10, r15, r12, false, 4, null);
    L10:
        if (r16 >= 0) goto L13;
        return null;
    L13:
        return kotlin.d.a(Integer.valueOf(r16), r15);
    L9:
        r16 = W(r10, r15, r12, false, 4, null);
    L15:
        if (r14 == true) goto L17;
        bg.a r17 = new bg.c(bg.h.d(r12, 0), r10.length());
    L19:
        if ((r10 instanceof String) == false) goto L38;
        int r18 = r17.a();
        int r19 = r17.b();
        int r110 = r17.c();
        if (r110 <= 0) goto L23;
        if (r18 > r19) goto L23;
    L25:
        Iterator r20 = r11.iterator();
    L27:
        if (r20.hasNext() == false) goto L31;
        Object r21 = r20.next();
        String r22 = (String) r21;
        if (o.s(r22, 0, (String) r10, r18, r22.length(), r13) == false) goto L27;
    L32:
        String r23 = (String) r21;
        if (r23 != null) goto L35;
        if (r18 == r19) goto L56;
        r18 = r18 + r110;
    L56:
        return null;
    L35:
        return kotlin.d.a(Integer.valueOf(r18), r23);
    L31:
        r21 = null;
    L23:
        if (r110 >= 0) goto L56;
        if (r19 > r18) goto L56;
    L38:
        int r111 = r17.a();
        int r24 = r17.b();
        int r112 = r17.c();
        if (r112 <= 0) goto L41;
        if (r111 > r24) goto L41;
    L43:
        Iterator r25 = r11.iterator();
    L45:
        if (r25.hasNext() == false) goto L49;
        Object r26 = r25.next();
        String r27 = (String) r26;
        if (e0(r27, 0, r10, r111, r27.length(), r13) == false) goto L45;
    L50:
        String r28 = (String) r26;
        if (r28 != null) goto L53;
        if (r111 == r24) goto L56;
        r111 = r111 + r112;
        goto L43
    L53:
        return kotlin.d.a(Integer.valueOf(r111), r28);
    L49:
        r26 = null;
    L41:
        if (r112 >= 0) goto L56;
        if (r24 > r111) goto L56;
    L17:
        r17 = bg.h.m(bg.h.g(r12, K(r10)), 0);
        goto L19
    }

    public static final bg.c J(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new bg.c(0, r10.length() - 1);
    }

    public static int K(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.length() - 1;
    }

    public static final int L(CharSequence r10, char r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).indexOf(r11, r12);
    L9:
        return R(r10, new char[]{r11}, r12, r13);
    }

    public static final int M(CharSequence r10, String r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "string");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).indexOf(r11, r12);
    L9:
        return O(r10, r11, r12, r10.length(), r13, false, 16, null);
    }

    public static final int N(CharSequence r10, CharSequence r11, int r12, int r13, boolean r14, boolean r15) {
        if (r15 == true) goto L5;
        bg.a r16 = new bg.c(bg.h.d(r12, 0), bg.h.g(r13, r10.length()));
    L7:
        if ((r10 instanceof String) == true) goto L9;
    L20:
        int r17 = r16.a();
        int r18 = r16.b();
        int r19 = r16.c();
        if (r19 <= 0) goto L23;
        if (r17 > r18) goto L23;
    L25:
        int r20 = r17;
        if (e0(r11, 0, r10, r20, r11.length(), r14) == true) goto L27;
        if (r17 == r18) goto L42;
        r17 = r17 + r19;
        goto L25
    L42:
        return -1;
    L27:
        return r17;
    L23:
        if (r19 >= 0) goto L39;
        if (r18 <= r17) goto L25;
        return -1;
    L39:
        return -1;
    L9:
        if ((r11 instanceof String) == false) goto L20;
        int r21 = r16.a();
        int r22 = r16.b();
        int r110 = r16.c();
        if (r110 <= 0) goto L13;
        if (r21 > r22) goto L13;
    L15:
        int r23 = r21;
        if (o.s((String) r11, 0, (String) r10, r23, r11.length(), r14) == true) goto L17;
        if (r21 == r22) goto L41;
        r21 = r21 + r110;
        goto L15
    L41:
        return -1;
    L17:
        return r21;
    L13:
        if (r110 >= 0) goto L30;
        if (r22 <= r21) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r16 = bg.h.m(bg.h.g(r12, K(r10)), bg.h.d(r13, 0));
        goto L7
    }

    public static /* synthetic */ int O(CharSequence r10, CharSequence r11, int r12, int r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return N(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ int P(CharSequence r10, char r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return L(r10, r11, r12, r13);
    }

    public static /* synthetic */ int Q(CharSequence r10, String r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return M(r10, r11, r12, r13);
    }

    public static final int R(CharSequence r10, char[] r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "chars");
        if (r13 == false) goto L5;
    L10:
        g0 r14 = new bg.c(bg.h.d(r12, 0), K(r10)).d();
    L12:
        if (r14.hasNext() == false) goto L19;
        int r15 = r14.nextInt();
        char r16 = r10.charAt(r15);
        int r17 = r11.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L12;
        if (b.d(r11[r18], r16, r13) == true) goto L17;
        r18 = r18 + 1;
        goto L14
    L17:
        return r15;
    L19:
        return -1;
    L5:
        if (r11.length != 1) goto L10;
        if ((r10 instanceof String) == false) goto L10;
        return ((String) r10).indexOf(kotlin.collections.n.D(r11), r12);
    }

    public static final r S(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new a(r10);
    }

    public static final int T(CharSequence r10, char r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).lastIndexOf(r11, r12);
    L9:
        return X(r10, new char[]{r11}, r12, r13);
    }

    public static final int U(CharSequence r10, String r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "string");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).lastIndexOf(r11, r12);
    L9:
        return N(r10, r11, r12, 0, r13, true);
    }

    public static /* synthetic */ int V(CharSequence r10, char r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = K(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return T(r10, r11, r12, r13);
    }

    public static /* synthetic */ int W(CharSequence r10, String r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = K(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return U(r10, r11, r12, r13);
    }

    public static final int X(CharSequence r10, char[] r11, int r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "chars");
        if (r13 == false) goto L5;
    L10:
        int r14 = bg.h.g(r12, K(r10));
    L12:
        if ((-1) >= r14) goto L20;
        char r15 = r10.charAt(r14);
        int r16 = r11.length;
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L19;
        if (b.d(r11[r17], r15, r13) == true) goto L17;
        r17 = r17 + 1;
        goto L14
    L17:
        return r14;
    L19:
        r14 = r14 - 1;
        goto L12
    L20:
        return -1;
    L5:
        if (r11.length != 1) goto L10;
        if ((r10 instanceof String) == false) goto L10;
        return ((String) r10).lastIndexOf(kotlin.collections.n.D(r11), r12);
    }

    public static final Sequence Y(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return n0(r10, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List Z(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return SequencesKt___SequencesKt.w(Y(r10));
    }

    public static final CharSequence a0(CharSequence r10, int r11, char r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L15;
        if (r11 <= r10.length()) goto L7;
        StringBuilder r13 = new StringBuilder(r11);
        g0 r14 = new bg.c(1, r11 - r10.length()).d();
    L10:
        if (r14.hasNext() == false) goto L12;
        r14.nextInt();
        r13.append(r12);
        goto L10
    L12:
        r13.append(r10);
        return r13;
    L7:
        return r10.subSequence(0, r10.length());
    L15:
        throw new IllegalArgumentException("Desired length " + r11 + " is less than zero.");
    }

    public static String b0(String r10, int r11, char r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return a0(r10, r11, r12).toString();
    }

    public static final Sequence c0(CharSequence r10, String[] r11, int r12, final boolean r13, int r14) {
        i0(r14);
        final List r15 = kotlin.collections.m.d(r11);
        return new d(r10, r12, r14, new StringsKt__StringsKt$rangesDelimitedBy$2(r15, r13));
    }

    public static /* synthetic */ Sequence d0(CharSequence r10, String[] r11, int r12, boolean r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = 0;
    L12:
        return c0(r10, r11, r12, r13, r14);
    }

    public static final boolean e0(CharSequence r10, int r11, CharSequence r12, int r13, int r14, boolean r15) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r12, AppInfo.SEARCH_SOURCE_EXTENAL);
        if (r13 < 0) goto L18;
        if (r11 < 0) goto L18;
        if (r11 > (r10.length() - r14)) goto L18;
        if (r13 > (r12.length() - r14)) goto L18;
        int r16 = 0;
    L11:
        if (r16 >= r14) goto L16;
        if (b.d(r10.charAt(r11 + r16), r12.charAt(r13 + r16), r15) == false) goto L14;
        r16 = r16 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static String f0(String r10, CharSequence r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "prefix");
        if (p0(r10, r11, false, 2, null) == false) goto L6;
        String r12 = r10.substring(r11.length());
        kotlin.jvm.internal.q.f(r12, "substring(...)");
        return r12;
    L6:
        return r10;
    }

    public static String g0(String r10, CharSequence r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "suffix");
        if (H(r10, r11, false, 2, null) == false) goto L6;
        String r12 = r10.substring(0, r10.length() - r11.length());
        kotlin.jvm.internal.q.f(r12, "substring(...)");
        return r12;
    L6:
        return r10;
    }

    public static final CharSequence h0(CharSequence r10, int r11, int r12, CharSequence r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r13, "replacement");
        if (r12 < r11) goto L7;
        StringBuilder r14 = new StringBuilder();
        r14.append(r10, 0, r11);
        kotlin.jvm.internal.q.f(r14, "append(...)");
        r14.append(r13);
        r14.append(r10, r12, r10.length());
        kotlin.jvm.internal.q.f(r14, "append(...)");
        return r14;
    L7:
        throw new IndexOutOfBoundsException("End index (" + r12 + ") is less than start index (" + r11 + ").");
    }

    public static final void i0(int r10) {
        if (r10 < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + r10).toString());
    }

    public static final List j0(CharSequence r10, String[] r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "delimiters");
        if (r11.length != 1) goto L9;
        String r14 = r11[0];
        if (r14.length() == 0) goto L9;
        return k0(r10, r14, r12, r13);
    L9:
        Iterable r15 = SequencesKt___SequencesKt.h(d0(r10, r11, 0, r12, r13, 2, null));
        ArrayList r16 = new ArrayList(u.r(r15, 10));
        Iterator r17 = r15.iterator();
    L11:
        if (r17.hasNext() == false) goto L13;
        r16.add(q0(r10, (bg.c) r17.next()));
        goto L11
    L13:
        return r16;
    }

    public static final List k0(CharSequence r10, String r11, boolean r12, int r13) {
        i0(r13);
        int r14 = 0;
        int r15 = M(r10, r11, 0, r12);
        if (r15 == (-1)) goto L23;
        if (r13 == 1) goto L23;
        if (r13 <= 0) goto L9;
        boolean r16 = true;
    L10:
        int r17 = 10;
        if (r16 == false) goto L13;
        r17 = bg.h.g(r13, 10);
    L13:
        ArrayList r18 = new ArrayList(r17);
    L14:
        r18.add(r10.subSequence(r14, r15).toString());
        r14 = r11.length() + r15;
        if (r16 == true) goto L17;
    L18:
        r15 = M(r10, r11, r14, r12);
        if (r15 != (-1)) goto L14;
    L20:
        r18.add(r10.subSequence(r14, r10.length()).toString());
        return r18;
    L17:
        if (r18.size() == (r13 - 1)) goto L20;
    L9:
        r16 = false;
    L23:
        return s.e(r10.toString());
    }

    public static /* synthetic */ List l0(CharSequence r10, String[] r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return j0(r10, r11, r12, r13);
    }

    public static final Sequence m0(final CharSequence r10, String[] r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "delimiters");
        return SequencesKt___SequencesKt.s(d0(r10, r11, 0, r12, r13, 2, null), new StringsKt__StringsKt$splitToSequence$1(r10));
    }

    public static /* synthetic */ Sequence n0(CharSequence r10, String[] r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return m0(r10, r11, r12, r13);
    }

    public static final boolean o0(CharSequence r10, CharSequence r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "prefix");
        if (r12 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return o.B((String) r10, (String) r11, false, 2, null);
    L11:
        return e0(r10, 0, r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean p0(CharSequence r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return o0(r10, r11, r12);
    }

    public static final String q0(CharSequence r10, bg.c r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "range");
        return r10.subSequence(r11.i().intValue(), r11.h().intValue() + 1).toString();
    }

    public static final String r0(String r10, char r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r12, "missingDelimiterValue");
        int r13 = P(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + 1, r10.length());
        kotlin.jvm.internal.q.f(r14, "substring(...)");
        return r14;
    L7:
        return r12;
    }

    public static final String s0(String r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "delimiter");
        kotlin.jvm.internal.q.g(r12, "missingDelimiterValue");
        int r13 = Q(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + r11.length(), r10.length());
        kotlin.jvm.internal.q.f(r14, "substring(...)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String t0(String r10, char r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return r0(r10, r11, r12);
    }

    public static /* synthetic */ String u0(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return s0(r10, r11, r12);
    }

    public static String v0(String r10, char r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r12, "missingDelimiterValue");
        int r13 = V(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(r13 + 1, r10.length());
        kotlin.jvm.internal.q.f(r14, "substring(...)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String w0(String r10, char r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return v0(r10, r11, r12);
    }

    public static final String x0(String r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "delimiter");
        kotlin.jvm.internal.q.g(r12, "missingDelimiterValue");
        int r13 = Q(r10, r11, 0, false, 6, null);
        if (r13 == (-1)) goto L7;
        String r14 = r10.substring(0, r13);
        kotlin.jvm.internal.q.f(r14, "substring(...)");
        return r14;
    L7:
        return r12;
    }

    public static /* synthetic */ String y0(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10;
    L6:
        return x0(r10, r11, r12);
    }

    public static CharSequence z0(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length() - 1;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 > r11) goto L16;
        if (r13 == true) goto L6;
        int r14 = r12;
    L7:
        boolean r15 = kotlin.text.a.c(r10.charAt(r14));
        if (r13 == false) goto L9;
        if (r15 == false) goto L16;
        r11 = r11 - 1;
        goto L3
    L9:
        if (r15 == false) goto L10;
        r12 = r12 + 1;
        goto L3
    L10:
        r13 = true;
        goto L3
    L6:
        r14 = r11;
    L16:
        return r10.subSequence(r12, r11 + 1);
    }
}
