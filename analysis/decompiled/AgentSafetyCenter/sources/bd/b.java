package bd;

import ad.e0;
import ad.g0;
import ad.n;
import ad.q;
import b8.z;
import com.google.crypto.tink.shaded.protobuf.Reader;
import hc.g;
import hc.h;
import id.c;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
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
import od.c0;
import od.f;
import od.i;
import od.i0;
import od.l;
import od.y;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f2074a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f2075b = c.z(new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final g0 f2076c;

    /* renamed from: d, reason: collision with root package name */
    public static final y f2077d;

    /* renamed from: e, reason: collision with root package name */
    public static final TimeZone f2078e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f2079f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f2080g;

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fb, code lost:
    
        continue;
     */
    static {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.b.<clinit>():void");
    }

    public static final boolean a(q qVar, q qVar2) {
        qVar.getClass();
        qVar2.getClass();
        return k.a(qVar.f562d, qVar2.f562d) && qVar.f563e == qVar2.f563e && k.a(qVar.f559a, qVar2.f559a);
    }

    public static final int b(long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            z.j("timeout".concat(" < 0"));
            return 0;
        }
        if (timeUnit == null) {
            f.e("unit == null");
            return 0;
        }
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            f.c("timeout".concat(" too large."));
            return 0;
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        f.c("timeout".concat(" too small."));
        return 0;
    }

    public static final void c(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeable) throws IOException {
        closeable.getClass();
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) throws IOException {
        socket.getClass();
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!k.a(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final int f(char c9, int i, int i3, String str) {
        str.getClass();
        while (i < i3) {
            if (str.charAt(i) == c9) {
                return i;
            }
            i++;
        }
        return i3;
    }

    public static final int g(String str, int i, String str2, int i3) {
        str.getClass();
        while (i < i3) {
            if (h.Y(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i3;
    }

    public static final String h(String str, Object... objArr) {
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean i(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                kb.b bVarD = k.d(strArr2);
                while (bVarD.hasNext()) {
                    if (comparator.compare(str, (String) bVarD.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long j(e0 e0Var) {
        String strA = e0Var.f472j.a(HttpHeaders.CONTENT_LENGTH);
        if (strA == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List k(Object... objArr) {
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(ac.a.F(Arrays.copyOf(objArr2, objArr2.length)));
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final int l(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (k.b(cCharAt, 31) <= 0 || k.b(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int m(int i, int i3, String str) {
        str.getClass();
        while (i < i3) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i3;
    }

    public static final int n(int i, int i3, String str) {
        str.getClass();
        int i10 = i3 - 1;
        if (i <= i10) {
            while (true) {
                char cCharAt = str.charAt(i10);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i10 + 1;
                }
                if (i10 == i) {
                    break;
                }
                i10--;
            }
        }
        return i;
    }

    public static final String[] o(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr2.getClass();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean p(String str) {
        str.getClass();
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int q(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('a' <= c9 && c9 < 'g') {
            return c9 - 'W';
        }
        if ('A' > c9 || c9 >= 'G') {
            return -1;
        }
        return c9 - '7';
    }

    public static final Charset r(od.k kVar, Charset charset) {
        kVar.getClass();
        charset.getClass();
        int iE = kVar.E(f2077d);
        if (iE == -1) {
            return charset;
        }
        if (iE == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            charset2.getClass();
            return charset2;
        }
        if (iE == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            charset3.getClass();
            return charset3;
        }
        if (iE == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            charset4.getClass();
            return charset4;
        }
        if (iE == 3) {
            Charset charset5 = hc.a.f5448a;
            Charset charset6 = hc.a.f5450c;
            if (charset6 != null) {
                return charset6;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            charsetForName.getClass();
            hc.a.f5450c = charsetForName;
            return charsetForName;
        }
        if (iE != 4) {
            throw new AssertionError();
        }
        Charset charset7 = hc.a.f5448a;
        Charset charset8 = hc.a.f5449b;
        if (charset8 != null) {
            return charset8;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        charsetForName2.getClass();
        hc.a.f5449b = charsetForName2;
        return charsetForName2;
    }

    public static final Object s(Class cls, Object obj, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objCast;
        Object objS;
        obj.getClass();
        Class<?> superclass = obj.getClass();
        while (true) {
            objCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals("delegate") || (objS = s(Object.class, obj, "delegate")) == null) {
                    return null;
                }
                return s(cls, objS, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                objCast = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                superclass.getClass();
            }
        }
        return objCast;
    }

    public static final int t(c0 c0Var) {
        c0Var.getClass();
        return (c0Var.g() & 255) | ((c0Var.g() & 255) << 16) | ((c0Var.g() & 255) << 8);
    }

    public static final boolean u(i0 i0Var, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        long jNanoTime = System.nanoTime();
        long jC = i0Var.b().e() ? i0Var.b().c() - jNanoTime : Long.MAX_VALUE;
        i0Var.b().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            i iVar = new i();
            while (i0Var.l(iVar, 8192L) != -1) {
                iVar.d();
            }
            if (jC == Long.MAX_VALUE) {
                i0Var.b().a();
                return true;
            }
            i0Var.b().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                i0Var.b().a();
                return false;
            }
            i0Var.b().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                i0Var.b().a();
            } else {
                i0Var.b().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final n v(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hd.b bVar = (hd.b) it.next();
            l lVar = bVar.f5473a;
            l lVar2 = bVar.f5474b;
            String strP = lVar.p();
            String strP2 = lVar2.p();
            arrayList.add(strP);
            arrayList.add(h.w0(strP2).toString());
        }
        return new n((String[]) arrayList.toArray(new String[0]));
    }

    public static final String w(q qVar, boolean z10) {
        qVar.getClass();
        int i = qVar.f563e;
        String str = qVar.f562d;
        if (h.X(str, ":", false)) {
            str = "[" + str + ']';
        }
        if (!z10) {
            String str2 = qVar.f559a;
            str2.getClass();
            if (i == (str2.equals("http") ? 80 : str2.equals("https") ? 443 : -1)) {
                return str;
            }
        }
        return str + ':' + i;
    }

    public static final List x(List list) {
        list.getClass();
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final int y(int i, String str) {
        if (str == null) {
            return i;
        }
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Reader.READ_DONE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
