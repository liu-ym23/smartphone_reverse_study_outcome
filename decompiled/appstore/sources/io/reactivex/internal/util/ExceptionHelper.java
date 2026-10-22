package io.reactivex.internal.util;

import androidx.lifecycle.p;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f20726a = null;

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        f20726a = new Termination();
    }

    public static boolean a(AtomicReference r10, Throwable r11) {
    L2:
        Throwable r12 = (Throwable) r10.get();
        if (r12 == f20726a) goto L4;
        if (r12 != null) goto L8;
        Throwable r13 = r11;
    L10:
        if (p.a(r10, r12, r13) == false) goto L2;
        return true;
    L8:
        r13 = new CompositeException(new Throwable[]{r12, r11});
        goto L10
    L4:
        return false;
    }

    public static Throwable b(AtomicReference r10) {
        Throwable r11 = (Throwable) r10.get();
        Throwable r12 = f20726a;
        if (r11 != r12) goto L5;
        return r11;
    L5:
        return (Throwable) r10.getAndSet(r12);
    }

    public static String c(long r10, TimeUnit r11) {
        return "The source did not signal an event for " + r10 + " " + r11.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException d(Throwable r10) {
        if ((r10 instanceof Error) == true) goto L11;
        if ((r10 instanceof RuntimeException) == false) goto L9;
        return (RuntimeException) r10;
    L9:
        return new RuntimeException(r10);
    L11:
        throw ((Error) r10);
    }
}
