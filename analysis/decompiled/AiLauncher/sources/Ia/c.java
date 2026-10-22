package Ia;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class c {
    public static final boolean a(Throwable th) {
        p.i(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!p.d(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable e10) throws Throwable {
        p.i(e10, "e");
        throw e10;
    }
}
