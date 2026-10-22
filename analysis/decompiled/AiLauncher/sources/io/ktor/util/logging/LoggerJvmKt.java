package io.ktor.util.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import vc.c;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u0019\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004*\n\u0010\u0006\"\u00020\u00002\u00020\u0000¨\u0006\u0007"}, d2 = {"Lvc/c;", "Lio/ktor/util/logging/Logger;", "", "isTraceEnabled", "(Lvc/c;)Z", "isDebugEnabled", "Logger", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoggerJvmKt {
    public static final boolean isDebugEnabled(c cVar) {
        p.i(cVar, "<this>");
        return cVar.isDebugEnabled();
    }

    public static final boolean isTraceEnabled(c cVar) {
        p.i(cVar, "<this>");
        return cVar.isTraceEnabled();
    }
}
