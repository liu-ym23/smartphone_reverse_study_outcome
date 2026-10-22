package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import java.io.File;
import java.util.concurrent.Executor;
import s0.h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f13081a = new Object();

    /* renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    public static class C0157a {
        public static Drawable a(Context context, int i10) {
            return context.getDrawable(i10);
        }
    }

    public static class b {
        public static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        public static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }
    }

    public static class c {
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    public static class d {
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static class e {
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10);
        }
    }

    public static int a(Context context, String str) {
        B0.c.d(str, "permission must be non-null");
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static Context b(Context context) {
        return c.a(context);
    }

    public static int c(Context context, int i10) {
        return b.a(context, i10);
    }

    public static ColorStateList d(Context context, int i10) {
        return h.d(context.getResources(), i10, context.getTheme());
    }

    public static Drawable e(Context context, int i10) {
        return C0157a.a(context, i10);
    }

    @Deprecated
    public static File[] f(Context context) {
        return context.getExternalCacheDirs();
    }

    @Deprecated
    public static File[] g(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Executor h(Context context) {
        return d.a(context);
    }

    public static <T> T i(Context context, Class<T> cls) {
        return (T) b.b(context, cls);
    }

    public static Intent j(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i10) {
        return k(context, broadcastReceiver, intentFilter, null, null, i10);
    }

    public static Intent k(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
        int i11 = i10 & 1;
        if (i11 != 0 && (i10 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i11 != 0) {
            i10 |= 2;
        }
        int i12 = i10;
        int i13 = i12 & 2;
        if (i13 == 0 && (i12 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i13 == 0 || (i12 & 4) == 0) {
            return e.a(context, broadcastReceiver, intentFilter, str, handler, i12);
        }
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    }

    public static boolean l(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    @Deprecated
    public static void m(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
