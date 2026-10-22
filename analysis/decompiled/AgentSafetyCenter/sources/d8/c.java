package d8;

import androidx.room.q;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.regex.Pattern;
import w7.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface c {
    static c a(String str, q qVar) {
        boolean z10;
        int i;
        char c9;
        char c10;
        int i3;
        int i10;
        int i11;
        int i12;
        String string = str;
        if (string == null) {
            return new b();
        }
        ((o) qVar.f1601d).f15349g.getClass();
        a aVar = new a();
        HashMap map = d.f3291a;
        char c11 = '[';
        char c12 = 'E';
        if (string.indexOf(36) == -1) {
            z10 = true;
        } else {
            StringBuilder sb2 = new StringBuilder();
            z10 = true;
            int i13 = 0;
            boolean z11 = false;
            boolean z12 = false;
            while (i13 < string.length()) {
                char cCharAt = string.charAt(i13);
                if (z11) {
                    if (cCharAt == '\\' && (i = i13 + 1) < string.length() && string.charAt(i) == 'E') {
                        sb2.append("\\E");
                        i13 = i;
                        z11 = false;
                    } else {
                        sb2.append(cCharAt);
                    }
                } else if (cCharAt == '\\') {
                    sb2.append(cCharAt);
                    int i14 = i13 + 1;
                    if (i14 < string.length()) {
                        char cCharAt2 = string.charAt(i14);
                        sb2.append(cCharAt2);
                        if (cCharAt2 == 'Q') {
                            z11 = true;
                        }
                        i13 = i14;
                    }
                } else if (cCharAt == '[') {
                    sb2.append(cCharAt);
                    z12 = true;
                } else if (cCharAt == ']') {
                    sb2.append(cCharAt);
                    z12 = false;
                } else if (cCharAt != '$') {
                    sb2.append(cCharAt);
                } else if (z12) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append("\\z");
                }
                i13++;
            }
            string = sb2.toString();
        }
        HashMap map2 = d.f3291a;
        if (string.indexOf("\\p{") != -1) {
            StringBuilder sb3 = new StringBuilder();
            int i15 = 0;
            boolean z13 = false;
            boolean z14 = false;
            while (i15 < string.length()) {
                char cCharAt3 = string.charAt(i15);
                if (!z13) {
                    if (!z14 && string.length() >= (i10 = i15 + 3) && string.startsWith("\\p{", i15)) {
                        i3 = i10;
                        while (true) {
                            if (i3 >= string.length()) {
                                i3 = -1;
                                break;
                            }
                            if (string.charAt(i3) == '}') {
                                break;
                            }
                            if (string.charAt(i3) == '\\' && (i11 = i3 + 1) < string.length()) {
                                i3 = i11;
                            }
                            i3++;
                        }
                        if (i3 != -1) {
                            sb3.append("\\p{");
                            String strSubstring = string.substring(i10, i3);
                            String str2 = (String) map2.get(strSubstring);
                            if (str2 == null) {
                                sb3.append(strSubstring);
                            } else {
                                sb3.append(str2);
                            }
                            sb3.append("}");
                        }
                        i15 = i3;
                        c9 = '[';
                        c10 = ']';
                    }
                    if (cCharAt3 == '\\') {
                        sb3.append(cCharAt3);
                        i3 = i15 + 1;
                        if (i3 < string.length()) {
                            char cCharAt4 = string.charAt(i3);
                            sb3.append(cCharAt4);
                            if (cCharAt4 == 'Q') {
                                z13 = z10;
                            }
                            i15 = i3;
                        }
                        c9 = '[';
                        c10 = ']';
                    } else {
                        c9 = '[';
                        if (cCharAt3 == '[') {
                            sb3.append(cCharAt3);
                            z14 = z10;
                            c10 = ']';
                        } else {
                            c10 = ']';
                            if (cCharAt3 == ']') {
                                sb3.append(cCharAt3);
                                z14 = false;
                            } else {
                                sb3.append(cCharAt3);
                            }
                        }
                    }
                } else if (cCharAt3 == '\\' && (i12 = i15 + 1) < string.length() && string.charAt(i12) == c12) {
                    sb3.append("\\E");
                    c9 = c11;
                    i15 = i12;
                    c10 = ']';
                    z13 = false;
                } else {
                    sb3.append(cCharAt3);
                    c9 = c11;
                    c10 = ']';
                }
                i15++;
                c11 = c9;
                c12 = 'E';
            }
            string = sb3.toString();
        }
        aVar.f3290a = Pattern.compile(string);
        VarHandle.storeStoreFence();
        return aVar;
    }

    boolean matches(String str);
}
