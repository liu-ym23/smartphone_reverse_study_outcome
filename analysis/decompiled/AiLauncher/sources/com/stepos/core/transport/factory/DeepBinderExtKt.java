package com.stepos.core.transport.factory;

import com.stepos.deepbinder.core.exception.IPCException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0000¨\u0006\u0007"}, d2 = {"ipcErrorCode", "", "", "(Ljava/lang/Throwable;)Ljava/lang/Integer;", "isDeadProxy", "", "isMethodNotFound", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderExtKt {
    public static final Integer ipcErrorCode(Throwable th) {
        p.i(th, "<this>");
        IPCException iPCException = th instanceof IPCException ? (IPCException) th : null;
        if (iPCException == null) {
            Throwable cause = th.getCause();
            iPCException = cause instanceof IPCException ? (IPCException) cause : null;
        }
        if (iPCException != null) {
            return Integer.valueOf(iPCException.getErrorCode());
        }
        return null;
    }

    public static final boolean isDeadProxy(Throwable th) {
        p.i(th, "<this>");
        Integer numIpcErrorCode = ipcErrorCode(th);
        return numIpcErrorCode != null && numIpcErrorCode.intValue() == 22;
    }

    public static final boolean isMethodNotFound(Throwable th) {
        p.i(th, "<this>");
        Integer numIpcErrorCode = ipcErrorCode(th);
        return numIpcErrorCode != null && numIpcErrorCode.intValue() == 12;
    }
}
