package x3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Closeable r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: IOException -> L6
        return;
    }

    public static boolean b(String r10, String r11) {
        File r12 = new File(r10);
        File r13 = new File(r11);
        if (r12.exists() == true) goto L7;
        return false;
    L7:
        return r12.renameTo(r13);
    }
}
