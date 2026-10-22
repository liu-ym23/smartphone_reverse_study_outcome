package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void stopForeground(Service r100, int r101) {
            r100.stopForeground(r101);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void startForeground(Service r100, int r101, Notification r102, int r103) {
            if (r103 != 0) goto L4;
        L7:
            r100.startForeground(r101, r102, r103);
            return;
        L4:
            if (r103 == (-1)) goto L7;
            r100.startForeground(r101, r102, r103 & 255);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void startForeground(Service r100, int r101, Notification r102, int r103) {
            if (r103 != 0) goto L4;
        L7:
            r100.startForeground(r101, r102, r103);
            return;
        L4:
            if (r103 == (-1)) goto L7;
            r100.startForeground(r101, r102, r103 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void stopForeground(Service r100, int r101) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.stopForeground(r100, r101);
        return;
    L5:
        boolean r102 = true;
        if ((r101 & 1) != 0) goto L9;
        r102 = false;
    L9:
        r100.stopForeground(r102);
    }

    public static void startForeground(Service r100, int r101, Notification r102, int r103) {
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 34) goto L6;
        Api34Impl.startForeground(r100, r101, r102, r103);
        return;
    L6:
        if (r104 < 29) goto L8;
        Api29Impl.startForeground(r100, r101, r102, r103);
        return;
    L8:
        r100.startForeground(r101, r102);
    }
}
