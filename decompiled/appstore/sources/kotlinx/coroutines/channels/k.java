package kotlinx.coroutines.channels;

import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements Waiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f21368a;

    public k(n r10) {
        this.f21368a = r10;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(y r10, int r11) {
        this.f21368a.invokeOnCancellation(r10, r11);
    }
}
