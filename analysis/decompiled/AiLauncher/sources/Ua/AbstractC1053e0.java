package Ua;

import Z8.C1165m;
import Za.C1192l;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010%\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u0011\u0010)\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b(\u0010\tR\u0011\u0010+\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b*\u0010\t¨\u0006,"}, d2 = {"LUa/e0;", "LUa/I;", "<init>", "()V", "", "D1", "()J", "", "E1", "()Z", "Lkotlinx/coroutines/f;", "task", "LY8/t;", "x1", "(Lkotlinx/coroutines/f;)V", "unconfined", "z1", "(Z)V", "u1", "", "parallelism", "", "name", "s1", "(ILjava/lang/String;)LUa/I;", "shutdown", "w1", "(Z)J", Const.INTENT_KEY_PKGNAME, "J", "useCount", "c", "Z", "shared", "LZ8/m;", Const.INTENT_KEY_UMID, "LZ8/m;", "unconfinedQueue", "y1", "nextTime", "B1", "isUnconfinedLoopActive", "C1", "isUnconfinedQueueEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.e0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1053e0 extends I {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long useCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean shared;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public C1165m<kotlinx.coroutines.f<?>> unconfinedQueue;

    public static /* synthetic */ void A1(AbstractC1053e0 abstractC1053e0, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        abstractC1053e0.z1(z10);
    }

    public static /* synthetic */ void v1(AbstractC1053e0 abstractC1053e0, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        abstractC1053e0.u1(z10);
    }

    public final boolean B1() {
        return this.useCount >= w1(true);
    }

    public final boolean C1() {
        C1165m<kotlinx.coroutines.f<?>> c1165m = this.unconfinedQueue;
        if (c1165m != null) {
            return c1165m.isEmpty();
        }
        return true;
    }

    public long D1() {
        return !E1() ? Long.MAX_VALUE : 0L;
    }

    public final boolean E1() {
        kotlinx.coroutines.f<?> fVarV;
        C1165m<kotlinx.coroutines.f<?>> c1165m = this.unconfinedQueue;
        if (c1165m == null || (fVarV = c1165m.v()) == null) {
            return false;
        }
        fVarV.run();
        return true;
    }

    @Override // Ua.I
    public final I s1(int parallelism, String name) {
        C1192l.a(parallelism);
        return C1192l.b(this, name);
    }

    public void shutdown() {
    }

    public final void u1(boolean unconfined) {
        long jW1 = this.useCount - w1(unconfined);
        this.useCount = jW1;
        if (jW1 <= 0 && this.shared) {
            shutdown();
        }
    }

    public final long w1(boolean unconfined) {
        return unconfined ? 4294967296L : 1L;
    }

    public final void x1(kotlinx.coroutines.f<?> task) {
        C1165m<kotlinx.coroutines.f<?>> c1165m = this.unconfinedQueue;
        if (c1165m == null) {
            c1165m = new C1165m<>();
            this.unconfinedQueue = c1165m;
        }
        c1165m.addLast(task);
    }

    public long y1() {
        C1165m<kotlinx.coroutines.f<?>> c1165m = this.unconfinedQueue;
        return (c1165m == null || c1165m.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void z1(boolean unconfined) {
        this.useCount += w1(unconfined);
        if (unconfined) {
            return;
        }
        this.shared = true;
    }
}
