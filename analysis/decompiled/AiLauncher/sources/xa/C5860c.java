package xa;

import Y8.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* renamed from: xa.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5860c extends C5861d {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f43602c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5074l<InterruptedException, t> f43603d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C5860c(Lock lock, Runnable checkCancelled, InterfaceC5074l<? super InterruptedException, t> interruptedExceptionHandler) {
        super(lock);
        p.i(lock, "lock");
        p.i(checkCancelled, "checkCancelled");
        p.i(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.f43602c = checkCancelled;
        this.f43603d = interruptedExceptionHandler;
    }

    @Override // xa.C5861d, kotlin.reflect.jvm.internal.impl.storage.a
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f43602c.run();
            } catch (InterruptedException e10) {
                this.f43603d.invoke(e10);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5860c(Runnable checkCancelled, InterfaceC5074l<? super InterruptedException, t> interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        p.i(checkCancelled, "checkCancelled");
        p.i(interruptedExceptionHandler, "interruptedExceptionHandler");
    }
}
