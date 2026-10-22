package q2;

import M0.i;
import N9.j;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.Npth;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import com.stepos.statsrpk.d;
import e3.C1417f;
import h2.RunnableC1484b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import w2.f;
import y2.e;
import z2.k;
import z2.l;

/* renamed from: q2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1797b implements Thread.UncaughtExceptionHandler {
    public static C1797b l = null;
    public static volatile boolean m = false;
    public static volatile ThreadLocal n = new ThreadLocal();
    public static final ArrayList o = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f5573a;
    public com.zyql.ability.sdk.client.b b;
    public com.zyql.ability.sdk.client.b c;
    public volatile int d;
    public volatile int e;
    public ConcurrentHashMap f;
    public ConcurrentHashMap g;
    public Stack h;
    public HashMap i;

    /* renamed from: j, reason: collision with root package name */
    public volatile int f5574j;
    public RunnableC1484b k;

    public static Throwable b() {
        ArrayList arrayList = o;
        try {
            if (arrayList.size() > 0) {
                try {
                    if (arrayList.get(0) == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                } catch (Throwable unused) {
                }
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Looper.loop();
            }
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    public static C1797b c() {
        if (l == null) {
            C1797b c1797b = new C1797b();
            c1797b.d = 0;
            c1797b.e = 0;
            c1797b.f = new ConcurrentHashMap();
            c1797b.g = new ConcurrentHashMap();
            c1797b.h = new Stack();
            c1797b.i = new HashMap();
            c1797b.f5574j = 0;
            RunnableC1484b runnableC1484b = new RunnableC1484b(c1797b, 1);
            c1797b.k = runnableC1484b;
            c1797b.f();
            if (Npth.getConfigManager().isRegisterJavaCrashEnable()) {
                l.i().e(runnableC1484b);
                l.i().b(runnableC1484b, 5000L);
            }
            l = c1797b;
        }
        return l;
    }

    public static void d(Thread thread, Throwable th, boolean z10, long j5) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) k.f.e;
        CrashType crashType = z10 ? CrashType.LAUNCH : CrashType.JAVA;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Thread thread2 = thread;
            Throwable th2 = th;
            long j6 = j5;
            try {
                ((IOOMCallback) it.next()).onCrash(crashType, th2, thread2, j6);
            } catch (Throwable th3) {
                S0.b.p0(th3);
            }
            th = th2;
            thread = thread2;
            j5 = j6;
        }
    }

    public static void e(Thread thread, Throwable th, boolean z10, n2.a aVar) {
        CopyOnWriteArrayList<ICrashCallback> copyOnWriteArrayList;
        CrashType crashType;
        if (z10) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) k.f.f981a;
            crashType = CrashType.LAUNCH;
        } else {
            copyOnWriteArrayList = (CopyOnWriteArrayList) k.f.b;
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : copyOnWriteArrayList) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                iCrashCallback.onCrash(crashType, e.b(th), thread);
                aVar.n("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            } catch (Throwable th2) {
                S0.b.p0(th2);
                aVar.n("callback_err_".concat(iCrashCallback.getClass().getName()), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public static void i() {
        String[] list;
        File fileF = j.f(g.f2160a);
        File fileC = j.c();
        String[] list2 = fileF.list();
        if ((list2 == null || list2.length == 0) && ((list = fileC.list()) == null || list.length == 0)) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (!f.c().e && d.l(g.f2160a) && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    public final String a(File file, Throwable th, Thread thread, boolean z10) {
        C1417f c1417f;
        String absolutePath = file.getAbsolutePath();
        this.g.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.l(absolutePath);
        } catch (Throwable unused) {
        }
        String strC = null;
        if (z10) {
            int iV = NativeImpl.v(absolutePath);
            if (iV > 0) {
                try {
                    Context context = g.f2160a;
                    NativeImpl.c(iV, d.o());
                    NativeImpl.c(iV, "\n");
                    NativeImpl.c(iV, th.getMessage());
                    NativeImpl.c(iV, "\n");
                    NativeImpl.c(iV, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.c(iV, ": ");
                        NativeImpl.c(iV, th.getMessage());
                    }
                    NativeImpl.c(iV, "\n");
                    NativeImpl.c(iV, thread.getName());
                    NativeImpl.c(iV, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.c(iV, "stack:");
                    NativeImpl.c(iV, "\n");
                } catch (Throwable unused3) {
                }
                try {
                    e.o(iV, th);
                } catch (Throwable unused4) {
                }
                NativeImpl.i(iV);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    StringBuilder sb = new StringBuilder();
                    Context context2 = g.f2160a;
                    sb.append(d.o());
                    sb.append("\n");
                    fileOutputStream.write(sb.toString().getBytes());
                    fileOutputStream.write((th.getMessage() + "\n").getBytes());
                    fileOutputStream.write((th + "\n").getBytes());
                    fileOutputStream.write((thread.getName() + "\n").getBytes());
                } catch (Throwable unused5) {
                }
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused6) {
                }
                try {
                    PrintStream printStream = new PrintStream(fileOutputStream);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        C1796a c1796a = new C1796a(10);
                        c1796a.c = false;
                        c1417f = c1796a;
                    } else {
                        c1417f = new C1417f(10);
                    }
                    strC = e.c(th, printStream, c1417f);
                    i.i(fileOutputStream);
                } catch (Throwable th2) {
                    try {
                        th.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th2 + "\n").getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                        } catch (Throwable unused7) {
                        }
                    }
                }
                i.i(fileOutputStream);
            } catch (Throwable unused8) {
            }
        }
        return strC;
    }

    public final void f() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            if (defaultUncaughtExceptionHandler != null) {
                S0.b.N("Put this uncaught exception handler to stack. ".concat(defaultUncaughtExceptionHandler.getClass().getName()));
                this.h.push(defaultUncaughtExceptionHandler);
            }
            this.f5573a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public final void g(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Stack stack = this.h;
        try {
            if (!stack.isEmpty() && (uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) stack.pop()) != null) {
                this.f5573a = uncaughtExceptionHandler;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f5573a;
            if (uncaughtExceptionHandler2 != null && uncaughtExceptionHandler2 != this) {
                S0.b.N("mDefaultHandler != null, call mDefaultHandler.");
                this.f5573a.uncaughtException(thread, th);
                return;
            }
        } catch (Throwable unused) {
        }
        S0.b.N("Uncaught exception handler null, kill process.");
        Process.killProcess(Process.myPid());
    }

    public final void h() {
        synchronized (this) {
            this.e--;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (this.e != 0 && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            SystemClock.sleep(50L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01c3 A[Catch: all -> 0x02fa, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x02fa, blocks: (B:85:0x0166, B:110:0x01c3, B:120:0x01f0, B:127:0x0210), top: B:272:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x030f A[Catch: all -> 0x0313, TRY_LEAVE, TryCatch #26 {all -> 0x0313, blocks: (B:202:0x0309, B:204:0x030f), top: B:297:0x0309 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0151 A[EDGE_INSN: B:311:0x0151->B:78:0x0151 BREAK  A[LOOP:2: B:276:0x012d->B:75:0x0147], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0164  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void uncaughtException(java.lang.Thread r20, java.lang.Throwable r21) {
        /*
            Method dump skipped, instructions count: 871
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.C1797b.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
