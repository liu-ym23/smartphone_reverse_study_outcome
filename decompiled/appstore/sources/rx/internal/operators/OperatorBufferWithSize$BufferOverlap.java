package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OperatorBufferWithSize$BufferOverlap extends Subscriber {

    public final class BufferOverlapProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = -4015894850868853147L;
        final /* synthetic */ OperatorBufferWithSize$BufferOverlap this$0;

        public BufferOverlapProducer(OperatorBufferWithSize$BufferOverlap r10) {
        }

        @Override // rx.Producer
        public void request(long r10) {
            throw null;
        }
    }
}
