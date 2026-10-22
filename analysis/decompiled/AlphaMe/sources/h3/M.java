package h3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes2.dex */
public final class M {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f12732d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f12733e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    public final String f12734a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12735b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f12736c;

    public M(String str, String str2, String[] strArr) {
        this.f12734a = str;
        this.f12735b = str2;
        this.f12736c = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        Intrinsics.checkNotNullParameter("charset", "name");
        String[] strArr = this.f12736c;
        int i4 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                int i5 = i4 + 2;
                if (StringsKt__StringsJVMKt.equals(strArr[i4], "charset", true)) {
                    str = strArr[i4 + 1];
                    break;
                }
                if (i4 == progressionLastElement) {
                    break;
                }
                i4 = i5;
            }
            str = null;
        } else {
            str = null;
        }
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
        return (obj instanceof M) && Intrinsics.areEqual(((M) obj).f12734a, this.f12734a);
    }

    public final int hashCode() {
        return this.f12734a.hashCode();
    }

    public final String toString() {
        return this.f12734a;
    }
}
