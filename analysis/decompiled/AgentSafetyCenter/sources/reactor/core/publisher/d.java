package reactor.core.publisher;

import java.util.function.BiConsumer;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10772c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Context f10773f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ BiConsumer f10774g;

    public /* synthetic */ d(int i) {
        this.f10772c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f10772c) {
            case 0:
                ContextPropagation.lambda$contextRestoreForHandle$2(this.f10773f, this.f10774g, obj, (SynchronousSink) obj2);
                break;
            default:
                ContextPropagation.lambda$contextRestoreForHandle$3(this.f10773f, this.f10774g, obj, (SynchronousSink) obj2);
                break;
        }
    }
}
