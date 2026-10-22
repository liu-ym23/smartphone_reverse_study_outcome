package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BundleCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: compiled from: BundleCompat.java */
    static class a {
        static IBinder a(Bundle r0, String r1) {
            return r0.getBinder(r1);
        }

        static void a(Bundle r2, String r3, IBinder r4) {
            r2.putBinder(r3, (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BundleCompat.java */
    static class b {
        private static final String TAG = "BundleCompat";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Method f1260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f1261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f1262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f1263d;

        public static IBinder a(Bundle r7, String r8) {
            if (f1261b == false) goto L18;
        L9:
            Method r0 = f1260a;
            if (r0 != null) goto L16;
        L15:
            return null;
        L16:
            return (IBinder) ZeusTransformUtils.preCheckCast(r0.invoke(r7, new Object[]{r8}), IBinder.class, "com.obric.aiagent.plugin");
        L13:
            e = move-exception;
            a(TAG, "Failed to invoke getIBinder via reflection", e);
            f1260a = null;
            goto L15
        L18:
            Method r1 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});     // Catch: NoSuchMethodException -> L6
            f1260a = r1;     // Catch: NoSuchMethodException -> L6
            r1.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            f1261b = true;
        L6:
            e = move-exception;
            a(TAG, "Failed to retrieve getIBinder method", e);
            goto L8
        }

        public static void a(Bundle r8, String r9, IBinder r10) {
            IBinder r11 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.aiagent.plugin");
            if (f1263d == false) goto L16;
        L9:
            Method r0 = f1262c;
            if (r0 == null) goto L20;
            r0.invoke(r8, new Object[]{r9, r11});     // Catch: Throwable -> L13
            return;
        L13:
            e = move-exception;
            a(TAG, "Failed to invoke putIBinder via reflection", e);
            f1262c = null;
            return;
        L20:
            return;
        L16:
            Method r1 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});     // Catch: NoSuchMethodException -> L6
            f1262c = r1;     // Catch: NoSuchMethodException -> L6
            r1.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            f1263d = true;
        L6:
            e = move-exception;
            a(TAG, "Failed to retrieve putIBinder method", e);
            goto L8
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2, r3);
        }
    }

    public static IBinder a(Bundle r2, String r3) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return a.a(r2, r3);
    L7:
        return b.a(r2, r3);
    }

    public static void a(Bundle r2, String r3, IBinder r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 18) goto L5;
        a.a(r2, r3, r5);
        return;
    L5:
        b.a(r2, r3, r5);
    }
}
