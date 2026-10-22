package F9;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class B {
    public static final Pattern e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    public final String f597a;
    public final String b;
    public final String c;
    public final String[] d;

    public B(String str, String str2, String str3, String[] strArr) {
        this.f597a = str;
        this.b = str2;
        this.c = str3;
        this.d = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.d;
        int i = 0;
        int iD = Z6.k.D(0, strArr.length - 1, 2);
        if (iD < 0) {
            str = null;
            break;
        }
        while (!j9.t.X(strArr[i], "charset")) {
            if (i == iD) {
                str = null;
                break;
            }
            i += 2;
        }
        str = strArr[i + 1];
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof B) && kotlin.jvm.internal.k.b(((B) obj).f597a, this.f597a);
    }

    public final int hashCode() {
        return this.f597a.hashCode();
    }

    public final String toString() {
        return this.f597a;
    }
}
