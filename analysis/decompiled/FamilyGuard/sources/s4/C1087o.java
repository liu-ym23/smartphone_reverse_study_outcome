package s4;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: s4.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1087o extends C1096y {

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f20365c = AtomicIntegerFieldUpdater.newUpdater(C1087o.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public C1087o(Z3.e<?> eVar, Throwable th, boolean z5) {
        if (th == null) {
            th = new CancellationException("Continuation " + eVar + " was cancelled normally");
        }
        super(th, z5);
        this._resumed$volatile = 0;
    }

    public final boolean e() {
        return f20365c.compareAndSet(this, 0, 1);
    }
}
