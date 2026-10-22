package B4;

import Z3.i;
import java.util.concurrent.atomic.AtomicReferenceArray;
import x4.AbstractC1291C;

/* loaded from: classes.dex */
final class f extends AbstractC1291C<f> {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f243e;

    public f(long j5, f fVar, int i5) {
        super(j5, fVar, i5);
        this.f243e = new AtomicReferenceArray(e.f242f);
    }

    @Override // x4.AbstractC1291C
    public int r() {
        return e.f242f;
    }

    @Override // x4.AbstractC1291C
    public void s(int i5, Throwable th, i iVar) {
        v().set(i5, e.f241e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f23829c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.f243e;
    }
}
