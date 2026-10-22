package ze;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static String a(Throwable r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        Throwable r11 = r10;
    L6:
        if (r11 == null) goto L12;
        if ((r11 instanceof UnknownHostException) == true) goto L9;
        r11 = r11.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        StringWriter r12 = new StringWriter();
        PrintWriter r13 = new PrintWriter(r12);
        r10.printStackTrace(r13);     // Catch: Throwable -> L16
    L14:
        r13.flush();
        return r12.toString();
    }
}
