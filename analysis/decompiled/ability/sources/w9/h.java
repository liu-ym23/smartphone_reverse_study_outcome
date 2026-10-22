package w9;

import java.util.concurrent.atomic.AtomicReferenceArray;
import s9.p;

/* loaded from: classes4.dex */
public final class h extends p {
    public final /* synthetic */ AtomicReferenceArray e;

    public h(long j5, h hVar, int i) {
        super(j5, hVar, i);
        this.e = new AtomicReferenceArray(g.f);
    }

    @Override // s9.p
    public final int g() {
        return g.f;
    }

    @Override // s9.p
    public final void h(int i, H7.h hVar) {
        this.e.set(i, g.e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }
}
