package reactor.util.context;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ BiConsumer f10910c;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ContextView.lambda$forEach$0(this.f10910c, (Map.Entry) obj);
    }
}
