package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void stopForeground(Service service, int i) {
            service.stopForeground(i);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void startForeground(Service service, int i, Notification notification, int i6) {
            if (i6 == 0 || i6 == -1) {
                service.startForeground(i, notification, i6);
            } else {
                service.startForeground(i, notification, i6 & 255);
            }
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void startForeground(Service service, int i, Notification notification, int i6) {
            if (i6 == 0 || i6 == -1) {
                service.startForeground(i, notification, i6);
            } else {
                service.startForeground(i, notification, i6 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(Service service, int i, Notification notification, int i6) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.startForeground(service, i, notification, i6);
        } else {
            Api29Impl.startForeground(service, i, notification, i6);
        }
    }

    public static void stopForeground(Service service, int i) {
        Api24Impl.stopForeground(service, i);
    }
}
