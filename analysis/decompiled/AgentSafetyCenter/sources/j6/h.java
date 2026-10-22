package j6;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;
import stepos.support.v7.widget.x1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends Thread {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6607c = 2;

    public /* synthetic */ h() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws NoSuchMethodException, SecurityException {
        ReentrantLock reentrantLock;
        od.d dVarI;
        switch (this.f6607c) {
            case 0:
                try {
                    super.run();
                    return;
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    return;
                }
            case 1:
                break;
            default:
                if (x1.f12902b == null) {
                    try {
                        Method method = View.class.getMethod("makeOptionalFitsSystemWindows", null);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        x1.f12902b = method;
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    }
                }
                if (x1.f12901a == null) {
                    try {
                        Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                        x1.f12901a = declaredMethod;
                        if (!declaredMethod.isAccessible()) {
                            x1.f12901a.setAccessible(true);
                        }
                    } catch (NoSuchMethodException unused2) {
                        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                    }
                }
                x1.f12903c = 2;
                return;
        }
        while (true) {
            try {
                ReentrantLock reentrantLock2 = od.d.f9430h;
                reentrantLock = od.d.f9430h;
                reentrantLock.lock();
                try {
                    dVarI = f8.b.i();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            } catch (InterruptedException unused3) {
                continue;
            }
            if (dVarI == od.d.f9433l) {
                od.d.f9433l = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (dVarI != null) {
                    dVarI.j();
                }
            }
        }
    }

    public /* synthetic */ h(Runnable runnable, String str) {
        super(runnable, str);
    }

    public /* synthetic */ h(String str) {
        super(str);
    }
}
