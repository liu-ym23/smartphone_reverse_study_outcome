package x4;

import java.util.Collection;
import java.util.ServiceLoader;
import s4.InterfaceC1057F;

/* renamed from: x4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1307g {

    /* renamed from: a, reason: collision with root package name */
    private static final Collection<InterfaceC1057F> f23854a = q4.e.g(q4.e.c(ServiceLoader.load(InterfaceC1057F.class, InterfaceC1057F.class.getClassLoader()).iterator()));

    public static final Collection<InterfaceC1057F> a() {
        return f23854a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
