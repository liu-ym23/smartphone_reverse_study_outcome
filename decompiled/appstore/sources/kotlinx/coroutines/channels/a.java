package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes4.dex */
public class a extends d implements ActorScope {
    public a(CoroutineContext r10, Channel r11, boolean r12) {
        super(r10, r11, false, r12);
        H((Job) r10.get(Job.Key));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean F(Throwable r10) {
        a0.a(getContext(), r10);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void V(Throwable r10) {
        Channel r11 = r0();
        CancellationException r12 = null;
        if (r10 != null) goto L5;
    L9:
        r11.cancel(r12);
        return;
    L5:
        if ((r10 instanceof CancellationException) == false) goto L7;
        r12 = (CancellationException) r10;
    L7:
        if (r12 != null) goto L9;
        r12 = v0.a(e0.a(this) + " was cancelled", r10);
        goto L9
    }
}
