package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* JADX INFO: loaded from: classes17.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static String permissionToOp(String r100) {
            return AppOpsManager.permissionToOp(r100);
        }

        public static <T> T getSystemService(Context r100, Class<T> r101) {
            return (T) r100.getSystemService(r101);
        }

        public static int noteProxyOp(AppOpsManager r100, String r101, String r102) {
            return r100.noteProxyOp(r101, r102);
        }

        public static int noteProxyOpNoThrow(AppOpsManager r100, String r101, String r102) {
            return r100.noteProxyOpNoThrow(r101, r102);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static String getOpPackageName(Context r100) {
            return r100.getOpPackageName();
        }

        public static AppOpsManager getSystemService(Context r100) {
            return (AppOpsManager) r100.getSystemService(AppOpsManager.class);
        }

        public static int checkOpNoThrow(AppOpsManager r100, String r101, int r102, String r103) {
            if (r100 != null) goto L6;
            return 1;
        L6:
            return r100.checkOpNoThrow(r101, r102, r103);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static String permissionToOp(String r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.permissionToOp(r100);
    }

    public static int noteProxyOp(Context r100, String r101, String r102) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(r100, AppOpsManager.class), r101, r102);
    }

    public static int noteProxyOpNoThrow(Context r100, String r101, String r102) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(r100, AppOpsManager.class), r101, r102);
    }

    public static int checkOrNoteProxyOp(Context r100, int r101, String r102, String r103) {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AppOpsManager r104 = Api29Impl.getSystemService(r100);
        int r105 = Api29Impl.checkOpNoThrow(r104, r102, Binder.getCallingUid(), r103);
        if (r105 == 0) goto L8;
        return r105;
    L8:
        return Api29Impl.checkOpNoThrow(r104, r102, r101, Api29Impl.getOpPackageName(r100));
    L10:
        return noteProxyOpNoThrow(r100, r102, r103);
    }

    public static int noteOp(Context r100, String r101, int r102, String r103) {
        return ((AppOpsManager) r100.getSystemService("appops")).noteOp(r101, r102, r103);
    }

    public static int noteOpNoThrow(Context r100, String r101, int r102, String r103) {
        return ((AppOpsManager) r100.getSystemService("appops")).noteOpNoThrow(r101, r102, r103);
    }
}
