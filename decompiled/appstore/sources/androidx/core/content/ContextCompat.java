package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.os.BuildCompat;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContextCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f2510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2511b = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RegisterReceiverFlags {
    }

    public static class a {
        @DoNotInline
        public static void a(Context r10, Intent[] r11, Bundle r12) {
            r10.startActivities(r11, r12);
        }

        @DoNotInline
        public static void b(Context r10, Intent r11, Bundle r12) {
            r10.startActivity(r11, r12);
        }
    }

    public static class b {
        @DoNotInline
        public static File[] a(Context r10) {
            return r10.getExternalCacheDirs();
        }

        @DoNotInline
        public static File[] b(Context r10, String r11) {
            return r10.getExternalFilesDirs(r11);
        }

        @DoNotInline
        public static File[] c(Context r10) {
            return r10.getObbDirs();
        }
    }

    public static class c {
        @DoNotInline
        public static File a(Context r10) {
            return r10.getCodeCacheDir();
        }

        @DoNotInline
        public static Drawable b(Context r10, int r11) {
            return r10.getDrawable(r11);
        }

        @DoNotInline
        public static File c(Context r10) {
            return r10.getNoBackupFilesDir();
        }
    }

    public static class d {
        @DoNotInline
        public static int a(Context r10, int r11) {
            return r10.getColor(r11);
        }

        @DoNotInline
        public static <T> T b(Context r10, Class<T> r11) {
            return (T) r10.getSystemService(r11);
        }

        @DoNotInline
        public static String c(Context r10, Class<?> r11) {
            return r10.getSystemServiceName(r11);
        }
    }

    public static class e {
        @DoNotInline
        public static Intent a(Context r10, @Nullable BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
            if ((r15 & 4) == 0) goto L8;
            if (r13 != null) goto L8;
            return r10.registerReceiver(r11, r12, ContextCompat.i(r10), r14);
        L8:
            return r10.registerReceiver(r11, r12, r13, r14, r15 & 1);
        }

        @DoNotInline
        public static ComponentName b(Context r10, Intent r11) {
            return r10.startForegroundService(r11);
        }
    }

    public static class f {
        @DoNotInline
        public static Executor a(Context r10) {
            return r10.getMainExecutor();
        }
    }

    static {
        f2510a = new Object();
        f2511b = new Object();
    }

    public static int a(Context r10, String r11) {
        androidx.core.util.b.c(r11, "permission must be non-null");
        if (BuildCompat.c() == true) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r11) == false) goto L12;
        if (NotificationManagerCompat.b(r10).a() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return r10.checkPermission(r11, Process.myPid(), Process.myUid());
    }

    public static int b(Context r10, int r11) {
        return d.a(r10, r11);
    }

    public static ColorStateList c(Context r10, int r11) {
        return androidx.core.content.res.a.e(r10.getResources(), r11, r10.getTheme());
    }

    public static Drawable d(Context r10, int r11) {
        return c.b(r10, r11);
    }

    public static File[] e(Context r10) {
        return b.a(r10);
    }

    public static File[] f(Context r10, String r11) {
        return b.b(r10, r11);
    }

    public static Executor g(Context r10) {
        return f.a(r10);
    }

    public static Object h(Context r10, Class r11) {
        return d.b(r10, r11);
    }

    public static String i(Context r10) {
        String r11 = r10.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (PermissionChecker.b(r10, r11) != 0) goto L6;
        return r11;
    L6:
        throw new RuntimeException("Permission " + r11 + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static boolean j(Context r10, Intent[] r11, Bundle r12) {
        a.a(r10, r11, r12);
        return true;
    }

    public static void k(Context r10, Intent r11, Bundle r12) {
        a.b(r10, r11, r12);
    }

    public static void l(Context r10, Intent r11) {
        e.b(r10, r11);
    }
}
