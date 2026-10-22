package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ab {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f38829b = null;
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f38830a;

    static {
        f38829b = AtomicIntegerFieldUpdater.newUpdater(ab.class, "_handled$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater a() {
        return f38829b;
    }

    public ab(Throwable r1, boolean r2) {
        this.f38830a = r1;
        this._handled$volatile = r2 ? 1 : 0;
    }

    public /* synthetic */ ab(Throwable r1, boolean r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public final boolean b() {
        if (a().get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        return a().compareAndSet(this, 0, 1);
    }

    public String toString() {
        return ar.b(this) + '[' + this.f38830a + ']';
    }
}
