package C4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f955a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f956a = new ArrayList(20);

        public a a(String str, String str2) {
            v.a(str);
            v.b(str2, str);
            return d(str, str2);
        }

        public a b(v vVar) {
            int iH = vVar.h();
            for (int i5 = 0; i5 < iH; i5++) {
                d(vVar.e(i5), vVar.i(i5));
            }
            return this;
        }

        a c(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? d(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? d(BuildConfig.FLAVOR, str.substring(1)) : d(BuildConfig.FLAVOR, str);
        }

        a d(String str, String str2) {
            this.f956a.add(str);
            this.f956a.add(str2.trim());
            return this;
        }

        public v e() {
            return new v(this);
        }

        public a f(String str) {
            int i5 = 0;
            while (i5 < this.f956a.size()) {
                if (str.equalsIgnoreCase(this.f956a.get(i5))) {
                    this.f956a.remove(i5);
                    this.f956a.remove(i5);
                    i5 -= 2;
                }
                i5 += 2;
            }
            return this;
        }

        public a g(String str, String str2) {
            v.a(str);
            v.b(str2, str);
            f(str);
            d(str, str2);
            return this;
        }
    }

    v(a aVar) {
        List<String> list = aVar.f956a;
        this.f955a = (String[]) list.toArray(new String[list.size()]);
    }

    static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(D4.e.q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i5), str));
            }
        }
    }

    static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(D4.e.q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i5), str2, str));
            }
        }
    }

    @Nullable
    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static v g(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i5 = 0; i5 < strArr2.length; i5++) {
            String str = strArr2[i5];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i5] = str.trim();
        }
        for (int i6 = 0; i6 < strArr2.length; i6 += 2) {
            String str2 = strArr2[i6];
            String str3 = strArr2[i6 + 1];
            a(str2);
            b(str3, str2);
        }
        return new v(strArr2);
    }

    @Nullable
    public String c(String str) {
        return d(this.f955a, str);
    }

    public String e(int i5) {
        return this.f955a[i5 * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof v) && Arrays.equals(((v) obj).f955a, this.f955a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.f956a, this.f955a);
        return aVar;
    }

    public int h() {
        return this.f955a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f955a);
    }

    public String i(int i5) {
        return this.f955a[(i5 * 2) + 1];
    }

    public List<String> j(String str) {
        int iH = h();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < iH; i5++) {
            if (str.equalsIgnoreCase(e(i5))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(i(i5));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iH = h();
        for (int i5 = 0; i5 < iH; i5++) {
            sb.append(e(i5));
            sb.append(": ");
            sb.append(i(i5));
            sb.append("\n");
        }
        return sb.toString();
    }

    private v(String[] strArr) {
        this.f955a = strArr;
    }
}
