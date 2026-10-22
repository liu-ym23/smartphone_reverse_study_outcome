package jb;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final d f5430a = new d();

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int iMin;
        q7.k.e(logRecord, "record");
        CopyOnWriteArraySet copyOnWriteArraySet = c.f5428a;
        String loggerName = logRecord.getLoggerName();
        q7.k.d(loggerName, "record.loggerName");
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        int i2 = iIntValue > level.intValue() ? 5 : logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
        String message = logRecord.getMessage();
        q7.k.d(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        String strL0 = (String) c.f5429b.get(loggerName);
        if (strL0 == null) {
            strL0 = ga.k.L0(23, loggerName);
        }
        if (Log.isLoggable(strL0, i2)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i10 = 0;
            while (i10 < length) {
                int iQ0 = ga.k.q0(message, '\n', i10, 4);
                if (iQ0 == -1) {
                    iQ0 = length;
                }
                while (true) {
                    iMin = Math.min(iQ0, i10 + 4000);
                    String strSubstring = message.substring(i10, iMin);
                    q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i2, strL0, strSubstring);
                    if (iMin >= iQ0) {
                        break;
                    } else {
                        i10 = iMin;
                    }
                }
                i10 = iMin + 1;
            }
        }
    }
}
