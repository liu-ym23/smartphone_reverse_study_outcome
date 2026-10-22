package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {
        @DoNotInline
        public static <T> T a(Context r10, Class<T> r11) {
            return (T) r10.getSystemService(r11);
        }

        @DoNotInline
        public static int b(AppOpsManager r10, String r11, String r12) {
            return r10.noteProxyOp(r11, r12);
        }

        @DoNotInline
        public static int c(AppOpsManager r10, String r11, String r12) {
            return r10.noteProxyOpNoThrow(r11, r12);
        }

        @DoNotInline
        public static String d(String r10) {
            return AppOpsManager.permissionToOp(r10);
        }
    }

    public static class b {
        @DoNotInline
        public static int a(@Nullable AppOpsManager r10, @NonNull String r11, int r12, @NonNull String r13) {
            if (r10 != null) goto L6;
            return 1;
        L6:
            return r10.checkOpNoThrow(r11, r12, r13);
        }

        @NonNull
        @DoNotInline
        public static String b(@NonNull Context r10) {
            return r10.getOpPackageName();
        }

        @Nullable
        @DoNotInline
        public static AppOpsManager c(@NonNull Context r10) {
            return (AppOpsManager) r10.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(Context r10, int r11, String r12, String r13) {
        AppOpsManager r14 = b.c(r10);
        int r15 = b.a(r14, r12, Binder.getCallingUid(), r13);
        if (r15 == 0) goto L6;
        return r15;
    L6:
        return b.a(r14, r12, r11, b.b(r10));
    }

    public static int b(Context r10, String r11, String r12) {
        return a.c((AppOpsManager) a.a(r10, AppOpsManager.class), r11, r12);
    }

    public static String c(String r10) {
        return a.d(r10);
    }
}
