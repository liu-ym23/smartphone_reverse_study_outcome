package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public final class m0 implements DisposableHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f21645a;

    public m0(Future r10) {
        this.f21645a = r10;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.f21645a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f21645a + ']';
    }
}
