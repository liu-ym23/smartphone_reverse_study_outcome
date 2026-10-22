package com.android.server.permission.jarjar.kotlin;

import com.android.server.permission.jarjar.kotlin.internal.PlatformImplementationsKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
class ExceptionsKt__ExceptionsKt {
    public static void addSuppressed(Throwable $this$addSuppressed, Throwable exception) {
        Intrinsics.checkNotNullParameter($this$addSuppressed, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ($this$addSuppressed == exception) goto L6;
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed($this$addSuppressed, exception);
        return;
    }
}
