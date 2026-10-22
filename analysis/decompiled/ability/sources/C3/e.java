package C3;

import u3.C2035a;

/* loaded from: classes3.dex */
public abstract class e {
    public static C2035a a(C2035a c2035a) {
        String str = c2035a != null ? c2035a.f6694a : null;
        if (str == null) {
            return null;
        }
        if (str.startsWith("https://json-schema.org/")) {
            return new C2035a("classpath:" + str.substring(24));
        }
        if (!str.startsWith("http://json-schema.org/")) {
            return null;
        }
        int length = str.length();
        int i = length - 1;
        if (str.charAt(i) == '#') {
            length = i;
        }
        return new C2035a("classpath:" + str.substring(23, length));
    }
}
