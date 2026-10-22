package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class i1 {
    public static final void a(CancellableContinuation r10, Future r11) {
        r10.invokeOnCancellation(new k(r11));
    }
}
