package F5;

import La.H;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.g;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LF5/b;", "", "<init>", "()V", "LY8/t;", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "e", "", "f", "(Ljava/lang/Throwable;)Z", "", "name", "Ljava/lang/Thread;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/Thread;", "TAG", "Ljava/lang/String;", "THREAD_NAME", "installed", "Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final String TAG = "FinalizerWatchdogGuard";
    private static final String THREAD_NAME = "FinalizerWatchdogDaemon";
    private static volatile boolean installed;

    public static final void c() {
        if (installed) {
            return;
        }
        installed = true;
        b bVar = INSTANCE;
        bVar.d();
        bVar.h();
        bVar.g();
    }

    public static final void e(b bVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        if (bVar.f(th)) {
            Log.w(TAG, "swallow finalizer timeout (uncaught): " + th.getMessage());
            return;
        }
        if (uncaughtExceptionHandler == null) {
            uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public final Thread b(String name) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        if (threadGroup == null) {
            return null;
        }
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
            p.f(threadGroup);
        }
        Thread[] threadArr = new Thread[threadGroup.activeCount() + 32];
        int iEnumerate = threadGroup.enumerate(threadArr, true);
        while (iEnumerate >= threadArr.length) {
            threadArr = new Thread[threadArr.length * 2];
            iEnumerate = threadGroup.enumerate(threadArr, true);
        }
        for (int i10 = 0; i10 < iEnumerate; i10++) {
            Thread thread = threadArr[i10];
            if (p.d(thread != null ? thread.getName() : null, name)) {
                return threadArr[i10];
            }
        }
        return null;
    }

    public final void d() {
        Object objB;
        Thread threadB;
        try {
            Result.Companion companion = Result.INSTANCE;
            threadB = b(THREAD_NAME);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (threadB == null) {
            return;
        }
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadB.getUncaughtExceptionHandler();
        threadB.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: F5.a
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th2) {
                b.e(this.f2577a, uncaughtExceptionHandler, thread, th2);
            }
        });
        objB = Result.b(Integer.valueOf(Log.i(TAG, "uncaught handler installed on FinalizerWatchdogDaemon")));
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "installUncaughtHandler failed: " + thE.getMessage());
        }
    }

    public final boolean f(Throwable e10) {
        while (e10 != null) {
            if (e10 instanceof TimeoutException) {
                return true;
            }
            String message = e10.getMessage();
            if (message != null && H.g0(message, "finalize() timed out", false, 2, null)) {
                return true;
            }
            e10 = e10.getCause();
        }
        return false;
    }

    public final void g() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(b(THREAD_NAME));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Thread thread = (Thread) objB;
        boolean z10 = false;
        if (thread != null && thread.isAlive()) {
            z10 = true;
        }
        if (thread == null || !z10) {
            Log.i(TAG, "selfCheck: FinalizerWatchdogDaemon stopped (guard effective)");
            return;
        }
        Log.w(TAG, "selfCheck: FinalizerWatchdogDaemon still ALIVE (state=" + thread.getState() + "); stop() not effective on this ROM, relying on uncaught-handler fallback only");
    }

    public final void h() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon").getDeclaredField("INSTANCE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Method declaredMethod = Class.forName("java.lang.Daemons$Daemon").getDeclaredMethod(g.ACTION_STOP, null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, null);
            objB = Result.b(Integer.valueOf(Log.i(TAG, "FinalizerWatchdogDaemon stopped")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "stopWatchdogDaemon failed: " + thE.getMessage());
        }
    }
}
