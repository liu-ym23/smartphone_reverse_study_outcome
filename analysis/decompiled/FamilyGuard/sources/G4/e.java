package G4;

import C4.F;
import C4.m;
import C4.n;
import C4.v;
import C4.w;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final L4.h f1920a = L4.h.h("\"\\");

    /* renamed from: b, reason: collision with root package name */
    private static final L4.h f1921b = L4.h.h("\t ,=");

    public static long a(v vVar) {
        return h(vVar.c("Content-Length"));
    }

    public static long b(F f5) {
        return a(f5.v());
    }

    public static boolean c(F f5) {
        if (f5.I().f().equals("HEAD")) {
            return false;
        }
        int iM = f5.m();
        return (((iM >= 100 && iM < 200) || iM == 204 || iM == 304) && b(f5) == -1 && !"chunked".equalsIgnoreCase(f5.r("Transfer-Encoding"))) ? false : true;
    }

    public static int d(String str, int i5) throws NumberFormatException {
        try {
            long j5 = Long.parseLong(str);
            if (j5 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j5 < 0) {
                return 0;
            }
            return (int) j5;
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    public static void e(n nVar, w wVar, v vVar) {
        if (nVar == n.f934a) {
            return;
        }
        List<m> listF = m.f(wVar, vVar);
        if (listF.isEmpty()) {
            return;
        }
        nVar.a(wVar, listF);
    }

    public static int f(String str, int i5, String str2) {
        while (i5 < str.length() && str2.indexOf(str.charAt(i5)) == -1) {
            i5++;
        }
        return i5;
    }

    public static int g(String str, int i5) {
        char cCharAt;
        while (i5 < str.length() && ((cCharAt = str.charAt(i5)) == ' ' || cCharAt == '\t')) {
            i5++;
        }
        return i5;
    }

    private static long h(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
