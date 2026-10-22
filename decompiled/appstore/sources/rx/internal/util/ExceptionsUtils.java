package rx.internal.util;

import androidx.lifecycle.p;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

/* JADX INFO: loaded from: classes4.dex */
public final enum ExceptionsUtils extends Enum<ExceptionsUtils> {
    private static final /* synthetic */ ExceptionsUtils[] $VALUES = null;
    private static final Throwable TERMINATED = null;

    static {
        $VALUES = new ExceptionsUtils[0];
        TERMINATED = new Throwable("Terminated");
    }

    private ExceptionsUtils(String r10, int r11) {
        super(r10, r11);
    }

    public static boolean addThrowable(AtomicReference<Throwable> r10, Throwable r11) {
    L2:
        Throwable r12 = r10.get();
        if (r12 == TERMINATED) goto L4;
        if (r12 != null) goto L9;
        Throwable r13 = r11;
    L13:
        if (p.a(r10, r12, r13) == false) goto L2;
        return true;
    L9:
        if ((r12 instanceof CompositeException) == false) goto L11;
        ArrayList r14 = new ArrayList(((CompositeException) r12).getExceptions());
        r14.add(r11);
        r13 = new CompositeException(r14);
        goto L13
    L11:
        r13 = new CompositeException(new Throwable[]{r12, r11});
        goto L13
    L4:
        return false;
    }

    public static boolean isTerminated(AtomicReference<Throwable> r10) {
        return isTerminated(r10.get());
    }

    public static Throwable terminate(AtomicReference<Throwable> r10) {
        Throwable r11 = r10.get();
        Throwable r12 = TERMINATED;
        if (r11 != r12) goto L5;
        return r11;
    L5:
        return r10.getAndSet(r12);
    }

    public static ExceptionsUtils valueOf(String r10) {
        return (ExceptionsUtils) Enum.valueOf(ExceptionsUtils.class, r10);
    }

    public static ExceptionsUtils[] values() {
        return (ExceptionsUtils[]) $VALUES.clone();
    }

    public static boolean isTerminated(Throwable r10) {
        if (r10 != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }
}
