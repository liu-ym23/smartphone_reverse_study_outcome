package m9;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: m9.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1719l extends C1727t {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C1719l.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public C1719l(C1718k c1718k, Throwable th, boolean z10) {
        if (th == null) {
            th = new CancellationException("Continuation " + c1718k + " was cancelled normally");
        }
        super(th, z10);
        this._resumed$volatile = 0;
    }
}
