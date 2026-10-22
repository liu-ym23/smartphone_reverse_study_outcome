package io.ktor.util.logging;

import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import vc.c;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001d\u0010\u0005\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\n\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\f\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lvc/c;", "Lio/ktor/util/logging/Logger;", "", "exception", "LY8/t;", "error", "(Lvc/c;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "", "message", "trace", "(Lvc/c;Lp9/a;)V", Parameters.DEBUG, "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoggerKt {
    public static final void debug(c cVar, InterfaceC5063a<String> message) {
        p.i(cVar, "<this>");
        p.i(message, "message");
        if (LoggerJvmKt.isDebugEnabled(cVar)) {
            cVar.debug(message.invoke());
        }
    }

    public static final void error(c cVar, Throwable exception) {
        p.i(cVar, "<this>");
        p.i(exception, "exception");
        String message = exception.getMessage();
        if (message == null) {
            message = "Exception of type " + t.b(exception.getClass());
        }
        cVar.error(message, exception);
    }

    public static final void trace(c cVar, InterfaceC5063a<String> message) {
        p.i(cVar, "<this>");
        p.i(message, "message");
        if (LoggerJvmKt.isTraceEnabled(cVar)) {
            cVar.trace(message.invoke());
        }
    }
}
