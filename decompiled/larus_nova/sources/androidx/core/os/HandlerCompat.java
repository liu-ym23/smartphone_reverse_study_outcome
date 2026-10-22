package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r100) {
            return Handler.createAsync(r100);
        }

        public static Handler createAsync(Looper r100, Handler.Callback r101) {
            return Handler.createAsync(r100, r101);
        }

        public static boolean postDelayed(Handler r100, Runnable r101, Object r102, long r103) {
            return r100.postDelayed(r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler r100, Runnable r101) {
            return r100.hasCallbacks(r101);
        }
    }

    private HandlerCompat() {
    }

    public static Handler createAsync(Looper r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r100, null, Boolean.TRUE});
    L8:
        e = move-exception;
        Throwable r101 = e.getCause();
        if ((r101 instanceof RuntimeException) == true) goto L18;
        if ((r101 instanceof Error) == false) goto L16;
        throw ((Error) r101);
    L16:
        throw new RuntimeException(r101);
    L18:
        throw ((RuntimeException) r101);
    L20:
        return new Handler(r100);
    L5:
        return Api28Impl.createAsync(r100);
    }

    public static Handler createAsync(Looper r100, Handler.Callback r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r100, r101, Boolean.TRUE});
    L8:
        e = move-exception;
        Throwable r102 = e.getCause();
        if ((r102 instanceof RuntimeException) == true) goto L18;
        if ((r102 instanceof Error) == false) goto L16;
        throw ((Error) r102);
    L16:
        throw new RuntimeException(r102);
    L18:
        throw ((RuntimeException) r102);
    L20:
        return new Handler(r100, r101);
    L5:
        return Api28Impl.createAsync(r100, r101);
    }

    public static boolean hasCallbacks(Handler r100, Runnable r101) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return ((Boolean) Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(r100, new Object[]{r101})).booleanValue();
    L12:
        e = e;
    L14:
        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
    L10:
        e = e;
    L8:
        e = e;
    L15:
        e = move-exception;
        Throwable r102 = e.getCause();
        if ((r102 instanceof RuntimeException) == true) goto L25;
        if ((r102 instanceof Error) == false) goto L23;
        throw ((Error) r102);
    L23:
        throw new RuntimeException(r102);
    L25:
        throw ((RuntimeException) r102);
    L5:
        return Api29Impl.hasCallbacks(r100, r101);
    }

    public static boolean postDelayed(Handler r100, Runnable r101, Object r102, long r103) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Message r104 = Message.obtain(r100, r101);
        r104.obj = r102;
        return r100.sendMessageDelayed(r104, r103);
    L5:
        return Api28Impl.postDelayed(r100, r101, r102, r103);
    }
}
