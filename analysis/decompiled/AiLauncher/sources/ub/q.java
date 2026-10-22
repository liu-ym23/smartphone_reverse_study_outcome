package ub;

import La.C0953c;
import La.H;
import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0968f;
import Z8.C1168p;
import Z8.C1173v;
import Z8.C1174w;
import Z8.M;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import tb.AbstractC5550q;
import tb.C5530C;
import tb.C5548o;
import tb.InterfaceC5538e;
import tb.u;
import tb.v;
import tb.z;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\t\u001a\u00020\u0000*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0014\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0019\u0010 \u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0000¢\u0006\u0004\b \u0010!\u001a\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d*\u00020\u001fH\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001b\u0010%\u001a\u00020\u0002*\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0000¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010)\u001a\u00020(*\u00020'H\u0000¢\u0006\u0004\b)\u0010*\u001a#\u0010-\u001a\u00020\u0002*\u00020+2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0018H\u0000¢\u0006\u0004\b-\u0010.\u001a#\u00100\u001a\u00020\u0002*\u00020+2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0018H\u0000¢\u0006\u0004\b0\u0010.\u001a\u001b\u00103\u001a\u00020\u0002*\u0002012\u0006\u00102\u001a\u00020\u0011H\u0000¢\u0006\u0004\b3\u00104\u001a\u0013\u00106\u001a\u00020\u0016*\u000205H\u0000¢\u0006\u0004\b6\u00107\u001a%\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0000¢\u0006\u0004\b9\u0010:\u001a/\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\u0004\b\u0000\u001082\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\"\u00028\u0000H\u0001¢\u0006\u0004\b<\u0010=\u001a)\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\u0004\b\u0000\u00108*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\fH\u0000¢\u0006\u0004\b>\u0010=\u001a\u0013\u0010@\u001a\u00020?*\u000201H\u0000¢\u0006\u0004\b@\u0010A\u001a5\u0010F\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u001082\u0006\u0010B\u001a\u00020\r2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000C2\u0006\u0010E\u001a\u00020\u0000H\u0000¢\u0006\u0004\bF\u0010G\u001a\u0013\u0010I\u001a\u00020?*\u00020HH\u0000¢\u0006\u0004\bI\u0010J\"\u0014\u0010N\u001a\u00020K8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bL\u0010M\"\u0014\u0010Q\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bO\u0010P\"\u0014\u0010S\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b)\u0010R¨\u0006T"}, d2 = {"", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "q", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "Ltb/v;", "includeDefaultPort", "u", "(Ltb/v;Z)Ljava/lang/String;", "format", "", "", "args", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "LMb/f;", "Ljava/nio/charset/Charset;", "default", "n", "(LMb/f;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "", "LBb/a;", "Ltb/u;", "t", "(Ljava/util/List;)Ltb/u;", "s", "(Ltb/u;)Ljava/util/List;", "other", "f", "(Ltb/v;Ltb/v;)Z", "Ltb/q;", "Ltb/q$c;", "c", "(Ltb/q;)Ltb/q$c;", "LMb/I;", "timeUnit", "p", "(LMb/I;ILjava/util/concurrent/TimeUnit;)Z", "timeout", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/net/Socket;", "source", "m", "(Ljava/net/Socket;LMb/f;)Z", "Ltb/C;", "k", "(Ltb/C;)J", ExifInterface.GPS_DIRECTION_TRUE, "w", "(Ljava/util/List;)Ljava/util/List;", "elements", "l", "([Ljava/lang/Object;)Ljava/util/List;", "x", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/net/Socket;)V", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "o", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Ltb/o;", "e", "(Ltb/o;)V", "Ljava/util/TimeZone;", Const.INTENT_KEY_APIKEY, "Ljava/util/TimeZone;", "UTC", Const.INTENT_KEY_PKGNAME, "Z", "assertionsEnabled", "Ljava/lang/String;", "okHttpName", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f42673a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f42674b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f42675c;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        kotlin.jvm.internal.p.f(timeZone);
        f42673a = timeZone;
        f42674b = false;
        String name = z.class.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        f42675c = H.T0(H.R0(name, "okhttp3."), "Client");
    }

    public static final AbstractC5550q.c c(final AbstractC5550q abstractC5550q) {
        kotlin.jvm.internal.p.i(abstractC5550q, "<this>");
        return new AbstractC5550q.c() { // from class: ub.o
            @Override // tb.AbstractC5550q.c
            public final AbstractC5550q a(InterfaceC5538e interfaceC5538e) {
                return q.d(abstractC5550q, interfaceC5538e);
            }
        };
    }

    public static final AbstractC5550q d(AbstractC5550q abstractC5550q, InterfaceC5538e it) {
        kotlin.jvm.internal.p.i(it, "it");
        return abstractC5550q;
    }

    public static final void e(C5548o c5548o) {
        kotlin.jvm.internal.p.i(c5548o, "<this>");
        if (f42674b && Thread.holdsLock(c5548o)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c5548o);
        }
    }

    public static final boolean f(v vVar, v other) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return kotlin.jvm.internal.p.d(vVar.getHost(), other.getHost()) && vVar.getPort() == other.getPort() && kotlin.jvm.internal.p.d(vVar.getScheme(), other.getScheme());
    }

    public static final int g(String name, long j10, TimeUnit unit) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(unit, "unit");
        if (j10 < 0) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long millis = unit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException((name + " too large").toString());
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small").toString());
    }

    public static final void h(Socket socket) throws IOException {
        kotlin.jvm.internal.p.i(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!kotlin.jvm.internal.p.d(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean i(I i10, int i11, TimeUnit timeUnit) {
        kotlin.jvm.internal.p.i(i10, "<this>");
        kotlin.jvm.internal.p.i(timeUnit, "timeUnit");
        try {
            return p(i10, i11, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String j(String format, Object... args) {
        kotlin.jvm.internal.p.i(format, "format");
        kotlin.jvm.internal.p.i(args, "args");
        y yVar = y.f34840a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public static final long k(C5530C c5530c) {
        kotlin.jvm.internal.p.i(c5530c, "<this>");
        String strB = c5530c.getHeaders().b("Content-Length");
        if (strB != null) {
            return n.z(strB, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> l(T... elements) {
        kotlin.jvm.internal.p.i(elements, "elements");
        return x(elements);
    }

    public static final boolean m(Socket socket, InterfaceC0968f source) throws SocketException {
        kotlin.jvm.internal.p.i(socket, "<this>");
        kotlin.jvm.internal.p.i(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.k();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final Charset n(InterfaceC0968f interfaceC0968f, Charset charset) throws IOException {
        kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
        kotlin.jvm.internal.p.i(charset, "default");
        int iP0 = interfaceC0968f.p0(n.k());
        if (iP0 == -1) {
            return charset;
        }
        if (iP0 == 0) {
            return C0953c.UTF_8;
        }
        if (iP0 == 1) {
            return C0953c.UTF_16BE;
        }
        if (iP0 == 2) {
            return C0953c.f4336a.b();
        }
        if (iP0 == 3) {
            return C0953c.UTF_16LE;
        }
        if (iP0 == 4) {
            return C0953c.f4336a.a();
        }
        throw new AssertionError();
    }

    public static final <T> T o(Object instance, Class<T> fieldType, String fieldName) {
        T tCast;
        Object objO;
        kotlin.jvm.internal.p.i(instance, "instance");
        kotlin.jvm.internal.p.i(fieldType, "fieldType");
        kotlin.jvm.internal.p.i(fieldName, "fieldName");
        Class<?> superclass = instance.getClass();
        while (true) {
            tCast = null;
            if (kotlin.jvm.internal.p.d(superclass, Object.class)) {
                if (kotlin.jvm.internal.p.d(fieldName, "delegate") || (objO = o(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) o(objO, fieldType, fieldName);
            }
            try {
                Field declaredField = superclass.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                tCast = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                kotlin.jvm.internal.p.h(superclass, "getSuperclass(...)");
            }
        }
        return tCast;
    }

    public static final boolean p(I i10, int i11, TimeUnit timeUnit) throws IOException {
        kotlin.jvm.internal.p.i(i10, "<this>");
        kotlin.jvm.internal.p.i(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jD = i10.c().getHasDeadline() ? i10.c().d() - jNanoTime : Long.MAX_VALUE;
        i10.c().e(Math.min(jD, timeUnit.toNanos(i11)) + jNanoTime);
        try {
            C0966d c0966d = new C0966d();
            while (i10.u0(c0966d, 8192L) != -1) {
                c0966d.g();
            }
            if (jD == Long.MAX_VALUE) {
                i10.c().b();
                return true;
            }
            i10.c().e(jNanoTime + jD);
            return true;
        } catch (InterruptedIOException unused) {
            if (jD == Long.MAX_VALUE) {
                i10.c().b();
                return false;
            }
            i10.c().e(jNanoTime + jD);
            return false;
        } catch (Throwable th) {
            if (jD == Long.MAX_VALUE) {
                i10.c().b();
            } else {
                i10.c().e(jNanoTime + jD);
            }
            throw th;
        }
    }

    public static final ThreadFactory q(final String name, final boolean z10) {
        kotlin.jvm.internal.p.i(name, "name");
        return new ThreadFactory() { // from class: ub.p
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return q.r(name, z10, runnable);
            }
        };
    }

    public static final Thread r(String str, boolean z10, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }

    public static final List<Bb.a> s(u uVar) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        C5680i c5680iS = C5685n.s(0, uVar.size());
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            int iNextInt = ((M) it).nextInt();
            arrayList.add(new Bb.a(uVar.f(iNextInt), uVar.k(iNextInt)));
        }
        return arrayList;
    }

    public static final u t(List<Bb.a> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        u.a aVar = new u.a();
        for (Bb.a aVar2 : list) {
            aVar.d(aVar2.getName().Q(), aVar2.getValue().Q());
        }
        return aVar.f();
    }

    public static final String u(v vVar, boolean z10) {
        String host;
        kotlin.jvm.internal.p.i(vVar, "<this>");
        if (H.g0(vVar.getHost(), ServerSentEventKt.COLON, false, 2, null)) {
            host = '[' + vVar.getHost() + ']';
        } else {
            host = vVar.getHost();
        }
        if (!z10 && vVar.getPort() == v.INSTANCE.b(vVar.getScheme())) {
            return host;
        }
        return host + ':' + vVar.getPort();
    }

    public static /* synthetic */ String v(v vVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return u(vVar, z10);
    }

    public static final <T> List<T> w(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            return C1173v.m();
        }
        if (list.size() == 1) {
            List<T> listSingletonList = Collections.singletonList(list.get(0));
            kotlin.jvm.internal.p.h(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        Object[] array = list.toArray();
        kotlin.jvm.internal.p.h(array, "toArray(...)");
        List<T> listUnmodifiableList = Collections.unmodifiableList(C1168p.d(array));
        kotlin.jvm.internal.p.h(listUnmodifiableList, "unmodifiableList(...)");
        kotlin.jvm.internal.p.g(listUnmodifiableList, "null cannot be cast to non-null type kotlin.collections.List<T of okhttp3.internal._UtilJvmKt.toImmutableList>");
        return listUnmodifiableList;
    }

    public static final <T> List<T> x(T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            return C1173v.m();
        }
        if (tArr.length == 1) {
            List<T> listSingletonList = Collections.singletonList(tArr[0]);
            kotlin.jvm.internal.p.h(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        List<T> listUnmodifiableList = Collections.unmodifiableList(C1168p.d((Object[]) tArr.clone()));
        kotlin.jvm.internal.p.h(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }
}
