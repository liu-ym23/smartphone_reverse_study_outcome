package bd;

import ad.n;
import com.tonyodev.fetch2core.server.FileRequest;
import gc.q;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import mb.m;
import okhttp3.Response;
import okhttp3.f;
import sd.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final okhttp3.f f3237a = i.f3232c;

    /* renamed from: b, reason: collision with root package name */
    public static final TimeZone f3238b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f3239c;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        kotlin.jvm.internal.g.c(timeZone);
        f3238b = timeZone;
        f3239c = q.A0(q.z0(n.class.getName(), "okhttp3."), FileRequest.FIELD_CLIENT);
    }

    public static final boolean a(okhttp3.g gVar, okhttp3.g other) {
        kotlin.jvm.internal.g.f(gVar, "<this>");
        kotlin.jvm.internal.g.f(other, "other");
        return kotlin.jvm.internal.g.b(gVar.f10980d, other.f10980d) && gVar.f10981e == other.f10981e && kotlin.jvm.internal.g.b(gVar.f10977a, other.f10977a);
    }

    public static final int b(String str, long j10, TimeUnit unit) {
        kotlin.jvm.internal.g.f(unit, "unit");
        if (j10 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        long millis = unit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large").toString());
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small").toString());
    }

    public static final void c(Socket socket) {
        kotlin.jvm.internal.g.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!kotlin.jvm.internal.g.b(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final String d(String format, Object... objArr) {
        kotlin.jvm.internal.g.f(format, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long e(Response response) {
        String strA = response.h.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        byte[] bArr = i.f3230a;
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @SafeVarargs
    public static final <T> List<T> f(T... elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(m.b0(Arrays.copyOf(objArr, objArr.length)));
        kotlin.jvm.internal.g.e(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final Charset g(sd.h hVar, Charset charset) {
        kotlin.jvm.internal.g.f(hVar, "<this>");
        kotlin.jvm.internal.g.f(charset, "default");
        int iR = hVar.R(i.f3231b);
        if (iR == -1) {
            return charset;
        }
        if (iR == 0) {
            return gc.a.f9106b;
        }
        if (iR == 1) {
            return gc.a.f9107c;
        }
        if (iR == 2) {
            return gc.a.f9108d;
        }
        if (iR == 3) {
            gc.a.f9105a.getClass();
            Charset charset2 = gc.a.f9111g;
            if (charset2 != null) {
                return charset2;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            kotlin.jvm.internal.g.e(charsetForName, "forName(...)");
            gc.a.f9111g = charsetForName;
            return charsetForName;
        }
        if (iR != 4) {
            throw new AssertionError();
        }
        gc.a.f9105a.getClass();
        Charset charset3 = gc.a.f9110f;
        if (charset3 != null) {
            return charset3;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        kotlin.jvm.internal.g.e(charsetForName2, "forName(...)");
        gc.a.f9110f = charsetForName2;
        return charsetForName2;
    }

    public static final <T> T h(Object instance, Class<T> fieldType, String str) {
        T tCast;
        Object objH;
        kotlin.jvm.internal.g.f(instance, "instance");
        kotlin.jvm.internal.g.f(fieldType, "fieldType");
        Class<?> superclass = instance.getClass();
        while (true) {
            tCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals("delegate") || (objH = h(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) h(objH, fieldType, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                tCast = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                kotlin.jvm.internal.g.e(superclass, "getSuperclass(...)");
            }
        }
        return tCast;
    }

    public static final boolean i(e0 e0Var, int i10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        kotlin.jvm.internal.g.f(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = e0Var.timeout().e() ? e0Var.timeout().c() - jNanoTime : Long.MAX_VALUE;
        e0Var.timeout().d(Math.min(jC, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            sd.e eVar = new sd.e();
            while (e0Var.read(eVar, 8192L) != -1) {
                eVar.o();
            }
            if (jC == Long.MAX_VALUE) {
                e0Var.timeout().a();
                return true;
            }
            e0Var.timeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                e0Var.timeout().a();
                return false;
            }
            e0Var.timeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                e0Var.timeout().a();
            } else {
                e0Var.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final okhttp3.f j(List<hd.a> list) {
        kotlin.jvm.internal.g.f(list, "<this>");
        f.a aVar = new f.a();
        for (hd.a aVar2 : list) {
            b.a(aVar, aVar2.f9411a.r(), aVar2.f9412b.r());
        }
        return aVar.b();
    }

    public static final String k(okhttp3.g gVar, boolean z) {
        kotlin.jvm.internal.g.f(gVar, "<this>");
        int i10 = gVar.f10981e;
        String str = gVar.f10980d;
        if (q.l0(str, ":", false)) {
            str = "[" + str + ']';
        }
        if (!z) {
            String scheme = gVar.f10977a;
            kotlin.jvm.internal.g.f(scheme, "scheme");
            if (i10 == (scheme.equals("http") ? 80 : scheme.equals("https") ? 443 : -1)) {
                return str;
            }
        }
        return str + ':' + i10;
    }

    public static final <T> List<T> l(List<? extends T> list) {
        kotlin.jvm.internal.g.f(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(kotlin.collections.a.P0(list));
        kotlin.jvm.internal.g.e(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }
}
