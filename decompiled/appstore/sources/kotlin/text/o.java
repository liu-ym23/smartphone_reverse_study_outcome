package kotlin.text;

import com.bytedanceos.common.model.AppInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.g0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o extends n {
    public static boolean A(String r10, String r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "prefix");
        if (r12 == true) goto L7;
        return r10.startsWith(r11);
    L7:
        return s(r10, 0, r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean B(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return A(r10, r11, r12);
    }

    public static String k(String r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Locale r11 = Locale.getDefault();
        kotlin.jvm.internal.q.f(r11, "getDefault(...)");
        return l(r10, r11);
    }

    public static final String l(String r10, Locale r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "locale");
        if (r10.length() <= 0) goto L12;
        char r12 = r10.charAt(0);
        if (Character.isLowerCase(r12) == false) goto L13;
        StringBuilder r13 = new StringBuilder();
        char r14 = Character.toTitleCase(r12);
        if (r14 == Character.toUpperCase(r12)) goto L9;
        r13.append(r14);
    L10:
        String r15 = r10.substring(1);
        kotlin.jvm.internal.q.f(r15, "substring(...)");
        r13.append(r15);
        String r16 = r13.toString();
        kotlin.jvm.internal.q.f(r16, "toString(...)");
        return r16;
    L9:
        String r17 = r10.substring(0, 1);
        kotlin.jvm.internal.q.f(r17, "substring(...)");
        kotlin.jvm.internal.q.e(r17, "null cannot be cast to non-null type java.lang.String");
        String r18 = r17.toUpperCase(r11);
        kotlin.jvm.internal.q.f(r18, "toUpperCase(...)");
        r13.append(r18);
        goto L10
    L13:
        return r10;
    L12:
        return r10;
    }

    public static boolean m(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == false) goto L7;
        if (r11 == null) goto L7;
        return ((String) r10).contentEquals(r11);
    L7:
        return StringsKt__StringsKt.F(r10, r11);
    }

    public static final boolean n(String r10, String r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "suffix");
        if (r12 == true) goto L7;
        return r10.endsWith(r11);
    L7:
        return s(r10, r10.length() - r11.length(), r11, 0, r11.length(), true);
    }

    public static /* synthetic */ boolean o(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return n(r10, r11, r12);
    }

    public static boolean p(String r10, String r11, boolean r12) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        if (r12 == true) goto L10;
        return r10.equals(r11);
    L10:
        return r10.equalsIgnoreCase(r11);
    }

    public static /* synthetic */ boolean q(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return p(r10, r11, r12);
    }

    public static boolean r(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.length() == 0) goto L15;
        Iterable r11 = StringsKt__StringsKt.J(r10);
        if ((r11 instanceof Collection) == true) goto L7;
    L9:
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        if (a.c(r10.charAt(((g0) r12).nextInt())) == true) goto L11;
        return false;
    L7:
        if (((Collection) r11).isEmpty() == false) goto L9;
    L15:
        return true;
    }

    public static final boolean s(String r10, int r11, String r12, int r13, int r14, boolean r15) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r12, AppInfo.SEARCH_SOURCE_EXTENAL);
        if (r15 == true) goto L6;
        return r10.regionMatches(r11, r12, r13, r14);
    L6:
        return r10.regionMatches(r15, r11, r12, r13, r14);
    }

    public static String t(CharSequence r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L23;
        if (r11 != 0) goto L7;
        return "";
    L7:
        if (r11 == 1) goto L21;
        int r12 = r10.length();
        if (r12 == 0) goto L27;
        if (r12 == 1) goto L16;
        StringBuilder r13 = new StringBuilder(r10.length() * r11);
        g0 r14 = new bg.c(1, r11).d();
    L13:
        if (r14.hasNext() == false) goto L15;
        r14.nextInt();
        r13.append(r10);
        goto L13
    L15:
        String r15 = r13.toString();
        kotlin.jvm.internal.q.d(r15);
        return r15;
    L16:
        int r16 = 0;
        char r17 = r10.charAt(0);
        char[] r18 = new char[r11];
    L17:
        if (r16 >= r11) goto L29;
        r18[r16] = r17;
        r16 = r16 + 1;
        goto L17
    L29:
        return new String(r18);
    L27:
        return "";
    L21:
        return r10.toString();
    L23:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r11 + '.').toString());
    }

    public static final String u(String r10, char r11, char r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r13 == true) goto L6;
        String r14 = r10.replace(r11, r12);
        kotlin.jvm.internal.q.f(r14, "replace(...)");
        return r14;
    L6:
        StringBuilder r15 = new StringBuilder(r10.length());
        int r16 = 0;
    L8:
        if (r16 >= r10.length()) goto L13;
        char r17 = r10.charAt(r16);
        if (b.d(r17, r11, r13) == false) goto L12;
        r17 = r12;
    L12:
        r15.append(r17);
        r16 = r16 + 1;
        goto L8
    L13:
        String r18 = r15.toString();
        kotlin.jvm.internal.q.f(r18, "toString(...)");
        return r18;
    }

    public static final String v(String r10, String r11, String r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "oldValue");
        kotlin.jvm.internal.q.g(r12, "newValue");
        int r14 = 0;
        int r15 = StringsKt__StringsKt.M(r10, r11, 0, r13);
        if (r15 >= 0) goto L5;
        return r10;
    L5:
        int r16 = r11.length();
        int r17 = bg.h.d(r16, 1);
        int r18 = (r10.length() - r16) + r12.length();
        if (r18 < 0) goto L15;
        StringBuilder r19 = new StringBuilder(r18);
    L8:
        r19.append(r10, r14, r15);
        r19.append(r12);
        r14 = r15 + r16;
        if (r15 >= r10.length()) goto L12;
        r15 = StringsKt__StringsKt.M(r10, r11, r15 + r17, r13);
        if (r15 > 0) goto L8;
    L12:
        r19.append(r10, r14, r10.length());
        String r20 = r19.toString();
        kotlin.jvm.internal.q.f(r20, "toString(...)");
        return r20;
    L15:
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String w(String r10, char r11, char r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return u(r10, r11, r12, r13);
    }

    public static /* synthetic */ String x(String r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return v(r10, r11, r12, r13);
    }

    public static final String y(String r10, String r11, String r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "oldValue");
        kotlin.jvm.internal.q.g(r12, "newValue");
        int r14 = StringsKt__StringsKt.Q(r10, r11, 0, r13, 2, null);
        if (r14 >= 0) goto L6;
        return r10;
    L6:
        return StringsKt__StringsKt.h0(r10, r14, r11.length() + r14, r12).toString();
    }

    public static /* synthetic */ String z(String r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return y(r10, r11, r12, r13);
    }
}
