package okhttp3.internal.i.a;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {
    public static final /* synthetic */ int a(LogRecord r0) {
        return b(r0);
    }

    private static final int b(LogRecord r2) {
        if (r2.getLevel().intValue() <= Level.INFO.intValue()) goto L6;
        return 5;
    L6:
        if (r2.getLevel().intValue() != Level.INFO.intValue()) goto L8;
        return 4;
    L8:
        return 3;
    }
}
