package C4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f921j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f922k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f923l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f924m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    private final String f925a;

    /* renamed from: b, reason: collision with root package name */
    private final String f926b;

    /* renamed from: c, reason: collision with root package name */
    private final long f927c;

    /* renamed from: d, reason: collision with root package name */
    private final String f928d;

    /* renamed from: e, reason: collision with root package name */
    private final String f929e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f930f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f931g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f932h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f933i;

    private m(String str, String str2, long j5, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f925a = str;
        this.f926b = str2;
        this.f927c = j5;
        this.f928d = str3;
        this.f929e = str4;
        this.f930f = z5;
        this.f931g = z6;
        this.f933i = z7;
        this.f932h = z8;
    }

    private static int a(String str, int i5, int i6, boolean z5) {
        while (i5 < i6) {
            char cCharAt = str.charAt(i5);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z5)) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !D4.e.L(str);
    }

    @Nullable
    static m d(long j5, w wVar, String str) throws NumberFormatException {
        long j6;
        String str2;
        int length = str.length();
        char c6 = ';';
        int iN = D4.e.n(str, 0, length, ';');
        int iN2 = D4.e.n(str, 0, iN, '=');
        String strG = null;
        if (iN2 == iN) {
            return null;
        }
        String strK = D4.e.K(str, 0, iN2);
        if (strK.isEmpty() || D4.e.x(strK) != -1) {
            return null;
        }
        String strK2 = D4.e.K(str, iN2 + 1, iN);
        if (D4.e.x(strK2) != -1) {
            return null;
        }
        int i5 = iN + 1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = true;
        long jH = 253402300799999L;
        long jI = -1;
        String strSubstring = null;
        while (i5 < length) {
            int iN3 = D4.e.n(str, i5, length, c6);
            int iN4 = D4.e.n(str, i5, iN3, '=');
            String strK3 = D4.e.K(str, i5, iN4);
            String strK4 = iN4 < iN3 ? D4.e.K(str, iN4 + 1, iN3) : BuildConfig.FLAVOR;
            if (strK3.equalsIgnoreCase("expires")) {
                try {
                    jH = h(strK4, 0, strK4.length());
                    z7 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strK3.equalsIgnoreCase("max-age")) {
                jI = i(strK4);
                z7 = true;
            } else if (strK3.equalsIgnoreCase("domain")) {
                strG = g(strK4);
                z8 = false;
            } else if (strK3.equalsIgnoreCase("path")) {
                strSubstring = strK4;
            } else if (strK3.equalsIgnoreCase("secure")) {
                z5 = true;
            } else if (strK3.equalsIgnoreCase("httponly")) {
                z6 = true;
            }
            i5 = iN3 + 1;
            c6 = ';';
        }
        if (jI == Long.MIN_VALUE) {
            j6 = Long.MIN_VALUE;
        } else if (jI != -1) {
            long j7 = j5 + (jI <= 9223372036854775L ? jI * 1000 : Long.MAX_VALUE);
            j6 = (j7 < j5 || j7 > 253402300799999L) ? 253402300799999L : j7;
        } else {
            j6 = jH;
        }
        String strM = wVar.m();
        if (strG == null) {
            str2 = strM;
        } else {
            if (!b(strM, strG)) {
                return null;
            }
            str2 = strG;
        }
        if (strM.length() != str2.length() && PublicSuffixDatabase.c().d(str2) == null) {
            return null;
        }
        if (strSubstring == null || !strSubstring.startsWith("/")) {
            String strH = wVar.h();
            int iLastIndexOf = strH.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strH.substring(0, iLastIndexOf) : "/";
        }
        return new m(strK, strK2, j6, str2, strSubstring, z5, z6, z8, z7);
    }

    @Nullable
    public static m e(w wVar, String str) {
        return d(System.currentTimeMillis(), wVar, str);
    }

    public static List<m> f(w wVar, v vVar) {
        List<String> listJ = vVar.j("Set-Cookie");
        int size = listJ.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            m mVarE = e(wVar, listJ.get(i5));
            if (mVarE != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mVarE);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    private static String g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strD = D4.e.d(str);
        if (strD != null) {
            return strD;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long h(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C4.m.h(java.lang.String, int, int):long");
    }

    private static long i(String str) throws NumberFormatException {
        try {
            long j5 = Long.parseLong(str);
            if (j5 <= 0) {
                return Long.MIN_VALUE;
            }
            return j5;
        } catch (NumberFormatException e6) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e6;
        }
    }

    public String c() {
        return this.f925a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f925a.equals(this.f925a) && mVar.f926b.equals(this.f926b) && mVar.f928d.equals(this.f928d) && mVar.f929e.equals(this.f929e) && mVar.f927c == this.f927c && mVar.f930f == this.f930f && mVar.f931g == this.f931g && mVar.f932h == this.f932h && mVar.f933i == this.f933i;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f925a.hashCode()) * 31) + this.f926b.hashCode()) * 31) + this.f928d.hashCode()) * 31) + this.f929e.hashCode()) * 31;
        long j5 = this.f927c;
        return ((((((((iHashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (!this.f930f ? 1 : 0)) * 31) + (!this.f931g ? 1 : 0)) * 31) + (!this.f932h ? 1 : 0)) * 31) + (!this.f933i ? 1 : 0);
    }

    String j(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f925a);
        sb.append('=');
        sb.append(this.f926b);
        if (this.f932h) {
            if (this.f927c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(G4.d.a(new Date(this.f927c)));
            }
        }
        if (!this.f933i) {
            sb.append("; domain=");
            if (z5) {
                sb.append(".");
            }
            sb.append(this.f928d);
        }
        sb.append("; path=");
        sb.append(this.f929e);
        if (this.f930f) {
            sb.append("; secure");
        }
        if (this.f931g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f926b;
    }

    public String toString() {
        return j(false);
    }
}
