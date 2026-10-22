package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "cause", "LY8/t;", "initCauseBridge", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExceptionUtilsJvmKt {
    public static final void initCauseBridge(Throwable th, Throwable cause) {
        p.i(th, "<this>");
        p.i(cause, "cause");
        th.initCause(cause);
    }
}
