package androidx.core.os;

import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public final class ProcessCompat {

    public static class Api19Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api19Impl() {
        }

        public static boolean isApplicationUid(int r100) {
            Object r101 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r101);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r101);     // Catch: Throwable -> L17
            Method r102 = sMethodUserHandleIsAppMethod;     // Catch: Exception -> L20
            if (r102 == null) goto L22;
            Boolean r103 = (Boolean) r102.invoke(null, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L20
            if (r103 == null) goto L16;
            return r103.booleanValue();
        L16:
            throw new NullPointerException();     // Catch: Exception -> L20
        L22:
            return true;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isApplicationUid(int r100) {
            return Process.isApplicationUid(r100);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int r100) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.isApplicationUid(r100);
    L7:
        return Api19Impl.isApplicationUid(r100);
    }
}
