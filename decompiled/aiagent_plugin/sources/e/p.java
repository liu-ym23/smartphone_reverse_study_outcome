package e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f38741a = null;

    public static final /* synthetic */ Logger a() {
        return f38741a;
    }

    public static final y a(OutputStream r2) {
        d.h.b.o.e(r2, "<this>");
        return (y) ZeusTransformUtils.preCheckCast(new s(r2, new ab()), y.class, "com.obric.aiagent.plugin");
    }

    public static final aa a(InputStream r2) {
        d.h.b.o.e(r2, "<this>");
        return (aa) ZeusTransformUtils.preCheckCast(new n(r2, new ab()), aa.class, "com.obric.aiagent.plugin");
    }

    public static final y a(Socket r4) {
        d.h.b.o.e(r4, "<this>");
        z r0 = new z(r4);
        OutputStream r5 = r4.getOutputStream();
        d.h.b.o.c(r5, "getOutputStream(...)");
        return r0.a((y) ZeusTransformUtils.preCheckCast(new s(r5, (ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin"));
    }

    public static final aa b(Socket r4) {
        d.h.b.o.e(r4, "<this>");
        z r0 = new z(r4);
        InputStream r5 = r4.getInputStream();
        d.h.b.o.c(r5, "getInputStream(...)");
        return r0.a((aa) ZeusTransformUtils.preCheckCast(new n(r5, (ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin"));
    }

    static {
        f38741a = Logger.getLogger("okio.Okio");
    }

    public static final y a(File r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        return o.a((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1, r2), OutputStream.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ y a(File r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return o.a(r0, r1);
    }

    public static final y a(File r2) {
        d.h.b.o.e(r2, "<this>");
        return o.a((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2, true), OutputStream.class, "com.obric.aiagent.plugin"));
    }

    public static final aa b(File r3) {
        d.h.b.o.e(r3, "<this>");
        return (aa) ZeusTransformUtils.preCheckCast(new n((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.aiagent.plugin"), ab.f38700d), aa.class, "com.obric.aiagent.plugin");
    }

    public static final boolean a(AssertionError r4) {
        d.h.b.o.e(r4, "<this>");
        if (r4.getCause() == null) goto L11;
        String r5 = r4.getMessage();
        if (r5 == null) goto L7;
        boolean r6 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("getsockname failed", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
    L8:
        if (r6 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r6 = false;
        goto L8
    L11:
        return false;
    }
}
