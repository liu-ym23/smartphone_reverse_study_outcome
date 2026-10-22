package io.ktor.util.pipeline;

import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "exception", "Le9/c;", "continuation", "recoverStackTraceBridge", "(Ljava/lang/Throwable;Le9/c;)Ljava/lang/Throwable;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StackTraceRecoverKt {
    public static final Throwable recoverStackTraceBridge(Throwable exception, InterfaceC4014c<?> continuation) {
        p.i(exception, "exception");
        p.i(continuation, "continuation");
        try {
            return StackTraceRecoverJvmKt.withCause(exception, exception.getCause());
        } catch (Throwable unused) {
            return exception;
        }
    }
}
