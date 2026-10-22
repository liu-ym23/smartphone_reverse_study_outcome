package androidx.core.os;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }

        public static Handler createAsync(Looper r0, Handler.Callback r1) {
            return Handler.createAsync(r0, r1);
        }

        public static boolean postDelayed(Handler r0, Runnable r1, Object r2, long r3) {
            return r0.postDelayed(r1, r2, r3);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler r0, Runnable r1) {
            return r0.hasCallbacks(r1);
        }
    }

    public static Handler createAsync(Looper r0) {
        return Api28Impl.createAsync(r0);
    }

    public static Handler createAsync(Looper r0, Handler.Callback r1) {
        return Api28Impl.createAsync(r0, r1);
    }

    public static boolean postDelayed(Handler r0, Runnable r1, Object r2, long r3) {
        return Api28Impl.postDelayed(r0, r1, r2, r3);
    }

    public static boolean hasCallbacks(Handler r0, Runnable r1) {
        return Api29Impl.hasCallbacks(r0, r1);
    }

    private HandlerCompat() {
    }
}
