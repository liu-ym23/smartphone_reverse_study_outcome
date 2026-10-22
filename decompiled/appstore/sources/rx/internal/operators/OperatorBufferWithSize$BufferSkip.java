package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OperatorBufferWithSize$BufferSkip extends Subscriber {

    public final class BufferSkipProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 3428177408082367154L;
        final /* synthetic */ OperatorBufferWithSize$BufferSkip this$0;

        public BufferSkipProducer(OperatorBufferWithSize$BufferSkip r10) {
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
