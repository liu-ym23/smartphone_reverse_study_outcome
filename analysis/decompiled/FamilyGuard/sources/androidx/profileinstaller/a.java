package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes.dex */
class a {

    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    private static class C0144a {
        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z5 = true;
        for (File file2 : fileArrListFiles) {
            z5 = a(file2) && z5;
        }
        return z5;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        if (a(C0144a.a(context))) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
