package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorZip$ZipProducer<R> extends AtomicLong implements Producer {
    private static final long serialVersionUID = -1216676403723546796L;
    final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> r10) {
        this.zipper = r10;
    }

    @Override // rx.Producer
    public void request(long r10) {
        a.b(this, r10);
        this.zipper.tick();
    }
}
