package r3;

import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(File r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == false) goto L12;
        r10.delete();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static boolean b(File r10) {
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.exists() == false) goto L9;
        return r10.delete();
    }

    public static long c(String r10) {
        return new StatFs(r10).getAvailableBytes();
    }

    public static long d(String r10) {
        return new StatFs(r10).getTotalBytes();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0027: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:14:0x0027 */
    public static byte[] e(File r10) {
        Closeable r11 = null;
        if (r10 != null) goto L5;
    L32:
        return null;
    L5:
        if (r10.exists() == false) goto L32;
        int r12 = (int) r10.length();
        byte[] r13 = new byte[r12];
        BufferedInputStream r14 = new BufferedInputStream(new FileInputStream(r10));     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L23
    L34:
        r14.read(r13, 0, r12);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r14.close();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        d.a(r14);
        return r13;
    L17:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L13
    L26:
        d.a(r14);
        return null;
    L15:
        e = e;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = th;
        r11 = r3;
    L30:
        d.a(r11);
        throw th;
    L23:
        e = e;
        r14 = null;
    L21:
        e = e;
        r14 = null;
    L19:
        th = th;
        goto L30
    }
}
