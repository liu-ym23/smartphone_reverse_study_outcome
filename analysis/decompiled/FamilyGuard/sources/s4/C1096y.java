package s4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: s4.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1096y {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f20397b = AtomicIntegerFieldUpdater.newUpdater(C1096y.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f20398a;

    public C1096y(Throwable th, boolean z5) {
        this.f20398a = th;
        this._handled$volatile = z5 ? 1 : 0;
    }

    public final boolean a() {
        return f20397b.get(this) != 0;
    }

    public final boolean c() {
        return f20397b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return M.a(this) + '[' + this.f20398a + ']';
    }

    public /* synthetic */ C1096y(Throwable th, boolean z5, int i5, j4.g gVar) {
        this(th, (i5 & 2) != 0 ? false : z5);
    }
}
