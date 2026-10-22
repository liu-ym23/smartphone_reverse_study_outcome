package Z2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* renamed from: Z2.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0135k0 extends q0 {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2225f = AtomicIntegerFieldUpdater.newUpdater(C0135k0.class, "_invoked");

    @Volatile
    private volatile int _invoked;

    /* renamed from: e, reason: collision with root package name */
    public final Function1 f2226e;

    public C0135k0(Function1 function1) {
        this.f2226e = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        j((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // Z2.s0
    public final void j(Throwable th) {
        if (f2225f.compareAndSet(this, 0, 1)) {
            this.f2226e.invoke(th);
        }
    }
}
