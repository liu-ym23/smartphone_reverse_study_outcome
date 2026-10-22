package ba;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import w0.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static void a(String r10, String r11, int r12, Map r13) {
        if (c.B() == false) goto L5;
        s1.c.b("cloudmessage", new String[]{"report: commandId=" + r10, ", message=" + r11, ", code=" + r12, ", specificParams=" + r13});
    L5:
        if (r13 == null) goto L8;
        HashMap r14 = new HashMap(r13);
    L9:
        da.b r15 = new da.b(0, false, r10, r14);
        r15.h(r12);
        r15.i(r11);
        ca.a.d(r15);
        return;
    L8:
        r14 = null;
        goto L9
    }

    public static boolean b(String r10, File r11, String r12, String r13) {
        if (c.B() == false) goto L6;
        s1.c.b("cloudmessage", new String[]{"postFile: commandId=" + r10, "postFile=" + r11.getAbsolutePath(), ", uploadMessage=" + r13, ", fileType=" + r12});
    L6:
        return ea.a.e(r11, 1, r12, r10, r13, System.currentTimeMillis(), null);
    }

    public static void c(String r10, w9.a r11) {
        a(r11.b(), r10, 0, null);
    }

    public static void d(String r10, w9.a r11, Map r12) {
        a(r11.b(), r10, 0, r12);
    }

    public static void e(String r10) {
        a(r10, "上传成功", 2, null);
    }
}
