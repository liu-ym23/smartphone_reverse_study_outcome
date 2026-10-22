package fg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.text.StringsKt__StringsKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {
    public static final Sink a(File r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return h(new FileOutputStream(r10, true));
    }

    public static final Sink b() {
        return new d();
    }

    public static final BufferedSink c(Sink r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return new n(r10);
    }

    public static final BufferedSource d(Source r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return new o(r10);
    }

    public static final boolean e(AssertionError r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        if (r10.getCause() == null) goto L11;
        String r11 = r10.getMessage();
        if (r11 == null) goto L7;
        boolean r12 = StringsKt__StringsKt.E(r11, "getsockname failed", false, 2, null);
    L8:
        if (r12 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r12 = false;
        goto L8
    L11:
        return false;
    }

    public static final Sink f(File r10) {
        return j(r10, false, 1, null);
    }

    public static final Sink g(File r10, boolean r11) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return h(new FileOutputStream(r10, r11));
    }

    public static final Sink h(OutputStream r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return new l(r10, new Timeout());
    }

    public static final Sink i(Socket r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        r r11 = new r(r10);
        OutputStream r12 = r10.getOutputStream();
        kotlin.jvm.internal.q.c(r12, "getOutputStream()");
        return r11.sink(new l(r12, r11));
    }

    public static /* bridge */ /* synthetic */ Sink j(File r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return g(r10, r11);
    }

    public static final Source k(File r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return l(new FileInputStream(r10));
    }

    public static final Source l(InputStream r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        return new i(r10, new Timeout());
    }

    public static final Source m(Socket r10) {
        kotlin.jvm.internal.q.h(r10, "$receiver");
        r r11 = new r(r10);
        InputStream r12 = r10.getInputStream();
        kotlin.jvm.internal.q.c(r12, "getInputStream()");
        return r11.source(new i(r12, r11));
    }
}
