package Y8;

import com.autonavi.aps.amapapi.config.Const;
import i9.C4179b;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Throwable;)Ljava/lang/String;", "exception", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
/* loaded from: classes4.dex */
public class d {
    public static void a(Throwable th, Throwable exception) {
        kotlin.jvm.internal.p.i(th, "<this>");
        kotlin.jvm.internal.p.i(exception, "exception");
        if (th != exception) {
            C4179b.f33080a.a(th, exception);
        }
    }

    public static String b(Throwable th) {
        kotlin.jvm.internal.p.i(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }
}
