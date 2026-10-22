package okhttp3.internal.i.a;

import d.h.b.o;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f40101a = null;

    static {
        f40101a = new d();
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    private d() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord r5) {
        o.e(r5, "record");
        c r4 = c.f40098a;
        String r0 = r5.getLoggerName();
        o.c(r0, "record.loggerName");
        int r1 = e.a(r5);
        String r2 = r5.getMessage();
        o.c(r2, "record.message");
        r4.a(r0, r1, r2, r5.getThrown());
    }
}
