package r4;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: r4.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1017D extends C1016C {
    public static final String j0(String str, int i5) {
        j4.k.g(str, "<this>");
        if (i5 >= 0) {
            String strSubstring = str.substring(kotlin.ranges.l.e(i5, str.length()));
            j4.k.f(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static char k0(CharSequence charSequence) {
        j4.k.g(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(C1015B.w(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }
}
