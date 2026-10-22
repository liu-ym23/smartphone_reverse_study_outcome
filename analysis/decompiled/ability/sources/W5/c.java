package W5;

import D9.t;
import a.AbstractC0291a;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.stepos.statsapp.v3.utils.log.LogLevel;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static t f1491a;
    public static final Handler b;
    public static final boolean c;

    static {
        boolean z10 = false;
        c = false;
        try {
            String strV = AbstractC0291a.v("persist.stepos.usagestats.log", "false");
            if (strV != null) {
                if (strV.equals("true")) {
                    z10 = true;
                }
            }
        } catch (Exception e) {
            androidx.constraintlayout.core.dsl.a.t(e, new StringBuilder("isPrintLog error "), "CommonUtils");
        }
        c = z10;
        HandlerThread handlerThread = new HandlerThread("UsageStats_Logger");
        handlerThread.start();
        b = new Handler(handlerThread.getLooper());
    }

    public static void a(String str, String str2) {
        Log.d("[Cloud]Data", c(str, str2));
        b.post(new b(LogLevel.b, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void b(String str, String str2) {
        Log.e("[Cloud]Data", c(str, str2));
        b.post(new b(LogLevel.e, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static String c(String str, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb = new StringBuilder("[");
        sb.append(threadCurrentThread.getName());
        sb.append("-");
        sb.append(threadCurrentThread.getId());
        sb.append("][");
        sb.append(str);
        return B7.a.q(sb, "] ", str2);
    }

    public static void d(String str, String str2) {
        Log.i("[Cloud]Data", c(str, str2));
        b.post(new b(LogLevel.c, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void e(String str, String str2) {
        Log.v("[Cloud]Data", c(str, str2));
        b.post(new b(LogLevel.f3974a, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }

    public static void f(String str, String str2) {
        Log.w("[Cloud]Data", c(str, str2));
        b.post(new b(LogLevel.d, str, str2, Thread.currentThread().getId(), Thread.currentThread().getName()));
    }
}
