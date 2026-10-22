package Z2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;

/* renamed from: Z2.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0130i extends r {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2222c = AtomicIntegerFieldUpdater.newUpdater(C0130i.class, "_resumed");

    @Volatile
    private volatile int _resumed;

    public C0130i(Continuation continuation, Throwable th, boolean z4) {
        if (th == null) {
            th = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        super(th, z4);
        this._resumed = 0;
    }
}
