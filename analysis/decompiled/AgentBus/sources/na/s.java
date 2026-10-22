package na;

import ia.t1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public abstract class s extends c implements t1 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6926d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f6927c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public s(long j2, s sVar, int i2) {
        super(sVar);
        this.f6927c = j2;
        this.cleanedAndPointers$volatile = i2 << 16;
    }

    @Override // na.c
    public final boolean d() {
        return f6926d.get(this) == g() && c() != null;
    }

    public final boolean f() {
        return f6926d.addAndGet(this, -65536) == g() && c() != null;
    }

    public abstract int g();

    public abstract void h(int i2, g7.l lVar);

    public final void i() {
        if (f6926d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f6926d;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 == g() && c() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
