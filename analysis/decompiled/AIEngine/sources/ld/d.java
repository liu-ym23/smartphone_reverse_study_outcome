package ld;

import android.util.Log;
import gc.q;
import gc.r;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final d f10421a = new d();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord record) {
        int iMin;
        kotlin.jvm.internal.g.f(record, "record");
        CopyOnWriteArraySet<Logger> copyOnWriteArraySet = c.f10419a;
        String loggerName = record.getLoggerName();
        kotlin.jvm.internal.g.e(loggerName, "getLoggerName(...)");
        int iIntValue = record.getLevel().intValue();
        Level level = Level.INFO;
        int i10 = iIntValue > level.intValue() ? 5 : record.getLevel().intValue() == level.intValue() ? 4 : 3;
        String message = record.getMessage();
        kotlin.jvm.internal.g.e(message, "getMessage(...)");
        Throwable thrown = record.getThrown();
        String strR0 = c.f10420b.get(loggerName);
        if (strR0 == null) {
            strR0 = r.R0(23, loggerName);
        }
        if (Log.isLoggable(strR0, i10)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i11 = 0;
            while (i11 < length) {
                int iQ0 = q.q0(message, '\n', i11, 4);
                if (iQ0 == -1) {
                    iQ0 = length;
                }
                while (true) {
                    iMin = Math.min(iQ0, i11 + 4000);
                    String strSubstring = message.substring(i11, iMin);
                    kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                    Log.println(i10, strR0, strSubstring);
                    if (iMin >= iQ0) {
                        break;
                    } else {
                        i11 = iMin;
                    }
                }
                i11 = iMin + 1;
            }
        }
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}
