package kotlin.collections;

import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n extends m {

    public static final class a implements Iterable, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f21100a;

        public a(Object[] r10) {
            this.f21100a = r10;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return kotlin.jvm.internal.h.a(this.f21100a);
        }
    }

    public static final String A(Object[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "separator");
        kotlin.jvm.internal.q.g(r12, "prefix");
        kotlin.jvm.internal.q.g(r13, "postfix");
        kotlin.jvm.internal.q.g(r15, "truncated");
        String r17 = ((StringBuilder) y(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
        kotlin.jvm.internal.q.f(r17, "toString(...)");
        return r17;
    }

    public static /* synthetic */ String B(byte[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
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
        return z(r10, r22, r23, r24, r20, r21, r16);
    L8:
        r110 = r12;
        goto L10
    }

    public static /* synthetic */ String C(Object[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
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
        return A(r10, r22, r23, r24, r20, r21, r16);
    L8:
        r110 = r12;
        goto L10
    }

    public static char D(char[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L9;
        return r10[0];
    L9:
        throw new IllegalArgumentException("Array has more than one element.");
    L11:
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object E(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.length == 1) goto L7;
        return null;
    L7:
        return r10[0];
    }

    public static float F(float[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length;
        float r12 = 0.0f;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12 = r12 + r10[r13];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static final List G(Object[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L20;
        if (r11 == 0) goto L6;
        int r12 = r10.length;
        if (r11 < r12) goto L12;
        return K(r10);
    L12:
        if (r11 == 1) goto L14;
        ArrayList r13 = new ArrayList(r11);
        int r14 = r12 - r11;
    L16:
        if (r14 >= r12) goto L18;
        r13.add(r10[r14]);
        r14 = r14 + 1;
        goto L16
    L18:
        return r13;
    L14:
        return s.e(r10[r12 - 1]);
    L6:
        return t.i();
    L20:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    }

    public static final Collection H(int[] r10, Collection r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(Integer.valueOf(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Collection I(Object[] r10, Collection r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static List J(long[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length;
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return L(r10);
    L11:
        return s.e(Long.valueOf(r10[0]));
    L9:
        return t.i();
    }

    public static List K(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length;
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return M(r10);
    L11:
        return s.e(r10[0]);
    L9:
        return t.i();
    }

    public static final List L(long[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(Long.valueOf(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static List M(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new ArrayList(t.h(r10));
    }

    public static Set N(int[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length;
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return (Set) H(r10, new LinkedHashSet(j0.e(r10.length)));
    L11:
        return q0.d(Integer.valueOf(r10[0]));
    L9:
        return r0.e();
    }

    public static Set O(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.length;
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return (Set) I(r10, new LinkedHashSet(j0.e(r10.length)));
    L11:
        return q0.d(r10[0]);
    L9:
        return r0.e();
    }

    public static List P(Object[] r10, Object[] r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        int r12 = Math.min(r10.length, r11.length);
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13.add(kotlin.d.a(r10[r14], r11[r14]));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    public static Iterable m(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.length != 0) goto L7;
        return t.i();
    L7:
        return new a(r10);
    }

    public static boolean n(char[] r10, char r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (v(r10, r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean o(Object[] r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (w(r10, r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List p(Object[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L7;
        return G(r10, bg.h.d(r10.length - r11, 0));
    L7:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    }

    public static List q(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return (List) r(r10, new ArrayList());
    }

    public static final Collection r(Object[] r10, Collection r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Object r14 = r10[r13];
        if (r14 == null) goto L7;
        r11.add(r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r11;
    }

    public static Object s(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.length != 0) goto L6;
        return null;
    L6:
        return r10[0];
    }

    public static int t(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.length - 1;
    }

    public static Object u(Object[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > t(r10)) goto L7;
        return r10[r11];
    }

    public static final int v(char[] r10, char r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11 == r10[r13]) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return -1;
    }

    public static final int w(Object[] r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r12 = 0;
        if (r11 != null) goto L10;
        int r13 = r10.length;
    L5:
        if (r12 >= r13) goto L16;
        if (r10[r12] == null) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return r12;
    L16:
        return -1;
    L10:
        int r14 = r10.length;
    L11:
        if (r12 >= r14) goto L22;
        if (kotlin.jvm.internal.q.b(r11, r10[r12]) == true) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        return r12;
    L22:
        return -1;
    }

    public static final Appendable x(byte[] r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "buffer");
        kotlin.jvm.internal.q.g(r12, "separator");
        kotlin.jvm.internal.q.g(r13, "prefix");
        kotlin.jvm.internal.q.g(r14, "postfix");
        kotlin.jvm.internal.q.g(r16, "truncated");
        r11.append(r13);
        int r18 = r10.length;
        int r19 = 0;
        int r20 = 0;
    L3:
        if (r19 >= r18) goto L13;
        byte r21 = r10[r19];
        r20 = r20 + 1;
        if (r20 <= 1) goto L7;
        r11.append(r12);
    L7:
        if (r15 < 0) goto L9;
        if (r20 > r15) goto L13;
    L9:
        if (r17 == null) goto L11;
        r11.append((CharSequence) r17.invoke(Byte.valueOf(r21)));
    L12:
        r19 = r19 + 1;
        goto L3
    L11:
        r11.append(String.valueOf(r21));
    L13:
        if (r15 < 0) goto L16;
        if (r20 <= r15) goto L16;
        r11.append(r16);
    L16:
        r11.append(r14);
        return r11;
    }

    public static final Appendable y(Object[] r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "buffer");
        kotlin.jvm.internal.q.g(r12, "separator");
        kotlin.jvm.internal.q.g(r13, "prefix");
        kotlin.jvm.internal.q.g(r14, "postfix");
        kotlin.jvm.internal.q.g(r16, "truncated");
        r11.append(r13);
        int r18 = r10.length;
        int r19 = 0;
        int r20 = 0;
    L3:
        if (r19 >= r18) goto L10;
        Object r21 = r10[r19];
        r20 = r20 + 1;
        if (r20 <= 1) goto L7;
        r11.append(r12);
    L7:
        if (r15 < 0) goto L9;
        if (r20 > r15) goto L10;
    L9:
        kotlin.text.h.a(r11, r21, r17);
        r19 = r19 + 1;
    L10:
        if (r15 < 0) goto L13;
        if (r20 <= r15) goto L13;
        r11.append(r16);
    L13:
        r11.append(r14);
        return r11;
    }

    public static final String z(byte[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "separator");
        kotlin.jvm.internal.q.g(r12, "prefix");
        kotlin.jvm.internal.q.g(r13, "postfix");
        kotlin.jvm.internal.q.g(r15, "truncated");
        String r17 = ((StringBuilder) x(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
        kotlin.jvm.internal.q.f(r17, "toString(...)");
        return r17;
    }
}
