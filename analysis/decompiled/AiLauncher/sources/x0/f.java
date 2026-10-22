package x0;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class f {

    public static class a {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static boolean b(Handler handler, Runnable runnable, Object obj, long j10) {
            return handler.postDelayed(runnable, obj, j10);
        }
    }

    public static Handler a(Looper looper) {
        return a.a(looper);
    }

    public static boolean b(Handler handler, Runnable runnable, Object obj, long j10) {
        return a.b(handler, runnable, obj, j10);
    }
}
