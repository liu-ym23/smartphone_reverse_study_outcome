package ad;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f568d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f569e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    public String f570a;

    /* renamed from: b, reason: collision with root package name */
    public String f571b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f572c;

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.f572c;
        int i = 0;
        int iR = com.stepos.statsrpk.h.r(0, strArr.length - 1, 2);
        if (iR < 0) {
            str = null;
            break;
        }
        while (!hc.o.Q(strArr[i], "charset")) {
            if (i == iR) {
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
        return (obj instanceof s) && yb.k.a(((s) obj).f570a, this.f570a);
    }

    public final int hashCode() {
        return this.f570a.hashCode();
    }

    public final String toString() {
        return this.f570a;
    }
}
