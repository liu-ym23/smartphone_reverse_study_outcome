package ra;

import java.util.concurrent.atomic.AtomicReferenceArray;
import na.s;

/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f9134e;

    public l(long j2, l lVar, int i2) {
        super(j2, lVar, i2);
        this.f9134e = new AtomicReferenceArray(k.f9133f);
    }

    @Override // na.s
    public final int g() {
        return k.f9133f;
    }

    @Override // na.s
    public final void h(int i2, g7.l lVar) {
        this.f9134e.set(i2, k.f9132e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f6927c + ", hashCode=" + hashCode() + ']';
    }
}
