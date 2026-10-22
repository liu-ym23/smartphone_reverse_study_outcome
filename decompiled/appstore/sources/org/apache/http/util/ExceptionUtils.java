package org.apache.http.util;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class ExceptionUtils {
    private static final Method INIT_CAUSE_METHOD = null;

    static {
        INIT_CAUSE_METHOD = getInitCauseMethod();
    }

    private ExceptionUtils() {
    }

    private static Method getInitCauseMethod() {
        return Throwable.class.getMethod("initCause", new Class[]{Throwable.class});
    L5:
        return null;
    }

    public static void initCause(Throwable r10, Throwable r11) {
        Method r12 = INIT_CAUSE_METHOD;
        if (r12 == null) goto L9;
        r12.invoke(r10, new Object[]{r11});     // Catch: Exception -> L6
        return;
    L10:
        return;
    }
}
