package o6;

import androidx.fragment.app.l;
import c5.s;
import c7.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import n6.k;
import n6.m;
import n6.q;
import n6.u;
import org.tukaani.xz.common.Util;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f4330a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f4331b;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        p.b(timeZone);
        f4330a = timeZone;
        f4331b = n.C1(n.B1(q.class.getName(), "okhttp3."), "Client");
    }

    public static final boolean a(m mVar, m other) {
        p.e(mVar, "<this>");
        p.e(other, "other");
        return p.a(mVar.d, other.d) && mVar.f4066e == other.f4066e && p.a(mVar.f4063a, other.f4063a);
    }

    public static final int b(long j4, String str) {
        TimeUnit unit = TimeUnit.SECONDS;
        p.e(unit, "unit");
        if (j4 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        long millis = unit.toMillis(j4);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large").toString());
        }
        if (millis != 0 || j4 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small").toString());
    }

    public static final void c(Socket socket) throws IOException {
        p.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e9) {
            throw e9;
        } catch (RuntimeException e10) {
            if (!p.a(e10.getMessage(), "bio == null")) {
                throw e10;
            }
        } catch (Exception unused) {
        }
    }

    public static final String d(String format, Object... objArr) {
        p.e(format, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long e(u uVar) {
        String strF = uVar.f4150f.f("Content-Length");
        if (strF == null) {
            return -1L;
        }
        byte[] bArr = d.f4327a;
        try {
            return Long.parseLong(strF);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final Object f(Object instance, Class fieldType, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objCast;
        Object objF;
        p.e(instance, "instance");
        p.e(fieldType, "fieldType");
        Class<?> superclass = instance.getClass();
        while (true) {
            objCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals("delegate") || (objF = f(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return f(objF, fieldType, str);
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
                p.d(superclass, "getSuperclass(...)");
            }
        }
        return objCast;
    }

    public static final boolean g(v vVar, int i8) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        p.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = vVar.d().e() ? vVar.d().c() - jNanoTime : Long.MAX_VALUE;
        vVar.d().d(Math.min(jC, timeUnit.toNanos(i8)) + jNanoTime);
        try {
            c7.f fVar = new c7.f();
            while (vVar.h(8192L, fVar) != -1) {
                fVar.skip(fVar.f1164b);
            }
            if (jC == Util.VLI_MAX) {
                vVar.d().a();
                return true;
            }
            vVar.d().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Util.VLI_MAX) {
                vVar.d().a();
                return false;
            }
            vVar.d().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Util.VLI_MAX) {
                vVar.d().a();
            } else {
                vVar.d().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final k h(List list) {
        l lVar = new l(1);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u6.d dVar = (u6.d) it.next();
            k4.v.p(lVar, dVar.f5684a.l(), dVar.f5685b.l());
        }
        return lVar.a();
    }

    public static final String i(m mVar, boolean z) {
        p.e(mVar, "<this>");
        int i8 = mVar.f4066e;
        String str = mVar.d;
        if (n.g1(str, ":", false)) {
            str = "[" + str + AbstractJsonLexerKt.END_LIST;
        }
        if (!z) {
            String scheme = mVar.f4063a;
            p.e(scheme, "scheme");
            if (i8 == (scheme.equals("http") ? 80 : scheme.equals("https") ? 443 : -1)) {
                return str;
            }
        }
        return str + AbstractJsonLexerKt.COLON + i8;
    }

    public static final List j(List list) {
        p.e(list, "<this>");
        if (list.isEmpty()) {
            return s.f1092a;
        }
        if (list.size() == 1) {
            List listSingletonList = Collections.singletonList(list.get(0));
            p.d(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        Object[] array = list.toArray();
        p.d(array, "toArray(...)");
        List listUnmodifiableList = Collections.unmodifiableList(c5.l.S(array));
        p.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final List k(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return s.f1092a;
        }
        if (objArr.length == 1) {
            List listSingletonList = Collections.singletonList(objArr[0]);
            p.d(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        List listUnmodifiableList = Collections.unmodifiableList(c5.l.S((Object[]) objArr.clone()));
        p.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }
}
