package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t {
    public static final d.n.j<String> a(BufferedReader r2) {
        d.h.b.o.e(r2, "<this>");
        return d.n.m.a((d.n.j) ZeusTransformUtils.preCheckCast(new p(r2), d.n.j.class, "com.obric.aiagent.plugin"));
    }

    public static final String a(Reader r5) {
        d.h.b.o.e(r5, "<this>");
        StringWriter r0 = new StringWriter();
        a(r5, (Writer) ZeusTransformUtils.preCheckCast(r0, Writer.class, "com.obric.aiagent.plugin"), 0, 2, null);
        String r6 = r0.toString();
        d.h.b.o.c(r6, "toString(...)");
        return r6;
    }

    public static /* synthetic */ long a(Reader r0, Writer r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 8192;
    L6:
        return a(r0, r1, r2);
    }

    public static final long a(Reader r5, Writer r6, int r7) {
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "out");
        char[] r8 = new char[r7];
        int r0 = r5.read(r8);
        long r1 = 0;
    L3:
        if (r0 < 0) goto L5;
        r6.write(r8, 0, r0);
        r1 = r1 + ((long) r0);
        r0 = r5.read(r8);
        goto L3
    L5:
        return r1;
    }

    public static final void a(Reader r3, d.h.a.b<? super String, x> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r5, "action");
        if (ZeusTransformUtils.instanceOf(r3, BufferedReader.class) == false) goto L5;
        BufferedReader r6 = (BufferedReader) ZeusTransformUtils.preCheckCast(r3, BufferedReader.class, "com.obric.aiagent.plugin");
    L6:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.aiagent.plugin");
        Iterator<String> r1 = a((BufferedReader) ZeusTransformUtils.preCheckCast(r7, BufferedReader.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        r5.invoke(r1.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        x r8 = x.f38692a;     // Catch: Throwable -> L14
        c.a(r7, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        c.a(r7, th);
        throw th;
    L5:
        r6 = new BufferedReader(r3, 8192);
        goto L6
    }
}
