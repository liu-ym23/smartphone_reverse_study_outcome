package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ad;
import java.util.Comparator;

/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class x extends w {
    public x() {
    }

    public static /* synthetic */ boolean a(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return o.a(r0, r1, r2);
    }

    public static final boolean a(String r0, String r1, boolean r2) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        if (r2 == true) goto L10;
        return r0.equals(r1);
    L10:
        return r0.equalsIgnoreCase(r1);
    }

    public static /* synthetic */ String a(String r0, char r1, char r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return o.a(r0, r1, r2, r3);
    }

    public static final String a(String r4, char r5, char r6, boolean r7) {
        d.h.b.o.e(r4, "<this>");
        if (r7 == true) goto L6;
        String r8 = r4.replace(r5, r6);
        d.h.b.o.c(r8, "replace(...)");
        return r8;
    L6:
        StringBuilder r1 = new StringBuilder(r4.length());
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L8:
        if (r0 >= r9.length()) goto L13;
        char r2 = r9.charAt(r0);
        if (a.a(r2, r5, r7) == false) goto L12;
        r2 = r6;
    L12:
        r1.append(r2);
        r0 = r0 + 1;
        goto L8
    L13:
        String r10 = r1.toString();
        d.h.b.o.c(r10, "toString(...)");
        return r10;
    }

    public static /* synthetic */ String a(String r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return o.a(r0, r1, r2, r3);
    }

    public static final String a(String r7, String r8, String r9, boolean r10) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "oldValue");
        d.h.b.o.e(r9, "newValue");
        int r2 = 0;
        int r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, 0, r10);
        if (r0 >= 0) goto L5;
        return r7;
    L5:
        int r3 = r8.length();
        int r4 = d.l.n.c(r3, 1);
        int r5 = (r7.length() - r3) + r9.length();
        if (r5 < 0) goto L15;
        StringBuilder r6 = new StringBuilder(r5);
    L8:
        r6.append((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r2, r0).append(r9);
        r2 = r0 + r3;
        if (r0 >= r7.length()) goto L12;
        r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, r0 + r4, r10);
        if (r0 > 0) goto L8;
    L12:
        String r11 = r6.append((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r2, r7.length()).toString();
        d.h.b.o.c(r11, "toString(...)");
        return r11;
    L15:
        throw new OutOfMemoryError();
    }

    public static final String a(char[] r1) {
        d.h.b.o.e(r1, "<this>");
        return new String(r1);
    }

    public static final String a(char[] r2, int r3, int r4) {
        d.h.b.o.e(r2, "<this>");
        d.a.c.f38373a.b(r3, r4, r2.length);
        return new String(r2, r3, r4 - r3);
    }

    public static final String a(byte[] r2) {
        d.h.b.o.e(r2, "<this>");
        return new String(r2, d.f38623b);
    }

    public static /* synthetic */ boolean b(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return o.b(r0, r1, r2);
    }

    public static final boolean b(String r6, String r7, boolean r8) {
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "prefix");
        if (r8 == true) goto L7;
        return r6.startsWith(r7);
    L7:
        return o.a(r6, 0, r7, 0, r7.length(), r8);
    }

    public static /* synthetic */ boolean a(String r0, String r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return o.a(r0, r1, r2, r3);
    }

    public static final boolean a(String r6, String r7, int r8, boolean r9) {
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "prefix");
        if (r9 == true) goto L7;
        return r6.startsWith(r7, r8);
    L7:
        return o.a(r6, r8, r7, 0, r7.length(), r9);
    }

    public static /* synthetic */ boolean c(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return o.c(r0, r1, r2);
    }

    public static final boolean c(String r7, String r8, boolean r9) {
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "suffix");
        if (r9 == true) goto L7;
        return r7.endsWith(r8);
    L7:
        return o.a(r7, r7.length() - r8.length(), r8, 0, r8.length(), true);
    }

    public static final boolean a(CharSequence r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L7;
        if (r5 == null) goto L7;
        return ((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).contentEquals(r5);
    L7:
        return o.b(r4, r5);
    }

    public static /* synthetic */ boolean a(String r6, int r7, String r8, int r9, int r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        return o.a(r6, r7, r8, r9, r10, r11);
    }

    public static final boolean a(String r6, int r7, String r8, int r9, int r10, boolean r11) {
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r8, "other");
        if (r11 == true) goto L6;
        return r6.regionMatches(r7, r8, r9, r10);
    L6:
        return r6.regionMatches(r11, r7, r8, r9, r10);
    }

    public static final String a(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        int r0 = 0;
        int r1 = 1;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L26;
        if (r5 == 0) goto L29;
        if (r5 == 1) goto L24;
        int r3 = r6.length();
        if (r3 == 0) goto L30;
        if (r3 == 1) goto L19;
        StringBuilder r7 = new StringBuilder(r6.length() * r5);
        if (1 > r5) goto L18;
    L15:
        r7.append(r6);
        if (r1 == r5) goto L18;
        r1 = r1 + 1;
    L18:
        String r8 = r7.toString();
        d.h.b.o.a(r8);
        return r8;
    L19:
        char r9 = r6.charAt(0);
        char[] r10 = new char[r5];
    L20:
        if (r0 >= r5) goto L32;
        r10[r0] = r9;
        r0 = r0 + 1;
        goto L20
    L32:
        return new String(r10);
    L30:
        return "";
    L24:
        return r6.toString();
    L29:
        return "";
    L26:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r5 + '.').toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final Comparator<String> a(ad r1) {
        d.h.b.o.e(r1, "<this>");
        Comparator<String> r2 = String.CASE_INSENSITIVE_ORDER;
        d.h.b.o.c(r2, "CASE_INSENSITIVE_ORDER");
        return r2;
    }
}
