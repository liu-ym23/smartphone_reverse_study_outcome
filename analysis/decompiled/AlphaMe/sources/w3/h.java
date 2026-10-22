package w3;

import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class h extends RuntimeException {
    public static Throwable a(Object obj, Throwable th) {
        int i4 = 0;
        Throwable runtimeException = th;
        int i5 = 0;
        while (true) {
            if (runtimeException.getCause() == null) {
                break;
            }
            int i6 = i5 + 1;
            if (i5 >= 25) {
                runtimeException = new RuntimeException("Stack too deep to get final cause");
                break;
            }
            runtimeException = runtimeException.getCause();
            i5 = i6;
        }
        if ((runtimeException instanceof g) && ((g) runtimeException).f15867a == obj) {
            return th;
        }
        g gVar = new g(obj);
        HashSet hashSet = new HashSet();
        Throwable cause = th;
        while (true) {
            if (cause.getCause() == null) {
                cause.initCause(gVar);
                break;
            }
            int i7 = i4 + 1;
            if (i4 >= 25) {
                break;
            }
            cause = cause.getCause();
            if (!hashSet.contains(cause.getCause())) {
                hashSet.add(cause.getCause());
                i4 = i7;
            }
            try {
                cause.initCause(gVar);
                break;
            } catch (Throwable unused) {
            }
        }
        return th;
    }
}
