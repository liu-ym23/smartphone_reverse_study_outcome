package d3;

import Z2.B0;
import com.alibaba.fastjson.util.UTF8Decoder;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;

/* loaded from: classes2.dex */
public abstract class v extends e implements B0 {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12480d = AtomicIntegerFieldUpdater.newUpdater(v.class, "cleanedAndPointers");

    /* renamed from: c, reason: collision with root package name */
    public final long f12481c;

    @Volatile
    private volatile int cleanedAndPointers;

    public v(long j4, v vVar, int i4) {
        super(vVar);
        this.f12481c = j4;
        this.cleanedAndPointers = i4 << 16;
    }

    @Override // d3.e
    public final boolean c() {
        return f12480d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f12480d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i4, CoroutineContext coroutineContext);

    public final void h() {
        if (f12480d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i4;
        do {
            atomicIntegerFieldUpdater = f12480d;
            i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, UTF8Decoder.Surrogate.UCS4_MIN + i4));
        return true;
    }
}
