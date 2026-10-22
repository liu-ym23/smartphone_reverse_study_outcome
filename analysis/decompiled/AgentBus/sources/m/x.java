package m;

import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public abstract /* synthetic */ class x {
    public static final boolean a(int i2) {
        return !x3.a.a();
    }

    public static final boolean b(int i2) {
        Boolean bool;
        if (x3.a.a()) {
            try {
                bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
            } catch (Exception unused) {
                x3.a.f11156a.info("Conscrypt is not available or does not support checking for FIPS build.");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean c(int i2) {
        if (i2 == 1 || i2 == 2) {
            return false;
        }
        if (i2 == 3 || i2 == 4) {
            return true;
        }
        throw null;
    }

    public static int d(float f10, int i2, int i10) {
        return (Float.hashCode(f10) + i2) * i10;
    }

    public static int e(int i2, int i10, boolean z4) {
        return (Boolean.hashCode(z4) + i2) * i10;
    }

    public static int f(long j2, int i2, int i10) {
        return (Long.hashCode(j2) + i2) * i10;
    }

    public static int g(String str, int i2, int i10) {
        return (str.hashCode() + i2) * i10;
    }

    public static int h(List list, int i2, int i10) {
        return (list.hashCode() + i2) * i10;
    }

    public static a4.u i(String str) {
        f1.a.c(str);
        return new a4.u();
    }

    public static String j(Class cls, StringBuilder sb2) {
        sb2.append(cls.getCanonicalName());
        return sb2.toString();
    }

    public static String k(String str, int i2, int i10, String str2) {
        return str + i2 + str2 + i10;
    }

    public static String l(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String m(StringBuilder sb2, int i2, char c10) {
        sb2.append(i2);
        sb2.append(c10);
        return sb2.toString();
    }

    public static String n(StringBuilder sb2, String str, String str2, String str3) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2.toString();
    }

    public static String o(q7.x xVar, Class cls, StringBuilder sb2) {
        sb2.append(xVar.b(cls));
        return sb2.toString();
    }

    public static StringBuilder p(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        return sb2;
    }

    public static StringBuilder q(String str, y9.j jVar, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(jVar);
        sb2.append(str2);
        return sb2;
    }

    public static w7.j r(String str, String str2, q7.x xVar) {
        return xVar.d(new q7.n(str, str2));
    }

    public static /* synthetic */ void s(int i2) {
        if (i2 != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        q7.k.i(nullPointerException, q7.k.class.getName());
        throw nullPointerException;
    }

    public static /* synthetic */ void t(int i2, String str) {
        if (i2 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = q7.k.class.getName();
            int i10 = 0;
            while (!stackTrace[i10].getClassName().equals(name)) {
                i10++;
            }
            while (stackTrace[i10].getClassName().equals(name)) {
                i10++;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            StringBuilder sbP = a1.a.p("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
            sbP.append(str);
            NullPointerException nullPointerException = new NullPointerException(sbP.toString());
            q7.k.i(nullPointerException, q7.k.class.getName());
            throw nullPointerException;
        }
    }

    public static void u(long j2, StringBuilder sb2, String str) {
        sb2.append((Object) u0.m.i(j2));
        sb2.append(str);
    }

    public static void v(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static void w(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
    }

    public static String x(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static /* synthetic */ void y(int i2, String str) {
        if (i2 != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(a1.a.i(str, " must not be null"));
        q7.k.i(nullPointerException, q7.k.class.getName());
        throw nullPointerException;
    }

    public static /* synthetic */ String z(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "null" : "OUT_VARIANCE" : "IN_VARIANCE" : "INVARIANT";
    }
}
