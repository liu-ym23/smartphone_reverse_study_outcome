package com.android.server.permission.jarjar.kotlin.io;

import com.android.server.permission.jarjar.kotlin.ExceptionsKt;
import java.io.Closeable;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CloseableKt {
    public static final void closeFinally(Closeable $this$closeFinally, Throwable cause) {
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
