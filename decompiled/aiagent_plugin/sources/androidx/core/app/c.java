package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppOpsManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: compiled from: AppOpsManagerCompat.java */
    static class a {
        static String a(String r0) {
            return AppOpsManager.permissionToOp(r0);
        }

        static <T> T a(Context r2, Class<T> r3) {
            return (T) ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService(r3);
        }

        static int a(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOp(r1, r2);
        }

        static int b(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOpNoThrow(r1, r2);
        }
    }

    /* JADX INFO: compiled from: AppOpsManagerCompat.java */
    static class b {
        static AppOpsManager a(Context r2) {
            return (AppOpsManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService(AppOpsManager.class), AppOpsManager.class, "com.obric.aiagent.plugin");
        }

        static int a(AppOpsManager r0, String r1, int r2, String r3) {
            if (r0 != null) goto L6;
            return 1;
        L6:
            return r0.checkOpNoThrow(r1, r2, r3);
        }

        static String b(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getOpPackageName();
        }
    }

    public static String a(String r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return a.a(r2);
    }

    public static int a(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return a.b((AppOpsManager) ZeusTransformUtils.preCheckCast(a.a(r6, AppOpsManager.class), AppOpsManager.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static int a(Context r2, int r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AppOpsManager r0 = b.a(r6);
        int r7 = b.a(r0, r4, Binder.getCallingUid(), r5);
        if (r7 == 0) goto L8;
        return r7;
    L8:
        return b.a(r0, r4, r3, b.b(r6));
    L10:
        return a(r6, r4, r5);
    }
}
