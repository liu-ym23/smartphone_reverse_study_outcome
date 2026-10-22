package d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
class b {
    public static final String a(Throwable r4) {
        d.h.b.o.e(r4, "<this>");
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter((Writer) ZeusTransformUtils.preCheckCast(r0, Writer.class, "com.obric.aiagent.plugin"));
        r4.printStackTrace(r1);
        r1.flush();
        String r5 = r0.toString();
        d.h.b.o.c(r5, "toString(...)");
        return r5;
    }

    public static final void a(Throwable r1, Throwable r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "exception");
        if (r1 == r2) goto L6;
        d.e.b.f38433a.a(r1, r2);
        return;
    }
}
