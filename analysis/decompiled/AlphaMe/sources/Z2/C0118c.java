package Z2;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: Z2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0118c extends AbstractC0114a {

    /* renamed from: d, reason: collision with root package name */
    public final Thread f2208d;

    /* renamed from: e, reason: collision with root package name */
    public final V f2209e;

    public C0118c(CoroutineContext coroutineContext, Thread thread, V v4) {
        super(coroutineContext, true);
        this.f2208d = thread;
        this.f2209e = v4;
    }

    @Override // Z2.x0
    public final void s(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f2208d;
        if (Intrinsics.areEqual(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
