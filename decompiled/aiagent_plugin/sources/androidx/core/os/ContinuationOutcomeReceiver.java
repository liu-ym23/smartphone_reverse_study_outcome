package androidx.core.os;

import android.os.OutcomeReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: OutcomeReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final d.c.d<R> continuation;

    public ContinuationOutcomeReceiver(d.c.d<? super R> r3) {
        d.c.d<R> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        super(false);
        this.continuation = r4;
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r3) {
        if (compareAndSet(false, true) == false) goto L6;
        d.c.d<R> r2 = this.continuation;
        d.n.a r0 = d.n.f38560a;
        r2.resumeWith(d.n.f(r3));
        return;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E r3) {
        if (compareAndSet(false, true) == false) goto L6;
        d.c.d<R> r2 = this.continuation;
        d.n.a r0 = d.n.f38560a;
        r2.resumeWith(d.n.f(o.a(r3)));
        return;
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
