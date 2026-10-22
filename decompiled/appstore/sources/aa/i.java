package aa;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public static File a(Context r10, String r11) {
        BufferedWriter r12 = null;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        String r13 = com.monitor.cloudmessage.utils.b.h(r10).getAbsolutePath();
        String r14 = r13 + File.separator + "template.txt";
        File r15 = new File(r13);     // Catch: Throwable -> L9 IOException -> L11
        if (r15.exists() == true) goto L13;
        r15.mkdirs();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        FileWriter r16 = new FileWriter(r14);     // Catch: Throwable -> L9 IOException -> L11
        BufferedWriter r17 = new BufferedWriter(r16);     // Catch: Throwable -> L27 IOException -> L29
    L64:
        r17.write(r11);     // Catch: Throwable -> L22 IOException -> L25
        r17.close();     // Catch: IOException -> L18
        r16.close();     // Catch: IOException -> L18
    L21:
        return new File(r14);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L25:
        e = e;
    L26:
        IOException r18 = e;
        FileWriter r19 = r16;
        e = r18;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r17 != null) goto L54;
    L36:
        if (r19 == null) goto L40;
        r19.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L54:
        r17.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r12 = r17;
    L43:
        if (r12 != null) goto L52;
    L47:
        if (r19 == null) goto L51;
        r19.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L52:
        r12.close();     // Catch: IOException -> L45
    L22:
        th = th;
        r12 = r17;
    L24:
        Throwable r20 = th;
        r19 = r16;
        th = r20;
    L29:
        e = e;
        r17 = null;
    L27:
        th = th;
        goto L24
    L11:
        e = e;
        r19 = null;
        r17 = null;
    L9:
        th = th;
        r19 = null;
        goto L43
    }
}
