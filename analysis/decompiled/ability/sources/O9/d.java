package O9;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes4.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1047a = new d();

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }

    @Override // java.util.logging.Handler
    public final void publish(LogRecord record) {
        int iMin;
        kotlin.jvm.internal.k.f(record, "record");
        CopyOnWriteArraySet copyOnWriteArraySet = c.f1046a;
        String loggerName = record.getLoggerName();
        kotlin.jvm.internal.k.e(loggerName, "record.loggerName");
        int iIntValue = record.getLevel().intValue();
        Level level = Level.INFO;
        int i = iIntValue > level.intValue() ? 5 : record.getLevel().intValue() == level.intValue() ? 4 : 3;
        String message = record.getMessage();
        kotlin.jvm.internal.k.e(message, "record.message");
        Throwable thrown = record.getThrown();
        String strN0 = (String) c.b.get(loggerName);
        if (strN0 == null) {
            strN0 = j9.m.N0(23, loggerName);
        }
        if (Log.isLoggable(strN0, i)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i6 = 0;
            while (i6 < length) {
                int iP0 = j9.m.p0(message, '\n', i6, 4);
                if (iP0 == -1) {
                    iP0 = length;
                }
                while (true) {
                    iMin = Math.min(iP0, i6 + 4000);
                    String strSubstring = message.substring(i6, iMin);
                    kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i, strN0, strSubstring);
                    if (iMin >= iP0) {
                        break;
                    } else {
                        i6 = iMin;
                    }
                }
                i6 = iMin + 1;
            }
        }
    }
}
