package reactor.core.publisher;

import reactor.core.Scannable;
import reactor.core.publisher.FluxDelaySequence;
import reactor.core.publisher.ParallelDoOnEach;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
public final /* synthetic */ class K implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5839a;
    public final /* synthetic */ Scannable b;
    public final /* synthetic */ Object c;

    public /* synthetic */ K(Scannable scannable, Object obj, int i) {
        this.f5839a = i;
        this.b = scannable;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5839a) {
            case 0:
                ((FluxDelaySequence.DelaySubscriber) this.b).lambda$onNext$0(this.c);
                break;
            default:
                ((ParallelDoOnEach.DoOnEachSignalPeek) this.b).lambda$new$2((Context) this.c);
                break;
        }
    }
}
