package i5;

import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static boolean a(String r10) {
        return new File(r10).mkdirs();
    }

    public static void b(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void c(ZipFile r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: Throwable -> L6
        return;
    }

    public static void d(String r10, int r11) {
        j5.a.a("android.os.FileUtils", "setPermissions", new Object[]{r10, Integer.valueOf(r11), -1, -1});
    }
}
