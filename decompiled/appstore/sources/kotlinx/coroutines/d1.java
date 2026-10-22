package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 extends f1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21371f = null;

    @Volatile
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1 f21372e;

    static {
        f21371f = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked");
    }

    public d1(Function1 r10) {
        this.f21372e = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        if (f21371f.compareAndSet(this, 0, 1) == false) goto L6;
        this.f21372e.invoke(r10);
        return;
    }
}
