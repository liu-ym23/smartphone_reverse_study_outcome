package com.android.server.permission.jarjar.kotlin.jdk7;

import com.android.server.permission.jarjar.kotlin.ExceptionsKt;

/* JADX INFO: compiled from: AutoCloseableJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoCloseableKt {
    public static final void closeFinally(AutoCloseable $this$closeFinally, Throwable cause) {
        if ($this$closeFinally == null) goto L13;
        if (cause != null) goto L11;
        $this$closeFinally.close();
        return;
    L11:
        $this$closeFinally.close();     // Catch: Throwable -> L8
        return;
    L8:
        closeException = move-exception;
        ExceptionsKt.addSuppressed(cause, closeException);
        return;
    }
}
