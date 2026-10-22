package com.stepos.core.common.cloud;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.q;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudSseEventLog {
    public static final CloudSseEventLog INSTANCE = new CloudSseEventLog();

    private CloudSseEventLog() {
    }

    public final void logError(String tag, String logPrefix, String type, String message) {
        kotlin.jvm.internal.g.f(tag, "tag");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        kotlin.jvm.internal.g.f(type, "type");
        kotlin.jvm.internal.g.f(message, "message");
        AIEngineLogger.e(LogModule.ABILITY, tag, logPrefix + " [DIAG] sse-event type=" + type + " message=" + message);
    }

    public final void logEvent(String tag, String logPrefix, String type, String detail) {
        kotlin.jvm.internal.g.f(tag, "tag");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        kotlin.jvm.internal.g.f(type, "type");
        kotlin.jvm.internal.g.f(detail, "detail");
        AIEngineLogger.i(LogModule.ABILITY, tag, logPrefix + " [DIAG] sse-event type=" + type + " " + detail);
    }

    public final void logUnknown(String tag, String logPrefix, String type, int i10) {
        kotlin.jvm.internal.g.f(tag, "tag");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        kotlin.jvm.internal.g.f(type, "type");
        LogModule logModule = LogModule.ABILITY;
        if (q.t0(type)) {
            type = "<absent>";
        }
        AIEngineLogger.w(logModule, tag, logPrefix + " [DIAG] sse-event type=" + ((Object) type) + " unhandled rawLen=" + i10);
    }

    public final String redactText(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        return a0.a.g("len=", text.length(), ",hash=", String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(text.hashCode())}, 1)));
    }
}
