package v7;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Pattern[] f14849c = new Pattern[1];

    public f(String str) {
        String[] strArr = {str};
        for (int i = 0; i < 1; i++) {
            String str2 = strArr[i];
            if (str2 == null || str2.isEmpty()) {
                g5.f.s(k0.a.k(i, "Regular expression[", "] is missing"));
                throw null;
            }
            this.f14849c[i] = Pattern.compile(strArr[i], 0);
        }
    }

    public final String[] a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        for (Pattern pattern : this.f14849c) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                int iGroupCount = matcher.groupCount();
                String[] strArr = new String[iGroupCount];
                while (i < iGroupCount) {
                    int i3 = i + 1;
                    strArr[i] = matcher.group(i3);
                    i = i3;
                }
                return strArr;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RegexValidator{");
        int i = 0;
        while (true) {
            Pattern[] patternArr = this.f14849c;
            if (i >= patternArr.length) {
                sb2.append("}");
                return sb2.toString();
            }
            if (i > 0) {
                sb2.append(",");
            }
            sb2.append(patternArr[i].pattern());
            i++;
        }
    }
}
