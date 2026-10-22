package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends x {
    public h(CoroutineContext r10, Continuation r11) {
        super(r10, r11);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean q(Throwable r10) {
        if ((r10 instanceof ChildCancelledException) == false) goto L7;
        return true;
    L7:
        return l(r10);
    }
}
