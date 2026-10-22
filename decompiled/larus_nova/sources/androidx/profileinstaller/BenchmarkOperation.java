package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes17.dex */
class BenchmarkOperation {

    public static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        public static File getCodeCacheDir(Context r100) {
            return r100.getCodeCacheDir();
        }
    }

    public static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        public static Context createDeviceProtectedStorageContext(Context r100) {
            return r100.createDeviceProtectedStorageContext();
        }
    }

    private BenchmarkOperation() {
    }

    public static boolean deleteFilesRecursively(File r100) {
        if (r100.isDirectory() == false) goto L16;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L7;
        return false;
    L7:
        int r102 = r101.length;
        int r103 = 0;
        boolean r104 = true;
    L8:
        if (r103 >= r102) goto L15;
        if (deleteFilesRecursively(r101[r103]) == false) goto L13;
        if (r104 == false) goto L13;
        r104 = true;
    L14:
        r103 = r103 + 1;
    L13:
        r104 = false;
        goto L14
    L15:
        return r104;
    L16:
        r100.delete();
        return true;
    }

    public static void dropShaderCache(Context r100, ProfileInstallReceiver.ResultDiagnostics r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 34) goto L6;
        File r103 = Api24ContextHelper.createDeviceProtectedStorageContext(r100).getCacheDir();
    L13:
        if (deleteFilesRecursively(r103) == false) goto L15;
        r101.onResultReceived(14, null);
        return;
    L15:
        r101.onResultReceived(15, null);
        return;
    L6:
        if (r102 < 24) goto L9;
        r103 = Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(r100));
        goto L13
    L9:
        if (r102 != 23) goto L11;
        r103 = Api21ContextHelper.getCodeCacheDir(r100);
        goto L13
    L11:
        r103 = r100.getCacheDir();
        goto L13
    }
}
