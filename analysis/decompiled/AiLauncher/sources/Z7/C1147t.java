package Z7;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.as;
import io.ktor.sse.ServerSentEventKt;
import java.lang.Thread;

/* renamed from: Z7.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1147t implements Thread.UncaughtExceptionHandler {

    /* renamed from: i, reason: collision with root package name */
    public static String f7614i;

    /* renamed from: j, reason: collision with root package name */
    public static final Object f7615j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f7616a;

    /* renamed from: b, reason: collision with root package name */
    public final as f7617b;

    /* renamed from: c, reason: collision with root package name */
    public final C1131c f7618c;

    /* renamed from: d, reason: collision with root package name */
    public final C1130b f7619d;

    /* renamed from: e, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f7620e;

    /* renamed from: f, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f7621f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7622g = false;

    /* renamed from: h, reason: collision with root package name */
    public int f7623h;

    public C1147t(Context context, as asVar, C1131c c1131c, C1130b c1130b) {
        this.f7616a = context;
        this.f7617b = asVar;
        this.f7618c = c1131c;
        this.f7619d = c1130b;
    }

    public static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }

    public static String b(Throwable th, int i10) {
        if (th == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i10 > 0 && sb2.length() >= i10) {
                        sb2.append("\n[Stack over limit size :" + i10 + " , has been cutted !]");
                        return sb2.toString();
                    }
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            }
        } catch (Throwable th2) {
            C1139k.j("gen stack error %s", th2.toString());
        }
        return sb2.toString();
    }

    public static void e(CrashDetailBean crashDetailBean, Throwable th, boolean z10) {
        String strB;
        String name = th.getClass().getName();
        String strA = a(th);
        C1139k.j("stack frame :%d, has cause %b", Integer.valueOf(th.getStackTrace().length), Boolean.valueOf(th.getCause() != null));
        String str = "";
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause == null || cause == th) {
            crashDetailBean.f31510n = name;
            if (r.a().h() && z10) {
                C1139k.j("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f31511o = strA + str;
            crashDetailBean.f31512p = string;
            strB = b(th, r.f7585o);
            crashDetailBean.f31513q = strB;
        } else {
            crashDetailBean.f31510n = cause.getClass().getName();
            crashDetailBean.f31511o = a(cause);
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.f31512p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(strA);
            sb2.append("\n");
            sb2.append(string);
            sb2.append("\n......");
            sb2.append("\nCaused by:\n");
            sb2.append(crashDetailBean.f31510n);
            sb2.append(ServerSentEventKt.COLON);
            sb2.append(crashDetailBean.f31511o);
            sb2.append("\n");
            strB = b(cause, r.f7585o);
            sb2.append(strB);
            crashDetailBean.f31513q = sb2.toString();
        }
        crashDetailBean.f31517u = C1143o.I(crashDetailBean.f31513q.getBytes());
        crashDetailBean.f31522z.put(crashDetailBean.f31471B, strB);
    }

    public static boolean g(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(Thread thread) {
        synchronized (f7615j) {
            try {
                if (f7614i != null && thread.getName().equals(f7614i)) {
                    return true;
                }
                f7614i = thread.getName();
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void k() {
        C1139k.j("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void c() {
        if (this.f7623h >= 10) {
            C1139k.d("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f7622g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (C1147t.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C1139k.d("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7621f = defaultUncaughtExceptionHandler;
                this.f7620e = defaultUncaughtExceptionHandler;
            } else {
                C1139k.d("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7620e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f7623h++;
        C1139k.d("registered java monitor: %s", toString());
    }

    public final synchronized void d(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z10 = strategyBean.f31452f;
            if (z10 != this.f7622g) {
                C1139k.d("java changed to %b", Boolean.valueOf(z10));
                if (strategyBean.f31452f) {
                    c();
                    return;
                }
                j();
            }
        }
    }

    public final void f(Thread thread, Throwable th, boolean z10, String str, byte[] bArr, boolean z11) {
        if (z10) {
            C1139k.j("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (h(thread)) {
                C1139k.d("this class has handled this exception", new Object[0]);
                if (this.f7621f != null) {
                    C1139k.d("call system handler", new Object[0]);
                    this.f7621f.uncaughtException(thread, th);
                } else {
                    k();
                }
            }
        } else {
            C1139k.j("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f7622g) {
                C1139k.h("Java crash handler is disable. Just return.", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7620e;
                    if (uncaughtExceptionHandler != null && g(uncaughtExceptionHandler)) {
                        C1139k.j("sys default last handle start!", new Object[0]);
                        this.f7620e.uncaughtException(thread, th);
                        C1139k.j("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7621f != null) {
                        C1139k.j("system handle start!", new Object[0]);
                        this.f7621f.uncaughtException(thread, th);
                        C1139k.j("system handle end!", new Object[0]);
                        return;
                    } else {
                        C1139k.j("crashreport last handle start!", new Object[0]);
                        k();
                        C1139k.j("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f7618c.h()) {
                C1139k.i("no remote but still store!", new Object[0]);
            }
            if (!this.f7618c.i().f31452f && this.f7618c.h()) {
                C1139k.j("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                as.k(z10 ? "JAVA_CRASH" : "JAVA_CATCH", C1143o.f(), this.f7619d.f7455f, thread.getName(), C1143o.l(th), null);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f7620e;
                    if (uncaughtExceptionHandler2 != null && g(uncaughtExceptionHandler2)) {
                        C1139k.j("sys default last handle start!", new Object[0]);
                        this.f7620e.uncaughtException(thread, th);
                        C1139k.j("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7621f != null) {
                        C1139k.j("system handle start!", new Object[0]);
                        this.f7621f.uncaughtException(thread, th);
                        C1139k.j("system handle end!", new Object[0]);
                        return;
                    } else {
                        C1139k.j("crashreport last handle start!", new Object[0]);
                        k();
                        C1139k.j("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanI = i(thread, th, z10, str, bArr, z11);
            if (crashDetailBeanI == null) {
                C1139k.j("pkg crash datas fail!", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f7620e;
                    if (uncaughtExceptionHandler3 != null && g(uncaughtExceptionHandler3)) {
                        C1139k.j("sys default last handle start!", new Object[0]);
                        this.f7620e.uncaughtException(thread, th);
                        C1139k.j("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7621f != null) {
                        C1139k.j("system handle start!", new Object[0]);
                        this.f7621f.uncaughtException(thread, th);
                        C1139k.j("system handle end!", new Object[0]);
                        return;
                    } else {
                        C1139k.j("crashreport last handle start!", new Object[0]);
                        k();
                        C1139k.j("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            as.k(z10 ? "JAVA_CRASH" : "JAVA_CATCH", C1143o.f(), this.f7619d.f7455f, thread.getName(), C1143o.l(th), crashDetailBeanI);
            if (!this.f7617b.w(crashDetailBeanI, z10)) {
                this.f7617b.C(crashDetailBeanI, z10);
            }
            if (z10) {
                this.f7617b.i(crashDetailBeanI);
            }
            if (z10) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f7620e;
                if (uncaughtExceptionHandler4 != null && g(uncaughtExceptionHandler4)) {
                    C1139k.j("sys default last handle start!", new Object[0]);
                    this.f7620e.uncaughtException(thread, th);
                    C1139k.j("sys default last handle end!", new Object[0]);
                } else if (this.f7621f != null) {
                    C1139k.j("system handle start!", new Object[0]);
                    this.f7621f.uncaughtException(thread, th);
                    C1139k.j("system handle end!", new Object[0]);
                } else {
                    C1139k.j("crashreport last handle start!", new Object[0]);
                    k();
                    C1139k.j("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!C1139k.e(th2)) {
                    th2.printStackTrace();
                }
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f7620e;
                    if (uncaughtExceptionHandler5 != null && g(uncaughtExceptionHandler5)) {
                        C1139k.j("sys default last handle start!", new Object[0]);
                        this.f7620e.uncaughtException(thread, th);
                        C1139k.j("sys default last handle end!", new Object[0]);
                    } else if (this.f7621f != null) {
                        C1139k.j("system handle start!", new Object[0]);
                        this.f7621f.uncaughtException(thread, th);
                        C1139k.j("system handle end!", new Object[0]);
                    } else {
                        C1139k.j("crashreport last handle start!", new Object[0]);
                        k();
                        C1139k.j("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f7620e;
                    if (uncaughtExceptionHandler6 != null && g(uncaughtExceptionHandler6)) {
                        C1139k.j("sys default last handle start!", new Object[0]);
                        this.f7620e.uncaughtException(thread, th);
                        C1139k.j("sys default last handle end!", new Object[0]);
                    } else if (this.f7621f != null) {
                        C1139k.j("system handle start!", new Object[0]);
                        this.f7621f.uncaughtException(thread, th);
                        C1139k.j("system handle end!", new Object[0]);
                    } else {
                        C1139k.j("crashreport last handle start!", new Object[0]);
                        k();
                        C1139k.j("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.tencent.bugly.crashreport.crash.CrashDetailBean i(java.lang.Thread r5, java.lang.Throwable r6, boolean r7, java.lang.String r8, byte[] r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.C1147t.i(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    public final synchronized void j() {
        this.f7622g = false;
        C1139k.d("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            C1139k.d("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f7620e);
            this.f7623h--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f7615j) {
            f(thread, th, true, null, null, this.f7619d.f7470m0);
        }
    }
}
