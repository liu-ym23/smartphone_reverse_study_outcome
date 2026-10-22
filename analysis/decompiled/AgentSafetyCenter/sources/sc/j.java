package sc;

import java.util.concurrent.atomic.AtomicReferenceArray;
import pc.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends r {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f12191e;

    public j(long j10, j jVar, int i) {
        super(j10, jVar, i);
        this.f12191e = new AtomicReferenceArray(i.f12190f);
    }

    @Override // pc.r
    public final int f() {
        return i.f12190f;
    }

    @Override // pc.r
    public final void g(int i, nb.g gVar) {
        this.f12191e.set(i, i.f12189e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f9982c + ", hashCode=" + hashCode() + ']';
    }
}
