package androidx.core.os;

import android.os.Build;
import android.os.Message;

/* JADX INFO: loaded from: classes17.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    public static class Api22Impl {
        private Api22Impl() {
        }

        public static boolean isAsynchronous(Message r100) {
            return r100.isAsynchronous();
        }

        public static void setAsynchronous(Message r100, boolean r101) {
            r100.setAsynchronous(r101);
        }
    }

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message r100) {
        if (Build.VERSION.SDK_INT < 22) goto L7;
        return Api22Impl.isAsynchronous(r100);
    L7:
        if (sTryIsAsynchronous == true) goto L12;
    L11:
        return false;
    L12:
        return Api22Impl.isAsynchronous(r100);
    L10:
        sTryIsAsynchronous = false;
        goto L11
    }

    public static void setAsynchronous(Message r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 22) goto L7;
        Api22Impl.setAsynchronous(r100, r101);
        return;
    L7:
        if (sTrySetAsynchronous == false) goto L14;
        Api22Impl.setAsynchronous(r100, r101);     // Catch: NoSuchMethodError -> L10
        return;
    L10:
        sTrySetAsynchronous = false;
        return;
    }
}
