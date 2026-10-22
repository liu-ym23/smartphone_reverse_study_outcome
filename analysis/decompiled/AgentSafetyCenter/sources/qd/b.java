package qd;

import java.util.concurrent.Flow;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: c, reason: collision with root package name */
    public Flow.Subscription f10217c;

    @Override // qd.e
    public final void cancel() {
        this.f10217c.cancel();
    }

    @Override // qd.e
    public final void request(long j10) {
        this.f10217c.request(j10);
    }
}
