package i0;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0618a {
    public static boolean a(String current, String str) {
        Intrinsics.checkNotNullParameter(current, "current");
        if (Intrinsics.areEqual(current, str)) {
            return true;
        }
        if (current.length() != 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i4 < current.length()) {
                    char cCharAt = current.charAt(i4);
                    int i7 = i6 + 1;
                    if (i6 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt != '(') {
                        if (cCharAt == ')' && i5 - 1 == 0 && i6 != current.length() - 1) {
                            break;
                        }
                    } else {
                        i5++;
                    }
                    i4++;
                    i6 = i7;
                } else if (i5 == 0) {
                    String strSubstring = current.substring(1, current.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return Intrinsics.areEqual(StringsKt.trim((CharSequence) strSubstring).toString(), str);
                }
            }
        }
        return false;
    }
}
