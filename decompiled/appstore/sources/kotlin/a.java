package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static void a(Throwable r10, Throwable r11) {
        q.g(r10, "<this>");
        q.g(r11, "exception");
        if (r10 == r11) goto L6;
        uf.b.f24937a.a(r10, r11);
        return;
    }

    public static String b(Throwable r10) {
        q.g(r10, "<this>");
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        r10.printStackTrace(r12);
        r12.flush();
        String r13 = r11.toString();
        q.f(r13, "toString(...)");
        return r13;
    }
}
