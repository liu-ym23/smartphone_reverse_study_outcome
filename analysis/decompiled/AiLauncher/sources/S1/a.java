package S1;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2) {
    }

    public static void b(Throwable th) {
        if (!N1.a.f4787a || th == null) {
            return;
        }
        a("ERROR", e(th));
    }

    public static void c(String str, String str2) {
    }

    public static void d(String str, Throwable th) {
        c(str, e(th));
    }

    public static String e(Throwable th) {
        if (th == null) {
            return "exception in null";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return cause.getMessage();
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
