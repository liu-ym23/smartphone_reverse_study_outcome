package com.fasterxml.jackson.databind.util;

import ad.o;
import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    private static boolean isFatal(Throwable th) {
        return (th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof InterruptedException) || (th instanceof ClassCircularityError) || (th instanceof ClassFormatError) || (th instanceof IncompatibleClassChangeError) || (th instanceof BootstrapMethodError) || (th instanceof VerifyError);
    }

    public static void rethrowIfFatal(Throwable th) {
        if (isFatal(th)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            o.h(th);
        }
    }

    public static <T> T throwSneaky(IOException iOException) throws Throwable {
        _sneaky(iOException);
        return null;
    }

    private static <E extends Throwable> void _sneaky(Throwable th) throws Throwable {
        throw th;
    }
}
