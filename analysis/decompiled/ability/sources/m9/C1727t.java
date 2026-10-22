package m9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: m9.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1727t {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C1727t.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f5333a;

    public C1727t(Throwable th, boolean z10) {
        this.f5333a = th;
        this._handled$volatile = z10 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f5333a + ']';
    }
}
