package kc;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends n {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7438c = AtomicIntegerFieldUpdater.newUpdater(h.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public h(g gVar, Throwable th, boolean z10) {
        if (th == null) {
            th = new CancellationException("Continuation " + gVar + " was cancelled normally");
        }
        super(th, z10);
        this._resumed$volatile = 0;
    }
}
