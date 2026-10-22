package bb;

import ab.a0;
import ab.n;
import ab.p;
import ab.t;
import ab.z;
import d7.c;
import d7.s;
import ga.i;
import ga.r;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import ob.h;
import ob.j;
import ob.k;
import ob.k0;
import ob.y;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1659a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f1660b = s7.a.J(new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final a0 f1661c;

    /* renamed from: d, reason: collision with root package name */
    public static final y f1662d;

    /* renamed from: e, reason: collision with root package name */
    public static final TimeZone f1663e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f1664f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f1665g;

    static {
        byte[] bArr = new byte[0];
        f1659a = bArr;
        h hVar = new h();
        hVar.m22write(bArr);
        long j2 = 0;
        f1661c = new a0(hVar, j2);
        c(j2, j2, j2);
        k kVar = k.f7997i;
        f1662d = ob.b.g(h4.n.i("efbbbf"), h4.n.i("feff"), h4.n.i("fffe"), h4.n.i("0000ffff"), h4.n.i("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        q7.k.b(timeZone);
        f1663e = timeZone;
        f1664f = new i("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String strZ0 = ga.k.z0(t.class.getName(), "okhttp3.");
        if (r.Z(strZ0, "Client", false)) {
            strZ0 = strZ0.substring(0, strZ0.length() - 6);
            q7.k.d(strZ0, "substring(...)");
        }
        f1665g = strZ0;
    }

    public static final boolean a(p pVar, p pVar2) {
        q7.k.e(pVar, "<this>");
        q7.k.e(pVar2, "other");
        return q7.k.a(pVar.f591d, pVar2.f591d) && pVar.f592e == pVar2.f592e && q7.k.a(pVar.f588a, pVar2.f588a);
    }

    public static final int b(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j2);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large.").toString());
        }
        if (millis != 0 || j2 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small.").toString());
    }

    public static final void c(long j2, long j4, long j10) {
        if ((j4 | j10) < 0 || j4 > j2 || j2 - j4 < j10) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeable) throws IOException {
        q7.k.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) throws IOException {
        q7.k.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!q7.k.a(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final int f(String str, char c10, int i2, int i10) {
        while (i2 < i10) {
            if (str.charAt(i2) == c10) {
                return i2;
            }
            i2++;
        }
        return i10;
    }

    public static final int g(String str, int i2, int i10, String str2) {
        while (i2 < i10) {
            if (ga.k.l0(str2, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return i10;
    }

    public static /* synthetic */ int h(String str, char c10, int i2, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i2 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = str.length();
        }
        return f(str, c10, i2, i10);
    }

    public static final String i(String str, Object... objArr) {
        q7.k.e(str, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator comparator) {
        q7.k.e(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                c cVarH = q7.k.h(strArr2);
                while (cVarH.hasNext()) {
                    if (comparator.compare(str, (String) cVarH.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long k(z zVar) {
        String strA = zVar.f689k.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List l(Object... objArr) {
        q7.k.e(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(s.u0(Arrays.copyOf(objArr2, objArr2.length)));
        q7.k.d(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int m(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (q7.k.f(cCharAt, 31) <= 0 || q7.k.f(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int n(String str, int i2, int i10) {
        while (i2 < i10) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i10;
    }

    public static final int o(String str, int i2, int i10) {
        int i11 = i10 - 1;
        if (i2 <= i11) {
            while (true) {
                char cCharAt = str.charAt(i11);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i11 + 1;
                }
                if (i11 == i2) {
                    break;
                }
                i11--;
            }
        }
        return i2;
    }

    public static final String[] p(String[] strArr, String[] strArr2, Comparator comparator) {
        q7.k.e(strArr2, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean q(String str) {
        q7.k.e(str, "name");
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int r(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' > c10 || c10 >= 'G') {
            return -1;
        }
        return c10 - '7';
    }

    public static final Charset s(j jVar, Charset charset) {
        q7.k.e(jVar, "<this>");
        q7.k.e(charset, "default");
        int iB = jVar.B(f1662d);
        if (iB == -1) {
            return charset;
        }
        if (iB == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            q7.k.d(charset2, "UTF_8");
            return charset2;
        }
        if (iB == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            q7.k.d(charset3, "UTF_16BE");
            return charset3;
        }
        if (iB == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            q7.k.d(charset4, "UTF_16LE");
            return charset4;
        }
        if (iB == 3) {
            Charset charset5 = ga.a.f4005a;
            Charset charset6 = ga.a.f4007c;
            if (charset6 != null) {
                return charset6;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            q7.k.d(charsetForName, "forName(...)");
            ga.a.f4007c = charsetForName;
            return charsetForName;
        }
        if (iB != 4) {
            throw new AssertionError();
        }
        Charset charset7 = ga.a.f4005a;
        Charset charset8 = ga.a.f4006b;
        if (charset8 != null) {
            return charset8;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        q7.k.d(charsetForName2, "forName(...)");
        ga.a.f4006b = charsetForName2;
        return charsetForName2;
    }

    public static final int t(j jVar) {
        q7.k.e(jVar, "<this>");
        return (jVar.readByte() & 255) | ((jVar.readByte() & 255) << 16) | ((jVar.readByte() & 255) << 8);
    }

    public static final boolean u(k0 k0Var, int i2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        q7.k.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = k0Var.timeout().e() ? k0Var.timeout().c() - jNanoTime : Long.MAX_VALUE;
        k0Var.timeout().d(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            h hVar = new h();
            while (k0Var.read(hVar, 8192L) != -1) {
                hVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                k0Var.timeout().a();
                return true;
            }
            k0Var.timeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                k0Var.timeout().a();
                return false;
            }
            k0Var.timeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                k0Var.timeout().a();
            } else {
                k0Var.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final n v(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hb.b bVar = (hb.b) it.next();
            k kVar = bVar.f4262a;
            k kVar2 = bVar.f4263b;
            String strR = kVar.r();
            String strR2 = kVar2.r();
            arrayList.add(strR);
            arrayList.add(ga.k.N0(strR2).toString());
        }
        return new n((String[]) arrayList.toArray(new String[0]));
    }

    public static final String w(p pVar, boolean z4) {
        q7.k.e(pVar, "<this>");
        int i2 = pVar.f592e;
        String strE = pVar.f591d;
        if (ga.k.k0(strE, ":", false)) {
            strE = a1.a.e(']', "[", strE);
        }
        if (!z4) {
            String str = pVar.f588a;
            q7.k.e(str, "scheme");
            if (i2 == (str.equals("http") ? 80 : str.equals("https") ? 443 : -1)) {
                return strE;
            }
        }
        return strE + ':' + i2;
    }

    public static final List x(List list) {
        q7.k.e(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(d7.r.n1(list));
        q7.k.d(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int y(int i2, String str) throws NumberFormatException {
        if (str == null) {
            return i2;
        }
        try {
            long j2 = Long.parseLong(str);
            if (j2 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j2 < 0) {
                return 0;
            }
            return (int) j2;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static final String z(String str, int i2, int i10) {
        int iN = n(str, i2, i10);
        String strSubstring = str.substring(iN, o(str, iN, i10));
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
