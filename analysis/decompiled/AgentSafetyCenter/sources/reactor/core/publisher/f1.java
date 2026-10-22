package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.core.publisher.ParallelDoOnEach;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class f1 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10789c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ParallelDoOnEach.DoOnEachSignalPeek f10790f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Context f10791g;

    public /* synthetic */ f1(int i) {
        this.f10789c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10789c) {
            case 0:
                this.f10790f.lambda$new$0(this.f10791g, obj);
                break;
            default:
                this.f10790f.lambda$new$1(this.f10791g, (Throwable) obj);
                break;
        }
    }
}
