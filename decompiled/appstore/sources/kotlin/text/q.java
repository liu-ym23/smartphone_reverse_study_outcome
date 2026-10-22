package kotlin.text;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q extends p {
    public static final String C0(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L7;
        String r12 = r10.substring(bg.h.g(r11, r10.length()));
        kotlin.jvm.internal.q.f(r12, "substring(...)");
        return r12;
    L7:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    }

    public static String D0(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L7;
        return F0(r10, bg.h.d(r10.length() - r11, 0));
    L7:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    }

    public static char E0(CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.length() == 0) goto L7;
        return r10.charAt(StringsKt__StringsKt.K(r10));
    L7:
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final String F0(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 < 0) goto L7;
        String r12 = r10.substring(0, bg.h.g(r11, r10.length()));
        kotlin.jvm.internal.q.f(r12, "substring(...)");
        return r12;
    L7:
        throw new IllegalArgumentException(("Requested character count " + r11 + " is less than zero.").toString());
    }
}
