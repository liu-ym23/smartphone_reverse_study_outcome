package ie;

import java.util.concurrent.CompletableFuture;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class i extends CompletableFuture {

    /* renamed from: c, reason: collision with root package name */
    public final v f5999c;

    public i(v vVar) {
        this.f5999c = vVar;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        if (z10) {
            this.f5999c.cancel();
        }
        return super.cancel(z10);
    }
}
