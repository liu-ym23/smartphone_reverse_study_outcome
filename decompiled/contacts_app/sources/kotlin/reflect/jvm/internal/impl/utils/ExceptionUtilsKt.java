package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: exceptionUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionUtilsKt {
    public static final RuntimeException rethrow(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "e");
        throw r1;
    }

    public static final boolean isProcessCanceledException(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Class<?> r3 = r2.getClass();
    L4:
        if (Intrinsics.areEqual(r3.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException") == true) goto L5;
        r3 = r3.getSuperclass();
        if (r3 != null) goto L4;
        return false;
    L5:
        return true;
    }
}
