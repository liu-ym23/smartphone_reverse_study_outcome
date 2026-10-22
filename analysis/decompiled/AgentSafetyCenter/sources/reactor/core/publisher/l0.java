package reactor.core.publisher;

import reactor.core.Scannable;
import reactor.core.publisher.FluxDelaySequence;
import reactor.core.publisher.ParallelDoOnEach;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10816c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Scannable f10817f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10818g;

    public /* synthetic */ l0(int i) {
        this.f10816c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10816c) {
            case 0:
                ((FluxDelaySequence.DelaySubscriber) this.f10817f).lambda$onNext$0(this.f10818g);
                break;
            default:
                ((ParallelDoOnEach.DoOnEachSignalPeek) this.f10817f).lambda$new$2((Context) this.f10818g);
                break;
        }
    }
}
