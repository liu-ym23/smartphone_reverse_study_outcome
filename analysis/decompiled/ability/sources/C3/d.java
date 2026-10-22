package C3;

import u3.C2035a;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final a f287a = new a(0);

    public final b a(C2035a c2035a) {
        String str = c2035a != null ? c2035a.f6694a : "";
        String strSubstring = str.startsWith("classpath:") ? str.substring(10) : str.startsWith("resource:") ? str.substring(9) : null;
        if (strSubstring == null) {
            return null;
        }
        ClassLoader classLoader = (ClassLoader) this.f287a.get();
        if (strSubstring.startsWith("//")) {
            strSubstring = strSubstring.substring(2);
        }
        return new b(classLoader, strSubstring, str);
    }
}
