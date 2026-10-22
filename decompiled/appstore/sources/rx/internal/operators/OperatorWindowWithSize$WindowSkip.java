package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OperatorWindowWithSize$WindowSkip extends Subscriber implements Action0 {

    public final class WindowSkipProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 4625807964358024108L;
        final /* synthetic */ OperatorWindowWithSize$WindowSkip this$0;

        public WindowSkipProducer(OperatorWindowWithSize$WindowSkip r10) {
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (r10 < 0) goto L13;
            if (r10 != 0) goto L6;
            return;
        L6:
            if (get() == false) goto L8;
            throw null;
        L8:
            if (compareAndSet(false, true) == false) goto L14;
            throw null;
        L14:
            throw null;
        L13:
            throw new IllegalArgumentException("n >= 0 required but it was " + r10);
        }
    }
}
