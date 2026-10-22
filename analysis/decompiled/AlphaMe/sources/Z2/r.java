package Z2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;

/* loaded from: classes2.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2237b = AtomicIntegerFieldUpdater.newUpdater(r.class, "_handled");

    @Volatile
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f2238a;

    public r(Throwable th, boolean z4) {
        this.f2238a = th;
        this._handled = z4 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f2238a + ']';
    }
}
