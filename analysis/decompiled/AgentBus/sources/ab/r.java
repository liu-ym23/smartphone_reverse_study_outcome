package ab;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f597c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f598d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    public final String f599a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f600b;

    public r(String str, String[] strArr) {
        this.f599a = str;
        this.f600b = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.f600b;
        int i2 = 0;
        int iB = ib.c.B(0, strArr.length - 1, 2);
        if (iB < 0) {
            str = null;
            break;
        }
        while (!ga.r.a0(strArr[i2], "charset")) {
            if (i2 == iB) {
                str = null;
                break;
            }
            i2 += 2;
        }
        str = strArr[i2 + 1];
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
        return (obj instanceof r) && q7.k.a(((r) obj).f599a, this.f599a);
    }

    public final int hashCode() {
        return this.f599a.hashCode();
    }

    public final String toString() {
        return this.f599a;
    }
}
