package androidx.profileinstaller;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class BenchmarkOperation {

    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context r0) {
            return r0.getCodeCacheDir();
        }
    }

    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static File getDeviceProtectedCodeCacheDir(Context r0) {
            return r0.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    private BenchmarkOperation() {
    }

    static void dropShaderCache(Context r1, ProfileInstallReceiver.ResultDiagnostics r2) {
        if (deleteFilesRecursively(Api24ContextHelper.getDeviceProtectedCodeCacheDir(r1)) == false) goto L5;
        r2.onResultReceived(14, null);
        return;
    L5:
        r2.onResultReceived(15, null);
    }

    static boolean deleteFilesRecursively(File r6) {
        if (r6.isDirectory() == false) goto L16;
        File[] r7 = r6.listFiles();
        if (r7 != null) goto L7;
        return false;
    L7:
        int r2 = r7.length;
        int r3 = 0;
        boolean r4 = true;
    L8:
        if (r3 >= r2) goto L15;
        if (deleteFilesRecursively(r7[r3]) == false) goto L13;
        if (r4 == false) goto L13;
        r4 = true;
    L14:
        r3 = r3 + 1;
    L13:
        r4 = false;
        goto L14
    L15:
        return r4;
    L16:
        r6.delete();
        return true;
    }
}
