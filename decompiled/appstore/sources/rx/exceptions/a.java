package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.Observer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static void a(Throwable r10, Throwable r11) {
        HashSet r12 = new HashSet();
        int r13 = 0;
    L4:
        if (r10.getCause() == null) goto L15;
        int r14 = r13 + 1;
        if (r13 >= 25) goto L7;
        r10 = r10.getCause();
        if (r12.contains(r10.getCause()) == true) goto L15;
        r12.add(r10.getCause());
        r13 = r14;
        goto L4
    L7:
        return;
    L15:
        r10.initCause(r11);     // Catch: Throwable -> L14
        return;
    }

    public static Throwable b(Throwable r10) {
        int r11 = 0;
    L4:
        if (r10.getCause() == null) goto L10;
        int r12 = r11 + 1;
        if (r11 >= 25) goto L8;
        r10 = r10.getCause();
        r11 = r12;
        goto L4
    L8:
        return new RuntimeException("Stack too deep to get final cause");
    L10:
        return r10;
    }

    public static RuntimeException c(Throwable r10) {
        if ((r10 instanceof RuntimeException) == true) goto L11;
        if ((r10 instanceof Error) == false) goto L9;
        throw ((Error) r10);
    L9:
        throw new RuntimeException(r10);
    L11:
        throw ((RuntimeException) r10);
    }

    public static void d(List r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() != 1) goto L18;
        Throwable r11 = (Throwable) r10.get(0);
        if ((r11 instanceof RuntimeException) == true) goto L16;
        if ((r11 instanceof Error) == false) goto L14;
        throw ((Error) r11);
    L14:
        throw new RuntimeException(r11);
    L16:
        throw ((RuntimeException) r11);
    L18:
        throw new CompositeException(r10);
    }

    public static void e(Throwable r10) {
        if ((r10 instanceof OnErrorNotImplementedException) == true) goto L26;
        if ((r10 instanceof OnErrorFailedException) == true) goto L24;
        if ((r10 instanceof OnCompletedFailedException) == true) goto L22;
        if ((r10 instanceof VirtualMachineError) == true) goto L20;
        if ((r10 instanceof ThreadDeath) == true) goto L18;
        if ((r10 instanceof LinkageError) == true) goto L16;
        return;
    L16:
        throw ((LinkageError) r10);
    L18:
        throw ((ThreadDeath) r10);
    L20:
        throw ((VirtualMachineError) r10);
    L22:
        throw ((OnCompletedFailedException) r10);
    L24:
        throw ((OnErrorFailedException) r10);
    L26:
        throw ((OnErrorNotImplementedException) r10);
    }

    public static void f(Throwable r10, Observer r11) {
        e(r10);
        r11.onError(r10);
    }

    public static void g(Throwable r10, Observer r11, Object r12) {
        e(r10);
        r11.onError(OnErrorThrowable.addValueAsLastCause(r10, r12));
    }
}
