package aa;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static File a(Context r10, String r11, String r12) {
        BufferedWriter r13 = null;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        String r14 = com.monitor.cloudmessage.utils.b.h(r10).getAbsolutePath();
        String r15 = r14 + File.separator + r12 + ".txt";
        File r16 = new File(r14);     // Catch: Throwable -> L9 IOException -> L11
        if (r16.exists() == true) goto L13;
        r16.mkdirs();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        FileWriter r17 = new FileWriter(r15);     // Catch: Throwable -> L9 IOException -> L11
        BufferedWriter r18 = new BufferedWriter(r17);     // Catch: Throwable -> L27 IOException -> L29
    L62:
        r18.write(r11);     // Catch: Throwable -> L22 IOException -> L25
        r18.close();     // Catch: IOException -> L18
        r17.close();     // Catch: IOException -> L18
    L21:
        return new File(r15);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L25:
        e = e;
    L26:
        IOException r19 = e;
        FileWriter r20 = r17;
        e = r19;
    L54:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r18 != null) goto L56;
    L36:
        if (r20 == null) goto L40;
        r20.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L56:
        r18.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r13 = r18;
    L43:
        if (r13 != null) goto L52;
    L47:
        if (r20 == null) goto L51;
        r20.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L52:
        r13.close();     // Catch: IOException -> L45
    L22:
        th = th;
        r13 = r18;
    L24:
        Throwable r21 = th;
        r20 = r17;
        th = r21;
    L29:
        e = e;
        r18 = null;
    L27:
        th = th;
        goto L24
    L11:
        e = e;
        r20 = null;
        r18 = null;
    L9:
        th = th;
        r20 = null;
        goto L43
    }
}
