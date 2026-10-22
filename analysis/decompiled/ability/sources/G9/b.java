package G9;

import C7.i;
import D7.N;
import D7.v;
import F9.AbstractC0226d;
import F9.F;
import F9.I;
import F9.J;
import F9.K;
import F9.M;
import F9.O;
import F9.w;
import F9.y;
import H4.o;
import M9.C0247a;
import V9.g;
import V9.p;
import androidx.collection.SieveCacheKt;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.AbstractC1607a;
import j9.m;
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
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import okio.ByteString;
import org.java_websocket.WebSocketImpl;
import s2.C1912a;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f704a;
    public static final w b = AbstractC0226d.i(new String[0]);
    public static final O c;
    public static final I d;
    public static final p e;
    public static final TimeZone f;
    public static final Regex g;
    public static final String h;

    static {
        byte[] bArr = new byte[0];
        f704a = bArr;
        g gVar = new g();
        gVar.m1write(bArr, 0, 0);
        c = new O(null, 0, gVar, 0);
        d = J.c(K.Companion, bArr, null, 0, 7);
        ByteString byteString = ByteString.d;
        e = N.I(C1912a.h("efbbbf"), C1912a.h("feff"), C1912a.h("fffe"), C1912a.h("0000ffff"), C1912a.h("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        k.c(timeZone);
        f = timeZone;
        g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        h = m.z0(m.y0("okhttp3.", F.class.getName()), "Client");
    }

    public static final boolean a(y yVar, y other) {
        k.f(yVar, "<this>");
        k.f(other, "other");
        return k.b(yVar.d, other.d) && yVar.e == other.e && k.b(yVar.f659a, other.f659a);
    }

    public static final int b(long j5, TimeUnit timeUnit) {
        if (j5 < 0) {
            throw new IllegalStateException(InjectExperienceResult.REASON_TIMEOUT.concat(" < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j5);
        if (millis > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(InjectExperienceResult.REASON_TIMEOUT.concat(" too large.").toString());
        }
        if (millis != 0 || j5 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(InjectExperienceResult.REASON_TIMEOUT.concat(" too small.").toString());
    }

    public static final void c(Closeable closeable) throws IOException {
        k.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e6) {
            throw e6;
        } catch (Exception unused) {
        }
    }

    public static final void d(Socket socket) throws IOException {
        k.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e6) {
            throw e6;
        } catch (RuntimeException e9) {
            if (!k.b(e9.getMessage(), "bio == null")) {
                throw e9;
            }
        } catch (Exception unused) {
        }
    }

    public static final int e(int i, int i6, String str, String str2) {
        k.f(str, "<this>");
        while (i < i6) {
            if (m.i0(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static final int f(String str, char c2, int i, int i6) {
        k.f(str, "<this>");
        while (i < i6) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static final String g(String format, Object... objArr) {
        k.f(format, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean h(String[] strArr, String[] strArr2, Comparator comparator) {
        k.f(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                i iVarJ = k.j(strArr2);
                while (iVarJ.hasNext()) {
                    if (comparator.compare(str, (String) iVarJ.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long i(M m) {
        String strB = m.f.b(HttpHeaders.CONTENT_LENGTH);
        if (strB == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strB);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List j(Object... elements) {
        k.f(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List listUnmodifiableList = Collections.unmodifiableList(o.N(Arrays.copyOf(objArr, objArr.length)));
        k.e(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int k(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (k.g(cCharAt, 31) <= 0 || k.g(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int l(int i, int i6, String str) {
        k.f(str, "<this>");
        while (i < i6) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static final int m(int i, int i6, String str) {
        k.f(str, "<this>");
        int i10 = i6 - 1;
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

    public static final String[] n(String[] strArr, String[] other, Comparator comparator) {
        k.f(other, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, other[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean o(String name) {
        k.f(name, "name");
        return name.equalsIgnoreCase("Authorization") || name.equalsIgnoreCase("Cookie") || name.equalsIgnoreCase("Proxy-Authorization") || name.equalsIgnoreCase("Set-Cookie");
    }

    public static final int p(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final Charset q(V9.i iVar, Charset charset) {
        k.f(iVar, "<this>");
        k.f(charset, "default");
        int iZ = iVar.z(e);
        if (iZ == -1) {
            return charset;
        }
        if (iZ == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            k.e(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iZ == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            k.e(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iZ == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            k.e(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iZ == 3) {
            Charset charset2 = AbstractC1607a.f4778a;
            Charset charset3 = AbstractC1607a.d;
            if (charset3 != null) {
                return charset3;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            k.e(charsetForName, "forName(...)");
            AbstractC1607a.d = charsetForName;
            return charsetForName;
        }
        if (iZ != 4) {
            throw new AssertionError();
        }
        Charset charset4 = AbstractC1607a.f4778a;
        Charset charset5 = AbstractC1607a.c;
        if (charset5 != null) {
            return charset5;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        k.e(charsetForName2, "forName(...)");
        AbstractC1607a.c = charsetForName2;
        return charsetForName2;
    }

    public static final Object r(Class fieldType, Object instance, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objCast;
        Object objR;
        k.f(instance, "instance");
        k.f(fieldType, "fieldType");
        Class<?> superclass = instance.getClass();
        while (true) {
            objCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals("delegate") || (objR = r(Object.class, instance, "delegate")) == null) {
                    return null;
                }
                return r(fieldType, objR, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                objCast = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                k.e(superclass, "c.superclass");
            }
        }
        return objCast;
    }

    public static final int s(V9.i iVar) {
        k.f(iVar, "<this>");
        return (iVar.readByte() & 255) | ((iVar.readByte() & 255) << 16) | ((iVar.readByte() & 255) << 8);
    }

    public static final boolean t(V9.w wVar, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        k.f(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = wVar.timeout().e() ? wVar.timeout().c() - jNanoTime : Long.MAX_VALUE;
        wVar.timeout().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            g gVar = new g();
            while (wVar.e(gVar, 8192L) != -1) {
                gVar.b();
            }
            if (jC == Long.MAX_VALUE) {
                wVar.timeout().a();
                return true;
            }
            wVar.timeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                wVar.timeout().a();
                return false;
            }
            wVar.timeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                wVar.timeout().a();
            } else {
                wVar.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final w u(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0247a c0247a = (C0247a) it.next();
            ByteString byteString = c0247a.f976a;
            ByteString byteString2 = c0247a.b;
            String strJ = byteString.j();
            String strJ2 = byteString2.j();
            arrayList.add(strJ);
            arrayList.add(m.R0(strJ2).toString());
        }
        return new w((String[]) arrayList.toArray(new String[0]));
    }

    public static final String v(y yVar, boolean z10) {
        k.f(yVar, "<this>");
        int i = yVar.e;
        String strM = yVar.d;
        if (m.h0(strM, ":", false)) {
            strM = androidx.compose.foundation.b.m(']', "[", strM);
        }
        if (!z10) {
            String scheme = yVar.f659a;
            k.f(scheme, "scheme");
            if (i == (scheme.equals("http") ? 80 : scheme.equals("https") ? WebSocketImpl.DEFAULT_WSS_PORT : -1)) {
                return strM;
            }
        }
        return strM + ':' + i;
    }

    public static final List w(List list) {
        k.f(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(v.g1(list));
        k.e(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int x(int i, String str) throws NumberFormatException {
        if (str == null) {
            return i;
        }
        try {
            long j5 = Long.parseLong(str);
            if (j5 > SieveCacheKt.NodeLinkMask) {
                return Integer.MAX_VALUE;
            }
            if (j5 < 0) {
                return 0;
            }
            return (int) j5;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static final String y(int i, int i6, String str) {
        int iL = l(i, i6, str);
        String strSubstring = str.substring(iL, m(iL, i6, str));
        k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
