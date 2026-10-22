package x4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s4.A0;
import x4.AbstractC1291C;

/* renamed from: x4.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1291C<S extends AbstractC1291C<S>> extends AbstractC1304d<S> implements A0 {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f23828d = AtomicIntegerFieldUpdater.newUpdater(AbstractC1291C.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f23829c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public AbstractC1291C(long j5, S s5, int i5) {
        super(s5);
        this.f23829c = j5;
        this.cleanedAndPointers$volatile = i5 << 16;
    }

    @Override // x4.AbstractC1304d
    public boolean k() {
        return f23828d.get(this) == r() && !l();
    }

    public final boolean p() {
        return f23828d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i5, Throwable th, Z3.i iVar);

    public final void t() {
        if (f23828d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f23828d;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 65536 + i5));
        return true;
    }
}
