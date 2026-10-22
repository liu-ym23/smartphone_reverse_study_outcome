package androidx.profileinstaller;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    public static class C0039a {
        public static File a(Context r10) {
            return r10.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File r10) {
        if (r10.isDirectory() == false) goto L16;
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L7;
        return false;
    L7:
        int r12 = r11.length;
        int r13 = 0;
        boolean r14 = true;
    L8:
        if (r13 >= r12) goto L15;
        if (a(r11[r13]) == false) goto L13;
        if (r14 == false) goto L13;
        r14 = true;
    L14:
        r13 = r13 + 1;
    L13:
        r14 = false;
        goto L14
    L15:
        return r14;
    L16:
        r10.delete();
        return true;
    }

    public static void b(Context r10, ProfileInstallReceiver.a r11) {
        if (a(C0039a.a(r10)) == false) goto L5;
        r11.onResultReceived(14, null);
        return;
    L5:
        r11.onResultReceived(15, null);
    }
}
