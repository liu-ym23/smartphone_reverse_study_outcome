package E2;

import android.graphics.Rect;
import android.os.Process;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;
import stepos.support.v7.widget.I0;

/* loaded from: classes2.dex */
public final class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f455a = 3;

    public /* synthetic */ b() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws NoSuchMethodException, SecurityException, IllegalArgumentException {
        ReentrantLock reentrantLock;
        switch (this.f455a) {
            case 0:
                Process.setThreadPriority(10);
                super.run();
                return;
            case 1:
                break;
            case 2:
                try {
                    super.run();
                    return;
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    return;
                }
            default:
                if (I0.b == null) {
                    try {
                        Method method = View.class.getMethod("makeOptionalFitsSystemWindows", null);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        I0.b = method;
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    }
                }
                if (I0.f6469a == null) {
                    try {
                        Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                        I0.f6469a = declaredMethod;
                        if (!declaredMethod.isAccessible()) {
                            I0.f6469a.setAccessible(true);
                        }
                    } catch (NoSuchMethodException unused2) {
                        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                    }
                }
                I0.c = 2;
                return;
        }
        while (true) {
            try {
                reentrantLock = V9.d.h;
                reentrantLock.lock();
            } catch (InterruptedException unused3) {
            }
            try {
                V9.d dVarA = M.a.A();
                if (dVarA == V9.d.l) {
                    V9.d.l = null;
                    reentrantLock.unlock();
                    return;
                } else {
                    reentrantLock.unlock();
                    if (dVarA != null) {
                        dVarA.j();
                    }
                }
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    public /* synthetic */ b(Runnable runnable, String str) {
        super(runnable, str);
    }

    public /* synthetic */ b(String str) {
        super(str);
    }

    public /* synthetic */ b(ThreadGroup threadGroup, Runnable runnable, String str, long j5) {
        super(threadGroup, runnable, str, j5);
    }
}
