package g3;

import d3.v;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class j extends v {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f12684e;

    public j(long j4, j jVar, int i4) {
        super(j4, jVar, i4);
        this.f12684e = new AtomicReferenceArray(i.f12683f);
    }

    @Override // d3.v
    public final int f() {
        return i.f12683f;
    }

    @Override // d3.v
    public final void g(int i4, CoroutineContext coroutineContext) {
        this.f12684e.set(i4, i.f12682e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f12481c + ", hashCode=" + hashCode() + ']';
    }
}
